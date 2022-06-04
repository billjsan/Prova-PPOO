package websearch;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Perform "web search" (from a  file), notify the interested observers of each query.
 */
public class WebSearchModel {
    private final File sourceFile;
    private final List<QueryObserver> observers = new ArrayList<>();
    private final List<PoliticaDeFiltragem> politicaDeFiltragem = new ArrayList<>();


    public interface QueryObserver { // declaraçao da  interface
        void onQuery(String query); // metodo eh executado no observer quando for notificado
    }

    public interface PoliticaDeFiltragem {
        boolean vaiNotificar(String texto);
    }

    public WebSearchModel(File sourceFile) {
        this.sourceFile = sourceFile;
    }


    // 01 entry point of execution
    public void pretendToSearch() {
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {

            while (true) { // 02 percorre todas as queries que estao no arquivo recebido
                String line = br.readLine();
                if (line == null) { // 05 quando a ultima linha eh lida, sai do for;
                    break;
                }
                    notifyAllObservers(line); // 04 notifica todos os observers passando a nova linha (query) lida
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addQueryObserver(QueryObserver queryObserver) {
        observers.add(queryObserver); // adiciona a classe snooper como observer
    }

    public void addQueryObserver(QueryObserver queryObserver, PoliticaDeFiltragem pf) {
        observers.add(queryObserver); // adiciona a classe snooper como observer
        politicaDeFiltragem.add(pf);
    }
    private void notifyAllObservers(String line) {

        for (int i = 0; i < observers.size(); i++) {

            if(politicaDeFiltragem.get(i).vaiNotificar(line)){
                observers.get(i).onQuery(line);
            }
        }
    }
}



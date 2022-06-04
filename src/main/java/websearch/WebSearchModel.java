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

    public interface QueryObserver { // declaraçao da  interface
        void onQuery(String query); // metodo eh executado no observer quando for notificado
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

    private void notifyAllObservers(String line) {
        for (QueryObserver obs : observers) { // 05 notifica todos os observers armazenados na variavel chamando o metodo onQuery
            obs.onQuery(line);
        }
    }
}



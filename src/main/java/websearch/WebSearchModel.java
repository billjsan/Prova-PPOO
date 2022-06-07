/**
 * author: Willian J. Santos
 * Date: 03/JUN/2022
 */

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

    public interface QueryObserver {
        void onQuery(String query);
    }

    public interface SearchPolicy {
        String SEARCH_KEY = "gallon";
        int SEARCH_LENGTH = 35;
        boolean shouldNotify(String query);
    }

    public WebSearchModel(File sourceFile) {
        this.sourceFile = sourceFile;
        this.observers = new ArrayList<>();
        this.searchPolicy = new ArrayList<>();
    }

    public void pretendToSearch() {
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {

            while (true) {
                String line = br.readLine();
                if (line == null) {
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

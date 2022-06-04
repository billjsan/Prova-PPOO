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
    private final List<QueryObserver> observers;
    private SearchPolicy searchPolicy;

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
    }

    public void pretendToSearch() {
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {

            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                if(shouldNotify(line)){
                    notifyAllObservers(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addQueryObserver(QueryObserver queryObserver, SearchPolicy sp) {
        this.observers.add(queryObserver);
        this.searchPolicy = sp;
    }
    private void notifyAllObservers(String line) {
        for (QueryObserver obs : observers) {
            obs.onQuery(line);
        }
    }

    private boolean shouldNotify(String query){

        if(searchPolicy != null){
            return searchPolicy.shouldNotify(query);
        }
        return true;
    }
}



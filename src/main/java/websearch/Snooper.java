/**
 * author: Willian J. Santos
 * Date: 03/JUN/2022
 */

package websearch;

/**
 * Watches the search queries
 */
public class Snooper {

    public Snooper(WebSearchModel model) {
        //observer 1
        model.addQueryObserver(query -> System.out.println("[Gallon Found]: " + query),
                query -> query.contains(WebSearchModel.SearchPolicy.SEARCH_KEY));

        //observer 2
        model.addQueryObserver(query -> System.out.println("[Long Query..]: " + query),
                query -> query.length() > WebSearchModel.SearchPolicy.SEARCH_LENGTH);
    }
}
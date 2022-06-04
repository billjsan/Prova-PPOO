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
        model.addQueryObserver(query -> {
            if(query.contains(WebSearchModel.SearchPolicy.SEARCH_KEY)){
                System.out.println("[Gallon Found]: " + query);
            }else {
                System.out.println("[Long Query..]:" + query);
            }
        }, query -> query.contains(WebSearchModel.SearchPolicy.SEARCH_KEY) ||
                query.length() > WebSearchModel.SearchPolicy.SEARCH_LENGTH);
    }
}
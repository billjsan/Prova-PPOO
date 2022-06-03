package websearch;

/**
 * Watches the search queries
 */
public class Snooper {

    public Snooper(WebSearchModel model) {
        model.addQueryObserver( new WebSearchModel.QueryObserver() {
            @Override
            public void onQuery(String query) {
                System.out.println("Query: " + query);
            }
        });
    }
}

package websearch;

/**
 * Watches the search queries
 */
public class Snooper {

    /**
     * adiciona uma implementaçao da interface QueryObserver
     * ao model recebido como parametro no construtor
     * @param model
     */
    public Snooper(WebSearchModel model) {
        model.addQueryObserver( new WebSearchModel.QueryObserver() {
            @Override
            public void onQuery(String query) {
                System.out.println("Query: " + query); // executa toda vez que eh notificado
            }
        });
    }
}
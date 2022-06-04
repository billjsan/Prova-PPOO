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
        model.addQueryObserver(new WebSearchModel.QueryObserver() {
            @Override
            public void onQuery(String query) {
                System.out.println("[Gallon Found]: " + query);
            }
        }, new WebSearchModel.PoliticaDeFiltragem() {
            @Override
            public boolean vaiNotificar(String texto) {
                return texto.contains("gallon");
            }
        });

        model.addQueryObserver(new WebSearchModel.QueryObserver() {
            @Override
            public void onQuery(String query) {
                System.out.println("[Long Query..]: " + query);
            }
        }, new WebSearchModel.PoliticaDeFiltragem() {
            @Override
            public boolean vaiNotificar(String texto) {
                return texto.length() > 35;
            }
        });
    }
}

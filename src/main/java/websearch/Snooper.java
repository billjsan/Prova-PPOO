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
                if(query.contains("gallon")){
                    System.out.println("[Gallon Found]: " + query);
                }else {
                    System.out.println("[Long Query..]:" + query);
                }
            }
        }, new WebSearchModel.PoliticaDeFiltragem() {
            @Override
            public boolean vaiNotificar(String texto) {

                if (texto.contains("gallon") || texto.length() >= 35){
                    return true;
                }
                return false;
            }
        });
    }
}
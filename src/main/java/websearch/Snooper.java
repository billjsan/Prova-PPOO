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

/**
 * author: Willian J. Santos
 * Date: 03/JUN/2022
 */

package telephone;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

/**
 * Prints things out to the screen, when needed
 * Printing to the screen:
 *  System.out.println("hello");
 */
public class Screen {

    public Screen(PhoneModel model) {
    addFirstObserver(model);
    addSecondObserver(model);
    }

    private void addSecondObserver(PhoneModel model) {
        model.addListener(evt -> {
            List<Integer> all = (List<Integer>) evt.getNewValue();

            if(all.size() >  model.getMaxLength() - 1){

                String texto = "";
                for (Integer i :all) {
                    texto += " " + String.valueOf(i);
                }

                System.out.println("ligando para: " + texto + " ...");
            }
        });
    }

    private void addFirstObserver(PhoneModel model) {
        model.addListener(evt -> {
            int lastDigit = (Integer) evt.getOldValue();

            System.out.println("ultimo digito: " + lastDigit);

        });
    }

}

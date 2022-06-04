/**
 * author: Willian J. Santos
 * Date: 03/JUN/2022
 */

package telephone;

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
            try {
                List<Integer> numbers = (List<Integer>) evt.getNewValue();
                if(numbers.size() >  model.getMaxLength() - 1){

                    StringBuilder message = new StringBuilder();
                    for (Integer i :numbers) {
                        message.append(" ").append(i);
                    }
                    System.out.println("Ligando para:" + message + " ...");
                }

            }catch (Exception  e){}

        });
    }

    private void addFirstObserver(PhoneModel model) {
        model.addListener(evt -> {
            int lastDigit = (Integer) evt.getOldValue();

            System.out.println(lastDigit);

        });
    }

}

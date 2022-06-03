/**
 * author: Willian J. Santos
 * Date: 03/JUN/2022
 */
package telephone;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

/**
 * Store a phone number, digit-by-digit
 */
public class PhoneModel {
    private final List<Integer> digits;
    private final PropertyChangeSupport propertyChangeSupport;
    private final int maxLength;

    public PhoneModel(int maxLength){
        this.maxLength = maxLength;
        this.propertyChangeSupport = new PropertyChangeSupport(this);
        this.digits = new ArrayList<>();
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void addListener(PropertyChangeListener listener){
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removeListener(PropertyChangeListener listener){
        this.propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public void addDigit(int newDigit) {
        digits.add(newDigit);
        this.propertyChangeSupport.firePropertyChange("evento",newDigit, digits );
    }
}

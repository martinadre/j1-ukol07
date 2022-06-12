package cz.czechitas.ukol7.model;

import com.jgoodies.binding.beans.ExtendedPropertyChangeSupport;
import com.jgoodies.common.bean.ObservableBean;

import java.beans.PropertyChangeListener;

public class PreferenceBean implements ObservableBean {
    private final ExtendedPropertyChangeSupport pcs = new ExtendedPropertyChangeSupport(this);

    private String prezdivka;
    private Barva oblibenaBarva;


    public String getPrezdivka() {
        return prezdivka;
    }

    public void setPrezdivka(String prezdivka) {
        if (prezdivka.isBlank()) {
            prezdivka = null;
        }
        String oldValue = this.prezdivka;
        this.prezdivka = prezdivka;
        pcs.firePropertyChange("prezdivka", oldValue, prezdivka);
    }

    public Barva getOblibenaBarva() {
        return oblibenaBarva;
    }

    public void setOblibenaBarva(Barva oblibenaBarva) {
        Barva oldValue = this.oblibenaBarva;
        this.oblibenaBarva = oblibenaBarva;
        pcs.firePropertyChange("oblibenaBarva", oldValue, oblibenaBarva);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }
}

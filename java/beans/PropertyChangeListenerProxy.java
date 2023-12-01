package java.beans;

import java.util.EventListenerProxy;

/* loaded from: source-2895416-dex2jar.jar:java/beans/PropertyChangeListenerProxy.class */
public class PropertyChangeListenerProxy extends EventListenerProxy implements PropertyChangeListener {
    String propertyName;

    public PropertyChangeListenerProxy(String str, PropertyChangeListener propertyChangeListener) {
        super(propertyChangeListener);
        this.propertyName = str;
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    @Override // java.beans.PropertyChangeListener
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        ((PropertyChangeListener) getListener()).propertyChange(propertyChangeEvent);
    }
}

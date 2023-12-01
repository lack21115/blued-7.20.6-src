package java.beans;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import libcore.util.Objects;

/* loaded from: source-2895416-dex2jar.jar:java/beans/PropertyChangeSupport.class */
public class PropertyChangeSupport implements Serializable {
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("source", Object.class), new ObjectStreamField("children", Object.class), new ObjectStreamField("propertyChangeSupportSerializedDataVersion", Integer.TYPE)};
    private static final long serialVersionUID = 6401253773779951803L;
    private transient List<PropertyChangeListener> listeners = new CopyOnWriteArrayList();
    private transient Object sourceBean;

    public PropertyChangeSupport(Object obj) {
        if (obj == null) {
            throw new NullPointerException("sourceBean == null");
        }
        this.sourceBean = obj;
    }

    private boolean equals(String str, EventListener eventListener, EventListener eventListener2) {
        while (eventListener2 instanceof PropertyChangeListenerProxy) {
            PropertyChangeListenerProxy propertyChangeListenerProxy = (PropertyChangeListenerProxy) eventListener2;
            String propertyName = propertyChangeListenerProxy.getPropertyName();
            EventListener listener = propertyChangeListenerProxy.getListener();
            String str2 = str;
            EventListener eventListener3 = eventListener;
            if (str == null) {
                if (!(eventListener instanceof PropertyChangeListenerProxy)) {
                    return false;
                }
                PropertyChangeListenerProxy propertyChangeListenerProxy2 = (PropertyChangeListenerProxy) eventListener;
                str2 = propertyChangeListenerProxy2.getPropertyName();
                eventListener3 = propertyChangeListenerProxy2.getListener();
            }
            if (!Objects.equal(str2, propertyName)) {
                return false;
            }
            str = null;
            eventListener = eventListener3;
            eventListener2 = listener;
        }
        return str == null && Objects.equal(eventListener, eventListener2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField readFields = objectInputStream.readFields();
        this.sourceBean = readFields.get("source", (Object) null);
        this.listeners = new CopyOnWriteArrayList();
        Map map = (Map) readFields.get("children", (Object) null);
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                for (PropertyChangeListener propertyChangeListener : ((PropertyChangeSupport) entry.getValue()).listeners) {
                    this.listeners.add(new PropertyChangeListenerProxy((String) entry.getKey(), propertyChangeListener));
                }
            }
        }
        while (true) {
            PropertyChangeListener propertyChangeListener2 = (PropertyChangeListener) objectInputStream.readObject();
            if (propertyChangeListener2 == null) {
                return;
            }
            this.listeners.add(propertyChangeListener2);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Hashtable hashtable = new Hashtable();
        for (PropertyChangeListener propertyChangeListener : this.listeners) {
            if ((propertyChangeListener instanceof PropertyChangeListenerProxy) && !(propertyChangeListener instanceof Serializable)) {
                PropertyChangeListenerProxy propertyChangeListenerProxy = (PropertyChangeListenerProxy) propertyChangeListener;
                PropertyChangeListener propertyChangeListener2 = (PropertyChangeListener) propertyChangeListenerProxy.getListener();
                if (propertyChangeListener2 instanceof Serializable) {
                    PropertyChangeSupport propertyChangeSupport = (PropertyChangeSupport) hashtable.get(propertyChangeListenerProxy.getPropertyName());
                    PropertyChangeSupport propertyChangeSupport2 = propertyChangeSupport;
                    if (propertyChangeSupport == null) {
                        propertyChangeSupport2 = new PropertyChangeSupport(this.sourceBean);
                        hashtable.put(propertyChangeListenerProxy.getPropertyName(), propertyChangeSupport2);
                    }
                    propertyChangeSupport2.listeners.add(propertyChangeListener2);
                }
            }
        }
        ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
        putFields.put("source", this.sourceBean);
        putFields.put("children", hashtable);
        objectOutputStream.writeFields();
        for (PropertyChangeListener propertyChangeListener3 : this.listeners) {
            if (propertyChangeListener3 instanceof Serializable) {
                objectOutputStream.writeObject(propertyChangeListener3);
            }
        }
        objectOutputStream.writeObject(null);
    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        if (propertyChangeListener != null) {
            this.listeners.add(propertyChangeListener);
        }
    }

    public void addPropertyChangeListener(String str, PropertyChangeListener propertyChangeListener) {
        if (propertyChangeListener == null || str == null) {
            return;
        }
        this.listeners.add(new PropertyChangeListenerProxy(str, propertyChangeListener));
    }

    public void fireIndexedPropertyChange(String str, int i, int i2, int i3) {
        if (i2 != i3) {
            fireIndexedPropertyChange(str, i, Integer.valueOf(i2), Integer.valueOf(i3));
        }
    }

    public void fireIndexedPropertyChange(String str, int i, Object obj, Object obj2) {
        firePropertyChange(new IndexedPropertyChangeEvent(this.sourceBean, str, obj, obj2, i));
    }

    public void fireIndexedPropertyChange(String str, int i, boolean z, boolean z2) {
        if (z != z2) {
            fireIndexedPropertyChange(str, i, Boolean.valueOf(z), Boolean.valueOf(z2));
        }
    }

    public void firePropertyChange(PropertyChangeEvent propertyChangeEvent) {
        String propertyName = propertyChangeEvent.getPropertyName();
        Object oldValue = propertyChangeEvent.getOldValue();
        Object newValue = propertyChangeEvent.getNewValue();
        if (newValue == null || oldValue == null || !newValue.equals(oldValue)) {
            for (EventListener eventListener : this.listeners) {
                while (true) {
                    PropertyChangeListener propertyChangeListener = (PropertyChangeListener) eventListener;
                    if (!(propertyChangeListener instanceof PropertyChangeListenerProxy)) {
                        propertyChangeListener.propertyChange(propertyChangeEvent);
                        break;
                    }
                    PropertyChangeListenerProxy propertyChangeListenerProxy = (PropertyChangeListenerProxy) propertyChangeListener;
                    if (Objects.equal(propertyChangeListenerProxy.getPropertyName(), propertyName)) {
                        eventListener = propertyChangeListenerProxy.getListener();
                    }
                }
            }
        }
    }

    public void firePropertyChange(String str, int i, int i2) {
        firePropertyChange(str, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public void firePropertyChange(String str, Object obj, Object obj2) {
        firePropertyChange(new PropertyChangeEvent(this.sourceBean, str, obj, obj2));
    }

    public void firePropertyChange(String str, boolean z, boolean z2) {
        firePropertyChange(str, Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    public PropertyChangeListener[] getPropertyChangeListeners() {
        return (PropertyChangeListener[]) this.listeners.toArray(new PropertyChangeListener[0]);
    }

    public PropertyChangeListener[] getPropertyChangeListeners(String str) {
        ArrayList arrayList = new ArrayList();
        for (PropertyChangeListener propertyChangeListener : this.listeners) {
            if ((propertyChangeListener instanceof PropertyChangeListenerProxy) && Objects.equal(str, ((PropertyChangeListenerProxy) propertyChangeListener).getPropertyName())) {
                arrayList.add(propertyChangeListener);
            }
        }
        return (PropertyChangeListener[]) arrayList.toArray(new PropertyChangeListener[arrayList.size()]);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean hasListeners(java.lang.String r4) {
        /*
            r3 = this;
            r0 = r3
            java.util.List<java.beans.PropertyChangeListener> r0 = r0.listeners
            java.util.Iterator r0 = r0.iterator()
            r5 = r0
        La:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L34
            r0 = r5
            java.lang.Object r0 = r0.next()
            java.beans.PropertyChangeListener r0 = (java.beans.PropertyChangeListener) r0
            r6 = r0
            r0 = r6
            boolean r0 = r0 instanceof java.beans.PropertyChangeListenerProxy
            if (r0 == 0) goto L32
            r0 = r4
            r1 = r6
            java.beans.PropertyChangeListenerProxy r1 = (java.beans.PropertyChangeListenerProxy) r1
            java.lang.String r1 = r1.getPropertyName()
            boolean r0 = libcore.util.Objects.equal(r0, r1)
            if (r0 == 0) goto La
        L32:
            r0 = 1
            return r0
        L34:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.beans.PropertyChangeSupport.hasListeners(java.lang.String):boolean");
    }

    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        for (PropertyChangeListener propertyChangeListener2 : this.listeners) {
            if (equals(null, propertyChangeListener, propertyChangeListener2)) {
                this.listeners.remove(propertyChangeListener2);
                return;
            }
        }
    }

    public void removePropertyChangeListener(String str, PropertyChangeListener propertyChangeListener) {
        for (PropertyChangeListener propertyChangeListener2 : this.listeners) {
            if (equals(str, propertyChangeListener, propertyChangeListener2)) {
                this.listeners.remove(propertyChangeListener2);
                return;
            }
        }
    }
}

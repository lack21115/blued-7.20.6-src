package java.beans;

/* loaded from: source-2895416-dex2jar.jar:java/beans/IndexedPropertyChangeEvent.class */
public class IndexedPropertyChangeEvent extends PropertyChangeEvent {
    private static final long serialVersionUID = -320227448495806870L;
    private final int index;

    public IndexedPropertyChangeEvent(Object obj, String str, Object obj2, Object obj3, int i) {
        super(obj, str, obj2, obj3);
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }
}

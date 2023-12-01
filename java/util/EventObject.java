package java.util;

import java.io.Serializable;

/* loaded from: source-2895416-dex2jar.jar:java/util/EventObject.class */
public class EventObject implements Serializable {
    private static final long serialVersionUID = 5516075349620653480L;
    @FindBugsSuppressWarnings({"SE_TRANSIENT_FIELD_NOT_RESTORED"})
    protected transient Object source;

    public EventObject(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.source = obj;
    }

    public Object getSource() {
        return this.source;
    }

    public String toString() {
        return getClass().getName() + "[source=" + this.source + ']';
    }
}

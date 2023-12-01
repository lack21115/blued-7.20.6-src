package java.security;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: source-2895416-dex2jar.jar:java/security/GuardedObject.class */
public class GuardedObject implements Serializable {
    private static final long serialVersionUID = -5240450096227834308L;
    private final Guard guard;
    private final Object object;

    public GuardedObject(Object obj, Guard guard) {
        this.object = obj;
        this.guard = guard;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        if (this.guard != null) {
            this.guard.checkGuard(this.object);
        }
        objectOutputStream.defaultWriteObject();
    }

    public Object getObject() throws SecurityException {
        if (this.guard != null) {
            this.guard.checkGuard(this.object);
        }
        return this.object;
    }
}

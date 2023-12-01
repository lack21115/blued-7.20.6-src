package java.util.prefs;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.EventObject;

/* loaded from: source-2895416-dex2jar.jar:java/util/prefs/NodeChangeEvent.class */
public class NodeChangeEvent extends EventObject implements Serializable {
    private static final long serialVersionUID = 8068949086596572957L;
    private final Preferences child;
    private final Preferences parent;

    public NodeChangeEvent(Preferences preferences, Preferences preferences2) {
        super(preferences);
        this.parent = preferences;
        this.child = preferences2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        throw new NotSerializableException();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        throw new NotSerializableException();
    }

    public Preferences getChild() {
        return this.child;
    }

    public Preferences getParent() {
        return this.parent;
    }
}

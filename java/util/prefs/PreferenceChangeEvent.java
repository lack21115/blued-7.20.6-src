package java.util.prefs;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.EventObject;

/* loaded from: source-2895416-dex2jar.jar:java/util/prefs/PreferenceChangeEvent.class */
public class PreferenceChangeEvent extends EventObject implements Serializable {
    private static final long serialVersionUID = 793724513368024975L;
    private final String key;
    private final Preferences node;
    private final String value;

    public PreferenceChangeEvent(Preferences preferences, String str, String str2) {
        super(preferences);
        this.node = preferences;
        this.key = str;
        this.value = str2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new NotSerializableException();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        throw new NotSerializableException();
    }

    public String getKey() {
        return this.key;
    }

    public String getNewValue() {
        return this.value;
    }

    public Preferences getNode() {
        return this.node;
    }
}

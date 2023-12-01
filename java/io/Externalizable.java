package java.io;

/* loaded from: source-2895416-dex2jar.jar:java/io/Externalizable.class */
public interface Externalizable extends Serializable {
    void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException;

    void writeExternal(ObjectOutput objectOutput) throws IOException;
}

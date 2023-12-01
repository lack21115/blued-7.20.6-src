package android.database;

/* loaded from: source-9557208-dex2jar.jar:android/database/CharArrayBuffer.class */
public final class CharArrayBuffer {
    public char[] data;
    public int sizeCopied;

    public CharArrayBuffer(int i) {
        this.data = new char[i];
    }

    public CharArrayBuffer(char[] cArr) {
        this.data = cArr;
    }
}

package android.database;

/* loaded from: source-9557208-dex2jar.jar:android/database/SQLException.class */
public class SQLException extends RuntimeException {
    public SQLException() {
    }

    public SQLException(String str) {
        super(str);
    }

    public SQLException(String str, Throwable th) {
        super(str, th);
    }
}

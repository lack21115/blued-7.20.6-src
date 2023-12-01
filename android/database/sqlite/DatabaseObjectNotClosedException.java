package android.database.sqlite;

/* loaded from: source-9557208-dex2jar.jar:android/database/sqlite/DatabaseObjectNotClosedException.class */
public class DatabaseObjectNotClosedException extends RuntimeException {
    private static final String s = "Application did not close the cursor or database object that was opened here";

    public DatabaseObjectNotClosedException() {
        super(s);
    }
}

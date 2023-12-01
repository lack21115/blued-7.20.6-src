package android.database.sqlite;

/* loaded from: source-9557208-dex2jar.jar:android/database/sqlite/SQLiteTransactionListener.class */
public interface SQLiteTransactionListener {
    void onBegin();

    void onCommit();

    void onRollback();
}

package android.database;

/* loaded from: source-9557208-dex2jar.jar:android/database/CrossProcessCursor.class */
public interface CrossProcessCursor extends Cursor {
    void fillWindow(int i, CursorWindow cursorWindow);

    CursorWindow getWindow();

    boolean onMove(int i, int i2);
}

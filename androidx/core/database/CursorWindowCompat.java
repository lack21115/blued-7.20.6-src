package androidx.core.database;

import android.database.CursorWindow;
import android.os.Build;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/database/CursorWindowCompat.class */
public final class CursorWindowCompat {
    private CursorWindowCompat() {
    }

    public static CursorWindow create(String str, long j) {
        return Build.VERSION.SDK_INT >= 28 ? new CursorWindow(str, j) : Build.VERSION.SDK_INT >= 15 ? new CursorWindow(str) : new CursorWindow(false);
    }
}

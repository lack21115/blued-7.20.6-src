package pl.droidsonroids.gif;

import android.content.Context;

/* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/LibraryLoader.class */
public class LibraryLoader {
    private static Context a;

    private LibraryLoader() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context) {
        try {
            System.loadLibrary("pl_droidsonroids_gif");
        } catch (UnsatisfiedLinkError e) {
            Context context2 = context;
            if (context == null) {
                context2 = getContext();
            }
            ReLinker.a(context2);
        }
    }

    private static Context getContext() {
        if (a == null) {
            try {
                a = (Context) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception e) {
                throw new IllegalStateException("LibraryLoader not initialized. Call LibraryLoader.initialize() before using library classes.", e);
            }
        }
        return a;
    }
}

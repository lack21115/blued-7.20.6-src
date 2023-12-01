package android.webkit;

import android.content.Context;

@Deprecated
/* loaded from: source-4181928-dex2jar.jar:android/webkit/CookieSyncManager.class */
public final class CookieSyncManager extends WebSyncManager {
    private static boolean sGetInstanceAllowed = false;
    private static CookieSyncManager sRef;

    private CookieSyncManager() {
        super(null, null);
    }

    private static void checkInstanceIsAllowed() {
        if (!sGetInstanceAllowed) {
            throw new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
        }
    }

    public static CookieSyncManager createInstance(Context context) {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            try {
                if (context == null) {
                    throw new IllegalArgumentException("Invalid context argument");
                }
                setGetInstanceIsAllowed();
                cookieSyncManager = getInstance();
            } finally {
            }
        }
        return cookieSyncManager;
    }

    public static CookieSyncManager getInstance() {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            try {
                checkInstanceIsAllowed();
                if (sRef == null) {
                    sRef = new CookieSyncManager();
                }
                cookieSyncManager = sRef;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cookieSyncManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setGetInstanceIsAllowed() {
        sGetInstanceAllowed = true;
    }

    @Override // android.webkit.WebSyncManager
    @Deprecated
    public void resetSync() {
    }

    @Override // android.webkit.WebSyncManager, java.lang.Runnable
    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }

    @Override // android.webkit.WebSyncManager
    @Deprecated
    public void startSync() {
    }

    @Override // android.webkit.WebSyncManager
    @Deprecated
    public void stopSync() {
    }

    @Override // android.webkit.WebSyncManager
    @Deprecated
    public void sync() {
        CookieManager.getInstance().flush();
    }

    @Override // android.webkit.WebSyncManager
    @Deprecated
    protected void syncFromRamToFlash() {
        CookieManager.getInstance().flush();
    }
}

package android.app;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Slog;
import com.android.internal.statusbar.IStatusBarService;

/* loaded from: source-9557208-dex2jar.jar:android/app/StatusBarManager.class */
public class StatusBarManager {
    public static final int DISABLE_BACK = 4194304;
    public static final int DISABLE_CLOCK = 8388608;
    public static final int DISABLE_EXPAND = 65536;
    public static final int DISABLE_HOME = 2097152;
    public static final int DISABLE_MASK = 67043328;
    @Deprecated
    public static final int DISABLE_NAVIGATION = 18874368;
    public static final int DISABLE_NONE = 0;
    public static final int DISABLE_NOTIFICATION_ALERTS = 262144;
    public static final int DISABLE_NOTIFICATION_ICONS = 131072;
    @Deprecated
    public static final int DISABLE_NOTIFICATION_TICKER = 524288;
    public static final int DISABLE_RECENT = 16777216;
    public static final int DISABLE_SEARCH = 33554432;
    public static final int DISABLE_SYSTEM_INFO = 1048576;
    public static final int NAVIGATION_HINT_BACK_ALT = 1;
    public static final int NAVIGATION_HINT_IME_SHOWN = 2;
    public static final int WINDOW_NAVIGATION_BAR = 2;
    public static final int WINDOW_STATE_HIDDEN = 2;
    public static final int WINDOW_STATE_HIDING = 1;
    public static final int WINDOW_STATE_SHOWING = 0;
    public static final int WINDOW_STATUS_BAR = 1;
    private Context mContext;
    private IStatusBarService mService;
    private IBinder mToken = new Binder();

    /* JADX INFO: Access modifiers changed from: package-private */
    public StatusBarManager(Context context) {
        this.mContext = context;
    }

    private IStatusBarService getService() {
        IStatusBarService iStatusBarService;
        synchronized (this) {
            if (this.mService == null) {
                this.mService = IStatusBarService.Stub.asInterface(ServiceManager.getService(Context.STATUS_BAR_SERVICE));
                if (this.mService == null) {
                    Slog.w("StatusBarManager", "warning: no STATUS_BAR_SERVICE");
                }
            }
            iStatusBarService = this.mService;
        }
        return iStatusBarService;
    }

    public static String windowStateToString(int i) {
        return i == 1 ? "WINDOW_STATE_HIDING" : i == 2 ? "WINDOW_STATE_HIDDEN" : i == 0 ? "WINDOW_STATE_SHOWING" : "WINDOW_STATE_UNKNOWN";
    }

    public void collapsePanels() {
        try {
            IStatusBarService service = getService();
            if (service != null) {
                service.collapsePanels();
            }
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void disable(int i) {
        try {
            IStatusBarService service = getService();
            if (service != null) {
                service.disable(i, this.mToken, this.mContext.getPackageName());
            }
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void expandNotificationsPanel() {
        try {
            IStatusBarService service = getService();
            if (service != null) {
                service.expandNotificationsPanel();
            }
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void expandSettingsPanel() {
        try {
            IStatusBarService service = getService();
            if (service != null) {
                service.expandSettingsPanel();
            }
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeIcon(String str) {
        try {
            IStatusBarService service = getService();
            if (service != null) {
                service.removeIcon(str);
            }
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void setIcon(String str, int i, int i2, String str2) {
        try {
            IStatusBarService service = getService();
            if (service != null) {
                service.setIcon(str, this.mContext.getPackageName(), i, i2, str2);
            }
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void setIconVisibility(String str, boolean z) {
        try {
            IStatusBarService service = getService();
            if (service != null) {
                service.setIconVisibility(str, z);
            }
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}

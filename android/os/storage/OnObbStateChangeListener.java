package android.os.storage;

/* loaded from: source-9557208-dex2jar.jar:android/os/storage/OnObbStateChangeListener.class */
public abstract class OnObbStateChangeListener {
    public static final int ERROR_ALREADY_MOUNTED = 24;
    public static final int ERROR_COULD_NOT_MOUNT = 21;
    public static final int ERROR_COULD_NOT_UNMOUNT = 22;
    public static final int ERROR_INTERNAL = 20;
    public static final int ERROR_NOT_MOUNTED = 23;
    public static final int ERROR_PERMISSION_DENIED = 25;
    public static final int MOUNTED = 1;
    public static final int UNMOUNTED = 2;

    public void onObbStateChange(String str, int i) {
    }
}

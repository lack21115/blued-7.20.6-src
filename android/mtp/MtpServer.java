package android.mtp;

/* loaded from: source-9557208-dex2jar.jar:android/mtp/MtpServer.class */
public class MtpServer implements Runnable {
    private long mNativeContext;

    static {
        System.loadLibrary("media_jni");
    }

    public MtpServer(MtpDatabase mtpDatabase, boolean z) {
        native_setup(mtpDatabase, z);
        mtpDatabase.setServer(this);
    }

    private final native void native_add_storage(MtpStorage mtpStorage);

    private final native void native_cleanup();

    private final native void native_remove_storage(int i);

    private final native void native_run();

    private final native void native_send_device_property_changed(int i);

    private final native void native_send_object_added(int i);

    private final native void native_send_object_removed(int i);

    private final native void native_send_object_updated(int i);

    private final native void native_setup(MtpDatabase mtpDatabase, boolean z);

    public void addStorage(MtpStorage mtpStorage) {
        native_add_storage(mtpStorage);
    }

    public void removeStorage(MtpStorage mtpStorage) {
        native_remove_storage(mtpStorage.getStorageId());
    }

    @Override // java.lang.Runnable
    public void run() {
        native_run();
        native_cleanup();
    }

    public void sendDevicePropertyChanged(int i) {
        native_send_device_property_changed(i);
    }

    public void sendObjectAdded(int i) {
        native_send_object_added(i);
    }

    public void sendObjectRemoved(int i) {
        native_send_object_removed(i);
    }

    public void sendObjectUpdated(int i) {
        native_send_object_updated(i);
    }

    public void start() {
        new Thread(this, "MtpServer").start();
    }
}

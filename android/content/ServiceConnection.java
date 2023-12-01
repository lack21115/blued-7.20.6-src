package android.content;

import android.os.IBinder;

/* loaded from: source-9557208-dex2jar.jar:android/content/ServiceConnection.class */
public interface ServiceConnection {
    void onServiceConnected(ComponentName componentName, IBinder iBinder);

    void onServiceDisconnected(ComponentName componentName);
}

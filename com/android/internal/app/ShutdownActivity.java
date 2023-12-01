package com.android.internal.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.IPowerManager;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Slog;
import com.android.internal.util.cm.PowerMenuConstants;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/ShutdownActivity.class */
public class ShutdownActivity extends Activity {
    private static final String TAG = "ShutdownActivity";
    private boolean mConfirm;
    private boolean mReboot;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.mReboot = "android.intent.action.REBOOT".equals(intent.getAction());
        this.mConfirm = intent.getBooleanExtra("android.intent.extra.KEY_CONFIRM", false);
        Slog.i(TAG, "onCreate(): confirm=" + this.mConfirm);
        Thread thread = new Thread(TAG) { // from class: com.android.internal.app.ShutdownActivity.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                IPowerManager asInterface = IPowerManager.Stub.asInterface(ServiceManager.getService(PowerMenuConstants.GLOBAL_ACTION_KEY_POWER));
                try {
                    if (ShutdownActivity.this.mReboot) {
                        asInterface.reboot(ShutdownActivity.this.mConfirm, (String) null, false);
                    } else {
                        asInterface.shutdown(ShutdownActivity.this.mConfirm, false);
                    }
                } catch (RemoteException e) {
                }
            }
        };
        thread.start();
        finish();
        try {
            thread.join();
        } catch (InterruptedException e) {
        }
    }
}

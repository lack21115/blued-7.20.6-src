package com.android.internal.app;

import android.app.Activity;
import android.app.IUiModeManager;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/DisableCarModeActivity.class */
public class DisableCarModeActivity extends Activity {
    private static final String TAG = "DisableCarModeActivity";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            IUiModeManager.Stub.asInterface(ServiceManager.getService(Context.UI_MODE_SERVICE)).disableCarMode(1);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to disable car mode", e);
        }
        finish();
    }
}

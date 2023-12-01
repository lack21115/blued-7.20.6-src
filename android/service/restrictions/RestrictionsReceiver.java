package android.service.restrictions;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.RestrictionsManager;
import android.os.PersistableBundle;

/* loaded from: source-9557208-dex2jar.jar:android/service/restrictions/RestrictionsReceiver.class */
public abstract class RestrictionsReceiver extends BroadcastReceiver {
    private static final String TAG = "RestrictionsReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (RestrictionsManager.ACTION_REQUEST_PERMISSION.equals(intent.getAction())) {
            onRequestPermission(context, intent.getStringExtra("android.content.extra.PACKAGE_NAME"), intent.getStringExtra(RestrictionsManager.EXTRA_REQUEST_TYPE), intent.getStringExtra(RestrictionsManager.EXTRA_REQUEST_ID), (PersistableBundle) intent.getParcelableExtra(RestrictionsManager.EXTRA_REQUEST_BUNDLE));
        }
    }

    public abstract void onRequestPermission(Context context, String str, String str2, String str3, PersistableBundle persistableBundle);
}

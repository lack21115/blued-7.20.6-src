package com.android.internal.app;

import android.app.Activity;
import android.app.ActivityManagerNative;
import android.app.ActivityThread;
import android.app.AppGlobals;
import android.content.Intent;
import android.content.pm.IPackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.UserInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.UserManager;
import android.util.Slog;
import android.view.View;
import android.widget.Toast;
import com.android.ims.ImsConferenceState;
import com.blued.android.chat.grpc.backup.MsgBackupManager;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/IntentForwarderActivity.class */
public class IntentForwarderActivity extends Activity {
    public static String TAG = "IntentForwarderActivity";
    public static String FORWARD_INTENT_TO_USER_OWNER = "com.android.internal.app.ForwardIntentToUserOwner";
    public static String FORWARD_INTENT_TO_MANAGED_PROFILE = "com.android.internal.app.ForwardIntentToManagedProfile";

    private int getManagedProfile() {
        for (UserInfo userInfo : ((UserManager) getSystemService(ImsConferenceState.USER)).getProfiles(0)) {
            if (userInfo.isManagedProfile()) {
                return userInfo.id;
            }
        }
        Slog.wtf(TAG, FORWARD_INTENT_TO_MANAGED_PROFILE + " has been called, but there is no managed profile");
        return -10000;
    }

    boolean canForward(Intent intent, int i) {
        IPackageManager packageManager = AppGlobals.getPackageManager();
        Intent intent2 = intent;
        if (intent.getAction().equals("android.intent.action.CHOOSER")) {
            if (intent.hasExtra("android.intent.extra.INITIAL_INTENTS")) {
                Slog.wtf(TAG, "An chooser intent with extra initial intents cannot be forwarded to a different user");
                return false;
            } else if (intent.hasExtra("android.intent.extra.REPLACEMENT_EXTRAS")) {
                Slog.wtf(TAG, "A chooser intent with replacement extras cannot be forwarded to a different user");
                return false;
            } else {
                intent2 = (Intent) intent.getParcelableExtra("android.intent.extra.INTENT");
            }
        }
        String resolveTypeIfNeeded = intent2.resolveTypeIfNeeded(getContentResolver());
        Intent intent3 = intent2;
        if (intent2.getSelector() != null) {
            intent3 = intent2.getSelector();
        }
        try {
            return packageManager.canForwardTo(intent3, resolveTypeIfNeeded, getUserId(), i);
        } catch (RemoteException e) {
            Slog.e(TAG, "PackageManagerService is dead?");
            return false;
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        int i;
        int i2;
        super.onCreate(bundle);
        Intent intent = getIntent();
        String className = intent.getComponent().getClassName();
        if (className.equals(FORWARD_INTENT_TO_USER_OWNER)) {
            i = 17040924;
            i2 = 0;
        } else if (className.equals(FORWARD_INTENT_TO_MANAGED_PROFILE)) {
            i = 17040925;
            i2 = getManagedProfile();
        } else {
            Slog.wtf(TAG, IntentForwarderActivity.class.getName() + " cannot be called directly");
            i = -1;
            i2 = -10000;
        }
        if (i2 == -10000) {
            finish();
            return;
        }
        Intent intent2 = new Intent(intent);
        intent2.setComponent(null);
        intent2.setPackage(null);
        intent2.addFlags(View.SCROLLBARS_OUTSIDE_INSET);
        int userId = getUserId();
        if (canForward(intent2, i2)) {
            if (intent2.getAction().equals("android.intent.action.CHOOSER")) {
                ((Intent) intent2.getParcelableExtra("android.intent.extra.INTENT")).setContentUserHint(userId);
            } else {
                intent2.setContentUserHint(userId);
            }
            ResolveInfo resolveActivityAsUser = getPackageManager().resolveActivityAsUser(intent2, 65536, i2);
            boolean z = resolveActivityAsUser == null || resolveActivityAsUser.activityInfo == null || !MsgBackupManager.PLATFORM_ANDROID.equals(resolveActivityAsUser.activityInfo.packageName) || !(ResolverActivity.class.getName().equals(resolveActivityAsUser.activityInfo.name) || ChooserActivity.class.getName().equals(resolveActivityAsUser.activityInfo.name));
            try {
                startActivityAsCaller(intent2, null, i2);
            } catch (RuntimeException e) {
                int i3 = -1;
                String str = "?";
                try {
                    int launchedFromUid = ActivityManagerNative.getDefault().getLaunchedFromUid(getActivityToken());
                    i3 = launchedFromUid;
                    str = ActivityManagerNative.getDefault().getLaunchedFromPackage(getActivityToken());
                    i3 = launchedFromUid;
                } catch (RemoteException e2) {
                }
                Slog.wtf(TAG, "Unable to launch as UID " + i3 + " package " + str + ", while running in " + ActivityThread.currentProcessName(), e);
            }
            if (z) {
                Toast.makeText(this, getString(i), 1).show();
            }
        } else {
            Slog.wtf(TAG, "the intent: " + intent2 + "cannot be forwarded from user " + userId + " to user " + i2);
        }
        finish();
    }
}

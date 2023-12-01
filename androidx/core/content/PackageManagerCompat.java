package androidx.core.content;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.os.UserManagerCompat;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executors;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/content/PackageManagerCompat.class */
public final class PackageManagerCompat {
    public static final String ACTION_PERMISSION_REVOCATION_SETTINGS = "android.intent.action.AUTO_REVOKE_PERMISSIONS";
    public static final String LOG_TAG = "PackageManagerCompat";

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/content/PackageManagerCompat$Api30Impl.class */
    static class Api30Impl {
        private Api30Impl() {
        }

        static boolean a(Context context) {
            return !context.getPackageManager().isAutoRevokeWhitelisted();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/content/PackageManagerCompat$UnusedAppRestrictionsStatus.class */
    public @interface UnusedAppRestrictionsStatus {
    }

    private PackageManagerCompat() {
    }

    public static boolean areUnusedAppRestrictionsAvailable(PackageManager packageManager) {
        boolean z = true;
        boolean z2 = Build.VERSION.SDK_INT >= 30;
        boolean z3 = Build.VERSION.SDK_INT >= 23 && Build.VERSION.SDK_INT < 30;
        boolean z4 = getPermissionRevocationVerifierApp(packageManager) != null;
        if (!z2) {
            if (z3 && z4) {
                return true;
            }
            z = false;
        }
        return z;
    }

    public static String getPermissionRevocationVerifierApp(PackageManager packageManager) {
        String str = null;
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(new Intent(ACTION_PERMISSION_REVOCATION_SETTINGS).setData(Uri.fromParts("package", "com.example", null)), 0)) {
            String str2 = resolveInfo.activityInfo.packageName;
            if (packageManager.checkPermission(Manifest.permission.PACKAGE_VERIFICATION_AGENT, str2) == 0) {
                if (str != null) {
                    return str;
                }
                str = str2;
            }
        }
        return str;
    }

    public static ListenableFuture<Integer> getUnusedAppRestrictionsStatus(Context context) {
        ResolvableFuture<Integer> create = ResolvableFuture.create();
        if (!UserManagerCompat.isUserUnlocked(context)) {
            create.set(0);
            Log.e(LOG_TAG, "User is in locked direct boot mode");
            return create;
        } else if (!areUnusedAppRestrictionsAvailable(context.getPackageManager())) {
            create.set(1);
            return create;
        } else {
            int i = context.getApplicationInfo().targetSdkVersion;
            if (i < 30) {
                create.set(0);
                Log.e(LOG_TAG, "Target SDK version below API 30");
                return create;
            }
            int i2 = 4;
            if (Build.VERSION.SDK_INT >= 31) {
                if (!Api30Impl.a(context)) {
                    create.set(2);
                    return create;
                }
                if (i >= 31) {
                    i2 = 5;
                }
                create.set(Integer.valueOf(i2));
                return create;
            } else if (Build.VERSION.SDK_INT == 30) {
                if (!Api30Impl.a(context)) {
                    i2 = 2;
                }
                create.set(Integer.valueOf(i2));
                return create;
            } else {
                final UnusedAppRestrictionsBackportServiceConnection unusedAppRestrictionsBackportServiceConnection = new UnusedAppRestrictionsBackportServiceConnection(context);
                create.addListener(new Runnable() { // from class: androidx.core.content.-$$Lambda$XsmVtWS0-2G7pX9NpjmGUqZ_q-s
                    @Override // java.lang.Runnable
                    public final void run() {
                        UnusedAppRestrictionsBackportServiceConnection.this.disconnectFromService();
                    }
                }, Executors.newSingleThreadExecutor());
                unusedAppRestrictionsBackportServiceConnection.connectAndFetchResult(create);
                return create;
            }
        }
    }
}

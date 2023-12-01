package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/app/AppOpsManagerCompat.class */
public final class AppOpsManagerCompat {
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_ERRORED = 2;
    public static final int MODE_IGNORED = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/AppOpsManagerCompat$Api29Impl.class */
    public static class Api29Impl {
        private Api29Impl() {
        }

        static int a(AppOpsManager appOpsManager, String str, int i, String str2) {
            if (appOpsManager == null) {
                return 1;
            }
            return appOpsManager.checkOpNoThrow(str, i, str2);
        }

        static AppOpsManager a(Context context) {
            return (AppOpsManager) context.getSystemService(AppOpsManager.class);
        }

        static String b(Context context) {
            return context.getOpPackageName();
        }
    }

    private AppOpsManagerCompat() {
    }

    public static int checkOrNoteProxyOp(Context context, int i, String str, String str2) {
        if (Build.VERSION.SDK_INT >= 29) {
            AppOpsManager a2 = Api29Impl.a(context);
            int a3 = Api29Impl.a(a2, str, Binder.getCallingUid(), str2);
            return a3 != 0 ? a3 : Api29Impl.a(a2, str, i, Api29Impl.b(context));
        }
        return noteProxyOpNoThrow(context, str, str2);
    }

    public static int noteOp(Context context, String str, int i, String str2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return ((AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE)).noteOp(str, i, str2);
        }
        return 1;
    }

    public static int noteOpNoThrow(Context context, String str, int i, String str2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return ((AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE)).noteOpNoThrow(str, i, str2);
        }
        return 1;
    }

    public static int noteProxyOp(Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOp(str, str2);
        }
        return 1;
    }

    public static int noteProxyOpNoThrow(Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(str, str2);
        }
        return 1;
    }

    public static String permissionToOp(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return AppOpsManager.permissionToOp(str);
        }
        return null;
    }
}

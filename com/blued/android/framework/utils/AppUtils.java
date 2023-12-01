package com.blued.android.framework.utils;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.core.text.TextUtilsCompat;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.R;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/AppUtils.class */
public class AppUtils {
    private static Application a;

    private AppUtils() {
    }

    public static Application a() {
        if (a == null) {
            synchronized (AppUtils.class) {
                try {
                    if (a == null) {
                        try {
                            Class<?> cls = Class.forName("android.app.ActivityThread");
                            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
                            Field declaredField = cls.getDeclaredField("mInitialApplication");
                            declaredField.setAccessible(true);
                            a = (Application) declaredField.get(declaredMethod.invoke(null, new Object[0]));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    public static String a(int i) {
        return a().getString(i);
    }

    public static String a(Context context) {
        synchronized (AppUtils.class) {
            try {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    int i = packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes;
                    if (i == 0) {
                        return String.valueOf(packageManager.getApplicationLabel(context.getApplicationInfo()));
                    }
                    return context.getResources().getString(i);
                } catch (Exception e) {
                    e.printStackTrace();
                    return "";
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(final Context context, final String str, final boolean z) {
        if (StringUtils.b(str)) {
            return;
        }
        if (Build.VERSION.SDK_INT > 19) {
            MediaScannerConnection.scanFile(context, new String[]{str}, null, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.blued.android.framework.utils.-$$Lambda$AppUtils$BjUN7IrkRMAUwsSfkkdwNp74c9E
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public final void onScanCompleted(String str2, Uri uri) {
                    AppUtils.a(z, context, str, str2, uri);
                }
            });
            return;
        }
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", UriUtils.a(str));
        intent.addFlags(1);
        intent.addFlags(2);
        context.sendBroadcast(intent);
        if (z) {
            AppMethods.a((CharSequence) (context.getResources().getString(R.string.pic_save) + str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z, Context context, String str, String str2, Uri uri) {
        if (z) {
            AppMethods.a((CharSequence) (context.getResources().getString(R.string.pic_save) + str));
        }
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 29 && !Environment.isExternalStorageLegacy();
    }

    public static boolean c() {
        return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }
}

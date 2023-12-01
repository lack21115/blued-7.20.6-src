package com.soft.blued.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import com.blued.android.config.FlexDebugSevConfig;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.user.model.UserInfo;
import com.soft.blued.constant.CommonConstants;
import com.soft.blued.ui.welcome.FirstActivity;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/AppUtils.class */
public class AppUtils {

    /* renamed from: a  reason: collision with root package name */
    private static String f34716a;
    private static String b;

    public static String a() {
        if (TextUtils.isEmpty(f34716a)) {
            try {
                f34716a = AppInfo.d().getExternalCacheDir().getParentFile().getAbsolutePath();
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (f34716a == null) {
            f34716a = "";
        }
        return f34716a;
    }

    public static void a(Context context) {
        CommonConstants.f28316c = true;
        CommonConstants.d = false;
        FirstActivity.a(context);
    }

    public static void a(View view) {
        a(view, -1);
    }

    public static void a(View view, int i) {
        int i2 = FlexDebugSevConfig.a().b().gray_count;
        if (view == null || i2 <= 0) {
            return;
        }
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        if (i <= i2 - 1) {
            colorMatrix.setSaturation(0.0f);
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        }
        view.setLayerType(2, paint);
    }

    public static boolean a(Intent intent) {
        List<ResolveInfo> queryIntentActivities = AppInfo.d().getPackageManager().queryIntentActivities(intent, 64);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    public static boolean a(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        try {
            AppInfo.d().getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static String b() {
        if (TextUtils.isEmpty(b)) {
            try {
                b = AppInfo.d().getCacheDir().getParentFile().getAbsolutePath();
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (b == null) {
            b = "";
        }
        return b;
    }

    public static boolean b(String str) {
        if (str == null) {
            return false;
        }
        if (TextUtils.isEmpty(b()) || !str.startsWith(b())) {
            return !TextUtils.isEmpty(a()) && str.startsWith(a());
        }
        return true;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(UserInfo.getInstance().getLoginUserInfo().uid);
    }
}

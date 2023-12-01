package com.blued.android.core.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.blued.android.chat.grpc.backup.MsgBackupManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/ui/StatusBarHelper.class */
public class StatusBarHelper {
    public static int a(Context context) {
        int a = AppMethods.a(25);
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", MsgBackupManager.PLATFORM_ANDROID);
        if (identifier > 0) {
            a = context.getResources().getDimensionPixelSize(identifier);
        }
        return a;
    }

    public static int a(String str, String str2) throws Exception {
        int i;
        if (str == null || str2 == null) {
            throw new Exception("compareVersion error:illegal params.");
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int min = Math.min(split.length, split2.length);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i3;
            if (i2 >= min) {
                break;
            }
            int length = split[i2].length() - split2[i2].length();
            i = length;
            if (length != 0) {
                break;
            }
            int compareTo = split[i2].compareTo(split2[i2]);
            i = compareTo;
            if (compareTo != 0) {
                break;
            }
            i2++;
            i3 = compareTo;
        }
        return i != 0 ? i : split.length - split2.length;
    }

    public static Drawable a(Context context, int i, int i2, int i3, boolean z) {
        if (AppInfo.d() == null) {
            return new GradientDrawable();
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColor(AppInfo.d(), i3));
        if (z) {
            return gradientDrawable;
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        if (i2 == 0 || i2 == 17170445 || Build.VERSION.SDK_INT < 19) {
            gradientDrawable2.setColor(ContextCompat.getColor(AppInfo.d(), i));
        } else {
            gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            gradientDrawable2.setColors(new int[]{ContextCompat.getColor(AppInfo.d(), i), ContextCompat.getColor(AppInfo.d(), i2)});
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable2, gradientDrawable});
        layerDrawable.setLayerInset(1, 0, a(context), 0, 0);
        return layerDrawable;
    }

    public static void a(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setNavigationBarColor(i);
        }
    }

    public static boolean a() {
        if (b() || c()) {
            return true;
        }
        if (!AppInfo.i() || Build.VERSION.SDK_INT < 23) {
            return !AppInfo.i() && Build.VERSION.SDK_INT >= 19;
        }
        return true;
    }

    public static boolean a(Activity activity) {
        return a(activity, AppInfo.i(), AppInfo.v);
    }

    public static boolean a(Activity activity, View view) {
        if (activity == null || view == null || !a()) {
            return false;
        }
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + a((Context) activity), view.getPaddingRight(), view.getPaddingBottom());
        return true;
    }

    public static boolean a(Activity activity, boolean z) {
        return a(activity, z, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean a(Activity activity, boolean z, boolean z2) {
        if (a()) {
            if (Build.VERSION.SDK_INT < 21) {
                if (Build.VERSION.SDK_INT >= 19) {
                    activity.getWindow().addFlags(67108864);
                    b(activity, z, z2);
                    return true;
                }
                return false;
            }
            Window window = activity.getWindow();
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(GL10.GL_INVALID_ENUM);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
            b(activity, z, z2);
            return true;
        }
        return false;
    }

    public static boolean a(Window window) {
        if (a()) {
            if (Build.VERSION.SDK_INT < 21) {
                if (Build.VERSION.SDK_INT >= 19) {
                    window.addFlags(67108864);
                    return true;
                }
                return false;
            }
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(GL10.GL_INVALID_ENUM);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
            return true;
        }
        return false;
    }

    public static int b(Activity activity) {
        if (c(activity) && activity.getResources().getIdentifier("config_showNavigationBar", "bool", MsgBackupManager.PLATFORM_ANDROID) != 0) {
            return activity.getResources().getDimensionPixelSize(activity.getResources().getIdentifier("navigation_bar_height", "dimen", MsgBackupManager.PLATFORM_ANDROID));
        }
        return 0;
    }

    public static void b(Activity activity, boolean z) {
        int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
        activity.getWindow().getDecorView().setSystemUiVisibility(z ? systemUiVisibility | 16 : systemUiVisibility & (-17));
        a(activity, BluedSkinUtils.a(activity, AppInfo.k()));
    }

    protected static void b(Activity activity, boolean z, boolean z2) {
        View decorView;
        boolean z3 = z;
        if (BluedSkinUtils.a()) {
            z3 = z;
            if (!z2) {
                z3 = BluedSkinUtils.c();
            }
        }
        if (b()) {
            try {
                Window window = activity.getWindow();
                Class<?> cls = activity.getWindow().getClass();
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                if (z3) {
                    method.invoke(window, Integer.valueOf(i), Integer.valueOf(i));
                } else {
                    method.invoke(window, 0, Integer.valueOf(i));
                }
            } catch (Exception e) {
                Log.c("miui status bar excn", e.getMessage());
                e.printStackTrace();
            }
        } else if (!c()) {
            if (Build.VERSION.SDK_INT < 23 || (decorView = activity.getWindow().getDecorView()) == null) {
                return;
            }
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z3 ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        } else {
            try {
                Window window2 = activity.getWindow();
                WindowManager.LayoutParams attributes = window2.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i2 = declaredField.getInt(null);
                int i3 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, z3 ? i3 | i2 : i2 & i3);
                window2.setAttributes(attributes);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean b() {
        if (Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) {
            try {
                File file = new File(Environment.getRootDirectory(), "build.prop");
                if (file.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    String property = properties.getProperty("ro.miui.ui.version.code");
                    fileInputStream.close();
                    if (!TextUtils.isEmpty(property)) {
                        int parseInt = Integer.parseInt(property);
                        String str = Build.VERSION.INCREMENTAL;
                        if (parseInt >= 4) {
                            Class<?> cls = Class.forName("miui.os.Build");
                            if (!cls.getField("IS_ALPHA_BUILD").getBoolean(null) && !cls.getField("IS_DEVELOPMENT_VERSION").getBoolean(null)) {
                                if (cls.getField("IS_STABLE_VERSION").getBoolean(null) && a("V8.6", str) > 0) {
                                    return true;
                                }
                            }
                            if (a("7.7.13", str) > 0) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    private static boolean c() {
        String str = Build.DISPLAY;
        if (TextUtils.isEmpty(str) || !str.contains("Flyme") || Build.VERSION.SDK_INT >= 23) {
            return false;
        }
        String[] split = str.split(" ");
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (split[i2].matches("^[4-9]\\.(\\d+\\.)+\\S*")) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static boolean c(Activity activity) {
        try {
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            if (viewGroup == null) {
                return false;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= viewGroup.getChildCount()) {
                    return false;
                }
                viewGroup.getChildAt(i2).getContext().getPackageName();
                if (viewGroup.getChildAt(i2).getId() != -1 && "navigationBarBackground".equals(activity.getResources().getResourceEntryName(viewGroup.getChildAt(i2).getId()))) {
                    return true;
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
            return false;
        }
    }
}

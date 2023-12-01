package com.sobot.chat.notchlib.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/notchlib/utils/ScreenUtil.class */
public class ScreenUtil {
    public static Rect calculateNotchRect(Context context, int i, int i2) {
        int i3;
        int i4;
        int[] screenSize = getScreenSize(context);
        int i5 = 0;
        int i6 = screenSize[0];
        int i7 = screenSize[1];
        if (isPortrait(context)) {
            int i8 = (i6 - i) / 2;
            i5 = i8;
            i3 = i + i8;
            i4 = 0;
        } else {
            int i9 = (i7 - i) / 2;
            i3 = i2;
            i2 = i + i9;
            i4 = i9;
        }
        return new Rect(i5, i4, i3, i2);
    }

    public static View getContentView(Activity activity) {
        return activity.getWindow().getDecorView().findViewById(R.id.content);
    }

    public static Rect getContentViewDisplayFrame(Activity activity) {
        View contentView = getContentView(activity);
        Rect rect = new Rect();
        contentView.getWindowVisibleDisplayFrame(rect);
        return rect;
    }

    public static int getContentViewHeight(Activity activity) {
        return getContentView(activity).getHeight();
    }

    private static int getDimensionPixel(Context context, String str) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(str, "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int getNavigationBarHeight(Context context) {
        return getDimensionPixel(context, Settings.System.NAVIGATION_BAR_HEIGHT);
    }

    public static int[] getScreenSize(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        int i3 = i2;
        int i4 = i;
        if (Build.VERSION.SDK_INT >= 17) {
            i4 = i;
            try {
                Point point = new Point();
                Display.class.getMethod("getRealSize", Point.class).invoke(defaultDisplay, point);
                int i5 = point.x;
                i4 = i5;
                i3 = point.y;
                i4 = i5;
            } catch (Throwable th) {
                i3 = i2;
            }
        }
        return new int[]{i4, i3};
    }

    public static int getStatusBarHeight(Context context) {
        return getDimensionPixel(context, "status_bar_height");
    }

    public static boolean isPortrait(Context context) {
        return context.getResources().getConfiguration().orientation == 1;
    }
}

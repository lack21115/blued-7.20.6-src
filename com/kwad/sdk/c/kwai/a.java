package com.kwad.sdk.c.kwai;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.android.internal.telephony.PhoneConstants;
import com.kwad.sdk.utils.s;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/c/kwai/a.class */
public final class a {
    private static int abb;
    private static long abc;

    public static boolean A(View view) {
        return (view.getSystemUiVisibility() & 1024) == 1024;
    }

    public static void B(View view) {
        if (view == null || ((View) view.getParent()) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        view.setLayoutParams(layoutParams);
    }

    public static int[] C(View view) {
        if (view == null) {
            return null;
        }
        view.getLocationInWindow(r0);
        int[] iArr = {iArr[0] + (view.getWidth() / 2), iArr[1] + (view.getHeight() / 2)};
        return iArr;
    }

    public static int D(View view) {
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return ((FrameLayout.LayoutParams) layoutParams).gravity;
        }
        return 0;
    }

    public static int a(Context context, float f) {
        return (int) (context == null ? f * 2.0f : (f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static View a(ViewGroup viewGroup, int i, boolean z) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, true);
    }

    public static void a(View.OnClickListener onClickListener, View... viewArr) {
        int length = viewArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            viewArr[i2].setOnClickListener(onClickListener);
            i = i2 + 1;
        }
    }

    public static void a(TextView textView, String str, Bitmap bitmap) {
        int i;
        String str2 = str + " ";
        TextPaint paint = textView.getPaint();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        int ceil = ((int) Math.ceil(fontMetrics.descent - fontMetrics.top)) + 2;
        BitmapDrawable bitmapDrawable = new BitmapDrawable(textView.getContext().getResources(), bitmap);
        int intrinsicWidth = (bitmapDrawable.getIntrinsicWidth() * ceil) / bitmapDrawable.getIntrinsicHeight();
        bitmapDrawable.setBounds(0, a(textView.getContext(), 1.0f), intrinsicWidth, ceil);
        int width = textView.getWidth();
        float measureText = paint.measureText(str2);
        float f = width;
        String str3 = str2;
        if (measureText > f) {
            int i2 = 0;
            int i3 = 1;
            int i4 = 1;
            boolean z = false;
            while (true) {
                float measureText2 = paint.measureText(str2.substring(i2, i3));
                if (measureText2 < f) {
                    if (i4 == textView.getMaxLines()) {
                        float f2 = measureText2 + intrinsicWidth;
                        if (paint.measureText(" ") + f2 < f && f2 + paint.measureText("...") + paint.measureText(" ") < f) {
                            if (z) {
                                str3 = str2.substring(0, i3) + "... ";
                                break;
                            }
                        } else {
                            i3--;
                            z = true;
                            i = i4;
                        }
                    }
                    i3++;
                    i = i4;
                } else {
                    i2 = i3 - 1;
                    i = i4 + 1;
                }
                str3 = str2;
                if (i3 > str2.length()) {
                    break;
                }
                i4 = i;
                if (i > textView.getMaxLines()) {
                    str3 = str2;
                    break;
                }
            }
        }
        String str4 = str3 + PhoneConstants.APN_TYPE_ALL;
        SpannableString spannableString = new SpannableString(str4);
        spannableString.setSpan(new com.kwad.sdk.core.view.a(textView.getContext(), bitmap), str4.length() - 1, str4.length(), 33);
        textView.setText(spannableString);
    }

    public static boolean a(Activity activity) {
        return a(activity.getWindow());
    }

    private static boolean a(Window window) {
        return (window.getAttributes().flags & 1024) == 1024;
    }

    @Deprecated
    public static int aw(Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        int i = Build.VERSION.SDK_INT;
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (i >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    public static float ax(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static int b(Context context, float f) {
        return (int) (context == null ? f / 2.0f : (f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private static View b(Activity activity) {
        return b(activity.getWindow());
    }

    private static View b(Window window) {
        return window.getDecorView().findViewById(16908290);
    }

    public static void b(View view, int i, int i2, int i3, int i4) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).setMargins(i, i2, i3, 0);
            view.requestLayout();
        }
    }

    public static int c(Activity activity) {
        return b(activity).getWidth();
    }

    public static int d(Activity activity) {
        return b(activity).getHeight();
    }

    public static void d(View view, int i, int i2) {
        View view2;
        if (view == null || i == 0 || i2 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (width > height) {
            if (i <= i2) {
                layoutParams.width = (int) ((i / (i2 * 1.0f)) * height);
                layoutParams.height = height;
            }
            layoutParams.width = -1;
            layoutParams.height = -1;
        } else {
            if (i2 <= i) {
                layoutParams.width = width;
                layoutParams.height = (int) ((i2 / (i * 1.0f)) * width);
            }
            layoutParams.width = -1;
            layoutParams.height = -1;
        }
        view.setLayoutParams(layoutParams);
    }

    public static void e(View view, int i, int i2) {
        View view2;
        if (view == null || i == 0 || i2 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (i > i2) {
            layoutParams.width = width;
            layoutParams.height = (int) ((i2 / (i * 1.0f)) * width);
        } else {
            layoutParams.width = (int) ((i / (i2 * 1.0f)) * height);
            layoutParams.height = height;
        }
        view.setLayoutParams(layoutParams);
    }

    public static void f(View view, int i, int i2) {
        View view2;
        if (view == null || i == 0 || i2 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (width <= height || i > i2) {
            layoutParams.width = width;
            layoutParams.height = (int) ((i2 / (i * 1.0f)) * width);
        } else {
            layoutParams.width = (int) ((i / (i2 * 1.0f)) * height);
            layoutParams.height = height;
        }
        view.setLayoutParams(layoutParams);
    }

    public static int g(Context context, int i) {
        if (context == null || i == 0) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(i);
    }

    public static int getColor(Context context, int i) {
        return context.getResources().getColor(i);
    }

    @Deprecated
    public static int getScreenHeight(Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    @Deprecated
    public static int getScreenWidth(Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getStatusBarHeight(Context context) {
        int i = abb;
        if (i <= 0 && context != null) {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                abb = context.getResources().getDimensionPixelSize(identifier);
            } else {
                try {
                    abb = context.getResources().getDimensionPixelSize(((Integer) s.d("com.android.internal.R$dimen", "status_bar_height")).intValue());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (abb <= 0) {
                abb = a(context, 25.0f);
            }
            return abb;
        }
        return i;
    }

    public static void m(View view, int i) {
        if (view == null || i == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
    }

    public static void n(View view, int i) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i;
        }
    }

    public static boolean tC() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long abs = Math.abs(uptimeMillis - abc);
        abc = uptimeMillis;
        return abs < 500;
    }
}

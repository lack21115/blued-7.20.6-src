package com.sina.weibo.sdk.utils;

import android.R;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.StateSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import org.apache.http.util.EncodingUtils;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/utils/ResourceManager.class */
public class ResourceManager {
    private static final String DRAWABLE = "drawable";
    private static final String TAG = ResourceManager.class.getName();
    private static final String DRAWABLE_XXHDPI = "drawable-xxhdpi";
    private static final String DRAWABLE_XHDPI = "drawable-xhdpi";
    private static final String DRAWABLE_HDPI = "drawable-hdpi";
    private static final String DRAWABLE_MDPI = "drawable-mdpi";
    private static final String DRAWABLE_LDPI = "drawable-ldpi";
    private static final String[] PRE_INSTALL_DRAWBLE_PATHS = {DRAWABLE_XXHDPI, DRAWABLE_XHDPI, DRAWABLE_HDPI, DRAWABLE_MDPI, DRAWABLE_LDPI, "drawable"};

    /* JADX WARN: Type inference failed for: r2v1, types: [int[], int[][]] */
    public static ColorStateList createColorStateList(int i, int i2) {
        return new ColorStateList(new int[]{new int[]{R.attr.state_pressed}, new int[]{R.attr.state_selected}, new int[]{R.attr.state_focused}, StateSet.WILD_CARD}, new int[]{i2, i2, i2, i});
    }

    public static StateListDrawable createStateListDrawable(Context context, String str, String str2) {
        Drawable ninePatchDrawable = str.indexOf(".9") > -1 ? getNinePatchDrawable(context, str) : getDrawable(context, str);
        Drawable ninePatchDrawable2 = str2.indexOf(".9") > -1 ? getNinePatchDrawable(context, str2) : getDrawable(context, str2);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, ninePatchDrawable2);
        stateListDrawable.addState(new int[]{R.attr.state_selected}, ninePatchDrawable2);
        stateListDrawable.addState(new int[]{R.attr.state_focused}, ninePatchDrawable2);
        stateListDrawable.addState(StateSet.WILD_CARD, ninePatchDrawable);
        return stateListDrawable;
    }

    public static StateListDrawable createStateListDrawable(Context context, String str, String str2, String str3) {
        Drawable ninePatchDrawable = str.indexOf(".9") > -1 ? getNinePatchDrawable(context, str) : getDrawable(context, str);
        Drawable ninePatchDrawable2 = str3.indexOf(".9") > -1 ? getNinePatchDrawable(context, str3) : getDrawable(context, str3);
        Drawable ninePatchDrawable3 = str2.indexOf(".9") > -1 ? getNinePatchDrawable(context, str2) : getDrawable(context, str2);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, ninePatchDrawable3);
        stateListDrawable.addState(new int[]{R.attr.state_selected}, ninePatchDrawable3);
        stateListDrawable.addState(new int[]{R.attr.state_focused}, ninePatchDrawable3);
        stateListDrawable.addState(new int[]{R.attr.enabled}, ninePatchDrawable2);
        stateListDrawable.addState(StateSet.WILD_CARD, ninePatchDrawable);
        return stateListDrawable;
    }

    public static int dp2px(Context context, int i) {
        return (int) ((i * context.getResources().getDisplayMetrics().density) + 0.5d);
    }

    private static Drawable extractDrawable(Context context, String str) throws Exception {
        InputStream open = context.getAssets().open(str);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        TypedValue typedValue = new TypedValue();
        typedValue.density = displayMetrics.densityDpi;
        Drawable createFromResourceStream = Drawable.createFromResourceStream(context.getResources(), typedValue, open, str);
        open.close();
        return createFromResourceStream;
    }

    private static View extractView(Context context, String str, ViewGroup viewGroup) throws Exception {
        return ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(context.getAssets().openXmlResourceParser(str), viewGroup);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b4, code lost:
        if (java.lang.Math.abs(r11 - r10) <= java.lang.Math.abs(r11 - r8)) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String getAppropriatePathOfDrawable(android.content.Context r5, java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.ResourceManager.getAppropriatePathOfDrawable(android.content.Context, java.lang.String):java.lang.String");
    }

    private static String getCurrentDpiFolder(Context context) {
        int i = context.getResources().getDisplayMetrics().densityDpi;
        return i <= 120 ? DRAWABLE_LDPI : (i <= 120 || i > 160) ? (i <= 160 || i > 240) ? (i <= 240 || i > 320) ? DRAWABLE_XXHDPI : DRAWABLE_XHDPI : DRAWABLE_HDPI : DRAWABLE_MDPI;
    }

    public static Drawable getDrawable(Context context, String str) {
        return getDrawableFromAssert(context, getAppropriatePathOfDrawable(context, str), false);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.drawable.Drawable getDrawableFromAssert(android.content.Context r12, java.lang.String r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.ResourceManager.getDrawableFromAssert(android.content.Context, java.lang.String, boolean):android.graphics.drawable.Drawable");
    }

    public static Locale getLanguage() {
        Locale locale = Locale.getDefault();
        Locale locale2 = locale;
        if (!Locale.SIMPLIFIED_CHINESE.equals(locale)) {
            if (Locale.TRADITIONAL_CHINESE.equals(locale)) {
                return locale;
            }
            locale2 = Locale.ENGLISH;
        }
        return locale2;
    }

    public static Drawable getNinePatchDrawable(Context context, String str) {
        return getDrawableFromAssert(context, getAppropriatePathOfDrawable(context, str), true);
    }

    public static String getString(Context context, String str, String str2, String str3) {
        Locale language = getLanguage();
        return Locale.SIMPLIFIED_CHINESE.equals(language) ? str2 : Locale.TRADITIONAL_CHINESE.equals(language) ? str3 : str;
    }

    private static boolean isFileExisted(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        AssetManager assets = context.getAssets();
        InputStream inputStream = null;
        InputStream inputStream2 = null;
        try {
            try {
                InputStream open = assets.open(str);
                String str2 = TAG;
                StringBuilder sb = new StringBuilder("file [");
                sb.append(str);
                sb.append("] existed");
                inputStream2 = open;
                inputStream = open;
                LogUtil.d(str2, sb.toString());
                if (open != null) {
                    try {
                        open.close();
                        return true;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return true;
                    }
                }
                return true;
            } catch (Throwable th) {
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e3) {
            String str3 = TAG;
            InputStream inputStream3 = inputStream;
            StringBuilder sb2 = new StringBuilder("file [");
            InputStream inputStream4 = inputStream;
            sb2.append(str);
            InputStream inputStream5 = inputStream;
            sb2.append("] NOT existed");
            inputStream2 = inputStream;
            LogUtil.d(str3, sb2.toString());
            if (inputStream != null) {
                try {
                    inputStream.close();
                    return false;
                } catch (IOException e4) {
                    e4.printStackTrace();
                    return false;
                }
            }
            return false;
        }
    }

    public static String readCountryFromAsset(Context context, String str) {
        String str2 = "";
        try {
            InputStream open = context.getAssets().open(str);
            str2 = "";
            if (open != null) {
                DataInputStream dataInputStream = new DataInputStream(open);
                byte[] bArr = new byte[dataInputStream.available()];
                dataInputStream.read(bArr);
                String string = EncodingUtils.getString(bArr, "UTF-8");
                str2 = string;
                open.close();
                return string;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str2;
    }
}

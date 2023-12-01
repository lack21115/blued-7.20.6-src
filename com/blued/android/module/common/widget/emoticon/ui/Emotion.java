package com.blued.android.module.common.widget.emoticon.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import androidx.collection.ArrayMap;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.module.common.widget.emoticon.model.DefaultEmotionModel;
import com.google.common.base.Charsets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoticon/ui/Emotion.class */
public class Emotion {
    public static String[] a;
    public static String[] b;
    public static int[] c;
    private static Pattern d;
    private static Map<String, Integer> e;

    public Emotion(Context context) {
        d();
        if (d != null) {
            return;
        }
        d = b();
        int length = b.length;
        c = new int[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                e = c();
                return;
            }
            try {
                c[i2] = context.getResources().getIdentifier(b[i2], "drawable", context.getPackageName());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            i = i2 + 1;
        }
    }

    public static SpannableString a(String str, int i) {
        return Build.VERSION.SDK_INT >= 29 ? a(str, i, 2) : a(str, i, 1);
    }

    public static SpannableString a(String str, int i, int i2) {
        SpannableString spannableString = new SpannableString(str + "");
        if (d == null || e == null) {
            a();
        }
        Matcher matcher = d.matcher(str);
        if (matcher.find()) {
            Drawable drawable = AppInfo.d().getResources().getDrawable(e.get(matcher.group()).intValue());
            drawable.setBounds(0, 0, AppMethods.a(i), AppMethods.a(i));
            spannableString.setSpan(new ImageSpan(drawable, i2), 0, spannableString.length(), 33);
        }
        return spannableString;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.CharSequence a(java.lang.CharSequence r7, int r8, int r9) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.widget.emoticon.ui.Emotion.a(java.lang.CharSequence, int, int):java.lang.CharSequence");
    }

    public static void a() {
        if (d != null) {
            return;
        }
        if (a == null || b == null) {
            d();
        }
        d = b();
        int length = b.length;
        c = new int[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                e = c();
                return;
            }
            try {
                c[i2] = AppInfo.d().getResources().getIdentifier(b[i2], "drawable", AppInfo.d().getPackageName());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            i = i2 + 1;
        }
    }

    private static Pattern b() {
        StringBuilder sb = new StringBuilder(a.length * 3);
        try {
            sb.append('(');
            String[] strArr = a;
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                sb.append(Pattern.quote(strArr[i2]));
                sb.append('|');
                i = i2 + 1;
            }
            sb.replace(sb.length() - 1, sb.length(), ")");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return Pattern.compile(sb.toString());
    }

    private static ArrayMap<String, Integer> c() {
        ArrayMap<String, Integer> arrayMap = new ArrayMap<>(a.length);
        int i = 0;
        while (true) {
            int i2 = i;
            String[] strArr = a;
            if (i2 >= strArr.length) {
                return arrayMap;
            }
            arrayMap.put(strArr[i2], Integer.valueOf(c[i2]));
            i = i2 + 1;
        }
    }

    private static void d() {
        BufferedReader bufferedReader;
        InputStream inputStream;
        try {
            try {
                inputStream = AppInfo.d().getAssets().open("emotion.txt");
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charsets.UTF_8));
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = null;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
                inputStream = null;
            }
            try {
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine);
                }
                DefaultEmotionModel[] defaultEmotionModelArr = (DefaultEmotionModel[]) AppInfo.f().fromJson(stringBuffer.toString(), DefaultEmotionModel[].class);
                if (a == null) {
                    a = new String[defaultEmotionModelArr.length];
                    b = new String[defaultEmotionModelArr.length];
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= defaultEmotionModelArr.length) {
                            break;
                        }
                        a[i2] = defaultEmotionModelArr[i2].name;
                        b[i2] = defaultEmotionModelArr[i2].pid;
                        i = i2 + 1;
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                bufferedReader.close();
            } catch (Throwable th3) {
                th = th3;
                try {
                    th.printStackTrace();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                } catch (Throwable th4) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            throw th4;
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th4;
                }
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public SpannableString a(String str) {
        SpannableString spannableString = new SpannableString(str + "");
        Matcher matcher = d.matcher(str);
        if (matcher.find()) {
            Drawable drawable = AppInfo.d().getResources().getDrawable(e.get(matcher.group()).intValue());
            drawable.setBounds(0, 0, AppMethods.a(25), AppMethods.a(25));
            spannableString.setSpan(new ImageSpan(drawable), 0, spannableString.length(), 33);
        }
        return spannableString;
    }
}

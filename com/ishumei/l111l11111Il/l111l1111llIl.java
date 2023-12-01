package com.ishumei.l111l11111Il;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.ishumei.l1111l111111Il.l111l1111llIl;
import java.util.Locale;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111Il/l111l1111llIl.class */
public final class l111l1111llIl {
    public static String l1111l111111Il() {
        int i;
        int i2;
        int i3;
        Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
        if (context == null) {
            return "";
        }
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            i = displayMetrics.widthPixels;
            try {
                i2 = displayMetrics.heightPixels;
            } catch (Exception e) {
                i2 = 0;
                i3 = 0;
                return String.format(Locale.CHINA, "%d,%d,%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            }
            try {
                i3 = displayMetrics.densityDpi;
            } catch (Exception e2) {
                i3 = 0;
                return String.format(Locale.CHINA, "%d,%d,%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            }
        } catch (Exception e3) {
            i = 0;
        }
        return String.format(Locale.CHINA, "%d,%d,%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static void l1111l111111Il(com.ishumei.l1111l111111Il.l111l11111lIl l111l11111lil) {
        try {
            if (Build.VERSION.SDK_INT >= 18) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                l111l11111lil.l111l1111l1Il(Long.valueOf(statFs.getAvailableBytes()));
                l111l11111lil.l111l1111llIl(Long.valueOf(statFs.getFreeBytes()));
                l111l11111lil.l111l1111lI1l(Long.valueOf(statFs.getTotalBytes()));
            }
        } catch (Exception e) {
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static int l111l11111I1l() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static String l111l11111lIl() {
        int i;
        int i2;
        DisplayMetrics displayMetrics;
        Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
        if (context == null) {
            return "";
        }
        try {
            displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);
            i = displayMetrics.widthPixels;
        } catch (Exception e) {
            i = 0;
        }
        try {
            i2 = displayMetrics.heightPixels;
        } catch (Exception e2) {
            i2 = 0;
            return String.format(Locale.CHINA, "%d,%d", Integer.valueOf(i), Integer.valueOf(i2));
        }
        return String.format(Locale.CHINA, "%d,%d", Integer.valueOf(i), Integer.valueOf(i2));
    }
}

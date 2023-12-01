package com.bytedance.bdtracker;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/q0.class */
public class q0 extends i0 {
    public final Context e;

    public q0(Context context) {
        super(true, false);
        this.e = context;
    }

    @Override // com.bytedance.bdtracker.i0
    public boolean a(JSONObject jSONObject) {
        Object obj;
        int i;
        int i2;
        int i3;
        int i4 = this.e.getResources().getDisplayMetrics().densityDpi;
        switch (i4) {
            case 120:
                obj = "ldpi";
                break;
            case 240:
                obj = "hdpi";
                break;
            case 260:
            case 280:
            case 300:
            case 320:
                obj = "xhdpi";
                break;
            case 340:
            case 360:
            case 400:
            case 420:
            case 440:
            case 480:
                obj = "xxhdpi";
                break;
            case 560:
            case 640:
                obj = "xxxhdpi";
                break;
            default:
                obj = "mdpi";
                break;
        }
        jSONObject.put("density_dpi", i4);
        jSONObject.put("display_density", obj);
        WindowManager windowManager = (WindowManager) this.e.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = windowManager.getDefaultDisplay();
        try {
        } catch (Throwable th) {
            th = th;
            i = 0;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
            i = displayMetrics.widthPixels;
            try {
                i2 = i;
                i3 = displayMetrics.heightPixels;
            } catch (Throwable th2) {
                th = th2;
                z2.a(th);
                i2 = i;
                i3 = 0;
                int[] iArr = {i2, i3};
                jSONObject.put("resolution", iArr[1] + "x" + iArr[0]);
                return true;
            }
        } else {
            Method method = Display.class.getMethod("getRawHeight", new Class[0]);
            Method method2 = Display.class.getMethod("getRawWidth", new Class[0]);
            i = method2 != null ? ((Integer) method2.invoke(defaultDisplay, new Object[0])).intValue() : 0;
            i2 = i;
            if (method != null) {
                try {
                    i2 = i;
                    i3 = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
                } catch (Throwable th3) {
                    th = th3;
                    z2.a(th);
                    i2 = i;
                    i3 = 0;
                    int[] iArr2 = {i2, i3};
                    jSONObject.put("resolution", iArr2[1] + "x" + iArr2[0]);
                    return true;
                }
            }
            i3 = 0;
        }
        int[] iArr22 = {i2, i3};
        jSONObject.put("resolution", iArr22[1] + "x" + iArr22[0]);
        return true;
    }
}

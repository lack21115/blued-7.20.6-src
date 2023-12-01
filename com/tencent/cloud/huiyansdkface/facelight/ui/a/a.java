package com.tencent.cloud.huiyansdkface.facelight.ui.a;

import android.app.Activity;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.applog.tracker.Tracker;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/ui/a/a.class */
public abstract class a extends Activity {
    private boolean a() {
        return "EmotionUI_3.1".equals(b());
    }

    private String b() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, "ro.build.version.emui");
        } catch (Exception e) {
            return "";
        }
    }

    public void a(String str) {
        View decorView;
        int i;
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
            decorView = getWindow().getDecorView();
            i = 8;
        } else if (Build.VERSION.SDK_INT >= 21) {
            View decorView2 = getWindow().getDecorView();
            if (!a()) {
                getWindow().clearFlags(67108864);
            }
            int i2 = 5378;
            if (Build.VERSION.SDK_INT >= 23) {
                i2 = 5378;
                if (!WbCloudFaceContant.BLACK.equals(str)) {
                    i2 = 13314;
                }
            }
            decorView2.setSystemUiVisibility(i2);
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(0);
            return;
        } else {
            decorView = getWindow().getDecorView();
            i = 4098;
        }
        decorView.setSystemUiVisibility(i);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }
}

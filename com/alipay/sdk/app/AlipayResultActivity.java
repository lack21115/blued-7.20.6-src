package com.alipay.sdk.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import com.alipay.sdk.util.l;
import com.bytedance.applog.tracker.Tracker;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/AlipayResultActivity.class */
public class AlipayResultActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f4571a = new ConcurrentHashMap<>();

    /* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/AlipayResultActivity$a.class */
    public interface a {
        void a(int i, String str, String str2);
    }

    private void a(String str, Bundle bundle) {
        a remove = f4571a.remove(str);
        if (remove == null) {
            return;
        }
        try {
            remove.a(bundle.getInt("endCode"), bundle.getString(l.b), bundle.getString("result"));
        } finally {
            finish();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a1, code lost:
        if (r11 == null) goto L48;
     */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r8) {
        /*
            Method dump skipped, instructions count: 500
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.AlipayResultActivity.onCreate(android.os.Bundle):void");
    }
}

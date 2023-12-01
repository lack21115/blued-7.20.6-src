package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.alipay.sdk.sys.a;
import com.bytedance.applog.tracker.Tracker;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/PayResultActivity.class */
public final class PayResultActivity extends Activity {
    public static final String a = "{\"isLogin\":\"false\"}";
    public static final HashMap<String, Object> b = new HashMap<>();
    public static final String c = "hk.alipay.wallet";
    public static final String d = "phonecashier.pay.hash";
    public static final String e = "orderSuffix";
    public static final String f = "externalPkgName";
    public static final String g = "phonecashier.pay.result";
    public static final String h = "phonecashier.pay.resultOrderHash";
    private com.alipay.sdk.sys.a i = null;

    /* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/PayResultActivity$a.class */
    public static final class a {
        public static volatile String a;
        public static volatile String b;
    }

    private static void a(Activity activity, int i) {
        new Handler().postDelayed(new f(activity), i);
    }

    private static void a(Activity activity, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        Intent intent = new Intent();
        try {
            intent.setPackage(c);
            intent.setData(Uri.parse("alipayhk://platformapi/startApp?appId=20000125&schemePaySession=" + URLEncoder.encode(str, "UTF-8") + "&orderSuffix=" + URLEncoder.encode(str2, "UTF-8") + "&packageName=" + URLEncoder.encode(str3, "UTF-8") + "&externalPkgName=" + URLEncoder.encode(str3, "UTF-8")));
        } catch (UnsupportedEncodingException e2) {
            com.alipay.sdk.util.c.a(e2);
        }
        if (activity != null) {
            try {
                activity.startActivity(intent);
            } catch (Throwable th) {
                activity.finish();
            }
        }
    }

    private static void a(String str) {
        a.b = j.c();
        a(b, str);
    }

    private static void a(String str, String str2) {
        a.b = str;
        a(b, str2);
    }

    private static boolean a(HashMap<String, Object> hashMap, String str) {
        Object obj;
        if (hashMap == null || str == null || (obj = hashMap.get(str)) == null) {
            return false;
        }
        synchronized (obj) {
            obj.notifyAll();
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            if (!TextUtils.isEmpty(intent.getStringExtra(e))) {
                a.a = intent.getStringExtra(d);
                String stringExtra = intent.getStringExtra(e);
                String stringExtra2 = intent.getStringExtra(f);
                com.alipay.sdk.sys.a a2 = a.C0010a.a(intent);
                this.i = a2;
                if (a2 == null) {
                    finish();
                }
                a(this, a.a, stringExtra, stringExtra2);
                a(this, 300);
                return;
            }
            if (this.i == null) {
                finish();
            }
            String stringExtra3 = intent.getStringExtra(g);
            int intExtra = intent.getIntExtra(h, 0);
            if (intExtra != 0 && TextUtils.equals(a.a, String.valueOf(intExtra))) {
                if (TextUtils.isEmpty(stringExtra3)) {
                    a(a.a);
                } else {
                    a(stringExtra3, a.a);
                }
                a.a = "";
                a(this, 300);
                return;
            }
            com.alipay.sdk.sys.a aVar = this.i;
            com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.ad, "Expected " + a.a + ", got " + intExtra);
            a(a.a);
            a(this, 300);
        } catch (Throwable th) {
            finish();
        }
    }
}

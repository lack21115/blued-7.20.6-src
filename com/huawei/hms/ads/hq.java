package com.huawei.hms.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/hq.class */
public class hq {
    private static final String B = "NotificationActionManager";
    private static final byte[] C = new byte[0];
    public static final String Code = "com.huawei.ads.notification.action.CLICK";
    public static final int I = 1;
    private static hq S;
    public static final String V = "com.huawei.ads.notification.action.DELETE";
    public static final String Z = "type";
    private Context D;
    private fk L;
    private byte[] F = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Class<? extends hp>> f22493a = new HashMap();
    private BroadcastReceiver b = new BroadcastReceiver() { // from class: com.huawei.hms.ads.hq.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || TextUtils.isEmpty(intent.getAction())) {
                ge.Code(hq.B, "intent or action maybe empty.");
                return;
            }
            ge.Code(hq.B, " action name:%s", intent.getAction());
            hq.this.Code(context, intent);
        }
    };

    private hq(Context context) {
        this.D = context.getApplicationContext();
        this.L = fk.Code(context);
    }

    public static hq Code(Context context) {
        synchronized (C) {
            if (S == null) {
                S = new hq(context);
            }
        }
        return S;
    }

    private void V() {
        this.f22493a.put("com.huawei.ads.notification.action.CLICK1", hk.class);
        this.f22493a.put("com.huawei.ads.notification.action.DELETE1", hm.class);
    }

    public void Code() {
        String str;
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(V);
            this.D.registerReceiver(this.b, intentFilter);
        } catch (IllegalStateException e) {
            str = "init IllegalStateException";
            ge.I(B, str);
            V();
        } catch (Exception e2) {
            str = "init Exception";
            ge.I(B, str);
            V();
        }
        V();
    }

    public void Code(Context context, Intent intent) {
        StringBuilder sb;
        String str;
        String str2;
        try {
            int intExtra = intent.getIntExtra("type", 1);
            String str3 = intent.getAction() + intExtra;
            Class<? extends hp> cls = this.f22493a.get(str3);
            if (cls == null) {
                ge.V(B, "can not find action key:" + str3);
                return;
            }
            try {
                hp newInstance = cls.newInstance();
                if (newInstance != null) {
                    newInstance.Code(this.D, intent);
                }
            } catch (InstantiationException e) {
                str2 = "InstantiationException can not instantiation notification Action";
                ge.I(B, str2);
            } catch (Throwable th) {
                str2 = "Throwable can not instantiation notification Action";
                ge.I(B, str2);
            }
        } catch (IllegalStateException e2) {
            e = e2;
            sb = new StringBuilder();
            str = "actionReceiver.onReceive IllegalStateException:";
            sb.append(str);
            sb.append(e.getClass().getSimpleName());
            ge.I(B, sb.toString());
        } catch (Throwable th2) {
            e = th2;
            sb = new StringBuilder();
            str = "actionReceiver.onReceive Exception:";
            sb.append(str);
            sb.append(e.getClass().getSimpleName());
            ge.I(B, sb.toString());
        }
    }

    public void Code(String str) {
        if (TextUtils.isEmpty(str)) {
            ge.V(B, "add packageName is Empty.");
            return;
        }
        synchronized (this.F) {
            try {
                Set<String> ai = this.L.ai();
                if (ai != null) {
                    ai.add(str);
                    fk.Code(this.D).Code(ai);
                }
            }
        }
    }

    public boolean I(String str) {
        if (TextUtils.isEmpty(str)) {
            ge.V(B, "isPackageExist packageName is Empty.");
            return false;
        }
        synchronized (this.F) {
            Set<String> ai = this.L.ai();
            if (ai != null) {
                return ai.contains(str);
            }
            return false;
        }
    }

    public void V(String str) {
        if (TextUtils.isEmpty(str)) {
            ge.V(B, "remove packageName is Empty.");
            return;
        }
        synchronized (this.F) {
            try {
                Set<String> ai = this.L.ai();
                if (ai != null) {
                    ai.remove(str);
                    fk.Code(this.D).Code(ai);
                }
            }
        }
    }
}

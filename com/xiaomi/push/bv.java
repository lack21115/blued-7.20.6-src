package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.ai;
import com.xiaomi.push.ch;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/bv.class */
public class bv {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bv f41291a;

    /* renamed from: a  reason: collision with other field name */
    private Context f227a;

    /* renamed from: a  reason: collision with other field name */
    private ck f229a;

    /* renamed from: a  reason: collision with other field name */
    private cl f230a;
    private String e;
    private String f;

    /* renamed from: a  reason: collision with other field name */
    private final String f231a = "push_stat_sp";

    /* renamed from: b  reason: collision with other field name */
    private final String f232b = "upload_time";

    /* renamed from: c  reason: collision with other field name */
    private final String f233c = "delete_time";
    private final String d = "check_time";

    /* renamed from: a  reason: collision with other field name */
    private ai.a f228a = new bw(this);
    private ai.a b = new bx(this);

    /* renamed from: c  reason: collision with root package name */
    private ai.a f41292c = new by(this);

    private bv(Context context) {
        this.f227a = context;
    }

    public static bv a(Context context) {
        if (f41291a == null) {
            synchronized (bv.class) {
                try {
                    if (f41291a == null) {
                        f41291a = new bv(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f41291a;
    }

    private boolean a() {
        return com.xiaomi.push.service.ba.a(this.f227a).a(hl.StatDataSwitch.a(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        SharedPreferences.Editor edit = this.f227a.getSharedPreferences("push_stat_sp", 0).edit();
        edit.putLong(str, System.currentTimeMillis());
        p.a(edit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        return this.f227a.getDatabasePath(bz.f235a).getAbsolutePath();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m11558a() {
        return this.e;
    }

    public void a(ch.a aVar) {
        ch.a(this.f227a).a(aVar);
    }

    public void a(hk hkVar) {
        if (a() && com.xiaomi.push.service.bz.a(hkVar.e())) {
            a(ce.a(this.f227a, c(), hkVar));
        }
    }

    public void a(String str) {
        if (a() && !TextUtils.isEmpty(str)) {
            a(cm.a(this.f227a, str));
        }
    }

    public void a(String str, String str2, Boolean bool) {
        if (this.f229a != null) {
            if (bool.booleanValue()) {
                this.f229a.a(this.f227a, str2, str);
            } else {
                this.f229a.b(this.f227a, str2, str);
            }
        }
    }

    public String b() {
        return this.f;
    }
}

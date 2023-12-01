package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/eb.class */
public final class eb {

    /* renamed from: a  reason: collision with root package name */
    private static volatile eb f27678a;

    /* renamed from: a  reason: collision with other field name */
    private int f333a;

    /* renamed from: a  reason: collision with other field name */
    private Context f334a;

    /* renamed from: a  reason: collision with other field name */
    private ef f335a;

    /* renamed from: a  reason: collision with other field name */
    private String f336a;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<ed, ee> f337a;
    private String b;

    private eb(Context context) {
        HashMap<ed, ee> hashMap = new HashMap<>();
        this.f337a = hashMap;
        this.f334a = context;
        hashMap.put(ed.SERVICE_ACTION, new eh());
        this.f337a.put(ed.SERVICE_COMPONENT, new ei());
        this.f337a.put(ed.ACTIVITY, new dz());
        this.f337a.put(ed.PROVIDER, new eg());
    }

    public static eb a(Context context) {
        if (f27678a == null) {
            synchronized (eb.class) {
                try {
                    if (f27678a == null) {
                        f27678a = new eb(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f27678a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ed edVar, Context context, ea eaVar) {
        this.f337a.get(edVar).a(context, eaVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m8659a(Context context) {
        return com.xiaomi.push.service.ak.m9061a(context, context.getPackageName());
    }

    public final int a() {
        return this.f333a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final ef m8660a() {
        return this.f335a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final String m8661a() {
        return this.f336a;
    }

    public final void a(int i) {
        this.f333a = i;
    }

    public final void a(Context context, String str, int i, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            dx.a(context, String.valueOf(str), 1008, "A receive a incorrect message");
            return;
        }
        a(i);
        ai.a(this.f334a).a(new ec(this, str, context, str2, str3));
    }

    public final void a(ed edVar, Context context, Intent intent, String str) {
        if (edVar != null) {
            this.f337a.get(edVar).a(context, intent, str);
        } else {
            dx.a(context, com.igexin.push.core.b.l, 1008, "A receive a incorrect message with empty type");
        }
    }

    public final void a(ef efVar) {
        this.f335a = efVar;
    }

    public final void a(String str) {
        this.f336a = str;
    }

    public final void a(String str, String str2, int i, ef efVar) {
        a(str);
        b(str2);
        a(i);
        a(efVar);
    }

    public final String b() {
        return this.b;
    }

    public final void b(String str) {
        this.b = str;
    }
}

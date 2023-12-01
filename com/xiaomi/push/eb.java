package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/eb.class */
public final class eb {

    /* renamed from: a  reason: collision with root package name */
    private static volatile eb f41369a;

    /* renamed from: a  reason: collision with other field name */
    private int f380a;

    /* renamed from: a  reason: collision with other field name */
    private Context f381a;

    /* renamed from: a  reason: collision with other field name */
    private ef f382a;

    /* renamed from: a  reason: collision with other field name */
    private String f383a;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<ed, ee> f384a;
    private String b;

    private eb(Context context) {
        HashMap<ed, ee> hashMap = new HashMap<>();
        this.f384a = hashMap;
        this.f381a = context;
        hashMap.put(ed.SERVICE_ACTION, new eh());
        this.f384a.put(ed.SERVICE_COMPONENT, new ei());
        this.f384a.put(ed.ACTIVITY, new dz());
        this.f384a.put(ed.PROVIDER, new eg());
    }

    public static eb a(Context context) {
        if (f41369a == null) {
            synchronized (eb.class) {
                try {
                    if (f41369a == null) {
                        f41369a = new eb(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f41369a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ed edVar, Context context, ea eaVar) {
        this.f384a.get(edVar).a(context, eaVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m11709a(Context context) {
        return com.xiaomi.push.service.ak.m12111a(context, context.getPackageName());
    }

    public final int a() {
        return this.f380a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final ef m11710a() {
        return this.f382a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final String m11711a() {
        return this.f383a;
    }

    public final void a(int i) {
        this.f380a = i;
    }

    public final void a(Context context, String str, int i, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            dx.a(context, String.valueOf(str), 1008, "A receive a incorrect message");
            return;
        }
        a(i);
        ai.a(this.f381a).a(new ec(this, str, context, str2, str3));
    }

    public final void a(ed edVar, Context context, Intent intent, String str) {
        if (edVar != null) {
            this.f384a.get(edVar).a(context, intent, str);
        } else {
            dx.a(context, com.igexin.push.core.b.l, 1008, "A receive a incorrect message with empty type");
        }
    }

    public final void a(ef efVar) {
        this.f382a = efVar;
    }

    public final void a(String str) {
        this.f383a = str;
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

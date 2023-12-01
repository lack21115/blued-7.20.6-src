package com.xiaomi.push;

import android.content.Context;
import java.lang.reflect.Method;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/aw.class */
class aw implements as {

    /* renamed from: a  reason: collision with root package name */
    private Context f27572a;

    /* renamed from: a  reason: collision with other field name */
    private Class<?> f154a;

    /* renamed from: a  reason: collision with other field name */
    private Object f155a;

    /* renamed from: a  reason: collision with other field name */
    private Method f156a = null;
    private Method b = null;

    /* renamed from: c  reason: collision with root package name */
    private Method f27573c = null;
    private Method d = null;

    public aw(Context context) {
        this.f27572a = context;
        a(context);
    }

    private String a(Context context, Method method) {
        Object obj = this.f155a;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("miui invoke error", e);
            return null;
        }
    }

    private void a(Context context) {
        try {
            Class<?> a2 = r.a(context, "com.android.id.impl.IdProviderImpl");
            this.f154a = a2;
            this.f155a = a2.newInstance();
            this.b = this.f154a.getMethod("getOAID", Context.class);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("miui load class error", e);
        }
    }

    @Override // com.xiaomi.push.as
    /* renamed from: a */
    public String mo8458a() {
        return a(this.f27572a, this.b);
    }

    @Override // com.xiaomi.push.as
    /* renamed from: a */
    public boolean mo8459a() {
        return (this.f154a == null || this.f155a == null) ? false : true;
    }
}

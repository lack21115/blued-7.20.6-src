package com.xiaomi.push;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/aw.class */
public class aw implements as {

    /* renamed from: a  reason: collision with root package name */
    private Context f41263a;

    /* renamed from: a  reason: collision with other field name */
    private Class<?> f201a;

    /* renamed from: a  reason: collision with other field name */
    private Object f202a;

    /* renamed from: a  reason: collision with other field name */
    private Method f203a = null;
    private Method b = null;

    /* renamed from: c  reason: collision with root package name */
    private Method f41264c = null;
    private Method d = null;

    public aw(Context context) {
        this.f41263a = context;
        a(context);
    }

    private String a(Context context, Method method) {
        Object obj = this.f202a;
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
            this.f201a = a2;
            this.f202a = a2.newInstance();
            this.b = this.f201a.getMethod("getOAID", Context.class);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("miui load class error", e);
        }
    }

    @Override // com.xiaomi.push.as
    /* renamed from: a */
    public String mo11508a() {
        return a(this.f41263a, this.b);
    }

    @Override // com.xiaomi.push.as
    /* renamed from: a */
    public boolean mo11509a() {
        return (this.f201a == null || this.f202a == null) ? false : true;
    }
}

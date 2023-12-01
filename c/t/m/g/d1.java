package c.t.m.g;

import android.content.Context;
import java.lang.reflect.Method;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/d1.class */
public class d1 {

    /* renamed from: a  reason: collision with root package name */
    public Context f3737a;
    public Class b;

    /* renamed from: c  reason: collision with root package name */
    public Object f3738c;
    public Method d;

    public d1(Context context) {
        this.f3737a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.b = cls;
            this.f3738c = cls.newInstance();
        } catch (Exception e) {
        }
        try {
            this.d = this.b.getMethod("getOAID", Context.class);
        } catch (Exception e2) {
        }
    }

    public String a() {
        return a(this.f3737a, this.d);
    }

    public final String a(Context context, Method method) {
        Object obj = this.f3738c;
        if (obj == null || method == null) {
            return null;
        }
        try {
            return (String) method.invoke(obj, context);
        } catch (Exception e) {
            return null;
        }
    }
}

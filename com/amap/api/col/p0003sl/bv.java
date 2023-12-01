package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.col.p0003sl.hp;
import com.amap.api.maps.AMapException;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.bv  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/bv.class */
public abstract class bv<T, V> {

    /* renamed from: a  reason: collision with root package name */
    protected T f4797a;
    protected int b = 3;

    /* renamed from: c  reason: collision with root package name */
    protected Context f4798c;

    public bv(Context context, T t) {
        a(context, t);
    }

    private void a(Context context, T t) {
        this.f4798c = context;
        this.f4797a = t;
    }

    private V d() throws AMapException {
        int i;
        int i2;
        String str;
        AMapException aMapException;
        int i3 = 0;
        V v = null;
        hp.b bVar = null;
        while (i3 < this.b) {
            V v2 = v;
            hp.b bVar2 = bVar;
            try {
                bVar = hp.a(this.f4798c, dw.a(), a(), b());
                V v3 = v;
                v = a(a(bVar));
                i3 = this.b;
            } finally {
                if (i < i2) {
                    continue;
                }
            }
        }
        return v;
    }

    protected abstract V a(JSONObject jSONObject) throws AMapException;

    protected abstract String a();

    protected abstract JSONObject a(hp.b bVar);

    protected abstract Map<String, String> b();

    public final V c() throws AMapException {
        if (this.f4797a != null) {
            return d();
        }
        return null;
    }
}

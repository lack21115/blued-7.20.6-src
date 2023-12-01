package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.col.p0003sl.hp;
import com.amap.api.maps.AMapException;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.bv  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/bv.class */
public abstract class bv<T, V> {
    protected T a;
    protected int b = 3;
    protected Context c;

    public bv(Context context, T t) {
        a(context, t);
    }

    private void a(Context context, T t) {
        this.c = context;
        this.a = t;
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
                bVar = hp.a(this.c, dw.a(), a(), b());
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
        if (this.a != null) {
            return d();
        }
        return null;
    }
}

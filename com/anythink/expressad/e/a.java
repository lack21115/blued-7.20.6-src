package com.anythink.expressad.e;

import android.content.Context;
import com.anythink.expressad.foundation.g.f.m;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/e/a.class */
public final class a implements com.anythink.expressad.b {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, String> f7147a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7148c = false;

    private void a() {
        this.f7148c = false;
        try {
            m.a(this.b);
            com.anythink.expressad.foundation.b.b.a().a(f7147a, this.b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.b
    public final void a(Map<String, String> map, Context context) {
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        f7147a = map;
        this.f7148c = false;
        try {
            m.a(applicationContext);
            com.anythink.expressad.foundation.b.b.a().a(f7147a, this.b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

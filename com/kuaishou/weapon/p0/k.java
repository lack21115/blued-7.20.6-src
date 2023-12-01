package com.kuaishou.weapon.p0;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/k.class */
public class k<T> implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private String f10230a;
    private JSONObject b;

    /* renamed from: c  reason: collision with root package name */
    private j f10231c;
    private Context d;
    private String e;
    private String f;

    public k(Context context, String str, String str2, String str3, JSONObject jSONObject, j jVar) {
        this.d = context;
        this.f10230a = str3;
        this.b = jSONObject;
        this.f10231c = jVar;
        this.e = str;
        this.f = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            l a2 = l.a(this.d);
            m mVar = new m(this.f10230a, this.b);
            mVar.a(this.e);
            mVar.b(this.f);
            a2.b(mVar, new j() { // from class: com.kuaishou.weapon.p0.k.1
                @Override // com.kuaishou.weapon.p0.j
                public void a(String str) {
                    e.c("WeaponHttpTask sendLog response: --- " + str);
                    if (k.this.f10231c != null) {
                        k.this.f10231c.a(str);
                    }
                }

                @Override // com.kuaishou.weapon.p0.j
                public void b(String str) {
                    e.c("WeaponHttpTask sendLog errorMsg: --- " + str);
                    if (k.this.f10231c != null) {
                        k.this.f10231c.b(str);
                    }
                }
            });
        } catch (Throwable th) {
        }
    }
}

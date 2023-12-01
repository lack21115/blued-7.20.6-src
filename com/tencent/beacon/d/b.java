package com.tencent.beacon.d;

import android.content.SharedPreferences;
import com.tencent.beacon.a.d.a;
import com.tencent.beacon.base.net.b.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/d/b.class */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f35010a;
    final /* synthetic */ com.tencent.beacon.a.d.a b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ c f35011c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar, String str, com.tencent.beacon.a.d.a aVar) {
        this.f35011c = cVar;
        this.f35010a = str;
        this.b = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean c2;
        boolean z;
        if (d.d()) {
            c2 = this.f35011c.c();
            z = this.f35011c.f35013c;
            if (z && c2) {
                com.tencent.beacon.base.util.c.a("[event] rqd_heartbeat A85=Y report success : " + this.f35010a, new Object[0]);
                a.SharedPreferences$EditorC0895a edit = this.b.edit();
                if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor) edit)) {
                    edit.putString("active_user_date", this.f35010a).commit();
                    edit.putString("HEART_DENGTA", this.f35010a).commit();
                }
            }
        }
    }
}

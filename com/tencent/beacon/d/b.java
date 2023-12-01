package com.tencent.beacon.d;

import android.content.SharedPreferences;
import com.tencent.beacon.a.d.a;
import com.tencent.beacon.base.net.b.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/d/b.class */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f21319a;
    final /* synthetic */ com.tencent.beacon.a.d.a b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ c f21320c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar, String str, com.tencent.beacon.a.d.a aVar) {
        this.f21320c = cVar;
        this.f21319a = str;
        this.b = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean c2;
        boolean z;
        if (d.d()) {
            c2 = this.f21320c.c();
            z = this.f21320c.f21322c;
            if (z && c2) {
                com.tencent.beacon.base.util.c.a("[event] rqd_heartbeat A85=Y report success : " + this.f21319a, new Object[0]);
                a.SharedPreferences$EditorC0725a edit = this.b.edit();
                if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor) edit)) {
                    edit.putString("active_user_date", this.f21319a).commit();
                    edit.putString("HEART_DENGTA", this.f21319a).commit();
                }
            }
        }
    }
}

package com.tencent.beacon.e;

import android.content.SharedPreferences;
import com.tencent.beacon.a.d.a;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/e/g.class */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f35021a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ h f35022c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(h hVar, String str, String str2) {
        this.f35022c = hVar;
        this.f35021a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Date d = com.tencent.beacon.base.util.b.d(this.f35021a);
        long time = d != null ? d.getTime() / 1000 : 0L;
        long j = time;
        if (time == 0) {
            j = (new Date().getTime() / 1000) + 86400;
        }
        a.SharedPreferences$EditorC0895a edit = com.tencent.beacon.a.d.a.a().edit();
        if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor) edit)) {
            edit.putString("sid_value", this.b).putLong("sid_mt", j);
        }
    }
}

package com.xiaomi.push.service;

import android.util.Base64;
import com.xiaomi.push.al;
import com.xiaomi.push.cx;
import com.xiaomi.push.du;
import com.xiaomi.push.service.bv;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bw.class */
public class bw extends al.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bv f41654a;

    /* renamed from: a  reason: collision with other field name */
    boolean f1031a = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bv bvVar) {
        this.f41654a = bvVar;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        try {
            du.a a2 = du.a.a(Base64.decode(cx.a(com.xiaomi.push.r.m12066a(), "https://resolver.msg.xiaomi.net/psc/?t=a", (List<com.xiaomi.push.bg>) null), 10));
            if (a2 != null) {
                this.f41654a.f1029a = a2;
                this.f1031a = true;
                this.f41654a.e();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("fetch config failure: " + e.getMessage());
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo11618c() {
        List list;
        List list2;
        bv.a[] aVarArr;
        du.a aVar;
        this.f41654a.f1028a = null;
        if (!this.f1031a) {
            return;
        }
        synchronized (this.f41654a) {
            list = this.f41654a.f1030a;
            list2 = this.f41654a.f1030a;
            aVarArr = (bv.a[]) list.toArray(new bv.a[list2.size()]);
        }
        int length = aVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            bv.a aVar2 = aVarArr[i2];
            aVar = this.f41654a.f1029a;
            aVar2.a(aVar);
            i = i2 + 1;
        }
    }
}

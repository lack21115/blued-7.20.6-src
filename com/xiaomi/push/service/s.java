package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hg;
import com.xiaomi.push.ht;
import com.xiaomi.push.ic;
import com.xiaomi.push.iq;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/s.class */
class s extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ r f41700a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f1078a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ List f1079a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(r rVar, int i, String str, List list, String str2) {
        super(i);
        this.f41700a = rVar;
        this.f1078a = str;
        this.f1079a = list;
        this.b = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo12102a() {
        return "Send tiny data.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo11743a() {
        String a2;
        XMPushService xMPushService;
        a2 = this.f41700a.a(this.f1078a);
        ArrayList<Cif> a3 = bz.a(this.f1079a, this.f1078a, a2, 32768);
        if (a3 == null) {
            com.xiaomi.channel.commonutils.logger.b.d("TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.");
            return;
        }
        Iterator<Cif> it = a3.iterator();
        while (it.hasNext()) {
            Cif next = it.next();
            next.a("uploadWay", "longXMPushService");
            ic a4 = ah.a(this.f1078a, a2, next, hg.Notification);
            if (!TextUtils.isEmpty(this.b) && !TextUtils.equals(this.f1078a, this.b)) {
                if (a4.m11945a() == null) {
                    ht htVar = new ht();
                    htVar.a("-1");
                    a4.a(htVar);
                }
                a4.m11945a().b("ext_traffic_source_pkg", this.b);
            }
            byte[] a5 = iq.a(a4);
            xMPushService = this.f41700a.f41697a;
            xMPushService.a(this.f1078a, a5, true);
        }
    }
}

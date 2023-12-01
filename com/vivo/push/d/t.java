package com.vivo.push.d;

import android.content.Context;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.IntentConstant;
import com.vivo.push.d.r;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/d/t.class */
final class t implements r.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ s f41086a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.f41086a = sVar;
    }

    @Override // com.vivo.push.d.r.a
    public final void a() {
        Context context;
        Context context2;
        long l = com.vivo.push.e.a().l();
        if (l < 1400 && l != 1340) {
            com.vivo.push.util.p.b("OnNotificationArrivedTask", "引擎版本太低，不支持正向展示功能，pushEngineSDKVersion：".concat(String.valueOf(l)));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("srt", "1");
        hashMap.put("message_id", String.valueOf(this.f41086a.b.f()));
        context = this.f41086a.f41085c.f41105a;
        context2 = this.f41086a.f41085c.f41105a;
        String b = com.vivo.push.util.z.b(context, context2.getPackageName());
        if (!TextUtils.isEmpty(b)) {
            hashMap.put("app_id", b);
        }
        hashMap.put("type", "1");
        hashMap.put("dtp", "1");
        com.vivo.push.util.e.a(6L, hashMap);
    }

    @Override // com.vivo.push.d.r.a
    public final void b() {
        Context context;
        Context context2;
        HashMap hashMap = new HashMap();
        hashMap.put(IntentConstant.MESSAGE_ID, String.valueOf(this.f41086a.b.f()));
        context = this.f41086a.f41085c.f41105a;
        context2 = this.f41086a.f41085c.f41105a;
        String b = com.vivo.push.util.z.b(context, context2.getPackageName());
        if (!TextUtils.isEmpty(b)) {
            hashMap.put("remoteAppId", b);
        }
        com.vivo.push.util.e.a(2122L, hashMap);
    }
}

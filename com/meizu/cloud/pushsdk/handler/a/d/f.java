package com.meizu.cloud.pushsdk.handler.a.d;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.a.c.h;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/handler/a/d/f.class */
public class f extends com.meizu.cloud.pushsdk.handler.a.a<h> {
    public f(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 262144;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: a */
    public void b(h hVar) {
        com.meizu.cloud.pushsdk.util.d.b(d(), hVar.c(), hVar.a().b().d(), hVar.a().b().a(), hVar.a().b().e(), hVar.a().b().b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(h hVar, com.meizu.cloud.pushsdk.notification.c cVar) {
        NotificationManager notificationManager = (NotificationManager) d().getSystemService("notification");
        if (notificationManager != null) {
            DebugLogger.e("AbstractMessageHandler", "start cancel notification id " + hVar.b());
            notificationManager.cancel(hVar.b());
            com.meizu.cloud.pushsdk.handler.a.a.a b = com.meizu.cloud.pushsdk.b.a(d()).b();
            if (b != null) {
                b.a(hVar.b());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    @Override // com.meizu.cloud.pushsdk.handler.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(android.content.Intent r4) {
        /*
            r3 = this;
            java.lang.String r0 = "AbstractMessageHandler"
            java.lang.String r1 = "start WithDrawMessageHandler match"
            com.meizu.cloud.pushinternal.DebugLogger.i(r0, r1)
            r0 = r4
            java.lang.String r1 = "mz_push_control_message"
            java.lang.String r0 = r0.getStringExtra(r1)
            r8 = r0
            r0 = r8
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r6 = r0
            r0 = 0
            r7 = r0
            r0 = r6
            if (r0 != 0) goto L37
            r0 = r8
            com.meizu.cloud.pushsdk.handler.a.c.b r0 = com.meizu.cloud.pushsdk.handler.a.c.b.a(r0)
            r8 = r0
            r0 = r8
            com.meizu.cloud.pushsdk.handler.a.c.a r0 = r0.a()
            if (r0 == 0) goto L37
            r0 = r8
            com.meizu.cloud.pushsdk.handler.a.c.a r0 = r0.a()
            int r0 = r0.a()
            r5 = r0
            goto L39
        L37:
            r0 = 0
            r5 = r0
        L39:
            r0 = r7
            r6 = r0
            java.lang.String r0 = "com.meizu.flyme.push.intent.MESSAGE"
            r1 = r4
            java.lang.String r1 = r1.getAction()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L59
            r0 = r7
            r6 = r0
            java.lang.String r0 = "4"
            r1 = r5
            java.lang.String r1 = java.lang.String.valueOf(r1)
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L59
            r0 = 1
            r6 = r0
        L59:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.handler.a.d.f.a(android.content.Intent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: l */
    public h c(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.MZ_PUSH_CONTROL_MESSAGE);
        String stringExtra2 = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_SEQ_ID);
        return new h(intent.getStringExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE), g(intent), stringExtra, intent.getStringExtra(PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY), stringExtra2);
    }
}

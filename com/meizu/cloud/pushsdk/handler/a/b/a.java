package com.meizu.cloud.pushsdk.handler.a.b;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.a.c.g;
import com.meizu.cloud.pushsdk.notification.c;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.meizu.cloud.pushsdk.util.d;
import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/handler/a/b/a.class */
public class a extends com.meizu.cloud.pushsdk.handler.a.a<g> {
    public a(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 65536;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: a */
    public void b(g gVar) {
        d.b(d(), d().getPackageName(), gVar.d().b().d(), gVar.d().b().a(), gVar.d().b().e(), gVar.d().b().b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(g gVar, c cVar) {
        String str;
        String message;
        String str2;
        String str3;
        DebugLogger.flush();
        String a2 = gVar.d().b().a();
        String d = gVar.d().b().d();
        if (Build.VERSION.SDK_INT >= 29) {
            str = MzSystemUtils.getDocumentsPath(d()) + "/pushSdktmp/" + a2 + "_" + d + ".zip";
        } else {
            str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdktmp/" + a2 + "_" + d + ".zip";
        }
        File file = null;
        try {
            new b(str).a(gVar.c());
            file = new File(str);
            message = null;
        } catch (Exception e) {
            message = e.getMessage();
            DebugLogger.e("AbstractMessageHandler", "zip error message " + message);
        }
        if (file == null || file.length() / 1024 <= gVar.a()) {
            str2 = message;
            if (gVar.b()) {
                str2 = message;
                if (!com.meizu.cloud.pushsdk.util.a.b(d())) {
                    str2 = "current network not allowed upload log file";
                }
            }
        } else {
            str2 = "the upload file exceeds the max size";
        }
        com.meizu.cloud.pushsdk.c.a.c<String> a3 = com.meizu.cloud.pushsdk.platform.a.b.a(d()).a(gVar.d().b().a(), gVar.d().b().d(), str2, file);
        if (a3 != null && a3.b()) {
            if (file != null) {
                file.delete();
            }
            DebugLogger.e("AbstractMessageHandler", "upload success " + a3.a());
            return;
        }
        if (a3 != null) {
            str3 = "upload error code " + a3.c() + a3.a();
        } else {
            str3 = "upload error";
        }
        DebugLogger.i("AbstractMessageHandler", str3);
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
            java.lang.String r1 = "start LogUploadMessageHandler match"
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
            java.lang.String r0 = "2"
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
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.handler.a.b.a.a(android.content.Intent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: l */
    public g c(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.MZ_PUSH_CONTROL_MESSAGE);
        String stringExtra2 = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_SEQ_ID);
        return new g(intent.getStringExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE), stringExtra, intent.getStringExtra(PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY), stringExtra2);
    }
}

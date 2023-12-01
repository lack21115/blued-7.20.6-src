package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/ap.class */
public class ap extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ao f41210a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(ao aoVar, Looper looper) {
        super(looper);
        this.f41210a = aoVar;
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        HashMap<String, String> m11478a;
        ao aoVar;
        au auVar;
        Context context6;
        Context context7;
        Context context8;
        Context context9;
        Context context10;
        Context context11;
        Context context12;
        ao aoVar2;
        au auVar2;
        Context context13;
        Context context14;
        if (message.what != 19) {
            return;
        }
        String str = (String) message.obj;
        int i = message.arg1;
        synchronized (af.class) {
            try {
                context = this.f41210a.f132a;
                if (af.a(context).m11428a(str)) {
                    context2 = this.f41210a.f132a;
                    if (af.a(context2).a(str) < 10) {
                        String string = message.getData() != null ? message.getData().getString("third_sync_reason") : "";
                        if (au.DISABLE_PUSH.ordinal() == i) {
                            context14 = this.f41210a.f132a;
                            if ("syncing".equals(af.a(context14).a(au.DISABLE_PUSH))) {
                                aoVar2 = this.f41210a;
                                auVar2 = au.DISABLE_PUSH;
                                aoVar2.a(str, auVar2, true, (HashMap<String, String>) null);
                                context13 = this.f41210a.f132a;
                                af.a(context13).b(str);
                            }
                        }
                        if (au.ENABLE_PUSH.ordinal() == i) {
                            context12 = this.f41210a.f132a;
                            if ("syncing".equals(af.a(context12).a(au.ENABLE_PUSH))) {
                                aoVar2 = this.f41210a;
                                auVar2 = au.ENABLE_PUSH;
                                aoVar2.a(str, auVar2, true, (HashMap<String, String>) null);
                                context13 = this.f41210a.f132a;
                                af.a(context13).b(str);
                            }
                        }
                        if (au.UPLOAD_HUAWEI_TOKEN.ordinal() == i) {
                            context10 = this.f41210a.f132a;
                            if ("syncing".equals(af.a(context10).a(au.UPLOAD_HUAWEI_TOKEN))) {
                                context11 = this.f41210a.f132a;
                                m11478a = i.m11478a(context11, e.ASSEMBLE_PUSH_HUAWEI);
                                m11478a.put("third_sync_reason", string);
                                aoVar = this.f41210a;
                                auVar = au.UPLOAD_HUAWEI_TOKEN;
                                aoVar.a(str, auVar, false, m11478a);
                                context13 = this.f41210a.f132a;
                                af.a(context13).b(str);
                            }
                        }
                        if (au.UPLOAD_FCM_TOKEN.ordinal() == i) {
                            context8 = this.f41210a.f132a;
                            if ("syncing".equals(af.a(context8).a(au.UPLOAD_FCM_TOKEN))) {
                                ao aoVar3 = this.f41210a;
                                au auVar3 = au.UPLOAD_FCM_TOKEN;
                                context9 = this.f41210a.f132a;
                                aoVar3.a(str, auVar3, false, i.m11478a(context9, e.ASSEMBLE_PUSH_FCM));
                                context13 = this.f41210a.f132a;
                                af.a(context13).b(str);
                            }
                        }
                        if (au.UPLOAD_COS_TOKEN.ordinal() == i) {
                            context6 = this.f41210a.f132a;
                            if ("syncing".equals(af.a(context6).a(au.UPLOAD_COS_TOKEN))) {
                                context7 = this.f41210a.f132a;
                                m11478a = i.m11478a(context7, e.ASSEMBLE_PUSH_COS);
                                m11478a.put("third_sync_reason", string);
                                aoVar = this.f41210a;
                                auVar = au.UPLOAD_COS_TOKEN;
                                aoVar.a(str, auVar, false, m11478a);
                                context13 = this.f41210a.f132a;
                                af.a(context13).b(str);
                            }
                        }
                        if (au.UPLOAD_FTOS_TOKEN.ordinal() == i) {
                            context4 = this.f41210a.f132a;
                            if ("syncing".equals(af.a(context4).a(au.UPLOAD_FTOS_TOKEN))) {
                                context5 = this.f41210a.f132a;
                                m11478a = i.m11478a(context5, e.ASSEMBLE_PUSH_FTOS);
                                m11478a.put("third_sync_reason", string);
                                aoVar = this.f41210a;
                                auVar = au.UPLOAD_FTOS_TOKEN;
                                aoVar.a(str, auVar, false, m11478a);
                            }
                        }
                        context13 = this.f41210a.f132a;
                        af.a(context13).b(str);
                    } else {
                        context3 = this.f41210a.f132a;
                        af.a(context3).c(str);
                    }
                }
            } finally {
            }
        }
    }
}

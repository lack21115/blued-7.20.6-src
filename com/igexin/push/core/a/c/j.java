package com.igexin.push.core.a.c;

import android.content.Intent;
import android.text.TextUtils;
import com.igexin.push.core.b.p;
import com.igexin.push.extension.mod.BaseActionBean;
import com.igexin.push.extension.mod.PushMessageInterface;
import com.igexin.push.extension.mod.PushTaskBean;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/a/c/j.class */
public final class j implements PushMessageInterface {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23423a = com.igexin.push.config.c.f23373a;

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final boolean executeAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean) {
        String id;
        String messageId;
        String str;
        p pVar = (p) baseActionBean;
        try {
            Intent a2 = com.igexin.push.f.d.a(pVar.b);
            a2.setPackage(com.igexin.push.core.e.l.getPackageName());
            a2.addFlags(268435456);
            if (com.igexin.push.f.c.b(a2, com.igexin.push.core.e.l)) {
                com.igexin.push.core.e.l.startActivity(a2);
                com.igexin.push.core.a.b.d();
                id = pushTaskBean.getTaskId();
                messageId = pushTaskBean.getMessageId();
                str = pVar.getDoActionId();
            } else {
                com.igexin.c.a.c.a.a(f23423a, "execute failed, activity not exist");
                com.igexin.c.a.c.a.a(f23423a + "|execute failed, activity not exist", new Object[0]);
                com.igexin.push.core.a.b.d();
                id = pushTaskBean.getId();
                messageId = pushTaskBean.getMessageId();
                str = pVar.f23455a;
            }
            com.igexin.push.core.a.b.a(id, messageId, str);
            return true;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.push.core.a.b.d();
            com.igexin.push.core.a.b.a(pushTaskBean.getId(), pushTaskBean.getMessageId(), pVar.f23455a);
            return true;
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final BaseActionBean parseAction(JSONObject jSONObject) {
        try {
            if (jSONObject.has(com.anythink.expressad.foundation.d.d.s) && jSONObject.has("actionid") && jSONObject.has("type") && jSONObject.has("uri") && jSONObject.has("do_failed")) {
                String optString = jSONObject.optString("uri");
                if (TextUtils.isEmpty(optString)) {
                    return null;
                }
                p pVar = new p();
                pVar.setType(com.igexin.push.core.b.o);
                pVar.setActionId(jSONObject.getString("actionid"));
                pVar.setDoActionId(jSONObject.getString(com.anythink.expressad.foundation.d.d.s));
                pVar.b = optString;
                pVar.f23455a = jSONObject.optString("do_failed");
                return pVar;
            }
            return null;
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final PushMessageInterface.ActionPrepareState prepareExecuteAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean) {
        p pVar = (p) baseActionBean;
        try {
            Intent a2 = com.igexin.push.f.d.a(pVar.b);
            a2.setPackage(com.igexin.push.core.e.l.getPackageName());
            a2.addFlags(268435456);
            if (com.igexin.push.f.c.b(a2, com.igexin.push.core.e.l)) {
                return PushMessageInterface.ActionPrepareState.success;
            }
            com.igexin.c.a.c.a.a(f23423a, "execute failed, activity not exist");
            com.igexin.c.a.c.a.a(f23423a + "|execute failed, activity not exist", new Object[0]);
            com.igexin.push.core.a.b.d();
            com.igexin.push.core.a.b.a(pushTaskBean.getId(), pushTaskBean.getMessageId(), pVar.f23455a);
            return PushMessageInterface.ActionPrepareState.stop;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.push.core.a.b.d();
            com.igexin.push.core.a.b.a(pushTaskBean.getId(), pushTaskBean.getMessageId(), pVar.f23455a);
            return PushMessageInterface.ActionPrepareState.stop;
        }
    }
}

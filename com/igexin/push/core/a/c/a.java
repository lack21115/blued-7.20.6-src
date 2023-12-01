package com.igexin.push.core.a.c;

import com.igexin.push.extension.mod.BaseActionBean;
import com.igexin.push.extension.mod.PushMessageInterface;
import com.igexin.push.extension.mod.PushTaskBean;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/a/c/a.class */
public final class a implements PushMessageInterface {
    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final boolean executeAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean) {
        String str;
        com.igexin.push.core.b.e eVar = (com.igexin.push.core.b.e) baseActionBean;
        String taskId = pushTaskBean.getTaskId();
        String messageId = pushTaskBean.getMessageId();
        if (com.igexin.push.f.c.d(eVar.f9829a)) {
            if (eVar.b == null || eVar.b.equals("")) {
                return true;
            }
            com.igexin.push.core.a.b.d();
            str = eVar.b;
        } else if (eVar.f9830c == null || eVar.f9830c.equals("")) {
            return true;
        } else {
            com.igexin.push.core.a.b.d();
            str = eVar.f9830c;
        }
        com.igexin.push.core.a.b.a(taskId, messageId, str);
        return true;
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final BaseActionBean parseAction(JSONObject jSONObject) {
        try {
            if (jSONObject.has("type") && jSONObject.has("actionid")) {
                com.igexin.push.core.b.e eVar = new com.igexin.push.core.b.e();
                eVar.setType(com.igexin.push.core.b.s);
                eVar.setActionId(jSONObject.getString("actionid"));
                if (jSONObject.has("appstartupid")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("appstartupid");
                    if (jSONObject2.has("android")) {
                        eVar.f9829a = jSONObject2.getString("android");
                        if (jSONObject.has("do_installed") || jSONObject.has("do_uninstalled")) {
                            if (jSONObject.has("do_installed")) {
                                eVar.b = jSONObject.getString("do_installed");
                            }
                            if (jSONObject.has("do_uninstalled")) {
                                eVar.f9830c = jSONObject.getString("do_uninstalled");
                            }
                            return eVar;
                        }
                        return null;
                    }
                    return null;
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final PushMessageInterface.ActionPrepareState prepareExecuteAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean) {
        return PushMessageInterface.ActionPrepareState.success;
    }
}

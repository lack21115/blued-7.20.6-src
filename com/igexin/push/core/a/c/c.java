package com.igexin.push.core.a.c;

import com.igexin.push.extension.mod.BaseActionBean;
import com.igexin.push.extension.mod.PushMessageInterface;
import com.igexin.push.extension.mod.PushTaskBean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/a/c/c.class */
public final class c implements PushMessageInterface {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23412a = "BasicAction";

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final boolean executeAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean) {
        com.igexin.push.core.e.f.a().a(false);
        if (baseActionBean.getDoActionId().equals("")) {
            return true;
        }
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseActionBean.getDoActionId());
        return true;
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final BaseActionBean parseAction(JSONObject jSONObject) {
        try {
            if (jSONObject.has(com.anythink.expressad.foundation.d.d.s) && jSONObject.has("actionid")) {
                BaseActionBean baseActionBean = new BaseActionBean();
                baseActionBean.setType(jSONObject.getString("type"));
                baseActionBean.setActionId(jSONObject.getString("actionid"));
                baseActionBean.setDoActionId(jSONObject.getString(com.anythink.expressad.foundation.d.d.s));
                return baseActionBean;
            }
            return null;
        } catch (JSONException e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final PushMessageInterface.ActionPrepareState prepareExecuteAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean) {
        return PushMessageInterface.ActionPrepareState.success;
    }
}

package com.igexin.push.core.a.c;

import com.igexin.push.core.e.f;
import com.igexin.push.extension.mod.BaseActionBean;
import com.igexin.push.extension.mod.PushMessageInterface;
import com.igexin.push.extension.mod.PushTaskBean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/a/c/d.class */
public final class d implements PushMessageInterface {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23413a = "BasicAction";

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final boolean executeAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean) {
        long currentTimeMillis = System.currentTimeMillis() + (((com.igexin.push.core.b.h) baseActionBean).f23442a * 1000);
        com.igexin.push.core.e.f.a().a(true);
        com.igexin.push.core.e.f a2 = com.igexin.push.core.e.f.a();
        if (com.igexin.push.core.e.X != currentTimeMillis) {
            com.igexin.push.core.e.X = currentTimeMillis;
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new f.AnonymousClass5(), false, true);
            return true;
        }
        return true;
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final BaseActionBean parseAction(JSONObject jSONObject) {
        try {
            if (jSONObject.has(com.anythink.expressad.foundation.d.d.s) && jSONObject.has("actionid") && jSONObject.has("duration")) {
                com.igexin.push.core.b.h hVar = new com.igexin.push.core.b.h();
                hVar.setType(jSONObject.getString("type"));
                hVar.setActionId(jSONObject.getString("actionid"));
                hVar.setDoActionId(jSONObject.getString(com.anythink.expressad.foundation.d.d.s));
                if (jSONObject.has("duration")) {
                    hVar.f23442a = Long.valueOf(jSONObject.getString("duration")).longValue();
                }
                return hVar;
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

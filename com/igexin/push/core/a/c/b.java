package com.igexin.push.core.a.c;

import com.cdo.oaps.ad.OapsKey;
import com.getui.gtc.api.GtcManager;
import com.igexin.push.extension.mod.BaseActionBean;
import com.igexin.push.extension.mod.PushMessageInterface;
import com.igexin.push.extension.mod.PushTaskBean;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/a/c/b.class */
public final class b implements PushMessageInterface {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23411a = "CleanExtAction";

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final boolean executeAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean) {
        if (pushTaskBean != null && baseActionBean != null) {
            com.igexin.push.core.b.g gVar = (com.igexin.push.core.b.g) baseActionBean;
            if (gVar.f23441a != null && gVar.f23441a.length > 0) {
                Arrays.toString(gVar.f23441a);
                GtcManager.getInstance().removeExt(com.igexin.push.core.b.i, gVar.f23441a);
            }
        }
        if ("".equals(baseActionBean.getDoActionId())) {
            return true;
        }
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseActionBean.getDoActionId());
        return true;
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final BaseActionBean parseAction(JSONObject jSONObject) {
        if (!jSONObject.has(OapsKey.KEY_IDS)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(jSONObject.getString(OapsKey.KEY_IDS));
            if (jSONArray.length() <= 0) {
                return null;
            }
            int[] iArr = new int[jSONArray.length()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    com.igexin.push.core.b.g gVar = new com.igexin.push.core.b.g();
                    gVar.setType(com.igexin.push.core.b.t);
                    gVar.f23441a = iArr;
                    gVar.setActionId(jSONObject.getString("actionid"));
                    gVar.setDoActionId(jSONObject.getString(com.anythink.expressad.foundation.d.d.s));
                    return gVar;
                }
                iArr[i2] = jSONArray.getInt(i2);
                i = i2 + 1;
            }
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

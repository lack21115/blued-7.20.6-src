package com.igexin.push.core.a.b;

import android.content.Intent;
import android.os.Bundle;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.message.FeedbackCmdMessage;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/a/b/j.class */
public final class j extends a {
    @Override // com.igexin.push.core.a.b.a
    public final boolean a(Object obj, JSONObject jSONObject) {
        try {
            if (jSONObject.has("action") && jSONObject.getString("action").equals("sendmessage_feedback")) {
                String string = jSONObject.getString("appid");
                String string2 = jSONObject.getString("taskid");
                String string3 = jSONObject.getString("actionid");
                String string4 = jSONObject.getString("result");
                long j = jSONObject.getLong("timestamp");
                com.igexin.c.a.c.a.a("SendMessageFeedbackAction|appid:" + string + "|taskid:" + string2 + "|actionid:" + string3, new Object[0]);
                com.igexin.push.core.l a2 = com.igexin.push.core.l.a();
                if (com.igexin.push.core.e.f23495a != null && com.igexin.push.core.e.f23495a.equals(string)) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("action", 10010);
                    bundle.putSerializable(PushConsts.KEY_CMD_MSG, new FeedbackCmdMessage(string2, string3, string4, j, PushConsts.THIRDPART_FEEDBACK));
                    a2.a(bundle);
                }
                Intent d = com.igexin.push.core.l.d();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("action", PushConsts.THIRDPART_FEEDBACK);
                bundle2.putString("appid", string);
                bundle2.putString("taskid", string2);
                bundle2.putString("actionid", string3);
                bundle2.putString("result", string4);
                bundle2.putLong("timestamp", j);
                d.putExtras(bundle2);
                com.igexin.push.core.e.l.sendBroadcast(d);
                return true;
            }
            return true;
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return true;
        }
    }
}

package com.igexin.push.core.a.b;

import com.igexin.assist.action.MessageManger;
import com.igexin.push.c.c.n;
import com.igexin.sdk.main.FeedbackImpl;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/a/b/e.class */
public final class e extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23404a = "PushMessageAction";

    @Override // com.igexin.push.core.a.b.a
    public final boolean a(Object obj, JSONObject jSONObject) {
        FeedbackImpl feedbackImpl;
        String str;
        try {
            n nVar = (n) obj;
            if (jSONObject.has("action") && jSONObject.getString("action").equals(com.igexin.push.core.b.A)) {
                byte[] bArr = null;
                if (nVar.g instanceof byte[]) {
                    try {
                        new String((byte[]) nVar.g, "UTF-8");
                    } catch (Exception e) {
                        com.igexin.c.a.c.a.a(f23404a + e.toString(), new Object[0]);
                    }
                    bArr = (byte[]) nVar.g;
                }
                String string = jSONObject.getString("taskid");
                com.igexin.c.a.c.a.a("getui receive message : %s", jSONObject);
                if (bArr == null || !com.igexin.assist.sdk.a.a().c()) {
                    com.igexin.push.core.n.a().a(jSONObject, bArr, true);
                    return true;
                }
                com.igexin.push.core.e.d a2 = com.igexin.push.core.e.d.a(com.igexin.push.core.e.l);
                if (a2.a(string)) {
                    feedbackImpl = FeedbackImpl.getInstance();
                    str = "1" + MessageManger.getInstance().getBrandCode();
                } else {
                    a2.b(string);
                    com.igexin.push.core.n.a().a(jSONObject, bArr, true);
                    feedbackImpl = FeedbackImpl.getInstance();
                    str = "10";
                }
                feedbackImpl.feedbackMultiBrandMessageAction(jSONObject, str);
                return true;
            }
            return true;
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            com.igexin.c.a.c.a.a("PushMessageAction|" + e2.toString(), new Object[0]);
            return true;
        }
    }
}

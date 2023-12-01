package com.igexin.push.core.a.c;

import android.app.NotificationManager;
import android.text.TextUtils;
import com.igexin.push.core.b.r;
import com.igexin.push.core.d;
import com.igexin.push.extension.mod.BaseActionBean;
import com.igexin.push.extension.mod.PushMessageInterface;
import com.igexin.push.extension.mod.PushTaskBean;
import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/a/c/l.class */
public class l implements PushMessageInterface {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23425a = com.igexin.push.core.b.e + l.class.getName();

    private static void a(String str) {
        try {
            com.igexin.c.a.c.a.a(f23425a + "|del condition taskid = " + str, new Object[0]);
            d.a.f23474a.i.a("message", new String[]{"taskid"}, new String[]{str});
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            String str2 = f23425a;
            com.igexin.c.a.c.a.b(str2, "del condition" + th.toString());
        }
    }

    private static void a(String str, BaseActionBean baseActionBean) {
        if (baseActionBean == null) {
            return;
        }
        com.igexin.push.core.b.k kVar = (com.igexin.push.core.b.k) baseActionBean;
        String str2 = kVar.q;
        HashSet<String> hashSet = com.igexin.push.core.e.aj.get(kVar.q);
        Integer num = com.igexin.push.core.e.ak.get(kVar.q);
        if (hashSet != null && !hashSet.isEmpty()) {
            hashSet.remove(str);
        }
        if (TextUtils.isEmpty(str2) || num == null || hashSet == null || !hashSet.isEmpty()) {
            return;
        }
        ((NotificationManager) com.igexin.push.core.e.l.getSystemService("notification")).cancel(num.intValue());
        com.igexin.push.core.e.aj.remove(str2);
        com.igexin.push.core.e.ak.remove(str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0262, code lost:
        if (r14 == null) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0265, code lost:
        r14.close();
        r12 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0283, code lost:
        if (r14 == null) goto L4;
     */
    @Override // com.igexin.push.extension.mod.PushMessageInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean executeAction(com.igexin.push.extension.mod.PushTaskBean r9, com.igexin.push.extension.mod.BaseActionBean r10) {
        /*
            Method dump skipped, instructions count: 1060
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.c.l.executeAction(com.igexin.push.extension.mod.PushTaskBean, com.igexin.push.extension.mod.BaseActionBean):boolean");
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public BaseActionBean parseAction(JSONObject jSONObject) {
        try {
            if (jSONObject.has(com.anythink.expressad.foundation.d.d.s) && jSONObject.has("actionid") && jSONObject.has("taskid")) {
                r rVar = new r();
                rVar.setType(com.igexin.push.core.b.n);
                rVar.setActionId(jSONObject.getString("actionid"));
                rVar.setDoActionId(jSONObject.getString(com.anythink.expressad.foundation.d.d.s));
                rVar.f23458a = jSONObject.getString("taskid");
                rVar.b = jSONObject.optBoolean("force");
                return rVar;
            }
            return null;
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public PushMessageInterface.ActionPrepareState prepareExecuteAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean) {
        return PushMessageInterface.ActionPrepareState.success;
    }
}

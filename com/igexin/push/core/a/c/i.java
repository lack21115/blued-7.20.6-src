package com.igexin.push.core.a.c;

import android.content.Context;
import android.content.Intent;
import com.igexin.push.core.b.n;
import com.igexin.push.extension.mod.BaseActionBean;
import com.igexin.push.extension.mod.PushMessageInterface;
import com.igexin.push.extension.mod.PushTaskBean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/a/c/i.class */
public class i implements PushMessageInterface {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9814a = i.class.getName();

    private static void a(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getApplicationContext().getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                intent.setFlags(270532608);
                intent.setComponent(launchIntentForPackage.getComponent());
                context.startActivity(intent);
            }
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0078 A[Catch: Exception -> 0x0149, TRY_ENTER, TryCatch #0 {Exception -> 0x0149, blocks: (B:16:0x0078, B:18:0x0098, B:20:0x00a7, B:22:0x00ad, B:24:0x00c4, B:26:0x00cc, B:29:0x00ec, B:31:0x00f5, B:34:0x0109, B:36:0x0111, B:37:0x0129, B:39:0x0131), top: B:45:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cc A[Catch: Exception -> 0x0149, TRY_ENTER, TryCatch #0 {Exception -> 0x0149, blocks: (B:16:0x0078, B:18:0x0098, B:20:0x00a7, B:22:0x00ad, B:24:0x00c4, B:26:0x00cc, B:29:0x00ec, B:31:0x00f5, B:34:0x0109, B:36:0x0111, B:37:0x0129, B:39:0x0131), top: B:45:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0109 A[Catch: Exception -> 0x0149, TRY_ENTER, TryCatch #0 {Exception -> 0x0149, blocks: (B:16:0x0078, B:18:0x0098, B:20:0x00a7, B:22:0x00ad, B:24:0x00c4, B:26:0x00cc, B:29:0x00ec, B:31:0x00f5, B:34:0x0109, B:36:0x0111, B:37:0x0129, B:39:0x0131), top: B:45:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0129 A[Catch: Exception -> 0x0149, TRY_ENTER, TryCatch #0 {Exception -> 0x0149, blocks: (B:16:0x0078, B:18:0x0098, B:20:0x00a7, B:22:0x00ad, B:24:0x00c4, B:26:0x00cc, B:29:0x00ec, B:31:0x00f5, B:34:0x0109, B:36:0x0111, B:37:0x0129, B:39:0x0131), top: B:45:0x0075 }] */
    @Override // com.igexin.push.extension.mod.PushMessageInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean executeAction(com.igexin.push.extension.mod.PushTaskBean r7, com.igexin.push.extension.mod.BaseActionBean r8) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.c.i.executeAction(com.igexin.push.extension.mod.PushTaskBean, com.igexin.push.extension.mod.BaseActionBean):boolean");
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public BaseActionBean parseAction(JSONObject jSONObject) {
        try {
            n nVar = new n();
            nVar.setType(com.igexin.push.core.b.p);
            nVar.setActionId(jSONObject.getString("actionid"));
            nVar.setDoActionId(jSONObject.getString(com.anythink.expressad.foundation.d.d.s));
            if (jSONObject.has("appstartupid")) {
                nVar.f9844a = jSONObject.getJSONObject("appstartupid").getString("android");
            }
            if (jSONObject.has("is_autostart")) {
                nVar.d = jSONObject.getString("is_autostart");
            }
            if (jSONObject.has("appid")) {
                nVar.b = jSONObject.getString("appid");
            }
            if (jSONObject.has("noinstall_action")) {
                nVar.f9845c = jSONObject.getString("noinstall_action");
            }
            return nVar;
        } catch (JSONException e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public PushMessageInterface.ActionPrepareState prepareExecuteAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean) {
        return PushMessageInterface.ActionPrepareState.success;
    }
}

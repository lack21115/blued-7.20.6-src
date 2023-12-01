package com.igexin.push.core.a.c;

import android.content.Intent;
import android.net.Uri;
import com.igexin.push.core.b.q;
import com.igexin.push.extension.mod.BaseActionBean;
import com.igexin.push.extension.mod.PushMessageInterface;
import com.igexin.push.extension.mod.PushTaskBean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/a/c/k.class */
public final class k implements PushMessageInterface {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23424a = com.igexin.push.config.c.f23373a;

    private static void a(q qVar, String str) {
        int indexOf;
        String str2;
        String str3;
        String str4 = qVar.f23456a;
        if (str4 == null || (indexOf = str4.indexOf(str)) == -1) {
            return;
        }
        String str5 = null;
        int indexOf2 = str4.indexOf("&");
        String str6 = "";
        if (indexOf2 == -1) {
            String substring = str4.substring(0, indexOf - 1);
            String substring2 = str4.substring(indexOf);
            str2 = substring;
            if (substring2.contains("=")) {
                str3 = substring2;
                str2 = substring;
                str5 = str3.substring(str3.indexOf("=") + 1);
            }
            qVar.f23456a = str2;
            qVar.d = str5;
        }
        int i = indexOf - 1;
        if (str4.charAt(i) == '?') {
            String str7 = str4.substring(0, indexOf) + str4.substring(indexOf2 + 1);
            String substring3 = str4.substring(indexOf, indexOf2);
            str2 = str7;
            if (substring3.contains("=")) {
                str2 = str7;
                str3 = substring3;
                str5 = str3.substring(str3.indexOf("=") + 1);
            }
        } else {
            str2 = str6;
            if (str4.charAt(i) == '&') {
                String substring4 = str4.substring(0, i);
                String substring5 = str4.substring(indexOf);
                int indexOf3 = substring5.indexOf("&");
                String str8 = substring5;
                if (indexOf3 != -1) {
                    str6 = substring5.substring(indexOf3);
                    str8 = substring5.substring(0, indexOf3);
                }
                str5 = str8.substring(str8.indexOf("=") + 1);
                str2 = substring4 + str6;
            }
        }
        qVar.f23456a = str2;
        qVar.d = str5;
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final boolean executeAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean) {
        int indexOf;
        String str;
        String substring;
        String str2;
        String str3;
        q qVar = (q) baseActionBean;
        String str4 = qVar.f23456a;
        if (str4 != null && (indexOf = str4.indexOf(com.igexin.push.core.b.w)) != -1) {
            String str5 = null;
            int indexOf2 = str4.indexOf("&");
            if (indexOf2 == -1) {
                String substring2 = str4.substring(0, indexOf - 1);
                String substring3 = str4.substring(indexOf);
                str = substring2;
                if (substring3.contains("=")) {
                    str = substring2;
                    str3 = substring3;
                    str5 = str3.substring(str3.indexOf("=") + 1);
                }
                qVar.f23456a = str;
                qVar.d = str5;
            } else {
                int i = indexOf - 1;
                if (str4.charAt(i) == '?') {
                    String str6 = str4.substring(0, indexOf) + str4.substring(indexOf2 + 1);
                    String substring4 = str4.substring(indexOf, indexOf2);
                    str = str6;
                    if (substring4.contains("=")) {
                        str3 = substring4;
                        str = str6;
                        str5 = str3.substring(str3.indexOf("=") + 1);
                    }
                } else if (str4.charAt(i) == '&') {
                    String substring5 = str4.substring(0, i);
                    String substring6 = str4.substring(indexOf);
                    int indexOf3 = substring6.indexOf("&");
                    if (indexOf3 != -1) {
                        str2 = substring6.substring(indexOf3);
                        String substring7 = substring6.substring(0, indexOf3);
                        substring = substring7.substring(substring7.indexOf("=") + 1);
                    } else {
                        substring = substring6.substring(substring6.indexOf("=") + 1);
                        str2 = "";
                    }
                    str5 = substring;
                    str = substring5 + str2;
                } else {
                    str = "";
                }
                qVar.f23456a = str;
                qVar.d = str5;
            }
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setFlags(268435456);
        intent.setPackage(qVar.d);
        intent.setData(Uri.parse(qVar.a()));
        try {
            com.igexin.push.core.e.l.startActivity(intent);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
        qVar.a();
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
            if (jSONObject.has("url") && jSONObject.has(com.anythink.expressad.foundation.d.d.s) && jSONObject.has("actionid")) {
                String string = jSONObject.getString("url");
                if (string.equals("")) {
                    return null;
                }
                q qVar = new q();
                qVar.setType(com.igexin.push.core.b.r);
                qVar.setActionId(jSONObject.getString("actionid"));
                qVar.setDoActionId(jSONObject.getString(com.anythink.expressad.foundation.d.d.s));
                qVar.f23456a = string;
                if (jSONObject.has("is_withcid") && "true".equals(jSONObject.getString("is_withcid"))) {
                    qVar.b = true;
                }
                if (jSONObject.has("is_withnettype") && "true".equals(jSONObject.getString("is_withnettype"))) {
                    qVar.f23457c = true;
                }
                return qVar;
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

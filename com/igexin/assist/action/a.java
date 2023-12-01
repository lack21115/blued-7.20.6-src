package com.igexin.assist.action;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.igexin.assist.MessageBean;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.push.core.b;
import com.igexin.push.f.d;
import com.igexin.push.f.n;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/assist/action/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    byte[] f9573a;
    String b;

    /* renamed from: c  reason: collision with root package name */
    String f9574c;
    String d;
    String e;
    String f;
    private String g;

    private byte[] a() {
        return this.f9573a;
    }

    private String b() {
        return this.b;
    }

    private String c() {
        return this.f9574c;
    }

    private String d() {
        return this.d;
    }

    private String e() {
        return this.e;
    }

    private String f() {
        return this.g;
    }

    private String g() {
        return this.f;
    }

    public final void a(MessageBean messageBean) {
        try {
            Context context = messageBean.getContext();
            String stringMessage = messageBean.getStringMessage();
            if (TextUtils.isEmpty(stringMessage) || context == null) {
                return;
            }
            ApplicationInfo b = n.b(context);
            String a2 = d.a(b);
            this.d = a2;
            if (TextUtils.isEmpty(a2)) {
                this.d = b.metaData.getString(b.b);
            }
            if (TextUtils.isEmpty(this.d)) {
                this.d = b.metaData.getString("GETUI_APPID");
            }
            if (TextUtils.isEmpty(this.d)) {
                return;
            }
            this.g = context.getPackageName();
            String messageSource = TextUtils.isEmpty(messageBean.getMessageSource()) ? "" : messageBean.getMessageSource();
            this.f9574c = messageSource + UUID.randomUUID().toString();
            String a3 = com.igexin.assist.util.a.a(stringMessage, this.d);
            if (TextUtils.isEmpty(a3)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(a3);
            if (jSONObject.has("TI")) {
                this.b = jSONObject.getString("TI");
            }
            if (jSONObject.has(AssistPushConsts.MSG_KEY_ACTION)) {
                this.e = jSONObject.getString(AssistPushConsts.MSG_KEY_ACTION);
            }
            if (jSONObject.has(AssistPushConsts.MSG_KEY_CONTENT) && !TextUtils.isEmpty(jSONObject.getString(AssistPushConsts.MSG_KEY_CONTENT))) {
                this.f9573a = jSONObject.getString(AssistPushConsts.MSG_KEY_CONTENT).getBytes();
            }
            if (jSONObject.has(AssistPushConsts.MSG_KEY_ACTION_CHAINS)) {
                String string = jSONObject.getString(AssistPushConsts.MSG_KEY_ACTION_CHAINS);
                this.f = string;
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(this.f);
                jSONObject2.put("extra_actionid", b.h);
                this.f = jSONObject2.toString();
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public final boolean a(boolean z) {
        return (this.f9573a != null || (this.f != null && z)) && (d.a(this.b, this.g, this.d, this.e, this.f9574c) ^ true);
    }
}

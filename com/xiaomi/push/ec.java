package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ec.class */
public class ec implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f41370a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ eb f385a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f386a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f41371c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ec(eb ebVar, String str, Context context, String str2, String str3) {
        this.f385a = ebVar;
        this.f386a = str;
        this.f41370a = context;
        this.b = str2;
        this.f41371c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        String str;
        String str2;
        if (TextUtils.isEmpty(this.f386a)) {
            context = this.f41370a;
            str = com.igexin.push.core.b.l;
            str2 = "A receive a incorrect message with empty info";
        } else {
            try {
                dx.a(this.f41370a, this.f386a, 1001, "get message");
                JSONObject jSONObject = new JSONObject(this.f386a);
                String optString = jSONObject.optString("action");
                String optString2 = jSONObject.optString("awakened_app_packagename");
                String optString3 = jSONObject.optString("awake_app_packagename");
                String optString4 = jSONObject.optString("awake_app");
                String optString5 = jSONObject.optString("awake_type");
                int optInt = jSONObject.optInt("awake_foreground", 0);
                if (this.b.equals(optString3) && this.f41371c.equals(optString4)) {
                    if (TextUtils.isEmpty(optString5) || TextUtils.isEmpty(optString3) || TextUtils.isEmpty(optString4) || TextUtils.isEmpty(optString2)) {
                        dx.a(this.f41370a, this.f386a, 1008, "A receive a incorrect message with empty type");
                        return;
                    }
                    this.f385a.b(optString3);
                    this.f385a.a(optString4);
                    ea eaVar = new ea();
                    eaVar.b(optString);
                    eaVar.a(optString2);
                    eaVar.a(optInt);
                    eaVar.d(this.f386a);
                    if ("service".equals(optString5)) {
                        if (!TextUtils.isEmpty(optString)) {
                            this.f385a.a(ed.SERVICE_ACTION, this.f41370a, eaVar);
                            return;
                        }
                        eaVar.c("com.xiaomi.mipush.sdk.PushMessageHandler");
                        this.f385a.a(ed.SERVICE_COMPONENT, this.f41370a, eaVar);
                        return;
                    } else if (ed.ACTIVITY.f388a.equals(optString5)) {
                        this.f385a.a(ed.ACTIVITY, this.f41370a, eaVar);
                        return;
                    } else if (ed.PROVIDER.f388a.equals(optString5)) {
                        this.f385a.a(ed.PROVIDER, this.f41370a, eaVar);
                        return;
                    } else {
                        dx.a(this.f41370a, this.f386a, 1008, "A receive a incorrect message with unknown type ".concat(String.valueOf(optString5)));
                        return;
                    }
                }
                dx.a(this.f41370a, this.f386a, 1008, "A receive a incorrect message with incorrect package info".concat(String.valueOf(optString3)));
                return;
            } catch (JSONException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                context = this.f41370a;
                str = this.f386a;
                str2 = "A meet a exception when receive the message";
            }
        }
        dx.a(context, str, 1008, str2);
    }
}

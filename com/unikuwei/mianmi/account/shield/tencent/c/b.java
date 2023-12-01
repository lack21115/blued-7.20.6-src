package com.unikuwei.mianmi.account.shield.tencent.c;

import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.opos.process.bridge.provider.ProcessBridgeProvider;
import com.unikuwei.mianmi.account.shield.tencent.c.a;
import com.unikuwei.mianmi.account.shield.tencent.e.j;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/unikuwei/mianmi/account/shield/tencent/c/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private a.InterfaceC1091a f40994a;

    public b(a.InterfaceC1091a interfaceC1091a) {
        this.f40994a = null;
        this.f40994a = interfaceC1091a;
    }

    public void a(int i, String str) {
        a(i, str, "");
    }

    public void a(int i, String str, String str2) {
        try {
            if (this.f40994a == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ProcessBridgeProvider.KEY_RESULT_CODE, i);
            jSONObject.put(ProcessBridgeProvider.KEY_RESULT_MSG, str);
            jSONObject.put(ProcessBridgeProvider.KEY_RESULT_DATA, "");
            jSONObject.put("traceId", str2);
            jSONObject.put("operatorType", "CU");
            this.f40994a.a(jSONObject.toString());
            this.f40994a = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(String str, String str2) {
        try {
            if (this.f40994a == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ProcessBridgeProvider.KEY_RESULT_CODE, 0);
            jSONObject.put(ProcessBridgeProvider.KEY_RESULT_MSG, str);
            if (TextUtils.isEmpty(str2)) {
                jSONObject.put(ProcessBridgeProvider.KEY_RESULT_DATA, "");
            } else {
                JSONObject jSONObject2 = new JSONObject(str2);
                jSONObject2.put(RemoteMessageConst.MSGID, j.a("" + System.currentTimeMillis()));
                jSONObject2.put("operatorType", (Object) null);
                jSONObject.put(ProcessBridgeProvider.KEY_RESULT_DATA, jSONObject2);
            }
            jSONObject.put("operatorType", "CU");
            this.f40994a.a(jSONObject.toString());
            this.f40994a = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

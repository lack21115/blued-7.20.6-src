package com.igexin.push.core.h;

import com.igexin.c.a.b.g;
import com.igexin.push.config.SDKUrlConfig;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/h/e.class */
public class e extends com.igexin.push.e.a.d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9949a = "UploadBiLogPlugin";
    public boolean b;

    /* renamed from: c  reason: collision with root package name */
    private int f9950c;

    public e(String str, byte[] bArr, int i) {
        super(str);
        this.f9950c = i;
        a(bArr, i);
    }

    private e(byte[] bArr, int i) {
        super(SDKUrlConfig.getBiUploadServiceUrl());
        a(bArr, i);
    }

    private void a(byte[] bArr, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", "upload_BI");
            jSONObject.put("BIType", String.valueOf(i));
            jSONObject.put("cid", com.igexin.push.core.e.A);
            jSONObject.put("BIData", new String(g.c(bArr), "UTF-8"));
            this.g = jSONObject.toString().getBytes();
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    @Override // com.igexin.push.e.a.d
    public void a(byte[] bArr) throws Exception {
        JSONObject jSONObject = new JSONObject(new String(bArr));
        if (jSONObject.has("result") && com.igexin.push.core.b.x.equals(jSONObject.getString("result"))) {
            this.b = true;
            if (this.f9950c == 10) {
                com.igexin.c.a.c.a.b("UploadBITask", "upload type 10 success ####");
            }
        }
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return 0;
    }
}

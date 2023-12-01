package com.amap.api.col.p0003sl;

import android.util.Base64;
import java.nio.charset.StandardCharsets;

/* renamed from: com.amap.api.col.3sl.ln  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ln.class */
public final class ln {
    public static boolean a(byte[] bArr) {
        if (bArr != null) {
            try {
                mu muVar = new mu();
                muVar.b.put("Content-Type", "application/octet-stream");
                muVar.b.put("aps_c_src", Base64.encodeToString(mu.a().getBytes(), 2));
                muVar.b.put("aps_c_key", Base64.encodeToString(mu.b().getBytes(), 2));
                muVar.d = bArr;
                if (le.f5360a) {
                    muVar.f5391a = "http://cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&";
                } else {
                    muVar.f5391a = (le.b ? "https://" : "http://") + "cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&";
                }
                mv a2 = mi.b().a(muVar);
                byte[] bArr2 = null;
                if (a2 != null) {
                    bArr2 = null;
                    if (a2.f5393a == 200) {
                        bArr2 = a2.f5394c;
                    }
                }
                if (bArr2 != null) {
                    return "true".equals(new String(bArr2, StandardCharsets.UTF_8));
                }
                return false;
            } catch (Exception e) {
                mt.a(e);
                return false;
            }
        }
        return false;
    }
}

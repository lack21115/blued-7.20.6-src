package com.efs.sdk.base.core.f;

import android.text.TextUtils;
import com.efs.sdk.base.core.f.f;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/f/e.class */
public final class e implements com.efs.sdk.base.core.c.c {
    private static void a(HttpResponse httpResponse) {
        if (httpResponse == null || TextUtils.isEmpty(httpResponse.data)) {
            return;
        }
        String[] split = httpResponse.data.split("`");
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            String[] split2 = split[i2].split("=");
            if (split2.length >= 2) {
                if (split2[0].equalsIgnoreCase("retcode")) {
                    httpResponse.setBizCode(split2[1]);
                } else {
                    ((Map) httpResponse.extra).put(split2[0], split2[1]);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.efs.sdk.base.core.c.c
    public final HttpResponse a(com.efs.sdk.base.core.d.b bVar, boolean z) {
        f fVar;
        try {
            fVar = f.a.f8175a;
            c cVar = fVar.f8173a;
            String valueOf = String.valueOf(System.currentTimeMillis());
            StringBuilder sb = new StringBuilder();
            sb.append(cVar.b);
            sb.append(cVar.f8171c);
            sb.append(valueOf);
            sb.append("AppChk#2014");
            String a2 = com.efs.sdk.base.core.util.b.b.a(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            String str = cVar.f8170a;
            if (str.startsWith("http")) {
                sb2.append(str);
                sb2.append("?chk=");
            } else {
                sb2.append(str);
                sb2.append("?chk=");
            }
            sb2.append(a2.substring(a2.length() - 8));
            sb2.append("&vno=");
            sb2.append(valueOf);
            sb2.append("&uuid=");
            sb2.append(cVar.f8171c);
            sb2.append("&app=");
            sb2.append(cVar.b);
            sb2.append("&zip=gzip");
            String sb3 = sb2.toString();
            int i = 0;
            byte[] bArr = new byte[0];
            if (bVar.f8158a.f8157c == 0) {
                bArr = bVar.f8159c;
                i = bArr.length;
            } else if (1 == bVar.f8158a.f8157c) {
                bArr = com.efs.sdk.base.core.util.b.a(bVar.d.getPath());
                i = bArr.length;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Content-Length", String.valueOf(i));
            com.efs.sdk.base.core.util.a.d a3 = new com.efs.sdk.base.core.util.a.d(sb3).a(hashMap);
            a3.f8185a.f8183c = bArr;
            HttpResponse b = a3.a().b();
            a(b);
            if (!b.succ) {
                StringBuilder sb4 = new StringBuilder("wa upload fail, resp is ");
                sb4.append(b.toString());
                Log.i("efs.base", sb4.toString());
                return b;
            }
            StringBuilder sb5 = new StringBuilder("wa upload succ, ");
            sb5.append(b.toString());
            Log.i("efs.base", sb5.toString());
            com.efs.sdk.base.core.util.b.b(bVar.d);
            return b;
        } catch (Throwable th) {
            HttpResponse httpResponse = null;
            if (0 == 0) {
                httpResponse = new HttpResponse();
            }
            Log.e("efs.wa.send", "get file size error", th);
            return httpResponse;
        }
    }
}

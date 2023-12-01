package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.hs;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.ig  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ig.class */
public final class ig {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5151a = ib.c("SRFZHZUVZT3BOa0ZiemZRQQ");
    private static final String b = ib.c("FbGJzX3Nkaw");

    /* renamed from: c  reason: collision with root package name */
    private static final String f5152c = ib.c("SWjJuYVh2eEMwSzVmNklFSmh0UXpVb2xtOVM4eU9Ua3E");
    private static final String d = ib.c("FQU5EU0RLMTA");
    private static final String e = ib.c("FMTAw");
    private static boolean f = false;
    private String g = "";

    public static hs.a a() {
        return new hs.a() { // from class: com.amap.api.col.3sl.ig.1

            /* renamed from: a  reason: collision with root package name */
            private ig f5153a = new ig();

            @Override // com.amap.api.col.p0003sl.hs.a
            public final kb a(byte[] bArr, Map<String, String> map) {
                return new jt(bArr, map);
            }

            @Override // com.amap.api.col.p0003sl.hs.a
            public final String a() {
                return ig.c();
            }

            @Override // com.amap.api.col.p0003sl.hs.a
            public final String a(Context context, String str) {
                return ig.a(context, str);
            }

            @Override // com.amap.api.col.p0003sl.hs.a
            public final String a(String str, String str2, String str3, String str4) {
                return this.f5153a.a(str, str2, str3, str4);
            }

            @Override // com.amap.api.col.p0003sl.hs.a
            public final Map<String, String> b() {
                return this.f5153a.b();
            }
        };
    }

    public static String a(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(ib.c("UY29kZQ")) == 1) {
                String optString = new JSONObject(jSONObject.optString(ib.c("FZGF0YQ"))).optString(ib.c("FYWRpdQ"));
                if (TextUtils.isEmpty(optString)) {
                    return "";
                }
                ih.a(optString);
                ic.a(context).a(optString);
                return optString;
            }
            return "";
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String c() {
        return ih.a();
    }

    private String d() {
        if (!TextUtils.isEmpty(this.g)) {
            return this.g;
        }
        String a2 = ht.a("TUpJaVFGNk5LXHtSX1ZwQlRiV1VVZmtYWU1haV1hYWHCiXJtZcKLdmp8wpFewo1/wphwwoFzZmR8aWp6X2k6XsKDwoF+WGbChGdAScKLwoVXfmNxYEvCjcKLSG7CjGNvwoZtVFZ7WMKXYMKfwo5dZcKHfzZXUG85X0hNOVJrb2U8ZlJGW8KCe8KOV8KQWllrcGrCjcKIT25lUHPCicKGVsKKeG5fwp56XsKbc8KJbUVYR0pqU09gfE5/WT5YeHNAwoDCh1Z4V8KQT3JQYmxQbcKYwpFxdG/Ci3rCmMKQwop+YVbCmWFxwpxBdW07Zjp/ODlAbcKEY1pQwoJowohbV1VmV1laWmtcYGbClXfCk2NvesKdwohdWFnCol/CjWTCmMKicG1ENnAvPFtpcXtfclhfXsKAwolgRWNbS29OwpFafV3CkMKLTcKCwolrU3DCmGnCmX9wdsKPcXDCg3LCnFpGcDVTeTxNWW07bXJePVRfQn3ChGNraFhbwpNcwpXChMKNaFVjeVF8wojChm9YbmvChGDCmHvChGVQWjo0Z3o9djleOztWcVxSfWE9woLChkZdcGTCgVzCjMKUVE12wpV5bcKVwprCnntZworCgsKfwpHCksKnwpHClURURW9YaDtwXU1bck5YX3hSVFZUYlxKWFlua1xeYm9jU8KDa3ZrwpZ5am9Za3jCknR3fA");
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= a2.length()) {
                break;
            }
            stringBuffer.append((char) (a2.charAt(i2) - (i2 % 48)));
            i = i2 + 1;
        }
        String stringBuffer2 = stringBuffer.toString();
        StringBuffer stringBuffer3 = new StringBuffer();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= stringBuffer2.length() / 2) {
                String stringBuffer4 = stringBuffer3.toString();
                this.g = stringBuffer4;
                return stringBuffer4;
            }
            stringBuffer3.append((char) ((stringBuffer2.charAt(i4) + stringBuffer2.charAt((stringBuffer2.length() - 1) - i4)) / 2));
            i3 = i4 + 1;
        }
    }

    public final String a(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ib.c("LdGlk"), str);
            jSONObject.put(ib.c("FZGl1"), str2);
            jSONObject.put(ib.c("AZGl1Mg"), str3);
            jSONObject.put(ib.c("EZGl1Mw"), str4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        if (TextUtils.isEmpty(jSONObject2)) {
            return null;
        }
        String a2 = ij.a();
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        String a3 = ie.a(jq.a((jSONObject2 + "��").getBytes(), a2.getBytes()));
        if (TextUtils.isEmpty(a3)) {
            return null;
        }
        try {
            String a4 = ie.a(ii.a(a2.getBytes("utf-8"), ii.a(d())));
            return ib.c("Fa2V5PQ") + URLEncoder.encode(a4) + ib.c("SJmRhdGE9") + URLEncoder.encode(a3);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public final Map<String, String> b() {
        synchronized (this) {
            if (f) {
                return null;
            }
            f = true;
            HashMap hashMap = new HashMap();
            hashMap.put(ib.c("FZW50"), ib.c("FMg"));
            StringBuilder sb = new StringBuilder();
            sb.append(ib.c("SY2hhbm5lbD0"));
            sb.append(b);
            sb.append(ib.c("SJmRpdj0"));
            sb.append(d);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(b);
            stringBuffer.append(d);
            stringBuffer.append(ib.c("FQA"));
            stringBuffer.append(f5152c);
            String a2 = ij.a(stringBuffer.toString());
            sb.append(ib.c("FJnNpZ249"));
            sb.append(a2.toUpperCase(Locale.US));
            sb.append(ib.c("SJm91dHB1dD1qc29u") + "��");
            hashMap.put(ib.c("FaW4"), ie.a(jq.a(sb.toString().getBytes(), f5151a.getBytes())));
            hashMap.put(ib.c("Sa2V5dA"), e);
            return hashMap;
        }
    }
}

package com.tencent.tendinsv.d;

import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.tendinsv.utils.t;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/d/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private String f25341a;
    private Map<String, String> b;

    /* renamed from: c  reason: collision with root package name */
    private Context f25342c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str, Context context) {
        this.f25341a = null;
        this.b = null;
        this.f25341a = str;
        this.f25342c = context;
        this.b = new HashMap();
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x024c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x020a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0239 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x021f A[Catch: Exception -> 0x022a, TRY_ENTER, TryCatch #4 {Exception -> 0x022a, blocks: (B:45:0x0199, B:73:0x021f), top: B:101:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0260 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.tencent.tendinsv.d.f r5, java.util.Map<java.lang.String, java.lang.String> r6, com.tencent.tendinsv.d.c r7, java.lang.Boolean r8, java.lang.String r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 626
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tendinsv.d.d.a(com.tencent.tendinsv.d.f, java.util.Map, com.tencent.tendinsv.d.c, java.lang.Boolean, java.lang.String, int, int):void");
    }

    private void a(HttpURLConnection httpURLConnection) {
        for (Map.Entry<String, String> entry : this.b.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private void a(HttpsURLConnection httpsURLConnection) {
        for (Map.Entry<String, String> entry : this.b.entrySet()) {
            httpsURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private byte[] a(Map<String, String> map) {
        if (map == null) {
            return new byte[0];
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(URLEncoder.encode(entry.getKey(), "utf-8"));
            sb.append("=");
            sb.append(URLEncoder.encode(entry.getValue(), "utf-8"));
            sb.append(ContainerUtils.FIELD_DELIMITER);
        }
        return (sb.length() > 0 ? sb.substring(0, sb.length() - 1) : sb.toString()).getBytes("UTF_8");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x024c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x020a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0239 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x021f A[Catch: Exception -> 0x022a, TRY_ENTER, TryCatch #4 {Exception -> 0x022a, blocks: (B:45:0x0199, B:73:0x021f), top: B:101:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0260 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(com.tencent.tendinsv.d.f r5, java.util.Map<java.lang.String, java.lang.String> r6, com.tencent.tendinsv.d.c r7, java.lang.Boolean r8, java.lang.String r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 626
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tendinsv.d.d.b(com.tencent.tendinsv.d.f, java.util.Map, com.tencent.tendinsv.d.c, java.lang.Boolean, java.lang.String, int, int):void");
    }

    private byte[] b(Map<String, String> map) {
        return map == null ? new byte[0] : com.tencent.tendinsv.utils.a.b(new JSONObject(map).toString());
    }

    public void a(c cVar) {
        a(f.GET, null, cVar, false, "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(f fVar, Map<String, String> map, c cVar, Boolean bool, String str) {
        int round;
        int i;
        int b = t.b(this.f25342c, t.G, 4);
        if (bool.booleanValue()) {
            round = 5000;
            i = 25000;
        } else {
            round = Math.round(((b * 1000) - com.tencent.tendinsv.b.ak) / 2);
            i = round;
        }
        if (this.f25341a.startsWith("https")) {
            b(fVar, map, cVar, bool, str, round, i);
        } else {
            a(fVar, map, cVar, bool, str, round, i);
        }
    }

    public void a(Map<String, String> map, c cVar, Boolean bool, String str) {
        a(f.POST, map, cVar, bool, str);
    }
}

package com.huawei.hms.framework.network.grs.g;

import android.accounts.AccountManager;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.opos.process.bridge.provider.ProcessBridgeProvider;
import com.tencent.mapsdk.internal.k2;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/network/grs/g/d.class */
public class d {
    private static final String o = "d";

    /* renamed from: a  reason: collision with root package name */
    private Map<String, List<String>> f9097a;
    private byte[] b;

    /* renamed from: c  reason: collision with root package name */
    private int f9098c;
    private long d;
    private long e;
    private long f;
    private String g;
    private int h;
    private int i;
    private String j;
    private long k;
    private String l;
    private Exception m;
    private String n;

    public d(int i, Map<String, List<String>> map, byte[] bArr, long j) {
        this.f9098c = 0;
        this.h = 2;
        this.i = 9001;
        this.j = "";
        this.k = 0L;
        this.l = "";
        this.f9098c = i;
        this.f9097a = map;
        this.b = ByteBuffer.wrap(bArr).array();
        this.d = j;
        s();
    }

    public d(Exception exc, long j) {
        this.f9098c = 0;
        this.h = 2;
        this.i = 9001;
        this.j = "";
        this.k = 0L;
        this.l = "";
        this.m = exc;
        this.d = j;
    }

    private void a(Map<String, String> map) {
        String str;
        Object obj;
        if (map.containsKey("ETag")) {
            String str2 = map.get("ETag");
            if (!TextUtils.isEmpty(str2)) {
                Logger.i(o, "success get Etag from server");
                a(str2);
                return;
            }
            str = o;
            obj = "The Response Heads Etag is Empty";
        } else {
            str = o;
            obj = "Response Heads has not Etag";
        }
        Logger.i(str, obj);
    }

    private void b(int i) {
        this.i = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0110, code lost:
        if (r10 > 2592000) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(java.util.Map<java.lang.String, java.lang.String> r9) {
        /*
            Method dump skipped, instructions count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.g.d.b(java.util.Map):void");
    }

    private void c(int i) {
        this.h = i;
    }

    private void c(long j) {
        this.k = j;
    }

    private void c(String str) {
        this.j = str;
    }

    private void c(Map<String, String> map) {
        long j;
        if (map.containsKey(HttpHeaders.RETRY_AFTER)) {
            String str = map.get(HttpHeaders.RETRY_AFTER);
            if (!TextUtils.isEmpty(str)) {
                try {
                    j = Long.parseLong(str);
                } catch (NumberFormatException e) {
                    Logger.w(o, "getRetryAfter addHeadersToResult NumberFormatException", e);
                }
                long j2 = j * 1000;
                Logger.v(o, "convert retry-afterTime{%s}", Long.valueOf(j2));
                c(j2);
            }
        }
        j = 0;
        long j22 = j * 1000;
        Logger.v(o, "convert retry-afterTime{%s}", Long.valueOf(j22));
        c(j22);
    }

    private void d(String str) {
    }

    private void e(String str) {
    }

    private void f(String str) {
        this.g = str;
    }

    private void p() {
        if (m()) {
            Logger.i(o, "GRSSDK get httpcode{304} not any changed.");
            c(1);
        } else if (!o()) {
            Logger.i(o, "GRSSDK parse server body all failed.");
            c(2);
        } else {
            try {
                JSONObject jSONObject = new JSONObject(StringUtils.byte2Str(this.b));
                int i = -1;
                if (jSONObject.has("isSuccess")) {
                    if (jSONObject.getInt("isSuccess") == 1) {
                        i = 1;
                    }
                    i = 2;
                } else if (jSONObject.has(ProcessBridgeProvider.KEY_RESULT_CODE)) {
                    if (jSONObject.getInt(ProcessBridgeProvider.KEY_RESULT_CODE) == 0) {
                        i = 1;
                    }
                    i = 2;
                } else {
                    Logger.e(o, "sth. wrong because server errorcode's key.");
                }
                int i2 = i;
                if (i != 1) {
                    i2 = i;
                    if (jSONObject.has(k2.d)) {
                        i2 = 0;
                    }
                }
                c(i2);
                if (i2 == 1 || i2 == 0) {
                    f(jSONObject.has(k2.d) ? jSONObject.getJSONObject(k2.d).toString() : "");
                    e(jSONObject.has("errorList") ? jSONObject.getJSONObject("errorList").toString() : "");
                    return;
                }
                b(jSONObject.has(AccountManager.KEY_ERROR_CODE) ? jSONObject.getInt(AccountManager.KEY_ERROR_CODE) : 9001);
                d(jSONObject.has("errorDesc") ? jSONObject.getString("errorDesc") : "");
            } catch (JSONException e) {
                Logger.w(o, "GrsResponse GrsResponse(String result) JSONException: %s", StringUtils.anonymizeMessage(e.getMessage()));
                c(2);
            }
        }
    }

    private void q() {
        if (o() || n() || m()) {
            Map<String, String> r = r();
            if (r.size() <= 0) {
                Logger.w(o, "parseHeader {headers.size() <= 0}");
                return;
            }
            try {
                if (o() || m()) {
                    b(r);
                    a(r);
                }
                if (n()) {
                    c(r);
                }
            } catch (JSONException e) {
                Logger.w(o, "parseHeader catch JSONException: %s", StringUtils.anonymizeMessage(e.getMessage()));
            }
        }
    }

    private Map<String, String> r() {
        HashMap hashMap = new HashMap(16);
        Map<String, List<String>> map = this.f9097a;
        if (map == null || map.size() <= 0) {
            Logger.v(o, "parseRespHeaders {respHeaders == null} or {respHeaders.size() <= 0}");
            return hashMap;
        }
        for (Map.Entry<String, List<String>> entry : this.f9097a.entrySet()) {
            String key = entry.getKey();
            for (String str : entry.getValue()) {
                hashMap.put(key, str);
            }
        }
        return hashMap;
    }

    private void s() {
        q();
        p();
    }

    public String a() {
        return this.j;
    }

    public void a(int i) {
    }

    public void a(long j) {
        this.f = j;
    }

    public void a(String str) {
        this.l = str;
    }

    public int b() {
        return this.f9098c;
    }

    public void b(long j) {
        this.e = j;
    }

    public void b(String str) {
        this.n = str;
    }

    public int c() {
        return this.i;
    }

    public Exception d() {
        return this.m;
    }

    public String e() {
        return this.l;
    }

    public int f() {
        return this.h;
    }

    public long g() {
        return this.f;
    }

    public long h() {
        return this.e;
    }

    public long i() {
        return this.d;
    }

    public String j() {
        return this.g;
    }

    public long k() {
        return this.k;
    }

    public String l() {
        return this.n;
    }

    public boolean m() {
        return this.f9098c == 304;
    }

    public boolean n() {
        return this.f9098c == 503;
    }

    public boolean o() {
        return this.f9098c == 200;
    }
}

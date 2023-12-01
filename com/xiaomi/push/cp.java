package com.xiaomi.push;

import android.text.TextUtils;
import com.amap.api.services.district.DistrictSearchQuery;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.tendinsv.a.b;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/cp.class */
public class cp {

    /* renamed from: a  reason: collision with other field name */
    private long f258a;

    /* renamed from: a  reason: collision with other field name */
    public String f259a;

    /* renamed from: b  reason: collision with other field name */
    public String f261b;

    /* renamed from: c  reason: collision with root package name */
    public String f41315c;
    public String d;
    public String e;
    public String f;
    public String g;
    protected String h;
    private String i;

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<cy> f260a = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    private double f41314a = 0.1d;
    private String j = "s.mi1.cc";
    private long b = 86400000;

    public cp(String str) {
        this.f259a = "";
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f258a = System.currentTimeMillis();
        this.f260a.add(new cy(str, -1));
        this.f259a = ct.m11597a();
        this.f261b = str;
    }

    private void c(String str) {
        synchronized (this) {
            Iterator<cy> it = this.f260a.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().f277a, str)) {
                    it.remove();
                }
            }
        }
    }

    public cp a(JSONObject jSONObject) {
        synchronized (this) {
            this.f259a = jSONObject.optString("net");
            this.b = jSONObject.getLong(RemoteMessageConst.TTL);
            this.f41314a = jSONObject.getDouble("pct");
            this.f258a = jSONObject.getLong("ts");
            this.d = jSONObject.optString(DistrictSearchQuery.KEYWORDS_CITY);
            this.f41315c = jSONObject.optString("prv");
            this.g = jSONObject.optString("cty");
            this.e = jSONObject.optString("isp");
            this.f = jSONObject.optString(b.a.q);
            this.f261b = jSONObject.optString("host");
            this.h = jSONObject.optString("xf");
            JSONArray jSONArray = jSONObject.getJSONArray("fbs");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < jSONArray.length()) {
                    a(new cy().a(jSONArray.getJSONObject(i2)));
                    i = i2 + 1;
                }
            }
        }
        return this;
    }

    public String a() {
        synchronized (this) {
            if (!TextUtils.isEmpty(this.i)) {
                return this.i;
            } else if (TextUtils.isEmpty(this.e)) {
                return "hardcode_isp";
            } else {
                String a2 = bn.a(new String[]{this.e, this.f41315c, this.d, this.g, this.f}, BridgeUtil.UNDERLINE_STR);
                this.i = a2;
                return a2;
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public ArrayList<String> m11587a() {
        ArrayList<String> a2;
        synchronized (this) {
            a2 = a(false);
        }
        return a2;
    }

    public ArrayList<String> a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the url is empty.");
        }
        URL url = new URL(str);
        if (TextUtils.equals(url.getHost(), this.f261b)) {
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<String> it = a(true).iterator();
            while (it.hasNext()) {
                cr a2 = cr.a(it.next(), url.getPort());
                arrayList.add(new URL(url.getProtocol(), a2.m11595a(), a2.a(), url.getFile()).toString());
            }
            return arrayList;
        }
        throw new IllegalArgumentException("the url is not supported by the fallback");
    }

    public ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        String substring;
        synchronized (this) {
            int size = this.f260a.size();
            cy[] cyVarArr = new cy[size];
            this.f260a.toArray(cyVarArr);
            Arrays.sort(cyVarArr);
            arrayList = new ArrayList<>();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size) {
                    cy cyVar = cyVarArr[i2];
                    if (z) {
                        substring = cyVar.f277a;
                    } else {
                        int indexOf = cyVar.f277a.indexOf(":");
                        substring = indexOf != -1 ? cyVar.f277a.substring(0, indexOf) : cyVar.f277a;
                    }
                    arrayList.add(substring);
                    i = i2 + 1;
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m11588a() {
        JSONObject jSONObject;
        synchronized (this) {
            jSONObject = new JSONObject();
            jSONObject.put("net", this.f259a);
            jSONObject.put(RemoteMessageConst.TTL, this.b);
            jSONObject.put("pct", this.f41314a);
            jSONObject.put("ts", this.f258a);
            jSONObject.put(DistrictSearchQuery.KEYWORDS_CITY, this.d);
            jSONObject.put("prv", this.f41315c);
            jSONObject.put("cty", this.g);
            jSONObject.put("isp", this.e);
            jSONObject.put(b.a.q, this.f);
            jSONObject.put("host", this.f261b);
            jSONObject.put("xf", this.h);
            JSONArray jSONArray = new JSONArray();
            Iterator<cy> it = this.f260a.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().a());
            }
            jSONObject.put("fbs", jSONArray);
        }
        return jSONObject;
    }

    public void a(double d) {
        this.f41314a = d;
    }

    public void a(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("the duration is invalid ".concat(String.valueOf(j)));
        }
        this.b = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(cy cyVar) {
        synchronized (this) {
            c(cyVar.f277a);
            this.f260a.add(cyVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11589a(String str) {
        synchronized (this) {
            a(new cy(str));
        }
    }

    public void a(String str, int i, long j, long j2, Exception exc) {
        a(str, new co(i, j, j2, exc));
    }

    public void a(String str, long j, long j2) {
        try {
            b(new URL(str).getHost(), j, j2);
        } catch (MalformedURLException e) {
        }
    }

    public void a(String str, long j, long j2, Exception exc) {
        try {
            b(new URL(str).getHost(), j, j2, exc);
        } catch (MalformedURLException e) {
        }
    }

    public void a(String str, co coVar) {
        cy next;
        synchronized (this) {
            Iterator<cy> it = this.f260a.iterator();
            do {
                if (!it.hasNext()) {
                    return;
                }
                next = it.next();
            } while (!TextUtils.equals(str, next.f277a));
            next.a(coVar);
        }
    }

    public void a(String[] strArr) {
        int i;
        synchronized (this) {
            int size = this.f260a.size();
            while (true) {
                int i2 = size - 1;
                int i3 = 0;
                if (i2 < 0) {
                    break;
                }
                int length = strArr.length;
                while (true) {
                    if (i3 < length) {
                        if (TextUtils.equals(this.f260a.get(i2).f277a, strArr[i3])) {
                            this.f260a.remove(i2);
                            break;
                        }
                        i3++;
                    }
                }
                size = i2;
            }
            Iterator<cy> it = this.f260a.iterator();
            int i4 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                cy next = it.next();
                if (next.f41323a > i4) {
                    i4 = next.f41323a;
                }
            }
            for (i = 0; i < strArr.length; i++) {
                a(new cy(strArr[i], (strArr.length + i4) - i));
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11590a() {
        return TextUtils.equals(this.f259a, ct.m11597a());
    }

    public boolean a(cp cpVar) {
        return TextUtils.equals(this.f259a, cpVar.f259a);
    }

    public void b(String str) {
        this.j = str;
    }

    public void b(String str, long j, long j2) {
        a(str, 0, j, j2, null);
    }

    public void b(String str, long j, long j2, Exception exc) {
        a(str, -1, j, j2, exc);
    }

    public boolean b() {
        return System.currentTimeMillis() - this.f258a < this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        long j = this.b;
        if (864000000 >= j) {
            j = 864000000;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.f258a;
        if (currentTimeMillis - j2 <= j) {
            return currentTimeMillis - j2 > this.b && this.f259a.startsWith("WIFI-");
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f259a);
        sb.append("\n");
        sb.append(a());
        Iterator<cy> it = this.f260a.iterator();
        while (it.hasNext()) {
            sb.append("\n");
            sb.append(it.next().toString());
        }
        sb.append("\n");
        return sb.toString();
    }
}

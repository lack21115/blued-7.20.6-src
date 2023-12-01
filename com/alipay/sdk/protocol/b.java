package com.alipay.sdk.protocol;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/protocol/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private a f4645a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String[] f4646c;

    public b(String str) {
        this.b = str;
    }

    public b(String str, a aVar) {
        this.b = str;
        this.f4645a = aVar;
    }

    public static List<b> a(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null) {
            return arrayList;
        }
        String[] b = b(jSONObject.optString("name", ""));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= b.length) {
                return arrayList;
            }
            a a2 = a.a(b[i2]);
            if (a2 != a.None) {
                b bVar = new b(b[i2], a2);
                bVar.f4646c = a(b[i2]);
                arrayList.add(bVar);
            }
            i = i2 + 1;
        }
    }

    public static void a(b bVar) {
        String[] c2 = bVar.c();
        if (c2.length == 3 && TextUtils.equals("tid", c2[0])) {
            com.alipay.sdk.tid.b a2 = com.alipay.sdk.tid.b.a(com.alipay.sdk.sys.b.a().b());
            if (TextUtils.isEmpty(c2[1]) || TextUtils.isEmpty(c2[2])) {
                return;
            }
            a2.a(c2[1], c2[2]);
        }
    }

    private static String[] a(String str) {
        ArrayList arrayList = new ArrayList();
        int indexOf = str.indexOf(40);
        int lastIndexOf = str.lastIndexOf(41);
        if (indexOf == -1 || lastIndexOf == -1 || lastIndexOf <= indexOf) {
            return null;
        }
        String[] split = str.substring(indexOf + 1, lastIndexOf).split("' *, *'", -1);
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return (String[]) arrayList.toArray(new String[0]);
            }
            arrayList.add(split[i2].trim().replaceAll("'", "").replaceAll("\"", ""));
            i = i2 + 1;
        }
    }

    private static String[] b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split(";");
    }

    public String a() {
        return this.b;
    }

    public a b() {
        return this.f4645a;
    }

    public String[] c() {
        return this.f4646c;
    }
}

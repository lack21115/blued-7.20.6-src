package com.sdk.tencent.a;

import com.sdk.tencent.a.d;
import java.io.File;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/a/e.class */
public class e<T> implements Serializable {
    public static final String h = e.class.getName();
    public static final Boolean i = Boolean.valueOf(com.sdk.tencent.f.c.b);
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public TreeMap<String, Object> f28013c;
    public ArrayList<File> d;
    public HashMap<String, Object> e;
    public com.sdk.tencent.e.b<T> g;

    /* renamed from: a  reason: collision with root package name */
    public String f28012a = d.b.GET.toString();
    public int f = 0;

    public com.sdk.tencent.e.b<T> a() {
        return this.g;
    }

    public String a(TreeMap<String, Object> treeMap) {
        StringBuilder sb;
        if (treeMap != null) {
            try {
                StringBuilder sb2 = new StringBuilder();
                for (Map.Entry<String, Object> entry : treeMap.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (value != null && com.sdk.tencent.n.b.b(key).booleanValue()) {
                        String encode = URLEncoder.encode(value.toString(), "UTF-8");
                        String str = com.sdk.tencent.f.c.f28049a;
                        sb2.append(key);
                        sb2.append("=");
                        sb2.append(encode);
                        sb2.append("&");
                    }
                }
                sb2.deleteCharAt(sb2.length() - 1);
                sb = sb2;
            } catch (Exception e) {
                com.sdk.tencent.n.b.a(h, e.getMessage(), i);
                throw new Exception("http请求参数出错");
            }
        } else {
            sb = null;
        }
        if (sb == null) {
            return null;
        }
        return sb.toString();
    }

    public String b() {
        return this.f28012a;
    }

    public int c() {
        return this.f;
    }

    public String d() {
        return this.b;
    }
}

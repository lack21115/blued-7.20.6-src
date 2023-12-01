package com.tencent.tmsbeacon.qimei;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/qimei/Qimei.class */
public final class Qimei {

    /* renamed from: a  reason: collision with root package name */
    private String f39607a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f39608c;

    public Qimei() {
        this("", "", null);
    }

    public Qimei(String str) {
        this(str, "", null);
    }

    public Qimei(String str, String str2, Map<String, String> map) {
        this.f39607a = str == null ? "" : str;
        this.b = str2 == null ? "" : str2;
        this.f39608c = map;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(Map<String, String> map) {
        this.f39608c = map;
    }

    public void b(String str) {
        this.f39607a = str;
    }

    public Map<String, String> getQimeiMap() {
        return this.f39608c;
    }

    public String getQimeiNew() {
        return this.b;
    }

    public String getQimeiOld() {
        return this.f39607a;
    }

    public boolean isEmpty() {
        Map<String, String> map = this.f39608c;
        return map == null || map.isEmpty();
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Qimei:");
        sb.append(this.f39607a);
        if (TextUtils.isEmpty(this.b)) {
            str = "";
        } else {
            str = "\nQimei3:" + this.b;
        }
        sb.append(str);
        return sb.toString();
    }
}

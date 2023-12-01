package com.tencent.tmsbeacon.qimei;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/qimei/Qimei.class */
public final class Qimei {

    /* renamed from: a  reason: collision with root package name */
    private String f25916a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f25917c;

    public Qimei() {
        this("", "", null);
    }

    public Qimei(String str) {
        this(str, "", null);
    }

    public Qimei(String str, String str2, Map<String, String> map) {
        this.f25916a = str == null ? "" : str;
        this.b = str2 == null ? "" : str2;
        this.f25917c = map;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(Map<String, String> map) {
        this.f25917c = map;
    }

    public void b(String str) {
        this.f25916a = str;
    }

    public Map<String, String> getQimeiMap() {
        return this.f25917c;
    }

    public String getQimeiNew() {
        return this.b;
    }

    public String getQimeiOld() {
        return this.f25916a;
    }

    public boolean isEmpty() {
        Map<String, String> map = this.f25917c;
        return map == null || map.isEmpty();
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Qimei:");
        sb.append(this.f25916a);
        if (TextUtils.isEmpty(this.b)) {
            str = "";
        } else {
            str = "\nQimei3:" + this.b;
        }
        sb.append(str);
        return sb.toString();
    }
}

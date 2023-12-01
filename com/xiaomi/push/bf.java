package com.xiaomi.push;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/bf.class */
public class bf {

    /* renamed from: a  reason: collision with root package name */
    public int f27586a;

    /* renamed from: a  reason: collision with other field name */
    public String f169a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f170a = new HashMap();

    public String a() {
        return this.f169a;
    }

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", Integer.valueOf(this.f27586a), this.f170a.toString(), this.f169a);
    }
}

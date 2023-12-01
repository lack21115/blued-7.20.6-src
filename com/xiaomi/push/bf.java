package com.xiaomi.push;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/bf.class */
public class bf {

    /* renamed from: a  reason: collision with root package name */
    public int f41277a;

    /* renamed from: a  reason: collision with other field name */
    public String f216a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f217a = new HashMap();

    public String a() {
        return this.f216a;
    }

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", Integer.valueOf(this.f41277a), this.f217a.toString(), this.f216a);
    }
}

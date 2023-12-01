package com.cmic.gen.sdk.tencent;

import com.cmic.gen.sdk.tencent.a.a;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<String, Object> f21576a;

    public a(int i) {
        this.f21576a = new ConcurrentHashMap<>(i);
    }

    public com.cmic.gen.sdk.tencent.d.b a() {
        com.cmic.gen.sdk.tencent.d.b bVar = (com.cmic.gen.sdk.tencent.d.b) this.f21576a.get("logBean");
        return bVar != null ? bVar : new com.cmic.gen.sdk.tencent.d.b();
    }

    public void a(com.cmic.gen.sdk.tencent.a.a aVar) {
        if (aVar != null) {
            this.f21576a.put("current_config", aVar);
        }
    }

    public void a(com.cmic.gen.sdk.tencent.d.b bVar) {
        if (bVar != null) {
            this.f21576a.put("logBean", bVar);
        }
    }

    public void a(String str, int i) {
        if (str != null) {
            this.f21576a.put(str, Integer.valueOf(i));
        }
    }

    public void a(String str, long j) {
        if (str != null) {
            this.f21576a.put(str, Long.valueOf(j));
        }
    }

    public void a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.f21576a.put(str, str2);
    }

    public void a(String str, boolean z) {
        if (str != null) {
            this.f21576a.put(str, Boolean.valueOf(z));
        }
    }

    public void a(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return;
        }
        this.f21576a.put(str, bArr);
    }

    public byte[] a(String str) {
        if (str != null) {
            return (byte[]) this.f21576a.get(str);
        }
        return null;
    }

    public int b(String str, int i) {
        return (str == null || !this.f21576a.containsKey(str)) ? i : ((Integer) this.f21576a.get(str)).intValue();
    }

    public long b(String str, long j) {
        return (str == null || !this.f21576a.containsKey(str)) ? j : ((Long) this.f21576a.get(str)).longValue();
    }

    public com.cmic.gen.sdk.tencent.a.a b() {
        com.cmic.gen.sdk.tencent.a.a aVar = (com.cmic.gen.sdk.tencent.a.a) this.f21576a.get("current_config");
        if (aVar != null) {
            return aVar;
        }
        com.cmic.gen.sdk.tencent.e.c.a("UmcConfigBean为空", "请核查");
        return new a.C0328a().a();
    }

    public String b(String str) {
        return b(str, "");
    }

    public String b(String str, String str2) {
        return (str == null || !this.f21576a.containsKey(str)) ? str2 : (String) this.f21576a.get(str);
    }

    public boolean b(String str, boolean z) {
        return (str == null || !this.f21576a.containsKey(str)) ? z : ((Boolean) this.f21576a.get(str)).booleanValue();
    }

    public int c(String str) {
        return b(str, 0);
    }
}

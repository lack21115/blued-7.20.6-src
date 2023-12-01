package com.cmic.gen.sdk.tencent.c.c;

import android.net.Network;
import com.cmic.gen.sdk.tencent.c.b.g;
import com.cmic.gen.sdk.tencent.e.e;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/c/c/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    String f21646a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, String> f21647c;
    private final String d;
    private boolean e;
    private final String f;
    private Network g;
    private long h;
    private final String i;
    private int j;
    private final g k;

    public c(String str, g gVar, String str2, String str3) {
        this(str, null, gVar, str2, str3);
    }

    private c(String str, Map<String, String> map, g gVar, String str2, String str3) {
        this.e = false;
        this.b = str;
        this.k = gVar;
        this.f21647c = map == null ? new HashMap() : map;
        this.f21646a = gVar == null ? "" : gVar.b().toString();
        this.d = str2;
        this.f = str3;
        this.i = gVar == null ? "" : gVar.a();
        l();
    }

    private void l() {
        this.f21647c.put("sdkVersion", com.cmic.gen.sdk.tencent.auth.c.SDK_VERSION);
        this.f21647c.put("Content-Type", "application/json");
        this.f21647c.put("CMCC-EncryptType", "STD");
        this.f21647c.put("traceId", this.f);
        this.f21647c.put("appid", this.i);
        this.f21647c.put("Connection", "close");
    }

    public String a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        this.h = j;
    }

    public void a(Network network) {
        this.g = network;
    }

    public void a(String str, String str2) {
        this.f21647c.put(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.e = z;
    }

    public boolean b() {
        return this.e;
    }

    public Map<String, String> c() {
        return this.f21647c;
    }

    public String d() {
        return this.f21646a;
    }

    public String e() {
        return this.d;
    }

    public String f() {
        return this.f;
    }

    public boolean g() {
        return !e.a(this.f) || this.b.contains("logReport") || this.b.contains("uniConfig");
    }

    public Network h() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long i() {
        return this.h;
    }

    public boolean j() {
        int i = this.j;
        this.j = i + 1;
        return i < 2;
    }

    public g k() {
        return this.k;
    }
}

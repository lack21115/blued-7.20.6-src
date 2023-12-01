package com.tencent.mapsdk.internal;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/d.class */
public class d extends f {
    private static final long o = 1;

    public d() {
        h hVar = this.i;
        hVar.f23805c = (short) 2;
        hVar.d = (byte) 0;
        hVar.e = 0;
        hVar.j = 0;
        hVar.i = new byte[0];
        hVar.k = new HashMap();
        this.i.l = new HashMap();
    }

    public void a(byte b) {
        this.i.d = b;
    }

    public void a(Map<String, String> map) {
        this.i.k = map;
    }

    public void a(short s) {
        this.i.f23805c = s;
        if (s == 3) {
            g();
        }
    }

    public void b(Map<String, String> map) {
        this.i.l = map;
    }

    public void c(int i) {
        this.i.e = i;
    }

    public void d(int i) {
        this.i.j = i;
    }

    public void d(byte[] bArr) {
        this.i.i = bArr;
    }

    public byte[] r() {
        return this.i.i;
    }

    public Map<String, String> s() {
        return this.i.k;
    }

    public int t() {
        return this.i.e;
    }

    public byte u() {
        return this.i.d;
    }

    public int v() {
        String str = this.i.l.get("STATUS_RESULT_CODE");
        if (str != null) {
            return Integer.parseInt(str);
        }
        return 0;
    }

    public String w() {
        String str = this.i.l.get("STATUS_RESULT_DESC");
        return str != null ? str : "";
    }

    public Map<String, String> x() {
        return this.i.l;
    }

    public int y() {
        return this.i.j;
    }

    public short z() {
        return this.i.f23805c;
    }
}

package com.opos.cmn.biz.monitor.b;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/monitor/b/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private int f10963a;
    private Map<String, String> b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f10964c;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/monitor/b/c$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f10965a;
        private Map<String, String> b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        private byte[] f10966c = null;

        public a(int i) {
            this.f10965a = i;
        }

        public a a(Map<String, String> map) {
            if (map == null) {
                return this;
            }
            this.b = map;
            return this;
        }

        public a a(byte[] bArr) {
            this.f10966c = bArr;
            return this;
        }

        public c a() {
            return new c(this.f10965a, this.b, this.f10966c);
        }
    }

    private c(int i, Map<String, String> map, byte[] bArr) {
        this.f10963a = i;
        this.b = map;
        this.f10964c = bArr;
    }

    public int a() {
        return this.f10963a;
    }

    public Map<String, String> b() {
        return this.b;
    }

    public byte[] c() {
        return this.f10964c;
    }
}

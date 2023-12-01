package com.opos.cmn.biz.monitor.b;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/monitor/b/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private int f24650a;
    private Map<String, String> b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f24651c;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/monitor/b/c$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f24652a;
        private Map<String, String> b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        private byte[] f24653c = null;

        public a(int i) {
            this.f24652a = i;
        }

        public a a(Map<String, String> map) {
            if (map == null) {
                return this;
            }
            this.b = map;
            return this;
        }

        public a a(byte[] bArr) {
            this.f24653c = bArr;
            return this;
        }

        public c a() {
            return new c(this.f24652a, this.b, this.f24653c);
        }
    }

    private c(int i, Map<String, String> map, byte[] bArr) {
        this.f24650a = i;
        this.b = map;
        this.f24651c = bArr;
    }

    public int a() {
        return this.f24650a;
    }

    public Map<String, String> b() {
        return this.b;
    }

    public byte[] c() {
        return this.f24651c;
    }
}

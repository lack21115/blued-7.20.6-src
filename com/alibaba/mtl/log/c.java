package com.alibaba.mtl.log;

import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/c.class */
public class c {
    public static final c a = new c();
    private boolean u = false;
    private boolean v = false;
    private String H = null;
    private Map<String, String> r = null;
    private boolean w = false;
    private boolean x = false;
    private String I = null;
    private String J = null;
    private String K = null;
    private boolean y = false;

    public static c a() {
        return a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m8612a() {
        Map<String, String> map;
        synchronized (this) {
            map = this.r;
        }
        return map;
    }

    public void c(Map<String, String> map) {
        synchronized (this) {
            this.r = map;
        }
    }

    public void e(String str) {
        synchronized (this) {
            this.I = str;
        }
    }

    public boolean f() {
        boolean z;
        synchronized (this) {
            z = this.x;
        }
        return z;
    }

    public void p() {
        synchronized (this) {
            this.x = true;
        }
    }
}

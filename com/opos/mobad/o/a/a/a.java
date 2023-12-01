package com.opos.mobad.o.a.a;

import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/a/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f13341a;
    public ArrayList<b> b;

    /* renamed from: com.opos.mobad.o.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/a/a/a$a.class */
    public static class C0550a {

        /* renamed from: a  reason: collision with root package name */
        private String f13342a = "";
        private ArrayList<b> b = new ArrayList<>();

        public C0550a a(b bVar) {
            if (!this.b.contains(bVar)) {
                this.b.add(bVar);
            }
            return this;
        }

        public C0550a a(String str) {
            this.f13342a = str;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }

    public a(C0550a c0550a) {
        this.b = c0550a.b;
        this.f13341a = c0550a.f13342a;
    }
}

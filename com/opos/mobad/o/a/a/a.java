package com.opos.mobad.o.a.a;

import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/a/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f27029a;
    public ArrayList<b> b;

    /* renamed from: com.opos.mobad.o.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/a/a/a$a.class */
    public static class C0720a {

        /* renamed from: a  reason: collision with root package name */
        private String f27030a = "";
        private ArrayList<b> b = new ArrayList<>();

        public C0720a a(b bVar) {
            if (!this.b.contains(bVar)) {
                this.b.add(bVar);
            }
            return this;
        }

        public C0720a a(String str) {
            this.f27030a = str;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }

    public a(C0720a c0720a) {
        this.b = c0720a.b;
        this.f27029a = c0720a.f27030a;
    }
}

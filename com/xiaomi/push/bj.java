package com.xiaomi.push;

import java.util.LinkedList;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/bj.class */
public class bj {

    /* renamed from: a  reason: collision with root package name */
    private LinkedList<a> f41284a = new LinkedList<>();

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/bj$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final bj f41285a = new bj();

        /* renamed from: a  reason: collision with other field name */
        public int f220a;

        /* renamed from: a  reason: collision with other field name */
        public Object f221a;

        /* renamed from: a  reason: collision with other field name */
        public String f222a;

        a(int i, Object obj) {
            this.f220a = i;
            this.f221a = obj;
        }
    }

    public static bj a() {
        return a.f41285a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m11541a() {
        if (this.f41284a.size() > 100) {
            this.f41284a.removeFirst();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m11542a() {
        int size;
        synchronized (this) {
            size = this.f41284a.size();
        }
        return size;
    }

    /* renamed from: a  reason: collision with other method in class */
    public LinkedList<a> m11543a() {
        LinkedList<a> linkedList;
        synchronized (this) {
            linkedList = this.f41284a;
            this.f41284a = new LinkedList<>();
        }
        return linkedList;
    }

    public void a(Object obj) {
        synchronized (this) {
            this.f41284a.add(new a(0, obj));
            m11541a();
        }
    }
}

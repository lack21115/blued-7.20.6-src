package com.xiaomi.push;

import java.util.LinkedList;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/bj.class */
public class bj {

    /* renamed from: a  reason: collision with root package name */
    private LinkedList<a> f27593a = new LinkedList<>();

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/bj$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final bj f27594a = new bj();

        /* renamed from: a  reason: collision with other field name */
        public int f173a;

        /* renamed from: a  reason: collision with other field name */
        public Object f174a;

        /* renamed from: a  reason: collision with other field name */
        public String f175a;

        a(int i, Object obj) {
            this.f173a = i;
            this.f174a = obj;
        }
    }

    public static bj a() {
        return a.f27594a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m8491a() {
        if (this.f27593a.size() > 100) {
            this.f27593a.removeFirst();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m8492a() {
        int size;
        synchronized (this) {
            size = this.f27593a.size();
        }
        return size;
    }

    /* renamed from: a  reason: collision with other method in class */
    public LinkedList<a> m8493a() {
        LinkedList<a> linkedList;
        synchronized (this) {
            linkedList = this.f27593a;
            this.f27593a = new LinkedList<>();
        }
        return linkedList;
    }

    public void a(Object obj) {
        synchronized (this) {
            this.f27593a.add(new a(0, obj));
            m8491a();
        }
    }
}

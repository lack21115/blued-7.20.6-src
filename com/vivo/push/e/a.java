package com.vivo.push.e;

import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/e/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static String[] f27402a = {"com.vivo.pushservice", "com.vivo.pushdemo.test", "com.vivo.sdk.test", "com.vivo.hybrid"};
    private ArrayList<String> b;

    /* renamed from: com.vivo.push.e.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/vivo/push/e/a$a.class */
    static final class C0922a {

        /* renamed from: a  reason: collision with root package name */
        private static a f27405a = new a((byte) 0);
    }

    private a() {
        this.b = null;
        this.b = new ArrayList<>();
    }

    /* synthetic */ a(byte b) {
        this();
    }

    public static a a() {
        return C0922a.f27405a;
    }

    public final ArrayList<String> b() {
        return new ArrayList<>(this.b);
    }

    public final boolean c() {
        ArrayList<String> arrayList = this.b;
        return (arrayList == null || arrayList.size() == 0) ? false : true;
    }
}

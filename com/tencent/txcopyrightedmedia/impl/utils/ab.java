package com.tencent.txcopyrightedmedia.impl.utils;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/ab.class */
public final class ab {

    /* renamed from: a  reason: collision with root package name */
    private static int f40039a = 5;
    private static final ArrayList<a> b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private static final ArrayList<a> f40040c = new ArrayList<>();
    private static final Object d = new Object();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/ab$a.class */
    public interface a {
        String a();

        void b();

        void c();
    }

    public static a a(a aVar) {
        a next;
        a next2;
        synchronized (d) {
            Iterator<a> it = f40040c.iterator();
            do {
                if (!it.hasNext()) {
                    Iterator<a> it2 = b.iterator();
                    do {
                        if (!it2.hasNext()) {
                            b.add(aVar);
                            int i = f40039a - 1;
                            f40039a = i;
                            if (i >= 0) {
                                aVar.b();
                                new Thread() { // from class: com.tencent.txcopyrightedmedia.impl.utils.ab.1
                                    @Override // java.lang.Thread, java.lang.Runnable
                                    public final void run() {
                                        a aVar2;
                                        while (true) {
                                            synchronized (ab.d) {
                                                if (ab.b.size() <= 0) {
                                                    ab.e();
                                                    return;
                                                } else {
                                                    aVar2 = (a) ab.b.remove(0);
                                                    ab.f40040c.add(aVar2);
                                                }
                                            }
                                            if (aVar2 != null) {
                                                aVar2.c();
                                                synchronized (ab.d) {
                                                    ab.f40040c.remove(aVar2);
                                                }
                                            }
                                        }
                                    }
                                }.start();
                            } else {
                                f40039a = 0;
                                aVar.b();
                            }
                            return null;
                        }
                        next = it2.next();
                    } while (!TextUtils.equals(aVar.a(), next.a()));
                    return next;
                }
                next2 = it.next();
            } while (!TextUtils.equals(aVar.a(), next2.a()));
            return next2;
        }
    }

    public static void a() {
        synchronized (d) {
            b.clear();
        }
    }

    static /* synthetic */ int e() {
        int i = f40039a + 1;
        f40039a = i;
        return i;
    }
}

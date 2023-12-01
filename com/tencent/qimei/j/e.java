package com.tencent.qimei.j;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/j/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static AtomicBoolean f24653a = new AtomicBoolean(false);

    public static void a(String str) {
        if (f24653a.get()) {
            throw new IllegalStateException("[strict] " + str);
        }
    }
}

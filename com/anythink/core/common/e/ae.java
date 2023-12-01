package com.anythink.core.common.e;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e/ae.class */
public final class ae {
    public int a;
    public String b;
    public int c;
    public int d;
    public long e;
    public ConcurrentHashMap<String, a> f;

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e/ae$a.class */
    public static final class a {
        public String a;
        public String b;
        public String c;
        public int d;
        public int e;
        public long f;
    }

    public final a a(String str) {
        ConcurrentHashMap<String, a> concurrentHashMap = this.f;
        if (concurrentHashMap != null) {
            return concurrentHashMap.get(str);
        }
        return null;
    }
}

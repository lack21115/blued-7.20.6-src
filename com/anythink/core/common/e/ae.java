package com.anythink.core.common.e;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e/ae.class */
public final class ae {

    /* renamed from: a  reason: collision with root package name */
    public int f6622a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public int f6623c;
    public int d;
    public long e;
    public ConcurrentHashMap<String, a> f;

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e/ae$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f6624a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public String f6625c;
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

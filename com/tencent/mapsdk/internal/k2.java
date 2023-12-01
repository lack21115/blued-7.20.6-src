package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/k2.class */
public interface k2 {
    public static final String d = "services";

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/k2$a.class */
    public interface a {
        void setAllow(boolean z);

        void setUseHttps(boolean z);

        void setUseTest(boolean z);
    }

    a a(String str);

    <T extends p> void a(Class<T> cls);

    <T extends a> void a(String str, Class<T> cls);

    j2 c();
}

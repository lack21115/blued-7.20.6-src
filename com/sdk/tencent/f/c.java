package com.sdk.tencent.f;

import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/f/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f14361a;
    public static boolean b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f14362c;
    public static boolean d;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/f/c$b.class */
    public static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f14363a;
        public static final b b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ b[] f14364c;

        /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/f/c$b$a.class */
        public enum a extends b {
            public a(String str, int i) {
                super(str, i);
            }

            @Override // com.sdk.tencent.f.c.b
            public String a() {
                return com.sdk.tencent.m.a.a("cucc/host_cucc.properties", "PRODUCE_STATISTICAL");
            }
        }

        /* renamed from: com.sdk.tencent.f.c$b$b  reason: collision with other inner class name */
        /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/f/c$b$b.class */
        public enum C0590b extends b {
            public C0590b(String str, int i) {
                super(str, i);
            }

            @Override // com.sdk.tencent.f.c.b
            public String a() {
                return com.sdk.tencent.m.a.a("cucc/host_cucc.properties", "PRODUCE_DZH");
            }
        }

        static {
            a aVar = new a("PRODUCE_STATISTICAL", 0);
            f14363a = aVar;
            C0590b c0590b = new C0590b("PRODUCE_DZH", 1);
            b = c0590b;
            f14364c = new b[]{aVar, c0590b};
        }

        public b(String str, int i) {
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f14364c.clone();
        }

        public abstract String a();
    }

    static {
        new HashMap();
        f14361a = "installTime";
        b = false;
        f14362c = true;
        d = false;
    }
}

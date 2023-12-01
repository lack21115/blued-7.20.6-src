package com.sdk.tencent.f;

import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/f/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f28049a;
    public static boolean b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f28050c;
    public static boolean d;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/f/c$b.class */
    public static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f28051a;
        public static final b b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ b[] f28052c;

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
        public enum C0760b extends b {
            public C0760b(String str, int i) {
                super(str, i);
            }

            @Override // com.sdk.tencent.f.c.b
            public String a() {
                return com.sdk.tencent.m.a.a("cucc/host_cucc.properties", "PRODUCE_DZH");
            }
        }

        static {
            a aVar = new a("PRODUCE_STATISTICAL", 0);
            f28051a = aVar;
            C0760b c0760b = new C0760b("PRODUCE_DZH", 1);
            b = c0760b;
            f28052c = new b[]{aVar, c0760b};
        }

        public b(String str, int i) {
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f28052c.clone();
        }

        public abstract String a();
    }

    static {
        new HashMap();
        f28049a = "installTime";
        b = false;
        f28050c = true;
        d = false;
    }
}

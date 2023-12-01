package com.sdk.tencent.o;

import com.sdk.tencent.f.c;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/o/b.class */
public class b extends com.sdk.tencent.i.a {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f14378a = 0;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: com.sdk.tencent.o.b$b  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/o/b$b.class */
    public static abstract class EnumC0591b {

        /* renamed from: a  reason: collision with root package name */
        public static final EnumC0591b f14379a;
        public static final EnumC0591b b;

        /* renamed from: c  reason: collision with root package name */
        public static final EnumC0591b f14380c;
        public static final /* synthetic */ EnumC0591b[] d;

        /* renamed from: com.sdk.tencent.o.b$b$a */
        /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/o/b$b$a.class */
        public enum a extends EnumC0591b {
            public a(String str, int i) {
                super(str, i);
            }

            @Override // com.sdk.tencent.o.b.EnumC0591b
            public int a() {
                return 0;
            }
        }

        /* renamed from: com.sdk.tencent.o.b$b$b  reason: collision with other inner class name */
        /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/o/b$b$b.class */
        public enum C0592b extends EnumC0591b {
            public C0592b(String str, int i) {
                super(str, i);
            }

            @Override // com.sdk.tencent.o.b.EnumC0591b
            public int a() {
                return 1;
            }
        }

        /* renamed from: com.sdk.tencent.o.b$b$c */
        /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/o/b$b$c.class */
        public enum c extends EnumC0591b {
            public c(String str, int i) {
                super(str, i);
            }

            @Override // com.sdk.tencent.o.b.EnumC0591b
            public int a() {
                return -1;
            }
        }

        static {
            a aVar = new a("WIFI", 0);
            f14379a = aVar;
            C0592b c0592b = new C0592b("NET", 1);
            b = c0592b;
            c cVar = new c("UNKNOW", 2);
            f14380c = cVar;
            d = new EnumC0591b[]{aVar, c0592b, cVar};
        }

        public EnumC0591b(String str, int i) {
        }

        public static EnumC0591b valueOf(String str) {
            return (EnumC0591b) Enum.valueOf(EnumC0591b.class, str);
        }

        public static EnumC0591b[] values() {
            return (EnumC0591b[]) d.clone();
        }

        public abstract int a();
    }

    static {
        boolean z = c.b;
    }
}

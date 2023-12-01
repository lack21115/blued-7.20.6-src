package com.sdk.tencent.o;

import com.sdk.tencent.f.c;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/o/b.class */
public class b extends com.sdk.tencent.i.a {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f28066a = 0;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: com.sdk.tencent.o.b$b  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/o/b$b.class */
    public static abstract class EnumC0761b {

        /* renamed from: a  reason: collision with root package name */
        public static final EnumC0761b f28067a;
        public static final EnumC0761b b;

        /* renamed from: c  reason: collision with root package name */
        public static final EnumC0761b f28068c;
        public static final /* synthetic */ EnumC0761b[] d;

        /* renamed from: com.sdk.tencent.o.b$b$a */
        /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/o/b$b$a.class */
        public enum a extends EnumC0761b {
            public a(String str, int i) {
                super(str, i);
            }

            @Override // com.sdk.tencent.o.b.EnumC0761b
            public int a() {
                return 0;
            }
        }

        /* renamed from: com.sdk.tencent.o.b$b$b  reason: collision with other inner class name */
        /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/o/b$b$b.class */
        public enum C0762b extends EnumC0761b {
            public C0762b(String str, int i) {
                super(str, i);
            }

            @Override // com.sdk.tencent.o.b.EnumC0761b
            public int a() {
                return 1;
            }
        }

        /* renamed from: com.sdk.tencent.o.b$b$c */
        /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/o/b$b$c.class */
        public enum c extends EnumC0761b {
            public c(String str, int i) {
                super(str, i);
            }

            @Override // com.sdk.tencent.o.b.EnumC0761b
            public int a() {
                return -1;
            }
        }

        static {
            a aVar = new a("WIFI", 0);
            f28067a = aVar;
            C0762b c0762b = new C0762b("NET", 1);
            b = c0762b;
            c cVar = new c("UNKNOW", 2);
            f28068c = cVar;
            d = new EnumC0761b[]{aVar, c0762b, cVar};
        }

        public EnumC0761b(String str, int i) {
        }

        public static EnumC0761b valueOf(String str) {
            return (EnumC0761b) Enum.valueOf(EnumC0761b.class, str);
        }

        public static EnumC0761b[] values() {
            return (EnumC0761b[]) d.clone();
        }

        public abstract int a();
    }

    static {
        boolean z = c.b;
    }
}

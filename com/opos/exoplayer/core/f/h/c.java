package com.opos.exoplayer.core.f.h;

import android.text.Layout;
import android.text.SpannableStringBuilder;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/h/c.class */
public final class c extends com.opos.exoplayer.core.f.b {
    public final long m;
    public final long n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.exoplayer.core.f.h.c$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/h/c$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25395a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            f25395a = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f25395a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f25395a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/h/c$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private long f25396a;
        private long b;

        /* renamed from: c  reason: collision with root package name */
        private SpannableStringBuilder f25397c;
        private Layout.Alignment d;
        private float e;
        private int f;
        private int g;
        private float h;
        private int i;
        private float j;

        public a() {
            a();
        }

        private a c() {
            if (this.d == null) {
                this.i = Integer.MIN_VALUE;
                return this;
            }
            int i = AnonymousClass1.f25395a[this.d.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    this.i = 1;
                    return this;
                } else if (i == 3) {
                    this.i = 2;
                    return this;
                } else {
                    com.opos.cmn.an.f.a.c("WebvttCueBuilder", "Unrecognized alignment: " + this.d);
                }
            }
            this.i = 0;
            return this;
        }

        public a a(float f) {
            this.e = f;
            return this;
        }

        public a a(int i) {
            this.f = i;
            return this;
        }

        public a a(long j) {
            this.f25396a = j;
            return this;
        }

        public a a(Layout.Alignment alignment) {
            this.d = alignment;
            return this;
        }

        public a a(SpannableStringBuilder spannableStringBuilder) {
            this.f25397c = spannableStringBuilder;
            return this;
        }

        public void a() {
            this.f25396a = 0L;
            this.b = 0L;
            this.f25397c = null;
            this.d = null;
            this.e = Float.MIN_VALUE;
            this.f = Integer.MIN_VALUE;
            this.g = Integer.MIN_VALUE;
            this.h = Float.MIN_VALUE;
            this.i = Integer.MIN_VALUE;
            this.j = Float.MIN_VALUE;
        }

        public a b(float f) {
            this.h = f;
            return this;
        }

        public a b(int i) {
            this.g = i;
            return this;
        }

        public a b(long j) {
            this.b = j;
            return this;
        }

        public c b() {
            if (this.h != Float.MIN_VALUE && this.i == Integer.MIN_VALUE) {
                c();
            }
            return new c(this.f25396a, this.b, this.f25397c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
        }

        public a c(float f) {
            this.j = f;
            return this;
        }

        public a c(int i) {
            this.i = i;
            return this;
        }
    }

    public c(long j, long j2, CharSequence charSequence) {
        this(j, j2, charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public c(long j, long j2, CharSequence charSequence, Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3) {
        super(charSequence, alignment, f, i, i2, f2, i3, f3);
        this.m = j;
        this.n = j2;
    }

    public c(CharSequence charSequence) {
        this(0L, 0L, charSequence);
    }

    public boolean a() {
        return this.d == Float.MIN_VALUE && this.g == Float.MIN_VALUE;
    }
}

package com.kwad.sdk.utils.kwai;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/kwai/a.class */
final class a {

    /* renamed from: com.kwad.sdk.utils.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/kwai/a$a.class */
    static final class C0410a extends j {
        /* JADX INFO: Access modifiers changed from: package-private */
        public C0410a(int i, int i2, Object obj, int i3, boolean z) {
            super(i, i2, obj, i3, z);
        }

        @Override // com.kwad.sdk.utils.kwai.a.b
        final byte Fb() {
            return (byte) 7;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/kwai/a$b.class */
    static abstract class b {
        int offset;

        b() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract byte Fb();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/kwai/a$c.class */
    static final class c extends b {
        boolean value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, boolean z) {
            this.offset = i;
            this.value = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.kwad.sdk.utils.kwai.a.b
        public final byte Fb() {
            return (byte) 1;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/kwai/a$d.class */
    static final class d extends b {
        double value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(int i, double d) {
            this.offset = i;
            this.value = d;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.kwad.sdk.utils.kwai.a.b
        public final byte Fb() {
            return (byte) 5;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/kwai/a$e.class */
    static final class e extends b {
        float value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public e(int i, float f) {
            this.offset = i;
            this.value = f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.kwad.sdk.utils.kwai.a.b
        public final byte Fb() {
            return (byte) 3;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/kwai/a$f.class */
    static final class f extends b {
        int value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public f(int i, int i2) {
            this.offset = i;
            this.value = i2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.kwad.sdk.utils.kwai.a.b
        public final byte Fb() {
            return (byte) 2;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/kwai/a$g.class */
    static final class g extends b {
        long value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(int i, long j) {
            this.offset = i;
            this.value = j;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.kwad.sdk.utils.kwai.a.b
        public final byte Fb() {
            return (byte) 4;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/kwai/a$h.class */
    static final class h extends j {
        /* JADX INFO: Access modifiers changed from: package-private */
        public h(int i, int i2, Object obj, int i3, boolean z) {
            super(i, i2, obj, i3, z);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.kwad.sdk.utils.kwai.a.b
        public final byte Fb() {
            return (byte) 8;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/kwai/a$i.class */
    static final class i extends j {
        /* JADX INFO: Access modifiers changed from: package-private */
        public i(int i, int i2, String str, int i3, boolean z) {
            super(i, i2, str, i3, z);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.kwad.sdk.utils.kwai.a.b
        public final byte Fb() {
            return (byte) 6;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/kwai/a$j.class */
    static abstract class j extends b {
        int aBL;
        boolean aBM;
        int start;
        Object value;

        j(int i, int i2, Object obj, int i3, boolean z) {
            this.start = i;
            this.offset = i2;
            this.value = obj;
            this.aBL = i3;
            this.aBM = z;
        }
    }
}

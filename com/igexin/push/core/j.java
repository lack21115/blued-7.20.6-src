package com.igexin.push.core;

import com.igexin.push.core.d;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/j.class */
public final class j {
    private static final String b = "HeartBeatGenerator";
    private static j e;

    /* renamed from: a  reason: collision with root package name */
    public long f23563a = 240000;

    /* renamed from: c  reason: collision with root package name */
    private int f23564c = b.f23568a;
    private long d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.igexin.push.core.j$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/j$1.class */
    public static final /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23565a;
        static final /* synthetic */ int[] b;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0059 -> B:34:0x0013). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x005d -> B:44:0x001d). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0061 -> B:40:0x0027). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0065 -> B:10:0x0031). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0069 -> B:32:0x0044). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x006d -> B:42:0x004e). Please submit an issue!!! */
        static {
            int[] iArr = new int[a.a().length];
            b = iArr;
            try {
                iArr[a.f23566a - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[a.b - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                b[a.f23567c - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                b[a.d - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
            int[] iArr2 = new int[b.a().length];
            f23565a = iArr2;
            try {
                iArr2[b.f23568a - 1] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f23565a[b.b - 1] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f23565a[b.f23569c - 1] = 3;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/j$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f23566a = 1;
        public static final int b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f23567c = 3;
        public static final int d = 4;
        private static final /* synthetic */ int[] e = {1, 2, 3, 4};

        private a(String str, int i) {
        }

        public static int[] a() {
            return (int[]) e.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/j$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final int f23568a = 1;
        public static final int b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f23569c = 3;
        private static final /* synthetic */ int[] d = {1, 2, 3};

        private b(String str, int i) {
        }

        public static int[] a() {
            return (int[]) d.clone();
        }
    }

    private j() {
    }

    public static j a() {
        if (e == null) {
            e = new j();
        }
        return e;
    }

    private void a(long j) {
        this.f23563a = j;
    }

    private void b(int i) {
        int i2;
        int i3 = AnonymousClass1.b[i - 1];
        if (i3 == 1) {
            this.f23563a = Math.min(this.f23563a + 60000, (long) com.igexin.push.config.c.n);
            i2 = b.f23568a;
        } else if (i3 != 2 && i3 != 3) {
            if (i3 != 4) {
                return;
            }
            this.f23563a = 240000L;
            e(b.f23568a);
            return;
        } else {
            long j = this.d + 1;
            this.d = j;
            if (j < 2) {
                return;
            }
            this.f23563a = Math.max(this.f23563a - 60000, 240000L);
            i2 = b.b;
        }
        e(i2);
    }

    private void c(int i) {
        int i2;
        int i3 = AnonymousClass1.b[i - 1];
        if (i3 == 1) {
            i2 = b.b;
        } else if (i3 != 2 && i3 != 3) {
            if (i3 != 4) {
                return;
            }
            this.f23563a = 240000L;
            e(b.f23568a);
            return;
        } else {
            this.f23563a = Math.max(this.f23563a - 60000, 240000L);
            long j = this.d + 1;
            this.d = j;
            if (j < 2) {
                return;
            }
            this.f23563a = 240000L;
            i2 = b.f23569c;
        }
        e(i2);
    }

    private void d(int i) {
        int i2;
        int i3 = AnonymousClass1.b[i - 1];
        if (i3 == 1) {
            this.f23563a = 240000L;
            i2 = b.f23568a;
        } else if (i3 != 2 && i3 != 3) {
            if (i3 != 4) {
                return;
            }
            this.f23563a = 240000L;
            e(b.f23568a);
            return;
        } else {
            i2 = b.f23569c;
        }
        e(i2);
    }

    private void e(int i) {
        this.f23564c = i;
        this.d = 0L;
    }

    public final void a(int i) {
        int i2;
        int i3 = AnonymousClass1.f23565a[this.f23564c - 1];
        if (i3 != 1) {
            if (i3 == 2) {
                int i4 = AnonymousClass1.b[i - 1];
                if (i4 != 1) {
                    if (i4 != 2 && i4 != 3) {
                        if (i4 != 4) {
                            return;
                        }
                        this.f23563a = 240000L;
                        e(b.f23568a);
                        return;
                    }
                    this.f23563a = Math.max(this.f23563a - 60000, 240000L);
                    long j = this.d + 1;
                    this.d = j;
                    if (j < 2) {
                        return;
                    }
                    this.f23563a = 240000L;
                }
                i2 = b.b;
            } else if (i3 != 3) {
                return;
            } else {
                int i5 = AnonymousClass1.b[i - 1];
                if (i5 == 1) {
                    this.f23563a = 240000L;
                    i2 = b.f23568a;
                } else if (i5 != 2 && i5 != 3) {
                    if (i5 != 4) {
                        return;
                    }
                    this.f23563a = 240000L;
                    e(b.f23568a);
                    return;
                }
            }
            i2 = b.f23569c;
        } else {
            int i6 = AnonymousClass1.b[i - 1];
            if (i6 == 1) {
                this.f23563a = Math.min(this.f23563a + 60000, (long) com.igexin.push.config.c.n);
                i2 = b.f23568a;
            } else if (i6 != 2 && i6 != 3) {
                if (i6 != 4) {
                    return;
                }
                this.f23563a = 240000L;
                e(b.f23568a);
                return;
            } else {
                long j2 = this.d + 1;
                this.d = j2;
                if (j2 < 2) {
                    return;
                }
                this.f23563a = Math.max(this.f23563a - 60000, 240000L);
                i2 = b.b;
            }
        }
        e(i2);
    }

    public final long b() {
        long j = this.f23563a;
        if (com.igexin.push.config.d.e > 0) {
            j = com.igexin.push.config.d.e * 1000;
        }
        if (e.n && e.u && d.a.f23474a.h.b) {
            return j;
        }
        return 3600000L;
    }
}

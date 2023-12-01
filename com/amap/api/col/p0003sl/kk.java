package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Random;

/* renamed from: com.amap.api.col.3sl.kk  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/kk.class */
public class kk {

    /* renamed from: a  reason: collision with root package name */
    static boolean f5278a = false;
    static int b = 20;

    /* renamed from: c  reason: collision with root package name */
    private static int f5279c = 20;
    private static WeakReference<ke> d;
    private static int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.kk$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/kk$a.class */
    public static final class a extends lc {

        /* renamed from: a  reason: collision with root package name */
        static int f5280a = 1;
        static int b = 2;

        /* renamed from: c  reason: collision with root package name */
        static int f5281c = 3;
        private Context d;
        private kj e;
        private int g;
        private List<kj> h;

        a(Context context, int i) {
            this.d = context;
            this.g = i;
        }

        a(Context context, int i, kj kjVar) {
            this(context, i);
            this.e = kjVar;
        }

        a(Context context, int i, List<kj> list) {
            this(context, i);
            this.h = list;
        }

        @Override // com.amap.api.col.p0003sl.lc
        public final void runTask() {
            ByteArrayOutputStream byteArrayOutputStream;
            Throwable th;
            byte[] bArr;
            int i = this.g;
            if (i == 1) {
                try {
                    if (this.d == null || this.e == null) {
                        return;
                    }
                    synchronized (kk.class) {
                        if (this.d != null && this.e != null) {
                            kk.a(this.d, this.e.a());
                        }
                    }
                } catch (Throwable th2) {
                    iw.c(th2, "stm", "as");
                }
            } else if (i != 2) {
                if (i == 3) {
                    try {
                        if (this.d == null) {
                            return;
                        }
                        ke a2 = kl.a(kk.d);
                        kl.a(this.d, a2, iu.h, 1000, 307200, "2");
                        if (a2.g == null) {
                            a2.g = new km(new kq(this.d, new kn(new kr(new kt()))));
                        }
                        a2.h = 3600000;
                        if (TextUtils.isEmpty(a2.i)) {
                            a2.i = "cKey";
                        }
                        if (a2.f == null) {
                            a2.f = new kx(this.d, a2.h, a2.i, new ku(a2.f5266a, new kv(this.d, kk.f5278a, kk.f5279c * 1024, kk.b * 1024, "staticUpdate", kk.e * 1024)));
                        }
                        kf.a(a2);
                    } catch (Throwable th3) {
                        iw.c(th3, "stm", "usd");
                    }
                }
            } else {
                try {
                    synchronized (kk.class) {
                        if (this.h != null && this.d != null) {
                            byte[] bArr2 = new byte[0];
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                try {
                                    for (kj kjVar : this.h) {
                                        if (kjVar != null) {
                                            byteArrayOutputStream.write(kjVar.a());
                                        }
                                    }
                                    bArr = byteArrayOutputStream.toByteArray();
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Throwable th4) {
                                        th = th4;
                                        th.printStackTrace();
                                        kk.a(this.d, bArr);
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    iw.c(th, "stm", "aStB");
                                    bArr = bArr2;
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                            bArr = bArr2;
                                        } catch (Throwable th6) {
                                            th = th6;
                                            bArr = bArr2;
                                            th.printStackTrace();
                                            kk.a(this.d, bArr);
                                        }
                                    }
                                    kk.a(this.d, bArr);
                                }
                            } catch (Throwable th7) {
                                byteArrayOutputStream = null;
                                th = th7;
                            }
                            kk.a(this.d, bArr);
                        }
                    }
                } catch (Throwable th8) {
                    iw.c(th8, "stm", "apb");
                }
            }
        }
    }

    public static void a(Context context) {
        lb.a().a(new a(context, a.f5281c));
    }

    static /* synthetic */ void a(Context context, byte[] bArr) throws IOException {
        ke a2 = kl.a(d);
        kl.a(context, a2, iu.h, 1000, 307200, "2");
        if (a2.e == null) {
            a2.e = new jk();
        }
        Random random = new Random();
        try {
            kf.a(Integer.toString(random.nextInt(100)) + Long.toString(System.nanoTime()), bArr, a2);
        } catch (Throwable th) {
            iw.c(th, "stm", "wts");
        }
    }

    public static void a(kj kjVar, Context context) {
        synchronized (kk.class) {
            try {
                lb.a().a(new a(context, a.f5280a, kjVar));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(List<kj> list, Context context) {
        synchronized (kk.class) {
            if (list != null) {
                try {
                    if (list.size() != 0) {
                        lb.a().a(new a(context, a.b, list));
                    }
                } catch (Throwable th) {
                }
            }
        }
    }

    public static void a(boolean z, int i) {
        synchronized (kk.class) {
            try {
                f5278a = z;
                e = Math.max(0, i);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void b(List<kj> list, Context context) {
        synchronized (kk.class) {
            try {
                List<kj> b2 = jx.b();
                if (b2 != null && b2.size() > 0) {
                    list.addAll(b2);
                }
            } catch (Throwable th) {
            }
            try {
                a(list, context);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}

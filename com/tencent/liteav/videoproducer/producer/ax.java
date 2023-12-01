package com.tencent.liteav.videoproducer.producer;

import android.content.Context;
import android.graphics.Rect;
import com.sina.weibo.sdk.constant.WBConstants;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/ax.class */
public final class ax {
    private static final com.tencent.liteav.base.util.n h = new com.tencent.liteav.base.util.n(360, 640);

    /* renamed from: a  reason: collision with root package name */
    CaptureSourceInterface.SourceType f23450a = CaptureSourceInterface.SourceType.NONE;
    VideoProducerDef.ProducerMode b = VideoProducerDef.ProducerMode.AUTO;

    /* renamed from: c  reason: collision with root package name */
    VideoProducerDef.HomeOrientation f23451c = VideoProducerDef.HomeOrientation.UNSET;
    GLConstants.Orientation d = null;
    GLConstants.Orientation e = null;
    private final com.tencent.liteav.base.util.n i = new com.tencent.liteav.base.util.n();
    final com.tencent.liteav.base.util.n f = new com.tencent.liteav.base.util.n();
    private final com.tencent.liteav.base.util.n j = new com.tencent.liteav.base.util.n();
    private final com.tencent.liteav.base.util.n k = new com.tencent.liteav.base.util.n();
    private final com.tencent.liteav.base.util.n l = new com.tencent.liteav.base.util.n();
    final com.tencent.liteav.base.util.n g = new com.tencent.liteav.base.util.n();
    private final com.tencent.liteav.base.util.n m = new com.tencent.liteav.base.util.n();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.liteav.videoproducer.producer.ax$1  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/ax$1.class */
    public static final /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23452a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[VideoProducerDef.ProducerMode.values().length];
            f23452a = iArr;
            try {
                iArr[VideoProducerDef.ProducerMode.PERFORMANCE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23452a[VideoProducerDef.ProducerMode.HIGH_QUALITY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f23452a[VideoProducerDef.ProducerMode.MANUAL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f23452a[VideoProducerDef.ProducerMode.AUTO.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public ax(Context context) {
        this.m.a(com.tencent.liteav.base.util.q.a(context));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
        if (r7 > 1.0d) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.tencent.liteav.base.util.n r6, double r7) {
        /*
            r0 = r7
            boolean r0 = java.lang.Double.isNaN(r0)
            if (r0 != 0) goto L5a
            r0 = r7
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto Le
            return
        Le:
            r0 = r6
            int r0 = r0.f22649a
            r1 = r6
            int r1 = r1.b
            if (r0 <= r1) goto L1f
            r0 = r7
            r1 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L34
        L1f:
            r0 = r7
            r9 = r0
            r0 = r6
            int r0 = r0.f22649a
            r1 = r6
            int r1 = r1.b
            if (r0 >= r1) goto L38
            r0 = r7
            r9 = r0
            r0 = r7
            r1 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L38
        L34:
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r1 = r7
            double r0 = r0 / r1
            r9 = r0
        L38:
            r0 = r6
            double r0 = r0.c()
            r1 = r9
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L4e
            r0 = r6
            r1 = r6
            int r1 = r1.f22649a
            double r1 = (double) r1
            r2 = r9
            double r1 = r1 / r2
            int r1 = (int) r1
            r0.b = r1
            return
        L4e:
            r0 = r6
            r1 = r6
            int r1 = r1.b
            double r1 = (double) r1
            r2 = r9
            double r1 = r1 * r2
            int r1 = (int) r1
            r0.f22649a = r1
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer.producer.ax.a(com.tencent.liteav.base.util.n, double):void");
    }

    private static void a(com.tencent.liteav.base.util.n nVar, com.tencent.liteav.base.util.n nVar2) {
        if (nVar.f22649a > 1920) {
            nVar2.a(nVar);
            return;
        }
        nVar2.f22649a = WBConstants.SDK_NEW_PAY_VERSION;
        nVar2.b = (nVar.b * nVar2.f22649a) / nVar.f22649a;
    }

    private static void b(com.tencent.liteav.base.util.n nVar, com.tencent.liteav.base.util.n nVar2) {
        if (nVar.f22649a > 1280) {
            nVar2.a(nVar);
            return;
        }
        nVar2.f22649a = 1280;
        nVar2.b = (nVar.b * nVar2.f22649a) / nVar.f22649a;
    }

    private static com.tencent.liteav.base.util.n c(com.tencent.liteav.base.util.n nVar, com.tencent.liteav.base.util.n nVar2) {
        com.tencent.liteav.base.util.n nVar3 = new com.tencent.liteav.base.util.n();
        if (nVar.f22649a <= 0 || nVar.b <= 0) {
            nVar3.a(nVar2);
            return nVar3;
        } else if (Math.abs(nVar2.c() - nVar.c()) < 0.001d) {
            nVar3.a(nVar2);
            return nVar3;
        } else if (nVar2.c() > nVar.c()) {
            nVar3.b = nVar2.b;
            nVar3.f22649a = (nVar.f22649a * nVar3.b) / nVar.b;
            return nVar3;
        } else {
            nVar3.f22649a = nVar2.f22649a;
            nVar3.b = (nVar.b * nVar3.f22649a) / nVar.f22649a;
            return nVar3;
        }
    }

    private com.tencent.liteav.base.util.n e() {
        com.tencent.liteav.base.util.n nVar = new com.tencent.liteav.base.util.n();
        com.tencent.liteav.base.util.n nVar2 = new com.tencent.liteav.base.util.n();
        if (this.j.f22649a <= 0 || this.j.b <= 0) {
            nVar2.a(h);
        } else {
            nVar2.a(this.j);
        }
        if (this.f23450a == CaptureSourceInterface.SourceType.CAMERA && this.j.f22649a > this.j.b) {
            nVar2.a();
        }
        boolean z = nVar2.b > nVar2.f22649a;
        if (z) {
            nVar2.a();
        }
        int i = AnonymousClass1.f23452a[this.b.ordinal()];
        if (i == 1) {
            nVar.a(nVar2);
        } else if (i != 2) {
            if (i != 3) {
                a(nVar2, nVar);
            } else if (this.i.f22649a <= 0 || this.i.b <= 0) {
                a(nVar2, nVar);
            } else {
                nVar.a(this.i);
                z = false;
            }
        } else if (nVar2.f22649a <= 1920) {
            nVar.f22649a = WBConstants.SDK_NEW_PAY_VERSION;
            nVar.b = (nVar2.b * nVar.f22649a) / nVar2.f22649a;
        } else {
            nVar.a(nVar2);
        }
        if (z) {
            nVar.a();
        }
        return nVar;
    }

    private com.tencent.liteav.base.util.n f() {
        com.tencent.liteav.base.util.n nVar = new com.tencent.liteav.base.util.n();
        com.tencent.liteav.base.util.n d = d();
        if (d.f22649a <= 0 || d.b <= 0) {
            d.a(h);
        }
        if (this.f23450a == CaptureSourceInterface.SourceType.CAMERA && this.e != null && d.f22649a > d.b) {
            d.a();
        }
        boolean z = d.b > d.f22649a;
        if (z) {
            d.a();
        }
        int i = AnonymousClass1.f23452a[this.b.ordinal()];
        if (i == 1) {
            nVar.a(d);
        } else if (i != 2) {
            if (i != 3) {
                b(d, nVar);
            } else {
                com.tencent.liteav.base.util.n nVar2 = new com.tencent.liteav.base.util.n();
                if (this.f.d()) {
                    nVar2 = new com.tencent.liteav.base.util.n(this.f);
                } else if (this.i.d()) {
                    nVar2 = new com.tencent.liteav.base.util.n(this.i);
                }
                if (nVar2.d()) {
                    if (z) {
                        nVar2.a();
                    }
                    nVar.a(c(d, nVar2));
                } else {
                    b(d, nVar);
                }
            }
        } else if (d.f22649a <= 1920) {
            nVar.f22649a = WBConstants.SDK_NEW_PAY_VERSION;
            nVar.b = (d.b * nVar.f22649a) / d.f22649a;
        } else {
            nVar.a(d);
        }
        if (z) {
            nVar.a();
        }
        nVar.f22649a = ((nVar.f22649a + 7) / 8) * 8;
        nVar.b = ((nVar.b + 7) / 8) * 8;
        return nVar;
    }

    public final VideoProducerDef.HomeOrientation a() {
        return this.f23450a == CaptureSourceInterface.SourceType.CAMERA ? this.f23451c : VideoProducerDef.HomeOrientation.UNSET;
    }

    public final void a(Rect rect) {
        if (rect == null) {
            this.k.a(0, 0);
            return;
        }
        LiteavLog.i("VideoResolutionSupervisor", "setExpectCaptureCropRect width=" + rect.width() + ",height=" + rect.height());
        this.k.a(rect.width(), rect.height());
    }

    public final void a(com.tencent.liteav.base.util.n nVar) {
        this.i.a(nVar);
        this.l.a(0, 0);
        this.g.a(0, 0);
    }

    public final void a(VideoProducerDef.ProducerMode producerMode) {
        if (producerMode != null) {
            this.b = producerMode;
        }
    }

    public final com.tencent.liteav.base.util.n b() {
        com.tencent.liteav.base.util.n e = e();
        if (e.f22649a > this.l.f22649a || e.b > this.l.b) {
            this.l.a(e);
        } else if (Math.abs(e.c() - this.l.c()) > 0.001d) {
            this.l.a(e);
        }
        e.a(this.l);
        return e;
    }

    public final void b(com.tencent.liteav.base.util.n nVar) {
        this.j.a(nVar);
    }

    public final com.tencent.liteav.base.util.n c() {
        com.tencent.liteav.base.util.n f = f();
        if (f.f22649a > this.g.f22649a || f.b > this.g.b) {
            this.g.a(f);
        } else if (Math.abs(f.c() - this.g.c()) > 0.001d) {
            this.g.a(f);
        }
        f.a(this.g);
        if (this.f23450a == CaptureSourceInterface.SourceType.CAMERA && (this.f23451c == VideoProducerDef.HomeOrientation.RIGHT || this.f23451c == VideoProducerDef.HomeOrientation.LEFT)) {
            f.a();
        }
        return f;
    }

    public final com.tencent.liteav.base.util.n d() {
        com.tencent.liteav.base.util.n nVar = new com.tencent.liteav.base.util.n();
        com.tencent.liteav.base.util.n nVar2 = this.j;
        if (nVar2 == null || nVar2.f22649a == 0 || this.j.b == 0) {
            LiteavLog.e("VideoResolutionSupervisor", "encode size is invalid.");
            return nVar;
        }
        nVar.a(this.j);
        if (this.f23450a == CaptureSourceInterface.SourceType.SCREEN) {
            double c2 = this.m.c();
            if (this.k.d()) {
                c2 = this.k.c();
            }
            a(nVar, c2);
            if (this.d != null) {
                boolean z = this.j.f22649a >= this.j.b;
                if ((!z && this.d == GLConstants.Orientation.LANDSCAPE) || (z && this.d == GLConstants.Orientation.PORTRAIT)) {
                    nVar.a();
                }
            }
        }
        nVar.f22649a = ((nVar.f22649a + 15) / 16) * 16;
        nVar.b = ((nVar.b + 15) / 16) * 16;
        return nVar;
    }
}

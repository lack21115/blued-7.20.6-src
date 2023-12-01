package com.tencent.liteav.videoproducer.preprocessor;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.e;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/h.class */
public final class h implements com.tencent.liteav.videobase.base.a {

    /* renamed from: a  reason: collision with root package name */
    final IVideoReporter f37065a;
    final BeautyProcessor e;
    com.tencent.liteav.videobase.b.e k;
    Object l;
    com.tencent.liteav.videobase.frame.j m;
    com.tencent.liteav.videobase.frame.e n;
    com.tencent.liteav.videobase.a.a o;
    com.tencent.liteav.videobase.videobase.e q;
    private final Context t;
    private final com.tencent.liteav.videobase.a.b[] u = new com.tencent.liteav.videobase.a.b[b.a().length];
    final com.tencent.liteav.videobase.utils.d d = new com.tencent.liteav.videobase.utils.d();
    final com.tencent.liteav.videobase.a.h f = new com.tencent.liteav.videobase.a.h();
    final com.tencent.liteav.base.b.a g = new com.tencent.liteav.base.b.a(TimeUnit.SECONDS.toMillis(1));
    CaptureSourceInterface.SourceType h = CaptureSourceInterface.SourceType.NONE;
    int i = 128;
    int j = 128;
    final com.tencent.liteav.videobase.videobase.e p = new com.tencent.liteav.videobase.videobase.e();
    final List<c> r = new ArrayList();
    final List<c> s = new ArrayList();
    private Boolean v = null;
    final FloatBuffer b = OpenGlUtils.createNormalCubeVerticesBuffer();

    /* renamed from: c  reason: collision with root package name */
    final FloatBuffer f37066c = OpenGlUtils.createTextureCoordsBuffer(Rotation.NORMAL, false, false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.liteav.videoproducer.preprocessor.h$1  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/h$1.class */
    public static final /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f37067a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0032 -> B:23:0x0013). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0036 -> B:21:0x001d). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003a -> B:19:0x0027). Please submit an issue!!! */
        static {
            int[] iArr = new int[b.a().length];
            f37067a = iArr;
            try {
                iArr[b.e - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f37067a[b.b - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f37067a[b.f37069c - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f37067a[b.d - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/h$a.class */
    public static final class a extends com.tencent.liteav.videobase.a.a {
        private final com.tencent.liteav.videobase.videobase.e b;

        public a(com.tencent.liteav.videobase.videobase.e eVar) {
            this.b = eVar;
        }

        @Override // com.tencent.liteav.videobase.a.a
        public final com.tencent.liteav.videobase.frame.d a(long j, com.tencent.liteav.videobase.frame.d dVar) {
            com.tencent.liteav.videobase.videobase.e eVar = this.b;
            if (eVar != null) {
                eVar.a(j, dVar);
            }
            return dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/h$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final int f37068a = 1;
        public static final int b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f37069c = 3;
        public static final int d = 4;
        public static final int e = 5;
        private static final /* synthetic */ int[] f = {1, 2, 3, 4, 5};

        public static int[] a() {
            return (int[]) f.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/h$c.class */
    public final class c implements e.a {

        /* renamed from: a  reason: collision with root package name */
        public int f37070a;
        public com.tencent.liteav.videobase.videobase.a b;

        /* renamed from: c  reason: collision with root package name */
        public GLConstants.PixelBufferType f37071c;
        public GLConstants.PixelFormatType d;
        public ag e;

        public c(int i, com.tencent.liteav.videobase.videobase.a aVar, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType, ag agVar) {
            this.f37070a = i;
            this.b = aVar;
            this.d = pixelFormatType;
            this.f37071c = pixelBufferType;
            this.e = agVar;
        }

        @Override // com.tencent.liteav.videobase.videobase.e.a
        public final void onFrameConverted(int i, PixelFrame pixelFrame) {
            if (this.e == null || h.this.k == null) {
                return;
            }
            this.e.a(i, pixelFrame);
            h hVar = h.this;
            try {
                if (hVar.k != null) {
                    hVar.k.a();
                }
            } catch (com.tencent.liteav.videobase.b.g e) {
                if (hVar.g.a()) {
                    LiteavLog.e("GPUPreprocessor", "makeCurrent failed. ", e.getMessage());
                }
            }
        }
    }

    public h(Context context, BeautyProcessor beautyProcessor, IVideoReporter iVideoReporter) {
        this.t = context.getApplicationContext();
        this.e = beautyProcessor;
        this.f37065a = iVideoReporter;
        this.e.setAIDetectListener(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c a(int i, ag agVar, List<c> list) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                return null;
            }
            c cVar = list.get(i3);
            if (cVar.f37070a == i && cVar.e == agVar) {
                list.remove(i3);
                return cVar;
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(c cVar, List<c> list) {
        for (c cVar2 : list) {
            if (cVar2.f37070a == cVar.f37070a && cVar2.e == cVar.e) {
                return;
            }
        }
        list.add(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <T> T a(int i) {
        com.tencent.liteav.videobase.a.b nVar;
        com.tencent.liteav.videobase.a.b[] bVarArr = this.u;
        int i2 = i - 1;
        if (bVarArr[i2] != null) {
            return (T) bVarArr[i2];
        }
        int i3 = AnonymousClass1.f37067a[i2];
        if (i3 == 1) {
            nVar = new com.tencent.liteav.beauty.b.n();
        } else if (i3 == 2) {
            nVar = new com.tencent.liteav.beauty.b.f(0.8f);
        } else if (i3 == 3) {
            nVar = new com.tencent.liteav.beauty.b.i();
        } else if (i3 != 4) {
            throw new RuntimeException("unknown filter type");
        } else {
            nVar = new com.tencent.liteav.beauty.b.h(this.t);
        }
        nVar.initialize(this.n);
        nVar.onOutputSizeChanged(this.i, this.j);
        this.u[i2] = nVar;
        b();
        return (T) nVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.p.a();
        com.tencent.liteav.videobase.videobase.e eVar = this.q;
        if (eVar != null) {
            eVar.a();
            this.q = null;
        }
        this.e.uninitialize();
        com.tencent.liteav.videobase.frame.e eVar2 = this.n;
        if (eVar2 != null) {
            eVar2.a();
            this.n.b();
            this.n = null;
        }
        com.tencent.liteav.videobase.frame.j jVar = this.m;
        if (jVar != null) {
            jVar.a();
            this.m = null;
        }
        this.f.uninitialize();
        com.tencent.liteav.videobase.b.e.a(this.k);
        this.k = null;
        LiteavLog.i("GPUPreprocessor", "uninitialize opengl components");
    }

    public final void a(float f, Bitmap bitmap, float f2, Bitmap bitmap2, float f3) {
        this.d.a(n.a(this, bitmap, bitmap2, f, f2, f3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <T> T b(int i) {
        return (T) this.u[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        this.f.removeAllFilterAndInterceptor();
        this.f.uninitialize();
        c();
        int[] a2 = b.a();
        int length = a2.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                this.f.addInterceptor(new a(this.p));
                this.f.initialize(this.n);
                this.f.onOutputSizeChanged(this.i, this.j);
                return;
            }
            int i3 = a2[i2];
            if (i3 == b.e) {
                this.f.addInterceptor(this.o);
                this.f.addInterceptor(new a(this.q));
            }
            if (i3 == b.f37068a) {
                this.f.addFilter(this.e);
            } else {
                this.f.addFilter(this.u[i3 - 1]);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        if (this.k == null) {
            return;
        }
        if (this.u[b.e - 1] != null) {
            if (this.q == null) {
                com.tencent.liteav.videobase.videobase.e eVar = new com.tencent.liteav.videobase.videobase.e();
                this.q = eVar;
                eVar.a(this.n);
            }
            for (c cVar : this.r) {
                this.p.a(cVar.f37070a, cVar);
                this.q.a(cVar.b, cVar.f37071c, cVar.d, cVar.f37070a, cVar);
            }
        } else {
            for (c cVar2 : this.r) {
                com.tencent.liteav.videobase.videobase.e eVar2 = this.q;
                if (eVar2 != null) {
                    eVar2.a(cVar2.f37070a, cVar2);
                }
                this.p.a(cVar2.b, cVar2.f37071c, cVar2.d, cVar2.f37070a, cVar2);
            }
            com.tencent.liteav.videobase.videobase.e eVar3 = this.q;
            if (eVar3 != null) {
                eVar3.a();
                this.q = null;
            }
        }
        for (c cVar3 : this.s) {
            this.p.a(cVar3.b, cVar3.f37071c, cVar3.d, cVar3.f37070a, cVar3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(int i) {
        com.tencent.liteav.videobase.a.b bVar;
        com.tencent.liteav.videobase.a.b[] bVarArr = this.u;
        int i2 = i - 1;
        if (bVarArr[i2] == null || (bVar = bVarArr[i2]) == null) {
            return;
        }
        bVarArr[i2] = null;
        bVar.uninitialize();
        b();
    }
}

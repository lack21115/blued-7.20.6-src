package com.tencent.liteav.videobase.frame;

import android.opengl.GLES20;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.Rotation;
import com.uc.crashsdk.export.LogType;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/frame/j.class */
public final class j {

    /* renamed from: c  reason: collision with root package name */
    private static final float[] f36642c = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private static final float[] d = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    private static final float[] e = {1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};
    private static final float[] f = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: a  reason: collision with root package name */
    public final int f36643a;
    public final int b;
    private GLConstants.GLScaleType j;
    private c n;
    private final com.tencent.liteav.videobase.a.b[] i = new com.tencent.liteav.videobase.a.b[GLConstants.PixelFormatType.values().length];
    private PixelFrame k = null;
    private com.tencent.liteav.videobase.c.a l = null;
    private com.tencent.liteav.videobase.a.b m = null;
    private final FloatBuffer g = ByteBuffer.allocateDirect(GLConstants.f36598c.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(GLConstants.f36598c);
    private final FloatBuffer h = OpenGlUtils.createTextureCoordsBuffer(Rotation.NORMAL, false, false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.liteav.videobase.frame.j$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/frame/j$1.class */
    public static final /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f36644a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[Rotation.values().length];
            f36644a = iArr;
            try {
                iArr[Rotation.ROTATION_90.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f36644a[Rotation.ROTATION_180.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f36644a[Rotation.ROTATION_270.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f36644a[Rotation.NORMAL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public j(int i, int i2) {
        this.f36643a = i;
        this.b = i2;
    }

    private static float a(float f2) {
        return f2 == 0.0f ? 1.0f : 0.0f;
    }

    private static float a(float f2, float f3) {
        return f2 == 0.0f ? f3 : 1.0f - f3;
    }

    private void a(GLConstants.PixelFormatType pixelFormatType, d dVar, ByteBuffer byteBuffer) {
        int ordinal = pixelFormatType.ordinal();
        if (this.i[ordinal] == null) {
            if (pixelFormatType == GLConstants.PixelFormatType.I420) {
                this.i[ordinal] = new com.tencent.liteav.videobase.d.a();
            } else if (pixelFormatType == GLConstants.PixelFormatType.NV21) {
                this.i[ordinal] = new com.tencent.liteav.videobase.d.d();
            } else {
                this.i[ordinal] = new com.tencent.liteav.videobase.d.c();
            }
            this.i[ordinal].initialize(null);
            this.i[ordinal].onOutputSizeChanged(this.f36643a, this.b);
        }
        com.tencent.liteav.videobase.d.i iVar = (com.tencent.liteav.videobase.d.i) this.i[ordinal];
        OpenGlUtils.glViewport(0, 0, this.f36643a, this.b);
        if (this.k.getRotation() == Rotation.ROTATION_90 || this.k.getRotation() == Rotation.ROTATION_270) {
            iVar.a(byteBuffer, this.k.getHeight(), this.k.getWidth());
        } else {
            iVar.a(byteBuffer, this.k.getWidth(), this.k.getHeight());
        }
        iVar.onDraw(-1, dVar, this.g, this.h);
    }

    private void a(d dVar) {
        if (this.n == null) {
            c cVar = new c();
            this.n = cVar;
            cVar.a();
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        if (dVar == null) {
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glClear(LogType.UNEXP_RESTART);
            return;
        }
        this.n.a(dVar.a());
        this.n.b();
        GLES20.glClear(LogType.UNEXP_RESTART);
        OpenGlUtils.bindFramebuffer(36160, 0);
        this.n.c();
    }

    private void a(d dVar, int i) {
        c();
        OpenGlUtils.glViewport(0, 0, this.f36643a, this.b);
        this.m.onDraw(i, dVar, this.g, this.h);
    }

    private void a(d dVar, int i, float[] fArr) {
        if (this.l == null) {
            com.tencent.liteav.videobase.c.a aVar = new com.tencent.liteav.videobase.c.a();
            this.l = aVar;
            aVar.initialize(null);
            this.l.onOutputSizeChanged(this.f36643a, this.b);
        }
        OpenGlUtils.glViewport(0, 0, this.f36643a, this.b);
        this.l.setTexutreTransform(fArr);
        this.l.onDraw(i, dVar, this.g, this.h);
    }

    private void a(d dVar, Buffer buffer) {
        int ordinal = GLConstants.PixelFormatType.RGBA.ordinal();
        com.tencent.liteav.videobase.a.b[] bVarArr = this.i;
        if (bVarArr[ordinal] == null) {
            bVarArr[ordinal] = new com.tencent.liteav.videobase.c.b();
            this.i[ordinal].initialize(null);
            this.i[ordinal].onOutputSizeChanged(this.f36643a, this.b);
        }
        com.tencent.liteav.videobase.c.b bVar = (com.tencent.liteav.videobase.c.b) this.i[ordinal];
        OpenGlUtils.glViewport(0, 0, this.f36643a, this.b);
        if (this.k.getRotation() == Rotation.ROTATION_90 || this.k.getRotation() == Rotation.ROTATION_270) {
            bVar.a(buffer, this.k.getHeight(), this.k.getWidth());
        } else {
            bVar.a(buffer, this.k.getWidth(), this.k.getHeight());
        }
        bVar.onDraw(-1, dVar, this.g, this.h);
    }

    private static void a(float[] fArr, Rotation rotation, boolean z, boolean z2) {
        float[] fArr2 = f36642c;
        if (rotation != null) {
            int i = AnonymousClass1.f36644a[rotation.ordinal()];
            fArr2 = i != 1 ? i != 2 ? i != 3 ? f36642c : e : f : d;
        }
        System.arraycopy((Object) fArr2, 0, (Object) fArr, 0, fArr2.length);
        if (z) {
            fArr[0] = a(fArr[0]);
            fArr[2] = a(fArr[2]);
            fArr[4] = a(fArr[4]);
            fArr[6] = a(fArr[6]);
        }
        if (z2) {
            fArr[1] = a(fArr[1]);
            fArr[3] = a(fArr[3]);
            fArr[5] = a(fArr[5]);
            fArr[7] = a(fArr[7]);
        }
    }

    private boolean a(PixelFrame pixelFrame, GLConstants.GLScaleType gLScaleType) {
        return (gLScaleType == this.j && pixelFrame.getWidth() == this.k.getWidth() && pixelFrame.getHeight() == this.k.getHeight() && pixelFrame.getPixelBufferType() == this.k.getPixelBufferType() && pixelFrame.getPixelFormatType() == this.k.getPixelFormatType() && pixelFrame.isMirrorHorizontal() == this.k.isMirrorHorizontal() && pixelFrame.isMirrorVertical() == this.k.isMirrorVertical() && pixelFrame.getRotation() == this.k.getRotation()) ? false : true;
    }

    private void b() {
        float f2;
        float f3;
        float[] fArr;
        boolean z = this.k.getRotation() == Rotation.ROTATION_90 || this.k.getRotation() == Rotation.ROTATION_270;
        float max = Math.max((this.f36643a * 1.0f) / this.k.getWidth(), (this.b * 1.0f) / this.k.getHeight());
        float round = (Math.round(f2 * max) * 1.0f) / this.f36643a;
        float round2 = (Math.round(f3 * max) * 1.0f) / this.b;
        float[] fArr2 = GLConstants.f36598c;
        float[] fArr3 = new float[8];
        if (this.k.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_OES) {
            a(fArr3, this.k.getRotation(), this.k.isMirrorHorizontal(), this.k.isMirrorVertical());
        } else {
            OpenGlUtils.initTextureCoordsBuffer(fArr3, this.k.getRotation(), this.k.isMirrorHorizontal(), this.k.isMirrorVertical());
        }
        if (this.j == GLConstants.GLScaleType.CENTER_CROP) {
            float f4 = (1.0f - (z ? 1.0f / round2 : 1.0f / round)) / 2.0f;
            float f5 = (1.0f - (z ? 1.0f / round : 1.0f / round2)) / 2.0f;
            fArr3[0] = a(fArr3[0], f4);
            fArr3[1] = a(fArr3[1], f5);
            fArr3[2] = a(fArr3[2], f4);
            fArr3[3] = a(fArr3[3], f5);
            fArr3[4] = a(fArr3[4], f4);
            fArr3[5] = a(fArr3[5], f5);
            fArr3[6] = a(fArr3[6], f4);
            fArr3[7] = a(fArr3[7], f5);
            fArr = fArr2;
        } else {
            fArr = fArr2;
            if (this.j == GLConstants.GLScaleType.FIT_CENTER) {
                fArr = new float[]{fArr2[0] / round2, fArr2[1] / round, fArr2[2] / round2, fArr2[3] / round, fArr2[4] / round2, fArr2[5] / round, fArr2[6] / round2, fArr2[7] / round};
            }
        }
        this.g.clear();
        this.g.put(fArr).position(0);
        this.h.clear();
        this.h.put(fArr3).position(0);
    }

    private void c() {
        if (this.m != null) {
            return;
        }
        com.tencent.liteav.videobase.a.b bVar = new com.tencent.liteav.videobase.a.b();
        this.m = bVar;
        bVar.initialize(null);
        this.m.onOutputSizeChanged(this.f36643a, this.b);
    }

    private void d() {
        com.tencent.liteav.videobase.c.a aVar = this.l;
        if (aVar != null) {
            aVar.uninitialize();
            this.l = null;
        }
        com.tencent.liteav.videobase.a.b bVar = this.m;
        if (bVar != null) {
            bVar.uninitialize();
            this.m = null;
        }
        c cVar = this.n;
        if (cVar != null) {
            cVar.d();
            this.n = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            com.tencent.liteav.videobase.a.b[] bVarArr = this.i;
            if (i2 >= bVarArr.length) {
                LiteavLog.i("PixelFrameRenderer", "uninitialize GL components");
                return;
            }
            if (bVarArr[i2] != null) {
                bVarArr[i2].uninitialize();
                this.i[i2] = null;
            }
            i = i2 + 1;
        }
    }

    public final void a() {
        this.k = null;
        d();
    }

    public final void a(PixelFrame pixelFrame, GLConstants.GLScaleType gLScaleType, d dVar) {
        if (pixelFrame == null || !pixelFrame.isFrameDataValid()) {
            LiteavLog.w("PixelFrameRenderer", "renderFrame: pixelFrame is not valid");
            return;
        }
        if (this.k == null || a(pixelFrame, gLScaleType)) {
            this.j = gLScaleType;
            this.k = new PixelFrame(pixelFrame);
            d();
            b();
        }
        if (gLScaleType == GLConstants.GLScaleType.FIT_CENTER) {
            a(dVar);
        }
        if (this.k.getPixelBufferType() == GLConstants.PixelBufferType.BYTE_BUFFER) {
            if (this.k.getPixelFormatType() != GLConstants.PixelFormatType.RGBA) {
                a(this.k.getPixelFormatType(), dVar, pixelFrame.getBuffer());
            } else {
                a(dVar, pixelFrame.getBuffer());
            }
        } else if (this.k.getPixelBufferType() == GLConstants.PixelBufferType.BYTE_ARRAY) {
            if (this.k.getPixelFormatType() != GLConstants.PixelFormatType.RGBA) {
                a(this.k.getPixelFormatType(), dVar, ByteBuffer.wrap(pixelFrame.getData()));
            } else {
                a(dVar, ByteBuffer.wrap(pixelFrame.getData()));
            }
        } else if (this.k.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_OES) {
            a(dVar, pixelFrame.getTextureId(), pixelFrame.getMatrix());
        } else if (this.k.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_2D) {
            a(dVar, pixelFrame.getTextureId());
        }
    }
}

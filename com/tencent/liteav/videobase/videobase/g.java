package com.tencent.liteav.videobase.videobase;

import android.opengl.GLES20;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.frame.j;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.liteav.videobase.utils.YUVReadTools;
import com.tencent.liteav.videobase.videobase.e;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/videobase/g.class */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    static final GLConstants.PixelFormatType[] f36674a = {GLConstants.PixelFormatType.I420, GLConstants.PixelFormatType.NV21, GLConstants.PixelFormatType.NV12};
    final com.tencent.liteav.videobase.videobase.a d;
    j g;
    com.tencent.liteav.videobase.frame.i i;
    com.tencent.liteav.videobase.frame.e j;
    private int k = -1;
    boolean h = false;
    final FloatBuffer b = OpenGlUtils.createNormalCubeVerticesBuffer();

    /* renamed from: c  reason: collision with root package name */
    final FloatBuffer f36675c = OpenGlUtils.createTextureCoordsBuffer(Rotation.NORMAL, false, false);
    final Map<GLConstants.PixelFormatType, List<a>> e = new HashMap();
    final Map<GLConstants.PixelFormatType, com.tencent.liteav.videobase.a.b> f = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.liteav.videobase.videobase.g$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/videobase/g$1.class */
    public static final /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f36676a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[GLConstants.PixelFormatType.values().length];
            f36676a = iArr;
            try {
                iArr[GLConstants.PixelFormatType.I420.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f36676a[GLConstants.PixelFormatType.NV12.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f36676a[GLConstants.PixelFormatType.NV21.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/videobase/g$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final GLConstants.PixelBufferType f36677a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final e.a f36678c;

        public a(GLConstants.PixelBufferType pixelBufferType, int i, e.a aVar) {
            this.f36677a = pixelBufferType;
            this.b = i;
            this.f36678c = aVar;
        }
    }

    public g(com.tencent.liteav.videobase.videobase.a aVar) {
        this.d = aVar;
    }

    private void a(GLConstants.PixelFormatType pixelFormatType, com.tencent.liteav.videobase.frame.d dVar, Object obj) {
        int i = this.d.f36668a;
        int i2 = this.d.b;
        if (this.k == -1) {
            this.k = OpenGlUtils.generateFrameBufferId();
        }
        OpenGlUtils.attachTextureToFrameBuffer(dVar.a(), this.k);
        GLES20.glBindFramebuffer(36160, this.k);
        if (pixelFormatType == GLConstants.PixelFormatType.RGBA) {
            OpenGlUtils.readPixels(0, 0, i, i2, obj);
            OpenGlUtils.detachTextureFromFrameBuffer(this.k);
            return;
        }
        if (i2 % 16 == 0) {
            OpenGlUtils.readPixels(0, 0, i, (i2 * 3) / 8, obj);
        } else if (obj instanceof ByteBuffer) {
            YUVReadTools.nativeReadYUVPlanesForByteBuffer(i, i2, (ByteBuffer) obj);
        } else {
            YUVReadTools.nativeReadYUVPlanesForByteArray(i, i2, (byte[]) obj);
        }
        OpenGlUtils.detachTextureFromFrameBuffer(this.k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a(GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType) {
        List<a> list = this.e.get(pixelFormatType);
        int i = 0;
        int i2 = 0;
        if (list != null) {
            Iterator<a> it = list.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                } else if (it.next().f36677a == pixelBufferType) {
                    i2++;
                }
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PixelFrame a(long j, com.tencent.liteav.videobase.frame.d dVar, GLConstants.PixelFormatType pixelFormatType) {
        PixelFrame pixelFrame;
        int a2 = a(pixelFormatType, GLConstants.PixelBufferType.BYTE_BUFFER);
        int a3 = a(pixelFormatType, GLConstants.PixelBufferType.BYTE_ARRAY);
        if (a2 == 0 && a3 == 0) {
            return null;
        }
        if (a2 != 0) {
            PixelFrame a4 = this.i.a(dVar.b(), dVar.c(), GLConstants.PixelBufferType.BYTE_BUFFER, pixelFormatType);
            a(pixelFormatType, dVar, a4.getBuffer());
            pixelFrame = a4;
        } else {
            PixelFrame a5 = this.i.a(dVar.b(), dVar.c(), GLConstants.PixelBufferType.BYTE_ARRAY, pixelFormatType);
            a(pixelFormatType, dVar, a5.getData());
            pixelFrame = a5;
        }
        a(pixelFrame, j);
        a(j, pixelFrame, a2, a3);
        return pixelFrame;
    }

    public final void a() {
        for (com.tencent.liteav.videobase.a.b bVar : this.f.values()) {
            bVar.uninitialize();
        }
        this.f.clear();
        j jVar = this.g;
        if (jVar != null) {
            jVar.a();
            this.g = null;
        }
        com.tencent.liteav.videobase.frame.i iVar = this.i;
        if (iVar != null) {
            iVar.b();
            this.i = null;
        }
        OpenGlUtils.deleteFrameBuffer(this.k);
        this.k = -1;
        this.h = false;
    }

    public final void a(int i, e.a aVar) {
        for (Map.Entry<GLConstants.PixelFormatType, List<a>> entry : this.e.entrySet()) {
            Iterator<a> it = entry.getValue().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next.b == i && next.f36678c == aVar) {
                    entry.getValue().remove(next);
                    break;
                }
            }
            if (entry.getValue().isEmpty()) {
                this.e.remove(entry.getKey());
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(long j, PixelFrame pixelFrame, int i, int i2) {
        if (pixelFrame.getPixelBufferType() == GLConstants.PixelBufferType.BYTE_BUFFER) {
            if (i2 != 0) {
                PixelFrame a2 = this.i.a(pixelFrame.getWidth(), pixelFrame.getHeight(), GLConstants.PixelBufferType.BYTE_ARRAY, pixelFrame.getPixelFormatType());
                OpenGlUtils.nativeCopyDataFromByteBufferToByteArray(pixelFrame.getBuffer(), a2.getData(), a2.getData().length);
                a(a2, j);
                a2.release();
            }
        } else if (pixelFrame.getPixelBufferType() != GLConstants.PixelBufferType.BYTE_ARRAY || i == 0) {
        } else {
            PixelFrame a3 = this.i.a(pixelFrame.getWidth(), pixelFrame.getHeight(), GLConstants.PixelBufferType.BYTE_BUFFER, pixelFrame.getPixelFormatType());
            OpenGlUtils.nativeCopyDataFromByteArrayToByteBuffer(pixelFrame.getData(), a3.getBuffer(), pixelFrame.getData().length);
            a(a3, j);
            a3.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(PixelFrame pixelFrame, long j) {
        List<a> list = this.e.get(pixelFrame.getPixelFormatType());
        if (list == null || list.isEmpty()) {
            return;
        }
        pixelFrame.setTimestamp(j);
        for (a aVar : list) {
            if (aVar.f36677a == pixelFrame.getPixelBufferType()) {
                aVar.f36678c.onFrameConverted(aVar.b, pixelFrame);
            }
        }
    }

    public final void a(com.tencent.liteav.videobase.frame.e eVar) {
        if (!this.h && eVar != null) {
            this.h = true;
            this.i = new com.tencent.liteav.videobase.frame.i();
            this.j = eVar;
            return;
        }
        LiteavLog.i("SameParamsConverter", "SameParamsConverter mIsInitialized " + this.h + " , texturePool " + eVar);
    }
}

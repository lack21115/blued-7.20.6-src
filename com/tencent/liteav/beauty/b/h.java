package com.tencent.liteav.beauty.b;

import android.content.Context;
import com.tencent.liteav.beauty.a.a;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.PixelFrame;
import java.nio.FloatBuffer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/b/h.class */
public final class h extends com.tencent.liteav.videobase.a.b {

    /* renamed from: a  reason: collision with root package name */
    public GLConstants.GLScaleType f22692a;
    public boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f22693c;
    private com.tencent.liteav.videobase.frame.j e;
    private d f;
    private com.tencent.liteav.beauty.a.a h;
    private final PixelFrame d = new PixelFrame();
    private boolean g = false;
    private a i = null;
    private a.InterfaceC0757a j = new a.InterfaceC0757a() { // from class: com.tencent.liteav.beauty.b.h.1
    };

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/b/h$a.class */
    public interface a {
    }

    public h(Context context) {
        this.f22693c = context;
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onDraw(int i, com.tencent.liteav.videobase.frame.d dVar, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        int a2;
        if (isInitialized()) {
            runPendingOnDrawTasks();
            if (this.d.getTextureId() == -1) {
                super.onDraw(i, dVar, floatBuffer, floatBuffer2);
                return;
            }
            com.tencent.liteav.videobase.frame.d a3 = this.mTexturePool.a(this.mOutputSize.f22649a, this.mOutputSize.b);
            if (this.e == null) {
                this.e = new com.tencent.liteav.videobase.frame.j(this.mOutputSize.f22649a, this.mOutputSize.b);
            }
            if (!this.d.hasTransformParams() && this.d.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_2D && this.d.getPixelFormatType() == GLConstants.PixelFormatType.RGBA) {
                a2 = this.d.getTextureId();
            } else {
                this.e.a(this.d, this.f22692a, a3);
                a2 = a3.a();
            }
            d dVar2 = this.f;
            dVar2.setFloatOnDraw(dVar2.f22683a, this.b ? 1.0f : 0.0f);
            this.f.setSecondInputTexture(i);
            this.f.setInputTexture(com.tencent.liteav.videobase.a.j.THIRD_INPUT_SAMPLE2D_NAME, a2);
            this.f.onDraw(i, dVar, floatBuffer, floatBuffer2);
            a3.release();
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(eVar);
        d dVar = new d();
        this.f = dVar;
        dVar.initialize(eVar);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
        this.f.onOutputSizeChanged(i, i2);
        com.tencent.liteav.videobase.frame.j jVar = this.e;
        if (jVar != null) {
            jVar.a();
            this.e = null;
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onUninit() {
        com.tencent.liteav.beauty.a.a aVar = this.h;
        if (aVar != null) {
            aVar.f22660c = null;
            com.tencent.liteav.beauty.a.a aVar2 = this.h;
            aVar2.b = true;
            if (aVar2.f22659a != null) {
                aVar2.f22659a.interrupt();
                aVar2.f22659a = null;
            }
            this.h = null;
        }
        d dVar = this.f;
        if (dVar != null) {
            dVar.uninitialize();
            this.f = null;
        }
        com.tencent.liteav.videobase.frame.j jVar = this.e;
        if (jVar != null) {
            jVar.a();
            this.e = null;
        }
        super.onUninit();
    }
}

package com.tencent.liteav.videobase.frame;

import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.a;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/frame/e.class */
public final class e extends com.tencent.liteav.videobase.frame.a<d> {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f36631a = new AtomicInteger();

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/frame/e$a.class */
    public static final class a extends d {

        /* renamed from: a  reason: collision with root package name */
        int f36632a;
        final int b;

        /* renamed from: c  reason: collision with root package name */
        final int f36633c;

        private a(g<d> gVar, int i, int i2) {
            super(gVar);
            this.f36632a = -1;
            this.b = i;
            this.f36633c = i2;
        }

        /* synthetic */ a(g gVar, int i, int i2, byte b) {
            this(gVar, i, i2);
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final int a() {
            return this.f36632a;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final PixelFrame a(Object obj) {
            b bVar = new b(this, obj, (byte) 0);
            bVar.retain();
            return bVar;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final int b() {
            return this.b;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final int c() {
            return this.f36633c;
        }

        @Override // com.tencent.liteav.videobase.frame.k
        public final void release() {
            super.release();
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/frame/e$b.class */
    public static final class b extends PixelFrame {
        private static final g<b> b = f.a();

        /* renamed from: a  reason: collision with root package name */
        public final d f36634a;

        private b(d dVar, Object obj) {
            super(b);
            dVar.retain();
            this.mWidth = dVar.b();
            this.mHeight = dVar.c();
            this.f36634a = dVar;
            this.mTextureId = dVar.a();
            this.mGLContext = obj;
            this.mPixelBufferType = GLConstants.PixelBufferType.TEXTURE_2D;
            this.mPixelFormatType = GLConstants.PixelFormatType.RGBA;
        }

        /* synthetic */ b(d dVar, Object obj, byte b2) {
            this(dVar, obj);
        }

        @Override // com.tencent.liteav.videobase.frame.PixelFrame
        public final void setTextureId(int i) {
            throw new UnsupportedOperationException("Object is allocated by pool, can't change its Buffer");
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/frame/e$c.class */
    static final class c implements a.InterfaceC0936a {

        /* renamed from: a  reason: collision with root package name */
        final int f36635a;
        final int b;

        public c(int i, int i2) {
            this.f36635a = i;
            this.b = i2;
        }

        public final boolean equals(Object obj) {
            if (obj.getClass() != getClass()) {
                return false;
            }
            c cVar = (c) obj;
            return this.f36635a == cVar.f36635a && this.b == cVar.b;
        }

        public final int hashCode() {
            return (this.f36635a * 37213) + this.b;
        }
    }

    public final d a(int i, int i2) {
        return (d) super.a(new c(i, i2));
    }

    @Override // com.tencent.liteav.videobase.frame.a
    protected final /* synthetic */ d a(g<d> gVar, a.InterfaceC0936a interfaceC0936a) {
        c cVar = (c) interfaceC0936a;
        a aVar = new a(gVar, cVar.f36635a, cVar.b, (byte) 0);
        aVar.f36632a = OpenGlUtils.createTexture(aVar.b, aVar.f36633c, 6408, 6408);
        f36631a.incrementAndGet();
        return aVar;
    }

    @Override // com.tencent.liteav.videobase.frame.a
    public final void a() {
        super.a();
    }

    @Override // com.tencent.liteav.videobase.frame.a
    protected final /* synthetic */ void a(d dVar) {
        a aVar = (a) dVar;
        OpenGlUtils.deleteTexture(aVar.f36632a);
        aVar.f36632a = -1;
        f36631a.getAndDecrement();
    }

    @Override // com.tencent.liteav.videobase.frame.a
    protected final /* synthetic */ a.InterfaceC0936a b(d dVar) {
        d dVar2 = dVar;
        return new c(dVar2.b(), dVar2.c());
    }

    @Override // com.tencent.liteav.videobase.frame.a
    public final void b() {
        super.b();
    }
}

package com.tencent.liteav.videobase.frame;

import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.a;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/frame/e.class */
public final class e extends com.tencent.liteav.videobase.frame.a<d> {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f22940a = new AtomicInteger();

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/frame/e$a.class */
    public static final class a extends d {

        /* renamed from: a  reason: collision with root package name */
        int f22941a;
        final int b;

        /* renamed from: c  reason: collision with root package name */
        final int f22942c;

        private a(g<d> gVar, int i, int i2) {
            super(gVar);
            this.f22941a = -1;
            this.b = i;
            this.f22942c = i2;
        }

        /* synthetic */ a(g gVar, int i, int i2, byte b) {
            this(gVar, i, i2);
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final int a() {
            return this.f22941a;
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
            return this.f22942c;
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
        public final d f22943a;

        private b(d dVar, Object obj) {
            super(b);
            dVar.retain();
            this.mWidth = dVar.b();
            this.mHeight = dVar.c();
            this.f22943a = dVar;
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
    static final class c implements a.InterfaceC0766a {

        /* renamed from: a  reason: collision with root package name */
        final int f22944a;
        final int b;

        public c(int i, int i2) {
            this.f22944a = i;
            this.b = i2;
        }

        public final boolean equals(Object obj) {
            if (obj.getClass() != getClass()) {
                return false;
            }
            c cVar = (c) obj;
            return this.f22944a == cVar.f22944a && this.b == cVar.b;
        }

        public final int hashCode() {
            return (this.f22944a * 37213) + this.b;
        }
    }

    public final d a(int i, int i2) {
        return (d) super.a(new c(i, i2));
    }

    @Override // com.tencent.liteav.videobase.frame.a
    protected final /* synthetic */ d a(g<d> gVar, a.InterfaceC0766a interfaceC0766a) {
        c cVar = (c) interfaceC0766a;
        a aVar = new a(gVar, cVar.f22944a, cVar.b, (byte) 0);
        aVar.f22941a = OpenGlUtils.createTexture(aVar.b, aVar.f22942c, 6408, 6408);
        f22940a.incrementAndGet();
        return aVar;
    }

    @Override // com.tencent.liteav.videobase.frame.a
    public final void a() {
        super.a();
    }

    @Override // com.tencent.liteav.videobase.frame.a
    protected final /* synthetic */ void a(d dVar) {
        a aVar = (a) dVar;
        OpenGlUtils.deleteTexture(aVar.f22941a);
        aVar.f22941a = -1;
        f22940a.getAndDecrement();
    }

    @Override // com.tencent.liteav.videobase.frame.a
    protected final /* synthetic */ a.InterfaceC0766a b(d dVar) {
        d dVar2 = dVar;
        return new c(dVar2.b(), dVar2.c());
    }

    @Override // com.tencent.liteav.videobase.frame.a
    public final void b() {
        super.b();
    }
}

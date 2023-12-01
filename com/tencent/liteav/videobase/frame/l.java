package com.tencent.liteav.videobase.frame;

import com.tencent.liteav.videobase.base.GLConstants;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/frame/l.class */
public final class l extends h<b> {

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/frame/l$a.class */
    static final class a extends PixelFrame {
        private static final g<a> b = m.a();

        /* renamed from: a  reason: collision with root package name */
        private final b f36645a;

        private a(b bVar, Object obj) {
            super(b);
            bVar.retain();
            this.mWidth = bVar.f36647c;
            this.mHeight = bVar.d;
            this.f36645a = bVar;
            this.mTextureId = bVar.f36646a;
            this.mGLContext = obj;
            if (bVar.b == 3553) {
                this.mPixelBufferType = GLConstants.PixelBufferType.TEXTURE_2D;
            } else if (bVar.b == 36197) {
                this.mPixelBufferType = GLConstants.PixelBufferType.TEXTURE_OES;
            }
            this.mPixelFormatType = GLConstants.PixelFormatType.RGBA;
        }

        /* synthetic */ a(b bVar, Object obj, byte b2) {
            this(bVar, obj);
        }

        @Override // com.tencent.liteav.videobase.frame.PixelFrame
        public final void setTextureId(int i) {
            throw new UnsupportedOperationException("Object is allocated by pool, can't change its Buffer");
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/frame/l$b.class */
    public static final class b extends d {

        /* renamed from: a  reason: collision with root package name */
        int f36646a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        int f36647c;
        int d;

        public b(g<? extends d> gVar) {
            super(gVar);
            this.f36646a = -1;
            this.b = 3553;
            this.f36647c = 0;
            this.d = 0;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final int a() {
            return this.f36646a;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final PixelFrame a(Object obj) {
            a aVar = new a(this, obj, (byte) 0);
            aVar.retain();
            return aVar;
        }

        public final void a(int i, int i2, int i3, int i4) {
            this.b = i;
            this.f36646a = i2;
            this.f36647c = i3;
            this.d = i4;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final int b() {
            return this.f36647c;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final int c() {
            return this.d;
        }
    }

    @Override // com.tencent.liteav.videobase.frame.h
    protected final /* synthetic */ b a(g<b> gVar) {
        return new b(gVar);
    }
}

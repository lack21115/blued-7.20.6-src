package com.tencent.liteav.videobase.frame;

import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.a;
import java.nio.ByteBuffer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/frame/i.class */
public final class i extends com.tencent.liteav.videobase.frame.a<PixelFrame> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/frame/i$a.class */
    public static final class a implements a.InterfaceC0936a {

        /* renamed from: a  reason: collision with root package name */
        final int f36640a;
        final int b;

        /* renamed from: c  reason: collision with root package name */
        final GLConstants.PixelBufferType f36641c;
        final GLConstants.PixelFormatType d;

        public a(int i, int i2, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType) {
            this.f36640a = i;
            this.b = i2;
            this.f36641c = pixelBufferType;
            this.d = pixelFormatType;
        }

        public final boolean equals(Object obj) {
            if (getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f36640a == aVar.f36640a && this.b == aVar.b && this.f36641c == aVar.f36641c && this.d == aVar.d;
        }

        public final int hashCode() {
            return (((((this.f36640a * 10001) + this.b) << 2) + this.f36641c.ordinal()) << 2) + this.d.ordinal();
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/frame/i$b.class */
    static final class b extends PixelFrame {
        private b(g<PixelFrame> gVar, int i, int i2, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType) {
            super(gVar, i, i2, pixelBufferType, pixelFormatType);
        }

        /* synthetic */ b(g gVar, int i, int i2, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType, byte b) {
            this(gVar, i, i2, pixelBufferType, pixelFormatType);
        }

        @Override // com.tencent.liteav.videobase.frame.PixelFrame
        public final void setBuffer(ByteBuffer byteBuffer) {
            throw new UnsupportedOperationException("Object is allocated by pool, can't change its Buffer");
        }

        @Override // com.tencent.liteav.videobase.frame.PixelFrame
        public final void setData(byte[] bArr) {
            throw new UnsupportedOperationException("Object is allocated by pool, can't change its Data");
        }

        @Override // com.tencent.liteav.videobase.frame.PixelFrame
        public final void setHeight(int i) {
            throw new UnsupportedOperationException("Object is allocated by pool, can't change its height");
        }

        @Override // com.tencent.liteav.videobase.frame.PixelFrame
        public final void setPixelBufferType(GLConstants.PixelBufferType pixelBufferType) {
            throw new UnsupportedOperationException("Object is allocated by pool, can't change its buffer type");
        }

        @Override // com.tencent.liteav.videobase.frame.PixelFrame
        public final void setPixelFormatType(GLConstants.PixelFormatType pixelFormatType) {
            throw new UnsupportedOperationException("Object is allocated by pool, can't change its format type");
        }

        @Override // com.tencent.liteav.videobase.frame.PixelFrame
        public final void setWidth(int i) {
            throw new UnsupportedOperationException("Object is allocated by pool, can't change its width");
        }
    }

    public final PixelFrame a(int i, int i2, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType) {
        return (PixelFrame) super.a(new a(i, i2, pixelBufferType, pixelFormatType));
    }

    @Override // com.tencent.liteav.videobase.frame.a
    protected final /* synthetic */ PixelFrame a(g<PixelFrame> gVar, a.InterfaceC0936a interfaceC0936a) {
        a aVar = (a) interfaceC0936a;
        return new b(gVar, aVar.f36640a, aVar.b, aVar.f36641c, aVar.d, (byte) 0);
    }

    @Override // com.tencent.liteav.videobase.frame.a
    protected final /* bridge */ /* synthetic */ void a(PixelFrame pixelFrame) {
    }

    @Override // com.tencent.liteav.videobase.frame.a
    protected final /* synthetic */ a.InterfaceC0936a b(PixelFrame pixelFrame) {
        PixelFrame pixelFrame2 = pixelFrame;
        return new a(pixelFrame2.getWidth(), pixelFrame2.getHeight(), pixelFrame2.getPixelBufferType(), pixelFrame2.getPixelFormatType());
    }
}

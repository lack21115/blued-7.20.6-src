package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/aq.class */
public final class aq implements CaptureSourceInterface.a {

    /* renamed from: a  reason: collision with root package name */
    protected final Set<CaptureSourceInterface.a> f36879a = new HashSet();

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.a
    public final void a() {
        for (CaptureSourceInterface.a aVar : this.f36879a) {
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public final void a(CaptureSourceInterface.a aVar) {
        if (aVar != null) {
            this.f36879a.add(aVar);
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.a
    public final void a(CaptureSourceInterface captureSourceInterface, PixelFrame pixelFrame) {
        for (CaptureSourceInterface.a aVar : this.f36879a) {
            if (aVar != null) {
                aVar.a(null, pixelFrame);
            }
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.a
    public final void a(boolean z) {
        for (CaptureSourceInterface.a aVar : this.f36879a) {
            if (aVar != null) {
                aVar.a(z);
            }
        }
    }

    public final int b() {
        return this.f36879a.size();
    }

    public final void b(CaptureSourceInterface.a aVar) {
        this.f36879a.remove(aVar);
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.a
    public final void b(boolean z) {
        for (CaptureSourceInterface.a aVar : this.f36879a) {
            if (aVar != null) {
                aVar.b(z);
            }
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.a
    public final void c(boolean z) {
        for (CaptureSourceInterface.a aVar : this.f36879a) {
            if (aVar != null) {
                aVar.c(z);
            }
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.a
    public final void d(boolean z) {
        for (CaptureSourceInterface.a aVar : this.f36879a) {
            if (aVar != null) {
                aVar.d(z);
            }
        }
    }
}

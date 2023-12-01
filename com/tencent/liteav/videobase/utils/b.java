package com.tencent.liteav.videobase.utils;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.frame.PixelFrame;
import java.util.ArrayList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/utils/b.class */
public final class b implements h {

    /* renamed from: a  reason: collision with root package name */
    private final BlockingDeque<PixelFrame> f36654a = new LinkedBlockingDeque(2);

    @Override // com.tencent.liteav.videobase.utils.h
    public final PixelFrame a() {
        return this.f36654a.poll();
    }

    @Override // com.tencent.liteav.videobase.utils.h
    public final void a(PixelFrame pixelFrame) {
        pixelFrame.retain();
        try {
            this.f36654a.put(pixelFrame);
        } catch (InterruptedException e) {
            LiteavLog.e("BlockingFrameQueue", "push frame failed with exception", e);
        }
    }

    @Override // com.tencent.liteav.videobase.utils.h
    public final void b() {
        ArrayList arrayList = new ArrayList();
        this.f36654a.drainTo(arrayList);
        PixelFrame.releasePixelFrames(arrayList);
    }
}

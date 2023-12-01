package com.tencent.liteav.videobase.utils;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.frame.PixelFrame;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/utils/j.class */
public final class j implements h {

    /* renamed from: a  reason: collision with root package name */
    private final Deque<PixelFrame> f22970a = new LinkedList();
    private int b;

    public j(int i) {
        this.b = i;
    }

    @Override // com.tencent.liteav.videobase.utils.h
    public final PixelFrame a() {
        PixelFrame pollFirst;
        synchronized (this) {
            pollFirst = this.f22970a.pollFirst();
        }
        return pollFirst;
    }

    @Override // com.tencent.liteav.videobase.utils.h
    public final void a(PixelFrame pixelFrame) {
        PixelFrame removeFirst;
        pixelFrame.retain();
        synchronized (this) {
            removeFirst = this.f22970a.size() >= this.b ? this.f22970a.removeFirst() : null;
            this.f22970a.addLast(pixelFrame);
        }
        if (removeFirst != null) {
            removeFirst.release();
        }
    }

    @Override // com.tencent.liteav.videobase.utils.h
    public final void b() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f22970a);
            this.f22970a.clear();
        }
        LiteavLog.i("RingFrameQueue", "evictAll pixelFrame.");
        PixelFrame.releasePixelFrames(arrayList);
    }

    public final boolean b(PixelFrame pixelFrame) {
        boolean z = false;
        if (pixelFrame == null) {
            return false;
        }
        synchronized (this) {
            if (this.f22970a.size() > 0) {
                z = this.f22970a.removeFirstOccurrence(pixelFrame);
            }
        }
        if (z) {
            pixelFrame.release();
        }
        return z;
    }

    public final int c() {
        int size;
        synchronized (this) {
            size = this.f22970a.size();
        }
        return size;
    }
}

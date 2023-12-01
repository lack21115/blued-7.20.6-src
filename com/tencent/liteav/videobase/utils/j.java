package com.tencent.liteav.videobase.utils;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.frame.PixelFrame;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/utils/j.class */
public final class j implements h {

    /* renamed from: a  reason: collision with root package name */
    private final Deque<PixelFrame> f36661a = new LinkedList();
    private int b;

    public j(int i) {
        this.b = i;
    }

    @Override // com.tencent.liteav.videobase.utils.h
    public final PixelFrame a() {
        PixelFrame pollFirst;
        synchronized (this) {
            pollFirst = this.f36661a.pollFirst();
        }
        return pollFirst;
    }

    @Override // com.tencent.liteav.videobase.utils.h
    public final void a(PixelFrame pixelFrame) {
        PixelFrame removeFirst;
        pixelFrame.retain();
        synchronized (this) {
            removeFirst = this.f36661a.size() >= this.b ? this.f36661a.removeFirst() : null;
            this.f36661a.addLast(pixelFrame);
        }
        if (removeFirst != null) {
            removeFirst.release();
        }
    }

    @Override // com.tencent.liteav.videobase.utils.h
    public final void b() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f36661a);
            this.f36661a.clear();
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
            if (this.f36661a.size() > 0) {
                z = this.f36661a.removeFirstOccurrence(pixelFrame);
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
            size = this.f36661a.size();
        }
        return size;
    }
}

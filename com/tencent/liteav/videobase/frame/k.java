package com.tencent.liteav.videobase.frame;

import com.tencent.liteav.base.util.LiteavLog;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/frame/k.class */
public abstract class k {
    private static final String TAG = "RefCounted";
    private final g mRecycler;
    private String mStackTrace;
    private final AtomicInteger mRefCnt = new AtomicInteger(0);
    private long mLastUsedTimestamp = -1;

    public k(g gVar) {
        this.mRecycler = gVar;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.mRecycler == null || this.mRefCnt.get() == 0) {
            return;
        }
        LiteavLog.e(TAG, "Object's reference count(%d) isn't zero when finalize.\n retainTrack:%s", Integer.valueOf(this.mRefCnt.get()), this.mStackTrace);
    }

    public long getLastUsedTimestamp() {
        return this.mLastUsedTimestamp;
    }

    public void release() {
        g gVar;
        if (this.mRefCnt.decrementAndGet() != 0 || (gVar = this.mRecycler) == null) {
            return;
        }
        gVar.a(this);
    }

    public int retain() {
        this.mStackTrace = null;
        return this.mRefCnt.addAndGet(1);
    }

    public void updateLastUsedTimestamp(long j) {
        this.mLastUsedTimestamp = j;
    }
}

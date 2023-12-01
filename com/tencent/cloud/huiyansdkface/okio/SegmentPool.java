package com.tencent.cloud.huiyansdkface.okio;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okio/SegmentPool.class */
public final class SegmentPool {
    static final long MAX_SIZE = 65536;
    static long byteCount;
    static Segment next;

    private SegmentPool() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void recycle(Segment segment) {
        if (segment.next != null || segment.prev != null) {
            throw new IllegalArgumentException();
        }
        if (segment.shared) {
            return;
        }
        synchronized (SegmentPool.class) {
            try {
                if (byteCount + 8192 > 65536) {
                    return;
                }
                byteCount += 8192;
                segment.next = next;
                segment.limit = 0;
                segment.pos = 0;
                next = segment;
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Segment take() {
        synchronized (SegmentPool.class) {
            try {
                if (next != null) {
                    Segment segment = next;
                    next = segment.next;
                    segment.next = null;
                    byteCount -= 8192;
                    return segment;
                }
                return new Segment();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

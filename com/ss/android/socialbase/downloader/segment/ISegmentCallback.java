package com.ss.android.socialbase.downloader.segment;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.RetryThrowable;
import com.ss.android.socialbase.downloader.model.HttpResponse;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/segment/ISegmentCallback.class */
public interface ISegmentCallback {
    void applySegment(SegmentReader segmentReader, Segment segment) throws BaseException;

    IOutput createOutput(SegmentReader segmentReader, Segment segment) throws BaseException;

    Segment obtainSegment(SegmentReader segmentReader, UrlRecord urlRecord);

    void onReaderExit(SegmentReader segmentReader);

    void onReaderRun(SegmentReader segmentReader);

    void onSegmentConnected(SegmentReader segmentReader, Segment segment, UrlRecord urlRecord, HttpResponse httpResponse) throws BaseException, RetryThrowable;

    void onSegmentFailed(SegmentReader segmentReader, UrlRecord urlRecord, Segment segment, BaseException baseException);

    void onSegmentRetry(SegmentReader segmentReader, UrlRecord urlRecord, Segment segment, BaseException baseException, int i, int i2);

    void unApplySegment(SegmentReader segmentReader, Segment segment);

    void unObtainSegment(SegmentReader segmentReader, Segment segment);
}

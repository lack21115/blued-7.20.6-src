package com.tencent.thumbplayer.f.a;

import android.content.Context;
import com.tencent.thumbplayer.api.TPTimeRange;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequester;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequesterListener;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaFeature;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaFeatureData;
import com.tencent.thumbplayer.core.richmedia.TPNativeRichMediaFeature;
import com.tencent.thumbplayer.core.richmedia.TPNativeRichMediaFeatureData;
import com.tencent.thumbplayer.core.richmedia.TPNativeTimeRange;
import com.tencent.thumbplayer.core.richmedia.async.ITPNativeRichMediaAsyncRequester;
import com.tencent.thumbplayer.core.richmedia.async.ITPNativeRichMediaAsyncRequesterListener;
import com.tencent.thumbplayer.core.richmedia.async.TPNativeRichMediaAsyncRequester;
import com.tencent.thumbplayer.utils.TPLogUtil;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/f/a/a.class */
public class a implements ITPRichMediaAsyncRequester {

    /* renamed from: a  reason: collision with root package name */
    private final ITPNativeRichMediaAsyncRequester f25612a;

    /* renamed from: com.tencent.thumbplayer.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/f/a/a$a.class */
    class C0850a implements ITPNativeRichMediaAsyncRequesterListener {
        private final ITPRichMediaAsyncRequesterListener b;

        public C0850a(ITPRichMediaAsyncRequesterListener iTPRichMediaAsyncRequesterListener) {
            this.b = iTPRichMediaAsyncRequesterListener;
        }

        @Override // com.tencent.thumbplayer.core.richmedia.async.ITPNativeRichMediaAsyncRequesterListener
        public void onFeatureDataRequestFailure(ITPNativeRichMediaAsyncRequester iTPNativeRichMediaAsyncRequester, int i, int i2, int i3) {
            this.b.onFeatureDataRequestFailure(a.this, i, i2, i3);
        }

        @Override // com.tencent.thumbplayer.core.richmedia.async.ITPNativeRichMediaAsyncRequesterListener
        public void onFeatureDataRequestSuccess(ITPNativeRichMediaAsyncRequester iTPNativeRichMediaAsyncRequester, int i, int i2, TPNativeRichMediaFeatureData tPNativeRichMediaFeatureData) {
            this.b.onFeatureDataRequestSuccess(a.this, i, i2, new TPRichMediaFeatureData(tPNativeRichMediaFeatureData));
        }

        @Override // com.tencent.thumbplayer.core.richmedia.async.ITPNativeRichMediaAsyncRequesterListener
        public void onRequesterError(ITPNativeRichMediaAsyncRequester iTPNativeRichMediaAsyncRequester, int i) {
            this.b.onRequesterError(a.this, i);
        }

        @Override // com.tencent.thumbplayer.core.richmedia.async.ITPNativeRichMediaAsyncRequesterListener
        public void onRequesterPrepared(ITPNativeRichMediaAsyncRequester iTPNativeRichMediaAsyncRequester) {
            this.b.onRequesterPrepared(a.this);
        }
    }

    public a(Context context) {
        this.f25612a = new TPNativeRichMediaAsyncRequester(context);
    }

    private TPRichMediaFeature[] a(TPNativeRichMediaFeature[] tPNativeRichMediaFeatureArr) {
        if (tPNativeRichMediaFeatureArr == null || tPNativeRichMediaFeatureArr.length == 0) {
            return new TPRichMediaFeature[0];
        }
        TPRichMediaFeature[] tPRichMediaFeatureArr = new TPRichMediaFeature[tPNativeRichMediaFeatureArr.length];
        for (int i = 0; i < tPNativeRichMediaFeatureArr.length; i++) {
            tPRichMediaFeatureArr[i] = new TPRichMediaFeature(tPNativeRichMediaFeatureArr[i]);
        }
        return tPRichMediaFeatureArr;
    }

    private TPNativeTimeRange[] a(TPTimeRange[] tPTimeRangeArr) {
        if (tPTimeRangeArr == null || tPTimeRangeArr.length == 0) {
            return new TPNativeTimeRange[0];
        }
        TPNativeTimeRange[] tPNativeTimeRangeArr = new TPNativeTimeRange[tPTimeRangeArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= tPTimeRangeArr.length) {
                return tPNativeTimeRangeArr;
            }
            TPTimeRange tPTimeRange = tPTimeRangeArr[i2];
            if (tPTimeRange == null) {
                return new TPNativeTimeRange[0];
            }
            tPNativeTimeRangeArr[i2] = new TPNativeTimeRange(tPTimeRange.getStartTimeMs(), tPTimeRange.getEndTimeMs());
            i = i2 + 1;
        }
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequester
    public void cancelRequest(int i) {
        this.f25612a.cancelRequest(i);
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequester
    public TPRichMediaFeature[] getFeatures() {
        return a(this.f25612a.getFeatures());
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequester
    public void prepareAsync() {
        this.f25612a.prepareAsync();
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequester
    public void release() {
        this.f25612a.release();
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequester
    public int requestFeatureDataAsyncAtTimeMs(int i, long j) {
        return this.f25612a.requestFeatureDataAsyncAtTimeMs(i, j);
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequester
    public int requestFeatureDataAsyncAtTimeMsArray(int i, long[] jArr) {
        return this.f25612a.requestFeatureDataAsyncAtTimeMsArray(i, jArr);
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequester
    public int requestFeatureDataAsyncAtTimeRange(int i, TPTimeRange tPTimeRange) {
        if (tPTimeRange == null) {
            TPLogUtil.w("TPRichMediaAsyncRequester", "requestFeatureDataAsyncAtTimeRange, timeRange == null");
            return -1;
        }
        return this.f25612a.requestFeatureDataAsyncAtTimeRange(i, new TPNativeTimeRange(tPTimeRange.getStartTimeMs(), tPTimeRange.getEndTimeMs()));
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequester
    public int requestFeatureDataAsyncAtTimeRanges(int i, TPTimeRange[] tPTimeRangeArr) {
        TPNativeTimeRange[] a2 = a(tPTimeRangeArr);
        if (a2.length == 0) {
            TPLogUtil.w("TPRichMediaAsyncRequester", "requestFeatureDataAsyncAtTimeRanges, toNativeTimeRanges return empty array");
            return -1;
        }
        return this.f25612a.requestFeatureDataAsyncAtTimeRanges(i, a2);
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequester
    public void setRequesterListener(ITPRichMediaAsyncRequesterListener iTPRichMediaAsyncRequesterListener) {
        this.f25612a.setRequesterListener(new C0850a(iTPRichMediaAsyncRequesterListener));
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequester
    public void setRichMediaSource(String str) {
        this.f25612a.setRichMediaSource(str);
    }
}

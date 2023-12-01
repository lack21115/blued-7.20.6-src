package com.tencent.thumbplayer.core.richmedia.async;

import android.content.Context;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import com.tencent.thumbplayer.core.richmedia.TPNativeRichMediaFeature;
import com.tencent.thumbplayer.core.richmedia.TPNativeTimeRange;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/richmedia/async/TPNativeRichMediaAsyncRequester.class */
public class TPNativeRichMediaAsyncRequester implements ITPNativeRichMediaAsyncRequester {
    private static final int REQUEST_ID_NATIVE_EXCEPTION_THROW = -100;
    private long mNativeContext = 0;

    public TPNativeRichMediaAsyncRequester(Context context) {
        TPNativeLibraryLoader.loadLibIfNeeded(context);
        try {
            if (_nativeSetup() == 0) {
                return;
            }
            throw new UnsupportedOperationException("failed to setup rich media");
        } catch (Throwable th) {
            TPNativeLog.printLog(4, "Failed to create native rich media:" + th.getMessage());
            throw new UnsupportedOperationException("failed to create rich media");
        }
    }

    private native void _cancelRequest(int i);

    private native TPNativeRichMediaFeature[] _getFeatures();

    private native int _nativeSetup();

    private native int _prepareAsync();

    private native void _release();

    private native int _requestFeatureDataAsyncAtTimeMs(int i, long j);

    private native int _requestFeatureDataAsyncAtTimeMsArray(int i, long[] jArr);

    private native int _requestFeatureDataAsyncAtTimeRange(int i, TPNativeTimeRange tPNativeTimeRange);

    private native int _requestFeatureDataAsyncAtTimeRanges(int i, TPNativeTimeRange[] tPNativeTimeRangeArr);

    private native void _setRequesterListener(ITPNativeRichMediaAsyncRequesterListener iTPNativeRichMediaAsyncRequesterListener);

    private native int _setRichMediaSource(String str);

    @Override // com.tencent.thumbplayer.core.richmedia.async.ITPNativeRichMediaAsyncRequester
    public void cancelRequest(int i) {
        try {
            _cancelRequest(i);
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.core.richmedia.async.ITPNativeRichMediaAsyncRequester
    public TPNativeRichMediaFeature[] getFeatures() {
        try {
            return _getFeatures();
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            return new TPNativeRichMediaFeature[0];
        }
    }

    @Override // com.tencent.thumbplayer.core.richmedia.async.ITPNativeRichMediaAsyncRequester
    public void prepareAsync() {
        int i;
        try {
            i = _prepareAsync();
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            i = 1000001;
        }
        if (i != 0) {
            throw new IllegalStateException("prepareAsync, ret=".concat(String.valueOf(i)));
        }
    }

    @Override // com.tencent.thumbplayer.core.richmedia.async.ITPNativeRichMediaAsyncRequester
    public void release() {
        try {
            _release();
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.core.richmedia.async.ITPNativeRichMediaAsyncRequester
    public int requestFeatureDataAsyncAtTimeMs(int i, long j) {
        try {
            return _requestFeatureDataAsyncAtTimeMs(i, j);
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            return -100;
        }
    }

    @Override // com.tencent.thumbplayer.core.richmedia.async.ITPNativeRichMediaAsyncRequester
    public int requestFeatureDataAsyncAtTimeMsArray(int i, long[] jArr) {
        try {
            return _requestFeatureDataAsyncAtTimeMsArray(i, jArr);
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            return -100;
        }
    }

    @Override // com.tencent.thumbplayer.core.richmedia.async.ITPNativeRichMediaAsyncRequester
    public int requestFeatureDataAsyncAtTimeRange(int i, TPNativeTimeRange tPNativeTimeRange) {
        try {
            return _requestFeatureDataAsyncAtTimeRange(i, tPNativeTimeRange);
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            return -100;
        }
    }

    @Override // com.tencent.thumbplayer.core.richmedia.async.ITPNativeRichMediaAsyncRequester
    public int requestFeatureDataAsyncAtTimeRanges(int i, TPNativeTimeRange[] tPNativeTimeRangeArr) {
        try {
            return _requestFeatureDataAsyncAtTimeRanges(i, tPNativeTimeRangeArr);
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            return -100;
        }
    }

    @Override // com.tencent.thumbplayer.core.richmedia.async.ITPNativeRichMediaAsyncRequester
    public void setRequesterListener(ITPNativeRichMediaAsyncRequesterListener iTPNativeRichMediaAsyncRequesterListener) {
        try {
            _setRequesterListener(iTPNativeRichMediaAsyncRequesterListener);
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.core.richmedia.async.ITPNativeRichMediaAsyncRequester
    public void setRichMediaSource(String str) {
        int i;
        try {
            i = _setRichMediaSource(str);
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            i = 1000001;
        }
        if (i == 0) {
            return;
        }
        if (i != 1000012) {
            throw new IllegalStateException("setRichMediaSource:".concat(String.valueOf(i)));
        }
        throw new IllegalArgumentException("setRichMediaSource，invalid argument, url=".concat(String.valueOf(str)));
    }
}

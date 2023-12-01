package com.blued.android.module.shortvideo.model;

import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import com.qiniu.pili.droid.shortvideo.PLMediaFile;
import java.io.Serializable;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/model/TrimDataModel.class */
public class TrimDataModel extends CommonModel {
    public static final int SLICE_COUNT = 7;
    private static final String TAG = TrimDataModel.class.getSimpleName() + " ";
    private long durationMs;
    private int marginSize;
    private int maxWidth;
    private PLMediaFile mediaFile;
    private int paddingSize;
    private double rangeWidth;
    private SerializableData serializableData = new SerializableData();
    private int singleRangeWidth;
    private int slidingBlockPxHeight;
    private int slidingBlockPxWidth;
    private int thumbnailsCount;
    private int videoHeigh;
    private int videoRotation;
    private int videoWidth;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/model/TrimDataModel$SerializableData.class */
    public static class SerializableData implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public long f15758a;

        /* renamed from: c  reason: collision with root package name */
        private float f15759c;
        private float d;
        private double e;
        private double f;
        public long b = 60000;
        private long g = 0;

        public void a() {
            this.f15758a = 0L;
            this.b = 60000L;
            this.f15759c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0d;
            this.f = 0.0d;
            this.g = 0L;
        }

        public void a(SerializableData serializableData) {
            if (serializableData != null) {
                this.f15758a = serializableData.f15758a;
                this.b = serializableData.b;
                this.f15759c = serializableData.f15759c;
                this.d = serializableData.d;
                this.e = serializableData.e;
                this.f = serializableData.f;
                this.g = serializableData.g;
            }
        }
    }

    private void initTrimViewData() {
        if (this.durationMs > 0) {
            setLeftProgress(0.0d);
            setRightProgress(Math.min(getDurationMs(), getMaxVideoDuration()));
            if (getDurationMs() <= getMaxVideoDuration()) {
                this.thumbnailsCount = 10;
                this.rangeWidth = this.maxWidth;
            } else {
                this.thumbnailsCount = (int) Math.ceil(((((float) this.durationMs) * 1.0f) / (((float) getMaxVideoDuration()) * 1.0f)) * 10.0f);
                this.rangeWidth = this.maxWidth / ((((float) getMaxVideoDuration()) * 1.0f) / ((float) this.durationMs));
            }
            this.singleRangeWidth = (int) Math.round(this.rangeWidth / this.thumbnailsCount);
            this.serializableData.f15759c = (float) ((this.rangeWidth / this.durationMs) * 1.0d);
            this.serializableData.d = (float) (((((float) this.durationMs) * 1.0f) / this.rangeWidth) * 1.0d);
        }
    }

    @Override // com.blued.android.module.shortvideo.model.CommonModel
    public void clear() {
        super.clear();
        this.serializableData.a();
        this.mediaFile = null;
        this.durationMs = 0L;
        this.videoWidth = 0;
        this.videoHeigh = 0;
        this.videoRotation = 0;
        this.maxWidth = 0;
        this.marginSize = 0;
        this.paddingSize = 0;
        this.slidingBlockPxWidth = 0;
        this.slidingBlockPxHeight = 0;
        this.thumbnailsCount = 0;
        this.rangeWidth = 0.0d;
        this.singleRangeWidth = 0;
    }

    public void copyModel(CommonModel commonModel, SerializableData serializableData) {
        super.copyModel(commonModel, true);
        if (this.serializableData == null) {
            this.serializableData = new SerializableData();
        }
        this.serializableData.a(serializableData);
        setCurrentPage(3);
        setMediaFile(commonModel.getVideoPath());
    }

    public int getAudioChannels() {
        return this.mediaFile.getAudioChannels();
    }

    public int getAudioSampleRate() {
        return this.mediaFile.getAudioSampleRate();
    }

    public float getAverageMsPx() {
        return this.serializableData.f15759c;
    }

    public float getAveragePxMs() {
        return this.serializableData.d;
    }

    public long getDurationMs() {
        return this.durationMs;
    }

    public String getFilepath() {
        return this.mediaFile.getFilepath();
    }

    public double getLeftProgress() {
        return this.serializableData.e;
    }

    public int getMarginSize() {
        return this.marginSize;
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public PLMediaFile getMediaFile() {
        return this.mediaFile;
    }

    public int getPaddingSize() {
        return this.paddingSize;
    }

    public double getRightProgress() {
        return this.serializableData.f;
    }

    public long getScrollMs() {
        return this.serializableData.g;
    }

    public long getSelectedBeginMs() {
        return this.serializableData.f15758a;
    }

    public long getSelectedDurationMs() {
        return this.serializableData.b - this.serializableData.f15758a;
    }

    public long getSelectedEndMs() {
        return this.serializableData.b;
    }

    public SerializableData getSerializableData() {
        return this.serializableData;
    }

    public int getSingleRangeWidth() {
        return this.singleRangeWidth;
    }

    public int getSlidingBlockPxHeight() {
        return this.slidingBlockPxHeight;
    }

    public int getSlidingBlockPxWidth() {
        return this.slidingBlockPxWidth;
    }

    public int getThumbnailsCount() {
        return this.thumbnailsCount;
    }

    public int getVideoBitrate() {
        return this.mediaFile.getVideoBitrate();
    }

    public int getVideoFrameRate() {
        return this.mediaFile.getVideoFrameRate();
    }

    public int getVideoHeight() {
        return this.videoHeigh;
    }

    public int getVideoIFrameInterval() {
        return this.mediaFile.getVideoIFrameInterval();
    }

    public int getVideoRotation() {
        return this.mediaFile.getVideoRotation();
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public void initViewData() {
        this.slidingBlockPxWidth = DensityUtils.a(AppInfo.d(), 11.0f);
        this.slidingBlockPxHeight = DensityUtils.a(AppInfo.d(), 55.0f);
        int a2 = DensityUtils.a(AppInfo.d(), 39.0f);
        this.paddingSize = a2;
        this.marginSize = a2 + DensityUtils.a(AppInfo.d(), 11.0f);
        this.maxWidth = AppInfo.l - (this.marginSize * 2);
    }

    public void release() {
        this.mediaFile.release();
    }

    public void setLeftProgress(double d) {
        StvLogUtils.a(TAG + "setLeftProgress:%f", Double.valueOf(d));
        this.serializableData.e = d;
    }

    @Override // com.blued.android.module.shortvideo.model.CommonModel
    public void setMaxVideoDuration(long j) {
        super.setMaxVideoDuration(j);
        initTrimViewData();
    }

    public void setMediaFile(String str) {
        PLMediaFile pLMediaFile = new PLMediaFile(str);
        this.mediaFile = pLMediaFile;
        this.durationMs = pLMediaFile.getDurationMs();
        int videoRotation = this.mediaFile.getVideoRotation();
        this.videoRotation = videoRotation;
        if (videoRotation == 90 || videoRotation == 270) {
            this.videoWidth = this.mediaFile.getVideoHeight();
            this.videoHeigh = this.mediaFile.getVideoWidth();
        } else {
            this.videoWidth = this.mediaFile.getVideoWidth();
            this.videoHeigh = this.mediaFile.getVideoHeight();
        }
        initViewData();
    }

    public void setRightProgress(double d) {
        StvLogUtils.a(TAG + "setRightProgress:%f", Double.valueOf(d));
        this.serializableData.f = d;
    }

    public void setScrollMs(long j) {
        StvLogUtils.a(TAG + " scrollMs:" + j, new Object[0]);
        this.serializableData.g = j;
    }

    public void setSelectedBeginMs(long j) {
        this.serializableData.f15758a = j;
    }

    public void setSelectedEndMs(long j) {
        this.serializableData.b = j;
    }
}

package com.blued.android.module.shortvideo.model;

import com.qiniu.pili.droid.shortvideo.PLCameraSetting;
import com.qiniu.pili.droid.shortvideo.PLMediaFile;
import java.io.Serializable;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/model/ShineDataModel.class */
public class ShineDataModel extends CommonModel {
    public static final int SHOW_V_COUNTDOWN = 5;
    private long durationMs;
    private PLMediaFile mediaFile;
    private int videoHeigh;
    private int videoRotation;
    private int videoWidth;
    private boolean isRecording = false;
    private SerializableData serializableData = new SerializableData();

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/model/ShineDataModel$SerializableData.class */
    public static class SerializableData implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public double f15756a = 1.0d;
        public boolean b = false;

        /* renamed from: c  reason: collision with root package name */
        public boolean f15757c = false;
        public int d = PLCameraSetting.CAMERA_FACING_ID.CAMERA_FACING_FRONT.ordinal();
        public int e;
        public long f;
        public String g;

        public void a() {
            this.f15756a = 1.0d;
            this.b = false;
            this.d = PLCameraSetting.CAMERA_FACING_ID.CAMERA_FACING_FRONT.ordinal();
            this.f15757c = false;
            this.e = 0;
            this.f = 0L;
            this.g = null;
        }

        public void a(SerializableData serializableData) {
            if (serializableData != null) {
                this.f15756a = serializableData.f15756a;
                this.b = serializableData.b;
                this.d = serializableData.d;
                this.f15757c = serializableData.f15757c;
                this.e = serializableData.e;
                this.f = serializableData.f;
                this.g = serializableData.g;
            }
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
        this.isRecording = false;
    }

    public void copyModel(CommonModel commonModel, SerializableData serializableData) {
        super.copyModel(commonModel, true);
        if (this.serializableData == null) {
            this.serializableData = new SerializableData();
        }
        this.serializableData.a(serializableData);
    }

    public int getAudioChannels() {
        return this.mediaFile.getAudioChannels();
    }

    public int getAudioSampleRate() {
        return this.mediaFile.getAudioSampleRate();
    }

    public int getCurrentCameraId() {
        return this.serializableData.d;
    }

    public long getDurationMs() {
        return this.durationMs;
    }

    public String getFramePath() {
        return this.serializableData.g;
    }

    public PLMediaFile getMediaFile() {
        return this.mediaFile;
    }

    public double getRecordSpeed() {
        double d;
        synchronized (this) {
            d = this.serializableData.f15756a;
        }
        return d;
    }

    public SerializableData getSerializableData() {
        return this.serializableData;
    }

    public long getTotalDuration() {
        return this.serializableData.f;
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

    public boolean isBeginSection() {
        boolean z;
        synchronized (this) {
            z = this.serializableData.b;
        }
        return z;
    }

    public boolean isConcatSections() {
        return ((double) getTotalDuration()) >= ((double) getMinRecordDuration()) * getRecordSpeed();
    }

    public boolean isMaxTime() {
        return this.serializableData.f >= getMaxRecordDuration();
    }

    public boolean isRecordCompleted() {
        return this.serializableData.f15757c;
    }

    public boolean isRecordSection() {
        return this.serializableData.e > 0;
    }

    public boolean isRecording() {
        return this.isRecording;
    }

    public void onSectionCountChanged(long j, int i) {
        this.serializableData.f = j;
        this.serializableData.e = i;
    }

    public void release() {
        this.mediaFile.release();
    }

    public void setBeginSection(boolean z) {
        synchronized (this) {
            this.serializableData.b = z;
        }
    }

    public void setCurrentCameraId(int i) {
        this.serializableData.d = i;
    }

    public void setFramePath(String str) {
        this.serializableData.g = str;
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
            return;
        }
        this.videoWidth = this.mediaFile.getVideoWidth();
        this.videoHeigh = this.mediaFile.getVideoHeight();
    }

    public void setRecordCompleted(boolean z) {
        this.serializableData.f15757c = z;
    }

    public void setRecordSpeed(double d) {
        synchronized (this) {
            this.serializableData.f15756a = d;
        }
    }

    public void setRecording(boolean z) {
        this.isRecording = z;
    }
}

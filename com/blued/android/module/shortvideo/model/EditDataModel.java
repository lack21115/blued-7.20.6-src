package com.blued.android.module.shortvideo.model;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import com.qiniu.pili.droid.shortvideo.PLMediaFile;
import com.tencent.ugc.UGCTransitionRules;
import java.io.File;
import java.io.IOException;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/model/EditDataModel.class */
public class EditDataModel {
    public static final String DEFAULT_MUTE_AUDIO_NAME = "silent_audio.mp3";
    public static final int SHOW_V_COVER = 3;
    public static final int SHOW_V_EDITCONTENT = 1;
    public static final int SHOW_V_VOLUME = 4;
    public static final int SLICE_COUNT = 7;
    public static final int VOLUME_MAX = 100;
    private PLMediaFile mediaFile;
    private PLMediaFile saveMediaFile;
    private SerializableData serializableData = new SerializableData();

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/model/EditDataModel$SerializableData.class */
    public static class SerializableData extends CommonModel {
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public String m;
        public String n;
        public String o;
        public long q;
        private int r;
        private int s;
        private int t;
        private long u;
        private long v;
        private int w;
        private int x;
        private int y;
        private String z;

        /* renamed from: a  reason: collision with root package name */
        public int f15749a = 100;
        public int b = 100;

        /* renamed from: c  reason: collision with root package name */
        public long f15750c = -1;
        public boolean l = false;
        public boolean p = true;

        public void a(CommonModel commonModel) {
            if (commonModel != null) {
                super.copyModel(commonModel, true);
            }
        }

        public void a(SerializableData serializableData) {
            if (serializableData != null) {
                super.copyModel(serializableData);
                this.f15749a = serializableData.f15749a;
                this.b = serializableData.b;
                this.f15750c = serializableData.f15750c;
                this.d = serializableData.d;
                this.e = serializableData.e;
                this.f = serializableData.f;
                this.h = serializableData.h;
                this.g = serializableData.g;
                this.l = serializableData.l;
                this.m = serializableData.m;
                this.n = serializableData.n;
                this.o = serializableData.o;
                this.i = serializableData.i;
                this.j = serializableData.j;
                this.k = serializableData.k;
                this.p = serializableData.p;
                this.q = serializableData.q;
                this.r = serializableData.r;
                this.s = serializableData.s;
                this.t = serializableData.t;
                this.u = serializableData.u;
                this.v = serializableData.v;
                this.w = serializableData.w;
                this.x = serializableData.x;
                this.y = serializableData.y;
                this.z = serializableData.z;
            }
        }

        public boolean a() {
            return this.f15750c != -1;
        }

        @Override // com.blued.android.module.shortvideo.model.CommonModel
        public void clear() {
            super.clear();
            this.f15749a = 100;
            this.b = 100;
            this.f15750c = -1L;
            this.e = 0;
            this.f = 0;
            this.h = 0;
            this.g = 0;
            this.i = 0;
            this.j = 0;
            this.k = 0;
            this.l = false;
            this.o = null;
            this.m = null;
            this.n = null;
            this.p = true;
            this.q = 0L;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.v = 0L;
            this.u = 0L;
            this.w = 0;
            this.x = 0;
            this.y = 0;
            this.z = null;
        }
    }

    private void setEncodingH(int i) {
        this.serializableData.j = i;
    }

    private void setEncodingVideoBitrate(int i) {
        this.serializableData.k = i;
    }

    private void setEncodingW(int i) {
        this.serializableData.i = i;
    }

    private void setTranscode(boolean z) {
        this.serializableData.p = z;
    }

    public void calculateEncodingSize(int i, int i2, int i3) {
        float f;
        float f2 = i2;
        float f3 = 1.0f;
        float f4 = f2 * 1.0f;
        float f5 = i3;
        int i4 = ((f4 / f5) > 1.0d ? 1 : ((f4 / f5) == 1.0d ? 0 : -1));
        if (i4 == 0) {
            setEncodingW(UGCTransitionRules.DEFAULT_IMAGE_WIDTH);
            setEncodingH(UGCTransitionRules.DEFAULT_IMAGE_WIDTH);
        } else if (i4 > 0) {
            if (f4 / 1280.0f > (f5 * 1.0f) / 720.0f) {
                setEncodingW(1280);
                setEncodingH((int) (Math.ceil((1280.0f / f) / 8.0d) * 8.0d));
            } else {
                setEncodingH(UGCTransitionRules.DEFAULT_IMAGE_WIDTH);
                setEncodingW((int) (Math.ceil((f * 720.0f) / 8.0d) * 8.0d));
            }
        } else if (f4 / 720.0f > (f5 * 1.0f) / 1280.0f) {
            setEncodingW(UGCTransitionRules.DEFAULT_IMAGE_WIDTH);
            setEncodingH((int) (Math.ceil((720.0f / f) / 8.0d) * 8.0d));
        } else {
            setEncodingH(1280);
            setEncodingW((int) (Math.ceil((f * 1280.0f) / 8.0d) * 8.0d));
        }
        if (i2 > getEncodingW()) {
            f3 = (getEncodingW() * 1.0f) / f2;
        }
        int i5 = (int) (i * f3);
        if (i5 >= 2800000) {
            setEncodingVideoBitrate(2800000);
        } else {
            setEncodingVideoBitrate(i5);
        }
    }

    public void clear() {
        this.serializableData.clear();
        this.mediaFile = null;
    }

    public void copyModel(CommonModel commonModel, SerializableData serializableData) {
        if (this.serializableData == null) {
            this.serializableData = new SerializableData();
        }
        this.serializableData.a(commonModel);
        this.serializableData.a(serializableData);
        this.serializableData.setCurrentPage(4);
        setMediaFile(this.serializableData.getVideoPath());
    }

    public int getAudioChannels() {
        return this.mediaFile.getAudioChannels();
    }

    public int getAudioSampleRate() {
        return this.mediaFile.getAudioSampleRate();
    }

    public int getCoverCurrentLeftPosition() {
        return this.serializableData.g;
    }

    public int getCoverEndPosition() {
        return this.serializableData.h;
    }

    public String getCoverImgPath() {
        return this.serializableData.m;
    }

    public int getCoverStartPositon() {
        return this.serializableData.f;
    }

    public int getCoverVLenght() {
        return this.serializableData.e;
    }

    public int getCurrentBgVolume() {
        return this.serializableData.b;
    }

    public long getCurrentCoverTime() {
        return this.serializableData.f15750c;
    }

    public int getCurrentFgVolume() {
        return this.serializableData.f15749a;
    }

    public long getDurationMs() {
        return this.serializableData.q;
    }

    public int getEncodingH() {
        return this.serializableData.j;
    }

    public int getEncodingVideoBitrate() {
        return this.serializableData.k;
    }

    public int getEncodingW() {
        return this.serializableData.i;
    }

    public String getFilepath() {
        return this.mediaFile.getFilepath();
    }

    public String getFirstImgPath() {
        return this.serializableData.n;
    }

    public PLMediaFile getMediaFile() {
        return this.mediaFile;
    }

    public String getNeedDeleteVideoPath() {
        return this.serializableData.z;
    }

    public long getSaveDurationMs() {
        return this.serializableData.u;
    }

    public int getSaveVideoHeight() {
        return this.serializableData.x;
    }

    public String getSaveVideoPath() {
        return this.serializableData.o;
    }

    public int getSaveVideoWidth() {
        return this.serializableData.w;
    }

    public SerializableData getSerializableData() {
        return this.serializableData;
    }

    public int getVideoBitrate() {
        return this.mediaFile.getVideoBitrate();
    }

    public int getVideoFrameRate() {
        return this.mediaFile.getVideoFrameRate();
    }

    public int getVideoHeight() {
        return this.serializableData.s;
    }

    public int getVideoIFrameInterval() {
        return this.mediaFile.getVideoIFrameInterval();
    }

    public int getVideoRotation() {
        return this.mediaFile.getVideoRotation();
    }

    public long getVideoSize() {
        return this.serializableData.v;
    }

    public int getVideoWidth() {
        return this.serializableData.r;
    }

    public boolean isAutoDelete() {
        return this.serializableData.l;
    }

    public boolean isNeedTranscodeAgain(String str) {
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return false;
        }
        PLMediaFile pLMediaFile = new PLMediaFile(str);
        this.mediaFile = pLMediaFile;
        if (pLMediaFile == null) {
            return false;
        }
        this.serializableData.q = pLMediaFile.getDurationMs();
        this.serializableData.t = this.mediaFile.getVideoRotation();
        this.serializableData.r = this.mediaFile.getVideoWidth();
        this.serializableData.s = this.mediaFile.getVideoHeight();
        if (this.serializableData.r > 720 || this.serializableData.s > 1280) {
            setTranscode(true);
            return true;
        }
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(str);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= mediaExtractor.getTrackCount()) {
                    setTranscode(false);
                    return false;
                }
                String string = mediaExtractor.getTrackFormat(i2).getString(MediaFormat.KEY_MIME);
                if (string.startsWith("video/")) {
                    if (string.equals("video/avc")) {
                        setTranscode(false);
                        return false;
                    }
                    setTranscode(true);
                    return true;
                }
                i = i2 + 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
            setTranscode(false);
            return false;
        }
    }

    public boolean isTranscode() {
        return this.serializableData.p;
    }

    public void release() {
        this.mediaFile.release();
    }

    public void setAutoDelete(boolean z) {
        this.serializableData.l = z;
    }

    public void setCoverCurrentLeftPosition(int i) {
        this.serializableData.g = i;
    }

    public void setCoverEndPosition(int i) {
        this.serializableData.h = i;
    }

    public void setCoverImgPath(String str) {
        this.serializableData.m = str;
    }

    public void setCoverStartPositon(int i) {
        this.serializableData.f = i;
    }

    public void setCoverVLenght(int i) {
        this.serializableData.e = i;
    }

    public void setCurrentBgVolume(int i) {
        this.serializableData.b = i;
    }

    public void setCurrentCoverTime(long j) {
        this.serializableData.f15750c = j;
    }

    public void setCurrentFgVolume(int i) {
        this.serializableData.f15749a = i;
    }

    public void setFirstImgPath(String str) {
        this.serializableData.n = str;
    }

    public void setMediaFile(String str) {
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return;
        }
        PLMediaFile pLMediaFile = new PLMediaFile(str);
        this.mediaFile = pLMediaFile;
        this.serializableData.q = pLMediaFile.getDurationMs();
        this.serializableData.t = this.mediaFile.getVideoRotation();
        if (this.serializableData.t == 90 || this.serializableData.t == 270) {
            this.serializableData.r = this.mediaFile.getVideoHeight();
            this.serializableData.s = this.mediaFile.getVideoWidth();
        } else {
            this.serializableData.r = this.mediaFile.getVideoWidth();
            this.serializableData.s = this.mediaFile.getVideoHeight();
        }
        if (this.serializableData.r > 720 || this.serializableData.s > 1280 || this.mediaFile.getVideoBitrate() > 2800000) {
            setTranscode(true);
        } else {
            setTranscode(false);
        }
    }

    public void setNeedDeleteVideoPath(String str) {
        this.serializableData.z = str;
    }

    public void setSaveVideoPath(String str) {
        this.serializableData.o = str;
        PLMediaFile pLMediaFile = new PLMediaFile(str);
        this.saveMediaFile = pLMediaFile;
        this.serializableData.u = pLMediaFile.getDurationMs();
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            this.serializableData.v = Math.round((file.length() * 1.0d) / 1024.0d);
        }
        this.serializableData.y = this.saveMediaFile.getVideoRotation();
        if (this.serializableData.y == 90 || this.serializableData.y == 270) {
            this.serializableData.w = this.saveMediaFile.getVideoHeight();
            this.serializableData.x = this.saveMediaFile.getVideoWidth();
            return;
        }
        this.serializableData.w = this.saveMediaFile.getVideoWidth();
        this.serializableData.x = this.saveMediaFile.getVideoHeight();
    }

    public void setScreenWidth(int i) {
        this.serializableData.d = i;
    }
}

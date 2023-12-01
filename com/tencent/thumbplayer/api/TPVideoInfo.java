package com.tencent.thumbplayer.api;

import com.tencent.thumbplayer.api.TPCommonEnum;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.utils.b;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPVideoInfo.class */
public class TPVideoInfo {
    private Builder builder;
    private String definition;
    private ArrayList<TPDownloadParamData> downloadParamList;
    private String fileID;
    private long height;
    @TPCommonEnum.TP_VIDEO_CODEC_TYPE
    private int videoCodecId;
    private long width;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPVideoInfo$Builder.class */
    public static class Builder {
        private String definition;
        private ArrayList<TPDownloadParamData> downloadParamList;
        private String fileID;
        private long height;
        @TPCommonEnum.TP_VIDEO_CODEC_TYPE
        private int videoCodecId;
        private long width;

        public TPVideoInfo build() {
            return new TPVideoInfo(this);
        }

        public Builder definition(String str) {
            this.definition = str;
            return this;
        }

        public Builder downloadParam(TPDownloadParamData tPDownloadParamData) {
            if (b.a(this.downloadParamList)) {
                this.downloadParamList = new ArrayList<>();
            } else {
                this.downloadParamList.clear();
            }
            this.downloadParamList.add(tPDownloadParamData);
            return this;
        }

        public Builder downloadParamList(ArrayList<TPDownloadParamData> arrayList) {
            this.downloadParamList = arrayList;
            return this;
        }

        public Builder fileId(String str) {
            this.fileID = str;
            return this;
        }

        public Builder size(long j, long j2) {
            this.width = j;
            this.height = j2;
            return this;
        }

        public Builder videoCodecId(@TPCommonEnum.TP_VIDEO_CODEC_TYPE int i) {
            this.videoCodecId = i;
            return this;
        }
    }

    private TPVideoInfo(Builder builder) {
        this.downloadParamList = new ArrayList<>();
        this.width = builder.width;
        this.height = builder.height;
        this.videoCodecId = builder.videoCodecId;
        this.fileID = builder.fileID;
        this.definition = builder.definition;
        this.downloadParamList = builder.downloadParamList;
        this.builder = builder;
    }

    public Builder getBuilder() {
        return this.builder;
    }

    public String getDefinition() {
        return this.definition;
    }

    public ArrayList<TPDownloadParamData> getDownloadPraramList() {
        return this.downloadParamList;
    }

    public long getHeight() {
        return this.height;
    }

    public String getProxyFileID() {
        return this.fileID;
    }

    public int getVideoCodecId() {
        return this.videoCodecId;
    }

    public long getWidth() {
        return this.width;
    }
}

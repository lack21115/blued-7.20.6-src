package com.tencent.thumbplayer.api.richmedia;

import com.tencent.thumbplayer.core.richmedia.TPNativeRichMediaFeatureData;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/richmedia/TPRichMediaFeatureData.class */
public class TPRichMediaFeatureData {
    private final String mEnv;
    private final List<TPRichMediaFeatureContent> mFeatureContentList = new ArrayList();
    private final String mFeatureType;
    private final String mVersion;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/richmedia/TPRichMediaFeatureData$TPRichMediaFeatureContent.class */
    public static class TPRichMediaFeatureContent {
        private String mContent;
        private long mEndTimeMs;
        private long mStartTimeMs;

        TPRichMediaFeatureContent(TPNativeRichMediaFeatureData.TPNativeRichMediaFeatureContent tPNativeRichMediaFeatureContent) {
            this.mStartTimeMs = -1L;
            this.mEndTimeMs = -1L;
            this.mContent = "";
            this.mStartTimeMs = tPNativeRichMediaFeatureContent.getStartTimeMs();
            this.mEndTimeMs = tPNativeRichMediaFeatureContent.getEndTimeMs();
            this.mContent = tPNativeRichMediaFeatureContent.getContent();
        }

        public String getContent() {
            return this.mContent;
        }

        public long getEndTimeMs() {
            return this.mEndTimeMs;
        }

        public long getStartTimeMs() {
            return this.mStartTimeMs;
        }
    }

    public TPRichMediaFeatureData(TPNativeRichMediaFeatureData tPNativeRichMediaFeatureData) {
        this.mFeatureType = tPNativeRichMediaFeatureData.getFeatureType();
        this.mEnv = tPNativeRichMediaFeatureData.getEnv();
        this.mVersion = tPNativeRichMediaFeatureData.getVersion();
        if (tPNativeRichMediaFeatureData.getFeatureContents() == null) {
            return;
        }
        TPNativeRichMediaFeatureData.TPNativeRichMediaFeatureContent[] featureContents = tPNativeRichMediaFeatureData.getFeatureContents();
        int length = featureContents.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            this.mFeatureContentList.add(new TPRichMediaFeatureContent(featureContents[i2]));
            i = i2 + 1;
        }
    }

    public String getEnv() {
        return this.mEnv;
    }

    public List<TPRichMediaFeatureContent> getFeatureContentList() {
        return this.mFeatureContentList;
    }

    public String getFeatureType() {
        return this.mFeatureType;
    }

    public String getVersion() {
        return this.mVersion;
    }
}

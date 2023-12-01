package com.tencent.cos.xml.model.tag;

import com.tencent.cos.xml.model.tag.audit.bean.AuditOcrResults;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/RecognitionResult.class */
public class RecognitionResult {
    public AdsInfo adsInfo;
    public int compressionResult;
    public String jobId;
    public String label;
    public PoliticsInfo politicsInfo;
    public PornInfo pornInfo;
    public int result;
    public int score;
    public String subLabel;
    public TerroristInfo terroristInfo;
    public String text;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/RecognitionResult$AdsInfo.class */
    public static class AdsInfo {
        public int code;
        public int hitFlag;
        public String label;
        public String msg;
        public AuditOcrResults ocrResults;
        public int score;
        public String subLabel;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/RecognitionResult$PoliticsInfo.class */
    public static class PoliticsInfo {
        public int code;
        public int hitFlag;
        public String label;
        public String msg;
        public AuditOcrResults ocrResults;
        public int score;
        public String subLabel;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/RecognitionResult$PornInfo.class */
    public static class PornInfo {
        public int code;
        public int hitFlag;
        public String label;
        public String msg;
        public AuditOcrResults ocrResults;
        public int score;
        public String subLabel;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/RecognitionResult$TerroristInfo.class */
    public static class TerroristInfo {
        public int code;
        public int hitFlag;
        public String label;
        public String msg;
        public AuditOcrResults ocrResults;
        public int score;
        public String subLabel;
    }
}

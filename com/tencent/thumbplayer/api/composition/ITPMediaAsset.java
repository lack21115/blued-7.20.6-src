package com.tencent.thumbplayer.api.composition;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/composition/ITPMediaAsset.class */
public interface ITPMediaAsset {
    public static final int INVALID_ID = -1;
    public static final int MEDIA_TYPE_AUDIO = 3;
    public static final int MEDIA_TYPE_AV_MIX = 1;
    public static final int MEDIA_TYPE_MUTABLE = 4;
    public static final int MEDIA_TYPE_VIDEO = 2;

    ITPMediaAssetExtraParam getExtraParam();

    int getMediaType();

    String getUrl();

    void setExtraParam(ITPMediaAssetExtraParam iTPMediaAssetExtraParam);
}

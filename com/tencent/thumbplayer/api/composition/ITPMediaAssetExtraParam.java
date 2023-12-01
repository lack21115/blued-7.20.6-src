package com.tencent.thumbplayer.api.composition;

import java.io.Serializable;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/composition/ITPMediaAssetExtraParam.class */
public interface ITPMediaAssetExtraParam extends Serializable {
    public static final String TP_PLAYER_EXTRA_PARAM_PREFERRED_AUDIO = "preferred_audio";
    public static final String TP_PLAYER_EXTRA_PARAM_PREFERRED_SUBTITLE = "preferred_subtitle";
    public static final String TP_PLAYER_EXTRA_PARAM_PREFERRED_VIDEO = "preferred_video";

    int getExtraInt(String str);

    ITPMediaAssetObjectParam getExtraObject(String str);

    String getExtraString(String str);

    void setExtraInt(String str, int i);

    void setExtraObject(String str, ITPMediaAssetObjectParam iTPMediaAssetObjectParam);

    void setExtraString(String str, String str2);
}

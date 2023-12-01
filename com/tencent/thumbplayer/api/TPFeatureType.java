package com.tencent.thumbplayer.api;

import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPFeatureType.class */
public class TPFeatureType {
    @TPNativeKeyMap.MapFeatureType(-1)
    public static final int TP_FEATURE_NONE = -1;
    @TPNativeKeyMap.MapFeatureType(0)
    public static final int TP_SUBTITLE_RGBA_OUTPUT = 0;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPFeatureType$TP_FEATURE_TYPE.class */
    public @interface TP_FEATURE_TYPE {
    }
}

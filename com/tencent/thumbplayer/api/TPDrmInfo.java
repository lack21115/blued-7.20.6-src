package com.tencent.thumbplayer.api;

import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPDrmInfo.class */
public class TPDrmInfo {
    @TPNativeKeyMap.MapReportDrmType(8)
    public static final int TP_PLAYER_DRM_TYPE_CHACHA20 = 8;
    @TPNativeKeyMap.MapReportDrmType(64)
    public static final int TP_PLAYER_DRM_TYPE_CHINA_DRM = 64;
    @TPNativeKeyMap.MapReportDrmType(-1)
    public static final int TP_PLAYER_DRM_TYPE_NONE = -1;
    @TPNativeKeyMap.MapReportDrmType(4)
    public static final int TP_PLAYER_DRM_TYPE_TAIHE = 4;
    @TPNativeKeyMap.MapReportDrmType(32)
    public static final int TP_PLAYER_DRM_TYPE_WIDEVINE = 32;
    public String drmComponentName;
    public long drmGetKeyReqEndTimeMs;
    public long drmGetKeyReqStartTimeMs;
    public long drmGetProvisionReqEndTimeMs;
    public long drmGetProvisionReqStartTimeMs;
    public long drmOpenSessionEndTimeMs;
    public long drmOpenSessionStartTimeMs;
    public long drmPrepareEndTimeMs;
    public long drmPrepareStartTimeMs;
    public long drmProvideKeyRespEndTimeMs;
    public long drmProvideKeyRespStartTimeMs;
    public long drmProvideProvisionRespEndTimeMs;
    public long drmProvideProvisionRespStartTimeMs;
    public long drmRecvKeyRespTimeMs;
    public long drmRecvProvisionRespTimeMs;
    public long drmSendKeyReqTimeMs;
    public long drmSendProvisionReqTimeMs;
    public int drmAbility = -1;
    public int drmSupportSecureDecoder = -1;
    public int drmSupportSecureDecrypt = -1;
    public int drmSecureLevel = -1;
    @TPPlayerDrmType
    public int drmType = -1;

    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPDrmInfo$TPPlayerDrmType.class */
    public @interface TPPlayerDrmType {
    }
}

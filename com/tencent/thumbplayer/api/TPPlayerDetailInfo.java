package com.tencent.thumbplayer.api;

import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPPlayerDetailInfo.class */
public class TPPlayerDetailInfo {
    @TPNativeKeyMap.MapDetailInfoType(16)
    public static final int TP_PLAYER_DETAIL_INFO_TYPE_TRACKING_AUDIO_MEDIACODEC_CONFIGURE_END = 16;
    @TPNativeKeyMap.MapDetailInfoType(15)
    public static final int TP_PLAYER_DETAIL_INFO_TYPE_TRACKING_AUDIO_MEDIACODEC_CONFIGURE_START = 15;
    @TPNativeKeyMap.MapDetailInfoType(18)
    public static final int TP_PLAYER_DETAIL_INFO_TYPE_TRACKING_AUDIO_MEDIACODEC_START_END = 18;
    @TPNativeKeyMap.MapDetailInfoType(17)
    public static final int TP_PLAYER_DETAIL_INFO_TYPE_TRACKING_AUDIO_MEDIACODEC_START_START = 17;
    @TPNativeKeyMap.MapDetailInfoType(4)
    public static final int TP_PLAYER_DETAIL_INFO_TYPE_TRACKING_DEMUXER_FILE_OPEN_END = 4;
    @TPNativeKeyMap.MapDetailInfoType(3)
    public static final int TP_PLAYER_DETAIL_INFO_TYPE_TRACKING_DEMUXER_FILE_OPEN_START = 3;
    @TPNativeKeyMap.MapDetailInfoType(5)
    public static final int TP_PLAYER_DETAIL_INFO_TYPE_TRACKING_DEMUX_THREAD_ON_PREAPRED = 5;
    @TPNativeKeyMap.MapDetailInfoType(2)
    public static final int TP_PLAYER_DETAIL_INFO_TYPE_TRACKING_DEMUX_THREAD_PREPARE_START = 2;
    @TPNativeKeyMap.MapDetailInfoType(8)
    public static final int TP_PLAYER_DETAIL_INFO_TYPE_TRACKING_FIRST_AUDIO_DECODER_CREATE_START = 8;
    @TPNativeKeyMap.MapDetailInfoType(10)
    public static final int TP_PLAYER_DETAIL_INFO_TYPE_TRACKING_FIRST_AUDIO_FRAME_RENDERED = 10;
    @TPNativeKeyMap.MapDetailInfoType(0)
    public static final int TP_PLAYER_DETAIL_INFO_TYPE_TRACKING_FIRST_START = 0;
    @TPNativeKeyMap.MapDetailInfoType(7)
    public static final int TP_PLAYER_DETAIL_INFO_TYPE_TRACKING_FIRST_VIDEO_DECODER_CREATE_START = 7;
    @TPNativeKeyMap.MapDetailInfoType(9)
    public static final int TP_PLAYER_DETAIL_INFO_TYPE_TRACKING_FIRST_VIDEO_FRAME_RENDERED = 9;
    @TPNativeKeyMap.MapDetailInfoType(6)
    public static final int TP_PLAYER_DETAIL_INFO_TYPE_TRACKING_PLAYER_SCHEDULING_THREAD_ON_PREAPRED = 6;
    @TPNativeKeyMap.MapDetailInfoType(1)
    public static final int TP_PLAYER_DETAIL_INFO_TYPE_TRACKING_PLAYER_SCHEDULING_THREAD_PREPARE_START = 1;
    public static final int TP_PLAYER_DETAIL_INFO_TYPE_TRACKING_TP_API_ON_FIRST_AUDIO_FRAME_RENDERED = 1006;
    public static final int TP_PLAYER_DETAIL_INFO_TYPE_TRACKING_TP_API_ON_FIRST_VIDEO_FRAME_RENDERED = 1005;
    public static final int TP_PLAYER_DETAIL_INFO_TYPE_TRACKING_TP_API_ON_PREPARED = 1004;
    public static final int TP_PLAYER_DETAIL_INFO_TYPE_TRACKING_TP_API_PREPARE_START = 1003;
    public static final int TP_PLAYER_DETAIL_INFO_TYPE_TRACKING_TP_API_SET_DATA_SOURCE_END = 1001;
    public static final int TP_PLAYER_DETAIL_INFO_TYPE_TRACKING_TP_API_SET_DATA_SOURCE_START = 1000;
    @TPNativeKeyMap.MapDetailInfoType(12)
    public static final int TP_PLAYER_DETAIL_INFO_TYPE_TRACKING_VIDEO_MEDIACODEC_CONFIGURE_END = 12;
    @TPNativeKeyMap.MapDetailInfoType(11)
    public static final int TP_PLAYER_DETAIL_INFO_TYPE_TRACKING_VIDEO_MEDIACODEC_CONFIGURE_START = 11;
    @TPNativeKeyMap.MapDetailInfoType(14)
    public static final int TP_PLAYER_DETAIL_INFO_TYPE_TRACKING_VIDEO_MEDIACODEC_START_END = 14;
    @TPNativeKeyMap.MapDetailInfoType(13)
    public static final int TP_PLAYER_DETAIL_INFO_TYPE_TRACKING_VIDEO_MEDIACODEC_START_START = 13;
    @TPNativeKeyMap.MapDetailInfoType(-1)
    public static final int TP_PLAYER_DETAIL_INFO_TYPE_UNKNOWN = -1;
    public long timeSince1970Ms;
    @TPPlayerDetailInfoType
    public int type;

    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPPlayerDetailInfo$TPPlayerDetailInfoType.class */
    public @interface TPPlayerDetailInfoType {
    }

    public TPPlayerDetailInfo(@TPPlayerDetailInfoType int i) {
        this(i, System.currentTimeMillis());
    }

    public TPPlayerDetailInfo(@TPPlayerDetailInfoType int i, long j) {
        this.type = i;
        this.timeSince1970Ms = j;
    }
}

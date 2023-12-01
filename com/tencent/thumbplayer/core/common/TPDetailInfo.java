package com.tencent.thumbplayer.core.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/common/TPDetailInfo.class */
public class TPDetailInfo {
    public static final int TP_DETAIL_INFO_TYPE_TRACKING_AUDIO_MEDIACODEC_CONFIGURE_END = 16;
    public static final int TP_DETAIL_INFO_TYPE_TRACKING_AUDIO_MEDIACODEC_CONFIGURE_START = 15;
    public static final int TP_DETAIL_INFO_TYPE_TRACKING_AUDIO_MEDIACODEC_START_END = 18;
    public static final int TP_DETAIL_INFO_TYPE_TRACKING_AUDIO_MEDIACODEC_START_START = 17;
    public static final int TP_DETAIL_INFO_TYPE_TRACKING_DEMUXER_FILE_OPEN_END = 4;
    public static final int TP_DETAIL_INFO_TYPE_TRACKING_DEMUXER_FILE_OPEN_START = 3;
    public static final int TP_DETAIL_INFO_TYPE_TRACKING_DEMUX_THREAD_ON_PREAPRED = 5;
    public static final int TP_DETAIL_INFO_TYPE_TRACKING_DEMUX_THREAD_PREPARE_START = 2;
    public static final int TP_DETAIL_INFO_TYPE_TRACKING_FIRST_AUDIO_DECODER_CREATE_START = 8;
    public static final int TP_DETAIL_INFO_TYPE_TRACKING_FIRST_AUDIO_FRAME_RENDERED = 10;
    public static final int TP_DETAIL_INFO_TYPE_TRACKING_FIRST_START = 0;
    public static final int TP_DETAIL_INFO_TYPE_TRACKING_FIRST_VIDEO_DECODER_CREATE_START = 7;
    public static final int TP_DETAIL_INFO_TYPE_TRACKING_FIRST_VIDEO_FRAME_RENDERED = 9;
    public static final int TP_DETAIL_INFO_TYPE_TRACKING_PLAYER_SCHEDULING_THREAD_ON_PREAPRED = 6;
    public static final int TP_DETAIL_INFO_TYPE_TRACKING_PLAYER_SCHEDULING_THREAD_PREPARE_START = 1;
    public static final int TP_DETAIL_INFO_TYPE_TRACKING_VIDEO_MEDIACODEC_CONFIGURE_END = 12;
    public static final int TP_DETAIL_INFO_TYPE_TRACKING_VIDEO_MEDIACODEC_CONFIGURE_START = 11;
    public static final int TP_DETAIL_INFO_TYPE_TRACKING_VIDEO_MEDIACODEC_START_END = 14;
    public static final int TP_DETAIL_INFO_TYPE_TRACKING_VIDEO_MEDIACODEC_START_START = 13;
    public static final int TP_DETAIL_INFO_TYPE_UNKNOWN = -1;
    public long timeSince1970Us;
    @TPDetailInfoType
    public int type;

    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/common/TPDetailInfo$TPDetailInfoType.class */
    public @interface TPDetailInfoType {
    }
}

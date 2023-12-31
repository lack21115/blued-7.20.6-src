package com.tencent.liteav.videobase.videobase;

import com.huawei.openalliance.ad.constant.ab;
import com.tencent.thumbplayer.api.TPErrorCode;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/videobase/i.class */
public enum i {
    STATUS_VIDEO_NONE(0),
    STATUS_VIDEO_CAPTURE_REAL_FRAME_RATE(1),
    STATUS_CUSTOM_CAPTURE_REAL_FRAME_RATE(3),
    STATUS_CUSTOM_CAPTURE_ENABLED(4),
    STATUS_VIDEO_PREPROCESS_REAL_FRAME_RATE(100),
    STATUS_VIDEO_PREPROCESS_AVERAGE_PROCESS_COST(101),
    STATUS_VIDEO_PREPROCESS_AVERAGE_RECOGNIZE_COST(102),
    STATUS_VIDEO_PREPROCESS_FPS_IN(103),
    STATUS_VIDEO_ENCODE_REAL_ENCODE_BITRATE(201),
    STATUS_VIDEO_ENCODE_REAL_FRAME_RATE(202),
    STATUS_VIDEO_ENCODE_AVERAGE_ENCODE_COST(203),
    STATUS_LOCAL_VIDEO_STREAM_ORIENTATION(301),
    STATUS_AUTO_FOCUS_ENABLED(302),
    STATUS_LOCAL_VIDEO_STREAM_IS_PUBLISHING(303),
    STATUS_VIDEO_SW_ENCODE_TASK_COST(402),
    STATUS_VIDEO_HW_ENCODE_TASK_COST(403),
    STATUS_VIDEO_SW_DECODE_TASK_COST(404),
    STATUS_VIDEO_HW_DECODE_TASK_COST(405),
    STATUS_VIDEO_RENDER_AVARAGE_FPS(500),
    STATUS_CUSTOM_RENDER_ENABLED(501),
    STATUS_VIDEO_RENDER_RESOLUTION(502),
    STATUS_VIDEO_RENDER_REEZE(503),
    STATUS_VIDEO_FRAME_RENDER_PTS(601),
    STATUS_VIDEO_CONSUMER_RECEIVE_FPS(700),
    STATUS_VIDEO_DECODER_STREAM_CODEC_TYPE(802),
    STATUS_VIDEO_DECODER_PENDING_FRAME_COUNT(803),
    STATUS_VIDEO_DECODER_FRAMERATE(ab.Y),
    STATUS_VIDEO_DECODER_ERROR(805),
    STATUS_VIDEO_CAPTURE_FRAME(1000),
    STATUS_VIDEO_INCOME_FRAME(1001),
    STATUS_VIDEO_PREPROCESS_TIME(2000),
    STATUS_VIDEO_PREPROCESS_BEAUTY_SETTINGS(2001),
    STATUS_VIDEO_ENCODER_TYPE(3000),
    STATUS_VIDEO_ENCODER_FRAME(3001),
    STATUS_VIDEO_ENCODER_COST(3004),
    STATUS_VIDEO_ENCODER_CODEC(3005),
    STATUS_VIDEO_ENCODER_ABILITY(3006),
    STATUS_VIDEO_DECODER_TYPE(TPErrorCode.TP_ERROR_TYPE_DOWNLOAD_PROXY),
    STATUS_VIDEO_DECODER_FRAME(4001),
    STATUS_VIDEO_DECODER_WIDTH(4002),
    STATUS_VIDEO_DECODER_HEIGHT(4003),
    STATUS_VIDEO_DECODER_COST(4004),
    STATUS_VIDEO_DECODER_CACHE(4005),
    STATUS_VIDEO_DECODER_CODEC(4006),
    STATUS_VIDEO_RENDER_FRAME(5000),
    STATUS_VIDEO_RENDER_FRAME_WIDTH(5001),
    STATUS_VIDEO_RENDER_FRAME_HEIGHT(5002),
    STATUS_VIDEO_RENDER_RESET_FREEZE_TIME(5003),
    STATUS_VIDEO_RECEIVED_FRAME(6000),
    STATUS_VIDEO_DROP_FRAME(6001);
    
    private static final i[] Y = values();
    int value;

    i(int i) {
        this.value = i;
    }
}

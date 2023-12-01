package com.tencent.thumbplayer.core.downloadproxy.api;

import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/downloadproxy/api/ITPPlayListener.class */
public interface ITPPlayListener {
    public static final int MESSAGE_FLV_PRELOAD_STATUS = 5;
    public static final int MESSAGE_HTTP_HEADER = 3;
    public static final int MESSAGE_MULTI_NETWORK = 7;
    public static final int MESSAGE_NOTIFY_M3U8_CONTENT = 4;
    public static final int MESSAGE_NOTIFY_PLAYER_SWITCH_DEFINITION = 2;
    public static final int MESSAGE_PLAY_VIDEO_NO_MORE_CACHE = 1;
    public static final int MESSAGE_QUIC_DOWNLOAD_STATUS = 6;
    public static final int MESSAGE_TAB_TESTID = 8;

    long getAdvRemainTime();

    String getContentType(int i, String str);

    int getCurrentPlayClipNo();

    long getCurrentPlayOffset();

    long getCurrentPosition();

    String getDataFilePath(int i, String str);

    long getDataTotalSize(int i, String str);

    Object getPlayInfo(long j);

    Object getPlayInfo(String str);

    long getPlayerBufferLength();

    void onDownloadCdnUrlExpired(Map<String, String> map);

    void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4);

    void onDownloadCdnUrlUpdate(String str);

    void onDownloadError(int i, int i2, String str);

    void onDownloadFinish();

    void onDownloadProgressUpdate(int i, int i2, long j, long j2, String str);

    void onDownloadProtocolUpdate(String str, String str2);

    void onDownloadStatusUpdate(int i);

    Object onPlayCallback(int i, Object obj, Object obj2, Object obj3, Object obj4);

    int onReadData(int i, String str, long j, long j2);

    int onStartReadData(int i, String str, long j, long j2);

    int onStopReadData(int i, String str, int i2);
}

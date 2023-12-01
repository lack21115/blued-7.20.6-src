package com.tencent.liteav.thumbplayer;

import android.graphics.Rect;
import com.huawei.hms.framework.common.ExceptionCode;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.txcplayer.d.d;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPPlayerMsg;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import java.lang.ref.WeakReference;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/thumbplayer/ThumbMediaPlayerListener.class */
class ThumbMediaPlayerListener implements ITPPlayerListener.IOnAudioFrameOutputListener, ITPPlayerListener.IOnAudioProcessFrameOutputListener, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnStateChangeListener, ITPPlayerListener.IOnStopAsyncCompleteListener, ITPPlayerListener.IOnSubtitleDataListener, ITPPlayerListener.IOnSubtitleFrameOutListener, ITPPlayerListener.IOnVideoFrameOutListener, ITPPlayerListener.IOnVideoProcessFrameOutputListener, ITPPlayerListener.IOnVideoSizeChangedListener {
    private final String TAG = ThumbMediaPlayerListener.class.getName();
    private final WeakReference<ThumbMediaPlayer> mThumbMediaPlayer;

    public ThumbMediaPlayerListener(ThumbMediaPlayer thumbMediaPlayer) {
        this.mThumbMediaPlayer = new WeakReference<>(thumbMediaPlayer);
    }

    private int transferError(int i, int i2) {
        if (i != 1001) {
            if (i != 1102) {
                if (i != 1210) {
                    if (i != 1211) {
                        if (i != 1220) {
                            if (i != 1221) {
                                if (i != 1230) {
                                    if (i != 1231) {
                                        if (i == 2000 || i == 2001) {
                                            return transferSystemPlayerError(i2);
                                        }
                                        return 1;
                                    }
                                    return -1007;
                                }
                                return -1010;
                            }
                            return -1007;
                        }
                        ThumbMediaPlayer thumbMediaPlayer = this.mThumbMediaPlayer.get();
                        if (thumbMediaPlayer != null) {
                            String propertyString = thumbMediaPlayer.getTPPPlayer().getPropertyString(0);
                            if (propertyString == null || !(propertyString.toLowerCase().contains("hevc") || propertyString.toLowerCase().contains("h265"))) {
                                thumbMediaPlayer.notifyVideoDecoderError();
                                return -1010;
                            }
                            thumbMediaPlayer.notifyHevcVideoDecoderError();
                            return -1010;
                        }
                        return -1010;
                    }
                    return -1007;
                }
                return -1010;
            }
            return -1007;
        }
        return transferGeneralError(i2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x008d, code lost:
        if (r0.toLowerCase().contains("h265") != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int transferGeneralError(int r4) {
        /*
            r3 = this;
            r0 = -1007(0xfffffffffffffc11, float:NaN)
            r6 = r0
            r0 = r6
            r5 = r0
            r0 = r4
            switch(r0) {
                case 11010101: goto L9b;
                case 11010103: goto L9b;
                case 11010104: goto L4f;
                case 11010201: goto L4b;
                case 11010202: goto L4b;
                case 11010401: goto L4b;
                case 11010402: goto L4b;
                default: goto L48;
            }
        L48:
            goto L99
        L4b:
            r0 = -1010(0xfffffffffffffc0e, float:NaN)
            return r0
        L4f:
            r0 = r3
            java.lang.ref.WeakReference<com.tencent.liteav.thumbplayer.ThumbMediaPlayer> r0 = r0.mThumbMediaPlayer
            java.lang.Object r0 = r0.get()
            com.tencent.liteav.thumbplayer.ThumbMediaPlayer r0 = (com.tencent.liteav.thumbplayer.ThumbMediaPlayer) r0
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L99
            r0 = r7
            com.tencent.thumbplayer.api.ITPPlayer r0 = r0.getTPPPlayer()
            r1 = 0
            java.lang.String r0 = r0.getPropertyString(r1)
            r8 = r0
            r0 = r6
            r5 = r0
            r0 = r8
            if (r0 == 0) goto L9b
            r0 = r8
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r1 = "hevc"
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L90
            r0 = r6
            r5 = r0
            r0 = r8
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r1 = "h265"
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L9b
        L90:
            r0 = r7
            r0.notifyHLSKeyError()
            r0 = -1007(0xfffffffffffffc11, float:NaN)
            return r0
        L99:
            r0 = 1
            r5 = r0
        L9b:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.thumbplayer.ThumbMediaPlayerListener.transferGeneralError(int):int");
    }

    private int transferInfo(int i) {
        int i2 = 1006;
        if (i == 104) {
            i2 = 2008;
        } else if (i == 106) {
            ThumbMediaPlayer thumbMediaPlayer = this.mThumbMediaPlayer.get();
            if (thumbMediaPlayer != null) {
                thumbMediaPlayer.onReceiveFirstVideoRenderEvent();
                return -1;
            }
            return -1;
        } else if (i == 1001) {
            LiteavLog.i(this.TAG, "TP_PLAYER_INFO_LONG0_ALL_DOWNLOAD_FINISH");
            ThumbMediaPlayer thumbMediaPlayer2 = this.mThumbMediaPlayer.get();
            if (thumbMediaPlayer2 != null) {
                thumbMediaPlayer2.updateTcpSpeed(0L);
                return -1;
            }
            return -1;
        } else if (i != 1006) {
            if (i != 200) {
                return i != 201 ? -1 : 2014;
            }
            return 2007;
        }
        return i2;
    }

    private int transferSystemPlayerError(int i) {
        switch (i) {
            case ExceptionCode.NETWORK_UNREACHABLE /* 10000200 */:
                return 200;
            case 10001004:
                return -1004;
            case 10001007:
                return -1007;
            case 10001010:
                return -1010;
            default:
                return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void attachToPlayer() {
        ITPPlayer tPPPlayer;
        ThumbMediaPlayer thumbMediaPlayer = this.mThumbMediaPlayer.get();
        if (thumbMediaPlayer == null || (tPPPlayer = thumbMediaPlayer.getTPPPlayer()) == null) {
            return;
        }
        tPPPlayer.setOnPreparedListener(this);
        tPPPlayer.setOnCompletionListener(this);
        tPPPlayer.setOnInfoListener(this);
        tPPPlayer.setOnErrorListener(this);
        tPPPlayer.setOnSeekCompleteListener(this);
        tPPPlayer.setOnVideoSizeChangedListener(this);
        tPPPlayer.setOnSubtitleDataListener(this);
        tPPPlayer.setOnSubtitleFrameOutListener(this);
        tPPPlayer.setOnVideoFrameOutListener(this);
        tPPPlayer.setOnAudioFrameOutputListener(this);
        tPPPlayer.setOnVideoProcessFrameOutputListener(this);
        tPPPlayer.setOnAudioProcessFrameOutputListener(this);
        tPPPlayer.setOnPlayerStateChangeListener(this);
        tPPPlayer.setOnStopAsyncCompleteListener(this);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnAudioFrameOutputListener
    public void onAudioFrameOut(ITPPlayer iTPPlayer, TPAudioFrameBuffer tPAudioFrameBuffer) {
        LiteavLog.i(this.TAG, "ThumbMediaPlayerListener onAudioFrameOut");
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnAudioProcessFrameOutputListener
    public TPPostProcessFrameBuffer onAudioProcessFrameOut(ITPPlayer iTPPlayer, TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
        return tPPostProcessFrameBuffer;
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener
    public void onCompletion(ITPPlayer iTPPlayer) {
        ThumbMediaPlayer thumbMediaPlayer = this.mThumbMediaPlayer.get();
        if (thumbMediaPlayer != null) {
            thumbMediaPlayer.notifyOnCompletion();
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener
    public void onError(ITPPlayer iTPPlayer, int i, int i2, long j, long j2) {
        if (i != 1000) {
            String str = this.TAG;
            LiteavLog.w(str, "onError type: " + i + " code: " + i2);
            ThumbMediaPlayer thumbMediaPlayer = this.mThumbMediaPlayer.get();
            if (thumbMediaPlayer != null) {
                thumbMediaPlayer.notifyOnError(transferError(i, i2), (int) j);
            }
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener
    public void onInfo(ITPPlayer iTPPlayer, int i, long j, long j2, Object obj) {
        ThumbMediaPlayer thumbMediaPlayer = this.mThumbMediaPlayer.get();
        if (thumbMediaPlayer != null) {
            int transferInfo = transferInfo(i);
            int i2 = (int) j;
            if (obj != null && (obj instanceof TPPlayerMsg.TPCDNURLInfo)) {
                TPPlayerMsg.TPCDNURLInfo tPCDNURLInfo = (TPPlayerMsg.TPCDNURLInfo) obj;
                LiteavLog.i(this.TAG, "onInfo TPCDNURLInfo:cdnIp:" + tPCDNURLInfo.cdnIp + ":uIp:" + tPCDNURLInfo.uIp + ": url: " + tPCDNURLInfo.url + ":errorStr: " + tPCDNURLInfo.errorStr);
            }
            if (obj != null && (obj instanceof TPPlayerMsg.TPDownLoadProgressInfo)) {
                TPPlayerMsg.TPDownLoadProgressInfo tPDownLoadProgressInfo = (TPPlayerMsg.TPDownLoadProgressInfo) obj;
                thumbMediaPlayer.updateBitrate(tPDownLoadProgressInfo.totalFileSize);
                long j3 = tPDownLoadProgressInfo.downloadSpeedKBps;
                long j4 = j3;
                if (j3 < 0) {
                    j4 = j3;
                    if (tPDownLoadProgressInfo.extraInfo != null) {
                        String[] split = tPDownLoadProgressInfo.extraInfo.split(",");
                        j4 = j3;
                        if (split != null) {
                            int length = split.length;
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                j4 = j3;
                                if (i4 < length) {
                                    String str = split[i4];
                                    if (str != null && str.contains("httpAvgSpeedKB")) {
                                        j4 = Long.valueOf(str.substring(str.indexOf(":") + 1, str.length()).trim()).longValue();
                                        break;
                                    }
                                    i3 = i4 + 1;
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                }
                thumbMediaPlayer.updateTcpSpeed(j4 * 1024);
            }
            if (obj instanceof TPPlayerMsg.TPProtocolInfo) {
                TPPlayerMsg.TPProtocolInfo tPProtocolInfo = (TPPlayerMsg.TPProtocolInfo) obj;
                LiteavLog.i(this.TAG, "onInfo TPProtocolInfo:protocolName:" + tPProtocolInfo.protocolName + ":protocolVersion:" + tPProtocolInfo.protocolVersion);
            }
            if (obj instanceof TPPlayerMsg.TPVideoCropInfo) {
                TPPlayerMsg.TPVideoCropInfo tPVideoCropInfo = (TPPlayerMsg.TPVideoCropInfo) obj;
                LiteavLog.i(this.TAG, "onInfo TPVideoCropInfo:cropBottom:" + tPVideoCropInfo.cropBottom + ":cropLeft:" + tPVideoCropInfo.cropLeft + ": cropRight: " + tPVideoCropInfo.cropRight + ":cropTop: " + tPVideoCropInfo.cropTop + ":height:" + tPVideoCropInfo.height + ":width:" + tPVideoCropInfo.width);
            }
            thumbMediaPlayer.notifyOnInfo(transferInfo, i2, 0, obj);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener
    public void onPrepared(ITPPlayer iTPPlayer) {
        LiteavLog.i(this.TAG, "ThumbMediaPlayerListener onPrepared");
        ThumbMediaPlayer thumbMediaPlayer = this.mThumbMediaPlayer.get();
        if (thumbMediaPlayer != null) {
            thumbMediaPlayer.notifyOnPrepared();
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnSeekCompleteListener
    public void onSeekComplete(ITPPlayer iTPPlayer) {
        LiteavLog.i(this.TAG, "ThumbMediaPlayerListener onSeekComplete");
        ThumbMediaPlayer thumbMediaPlayer = this.mThumbMediaPlayer.get();
        if (thumbMediaPlayer != null) {
            thumbMediaPlayer.notifyOnSeekComplete();
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnStateChangeListener
    public void onStateChange(int i, int i2) {
        String str = this.TAG;
        LiteavLog.i(str, "ThumbMediaPlayerListener onStateChange:preState" + i + ": curState:" + i2);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnStopAsyncCompleteListener
    public void onStopAsyncComplete(ITPPlayer iTPPlayer) {
        LiteavLog.i(this.TAG, "ThumbMediaPlayerListener onStopAsyncComplete");
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnSubtitleDataListener
    public void onSubtitleData(ITPPlayer iTPPlayer, TPSubtitleData tPSubtitleData) {
        ThumbMediaPlayer thumbMediaPlayer = this.mThumbMediaPlayer.get();
        if (thumbMediaPlayer == null || tPSubtitleData == null) {
            return;
        }
        String str = this.TAG;
        LiteavLog.i(str, "ThumbMediaPlayerListener onSubtitleData:" + tPSubtitleData.subtitleData);
        thumbMediaPlayer.notifyOnTimedText(new d(new Rect(0, 0, 1, 1), tPSubtitleData.subtitleData));
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnSubtitleFrameOutListener
    public void onSubtitleFrameOut(ITPPlayer iTPPlayer, TPSubtitleFrameBuffer tPSubtitleFrameBuffer) {
        LiteavLog.i(this.TAG, "ThumbMediaPlayerListener onSubtitleFrameOut");
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoFrameOutListener
    public void onVideoFrameOut(ITPPlayer iTPPlayer, TPVideoFrameBuffer tPVideoFrameBuffer) {
        LiteavLog.i(this.TAG, "ThumbMediaPlayerListener onVideoFrameOut");
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoProcessFrameOutputListener
    public TPPostProcessFrameBuffer onVideoProcessFrameOut(ITPPlayer iTPPlayer, TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
        LiteavLog.i(this.TAG, "ThumbMediaPlayerListener onVideoProcessFrameOut");
        return tPPostProcessFrameBuffer;
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoSizeChangedListener
    public void onVideoSizeChanged(ITPPlayer iTPPlayer, long j, long j2) {
        ThumbMediaPlayer thumbMediaPlayer = this.mThumbMediaPlayer.get();
        if (thumbMediaPlayer != null) {
            String str = this.TAG;
            LiteavLog.i(str, "ThumbMediaPlayerListener on:videoSizeChanged:width:" + j + ":height:" + j2);
            thumbMediaPlayer.notifyOnVideoSizeChanged((int) j, (int) j2, thumbMediaPlayer.getVideoSarNum(), thumbMediaPlayer.getVideoSarDen(), null);
        }
    }
}

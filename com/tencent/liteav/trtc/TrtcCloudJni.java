package com.tencent.liteav.trtc;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.liteav.base.ThreadUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.o;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.trtc.TRTCStatistics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.microedition.khronos.egl.EGLContext;

@JNINamespace("liteav::trtc")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/trtc/TrtcCloudJni.class */
public class TrtcCloudJni {
    private static final Object INIT_LOCK = new Object();
    private static final String TAG = "TrtcCloudJni";
    private static boolean mHasInited = false;
    private TRTCCloudListener.TRTCAudioFrameListener mAudioFrameListener;
    private TRTCCloudListener.TRTCVideoFrameListener mCalledGLCreatedFrameListener;
    private View mFloatingWindow;
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    private TRTCCloudListener mListener;
    private Handler mListenerHandler;
    private String mLocalUserId;
    private final a<TRTCCloudListener.TRTCVideoRenderListener> mLocalVideoRenderListenerWrapper;
    private long mNativeTrtcCloudJni;
    private final ReentrantReadWriteLock mReadWriteLock;
    private final Map<String, a<TRTCCloudListener.TRTCVideoRenderListener>> mRemoteVideoRenderListenerMap;
    private TRTCCloudListener.TRTCSnapshotListener mSnapshotListener;
    private final a<TRTCCloudListener.TRTCVideoFrameListener> mVideoFrameListenerWrapper;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/trtc/TrtcCloudJni$AudioFrame.class */
    static class AudioFrame {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCAudioFrame f22755a;

        public AudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
            this.f22755a = tRTCAudioFrame;
        }

        public int getChannel() {
            return this.f22755a.channel;
        }

        public byte[] getData() {
            return this.f22755a.data;
        }

        public int getSampleRate() {
            return this.f22755a.sampleRate;
        }

        public long getTimestamp() {
            return this.f22755a.timestamp;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/trtc/TrtcCloudJni$AudioParallelParams.class */
    static class AudioParallelParams {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCAudioParallelParams f22756a;

        public AudioParallelParams(TRTCCloudDef.TRTCAudioParallelParams tRTCAudioParallelParams) {
            this.f22756a = tRTCAudioParallelParams;
        }

        public String[] getIncludeUsers() {
            return (String[]) this.f22756a.includeUsers.toArray(new String[this.f22756a.includeUsers.size()]);
        }

        public int getMaxCount() {
            return this.f22756a.maxCount;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/trtc/TrtcCloudJni$AudioRecordingParams.class */
    static class AudioRecordingParams {

        /* renamed from: a  reason: collision with root package name */
        private final TRTCCloudDef.TRTCAudioRecordingParams f22757a;

        public AudioRecordingParams(TRTCCloudDef.TRTCAudioRecordingParams tRTCAudioRecordingParams) {
            this.f22757a = tRTCAudioRecordingParams;
        }

        public int getContent() {
            return this.f22757a.recordingContent;
        }

        public String getFilePath() {
            return this.f22757a.filePath;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/trtc/TrtcCloudJni$EnterRoomParams.class */
    static class EnterRoomParams {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCParams f22758a;

        public EnterRoomParams(TRTCCloudDef.TRTCParams tRTCParams) {
            this.f22758a = tRTCParams;
        }

        public String getBusinessInfo() {
            return this.f22758a.businessInfo;
        }

        public String getPrivateMapKey() {
            return this.f22758a.privateMapKey;
        }

        public String getRecordId() {
            return this.f22758a.userDefineRecordId;
        }

        public int getRole() {
            return this.f22758a.role;
        }

        public int getRoomId() {
            return this.f22758a.roomId;
        }

        public int getSdkAppId() {
            return this.f22758a.sdkAppId;
        }

        public String getStrRoomId() {
            return this.f22758a.strRoomId;
        }

        public String getStreamId() {
            return this.f22758a.streamId;
        }

        public String getUserId() {
            return this.f22758a.userId;
        }

        public String getUserSig() {
            return this.f22758a.userSig;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/trtc/TrtcCloudJni$LocalRecordingParams.class */
    static class LocalRecordingParams {

        /* renamed from: a  reason: collision with root package name */
        private final TRTCCloudDef.TRTCLocalRecordingParams f22759a;

        public LocalRecordingParams(TRTCCloudDef.TRTCLocalRecordingParams tRTCLocalRecordingParams) {
            this.f22759a = tRTCLocalRecordingParams;
        }

        public String getFilePath() {
            return this.f22759a.filePath;
        }

        public int getInterval() {
            return this.f22759a.interval;
        }

        public int getRecordType() {
            return this.f22759a.recordType;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/trtc/TrtcCloudJni$LocalStatistics.class */
    static class LocalStatistics {

        /* renamed from: a  reason: collision with root package name */
        private TRTCStatistics.TRTCLocalStatistics f22760a = new TRTCStatistics.TRTCLocalStatistics();

        LocalStatistics() {
        }

        public static void addLocalStatistics(LocalStatistics localStatistics, ArrayList<LocalStatistics> arrayList) {
            arrayList.add(localStatistics);
        }

        public static LocalStatistics createLocalStatistics(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            LocalStatistics localStatistics = new LocalStatistics();
            localStatistics.f22760a.streamType = i;
            localStatistics.f22760a.width = i2;
            localStatistics.f22760a.height = i3;
            localStatistics.f22760a.frameRate = i4;
            localStatistics.f22760a.videoBitrate = i5;
            localStatistics.f22760a.audioBitrate = i7;
            localStatistics.f22760a.audioSampleRate = i6;
            localStatistics.f22760a.audioCaptureState = i8;
            return localStatistics;
        }

        public static ArrayList<LocalStatistics> createLocalStatisticsArray() {
            return new ArrayList<>();
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/trtc/TrtcCloudJni$MixUser.class */
    static class MixUser {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCMixUser f22761a;

        private MixUser(TRTCCloudDef.TRTCMixUser tRTCMixUser) {
            this.f22761a = tRTCMixUser;
        }

        /* synthetic */ MixUser(TRTCCloudDef.TRTCMixUser tRTCMixUser, byte b) {
            this(tRTCMixUser);
        }

        public int getHeight() {
            return this.f22761a.height;
        }

        public String getImage() {
            return TextUtils.isEmpty(this.f22761a.image) ? "" : this.f22761a.image;
        }

        public int getInputType() {
            return this.f22761a.inputType;
        }

        public boolean getPureAudio() {
            return this.f22761a.pureAudio;
        }

        public int getRenderMode() {
            return this.f22761a.renderMode;
        }

        public String getRoomId() {
            return TextUtils.isEmpty(this.f22761a.roomId) ? "" : this.f22761a.roomId;
        }

        public int getSoundLevel() {
            return this.f22761a.soundLevel;
        }

        public int getStreamType() {
            return this.f22761a.streamType;
        }

        public String getUserId() {
            return TextUtils.isEmpty(this.f22761a.userId) ? "" : this.f22761a.userId;
        }

        public int getWidth() {
            return this.f22761a.width;
        }

        public int getX() {
            return this.f22761a.x;
        }

        public int getY() {
            return this.f22761a.y;
        }

        public int getZOrder() {
            return this.f22761a.zOrder;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/trtc/TrtcCloudJni$PublishCDNParams.class */
    public static class PublishCDNParams {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCPublishCDNParam f22762a;

        public PublishCDNParams(TRTCCloudDef.TRTCPublishCDNParam tRTCPublishCDNParam) {
            this.f22762a = tRTCPublishCDNParam;
        }

        public int getAppId() {
            return this.f22762a.appId;
        }

        public int getBizId() {
            return this.f22762a.bizId;
        }

        public String getStreamId() {
            return TextUtils.isEmpty(this.f22762a.streamId) ? "" : this.f22762a.streamId;
        }

        public String getUrl() {
            return TextUtils.isEmpty(this.f22762a.url) ? "" : this.f22762a.url;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/trtc/TrtcCloudJni$PublishCdnUrl.class */
    static class PublishCdnUrl {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCPublishCdnUrl f22763a;

        public PublishCdnUrl(TRTCCloudDef.TRTCPublishCdnUrl tRTCPublishCdnUrl) {
            this.f22763a = tRTCPublishCdnUrl;
        }

        public boolean getIsInternalLine() {
            return this.f22763a.isInternalLine;
        }

        public String getRtmpUrl() {
            return this.f22763a.rtmpUrl != null ? this.f22763a.rtmpUrl : "";
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/trtc/TrtcCloudJni$PublishTarget.class */
    static class PublishTarget {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCPublishTarget f22764a;

        public PublishTarget(TRTCCloudDef.TRTCPublishTarget tRTCPublishTarget) {
            this.f22764a = tRTCPublishTarget;
        }

        public int getMode() {
            return this.f22764a.mode;
        }

        public PublishCdnUrl[] getPublishCdnUrls() {
            if (this.f22764a.cdnUrlList == null) {
                return null;
            }
            PublishCdnUrl[] publishCdnUrlArr = new PublishCdnUrl[this.f22764a.cdnUrlList.size()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f22764a.cdnUrlList.size()) {
                    return publishCdnUrlArr;
                }
                publishCdnUrlArr[i2] = new PublishCdnUrl(this.f22764a.cdnUrlList.get(i2));
                i = i2 + 1;
            }
        }

        public TRTCUser getTRTCUser() {
            return new TRTCUser(this.f22764a.mixStreamIdentity);
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/trtc/TrtcCloudJni$RemoteStatistics.class */
    static class RemoteStatistics {

        /* renamed from: a  reason: collision with root package name */
        public TRTCStatistics.TRTCRemoteStatistics f22765a = new TRTCStatistics.TRTCRemoteStatistics();

        RemoteStatistics() {
        }

        public static void addRemoteStatistics(RemoteStatistics remoteStatistics, ArrayList<RemoteStatistics> arrayList) {
            arrayList.add(remoteStatistics);
        }

        public static RemoteStatistics createRemoteStatistics(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
            RemoteStatistics remoteStatistics = new RemoteStatistics();
            remoteStatistics.f22765a.userId = str;
            remoteStatistics.f22765a.streamType = i;
            remoteStatistics.f22765a.width = i2;
            remoteStatistics.f22765a.height = i3;
            remoteStatistics.f22765a.frameRate = i4;
            remoteStatistics.f22765a.audioPacketLoss = i11;
            remoteStatistics.f22765a.videoPacketLoss = i5;
            remoteStatistics.f22765a.videoBlockRate = i8;
            remoteStatistics.f22765a.videoTotalBlockTime = i7;
            remoteStatistics.f22765a.videoBitrate = i6;
            remoteStatistics.f22765a.audioBitrate = i10;
            remoteStatistics.f22765a.audioSampleRate = i9;
            remoteStatistics.f22765a.audioTotalBlockTime = i12;
            remoteStatistics.f22765a.audioBlockRate = i13;
            remoteStatistics.f22765a.jitterBufferDelay = i14;
            remoteStatistics.f22765a.point2PointDelay = i15;
            remoteStatistics.f22765a.finalLoss = i16;
            return remoteStatistics;
        }

        public static ArrayList<RemoteStatistics> createRemoteStatisticsArray() {
            return new ArrayList<>();
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/trtc/TrtcCloudJni$ScreenShareParams.class */
    static class ScreenShareParams {

        /* renamed from: a  reason: collision with root package name */
        private final TRTCCloudDef.TRTCScreenShareParams f22766a;

        public ScreenShareParams(TRTCCloudDef.TRTCScreenShareParams tRTCScreenShareParams) {
            this.f22766a = tRTCScreenShareParams;
        }

        public Object getMediaProjection() {
            return this.f22766a.mediaProjection;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/trtc/TrtcCloudJni$SpeedTestParams.class */
    static class SpeedTestParams {

        /* renamed from: a  reason: collision with root package name */
        private final TRTCCloudDef.TRTCSpeedTestParams f22767a;

        public SpeedTestParams(TRTCCloudDef.TRTCSpeedTestParams tRTCSpeedTestParams) {
            this.f22767a = tRTCSpeedTestParams;
        }

        public int getExpectedDownBandwidth() {
            return this.f22767a.expectedDownBandwidth;
        }

        public int getExpectedUpBandwidth() {
            return this.f22767a.expectedUpBandwidth;
        }

        public int getSDKAppId() {
            return this.f22767a.sdkAppId;
        }

        public String getUserId() {
            return this.f22767a.userId;
        }

        public String getUserSig() {
            return this.f22767a.userSig;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/trtc/TrtcCloudJni$SpeedTestResult.class */
    static class SpeedTestResult {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCSpeedTestResult f22768a = new TRTCCloudDef.TRTCSpeedTestResult();

        SpeedTestResult() {
        }

        public static SpeedTestResult createSpeedTestResult(boolean z, String str, String str2, int i, float f, float f2, int i2, int i3, int i4) {
            SpeedTestResult speedTestResult = new SpeedTestResult();
            speedTestResult.f22768a.success = z;
            speedTestResult.f22768a.errMsg = str;
            speedTestResult.f22768a.ip = str2;
            speedTestResult.f22768a.quality = i;
            speedTestResult.f22768a.upLostRate = f;
            speedTestResult.f22768a.downLostRate = f2;
            speedTestResult.f22768a.rtt = i2;
            speedTestResult.f22768a.availableUpBandwidth = i3;
            speedTestResult.f22768a.availableDownBandwidth = i4;
            return speedTestResult;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/trtc/TrtcCloudJni$Statistics.class */
    static class Statistics {

        /* renamed from: a  reason: collision with root package name */
        private TRTCStatistics f22769a = new TRTCStatistics();

        Statistics() {
        }

        public static Statistics createStatistics(int i, int i2, int i3, int i4, int i5, int i6, long j, long j2, ArrayList<LocalStatistics> arrayList, ArrayList<RemoteStatistics> arrayList2) {
            Statistics statistics = new Statistics();
            statistics.f22769a.appCpu = i;
            statistics.f22769a.systemCpu = i2;
            statistics.f22769a.upLoss = i3;
            statistics.f22769a.downLoss = i4;
            statistics.f22769a.rtt = i5;
            statistics.f22769a.gatewayRtt = i6;
            statistics.f22769a.sendBytes = j;
            statistics.f22769a.receiveBytes = j2;
            statistics.f22769a.localArray = new ArrayList<>();
            statistics.f22769a.remoteArray = new ArrayList<>();
            if (arrayList != null) {
                Iterator<LocalStatistics> it = arrayList.iterator();
                while (it.hasNext()) {
                    statistics.f22769a.localArray.add(it.next().f22760a);
                }
            }
            if (arrayList2 != null) {
                Iterator<RemoteStatistics> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    statistics.f22769a.remoteArray.add(it2.next().f22765a);
                }
            }
            return statistics;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/trtc/TrtcCloudJni$StreamEncoderParam.class */
    static class StreamEncoderParam {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCStreamEncoderParam f22770a;

        public StreamEncoderParam(TRTCCloudDef.TRTCStreamEncoderParam tRTCStreamEncoderParam) {
            this.f22770a = tRTCStreamEncoderParam;
        }

        public int getAudioEncodedChannelNum() {
            return this.f22770a.audioEncodedChannelNum;
        }

        public int getAudioEncodedCodecType() {
            return this.f22770a.audioEncodedCodecType;
        }

        public int getAudioEncodedKbps() {
            return this.f22770a.audioEncodedKbps;
        }

        public int getAudioEncodedSampleRate() {
            return this.f22770a.audioEncodedSampleRate;
        }

        public int getVideoEncodedFPS() {
            return this.f22770a.videoEncodedFPS;
        }

        public int getVideoEncodedGOP() {
            return this.f22770a.videoEncodedGOP;
        }

        public int getVideoEncodedHeight() {
            return this.f22770a.videoEncodedHeight;
        }

        public int getVideoEncodedKbps() {
            return this.f22770a.videoEncodedKbps;
        }

        public int getVideoEncodedWidth() {
            return this.f22770a.videoEncodedWidth;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/trtc/TrtcCloudJni$StreamMixingConfig.class */
    static class StreamMixingConfig {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCStreamMixingConfig f22771a;

        public StreamMixingConfig(TRTCCloudDef.TRTCStreamMixingConfig tRTCStreamMixingConfig) {
            this.f22771a = tRTCStreamMixingConfig;
        }

        public TRTCUser[] getAudioMixUserList() {
            if (this.f22771a.audioMixUserList == null) {
                return null;
            }
            TRTCUser[] tRTCUserArr = new TRTCUser[this.f22771a.audioMixUserList.size()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f22771a.audioMixUserList.size()) {
                    return tRTCUserArr;
                }
                tRTCUserArr[i2] = new TRTCUser(this.f22771a.audioMixUserList.get(i2));
                i = i2 + 1;
            }
        }

        public int getBackgroundColor() {
            return this.f22771a.backgroundColor;
        }

        public String getBackgroundImage() {
            return this.f22771a.backgroundImage != null ? this.f22771a.backgroundImage : "";
        }

        public VideoLayout[] getVideoLayoutList() {
            if (this.f22771a.videoLayoutList == null) {
                return null;
            }
            VideoLayout[] videoLayoutArr = new VideoLayout[this.f22771a.videoLayoutList.size()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f22771a.videoLayoutList.size()) {
                    return videoLayoutArr;
                }
                videoLayoutArr[i2] = new VideoLayout(this.f22771a.videoLayoutList.get(i2));
                i = i2 + 1;
            }
        }

        public Watermark[] getWatermarkList() {
            if (this.f22771a.watermarkList == null) {
                return null;
            }
            Watermark[] watermarkArr = new Watermark[this.f22771a.watermarkList.size()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f22771a.watermarkList.size()) {
                    return watermarkArr;
                }
                watermarkArr[i2] = new Watermark(this.f22771a.watermarkList.get(i2));
                i = i2 + 1;
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/trtc/TrtcCloudJni$SwitchRoomConfig.class */
    static class SwitchRoomConfig {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCSwitchRoomConfig f22772a;

        public SwitchRoomConfig(TRTCCloudDef.TRTCSwitchRoomConfig tRTCSwitchRoomConfig) {
            this.f22772a = tRTCSwitchRoomConfig;
        }

        public String getPrivateMapKey() {
            return this.f22772a.privateMapKey != null ? this.f22772a.privateMapKey : "";
        }

        public int getRoomId() {
            return this.f22772a.roomId;
        }

        public String getStringRoomId() {
            return this.f22772a.strRoomId != null ? this.f22772a.strRoomId : "";
        }

        public String getUserSig() {
            return this.f22772a.userSig != null ? this.f22772a.userSig : "";
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/trtc/TrtcCloudJni$TRTCUser.class */
    static class TRTCUser {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCUser f22773a;

        public TRTCUser(TRTCCloudDef.TRTCUser tRTCUser) {
            this.f22773a = tRTCUser;
        }

        public int getIntRoomId() {
            return this.f22773a.intRoomId;
        }

        public String getStrRoomId() {
            return this.f22773a.strRoomId != null ? this.f22773a.strRoomId : "";
        }

        public String getUserId() {
            return this.f22773a.userId != null ? this.f22773a.userId : "";
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/trtc/TrtcCloudJni$TranscodingConfig.class */
    static class TranscodingConfig {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCTranscodingConfig f22774a;

        public TranscodingConfig(TRTCCloudDef.TRTCTranscodingConfig tRTCTranscodingConfig) {
            this.f22774a = tRTCTranscodingConfig;
        }

        public int getAppId() {
            return this.f22774a.appId;
        }

        public int getAudioBitrate() {
            return this.f22774a.audioBitrate;
        }

        public int getAudioChannels() {
            return this.f22774a.audioChannels;
        }

        public int getAudioSampleRate() {
            return this.f22774a.audioSampleRate;
        }

        public int getBackgroundColor() {
            return this.f22774a.backgroundColor;
        }

        public String getBackgroundImage() {
            return TextUtils.isEmpty(this.f22774a.backgroundImage) ? "" : this.f22774a.backgroundImage;
        }

        public int getBizId() {
            return this.f22774a.bizId;
        }

        public MixUser[] getMixUsers() {
            if (this.f22774a.mixUsers == null) {
                return null;
            }
            MixUser[] mixUserArr = new MixUser[this.f22774a.mixUsers.size()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f22774a.mixUsers.size()) {
                    return mixUserArr;
                }
                mixUserArr[i2] = new MixUser(this.f22774a.mixUsers.get(i2), (byte) 0);
                i = i2 + 1;
            }
        }

        public int getMode() {
            return this.f22774a.mode;
        }

        public String getStreamId() {
            return TextUtils.isEmpty(this.f22774a.streamId) ? "" : this.f22774a.streamId;
        }

        public int getVideoBitrate() {
            return this.f22774a.videoBitrate;
        }

        public int getVideoFramerate() {
            return this.f22774a.videoFramerate;
        }

        public int getVideoGOP() {
            return this.f22774a.videoGOP;
        }

        public int getVideoHeight() {
            return this.f22774a.videoHeight;
        }

        public int getVideoWidth() {
            return this.f22774a.videoWidth;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/trtc/TrtcCloudJni$VideoEncParams.class */
    static class VideoEncParams {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCVideoEncParam f22775a;

        public VideoEncParams(TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
            this.f22775a = tRTCVideoEncParam;
        }

        public int getMinVideoBitrate() {
            return this.f22775a.minVideoBitrate;
        }

        public int getVideoBitrate() {
            return this.f22775a.videoBitrate;
        }

        public int getVideoFps() {
            return this.f22775a.videoFps;
        }

        public int getVideoResolution() {
            return this.f22775a.videoResolution;
        }

        public int getVideoResolutionMode() {
            return this.f22775a.videoResolutionMode;
        }

        public boolean isEnableAdjustRes() {
            return this.f22775a.enableAdjustRes;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/trtc/TrtcCloudJni$VideoLayout.class */
    static class VideoLayout {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCVideoLayout f22776a;

        public VideoLayout(TRTCCloudDef.TRTCVideoLayout tRTCVideoLayout) {
            this.f22776a = tRTCVideoLayout;
        }

        public int getBackgroundColor() {
            return this.f22776a.backgroundColor;
        }

        public int getFillMode() {
            return this.f22776a.fillMode;
        }

        public int getHeight() {
            return this.f22776a.height;
        }

        public String getPlaceHolderImage() {
            return this.f22776a.placeHolderImage != null ? this.f22776a.placeHolderImage : "";
        }

        public TRTCUser getTRTCUser() {
            return new TRTCUser(this.f22776a.fixedVideoUser);
        }

        public int getVideoStreamType() {
            return this.f22776a.fixedVideoStreamType;
        }

        public int getWidth() {
            return this.f22776a.width;
        }

        public int getX() {
            return this.f22776a.x;
        }

        public int getY() {
            return this.f22776a.y;
        }

        public int getZOrder() {
            return this.f22776a.zOrder;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/trtc/TrtcCloudJni$Watermark.class */
    static class Watermark {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCWatermark f22777a;

        public Watermark(TRTCCloudDef.TRTCWatermark tRTCWatermark) {
            this.f22777a = tRTCWatermark;
        }

        public int getHeight() {
            return this.f22777a.height;
        }

        public String getWatermarkUrl() {
            return this.f22777a.watermarkUrl != null ? this.f22777a.watermarkUrl : "";
        }

        public int getWidth() {
            return this.f22777a.width;
        }

        public int getX() {
            return this.f22777a.x;
        }

        public int getY() {
            return this.f22777a.y;
        }

        public int getZOrder() {
            return this.f22777a.zOrder;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/trtc/TrtcCloudJni$a.class */
    static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public int f22778a;
        public GLConstants.PixelFormatType b;

        /* renamed from: c  reason: collision with root package name */
        public GLConstants.PixelBufferType f22779c;
        public T d;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        o.a();
    }

    public TrtcCloudJni() {
        this(0L);
    }

    public TrtcCloudJni(long j) {
        this.mNativeTrtcCloudJni = 0L;
        this.mLocalUserId = "";
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mReadWriteLock = reentrantReadWriteLock;
        this.mJniReadLock = reentrantReadWriteLock.readLock();
        this.mJniWriteLock = this.mReadWriteLock.writeLock();
        this.mFloatingWindow = null;
        if (j == 0) {
            this.mNativeTrtcCloudJni = nativeCreatePipeline(this);
        } else {
            this.mNativeTrtcCloudJni = nativeCreateSubCloud(this, j);
        }
        this.mVideoFrameListenerWrapper = new a<>((byte) 0);
        this.mLocalVideoRenderListenerWrapper = new a<>((byte) 0);
        this.mRemoteVideoRenderListenerMap = new HashMap();
        this.mListenerHandler = new Handler(Looper.getMainLooper());
    }

    private static int convertPixelBufferTypeToTRTCBufferType(GLConstants.PixelBufferType pixelBufferType) {
        if (pixelBufferType == GLConstants.PixelBufferType.BYTE_BUFFER) {
            return 1;
        }
        if (pixelBufferType == GLConstants.PixelBufferType.BYTE_ARRAY) {
            return 2;
        }
        return pixelBufferType == GLConstants.PixelBufferType.TEXTURE_2D ? 3 : 0;
    }

    private static int convertPixelFormatTypeToTRTCFormatType(GLConstants.PixelFormatType pixelFormatType) {
        if (pixelFormatType == GLConstants.PixelFormatType.I420) {
            return 1;
        }
        if (pixelFormatType == GLConstants.PixelFormatType.NV21) {
            return 4;
        }
        return pixelFormatType == GLConstants.PixelFormatType.RGBA ? 5 : 0;
    }

    private static GLConstants.PixelBufferType convertTRTCBufferTypeToPixelBufferType(int i) {
        return i != 1 ? i != 2 ? GLConstants.PixelBufferType.TEXTURE_2D : GLConstants.PixelBufferType.BYTE_ARRAY : GLConstants.PixelBufferType.BYTE_BUFFER;
    }

    private static GLConstants.PixelFormatType convertTRTCFormatTypeToPixelFormatType(int i) {
        if (i != 2) {
            if (i == 4) {
                return GLConstants.PixelFormatType.NV21;
            }
            if (i != 5) {
                return GLConstants.PixelFormatType.I420;
            }
        }
        return GLConstants.PixelFormatType.RGBA;
    }

    public static Bundle createExtraInfoBundle(String str, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(str, i);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideFloatingWindow() {
        View view = this.mFloatingWindow;
        if (view == null) {
            return;
        }
        ((WindowManager) view.getContext().getSystemService(Context.WINDOW_SERVICE)).removeViewImmediate(this.mFloatingWindow);
        this.mFloatingWindow = null;
    }

    public static void init(int i) {
        synchronized (INIT_LOCK) {
            if (!mHasInited) {
                mHasInited = true;
                nativeGlobalInit(i);
            }
        }
    }

    private static boolean isCustomPreprocessSupportedBufferType(GLConstants.PixelBufferType pixelBufferType) {
        return pixelBufferType == GLConstants.PixelBufferType.BYTE_BUFFER || pixelBufferType == GLConstants.PixelBufferType.BYTE_ARRAY || pixelBufferType == GLConstants.PixelBufferType.TEXTURE_2D;
    }

    private static boolean isCustomPreprocessSupportedFormatType(GLConstants.PixelFormatType pixelFormatType) {
        return pixelFormatType == GLConstants.PixelFormatType.I420 || pixelFormatType == GLConstants.PixelFormatType.NV21 || pixelFormatType == GLConstants.PixelFormatType.RGBA;
    }

    private static boolean isCustomRenderSupportedBufferType(GLConstants.PixelBufferType pixelBufferType) {
        return pixelBufferType == GLConstants.PixelBufferType.BYTE_BUFFER || pixelBufferType == GLConstants.PixelBufferType.BYTE_ARRAY || pixelBufferType == GLConstants.PixelBufferType.TEXTURE_2D;
    }

    private static boolean isCustomRenderSupportedFormatType(GLConstants.PixelFormatType pixelFormatType) {
        return pixelFormatType == GLConstants.PixelFormatType.I420 || pixelFormatType == GLConstants.PixelFormatType.NV21 || pixelFormatType == GLConstants.PixelFormatType.RGBA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$enterRoom$0(TrtcCloudJni trtcCloudJni) {
        trtcCloudJni.onEnterRoom(-3316);
        trtcCloudJni.onError(-3316, "enter room param null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onSnapshotComplete$1(TrtcCloudJni trtcCloudJni, Bitmap bitmap) {
        TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener = trtcCloudJni.mSnapshotListener;
        if (tRTCSnapshotListener != null) {
            tRTCSnapshotListener.onSnapshotComplete(bitmap);
        }
    }

    private static native void nativeCallExperimentalAPI(long j, String str);

    private static native void nativeConnectOtherRoom(long j, String str);

    private static native long nativeCreateAudioEffectManager(long j);

    private static native long nativeCreateBeautyManager(long j);

    private static native long nativeCreateDeviceManager(long j);

    private static native long nativeCreatePipeline(TrtcCloudJni trtcCloudJni);

    private static native long nativeCreateSubCloud(TrtcCloudJni trtcCloudJni, long j);

    private static native void nativeDestroyPipeline(long j);

    private static native void nativeDisconnectOtherRoom(long j);

    private static native void nativeEnable3DSpatialAudioEffect(long j, boolean z);

    private static native void nativeEnableAudioFrameNotification(long j, boolean z);

    private static native void nativeEnableAudioVolumeEvaluation(long j, int i, boolean z);

    private static native void nativeEnableCustomAudioCapture(long j, boolean z);

    private static native void nativeEnableCustomAudioRendering(long j, boolean z);

    private static native void nativeEnableCustomVideoCapture(long j, int i, boolean z);

    private static native void nativeEnableEncSmallVideoStream(long j, boolean z, VideoEncParams videoEncParams);

    private static native void nativeEnableMixExternalAudioFrame(long j, boolean z, boolean z2);

    private static native void nativeEnableVideoCustomPreprocess(long j, boolean z, int i, int i2, int i3);

    private static native void nativeEnableVideoCustomRender(long j, boolean z, String str, int i, int i2, int i3);

    private static native void nativeEnterRoom(long j, EnterRoomParams enterRoomParams, int i);

    private static native void nativeExitRoom(long j);

    private static native int nativeGetAudioCaptureVolume(long j);

    private static native int nativeGetAudioPlayoutVolume(long j);

    private static native void nativeGetCustomAudioRenderingFrame(long j, byte[] bArr, int i, int i2);

    private static native void nativeGlobalInit(int i);

    private static native void nativeGlobalUninit();

    private static native int nativeMixExternalAudioFrame(long j, AudioFrame audioFrame);

    private static native void nativeMuteAllRemoteAudio(long j, boolean z);

    private static native void nativeMuteAllRemoteVideoStreams(long j, boolean z);

    private static native void nativeMuteLocalAudio(long j, boolean z);

    private static native void nativeMuteLocalVideo(long j, int i, boolean z);

    private static native void nativeMuteRemoteAudio(long j, String str, boolean z);

    private static native void nativeMuteRemoteVideoStream(long j, String str, int i, boolean z);

    private static native void nativePauseScreenCapture(long j, int i);

    private static native void nativeResumeScreenCapture(long j, int i);

    private static native void nativeSendCustomAudioData(long j, AudioFrame audioFrame);

    private static native boolean nativeSendCustomCmdMsg(long j, int i, byte[] bArr, boolean z, boolean z2);

    private static native void nativeSendCustomVideoData(long j, int i, PixelFrame pixelFrame);

    private static native boolean nativeSendSEIMsg(long j, byte[] bArr, int i);

    private static native void nativeSet3DSpatialReceivingRange(long j, String str, int i);

    private static native void nativeSetAudioCaptureVolume(long j, int i);

    private static native void nativeSetAudioPlayoutVolume(long j, int i);

    private static native void nativeSetAudioQuality(long j, int i);

    private static native int nativeSetCapturedRawAudioFrameCallbackFormat(long j, int i, int i2, int i3, int i4);

    private static native void nativeSetConsoleEnabled(boolean z);

    private static native void nativeSetDefaultStreamRecvMode(long j, boolean z, boolean z2);

    private static native void nativeSetGSensorMode(long j, int i, int i2);

    private static native void nativeSetListenerHandler(long j, Handler handler);

    private static native int nativeSetLocalProcessedAudioFrameCallbackFormat(long j, int i, int i2, int i3, int i4);

    private static native void nativeSetLocalViewFillMode(long j, int i);

    private static native void nativeSetLocalViewMirror(long j, int i);

    private static native void nativeSetLocalViewRotation(long j, int i);

    private static native void nativeSetLogCompressEnabled(boolean z);

    private static native void nativeSetLogLevel(int i);

    private static native void nativeSetLogPath(String str);

    private static native void nativeSetMixExternalAudioVolume(long j, int i, int i2);

    private static native void nativeSetMixTranscodingConfig(long j, TranscodingConfig transcodingConfig);

    private static native int nativeSetMixedPlayAudioFrameCallbackFormat(long j, int i, int i2, int i3, int i4);

    private static native void nativeSetNetworkQosParam(long j, int i, int i2);

    private static native void nativeSetPriorRemoteVideoStreamType(long j, int i);

    private static native void nativeSetRemoteAudioParallelParams(long j, AudioParallelParams audioParallelParams);

    private static native void nativeSetRemoteAudioVolume(long j, String str, int i);

    private static native void nativeSetRemoteVideoStreamType(long j, String str, int i);

    private static native void nativeSetRemoteViewFillMode(long j, String str, int i, int i2);

    private static native void nativeSetRemoteViewMirror(long j, String str, int i, int i2);

    private static native void nativeSetRemoteViewRotation(long j, String str, int i, int i2);

    private static native void nativeSetVideoEncoderMirror(long j, boolean z);

    private static native void nativeSetVideoEncoderParams(long j, int i, VideoEncParams videoEncParams);

    private static native void nativeSetVideoEncoderRotation(long j, int i);

    private static native void nativeSetVideoMuteImage(long j, int i, Bitmap bitmap, int i2);

    private static native void nativeSetWatermark(long j, Bitmap bitmap, int i, float f, float f2, float f3);

    private static native void nativeShowDashboardManager(long j, int i);

    private static native void nativeSnapshotVideo(long j, String str, int i);

    private static native int nativeStartAudioRecording(long j, AudioRecordingParams audioRecordingParams);

    private static native void nativeStartLocalAudio(long j);

    private static native void nativeStartLocalAudioWithQuality(long j, int i);

    private static native void nativeStartLocalPreview(long j, boolean z, DisplayTarget displayTarget);

    private static native void nativeStartLocalRecording(long j, LocalRecordingParams localRecordingParams);

    private static native void nativeStartPublishCDNStream(long j, PublishCDNParams publishCDNParams);

    private static native void nativeStartPublishMediaStream(long j, PublishTarget publishTarget, StreamEncoderParam streamEncoderParam, StreamMixingConfig streamMixingConfig);

    private static native void nativeStartPublishing(long j, String str, int i);

    private static native void nativeStartRemoteView(long j, String str, int i, DisplayTarget displayTarget);

    private static native void nativeStartRemoteViewWithoutStreamType(long j, String str, DisplayTarget displayTarget);

    private static native void nativeStartScreenCapture(long j, int i, VideoEncParams videoEncParams, ScreenShareParams screenShareParams);

    private static native void nativeStartSpeedTest(long j, boolean z, SpeedTestParams speedTestParams);

    private static native void nativeStartSystemAudioLoopback(long j);

    private static native void nativeStopAllRemoteView(long j);

    private static native void nativeStopAudioRecording(long j);

    private static native void nativeStopLocalAudio(long j);

    private static native void nativeStopLocalPreview(long j);

    private static native void nativeStopLocalRecording(long j);

    private static native void nativeStopPublishCDNStream(long j);

    private static native void nativeStopPublishMediaStream(long j, String str);

    private static native void nativeStopPublishing(long j);

    private static native void nativeStopRemoteView(long j, String str, int i);

    private static native void nativeStopRemoteViewWithoutStreamType(long j, String str);

    private static native void nativeStopScreenCapture(long j, int i);

    private static native void nativeStopSpeedTest(long j);

    private static native void nativeStopSystemAudioLoopback(long j);

    private static native void nativeSwitchRole(long j, int i);

    private static native void nativeSwitchRoleWithPrivateMapKey(long j, int i, String str);

    private static native void nativeSwitchRoom(long j, SwitchRoomConfig switchRoomConfig);

    private static native void nativeUpdateLocalView(long j, DisplayTarget displayTarget);

    private static native void nativeUpdatePublishMediaStream(long j, String str, PublishTarget publishTarget, StreamEncoderParam streamEncoderParam, StreamMixingConfig streamMixingConfig);

    private static native void nativeUpdateRemote3DSpatialPosition(long j, String str, int[] iArr);

    private static native void nativeUpdateRemoteView(long j, String str, int i, DisplayTarget displayTarget);

    private static native void nativeUpdateSelf3DSpatialPosition(long j, int[] iArr, float[] fArr, float[] fArr2, float[] fArr3);

    private void runOnListenerThread(Runnable runnable) {
        Handler handler = this.mListenerHandler;
        if (Looper.myLooper() != handler.getLooper()) {
            handler.post(runnable);
        } else {
            runnable.run();
        }
    }

    public static void setConsoleEnabled(boolean z) {
        nativeSetConsoleEnabled(z);
    }

    public static void setLogCompressEnabled(boolean z) {
        nativeSetLogCompressEnabled(z);
    }

    public static void setLogDirPath(String str) {
        nativeSetLogPath(str);
    }

    public static void setLogLevel(int i) {
        nativeSetLogLevel(i);
    }

    private static void shadowCopy(PixelFrame pixelFrame, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        tRTCVideoFrame.pixelFormat = convertPixelFormatTypeToTRTCFormatType(pixelFrame.getPixelFormatType());
        tRTCVideoFrame.bufferType = convertPixelBufferTypeToTRTCBufferType(pixelFrame.getPixelBufferType());
        tRTCVideoFrame.texture = new TRTCCloudDef.TRTCTexture();
        tRTCVideoFrame.texture.textureId = pixelFrame.getTextureId();
        if (pixelFrame.getGLContext() instanceof EGLContext) {
            tRTCVideoFrame.texture.eglContext10 = (EGLContext) pixelFrame.getGLContext();
        } else if (LiteavSystemInfo.getSystemOSVersionInt() >= 17 && (pixelFrame.getGLContext() instanceof android.opengl.EGLContext)) {
            tRTCVideoFrame.texture.eglContext14 = (android.opengl.EGLContext) pixelFrame.getGLContext();
        }
        tRTCVideoFrame.data = pixelFrame.getData();
        tRTCVideoFrame.buffer = pixelFrame.getBuffer();
        tRTCVideoFrame.width = pixelFrame.getWidth();
        tRTCVideoFrame.height = pixelFrame.getHeight();
        tRTCVideoFrame.timestamp = pixelFrame.getTimestamp();
        tRTCVideoFrame.rotation = pixelFrame.getRotation().mValue;
    }

    private static void shadowCopy(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame, PixelFrame pixelFrame) {
        int i;
        android.opengl.EGLContext eGLContext;
        TRTCCloudDef.TRTCTexture tRTCTexture = tRTCVideoFrame.texture;
        pixelFrame.setPixelFormatType(convertTRTCFormatTypeToPixelFormatType(tRTCVideoFrame.pixelFormat));
        pixelFrame.setPixelBufferType(convertTRTCBufferTypeToPixelBufferType(tRTCVideoFrame.bufferType));
        if (tRTCTexture != null) {
            i = tRTCTexture.textureId;
            eGLContext = tRTCTexture.eglContext10 == null ? tRTCTexture.eglContext14 : tRTCTexture.eglContext10;
        } else {
            i = -1;
            eGLContext = null;
        }
        pixelFrame.setTextureId(i);
        pixelFrame.setGLContext(eGLContext);
        pixelFrame.setData(tRTCVideoFrame.data);
        pixelFrame.setBuffer(tRTCVideoFrame.buffer);
        pixelFrame.setWidth(tRTCVideoFrame.width);
        pixelFrame.setHeight(tRTCVideoFrame.height);
        pixelFrame.setTimestamp(tRTCVideoFrame.timestamp);
        pixelFrame.setRotation(Rotation.a(tRTCVideoFrame.rotation));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFloatingWindow(View view) {
        if (view == null) {
            return;
        }
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 23 && !Settings.canDrawOverlays(view.getContext())) {
            LiteavLog.e(TAG, "can't show floating window for no drawing overlay permission");
            return;
        }
        this.mFloatingWindow = view;
        WindowManager windowManager = (WindowManager) view.getContext().getSystemService(Context.WINDOW_SERVICE);
        int i = 2005;
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 26) {
            i = 2038;
        } else if (LiteavSystemInfo.getSystemOSVersionInt() > 24) {
            i = 2002;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(i);
        layoutParams.flags = 8;
        layoutParams.flags |= 262144;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        windowManager.addView(view, layoutParams);
    }

    public static void uninit() {
        synchronized (INIT_LOCK) {
            if (mHasInited) {
                mHasInited = false;
                nativeGlobalUninit();
            }
        }
    }

    public void callExperimentalAPI(String str) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeCallExperimentalAPI(this.mNativeTrtcCloudJni, str);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void connectOtherRoom(String str) {
        long j = this.mNativeTrtcCloudJni;
        if (j != 0) {
            nativeConnectOtherRoom(j, str);
        }
    }

    public long createAudioEffectManager() {
        this.mJniReadLock.lock();
        try {
            long j = 0;
            if (this.mNativeTrtcCloudJni != 0) {
                j = nativeCreateAudioEffectManager(this.mNativeTrtcCloudJni);
            }
            this.mJniReadLock.unlock();
            return j;
        } catch (Throwable th) {
            this.mJniReadLock.unlock();
            throw th;
        }
    }

    public long createBeautyManager() {
        this.mJniReadLock.lock();
        try {
            long j = 0;
            if (this.mNativeTrtcCloudJni != 0) {
                j = nativeCreateBeautyManager(this.mNativeTrtcCloudJni);
            }
            this.mJniReadLock.unlock();
            return j;
        } catch (Throwable th) {
            this.mJniReadLock.unlock();
            throw th;
        }
    }

    public long createDeviceManager() {
        this.mJniReadLock.lock();
        try {
            long j = 0;
            if (this.mNativeTrtcCloudJni != 0) {
                j = nativeCreateDeviceManager(this.mNativeTrtcCloudJni);
            }
            this.mJniReadLock.unlock();
            return j;
        } catch (Throwable th) {
            this.mJniReadLock.unlock();
            throw th;
        }
    }

    public void destroy() {
        this.mJniWriteLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeDestroyPipeline(this.mNativeTrtcCloudJni);
                this.mNativeTrtcCloudJni = 0L;
            }
        } finally {
            this.mJniWriteLock.unlock();
        }
    }

    public void disconnectOtherRoom() {
        long j = this.mNativeTrtcCloudJni;
        if (j != 0) {
            nativeDisconnectOtherRoom(j);
        }
    }

    public void enable3DSpatialAudioEffect(boolean z) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeEnable3DSpatialAudioEffect(this.mNativeTrtcCloudJni, z);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void enableAudioVolumeEvaluation(int i, boolean z) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeEnableAudioVolumeEvaluation(this.mNativeTrtcCloudJni, i, z);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void enableCustomAudioCapture(boolean z) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeEnableCustomAudioCapture(this.mNativeTrtcCloudJni, z);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void enableCustomAudioRendering(boolean z) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeEnableCustomAudioRendering(this.mNativeTrtcCloudJni, z);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void enableCustomVideoCapture(int i, boolean z) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeEnableCustomVideoCapture(this.mNativeTrtcCloudJni, i, z);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int enableEncSmallVideoStream(boolean z, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeEnableEncSmallVideoStream(this.mNativeTrtcCloudJni, z, new VideoEncParams(tRTCVideoEncParam));
            }
            this.mJniReadLock.unlock();
            return 0;
        } catch (Throwable th) {
            this.mJniReadLock.unlock();
            throw th;
        }
    }

    public void enableMixExternalAudioFrame(boolean z, boolean z2) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeEnableMixExternalAudioFrame(this.mNativeTrtcCloudJni, z, z2);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void enterRoom(TRTCCloudDef.TRTCParams tRTCParams, int i) {
        if (tRTCParams == null) {
            LiteavLog.e(TAG, "enterRoom param is null");
            runOnListenerThread(com.tencent.liteav.trtc.a.a(this));
            return;
        }
        this.mJniReadLock.lock();
        try {
            this.mLocalUserId = tRTCParams.userId;
            if (this.mNativeTrtcCloudJni != 0) {
                nativeEnterRoom(this.mNativeTrtcCloudJni, new EnterRoomParams(tRTCParams), i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void exitRoom() {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeExitRoom(this.mNativeTrtcCloudJni);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int getAudioCaptureVolume() {
        this.mJniReadLock.lock();
        try {
            int nativeGetAudioCaptureVolume = this.mNativeTrtcCloudJni != 0 ? nativeGetAudioCaptureVolume(this.mNativeTrtcCloudJni) : 0;
            this.mJniReadLock.unlock();
            return nativeGetAudioCaptureVolume;
        } catch (Throwable th) {
            this.mJniReadLock.unlock();
            throw th;
        }
    }

    public int getAudioPlayoutVolume() {
        this.mJniReadLock.lock();
        try {
            int nativeGetAudioPlayoutVolume = this.mNativeTrtcCloudJni != 0 ? nativeGetAudioPlayoutVolume(this.mNativeTrtcCloudJni) : 0;
            this.mJniReadLock.unlock();
            return nativeGetAudioPlayoutVolume;
        } catch (Throwable th) {
            this.mJniReadLock.unlock();
            throw th;
        }
    }

    public void getCustomAudioRenderingFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeGetCustomAudioRenderingFrame(this.mNativeTrtcCloudJni, tRTCAudioFrame.data, tRTCAudioFrame.sampleRate, tRTCAudioFrame.channel);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public long getTrtcCloudJni() {
        this.mJniReadLock.lock();
        try {
            return this.mNativeTrtcCloudJni;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int mixExternalAudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                return nativeMixExternalAudioFrame(this.mNativeTrtcCloudJni, new AudioFrame(tRTCAudioFrame));
            }
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void muteAllRemoteAudio(boolean z) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeMuteAllRemoteAudio(this.mNativeTrtcCloudJni, z);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void muteAllRemoteVideoStreams(boolean z) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeMuteAllRemoteVideoStreams(this.mNativeTrtcCloudJni, z);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void muteLocalAudio(boolean z) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeMuteLocalAudio(this.mNativeTrtcCloudJni, z);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void muteLocalVideo(int i, boolean z) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeMuteLocalVideo(this.mNativeTrtcCloudJni, i, z);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void muteRemoteAudio(String str, boolean z) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeMuteRemoteAudio(this.mNativeTrtcCloudJni, str, z);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void muteRemoteVideoStream(String str, int i, boolean z) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeMuteRemoteVideoStream(this.mNativeTrtcCloudJni, str, i, z);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void onAudioCaptureProcessedData(byte[] bArr, long j, int i, int i2) {
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener == null) {
            return;
        }
        TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
        tRTCAudioFrame.data = bArr;
        tRTCAudioFrame.timestamp = j;
        tRTCAudioFrame.sampleRate = i;
        tRTCAudioFrame.channel = i2;
        tRTCAudioFrameListener.onCapturedRawAudioFrame(tRTCAudioFrame);
    }

    public void onAudioMixedAllData(byte[] bArr, int i, int i2) {
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener == null) {
            return;
        }
        TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
        tRTCAudioFrame.data = bArr;
        tRTCAudioFrame.timestamp = 0L;
        tRTCAudioFrame.sampleRate = i;
        tRTCAudioFrame.channel = i2;
        tRTCAudioFrameListener.onMixedAllAudioFrame(tRTCAudioFrame);
    }

    public void onAudioPlayoutData(byte[] bArr, long j, int i, int i2) {
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener == null) {
            return;
        }
        TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
        tRTCAudioFrame.data = bArr;
        tRTCAudioFrame.timestamp = j;
        tRTCAudioFrame.sampleRate = i;
        tRTCAudioFrame.channel = i2;
        tRTCAudioFrameListener.onMixedPlayAudioFrame(tRTCAudioFrame);
    }

    public void onAudioRemoteStreamData(String str, byte[] bArr, long j, int i, int i2, byte[] bArr2) {
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener == null) {
            return;
        }
        TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
        tRTCAudioFrame.data = bArr;
        tRTCAudioFrame.timestamp = j;
        tRTCAudioFrame.sampleRate = i;
        tRTCAudioFrame.channel = i2;
        tRTCAudioFrame.extraData = bArr2;
        tRTCAudioFrameListener.onRemoteUserAudioFrame(tRTCAudioFrame, str);
    }

    public void onAudioRouteChanged(int i, int i2) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onAudioRouteChanged(i, i2);
        }
    }

    void onCameraDidReady() {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onCameraDidReady();
        }
    }

    public void onCdnStreamStateChanged(String str, int i, int i2, String str2, String str3) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onCdnStreamStateChanged(str, i, i2, str2, null);
        }
    }

    public void onConnectOtherRoom(String str, int i, String str2) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onConnectOtherRoom(str, i, str2);
        }
    }

    void onConnectionLost() {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onConnectionLost();
        }
    }

    void onConnectionRecovery() {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onConnectionRecovery();
        }
    }

    public void onDisConnectOtherRoom(int i, String str) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onDisConnectOtherRoom(i, str);
        }
    }

    public void onEnterRoom(int i) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onEnterRoom(i);
        }
    }

    public void onError(int i, String str) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onError(i, str, null);
        }
    }

    public void onExitRoom(int i) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onExitRoom(i);
        }
        synchronized (this.mLocalVideoRenderListenerWrapper) {
            this.mLocalVideoRenderListenerWrapper.d = null;
        }
        synchronized (this.mRemoteVideoRenderListenerMap) {
            this.mRemoteVideoRenderListenerMap.clear();
        }
    }

    void onFirstAudioFrame(String str) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onFirstAudioFrame(str);
        }
    }

    void onFirstVideoFrame(String str, int i, int i2, int i3) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onFirstVideoFrame(str, i, i2, i3);
        }
    }

    public void onGLContextCreated() {
        synchronized (this.mVideoFrameListenerWrapper) {
            this.mCalledGLCreatedFrameListener = this.mVideoFrameListenerWrapper.d;
        }
        LiteavLog.i(TAG, "onGLContextCreated " + this.mCalledGLCreatedFrameListener);
        TRTCCloudListener.TRTCVideoFrameListener tRTCVideoFrameListener = this.mCalledGLCreatedFrameListener;
        if (tRTCVideoFrameListener != null) {
            tRTCVideoFrameListener.onGLContextCreated();
        }
    }

    public void onGLContextDestroy() {
        LiteavLog.i(TAG, "onGLContextDestroy " + this.mCalledGLCreatedFrameListener);
        TRTCCloudListener.TRTCVideoFrameListener tRTCVideoFrameListener = this.mCalledGLCreatedFrameListener;
        if (tRTCVideoFrameListener != null) {
            tRTCVideoFrameListener.onGLContextDestory();
            this.mCalledGLCreatedFrameListener = null;
        }
    }

    public byte[] onLocalAudioStreamData(byte[] bArr, long j, int i, int i2) {
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener == null) {
            return null;
        }
        TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
        tRTCAudioFrame.data = bArr;
        tRTCAudioFrame.timestamp = j;
        tRTCAudioFrame.sampleRate = i;
        tRTCAudioFrame.channel = i2;
        tRTCAudioFrameListener.onLocalProcessedAudioFrame(tRTCAudioFrame);
        if (tRTCAudioFrame.extraData == null) {
            return null;
        }
        if (tRTCAudioFrame.extraData.length > 100) {
            LiteavLog.w(TAG, "Audioframe.extraData length need to be under 100!");
            return null;
        }
        return tRTCAudioFrame.extraData;
    }

    public void onLocalRecordBegin(int i, String str) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onLocalRecordBegin(i, str);
        }
    }

    public void onLocalRecordComplete(int i, String str) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onLocalRecordComplete(i, str);
        }
    }

    public void onLocalRecording(long j, String str) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onLocalRecording(j, str);
        }
    }

    void onMicDidReady() {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onMicDidReady();
        }
    }

    public void onMissCustomCmdMsg(String str, int i, int i2, int i3) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onMissCustomCmdMsg(str, i, i2, i3);
        }
    }

    public void onNetworkQuality(int i, String[] strArr, int[] iArr) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            TRTCCloudDef.TRTCQuality tRTCQuality = new TRTCCloudDef.TRTCQuality();
            tRTCQuality.userId = "";
            tRTCQuality.quality = i;
            ArrayList<TRTCCloudDef.TRTCQuality> arrayList = new ArrayList<>();
            if (strArr != null && strArr.length != 0 && iArr != null && iArr.length != 0 && iArr.length == strArr.length) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= strArr.length) {
                        break;
                    }
                    TRTCCloudDef.TRTCQuality tRTCQuality2 = new TRTCCloudDef.TRTCQuality();
                    tRTCQuality2.userId = strArr[i3];
                    tRTCQuality2.quality = iArr[i3];
                    arrayList.add(tRTCQuality2);
                    i2 = i3 + 1;
                }
            }
            tRTCCloudListener.onNetworkQuality(tRTCQuality, arrayList);
        }
    }

    public void onPreprocessVideoFrame(int i, PixelFrame pixelFrame, PixelFrame pixelFrame2) {
        TRTCCloudListener.TRTCVideoFrameListener tRTCVideoFrameListener = this.mCalledGLCreatedFrameListener;
        if (tRTCVideoFrameListener == null || tRTCVideoFrameListener == null) {
            return;
        }
        TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame = new TRTCCloudDef.TRTCVideoFrame();
        TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame2 = new TRTCCloudDef.TRTCVideoFrame();
        shadowCopy(pixelFrame, tRTCVideoFrame);
        shadowCopy(pixelFrame2, tRTCVideoFrame2);
        tRTCVideoFrameListener.onProcessVideoFrame(tRTCVideoFrame, tRTCVideoFrame2);
        shadowCopy(tRTCVideoFrame, pixelFrame);
        shadowCopy(tRTCVideoFrame2, pixelFrame2);
    }

    public void onRecvCustomCmdMsg(String str, int i, int i2, byte[] bArr) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onRecvCustomCmdMsg(str, i, i2, bArr);
        }
    }

    public void onRemoteVideoStatusUpdated(String str, int i, int i2) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onRemoteVideoStatusUpdated(str, i, i2, 0, null);
        }
    }

    public void onRenderVideoFrame(String str, int i, PixelFrame pixelFrame) {
        TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener;
        if (TextUtils.isEmpty(str)) {
            str = this.mLocalUserId;
            tRTCVideoRenderListener = this.mLocalVideoRenderListenerWrapper.d;
        } else {
            a<TRTCCloudListener.TRTCVideoRenderListener> aVar = this.mRemoteVideoRenderListenerMap.get(str);
            tRTCVideoRenderListener = aVar == null ? null : aVar.d;
        }
        if (tRTCVideoRenderListener != null) {
            TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame = new TRTCCloudDef.TRTCVideoFrame();
            shadowCopy(pixelFrame, tRTCVideoFrame);
            tRTCVideoRenderListener.onRenderVideoFrame(str, i, tRTCVideoFrame);
        }
    }

    public void onSEIMessageReceived(byte[] bArr, String str) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onRecvSEIMsg(str, bArr);
        }
    }

    void onScreenCapturePaused() {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onScreenCapturePaused();
        }
    }

    void onScreenCaptureResumed() {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onScreenCaptureResumed();
        }
    }

    void onScreenCaptureStarted() {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onScreenCaptureStarted();
        }
    }

    void onScreenCaptureStopped(int i) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onScreenCaptureStopped(i);
        }
    }

    void onSendFirstLocalAudioFrame() {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onSendFirstLocalAudioFrame();
        }
    }

    void onSendFirstLocalVideoFrame(int i) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onSendFirstLocalVideoFrame(i);
        }
    }

    void onSetMixTranscodingConfig(int i, String str) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onSetMixTranscodingConfig(i, str);
        }
    }

    public void onSnapshotComplete(Bitmap bitmap) {
        runOnListenerThread(b.a(this, bitmap));
    }

    public void onSpeedTest(SpeedTestResult speedTestResult, int i, int i2) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onSpeedTest(speedTestResult.f22768a, i, i2);
        }
    }

    public void onSpeedTestResult(SpeedTestResult speedTestResult) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onSpeedTestResult(speedTestResult.f22768a);
        }
    }

    void onStartPublishCDNStream(int i, String str) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onStartPublishCDNStream(i, str);
        }
    }

    public void onStartPublishMediaStream(String str, int i, String str2, String str3) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onStartPublishMediaStream(str, i, str2, null);
        }
    }

    void onStartPublishing(int i, String str) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onStartPublishing(i, str);
        }
    }

    public void onStatistics(Statistics statistics) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onStatistics(statistics.f22769a);
        }
    }

    void onStopPublishCDNStream(int i, String str) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onStopPublishCDNStream(i, str);
        }
    }

    public void onStopPublishMediaStream(String str, int i, String str2, String str3) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onStopPublishMediaStream(str, i, str2, null);
        }
    }

    void onStopPublishing(int i, String str) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onStopPublishing(i, str);
        }
    }

    public void onSwitchRole(int i, String str) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onSwitchRole(i, str);
        }
    }

    public void onSwitchRoom(int i, String str) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onSwitchRoom(i, str);
        }
    }

    void onTryToReconnect() {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onTryToReconnect();
        }
    }

    public void onUpdatePublishMediaStream(String str, int i, String str2, String str3) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onUpdatePublishMediaStream(str, i, str2, null);
        }
    }

    void onUserAudioAvailable(String str, boolean z) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onUserAudioAvailable(str, z);
        }
    }

    public void onUserEnter(String str) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onUserEnter(str);
        }
    }

    public void onUserExit(String str) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onUserExit(str, 0);
        }
    }

    public void onUserOffline(String str, int i) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onRemoteUserLeaveRoom(str, i);
        }
    }

    public void onUserOnline(String str) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onRemoteUserEnterRoom(str);
        }
    }

    void onUserSubStreamAvailable(String str, boolean z) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onUserSubStreamAvailable(str, z);
        }
    }

    void onUserVideoAvailable(String str, boolean z) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onUserVideoAvailable(str, z);
        }
    }

    public void onUserVideoSizeChanged(String str, int i, int i2, int i3) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onUserVideoSizeChanged(str, i, i2, i3);
        }
    }

    public void onUserVoiceVolume(String[] strArr, int[] iArr, int[] iArr2, int i) {
        String str;
        if (strArr == null || iArr == null) {
            return;
        }
        if (strArr.length != iArr.length) {
            throw new IllegalArgumentException("Invalid parameter, userIds and volumes do not match.");
        }
        ArrayList<TRTCCloudDef.TRTCVolumeInfo> arrayList = new ArrayList<>();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= strArr.length) {
                break;
            }
            TRTCCloudDef.TRTCVolumeInfo tRTCVolumeInfo = new TRTCCloudDef.TRTCVolumeInfo();
            if (!strArr[i3].isEmpty() || (str = this.mLocalUserId) == null || str.isEmpty()) {
                tRTCVolumeInfo.userId = strArr[i3];
            } else {
                tRTCVolumeInfo.userId = this.mLocalUserId;
            }
            tRTCVolumeInfo.volume = iArr[i3];
            tRTCVolumeInfo.vad = iArr2[i3];
            arrayList.add(tRTCVolumeInfo);
            i2 = i3 + 1;
        }
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onUserVoiceVolume(arrayList, i);
        }
    }

    public void onWarning(int i, String str, Bundle bundle) {
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null) {
            tRTCCloudListener.onWarning(i, str, bundle);
        }
    }

    public void pauseScreenCapture(int i) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativePauseScreenCapture(this.mNativeTrtcCloudJni, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void resumeScreenCapture(int i) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeResumeScreenCapture(this.mNativeTrtcCloudJni, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void sendCustomAudioData(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeSendCustomAudioData(this.mNativeTrtcCloudJni, new AudioFrame(tRTCAudioFrame));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public boolean sendCustomCmdMsg(int i, byte[] bArr, boolean z, boolean z2) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                return nativeSendCustomCmdMsg(this.mNativeTrtcCloudJni, i, bArr, z, z2);
            }
            this.mJniReadLock.unlock();
            return false;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void sendCustomVideoData(int i, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                PixelFrame pixelFrame = new PixelFrame();
                shadowCopy(tRTCVideoFrame, pixelFrame);
                nativeSendCustomVideoData(this.mNativeTrtcCloudJni, i, pixelFrame);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public boolean sendSEIMsg(byte[] bArr, int i) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                return nativeSendSEIMsg(this.mNativeTrtcCloudJni, bArr, i);
            }
            this.mJniReadLock.unlock();
            return false;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void set3DSpatialReceivingRange(String str, int i) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeSet3DSpatialReceivingRange(this.mNativeTrtcCloudJni, str, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setAudioCaptureVolume(int i) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeSetAudioCaptureVolume(this.mNativeTrtcCloudJni, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setAudioFrameListener(TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                this.mAudioFrameListener = tRTCAudioFrameListener;
                nativeEnableAudioFrameNotification(this.mNativeTrtcCloudJni, tRTCAudioFrameListener != null);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setAudioPlayoutVolume(int i) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeSetAudioPlayoutVolume(this.mNativeTrtcCloudJni, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setAudioQuality(int i) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeSetAudioQuality(this.mNativeTrtcCloudJni, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int setCapturedRawAudioFrameCallbackFormat(int i, int i2, int i3, int i4) {
        this.mJniReadLock.lock();
        try {
            int nativeSetCapturedRawAudioFrameCallbackFormat = this.mNativeTrtcCloudJni != 0 ? nativeSetCapturedRawAudioFrameCallbackFormat(this.mNativeTrtcCloudJni, i, i2, i3, i4) : 0;
            this.mJniReadLock.unlock();
            return nativeSetCapturedRawAudioFrameCallbackFormat;
        } catch (Throwable th) {
            this.mJniReadLock.unlock();
            throw th;
        }
    }

    public void setDefaultStreamRecvMode(boolean z, boolean z2) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeSetDefaultStreamRecvMode(this.mNativeTrtcCloudJni, z, z2);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setGSensorMode(int i, int i2) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeSetGSensorMode(this.mNativeTrtcCloudJni, i, i2);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setListener(TRTCCloudListener tRTCCloudListener) {
        this.mListener = tRTCCloudListener;
    }

    public void setListenerHandler(Handler handler) {
        this.mJniReadLock.lock();
        if (handler == null) {
            this.mListenerHandler = new Handler(Looper.getMainLooper());
        } else {
            this.mListenerHandler = handler;
        }
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeSetListenerHandler(this.mNativeTrtcCloudJni, handler);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int setLocalProcessedAudioFrameCallbackFormat(int i, int i2, int i3, int i4) {
        this.mJniReadLock.lock();
        try {
            int nativeSetLocalProcessedAudioFrameCallbackFormat = this.mNativeTrtcCloudJni != 0 ? nativeSetLocalProcessedAudioFrameCallbackFormat(this.mNativeTrtcCloudJni, i, i2, i3, i4) : 0;
            this.mJniReadLock.unlock();
            return nativeSetLocalProcessedAudioFrameCallbackFormat;
        } catch (Throwable th) {
            this.mJniReadLock.unlock();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int setLocalVideoProcessListener(int i, int i2, int i3, TRTCCloudListener.TRTCVideoFrameListener tRTCVideoFrameListener) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                GLConstants.PixelFormatType convertTRTCFormatTypeToPixelFormatType = convertTRTCFormatTypeToPixelFormatType(i2);
                GLConstants.PixelBufferType convertTRTCBufferTypeToPixelBufferType = convertTRTCBufferTypeToPixelBufferType(i3);
                if (!isCustomPreprocessSupportedFormatType(convertTRTCFormatTypeToPixelFormatType)) {
                    this.mJniReadLock.unlock();
                    return TXLiteAVCode.ERR_PIXEL_FORMAT_UNSUPPORTED;
                } else if (!isCustomPreprocessSupportedBufferType(convertTRTCBufferTypeToPixelBufferType)) {
                    this.mJniReadLock.unlock();
                    return TXLiteAVCode.ERR_BUFFER_TYPE_UNSUPPORTED;
                } else {
                    synchronized (this.mVideoFrameListenerWrapper) {
                        if (this.mVideoFrameListenerWrapper.d != null) {
                            nativeEnableVideoCustomPreprocess(this.mNativeTrtcCloudJni, false, this.mVideoFrameListenerWrapper.f22778a, this.mVideoFrameListenerWrapper.b.getValue(), this.mVideoFrameListenerWrapper.f22779c.mValue);
                        }
                        this.mVideoFrameListenerWrapper.d = tRTCVideoFrameListener;
                        this.mVideoFrameListenerWrapper.f22778a = i;
                        this.mVideoFrameListenerWrapper.b = convertTRTCFormatTypeToPixelFormatType;
                        this.mVideoFrameListenerWrapper.f22779c = convertTRTCBufferTypeToPixelBufferType;
                        if (tRTCVideoFrameListener != 0) {
                            nativeEnableVideoCustomPreprocess(this.mNativeTrtcCloudJni, true, this.mVideoFrameListenerWrapper.f22778a, this.mVideoFrameListenerWrapper.b.getValue(), this.mVideoFrameListenerWrapper.f22779c.mValue);
                        }
                    }
                }
            }
            this.mJniReadLock.unlock();
            return 0;
        } catch (Throwable th) {
            this.mJniReadLock.unlock();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int setLocalVideoRenderListener(int i, int i2, TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener) {
        boolean z;
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                GLConstants.PixelFormatType convertTRTCFormatTypeToPixelFormatType = convertTRTCFormatTypeToPixelFormatType(i);
                GLConstants.PixelBufferType convertTRTCBufferTypeToPixelBufferType = convertTRTCBufferTypeToPixelBufferType(i2);
                if (!isCustomRenderSupportedFormatType(convertTRTCFormatTypeToPixelFormatType)) {
                    this.mJniReadLock.unlock();
                    return TXLiteAVCode.ERR_PIXEL_FORMAT_UNSUPPORTED;
                } else if (!isCustomRenderSupportedBufferType(convertTRTCBufferTypeToPixelBufferType)) {
                    this.mJniReadLock.unlock();
                    return TXLiteAVCode.ERR_BUFFER_TYPE_UNSUPPORTED;
                } else {
                    synchronized (this.mLocalVideoRenderListenerWrapper) {
                        if (this.mLocalVideoRenderListenerWrapper.d != null) {
                            if (this.mLocalVideoRenderListenerWrapper.b == convertTRTCFormatTypeToPixelFormatType && this.mLocalVideoRenderListenerWrapper.f22779c == convertTRTCBufferTypeToPixelBufferType) {
                                z = false;
                                if (!z || tRTCVideoRenderListener == 0) {
                                    nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, false, "", 0, this.mLocalVideoRenderListenerWrapper.b.getValue(), this.mLocalVideoRenderListenerWrapper.f22779c.mValue);
                                    nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, false, "", 2, this.mLocalVideoRenderListenerWrapper.b.getValue(), this.mLocalVideoRenderListenerWrapper.f22779c.mValue);
                                } else {
                                    this.mLocalVideoRenderListenerWrapper.d = tRTCVideoRenderListener;
                                }
                            }
                            z = true;
                            if (z) {
                            }
                            nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, false, "", 0, this.mLocalVideoRenderListenerWrapper.b.getValue(), this.mLocalVideoRenderListenerWrapper.f22779c.mValue);
                            nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, false, "", 2, this.mLocalVideoRenderListenerWrapper.b.getValue(), this.mLocalVideoRenderListenerWrapper.f22779c.mValue);
                        }
                        this.mLocalVideoRenderListenerWrapper.d = tRTCVideoRenderListener;
                        this.mLocalVideoRenderListenerWrapper.b = convertTRTCFormatTypeToPixelFormatType;
                        this.mLocalVideoRenderListenerWrapper.f22779c = convertTRTCBufferTypeToPixelBufferType;
                        if (tRTCVideoRenderListener != 0) {
                            nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, true, "", 0, this.mLocalVideoRenderListenerWrapper.b.getValue(), this.mLocalVideoRenderListenerWrapper.f22779c.mValue);
                            nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, true, "", 2, this.mLocalVideoRenderListenerWrapper.b.getValue(), this.mLocalVideoRenderListenerWrapper.f22779c.mValue);
                        }
                    }
                }
            }
            this.mJniReadLock.unlock();
            return 0;
        } catch (Throwable th) {
            this.mJniReadLock.unlock();
            throw th;
        }
    }

    public void setLocalViewFillMode(int i) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeSetLocalViewFillMode(this.mNativeTrtcCloudJni, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setLocalViewMirror(int i) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeSetLocalViewMirror(this.mNativeTrtcCloudJni, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setLocalViewRotation(int i) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeSetLocalViewRotation(this.mNativeTrtcCloudJni, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setMixExternalAudioVolume(int i, int i2) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeSetMixExternalAudioVolume(this.mNativeTrtcCloudJni, i, i2);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setMixTranscodingConfig(TRTCCloudDef.TRTCTranscodingConfig tRTCTranscodingConfig) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeSetMixTranscodingConfig(this.mNativeTrtcCloudJni, tRTCTranscodingConfig == null ? null : new TranscodingConfig(tRTCTranscodingConfig));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int setMixedPlayAudioFrameCallbackFormat(int i, int i2, int i3, int i4) {
        this.mJniReadLock.lock();
        try {
            int nativeSetMixedPlayAudioFrameCallbackFormat = this.mNativeTrtcCloudJni != 0 ? nativeSetMixedPlayAudioFrameCallbackFormat(this.mNativeTrtcCloudJni, i, i2, i3, i4) : 0;
            this.mJniReadLock.unlock();
            return nativeSetMixedPlayAudioFrameCallbackFormat;
        } catch (Throwable th) {
            this.mJniReadLock.unlock();
            throw th;
        }
    }

    public void setNetworkQosParam(TRTCCloudDef.TRTCNetworkQosParam tRTCNetworkQosParam) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeSetNetworkQosParam(this.mNativeTrtcCloudJni, tRTCNetworkQosParam.preference, tRTCNetworkQosParam.controlMode);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int setPriorRemoteVideoStreamType(int i) {
        long j = this.mNativeTrtcCloudJni;
        if (j != 0) {
            nativeSetPriorRemoteVideoStreamType(j, i);
            return 0;
        }
        return 0;
    }

    public void setRemoteAudioParallelParams(TRTCCloudDef.TRTCAudioParallelParams tRTCAudioParallelParams) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeSetRemoteAudioParallelParams(this.mNativeTrtcCloudJni, new AudioParallelParams(tRTCAudioParallelParams));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setRemoteAudioVolume(String str, int i) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeSetRemoteAudioVolume(this.mNativeTrtcCloudJni, str, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int setRemoteVideoRenderListener(String str, int i, int i2, TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener) {
        boolean z;
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                if (TextUtils.isEmpty(str)) {
                    this.mJniReadLock.unlock();
                    return -3319;
                }
                GLConstants.PixelFormatType convertTRTCFormatTypeToPixelFormatType = convertTRTCFormatTypeToPixelFormatType(i);
                GLConstants.PixelBufferType convertTRTCBufferTypeToPixelBufferType = convertTRTCBufferTypeToPixelBufferType(i2);
                if (!isCustomRenderSupportedFormatType(convertTRTCFormatTypeToPixelFormatType)) {
                    this.mJniReadLock.unlock();
                    return TXLiteAVCode.ERR_PIXEL_FORMAT_UNSUPPORTED;
                } else if (!isCustomRenderSupportedBufferType(convertTRTCBufferTypeToPixelBufferType)) {
                    this.mJniReadLock.unlock();
                    return TXLiteAVCode.ERR_BUFFER_TYPE_UNSUPPORTED;
                } else {
                    synchronized (this.mRemoteVideoRenderListenerMap) {
                        a<TRTCCloudListener.TRTCVideoRenderListener> aVar = this.mRemoteVideoRenderListenerMap.get(str);
                        if (aVar != null) {
                            if (aVar.b == convertTRTCFormatTypeToPixelFormatType && aVar.f22779c == convertTRTCBufferTypeToPixelBufferType) {
                                z = false;
                                if (!z || tRTCVideoRenderListener == 0) {
                                    nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, false, "", 0, aVar.b.getValue(), aVar.f22779c.mValue);
                                    nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, false, "", 2, aVar.b.getValue(), aVar.f22779c.mValue);
                                } else {
                                    aVar.d = tRTCVideoRenderListener;
                                    this.mRemoteVideoRenderListenerMap.put(str, aVar);
                                }
                            }
                            z = true;
                            if (z) {
                            }
                            nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, false, "", 0, aVar.b.getValue(), aVar.f22779c.mValue);
                            nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, false, "", 2, aVar.b.getValue(), aVar.f22779c.mValue);
                        }
                        if (tRTCVideoRenderListener != 0) {
                            a<TRTCCloudListener.TRTCVideoRenderListener> aVar2 = new a<>((byte) 0);
                            aVar2.d = tRTCVideoRenderListener;
                            aVar2.b = convertTRTCFormatTypeToPixelFormatType;
                            aVar2.f22779c = convertTRTCBufferTypeToPixelBufferType;
                            nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, true, str, 0, aVar2.b.getValue(), aVar2.f22779c.mValue);
                            nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, true, str, 2, aVar2.b.getValue(), aVar2.f22779c.mValue);
                            this.mRemoteVideoRenderListenerMap.put(str, aVar2);
                        } else {
                            this.mRemoteVideoRenderListenerMap.remove(str);
                        }
                    }
                }
            }
            this.mJniReadLock.unlock();
            return 0;
        } catch (Throwable th) {
            this.mJniReadLock.unlock();
            throw th;
        }
    }

    public int setRemoteVideoStreamType(String str, int i) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeSetRemoteVideoStreamType(this.mNativeTrtcCloudJni, str, i);
            }
            this.mJniReadLock.unlock();
            return 0;
        } catch (Throwable th) {
            this.mJniReadLock.unlock();
            throw th;
        }
    }

    public void setRemoteViewFillMode(String str, int i, int i2) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeSetRemoteViewFillMode(this.mNativeTrtcCloudJni, str, i, i2);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setRemoteViewMirror(String str, int i, int i2) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeSetRemoteViewMirror(this.mNativeTrtcCloudJni, str, i, i2);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setRemoteViewRotation(String str, int i, int i2) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeSetRemoteViewRotation(this.mNativeTrtcCloudJni, str, i, i2);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setVideoEncoderMirror(boolean z) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeSetVideoEncoderMirror(this.mNativeTrtcCloudJni, z);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setVideoEncoderParams(int i, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeSetVideoEncoderParams(this.mNativeTrtcCloudJni, i, new VideoEncParams(tRTCVideoEncParam));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setVideoEncoderRotation(int i) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeSetVideoEncoderRotation(this.mNativeTrtcCloudJni, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setVideoMuteImage(int i, Bitmap bitmap, int i2) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeSetVideoMuteImage(this.mNativeTrtcCloudJni, i, bitmap, i2);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setWatermark(Bitmap bitmap, int i, float f, float f2, float f3) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeSetWatermark(this.mNativeTrtcCloudJni, bitmap, i, f, f2, f3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void showDashboardManager(int i) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeShowDashboardManager(this.mNativeTrtcCloudJni, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void snapshotVideo(String str, int i, TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener) {
        this.mJniReadLock.lock();
        try {
            this.mSnapshotListener = tRTCSnapshotListener;
            if (this.mNativeTrtcCloudJni != 0) {
                nativeSnapshotVideo(this.mNativeTrtcCloudJni, str, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int startAudioRecording(TRTCCloudDef.TRTCAudioRecordingParams tRTCAudioRecordingParams) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni == 0) {
                this.mJniReadLock.unlock();
                return 0;
            }
            return nativeStartAudioRecording(this.mNativeTrtcCloudJni, new AudioRecordingParams(tRTCAudioRecordingParams));
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startLocalAudio() {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeStartLocalAudio(this.mNativeTrtcCloudJni);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startLocalAudio(int i) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeStartLocalAudioWithQuality(this.mNativeTrtcCloudJni, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startLocalPreview(boolean z, TXCloudVideoView tXCloudVideoView) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeStartLocalPreview(this.mNativeTrtcCloudJni, z, new DisplayTarget(tXCloudVideoView));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startLocalRecording(TRTCCloudDef.TRTCLocalRecordingParams tRTCLocalRecordingParams) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeStartLocalRecording(this.mNativeTrtcCloudJni, new LocalRecordingParams(tRTCLocalRecordingParams));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startPublishCDNStream(TRTCCloudDef.TRTCPublishCDNParam tRTCPublishCDNParam) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeStartPublishCDNStream(this.mNativeTrtcCloudJni, new PublishCDNParams(tRTCPublishCDNParam));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startPublishMediaStream(TRTCCloudDef.TRTCPublishTarget tRTCPublishTarget, TRTCCloudDef.TRTCStreamEncoderParam tRTCStreamEncoderParam, TRTCCloudDef.TRTCStreamMixingConfig tRTCStreamMixingConfig) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeStartPublishMediaStream(this.mNativeTrtcCloudJni, tRTCPublishTarget == null ? null : new PublishTarget(tRTCPublishTarget), tRTCStreamEncoderParam == null ? null : new StreamEncoderParam(tRTCStreamEncoderParam), tRTCStreamMixingConfig == null ? null : new StreamMixingConfig(tRTCStreamMixingConfig));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startPublishing(String str, int i) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeStartPublishing(this.mNativeTrtcCloudJni, str, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startRemoteView(String str, int i, TXCloudVideoView tXCloudVideoView) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeStartRemoteView(this.mNativeTrtcCloudJni, str, i, new DisplayTarget(tXCloudVideoView));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startRemoteView(String str, TXCloudVideoView tXCloudVideoView) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeStartRemoteViewWithoutStreamType(this.mNativeTrtcCloudJni, str, new DisplayTarget(tXCloudVideoView));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startScreenCapture(int i, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam, final TRTCCloudDef.TRTCScreenShareParams tRTCScreenShareParams) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                ScreenShareParams screenShareParams = tRTCScreenShareParams != null ? new ScreenShareParams(tRTCScreenShareParams) : null;
                if (tRTCVideoEncParam == null) {
                    nativeStartScreenCapture(this.mNativeTrtcCloudJni, i, null, screenShareParams);
                    LiteavLog.w(TAG, "startScreenCapture encParams is null");
                } else {
                    nativeStartScreenCapture(this.mNativeTrtcCloudJni, i, new VideoEncParams(tRTCVideoEncParam), screenShareParams);
                }
            }
            if (tRTCScreenShareParams != null) {
                ThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.liteav.trtc.TrtcCloudJni.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        TrtcCloudJni.this.showFloatingWindow(tRTCScreenShareParams.floatingView);
                    }
                });
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startSpeedTest(boolean z, TRTCCloudDef.TRTCSpeedTestParams tRTCSpeedTestParams) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeStartSpeedTest(this.mNativeTrtcCloudJni, z, new SpeedTestParams(tRTCSpeedTestParams));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startSystemAudioLoopback() {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeStartSystemAudioLoopback(this.mNativeTrtcCloudJni);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopAllRemoteView() {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeStopAllRemoteView(this.mNativeTrtcCloudJni);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopAudioRecording() {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeStopAudioRecording(this.mNativeTrtcCloudJni);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopLocalAudio() {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeStopLocalAudio(this.mNativeTrtcCloudJni);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopLocalPreview() {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeStopLocalPreview(this.mNativeTrtcCloudJni);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopLocalRecording() {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeStopLocalRecording(this.mNativeTrtcCloudJni);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopPublishCDNStream() {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeStopPublishCDNStream(this.mNativeTrtcCloudJni);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopPublishMediaStream(String str) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeStopPublishMediaStream(this.mNativeTrtcCloudJni, str);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopPublishing() {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeStopPublishing(this.mNativeTrtcCloudJni);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopRemoteView(String str) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeStopRemoteViewWithoutStreamType(this.mNativeTrtcCloudJni, str);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopRemoteView(String str, int i) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeStopRemoteView(this.mNativeTrtcCloudJni, str, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopScreenCapture(int i) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeStopScreenCapture(this.mNativeTrtcCloudJni, i);
            }
            this.mJniReadLock.unlock();
            ThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.liteav.trtc.TrtcCloudJni.2
                @Override // java.lang.Runnable
                public final void run() {
                    TrtcCloudJni.this.hideFloatingWindow();
                }
            });
        } catch (Throwable th) {
            this.mJniReadLock.unlock();
            throw th;
        }
    }

    public void stopSpeedTest() {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeStopSpeedTest(this.mNativeTrtcCloudJni);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopSystemAudioLoopback() {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeStopSystemAudioLoopback(this.mNativeTrtcCloudJni);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void switchRole(int i) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeSwitchRole(this.mNativeTrtcCloudJni, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void switchRole(int i, String str) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeSwitchRoleWithPrivateMapKey(this.mNativeTrtcCloudJni, i, str);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void switchRoom(TRTCCloudDef.TRTCSwitchRoomConfig tRTCSwitchRoomConfig) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeSwitchRoom(this.mNativeTrtcCloudJni, new SwitchRoomConfig(tRTCSwitchRoomConfig));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void updateLocalView(TXCloudVideoView tXCloudVideoView) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeUpdateLocalView(this.mNativeTrtcCloudJni, new DisplayTarget(tXCloudVideoView));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void updatePublishMediaStream(String str, TRTCCloudDef.TRTCPublishTarget tRTCPublishTarget, TRTCCloudDef.TRTCStreamEncoderParam tRTCStreamEncoderParam, TRTCCloudDef.TRTCStreamMixingConfig tRTCStreamMixingConfig) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeUpdatePublishMediaStream(this.mNativeTrtcCloudJni, str, tRTCPublishTarget == null ? null : new PublishTarget(tRTCPublishTarget), tRTCStreamEncoderParam == null ? null : new StreamEncoderParam(tRTCStreamEncoderParam), tRTCStreamMixingConfig == null ? null : new StreamMixingConfig(tRTCStreamMixingConfig));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void updateRemote3DSpatialPosition(String str, int[] iArr) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeUpdateRemote3DSpatialPosition(this.mNativeTrtcCloudJni, str, iArr);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void updateRemoteView(String str, int i, TXCloudVideoView tXCloudVideoView) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeUpdateRemoteView(this.mNativeTrtcCloudJni, str, i, new DisplayTarget(tXCloudVideoView));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void updateSelf3DSpatialPosition(int[] iArr, float[] fArr, float[] fArr2, float[] fArr3) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                nativeUpdateSelf3DSpatialPosition(this.mNativeTrtcCloudJni, iArr, fArr, fArr2, fArr3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }
}

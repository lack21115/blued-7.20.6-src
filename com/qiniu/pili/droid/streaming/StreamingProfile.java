package com.qiniu.pili.droid.streaming;

import a.a.a.a.a.e.e;
import a.a.a.a.a.e.f;
import a.a.a.a.a.e.h;
import android.bluetooth.BluetoothClass;
import android.graphics.Point;
import android.media.AudioSystem;
import android.net.wifi.WifiScanner;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.das.live.LiveProtos;
import com.kuaishou.pushad.BuildConfig;
import com.qiniu.android.dns.DnsManager;
import com.qiniu.pili.droid.streaming.CameraStreamingSetting;
import com.sina.weibo.sdk.constant.WBConstants;
import com.tencent.ugc.UGCTransitionRules;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/StreamingProfile.class */
public class StreamingProfile {
    public static final int AUDIO_QUALITY_HIGH1 = 20;
    public static final int AUDIO_QUALITY_HIGH2 = 21;
    public static final int AUDIO_QUALITY_LOW1 = 0;
    public static final int AUDIO_QUALITY_LOW2 = 1;
    public static final int AUDIO_QUALITY_MEDIUM1 = 10;
    public static final int AUDIO_QUALITY_MEDIUM2 = 11;
    public static final int AUDIO_TRACK_INDEX = 0;
    public static final int HIGH_LEVEL = 2;
    public static final int LOW_LEVEL = 0;
    public static final int MEDIUM_LEVEL = 1;
    @Deprecated
    public static final int QUALITY_HIGH1 = 20;
    @Deprecated
    public static final int QUALITY_HIGH2 = 21;
    @Deprecated
    public static final int QUALITY_HIGH3 = 22;
    @Deprecated
    public static final int QUALITY_LOW1 = 0;
    @Deprecated
    public static final int QUALITY_LOW2 = 1;
    @Deprecated
    public static final int QUALITY_LOW3 = 2;
    @Deprecated
    public static final int QUALITY_MEDIUM1 = 10;
    @Deprecated
    public static final int QUALITY_MEDIUM2 = 11;
    @Deprecated
    public static final int QUALITY_MEDIUM3 = 12;
    public static final int VIDEO_ENCODING_HEIGHT_1088 = 4;
    public static final int VIDEO_ENCODING_HEIGHT_240 = 0;
    public static final int VIDEO_ENCODING_HEIGHT_480 = 1;
    public static final int VIDEO_ENCODING_HEIGHT_544 = 2;
    public static final int VIDEO_ENCODING_HEIGHT_720 = 3;
    @Deprecated
    public static final int VIDEO_ENCODING_SIZE_FHD = 4;
    @Deprecated
    public static final int VIDEO_ENCODING_SIZE_HD = 3;
    @Deprecated
    public static final int VIDEO_ENCODING_SIZE_QVGA = 0;
    @Deprecated
    public static final int VIDEO_ENCODING_SIZE_VGA = 1;
    public static final int VIDEO_QUALITY_HIGH1 = 20;
    public static final int VIDEO_QUALITY_HIGH2 = 21;
    public static final int VIDEO_QUALITY_HIGH3 = 22;
    public static final int VIDEO_QUALITY_LOW1 = 0;
    public static final int VIDEO_QUALITY_LOW2 = 1;
    public static final int VIDEO_QUALITY_LOW3 = 2;
    public static final int VIDEO_QUALITY_MEDIUM1 = 10;
    public static final int VIDEO_QUALITY_MEDIUM2 = 11;
    public static final int VIDEO_QUALITY_MEDIUM3 = 12;
    public static final int VIDEO_TRACK_INDEX = 1;
    public VideoEncodingSize b;

    /* renamed from: c  reason: collision with root package name */
    public Point f27834c;
    public f d;
    public Stream h;
    public String i;
    public String j;
    public SendingBufferProfile k;
    public AVProfile l;
    public Map<Integer, Integer> n;
    public ENCODING_ORIENTATION o;
    public StreamStatusConfig q;
    public String x;
    public String y;
    public static DnsManager E = h.f();
    public static int F = 3;
    public static final int[][] G = {new int[]{0, 0, 12, 153600, 3}, new int[]{0, 1, 15, 270336, 3}, new int[]{0, 2, 15, 358400, 3}, new int[]{1, 10, 30, 524288, 3}, new int[]{1, 11, 30, 819200, 3}, new int[]{1, 12, 30, WifiScanner.MAX_SCAN_PERIOD_MS, 3}, new int[]{2, 20, 30, 1228800, 3}, new int[]{2, 21, 30, 1536000, 3}, new int[]{2, 22, 30, 2048000, 3}};
    public static final int[][] H = {new int[]{0, 0, 44100, 18432}, new int[]{0, 1, 44100, AudioSystem.DEVICE_OUT_ALL_USB}, new int[]{1, 10, 44100, 32768}, new int[]{1, 11, 44100, 49152}, new int[]{2, 20, 44100, 98304}, new int[]{2, 21, 44100, 131072}};
    public static final VideoEncodingSize[] I = {new VideoEncodingSize(0, 424, 240), new VideoEncodingSize(1, 848, 480), new VideoEncodingSize(2, 960, LiveProtos.Event.LIVE_GIFT_EFFECT_BTN_CLICK_VALUE), new VideoEncodingSize(3, 1280, UGCTransitionRules.DEFAULT_IMAGE_WIDTH), new VideoEncodingSize(4, WBConstants.SDK_NEW_PAY_VERSION, BluetoothClass.Device.AUDIO_VIDEO_VIDEO_CONFERENCING)};
    public static final VideoEncodingSize[] J = {new VideoEncodingSize(0, 320, 240), new VideoEncodingSize(1, 640, 480), new VideoEncodingSize(2, UGCTransitionRules.DEFAULT_IMAGE_WIDTH, LiveProtos.Event.LIVE_GIFT_EFFECT_BTN_CLICK_VALUE), new VideoEncodingSize(3, 960, UGCTransitionRules.DEFAULT_IMAGE_WIDTH), new VideoEncodingSize(4, 1440, BluetoothClass.Device.AUDIO_VIDEO_VIDEO_CONFERENCING)};

    /* renamed from: a  reason: collision with root package name */
    public int f27833a = 0;
    public int e = -1;
    public int f = -1;
    public int g = -1;
    public a m = a.MEDIUM;
    public EncoderRCModes p = EncoderRCModes.QUALITY_PRIORITY;
    public volatile StreamStatus r = new StreamStatus();
    public boolean s = true;
    public boolean t = false;
    public BitrateAdjustMode u = BitrateAdjustMode.Disable;
    public int v = -1;
    public int w = -1;
    public Map<String, String> z = null;
    public String A = null;
    public int B = -1;
    public float C = 5.0f;
    public YuvFilterMode D = YuvFilterMode.None;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/StreamingProfile$AVProfile.class */
    public static class AVProfile {
        public AudioProfile mAudioProfile;
        public VideoProfile mVideoProfile;

        public AVProfile(VideoProfile videoProfile, AudioProfile audioProfile) {
            this.mVideoProfile = videoProfile;
            this.mAudioProfile = audioProfile;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/StreamingProfile$AudioProfile.class */
    public static class AudioProfile {
        public int channelNumber = 1;
        public int reqBitrate;
        public int sampleRate;

        public AudioProfile(int i, int i2) {
            this.sampleRate = i;
            this.reqBitrate = i2;
        }

        public String toString() {
            return "AudioProfile: [" + this.sampleRate + "Hz," + this.reqBitrate + "bps]";
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/StreamingProfile$BitrateAdjustMode.class */
    public enum BitrateAdjustMode {
        Auto,
        Manual,
        Disable
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/StreamingProfile$ENCODING_ORIENTATION.class */
    public enum ENCODING_ORIENTATION {
        PORT,
        LAND
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/StreamingProfile$EncoderRCModes.class */
    public enum EncoderRCModes {
        QUALITY_PRIORITY,
        BITRATE_PRIORITY
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/StreamingProfile$H264Profile.class */
    public enum H264Profile {
        BASELINE,
        MAIN,
        HIGH
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/StreamingProfile$SendingBufferProfile.class */
    public static class SendingBufferProfile {
        public static final long DEFAULT_LOW_THRESHOLD_TIMEOUT = 60000;
        public static final float DURATION_LIMIT_DEFAULT = 3.0f;
        public static final float DURATION_LIMIT_MAX = 5.0f;
        public static final float DURATION_LIMIT_MIN = 1.1f;
        public static final float HIGH_THRESHOLD_DEFAULT = 0.8f;
        public static final float HIGH_THRESHOLD_MAX = 1.0f;
        public static final float HIGH_THRESHOLD_MIN = 0.0f;
        public static final float LOW_THRESHOLD_DEFAULT = 0.2f;
        public static final float LOW_THRESHOLD_MAX = 1.0f;
        public static final float LOW_THRESHOLD_MIN = 0.0f;
        public static final long LOW_THRESHOLD_TIMEOUT_MIN = 10000;
        public float mDurationLimit;
        public float mHighThreshold;
        public float mLowThreshold;
        public long mLowThresholdTimeout;

        public SendingBufferProfile(float f, float f2, float f3, long j) {
            if (f >= 0.0f && f <= 1.0f) {
                double d = f;
                double d2 = f2;
                if (d < d2 - 0.1d) {
                    if (f2 < 0.0f || f2 > 1.0f || d2 <= d + 0.1d) {
                        throw new IllegalArgumentException("Illegal highThreshold value:" + this.mHighThreshold);
                    } else if (f3 < 1.1f || f3 > 5.0f) {
                        throw new IllegalArgumentException("Illegal durationLimit value:" + this.mDurationLimit);
                    } else if (j >= 10000) {
                        this.mLowThreshold = f;
                        this.mHighThreshold = f2;
                        this.mDurationLimit = f3;
                        this.mLowThresholdTimeout = j;
                        return;
                    } else {
                        throw new IllegalArgumentException("Illegal timeout value:" + j + ", should at least:10000");
                    }
                }
            }
            throw new IllegalArgumentException("Illegal lowThreshold value:" + this.mLowThreshold);
        }

        public float getDurationLimit() {
            return this.mDurationLimit;
        }

        public float getHighThreshold() {
            return this.mHighThreshold;
        }

        public float getLowThreshold() {
            return this.mLowThreshold;
        }

        public long getLowThresholdTimeout() {
            return this.mLowThresholdTimeout;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/StreamingProfile$Stream.class */
    public static class Stream {
        public String hubName;
        public String publishKey;
        public String publishRtmpHost;
        public String publishSecurity;
        public String streamId;
        public String title;

        public Stream(JSONObject jSONObject) {
            try {
                this.streamId = jSONObject.getString("id");
                this.hubName = jSONObject.getString("hub");
                this.title = jSONObject.getString("title");
                this.publishKey = jSONObject.getString("publishKey");
                this.publishSecurity = jSONObject.getString("publishSecurity");
                this.publishRtmpHost = jSONObject.getJSONObject("hosts").getJSONObject(BuildConfig.FLAVOR).getString("rtmp");
            } catch (JSONException e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        public String getHubName() {
            return this.hubName;
        }

        public String getPublishKey() {
            return this.publishKey;
        }

        public String getPublishRtmpHost() {
            return this.publishRtmpHost;
        }

        public String getPublishSecurity() {
            return this.publishSecurity;
        }

        public String getStreamId() {
            return this.streamId;
        }

        public String getTitle() {
            return this.title;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/StreamingProfile$StreamStatus.class */
    public static class StreamStatus {
        public int audioBitrate;
        public int audioFps;
        public float meanTcpSendTimeInMilliseconds;
        public int totalAVBitrate;
        public int totalAVBitrateProduce;
        public int videoBitrate;
        public int videoFps;
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/StreamingProfile$StreamStatusConfig.class */
    public static class StreamStatusConfig {
        public static final int DEFAULT_INTERVAL_SECOND = 3;
        public static final int MAX_INTERVAL_SECOND = 30;
        public static final int MIN_INTERVAL_SECOND = 1;
        public int mIntervalMs;

        public StreamStatusConfig(int i) {
            this.mIntervalMs = 3000;
            if (i >= 1 && i <= 30) {
                this.mIntervalMs = i * 1000;
                return;
            }
            throw new IllegalArgumentException("Bad Interval value:" + i);
        }

        public int getIntervalMs() {
            return this.mIntervalMs;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/StreamingProfile$VideoEncodingSize.class */
    public static class VideoEncodingSize {
        public int height;
        public int level;
        public int width;

        public VideoEncodingSize(int i, int i2, int i3) {
            this.level = i;
            this.width = i2;
            this.height = i3;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/StreamingProfile$VideoProfile.class */
    public static class VideoProfile {
        public boolean avcc;
        public H264Profile h264Profile;
        public int maxKeyFrameInterval;
        public int reqBitrate;
        public int reqFps;

        public VideoProfile(int i, int i2) {
            this.reqFps = i;
            this.reqBitrate = i2;
            this.maxKeyFrameInterval = i * 3;
            this.h264Profile = H264Profile.BASELINE;
            this.avcc = true;
        }

        public VideoProfile(int i, int i2, int i3) {
            this.reqFps = i;
            this.reqBitrate = i2;
            this.maxKeyFrameInterval = i3;
            this.h264Profile = H264Profile.BASELINE;
            this.avcc = true;
        }

        public VideoProfile(int i, int i2, int i3, H264Profile h264Profile) {
            this.reqFps = i;
            this.reqBitrate = i2;
            this.maxKeyFrameInterval = i3;
            this.h264Profile = h264Profile;
            this.avcc = true;
        }

        public VideoProfile(int i, int i2, int i3, boolean z) {
            this.reqFps = i;
            this.reqBitrate = i2;
            this.maxKeyFrameInterval = i3;
            this.h264Profile = H264Profile.BASELINE;
            this.avcc = z;
        }

        public H264Profile getH264Profile() {
            return this.h264Profile;
        }

        public String toString() {
            return "VideoProfile: [" + this.reqFps + "fps," + this.reqBitrate + "bps, GOP:" + this.maxKeyFrameInterval + "," + this.h264Profile + ",avcc=" + this.avcc + "]";
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/StreamingProfile$YuvFilterMode.class */
    public enum YuvFilterMode {
        None,
        Linear,
        Bilinear,
        Box
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/StreamingProfile$a.class */
    public enum a {
        HIGH,
        MEDIUM,
        LOW
    }

    private AudioProfile getAudioProfileByQuality(int i) {
        int[] a2 = a(i, H);
        int[] iArr = a2;
        if (a2 == null) {
            iArr = H[0];
        }
        return new AudioProfile(iArr[2], iArr[3]);
    }

    public static DnsManager getDnsManager() {
        return E;
    }

    private int getProfileLow(int i) {
        return i - (getQualityLevelByQuality(i) * 10);
    }

    private int getQualityLevelByQuality(int i) {
        if (i < 0 || i >= 10) {
            if (i < 10 || i >= 20) {
                if (i < 30) {
                    return 2;
                }
                throw new RuntimeException("Illegal quality:(" + i + "), the range of the quality is[20,29]");
            }
            return 1;
        }
        return 0;
    }

    public static int getSendTimeout() {
        return F;
    }

    private Map<Integer, Integer> getSupportVideoQualitiesByProfile(int[][] iArr) {
        HashMap hashMap = new HashMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iArr.length) {
                return hashMap;
            }
            int[] iArr2 = iArr[i2];
            if (iArr2[0] == 0) {
                hashMap.put(0, Integer.valueOf(iArr2[1]));
            } else if (iArr2[0] == 1) {
                hashMap.put(1, Integer.valueOf(iArr2[1]));
            } else if (iArr2[0] != 2) {
                throw new IllegalStateException("Never go here!");
            } else {
                hashMap.put(2, Integer.valueOf(iArr2[1]));
            }
            i = i2 + 1;
        }
    }

    private VideoProfile getVideoProfileByQuality(int i) {
        int[] a2 = a(i, G);
        int[] iArr = a2;
        if (a2 == null) {
            iArr = G[0];
        }
        return new VideoProfile(iArr[2], iArr[3], iArr[2] * iArr[4]);
    }

    public final int a(int i, int i2, int[][] iArr) {
        if (e()) {
            return this.f;
        }
        int length = iArr.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                throw new IllegalArgumentException("Illegal quality:" + i2);
            } else if (iArr[i4][1] == i2) {
                int i5 = i4 + i;
                int i6 = i5;
                if (i5 >= length) {
                    e eVar = e.f1361c;
                    eVar.d("StreamingProfile", "quality have been out of the MAX:" + i5 + ", choose the max quality!");
                    i6 = length - 1;
                }
                AVProfile aVProfile = this.l;
                if (aVProfile != null && aVProfile.mVideoProfile != null) {
                    this.l.mVideoProfile.reqBitrate = getVideoProfileByQuality(iArr[i6][1]).reqBitrate;
                }
                return iArr[i6][1];
            } else {
                i3 = i4 + 1;
            }
        }
    }

    public final int a(AVProfile aVProfile, int[][] iArr) {
        int i = -1;
        if (aVProfile != null) {
            i = -1;
            if (iArr != null) {
                if (iArr != G && iArr != H) {
                    return -1;
                }
                int i2 = 0;
                boolean z = iArr == G;
                if (z && aVProfile.mVideoProfile == null) {
                    return -1;
                }
                if (!z && aVProfile.mAudioProfile == null) {
                    return -1;
                }
                int length = iArr.length;
                int i3 = z ? aVProfile.mVideoProfile.reqBitrate : aVProfile.mAudioProfile.reqBitrate;
                if (i3 > iArr[0][3]) {
                    int i4 = length - 1;
                    if (i3 < iArr[i4][3]) {
                        while (true) {
                            i = -1;
                            if (i2 < i4) {
                                if (i3 >= iArr[i2][3] && i3 < iArr[i2 + 1][3]) {
                                    i = iArr[i2][1];
                                    break;
                                }
                                i2++;
                            } else {
                                break;
                            }
                        }
                    } else {
                        i = z ? 22 : 21;
                    }
                } else {
                    i = 0;
                }
                e eVar = e.f1361c;
                StringBuilder sb = new StringBuilder();
                sb.append(z ? "target video quality = " : "target audio quality = ");
                sb.append(i);
                eVar.b("StreamingProfile", sb.toString());
            }
        }
        return i;
    }

    public final VideoEncodingSize a(VideoEncodingSize[] videoEncodingSizeArr, int i) {
        int length = videoEncodingSizeArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return null;
            }
            VideoEncodingSize videoEncodingSize = videoEncodingSizeArr[i3];
            if (videoEncodingSize.level == i) {
                return videoEncodingSize;
            }
            i2 = i3 + 1;
        }
    }

    public boolean a() {
        return this.u == BitrateAdjustMode.Auto;
    }

    public final boolean a(int i) {
        if (i < 0 || i >= 30) {
            throw new IllegalArgumentException("Illegal quality:(" + i + "), the range of the quality is[20,29]");
        }
        return true;
    }

    public final boolean a(Stream stream) {
        String streamId = stream.getStreamId();
        String title = stream.getTitle();
        String publishRtmpHost = stream.getPublishRtmpHost();
        String publishKey = stream.getPublishKey();
        String publishSecurity = stream.getPublishSecurity();
        String hubName = stream.getHubName();
        if (!h.a(streamId)) {
            throw new IllegalArgumentException("Illegal streamId:" + streamId);
        } else if (!h.a(title)) {
            throw new IllegalArgumentException("Illegal title:" + title);
        } else if (!h.a(publishRtmpHost)) {
            throw new IllegalArgumentException("Illegal publish host:" + publishRtmpHost);
        } else if (!h.a(publishKey)) {
            throw new IllegalArgumentException("Illegal publish key:" + publishKey);
        } else if (!h.a(publishSecurity)) {
            throw new IllegalArgumentException("Illegal publish security:" + publishSecurity);
        } else if (h.a(hubName)) {
            return true;
        } else {
            throw new IllegalArgumentException("Illegal hub name:" + hubName);
        }
    }

    public final int[] a(int i, int[][] iArr) {
        if (i == -1) {
            return null;
        }
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                throw new IllegalArgumentException("Cannot support the quality:" + i);
            }
            int[] iArr2 = iArr[i3];
            if (iArr2[1] == i) {
                return iArr2;
            }
            i2 = i3 + 1;
        }
    }

    public final int b(int i, int i2, int[][] iArr) {
        int length = iArr.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                throw new IllegalArgumentException("Illegal quality:" + i2);
            } else if (iArr[i4][1] == i2) {
                int i5 = i4 - i;
                if (i5 < 0) {
                    i5 = 0;
                }
                AVProfile aVProfile = this.l;
                if (aVProfile != null && aVProfile.mVideoProfile != null) {
                    this.l.mVideoProfile.reqBitrate = getVideoProfileByQuality(iArr[i5][1]).reqBitrate;
                }
                return iArr[i5][1];
            } else {
                i3 = i4 + 1;
            }
        }
    }

    public boolean b() {
        return this.u != BitrateAdjustMode.Disable;
    }

    public boolean b(int i) {
        return i >= 10240 && i <= 10240000;
    }

    public boolean c() {
        return this.o == ENCODING_ORIENTATION.LAND;
    }

    public boolean d() {
        return this.s;
    }

    public boolean e() {
        return this.e >= this.f;
    }

    public boolean f() {
        return this.t;
    }

    public AudioProfile getAudioProfile() {
        AVProfile aVProfile = this.l;
        return (aVProfile == null || aVProfile.mAudioProfile == null) ? getAudioProfileByQuality(this.g) : this.l.mAudioProfile;
    }

    public int getBestFromVideoQualityRank() {
        Map<Integer, Integer> map = this.n;
        int i = -1;
        int i2 = -1;
        if (map != null) {
            int i3 = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                e.f1361c.c("StreamingProfile", "key:" + entry.getKey().intValue() + ",value:" + entry.getValue().intValue());
                if (entry.getValue().intValue() >= 2 && i3 <= entry.getValue().intValue()) {
                    i3 = entry.getValue().intValue();
                    i = entry.getKey().intValue();
                }
            }
            e.f1361c.c("StreamingProfile", "best:" + i);
            i2 = i;
        }
        return i2;
    }

    public BitrateAdjustMode getBitrateAdjustMode() {
        return this.u;
    }

    public a getCPUWorkload() {
        return this.m;
    }

    public int getCurrentAudioQuality() {
        return this.g;
    }

    public int getCurrentVideoQuality() {
        return this.e;
    }

    public EncoderRCModes getEncoderRCMode() {
        return this.p;
    }

    public ENCODING_ORIENTATION getEncodingOrientation() {
        return this.o;
    }

    public int getEncodingSizeLevel() {
        return this.f27833a;
    }

    public f getImageSize() {
        return this.d;
    }

    public String getLocalFileAbsolutePath() {
        return this.j;
    }

    public String getPictureStreamingFilePath() {
        return this.A;
    }

    public float getPictureStreamingFps() {
        return this.C;
    }

    public int getPictureStreamingResourceId() {
        return this.B;
    }

    public String getPublishHost() {
        return this.i;
    }

    public String getPublishUrl() {
        return this.x;
    }

    public Map<String, String> getRtmpOptions() {
        return this.z;
    }

    public SendingBufferProfile getSendingBufferInfo() {
        return this.k;
    }

    public Point getStartPoint() {
        return this.f27834c;
    }

    public Stream getStream() {
        return this.h;
    }

    public String getStreamId() {
        Stream stream = this.h;
        return stream != null ? stream.getStreamId() : this.y;
    }

    public StreamStatus getStreamStatus() {
        return this.r;
    }

    public StreamStatusConfig getStreamStatusConfig() {
        if (this.q == null) {
            this.q = new StreamStatusConfig(3);
        }
        return this.q;
    }

    public Map<Integer, Integer> getSupportAudioQualities() {
        return getSupportVideoQualitiesByProfile(H);
    }

    public Map<Integer, Integer> getSupportVideoQualities() {
        return getSupportVideoQualitiesByProfile(G);
    }

    public int getTargetVideoQuality() {
        return this.f;
    }

    public VideoEncodingSize getVideoEncodingSize(CameraStreamingSetting.PREVIEW_SIZE_RATIO preview_size_ratio) {
        VideoEncodingSize videoEncodingSize = this.b;
        if (videoEncodingSize != null) {
            return videoEncodingSize;
        }
        if (preview_size_ratio == CameraStreamingSetting.PREVIEW_SIZE_RATIO.RATIO_16_9) {
            return a(I, this.f27833a);
        }
        if (preview_size_ratio == CameraStreamingSetting.PREVIEW_SIZE_RATIO.RATIO_4_3) {
            return a(J, this.f27833a);
        }
        throw new IllegalArgumentException("Only support 16:9/4:3 ratio!");
    }

    public int getVideoMaxBitrate() {
        return this.w;
    }

    public int getVideoMinBitrate() {
        return this.v;
    }

    public VideoProfile getVideoProfile() {
        AVProfile aVProfile = this.l;
        return (aVProfile == null || aVProfile.mVideoProfile == null) ? getVideoProfileByQuality(this.e) : this.l.mVideoProfile;
    }

    public Map<Integer, Integer> getVideoQualityRank() {
        return this.n;
    }

    public YuvFilterMode getYuvFilterMode() {
        return this.D;
    }

    public boolean improveVideoQuality(int i) {
        int i2 = this.e;
        if (i2 == -1 || this.k == null) {
            e eVar = e.f1361c;
            eVar.e("StreamingProfile", "Fail! mVideoQuality:" + this.e + ",mSendingBufferInfo:" + this.k);
            return false;
        }
        this.e = a(i, i2, G);
        e eVar2 = e.f1361c;
        eVar2.b("StreamingProfile", "improve video quality:" + this.e);
        if (this.n.containsKey(Integer.valueOf(i2))) {
            this.n.put(Integer.valueOf(i2), Integer.valueOf(this.n.get(Integer.valueOf(i2)).intValue() - 1));
        }
        if (this.n.containsKey(Integer.valueOf(this.e))) {
            this.n.put(Integer.valueOf(this.e), Integer.valueOf(this.n.get(Integer.valueOf(this.e)).intValue() + 1));
            return true;
        }
        this.n.put(Integer.valueOf(this.e), 1);
        return true;
    }

    public boolean reduceVideoQuality(int i) {
        int i2 = this.e;
        if (i2 == -1 || this.k == null) {
            e eVar = e.f1361c;
            eVar.e("StreamingProfile", "Fail! mVideoQuality:" + this.e + ",mSendingBufferInfo:" + this.k);
            return false;
        }
        this.e = b(i, i2, G);
        e eVar2 = e.f1361c;
        eVar2.b("StreamingProfile", "reduce video quality:" + this.e);
        if (this.n.containsKey(Integer.valueOf(i2))) {
            this.n.put(Integer.valueOf(i2), Integer.valueOf(this.n.get(Integer.valueOf(i2)).intValue() - 1));
        }
        if (this.n.containsKey(Integer.valueOf(this.e))) {
            this.n.put(Integer.valueOf(this.e), Integer.valueOf(this.n.get(Integer.valueOf(this.e)).intValue() + 1));
            return true;
        }
        this.n.put(Integer.valueOf(this.e), 1);
        return true;
    }

    public StreamingProfile setAVProfile(AVProfile aVProfile) {
        this.l = aVProfile;
        this.e = a(aVProfile, G);
        this.g = a(aVProfile, H);
        this.f = this.e;
        return this;
    }

    public StreamingProfile setAdaptiveBitrateAdjustThreshold(int i, int i2) {
        if (i < 1 || i > 10 || i2 < 1 || i2 > 20) {
            e.f1361c.e("StreamingProfile", "Out of range: tcpSendTimeMsSafeThreshold: 1~10, fpsDangerousThreshold: 1~20");
            return this;
        }
        a.a.a.a.a.m.a.a(i, i2);
        return this;
    }

    @Deprecated
    public StreamingProfile setAdaptiveBitrateEnable(boolean z) {
        setBitrateAdjustMode(BitrateAdjustMode.Auto);
        return this;
    }

    public StreamingProfile setAudioQuality(int i) {
        if (a(i)) {
            this.g = i;
        }
        return this;
    }

    public StreamingProfile setBitrateAdjustMode(BitrateAdjustMode bitrateAdjustMode) {
        this.u = bitrateAdjustMode;
        return this;
    }

    public StreamingProfile setDnsManager(DnsManager dnsManager) {
        E = dnsManager;
        return this;
    }

    public StreamingProfile setEncoderRCMode(EncoderRCModes encoderRCModes) {
        this.p = encoderRCModes;
        return this;
    }

    public StreamingProfile setEncodingOrientation(ENCODING_ORIENTATION encoding_orientation) {
        this.o = encoding_orientation;
        return this;
    }

    public StreamingProfile setEncodingSizeLevel(int i) {
        if (i < 0 || i > 4) {
            throw new IllegalArgumentException("Illegal encoding size level. The range is:[0,4]");
        }
        if (this.b == null) {
            this.f27833a = i;
        }
        return this;
    }

    public StreamingProfile setFpsControllerEnable(boolean z) {
        this.s = z;
        return this;
    }

    public StreamingProfile setLocalFileAbsolutePath(String str) {
        this.j = str;
        return this;
    }

    public StreamingProfile setPictureStreamingFilePath(String str) {
        this.A = str;
        this.B = -1;
        return this;
    }

    public void setPictureStreamingFps(float f) {
        if (f <= 0.0f || f > 30.0f) {
            e.d.e("StreamingProfile", "Error: fps range: 0-30");
        }
        this.C = f;
    }

    public StreamingProfile setPictureStreamingResourceId(int i) {
        this.B = i;
        this.A = null;
        return this;
    }

    public StreamingProfile setPreferredVideoEncodingSize(int i, int i2) {
        setPreferredVideoEncodingSize(i, i2, null, 0, 0);
        return this;
    }

    public StreamingProfile setPreferredVideoEncodingSize(int i, int i2, Point point, int i3, int i4) {
        e eVar = e.d;
        eVar.c("StreamingProfile", "setPreferredVideoEncodingSize: width = " + i + ", height = " + i2 + ", image width = " + i3 + ", image height = " + i4);
        this.f27833a = -1;
        this.b = new VideoEncodingSize(-1, i, i2);
        this.f27834c = point;
        if (i3 > 0 && i4 > 0) {
            this.d = new f(i3, i4);
        }
        return this;
    }

    public StreamingProfile setPublishUrl(String str) throws URISyntaxException {
        this.x = str;
        URI uri = new URI(str);
        if (uri.getHost() != null) {
            this.h = null;
            this.i = uri.getHost();
            String path = uri.getPath();
            this.y = path;
            if (h.a(path) && this.y.startsWith(BridgeUtil.SPLIT_MARK)) {
                this.y = this.y.substring(1);
            }
            return this;
        }
        throw new URISyntaxException(str, "no host");
    }

    @Deprecated
    public StreamingProfile setQuality(int i) {
        if (a(i)) {
            this.e = i;
            this.f = i;
        }
        return this;
    }

    public StreamingProfile setQuicEnable(boolean z) {
        this.t = z;
        return this;
    }

    public StreamingProfile setRtmpOptions(String str, String str2) {
        if (this.z == null) {
            this.z = new HashMap();
        }
        this.z.put(str, str2);
        return this;
    }

    public StreamingProfile setSendTimeoutInSecond(int i) {
        if (i >= 3) {
            F = i;
            return this;
        }
        throw new IllegalArgumentException("RTMPSendTimeout should be greater than 3 seconds!");
    }

    public StreamingProfile setSendingBufferProfile(SendingBufferProfile sendingBufferProfile) {
        this.k = sendingBufferProfile;
        this.n = new HashMap();
        return this;
    }

    public StreamingProfile setStream(Stream stream) {
        a(stream);
        this.h = stream;
        this.i = stream.getPublishRtmpHost();
        return this;
    }

    public StreamingProfile setStreamStatusConfig(StreamStatusConfig streamStatusConfig) {
        this.q = streamStatusConfig;
        return this;
    }

    public StreamingProfile setVideoAdaptiveBitrateRange(int i, int i2) {
        int[][] iArr = G;
        int i3 = iArr[0][3];
        int i4 = iArr[iArr.length - 1][3];
        if (i >= i3) {
            this.v = i;
        } else {
            e eVar = e.f1361c;
            eVar.d("StreamingProfile", "bitrate have been out of the MIN:" + i3 + "!");
        }
        if (i2 <= i4) {
            this.w = i2;
            return this;
        }
        e eVar2 = e.f1361c;
        eVar2.d("StreamingProfile", "bitrate have been out of the MAX:" + i4 + "!");
        return this;
    }

    public StreamingProfile setVideoQuality(int i) {
        return setQuality(i);
    }

    public StreamingProfile setYuvFilterMode(YuvFilterMode yuvFilterMode) {
        this.D = yuvFilterMode;
        return this;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.b != null) {
                jSONObject.put("PreferredVideoEncodingWidth", this.b.width);
                jSONObject.put("PreferredVideoEncodingHeight", this.b.height);
            } else {
                jSONObject.put("EncodingSizeLevel", this.f27833a);
            }
            jSONObject.put("QuicEnable", this.t);
            jSONObject.put("SendTimeout", F);
            jSONObject.put("EncoderRCMode", this.p);
            jSONObject.put("FpsController", this.s);
            jSONObject.put("AdjustBitrate", this.u != BitrateAdjustMode.Disable);
            jSONObject.put("AdaptiveBitrate", this.u == BitrateAdjustMode.Auto);
            if (this.v > 0 && this.w > 0) {
                jSONObject.put("VideoMinBitrate", this.v);
                jSONObject.put("VideoMaxBitrate", this.w);
            }
            jSONObject.put("EncodingOrientation", this.o);
            jSONObject.put("VideoQuality", this.e);
            jSONObject.put("AudioQuality", this.g);
            if (this.l != null && this.l.mVideoProfile != null && this.l.mAudioProfile != null) {
                jSONObject.put("VideoProfile", this.l.mVideoProfile);
                jSONObject.put("AudioProfile", this.l.mAudioProfile);
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return e.toString();
        }
    }
}

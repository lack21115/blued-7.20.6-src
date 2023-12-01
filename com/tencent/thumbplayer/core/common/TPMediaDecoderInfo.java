package com.tencent.thumbplayer.core.common;

import android.media.MediaCodecInfo;
import android.os.Build;
import android.util.Range;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/common/TPMediaDecoderInfo.class */
public final class TPMediaDecoderInfo implements Serializable {
    private static final int DEFAULT_MAX_BITRATE = 960000;
    private static final int DEFAULT_MAX_CHANNELNUM = 2;
    private static final int DEFAULT_MAX_HEIGHT = 720;
    private static final int DEFAULT_MAX_SAMPLERATE = 48000;
    private static final int DEFAULT_MAX_WIDTH = 1280;
    private static final int DEFAULT_MIN_BITRATE = 8000;
    private static final String TAG = "TPCodecUtils";
    private static final ArrayList<String> mAudioDecoderWhiteList;
    private static final ArrayList<String> mVideoSoftwareDecoderWhiteList;
    private boolean adaptiveDec;
    private int[] colorFormats;
    private String decMimeType;
    private String decName;
    private int maxBitRate;
    private int maxChannels;
    private int maxFrameRate;
    private int maxHeight;
    private int maxLumaFrameRate;
    private int maxLumaHeight;
    private int maxLumaWidth;
    private int maxSampleRate;
    private int maxSupportedInstances;
    private int maxWidth;
    private DecoderProfileLevel[] profileLevels;
    private boolean secureDec;
    private boolean softwareAudioDec;
    private boolean softwareVideoDec;
    private boolean tunnelingDec;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/common/TPMediaDecoderInfo$DecoderProfileLevel.class */
    public final class DecoderProfileLevel implements Serializable {
        public int level;
        public int profile;

        public DecoderProfileLevel(int i, int i2) {
            this.profile = i;
            this.level = i2;
        }
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        mVideoSoftwareDecoderWhiteList = arrayList;
        arrayList.add("c2.android.vp9.decoder");
        mVideoSoftwareDecoderWhiteList.add("OMX.google.vp9.decoder");
        mVideoSoftwareDecoderWhiteList.add("c2.android.vp8.decoder");
        mVideoSoftwareDecoderWhiteList.add("OMX.google.vp8.decoder");
        mVideoSoftwareDecoderWhiteList.add("c2.android.av1.decoder");
        mAudioDecoderWhiteList = new ArrayList<>();
    }

    public TPMediaDecoderInfo(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        MediaCodecInfo.AudioCapabilities audioCapabilities;
        reset();
        this.decName = str2;
        this.decMimeType = str;
        this.softwareVideoDec = isVideo() && isVideoSoftwareOnly(str2);
        this.softwareAudioDec = isAudio() && isAudioSoftwareOnly(str2);
        this.adaptiveDec = codecCapabilities != null && isAdaptive(codecCapabilities);
        this.tunnelingDec = codecCapabilities != null && isTunneling(codecCapabilities);
        this.secureDec = codecCapabilities != null && isSecure(codecCapabilities);
        if (codecCapabilities == null || codecCapabilities.profileLevels == null || codecCapabilities.profileLevels.length <= 0) {
            this.profileLevels = new DecoderProfileLevel[0];
        } else {
            ArrayList arrayList = new ArrayList();
            MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = codecCapabilities.profileLevels;
            int length = codecProfileLevelArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                MediaCodecInfo.CodecProfileLevel codecProfileLevel = codecProfileLevelArr[i2];
                arrayList.add(new DecoderProfileLevel(codecProfileLevel.profile, codecProfileLevel.level));
                i = i2 + 1;
            }
            this.profileLevels = (DecoderProfileLevel[]) arrayList.toArray(new DecoderProfileLevel[arrayList.size()]);
        }
        if (codecCapabilities == null || codecCapabilities.colorFormats == null || codecCapabilities.colorFormats.length <= 0) {
            this.colorFormats = new int[0];
        } else {
            this.colorFormats = Arrays.copyOf(codecCapabilities.colorFormats, codecCapabilities.colorFormats.length);
        }
        this.maxSupportedInstances = getMaxSupportedInstances(codecCapabilities);
        if (Build.VERSION.SDK_INT >= 21) {
            if (!str.contains("video") || codecCapabilities == null) {
                if (!str.contains("audio") || codecCapabilities == null || (audioCapabilities = codecCapabilities.getAudioCapabilities()) == null) {
                    return;
                }
                this.maxSampleRate = getMaxSampleRate(audioCapabilities);
                this.maxBitRate = getMaxBitRate(audioCapabilities);
                this.maxChannels = getMaxChannels(audioCapabilities);
                return;
            }
            MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
            if (videoCapabilities != null) {
                this.maxWidth = getMaxWidth(videoCapabilities);
                this.maxHeight = getMaxHeight(videoCapabilities);
                this.maxLumaFrameRate = getMaxSupportedFrameRate(videoCapabilities);
                this.maxFrameRate = videoCapabilities.getSupportedFrameRates().getUpper().intValue();
            }
        }
    }

    private int getMaxBitRate(MediaCodecInfo.AudioCapabilities audioCapabilities) {
        return (audioCapabilities != null ? audioCapabilities.getBitrateRange() : new Range<>(8000, Integer.valueOf((int) DEFAULT_MAX_BITRATE))).getUpper().intValue();
    }

    private int getMaxChannels(MediaCodecInfo.AudioCapabilities audioCapabilities) {
        if (audioCapabilities != null) {
            return audioCapabilities.getMaxInputChannelCount();
        }
        return 2;
    }

    private int getMaxHeight(MediaCodecInfo.VideoCapabilities videoCapabilities) {
        return (videoCapabilities != null ? videoCapabilities.getSupportedHeights() : new Range<>(0, 720)).getUpper().intValue();
    }

    private int getMaxSampleRate(MediaCodecInfo.AudioCapabilities audioCapabilities) {
        Range<Integer>[] supportedSampleRateRanges = audioCapabilities != null ? audioCapabilities.getSupportedSampleRateRanges() : null;
        if (supportedSampleRateRanges == null || supportedSampleRateRanges.length <= 0) {
            return 48000;
        }
        return supportedSampleRateRanges[supportedSampleRateRanges.length - 1].getUpper().intValue();
    }

    private final int getMaxSupportedFrameRate(MediaCodecInfo.VideoCapabilities videoCapabilities) {
        if (videoCapabilities == null) {
            return 30;
        }
        this.maxLumaWidth = videoCapabilities.getSupportedWidthsFor(this.maxHeight).getUpper().intValue();
        int intValue = videoCapabilities.getSupportedHeightsFor(this.maxWidth).getUpper().intValue();
        this.maxLumaHeight = intValue;
        return videoCapabilities.getSupportedFrameRatesFor(this.maxWidth, intValue).getUpper().intValue();
    }

    private int getMaxSupportedInstances(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        if (codecCapabilities == null || Build.VERSION.SDK_INT < 23) {
            return 1;
        }
        return codecCapabilities.getMaxSupportedInstances();
    }

    private int getMaxWidth(MediaCodecInfo.VideoCapabilities videoCapabilities) {
        return (videoCapabilities != null ? videoCapabilities.getSupportedWidths() : new Range<>(0, 1280)).getUpper().intValue();
    }

    private boolean isAdaptive(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return Build.VERSION.SDK_INT >= 19 && codecCapabilities.isFeatureSupported(MediaCodecInfo.CodecCapabilities.FEATURE_AdaptivePlayback);
    }

    private boolean isAudioSoftwareOnly(String str) {
        String lowerCase = str == null ? "" : str.toLowerCase();
        return lowerCase.startsWith("omx.google.") || lowerCase.startsWith("c2.android.") || lowerCase.startsWith("c2.google.");
    }

    private boolean isSecure(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return Build.VERSION.SDK_INT >= 21 && codecCapabilities.isFeatureSupported(MediaCodecInfo.CodecCapabilities.FEATURE_SecurePlayback);
    }

    private boolean isTunneling(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return Build.VERSION.SDK_INT >= 21 && codecCapabilities.isFeatureSupported(MediaCodecInfo.CodecCapabilities.FEATURE_TunneledPlayback);
    }

    private boolean isVideoSoftwareOnly(String str) {
        String lowerCase = str == null ? "" : str.toLowerCase();
        if (lowerCase.startsWith("omx.google.") || lowerCase.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((lowerCase.startsWith("omx.sec.") && lowerCase.contains(".sw.")) || lowerCase.equals("omx.qcom.video.decoder.hevcswvdec")) {
            return true;
        }
        return (lowerCase.startsWith("omx.qti.video.decoder") && lowerCase.contains("sw")) || lowerCase.startsWith("c2.android.") || lowerCase.startsWith("c2.google.");
    }

    private void reset() {
        this.decName = "";
        this.decMimeType = "";
        this.softwareVideoDec = false;
        this.softwareVideoDec = false;
        this.adaptiveDec = false;
        this.tunnelingDec = false;
        this.secureDec = false;
        this.profileLevels = null;
        this.colorFormats = null;
        this.maxSupportedInstances = 0;
        this.maxLumaFrameRate = 30;
        this.maxFrameRate = 30;
        this.maxWidth = 1280;
        this.maxHeight = 720;
        this.maxLumaWidth = 1280;
        this.maxLumaHeight = 720;
        this.maxSampleRate = 48000;
        this.maxBitRate = DEFAULT_MAX_BITRATE;
        this.maxChannels = 2;
    }

    public final int[] getColorFormats() {
        return this.colorFormats;
    }

    public final int getDecoderLumaHeight() {
        return this.maxLumaHeight;
    }

    public final int getDecoderLumaWidth() {
        return this.maxLumaWidth;
    }

    public final int getDecoderMaxFrameRate() {
        return this.maxFrameRate;
    }

    public final int getDecoderMaxFrameRateForMaxLuma() {
        return this.maxLumaFrameRate;
    }

    public final int getDecoderMaxHeight() {
        return this.maxHeight;
    }

    public final int getDecoderMaxWidth() {
        return this.maxWidth;
    }

    public final String getDecoderMimeType() {
        return this.decMimeType;
    }

    public final String getDecoderName() {
        return this.decName;
    }

    public final int getMaxAudioBitRate() {
        return this.maxBitRate;
    }

    public final int getMaxAudioChannels() {
        return this.maxChannels;
    }

    public final int getMaxAudioSampleRate() {
        return this.maxSampleRate;
    }

    public final DecoderProfileLevel getMaxProfileLevel() {
        int i = 0;
        DecoderProfileLevel decoderProfileLevel = new DecoderProfileLevel(0, 0);
        DecoderProfileLevel[] decoderProfileLevelArr = this.profileLevels;
        int length = decoderProfileLevelArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= length) {
                return decoderProfileLevel;
            }
            DecoderProfileLevel decoderProfileLevel2 = decoderProfileLevelArr[i];
            int i4 = i3;
            if (decoderProfileLevel2.level >= i3) {
                i4 = decoderProfileLevel2.level;
                decoderProfileLevel = decoderProfileLevel2;
            }
            i++;
            i2 = i4;
        }
    }

    public final int getMaxSupportedInstances() {
        return this.maxSupportedInstances;
    }

    public final DecoderProfileLevel[] getProfileLevels() {
        return this.profileLevels;
    }

    public final boolean isAudio() {
        String str = this.decMimeType;
        if (str == null) {
            return false;
        }
        return str.startsWith("audio/");
    }

    public final boolean isAudioSofwareDecoder() {
        return this.softwareAudioDec;
    }

    public final boolean isSecureDecoder() {
        return this.secureDec;
    }

    public final boolean isValidDecoder() {
        if (isVideo()) {
            return !this.softwareVideoDec || mVideoSoftwareDecoderWhiteList.contains(this.decName);
        } else if (isAudio()) {
            return this.softwareAudioDec || mAudioDecoderWhiteList.contains(this.decName);
        } else {
            return false;
        }
    }

    public final boolean isVideo() {
        String str = this.decMimeType;
        if (str == null) {
            return false;
        }
        return str.startsWith("video/");
    }

    public final boolean isVideoSofwareDecoder() {
        return this.softwareVideoDec;
    }
}

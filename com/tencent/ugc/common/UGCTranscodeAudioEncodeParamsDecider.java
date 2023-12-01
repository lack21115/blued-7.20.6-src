package com.tencent.ugc.common;

import android.media.MediaFormat;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.utils.c;
import com.tencent.ugc.AudioEncodeParams;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/common/UGCTranscodeAudioEncodeParamsDecider.class */
public class UGCTranscodeAudioEncodeParamsDecider {
    private static final int DEFAULT_BITRATE = 98304;
    private static final int DEFAULT_BIT_PER_CHANNEL = 16;
    private static final int DEFAULT_CHANNEL_COUNT = 1;
    private static final int DEFAULT_SAMPLE_RATE = 48000;
    private static final String TAG = "UGCTranscodeAudioEncodeParamsDecider";
    private List<MediaFormat> mAudioMediaFormatList;
    private MediaFormat mBGMMediaFormat;
    private int mEncodeBitrate = 0;

    private int getDecidedBitRate() {
        int i = this.mEncodeBitrate;
        if (i != 0) {
            return i;
        }
        if (this.mBGMMediaFormat == null) {
            int maxAudioBitRate = getMaxAudioBitRate(this.mAudioMediaFormatList);
            return maxAudioBitRate != -1 ? maxAudioBitRate : DEFAULT_BITRATE;
        } else if (c.a(this.mAudioMediaFormatList)) {
            return getIntValueFromFormat(this.mBGMMediaFormat, MediaFormat.KEY_BIT_RATE, DEFAULT_BITRATE);
        } else {
            ArrayList arrayList = new ArrayList(this.mAudioMediaFormatList);
            arrayList.add(this.mBGMMediaFormat);
            int maxAudioBitRate2 = getMaxAudioBitRate(arrayList);
            return maxAudioBitRate2 != -1 ? maxAudioBitRate2 : DEFAULT_BITRATE;
        }
    }

    private int getDecidedChannels() {
        MediaFormat firstValidMediaFormat = !c.a(this.mAudioMediaFormatList) ? getFirstValidMediaFormat() : null;
        MediaFormat mediaFormat = this.mBGMMediaFormat;
        return mediaFormat == null ? getIntValueFromFormat(firstValidMediaFormat, MediaFormat.KEY_CHANNEL_COUNT, 1) : firstValidMediaFormat == null ? getIntValueFromFormat(mediaFormat, MediaFormat.KEY_CHANNEL_COUNT, 1) : Math.max(getIntValueFromFormat(firstValidMediaFormat, MediaFormat.KEY_CHANNEL_COUNT, 1), getIntValueFromFormat(this.mBGMMediaFormat, MediaFormat.KEY_CHANNEL_COUNT, 1));
    }

    private int getDecidedSampleRate() {
        MediaFormat mediaFormat = this.mBGMMediaFormat;
        if (mediaFormat == null) {
            MediaFormat mediaFormat2 = null;
            if (!c.a(this.mAudioMediaFormatList)) {
                mediaFormat2 = getFirstValidMediaFormat();
            }
            return getIntValueFromFormat(mediaFormat2, MediaFormat.KEY_SAMPLE_RATE, 48000);
        }
        return getIntValueFromFormat(mediaFormat, MediaFormat.KEY_SAMPLE_RATE, 48000);
    }

    private MediaFormat getFirstValidMediaFormat() {
        for (MediaFormat mediaFormat : this.mAudioMediaFormatList) {
            if (mediaFormat != null) {
                return mediaFormat;
            }
        }
        return null;
    }

    private int getIntValueFromFormat(MediaFormat mediaFormat, String str, int i) {
        if (mediaFormat == null) {
            return i;
        }
        try {
            return mediaFormat.getInteger(str);
        } catch (Exception e) {
            LiteavLog.w(TAG, String.valueOf(e));
            return i;
        }
    }

    private int getMaxAudioBitRate(List<MediaFormat> list) {
        int i = -1;
        if (list == null) {
            return -1;
        }
        for (MediaFormat mediaFormat : list) {
            if (mediaFormat.containsKey(MediaFormat.KEY_BIT_RATE)) {
                i = Math.max(i, mediaFormat.getInteger(MediaFormat.KEY_BIT_RATE));
            }
        }
        return i;
    }

    public AudioEncodeParams getDecidedEncodeParams() {
        AudioEncodeParams audioEncodeParams = new AudioEncodeParams();
        audioEncodeParams.setSampleRate(getDecidedSampleRate());
        audioEncodeParams.setChannels(getDecidedChannels());
        audioEncodeParams.setBitsPerChannel(16);
        audioEncodeParams.setBitrate(getDecidedBitRate());
        return audioEncodeParams;
    }

    public void setBGMMediaFormat(MediaFormat mediaFormat) {
        this.mBGMMediaFormat = mediaFormat;
    }

    public void setEncodeBitrate(int i) {
        if (this.mEncodeBitrate == i) {
            return;
        }
        LiteavLog.i(TAG, "setAudioBitrate ".concat(String.valueOf(i)));
        this.mEncodeBitrate = i;
    }

    public void setInputAudioMediaFormat(List<MediaFormat> list) {
        this.mAudioMediaFormatList = list;
    }
}

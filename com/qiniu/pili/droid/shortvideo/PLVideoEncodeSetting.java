package com.qiniu.pili.droid.shortvideo;

import android.bluetooth.BluetoothClass;
import android.content.Context;
import com.blued.das.live.LiveProtos;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.g;
import com.qiniu.pili.droid.shortvideo.f.j;
import com.tencent.ugc.UGCTransitionRules;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLVideoEncodeSetting.class */
public class PLVideoEncodeSetting {
    private static final String BITRATE_MODE = "bitrateMode";
    private static final String ENCODING_BITRATE = "encodingBitrate";
    private static final String ENCODING_FPS = "encodingFps";
    private static final String ENCODING_SIZE_LEVEL = "encodingSizeLevel";
    private static final String IS_HW_CODEC_ENABLED = "isHWCodecEnabled";
    private static final String I_FRAME_INTERVAL = "iFrameInterval";
    private static final String PREFERRED_ENCODING_HEIGHT = "preferredEncodingHeight";
    private static final String PREFERRED_ENCODING_WIDTH = "preferredEncodingWidth";
    public static final String TAG = "PLVideoEncodeSetting";
    private static final int[][] VIDEO_ENCODING_SIZE_ARRAY = {new int[]{240, 240}, new int[]{320, 240}, new int[]{352, 352}, new int[]{640, 352}, new int[]{360, 360}, new int[]{480, 360}, new int[]{640, 360}, new int[]{480, 480}, new int[]{640, 480}, new int[]{848, 480}, new int[]{LiveProtos.Event.LIVE_GIFT_EFFECT_BTN_CLICK_VALUE, LiveProtos.Event.LIVE_GIFT_EFFECT_BTN_CLICK_VALUE}, new int[]{UGCTransitionRules.DEFAULT_IMAGE_WIDTH, LiveProtos.Event.LIVE_GIFT_EFFECT_BTN_CLICK_VALUE}, new int[]{UGCTransitionRules.DEFAULT_IMAGE_WIDTH, UGCTransitionRules.DEFAULT_IMAGE_WIDTH}, new int[]{960, UGCTransitionRules.DEFAULT_IMAGE_WIDTH}, new int[]{1280, UGCTransitionRules.DEFAULT_IMAGE_WIDTH}, new int[]{BluetoothClass.Device.AUDIO_VIDEO_VIDEO_CONFERENCING, BluetoothClass.Device.AUDIO_VIDEO_VIDEO_CONFERENCING}, new int[]{1440, BluetoothClass.Device.AUDIO_VIDEO_VIDEO_CONFERENCING}};
    private Context mContext;
    private int mRotationInMetadata;
    private int mPreferredEncodingWidth = 0;
    private int mPreferredEncodingHeight = 0;
    private int mEncodingFps = 30;
    private int mEncodingBitrateInBps = 1000000;
    private int mIFrameInterval = 30;
    private BitrateMode mBitrateMode = BitrateMode.QUALITY_PRIORITY;
    private ProfileMode mProfileMode = ProfileMode.BASELINE;
    private VIDEO_ENCODING_SIZE_LEVEL mEncodingSizeLevel = VIDEO_ENCODING_SIZE_LEVEL.VIDEO_ENCODING_SIZE_LEVEL_480P_1;
    private boolean mIsHWCodecEnabled = true;
    private boolean mIsConstFrameRateEnabled = false;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLVideoEncodeSetting$BitrateMode.class */
    public enum BitrateMode {
        QUALITY_PRIORITY,
        BITRATE_PRIORITY,
        CONSTANT_QUALITY_PRIORITY
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLVideoEncodeSetting$ProfileMode.class */
    public enum ProfileMode {
        BASELINE,
        MAIN,
        HIGH
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLVideoEncodeSetting$VIDEO_ENCODING_SIZE_LEVEL.class */
    public enum VIDEO_ENCODING_SIZE_LEVEL {
        VIDEO_ENCODING_SIZE_LEVEL_240P_1,
        VIDEO_ENCODING_SIZE_LEVEL_240P_2,
        VIDEO_ENCODING_SIZE_LEVEL_352P_1,
        VIDEO_ENCODING_SIZE_LEVEL_352P_2,
        VIDEO_ENCODING_SIZE_LEVEL_360P_1,
        VIDEO_ENCODING_SIZE_LEVEL_360P_2,
        VIDEO_ENCODING_SIZE_LEVEL_360P_3,
        VIDEO_ENCODING_SIZE_LEVEL_480P_1,
        VIDEO_ENCODING_SIZE_LEVEL_480P_2,
        VIDEO_ENCODING_SIZE_LEVEL_480P_3,
        VIDEO_ENCODING_SIZE_LEVEL_544P_1,
        VIDEO_ENCODING_SIZE_LEVEL_544P_2,
        VIDEO_ENCODING_SIZE_LEVEL_720P_1,
        VIDEO_ENCODING_SIZE_LEVEL_720P_2,
        VIDEO_ENCODING_SIZE_LEVEL_720P_3,
        VIDEO_ENCODING_SIZE_LEVEL_1088P_1,
        VIDEO_ENCODING_SIZE_LEVEL_1088P_2
    }

    public PLVideoEncodeSetting(Context context) {
        this.mContext = context;
    }

    public static PLVideoEncodeSetting fromJSON(Context context, JSONObject jSONObject) {
        PLVideoEncodeSetting pLVideoEncodeSetting = new PLVideoEncodeSetting(context);
        pLVideoEncodeSetting.setPreferredEncodingSize(jSONObject.optInt(PREFERRED_ENCODING_WIDTH, 0), jSONObject.optInt(PREFERRED_ENCODING_HEIGHT, 0));
        pLVideoEncodeSetting.setEncodingFps(jSONObject.optInt(ENCODING_FPS, 30));
        pLVideoEncodeSetting.setEncodingBitrate(jSONObject.optInt(ENCODING_BITRATE, 1000000));
        pLVideoEncodeSetting.setIFrameInterval(jSONObject.optInt(I_FRAME_INTERVAL, 30));
        pLVideoEncodeSetting.setEncodingBitrateMode(BitrateMode.valueOf(jSONObject.optString(BITRATE_MODE, BitrateMode.QUALITY_PRIORITY.name())));
        pLVideoEncodeSetting.setEncodingSizeLevel(VIDEO_ENCODING_SIZE_LEVEL.valueOf(jSONObject.optString(ENCODING_SIZE_LEVEL, VIDEO_ENCODING_SIZE_LEVEL.VIDEO_ENCODING_SIZE_LEVEL_480P_1.name())));
        pLVideoEncodeSetting.setHWCodecEnabled(jSONObject.optBoolean(IS_HW_CODEC_ENABLED, true));
        return pLVideoEncodeSetting;
    }

    public static PLVideoEncodeSetting fromSetting(PLVideoEncodeSetting pLVideoEncodeSetting) {
        PLVideoEncodeSetting pLVideoEncodeSetting2 = new PLVideoEncodeSetting(pLVideoEncodeSetting.mContext);
        pLVideoEncodeSetting2.setPreferredEncodingSize(pLVideoEncodeSetting.mPreferredEncodingWidth, pLVideoEncodeSetting.mPreferredEncodingHeight);
        pLVideoEncodeSetting2.setEncodingFps(pLVideoEncodeSetting.mEncodingFps);
        pLVideoEncodeSetting2.setEncodingBitrate(pLVideoEncodeSetting.mEncodingBitrateInBps);
        pLVideoEncodeSetting2.setIFrameInterval(pLVideoEncodeSetting.mIFrameInterval);
        pLVideoEncodeSetting2.setEncodingBitrateMode(pLVideoEncodeSetting.mBitrateMode);
        pLVideoEncodeSetting2.setEncodingSizeLevel(pLVideoEncodeSetting.mEncodingSizeLevel);
        pLVideoEncodeSetting2.setHWCodecEnabled(pLVideoEncodeSetting.mIsHWCodecEnabled);
        pLVideoEncodeSetting2.setConstFrameRateEnabled(pLVideoEncodeSetting.mIsConstFrameRateEnabled);
        pLVideoEncodeSetting2.setRotationInMetadata(pLVideoEncodeSetting.mRotationInMetadata);
        pLVideoEncodeSetting2.setProfileMode(pLVideoEncodeSetting.mProfileMode);
        return pLVideoEncodeSetting2;
    }

    public boolean IsConstFrameRateEnabled() {
        return this.mIsConstFrameRateEnabled;
    }

    public BitrateMode getBitrateMode() {
        return this.mBitrateMode;
    }

    public int getEncodingBitrate() {
        return this.mEncodingBitrateInBps;
    }

    public int getIFrameInterval() {
        return this.mIFrameInterval;
    }

    public ProfileMode getProfileMode() {
        return this.mProfileMode;
    }

    public int getRotationInMetadata() {
        return this.mRotationInMetadata;
    }

    public int getVideoEncodingFps() {
        return this.mEncodingFps;
    }

    public int getVideoEncodingHeight() {
        int i = this.mPreferredEncodingHeight;
        return i != 0 ? i : this.mContext.getResources().getConfiguration().orientation == 1 ? VIDEO_ENCODING_SIZE_ARRAY[this.mEncodingSizeLevel.ordinal()][0] : VIDEO_ENCODING_SIZE_ARRAY[this.mEncodingSizeLevel.ordinal()][1];
    }

    public int getVideoEncodingWidth() {
        int i = this.mPreferredEncodingWidth;
        return i != 0 ? i : this.mContext.getResources().getConfiguration().orientation == 1 ? VIDEO_ENCODING_SIZE_ARRAY[this.mEncodingSizeLevel.ordinal()][1] : VIDEO_ENCODING_SIZE_ARRAY[this.mEncodingSizeLevel.ordinal()][0];
    }

    public boolean isHWCodecEnabled() {
        return this.mIsHWCodecEnabled;
    }

    public PLVideoEncodeSetting setConstFrameRateEnabled(boolean z) {
        e eVar = e.h;
        eVar.c(TAG, "setConstFrameRateEnabled: " + z);
        this.mIsConstFrameRateEnabled = z;
        return this;
    }

    public PLVideoEncodeSetting setEncodingBitrate(int i) {
        e eVar = e.h;
        eVar.c(TAG, "setEncodingBitrate: " + i);
        this.mEncodingBitrateInBps = i;
        return this;
    }

    public PLVideoEncodeSetting setEncodingBitrateMode(BitrateMode bitrateMode) {
        e eVar = e.h;
        eVar.c(TAG, "setEncodingBitrateMode: " + bitrateMode);
        this.mBitrateMode = bitrateMode;
        return this;
    }

    public PLVideoEncodeSetting setEncodingFps(int i) {
        e eVar = e.h;
        eVar.c(TAG, "setEncodingFps: " + i);
        this.mEncodingFps = i;
        return this;
    }

    public PLVideoEncodeSetting setEncodingSizeLevel(VIDEO_ENCODING_SIZE_LEVEL video_encoding_size_level) {
        e eVar = e.h;
        eVar.c(TAG, "setEncodingSizeLevel: " + video_encoding_size_level);
        this.mEncodingSizeLevel = video_encoding_size_level;
        return this;
    }

    public PLVideoEncodeSetting setHWCodecEnabled(boolean z) {
        e eVar = e.h;
        eVar.c(TAG, "setHWCodecEnabled: " + z);
        this.mIsHWCodecEnabled = z;
        return this;
    }

    public PLVideoEncodeSetting setIFrameInterval(int i) {
        e eVar = e.h;
        eVar.c(TAG, "setIFrameInterval: " + i);
        this.mIFrameInterval = i;
        return this;
    }

    public PLVideoEncodeSetting setPreferredEncodingSize(int i, int i2) {
        int b = g.b(i);
        int b2 = g.b(i2);
        e eVar = e.h;
        eVar.c(TAG, "setPreferredEncodingSize: " + b + "x" + b2);
        this.mPreferredEncodingWidth = b;
        this.mPreferredEncodingHeight = b2;
        return this;
    }

    public PLVideoEncodeSetting setProfileMode(ProfileMode profileMode) {
        e eVar = e.h;
        eVar.c(TAG, "setProfileMode: " + profileMode);
        this.mProfileMode = profileMode;
        return this;
    }

    public PLVideoEncodeSetting setRotationInMetadata(int i) {
        e eVar = e.h;
        eVar.c(TAG, "setRotationInMetadata: " + i);
        this.mRotationInMetadata = j.b(i);
        return this;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PREFERRED_ENCODING_WIDTH, this.mPreferredEncodingWidth);
            jSONObject.put(PREFERRED_ENCODING_HEIGHT, this.mPreferredEncodingHeight);
            jSONObject.put(ENCODING_FPS, this.mEncodingFps);
            jSONObject.put(ENCODING_BITRATE, this.mEncodingBitrateInBps);
            jSONObject.put(I_FRAME_INTERVAL, this.mIFrameInterval);
            jSONObject.put(BITRATE_MODE, this.mBitrateMode.name());
            jSONObject.put(ENCODING_SIZE_LEVEL, this.mEncodingSizeLevel.name());
            jSONObject.put(IS_HW_CODEC_ENABLED, this.mIsHWCodecEnabled);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}

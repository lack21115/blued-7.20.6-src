package com.tencent.thumbplayer.api;

import android.media.AudioAttributes;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPAudioAttributes.class */
public class TPAudioAttributes {
    @TPNativeKeyMap.MapTPAudioAttributeContentType(3)
    public static final int TP_CONTENT_MOVIE = 3;
    @TPNativeKeyMap.MapTPAudioAttributeContentType(2)
    public static final int TP_CONTENT_MUSIC = 2;
    @TPNativeKeyMap.MapTPAudioAttributeContentType(4)
    public static final int TP_CONTENT_SONIFICATION = 4;
    @TPNativeKeyMap.MapTPAudioAttributeContentType(1)
    public static final int TP_CONTENT_SPEECH = 1;
    @TPNativeKeyMap.MapTPAudioAttributeContentType(0)
    public static final int TP_CONTENT_UNKNOWN = 0;
    @TPNativeKeyMap.MapTPAudioAttributeFlag(1)
    public static final int TP_FLAG_AUDIBILITY_ENFORCED = 1;
    @TPNativeKeyMap.MapTPAudioAttributeFlag(16)
    public static final int TP_FLAG_HW_AV_SYNC = 16;
    @TPNativeKeyMap.MapTPAudioAttributeFlag(256)
    public static final int TP_FLAG_LOW_LATENCY = 256;
    private static final int TP_FLAG_PUBLIC = 273;
    @TPNativeKeyMap.MapTPAudioAttributeFlag(0)
    public static final int TP_FLAG_UNKNOWN = 0;
    @TPNativeKeyMap.MapTPAudioAttributeStreamType(4)
    public static final int TP_STREAM_ALARM = 4;
    @TPNativeKeyMap.MapTPAudioAttributeStreamType(8)
    public static final int TP_STREAM_DTMF = 8;
    @TPNativeKeyMap.MapTPAudioAttributeStreamType(3)
    public static final int TP_STREAM_MUSIC = 3;
    @TPNativeKeyMap.MapTPAudioAttributeStreamType(5)
    public static final int TP_STREAM_NOTIFICATION = 5;
    @TPNativeKeyMap.MapTPAudioAttributeStreamType(2)
    public static final int TP_STREAM_RING = 2;
    @TPNativeKeyMap.MapTPAudioAttributeStreamType(1)
    public static final int TP_STREAM_SYSTEM = 1;
    @TPNativeKeyMap.MapTPAudioAttributeStreamType(-1)
    public static final int TP_STREAM_UNKNOWN = -1;
    @TPNativeKeyMap.MapTPAudioAttributeStreamType(0)
    public static final int TP_STREAM_VOICE_CALL = 0;
    @TPNativeKeyMap.MapTPAudioAttributeUsage(4)
    public static final int TP_USAGE_ALARM = 4;
    @TPNativeKeyMap.MapTPAudioAttributeUsage(11)
    public static final int TP_USAGE_ASSISTANCE_ACCESSIBILITY = 11;
    @TPNativeKeyMap.MapTPAudioAttributeUsage(12)
    public static final int TP_USAGE_ASSISTANCE_NAVIGATION_GUIDANCE = 12;
    @TPNativeKeyMap.MapTPAudioAttributeUsage(13)
    public static final int TP_USAGE_ASSISTANCE_SONIFICATION = 13;
    @TPNativeKeyMap.MapTPAudioAttributeUsage(16)
    public static final int TP_USAGE_ASSISTANT = 16;
    @TPNativeKeyMap.MapTPAudioAttributeUsage(14)
    public static final int TP_USAGE_GAME = 14;
    @TPNativeKeyMap.MapTPAudioAttributeUsage(1)
    public static final int TP_USAGE_MEDIA = 1;
    @TPNativeKeyMap.MapTPAudioAttributeUsage(5)
    public static final int TP_USAGE_NOTIFICATION = 5;
    @TPNativeKeyMap.MapTPAudioAttributeUsage(9)
    public static final int TP_USAGE_NOTIFICATION_COMMUNICATION_DELAYED = 9;
    @TPNativeKeyMap.MapTPAudioAttributeUsage(8)
    public static final int TP_USAGE_NOTIFICATION_COMMUNICATION_INSTANT = 8;
    @TPNativeKeyMap.MapTPAudioAttributeUsage(7)
    public static final int TP_USAGE_NOTIFICATION_COMMUNICATION_REQUEST = 7;
    @TPNativeKeyMap.MapTPAudioAttributeUsage(10)
    public static final int TP_USAGE_NOTIFICATION_EVENT = 10;
    @TPNativeKeyMap.MapTPAudioAttributeUsage(6)
    public static final int TP_USAGE_NOTIFICATION_RINGTONE = 6;
    @TPNativeKeyMap.MapTPAudioAttributeUsage(0)
    public static final int TP_USAGE_UNKNOWN = 0;
    @TPNativeKeyMap.MapTPAudioAttributeUsage(2)
    public static final int TP_USAGE_VOICE_COMMUNICATION = 2;
    @TPNativeKeyMap.MapTPAudioAttributeUsage(3)
    public static final int TP_USAGE_VOICE_COMMUNICATION_SIGNALLING = 3;
    private static final HashMap<Integer, Integer> mMapContentTypeToAndroidMediaContentType;
    private static final HashMap<Integer, String> mMapContentTypeToString;
    private static final HashMap<Integer, Integer> mMapUsageToAndroidMediaStreamType;
    private static final HashMap<Integer, Integer> mMapUsageToAndroidMediaUsage;
    private static final HashMap<Integer, String> mMapUsageToString;
    private int mContentType;
    private int mFlags;
    private int mUsage;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPAudioAttributes$Builder.class */
    public static class Builder {
        private static final HashMap<Integer, Integer> mMapStreamTypeToContentType;
        private static final HashMap<Integer, Integer> mMapStreamTypeToUsage;
        private int mUsage = 0;
        private int mContentType = 0;
        private int mFlags = 0;

        static {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            mMapStreamTypeToContentType = hashMap;
            hashMap.put(-1, 0);
            mMapStreamTypeToContentType.put(0, 1);
            mMapStreamTypeToContentType.put(1, 4);
            mMapStreamTypeToContentType.put(2, 4);
            mMapStreamTypeToContentType.put(3, 2);
            mMapStreamTypeToContentType.put(4, 4);
            mMapStreamTypeToContentType.put(5, 4);
            mMapStreamTypeToContentType.put(8, 4);
            HashMap<Integer, Integer> hashMap2 = new HashMap<>();
            mMapStreamTypeToUsage = hashMap2;
            hashMap2.put(-1, 0);
            mMapStreamTypeToUsage.put(0, 2);
            mMapStreamTypeToUsage.put(1, 13);
            mMapStreamTypeToUsage.put(2, 6);
            mMapStreamTypeToUsage.put(3, 1);
            mMapStreamTypeToUsage.put(4, 4);
            mMapStreamTypeToUsage.put(5, 5);
            mMapStreamTypeToUsage.put(8, 3);
        }

        public Builder addFlags(int i) {
            this.mFlags = (i & 273) | this.mFlags;
            return this;
        }

        public TPAudioAttributes build() {
            TPAudioAttributes tPAudioAttributes = new TPAudioAttributes();
            tPAudioAttributes.mContentType = this.mContentType;
            tPAudioAttributes.mUsage = this.mUsage;
            tPAudioAttributes.mFlags = this.mFlags;
            return tPAudioAttributes;
        }

        public Builder setContentType(@TPAudioAttributeContentType int i) {
            if (!TPAudioAttributes.mMapContentTypeToString.containsKey(Integer.valueOf(i))) {
                i = 0;
            }
            this.mContentType = i;
            return this;
        }

        public Builder setFlag(int i) {
            this.mFlags = i & 273;
            return this;
        }

        public Builder setLegacyStreamType(@TPAudioAttributeStreamType int i) {
            if (mMapStreamTypeToContentType.containsKey(Integer.valueOf(i))) {
                this.mContentType = mMapStreamTypeToContentType.get(Integer.valueOf(i)).intValue();
            } else {
                this.mContentType = 0;
            }
            if (mMapStreamTypeToUsage.containsKey(Integer.valueOf(i))) {
                this.mUsage = mMapStreamTypeToUsage.get(Integer.valueOf(i)).intValue();
                return this;
            }
            this.mUsage = 0;
            return this;
        }

        public Builder setUsage(@TPAudioAttributeUsage int i) {
            if (!TPAudioAttributes.mMapUsageToString.containsKey(Integer.valueOf(i))) {
                i = 0;
            }
            this.mUsage = i;
            return this;
        }
    }

    @Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPAudioAttributes$TPAudioAttributeContentType.class */
    public @interface TPAudioAttributeContentType {
    }

    @Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPAudioAttributes$TPAudioAttributeFlag.class */
    public @interface TPAudioAttributeFlag {
    }

    @Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPAudioAttributes$TPAudioAttributeStreamType.class */
    public @interface TPAudioAttributeStreamType {
    }

    @Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPAudioAttributes$TPAudioAttributeUsage.class */
    public @interface TPAudioAttributeUsage {
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        mMapContentTypeToString = hashMap;
        hashMap.put(0, "TP_CONTENT_UNKNOWN");
        mMapContentTypeToString.put(1, "TP_CONTENT_SPEECH");
        mMapContentTypeToString.put(2, "TP_CONTENT_MUSIC");
        mMapContentTypeToString.put(3, "TP_CONTENT_MOVIE");
        mMapContentTypeToString.put(4, "TP_CONTENT_SONIFICATION");
        HashMap<Integer, Integer> hashMap2 = new HashMap<>();
        mMapContentTypeToAndroidMediaContentType = hashMap2;
        hashMap2.put(0, 0);
        mMapContentTypeToAndroidMediaContentType.put(1, 1);
        mMapContentTypeToAndroidMediaContentType.put(2, 2);
        mMapContentTypeToAndroidMediaContentType.put(3, 3);
        mMapContentTypeToAndroidMediaContentType.put(4, 4);
        HashMap<Integer, String> hashMap3 = new HashMap<>();
        mMapUsageToString = hashMap3;
        hashMap3.put(0, "TP_USAGE_UNKNOWN");
        mMapUsageToString.put(1, "TP_USAGE_MEDIA");
        mMapUsageToString.put(2, "TP_USAGE_VOICE_COMMUNICATION");
        mMapUsageToString.put(3, "TP_USAGE_VOICE_COMMUNICATION_SIGNALLING");
        mMapUsageToString.put(4, "TP_USAGE_ALARM");
        mMapUsageToString.put(5, "TP_USAGE_NOTIFICATION");
        mMapUsageToString.put(6, "TP_USAGE_NOTIFICATION_RINGTONE");
        mMapUsageToString.put(7, "TP_USAGE_NOTIFICATION_COMMUNICATION_REQUEST");
        mMapUsageToString.put(8, "TP_USAGE_NOTIFICATION_COMMUNICATION_INSTANT");
        mMapUsageToString.put(9, "TP_USAGE_NOTIFICATION_COMMUNICATION_DELAYED");
        mMapUsageToString.put(10, "TP_USAGE_NOTIFICATION_EVENT");
        mMapUsageToString.put(11, "TP_USAGE_ASSISTANCE_ACCESSIBILITY");
        mMapUsageToString.put(12, "TP_USAGE_ASSISTANCE_NAVIGATION_GUIDANCE");
        mMapUsageToString.put(13, "TP_USAGE_ASSISTANCE_SONIFICATION");
        mMapUsageToString.put(14, "TP_USAGE_GAME");
        mMapUsageToString.put(16, "TP_USAGE_ASSISTANT");
        HashMap<Integer, Integer> hashMap4 = new HashMap<>();
        mMapUsageToAndroidMediaUsage = hashMap4;
        hashMap4.put(0, 0);
        mMapUsageToAndroidMediaUsage.put(1, 1);
        mMapUsageToAndroidMediaUsage.put(2, 2);
        mMapUsageToAndroidMediaUsage.put(3, 3);
        mMapUsageToAndroidMediaUsage.put(4, 4);
        mMapUsageToAndroidMediaUsage.put(5, 5);
        mMapUsageToAndroidMediaUsage.put(6, 6);
        mMapUsageToAndroidMediaUsage.put(7, 7);
        mMapUsageToAndroidMediaUsage.put(8, 8);
        mMapUsageToAndroidMediaUsage.put(9, 9);
        mMapUsageToAndroidMediaUsage.put(10, 10);
        mMapUsageToAndroidMediaUsage.put(11, 11);
        mMapUsageToAndroidMediaUsage.put(12, 12);
        mMapUsageToAndroidMediaUsage.put(13, 13);
        mMapUsageToAndroidMediaUsage.put(14, 14);
        mMapUsageToAndroidMediaUsage.put(16, 16);
        HashMap<Integer, Integer> hashMap5 = new HashMap<>();
        mMapUsageToAndroidMediaStreamType = hashMap5;
        hashMap5.put(0, 3);
        mMapUsageToAndroidMediaStreamType.put(1, 3);
        mMapUsageToAndroidMediaStreamType.put(2, 0);
        mMapUsageToAndroidMediaStreamType.put(3, 8);
        mMapUsageToAndroidMediaStreamType.put(4, 4);
        mMapUsageToAndroidMediaStreamType.put(5, 5);
        mMapUsageToAndroidMediaStreamType.put(6, 2);
        mMapUsageToAndroidMediaStreamType.put(7, 5);
        mMapUsageToAndroidMediaStreamType.put(8, 5);
        mMapUsageToAndroidMediaStreamType.put(9, 5);
        mMapUsageToAndroidMediaStreamType.put(10, 5);
        mMapUsageToAndroidMediaStreamType.put(12, 3);
        mMapUsageToAndroidMediaStreamType.put(13, 1);
        mMapUsageToAndroidMediaStreamType.put(14, 3);
        mMapUsageToAndroidMediaStreamType.put(16, 3);
    }

    private TPAudioAttributes() {
        this.mUsage = 0;
        this.mContentType = 0;
        this.mFlags = 0;
    }

    private static int contentTypeToAndroidMediaContentType(@TPAudioAttributeContentType int i) {
        if (mMapContentTypeToAndroidMediaContentType.containsKey(Integer.valueOf(i))) {
            return mMapContentTypeToAndroidMediaContentType.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public static String contentTypeToString(@TPAudioAttributeContentType int i) {
        return mMapContentTypeToString.containsKey(Integer.valueOf(i)) ? mMapContentTypeToString.get(Integer.valueOf(i)) : "unknown content type".concat(String.valueOf(i));
    }

    private static int flagsToAndroidMediaFlags(int i) {
        int i2 = (i & 1) != 0 ? 1 : 0;
        int i3 = i2;
        if ((i & 16) != 0) {
            i3 = i2 | 16;
        }
        int i4 = i3;
        if ((i & 256) != 0) {
            i4 = i3 | 256;
        }
        return i4;
    }

    public static int usageToAndroidMediaStreamType(@TPAudioAttributeUsage int i) {
        if (mMapUsageToAndroidMediaStreamType.containsKey(Integer.valueOf(i))) {
            return mMapUsageToAndroidMediaStreamType.get(Integer.valueOf(i)).intValue();
        }
        return 3;
    }

    private static int usageToAndroidMediaUsage(@TPAudioAttributeUsage int i) {
        if (mMapUsageToAndroidMediaUsage.containsKey(Integer.valueOf(i))) {
            return mMapUsageToAndroidMediaUsage.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public static String usageToString(@TPAudioAttributeUsage int i) {
        return mMapUsageToString.containsKey(Integer.valueOf(i)) ? mMapUsageToString.get(Integer.valueOf(i)) : "unknown usage ".concat(String.valueOf(i));
    }

    @TPAudioAttributeContentType
    public int getContentType() {
        return this.mContentType;
    }

    public int getFlags() {
        return this.mFlags & 273;
    }

    @TPAudioAttributeUsage
    public int getUsage() {
        return this.mUsage;
    }

    public AudioAttributes toAndroidMediaAudioAttributes() {
        int usageToAndroidMediaUsage = usageToAndroidMediaUsage(this.mUsage);
        int contentTypeToAndroidMediaContentType = contentTypeToAndroidMediaContentType(this.mContentType);
        return new AudioAttributes.Builder().setContentType(contentTypeToAndroidMediaContentType).setUsage(usageToAndroidMediaUsage).setFlags(flagsToAndroidMediaFlags(this.mFlags)).build();
    }

    public String toString() {
        return "AudioAttributes: usage=" + usageToString(this.mUsage) + " content=" + contentTypeToString(this.mContentType) + " flags=0x" + Integer.toHexString(this.mFlags).toUpperCase();
    }
}

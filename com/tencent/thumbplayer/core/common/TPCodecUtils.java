package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.anythink.expressad.exoplayer.k.o;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tencent.thumbplayer.core.common.TPCodecCapability;
import com.tencent.thumbplayer.core.common.TPMediaDecoderInfo;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/common/TPCodecUtils.class */
public class TPCodecUtils {
    public static final int CAP_AUDIO_AAC = 8;
    public static final int CAP_AUDIO_DD = 16;
    public static final int CAP_AUDIO_DDP = 32;
    public static final int CAP_AUDIO_DTS = 128;
    public static final int CAP_AUDIO_FLAC = 64;
    public static final int CAP_VIDEO_AVC = 1;
    public static final int CAP_VIDEO_HEVC = 2;
    public static final int CAP_VIDEO_VP8 = 256;
    public static final int CAP_VIDEO_VP9 = 4;
    public static final int PLAYER_LEVEL_0 = 0;
    public static final int PLAYER_LEVEL_1 = 1;
    public static final int PLAYER_LEVEL_11 = 11;
    public static final int PLAYER_LEVEL_16 = 16;
    public static final int PLAYER_LEVEL_21 = 21;
    public static final int PLAYER_LEVEL_26 = 26;
    public static final int PLAYER_LEVEL_28 = 28;
    public static final int PLAYER_LEVEL_33 = 33;
    public static final int PLAYER_LEVEL_6 = 6;
    public static final int PLAYER_LEVEL_UNKNOWN = -1;
    private static final String TAG = "TPCodecUtils";
    private static final String VVC_SHD_HISI_CPU_NAME = "Kirin9000E";
    private static final String VVC_SHD_MTK_CPU_NAME = "MT6893";
    private static final String VVC_SHD_QUALCOMMN_CPU_NAME = "SM8250";
    private static final String VVC_SHD_SAMSUNG_CPU_NAME = "Exynos2100";
    private static int mAACMaxSupportedBitrate = 510000;
    private static int mAACMaxSupportedChannels = 8;
    private static int mAACMaxSupportedSamplerate = 96000;
    private static TPCodecCapability.TPCodecMaxCapability mAV1SWMaxCapability;
    private static TPCodecCapability.TPCodecMaxCapability mAVCSWMaxCapability;
    private static TPCodecCapability.TPCodecMaxCapability mAVS3WMaxCapability;
    private static int mAvs3DeviceLevel = -1;
    private static HashMap<String, Integer> mCodecCapBlackList;
    private static HashMap<String, Integer> mCodecCapWhiteList;
    private static Context mContext;
    private static int mDDPMaxSupportedBitrate = 6144000;
    private static int mDDPMaxSupportedChannels = 8;
    private static int mDDPMaxSupportedSamplerate = 48000;
    private static int mFLACMaxSupportedBitrate = 21000000;
    private static int mFLACMaxSupportedChannels = 8;
    private static int mFLACMaxSupportedSamplerate = 192000;
    private static TPCodecCapability.TPCodecMaxCapability mHEVCSWMaxCapability;
    private static int mHevcDeviceLevel = -1;
    private static boolean mIsFFmpegCapGot = false;
    private static LocalCache mLocalCache;
    private static HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> mMaxACodecHwCapabilityMap;
    private static HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> mMaxACodecSwCapabilityMap;
    private static HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> mMaxVCodecHwCapabilityMap;
    private static HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> mMaxVCodecSwCapabilityMap;
    private static TPCodecCapability.TPCodecMaxCapability mVP8SWMaxCapability;
    private static TPCodecCapability.TPCodecMaxCapability mVP9SWMaxCapability;
    private static TPCodecCapability.TPCodecMaxCapability mVVCSWMaxCapability;
    private static int mVvcDeviceLevel = -1;
    protected static ArrayList<String> mVMediaCodecCapList = new ArrayList<>();
    protected static ArrayList<String> mAMediaCodecCapList = new ArrayList<>();
    private static ArrayList<String> mVMediaCodecBlackListModel = new ArrayList<>();
    private static ArrayList<String> mAMediaCodecBlackListModel = new ArrayList<>();
    private static ArrayList<String> mAMediaCodecBlackListInstance = new ArrayList<>();
    private static ArrayList<String> mSupportedMediaCodec = new ArrayList<>();
    private static HashMap<Integer, HashMap<String, TPCodecCapability.TPHdrSupportVersionRange>> mHdrWhiteMap = new HashMap<>();
    private static HashMap<Integer, HashMap<String, TPCodecCapability.TPHdrSupportVersionRange>> mHdrBlackMap = new HashMap<>();
    private static HashMap<String, TPCodecCapability.TPHdrSupportVersionRange> mHDRVividSupportVersionMap = new HashMap<>();
    private static HashMap<Integer, ArrayList<TPCodecCapability.TPHdrSupportVersionRange>> mHDRTypeToHDRSoftwareCodecWhiteListMap = new HashMap<>();
    private static HashMap<Integer, ArrayList<TPCodecCapability.TPHdrSupportVersionRange>> mHDRTypeToHDRHardwareCodecWhiteListMap = new HashMap<>();
    private static HashMap<String, String> mAudioMaxCapCodecInstance = new HashMap<>();
    private static ArrayList<String> mWideVineBlackListModel = new ArrayList<>();
    private static HashMap<Integer, ArrayList<String>> mDrmL1BlackList = new HashMap<>();
    private static boolean mIsInitDone = false;
    private static boolean mPreferredSoftwareComponent = false;
    private static int mShdHevcQualcommIndex = 32;
    private static int mHdHevcQualcommIndex = 20;
    private static int mShdHevcMtkIndex = 12;
    private static int mHdHevcMtkIndex = 8;
    private static int mShdHevcHisiIndex = 8;
    private static int mHdHevcHisiIndex = 3;
    private static int mShdHevcSamsungIndex = 8;
    private static int mHdHevcSamsungIndex = 5;
    private static int mFhdAvs3QualcommIndex = 58;
    private static int mShdAvs3QualcommIndex = 55;
    private static int mFhdAvs3HisiIndex = 14;
    private static SparseArray<VideoSwCapabilityModel> mVideoCodecIdToSwCapabilityModel = new SparseArray<>();
    private static HashMap<DefinitionName, Integer> mDefinitionNameToDecodeLevelTable = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/common/TPCodecUtils$DefinitionName.class */
    public enum DefinitionName {
        DEFINITION_720P
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/common/TPCodecUtils$VideoSwCapabilityModel.class */
    public static class VideoSwCapabilityModel {
        SparseArray<HashMap<DefinitionName, String>> mCpuProducerToAllDefinitionDecTable;

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/common/TPCodecUtils$VideoSwCapabilityModel$Builder.class */
        static class Builder {
            private SparseArray<HashMap<DefinitionName, String>> mCpuProducerToAllDefinitionDecCapabilities = new SparseArray<>();

            Builder() {
            }

            Builder addVideoDecCap(int i, DefinitionName definitionName, String str) {
                HashMap<DefinitionName, String> hashMap = this.mCpuProducerToAllDefinitionDecCapabilities.get(i);
                HashMap<DefinitionName, String> hashMap2 = hashMap;
                if (hashMap == null) {
                    hashMap2 = new HashMap<>();
                    this.mCpuProducerToAllDefinitionDecCapabilities.put(i, hashMap2);
                }
                hashMap2.put(definitionName, str);
                return this;
            }

            VideoSwCapabilityModel build() {
                VideoSwCapabilityModel videoSwCapabilityModel = new VideoSwCapabilityModel();
                videoSwCapabilityModel.mCpuProducerToAllDefinitionDecTable = this.mCpuProducerToAllDefinitionDecCapabilities;
                return videoSwCapabilityModel;
            }
        }

        private VideoSwCapabilityModel() {
            this.mCpuProducerToAllDefinitionDecTable = new SparseArray<>();
        }
    }

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        mCodecCapWhiteList = hashMap;
        hashMap.put("NX511J", 11);
        mCodecCapWhiteList.put("Hi3798MV100", 11);
        mCodecCapWhiteList.put("长虹智能电视", 11);
        mCodecCapWhiteList.put("Android TV on Tcl 901", 11);
        mCodecCapWhiteList.put("xt880b", 11);
        TPNativeLog.printLog(2, TAG, "white list init");
        mSupportedMediaCodec.add("video/avc");
        mSupportedMediaCodec.add("video/hevc");
        mSupportedMediaCodec.add("video/x-vnd.on2.vp8");
        mSupportedMediaCodec.add("video/x-vnd.on2.vp9");
        mSupportedMediaCodec.add(TPDecoderType.TP_CODEC_MIMETYPE_AV1);
        mSupportedMediaCodec.add("audio/mp4a-latm");
        mSupportedMediaCodec.add("audio/ac3");
        mSupportedMediaCodec.add("audio/eac3");
        mSupportedMediaCodec.add(o.B);
        mSupportedMediaCodec.add("audio/flac");
        mSupportedMediaCodec.add(o.D);
        mAMediaCodecBlackListInstance.add("OMX.qti.audio.decoder.flac");
        mVMediaCodecBlackListModel.add("SM-J7008");
        mVMediaCodecBlackListModel.add("SM-J5008");
        mVMediaCodecBlackListModel.add("TCL i806");
        mVMediaCodecBlackListModel.add("NX511J");
        mVMediaCodecBlackListModel.add("vivo Y11i T");
        mVMediaCodecBlackListModel.add("长虹智能电视");
        mVMediaCodecBlackListModel.add("MI 1S");
        mVMediaCodecBlackListModel.add("SP9832A");
        mVMediaCodecBlackListModel.add("SP9830A");
        mVMediaCodecBlackListModel.add("VOTO GT17");
        mVMediaCodecBlackListModel.add("EVA-AL10");
        mHDRVividSupportVersionMap.put("TAS-AL00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
        mHDRVividSupportVersionMap.put("TAS-TL00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
        mHDRVividSupportVersionMap.put("TAS-AN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
        mHDRVividSupportVersionMap.put("LIO-AN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
        mHDRVividSupportVersionMap.put("LIO-AN00P", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
        mHDRVividSupportVersionMap.put("LIO-AN00m", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
        mHDRVividSupportVersionMap.put("LIO-TL00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
        mHDRVividSupportVersionMap.put("LIO-AL00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
        mHDRVividSupportVersionMap.put("ANA-AN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
        mHDRVividSupportVersionMap.put("ANA-TN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
        mHDRVividSupportVersionMap.put("ELS-AN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
        mHDRVividSupportVersionMap.put("ELS-TN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
        mHDRVividSupportVersionMap.put("ELS-AN10", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100166, 99, 3));
        mHDRVividSupportVersionMap.put("MRX-AL09", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100150, 99, 5));
        mHDRVividSupportVersionMap.put("MRX-AL19", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100150, 99, 5));
        mHDRVividSupportVersionMap.put("MRX-W09", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100150, 99, 5));
        mHDRVividSupportVersionMap.put("MRX-W19", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100150, 99, 5));
        mHDRVividSupportVersionMap.put("MRX-AN19", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100150, 99, 5));
        mHDRVividSupportVersionMap.put("MRX-W29", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100150, 99, 5));
        mHDRVividSupportVersionMap.put("MRX-W39", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100150, 99, 5));
        mHDRVividSupportVersionMap.put("OCE-AN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("OCE-AN10", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("OCE-AL50", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("OCE-AN50", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("NOH-NX9", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("NOH-AN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("NOH-AN01", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("NOH-AL00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("NOP-AN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("JAD-AN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("JAD-AN10", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("JAD-AL50", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("JAD-AL60", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("JAD-N29", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("JAD-N09", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("HEGE-550", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200187, 99, 0));
        mHDRVividSupportVersionMap.put("HEGE-550B", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200187, 99, 0));
        mHDRVividSupportVersionMap.put("HEGE-550C", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200187, 99, 0));
        mHDRVividSupportVersionMap.put("HEGE-550X", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200187, 99, 0));
        mHDRVividSupportVersionMap.put("HEGE-550AX", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200187, 99, 0));
        mHDRVividSupportVersionMap.put("HEGE-560", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200187, 99, 0));
        mHDRVividSupportVersionMap.put("HEGE-560B", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200187, 99, 0));
        mHDRVividSupportVersionMap.put("HEGE-570", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200187, 99, 0));
        mHDRVividSupportVersionMap.put("PLAT-760", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200172, 99, 0));
        mHDRVividSupportVersionMap.put("KANT-350", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200185, 99, 0));
        mHDRVividSupportVersionMap.put("KANT-350B", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200185, 99, 0));
        mHDRVividSupportVersionMap.put("KANT-350C", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200185, 99, 0));
        mHDRVividSupportVersionMap.put("KANT-350S", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200185, 99, 0));
        mHDRVividSupportVersionMap.put("KANT-360", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200185, 99, 0));
        mHDRVividSupportVersionMap.put("KANT-360S", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200185, 99, 0));
        mHDRVividSupportVersionMap.put("KANT-370", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200185, 99, 0));
        mHDRVividSupportVersionMap.put("KANT-370S", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200185, 99, 0));
        mHDRVividSupportVersionMap.put("KANT-359", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200183, 99, 0));
        mHDRVividSupportVersionMap.put("KANT-369", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200183, 99, 0));
        mHDRVividSupportVersionMap.put("THAL-550", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("THAL-560", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("THAL-570", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("THAL-580", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("FREG-770", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("DESC-220", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("DESC-250SY", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 10200557, 99, 0));
        mHDRVividSupportVersionMap.put("DESC-250S", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 10200557, 99, 0));
        mHDRVividSupportVersionMap.put("DESC-250SZ", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 10200557, 99, 0));
        mHDRVividSupportVersionMap.put("DESC-250", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 10200557, 99, 0));
        mHDRVividSupportVersionMap.put("DESC-260SY", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 10200557, 99, 0));
        mHDRVividSupportVersionMap.put("DESC-260S", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 10200557, 99, 0));
        mHDRVividSupportVersionMap.put("DESC-260SZ", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 10200557, 99, 0));
        mHDRVividSupportVersionMap.put("DESC-260", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 10200557, 99, 0));
        mHDRVividSupportVersionMap.put("DESC-270", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 10200547, 99, 0));
        mHDRVividSupportVersionMap.put("SOKR-790A", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("VOLT-350S", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mWideVineBlackListModel.add("RVL-AL09");
        mWideVineBlackListModel.add("CLT-L29");
        mWideVineBlackListModel.add("ASUS_Z00AD");
        mWideVineBlackListModel.add(TPSystemInfo.getDeviceName());
        mDrmL1BlackList.put(0, mWideVineBlackListModel);
        mVideoCodecIdToSwCapabilityModel.put(193, new VideoSwCapabilityModel.Builder().addVideoDecCap(0, DefinitionName.DEFINITION_720P, VVC_SHD_QUALCOMMN_CPU_NAME).addVideoDecCap(1, DefinitionName.DEFINITION_720P, VVC_SHD_MTK_CPU_NAME).addVideoDecCap(2, DefinitionName.DEFINITION_720P, VVC_SHD_HISI_CPU_NAME).addVideoDecCap(3, DefinitionName.DEFINITION_720P, VVC_SHD_SAMSUNG_CPU_NAME).build());
        mDefinitionNameToDecodeLevelTable.put(DefinitionName.DEFINITION_720P, 21);
        mIsFFmpegCapGot = false;
        mAVCSWMaxCapability = new TPCodecCapability.TPCodecMaxCapability(0, 0, 0, 30);
        mHEVCSWMaxCapability = new TPCodecCapability.TPCodecMaxCapability(0, 0, 0, 30);
        mVP9SWMaxCapability = new TPCodecCapability.TPCodecMaxCapability(0, 0, 0, 30);
        mAVS3WMaxCapability = new TPCodecCapability.TPCodecMaxCapability(0, 0, 0, 30);
        mAV1SWMaxCapability = new TPCodecCapability.TPCodecMaxCapability(0, 0, 0, 30);
        mVP8SWMaxCapability = new TPCodecCapability.TPCodecMaxCapability(0, 0, 0, 30);
        mVVCSWMaxCapability = new TPCodecCapability.TPCodecMaxCapability(0, 0, 0, 30);
        mMaxVCodecHwCapabilityMap = new HashMap<>();
        mMaxVCodecSwCapabilityMap = new HashMap<>();
        mMaxACodecHwCapabilityMap = new HashMap<>();
        mMaxACodecSwCapabilityMap = new HashMap<>();
    }

    public static boolean addDRMLevel1Blacklist(int i) {
        if (mDrmL1BlackList.containsKey(Integer.valueOf(i))) {
            ArrayList<String> arrayList = mDrmL1BlackList.get(Integer.valueOf(i));
            if (!arrayList.contains(TPSystemInfo.getDeviceName())) {
                arrayList.add(TPSystemInfo.getDeviceName());
            }
            mDrmL1BlackList.remove(Integer.valueOf(i));
            mDrmL1BlackList.put(Integer.valueOf(i), arrayList);
            return true;
        }
        return true;
    }

    public static boolean addHDRBlackList(int i, String str, TPCodecCapability.TPHdrSupportVersionRange tPHdrSupportVersionRange) {
        HashMap<String, TPCodecCapability.TPHdrSupportVersionRange> hashMap;
        if (tPHdrSupportVersionRange == null) {
            return false;
        }
        if (mHdrBlackMap.containsKey(Integer.valueOf(i))) {
            hashMap = mHdrBlackMap.get(Integer.valueOf(i));
            mHdrBlackMap.remove(Integer.valueOf(i));
            if (!hashMap.containsKey(str)) {
                hashMap.put(str, tPHdrSupportVersionRange);
            }
            hashMap.remove(str);
        } else {
            hashMap = new HashMap<>();
        }
        hashMap.put(str, tPHdrSupportVersionRange);
        mHdrBlackMap.put(Integer.valueOf(i), hashMap);
        return true;
    }

    private static void addHDRVersionRangeToWhiteList(int i, TPCodecCapability.TPHdrSupportVersionRange tPHdrSupportVersionRange, HashMap<Integer, ArrayList<TPCodecCapability.TPHdrSupportVersionRange>> hashMap) {
        ArrayList<TPCodecCapability.TPHdrSupportVersionRange> arrayList = hashMap.containsKey(Integer.valueOf(i)) ? hashMap.get(Integer.valueOf(i)) : new ArrayList<>();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= arrayList.size()) {
                arrayList.add(tPHdrSupportVersionRange);
                hashMap.put(Integer.valueOf(i), arrayList);
                return;
            } else if (isTheSameVersionRange(tPHdrSupportVersionRange, arrayList.get(i3))) {
                return;
            } else {
                i2 = i3 + 1;
            }
        }
    }

    public static boolean addHDRVideoDecoderTypeWhiteList(int i, int i2, TPCodecCapability.TPHdrSupportVersionRange tPHdrSupportVersionRange) {
        HashMap<Integer, ArrayList<TPCodecCapability.TPHdrSupportVersionRange>> hashMap;
        if (i2 == 101) {
            hashMap = mHDRTypeToHDRSoftwareCodecWhiteListMap;
        } else if (i2 != 102) {
            TPNativeLog.printLog(3, TAG, "addHDRVideoDecoderTypeWhiteList, decoder not support.");
            return false;
        } else {
            hashMap = mHDRTypeToHDRHardwareCodecWhiteListMap;
        }
        addHDRVersionRangeToWhiteList(i, tPHdrSupportVersionRange, hashMap);
        return true;
    }

    public static boolean addHDRWhiteList(int i, String str, TPCodecCapability.TPHdrSupportVersionRange tPHdrSupportVersionRange) {
        HashMap<String, TPCodecCapability.TPHdrSupportVersionRange> hashMap;
        if (tPHdrSupportVersionRange == null) {
            return false;
        }
        if (mHdrWhiteMap.containsKey(Integer.valueOf(i))) {
            hashMap = mHdrWhiteMap.get(Integer.valueOf(i));
            mHdrWhiteMap.remove(Integer.valueOf(i));
            if (!hashMap.containsKey(str)) {
                hashMap.put(str, tPHdrSupportVersionRange);
            }
            hashMap.remove(str);
        } else {
            hashMap = new HashMap<>();
        }
        hashMap.put(str, tPHdrSupportVersionRange);
        mHdrWhiteMap.put(Integer.valueOf(i), hashMap);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0092, code lost:
        r9 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:66:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0229  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean checkHDRVividSupportByVersion(java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 689
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.common.TPCodecUtils.checkHDRVividSupportByVersion(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    private static int convertDefinitionNameToDecodeLevel(DefinitionName definitionName) {
        Integer num = mDefinitionNameToDecodeLevelTable.get(definitionName);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public static int convertDolbyVisionToOmxLevel(int i) {
        int i2 = 1 << i;
        if (i2 <= 0 || i2 > 256) {
            TPNativeLog.printLog(2, TAG, "convertDolbyVisionToOmxLevel Unsupported level".concat(String.valueOf(i)));
            return i;
        }
        TPNativeLog.printLog(2, TAG, "convertDolbyVisionToOmxLevel dolbyVisionLevel:" + i + " omxLevel:" + i2);
        return i2;
    }

    public static int convertDolbyVisionToOmxProfile(int i) {
        int i2 = 1 << i;
        if (i <= 0 || i > 512) {
            TPNativeLog.printLog(2, TAG, "convertDolbyVisionToOmxProfile Unsupported profile".concat(String.valueOf(i)));
            return i;
        }
        TPNativeLog.printLog(2, TAG, "convertDolbyVisionToOmxProfile dolbyVisionProfile:" + i + " omxProfile:" + i2);
        return i2;
    }

    public static HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> getACodecSWMaxCapabilityMap() {
        synchronized (TPCodecUtils.class) {
            try {
                TPNativeLog.printLog(2, TAG, "getACodecSWMaxCapabilityMap func in");
                if (!mMaxACodecSwCapabilityMap.isEmpty()) {
                    return mMaxACodecSwCapabilityMap;
                }
                try {
                    TPCodecCapability.TPCodecMaxCapability tPCodecMaxCapability = new TPCodecCapability.TPCodecMaxCapability(0, 0, mAACMaxSupportedSamplerate, mAACMaxSupportedBitrate, mAACMaxSupportedChannels);
                    TPCodecCapability.TPCodecMaxCapability tPCodecMaxCapability2 = new TPCodecCapability.TPCodecMaxCapability(0, 0, mFLACMaxSupportedSamplerate, mFLACMaxSupportedBitrate, mFLACMaxSupportedChannels);
                    TPCodecCapability.TPCodecMaxCapability tPCodecMaxCapability3 = new TPCodecCapability.TPCodecMaxCapability(0, 0, mDDPMaxSupportedSamplerate, mDDPMaxSupportedBitrate, mDDPMaxSupportedChannels);
                    TPCodecCapability.TPCodecMaxCapability tPCodecMaxCapability4 = new TPCodecCapability.TPCodecMaxCapability(0, 0, mDDPMaxSupportedSamplerate, mDDPMaxSupportedBitrate, mDDPMaxSupportedChannels);
                    mMaxACodecSwCapabilityMap.put(5002, tPCodecMaxCapability);
                    mMaxACodecSwCapabilityMap.put(5012, tPCodecMaxCapability2);
                    mMaxACodecSwCapabilityMap.put(5003, tPCodecMaxCapability3);
                    mMaxACodecSwCapabilityMap.put(5040, tPCodecMaxCapability4);
                    TPNativeLog.printLog(2, "getACodecSWMaxCapabilityMap success.");
                    return mMaxACodecSwCapabilityMap;
                } catch (Exception e) {
                    TPNativeLog.printLog(4, TAG, "getACodecSWMaxCapabilityMap exception");
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> getAMediaCodecMaxCapabilityMap() {
        synchronized (TPCodecUtils.class) {
            try {
                TPNativeLog.printLog(2, TAG, "getAMediaCodecMaxCapabilityMap func in");
                if (!mMaxACodecHwCapabilityMap.isEmpty()) {
                    TPNativeLog.printLog(2, TAG, "return memory stored audio max cap map");
                    return mMaxACodecHwCapabilityMap;
                }
                try {
                    TPMediaDecoderInfo[] tPMediaDecoderInfos = TPMediaDecoderList.getTPMediaDecoderInfos(mLocalCache);
                    int length = tPMediaDecoderInfos.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            break;
                        }
                        TPMediaDecoderInfo tPMediaDecoderInfo = tPMediaDecoderInfos[i2];
                        String decoderMimeType = tPMediaDecoderInfo.getDecoderMimeType();
                        if (tPMediaDecoderInfo.isAudio() && isSupportedMediaCodec(decoderMimeType) && !isInMediaCodecBlackList(decoderMimeType) && !isAMediaCodecBlackListInstance(tPMediaDecoderInfo.getDecoderName())) {
                            TPNativeLog.printLog(2, TAG, "Audio MimeType: " + decoderMimeType + " codecName: " + tPMediaDecoderInfo.getDecoderName());
                            TPMediaDecoderInfo.DecoderProfileLevel maxProfileLevel = tPMediaDecoderInfo.getMaxProfileLevel();
                            TPCodecCapability.TPCodecMaxCapability tPCodecMaxCapability = new TPCodecCapability.TPCodecMaxCapability(maxProfileLevel.profile, maxProfileLevel.level, tPMediaDecoderInfo.getMaxAudioSampleRate(), tPMediaDecoderInfo.getMaxAudioBitRate(), tPMediaDecoderInfo.getMaxAudioChannels());
                            if (!mMaxACodecHwCapabilityMap.containsKey(Integer.valueOf(getSupportedCodecId(decoderMimeType)))) {
                                TPNativeLog.printLog(2, TAG, "audio codecName: " + tPMediaDecoderInfo.getDecoderName() + " maxSamplerate: " + tPMediaDecoderInfo.getMaxAudioSampleRate() + " maxChannels: " + tPMediaDecoderInfo.getMaxAudioChannels());
                                replace(Integer.valueOf(getSupportedCodecId(decoderMimeType)), tPCodecMaxCapability, mMaxACodecHwCapabilityMap);
                                replace(decoderMimeType, tPMediaDecoderInfo.getDecoderName(), mAudioMaxCapCodecInstance);
                                mAMediaCodecCapList.add(decoderMimeType);
                            } else if (tPMediaDecoderInfo.getMaxAudioSampleRate() > mMaxACodecHwCapabilityMap.get(Integer.valueOf(getSupportedCodecId(decoderMimeType))).maxSampleRate || TextUtils.equals(decoderMimeType, o.B)) {
                                TPNativeLog.printLog(2, TAG, "audio codecName: " + tPMediaDecoderInfo.getDecoderName() + " maxSamplerate: " + tPMediaDecoderInfo.getMaxAudioSampleRate() + " maxChannels: " + tPMediaDecoderInfo.getMaxAudioChannels());
                                replace(Integer.valueOf(getSupportedCodecId(decoderMimeType)), tPCodecMaxCapability, mMaxACodecHwCapabilityMap);
                                replace(decoderMimeType, tPMediaDecoderInfo.getDecoderName(), mAudioMaxCapCodecInstance);
                            }
                        }
                        i = i2 + 1;
                    }
                } catch (Exception e) {
                    TPNativeLog.printLog(4, TAG, "getAMediaCodecMaxCapabilityMap failed:" + e.getMessage());
                }
                return mMaxACodecHwCapabilityMap;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static int getAV1SWDecodeLevel() {
        return getDecodeLevelByCoresAndFreq();
    }

    public static boolean getAudioMediaCodecPassThroughCap(int i, int i2, int i3) {
        if (i != 5004) {
            return false;
        }
        int i4 = 1;
        if (i2 == 20) {
            i4 = 7;
        } else if (i2 == 50 || i2 == 60) {
            i4 = 8;
        }
        return TPAudioPassThroughPluginDetector.isAudioPassThroughSupport(i4, i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0097, code lost:
        if (r0 != 3) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a1, code lost:
        if (r0 >= com.tencent.thumbplayer.core.common.TPCodecUtils.mFhdAvs3HisiIndex) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getAvs3SWDecodeLevel() {
        /*
            java.lang.String r0 = com.tencent.thumbplayer.core.common.TPSystemInfo.getCpuHarewareName()
            r7 = r0
            r0 = r7
            int r0 = com.tencent.thumbplayer.core.common.TPSystemInfo.getCpuHWProducter(r0)
            r5 = r0
            r0 = r7
            int r0 = com.tencent.thumbplayer.core.common.TPSystemInfo.getCpuHWProductIndex(r0)
            r6 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            java.lang.String r2 = "[getAvs3SWDecodeLevel], mCpuHWProducter = "
            r1.<init>(r2)
            r8 = r0
            r0 = r8
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            java.lang.String r1 = ", getMaxCpuFreq() = "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            long r1 = com.tencent.thumbplayer.core.common.TPSystemInfo.getMaxCpuFreq()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            java.lang.String r1 = ", numCores = "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            int r1 = com.tencent.thumbplayer.core.common.TPSystemInfo.getNumCores()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            java.lang.String r1 = ", mCpuHWProductIdx="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            java.lang.String r1 = ", hardware="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = 2
            java.lang.String r1 = "TPCodecUtils"
            r2 = r8
            java.lang.String r2 = r2.toString()
            com.tencent.thumbplayer.core.common.TPNativeLog.printLog(r0, r1, r2)
            int r0 = com.tencent.thumbplayer.core.common.TPCodecUtils.mAvs3DeviceLevel
            r4 = r0
            r0 = -1
            r1 = r4
            if (r0 == r1) goto L7b
            r0 = r4
            return r0
        L7b:
            r0 = 0
            com.tencent.thumbplayer.core.common.TPCodecUtils.mAvs3DeviceLevel = r0
            r0 = -1
            r1 = r5
            if (r0 == r1) goto Lbe
            r0 = 26
            r4 = r0
            r0 = r5
            if (r0 == 0) goto La7
            r0 = r5
            r1 = 1
            if (r0 == r1) goto Lbe
            r0 = r5
            r1 = 2
            if (r0 == r1) goto L9d
            r0 = r5
            r1 = 3
            if (r0 == r1) goto Lbe
            goto Lc6
        L9d:
            r0 = r6
            int r1 = com.tencent.thumbplayer.core.common.TPCodecUtils.mFhdAvs3HisiIndex
            if (r0 < r1) goto Lbe
            goto Lae
        La7:
            r0 = r6
            int r1 = com.tencent.thumbplayer.core.common.TPCodecUtils.mFhdAvs3QualcommIndex
            if (r0 < r1) goto Lb1
        Lae:
            goto Lc2
        Lb1:
            r0 = r6
            int r1 = com.tencent.thumbplayer.core.common.TPCodecUtils.mShdAvs3QualcommIndex
            if (r0 < r1) goto Lbe
            r0 = 21
            r4 = r0
            goto Lc2
        Lbe:
            int r0 = getDecodeLevelByCoresAndFreq()
            r4 = r0
        Lc2:
            r0 = r4
            com.tencent.thumbplayer.core.common.TPCodecUtils.mAvs3DeviceLevel = r0
        Lc6:
            int r0 = com.tencent.thumbplayer.core.common.TPCodecUtils.mAvs3DeviceLevel
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.common.TPCodecUtils.getAvs3SWDecodeLevel():int");
    }

    private static int getDecodeLevelByCoresAndFreq() {
        if (TPSystemInfo.getNumCores() >= 8) {
            return TPSystemInfo.getMaxCpuFreq() / 1000 >= 1200 ? 21 : 16;
        } else if (TPSystemInfo.getNumCores() >= 6) {
            return TPSystemInfo.getMaxCpuFreq() / 1000 >= 1400 ? 21 : 16;
        } else if (TPSystemInfo.getNumCores() >= 4) {
            return TPSystemInfo.getMaxCpuFreq() / 1000 >= 1600 ? 21 : 16;
        } else {
            return 6;
        }
    }

    public static void getDecoderMaxCapabilityMapAsync() {
        synchronized (TPCodecUtils.class) {
            try {
                if (mIsInitDone) {
                    TPNativeLog.printLog(2, TAG, "decoder capability already init,return directly!");
                    return;
                }
                TPNativeLog.printLog(2, TAG, "decoder capability not init,acquire async with create thread!");
                Thread thread = new Thread(new Runnable() { // from class: com.tencent.thumbplayer.core.common.TPCodecUtils.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        TPCodecUtils.getVMediaCodecMaxCapabilityMap();
                        TPCodecUtils.getAMediaCodecMaxCapabilityMap();
                        TPCodecUtils.getVCodecSWMaxCapabilityMap();
                        TPCodecUtils.getACodecSWMaxCapabilityMap();
                        boolean unused = TPCodecUtils.mIsInitDone = true;
                        TPNativeLog.printLog(2, TPCodecUtils.TAG, "new thread getDecoderMaxCapabilityMap done");
                    }
                });
                thread.setName("TP_codec_init_thread");
                thread.start();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String getDecoderName(String str, boolean z) {
        if (str.contains("audio")) {
            if (TextUtils.equals(str, "audio/eac3") && mAudioMaxCapCodecInstance.containsKey(o.B)) {
                return mAudioMaxCapCodecInstance.get(o.B);
            }
            if (mAudioMaxCapCodecInstance.containsKey(str)) {
                return mAudioMaxCapCodecInstance.get(str);
            }
            return null;
        }
        ArrayList arrayList = new ArrayList();
        TPMediaDecoderInfo[] tPMediaDecoderInfos = TPMediaDecoderList.getTPMediaDecoderInfos(mLocalCache);
        int length = tPMediaDecoderInfos.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            TPMediaDecoderInfo tPMediaDecoderInfo = tPMediaDecoderInfos[i2];
            if (TextUtils.equals(str, tPMediaDecoderInfo.getDecoderMimeType()) && tPMediaDecoderInfo.isSecureDecoder() == z) {
                TPNativeLog.printLog(2, TAG, "getDecoderName:" + tPMediaDecoderInfo.getDecoderName());
                arrayList.add(tPMediaDecoderInfo);
            }
            i = i2 + 1;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            TPMediaDecoderInfo tPMediaDecoderInfo2 = (TPMediaDecoderInfo) it.next();
            if ((tPMediaDecoderInfo2.isVideo() && tPMediaDecoderInfo2.isVideoSofwareDecoder() == mPreferredSoftwareComponent) || (tPMediaDecoderInfo2.isAudio() && tPMediaDecoderInfo2.isAudioSofwareDecoder() == mPreferredSoftwareComponent)) {
                return tPMediaDecoderInfo2.getDecoderName();
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((TPMediaDecoderInfo) arrayList.get(0)).getDecoderName();
    }

    public static String getDisplayVersion() {
        if (TextUtils.equals(Build.BRAND, "HUAWEI")) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, "ro.build.display.id");
            } catch (Exception e) {
                TPNativeLog.printLog(4, TAG, "get huawei display version failed:" + e.getMessage());
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00d6, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getDolbyVisionDecoderName(java.lang.String r4, int r5, int r6, boolean r7) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.common.TPCodecUtils.getDolbyVisionDecoderName(java.lang.String, int, int, boolean):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00ab, code lost:
        if (r0 >= com.tencent.thumbplayer.core.common.TPCodecUtils.mHdHevcSamsungIndex) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00bf, code lost:
        if (r0 >= com.tencent.thumbplayer.core.common.TPCodecUtils.mHdHevcHisiIndex) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d3, code lost:
        if (r0 >= com.tencent.thumbplayer.core.common.TPCodecUtils.mHdHevcMtkIndex) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ec, code lost:
        if (r0 >= com.tencent.thumbplayer.core.common.TPCodecUtils.mHdHevcQualcommIndex) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getHevcSWDecodeLevel() {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.common.TPCodecUtils.getHevcSWDecodeLevel():int");
    }

    public static int getMaxLumaSample(String str, int i) {
        if (TextUtils.equals(str, "video/avc")) {
            return TPMediaCodecProfileLevel.getAVCMaxLumaSample(i);
        }
        if (TextUtils.equals(str, "video/hevc")) {
            return TPMediaCodecProfileLevel.getHEVCMaxLumaSample(i);
        }
        if (TextUtils.equals(str, "video/x-vnd.on2.vp8")) {
            return TPMediaCodecProfileLevel.getVP8MaxLumaSample(i);
        }
        if (TextUtils.equals(str, "video/x-vnd.on2.vp9")) {
            return TPMediaCodecProfileLevel.getVP9MaxLumaSample(i);
        }
        if (TextUtils.equals(str, TPDecoderType.TP_CODEC_MIMETYPE_AV1)) {
            return TPMediaCodecProfileLevel.getAV1MaxLumaSample(i);
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0072, code lost:
        r0 = r0.getDecoderMaxWidth();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007c, code lost:
        r0 = r0.getDecoderMaxHeight();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0086, code lost:
        r0 = r0.getDecoderLumaWidth();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0091, code lost:
        r0 = r0.getDecoderLumaHeight();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x009c, code lost:
        r0 = r0.getDecoderMaxFrameRateForMaxLuma();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a7, code lost:
        r0 = r0.getDecoderMaxFrameRate();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c1, code lost:
        if (isLimitMaxWidthOrMaxHeight(r0, r0, r0, r0, r11, r12) == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c7, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00da, code lost:
        r0 = java.lang.Integer.valueOf(java.lang.Math.min(r0, java.lang.Math.max(1, ((int) (((r0 * r0) * 1) / java.lang.Math.max((r11 * r12) * 1, 1L))) * r0)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00fd, code lost:
        r0 = new java.lang.StringBuilder("getSupportedFrameRatesFor max width:");
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x010d, code lost:
        r0.append(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0118, code lost:
        r0.append(" max height:");
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0125, code lost:
        r0.append(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0131, code lost:
        r0.append(" max framerate for max resolution:");
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x013e, code lost:
        r0.append(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x014a, code lost:
        r0.append(" current width:");
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0157, code lost:
        r0.append(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0162, code lost:
        r0.append(" height:");
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x016f, code lost:
        r0.append(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x017a, code lost:
        r0.append(" max support framerate:");
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0187, code lost:
        r0.append(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0191, code lost:
        r22 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0193, code lost:
        com.tencent.thumbplayer.core.common.TPNativeLog.printLog(2, com.tencent.thumbplayer.core.common.TPCodecUtils.TAG, r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01a0, code lost:
        r22 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getMaxSupportedFrameRatesFor(int r9, int r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 489
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.common.TPCodecUtils.getMaxSupportedFrameRatesFor(int, int, int, int):int");
    }

    private static int getSoftMaxSamples(int i) {
        if (i != 1) {
            if (i != 6) {
                if (i != 11) {
                    if (i != 16) {
                        if (i != 21) {
                            if (i != 26) {
                                if (i != 28) {
                                    return i != 33 ? 0 : 8847360;
                                }
                                return 8294400;
                            }
                            return 2073600;
                        }
                        return 921600;
                    }
                    return 480000;
                }
                return 407040;
            }
            return 307200;
        }
        return 129600;
    }

    private static int getSupportedCodecId(String str) {
        if (TextUtils.equals(str, "video/avc")) {
            return 26;
        }
        if (TextUtils.equals(str, "video/hevc")) {
            return 172;
        }
        if (TextUtils.equals(str, "video/x-vnd.on2.vp8")) {
            return 138;
        }
        if (TextUtils.equals(str, "video/x-vnd.on2.vp9")) {
            return 166;
        }
        if (TextUtils.equals(str, TPDecoderType.TP_CODEC_MIMETYPE_AV1)) {
            return 1029;
        }
        if (TextUtils.equals(str, "audio/mp4a-latm")) {
            return 5002;
        }
        if (TextUtils.equals(str, "audio/ac3")) {
            return 5003;
        }
        if (TextUtils.equals(str, "audio/eac3") || TextUtils.equals(str, o.B)) {
            return 5040;
        }
        if (TextUtils.equals(str, "audio/flac")) {
            return 5012;
        }
        return TextUtils.equals(str, o.D) ? 5004 : -1;
    }

    private static String getSupportedHWMimeType(int i) {
        return i != 26 ? i != 138 ? i != 166 ? i != 172 ? i != 1029 ? "" : TPDecoderType.TP_CODEC_MIMETYPE_AV1 : "video/hevc" : "video/x-vnd.on2.vp9" : "video/x-vnd.on2.vp8" : "video/avc";
    }

    public static String getSystemPatchVersion() {
        if (TextUtils.equals(Build.BRAND, "HUAWEI")) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, "hwouc.hwpatch.version");
            } catch (Exception e) {
                TPNativeLog.printLog(4, TAG, "get huawei system patch version failed:" + e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> getVCodecSWMaxCapabilityMap() {
        synchronized (TPCodecUtils.class) {
            try {
                TPNativeLog.printLog(2, TAG, "getVCodecSWMaxCapabilityMap func in");
                if (mIsFFmpegCapGot) {
                    return mMaxVCodecSwCapabilityMap;
                }
                try {
                    int hevcSWDecodeLevel = getHevcSWDecodeLevel();
                    int softMaxSamples = getSoftMaxSamples(hevcSWDecodeLevel);
                    int avs3SWDecodeLevel = getAvs3SWDecodeLevel();
                    int aV1SWDecodeLevel = getAV1SWDecodeLevel();
                    int vvcSWDecodeLevel = getVvcSWDecodeLevel();
                    int softMaxSamples2 = getSoftMaxSamples(avs3SWDecodeLevel);
                    int softMaxSamples3 = getSoftMaxSamples(aV1SWDecodeLevel);
                    int softMaxSamples4 = getSoftMaxSamples(vvcSWDecodeLevel);
                    TPNativeLog.printLog(2, "getVCodecSWMaxCapabilityMap, hevcDecodeLevel:" + hevcSWDecodeLevel + ", avs3DecodeLevel:" + avs3SWDecodeLevel + ", AV1DecodeLevel:" + aV1SWDecodeLevel + ", vvcDecodeLevel:" + vvcSWDecodeLevel);
                    mAVCSWMaxCapability.maxLumaSamples = softMaxSamples;
                    mAVCSWMaxCapability.maxProfile = 64;
                    mAVCSWMaxCapability.maxLevel = 65536;
                    mMaxVCodecSwCapabilityMap.put(26, mAVCSWMaxCapability);
                    mHEVCSWMaxCapability.maxLumaSamples = softMaxSamples;
                    mHEVCSWMaxCapability.maxProfile = 2;
                    mHEVCSWMaxCapability.maxLevel = 33554432;
                    mMaxVCodecSwCapabilityMap.put(172, mHEVCSWMaxCapability);
                    mVP9SWMaxCapability.maxLumaSamples = softMaxSamples;
                    mVP9SWMaxCapability.maxProfile = 8;
                    mVP9SWMaxCapability.maxLevel = 8192;
                    mMaxVCodecSwCapabilityMap.put(166, mVP9SWMaxCapability);
                    mVP8SWMaxCapability.maxLumaSamples = softMaxSamples;
                    mVP8SWMaxCapability.maxProfile = 1;
                    mVP8SWMaxCapability.maxLevel = 8;
                    mMaxVCodecSwCapabilityMap.put(138, mVP8SWMaxCapability);
                    mAVS3WMaxCapability.maxLumaSamples = softMaxSamples2;
                    mAVS3WMaxCapability.maxProfile = 0;
                    mAVS3WMaxCapability.maxLevel = 0;
                    mMaxVCodecSwCapabilityMap.put(192, mAVS3WMaxCapability);
                    mAV1SWMaxCapability.maxLumaSamples = softMaxSamples3;
                    mAV1SWMaxCapability.maxProfile = 0;
                    mAV1SWMaxCapability.maxLevel = 0;
                    mMaxVCodecSwCapabilityMap.put(1029, mAV1SWMaxCapability);
                    mVVCSWMaxCapability.maxLumaSamples = softMaxSamples4;
                    mVVCSWMaxCapability.maxProfile = 0;
                    mVVCSWMaxCapability.maxLevel = 0;
                    mMaxVCodecSwCapabilityMap.put(193, mVVCSWMaxCapability);
                    TPNativeLog.printLog(2, "getVCodecSWMaxCapabilityMap success, maxHevcLumaSamples:" + softMaxSamples + ", maxAvs3LumaSamples:" + softMaxSamples2 + ", maxAV1LumaSamples:" + softMaxSamples3 + ", maxVvcLumaSamples:" + softMaxSamples4);
                    mIsFFmpegCapGot = true;
                    return mMaxVCodecSwCapabilityMap;
                } catch (Exception e) {
                    TPNativeLog.printLog(4, TAG, "getVCodecSWMaxCapabilityMap exception");
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> getVMediaCodecMaxCapabilityMap() {
        synchronized (TPCodecUtils.class) {
            try {
                TPNativeLog.printLog(2, TAG, "getVMediaCodecMaxCapabilityMap func in");
                if (!mMaxVCodecHwCapabilityMap.isEmpty()) {
                    TPNativeLog.printLog(2, TAG, "return memory stored video max cap map");
                    return mMaxVCodecHwCapabilityMap;
                }
                try {
                    TPMediaDecoderInfo[] tPMediaDecoderInfos = TPMediaDecoderList.getTPMediaDecoderInfos(mLocalCache);
                    int length = tPMediaDecoderInfos.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            break;
                        }
                        TPMediaDecoderInfo tPMediaDecoderInfo = tPMediaDecoderInfos[i2];
                        String decoderMimeType = tPMediaDecoderInfo.getDecoderMimeType();
                        if (tPMediaDecoderInfo.isVideo()) {
                            mVMediaCodecCapList.add(decoderMimeType);
                            TPNativeLog.printLog(2, TAG, "Video MimeType: " + decoderMimeType + " codecName: " + tPMediaDecoderInfo.getDecoderName());
                            if (isSupportedMediaCodec(decoderMimeType) && !tPMediaDecoderInfo.isSecureDecoder()) {
                                TPMediaDecoderInfo.DecoderProfileLevel maxProfileLevel = tPMediaDecoderInfo.getMaxProfileLevel();
                                TPCodecCapability.TPCodecMaxCapability tPCodecMaxCapability = new TPCodecCapability.TPCodecMaxCapability(getMaxLumaSample(decoderMimeType, maxProfileLevel.level), maxProfileLevel.profile, maxProfileLevel.level, tPMediaDecoderInfo.getDecoderMaxFrameRateForMaxLuma());
                                TPNativeLog.printLog(2, TAG, "video codecName: " + tPMediaDecoderInfo.getDecoderName() + " lumasample: " + getMaxLumaSample(decoderMimeType, maxProfileLevel.level) + " framerate: " + tPMediaDecoderInfo.getDecoderMaxFrameRateForMaxLuma());
                                if (!mMaxVCodecHwCapabilityMap.containsKey(Integer.valueOf(getSupportedCodecId(decoderMimeType))) || maxProfileLevel.level > mMaxVCodecHwCapabilityMap.get(Integer.valueOf(getSupportedCodecId(decoderMimeType))).maxLevel) {
                                    replace(Integer.valueOf(getSupportedCodecId(decoderMimeType)), tPCodecMaxCapability, mMaxVCodecHwCapabilityMap);
                                }
                            }
                        }
                        i = i2 + 1;
                    }
                } catch (Exception e) {
                    TPNativeLog.printLog(4, TAG, "getVMediaCodecMaxCapabilityMap failed:" + Log.getStackTraceString(e));
                }
                return mMaxVCodecHwCapabilityMap;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static int getValueFromSubstring(String str, int i, int i2) {
        int i3 = i;
        if (i < 0) {
            i3 = 0;
        }
        int i4 = i2;
        if (i2 >= str.length()) {
            i4 = str.length() - 1;
        }
        int i5 = i3;
        if (i3 > i4) {
            i5 = i4;
        }
        return Integer.parseInt(str.substring(i5, i4));
    }

    private static int getVvcSWDecodeLevel() {
        String valueOf;
        String str;
        int i = mVvcDeviceLevel;
        if (i != -1) {
            return i;
        }
        String cpuHarewareName = TPSystemInfo.getCpuHarewareName();
        int cpuHWProducter = TPSystemInfo.getCpuHWProducter(cpuHarewareName);
        int cpuHWProductIndex = TPSystemInfo.getCpuHWProductIndex(cpuHarewareName);
        TPNativeLog.printLog(2, TAG, "[getVvcSWDecodeLevel], mCpuHWProducer = " + cpuHWProducter + ", getMaxCpuFreq() = " + TPSystemInfo.getMaxCpuFreq() + ", numCores = " + TPSystemInfo.getNumCores() + ", mCpuHWProductIdx = " + cpuHWProductIndex + ", hardware = " + cpuHarewareName);
        int i2 = 0;
        if (cpuHWProducter == -1) {
            valueOf = String.valueOf(cpuHWProducter);
            str = "current cpu manufacturer is not listed in the performance list, cpuHwProducer:";
        } else if (cpuHWProductIndex != -1) {
            int selectBestDecodeLevelFromCapabilityTable = selectBestDecodeLevelFromCapabilityTable(193, cpuHWProducter, cpuHWProductIndex);
            if (selectBestDecodeLevelFromCapabilityTable != -1) {
                i2 = selectBestDecodeLevelFromCapabilityTable;
            }
            mVvcDeviceLevel = i2;
            return i2;
        } else {
            valueOf = String.valueOf(cpuHWProductIndex);
            str = "current cpu model is not listed in the performance list, cpuHwProductIdx:";
        }
        TPNativeLog.printLog(3, TAG, str.concat(valueOf));
        mVvcDeviceLevel = 0;
        return 0;
    }

    public static void init(Context context, boolean z) {
        synchronized (TPCodecUtils.class) {
            try {
                TPNativeLog.printLog(2, TAG, "is local cache enabled:".concat(String.valueOf(z)));
                Context applicationContext = context.getApplicationContext();
                mContext = applicationContext;
                if (z) {
                    mLocalCache = LocalCache.get(applicationContext);
                }
                getDecoderMaxCapabilityMapAsync();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean isAMediaCodecBlackListInstance(String str) {
        return mAMediaCodecBlackListInstance.contains(str);
    }

    public static boolean isAMediaCodecBlackListModel() {
        return mAMediaCodecBlackListModel.contains(TPSystemInfo.getDeviceName());
    }

    public static boolean isBlackListType(String str) {
        return Arrays.asList("PRO 7 Plus", "PRO 7-H", "PRO+7+Plus").contains(TPSystemInfo.getDeviceName()) && TextUtils.equals(str, "video/hevc") && Build.VERSION.SDK_INT >= 14;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0065, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean isHDR10Support(int r5) {
        /*
            java.lang.Class<com.tencent.thumbplayer.core.common.TPCodecUtils> r0 = com.tencent.thumbplayer.core.common.TPCodecUtils.class
            monitor-enter(r0)
            com.tencent.thumbplayer.core.thirdparties.LocalCache r0 = com.tencent.thumbplayer.core.common.TPCodecUtils.mLocalCache     // Catch: java.lang.Throwable -> L71
            com.tencent.thumbplayer.core.common.TPMediaDecoderInfo[] r0 = com.tencent.thumbplayer.core.common.TPMediaDecoderList.getTPMediaDecoderInfos(r0)     // Catch: java.lang.Throwable -> L71
            r10 = r0
            r0 = r10
            int r0 = r0.length     // Catch: java.lang.Throwable -> L71
            r8 = r0
            r0 = 0
            r6 = r0
        L11:
            r0 = r6
            r1 = r8
            if (r0 >= r1) goto L6c
            r0 = r10
            r1 = r6
            r0 = r0[r1]
            r11 = r0
            r0 = r11
            java.lang.String r0 = r0.getDecoderMimeType()     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = "video/hevc"
            boolean r0 = android.text.TextUtils.equals(r0, r1)     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L65
            r0 = r11
            com.tencent.thumbplayer.core.common.TPMediaDecoderInfo$DecoderProfileLevel[] r0 = r0.getProfileLevels()     // Catch: java.lang.Throwable -> L71
            r11 = r0
            r0 = r11
            int r0 = r0.length     // Catch: java.lang.Throwable -> L71
            r9 = r0
            r0 = 0
            r7 = r0
        L38:
            r0 = r7
            r1 = r9
            if (r0 >= r1) goto L65
            r0 = r11
            r1 = r7
            r0 = r0[r1]     // Catch: java.lang.Throwable -> L71
            int r0 = r0.profile     // Catch: java.lang.Throwable -> L71
            r1 = r5
            if (r0 != r1) goto L5e
            r0 = 2
            java.lang.String r1 = "TPCodecUtils"
            java.lang.String r2 = "support hdr10 "
            r3 = r5
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L71
            java.lang.String r2 = r2.concat(r3)     // Catch: java.lang.Throwable -> L71
            com.tencent.thumbplayer.core.common.TPNativeLog.printLog(r0, r1, r2)     // Catch: java.lang.Throwable -> L71
            java.lang.Class<com.tencent.thumbplayer.core.common.TPCodecUtils> r0 = com.tencent.thumbplayer.core.common.TPCodecUtils.class
            monitor-exit(r0)
            r0 = 1
            return r0
        L5e:
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            r7 = r0
            goto L38
        L65:
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L11
        L6c:
            java.lang.Class<com.tencent.thumbplayer.core.common.TPCodecUtils> r0 = com.tencent.thumbplayer.core.common.TPCodecUtils.class
            monitor-exit(r0)
            r0 = 0
            return r0
        L71:
            r10 = move-exception
            java.lang.Class<com.tencent.thumbplayer.core.common.TPCodecUtils> r0 = com.tencent.thumbplayer.core.common.TPCodecUtils.class
            monitor-exit(r0)
            r0 = r10
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.common.TPCodecUtils.isHDR10Support(int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0086, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean isHDRDVSupport(int r4, int r5) {
        /*
            java.lang.Class<com.tencent.thumbplayer.core.common.TPCodecUtils> r0 = com.tencent.thumbplayer.core.common.TPCodecUtils.class
            monitor-enter(r0)
            r0 = r4
            if (r0 != 0) goto L1c
            r0 = r5
            if (r0 != 0) goto L1c
            java.util.ArrayList<java.lang.String> r0 = com.tencent.thumbplayer.core.common.TPCodecUtils.mVMediaCodecCapList     // Catch: java.lang.Throwable -> L92
            java.lang.String r1 = "video/dolby-vision"
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Throwable -> L92
            r10 = r0
            java.lang.Class<com.tencent.thumbplayer.core.common.TPCodecUtils> r0 = com.tencent.thumbplayer.core.common.TPCodecUtils.class
            monitor-exit(r0)
            r0 = r10
            return r0
        L1c:
            com.tencent.thumbplayer.core.thirdparties.LocalCache r0 = com.tencent.thumbplayer.core.common.TPCodecUtils.mLocalCache     // Catch: java.lang.Throwable -> L92
            com.tencent.thumbplayer.core.common.TPMediaDecoderInfo[] r0 = com.tencent.thumbplayer.core.common.TPMediaDecoderList.getTPMediaDecoderInfos(r0)     // Catch: java.lang.Throwable -> L92
            r11 = r0
            r0 = r11
            int r0 = r0.length     // Catch: java.lang.Throwable -> L92
            r8 = r0
            r0 = 0
            r6 = r0
        L2b:
            r0 = r6
            r1 = r8
            if (r0 >= r1) goto L8d
            r0 = r11
            r1 = r6
            r0 = r0[r1]
            r12 = r0
            r0 = r12
            java.lang.String r0 = r0.getDecoderMimeType()     // Catch: java.lang.Throwable -> L92
            java.lang.String r1 = "video/dolby-vision"
            boolean r0 = android.text.TextUtils.equals(r0, r1)     // Catch: java.lang.Throwable -> L92
            if (r0 == 0) goto L86
            r0 = r12
            com.tencent.thumbplayer.core.common.TPMediaDecoderInfo$DecoderProfileLevel[] r0 = r0.getProfileLevels()     // Catch: java.lang.Throwable -> L92
            r12 = r0
            r0 = r12
            int r0 = r0.length     // Catch: java.lang.Throwable -> L92
            r9 = r0
            r0 = 0
            r7 = r0
        L53:
            r0 = r7
            r1 = r9
            if (r0 >= r1) goto L86
            r0 = r12
            r1 = r7
            r0 = r0[r1]
            r13 = r0
            r0 = r13
            int r0 = r0.profile     // Catch: java.lang.Throwable -> L92
            r1 = r4
            if (r0 != r1) goto L7f
            r0 = r13
            int r0 = r0.level     // Catch: java.lang.Throwable -> L92
            r1 = r5
            if (r0 != r1) goto L7f
            r0 = 2
            java.lang.String r1 = "TPCodecUtils"
            java.lang.String r2 = "support dolbyvision"
            com.tencent.thumbplayer.core.common.TPNativeLog.printLog(r0, r1, r2)     // Catch: java.lang.Throwable -> L92
            java.lang.Class<com.tencent.thumbplayer.core.common.TPCodecUtils> r0 = com.tencent.thumbplayer.core.common.TPCodecUtils.class
            monitor-exit(r0)
            r0 = 1
            return r0
        L7f:
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            r7 = r0
            goto L53
        L86:
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L2b
        L8d:
            java.lang.Class<com.tencent.thumbplayer.core.common.TPCodecUtils> r0 = com.tencent.thumbplayer.core.common.TPCodecUtils.class
            monitor-exit(r0)
            r0 = 0
            return r0
        L92:
            r11 = move-exception
            java.lang.Class<com.tencent.thumbplayer.core.common.TPCodecUtils> r0 = com.tencent.thumbplayer.core.common.TPCodecUtils.class
            monitor-exit(r0)
            r0 = r11
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.common.TPCodecUtils.isHDRDVSupport(int, int):boolean");
    }

    public static boolean isHDRDecoderTypeSupport(int i, int i2) {
        String valueOf;
        String str;
        if (i2 == 102 || i2 == 101) {
            HashMap<Integer, ArrayList<TPCodecCapability.TPHdrSupportVersionRange>> hashMap = i2 == 102 ? mHDRTypeToHDRHardwareCodecWhiteListMap : mHDRTypeToHDRSoftwareCodecWhiteListMap;
            if (hashMap.containsKey(Integer.valueOf(i))) {
                return isInHDRVersionRangeWhiteList(hashMap.get(Integer.valueOf(i)));
            }
            valueOf = String.valueOf(i);
            str = "isHDRDecodeTypeSupport, not config hdrType whiteList, hdrType = ";
        } else {
            valueOf = String.valueOf(i2);
            str = "isHDRDecodeTypeSupport, not support decoderType, decoderType = ";
        }
        TPNativeLog.printLog(3, TAG, str.concat(valueOf));
        return false;
    }

    public static boolean isHDRsupport(int i, int i2, int i3) {
        if (i == 2) {
            return isHDRDVSupport(i2, i3);
        }
        if (i == 0) {
            return isHDR10Support(4096);
        }
        if (i == 1) {
            return isHDR10Support(8192);
        }
        if (i == 4) {
            String displayVersion = getDisplayVersion();
            String systemPatchVersion = getSystemPatchVersion();
            TPNativeLog.printLog(2, TAG, "isHDRsupport(HDRVivid):display version:".concat(String.valueOf(displayVersion)));
            TPNativeLog.printLog(2, TAG, "isHDRsupport(HDRVivid):patch version:".concat(String.valueOf(systemPatchVersion)));
            return checkHDRVividSupportByVersion(TPSystemInfo.getDeviceName(), displayVersion, systemPatchVersion);
        }
        return false;
    }

    public static boolean isInDRMLevel1Blacklist(int i) {
        if (mDrmL1BlackList.containsKey(Integer.valueOf(i))) {
            return mDrmL1BlackList.get(Integer.valueOf(i)).contains(TPSystemInfo.getDeviceName());
        }
        return false;
    }

    private static boolean isInHDRVersionRangeWhiteList(ArrayList<TPCodecCapability.TPHdrSupportVersionRange> arrayList) {
        if (arrayList == null) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return false;
            }
            TPCodecCapability.TPHdrSupportVersionRange tPHdrSupportVersionRange = arrayList.get(i2);
            if (Build.VERSION.SDK_INT <= tPHdrSupportVersionRange.upperboundAndroidAPILevel && Build.VERSION.SDK_INT >= tPHdrSupportVersionRange.lowerboundAndroidAPILevel) {
                TPNativeLog.printLog(2, TAG, "inHDRVersionRangeWhiteList!");
                return true;
            }
            i = i2 + 1;
        }
    }

    public static boolean isInHDRVividBlackList(String str, int i, int i2) {
        if (mHdrBlackMap.containsKey(4)) {
            HashMap<String, TPCodecCapability.TPHdrSupportVersionRange> hashMap = mHdrBlackMap.get(4);
            if (hashMap.containsKey(str)) {
                TPCodecCapability.TPHdrSupportVersionRange tPHdrSupportVersionRange = hashMap.get(str);
                return i <= tPHdrSupportVersionRange.upperboundSystemVersion && i >= tPHdrSupportVersionRange.lowerboundSystemVersion && i2 <= tPHdrSupportVersionRange.upperboundPatchVersion && i2 >= tPHdrSupportVersionRange.lowerboundPatchVersion;
            }
            return false;
        }
        return false;
    }

    public static boolean isInHDRVividWhiteList(String str, int i, int i2) {
        if (mHdrWhiteMap.containsKey(4)) {
            HashMap<String, TPCodecCapability.TPHdrSupportVersionRange> hashMap = mHdrWhiteMap.get(4);
            if (hashMap.containsKey(str)) {
                TPCodecCapability.TPHdrSupportVersionRange tPHdrSupportVersionRange = hashMap.get(str);
                return i <= tPHdrSupportVersionRange.upperboundSystemVersion && i >= tPHdrSupportVersionRange.lowerboundSystemVersion && i2 <= tPHdrSupportVersionRange.upperboundPatchVersion && i2 >= tPHdrSupportVersionRange.lowerboundPatchVersion;
            }
            return false;
        }
        return false;
    }

    public static boolean isInMediaCodecBlackList(String str) {
        HashMap<String, Integer> hashMap;
        String deviceName = TPSystemInfo.getDeviceName();
        if (TextUtils.isEmpty(deviceName) || (hashMap = mCodecCapBlackList) == null || !hashMap.containsKey(deviceName)) {
            return false;
        }
        Integer num = mCodecCapBlackList.get(deviceName);
        return TextUtils.equals(str, "video/avc") ? (num.intValue() & 1) != 0 : TextUtils.equals(str, "video/hevc") ? (num.intValue() & 2) != 0 : TextUtils.equals(str, "video/x-vnd.on2.vp8") ? (num.intValue() & 256) != 0 : TextUtils.equals(str, "video/x-vnd.on2.vp9") ? (num.intValue() & 4) != 0 : TextUtils.equals(str, "audio/mp4a-latm") ? (num.intValue() & 8) != 0 : TextUtils.equals(str, "audio/ac3") ? (num.intValue() & 16) != 0 : TextUtils.equals(str, "audio/eac3") ? (num.intValue() & 32) != 0 : TextUtils.equals(str, "audio/flac") ? (num.intValue() & 64) != 0 : TextUtils.equals(str, o.D) ? (num.intValue() & 128) != 0 : TextUtils.equals(str, o.B) && (num.intValue() & 32) != 0;
    }

    public static boolean isInMediaCodecWhiteList(String str) {
        HashMap<String, Integer> hashMap;
        String deviceName = TPSystemInfo.getDeviceName();
        if (TextUtils.isEmpty(deviceName) || (hashMap = mCodecCapWhiteList) == null || !hashMap.containsKey(deviceName)) {
            return false;
        }
        Integer num = mCodecCapWhiteList.get(deviceName);
        return TextUtils.equals(str, "video/avc") ? (num.intValue() & 1) != 0 : TextUtils.equals(str, "video/hevc") ? (num.intValue() & 2) != 0 : TextUtils.equals(str, "video/x-vnd.on2.vp8") ? (num.intValue() & 256) != 0 : TextUtils.equals(str, "video/x-vnd.on2.vp9") ? (num.intValue() & 4) != 0 : TextUtils.equals(str, "audio/mp4a-latm") ? (num.intValue() & 8) != 0 : TextUtils.equals(str, "audio/ac3") ? (num.intValue() & 16) != 0 : TextUtils.equals(str, "audio/eac3") ? (num.intValue() & 32) != 0 : TextUtils.equals(str, "audio/flac") ? (num.intValue() & 64) != 0 : TextUtils.equals(str, o.D) && (num.intValue() & 128) != 0;
    }

    private static boolean isLimitMaxWidthOrMaxHeight(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i5 <= i6 || (i5 <= i && i6 <= i4)) {
            if (i5 >= i6) {
                return false;
            }
            if (i5 <= i3 && i6 <= i2) {
                return false;
            }
        }
        int i7 = i5 > i6 ? i4 * i : i3 * i2;
        if (i < i5 || i2 < i6 || i7 < i5 * i6) {
            TPNativeLog.printLog(4, TAG, "getSupportedFrameRatesFor width:" + i5 + " height:" + i6 + " do not support! maxWidth:" + i + " maxHeight:" + i2);
            return true;
        }
        TPNativeLog.printLog(2, TAG, "getSupportedFrameRatesFor width:" + i5 + " height:" + i6 + " limit maxLumaWidth or maxLumaHeight, but not limit maxLumaSamples, do support! maxWidth:" + i + " maxHeight:" + i2 + " maxLumaSamples:" + i7);
        return false;
    }

    public static boolean isMediaCodecDDPlusSupported() {
        synchronized (TPCodecUtils.class) {
            try {
                if (isAMediaCodecBlackListModel()) {
                    return false;
                }
                if (!mAMediaCodecCapList.contains("audio/eac3")) {
                    if (!mAMediaCodecCapList.contains(o.B)) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean isMediaCodecDolbyDSSupported() {
        synchronized (TPCodecUtils.class) {
            try {
                if (isAMediaCodecBlackListModel()) {
                    return false;
                }
                return mAMediaCodecCapList.contains("audio/ac3");
            } finally {
            }
        }
    }

    private static boolean isSupportedMediaCodec(String str) {
        return mSupportedMediaCodec.contains(str);
    }

    private static boolean isTheSameVersionRange(TPCodecCapability.TPHdrSupportVersionRange tPHdrSupportVersionRange, TPCodecCapability.TPHdrSupportVersionRange tPHdrSupportVersionRange2) {
        return tPHdrSupportVersionRange.lowerboundPatchVersion == tPHdrSupportVersionRange2.lowerboundPatchVersion && tPHdrSupportVersionRange.lowerboundSystemVersion == tPHdrSupportVersionRange2.lowerboundSystemVersion && tPHdrSupportVersionRange.upperboundPatchVersion == tPHdrSupportVersionRange2.upperboundPatchVersion && tPHdrSupportVersionRange.upperboundSystemVersion == tPHdrSupportVersionRange2.upperboundSystemVersion;
    }

    public static boolean isVMediaCodecBlackListModel() {
        return mVMediaCodecBlackListModel.contains(TPSystemInfo.getDeviceName());
    }

    private static <K, T> void replace(K k, T t, HashMap<K, T> hashMap) {
        if (!hashMap.containsKey(k)) {
            hashMap.put(k, t);
            return;
        }
        hashMap.remove(k);
        hashMap.put(k, t);
    }

    private static int selectBestDecodeLevelFromCapabilityTable(int i, int i2, int i3) {
        String valueOf;
        String str;
        VideoSwCapabilityModel videoSwCapabilityModel = mVideoCodecIdToSwCapabilityModel.get(i);
        if (videoSwCapabilityModel == null) {
            valueOf = String.valueOf(i);
            str = "No corresponding codec id found, codecId:";
        } else {
            HashMap<DefinitionName, String> hashMap = videoSwCapabilityModel.mCpuProducerToAllDefinitionDecTable.get(i2);
            if (hashMap == null || hashMap.isEmpty()) {
                valueOf = String.valueOf(i2);
                str = "No corresponding cpu producer found, cpuHwProducer:";
            } else {
                DefinitionName[] values = DefinitionName.values();
                int length = values.length;
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= length) {
                        return -1;
                    }
                    DefinitionName definitionName = values[i5];
                    String str2 = hashMap.get(definitionName);
                    if (!TextUtils.isEmpty(str2) && i3 >= TPSystemInfo.getCpuHWProductIndex(i2, str2)) {
                        return convertDefinitionNameToDecodeLevel(definitionName);
                    }
                    i4 = i5 + 1;
                }
            }
        }
        TPNativeLog.printLog(3, TAG, str.concat(valueOf));
        return -1;
    }

    public static void setMediaCodecPreferredSoftwareComponent(boolean z) {
        mPreferredSoftwareComponent = z;
    }
}

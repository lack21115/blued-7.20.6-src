package android.media;

import android.util.Log;
import android.util.Pair;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.cdo.oaps.ad.p;
import com.huawei.hms.framework.common.ExceptionCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: source-9557208-dex2jar.jar:android/media/MediaCodecInfo.class */
public final class MediaCodecInfo {
    private static final int ERROR_NONE_SUPPORTED = 4;
    private static final int ERROR_UNRECOGNIZED = 1;
    private static final int ERROR_UNSUPPORTED = 2;
    private Map<String, CodecCapabilities> mCaps = new HashMap();
    private boolean mIsEncoder;
    private String mName;
    private static final Range<Integer> POSITIVE_INTEGERS = Range.create(1, Integer.MAX_VALUE);
    private static final Range<Long> POSITIVE_LONGS = Range.create(1L, Long.MAX_VALUE);
    private static final Range<Rational> POSITIVE_RATIONALS = Range.create(new Rational(1, Integer.MAX_VALUE), new Rational(Integer.MAX_VALUE, 1));
    private static final Range<Integer> SIZE_RANGE = Range.create(1, 32768);
    private static final Range<Integer> FRAME_RATE_RANGE = Range.create(0, 960);
    private static final Range<Integer> BITRATE_RANGE = Range.create(0, 500000000);

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaCodecInfo$AudioCapabilities.class */
    public static final class AudioCapabilities {
        private static final int MAX_INPUT_CHANNEL_COUNT = 30;
        private static final String TAG = "AudioCapabilities";
        private Range<Integer> mBitrateRange;
        private int mMaxInputChannelCount;
        private CodecCapabilities mParent;
        private Range<Integer>[] mSampleRateRanges;
        private int[] mSampleRates;

        private AudioCapabilities() {
        }

        private void applyLevelLimits() {
            int[] iArr = null;
            Range<Integer> range = null;
            Range<Integer> range2 = null;
            int i = 0;
            String mimeType = this.mParent.getMimeType();
            if (mimeType.equalsIgnoreCase("audio/mpeg")) {
                iArr = new int[]{8000, 11025, 12000, 16000, 22050, 24000, 32000, 44100, 48000};
                range2 = Range.create(8000, 320000);
                i = 2;
            } else if (mimeType.equalsIgnoreCase("audio/3gpp")) {
                iArr = new int[]{8000};
                range2 = Range.create(4750, 12200);
                i = 1;
            } else if (mimeType.equalsIgnoreCase("audio/amr-wb")) {
                iArr = new int[]{16000};
                range2 = Range.create(Integer.valueOf((int) p.g), 23850);
                i = 1;
            } else if (mimeType.equalsIgnoreCase("audio/mp4a-latm")) {
                iArr = new int[]{7350, 8000, 11025, 12000, 16000, 22050, 24000, 32000, 44100, 48000, 64000, 88200, 96000};
                range2 = Range.create(8000, 510000);
                i = 48;
            } else if (mimeType.equalsIgnoreCase("audio/vorbis")) {
                range2 = Range.create(32000, 500000);
                range = Range.create(8000, 192000);
                i = 255;
            } else if (mimeType.equalsIgnoreCase("audio/opus")) {
                range2 = Range.create(6000, 510000);
                iArr = new int[]{8000, 12000, 16000, 24000, 48000};
                i = 255;
            } else if (mimeType.equalsIgnoreCase("audio/raw")) {
                range = Range.create(1, 96000);
                range2 = Range.create(1, Integer.valueOf((int) ExceptionCode.CRASH_EXCEPTION));
                i = 8;
            } else if (mimeType.equalsIgnoreCase("audio/flac")) {
                range = Range.create(1, 655350);
                i = 255;
            } else if (mimeType.equalsIgnoreCase("audio/g711-alaw") || mimeType.equalsIgnoreCase("audio/g711-mlaw")) {
                iArr = new int[]{8000};
                range2 = Range.create(64000, 64000);
            } else if (mimeType.equalsIgnoreCase("audio/gsm")) {
                iArr = new int[]{8000};
                range2 = Range.create(13000, 13000);
                i = 1;
            } else {
                Log.w(TAG, "Unsupported mime " + mimeType);
                this.mParent.mError |= 2;
            }
            if (iArr != null) {
                limitSampleRates(iArr);
            } else if (range != null) {
                limitSampleRates(new Range[]{range});
            }
            applyLimits(i, range2);
        }

        private void applyLimits(int i, Range<Integer> range) {
            this.mMaxInputChannelCount = ((Integer) Range.create(1, Integer.valueOf(this.mMaxInputChannelCount)).clamp(Integer.valueOf(i))).intValue();
            if (range != null) {
                this.mBitrateRange = this.mBitrateRange.intersect(range);
            }
        }

        public static AudioCapabilities create(MediaFormat mediaFormat, CodecCapabilities codecCapabilities) {
            AudioCapabilities audioCapabilities = new AudioCapabilities();
            audioCapabilities.init(mediaFormat, codecCapabilities);
            return audioCapabilities;
        }

        private void createDiscreteSampleRates() {
            this.mSampleRates = new int[this.mSampleRateRanges.length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mSampleRateRanges.length) {
                    return;
                }
                this.mSampleRates[i2] = this.mSampleRateRanges[i2].getLower().intValue();
                i = i2 + 1;
            }
        }

        private void initWithPlatformLimits() {
            this.mBitrateRange = Range.create(0, Integer.MAX_VALUE);
            this.mMaxInputChannelCount = 30;
            this.mSampleRateRanges = new Range[]{Range.create(8000, 96000)};
            this.mSampleRates = null;
        }

        private void limitSampleRates(int[] iArr) {
            Arrays.sort(iArr);
            ArrayList arrayList = new ArrayList();
            int length = iArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    this.mSampleRateRanges = (Range[]) arrayList.toArray(new Range[arrayList.size()]);
                    createDiscreteSampleRates();
                    return;
                }
                int i3 = iArr[i2];
                if (supports(Integer.valueOf(i3), null)) {
                    arrayList.add(Range.create(Integer.valueOf(i3), Integer.valueOf(i3)));
                }
                i = i2 + 1;
            }
        }

        private void limitSampleRates(Range<Integer>[] rangeArr) {
            Utils.sortDistinctRanges(rangeArr);
            this.mSampleRateRanges = Utils.intersectSortedDistinctRanges(this.mSampleRateRanges, rangeArr);
            Range<Integer>[] rangeArr2 = this.mSampleRateRanges;
            int length = rangeArr2.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    createDiscreteSampleRates();
                    return;
                }
                Range<Integer> range = rangeArr2[i2];
                if (!range.getLower().equals(range.getUpper())) {
                    this.mSampleRates = null;
                    return;
                }
                i = i2 + 1;
            }
        }

        private void parseFromInfo(MediaFormat mediaFormat) {
            Range<Integer> range = MediaCodecInfo.POSITIVE_INTEGERS;
            if (mediaFormat.containsKey("sample-rate-ranges")) {
                String[] split = mediaFormat.getString("sample-rate-ranges").split(",");
                Range<Integer>[] rangeArr = new Range[split.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= split.length) {
                        break;
                    }
                    rangeArr[i2] = Utils.parseIntRange(split[i2], null);
                    i = i2 + 1;
                }
                limitSampleRates(rangeArr);
            }
            int i3 = 30;
            if (mediaFormat.containsKey("max-channel-count")) {
                i3 = Utils.parseIntSafely(mediaFormat.getString("max-channel-count"), 30);
            }
            Range<Integer> range2 = range;
            if (mediaFormat.containsKey("bitrate-range")) {
                range2 = range.intersect(Utils.parseIntRange(mediaFormat.getString("bitrate-range"), range));
            }
            applyLimits(i3, range2);
        }

        private boolean supports(Integer num, Integer num2) {
            if (num2 == null || (num2.intValue() >= 1 && num2.intValue() <= this.mMaxInputChannelCount)) {
                return num == null || Utils.binarySearchDistinctRanges(this.mSampleRateRanges, num) >= 0;
            }
            return false;
        }

        public Range<Integer> getBitrateRange() {
            return this.mBitrateRange;
        }

        public int getMaxInputChannelCount() {
            return this.mMaxInputChannelCount;
        }

        public Range<Integer>[] getSupportedSampleRateRanges() {
            return (Range[]) Arrays.copyOf(this.mSampleRateRanges, this.mSampleRateRanges.length);
        }

        public int[] getSupportedSampleRates() {
            return Arrays.copyOf(this.mSampleRates, this.mSampleRates.length);
        }

        public void init(MediaFormat mediaFormat, CodecCapabilities codecCapabilities) {
            this.mParent = codecCapabilities;
            initWithPlatformLimits();
            applyLevelLimits();
            parseFromInfo(mediaFormat);
        }

        public boolean isSampleRateSupported(int i) {
            return supports(Integer.valueOf(i), null);
        }

        public void setDefaultFormat(MediaFormat mediaFormat) {
            if (this.mBitrateRange.getLower().equals(this.mBitrateRange.getUpper())) {
                mediaFormat.setInteger(MediaFormat.KEY_BIT_RATE, this.mBitrateRange.getLower().intValue());
            }
            if (this.mMaxInputChannelCount == 1) {
                mediaFormat.setInteger(MediaFormat.KEY_CHANNEL_COUNT, 1);
            }
            if (this.mSampleRates == null || this.mSampleRates.length != 1) {
                return;
            }
            mediaFormat.setInteger(MediaFormat.KEY_SAMPLE_RATE, this.mSampleRates[0]);
        }

        public boolean supportsFormat(MediaFormat mediaFormat) {
            Map<String, Object> map = mediaFormat.getMap();
            return supports((Integer) map.get(MediaFormat.KEY_SAMPLE_RATE), (Integer) map.get(MediaFormat.KEY_CHANNEL_COUNT));
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaCodecInfo$CodecCapabilities.class */
    public static final class CodecCapabilities {
        public static final int COLOR_Format12bitRGB444 = 3;
        public static final int COLOR_Format16bitARGB1555 = 5;
        public static final int COLOR_Format16bitARGB4444 = 4;
        public static final int COLOR_Format16bitBGR565 = 7;
        public static final int COLOR_Format16bitRGB565 = 6;
        public static final int COLOR_Format18BitBGR666 = 41;
        public static final int COLOR_Format18bitARGB1665 = 9;
        public static final int COLOR_Format18bitRGB666 = 8;
        public static final int COLOR_Format19bitARGB1666 = 10;
        public static final int COLOR_Format24BitABGR6666 = 43;
        public static final int COLOR_Format24BitARGB6666 = 42;
        public static final int COLOR_Format24bitARGB1887 = 13;
        public static final int COLOR_Format24bitBGR888 = 12;
        public static final int COLOR_Format24bitRGB888 = 11;
        public static final int COLOR_Format25bitARGB1888 = 14;
        public static final int COLOR_Format32bitARGB8888 = 16;
        public static final int COLOR_Format32bitBGRA8888 = 15;
        public static final int COLOR_Format8bitRGB332 = 2;
        public static final int COLOR_FormatCbYCrY = 27;
        public static final int COLOR_FormatCrYCbY = 28;
        public static final int COLOR_FormatL16 = 36;
        public static final int COLOR_FormatL2 = 33;
        public static final int COLOR_FormatL24 = 37;
        public static final int COLOR_FormatL32 = 38;
        public static final int COLOR_FormatL4 = 34;
        public static final int COLOR_FormatL8 = 35;
        public static final int COLOR_FormatMonochrome = 1;
        public static final int COLOR_FormatRawBayer10bit = 31;
        public static final int COLOR_FormatRawBayer8bit = 30;
        public static final int COLOR_FormatRawBayer8bitcompressed = 32;
        public static final int COLOR_FormatSurface = 2130708361;
        public static final int COLOR_FormatYCbYCr = 25;
        public static final int COLOR_FormatYCrYCb = 26;
        public static final int COLOR_FormatYUV411PackedPlanar = 18;
        public static final int COLOR_FormatYUV411Planar = 17;
        public static final int COLOR_FormatYUV420Flexible = 2135033992;
        public static final int COLOR_FormatYUV420PackedPlanar = 20;
        public static final int COLOR_FormatYUV420PackedSemiPlanar = 39;
        public static final int COLOR_FormatYUV420Planar = 19;
        public static final int COLOR_FormatYUV420SemiPlanar = 21;
        public static final int COLOR_FormatYUV422PackedPlanar = 23;
        public static final int COLOR_FormatYUV422PackedSemiPlanar = 40;
        public static final int COLOR_FormatYUV422Planar = 22;
        public static final int COLOR_FormatYUV422SemiPlanar = 24;
        public static final int COLOR_FormatYUV444Interleaved = 29;
        public static final int COLOR_QCOM_FormatYUV420SemiPlanar = 2141391872;
        public static final int COLOR_TI_FormatYUV420PackedSemiPlanar = 2130706688;
        private static final String TAG = "CodecCapabilities";
        public int[] colorFormats;
        private AudioCapabilities mAudioCaps;
        private MediaFormat mCapabilitiesInfo;
        private MediaFormat mDefaultFormat;
        private EncoderCapabilities mEncoderCaps;
        int mError;
        private int mFlagsRequired;
        private int mFlagsSupported;
        private int mFlagsVerified;
        private String mMime;
        private VideoCapabilities mVideoCaps;
        public CodecProfileLevel[] profileLevels;
        public static final String FEATURE_AdaptivePlayback = "adaptive-playback";
        public static final String FEATURE_SecurePlayback = "secure-playback";
        public static final String FEATURE_TunneledPlayback = "tunneled-playback";
        private static final Feature[] decoderFeatures = {new Feature(FEATURE_AdaptivePlayback, 1, true), new Feature(FEATURE_SecurePlayback, 2, false), new Feature(FEATURE_TunneledPlayback, 4, false)};

        public CodecCapabilities() {
        }

        CodecCapabilities(CodecProfileLevel[] codecProfileLevelArr, int[] iArr, boolean z, int i, MediaFormat mediaFormat, MediaFormat mediaFormat2) {
            Map<String, Object> map = mediaFormat2.getMap();
            this.profileLevels = codecProfileLevelArr;
            this.colorFormats = iArr;
            this.mFlagsVerified = i;
            this.mDefaultFormat = mediaFormat;
            this.mCapabilitiesInfo = mediaFormat2;
            this.mMime = this.mDefaultFormat.getString(MediaFormat.KEY_MIME);
            if (this.mMime.toLowerCase().startsWith("audio/")) {
                this.mAudioCaps = AudioCapabilities.create(mediaFormat2, this);
                this.mAudioCaps.setDefaultFormat(this.mDefaultFormat);
            } else if (this.mMime.toLowerCase().startsWith("video/")) {
                this.mVideoCaps = VideoCapabilities.create(mediaFormat2, this);
            }
            if (z) {
                this.mEncoderCaps = EncoderCapabilities.create(mediaFormat2, this);
                this.mEncoderCaps.setDefaultFormat(this.mDefaultFormat);
            }
            Feature[] validFeatures = getValidFeatures();
            int length = validFeatures.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return;
                }
                Feature feature = validFeatures[i3];
                String str = MediaFormat.KEY_FEATURE_ + feature.mName;
                Integer num = (Integer) map.get(str);
                if (num != null) {
                    if (num.intValue() > 0) {
                        this.mFlagsRequired |= feature.mValue;
                    }
                    this.mFlagsSupported |= feature.mValue;
                    this.mDefaultFormat.setInteger(str, 1);
                }
                i2 = i3 + 1;
            }
        }

        CodecCapabilities(CodecProfileLevel[] codecProfileLevelArr, int[] iArr, boolean z, int i, Map<String, Object> map, Map<String, Object> map2) {
            this(codecProfileLevelArr, iArr, z, i, new MediaFormat(map), new MediaFormat(map2));
        }

        private boolean checkFeature(String str, int i) {
            boolean z;
            Feature[] validFeatures = getValidFeatures();
            int length = validFeatures.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                z = false;
                if (i3 >= length) {
                    break;
                }
                Feature feature = validFeatures[i3];
                if (feature.mName.equals(str)) {
                    z = false;
                    if ((feature.mValue & i) != 0) {
                        z = true;
                    }
                } else {
                    i2 = i3 + 1;
                }
            }
            return z;
        }

        public static CodecCapabilities createFromProfileLevel(String str, int i, int i2) {
            CodecProfileLevel codecProfileLevel = new CodecProfileLevel();
            codecProfileLevel.profile = i;
            codecProfileLevel.level = i2;
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString(MediaFormat.KEY_MIME, str);
            CodecCapabilities codecCapabilities = new CodecCapabilities(new CodecProfileLevel[]{codecProfileLevel}, new int[0], true, 0, mediaFormat, new MediaFormat());
            CodecCapabilities codecCapabilities2 = codecCapabilities;
            if (codecCapabilities.mError != 0) {
                codecCapabilities2 = null;
            }
            return codecCapabilities2;
        }

        private Feature[] getValidFeatures() {
            return !isEncoder() ? decoderFeatures : new Feature[0];
        }

        private boolean isAudio() {
            return this.mAudioCaps != null;
        }

        private boolean isEncoder() {
            return this.mEncoderCaps != null;
        }

        private boolean isVideo() {
            return this.mVideoCaps != null;
        }

        public CodecCapabilities dup() {
            return new CodecCapabilities((CodecProfileLevel[]) Arrays.copyOf(this.profileLevels, this.profileLevels.length), Arrays.copyOf(this.colorFormats, this.colorFormats.length), isEncoder(), this.mFlagsVerified, this.mDefaultFormat, this.mCapabilitiesInfo);
        }

        public AudioCapabilities getAudioCapabilities() {
            return this.mAudioCaps;
        }

        public MediaFormat getDefaultFormat() {
            return this.mDefaultFormat;
        }

        public EncoderCapabilities getEncoderCapabilities() {
            return this.mEncoderCaps;
        }

        public String getMimeType() {
            return this.mMime;
        }

        public VideoCapabilities getVideoCapabilities() {
            return this.mVideoCaps;
        }

        public final boolean isFeatureRequired(String str) {
            return checkFeature(str, this.mFlagsRequired);
        }

        public final boolean isFeatureSupported(String str) {
            return checkFeature(str, this.mFlagsSupported);
        }

        public final boolean isFormatSupported(MediaFormat mediaFormat) {
            Map<String, Object> map = mediaFormat.getMap();
            String str = (String) map.get(MediaFormat.KEY_MIME);
            if (str != null && !this.mMime.equalsIgnoreCase(str)) {
                return false;
            }
            Feature[] validFeatures = getValidFeatures();
            int length = validFeatures.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    if (this.mAudioCaps == null || this.mAudioCaps.supportsFormat(mediaFormat)) {
                        if (this.mVideoCaps == null || this.mVideoCaps.supportsFormat(mediaFormat)) {
                            return this.mEncoderCaps == null || this.mEncoderCaps.supportsFormat(mediaFormat);
                        }
                        return false;
                    }
                    return false;
                }
                Feature feature = validFeatures[i2];
                Integer num = (Integer) map.get(MediaFormat.KEY_FEATURE_ + feature.mName);
                if (num != null) {
                    if (num.intValue() == 1 && !isFeatureSupported(feature.mName)) {
                        return false;
                    }
                    if (num.intValue() == 0 && isFeatureRequired(feature.mName)) {
                        return false;
                    }
                }
                i = i2 + 1;
            }
        }

        public boolean isRegular() {
            Feature[] validFeatures = getValidFeatures();
            int length = validFeatures.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return true;
                }
                Feature feature = validFeatures[i2];
                if (!feature.mDefault && isFeatureRequired(feature.mName)) {
                    return false;
                }
                i = i2 + 1;
            }
        }

        public String[] validFeatures() {
            Feature[] validFeatures = getValidFeatures();
            String[] strArr = new String[validFeatures.length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= strArr.length) {
                    return strArr;
                }
                strArr[i2] = validFeatures[i2].mName;
                i = i2 + 1;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaCodecInfo$CodecProfileLevel.class */
    public static final class CodecProfileLevel {
        public static final int AACObjectELD = 39;
        public static final int AACObjectERLC = 17;
        public static final int AACObjectHE = 5;
        public static final int AACObjectHE_PS = 29;
        public static final int AACObjectLC = 2;
        public static final int AACObjectLD = 23;
        public static final int AACObjectLTP = 4;
        public static final int AACObjectMain = 1;
        public static final int AACObjectSSR = 3;
        public static final int AACObjectScalable = 6;
        public static final int AVCLevel1 = 1;
        public static final int AVCLevel11 = 4;
        public static final int AVCLevel12 = 8;
        public static final int AVCLevel13 = 16;
        public static final int AVCLevel1b = 2;
        public static final int AVCLevel2 = 32;
        public static final int AVCLevel21 = 64;
        public static final int AVCLevel22 = 128;
        public static final int AVCLevel3 = 256;
        public static final int AVCLevel31 = 512;
        public static final int AVCLevel32 = 1024;
        public static final int AVCLevel4 = 2048;
        public static final int AVCLevel41 = 4096;
        public static final int AVCLevel42 = 8192;
        public static final int AVCLevel5 = 16384;
        public static final int AVCLevel51 = 32768;
        public static final int AVCLevel52 = 65536;
        public static final int AVCProfileBaseline = 1;
        public static final int AVCProfileExtended = 4;
        public static final int AVCProfileHigh = 8;
        public static final int AVCProfileHigh10 = 16;
        public static final int AVCProfileHigh422 = 32;
        public static final int AVCProfileHigh444 = 64;
        public static final int AVCProfileMain = 2;
        public static final int H263Level10 = 1;
        public static final int H263Level20 = 2;
        public static final int H263Level30 = 4;
        public static final int H263Level40 = 8;
        public static final int H263Level45 = 16;
        public static final int H263Level50 = 32;
        public static final int H263Level60 = 64;
        public static final int H263Level70 = 128;
        public static final int H263ProfileBackwardCompatible = 4;
        public static final int H263ProfileBaseline = 1;
        public static final int H263ProfileH320Coding = 2;
        public static final int H263ProfileHighCompression = 32;
        public static final int H263ProfileHighLatency = 256;
        public static final int H263ProfileISWV2 = 8;
        public static final int H263ProfileISWV3 = 16;
        public static final int H263ProfileInterlace = 128;
        public static final int H263ProfileInternet = 64;
        public static final int HEVCHighTierLevel1 = 2;
        public static final int HEVCHighTierLevel2 = 8;
        public static final int HEVCHighTierLevel21 = 32;
        public static final int HEVCHighTierLevel3 = 128;
        public static final int HEVCHighTierLevel31 = 512;
        public static final int HEVCHighTierLevel4 = 2048;
        public static final int HEVCHighTierLevel41 = 8192;
        public static final int HEVCHighTierLevel5 = 32768;
        public static final int HEVCHighTierLevel51 = 131072;
        public static final int HEVCHighTierLevel52 = 524288;
        public static final int HEVCHighTierLevel6 = 2097152;
        public static final int HEVCHighTierLevel61 = 8388608;
        public static final int HEVCHighTierLevel62 = 33554432;
        public static final int HEVCMainTierLevel1 = 1;
        public static final int HEVCMainTierLevel2 = 4;
        public static final int HEVCMainTierLevel21 = 16;
        public static final int HEVCMainTierLevel3 = 64;
        public static final int HEVCMainTierLevel31 = 256;
        public static final int HEVCMainTierLevel4 = 1024;
        public static final int HEVCMainTierLevel41 = 4096;
        public static final int HEVCMainTierLevel5 = 16384;
        public static final int HEVCMainTierLevel51 = 65536;
        public static final int HEVCMainTierLevel52 = 262144;
        public static final int HEVCMainTierLevel6 = 1048576;
        public static final int HEVCMainTierLevel61 = 4194304;
        public static final int HEVCMainTierLevel62 = 16777216;
        public static final int HEVCProfileMain = 1;
        public static final int HEVCProfileMain10 = 2;
        public static final int MPEG4Level0 = 1;
        public static final int MPEG4Level0b = 2;
        public static final int MPEG4Level1 = 4;
        public static final int MPEG4Level2 = 8;
        public static final int MPEG4Level3 = 16;
        public static final int MPEG4Level4 = 32;
        public static final int MPEG4Level4a = 64;
        public static final int MPEG4Level5 = 128;
        public static final int MPEG4ProfileAdvancedCoding = 4096;
        public static final int MPEG4ProfileAdvancedCore = 8192;
        public static final int MPEG4ProfileAdvancedRealTime = 1024;
        public static final int MPEG4ProfileAdvancedScalable = 16384;
        public static final int MPEG4ProfileAdvancedSimple = 32768;
        public static final int MPEG4ProfileBasicAnimated = 256;
        public static final int MPEG4ProfileCore = 4;
        public static final int MPEG4ProfileCoreScalable = 2048;
        public static final int MPEG4ProfileHybrid = 512;
        public static final int MPEG4ProfileMain = 8;
        public static final int MPEG4ProfileNbit = 16;
        public static final int MPEG4ProfileScalableTexture = 32;
        public static final int MPEG4ProfileSimple = 1;
        public static final int MPEG4ProfileSimpleFBA = 128;
        public static final int MPEG4ProfileSimpleFace = 64;
        public static final int MPEG4ProfileSimpleScalable = 2;
        public static final int VP8Level_Version0 = 1;
        public static final int VP8Level_Version1 = 2;
        public static final int VP8Level_Version2 = 4;
        public static final int VP8Level_Version3 = 8;
        public static final int VP8ProfileMain = 1;
        public int level;
        public int profile;
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaCodecInfo$EncoderCapabilities.class */
    public static final class EncoderCapabilities {
        public static final int BITRATE_MODE_CBR = 2;
        public static final int BITRATE_MODE_CQ = 0;
        public static final int BITRATE_MODE_VBR = 1;
        private static final Feature[] bitrates = {new Feature("VBR", 1, true), new Feature("CBR", 2, false), new Feature("CQ", 0, false)};
        private int mBitControl;
        private Range<Integer> mComplexityRange;
        private Integer mDefaultComplexity;
        private Integer mDefaultQuality;
        private CodecCapabilities mParent;
        private Range<Integer> mQualityRange;
        private String mQualityScale;

        private EncoderCapabilities() {
        }

        private void applyLevelLimits() {
            String mimeType = this.mParent.getMimeType();
            if (mimeType.equalsIgnoreCase("audio/flac")) {
                this.mComplexityRange = Range.create(0, 8);
                this.mBitControl = 1;
            } else if (mimeType.equalsIgnoreCase("audio/3gpp") || mimeType.equalsIgnoreCase("audio/amr-wb") || mimeType.equalsIgnoreCase("audio/g711-alaw") || mimeType.equalsIgnoreCase("audio/g711-mlaw") || mimeType.equalsIgnoreCase("audio/gsm")) {
                this.mBitControl = 4;
            }
        }

        public static EncoderCapabilities create(MediaFormat mediaFormat, CodecCapabilities codecCapabilities) {
            EncoderCapabilities encoderCapabilities = new EncoderCapabilities();
            encoderCapabilities.init(mediaFormat, codecCapabilities);
            return encoderCapabilities;
        }

        private static int parseBitrateMode(String str) {
            Feature[] featureArr = bitrates;
            int length = featureArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return 0;
                }
                Feature feature = featureArr[i2];
                if (feature.mName.equalsIgnoreCase(str)) {
                    return feature.mValue;
                }
                i = i2 + 1;
            }
        }

        /* JADX WARN: Can't wrap try/catch for region: R(14:1|(1:3)|4|(1:6)|7|(9:9|(2:10|(1:12)(0))|14|15|16|17|18|19|20)(0)|13|14|15|16|17|18|19|20) */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void parseFromInfo(android.media.MediaFormat r5) {
            /*
                r4 = this;
                r0 = r5
                java.util.Map r0 = r0.getMap()
                r8 = r0
                r0 = r5
                java.lang.String r1 = "complexity-range"
                boolean r0 = r0.containsKey(r1)
                if (r0 == 0) goto L20
                r0 = r4
                r1 = r5
                java.lang.String r2 = "complexity-range"
                java.lang.String r1 = r1.getString(r2)
                r2 = r4
                android.util.Range<java.lang.Integer> r2 = r2.mComplexityRange
                android.util.Range r1 = android.media.Utils.parseIntRange(r1, r2)
                r0.mComplexityRange = r1
            L20:
                r0 = r5
                java.lang.String r1 = "quality-range"
                boolean r0 = r0.containsKey(r1)
                if (r0 == 0) goto L3a
                r0 = r4
                r1 = r5
                java.lang.String r2 = "quality-range"
                java.lang.String r1 = r1.getString(r2)
                r2 = r4
                android.util.Range<java.lang.Integer> r2 = r2.mQualityRange
                android.util.Range r1 = android.media.Utils.parseIntRange(r1, r2)
                r0.mQualityRange = r1
            L3a:
                r0 = r5
                java.lang.String r1 = "feature-bitrate-control"
                boolean r0 = r0.containsKey(r1)
                if (r0 == 0) goto L73
                r0 = r5
                java.lang.String r1 = "feature-bitrate-control"
                java.lang.String r0 = r0.getString(r1)
                java.lang.String r1 = ","
                java.lang.String[] r0 = r0.split(r1)
                r5 = r0
                r0 = r5
                int r0 = r0.length
                r7 = r0
                r0 = 0
                r6 = r0
            L54:
                r0 = r6
                r1 = r7
                if (r0 >= r1) goto L73
                r0 = r5
                r1 = r6
                r0 = r0[r1]
                r9 = r0
                r0 = r4
                r1 = r4
                int r1 = r1.mBitControl
                r2 = r9
                int r2 = parseBitrateMode(r2)
                r1 = r1 | r2
                r0.mBitControl = r1
                r0 = r6
                r1 = 1
                int r0 = r0 + r1
                r6 = r0
                goto L54
            L73:
                r0 = r4
                r1 = r8
                java.lang.String r2 = "complexity-default"
                java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.NumberFormatException -> Lb4
                java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.NumberFormatException -> Lb4
                int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> Lb4
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.NumberFormatException -> Lb4
                r0.mDefaultComplexity = r1     // Catch: java.lang.NumberFormatException -> Lb4
            L89:
                r0 = r4
                r1 = r8
                java.lang.String r2 = "quality-default"
                java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.NumberFormatException -> Lb0
                java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.NumberFormatException -> Lb0
                int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> Lb0
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.NumberFormatException -> Lb0
                r0.mDefaultQuality = r1     // Catch: java.lang.NumberFormatException -> Lb0
            L9f:
                r0 = r4
                r1 = r8
                java.lang.String r2 = "quality-scale"
                java.lang.Object r1 = r1.get(r2)
                java.lang.String r1 = (java.lang.String) r1
                r0.mQualityScale = r1
                return
            Lb0:
                r5 = move-exception
                goto L9f
            Lb4:
                r5 = move-exception
                goto L89
            */
            throw new UnsupportedOperationException("Method not decompiled: android.media.MediaCodecInfo.EncoderCapabilities.parseFromInfo(android.media.MediaFormat):void");
        }

        private boolean supports(Integer num, Integer num2, Integer num3) {
            Integer num4;
            boolean z = true;
            if (1 != 0) {
                z = true;
                if (num != null) {
                    z = this.mComplexityRange.contains((Range<Integer>) num);
                }
            }
            boolean z2 = z;
            if (z) {
                z2 = z;
                if (num2 != null) {
                    z2 = this.mQualityRange.contains((Range<Integer>) num2);
                }
            }
            boolean z3 = z2;
            if (z2) {
                z3 = z2;
                if (num3 != null) {
                    CodecProfileLevel[] codecProfileLevelArr = this.mParent.profileLevels;
                    int length = codecProfileLevelArr.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        num4 = num3;
                        if (i2 >= length) {
                            break;
                        } else if (codecProfileLevelArr[i2].profile == num3.intValue()) {
                            num4 = null;
                            break;
                        } else {
                            i = i2 + 1;
                        }
                    }
                    if (num4 != null) {
                        return false;
                    }
                    z3 = true;
                }
            }
            return z3;
        }

        public Range<Integer> getComplexityRange() {
            return this.mComplexityRange;
        }

        public Range<Integer> getQualityRange() {
            return this.mQualityRange;
        }

        public void init(MediaFormat mediaFormat, CodecCapabilities codecCapabilities) {
            this.mParent = codecCapabilities;
            this.mComplexityRange = Range.create(0, 0);
            this.mQualityRange = Range.create(0, 0);
            this.mBitControl = 2;
            applyLevelLimits();
            parseFromInfo(mediaFormat);
        }

        public boolean isBitrateModeSupported(int i) {
            Feature[] featureArr = bitrates;
            int length = featureArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return false;
                }
                if (i == featureArr[i3].mValue) {
                    return (this.mBitControl & (1 << i)) != 0;
                }
                i2 = i3 + 1;
            }
        }

        public void setDefaultFormat(MediaFormat mediaFormat) {
            if (!this.mQualityRange.getUpper().equals(this.mQualityRange.getLower()) && this.mDefaultQuality != null) {
                mediaFormat.setInteger(MediaFormat.KEY_QUALITY, this.mDefaultQuality.intValue());
            }
            if (!this.mComplexityRange.getUpper().equals(this.mComplexityRange.getLower()) && this.mDefaultComplexity != null) {
                mediaFormat.setInteger(MediaFormat.KEY_COMPLEXITY, this.mDefaultComplexity.intValue());
            }
            Feature[] featureArr = bitrates;
            int length = featureArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                Feature feature = featureArr[i2];
                if ((this.mBitControl & (1 << feature.mValue)) != 0) {
                    mediaFormat.setInteger(MediaFormat.KEY_BITRATE_MODE, feature.mValue);
                    return;
                }
                i = i2 + 1;
            }
        }

        public boolean supportsFormat(MediaFormat mediaFormat) {
            Map<String, Object> map = mediaFormat.getMap();
            String mimeType = this.mParent.getMimeType();
            Integer num = (Integer) map.get(MediaFormat.KEY_BITRATE_MODE);
            if (num == null || isBitrateModeSupported(num.intValue())) {
                Integer num2 = (Integer) map.get(MediaFormat.KEY_COMPLEXITY);
                Integer num3 = num2;
                if ("audio/flac".equalsIgnoreCase(mimeType)) {
                    Integer num4 = (Integer) map.get(MediaFormat.KEY_FLAC_COMPRESSION_LEVEL);
                    if (num2 == null) {
                        num3 = num4;
                    } else {
                        num3 = num2;
                        if (num4 != null) {
                            num3 = num2;
                            if (num2 != num4) {
                                throw new IllegalArgumentException("conflicting values for complexity and flac-compression-level");
                            }
                        }
                    }
                }
                Integer num5 = (Integer) map.get(MediaFormat.KEY_PROFILE);
                Integer num6 = num5;
                if ("audio/mp4a-latm".equalsIgnoreCase(mimeType)) {
                    Integer num7 = (Integer) map.get(MediaFormat.KEY_AAC_PROFILE);
                    if (num5 == null) {
                        num6 = num7;
                    } else {
                        num6 = num5;
                        if (num7 != null) {
                            num6 = num5;
                            if (num7 != num5) {
                                throw new IllegalArgumentException("conflicting values for profile and aac-profile");
                            }
                        }
                    }
                }
                return supports(num3, (Integer) map.get(MediaFormat.KEY_QUALITY), num6);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaCodecInfo$Feature.class */
    public static class Feature {
        public boolean mDefault;
        public String mName;
        public int mValue;

        public Feature(String str, int i, boolean z) {
            this.mName = str;
            this.mValue = i;
            this.mDefault = z;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaCodecInfo$VideoCapabilities.class */
    public static final class VideoCapabilities {
        private static final String TAG = "VideoCapabilities";
        private Range<Rational> mAspectRatioRange;
        private Range<Integer> mBitrateRange;
        private Range<Rational> mBlockAspectRatioRange;
        private Range<Integer> mBlockCountRange;
        private int mBlockHeight;
        private int mBlockWidth;
        private Range<Long> mBlocksPerSecondRange;
        private Range<Integer> mFrameRateRange;
        private int mHeightAlignment;
        private Range<Integer> mHeightRange;
        private Range<Integer> mHorizontalBlockRange;
        private CodecCapabilities mParent;
        private int mSmallerDimensionUpperLimit;
        private Range<Integer> mVerticalBlockRange;
        private int mWidthAlignment;
        private Range<Integer> mWidthRange;

        private VideoCapabilities() {
        }

        private void applyAlignment(int i, int i2) {
            MediaCodecInfo.checkPowerOfTwo(i, "widthAlignment must be a power of two");
            MediaCodecInfo.checkPowerOfTwo(i2, "heightAlignment must be a power of two");
            if (i > this.mBlockWidth || i2 > this.mBlockHeight) {
                applyBlockLimits(Math.max(i, this.mBlockWidth), Math.max(i2, this.mBlockHeight), MediaCodecInfo.POSITIVE_INTEGERS, MediaCodecInfo.POSITIVE_LONGS, MediaCodecInfo.POSITIVE_RATIONALS);
            }
            this.mWidthAlignment = Math.max(i, this.mWidthAlignment);
            this.mHeightAlignment = Math.max(i2, this.mHeightAlignment);
            this.mWidthRange = Utils.alignRange(this.mWidthRange, this.mWidthAlignment);
            this.mHeightRange = Utils.alignRange(this.mHeightRange, this.mHeightAlignment);
        }

        private void applyBlockLimits(int i, int i2, Range<Integer> range, Range<Long> range2, Range<Rational> range3) {
            MediaCodecInfo.checkPowerOfTwo(i, "blockWidth must be a power of two");
            MediaCodecInfo.checkPowerOfTwo(i2, "blockHeight must be a power of two");
            int max = Math.max(i, this.mBlockWidth);
            int max2 = Math.max(i2, this.mBlockHeight);
            int i3 = ((max * max2) / this.mBlockWidth) / this.mBlockHeight;
            if (i3 != 1) {
                this.mBlockCountRange = Utils.factorRange(this.mBlockCountRange, i3);
                this.mBlocksPerSecondRange = Utils.factorRange(this.mBlocksPerSecondRange, i3);
                this.mBlockAspectRatioRange = Utils.scaleRange(this.mBlockAspectRatioRange, max2 / this.mBlockHeight, max / this.mBlockWidth);
                this.mHorizontalBlockRange = Utils.factorRange(this.mHorizontalBlockRange, max / this.mBlockWidth);
                this.mVerticalBlockRange = Utils.factorRange(this.mVerticalBlockRange, max2 / this.mBlockHeight);
            }
            int i4 = ((max * max2) / i) / i2;
            Range<Integer> range4 = range;
            Range<Long> range5 = range2;
            Range<Rational> range6 = range3;
            if (i4 != 1) {
                range4 = Utils.factorRange(range, i4);
                range5 = Utils.factorRange(range2, i4);
                range6 = Utils.scaleRange(range3, max2 / i2, max / i);
            }
            this.mBlockCountRange = this.mBlockCountRange.intersect(range4);
            this.mBlocksPerSecondRange = this.mBlocksPerSecondRange.intersect(range5);
            this.mBlockAspectRatioRange = this.mBlockAspectRatioRange.intersect(range6);
            this.mBlockWidth = max;
            this.mBlockHeight = max2;
        }

        private void applyLevelLimits() {
            int i;
            int i2;
            boolean z;
            int i3 = 4;
            CodecProfileLevel[] codecProfileLevelArr = this.mParent.profileLevels;
            String mimeType = this.mParent.getMimeType();
            if (mimeType.equalsIgnoreCase("video/avc")) {
                int i4 = 99;
                int i5 = 1485;
                int i6 = 64000;
                int i7 = 396;
                int length = codecProfileLevelArr.length;
                int i8 = 0;
                int i9 = 4;
                while (true) {
                    int i10 = i9;
                    if (i8 < length) {
                        CodecProfileLevel codecProfileLevel = codecProfileLevelArr[i8];
                        int i11 = 0;
                        int i12 = 0;
                        int i13 = 0;
                        int i14 = 0;
                        boolean z2 = true;
                        switch (codecProfileLevel.level) {
                            case 1:
                                i11 = 1485;
                                i12 = 99;
                                i13 = 64;
                                i14 = 396;
                                break;
                            case 2:
                                i11 = 1485;
                                i12 = 99;
                                i13 = 128;
                                i14 = 396;
                                break;
                            case 4:
                                i11 = 3000;
                                i12 = 396;
                                i13 = 192;
                                i14 = 900;
                                break;
                            case 8:
                                i11 = 6000;
                                i12 = 396;
                                i13 = 384;
                                i14 = 2376;
                                break;
                            case 16:
                                i11 = 11880;
                                i12 = 396;
                                i13 = 768;
                                i14 = 2376;
                                break;
                            case 32:
                                i11 = 11880;
                                i12 = 396;
                                i13 = 2000;
                                i14 = 2376;
                                break;
                            case 64:
                                i11 = 19800;
                                i12 = 792;
                                i13 = 4000;
                                i14 = 4752;
                                break;
                            case 128:
                                i11 = 20250;
                                i12 = 1620;
                                i13 = 4000;
                                i14 = 8100;
                                break;
                            case 256:
                                i11 = 40500;
                                i12 = 1620;
                                i13 = 10000;
                                i14 = 8100;
                                break;
                            case 512:
                                i11 = 108000;
                                i12 = 3600;
                                i13 = 14000;
                                i14 = 18000;
                                break;
                            case 1024:
                                i11 = 216000;
                                i12 = 5120;
                                i13 = 20000;
                                i14 = 20480;
                                break;
                            case 2048:
                                i11 = 245760;
                                i12 = 8192;
                                i13 = 20000;
                                i14 = 32768;
                                break;
                            case 4096:
                                i11 = 245760;
                                i12 = 8192;
                                i13 = 50000;
                                i14 = 32768;
                                break;
                            case 8192:
                                i11 = 522240;
                                i12 = 8704;
                                i13 = 50000;
                                i14 = 34816;
                                break;
                            case 16384:
                                i11 = 589824;
                                i12 = 22080;
                                i13 = 135000;
                                i14 = 110400;
                                break;
                            case 32768:
                                i11 = 983040;
                                i12 = 36864;
                                i13 = 240000;
                                i14 = 184320;
                                break;
                            case 65536:
                                i11 = 2073600;
                                i12 = 36864;
                                i13 = 240000;
                                i14 = 184320;
                                break;
                            default:
                                Log.w(TAG, "Unrecognized level " + codecProfileLevel.level + " for " + mimeType);
                                i10 |= 1;
                                break;
                        }
                        int i15 = i10;
                        switch (codecProfileLevel.profile) {
                            case 4:
                            case 32:
                            case 64:
                                Log.w(TAG, "Unsupported profile " + codecProfileLevel.profile + " for " + mimeType);
                                i15 = i10 | 2;
                                z2 = false;
                            case 1:
                            case 2:
                                i2 = i13 * 1000;
                                i10 = i15;
                                z = z2;
                                break;
                            case 8:
                                i2 = i13 * 1250;
                                z = true;
                                break;
                            case 16:
                                i2 = i13 * 3000;
                                z = true;
                                break;
                            default:
                                Log.w(TAG, "Unrecognized profile " + codecProfileLevel.profile + " for " + mimeType);
                                i10 |= 1;
                                i2 = i13 * 1000;
                                z = true;
                                break;
                        }
                        int i16 = i10;
                        if (z) {
                            i16 = i10 & (-5);
                        }
                        i5 = Math.max(i11, i5);
                        i4 = Math.max(i12, i4);
                        i6 = Math.max(i2, i6);
                        i7 = Math.max(i7, i14);
                        i8++;
                        i9 = i16;
                    } else {
                        int sqrt = (int) Math.sqrt(i4 * 8);
                        applyMacroBlockLimits(sqrt, sqrt, i4, i5, 16, 16, 1, 1);
                        i = i6;
                        i3 = i10;
                    }
                }
            } else if (mimeType.equalsIgnoreCase("video/mp4v-es")) {
                int i17 = 11;
                int i18 = 9;
                int i19 = 15;
                int i20 = 99;
                int i21 = 1485;
                int i22 = 64000;
                int length2 = codecProfileLevelArr.length;
                int i23 = 0;
                int i24 = 4;
                while (true) {
                    int i25 = i24;
                    if (i23 < length2) {
                        CodecProfileLevel codecProfileLevel2 = codecProfileLevelArr[i23];
                        int i26 = 0;
                        int i27 = 0;
                        int i28 = 0;
                        int i29 = 0;
                        int i30 = 0;
                        int i31 = 0;
                        boolean z3 = true;
                        switch (codecProfileLevel2.profile) {
                            case 1:
                                switch (codecProfileLevel2.level) {
                                    case 1:
                                        i29 = 15;
                                        i30 = 11;
                                        i31 = 9;
                                        i26 = 1485;
                                        i27 = 99;
                                        i28 = 64;
                                        break;
                                    case 2:
                                        i29 = 30;
                                        i30 = 11;
                                        i31 = 9;
                                        i26 = 1485;
                                        i27 = 99;
                                        i28 = 128;
                                        break;
                                    case 4:
                                        i29 = 30;
                                        i30 = 11;
                                        i31 = 9;
                                        i26 = 1485;
                                        i27 = 99;
                                        i28 = 64;
                                        break;
                                    case 8:
                                        i29 = 30;
                                        i30 = 22;
                                        i31 = 18;
                                        i26 = 5940;
                                        i27 = 396;
                                        i28 = 128;
                                        break;
                                    case 16:
                                        i29 = 30;
                                        i30 = 22;
                                        i31 = 18;
                                        i26 = 11880;
                                        i27 = 396;
                                        i28 = 384;
                                        break;
                                    case 32:
                                    case 64:
                                    case 128:
                                        i29 = 30;
                                        i30 = 22;
                                        i31 = 18;
                                        i26 = 11880;
                                        i27 = 396;
                                        i28 = 384;
                                        z3 = false;
                                        break;
                                    default:
                                        Log.w(TAG, "Unrecognized profile/level " + codecProfileLevel2.profile + "/" + codecProfileLevel2.level + " for " + mimeType);
                                        i25 |= 1;
                                        break;
                                }
                            case 2:
                            case 4:
                            case 8:
                            case 16:
                            case 32:
                            case 64:
                            case 128:
                            case 256:
                            case 512:
                            case 1024:
                            case 2048:
                            case 4096:
                            case 8192:
                            case 16384:
                                Log.i(TAG, "Unsupported profile " + codecProfileLevel2.profile + " for " + mimeType);
                                i25 |= 2;
                                z3 = false;
                                break;
                            case 32768:
                                switch (codecProfileLevel2.level) {
                                    case 1:
                                    case 4:
                                        i29 = 30;
                                        i30 = 11;
                                        i31 = 9;
                                        i26 = 2970;
                                        i27 = 99;
                                        i28 = 128;
                                        break;
                                    case 8:
                                        i29 = 30;
                                        i30 = 22;
                                        i31 = 18;
                                        i26 = 5940;
                                        i27 = 396;
                                        i28 = 384;
                                        break;
                                    case 16:
                                        i29 = 30;
                                        i30 = 22;
                                        i31 = 18;
                                        i26 = 11880;
                                        i27 = 396;
                                        i28 = 768;
                                        break;
                                    case 32:
                                    case 64:
                                        i29 = 30;
                                        i30 = 44;
                                        i31 = 36;
                                        i26 = 23760;
                                        i27 = 792;
                                        i28 = 3000;
                                        break;
                                    case 128:
                                        i29 = 30;
                                        i30 = 45;
                                        i31 = 36;
                                        i26 = 48600;
                                        i27 = 1620;
                                        i28 = 8000;
                                        break;
                                    default:
                                        Log.w(TAG, "Unrecognized profile/level " + codecProfileLevel2.profile + "/" + codecProfileLevel2.level + " for " + mimeType);
                                        i25 |= 1;
                                        break;
                                }
                            default:
                                Log.w(TAG, "Unrecognized profile " + codecProfileLevel2.profile + " for " + mimeType);
                                i25 |= 1;
                                break;
                        }
                        int i32 = i25;
                        if (z3) {
                            i32 = i25 & (-5);
                        }
                        i21 = Math.max(i26, i21);
                        i20 = Math.max(i27, i20);
                        i22 = Math.max(i28 * 1000, i22);
                        i17 = Math.max(i30, i17);
                        i18 = Math.max(i31, i18);
                        i19 = Math.max(i29, i19);
                        i23++;
                        i24 = i32;
                    } else {
                        applyMacroBlockLimits(i17, i18, i20, i21, 16, 16, 1, 1);
                        this.mFrameRateRange = this.mFrameRateRange.intersect(12, Integer.valueOf(i19));
                        i3 = i25;
                        i = i22;
                    }
                }
            } else if (mimeType.equalsIgnoreCase("video/3gpp")) {
                int i33 = 11;
                int i34 = 9;
                int i35 = 15;
                int i36 = 99;
                int i37 = 1485;
                int i38 = 64000;
                int i39 = 4;
                for (CodecProfileLevel codecProfileLevel3 : codecProfileLevelArr) {
                    int i40 = 0;
                    int i41 = 0;
                    int i42 = 0;
                    int i43 = 0;
                    int i44 = 0;
                    switch (codecProfileLevel3.level) {
                        case 1:
                            i42 = 15;
                            i43 = 11;
                            i44 = 9;
                            i41 = 1;
                            i40 = 15 * 99;
                            break;
                        case 2:
                            i42 = 30;
                            i43 = 22;
                            i44 = 18;
                            i41 = 2;
                            i40 = 30 * ChatRoomProtos.Event.YY_LIFT_MASK_POP_CANCEL_CLICK_VALUE;
                            break;
                        case 4:
                            i42 = 30;
                            i43 = 22;
                            i44 = 18;
                            i41 = 6;
                            i40 = 30 * ChatRoomProtos.Event.YY_LIFT_MASK_POP_CANCEL_CLICK_VALUE;
                            break;
                        case 8:
                            i42 = 30;
                            i43 = 22;
                            i44 = 18;
                            i41 = 32;
                            i40 = 30 * ChatRoomProtos.Event.YY_LIFT_MASK_POP_CANCEL_CLICK_VALUE;
                            break;
                        case 16:
                            i42 = 30;
                            i43 = 11;
                            i44 = 9;
                            i41 = 2;
                            i40 = 30 * 99;
                            break;
                        case 32:
                            i42 = 60;
                            i43 = 22;
                            i44 = 18;
                            i41 = 64;
                            i40 = ChatRoomProtos.Event.YY_LIFT_MASK_POP_CANCEL_CLICK_VALUE * 50;
                            break;
                        case 64:
                            i42 = 60;
                            i43 = 45;
                            i44 = 18;
                            i41 = 128;
                            i40 = 810 * 50;
                            break;
                        case 128:
                            i42 = 60;
                            i43 = 45;
                            i44 = 36;
                            i41 = 256;
                            i40 = 1620 * 50;
                            break;
                        default:
                            Log.w(TAG, "Unrecognized profile/level " + codecProfileLevel3.profile + "/" + codecProfileLevel3.level + " for " + mimeType);
                            i39 |= 1;
                            break;
                    }
                    int i45 = i39;
                    switch (codecProfileLevel3.profile) {
                        case 1:
                        case 2:
                        case 4:
                        case 8:
                        case 16:
                        case 32:
                        case 64:
                        case 128:
                        case 256:
                            break;
                        default:
                            Log.w(TAG, "Unrecognized profile " + codecProfileLevel3.profile + " for " + mimeType);
                            i45 = i39 | 1;
                            break;
                    }
                    i39 = i45 & (-5);
                    i37 = Math.max(i40, i37);
                    i36 = Math.max(i43 * i44, i36);
                    i38 = Math.max(64000 * i41, i38);
                    i33 = Math.max(i43, i33);
                    i34 = Math.max(i44, i34);
                    i35 = Math.max(i42, i35);
                }
                applyMacroBlockLimits(i33, i34, i36, i37, 16, 16, 1, 1);
                this.mFrameRateRange = Range.create(1, Integer.valueOf(i35));
                i3 = i39;
                i = i38;
            } else if (mimeType.equalsIgnoreCase("video/x-vnd.on2.vp8") || mimeType.equalsIgnoreCase("video/x-vnd.on2.vp9")) {
                int length3 = codecProfileLevelArr.length;
                int i46 = 0;
                while (true) {
                    int i47 = i46;
                    if (i47 < length3) {
                        CodecProfileLevel codecProfileLevel4 = codecProfileLevelArr[i47];
                        int i48 = i3;
                        switch (codecProfileLevel4.level) {
                            case 1:
                            case 2:
                            case 4:
                            case 8:
                                break;
                            case 3:
                            case 5:
                            case 6:
                            case 7:
                            default:
                                Log.w(TAG, "Unrecognized level " + codecProfileLevel4.level + " for " + mimeType);
                                i48 = i3 | 1;
                                break;
                        }
                        int i49 = i48;
                        switch (codecProfileLevel4.profile) {
                            case 1:
                                break;
                            default:
                                Log.w(TAG, "Unrecognized profile " + codecProfileLevel4.profile + " for " + mimeType);
                                i49 = i48 | 1;
                                break;
                        }
                        i3 = i49 & (-5);
                        i46 = i47 + 1;
                    } else {
                        int i50 = mimeType.equalsIgnoreCase("video/x-vnd.on2.vp8") ? 16 : 8;
                        applyMacroBlockLimits(32767, 32767, Integer.MAX_VALUE, Integer.MAX_VALUE, i50, i50, 1, 1);
                        i = 100000000;
                    }
                }
            } else if (mimeType.equalsIgnoreCase("video/hevc")) {
                int i51 = 36864;
                int i52 = 36864 * 15;
                int i53 = 128000;
                int i54 = 4;
                for (CodecProfileLevel codecProfileLevel5 : codecProfileLevelArr) {
                    double d = 0.0d;
                    int i55 = 0;
                    int i56 = 0;
                    switch (codecProfileLevel5.level) {
                        case 1:
                        case 2:
                            d = 15.0d;
                            i55 = 36864;
                            i56 = 128;
                            break;
                        case 4:
                        case 8:
                            d = 30.0d;
                            i55 = 122880;
                            i56 = 1500;
                            break;
                        case 16:
                        case 32:
                            d = 30.0d;
                            i55 = 245760;
                            i56 = 3000;
                            break;
                        case 64:
                        case 128:
                            d = 30.0d;
                            i55 = 552960;
                            i56 = 6000;
                            break;
                        case 256:
                        case 512:
                            d = 33.75d;
                            i55 = 983040;
                            i56 = 10000;
                            break;
                        case 1024:
                            d = 30.0d;
                            i55 = 2228224;
                            i56 = 12000;
                            break;
                        case 2048:
                            d = 30.0d;
                            i55 = 2228224;
                            i56 = 30000;
                            break;
                        case 4096:
                            d = 60.0d;
                            i55 = 2228224;
                            i56 = 20000;
                            break;
                        case 8192:
                            d = 60.0d;
                            i55 = 2228224;
                            i56 = 50000;
                            break;
                        case 16384:
                            d = 30.0d;
                            i55 = 8912896;
                            i56 = 25000;
                            break;
                        case 32768:
                            d = 30.0d;
                            i55 = 8912896;
                            i56 = 100000;
                            break;
                        case 65536:
                            d = 60.0d;
                            i55 = 8912896;
                            i56 = 40000;
                            break;
                        case 131072:
                            d = 60.0d;
                            i55 = 8912896;
                            i56 = 160000;
                            break;
                        case 262144:
                            d = 120.0d;
                            i55 = 8912896;
                            i56 = 60000;
                            break;
                        case 524288:
                            d = 120.0d;
                            i55 = 8912896;
                            i56 = 240000;
                            break;
                        case 1048576:
                            d = 30.0d;
                            i55 = 35651584;
                            i56 = 60000;
                            break;
                        case 2097152:
                            d = 30.0d;
                            i55 = 35651584;
                            i56 = 240000;
                            break;
                        case 4194304:
                            d = 60.0d;
                            i55 = 35651584;
                            i56 = 120000;
                            break;
                        case 8388608:
                            d = 60.0d;
                            i55 = 35651584;
                            i56 = 480000;
                            break;
                        case 16777216:
                            d = 120.0d;
                            i55 = 35651584;
                            i56 = 240000;
                            break;
                        case 33554432:
                            d = 120.0d;
                            i55 = 35651584;
                            i56 = 800000;
                            break;
                        default:
                            Log.w(TAG, "Unrecognized level " + codecProfileLevel5.level + " for " + mimeType);
                            i54 |= 1;
                            break;
                    }
                    int i57 = i54;
                    switch (codecProfileLevel5.profile) {
                        case 1:
                        case 2:
                            break;
                        default:
                            Log.w(TAG, "Unrecognized profile " + codecProfileLevel5.profile + " for " + mimeType);
                            i57 = i54 | 1;
                            break;
                    }
                    i54 = i57 & (-5);
                    i52 = Math.max((int) (i55 * d), i52);
                    i51 = Math.max(i55, i51);
                    i53 = Math.max(i56 * 1000, i53);
                }
                int sqrt2 = (int) Math.sqrt(i51 * 8);
                int divUp = Utils.divUp(i51, 64);
                int divUp2 = Utils.divUp(i52, 64);
                int divUp3 = Utils.divUp(sqrt2, 8);
                applyMacroBlockLimits(divUp3, divUp3, divUp, divUp2, 8, 8, 1, 1);
                i3 = i54;
                i = i53;
            } else {
                Log.w(TAG, "Unsupported mime " + mimeType);
                i = 64000;
                i3 = 4 | 2;
            }
            this.mBitrateRange = Range.create(1, Integer.valueOf(i));
            this.mParent.mError |= i3;
        }

        private void applyMacroBlockLimits(int i, int i2, int i3, long j, int i4, int i5, int i6, int i7) {
            applyAlignment(i6, i7);
            applyBlockLimits(i4, i5, Range.create(1, Integer.valueOf(i3)), Range.create(1L, Long.valueOf(j)), Range.create(new Rational(1, i2), new Rational(i, 1)));
            this.mHorizontalBlockRange = this.mHorizontalBlockRange.intersect(1, Integer.valueOf(i / (this.mBlockWidth / i4)));
            this.mVerticalBlockRange = this.mVerticalBlockRange.intersect(1, Integer.valueOf(i2 / (this.mBlockHeight / i5)));
        }

        public static VideoCapabilities create(MediaFormat mediaFormat, CodecCapabilities codecCapabilities) {
            VideoCapabilities videoCapabilities = new VideoCapabilities();
            videoCapabilities.init(mediaFormat, codecCapabilities);
            return videoCapabilities;
        }

        private void initWithPlatformLimits() {
            this.mBitrateRange = MediaCodecInfo.BITRATE_RANGE;
            this.mWidthRange = MediaCodecInfo.SIZE_RANGE;
            this.mHeightRange = MediaCodecInfo.SIZE_RANGE;
            this.mFrameRateRange = MediaCodecInfo.FRAME_RATE_RANGE;
            this.mHorizontalBlockRange = MediaCodecInfo.SIZE_RANGE;
            this.mVerticalBlockRange = MediaCodecInfo.SIZE_RANGE;
            this.mBlockCountRange = MediaCodecInfo.POSITIVE_INTEGERS;
            this.mBlocksPerSecondRange = MediaCodecInfo.POSITIVE_LONGS;
            this.mBlockAspectRatioRange = MediaCodecInfo.POSITIVE_RATIONALS;
            this.mAspectRatioRange = MediaCodecInfo.POSITIVE_RATIONALS;
            this.mWidthAlignment = 2;
            this.mHeightAlignment = 2;
            this.mBlockWidth = 2;
            this.mBlockHeight = 2;
            this.mSmallerDimensionUpperLimit = ((Integer) MediaCodecInfo.SIZE_RANGE.getUpper()).intValue();
        }

        private void parseFromInfo(MediaFormat mediaFormat) {
            Map<String, Object> map = mediaFormat.getMap();
            Size size = new Size(this.mBlockWidth, this.mBlockHeight);
            Size size2 = new Size(this.mWidthAlignment, this.mHeightAlignment);
            Range<Integer> range = null;
            Range<Integer> range2 = null;
            Size parseSize = Utils.parseSize(map.get("block-size"), size);
            Size parseSize2 = Utils.parseSize(map.get("alignment"), size2);
            Range<Integer> parseIntRange = Utils.parseIntRange(map.get("block-count-range"), null);
            Range<Long> parseLongRange = Utils.parseLongRange(map.get("blocks-per-second-range"), null);
            Object obj = map.get("size-range");
            Pair<Size, Size> parseSizeRange = Utils.parseSizeRange(obj);
            if (parseSizeRange != null) {
                try {
                    range = Range.create(Integer.valueOf(parseSizeRange.first.getWidth()), Integer.valueOf(parseSizeRange.second.getWidth()));
                    range2 = Range.create(Integer.valueOf(parseSizeRange.first.getHeight()), Integer.valueOf(parseSizeRange.second.getHeight()));
                } catch (IllegalArgumentException e) {
                    Log.w(TAG, "could not parse size range '" + obj + "'");
                    range = null;
                    range2 = null;
                }
            }
            Range<Integer> range3 = range2;
            Range<Integer> range4 = range;
            Integer num = 1;
            if (num.equals(map.get("feature-can-swap-width-height"))) {
                if (range != null) {
                    this.mSmallerDimensionUpperLimit = Math.min(range.getUpper().intValue(), range2.getUpper().intValue());
                    range3 = range.extend(range2);
                    range4 = range3;
                } else {
                    Log.w(TAG, "feature can-swap-width-height is best used with size-range");
                    this.mSmallerDimensionUpperLimit = Math.min(this.mWidthRange.getUpper().intValue(), this.mHeightRange.getUpper().intValue());
                    Range<Integer> extend = this.mWidthRange.extend(this.mHeightRange);
                    this.mHeightRange = extend;
                    this.mWidthRange = extend;
                    range3 = range2;
                    range4 = range;
                }
            }
            Range<Rational> parseRationalRange = Utils.parseRationalRange(map.get("block-aspect-ratio-range"), null);
            Range<Rational> parseRationalRange2 = Utils.parseRationalRange(map.get("pixel-aspect-ratio-range"), null);
            Range<Integer> parseIntRange2 = Utils.parseIntRange(map.get("frame-rate-range"), null);
            Range<Integer> range5 = parseIntRange2;
            if (parseIntRange2 != null) {
                try {
                    range5 = parseIntRange2.intersect(MediaCodecInfo.FRAME_RATE_RANGE);
                } catch (IllegalArgumentException e2) {
                    Log.w(TAG, "frame rate range (" + parseIntRange2 + ") is out of limits: " + MediaCodecInfo.FRAME_RATE_RANGE);
                    range5 = null;
                }
            }
            Range<Integer> parseIntRange3 = Utils.parseIntRange(map.get("bitrate-range"), null);
            Range<Integer> range6 = parseIntRange3;
            if (parseIntRange3 != null) {
                try {
                    range6 = parseIntRange3.intersect(MediaCodecInfo.BITRATE_RANGE);
                } catch (IllegalArgumentException e3) {
                    Log.w(TAG, "bitrate range (" + parseIntRange3 + ") is out of limits: " + MediaCodecInfo.BITRATE_RANGE);
                    range6 = null;
                }
            }
            MediaCodecInfo.checkPowerOfTwo(parseSize.getWidth(), "block-size width must be power of two");
            MediaCodecInfo.checkPowerOfTwo(parseSize.getHeight(), "block-size height must be power of two");
            MediaCodecInfo.checkPowerOfTwo(parseSize2.getWidth(), "alignment width must be power of two");
            MediaCodecInfo.checkPowerOfTwo(parseSize2.getHeight(), "alignment height must be power of two");
            applyMacroBlockLimits(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Long.MAX_VALUE, parseSize.getWidth(), parseSize.getHeight(), parseSize2.getWidth(), parseSize2.getHeight());
            if ((this.mParent.mError & 2) != 0) {
                if (range4 != null) {
                    this.mWidthRange = MediaCodecInfo.SIZE_RANGE.intersect(range4);
                }
                if (range3 != null) {
                    this.mHeightRange = MediaCodecInfo.SIZE_RANGE.intersect(range3);
                }
                if (parseIntRange != null) {
                    this.mBlockCountRange = MediaCodecInfo.POSITIVE_INTEGERS.intersect(Utils.factorRange(parseIntRange, ((this.mBlockWidth * this.mBlockHeight) / parseSize.getWidth()) / parseSize.getHeight()));
                }
                if (parseLongRange != null) {
                    this.mBlocksPerSecondRange = MediaCodecInfo.POSITIVE_LONGS.intersect(Utils.factorRange(parseLongRange, ((this.mBlockWidth * this.mBlockHeight) / parseSize.getWidth()) / parseSize.getHeight()));
                }
                if (parseRationalRange2 != null) {
                    this.mBlockAspectRatioRange = MediaCodecInfo.POSITIVE_RATIONALS.intersect(Utils.scaleRange(parseRationalRange2, this.mBlockHeight / parseSize.getHeight(), this.mBlockWidth / parseSize.getWidth()));
                }
                if (parseRationalRange != null) {
                    this.mAspectRatioRange = MediaCodecInfo.POSITIVE_RATIONALS.intersect(parseRationalRange);
                }
                if (range5 != null) {
                    this.mFrameRateRange = MediaCodecInfo.FRAME_RATE_RANGE.intersect(range5);
                }
                if (range6 != null) {
                    this.mBitrateRange = MediaCodecInfo.BITRATE_RANGE.intersect(range6);
                }
            } else {
                if (range4 != null) {
                    this.mWidthRange = this.mWidthRange.intersect(range4);
                }
                if (range3 != null) {
                    this.mHeightRange = this.mHeightRange.intersect(range3);
                }
                if (parseIntRange != null) {
                    this.mBlockCountRange = this.mBlockCountRange.intersect(Utils.factorRange(parseIntRange, ((this.mBlockWidth * this.mBlockHeight) / parseSize.getWidth()) / parseSize.getHeight()));
                }
                if (parseLongRange != null) {
                    this.mBlocksPerSecondRange = this.mBlocksPerSecondRange.intersect(Utils.factorRange(parseLongRange, ((this.mBlockWidth * this.mBlockHeight) / parseSize.getWidth()) / parseSize.getHeight()));
                }
                if (parseRationalRange2 != null) {
                    this.mBlockAspectRatioRange = this.mBlockAspectRatioRange.intersect(Utils.scaleRange(parseRationalRange2, this.mBlockHeight / parseSize.getHeight(), this.mBlockWidth / parseSize.getWidth()));
                }
                if (parseRationalRange != null) {
                    this.mAspectRatioRange = this.mAspectRatioRange.intersect(parseRationalRange);
                }
                if (range5 != null) {
                    this.mFrameRateRange = this.mFrameRateRange.intersect(range5);
                }
                if (range6 != null) {
                    this.mBitrateRange = this.mBitrateRange.intersect(range6);
                }
            }
            updateLimits();
        }

        private boolean supports(Integer num, Integer num2, Number number) {
            boolean z = true;
            if (1 != 0) {
                z = true;
                if (num != null) {
                    z = this.mWidthRange.contains((Range<Integer>) num) && num.intValue() % this.mWidthAlignment == 0;
                }
            }
            boolean z2 = z;
            if (z) {
                z2 = z;
                if (num2 != null) {
                    z2 = this.mHeightRange.contains((Range<Integer>) num2) && num2.intValue() % this.mHeightAlignment == 0;
                }
            }
            boolean z3 = z2;
            if (z2) {
                z3 = z2;
                if (number != null) {
                    z3 = this.mFrameRateRange.contains(Utils.intRangeFor(number.doubleValue()));
                }
            }
            boolean z4 = z3;
            if (z3) {
                z4 = z3;
                if (num2 != null) {
                    z4 = z3;
                    if (num != null) {
                        boolean z5 = Math.min(num2.intValue(), num.intValue()) <= this.mSmallerDimensionUpperLimit;
                        int divUp = Utils.divUp(num.intValue(), this.mBlockWidth);
                        int divUp2 = Utils.divUp(num2.intValue(), this.mBlockHeight);
                        int i = divUp * divUp2;
                        boolean z6 = z5 && this.mBlockCountRange.contains((Range<Integer>) Integer.valueOf(i)) && this.mBlockAspectRatioRange.contains((Range<Rational>) new Rational(divUp, divUp2)) && this.mAspectRatioRange.contains((Range<Rational>) new Rational(num.intValue(), num2.intValue()));
                        z4 = z6;
                        if (z6) {
                            z4 = z6;
                            if (number != null) {
                                z4 = this.mBlocksPerSecondRange.contains(Utils.longRangeFor(i * number.doubleValue()));
                            }
                        }
                    }
                }
            }
            return z4;
        }

        private void updateLimits() {
            throw new VerifyError("bad dex opcode");
        }

        public boolean areSizeAndRateSupported(int i, int i2, double d) {
            return supports(Integer.valueOf(i), Integer.valueOf(i2), Double.valueOf(d));
        }

        public Range<Rational> getAspectRatioRange(boolean z) {
            return z ? this.mBlockAspectRatioRange : this.mAspectRatioRange;
        }

        public Range<Integer> getBitrateRange() {
            return this.mBitrateRange;
        }

        public Range<Integer> getBlockCountRange() {
            return this.mBlockCountRange;
        }

        public Size getBlockSize() {
            return new Size(this.mBlockWidth, this.mBlockHeight);
        }

        public Range<Long> getBlocksPerSecondRange() {
            return this.mBlocksPerSecondRange;
        }

        public int getHeightAlignment() {
            return this.mHeightAlignment;
        }

        public int getSmallerDimensionUpperLimit() {
            return this.mSmallerDimensionUpperLimit;
        }

        public Range<Integer> getSupportedFrameRates() {
            return this.mFrameRateRange;
        }

        public Range<Double> getSupportedFrameRatesFor(int i, int i2) {
            Range<Integer> range = this.mHeightRange;
            if (supports(Integer.valueOf(i), Integer.valueOf(i2), null)) {
                int divUp = Utils.divUp(i, this.mBlockWidth) * Utils.divUp(i2, this.mBlockHeight);
                return Range.create(Double.valueOf(Math.max(this.mBlocksPerSecondRange.getLower().longValue() / divUp, this.mFrameRateRange.getLower().intValue())), Double.valueOf(Math.min(this.mBlocksPerSecondRange.getUpper().longValue() / divUp, this.mFrameRateRange.getUpper().intValue())));
            }
            throw new IllegalArgumentException("unsupported size");
        }

        public Range<Integer> getSupportedHeights() {
            return this.mHeightRange;
        }

        public Range<Integer> getSupportedHeightsFor(int i) {
            try {
                Range<Integer> range = this.mHeightRange;
                if (this.mWidthRange.contains((Range<Integer>) Integer.valueOf(i)) && i % this.mWidthAlignment == 0) {
                    int divUp = Utils.divUp(i, this.mBlockWidth);
                    Range<Integer> intersect = range.intersect(Integer.valueOf(((Math.max(Utils.divUp(this.mBlockCountRange.getLower().intValue(), divUp), (int) Math.ceil(divUp / this.mBlockAspectRatioRange.getUpper().doubleValue())) - 1) * this.mBlockHeight) + this.mHeightAlignment), Integer.valueOf(this.mBlockHeight * Math.min(this.mBlockCountRange.getUpper().intValue() / divUp, (int) (divUp / this.mBlockAspectRatioRange.getLower().doubleValue()))));
                    Range<Integer> range2 = intersect;
                    if (i > this.mSmallerDimensionUpperLimit) {
                        range2 = intersect.intersect(1, Integer.valueOf(this.mSmallerDimensionUpperLimit));
                    }
                    return range2.intersect(Integer.valueOf((int) Math.ceil(i / this.mAspectRatioRange.getUpper().doubleValue())), Integer.valueOf((int) (i / this.mAspectRatioRange.getLower().doubleValue())));
                }
                throw new IllegalArgumentException("unsupported width");
            } catch (IllegalArgumentException e) {
                Log.w(TAG, "could not get supported heights for " + i, e);
                throw new IllegalArgumentException("unsupported width");
            }
        }

        public Range<Integer> getSupportedWidths() {
            return this.mWidthRange;
        }

        public Range<Integer> getSupportedWidthsFor(int i) {
            try {
                Range<Integer> range = this.mWidthRange;
                if (this.mHeightRange.contains((Range<Integer>) Integer.valueOf(i)) && i % this.mHeightAlignment == 0) {
                    int divUp = Utils.divUp(i, this.mBlockHeight);
                    Range<Integer> intersect = range.intersect(Integer.valueOf(((Math.max(Utils.divUp(this.mBlockCountRange.getLower().intValue(), divUp), (int) Math.ceil(this.mBlockAspectRatioRange.getLower().doubleValue() * divUp)) - 1) * this.mBlockWidth) + this.mWidthAlignment), Integer.valueOf(this.mBlockWidth * Math.min(this.mBlockCountRange.getUpper().intValue() / divUp, (int) (this.mBlockAspectRatioRange.getUpper().doubleValue() * divUp))));
                    Range<Integer> range2 = intersect;
                    if (i > this.mSmallerDimensionUpperLimit) {
                        range2 = intersect.intersect(1, Integer.valueOf(this.mSmallerDimensionUpperLimit));
                    }
                    return range2.intersect(Integer.valueOf((int) Math.ceil(this.mAspectRatioRange.getLower().doubleValue() * i)), Integer.valueOf((int) (this.mAspectRatioRange.getUpper().doubleValue() * i)));
                }
                throw new IllegalArgumentException("unsupported height");
            } catch (IllegalArgumentException e) {
                Log.w(TAG, "could not get supported widths for " + i, e);
                throw new IllegalArgumentException("unsupported height");
            }
        }

        public int getWidthAlignment() {
            return this.mWidthAlignment;
        }

        public void init(MediaFormat mediaFormat, CodecCapabilities codecCapabilities) {
            this.mParent = codecCapabilities;
            initWithPlatformLimits();
            applyLevelLimits();
            parseFromInfo(mediaFormat);
            updateLimits();
        }

        public boolean isSizeSupported(int i, int i2) {
            return supports(Integer.valueOf(i), Integer.valueOf(i2), null);
        }

        public boolean supportsFormat(MediaFormat mediaFormat) {
            Map<String, Object> map = mediaFormat.getMap();
            return supports((Integer) map.get("width"), (Integer) map.get("height"), (Number) map.get(MediaFormat.KEY_FRAME_RATE));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MediaCodecInfo(String str, boolean z, CodecCapabilities[] codecCapabilitiesArr) {
        this.mName = str;
        this.mIsEncoder = z;
        int length = codecCapabilitiesArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            CodecCapabilities codecCapabilities = codecCapabilitiesArr[i2];
            this.mCaps.put(codecCapabilities.getMimeType(), codecCapabilities);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int checkPowerOfTwo(int i, String str) {
        if (((i - 1) & i) != 0) {
            throw new IllegalArgumentException(str);
        }
        return i;
    }

    public final CodecCapabilities getCapabilitiesForType(String str) {
        CodecCapabilities codecCapabilities = this.mCaps.get(str);
        if (codecCapabilities == null) {
            throw new IllegalArgumentException("codec does not support type");
        }
        return codecCapabilities.dup();
    }

    public final String getName() {
        return this.mName;
    }

    public final String[] getSupportedTypes() {
        Set<String> keySet = this.mCaps.keySet();
        String[] strArr = (String[]) keySet.toArray(new String[keySet.size()]);
        Arrays.sort(strArr);
        return strArr;
    }

    public final boolean isEncoder() {
        return this.mIsEncoder;
    }

    public MediaCodecInfo makeRegular() {
        MediaCodecInfo mediaCodecInfo;
        ArrayList arrayList = new ArrayList();
        for (CodecCapabilities codecCapabilities : this.mCaps.values()) {
            if (codecCapabilities.isRegular()) {
                arrayList.add(codecCapabilities);
            }
        }
        if (arrayList.size() == 0) {
            mediaCodecInfo = null;
        } else {
            mediaCodecInfo = this;
            if (arrayList.size() != this.mCaps.size()) {
                return new MediaCodecInfo(this.mName, this.mIsEncoder, (CodecCapabilities[]) arrayList.toArray(new CodecCapabilities[arrayList.size()]));
            }
        }
        return mediaCodecInfo;
    }
}

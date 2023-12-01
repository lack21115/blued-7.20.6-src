package android.hardware.camera2.params;

import android.graphics.ImageFormat;
import android.graphics.PixelFormat;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.legacy.LegacyCameraDevice;
import android.hardware.camera2.legacy.LegacyExceptionUtils;
import android.hardware.camera2.utils.HashCodeHelpers;
import android.media.ImageReader;
import android.media.MediaCodec;
import android.media.MediaRecorder;
import android.renderscript.Allocation;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.android.internal.util.Preconditions;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/params/StreamConfigurationMap.class */
public final class StreamConfigurationMap {
    private static final int DURATION_MIN_FRAME = 0;
    private static final int DURATION_STALL = 1;
    private static final int HAL_PIXEL_FORMAT_BLOB = 33;
    private static final int HAL_PIXEL_FORMAT_IMPLEMENTATION_DEFINED = 34;
    private static final int HAL_PIXEL_FORMAT_RAW_OPAQUE = 36;
    private static final String TAG = "StreamConfigurationMap";
    private final StreamConfiguration[] mConfigurations;
    private final HighSpeedVideoConfiguration[] mHighSpeedVideoConfigurations;
    private final StreamConfigurationDuration[] mMinFrameDurations;
    private final StreamConfigurationDuration[] mStallDurations;
    private final HashMap<Integer, Integer> mOutputFormats = new HashMap<>();
    private final HashMap<Integer, Integer> mInputFormats = new HashMap<>();
    private final HashMap<Size, Integer> mHighSpeedVideoSizeMap = new HashMap<>();
    private final HashMap<Range<Integer>, Integer> mHighSpeedVideoFpsRangeMap = new HashMap<>();

    public StreamConfigurationMap(StreamConfiguration[] streamConfigurationArr, StreamConfigurationDuration[] streamConfigurationDurationArr, StreamConfigurationDuration[] streamConfigurationDurationArr2, HighSpeedVideoConfiguration[] highSpeedVideoConfigurationArr) {
        this.mConfigurations = (StreamConfiguration[]) Preconditions.checkArrayElementsNotNull(streamConfigurationArr, "configurations");
        this.mMinFrameDurations = (StreamConfigurationDuration[]) Preconditions.checkArrayElementsNotNull(streamConfigurationDurationArr, "minFrameDurations");
        this.mStallDurations = (StreamConfigurationDuration[]) Preconditions.checkArrayElementsNotNull(streamConfigurationDurationArr2, "stallDurations");
        if (highSpeedVideoConfigurationArr == null) {
            this.mHighSpeedVideoConfigurations = new HighSpeedVideoConfiguration[0];
        } else {
            this.mHighSpeedVideoConfigurations = (HighSpeedVideoConfiguration[]) Preconditions.checkArrayElementsNotNull(highSpeedVideoConfigurationArr, "highSpeedVideoConfigurations");
        }
        int length = streamConfigurationArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            StreamConfiguration streamConfiguration = streamConfigurationArr[i2];
            HashMap<Integer, Integer> hashMap = streamConfiguration.isOutput() ? this.mOutputFormats : this.mInputFormats;
            Integer num = hashMap.get(Integer.valueOf(streamConfiguration.getFormat()));
            Integer num2 = num;
            if (num == null) {
                num2 = 0;
            }
            hashMap.put(Integer.valueOf(streamConfiguration.getFormat()), Integer.valueOf(num2.intValue() + 1));
            i = i2 + 1;
        }
        if (!this.mOutputFormats.containsKey(34)) {
            throw new AssertionError("At least one stream configuration for IMPLEMENTATION_DEFINED must exist");
        }
        HighSpeedVideoConfiguration[] highSpeedVideoConfigurationArr2 = this.mHighSpeedVideoConfigurations;
        int length2 = highSpeedVideoConfigurationArr2.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length2) {
                return;
            }
            HighSpeedVideoConfiguration highSpeedVideoConfiguration = highSpeedVideoConfigurationArr2[i4];
            Size size = highSpeedVideoConfiguration.getSize();
            Range<Integer> fpsRange = highSpeedVideoConfiguration.getFpsRange();
            Integer num3 = this.mHighSpeedVideoSizeMap.get(size);
            this.mHighSpeedVideoSizeMap.put(size, Integer.valueOf((num3 == null ? 0 : num3).intValue() + 1));
            Integer num4 = this.mHighSpeedVideoFpsRangeMap.get(fpsRange);
            Integer num5 = num4;
            if (num4 == null) {
                num5 = 0;
            }
            this.mHighSpeedVideoFpsRangeMap.put(fpsRange, Integer.valueOf(num5.intValue() + 1));
            i3 = i4 + 1;
        }
    }

    private static <T> boolean arrayContains(T[] tArr, T t) {
        if (tArr == null) {
            return false;
        }
        int length = tArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (Objects.equals(tArr[i2], t)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    static int checkArgumentFormat(int i) {
        if (ImageFormat.isPublicFormat(i) || PixelFormat.isPublicFormat(i)) {
            return i;
        }
        throw new IllegalArgumentException(String.format("format 0x%x was not defined in either ImageFormat or PixelFormat", Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int checkArgumentFormatInternal(int i) {
        int i2 = i;
        switch (i) {
            case 33:
            case 34:
            case 36:
                break;
            case 256:
                throw new IllegalArgumentException("ImageFormat.JPEG is an unknown internal format");
            default:
                i2 = checkArgumentFormat(i);
                break;
        }
        return i2;
    }

    private int checkArgumentFormatSupported(int i, boolean z) {
        checkArgumentFormat(i);
        int[] outputFormats = z ? getOutputFormats() : getInputFormats();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= outputFormats.length) {
                throw new IllegalArgumentException(String.format("format %x is not supported by this stream configuration map", Integer.valueOf(i)));
            }
            if (i == outputFormats[i3]) {
                return i;
            }
            i2 = i3 + 1;
        }
    }

    private StreamConfigurationDuration[] getDurations(int i) {
        switch (i) {
            case 0:
                return this.mMinFrameDurations;
            case 1:
                return this.mStallDurations;
            default:
                throw new IllegalArgumentException("duration was invalid");
        }
    }

    private HashMap<Integer, Integer> getFormatsMap(boolean z) {
        return z ? this.mOutputFormats : this.mInputFormats;
    }

    private long getInternalFormatDuration(int i, Size size, int i2) {
        if (!arrayContains(getInternalFormatSizes(i, true), size)) {
            throw new IllegalArgumentException("size was not supported");
        }
        StreamConfigurationDuration[] durations = getDurations(i2);
        int length = durations.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                return 0L;
            }
            StreamConfigurationDuration streamConfigurationDuration = durations[i4];
            if (streamConfigurationDuration.getFormat() == i && streamConfigurationDuration.getWidth() == size.getWidth() && streamConfigurationDuration.getHeight() == size.getHeight()) {
                return streamConfigurationDuration.getDuration();
            }
            i3 = i4 + 1;
        }
    }

    private Size[] getInternalFormatSizes(int i, boolean z) {
        StreamConfiguration[] streamConfigurationArr;
        Integer num = getFormatsMap(z).get(Integer.valueOf(i));
        if (num == null) {
            throw new IllegalArgumentException("format not available");
        }
        int intValue = num.intValue();
        Size[] sizeArr = new Size[intValue];
        int i2 = 0;
        for (StreamConfiguration streamConfiguration : this.mConfigurations) {
            if (streamConfiguration.getFormat() == i && streamConfiguration.isOutput() == z) {
                sizeArr[i2] = streamConfiguration.getSize();
                i2++;
            }
        }
        if (i2 != intValue) {
            throw new AssertionError("Too few sizes (expected " + intValue + ", actual " + i2 + ")");
        }
        return sizeArr;
    }

    private int getPublicFormatCount(boolean z) {
        HashMap<Integer, Integer> formatsMap = getFormatsMap(z);
        int size = formatsMap.size();
        int i = size;
        if (formatsMap.containsKey(34)) {
            i = size - 1;
        }
        int i2 = i;
        if (formatsMap.containsKey(36)) {
            i2 = i - 1;
        }
        return i2;
    }

    private Size[] getPublicFormatSizes(int i, boolean z) {
        try {
            checkArgumentFormatSupported(i, z);
            return getInternalFormatSizes(imageFormatToInternal(i), z);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private int[] getPublicFormats(boolean z) {
        int[] iArr = new int[getPublicFormatCount(z)];
        int i = 0;
        for (Integer num : getFormatsMap(z).keySet()) {
            int intValue = num.intValue();
            if (intValue != 34 && intValue != 36) {
                iArr[i] = intValue;
                i++;
            }
        }
        if (iArr.length != i) {
            throw new AssertionError("Too few formats " + i + ", expected " + iArr.length);
        }
        return imageFormatToPublic(iArr);
    }

    static int imageFormatToInternal(int i) {
        switch (i) {
            case 34:
                throw new IllegalArgumentException("IMPLEMENTATION_DEFINED is not allowed via public API");
            case 256:
                return 33;
            default:
                return i;
        }
    }

    public static int[] imageFormatToInternal(int[] iArr) {
        int[] iArr2;
        if (iArr != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                iArr2 = iArr;
                if (i2 >= iArr.length) {
                    break;
                }
                iArr[i2] = imageFormatToInternal(iArr[i2]);
                i = i2 + 1;
            }
        } else {
            iArr2 = null;
        }
        return iArr2;
    }

    static int imageFormatToPublic(int i) {
        switch (i) {
            case 33:
                return 256;
            case 34:
                throw new IllegalArgumentException("IMPLEMENTATION_DEFINED must not leak to public API");
            case 256:
                throw new IllegalArgumentException("ImageFormat.JPEG is an unknown internal format");
            default:
                return i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int[] imageFormatToPublic(int[] iArr) {
        int[] iArr2;
        if (iArr != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                iArr2 = iArr;
                if (i2 >= iArr.length) {
                    break;
                }
                iArr[i2] = imageFormatToPublic(iArr[i2]);
                i = i2 + 1;
            }
        } else {
            iArr2 = null;
        }
        return iArr2;
    }

    public static <T> boolean isOutputSupportedFor(Class<T> cls) {
        Preconditions.checkNotNull(cls, "klass must not be null");
        return cls == ImageReader.class || cls == MediaRecorder.class || cls == MediaCodec.class || cls == Allocation.class || cls == SurfaceHolder.class || cls == SurfaceTexture.class;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof StreamConfigurationMap) {
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) obj;
            if (!Arrays.equals(this.mConfigurations, streamConfigurationMap.mConfigurations) || !Arrays.equals(this.mMinFrameDurations, streamConfigurationMap.mMinFrameDurations) || !Arrays.equals(this.mStallDurations, streamConfigurationMap.mStallDurations) || !Arrays.equals(this.mHighSpeedVideoConfigurations, streamConfigurationMap.mHighSpeedVideoConfigurations)) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public Range<Integer>[] getHighSpeedVideoFpsRanges() {
        Set<Range<Integer>> keySet = this.mHighSpeedVideoFpsRangeMap.keySet();
        return (Range[]) keySet.toArray(new Range[keySet.size()]);
    }

    public Range<Integer>[] getHighSpeedVideoFpsRangesFor(Size size) {
        HighSpeedVideoConfiguration[] highSpeedVideoConfigurationArr;
        Integer num = this.mHighSpeedVideoSizeMap.get(size);
        if (num == null || num.intValue() == 0) {
            throw new IllegalArgumentException(String.format("Size %s does not support high speed video recording", size));
        }
        Range<Integer>[] rangeArr = new Range[num.intValue()];
        int i = 0;
        for (HighSpeedVideoConfiguration highSpeedVideoConfiguration : this.mHighSpeedVideoConfigurations) {
            if (size.equals(highSpeedVideoConfiguration.getSize())) {
                rangeArr[i] = highSpeedVideoConfiguration.getFpsRange();
                i++;
            }
        }
        return rangeArr;
    }

    public Size[] getHighSpeedVideoSizes() {
        Set<Size> keySet = this.mHighSpeedVideoSizeMap.keySet();
        return (Size[]) keySet.toArray(new Size[keySet.size()]);
    }

    public Size[] getHighSpeedVideoSizesFor(Range<Integer> range) {
        HighSpeedVideoConfiguration[] highSpeedVideoConfigurationArr;
        Integer num = this.mHighSpeedVideoFpsRangeMap.get(range);
        if (num == null || num.intValue() == 0) {
            throw new IllegalArgumentException(String.format("FpsRange %s does not support high speed video recording", range));
        }
        Size[] sizeArr = new Size[num.intValue()];
        int i = 0;
        for (HighSpeedVideoConfiguration highSpeedVideoConfiguration : this.mHighSpeedVideoConfigurations) {
            if (range.equals(highSpeedVideoConfiguration.getFpsRange())) {
                sizeArr[i] = highSpeedVideoConfiguration.getSize();
                i++;
            }
        }
        return sizeArr;
    }

    public final int[] getInputFormats() {
        return getPublicFormats(false);
    }

    public Size[] getInputSizes(int i) {
        return getPublicFormatSizes(i, false);
    }

    public final int[] getOutputFormats() {
        return getPublicFormats(true);
    }

    public long getOutputMinFrameDuration(int i, Size size) {
        Preconditions.checkNotNull(size, "size must not be null");
        checkArgumentFormatSupported(i, true);
        return getInternalFormatDuration(imageFormatToInternal(i), size, 0);
    }

    public <T> long getOutputMinFrameDuration(Class<T> cls, Size size) {
        if (isOutputSupportedFor(cls)) {
            return getInternalFormatDuration(34, size, 0);
        }
        throw new IllegalArgumentException("klass was not supported");
    }

    public Size[] getOutputSizes(int i) {
        return getPublicFormatSizes(i, true);
    }

    public <T> Size[] getOutputSizes(Class<T> cls) {
        if (ImageReader.class.isAssignableFrom(cls)) {
            return new Size[0];
        }
        if (isOutputSupportedFor(cls)) {
            return getInternalFormatSizes(34, true);
        }
        return null;
    }

    public long getOutputStallDuration(int i, Size size) {
        checkArgumentFormatSupported(i, true);
        return getInternalFormatDuration(imageFormatToInternal(i), size, 1);
    }

    public <T> long getOutputStallDuration(Class<T> cls, Size size) {
        if (isOutputSupportedFor(cls)) {
            return getInternalFormatDuration(34, size, 1);
        }
        throw new IllegalArgumentException("klass was not supported");
    }

    public int hashCode() {
        return HashCodeHelpers.hashCode((HighSpeedVideoConfiguration[]) this.mConfigurations, (HighSpeedVideoConfiguration[]) this.mMinFrameDurations, (HighSpeedVideoConfiguration[]) this.mStallDurations, this.mHighSpeedVideoConfigurations);
    }

    public boolean isOutputSupportedFor(int i) {
        checkArgumentFormat(i);
        return getFormatsMap(true).containsKey(Integer.valueOf(imageFormatToInternal(i)));
    }

    public boolean isOutputSupportedFor(Surface surface) {
        Preconditions.checkNotNull(surface, "surface must not be null");
        try {
            Size surfaceSize = LegacyCameraDevice.getSurfaceSize(surface);
            int detectSurfaceType = LegacyCameraDevice.detectSurfaceType(surface);
            boolean isFlexibleConsumer = LegacyCameraDevice.isFlexibleConsumer(surface);
            int i = detectSurfaceType;
            if (detectSurfaceType >= 1) {
                i = detectSurfaceType;
                if (detectSurfaceType <= 5) {
                    i = 34;
                }
            }
            StreamConfiguration[] streamConfigurationArr = this.mConfigurations;
            int length = streamConfigurationArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return false;
                }
                StreamConfiguration streamConfiguration = streamConfigurationArr[i3];
                if (streamConfiguration.getFormat() == i && streamConfiguration.isOutput()) {
                    if (streamConfiguration.getSize().equals(surfaceSize)) {
                        return true;
                    }
                    if (isFlexibleConsumer && streamConfiguration.getSize().getWidth() <= 1080) {
                        return true;
                    }
                }
                i2 = i3 + 1;
            }
        } catch (LegacyExceptionUtils.BufferQueueAbandonedException e) {
            throw new IllegalArgumentException("Abandoned surface", e);
        }
    }
}

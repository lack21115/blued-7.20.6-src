package android.hardware.camera2.impl;

import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.marshal.MarshalQueryable;
import android.hardware.camera2.marshal.MarshalRegistry;
import android.hardware.camera2.marshal.Marshaler;
import android.hardware.camera2.marshal.impl.MarshalQueryableArray;
import android.hardware.camera2.marshal.impl.MarshalQueryableBlackLevelPattern;
import android.hardware.camera2.marshal.impl.MarshalQueryableBoolean;
import android.hardware.camera2.marshal.impl.MarshalQueryableColorSpaceTransform;
import android.hardware.camera2.marshal.impl.MarshalQueryableEnum;
import android.hardware.camera2.marshal.impl.MarshalQueryableHighSpeedVideoConfiguration;
import android.hardware.camera2.marshal.impl.MarshalQueryableMeteringRectangle;
import android.hardware.camera2.marshal.impl.MarshalQueryableNativeByteToInteger;
import android.hardware.camera2.marshal.impl.MarshalQueryablePair;
import android.hardware.camera2.marshal.impl.MarshalQueryableParcelable;
import android.hardware.camera2.marshal.impl.MarshalQueryablePrimitive;
import android.hardware.camera2.marshal.impl.MarshalQueryableRange;
import android.hardware.camera2.marshal.impl.MarshalQueryableRect;
import android.hardware.camera2.marshal.impl.MarshalQueryableReprocessFormatsMap;
import android.hardware.camera2.marshal.impl.MarshalQueryableRggbChannelVector;
import android.hardware.camera2.marshal.impl.MarshalQueryableSize;
import android.hardware.camera2.marshal.impl.MarshalQueryableSizeF;
import android.hardware.camera2.marshal.impl.MarshalQueryableStreamConfiguration;
import android.hardware.camera2.marshal.impl.MarshalQueryableStreamConfigurationDuration;
import android.hardware.camera2.marshal.impl.MarshalQueryableString;
import android.hardware.camera2.params.Face;
import android.hardware.camera2.params.HighSpeedVideoConfiguration;
import android.hardware.camera2.params.LensShadingMap;
import android.hardware.camera2.params.StreamConfiguration;
import android.hardware.camera2.params.StreamConfigurationDuration;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.hardware.camera2.params.TonemapCurve;
import android.hardware.camera2.utils.TypeReference;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.util.Size;
import com.android.internal.util.Preconditions;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/impl/CameraMetadataNative.class */
public class CameraMetadataNative implements Parcelable {
    private static final String CELLID_PROCESS = "CELLID";
    private static final int FACE_LANDMARK_SIZE = 6;
    private static final String GPS_PROCESS = "GPS";
    public static final int NATIVE_JPEG_FORMAT = 33;
    public static final int NUM_TYPES = 6;
    public static final int TYPE_BYTE = 0;
    public static final int TYPE_DOUBLE = 4;
    public static final int TYPE_FLOAT = 2;
    public static final int TYPE_INT32 = 1;
    public static final int TYPE_INT64 = 3;
    public static final int TYPE_RATIONAL = 5;
    private static final HashMap<Key<?>, SetCommand> sSetCommandMap;
    private long mMetadataPtr;
    private static final String TAG = "CameraMetadataJV";
    private static final boolean VERBOSE = Log.isLoggable(TAG, 2);
    public static final Parcelable.Creator<CameraMetadataNative> CREATOR = new Parcelable.Creator<CameraMetadataNative>() { // from class: android.hardware.camera2.impl.CameraMetadataNative.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CameraMetadataNative createFromParcel(Parcel parcel) {
            CameraMetadataNative cameraMetadataNative = new CameraMetadataNative();
            cameraMetadataNative.readFromParcel(parcel);
            return cameraMetadataNative;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CameraMetadataNative[] newArray(int i) {
            return new CameraMetadataNative[i];
        }
    };
    private static final HashMap<Key<?>, GetCommand> sGetCommandMap = new HashMap<>();

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/impl/CameraMetadataNative$Key.class */
    public static class Key<T> {
        private boolean mHasTag;
        private final int mHash;
        private final String mName;
        private int mTag;
        private final Class<T> mType;
        private final TypeReference<T> mTypeReference;

        public Key(String str, TypeReference<T> typeReference) {
            if (str == null) {
                throw new NullPointerException("Key needs a valid name");
            }
            if (typeReference == null) {
                throw new NullPointerException("TypeReference needs to be non-null");
            }
            this.mName = str;
            this.mType = (Class<? super T>) typeReference.getRawType();
            this.mTypeReference = typeReference;
            this.mHash = this.mName.hashCode() ^ this.mTypeReference.hashCode();
        }

        public Key(String str, Class<T> cls) {
            if (str == null) {
                throw new NullPointerException("Key needs a valid name");
            }
            if (cls == null) {
                throw new NullPointerException("Type needs to be non-null");
            }
            this.mName = str;
            this.mType = cls;
            this.mTypeReference = TypeReference.createSpecializedTypeReference((Class) cls);
            this.mHash = this.mName.hashCode() ^ this.mTypeReference.hashCode();
        }

        public final boolean equals(Object obj) {
            Key<T> key;
            if (this == obj) {
                return true;
            }
            if (obj == null || hashCode() != obj.hashCode()) {
                return false;
            }
            if (obj instanceof CaptureResult.Key) {
                key = ((CaptureResult.Key) obj).getNativeKey();
            } else if (obj instanceof CaptureRequest.Key) {
                key = ((CaptureRequest.Key) obj).getNativeKey();
            } else if (obj instanceof CameraCharacteristics.Key) {
                key = ((CameraCharacteristics.Key) obj).getNativeKey();
            } else if (!(obj instanceof Key)) {
                return false;
            } else {
                key = (Key) obj;
            }
            return this.mName.equals(key.mName) && this.mTypeReference.equals(key.mTypeReference);
        }

        public final String getName() {
            return this.mName;
        }

        public final int getTag() {
            if (!this.mHasTag) {
                this.mTag = CameraMetadataNative.getTag(this.mName);
                this.mHasTag = true;
            }
            return this.mTag;
        }

        public final Class<T> getType() {
            return this.mType;
        }

        public final TypeReference<T> getTypeReference() {
            return this.mTypeReference;
        }

        public final int hashCode() {
            return this.mHash;
        }
    }

    static {
        sGetCommandMap.put(CameraCharacteristics.SCALER_AVAILABLE_FORMATS.getNativeKey(), new GetCommand() { // from class: android.hardware.camera2.impl.CameraMetadataNative.2
            @Override // android.hardware.camera2.impl.GetCommand
            public <T> T getValue(CameraMetadataNative cameraMetadataNative, Key<T> key) {
                return (T) cameraMetadataNative.getAvailableFormats();
            }
        });
        sGetCommandMap.put(CaptureResult.STATISTICS_FACES.getNativeKey(), new GetCommand() { // from class: android.hardware.camera2.impl.CameraMetadataNative.3
            @Override // android.hardware.camera2.impl.GetCommand
            public <T> T getValue(CameraMetadataNative cameraMetadataNative, Key<T> key) {
                return (T) cameraMetadataNative.getFaces();
            }
        });
        sGetCommandMap.put(CaptureResult.STATISTICS_FACE_RECTANGLES.getNativeKey(), new GetCommand() { // from class: android.hardware.camera2.impl.CameraMetadataNative.4
            @Override // android.hardware.camera2.impl.GetCommand
            public <T> T getValue(CameraMetadataNative cameraMetadataNative, Key<T> key) {
                return (T) cameraMetadataNative.getFaceRectangles();
            }
        });
        sGetCommandMap.put(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP.getNativeKey(), new GetCommand() { // from class: android.hardware.camera2.impl.CameraMetadataNative.5
            @Override // android.hardware.camera2.impl.GetCommand
            public <T> T getValue(CameraMetadataNative cameraMetadataNative, Key<T> key) {
                return (T) cameraMetadataNative.getStreamConfigurationMap();
            }
        });
        sGetCommandMap.put(CameraCharacteristics.CONTROL_MAX_REGIONS_AE.getNativeKey(), new GetCommand() { // from class: android.hardware.camera2.impl.CameraMetadataNative.6
            @Override // android.hardware.camera2.impl.GetCommand
            public <T> T getValue(CameraMetadataNative cameraMetadataNative, Key<T> key) {
                return (T) cameraMetadataNative.getMaxRegions(key);
            }
        });
        sGetCommandMap.put(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB.getNativeKey(), new GetCommand() { // from class: android.hardware.camera2.impl.CameraMetadataNative.7
            @Override // android.hardware.camera2.impl.GetCommand
            public <T> T getValue(CameraMetadataNative cameraMetadataNative, Key<T> key) {
                return (T) cameraMetadataNative.getMaxRegions(key);
            }
        });
        sGetCommandMap.put(CameraCharacteristics.CONTROL_MAX_REGIONS_AF.getNativeKey(), new GetCommand() { // from class: android.hardware.camera2.impl.CameraMetadataNative.8
            @Override // android.hardware.camera2.impl.GetCommand
            public <T> T getValue(CameraMetadataNative cameraMetadataNative, Key<T> key) {
                return (T) cameraMetadataNative.getMaxRegions(key);
            }
        });
        sGetCommandMap.put(CameraCharacteristics.REQUEST_MAX_NUM_OUTPUT_RAW.getNativeKey(), new GetCommand() { // from class: android.hardware.camera2.impl.CameraMetadataNative.9
            @Override // android.hardware.camera2.impl.GetCommand
            public <T> T getValue(CameraMetadataNative cameraMetadataNative, Key<T> key) {
                return (T) cameraMetadataNative.getMaxNumOutputs(key);
            }
        });
        sGetCommandMap.put(CameraCharacteristics.REQUEST_MAX_NUM_OUTPUT_PROC.getNativeKey(), new GetCommand() { // from class: android.hardware.camera2.impl.CameraMetadataNative.10
            @Override // android.hardware.camera2.impl.GetCommand
            public <T> T getValue(CameraMetadataNative cameraMetadataNative, Key<T> key) {
                return (T) cameraMetadataNative.getMaxNumOutputs(key);
            }
        });
        sGetCommandMap.put(CameraCharacteristics.REQUEST_MAX_NUM_OUTPUT_PROC_STALLING.getNativeKey(), new GetCommand() { // from class: android.hardware.camera2.impl.CameraMetadataNative.11
            @Override // android.hardware.camera2.impl.GetCommand
            public <T> T getValue(CameraMetadataNative cameraMetadataNative, Key<T> key) {
                return (T) cameraMetadataNative.getMaxNumOutputs(key);
            }
        });
        sGetCommandMap.put(CaptureRequest.TONEMAP_CURVE.getNativeKey(), new GetCommand() { // from class: android.hardware.camera2.impl.CameraMetadataNative.12
            @Override // android.hardware.camera2.impl.GetCommand
            public <T> T getValue(CameraMetadataNative cameraMetadataNative, Key<T> key) {
                return (T) cameraMetadataNative.getTonemapCurve();
            }
        });
        sGetCommandMap.put(CaptureResult.JPEG_GPS_LOCATION.getNativeKey(), new GetCommand() { // from class: android.hardware.camera2.impl.CameraMetadataNative.13
            @Override // android.hardware.camera2.impl.GetCommand
            public <T> T getValue(CameraMetadataNative cameraMetadataNative, Key<T> key) {
                return (T) cameraMetadataNative.getGpsLocation();
            }
        });
        sGetCommandMap.put(CaptureResult.STATISTICS_LENS_SHADING_CORRECTION_MAP.getNativeKey(), new GetCommand() { // from class: android.hardware.camera2.impl.CameraMetadataNative.14
            @Override // android.hardware.camera2.impl.GetCommand
            public <T> T getValue(CameraMetadataNative cameraMetadataNative, Key<T> key) {
                return (T) cameraMetadataNative.getLensShadingMap();
            }
        });
        sSetCommandMap = new HashMap<>();
        sSetCommandMap.put(CameraCharacteristics.SCALER_AVAILABLE_FORMATS.getNativeKey(), new SetCommand() { // from class: android.hardware.camera2.impl.CameraMetadataNative.15
            @Override // android.hardware.camera2.impl.SetCommand
            public <T> void setValue(CameraMetadataNative cameraMetadataNative, T t) {
                cameraMetadataNative.setAvailableFormats((int[]) t);
            }
        });
        sSetCommandMap.put(CaptureResult.STATISTICS_FACE_RECTANGLES.getNativeKey(), new SetCommand() { // from class: android.hardware.camera2.impl.CameraMetadataNative.16
            @Override // android.hardware.camera2.impl.SetCommand
            public <T> void setValue(CameraMetadataNative cameraMetadataNative, T t) {
                cameraMetadataNative.setFaceRectangles((Rect[]) t);
            }
        });
        sSetCommandMap.put(CaptureResult.STATISTICS_FACES.getNativeKey(), new SetCommand() { // from class: android.hardware.camera2.impl.CameraMetadataNative.17
            @Override // android.hardware.camera2.impl.SetCommand
            public <T> void setValue(CameraMetadataNative cameraMetadataNative, T t) {
                cameraMetadataNative.setFaces((Face[]) t);
            }
        });
        sSetCommandMap.put(CaptureRequest.TONEMAP_CURVE.getNativeKey(), new SetCommand() { // from class: android.hardware.camera2.impl.CameraMetadataNative.18
            @Override // android.hardware.camera2.impl.SetCommand
            public <T> void setValue(CameraMetadataNative cameraMetadataNative, T t) {
                cameraMetadataNative.setTonemapCurve((TonemapCurve) t);
            }
        });
        sSetCommandMap.put(CaptureResult.JPEG_GPS_LOCATION.getNativeKey(), new SetCommand() { // from class: android.hardware.camera2.impl.CameraMetadataNative.19
            @Override // android.hardware.camera2.impl.SetCommand
            public <T> void setValue(CameraMetadataNative cameraMetadataNative, T t) {
                cameraMetadataNative.setGpsLocation((Location) t);
            }
        });
        nativeClassInit();
        registerAllMarshalers();
    }

    public CameraMetadataNative() {
        this.mMetadataPtr = nativeAllocate();
        if (this.mMetadataPtr == 0) {
            throw new OutOfMemoryError("Failed to allocate native CameraMetadata");
        }
    }

    public CameraMetadataNative(CameraMetadataNative cameraMetadataNative) {
        this.mMetadataPtr = nativeAllocateCopy(cameraMetadataNative);
        if (this.mMetadataPtr == 0) {
            throw new OutOfMemoryError("Failed to allocate native CameraMetadata");
        }
    }

    private static boolean areValuesAllNull(Object... objArr) {
        int length = objArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (objArr[i2] != null) {
                return false;
            }
            i = i2 + 1;
        }
    }

    private void close() {
        nativeClose();
        this.mMetadataPtr = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] getAvailableFormats() {
        int[] iArr = (int[]) getBase(CameraCharacteristics.SCALER_AVAILABLE_FORMATS);
        if (iArr != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= iArr.length) {
                    break;
                }
                if (iArr[i2] == 33) {
                    iArr[i2] = 256;
                }
                i = i2 + 1;
            }
        }
        return iArr;
    }

    private <T> T getBase(CameraCharacteristics.Key<T> key) {
        return (T) getBase(key.getNativeKey());
    }

    private <T> T getBase(CaptureRequest.Key<T> key) {
        return (T) getBase(key.getNativeKey());
    }

    private <T> T getBase(CaptureResult.Key<T> key) {
        return (T) getBase(key.getNativeKey());
    }

    private <T> T getBase(Key<T> key) {
        byte[] readValues = readValues(key.getTag());
        if (readValues == null) {
            return null;
        }
        return (T) getMarshalerForKey(key).unmarshal(ByteBuffer.wrap(readValues).order(ByteOrder.nativeOrder()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect[] getFaceRectangles() {
        Rect[] rectArr;
        Rect[] rectArr2 = (Rect[]) getBase(CaptureResult.STATISTICS_FACE_RECTANGLES);
        if (rectArr2 != null) {
            Rect[] rectArr3 = new Rect[rectArr2.length];
            int i = 0;
            while (true) {
                int i2 = i;
                rectArr = rectArr3;
                if (i2 >= rectArr2.length) {
                    break;
                }
                rectArr3[i2] = new Rect(rectArr2[i2].left, rectArr2[i2].top, rectArr2[i2].right - rectArr2[i2].left, rectArr2[i2].bottom - rectArr2[i2].top);
                i = i2 + 1;
            }
        } else {
            rectArr = null;
        }
        return rectArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Face[] getFaces() {
        Integer num;
        Integer num2 = (Integer) get(CaptureResult.STATISTICS_FACE_DETECT_MODE);
        byte[] bArr = (byte[]) get(CaptureResult.STATISTICS_FACE_SCORES);
        Rect[] rectArr = (Rect[]) get(CaptureResult.STATISTICS_FACE_RECTANGLES);
        int[] iArr = (int[]) get(CaptureResult.STATISTICS_FACE_IDS);
        int[] iArr2 = (int[]) get(CaptureResult.STATISTICS_FACE_LANDMARKS);
        if (areValuesAllNull(num2, bArr, rectArr, iArr, iArr2)) {
            return null;
        }
        if (num2 == null) {
            Log.w(TAG, "Face detect mode metadata is null, assuming the mode is SIMPLE");
            num = 1;
        } else if (num2.intValue() == 0) {
            return new Face[0];
        } else {
            num = num2;
            if (num2.intValue() != 1) {
                num = num2;
                if (num2.intValue() != 2) {
                    Log.w(TAG, "Unknown face detect mode: " + num2);
                    return new Face[0];
                }
            }
        }
        if (bArr == null || rectArr == null) {
            Log.w(TAG, "Expect face scores and rectangles to be non-null");
            return new Face[0];
        }
        if (bArr.length != rectArr.length) {
            Log.w(TAG, String.format("Face score size(%d) doesn match face rectangle size(%d)!", Integer.valueOf(bArr.length), Integer.valueOf(rectArr.length)));
        }
        int min = Math.min(bArr.length, rectArr.length);
        Integer num3 = num;
        int i = min;
        if (num.intValue() == 2) {
            if (iArr == null || iArr2 == null) {
                Log.w(TAG, "Expect face ids and landmarks to be non-null for FULL mode,fallback to SIMPLE mode");
                num3 = 1;
                i = min;
            } else {
                if (iArr.length != min || iArr2.length != min * 6) {
                    Log.w(TAG, String.format("Face id size(%d), or face landmark size(%d) don'tmatch face number(%d)!", Integer.valueOf(iArr.length), Integer.valueOf(iArr2.length * 6), Integer.valueOf(min)));
                }
                i = Math.min(Math.min(min, iArr.length), iArr2.length / 6);
                num3 = num;
            }
        }
        ArrayList arrayList = new ArrayList();
        if (num3.intValue() != 1) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    break;
                }
                if (bArr[i3] <= 100 && bArr[i3] >= 1 && iArr[i3] >= 0) {
                    arrayList.add(new Face(rectArr[i3], bArr[i3], iArr[i3], new Point(iArr2[i3 * 6], iArr2[(i3 * 6) + 1]), new Point(iArr2[(i3 * 6) + 2], iArr2[(i3 * 6) + 3]), new Point(iArr2[(i3 * 6) + 4], iArr2[(i3 * 6) + 5])));
                }
                i2 = i3 + 1;
            }
        } else {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= i) {
                    break;
                }
                if (bArr[i5] <= 100 && bArr[i5] >= 1) {
                    arrayList.add(new Face(rectArr[i5], bArr[i5]));
                }
                i4 = i5 + 1;
            }
        }
        Face[] faceArr = new Face[arrayList.size()];
        arrayList.toArray(faceArr);
        return faceArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Location getGpsLocation() {
        String str = (String) get(CaptureResult.JPEG_GPS_PROCESSING_METHOD);
        double[] dArr = (double[]) get(CaptureResult.JPEG_GPS_COORDINATES);
        Long l = (Long) get(CaptureResult.JPEG_GPS_TIMESTAMP);
        if (areValuesAllNull(str, dArr, l)) {
            return null;
        }
        Location location = new Location(translateProcessToLocationProvider(str));
        if (l != null) {
            location.setTime(l.longValue());
        } else {
            Log.w(TAG, "getGpsLocation - No timestamp for GPS location.");
        }
        if (dArr == null) {
            Log.w(TAG, "getGpsLocation - No coordinates for GPS location");
            return location;
        }
        location.setLatitude(dArr[0]);
        location.setLongitude(dArr[1]);
        location.setAltitude(dArr[2]);
        return location;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LensShadingMap getLensShadingMap() {
        float[] fArr = (float[]) getBase(CaptureResult.STATISTICS_LENS_SHADING_MAP);
        Size size = (Size) get(CameraCharacteristics.LENS_INFO_SHADING_MAP_SIZE);
        if (fArr == null) {
            return null;
        }
        if (size == null) {
            Log.w(TAG, "getLensShadingMap - Lens shading map size was null.");
            return null;
        }
        return new LensShadingMap(fArr, size.getHeight(), size.getWidth());
    }

    private static <T> Marshaler<T> getMarshalerForKey(Key<T> key) {
        return MarshalRegistry.getMarshaler(key.getTypeReference(), getNativeType(key.getTag()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> Integer getMaxNumOutputs(Key<T> key) {
        int[] iArr = (int[]) getBase(CameraCharacteristics.REQUEST_MAX_NUM_OUTPUT_STREAMS);
        if (iArr == null) {
            return null;
        }
        if (key.equals(CameraCharacteristics.REQUEST_MAX_NUM_OUTPUT_RAW)) {
            return Integer.valueOf(iArr[0]);
        }
        if (key.equals(CameraCharacteristics.REQUEST_MAX_NUM_OUTPUT_PROC)) {
            return Integer.valueOf(iArr[1]);
        }
        if (key.equals(CameraCharacteristics.REQUEST_MAX_NUM_OUTPUT_PROC_STALLING)) {
            return Integer.valueOf(iArr[2]);
        }
        throw new AssertionError("Invalid key " + key);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> Integer getMaxRegions(Key<T> key) {
        int[] iArr = (int[]) getBase(CameraCharacteristics.CONTROL_MAX_REGIONS);
        if (iArr == null) {
            return null;
        }
        if (key.equals(CameraCharacteristics.CONTROL_MAX_REGIONS_AE)) {
            return Integer.valueOf(iArr[0]);
        }
        if (key.equals(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB)) {
            return Integer.valueOf(iArr[1]);
        }
        if (key.equals(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)) {
            return Integer.valueOf(iArr[2]);
        }
        throw new AssertionError("Invalid key " + key);
    }

    public static int getNativeType(int i) {
        return nativeGetTypeFromTag(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public StreamConfigurationMap getStreamConfigurationMap() {
        return new StreamConfigurationMap((StreamConfiguration[]) getBase(CameraCharacteristics.SCALER_AVAILABLE_STREAM_CONFIGURATIONS), (StreamConfigurationDuration[]) getBase(CameraCharacteristics.SCALER_AVAILABLE_MIN_FRAME_DURATIONS), (StreamConfigurationDuration[]) getBase(CameraCharacteristics.SCALER_AVAILABLE_STALL_DURATIONS), (HighSpeedVideoConfiguration[]) getBase(CameraCharacteristics.CONTROL_AVAILABLE_HIGH_SPEED_VIDEO_CONFIGURATIONS));
    }

    public static int getTag(String str) {
        return nativeGetTagFromKey(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> TonemapCurve getTonemapCurve() {
        float[] fArr = (float[]) getBase(CaptureRequest.TONEMAP_CURVE_RED);
        float[] fArr2 = (float[]) getBase(CaptureRequest.TONEMAP_CURVE_GREEN);
        float[] fArr3 = (float[]) getBase(CaptureRequest.TONEMAP_CURVE_BLUE);
        if (areValuesAllNull(fArr, fArr2, fArr3)) {
            return null;
        }
        if (fArr == null || fArr2 == null || fArr3 == null) {
            Log.w(TAG, "getTonemapCurve - missing tone curve components");
            return null;
        }
        return new TonemapCurve(fArr, fArr2, fArr3);
    }

    public static CameraMetadataNative move(CameraMetadataNative cameraMetadataNative) {
        CameraMetadataNative cameraMetadataNative2 = new CameraMetadataNative();
        cameraMetadataNative2.swap(cameraMetadataNative);
        return cameraMetadataNative2;
    }

    private native long nativeAllocate();

    private native long nativeAllocateCopy(CameraMetadataNative cameraMetadataNative) throws NullPointerException;

    private static native void nativeClassInit();

    private native synchronized void nativeClose();

    private native synchronized void nativeDump() throws IOException;

    private native synchronized int nativeGetEntryCount();

    private static native int nativeGetTagFromKey(String str) throws IllegalArgumentException;

    private static native int nativeGetTypeFromTag(int i) throws IllegalArgumentException;

    private native synchronized boolean nativeIsEmpty();

    private native synchronized void nativeReadFromParcel(Parcel parcel);

    private native synchronized byte[] nativeReadValues(int i);

    public static native int nativeSetupGlobalVendorTagDescriptor();

    private native synchronized void nativeSwap(CameraMetadataNative cameraMetadataNative) throws NullPointerException;

    private native synchronized void nativeWriteToParcel(Parcel parcel);

    private native synchronized void nativeWriteValues(int i, byte[] bArr);

    private static void registerAllMarshalers() {
        if (VERBOSE) {
            Log.v(TAG, "Shall register metadata marshalers");
        }
        MarshalQueryable[] marshalQueryableArr = {new MarshalQueryablePrimitive(), new MarshalQueryableEnum(), new MarshalQueryableArray(), new MarshalQueryableBoolean(), new MarshalQueryableNativeByteToInteger(), new MarshalQueryableRect(), new MarshalQueryableSize(), new MarshalQueryableSizeF(), new MarshalQueryableString(), new MarshalQueryableReprocessFormatsMap(), new MarshalQueryableRange(), new MarshalQueryablePair(), new MarshalQueryableMeteringRectangle(), new MarshalQueryableColorSpaceTransform(), new MarshalQueryableStreamConfiguration(), new MarshalQueryableStreamConfigurationDuration(), new MarshalQueryableRggbChannelVector(), new MarshalQueryableBlackLevelPattern(), new MarshalQueryableHighSpeedVideoConfiguration(), new MarshalQueryableParcelable()};
        int length = marshalQueryableArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            MarshalRegistry.registerMarshalQueryable(marshalQueryableArr[i2]);
            i = i2 + 1;
        }
        if (VERBOSE) {
            Log.v(TAG, "Registered metadata marshalers");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean setAvailableFormats(int[] iArr) {
        if (iArr == null) {
            return false;
        }
        int[] iArr2 = new int[iArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iArr.length) {
                setBase((CameraCharacteristics.Key<CameraCharacteristics.Key<int[]>>) CameraCharacteristics.SCALER_AVAILABLE_FORMATS, (CameraCharacteristics.Key<int[]>) iArr2);
                return true;
            }
            iArr2[i2] = iArr[i2];
            if (iArr[i2] == 256) {
                iArr2[i2] = 33;
            }
            i = i2 + 1;
        }
    }

    private <T> void setBase(CameraCharacteristics.Key<T> key, T t) {
        setBase((Key<Key<T>>) key.getNativeKey(), (Key<T>) t);
    }

    private <T> void setBase(CaptureRequest.Key<T> key, T t) {
        setBase((Key<Key<T>>) key.getNativeKey(), (Key<T>) t);
    }

    private <T> void setBase(CaptureResult.Key<T> key, T t) {
        setBase((Key<Key<T>>) key.getNativeKey(), (Key<T>) t);
    }

    private <T> void setBase(Key<T> key, T t) {
        int tag = key.getTag();
        if (t == null) {
            writeValues(tag, null);
            return;
        }
        Marshaler marshalerForKey = getMarshalerForKey(key);
        byte[] bArr = new byte[marshalerForKey.calculateMarshalSize(t)];
        marshalerForKey.marshal(t, ByteBuffer.wrap(bArr).order(ByteOrder.nativeOrder()));
        writeValues(tag, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean setFaceRectangles(Rect[] rectArr) {
        if (rectArr == null) {
            return false;
        }
        Rect[] rectArr2 = new Rect[rectArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= rectArr2.length) {
                setBase((CaptureResult.Key<CaptureResult.Key<Rect[]>>) CaptureResult.STATISTICS_FACE_RECTANGLES, (CaptureResult.Key<Rect[]>) rectArr2);
                return true;
            }
            rectArr2[i2] = new Rect(rectArr[i2].left, rectArr[i2].top, rectArr[i2].right + rectArr[i2].left, rectArr[i2].bottom + rectArr[i2].top);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean setFaces(Face[] faceArr) {
        int i;
        if (faceArr == null) {
            return false;
        }
        int length = faceArr.length;
        boolean z = true;
        int length2 = faceArr.length;
        int i2 = 0;
        while (i2 < length2) {
            Face face = faceArr[i2];
            if (face == null) {
                i = length - 1;
                Log.w(TAG, "setFaces - null face detected, skipping");
            } else {
                i = length;
                if (face.getId() == -1) {
                    z = false;
                    i = length;
                }
            }
            i2++;
            length = i;
        }
        Rect[] rectArr = new Rect[length];
        byte[] bArr = new byte[length];
        int[] iArr = null;
        int[] iArr2 = null;
        if (z) {
            iArr = new int[length];
            iArr2 = new int[length * 6];
        }
        int i3 = 0;
        int length3 = faceArr.length;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= length3) {
                set((CaptureResult.Key<CaptureResult.Key<Rect[]>>) CaptureResult.STATISTICS_FACE_RECTANGLES, (CaptureResult.Key<Rect[]>) rectArr);
                set((CaptureResult.Key<CaptureResult.Key<int[]>>) CaptureResult.STATISTICS_FACE_IDS, (CaptureResult.Key<int[]>) iArr);
                set((CaptureResult.Key<CaptureResult.Key<int[]>>) CaptureResult.STATISTICS_FACE_LANDMARKS, (CaptureResult.Key<int[]>) iArr2);
                set((CaptureResult.Key<CaptureResult.Key<byte[]>>) CaptureResult.STATISTICS_FACE_SCORES, (CaptureResult.Key<byte[]>) bArr);
                return true;
            }
            Face face2 = faceArr[i5];
            if (face2 != null) {
                rectArr[i3] = face2.getBounds();
                bArr[i3] = (byte) face2.getScore();
                if (z) {
                    iArr[i3] = face2.getId();
                    iArr2[(i3 * 6) + 0] = face2.getLeftEyePosition().x;
                    iArr2[(i3 * 6) + 1] = face2.getLeftEyePosition().y;
                    iArr2[(i3 * 6) + 2] = face2.getRightEyePosition().x;
                    iArr2[(i3 * 6) + 3] = face2.getRightEyePosition().y;
                    iArr2[(i3 * 6) + 4] = face2.getMouthPosition().x;
                    iArr2[(i3 * 6) + 5] = face2.getMouthPosition().y;
                }
                i3++;
            }
            i4 = i5 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean setGpsLocation(Location location) {
        if (location == null) {
            return false;
        }
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        double altitude = location.getAltitude();
        String translateLocationProviderToProcess = translateLocationProviderToProcess(location.getProvider());
        set((CaptureRequest.Key<CaptureRequest.Key<Long>>) CaptureRequest.JPEG_GPS_TIMESTAMP, (CaptureRequest.Key<Long>) Long.valueOf(location.getTime()));
        set((CaptureRequest.Key<CaptureRequest.Key<double[]>>) CaptureRequest.JPEG_GPS_COORDINATES, (CaptureRequest.Key<double[]>) new double[]{latitude, longitude, altitude});
        if (translateLocationProviderToProcess == null) {
            Log.w(TAG, "setGpsLocation - No process method, Location is not from a GPS or NETWORKprovider");
            return true;
        }
        setBase((CaptureRequest.Key<CaptureRequest.Key<String>>) CaptureRequest.JPEG_GPS_PROCESSING_METHOD, (CaptureRequest.Key<String>) translateLocationProviderToProcess);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> boolean setTonemapCurve(TonemapCurve tonemapCurve) {
        if (tonemapCurve == null) {
            return false;
        }
        float[] fArr = new float[3];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 > 2) {
                setBase((CaptureRequest.Key<CaptureRequest.Key<float[]>>) CaptureRequest.TONEMAP_CURVE_RED, (CaptureRequest.Key<float[]>) fArr[0]);
                setBase((CaptureRequest.Key<CaptureRequest.Key<float[]>>) CaptureRequest.TONEMAP_CURVE_GREEN, (CaptureRequest.Key<float[]>) fArr[1]);
                setBase((CaptureRequest.Key<CaptureRequest.Key<float[]>>) CaptureRequest.TONEMAP_CURVE_BLUE, (CaptureRequest.Key<float[]>) fArr[2]);
                return true;
            }
            fArr[i2] = new float[tonemapCurve.getPointCount(i2) * 2];
            tonemapCurve.copyColorCurve(i2, fArr[i2], 0);
            i = i2 + 1;
        }
    }

    private static String translateLocationProviderToProcess(String str) {
        if (str == null) {
            return null;
        }
        boolean z = true;
        switch (str.hashCode()) {
            case 102570:
                if (str.equals("gps")) {
                    z = false;
                    break;
                }
                break;
            case 1843485230:
                if (str.equals("network")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                return GPS_PROCESS;
            case true:
                return CELLID_PROCESS;
            default:
                return null;
        }
    }

    private static String translateProcessToLocationProvider(String str) {
        if (str == null) {
            return null;
        }
        boolean z = true;
        switch (str.hashCode()) {
            case 70794:
                if (str.equals(GPS_PROCESS)) {
                    z = false;
                    break;
                }
                break;
            case 1984215549:
                if (str.equals(CELLID_PROCESS)) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                return "gps";
            case true:
                return "network";
            default:
                return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void dumpToLog() {
        try {
            nativeDump();
        } catch (IOException e) {
            Log.wtf(TAG, "Dump logging failed", e);
        }
    }

    protected void finalize() throws Throwable {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    public <T> T get(CameraCharacteristics.Key<T> key) {
        return (T) get(key.getNativeKey());
    }

    public <T> T get(CaptureRequest.Key<T> key) {
        return (T) get(key.getNativeKey());
    }

    public <T> T get(CaptureResult.Key<T> key) {
        return (T) get(key.getNativeKey());
    }

    public <T> T get(Key<T> key) {
        Preconditions.checkNotNull(key, "key must not be null");
        GetCommand getCommand = sGetCommandMap.get(key);
        return getCommand != null ? (T) getCommand.getValue(this, key) : (T) getBase(key);
    }

    public int getEntryCount() {
        return nativeGetEntryCount();
    }

    public boolean isEmpty() {
        return nativeIsEmpty();
    }

    public void readFromParcel(Parcel parcel) {
        nativeReadFromParcel(parcel);
    }

    public byte[] readValues(int i) {
        return nativeReadValues(i);
    }

    public <T> void set(CameraCharacteristics.Key<T> key, T t) {
        set((Key<Key<T>>) key.getNativeKey(), (Key<T>) t);
    }

    public <T> void set(CaptureRequest.Key<T> key, T t) {
        set((Key<Key<T>>) key.getNativeKey(), (Key<T>) t);
    }

    public <T> void set(CaptureResult.Key<T> key, T t) {
        set((Key<Key<T>>) key.getNativeKey(), (Key<T>) t);
    }

    public <T> void set(Key<T> key, T t) {
        SetCommand setCommand = sSetCommandMap.get(key);
        if (setCommand != null) {
            setCommand.setValue(this, t);
        } else {
            setBase((Key<Key<T>>) key, (Key<T>) t);
        }
    }

    public void swap(CameraMetadataNative cameraMetadataNative) {
        nativeSwap(cameraMetadataNative);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        nativeWriteToParcel(parcel);
    }

    public void writeValues(int i, byte[] bArr) {
        nativeWriteValues(i, bArr);
    }
}

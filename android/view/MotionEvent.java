package android.view;

import android.graphics.Matrix;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;

/* loaded from: source-9557208-dex2jar.jar:android/view/MotionEvent.class */
public final class MotionEvent extends InputEvent implements Parcelable {
    public static final int ACTION_CANCEL = 3;
    public static final int ACTION_DOWN = 0;
    public static final int ACTION_HOVER_ENTER = 9;
    public static final int ACTION_HOVER_EXIT = 10;
    public static final int ACTION_HOVER_MOVE = 7;
    public static final int ACTION_MASK = 255;
    public static final int ACTION_MOVE = 2;
    public static final int ACTION_OUTSIDE = 4;
    @Deprecated
    public static final int ACTION_POINTER_1_DOWN = 5;
    @Deprecated
    public static final int ACTION_POINTER_1_UP = 6;
    @Deprecated
    public static final int ACTION_POINTER_2_DOWN = 261;
    @Deprecated
    public static final int ACTION_POINTER_2_UP = 262;
    @Deprecated
    public static final int ACTION_POINTER_3_DOWN = 517;
    @Deprecated
    public static final int ACTION_POINTER_3_UP = 518;
    public static final int ACTION_POINTER_DOWN = 5;
    @Deprecated
    public static final int ACTION_POINTER_ID_MASK = 65280;
    @Deprecated
    public static final int ACTION_POINTER_ID_SHIFT = 8;
    public static final int ACTION_POINTER_INDEX_MASK = 65280;
    public static final int ACTION_POINTER_INDEX_SHIFT = 8;
    public static final int ACTION_POINTER_UP = 6;
    public static final int ACTION_SCROLL = 8;
    public static final int ACTION_UP = 1;
    public static final int AXIS_BRAKE = 23;
    public static final int AXIS_DISTANCE = 24;
    public static final int AXIS_GAS = 22;
    public static final int AXIS_GENERIC_1 = 32;
    public static final int AXIS_GENERIC_10 = 41;
    public static final int AXIS_GENERIC_11 = 42;
    public static final int AXIS_GENERIC_12 = 43;
    public static final int AXIS_GENERIC_13 = 44;
    public static final int AXIS_GENERIC_14 = 45;
    public static final int AXIS_GENERIC_15 = 46;
    public static final int AXIS_GENERIC_16 = 47;
    public static final int AXIS_GENERIC_2 = 33;
    public static final int AXIS_GENERIC_3 = 34;
    public static final int AXIS_GENERIC_4 = 35;
    public static final int AXIS_GENERIC_5 = 36;
    public static final int AXIS_GENERIC_6 = 37;
    public static final int AXIS_GENERIC_7 = 38;
    public static final int AXIS_GENERIC_8 = 39;
    public static final int AXIS_GENERIC_9 = 40;
    public static final int AXIS_HAT_X = 15;
    public static final int AXIS_HAT_Y = 16;
    public static final int AXIS_HSCROLL = 10;
    public static final int AXIS_LTRIGGER = 17;
    public static final int AXIS_ORIENTATION = 8;
    public static final int AXIS_PRESSURE = 2;
    public static final int AXIS_RTRIGGER = 18;
    public static final int AXIS_RUDDER = 20;
    public static final int AXIS_RX = 12;
    public static final int AXIS_RY = 13;
    public static final int AXIS_RZ = 14;
    public static final int AXIS_SIZE = 3;
    private static final SparseArray<String> AXIS_SYMBOLIC_NAMES = new SparseArray<>();
    public static final int AXIS_THROTTLE = 19;
    public static final int AXIS_TILT = 25;
    public static final int AXIS_TOOL_MAJOR = 6;
    public static final int AXIS_TOOL_MINOR = 7;
    public static final int AXIS_TOUCH_MAJOR = 4;
    public static final int AXIS_TOUCH_MINOR = 5;
    public static final int AXIS_VSCROLL = 9;
    public static final int AXIS_WHEEL = 21;
    public static final int AXIS_X = 0;
    public static final int AXIS_Y = 1;
    public static final int AXIS_Z = 11;
    public static final int BUTTON_BACK = 8;
    public static final int BUTTON_FORWARD = 16;
    public static final int BUTTON_PRIMARY = 1;
    public static final int BUTTON_SECONDARY = 2;
    private static final String[] BUTTON_SYMBOLIC_NAMES = null;
    public static final int BUTTON_TERTIARY = 4;
    public static final Parcelable.Creator<MotionEvent> CREATOR = null;
    public static final int EDGE_BOTTOM = 2;
    public static final int EDGE_LEFT = 4;
    public static final int EDGE_RIGHT = 8;
    public static final int EDGE_TOP = 1;
    public static final int FLAG_TAINTED = Integer.MIN_VALUE;
    public static final int FLAG_TARGET_ACCESSIBILITY_FOCUS = 1073741824;
    public static final int FLAG_WINDOW_IS_OBSCURED = 1;
    private static final int HISTORY_CURRENT = Integer.MIN_VALUE;
    public static final int INVALID_POINTER_ID = -1;
    private static final String LABEL_PREFIX = "AXIS_";
    private static final int MAX_RECYCLED = 10;
    private static final long NS_PER_MS = 1000000;
    public static final int TOOL_TYPE_ERASER = 4;
    public static final int TOOL_TYPE_FINGER = 1;
    public static final int TOOL_TYPE_MOUSE = 3;
    public static final int TOOL_TYPE_STYLUS = 2;
    private static final SparseArray<String> TOOL_TYPE_SYMBOLIC_NAMES = null;
    public static final int TOOL_TYPE_UNKNOWN = 0;
    private static final Object gRecyclerLock = null;
    private static MotionEvent gRecyclerTop;
    private static int gRecyclerUsed;
    private static final Object gSharedTempLock = null;
    private static PointerCoords[] gSharedTempPointerCoords;
    private static int[] gSharedTempPointerIndexMap;
    private static PointerProperties[] gSharedTempPointerProperties;
    private long mNativePtr;
    private MotionEvent mNext;

    /* renamed from: android.view.MotionEvent$1  reason: invalid class name */
    /* loaded from: source-9557208-dex2jar.jar:android/view/MotionEvent$1.class */
    static final class AnonymousClass1 implements Parcelable.Creator<MotionEvent> {
        AnonymousClass1() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MotionEvent createFromParcel(Parcel parcel) {
            parcel.readInt();
            return MotionEvent.createFromParcelBody(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MotionEvent[] newArray(int i) {
            return new MotionEvent[i];
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/view/MotionEvent$PointerCoords.class */
    public static final class PointerCoords {
        private static final int INITIAL_PACKED_AXIS_VALUES = 8;
        private long mPackedAxisBits;
        private float[] mPackedAxisValues;
        public float orientation;
        public float pressure;
        public float size;
        public float toolMajor;
        public float toolMinor;
        public float touchMajor;
        public float touchMinor;
        public float x;
        public float y;

        public PointerCoords() {
        }

        public PointerCoords(PointerCoords pointerCoords) {
            copyFrom(pointerCoords);
        }

        public static PointerCoords[] createArray(int i) {
            PointerCoords[] pointerCoordsArr = new PointerCoords[i];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    return pointerCoordsArr;
                }
                pointerCoordsArr[i3] = new PointerCoords();
                i2 = i3 + 1;
            }
        }

        public void clear() {
            this.mPackedAxisBits = 0L;
            this.x = 0.0f;
            this.y = 0.0f;
            this.pressure = 0.0f;
            this.size = 0.0f;
            this.touchMajor = 0.0f;
            this.touchMinor = 0.0f;
            this.toolMajor = 0.0f;
            this.toolMinor = 0.0f;
            this.orientation = 0.0f;
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x002e, code lost:
            if (r0 > r0.length) goto L8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void copyFrom(android.view.MotionEvent.PointerCoords r7) {
            /*
                r6 = this;
                r0 = r7
                long r0 = r0.mPackedAxisBits
                r9 = r0
                r0 = r6
                r1 = r9
                r0.mPackedAxisBits = r1
                r0 = r9
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 == 0) goto L48
                r0 = r7
                float[] r0 = r0.mPackedAxisValues
                r13 = r0
                r0 = r9
                int r0 = java.lang.Long.bitCount(r0)
                r8 = r0
                r0 = r6
                float[] r0 = r0.mPackedAxisValues
                r12 = r0
                r0 = r12
                if (r0 == 0) goto L31
                r0 = r12
                r11 = r0
                r0 = r8
                r1 = r12
                int r1 = r1.length
                if (r0 <= r1) goto L3e
            L31:
                r0 = r13
                int r0 = r0.length
                float[] r0 = new float[r0]
                r11 = r0
                r0 = r6
                r1 = r11
                r0.mPackedAxisValues = r1
            L3e:
                r0 = r13
                r1 = 0
                r2 = r11
                r3 = 0
                r4 = r8
                java.lang.System.arraycopy(r0, r1, r2, r3, r4)
            L48:
                r0 = r6
                r1 = r7
                float r1 = r1.x
                r0.x = r1
                r0 = r6
                r1 = r7
                float r1 = r1.y
                r0.y = r1
                r0 = r6
                r1 = r7
                float r1 = r1.pressure
                r0.pressure = r1
                r0 = r6
                r1 = r7
                float r1 = r1.size
                r0.size = r1
                r0 = r6
                r1 = r7
                float r1 = r1.touchMajor
                r0.touchMajor = r1
                r0 = r6
                r1 = r7
                float r1 = r1.touchMinor
                r0.touchMinor = r1
                r0 = r6
                r1 = r7
                float r1 = r1.toolMajor
                r0.toolMajor = r1
                r0 = r6
                r1 = r7
                float r1 = r1.toolMinor
                r0.toolMinor = r1
                r0 = r6
                r1 = r7
                float r1 = r1.orientation
                r0.orientation = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.view.MotionEvent.PointerCoords.copyFrom(android.view.MotionEvent$PointerCoords):void");
        }

        public float getAxisValue(int i) {
            switch (i) {
                case 0:
                    return this.x;
                case 1:
                    return this.y;
                case 2:
                    return this.pressure;
                case 3:
                    return this.size;
                case 4:
                    return this.touchMajor;
                case 5:
                    return this.touchMinor;
                case 6:
                    return this.toolMajor;
                case 7:
                    return this.toolMinor;
                case 8:
                    return this.orientation;
                default:
                    if (i < 0 || i > 63) {
                        throw new IllegalArgumentException("Axis out of range.");
                    }
                    long j = this.mPackedAxisBits;
                    if ((j & ((-9223372036854775808) >>> i)) == 0) {
                        return 0.0f;
                    }
                    return this.mPackedAxisValues[Long.bitCount((((-1) >>> i) ^ (-1)) & j)];
            }
        }

        public void setAxisValue(int i, float f) {
            switch (i) {
                case 0:
                    this.x = f;
                    return;
                case 1:
                    this.y = f;
                    return;
                case 2:
                    this.pressure = f;
                    return;
                case 3:
                    this.size = f;
                    return;
                case 4:
                    this.touchMajor = f;
                    return;
                case 5:
                    this.touchMinor = f;
                    return;
                case 6:
                    this.toolMajor = f;
                    return;
                case 7:
                    this.toolMinor = f;
                    return;
                case 8:
                    this.orientation = f;
                    return;
                default:
                    if (i < 0 || i > 63) {
                        throw new IllegalArgumentException("Axis out of range.");
                    }
                    long j = this.mPackedAxisBits;
                    long j2 = (-9223372036854775808) >>> i;
                    int bitCount = Long.bitCount((((-1) >>> i) ^ (-1)) & j);
                    float[] fArr = this.mPackedAxisValues;
                    float[] fArr2 = fArr;
                    if ((j & j2) == 0) {
                        if (fArr == null) {
                            fArr2 = new float[8];
                            this.mPackedAxisValues = fArr2;
                        } else {
                            int bitCount2 = Long.bitCount(j);
                            if (bitCount2 < fArr.length) {
                                fArr2 = fArr;
                                if (bitCount != bitCount2) {
                                    System.arraycopy(fArr, bitCount, fArr, bitCount + 1, bitCount2 - bitCount);
                                    fArr2 = fArr;
                                }
                            } else {
                                fArr2 = new float[bitCount2 * 2];
                                System.arraycopy(fArr, 0, fArr2, 0, bitCount);
                                System.arraycopy(fArr, bitCount, fArr2, bitCount + 1, bitCount2 - bitCount);
                                this.mPackedAxisValues = fArr2;
                            }
                        }
                        this.mPackedAxisBits = j | j2;
                    }
                    fArr2[bitCount] = f;
                    return;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/view/MotionEvent$PointerProperties.class */
    public static final class PointerProperties {
        public int id;
        public int toolType;

        public PointerProperties() {
            clear();
        }

        public PointerProperties(PointerProperties pointerProperties) {
            copyFrom(pointerProperties);
        }

        public static PointerProperties[] createArray(int i) {
            PointerProperties[] pointerPropertiesArr = new PointerProperties[i];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    return pointerPropertiesArr;
                }
                pointerPropertiesArr[i3] = new PointerProperties();
                i2 = i3 + 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean equals(PointerProperties pointerProperties) {
            return pointerProperties != null && this.id == pointerProperties.id && this.toolType == pointerProperties.toolType;
        }

        public void clear() {
            this.id = -1;
            this.toolType = 0;
        }

        public void copyFrom(PointerProperties pointerProperties) {
            this.id = pointerProperties.id;
            this.toolType = pointerProperties.toolType;
        }

        public boolean equals(Object obj) {
            if (obj instanceof PointerProperties) {
                return equals((PointerProperties) obj);
            }
            return false;
        }

        public int hashCode() {
            return this.id | (this.toolType << 8);
        }
    }

    static {
        SparseArray<String> sparseArray = AXIS_SYMBOLIC_NAMES;
        throw new VerifyError("bad dex opcode");
    }

    private MotionEvent() {
    }

    public static String actionToString(int i) {
        switch (i) {
            case 0:
                return "ACTION_DOWN";
            case 1:
                return "ACTION_UP";
            case 2:
                return "ACTION_MOVE";
            case 3:
                return "ACTION_CANCEL";
            case 4:
                return "ACTION_OUTSIDE";
            case 5:
            case 6:
            default:
                int i2 = (65280 & i) >> 8;
                switch (i & 255) {
                    case 5:
                        return "ACTION_POINTER_DOWN(" + i2 + ")";
                    case 6:
                        return "ACTION_POINTER_UP(" + i2 + ")";
                    default:
                        return Integer.toString(i);
                }
            case 7:
                return "ACTION_HOVER_MOVE";
            case 8:
                return "ACTION_SCROLL";
            case 9:
                return "ACTION_HOVER_ENTER";
            case 10:
                return "ACTION_HOVER_EXIT";
        }
    }

    public static int axisFromString(String str) {
        String str2 = str;
        if (str.startsWith(LABEL_PREFIX)) {
            str2 = str.substring(LABEL_PREFIX.length());
            int nativeAxisFromString = nativeAxisFromString(str2);
            if (nativeAxisFromString >= 0) {
                return nativeAxisFromString;
            }
        }
        try {
            return Integer.parseInt(str2, 10);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static String axisToString(int i) {
        String nativeAxisToString = nativeAxisToString(i);
        return nativeAxisToString != null ? LABEL_PREFIX + nativeAxisToString : Integer.toString(i);
    }

    public static String buttonStateToString(int i) {
        String str;
        if (i != 0) {
            StringBuilder sb = null;
            int i2 = i;
            int i3 = 0;
            while (i2 != 0) {
                boolean z = (i2 & 1) != 0;
                i2 >>>= 1;
                StringBuilder sb2 = sb;
                if (z) {
                    String str2 = BUTTON_SYMBOLIC_NAMES[i3];
                    if (sb == null) {
                        str = str2;
                        if (i2 != 0) {
                            sb2 = new StringBuilder(str2);
                        }
                    } else {
                        sb.append('|');
                        sb.append(str2);
                        sb2 = sb;
                    }
                }
                i3++;
                sb = sb2;
            }
            return sb.toString();
        }
        str = "0";
        return str;
    }

    private static final float clamp(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    public static MotionEvent createFromParcelBody(Parcel parcel) {
        MotionEvent obtain = obtain();
        obtain.mNativePtr = nativeReadFromParcel(obtain.mNativePtr, parcel);
        return obtain;
    }

    private static final void ensureSharedTempPointerCapacity(int i) {
        if (gSharedTempPointerCoords != null && gSharedTempPointerCoords.length >= i) {
            return;
        }
        int length = gSharedTempPointerCoords != null ? gSharedTempPointerCoords.length : 8;
        while (true) {
            int i2 = length;
            if (i2 >= i) {
                gSharedTempPointerCoords = PointerCoords.createArray(i2);
                gSharedTempPointerProperties = PointerProperties.createArray(i2);
                gSharedTempPointerIndexMap = new int[i2];
                return;
            }
            length = i2 * 2;
        }
    }

    private static native void nativeAddBatch(long j, long j2, PointerCoords[] pointerCoordsArr, int i);

    private static native int nativeAxisFromString(String str);

    private static native String nativeAxisToString(int i);

    private static native long nativeCopy(long j, long j2, boolean z);

    private static native void nativeDispose(long j);

    private static native int nativeFindPointerIndex(long j, int i);

    private static native int nativeGetAction(long j);

    private static native float nativeGetAxisValue(long j, int i, int i2, int i3);

    private static native int nativeGetButtonState(long j);

    private static native int nativeGetDeviceId(long j);

    private static native long nativeGetDownTimeNanos(long j);

    private static native int nativeGetEdgeFlags(long j);

    private static native long nativeGetEventTimeNanos(long j, int i);

    private static native int nativeGetFlags(long j);

    private static native int nativeGetHistorySize(long j);

    private static native int nativeGetMetaState(long j);

    private static native void nativeGetPointerCoords(long j, int i, int i2, PointerCoords pointerCoords);

    private static native int nativeGetPointerCount(long j);

    private static native int nativeGetPointerId(long j, int i);

    private static native void nativeGetPointerProperties(long j, int i, PointerProperties pointerProperties);

    private static native float nativeGetRawAxisValue(long j, int i, int i2, int i3);

    private static native int nativeGetSource(long j);

    private static native int nativeGetToolType(long j, int i);

    private static native float nativeGetXOffset(long j);

    private static native float nativeGetXPrecision(long j);

    private static native float nativeGetYOffset(long j);

    private static native float nativeGetYPrecision(long j);

    private static native long nativeInitialize(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, float f, float f2, float f3, float f4, long j2, long j3, int i8, PointerProperties[] pointerPropertiesArr, PointerCoords[] pointerCoordsArr);

    private static native boolean nativeIsTouchEvent(long j);

    private static native void nativeOffsetLocation(long j, float f, float f2);

    private static native long nativeReadFromParcel(long j, Parcel parcel);

    private static native void nativeScale(long j, float f);

    private static native void nativeSetAction(long j, int i);

    private static native void nativeSetDownTimeNanos(long j, long j2);

    private static native void nativeSetEdgeFlags(long j, int i);

    private static native void nativeSetFlags(long j, int i);

    private static native int nativeSetSource(long j, int i);

    private static native void nativeTransform(long j, Matrix matrix);

    private static native void nativeWriteToParcel(long j, Parcel parcel);

    private static MotionEvent obtain() {
        synchronized (gRecyclerLock) {
            MotionEvent motionEvent = gRecyclerTop;
            if (motionEvent == null) {
                return new MotionEvent();
            }
            gRecyclerTop = motionEvent.mNext;
            gRecyclerUsed--;
            motionEvent.mNext = null;
            motionEvent.prepareForReuse();
            return motionEvent;
        }
    }

    public static MotionEvent obtain(long j, long j2, int i, float f, float f2, float f3, float f4, int i2, float f5, float f6, int i3, int i4) {
        MotionEvent obtain = obtain();
        synchronized (gSharedTempLock) {
            ensureSharedTempPointerCapacity(1);
            PointerProperties[] pointerPropertiesArr = gSharedTempPointerProperties;
            pointerPropertiesArr[0].clear();
            pointerPropertiesArr[0].id = 0;
            PointerCoords[] pointerCoordsArr = gSharedTempPointerCoords;
            pointerCoordsArr[0].clear();
            pointerCoordsArr[0].x = f;
            pointerCoordsArr[0].y = f2;
            pointerCoordsArr[0].pressure = f3;
            pointerCoordsArr[0].size = f4;
            obtain.mNativePtr = nativeInitialize(obtain.mNativePtr, i3, 0, i, 0, i4, i2, 0, 0.0f, 0.0f, f5, f6, j * 1000000, j2 * 1000000, 1, pointerPropertiesArr, pointerCoordsArr);
        }
        return obtain;
    }

    public static MotionEvent obtain(long j, long j2, int i, float f, float f2, int i2) {
        return obtain(j, j2, i, f, f2, 1.0f, 1.0f, i2, 1.0f, 1.0f, 0, 0);
    }

    @Deprecated
    public static MotionEvent obtain(long j, long j2, int i, int i2, float f, float f2, float f3, float f4, int i3, float f5, float f6, int i4, int i5) {
        return obtain(j, j2, i, f, f2, f3, f4, i3, f5, f6, i4, i5);
    }

    @Deprecated
    public static MotionEvent obtain(long j, long j2, int i, int i2, int[] iArr, PointerCoords[] pointerCoordsArr, int i3, float f, float f2, int i4, int i5, int i6, int i7) {
        MotionEvent obtain;
        synchronized (gSharedTempLock) {
            ensureSharedTempPointerCapacity(i2);
            PointerProperties[] pointerPropertiesArr = gSharedTempPointerProperties;
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 < i2) {
                    pointerPropertiesArr[i9].clear();
                    pointerPropertiesArr[i9].id = iArr[i9];
                    i8 = i9 + 1;
                } else {
                    obtain = obtain(j, j2, i, i2, pointerPropertiesArr, pointerCoordsArr, i3, 0, f, f2, i4, i5, i6, i7);
                }
            }
        }
        return obtain;
    }

    public static MotionEvent obtain(long j, long j2, int i, int i2, PointerProperties[] pointerPropertiesArr, PointerCoords[] pointerCoordsArr, int i3, int i4, float f, float f2, int i5, int i6, int i7, int i8) {
        MotionEvent obtain = obtain();
        obtain.mNativePtr = nativeInitialize(obtain.mNativePtr, i5, i7, i, i8, i6, i3, i4, 0.0f, 0.0f, f, f2, j * 1000000, j2 * 1000000, i2, pointerPropertiesArr, pointerCoordsArr);
        return obtain;
    }

    public static MotionEvent obtain(MotionEvent motionEvent) {
        if (motionEvent == null) {
            throw new IllegalArgumentException("other motion event must not be null");
        }
        MotionEvent obtain = obtain();
        obtain.mNativePtr = nativeCopy(obtain.mNativePtr, motionEvent.mNativePtr, true);
        return obtain;
    }

    public static MotionEvent obtainNoHistory(MotionEvent motionEvent) {
        if (motionEvent == null) {
            throw new IllegalArgumentException("other motion event must not be null");
        }
        MotionEvent obtain = obtain();
        obtain.mNativePtr = nativeCopy(obtain.mNativePtr, motionEvent.mNativePtr, false);
        return obtain;
    }

    public static String toolTypeToString(int i) {
        String str = TOOL_TYPE_SYMBOLIC_NAMES.get(i);
        return str != null ? str : Integer.toString(i);
    }

    public final void addBatch(long j, float f, float f2, float f3, float f4, int i) {
        synchronized (gSharedTempLock) {
            ensureSharedTempPointerCapacity(1);
            PointerCoords[] pointerCoordsArr = gSharedTempPointerCoords;
            pointerCoordsArr[0].clear();
            pointerCoordsArr[0].x = f;
            pointerCoordsArr[0].y = f2;
            pointerCoordsArr[0].pressure = f3;
            pointerCoordsArr[0].size = f4;
            nativeAddBatch(this.mNativePtr, 1000000 * j, pointerCoordsArr, i);
        }
    }

    public final void addBatch(long j, PointerCoords[] pointerCoordsArr, int i) {
        nativeAddBatch(this.mNativePtr, 1000000 * j, pointerCoordsArr, i);
    }

    public final boolean addBatch(MotionEvent motionEvent) {
        int nativeGetPointerCount;
        int nativeGetAction = nativeGetAction(this.mNativePtr);
        if ((nativeGetAction != 2 && nativeGetAction != 7) || nativeGetAction != nativeGetAction(motionEvent.mNativePtr) || nativeGetDeviceId(this.mNativePtr) != nativeGetDeviceId(motionEvent.mNativePtr) || nativeGetSource(this.mNativePtr) != nativeGetSource(motionEvent.mNativePtr) || nativeGetFlags(this.mNativePtr) != nativeGetFlags(motionEvent.mNativePtr) || (nativeGetPointerCount = nativeGetPointerCount(this.mNativePtr)) != nativeGetPointerCount(motionEvent.mNativePtr)) {
            return false;
        }
        synchronized (gSharedTempLock) {
            ensureSharedTempPointerCapacity(Math.max(nativeGetPointerCount, 2));
            PointerProperties[] pointerPropertiesArr = gSharedTempPointerProperties;
            PointerCoords[] pointerCoordsArr = gSharedTempPointerCoords;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < nativeGetPointerCount) {
                    nativeGetPointerProperties(this.mNativePtr, i2, pointerPropertiesArr[0]);
                    nativeGetPointerProperties(motionEvent.mNativePtr, i2, pointerPropertiesArr[1]);
                    if (!pointerPropertiesArr[0].equals(pointerPropertiesArr[1])) {
                        return false;
                    }
                    i = i2 + 1;
                } else {
                    int nativeGetMetaState = nativeGetMetaState(motionEvent.mNativePtr);
                    int nativeGetHistorySize = nativeGetHistorySize(motionEvent.mNativePtr);
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 > nativeGetHistorySize) {
                            return true;
                        }
                        int i5 = i4 == nativeGetHistorySize ? Integer.MIN_VALUE : i4;
                        int i6 = 0;
                        while (true) {
                            int i7 = i6;
                            if (i7 >= nativeGetPointerCount) {
                                break;
                            }
                            nativeGetPointerCoords(motionEvent.mNativePtr, i7, i5, pointerCoordsArr[i7]);
                            i6 = i7 + 1;
                        }
                        nativeAddBatch(this.mNativePtr, nativeGetEventTimeNanos(motionEvent.mNativePtr, i5), pointerCoordsArr, nativeGetMetaState);
                        i3 = i4 + 1;
                    }
                }
            }
        }
    }

    @Override // android.view.InputEvent
    public final void cancel() {
        setAction(3);
    }

    public final MotionEvent clampNoHistory(float f, float f2, float f3, float f4) {
        MotionEvent obtain = obtain();
        synchronized (gSharedTempLock) {
            int nativeGetPointerCount = nativeGetPointerCount(this.mNativePtr);
            ensureSharedTempPointerCapacity(nativeGetPointerCount);
            PointerProperties[] pointerPropertiesArr = gSharedTempPointerProperties;
            PointerCoords[] pointerCoordsArr = gSharedTempPointerCoords;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < nativeGetPointerCount) {
                    nativeGetPointerProperties(this.mNativePtr, i2, pointerPropertiesArr[i2]);
                    nativeGetPointerCoords(this.mNativePtr, i2, Integer.MIN_VALUE, pointerCoordsArr[i2]);
                    pointerCoordsArr[i2].x = clamp(pointerCoordsArr[i2].x, f, f3);
                    pointerCoordsArr[i2].y = clamp(pointerCoordsArr[i2].y, f2, f4);
                    i = i2 + 1;
                } else {
                    obtain.mNativePtr = nativeInitialize(obtain.mNativePtr, nativeGetDeviceId(this.mNativePtr), nativeGetSource(this.mNativePtr), nativeGetAction(this.mNativePtr), nativeGetFlags(this.mNativePtr), nativeGetEdgeFlags(this.mNativePtr), nativeGetMetaState(this.mNativePtr), nativeGetButtonState(this.mNativePtr), nativeGetXOffset(this.mNativePtr), nativeGetYOffset(this.mNativePtr), nativeGetXPrecision(this.mNativePtr), nativeGetYPrecision(this.mNativePtr), nativeGetDownTimeNanos(this.mNativePtr), nativeGetEventTimeNanos(this.mNativePtr, Integer.MIN_VALUE), nativeGetPointerCount, pointerPropertiesArr, pointerCoordsArr);
                }
            }
        }
        return obtain;
    }

    @Override // android.view.InputEvent
    public MotionEvent copy() {
        return obtain(this);
    }

    protected void finalize() throws Throwable {
        try {
            if (this.mNativePtr != 0) {
                nativeDispose(this.mNativePtr);
                this.mNativePtr = 0L;
            }
        } finally {
            super.finalize();
        }
    }

    public final int findPointerIndex(int i) {
        return nativeFindPointerIndex(this.mNativePtr, i);
    }

    public final int getAction() {
        return nativeGetAction(this.mNativePtr);
    }

    public final int getActionIndex() {
        return (nativeGetAction(this.mNativePtr) & 65280) >> 8;
    }

    public final int getActionMasked() {
        return nativeGetAction(this.mNativePtr) & 255;
    }

    public final float getAxisValue(int i) {
        return nativeGetAxisValue(this.mNativePtr, i, 0, Integer.MIN_VALUE);
    }

    public final float getAxisValue(int i, int i2) {
        return nativeGetAxisValue(this.mNativePtr, i, i2, Integer.MIN_VALUE);
    }

    public final int getButtonState() {
        return nativeGetButtonState(this.mNativePtr);
    }

    @Override // android.view.InputEvent
    public final int getDeviceId() {
        return nativeGetDeviceId(this.mNativePtr);
    }

    public final long getDownTime() {
        return nativeGetDownTimeNanos(this.mNativePtr) / 1000000;
    }

    public final int getEdgeFlags() {
        return nativeGetEdgeFlags(this.mNativePtr);
    }

    @Override // android.view.InputEvent
    public final long getEventTime() {
        return nativeGetEventTimeNanos(this.mNativePtr, Integer.MIN_VALUE) / 1000000;
    }

    @Override // android.view.InputEvent
    public final long getEventTimeNano() {
        return nativeGetEventTimeNanos(this.mNativePtr, Integer.MIN_VALUE);
    }

    public final int getFlags() {
        return nativeGetFlags(this.mNativePtr);
    }

    public final float getHistoricalAxisValue(int i, int i2) {
        return nativeGetAxisValue(this.mNativePtr, i, 0, i2);
    }

    public final float getHistoricalAxisValue(int i, int i2, int i3) {
        return nativeGetAxisValue(this.mNativePtr, i, i2, i3);
    }

    public final long getHistoricalEventTime(int i) {
        return nativeGetEventTimeNanos(this.mNativePtr, i) / 1000000;
    }

    public final long getHistoricalEventTimeNano(int i) {
        return nativeGetEventTimeNanos(this.mNativePtr, i);
    }

    public final float getHistoricalOrientation(int i) {
        return nativeGetAxisValue(this.mNativePtr, 8, 0, i);
    }

    public final float getHistoricalOrientation(int i, int i2) {
        return nativeGetAxisValue(this.mNativePtr, 8, i, i2);
    }

    public final void getHistoricalPointerCoords(int i, int i2, PointerCoords pointerCoords) {
        nativeGetPointerCoords(this.mNativePtr, i, i2, pointerCoords);
    }

    public final float getHistoricalPressure(int i) {
        return nativeGetAxisValue(this.mNativePtr, 2, 0, i);
    }

    public final float getHistoricalPressure(int i, int i2) {
        return nativeGetAxisValue(this.mNativePtr, 2, i, i2);
    }

    public final float getHistoricalSize(int i) {
        return nativeGetAxisValue(this.mNativePtr, 3, 0, i);
    }

    public final float getHistoricalSize(int i, int i2) {
        return nativeGetAxisValue(this.mNativePtr, 3, i, i2);
    }

    public final float getHistoricalToolMajor(int i) {
        return nativeGetAxisValue(this.mNativePtr, 6, 0, i);
    }

    public final float getHistoricalToolMajor(int i, int i2) {
        return nativeGetAxisValue(this.mNativePtr, 6, i, i2);
    }

    public final float getHistoricalToolMinor(int i) {
        return nativeGetAxisValue(this.mNativePtr, 7, 0, i);
    }

    public final float getHistoricalToolMinor(int i, int i2) {
        return nativeGetAxisValue(this.mNativePtr, 7, i, i2);
    }

    public final float getHistoricalTouchMajor(int i) {
        return nativeGetAxisValue(this.mNativePtr, 4, 0, i);
    }

    public final float getHistoricalTouchMajor(int i, int i2) {
        return nativeGetAxisValue(this.mNativePtr, 4, i, i2);
    }

    public final float getHistoricalTouchMinor(int i) {
        return nativeGetAxisValue(this.mNativePtr, 5, 0, i);
    }

    public final float getHistoricalTouchMinor(int i, int i2) {
        return nativeGetAxisValue(this.mNativePtr, 5, i, i2);
    }

    public final float getHistoricalX(int i) {
        return nativeGetAxisValue(this.mNativePtr, 0, 0, i);
    }

    public final float getHistoricalX(int i, int i2) {
        return nativeGetAxisValue(this.mNativePtr, 0, i, i2);
    }

    public final float getHistoricalY(int i) {
        return nativeGetAxisValue(this.mNativePtr, 1, 0, i);
    }

    public final float getHistoricalY(int i, int i2) {
        return nativeGetAxisValue(this.mNativePtr, 1, i, i2);
    }

    public final int getHistorySize() {
        return nativeGetHistorySize(this.mNativePtr);
    }

    public final int getMetaState() {
        return nativeGetMetaState(this.mNativePtr);
    }

    public final float getOrientation() {
        return nativeGetAxisValue(this.mNativePtr, 8, 0, Integer.MIN_VALUE);
    }

    public final float getOrientation(int i) {
        return nativeGetAxisValue(this.mNativePtr, 8, i, Integer.MIN_VALUE);
    }

    public final void getPointerCoords(int i, PointerCoords pointerCoords) {
        nativeGetPointerCoords(this.mNativePtr, i, Integer.MIN_VALUE, pointerCoords);
    }

    public final int getPointerCount() {
        return nativeGetPointerCount(this.mNativePtr);
    }

    public final int getPointerId(int i) {
        return nativeGetPointerId(this.mNativePtr, i);
    }

    public final int getPointerIdBits() {
        int i = 0;
        int nativeGetPointerCount = nativeGetPointerCount(this.mNativePtr);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= nativeGetPointerCount) {
                return i;
            }
            i |= 1 << nativeGetPointerId(this.mNativePtr, i3);
            i2 = i3 + 1;
        }
    }

    public final void getPointerProperties(int i, PointerProperties pointerProperties) {
        nativeGetPointerProperties(this.mNativePtr, i, pointerProperties);
    }

    public final float getPressure() {
        return nativeGetAxisValue(this.mNativePtr, 2, 0, Integer.MIN_VALUE);
    }

    public final float getPressure(int i) {
        return nativeGetAxisValue(this.mNativePtr, 2, i, Integer.MIN_VALUE);
    }

    public final float getRawX() {
        return nativeGetRawAxisValue(this.mNativePtr, 0, 0, Integer.MIN_VALUE);
    }

    public final float getRawY() {
        return nativeGetRawAxisValue(this.mNativePtr, 1, 0, Integer.MIN_VALUE);
    }

    public final float getSize() {
        return nativeGetAxisValue(this.mNativePtr, 3, 0, Integer.MIN_VALUE);
    }

    public final float getSize(int i) {
        return nativeGetAxisValue(this.mNativePtr, 3, i, Integer.MIN_VALUE);
    }

    @Override // android.view.InputEvent
    public final int getSource() {
        return nativeGetSource(this.mNativePtr);
    }

    public final float getToolMajor() {
        return nativeGetAxisValue(this.mNativePtr, 6, 0, Integer.MIN_VALUE);
    }

    public final float getToolMajor(int i) {
        return nativeGetAxisValue(this.mNativePtr, 6, i, Integer.MIN_VALUE);
    }

    public final float getToolMinor() {
        return nativeGetAxisValue(this.mNativePtr, 7, 0, Integer.MIN_VALUE);
    }

    public final float getToolMinor(int i) {
        return nativeGetAxisValue(this.mNativePtr, 7, i, Integer.MIN_VALUE);
    }

    public final int getToolType(int i) {
        return nativeGetToolType(this.mNativePtr, i);
    }

    public final float getTouchMajor() {
        return nativeGetAxisValue(this.mNativePtr, 4, 0, Integer.MIN_VALUE);
    }

    public final float getTouchMajor(int i) {
        return nativeGetAxisValue(this.mNativePtr, 4, i, Integer.MIN_VALUE);
    }

    public final float getTouchMinor() {
        return nativeGetAxisValue(this.mNativePtr, 5, 0, Integer.MIN_VALUE);
    }

    public final float getTouchMinor(int i) {
        return nativeGetAxisValue(this.mNativePtr, 5, i, Integer.MIN_VALUE);
    }

    public final float getX() {
        return nativeGetAxisValue(this.mNativePtr, 0, 0, Integer.MIN_VALUE);
    }

    public final float getX(int i) {
        return nativeGetAxisValue(this.mNativePtr, 0, i, Integer.MIN_VALUE);
    }

    public final float getXPrecision() {
        return nativeGetXPrecision(this.mNativePtr);
    }

    public final float getY() {
        return nativeGetAxisValue(this.mNativePtr, 1, 0, Integer.MIN_VALUE);
    }

    public final float getY(int i) {
        return nativeGetAxisValue(this.mNativePtr, 1, i, Integer.MIN_VALUE);
    }

    public final float getYPrecision() {
        return nativeGetYPrecision(this.mNativePtr);
    }

    public final boolean isButtonPressed(int i) {
        return i != 0 && (getButtonState() & i) == i;
    }

    @Override // android.view.InputEvent
    public final boolean isTainted() {
        return (Integer.MIN_VALUE & getFlags()) != 0;
    }

    public final boolean isTargetAccessibilityFocus() {
        return (1073741824 & getFlags()) != 0;
    }

    public final boolean isTouchEvent() {
        return nativeIsTouchEvent(this.mNativePtr);
    }

    public final boolean isWithinBoundsNoHistory(float f, float f2, float f3, float f4) {
        int nativeGetPointerCount = nativeGetPointerCount(this.mNativePtr);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= nativeGetPointerCount) {
                return true;
            }
            float nativeGetAxisValue = nativeGetAxisValue(this.mNativePtr, 0, i2, Integer.MIN_VALUE);
            float nativeGetAxisValue2 = nativeGetAxisValue(this.mNativePtr, 1, i2, Integer.MIN_VALUE);
            if (nativeGetAxisValue < f || nativeGetAxisValue > f3 || nativeGetAxisValue2 < f2 || nativeGetAxisValue2 > f4) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public final void offsetLocation(float f, float f2) {
        if (f == 0.0f && f2 == 0.0f) {
            return;
        }
        nativeOffsetLocation(this.mNativePtr, f, f2);
    }

    @Override // android.view.InputEvent
    public final void recycle() {
        super.recycle();
        synchronized (gRecyclerLock) {
            if (gRecyclerUsed < 10) {
                gRecyclerUsed++;
                this.mNext = gRecyclerTop;
                gRecyclerTop = this;
            }
        }
    }

    public final void scale(float f) {
        if (f != 1.0f) {
            nativeScale(this.mNativePtr, f);
        }
    }

    public final void setAction(int i) {
        nativeSetAction(this.mNativePtr, i);
    }

    public final void setDownTime(long j) {
        nativeSetDownTimeNanos(this.mNativePtr, 1000000 * j);
    }

    public final void setEdgeFlags(int i) {
        nativeSetEdgeFlags(this.mNativePtr, i);
    }

    public final void setLocation(float f, float f2) {
        offsetLocation(f - getX(), f2 - getY());
    }

    @Override // android.view.InputEvent
    public final void setSource(int i) {
        nativeSetSource(this.mNativePtr, i);
    }

    @Override // android.view.InputEvent
    public final void setTainted(boolean z) {
        int flags = getFlags();
        nativeSetFlags(this.mNativePtr, z ? Integer.MIN_VALUE | flags : Integer.MAX_VALUE & flags);
    }

    public final void setTargetAccessibilityFocus(boolean z) {
        int flags = getFlags();
        nativeSetFlags(this.mNativePtr, z ? 1073741824 | flags : (-1073741825) & flags);
    }

    public final MotionEvent split(int i) {
        MotionEvent obtain = obtain();
        synchronized (gSharedTempLock) {
            int nativeGetPointerCount = nativeGetPointerCount(this.mNativePtr);
            ensureSharedTempPointerCapacity(nativeGetPointerCount);
            PointerProperties[] pointerPropertiesArr = gSharedTempPointerProperties;
            PointerCoords[] pointerCoordsArr = gSharedTempPointerCoords;
            int[] iArr = gSharedTempPointerIndexMap;
            int nativeGetAction = nativeGetAction(this.mNativePtr);
            int i2 = nativeGetAction & 255;
            int i3 = -1;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (i6 < nativeGetPointerCount) {
                nativeGetPointerProperties(this.mNativePtr, i6, pointerPropertiesArr[i4]);
                int i7 = 1 << pointerPropertiesArr[i4].id;
                int i8 = i4;
                int i9 = i3;
                int i10 = i5;
                if ((i7 & i) != 0) {
                    if (i6 == ((65280 & nativeGetAction) >> 8)) {
                        i3 = i4;
                    }
                    iArr[i4] = i6;
                    i8 = i4 + 1;
                    i10 = i5 | i7;
                    i9 = i3;
                }
                i6++;
                i4 = i8;
                i3 = i9;
                i5 = i10;
            }
            if (i4 == 0) {
                throw new IllegalArgumentException("idBits did not match any ids in the event");
            }
            int i11 = (i2 == 5 || i2 == 6) ? i3 < 0 ? 2 : i4 == 1 ? i2 == 5 ? 0 : 1 : i2 | (i3 << 8) : nativeGetAction;
            int nativeGetHistorySize = nativeGetHistorySize(this.mNativePtr);
            int i12 = 0;
            while (true) {
                int i13 = i12;
                if (i13 <= nativeGetHistorySize) {
                    int i14 = i13 == nativeGetHistorySize ? Integer.MIN_VALUE : i13;
                    int i15 = 0;
                    while (true) {
                        int i16 = i15;
                        if (i16 >= i4) {
                            break;
                        }
                        nativeGetPointerCoords(this.mNativePtr, iArr[i16], i14, pointerCoordsArr[i16]);
                        i15 = i16 + 1;
                    }
                    long nativeGetEventTimeNanos = nativeGetEventTimeNanos(this.mNativePtr, i14);
                    if (i13 == 0) {
                        obtain.mNativePtr = nativeInitialize(obtain.mNativePtr, nativeGetDeviceId(this.mNativePtr), nativeGetSource(this.mNativePtr), i11, nativeGetFlags(this.mNativePtr), nativeGetEdgeFlags(this.mNativePtr), nativeGetMetaState(this.mNativePtr), nativeGetButtonState(this.mNativePtr), nativeGetXOffset(this.mNativePtr), nativeGetYOffset(this.mNativePtr), nativeGetXPrecision(this.mNativePtr), nativeGetYPrecision(this.mNativePtr), nativeGetDownTimeNanos(this.mNativePtr), nativeGetEventTimeNanos, i4, pointerPropertiesArr, pointerCoordsArr);
                    } else {
                        nativeAddBatch(obtain.mNativePtr, nativeGetEventTimeNanos, pointerCoordsArr, 0);
                    }
                    i12 = i13 + 1;
                }
            }
        }
        return obtain;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MotionEvent { action=").append(actionToString(getAction()));
        int pointerCount = getPointerCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= pointerCount) {
                sb.append(", buttonState=").append(buttonStateToString(getButtonState()));
                sb.append(", metaState=").append(KeyEvent.metaStateToString(getMetaState()));
                sb.append(", flags=0x").append(Integer.toHexString(getFlags()));
                sb.append(", edgeFlags=0x").append(Integer.toHexString(getEdgeFlags()));
                sb.append(", pointerCount=").append(pointerCount);
                sb.append(", historySize=").append(getHistorySize());
                sb.append(", eventTime=").append(getEventTime());
                sb.append(", downTime=").append(getDownTime());
                sb.append(", deviceId=").append(getDeviceId());
                sb.append(", source=0x").append(Integer.toHexString(getSource()));
                sb.append(" }");
                return sb.toString();
            }
            sb.append(", id[").append(i2).append("]=").append(getPointerId(i2));
            sb.append(", x[").append(i2).append("]=").append(getX(i2));
            sb.append(", y[").append(i2).append("]=").append(getY(i2));
            sb.append(", toolType[").append(i2).append("]=").append(toolTypeToString(getToolType(i2)));
            i = i2 + 1;
        }
    }

    public final void transform(Matrix matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("matrix must not be null");
        }
        nativeTransform(this.mNativePtr, matrix);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(1);
        nativeWriteToParcel(this.mNativePtr, parcel);
    }
}

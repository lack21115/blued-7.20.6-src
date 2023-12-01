package android.view;

import android.hardware.input.InputDeviceIdentifier;
import android.hardware.input.InputManager;
import android.os.NullVibrator;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Vibrator;
import com.android.internal.inputmethod.InputMethodUtils;
import com.oplus.quickgame.sdk.hall.Constant;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/view/InputDevice.class */
public final class InputDevice implements Parcelable {
    public static final Parcelable.Creator<InputDevice> CREATOR = new Parcelable.Creator<InputDevice>() { // from class: android.view.InputDevice.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InputDevice createFromParcel(Parcel parcel) {
            return new InputDevice(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InputDevice[] newArray(int i) {
            return new InputDevice[i];
        }
    };
    public static final int KEYBOARD_TYPE_ALPHABETIC = 2;
    public static final int KEYBOARD_TYPE_NONE = 0;
    public static final int KEYBOARD_TYPE_NON_ALPHABETIC = 1;
    @Deprecated
    public static final int MOTION_RANGE_ORIENTATION = 8;
    @Deprecated
    public static final int MOTION_RANGE_PRESSURE = 2;
    @Deprecated
    public static final int MOTION_RANGE_SIZE = 3;
    @Deprecated
    public static final int MOTION_RANGE_TOOL_MAJOR = 6;
    @Deprecated
    public static final int MOTION_RANGE_TOOL_MINOR = 7;
    @Deprecated
    public static final int MOTION_RANGE_TOUCH_MAJOR = 4;
    @Deprecated
    public static final int MOTION_RANGE_TOUCH_MINOR = 5;
    @Deprecated
    public static final int MOTION_RANGE_X = 0;
    @Deprecated
    public static final int MOTION_RANGE_Y = 1;
    public static final int SOURCE_ANY = -256;
    public static final int SOURCE_CLASS_BUTTON = 1;
    public static final int SOURCE_CLASS_JOYSTICK = 16;
    public static final int SOURCE_CLASS_MASK = 255;
    public static final int SOURCE_CLASS_NONE = 0;
    public static final int SOURCE_CLASS_POINTER = 2;
    public static final int SOURCE_CLASS_POSITION = 8;
    public static final int SOURCE_CLASS_TRACKBALL = 4;
    public static final int SOURCE_DPAD = 513;
    public static final int SOURCE_GAMEPAD = 1025;
    public static final int SOURCE_GESTURE_SENSOR = 4194304;
    public static final int SOURCE_HDMI = 33554433;
    public static final int SOURCE_JOYSTICK = 16777232;
    public static final int SOURCE_KEYBOARD = 257;
    public static final int SOURCE_MOUSE = 8194;
    public static final int SOURCE_STYLUS = 16386;
    public static final int SOURCE_TOUCHPAD = 1048584;
    public static final int SOURCE_TOUCHSCREEN = 4098;
    public static final int SOURCE_TOUCH_NAVIGATION = 2097152;
    public static final int SOURCE_TRACKBALL = 65540;
    public static final int SOURCE_UNKNOWN = 0;
    private final int mControllerNumber;
    private final String mDescriptor;
    private final int mGeneration;
    private final boolean mHasButtonUnderPad;
    private final boolean mHasVibrator;
    private final int mId;
    private final InputDeviceIdentifier mIdentifier;
    private final boolean mIsExternal;
    private final KeyCharacterMap mKeyCharacterMap;
    private final int mKeyboardType;
    private final ArrayList<MotionRange> mMotionRanges;
    private final String mName;
    private final int mProductId;
    private final int mSources;
    private final int mVendorId;
    private Vibrator mVibrator;

    /* loaded from: source-9557208-dex2jar.jar:android/view/InputDevice$MotionRange.class */
    public static final class MotionRange {
        private int mAxis;
        private float mFlat;
        private float mFuzz;
        private float mMax;
        private float mMin;
        private float mResolution;
        private int mSource;

        private MotionRange(int i, int i2, float f, float f2, float f3, float f4, float f5) {
            this.mAxis = i;
            this.mSource = i2;
            this.mMin = f;
            this.mMax = f2;
            this.mFlat = f3;
            this.mFuzz = f4;
            this.mResolution = f5;
        }

        public int getAxis() {
            return this.mAxis;
        }

        public float getFlat() {
            return this.mFlat;
        }

        public float getFuzz() {
            return this.mFuzz;
        }

        public float getMax() {
            return this.mMax;
        }

        public float getMin() {
            return this.mMin;
        }

        public float getRange() {
            return this.mMax - this.mMin;
        }

        public float getResolution() {
            return this.mResolution;
        }

        public int getSource() {
            return this.mSource;
        }

        public boolean isFromSource(int i) {
            return (getSource() & i) == i;
        }
    }

    private InputDevice(int i, int i2, int i3, String str, int i4, int i5, String str2, boolean z, int i6, int i7, KeyCharacterMap keyCharacterMap, boolean z2, boolean z3) {
        this.mMotionRanges = new ArrayList<>();
        this.mId = i;
        this.mGeneration = i2;
        this.mControllerNumber = i3;
        this.mName = str;
        this.mVendorId = i4;
        this.mProductId = i5;
        this.mDescriptor = str2;
        this.mIsExternal = z;
        this.mSources = i6;
        this.mKeyboardType = i7;
        this.mKeyCharacterMap = keyCharacterMap;
        this.mHasVibrator = z2;
        this.mHasButtonUnderPad = z3;
        this.mIdentifier = new InputDeviceIdentifier(str2, i4, i5);
    }

    private InputDevice(Parcel parcel) {
        this.mMotionRanges = new ArrayList<>();
        this.mId = parcel.readInt();
        this.mGeneration = parcel.readInt();
        this.mControllerNumber = parcel.readInt();
        this.mName = parcel.readString();
        this.mVendorId = parcel.readInt();
        this.mProductId = parcel.readInt();
        this.mDescriptor = parcel.readString();
        this.mIsExternal = parcel.readInt() != 0;
        this.mSources = parcel.readInt();
        this.mKeyboardType = parcel.readInt();
        this.mKeyCharacterMap = KeyCharacterMap.CREATOR.createFromParcel(parcel);
        this.mHasVibrator = parcel.readInt() != 0;
        this.mHasButtonUnderPad = parcel.readInt() != 0;
        this.mIdentifier = new InputDeviceIdentifier(this.mDescriptor, this.mVendorId, this.mProductId);
        while (true) {
            int readInt = parcel.readInt();
            if (readInt < 0) {
                return;
            }
            addMotionRange(readInt, parcel.readInt(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
        }
    }

    private void addMotionRange(int i, int i2, float f, float f2, float f3, float f4, float f5) {
        this.mMotionRanges.add(new MotionRange(i, i2, f, f2, f3, f4, f5));
    }

    private void appendSourceDescriptionIfApplicable(StringBuilder sb, int i, String str) {
        if ((this.mSources & i) == i) {
            sb.append(" ");
            sb.append(str);
        }
    }

    public static InputDevice getDevice(int i) {
        return InputManager.getInstance().getInputDevice(i);
    }

    public static int[] getDeviceIds() {
        return InputManager.getInstance().getInputDeviceIds();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getControllerNumber() {
        return this.mControllerNumber;
    }

    public String getDescriptor() {
        return this.mDescriptor;
    }

    public int getGeneration() {
        return this.mGeneration;
    }

    public int getId() {
        return this.mId;
    }

    public InputDeviceIdentifier getIdentifier() {
        return this.mIdentifier;
    }

    public KeyCharacterMap getKeyCharacterMap() {
        return this.mKeyCharacterMap;
    }

    public int getKeyboardType() {
        return this.mKeyboardType;
    }

    public MotionRange getMotionRange(int i) {
        int size = this.mMotionRanges.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return null;
            }
            MotionRange motionRange = this.mMotionRanges.get(i3);
            if (motionRange.mAxis == i) {
                return motionRange;
            }
            i2 = i3 + 1;
        }
    }

    public MotionRange getMotionRange(int i, int i2) {
        int size = this.mMotionRanges.size();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size) {
                return null;
            }
            MotionRange motionRange = this.mMotionRanges.get(i4);
            if (motionRange.mAxis == i && motionRange.mSource == i2) {
                return motionRange;
            }
            i3 = i4 + 1;
        }
    }

    public List<MotionRange> getMotionRanges() {
        return this.mMotionRanges;
    }

    public String getName() {
        return this.mName;
    }

    public int getProductId() {
        return this.mProductId;
    }

    public int getSources() {
        return this.mSources;
    }

    public int getVendorId() {
        return this.mVendorId;
    }

    public Vibrator getVibrator() {
        Vibrator vibrator;
        synchronized (this.mMotionRanges) {
            if (this.mVibrator == null) {
                if (this.mHasVibrator) {
                    this.mVibrator = InputManager.getInstance().getInputDeviceVibrator(this.mId);
                } else {
                    this.mVibrator = NullVibrator.getInstance();
                }
            }
            vibrator = this.mVibrator;
        }
        return vibrator;
    }

    public boolean hasButtonUnderPad() {
        return this.mHasButtonUnderPad;
    }

    public boolean[] hasKeys(int... iArr) {
        return InputManager.getInstance().deviceHasKeys(this.mId, iArr);
    }

    public boolean isExternal() {
        return this.mIsExternal;
    }

    public boolean isFullKeyboard() {
        return (this.mSources & 257) == 257 && this.mKeyboardType == 2;
    }

    public boolean isVirtual() {
        return this.mId < 0;
    }

    public boolean supportsSource(int i) {
        return (this.mSources & i) == i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Input Device ").append(this.mId).append(": ").append(this.mName).append("\n");
        sb.append("  Descriptor: ").append(this.mDescriptor).append("\n");
        sb.append("  Generation: ").append(this.mGeneration).append("\n");
        sb.append("  Location: ").append(this.mIsExternal ? Constant.Param.KEY_RPK_EXTERNAL : "built-in").append("\n");
        sb.append("  Keyboard Type: ");
        switch (this.mKeyboardType) {
            case 0:
                sb.append("none");
                break;
            case 1:
                sb.append("non-alphabetic");
                break;
            case 2:
                sb.append("alphabetic");
                break;
        }
        sb.append("\n");
        sb.append("  Has Vibrator: ").append(this.mHasVibrator).append("\n");
        sb.append("  Sources: 0x").append(Integer.toHexString(this.mSources)).append(" (");
        appendSourceDescriptionIfApplicable(sb, 257, InputMethodUtils.SUBTYPE_MODE_KEYBOARD);
        appendSourceDescriptionIfApplicable(sb, 513, "dpad");
        appendSourceDescriptionIfApplicable(sb, 4098, "touchscreen");
        appendSourceDescriptionIfApplicable(sb, 8194, "mouse");
        appendSourceDescriptionIfApplicable(sb, 16386, "stylus");
        appendSourceDescriptionIfApplicable(sb, 65540, "trackball");
        appendSourceDescriptionIfApplicable(sb, 1048584, "touchpad");
        appendSourceDescriptionIfApplicable(sb, 16777232, "joystick");
        appendSourceDescriptionIfApplicable(sb, 1025, "gamepad");
        appendSourceDescriptionIfApplicable(sb, 4194304, "gesture");
        sb.append(" )\n");
        int size = this.mMotionRanges.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return sb.toString();
            }
            MotionRange motionRange = this.mMotionRanges.get(i2);
            sb.append("    ").append(MotionEvent.axisToString(motionRange.mAxis));
            sb.append(": source=0x").append(Integer.toHexString(motionRange.mSource));
            sb.append(" min=").append(motionRange.mMin);
            sb.append(" max=").append(motionRange.mMax);
            sb.append(" flat=").append(motionRange.mFlat);
            sb.append(" fuzz=").append(motionRange.mFuzz);
            sb.append(" resolution=").append(motionRange.mResolution);
            sb.append("\n");
            i = i2 + 1;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mId);
        parcel.writeInt(this.mGeneration);
        parcel.writeInt(this.mControllerNumber);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mVendorId);
        parcel.writeInt(this.mProductId);
        parcel.writeString(this.mDescriptor);
        parcel.writeInt(this.mIsExternal ? 1 : 0);
        parcel.writeInt(this.mSources);
        parcel.writeInt(this.mKeyboardType);
        this.mKeyCharacterMap.writeToParcel(parcel, i);
        parcel.writeInt(this.mHasVibrator ? 1 : 0);
        parcel.writeInt(this.mHasButtonUnderPad ? 1 : 0);
        int size = this.mMotionRanges.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                parcel.writeInt(-1);
                return;
            }
            MotionRange motionRange = this.mMotionRanges.get(i3);
            parcel.writeInt(motionRange.mAxis);
            parcel.writeInt(motionRange.mSource);
            parcel.writeFloat(motionRange.mMin);
            parcel.writeFloat(motionRange.mMax);
            parcel.writeFloat(motionRange.mFlat);
            parcel.writeFloat(motionRange.mFuzz);
            parcel.writeFloat(motionRange.mResolution);
            i2 = i3 + 1;
        }
    }
}

package android.filterfw.core;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/NativeProgram.class */
public class NativeProgram extends Program {
    private boolean mHasGetValueFunction;
    private boolean mHasInitFunction;
    private boolean mHasResetFunction;
    private boolean mHasSetValueFunction;
    private boolean mHasTeardownFunction;
    private boolean mTornDown = false;
    private int nativeProgramId;

    static {
        System.loadLibrary("filterfw");
    }

    public NativeProgram(String str, String str2) {
        this.mHasInitFunction = false;
        this.mHasTeardownFunction = false;
        this.mHasSetValueFunction = false;
        this.mHasGetValueFunction = false;
        this.mHasResetFunction = false;
        allocate();
        String str3 = "lib" + str + ".so";
        if (!openNativeLibrary(str3)) {
            throw new RuntimeException("Could not find native library named '" + str3 + "' required for native program!");
        }
        String str4 = str2 + "_process";
        if (!bindProcessFunction(str4)) {
            throw new RuntimeException("Could not find native program function name " + str4 + " in library " + str3 + "! This function is required!");
        }
        this.mHasInitFunction = bindInitFunction(str2 + "_init");
        this.mHasTeardownFunction = bindTeardownFunction(str2 + "_teardown");
        this.mHasSetValueFunction = bindSetValueFunction(str2 + "_setvalue");
        this.mHasGetValueFunction = bindGetValueFunction(str2 + "_getvalue");
        this.mHasResetFunction = bindResetFunction(str2 + "_reset");
        if (this.mHasInitFunction && !callNativeInit()) {
            throw new RuntimeException("Could not initialize NativeProgram!");
        }
    }

    private native boolean allocate();

    private native boolean bindGetValueFunction(String str);

    private native boolean bindInitFunction(String str);

    private native boolean bindProcessFunction(String str);

    private native boolean bindResetFunction(String str);

    private native boolean bindSetValueFunction(String str);

    private native boolean bindTeardownFunction(String str);

    private native String callNativeGetValue(String str);

    private native boolean callNativeInit();

    private native boolean callNativeProcess(NativeFrame[] nativeFrameArr, NativeFrame nativeFrame);

    private native boolean callNativeReset();

    private native boolean callNativeSetValue(String str, String str2);

    private native boolean callNativeTeardown();

    private native boolean deallocate();

    private native boolean nativeInit();

    private native boolean openNativeLibrary(String str);

    protected void finalize() throws Throwable {
        tearDown();
    }

    @Override // android.filterfw.core.Program
    public Object getHostValue(String str) {
        if (this.mTornDown) {
            throw new RuntimeException("NativeProgram already torn down!");
        }
        if (this.mHasGetValueFunction) {
            return callNativeGetValue(str);
        }
        throw new RuntimeException("Attempting to get native variable, but native code does not define native getvalue function!");
    }

    @Override // android.filterfw.core.Program
    public void process(Frame[] frameArr, Frame frame) {
        if (this.mTornDown) {
            throw new RuntimeException("NativeProgram already torn down!");
        }
        NativeFrame[] nativeFrameArr = new NativeFrame[frameArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= frameArr.length) {
                if (frame != null && !(frame instanceof NativeFrame)) {
                    throw new RuntimeException("NativeProgram got non-native output frame!");
                }
                if (!callNativeProcess(nativeFrameArr, (NativeFrame) frame)) {
                    throw new RuntimeException("Calling native process() caused error!");
                }
                return;
            } else if (frameArr[i2] != null && !(frameArr[i2] instanceof NativeFrame)) {
                throw new RuntimeException("NativeProgram got non-native frame as input " + i2 + "!");
            } else {
                nativeFrameArr[i2] = (NativeFrame) frameArr[i2];
                i = i2 + 1;
            }
        }
    }

    @Override // android.filterfw.core.Program
    public void reset() {
        if (this.mHasResetFunction && !callNativeReset()) {
            throw new RuntimeException("Could not reset NativeProgram!");
        }
    }

    @Override // android.filterfw.core.Program
    public void setHostValue(String str, Object obj) {
        if (this.mTornDown) {
            throw new RuntimeException("NativeProgram already torn down!");
        }
        if (!this.mHasSetValueFunction) {
            throw new RuntimeException("Attempting to set native variable, but native code does not define native setvalue function!");
        }
        if (!callNativeSetValue(str, obj.toString())) {
            throw new RuntimeException("Error setting native value for variable '" + str + "'!");
        }
    }

    public void tearDown() {
        if (this.mTornDown) {
            return;
        }
        if (this.mHasTeardownFunction && !callNativeTeardown()) {
            throw new RuntimeException("Could not tear down NativeProgram!");
        }
        deallocate();
        this.mTornDown = true;
    }
}

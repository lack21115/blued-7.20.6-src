package android.filterfw.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.anythink.expressad.foundation.g.a.f;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.Arrays;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/FrameFormat.class */
public class FrameFormat {
    public static final int BYTES_PER_SAMPLE_UNSPECIFIED = 1;
    protected static final int SIZE_UNKNOWN = -1;
    public static final int SIZE_UNSPECIFIED = 0;
    public static final int TARGET_GPU = 3;
    public static final int TARGET_NATIVE = 2;
    public static final int TARGET_RS = 5;
    public static final int TARGET_SIMPLE = 1;
    public static final int TARGET_UNSPECIFIED = 0;
    public static final int TARGET_VERTEXBUFFER = 4;
    public static final int TYPE_BIT = 1;
    public static final int TYPE_BYTE = 2;
    public static final int TYPE_DOUBLE = 6;
    public static final int TYPE_FLOAT = 5;
    public static final int TYPE_INT16 = 3;
    public static final int TYPE_INT32 = 4;
    public static final int TYPE_OBJECT = 8;
    public static final int TYPE_POINTER = 7;
    public static final int TYPE_UNSPECIFIED = 0;
    protected int mBaseType;
    protected int mBytesPerSample;
    protected int[] mDimensions;
    protected KeyValueMap mMetaData;
    protected Class mObjectClass;
    protected int mSize;
    protected int mTarget;

    /* JADX INFO: Access modifiers changed from: protected */
    public FrameFormat() {
        this.mBaseType = 0;
        this.mBytesPerSample = 1;
        this.mSize = -1;
        this.mTarget = 0;
    }

    public FrameFormat(int i, int i2) {
        this.mBaseType = 0;
        this.mBytesPerSample = 1;
        this.mSize = -1;
        this.mTarget = 0;
        this.mBaseType = i;
        this.mTarget = i2;
        initDefaults();
    }

    public static String baseTypeToString(int i) {
        switch (i) {
            case 0:
                return "unspecified";
            case 1:
                return "bit";
            case 2:
                return "byte";
            case 3:
                return IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL;
            case 4:
                return IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL;
            case 5:
                return TypedValues.Custom.S_FLOAT;
            case 6:
                return "double";
            case 7:
                return "pointer";
            case 8:
                return "object";
            default:
                return "unknown";
        }
    }

    public static int bytesPerSampleOf(int i) {
        switch (i) {
            case 1:
            case 2:
            default:
                return 1;
            case 3:
                return 2;
            case 4:
            case 5:
            case 7:
                return 4;
            case 6:
                return 8;
        }
    }

    public static String dimensionsToString(int[] iArr) {
        StringBuffer stringBuffer = new StringBuffer();
        if (iArr != null) {
            int length = iArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                if (iArr[i2] == 0) {
                    stringBuffer.append("[]");
                } else {
                    stringBuffer.append("[" + String.valueOf(iArr[i2]) + "]");
                }
                i = i2 + 1;
            }
        }
        return stringBuffer.toString();
    }

    private void initDefaults() {
        this.mBytesPerSample = bytesPerSampleOf(this.mBaseType);
    }

    public static String metaDataToString(KeyValueMap keyValueMap) {
        if (keyValueMap == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{ ");
        for (Map.Entry<String, Object> entry : keyValueMap.entrySet()) {
            stringBuffer.append(entry.getKey() + ": " + entry.getValue() + " ");
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    public static int readTargetString(String str) {
        if (str.equalsIgnoreCase("CPU") || str.equalsIgnoreCase("NATIVE")) {
            return 2;
        }
        if (str.equalsIgnoreCase("GPU")) {
            return 3;
        }
        if (str.equalsIgnoreCase("SIMPLE")) {
            return 1;
        }
        if (str.equalsIgnoreCase("VERTEXBUFFER")) {
            return 4;
        }
        if (str.equalsIgnoreCase("UNSPECIFIED")) {
            return 0;
        }
        throw new RuntimeException("Unknown target type '" + str + "'!");
    }

    public static String targetToString(int i) {
        switch (i) {
            case 0:
                return "unspecified";
            case 1:
                return "simple";
            case 2:
                return f.f4992a;
            case 3:
                return "gpu";
            case 4:
                return "vbo";
            case 5:
                return "renderscript";
            default:
                return "unknown";
        }
    }

    public static FrameFormat unspecified() {
        return new FrameFormat(0, 0);
    }

    int calcSize(int[] iArr) {
        int i;
        if (iArr != null && iArr.length > 0) {
            int bytesPerSample = getBytesPerSample();
            int length = iArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                i = bytesPerSample;
                if (i3 >= length) {
                    break;
                }
                bytesPerSample *= iArr[i3];
                i2 = i3 + 1;
            }
        } else {
            i = 0;
        }
        return i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FrameFormat) {
            FrameFormat frameFormat = (FrameFormat) obj;
            return frameFormat.mBaseType == this.mBaseType && frameFormat.mTarget == this.mTarget && frameFormat.mBytesPerSample == this.mBytesPerSample && Arrays.equals(frameFormat.mDimensions, this.mDimensions) && frameFormat.mMetaData.equals(this.mMetaData);
        }
        return false;
    }

    public int getBaseType() {
        return this.mBaseType;
    }

    public int getBytesPerSample() {
        return this.mBytesPerSample;
    }

    public int getDepth() {
        if (this.mDimensions == null || this.mDimensions.length < 3) {
            return -1;
        }
        return this.mDimensions[2];
    }

    public int getDimension(int i) {
        return this.mDimensions[i];
    }

    public int getDimensionCount() {
        if (this.mDimensions == null) {
            return 0;
        }
        return this.mDimensions.length;
    }

    public int[] getDimensions() {
        return this.mDimensions;
    }

    public int getHeight() {
        if (this.mDimensions == null || this.mDimensions.length < 2) {
            return -1;
        }
        return this.mDimensions[1];
    }

    public int getLength() {
        if (this.mDimensions == null || this.mDimensions.length < 1) {
            return -1;
        }
        return this.mDimensions[0];
    }

    public Object getMetaValue(String str) {
        if (this.mMetaData != null) {
            return this.mMetaData.get(str);
        }
        return null;
    }

    public int getNumberOfDimensions() {
        if (this.mDimensions != null) {
            return this.mDimensions.length;
        }
        return 0;
    }

    public Class getObjectClass() {
        return this.mObjectClass;
    }

    public int getSize() {
        if (this.mSize == -1) {
            this.mSize = calcSize(this.mDimensions);
        }
        return this.mSize;
    }

    public int getTarget() {
        return this.mTarget;
    }

    public int getValuesPerSample() {
        return this.mBytesPerSample / bytesPerSampleOf(this.mBaseType);
    }

    public int getWidth() {
        return getLength();
    }

    public boolean hasMetaKey(String str) {
        if (this.mMetaData != null) {
            return this.mMetaData.containsKey(str);
        }
        return false;
    }

    public boolean hasMetaKey(String str, Class cls) {
        if (this.mMetaData == null || !this.mMetaData.containsKey(str)) {
            return false;
        }
        if (cls.isAssignableFrom(this.mMetaData.get(str).getClass())) {
            return true;
        }
        throw new RuntimeException("FrameFormat meta-key '" + str + "' is of type " + this.mMetaData.get(str).getClass() + " but expected to be of type " + cls + "!");
    }

    public int hashCode() {
        return ((this.mBaseType ^ 4211) ^ this.mBytesPerSample) ^ getSize();
    }

    public boolean isBinaryDataType() {
        return this.mBaseType >= 1 && this.mBaseType <= 6;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean isCompatibleWith(android.filterfw.core.FrameFormat r5) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.filterfw.core.FrameFormat.isCompatibleWith(android.filterfw.core.FrameFormat):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isReplaceableBy(FrameFormat frameFormat) {
        return this.mTarget == frameFormat.mTarget && getSize() == frameFormat.getSize() && Arrays.equals(frameFormat.mDimensions, this.mDimensions);
    }

    public boolean mayBeCompatibleWith(FrameFormat frameFormat) {
        if (frameFormat.getBaseType() != 0 && getBaseType() != 0 && getBaseType() != frameFormat.getBaseType()) {
            return false;
        }
        if (frameFormat.getTarget() != 0 && getTarget() != 0 && getTarget() != frameFormat.getTarget()) {
            return false;
        }
        if (frameFormat.getBytesPerSample() != 1 && getBytesPerSample() != 1 && getBytesPerSample() != frameFormat.getBytesPerSample()) {
            return false;
        }
        if (frameFormat.getDimensionCount() > 0 && getDimensionCount() > 0 && getDimensionCount() != frameFormat.getDimensionCount()) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= frameFormat.getDimensionCount()) {
                if (frameFormat.getObjectClass() == null || getObjectClass() == null || frameFormat.getObjectClass().isAssignableFrom(getObjectClass())) {
                    if (frameFormat.mMetaData == null || this.mMetaData == null) {
                        return true;
                    }
                    for (String str : frameFormat.mMetaData.keySet()) {
                        if (this.mMetaData.containsKey(str) && !this.mMetaData.get(str).equals(frameFormat.mMetaData.get(str))) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
            int dimension = frameFormat.getDimension(i2);
            if (dimension != 0 && getDimension(i2) != 0 && getDimension(i2) != dimension) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public MutableFrameFormat mutableCopy() {
        MutableFrameFormat mutableFrameFormat = new MutableFrameFormat();
        mutableFrameFormat.setBaseType(getBaseType());
        mutableFrameFormat.setTarget(getTarget());
        mutableFrameFormat.setBytesPerSample(getBytesPerSample());
        mutableFrameFormat.setDimensions(getDimensions());
        mutableFrameFormat.setObjectClass(getObjectClass());
        mutableFrameFormat.mMetaData = this.mMetaData == null ? null : (KeyValueMap) this.mMetaData.clone();
        return mutableFrameFormat;
    }

    public String toString() {
        int valuesPerSample = getValuesPerSample();
        return (this.mTarget == 0 ? "" : targetToString(this.mTarget) + " ") + baseTypeToString(this.mBaseType) + (valuesPerSample == 1 ? "" : String.valueOf(valuesPerSample)) + dimensionsToString(this.mDimensions) + (this.mObjectClass == null ? "" : " class(" + this.mObjectClass.getSimpleName() + ") ") + metaDataToString(this.mMetaData);
    }
}

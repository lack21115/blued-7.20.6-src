package android.mtp;

/* loaded from: source-9557208-dex2jar.jar:android/mtp/MtpPropertyList.class */
class MtpPropertyList {
    private int mCount;
    public final int[] mDataTypes;
    public long[] mLongValues;
    private final int mMaxCount;
    public final int[] mObjectHandles;
    public final int[] mPropertyCodes;
    public int mResult;
    public String[] mStringValues;

    public MtpPropertyList(int i, int i2) {
        this.mMaxCount = i;
        this.mResult = i2;
        this.mObjectHandles = new int[i];
        this.mPropertyCodes = new int[i];
        this.mDataTypes = new int[i];
    }

    public void append(int i, int i2, int i3, long j) {
        int i4 = this.mCount;
        this.mCount = i4 + 1;
        if (this.mLongValues == null) {
            this.mLongValues = new long[this.mMaxCount];
        }
        this.mObjectHandles[i4] = i;
        this.mPropertyCodes[i4] = i2;
        this.mDataTypes[i4] = i3;
        this.mLongValues[i4] = j;
    }

    public void append(int i, int i2, String str) {
        int i3 = this.mCount;
        this.mCount = i3 + 1;
        if (this.mStringValues == null) {
            this.mStringValues = new String[this.mMaxCount];
        }
        this.mObjectHandles[i3] = i;
        this.mPropertyCodes[i3] = i2;
        this.mDataTypes[i3] = 65535;
        this.mStringValues[i3] = str;
    }

    public void setResult(int i) {
        this.mResult = i;
    }
}

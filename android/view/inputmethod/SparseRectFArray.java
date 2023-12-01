package android.view.inputmethod;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.util.i;
import java.util.Arrays;

/* loaded from: source-4181928-dex2jar.jar:android/view/inputmethod/SparseRectFArray.class */
public final class SparseRectFArray implements Parcelable {
    public static final Parcelable.Creator<SparseRectFArray> CREATOR = new Parcelable.Creator<SparseRectFArray>() { // from class: android.view.inputmethod.SparseRectFArray.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SparseRectFArray createFromParcel(Parcel parcel) {
            return new SparseRectFArray(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SparseRectFArray[] newArray(int i) {
            return new SparseRectFArray[i];
        }
    };
    private final float[] mCoordinates;
    private final int[] mFlagsArray;
    private final int[] mKeys;

    /* loaded from: source-4181928-dex2jar.jar:android/view/inputmethod/SparseRectFArray$SparseRectFArrayBuilder.class */
    public static final class SparseRectFArrayBuilder {
        private static int INITIAL_SIZE = 16;
        private int mCount = 0;
        private int[] mKeys = null;
        private float[] mCoordinates = null;
        private int[] mFlagsArray = null;

        private void checkIndex(int i) {
            if (this.mCount != 0 && this.mKeys[this.mCount - 1] >= i) {
                throw new IllegalArgumentException("key must be greater than all existing keys.");
            }
        }

        private void ensureBufferSize() {
            if (this.mKeys == null) {
                this.mKeys = new int[INITIAL_SIZE];
            }
            if (this.mCoordinates == null) {
                this.mCoordinates = new float[INITIAL_SIZE * 4];
            }
            if (this.mFlagsArray == null) {
                this.mFlagsArray = new int[INITIAL_SIZE];
            }
            int i = this.mCount + 1;
            if (this.mKeys.length <= i) {
                int[] iArr = new int[i * 2];
                System.arraycopy(this.mKeys, 0, iArr, 0, this.mCount);
                this.mKeys = iArr;
            }
            int i2 = (this.mCount + 1) * 4;
            if (this.mCoordinates.length <= i2) {
                float[] fArr = new float[i2 * 2];
                System.arraycopy(this.mCoordinates, 0, fArr, 0, this.mCount * 4);
                this.mCoordinates = fArr;
            }
            if (this.mFlagsArray.length <= i) {
                int[] iArr2 = new int[i * 2];
                System.arraycopy(this.mFlagsArray, 0, iArr2, 0, this.mCount);
                this.mFlagsArray = iArr2;
            }
        }

        public SparseRectFArrayBuilder append(int i, float f, float f2, float f3, float f4, int i2) {
            checkIndex(i);
            ensureBufferSize();
            int i3 = this.mCount * 4;
            this.mCoordinates[i3 + 0] = f;
            this.mCoordinates[i3 + 1] = f2;
            this.mCoordinates[i3 + 2] = f3;
            this.mCoordinates[i3 + 3] = f4;
            this.mFlagsArray[this.mCount] = i2;
            this.mKeys[this.mCount] = i;
            this.mCount++;
            return this;
        }

        public SparseRectFArray build() {
            return new SparseRectFArray(this);
        }

        public boolean isEmpty() {
            return this.mCount <= 0;
        }

        public void reset() {
            if (this.mCount == 0) {
                this.mKeys = null;
                this.mCoordinates = null;
                this.mFlagsArray = null;
            }
            this.mCount = 0;
        }
    }

    public SparseRectFArray(Parcel parcel) {
        this.mKeys = parcel.createIntArray();
        this.mCoordinates = parcel.createFloatArray();
        this.mFlagsArray = parcel.createIntArray();
    }

    private SparseRectFArray(SparseRectFArrayBuilder sparseRectFArrayBuilder) {
        if (sparseRectFArrayBuilder.mCount == 0) {
            this.mKeys = null;
            this.mCoordinates = null;
            this.mFlagsArray = null;
            return;
        }
        this.mKeys = new int[sparseRectFArrayBuilder.mCount];
        this.mCoordinates = new float[sparseRectFArrayBuilder.mCount * 4];
        this.mFlagsArray = new int[sparseRectFArrayBuilder.mCount];
        System.arraycopy(sparseRectFArrayBuilder.mKeys, 0, this.mKeys, 0, sparseRectFArrayBuilder.mCount);
        System.arraycopy(sparseRectFArrayBuilder.mCoordinates, 0, this.mCoordinates, 0, sparseRectFArrayBuilder.mCount * 4);
        System.arraycopy(sparseRectFArrayBuilder.mFlagsArray, 0, this.mFlagsArray, 0, sparseRectFArrayBuilder.mCount);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof SparseRectFArray) {
            SparseRectFArray sparseRectFArray = (SparseRectFArray) obj;
            if (!Arrays.equals(this.mKeys, sparseRectFArray.mKeys) || !Arrays.equals(this.mCoordinates, sparseRectFArray.mCoordinates) || !Arrays.equals(this.mFlagsArray, sparseRectFArray.mFlagsArray)) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public RectF get(int i) {
        int binarySearch;
        if (this.mKeys != null && i >= 0 && (binarySearch = Arrays.binarySearch(this.mKeys, i)) >= 0) {
            int i2 = binarySearch * 4;
            return new RectF(this.mCoordinates[i2], this.mCoordinates[i2 + 1], this.mCoordinates[i2 + 2], this.mCoordinates[i2 + 3]);
        }
        return null;
    }

    public int getFlags(int i, int i2) {
        int binarySearch;
        return (this.mKeys != null && i >= 0 && (binarySearch = Arrays.binarySearch(this.mKeys, i)) >= 0) ? this.mFlagsArray[binarySearch] : i2;
    }

    public int hashCode() {
        if (this.mKeys == null || this.mKeys.length == 0) {
            return 0;
        }
        int length = this.mKeys.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 4) {
                return (length * 31) + this.mFlagsArray[0];
            }
            length = (int) ((length * 31) + this.mCoordinates[i2]);
            i = i2 + 1;
        }
    }

    public String toString() {
        if (this.mKeys == null || this.mCoordinates == null || this.mFlagsArray == null) {
            return "SparseRectFArray{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SparseRectFArray{");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mKeys.length) {
                sb.append(i.d);
                return sb.toString();
            }
            if (i2 != 0) {
                sb.append(", ");
            }
            int i3 = i2 * 4;
            sb.append(this.mKeys[i2]);
            sb.append(":[");
            sb.append(this.mCoordinates[i3 + 0]);
            sb.append(",");
            sb.append(this.mCoordinates[i3 + 1]);
            sb.append("],[");
            sb.append(this.mCoordinates[i3 + 2]);
            sb.append(",");
            sb.append(this.mCoordinates[i3 + 3]);
            sb.append("]:flagsArray=");
            sb.append(this.mFlagsArray[i2]);
            i = i2 + 1;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.mKeys);
        parcel.writeFloatArray(this.mCoordinates);
        parcel.writeIntArray(this.mFlagsArray);
    }
}

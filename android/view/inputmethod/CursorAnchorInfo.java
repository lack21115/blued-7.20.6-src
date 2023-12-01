package android.view.inputmethod;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannedString;
import android.text.TextUtils;
import android.view.inputmethod.SparseRectFArray;
import com.alipay.sdk.util.i;
import java.util.Objects;

/* loaded from: source-4181928-dex2jar.jar:android/view/inputmethod/CursorAnchorInfo.class */
public final class CursorAnchorInfo implements Parcelable {
    public static final Parcelable.Creator<CursorAnchorInfo> CREATOR = new Parcelable.Creator<CursorAnchorInfo>() { // from class: android.view.inputmethod.CursorAnchorInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CursorAnchorInfo createFromParcel(Parcel parcel) {
            return new CursorAnchorInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CursorAnchorInfo[] newArray(int i) {
            return new CursorAnchorInfo[i];
        }
    };
    public static final int FLAG_HAS_INVISIBLE_REGION = 2;
    public static final int FLAG_HAS_VISIBLE_REGION = 1;
    public static final int FLAG_IS_RTL = 4;
    private final SparseRectFArray mCharacterBoundsArray;
    private final CharSequence mComposingText;
    private final int mComposingTextStart;
    private final float mInsertionMarkerBaseline;
    private final float mInsertionMarkerBottom;
    private final int mInsertionMarkerFlags;
    private final float mInsertionMarkerHorizontal;
    private final float mInsertionMarkerTop;
    private final Matrix mMatrix;
    private final int mSelectionEnd;
    private final int mSelectionStart;

    /* loaded from: source-4181928-dex2jar.jar:android/view/inputmethod/CursorAnchorInfo$Builder.class */
    public static final class Builder {
        private int mSelectionStart = -1;
        private int mSelectionEnd = -1;
        private int mComposingTextStart = -1;
        private CharSequence mComposingText = null;
        private float mInsertionMarkerHorizontal = Float.NaN;
        private float mInsertionMarkerTop = Float.NaN;
        private float mInsertionMarkerBaseline = Float.NaN;
        private float mInsertionMarkerBottom = Float.NaN;
        private int mInsertionMarkerFlags = 0;
        private SparseRectFArray.SparseRectFArrayBuilder mCharacterBoundsArrayBuilder = null;
        private final Matrix mMatrix = new Matrix(Matrix.IDENTITY_MATRIX);
        private boolean mMatrixInitialized = false;

        public Builder addCharacterBounds(int i, float f, float f2, float f3, float f4, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("index must not be a negative integer.");
            }
            if (this.mCharacterBoundsArrayBuilder == null) {
                this.mCharacterBoundsArrayBuilder = new SparseRectFArray.SparseRectFArrayBuilder();
            }
            this.mCharacterBoundsArrayBuilder.append(i, f, f2, f3, f4, i2);
            return this;
        }

        public CursorAnchorInfo build() {
            if (!this.mMatrixInitialized) {
                if (((this.mCharacterBoundsArrayBuilder == null || this.mCharacterBoundsArrayBuilder.isEmpty()) ? false : true) || !Float.isNaN(this.mInsertionMarkerHorizontal) || !Float.isNaN(this.mInsertionMarkerTop) || !Float.isNaN(this.mInsertionMarkerBaseline) || !Float.isNaN(this.mInsertionMarkerBottom)) {
                    throw new IllegalArgumentException("Coordinate transformation matrix is required when positional parameters are specified.");
                }
            }
            return new CursorAnchorInfo(this);
        }

        public void reset() {
            this.mSelectionStart = -1;
            this.mSelectionEnd = -1;
            this.mComposingTextStart = -1;
            this.mComposingText = null;
            this.mInsertionMarkerFlags = 0;
            this.mInsertionMarkerHorizontal = Float.NaN;
            this.mInsertionMarkerTop = Float.NaN;
            this.mInsertionMarkerBaseline = Float.NaN;
            this.mInsertionMarkerBottom = Float.NaN;
            this.mMatrix.set(Matrix.IDENTITY_MATRIX);
            this.mMatrixInitialized = false;
            if (this.mCharacterBoundsArrayBuilder != null) {
                this.mCharacterBoundsArrayBuilder.reset();
            }
        }

        public Builder setComposingText(int i, CharSequence charSequence) {
            this.mComposingTextStart = i;
            if (charSequence == null) {
                this.mComposingText = null;
                return this;
            }
            this.mComposingText = new SpannedString(charSequence);
            return this;
        }

        public Builder setInsertionMarkerLocation(float f, float f2, float f3, float f4, int i) {
            this.mInsertionMarkerHorizontal = f;
            this.mInsertionMarkerTop = f2;
            this.mInsertionMarkerBaseline = f3;
            this.mInsertionMarkerBottom = f4;
            this.mInsertionMarkerFlags = i;
            return this;
        }

        public Builder setMatrix(Matrix matrix) {
            Matrix matrix2 = this.mMatrix;
            if (matrix == null) {
                matrix = Matrix.IDENTITY_MATRIX;
            }
            matrix2.set(matrix);
            this.mMatrixInitialized = true;
            return this;
        }

        public Builder setSelectionRange(int i, int i2) {
            this.mSelectionStart = i;
            this.mSelectionEnd = i2;
            return this;
        }
    }

    public CursorAnchorInfo(Parcel parcel) {
        this.mSelectionStart = parcel.readInt();
        this.mSelectionEnd = parcel.readInt();
        this.mComposingTextStart = parcel.readInt();
        this.mComposingText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mInsertionMarkerFlags = parcel.readInt();
        this.mInsertionMarkerHorizontal = parcel.readFloat();
        this.mInsertionMarkerTop = parcel.readFloat();
        this.mInsertionMarkerBaseline = parcel.readFloat();
        this.mInsertionMarkerBottom = parcel.readFloat();
        this.mCharacterBoundsArray = (SparseRectFArray) parcel.readParcelable(SparseRectFArray.class.getClassLoader());
        this.mMatrix = new Matrix();
        this.mMatrix.setValues(parcel.createFloatArray());
    }

    private CursorAnchorInfo(Builder builder) {
        this.mSelectionStart = builder.mSelectionStart;
        this.mSelectionEnd = builder.mSelectionEnd;
        this.mComposingTextStart = builder.mComposingTextStart;
        this.mComposingText = builder.mComposingText;
        this.mInsertionMarkerFlags = builder.mInsertionMarkerFlags;
        this.mInsertionMarkerHorizontal = builder.mInsertionMarkerHorizontal;
        this.mInsertionMarkerTop = builder.mInsertionMarkerTop;
        this.mInsertionMarkerBaseline = builder.mInsertionMarkerBaseline;
        this.mInsertionMarkerBottom = builder.mInsertionMarkerBottom;
        this.mCharacterBoundsArray = builder.mCharacterBoundsArrayBuilder != null ? builder.mCharacterBoundsArrayBuilder.build() : null;
        this.mMatrix = new Matrix(builder.mMatrix);
    }

    private static boolean areSameFloatImpl(float f, float f2) {
        return (Float.isNaN(f) && Float.isNaN(f2)) || f == f2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof CursorAnchorInfo) {
            CursorAnchorInfo cursorAnchorInfo = (CursorAnchorInfo) obj;
            return hashCode() == cursorAnchorInfo.hashCode() && this.mSelectionStart == cursorAnchorInfo.mSelectionStart && this.mSelectionEnd == cursorAnchorInfo.mSelectionEnd && this.mComposingTextStart == cursorAnchorInfo.mComposingTextStart && Objects.equals(this.mComposingText, cursorAnchorInfo.mComposingText) && this.mInsertionMarkerFlags == cursorAnchorInfo.mInsertionMarkerFlags && areSameFloatImpl(this.mInsertionMarkerHorizontal, cursorAnchorInfo.mInsertionMarkerHorizontal) && areSameFloatImpl(this.mInsertionMarkerTop, cursorAnchorInfo.mInsertionMarkerTop) && areSameFloatImpl(this.mInsertionMarkerBaseline, cursorAnchorInfo.mInsertionMarkerBaseline) && areSameFloatImpl(this.mInsertionMarkerBottom, cursorAnchorInfo.mInsertionMarkerBottom) && Objects.equals(this.mCharacterBoundsArray, cursorAnchorInfo.mCharacterBoundsArray) && Objects.equals(this.mMatrix, cursorAnchorInfo.mMatrix);
        }
        return false;
    }

    public RectF getCharacterBounds(int i) {
        if (this.mCharacterBoundsArray == null) {
            return null;
        }
        return this.mCharacterBoundsArray.get(i);
    }

    public int getCharacterBoundsFlags(int i) {
        if (this.mCharacterBoundsArray == null) {
            return 0;
        }
        return this.mCharacterBoundsArray.getFlags(i, 0);
    }

    public CharSequence getComposingText() {
        return this.mComposingText;
    }

    public int getComposingTextStart() {
        return this.mComposingTextStart;
    }

    public float getInsertionMarkerBaseline() {
        return this.mInsertionMarkerBaseline;
    }

    public float getInsertionMarkerBottom() {
        return this.mInsertionMarkerBottom;
    }

    public int getInsertionMarkerFlags() {
        return this.mInsertionMarkerFlags;
    }

    public float getInsertionMarkerHorizontal() {
        return this.mInsertionMarkerHorizontal;
    }

    public float getInsertionMarkerTop() {
        return this.mInsertionMarkerTop;
    }

    public Matrix getMatrix() {
        return new Matrix(this.mMatrix);
    }

    public int getSelectionEnd() {
        return this.mSelectionEnd;
    }

    public int getSelectionStart() {
        return this.mSelectionStart;
    }

    public int hashCode() {
        float f = this.mInsertionMarkerHorizontal + this.mInsertionMarkerTop + this.mInsertionMarkerBaseline + this.mInsertionMarkerBottom;
        return ((((((((((f > 0.0f ? (int) f : (int) (-f)) * 31) + this.mInsertionMarkerFlags) * 31) + this.mSelectionStart + this.mSelectionEnd + this.mComposingTextStart) * 31) + Objects.hashCode(this.mComposingText)) * 31) + Objects.hashCode(this.mCharacterBoundsArray)) * 31) + Objects.hashCode(this.mMatrix);
    }

    public String toString() {
        return "SelectionInfo{mSelection=" + this.mSelectionStart + "," + this.mSelectionEnd + " mComposingTextStart=" + this.mComposingTextStart + " mComposingText=" + Objects.toString(this.mComposingText) + " mInsertionMarkerFlags=" + this.mInsertionMarkerFlags + " mInsertionMarkerHorizontal=" + this.mInsertionMarkerHorizontal + " mInsertionMarkerTop=" + this.mInsertionMarkerTop + " mInsertionMarkerBaseline=" + this.mInsertionMarkerBaseline + " mInsertionMarkerBottom=" + this.mInsertionMarkerBottom + " mCharacterBoundsArray=" + Objects.toString(this.mCharacterBoundsArray) + " mMatrix=" + Objects.toString(this.mMatrix) + i.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mSelectionStart);
        parcel.writeInt(this.mSelectionEnd);
        parcel.writeInt(this.mComposingTextStart);
        TextUtils.writeToParcel(this.mComposingText, parcel, i);
        parcel.writeInt(this.mInsertionMarkerFlags);
        parcel.writeFloat(this.mInsertionMarkerHorizontal);
        parcel.writeFloat(this.mInsertionMarkerTop);
        parcel.writeFloat(this.mInsertionMarkerBaseline);
        parcel.writeFloat(this.mInsertionMarkerBottom);
        parcel.writeParcelable(this.mCharacterBoundsArray, i);
        float[] fArr = new float[9];
        this.mMatrix.getValues(fArr);
        parcel.writeFloatArray(fArr);
    }
}

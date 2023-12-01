package android.content.res;

import android.content.res.Resources;
import android.content.res.XmlBlock;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import com.android.internal.util.XmlUtils;
import java.util.Arrays;

/* loaded from: source-9557208-dex2jar.jar:android/content/res/TypedArray.class */
public class TypedArray {
    private final AssetManager mAssets;
    int[] mData;
    int[] mIndices;
    int mLength;
    private final DisplayMetrics mMetrics;
    private boolean mRecycled;
    private final Resources mResources;
    Resources.Theme mTheme;
    TypedValue mValue = new TypedValue();
    XmlBlock.Parser mXml;

    TypedArray(Resources resources, int[] iArr, int[] iArr2, int i) {
        this.mResources = resources;
        this.mMetrics = this.mResources.mMetrics;
        this.mAssets = this.mResources.mAssets;
        this.mData = iArr;
        this.mIndices = iArr2;
        this.mLength = i;
    }

    private boolean getValueAt(int i, TypedValue typedValue) {
        int[] iArr = this.mData;
        int i2 = iArr[i + 0];
        if (i2 == 0) {
            return false;
        }
        typedValue.type = i2;
        typedValue.data = iArr[i + 1];
        typedValue.assetCookie = iArr[i + 2];
        typedValue.resourceId = iArr[i + 3];
        typedValue.changingConfigurations = iArr[i + 4];
        typedValue.density = iArr[i + 5];
        typedValue.string = i2 == 3 ? loadStringValueAt(i) : null;
        return true;
    }

    private CharSequence loadStringValueAt(int i) {
        int[] iArr = this.mData;
        int i2 = iArr[i + 2];
        if (i2 < 0) {
            if (this.mXml != null) {
                return this.mXml.getPooledString(iArr[i + 1]);
            }
            return null;
        }
        return this.mAssets.getPooledStringForCookie(i2, iArr[i + 1]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TypedArray obtain(Resources resources, int i) {
        TypedArray acquire = resources.mTypedArrayPool.acquire();
        if (acquire != null) {
            acquire.mLength = i;
            acquire.mRecycled = false;
            int i2 = i * 6;
            if (acquire.mData.length >= i2) {
                return acquire;
            }
            acquire.mData = new int[i2];
            acquire.mIndices = new int[i + 1];
            return acquire;
        }
        return new TypedArray(resources, new int[i * 6], new int[i + 1], i);
    }

    public int[] extractThemeAttrs() {
        int[] iArr;
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        int[] iArr2 = null;
        int[] iArr3 = this.mData;
        int length = length();
        int i = 0;
        while (i < length) {
            int i2 = i * 6;
            if (iArr3[i2 + 0] != 2) {
                iArr = iArr2;
            } else {
                iArr3[i2 + 0] = 0;
                int i3 = iArr3[i2 + 1];
                iArr = iArr2;
                if (i3 != 0) {
                    iArr = iArr2;
                    if (iArr2 == null) {
                        iArr = new int[length];
                    }
                    iArr[i] = i3;
                }
            }
            i++;
            iArr2 = iArr;
        }
        return iArr2;
    }

    public boolean getBoolean(int i, boolean z) {
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        int i2 = i * 6;
        int[] iArr = this.mData;
        int i3 = iArr[i2 + 0];
        if (i3 == 0) {
            return z;
        }
        if (i3 >= 16 && i3 <= 31) {
            return iArr[i2 + 1] != 0;
        }
        TypedValue typedValue = this.mValue;
        if (getValueAt(i2, typedValue)) {
            Log.w("Resources", "Converting to boolean: " + typedValue);
            return XmlUtils.convertValueToBoolean(typedValue.coerceToString(), z);
        }
        Log.w("Resources", "getBoolean of bad type: 0x" + Integer.toHexString(i3));
        return z;
    }

    public int getChangingConfigurations() {
        int i = 0;
        int[] iArr = this.mData;
        int length = length();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return i;
            }
            int i4 = i3 * 6;
            if (iArr[i4 + 0] != 0) {
                i |= iArr[i4 + 4];
            }
            i2 = i3 + 1;
        }
    }

    public int getColor(int i, int i2) {
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        int i3 = i * 6;
        int[] iArr = this.mData;
        int i4 = iArr[i3 + 0];
        if (i4 != 0) {
            if (i4 >= 16 && i4 <= 31) {
                return iArr[i3 + 1];
            }
            if (i4 != 3) {
                if (i4 == 2) {
                    throw new RuntimeException("Failed to resolve attribute at index " + i3);
                }
                throw new UnsupportedOperationException("Can't convert to color: type=0x" + Integer.toHexString(i4));
            }
            TypedValue typedValue = this.mValue;
            if (getValueAt(i3, typedValue)) {
                return this.mResources.loadColorStateList(typedValue, typedValue.resourceId).getDefaultColor();
            }
        }
        return i2;
    }

    public ColorStateList getColorStateList(int i) {
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        TypedValue typedValue = this.mValue;
        if (getValueAt(i * 6, typedValue)) {
            if (typedValue.type == 2) {
                throw new RuntimeException("Failed to resolve attribute at index " + i);
            }
            return this.mResources.loadColorStateList(typedValue, typedValue.resourceId);
        }
        return null;
    }

    public float getDimension(int i, float f) {
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        int i2 = i * 6;
        int[] iArr = this.mData;
        int i3 = iArr[i2 + 0];
        if (i3 == 0) {
            return f;
        }
        if (i3 == 5) {
            return TypedValue.complexToDimension(iArr[i2 + 1], this.mMetrics);
        }
        if (i3 == 2) {
            throw new RuntimeException("Failed to resolve attribute at index " + i2);
        }
        throw new UnsupportedOperationException("Can't convert to dimension: type=0x" + Integer.toHexString(i3));
    }

    public int getDimensionPixelOffset(int i, int i2) {
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        int i3 = i * 6;
        int[] iArr = this.mData;
        int i4 = iArr[i3 + 0];
        if (i4 == 0) {
            return i2;
        }
        if (i4 == 5) {
            return TypedValue.complexToDimensionPixelOffset(iArr[i3 + 1], this.mMetrics);
        }
        if (i4 == 2) {
            throw new RuntimeException("Failed to resolve attribute at index " + i3);
        }
        throw new UnsupportedOperationException("Can't convert to dimension: type=0x" + Integer.toHexString(i4));
    }

    public int getDimensionPixelSize(int i, int i2) {
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        int i3 = i * 6;
        int[] iArr = this.mData;
        int i4 = iArr[i3 + 0];
        if (i4 == 0) {
            return i2;
        }
        if (i4 == 5) {
            return TypedValue.complexToDimensionPixelSize(iArr[i3 + 1], this.mMetrics);
        }
        if (i4 == 2) {
            throw new RuntimeException("Failed to resolve attribute at index " + i3);
        }
        throw new UnsupportedOperationException("Can't convert to dimension: type=0x" + Integer.toHexString(i4));
    }

    public Drawable getDrawable(int i) {
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        TypedValue typedValue = this.mValue;
        if (getValueAt(i * 6, typedValue)) {
            if (typedValue.type == 2) {
                throw new RuntimeException("Failed to resolve attribute at index " + i);
            }
            return this.mResources.loadDrawable(typedValue, typedValue.resourceId, this.mTheme);
        }
        return null;
    }

    public float getFloat(int i, float f) {
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        int i2 = i * 6;
        int[] iArr = this.mData;
        int i3 = iArr[i2 + 0];
        if (i3 == 0) {
            return f;
        }
        if (i3 == 4) {
            return Float.intBitsToFloat(iArr[i2 + 1]);
        }
        if (i3 < 16 || i3 > 31) {
            TypedValue typedValue = this.mValue;
            if (getValueAt(i2, typedValue)) {
                Log.w("Resources", "Converting to float: " + typedValue);
                CharSequence coerceToString = typedValue.coerceToString();
                if (coerceToString != null) {
                    return Float.parseFloat(coerceToString.toString());
                }
            }
            Log.w("Resources", "getFloat of bad type: 0x" + Integer.toHexString(i3));
            return f;
        }
        return iArr[i2 + 1];
    }

    public float getFraction(int i, int i2, int i3, float f) {
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        int i4 = i * 6;
        int[] iArr = this.mData;
        int i5 = iArr[i4 + 0];
        if (i5 == 0) {
            return f;
        }
        if (i5 == 6) {
            return TypedValue.complexToFraction(iArr[i4 + 1], i2, i3);
        }
        if (i5 == 2) {
            throw new RuntimeException("Failed to resolve attribute at index " + i4);
        }
        throw new UnsupportedOperationException("Can't convert to fraction: type=0x" + Integer.toHexString(i5));
    }

    public int getIndex(int i) {
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        return this.mIndices[i + 1];
    }

    public int getIndexCount() {
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        return this.mIndices[0];
    }

    public int getInt(int i, int i2) {
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        int i3 = i * 6;
        int[] iArr = this.mData;
        int i4 = iArr[i3 + 0];
        if (i4 == 0) {
            return i2;
        }
        if (i4 < 16 || i4 > 31) {
            TypedValue typedValue = this.mValue;
            if (getValueAt(i3, typedValue)) {
                Log.w("Resources", "Converting to int: " + typedValue);
                return XmlUtils.convertValueToInt(typedValue.coerceToString(), i2);
            }
            Log.w("Resources", "getInt of bad type: 0x" + Integer.toHexString(i4));
            return i2;
        }
        return iArr[i3 + 1];
    }

    public int getInteger(int i, int i2) {
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        int i3 = i * 6;
        int[] iArr = this.mData;
        int i4 = iArr[i3 + 0];
        if (i4 == 0) {
            return i2;
        }
        if (i4 < 16 || i4 > 31) {
            if (i4 == 2) {
                throw new RuntimeException("Failed to resolve attribute at index " + i3);
            }
            throw new UnsupportedOperationException("Can't convert to integer: type=0x" + Integer.toHexString(i4));
        }
        return iArr[i3 + 1];
    }

    public int getLayoutDimension(int i, int i2) {
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        int i3 = i * 6;
        int[] iArr = this.mData;
        int i4 = iArr[i3 + 0];
        if (i4 >= 16 && i4 <= 31) {
            i2 = iArr[i3 + 1];
        } else if (i4 == 5) {
            return TypedValue.complexToDimensionPixelSize(iArr[i3 + 1], this.mMetrics);
        }
        return i2;
    }

    public int getLayoutDimension(int i, String str) {
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        int i2 = i * 6;
        int[] iArr = this.mData;
        int i3 = iArr[i2 + 0];
        if (i3 < 16 || i3 > 31) {
            if (i3 == 5) {
                return TypedValue.complexToDimensionPixelSize(iArr[i2 + 1], this.mMetrics);
            }
            if (i3 == 2) {
                throw new RuntimeException("Failed to resolve attribute at index " + i2);
            }
            throw new RuntimeException(getPositionDescription() + ": You must supply a " + str + " attribute.");
        }
        return iArr[i2 + 1];
    }

    public String getNonConfigurationString(int i, int i2) {
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        int i3 = i * 6;
        int[] iArr = this.mData;
        int i4 = iArr[i3 + 0];
        if ((iArr[i3 + 4] & (i2 ^ (-1))) == 0 && i4 != 0) {
            if (i4 == 3) {
                return loadStringValueAt(i3).toString();
            }
            TypedValue typedValue = this.mValue;
            if (!getValueAt(i3, typedValue)) {
                Log.w("Resources", "getString of bad type: 0x" + Integer.toHexString(i4));
                return null;
            }
            Log.w("Resources", "Converting to string: " + typedValue);
            CharSequence coerceToString = typedValue.coerceToString();
            if (coerceToString != null) {
                return coerceToString.toString();
            }
            return null;
        }
        return null;
    }

    public String getNonResourceString(int i) {
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        int i2 = i * 6;
        int[] iArr = this.mData;
        if (iArr[i2 + 0] != 3 || iArr[i2 + 2] >= 0) {
            return null;
        }
        return this.mXml.getPooledString(iArr[i2 + 1]).toString();
    }

    public String getPositionDescription() {
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        return this.mXml != null ? this.mXml.getPositionDescription() : "<internal>";
    }

    public int getResourceId(int i, int i2) {
        int i3;
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        int i4 = i * 6;
        int[] iArr = this.mData;
        return (iArr[i4 + 0] == 0 || (i3 = iArr[i4 + 3]) == 0) ? i2 : i3;
    }

    public Resources getResources() {
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        return this.mResources;
    }

    public String getString(int i) {
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        int i2 = i * 6;
        int i3 = this.mData[i2 + 0];
        if (i3 == 0) {
            return null;
        }
        if (i3 == 3) {
            return loadStringValueAt(i2).toString();
        }
        TypedValue typedValue = this.mValue;
        if (!getValueAt(i2, typedValue)) {
            Log.w("Resources", "getString of bad type: 0x" + Integer.toHexString(i3));
            return null;
        }
        Log.w("Resources", "Converting to string: " + typedValue);
        CharSequence coerceToString = typedValue.coerceToString();
        if (coerceToString != null) {
            return coerceToString.toString();
        }
        return null;
    }

    public CharSequence getText(int i) {
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        int i2 = i * 6;
        int i3 = this.mData[i2 + 0];
        if (i3 == 0) {
            return null;
        }
        if (i3 == 3) {
            return loadStringValueAt(i2);
        }
        TypedValue typedValue = this.mValue;
        if (getValueAt(i2, typedValue)) {
            Log.w("Resources", "Converting to string: " + typedValue);
            return typedValue.coerceToString();
        }
        Log.w("Resources", "getString of bad type: 0x" + Integer.toHexString(i3));
        return null;
    }

    public CharSequence[] getTextArray(int i) {
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        TypedValue typedValue = this.mValue;
        if (getValueAt(i * 6, typedValue)) {
            return this.mResources.getTextArray(typedValue.resourceId);
        }
        return null;
    }

    public int getThemeAttributeId(int i, int i2) {
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        int i3 = i * 6;
        int[] iArr = this.mData;
        if (iArr[i3 + 0] == 2) {
            i2 = iArr[i3 + 1];
        }
        return i2;
    }

    public int getType(int i) {
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        return this.mData[(i * 6) + 0];
    }

    public boolean getValue(int i, TypedValue typedValue) {
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        return getValueAt(i * 6, typedValue);
    }

    public boolean hasValue(int i) {
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        return this.mData[(i * 6) + 0] != 0;
    }

    public boolean hasValueOrEmpty(int i) {
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        int i2 = i * 6;
        int[] iArr = this.mData;
        return iArr[i2 + 0] != 0 || iArr[i2 + 1] == 1;
    }

    public int length() {
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        return this.mLength;
    }

    public TypedValue peekValue(int i) {
        if (this.mRecycled) {
            throw new RuntimeException("Cannot make calls to a recycled instance!");
        }
        TypedValue typedValue = this.mValue;
        if (getValueAt(i * 6, typedValue)) {
            return typedValue;
        }
        return null;
    }

    public void recycle() {
        if (this.mRecycled) {
            throw new RuntimeException(toString() + " recycled twice!");
        }
        this.mRecycled = true;
        this.mXml = null;
        this.mTheme = null;
        this.mResources.mTypedArrayPool.release(this);
    }

    public String toString() {
        return Arrays.toString(this.mData);
    }
}

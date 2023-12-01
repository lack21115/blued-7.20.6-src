package android.content.res;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.MathUtils;
import android.util.SparseArray;
import android.util.StateSet;
import android.util.Xml;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.GrowingArrayUtils;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/content/res/ColorStateList.class */
public class ColorStateList implements Parcelable {
    private int[] mColors;
    private int mDefaultColor;
    private int[][] mStateSpecs;
    private static final int[][] EMPTY = {new int[0]};
    private static final SparseArray<WeakReference<ColorStateList>> sCache = new SparseArray<>();
    public static final Parcelable.Creator<ColorStateList> CREATOR = new Parcelable.Creator<ColorStateList>() { // from class: android.content.res.ColorStateList.1
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v3, types: [int[], int[][]] */
        @Override // android.os.Parcelable.Creator
        public ColorStateList createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            ?? r0 = new int[readInt];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readInt) {
                    return new ColorStateList(r0, parcel.createIntArray());
                }
                r0[i2] = parcel.createIntArray();
                i = i2 + 1;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ColorStateList[] newArray(int i) {
            return new ColorStateList[i];
        }
    };

    private ColorStateList() {
        this.mDefaultColor = -65536;
    }

    public ColorStateList(int[][] iArr, int[] iArr2) {
        this.mDefaultColor = -65536;
        this.mStateSpecs = iArr;
        this.mColors = iArr2;
        if (iArr.length <= 0) {
            return;
        }
        this.mDefaultColor = iArr2[0];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iArr.length) {
                return;
            }
            if (iArr[i2].length == 0) {
                this.mDefaultColor = iArr2[i2];
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [int[], int[][], java.lang.Object] */
    public static ColorStateList addFirstIfMissing(ColorStateList colorStateList, int i, int i2) {
        int[][] states = colorStateList.getStates();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= states.length) {
                ?? r0 = new int[states.length + 1];
                System.arraycopy(states, 0, (Object) r0, 1, states.length);
                int[] iArr = new int[1];
                iArr[0] = i;
                r0[0] = iArr;
                int[] colors = colorStateList.getColors();
                int[] iArr2 = new int[colors.length + 1];
                System.arraycopy(colors, 0, iArr2, 1, colors.length);
                iArr2[0] = i2;
                return new ColorStateList(r0, iArr2);
            }
            int[] iArr3 = states[i4];
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 < iArr3.length) {
                    if (iArr3[i6] == i) {
                        return colorStateList;
                    }
                    i5 = i6 + 1;
                }
            }
            i3 = i4 + 1;
        }
    }

    public static ColorStateList createFromXml(Resources resources, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        return createFromXmlInner(resources, xmlPullParser, asAttributeSet);
    }

    private static ColorStateList createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            ColorStateList colorStateList = new ColorStateList();
            colorStateList.inflate(resources, xmlPullParser, attributeSet);
            return colorStateList;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid drawable tag " + name);
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [int[], int[][]] */
    private void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int depth;
        int i;
        int i2;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = (int[][]) ArrayUtils.newUnpaddedArray(int[].class, 20);
        int[] iArr2 = new int[iArr.length];
        int i3 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            } else if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                int i4 = 0;
                float f = 1.0f;
                int i5 = 0;
                int i6 = -65536;
                boolean z = false;
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr3 = new int[attributeCount];
                int i7 = 0;
                for (int i8 = 0; i8 < attributeCount; i8++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i8);
                    if (attributeNameResource == 0) {
                        break;
                    }
                    if (attributeNameResource == 16843551) {
                        i4 = attributeSet.getAttributeResourceValue(i8, 0);
                        i = i4;
                        i2 = i5;
                        if (i4 == 0) {
                            f = attributeSet.getAttributeFloatValue(i8, 1.0f);
                        }
                        i4 = i;
                        i5 = i2;
                    } else if (attributeNameResource == 16843173) {
                        i5 = attributeSet.getAttributeResourceValue(i8, 0);
                        i = i4;
                        i2 = i5;
                        if (i5 == 0) {
                            i6 = attributeSet.getAttributeIntValue(i8, i6);
                            z = true;
                        }
                        i4 = i;
                        i5 = i2;
                    } else {
                        int i9 = i7 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i8, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr3[i7] = attributeNameResource;
                        i7 = i9;
                    }
                }
                int[] trimStateSet = StateSet.trimStateSet(iArr3, i7);
                if (i5 != 0) {
                    i6 = resources.getColor(i5);
                } else if (!z) {
                    throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'android:color' attribute.");
                }
                if (i4 != 0) {
                    f = resources.getFloat(i4);
                }
                int constrain = (16777215 & i6) | (MathUtils.constrain((int) (Color.alpha(i6) * f), 0, 255) << 24);
                if (i3 == 0 || trimStateSet.length == 0) {
                    this.mDefaultColor = constrain;
                }
                iArr2 = GrowingArrayUtils.append(iArr2, i3, constrain);
                iArr = (int[][]) GrowingArrayUtils.append(iArr, i3, trimStateSet);
                i3++;
            }
        }
        this.mColors = new int[i3];
        this.mStateSpecs = new int[i3];
        System.arraycopy(iArr2, 0, this.mColors, 0, i3);
        System.arraycopy(iArr, 0, this.mStateSpecs, 0, i3);
    }

    public static ColorStateList valueOf(int i) {
        synchronized (sCache) {
            WeakReference<ColorStateList> weakReference = sCache.get(i);
            ColorStateList colorStateList = weakReference != null ? weakReference.get() : null;
            if (colorStateList != null) {
                return colorStateList;
            }
            ColorStateList colorStateList2 = new ColorStateList(EMPTY, new int[]{i});
            sCache.put(i, new WeakReference<>(colorStateList2));
            return colorStateList2;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getColorForState(int[] iArr, int i) {
        int i2;
        int length = this.mStateSpecs.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            i2 = i;
            if (i4 >= length) {
                break;
            } else if (StateSet.stateSetMatches(this.mStateSpecs[i4], iArr)) {
                i2 = this.mColors[i4];
                break;
            } else {
                i3 = i4 + 1;
            }
        }
        return i2;
    }

    public int[] getColors() {
        return this.mColors;
    }

    public int getDefaultColor() {
        return this.mDefaultColor;
    }

    public int[][] getStates() {
        return this.mStateSpecs;
    }

    public boolean isOpaque() {
        int length = this.mColors.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (Color.alpha(this.mColors[i2]) != 255) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public boolean isStateful() {
        return this.mStateSpecs.length > 1;
    }

    public String toString() {
        return "ColorStateList{mStateSpecs=" + Arrays.deepToString(this.mStateSpecs) + "mColors=" + Arrays.toString(this.mColors) + "mDefaultColor=" + this.mDefaultColor + '}';
    }

    public ColorStateList withAlpha(int i) {
        int[] iArr = new int[this.mColors.length];
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return new ColorStateList(this.mStateSpecs, iArr);
            }
            iArr[i3] = (this.mColors[i3] & 16777215) | (i << 24);
            i2 = i3 + 1;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int length = this.mStateSpecs.length;
        parcel.writeInt(length);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                parcel.writeIntArray(this.mColors);
                return;
            } else {
                parcel.writeIntArray(this.mStateSpecs[i3]);
                i2 = i3 + 1;
            }
        }
    }
}

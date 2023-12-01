package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R;
import androidx.core.math.MathUtils;
import androidx.core.os.BuildCompat;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/content/res/ColorStateListInflaterCompat.class */
public final class ColorStateListInflaterCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f2378a = new ThreadLocal<>();

    private ColorStateListInflaterCompat() {
    }

    private static int a(int i, float f, float f2) {
        boolean z = f2 >= 0.0f && f2 <= 100.0f;
        if (f != 1.0f || z) {
            int clamp = MathUtils.clamp((int) ((Color.alpha(i) * f) + 0.5f), 0, 255);
            int i2 = i;
            if (z) {
                CamColor a2 = CamColor.a(i);
                i2 = CamColor.a(a2.a(), a2.b(), f2);
            }
            return (i2 & 16777215) | (clamp << 24);
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int[], int[][], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v67, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r0v69, types: [int[][]] */
    private static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int i;
        int depth;
        int color;
        int i2;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[] iArr = new int[20];
        int[] iArr2 = new int[20];
        int i3 = 0;
        while (true) {
            i = i3;
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            int[] iArr3 = iArr2;
            int[] iArr4 = iArr;
            int i4 = i;
            if (next == 2) {
                iArr3 = iArr2;
                iArr4 = iArr;
                i4 = i;
                if (depth <= depth2) {
                    if (xmlPullParser.getName().equals("item")) {
                        TypedArray a2 = a(resources, theme, attributeSet, R.styleable.ColorStateListItem);
                        int resourceId = a2.getResourceId(R.styleable.ColorStateListItem_android_color, -1);
                        if (resourceId == -1 || a(resources, resourceId)) {
                            color = a2.getColor(R.styleable.ColorStateListItem_android_color, Color.MAGENTA);
                        } else {
                            try {
                                color = createFromXml(resources, resources.getXml(resourceId), theme).getDefaultColor();
                            } catch (Exception e) {
                                color = a2.getColor(R.styleable.ColorStateListItem_android_color, Color.MAGENTA);
                            }
                        }
                        float f = 1.0f;
                        if (a2.hasValue(R.styleable.ColorStateListItem_android_alpha)) {
                            f = a2.getFloat(R.styleable.ColorStateListItem_android_alpha, 1.0f);
                        } else if (a2.hasValue(R.styleable.ColorStateListItem_alpha)) {
                            f = a2.getFloat(R.styleable.ColorStateListItem_alpha, 1.0f);
                        }
                        float f2 = (BuildCompat.isAtLeastS() && a2.hasValue(R.styleable.ColorStateListItem_android_lStar)) ? a2.getFloat(R.styleable.ColorStateListItem_android_lStar, -1.0f) : a2.getFloat(R.styleable.ColorStateListItem_lStar, -1.0f);
                        a2.recycle();
                        int attributeCount = attributeSet.getAttributeCount();
                        int[] iArr5 = new int[attributeCount];
                        int i5 = 0;
                        int i6 = 0;
                        while (true) {
                            i2 = i6;
                            if (i5 >= attributeCount) {
                                break;
                            }
                            int attributeNameResource = attributeSet.getAttributeNameResource(i5);
                            int i7 = i2;
                            if (attributeNameResource != 16843173) {
                                i7 = i2;
                                if (attributeNameResource != 16843551) {
                                    i7 = i2;
                                    if (attributeNameResource != R.attr.alpha) {
                                        i7 = i2;
                                        if (attributeNameResource != R.attr.lStar) {
                                            iArr5[i2] = attributeSet.getAttributeBooleanValue(i5, false) ? attributeNameResource : -attributeNameResource;
                                            i7 = i2 + 1;
                                        }
                                    }
                                }
                            }
                            i5++;
                            i6 = i7;
                        }
                        int[] trimStateSet = StateSet.trimStateSet(iArr5, i2);
                        iArr3 = GrowingArrayUtils.append(iArr2, i, a(color, f, f2));
                        iArr4 = (int[][]) GrowingArrayUtils.append((int[][]) iArr, i, trimStateSet);
                        i4 = i + 1;
                    } else {
                        iArr3 = iArr2;
                        iArr4 = iArr;
                        i4 = i;
                    }
                }
            }
            iArr2 = iArr3;
            iArr = iArr4;
            i3 = i4;
        }
        int[] iArr6 = new int[i];
        ?? r0 = new int[i];
        System.arraycopy(iArr2, 0, iArr6, 0, i);
        System.arraycopy(iArr, 0, r0, 0, i);
        return new ColorStateList(r0, iArr6);
    }

    private static TypedArray a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    private static TypedValue a() {
        TypedValue typedValue = f2378a.get();
        TypedValue typedValue2 = typedValue;
        if (typedValue == null) {
            typedValue2 = new TypedValue();
            f2378a.set(typedValue2);
        }
        return typedValue2;
    }

    private static boolean a(Resources resources, int i) {
        TypedValue a2 = a();
        resources.getValue(i, a2, true);
        return a2.type >= 28 && a2.type <= 31;
    }

    public static ColorStateList createFromXml(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return createFromXmlInner(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return a(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    public static ColorStateList inflate(Resources resources, int i, Resources.Theme theme) {
        try {
            return createFromXml(resources, resources.getXml(i), theme);
        } catch (Exception e) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e);
            return null;
        }
    }
}

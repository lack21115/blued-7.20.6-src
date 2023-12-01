package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/widget/ConstraintAttribute.class */
public class ConstraintAttribute {

    /* renamed from: a  reason: collision with root package name */
    String f2249a;
    boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2250c;
    private AttributeType d;
    private int e;
    private float f;
    private String g;
    private int h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.constraintlayout.widget.ConstraintAttribute$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/widget/ConstraintAttribute$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2251a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0065 -> B:41:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0069 -> B:37:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006d -> B:49:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0071 -> B:43:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0075 -> B:39:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0079 -> B:35:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x007d -> B:47:0x0058). Please submit an issue!!! */
        static {
            int[] iArr = new int[AttributeType.values().length];
            f2251a = iArr;
            try {
                iArr[AttributeType.REFERENCE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2251a[AttributeType.BOOLEAN_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2251a[AttributeType.STRING_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2251a[AttributeType.COLOR_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f2251a[AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f2251a[AttributeType.INT_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f2251a[AttributeType.FLOAT_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f2251a[AttributeType.DIMENSION_TYPE.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/widget/ConstraintAttribute$AttributeType.class */
    public enum AttributeType {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public ConstraintAttribute(ConstraintAttribute constraintAttribute, Object obj) {
        this.f2250c = false;
        this.f2249a = constraintAttribute.f2249a;
        this.d = constraintAttribute.d;
        setValue(obj);
    }

    public ConstraintAttribute(String str, AttributeType attributeType) {
        this.f2250c = false;
        this.f2249a = str;
        this.d = attributeType;
    }

    public ConstraintAttribute(String str, AttributeType attributeType, Object obj, boolean z) {
        this.f2250c = false;
        this.f2249a = str;
        this.d = attributeType;
        this.f2250c = z;
        setValue(obj);
    }

    private static int a(int i) {
        int i2 = (i & (i >> 31)) - 255;
        return (i2 & (i2 >> 31)) + 255;
    }

    public static HashMap<String, ConstraintAttribute> extractAttributes(HashMap<String, ConstraintAttribute> hashMap, View view) {
        HashMap<String, ConstraintAttribute> hashMap2 = new HashMap<>();
        Class<?> cls = view.getClass();
        for (String str : hashMap.keySet()) {
            ConstraintAttribute constraintAttribute = hashMap.get(str);
            try {
                if (str.equals("BackgroundColor")) {
                    hashMap2.put(str, new ConstraintAttribute(constraintAttribute, Integer.valueOf(((ColorDrawable) view.getBackground()).getColor())));
                } else {
                    hashMap2.put(str, new ConstraintAttribute(constraintAttribute, cls.getMethod("getMap" + str, new Class[0]).invoke(view, new Object[0])));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
        return hashMap2;
    }

    public static void parse(Context context, XmlPullParser xmlPullParser, HashMap<String, ConstraintAttribute> hashMap) {
        boolean z;
        String str;
        Object obj;
        AttributeType attributeType;
        boolean z2;
        AttributeType attributeType2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.CustomAttribute);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str2 = null;
        Object obj2 = null;
        AttributeType attributeType3 = null;
        int i = 0;
        boolean z3 = false;
        while (true) {
            z = z3;
            if (i >= indexCount) {
                break;
            }
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.CustomAttribute_attributeName) {
                String string = obtainStyledAttributes.getString(index);
                str = string;
                obj = obj2;
                attributeType = attributeType3;
                z2 = z;
                if (string != null) {
                    str = string;
                    obj = obj2;
                    attributeType = attributeType3;
                    z2 = z;
                    if (string.length() > 0) {
                        str = Character.toUpperCase(string.charAt(0)) + string.substring(1);
                        obj = obj2;
                        attributeType = attributeType3;
                        z2 = z;
                    }
                }
            } else if (index == R.styleable.CustomAttribute_methodName) {
                str = obtainStyledAttributes.getString(index);
                z2 = true;
                obj = obj2;
                attributeType = attributeType3;
            } else if (index == R.styleable.CustomAttribute_customBoolean) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                attributeType = AttributeType.BOOLEAN_TYPE;
                str = str2;
                z2 = z;
            } else {
                if (index == R.styleable.CustomAttribute_customColorValue) {
                    attributeType2 = AttributeType.COLOR_TYPE;
                    obj = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.CustomAttribute_customColorDrawableValue) {
                    attributeType2 = AttributeType.COLOR_DRAWABLE_TYPE;
                    obj = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.CustomAttribute_customPixelDimension) {
                    attributeType2 = AttributeType.DIMENSION_TYPE;
                    obj = Float.valueOf(TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                } else if (index == R.styleable.CustomAttribute_customDimension) {
                    attributeType2 = AttributeType.DIMENSION_TYPE;
                    obj = Float.valueOf(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.CustomAttribute_customFloatValue) {
                    attributeType2 = AttributeType.FLOAT_TYPE;
                    obj = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                } else if (index == R.styleable.CustomAttribute_customIntegerValue) {
                    attributeType2 = AttributeType.INT_TYPE;
                    obj = Integer.valueOf(obtainStyledAttributes.getInteger(index, -1));
                } else if (index == R.styleable.CustomAttribute_customStringValue) {
                    attributeType2 = AttributeType.STRING_TYPE;
                    obj = obtainStyledAttributes.getString(index);
                } else {
                    str = str2;
                    obj = obj2;
                    attributeType = attributeType3;
                    z2 = z;
                    if (index == R.styleable.CustomAttribute_customReference) {
                        attributeType2 = AttributeType.REFERENCE_TYPE;
                        int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                        int i2 = resourceId;
                        if (resourceId == -1) {
                            i2 = obtainStyledAttributes.getInt(index, -1);
                        }
                        obj = Integer.valueOf(i2);
                    }
                }
                attributeType = attributeType2;
                str = str2;
                z2 = z;
            }
            i++;
            str2 = str;
            obj2 = obj;
            attributeType3 = attributeType;
            z3 = z2;
        }
        if (str2 != null && obj2 != null) {
            hashMap.put(str2, new ConstraintAttribute(str2, attributeType3, obj2, z));
        }
        obtainStyledAttributes.recycle();
    }

    public static void setAttributes(View view, HashMap<String, ConstraintAttribute> hashMap) {
        Class<?> cls = view.getClass();
        for (String str : hashMap.keySet()) {
            ConstraintAttribute constraintAttribute = hashMap.get(str);
            String str2 = constraintAttribute.f2250c ? str : "set" + str;
            try {
                switch (AnonymousClass1.f2251a[constraintAttribute.d.ordinal()]) {
                    case 1:
                        cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.e));
                        break;
                    case 2:
                        cls.getMethod(str2, Boolean.TYPE).invoke(view, Boolean.valueOf(constraintAttribute.b));
                        break;
                    case 3:
                        cls.getMethod(str2, CharSequence.class).invoke(view, constraintAttribute.g);
                        break;
                    case 4:
                        cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.h));
                        break;
                    case 5:
                        Method method = cls.getMethod(str2, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(constraintAttribute.h);
                        method.invoke(view, colorDrawable);
                        break;
                    case 6:
                        cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.e));
                        break;
                    case 7:
                        cls.getMethod(str2, Float.TYPE).invoke(view, Float.valueOf(constraintAttribute.f));
                        break;
                    case 8:
                        cls.getMethod(str2, Float.TYPE).invoke(view, Float.valueOf(constraintAttribute.f));
                        break;
                }
            } catch (IllegalAccessException e) {
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                Log.e("TransitionLayout", e2.getMessage());
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                StringBuilder sb = new StringBuilder();
                sb.append(cls.getName());
                sb.append(" must have a method ");
                sb.append(str2);
                Log.e("TransitionLayout", sb.toString());
            } catch (InvocationTargetException e3) {
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                e3.printStackTrace();
            }
        }
    }

    public void applyCustom(View view) {
        String str;
        Class<?> cls = view.getClass();
        String str2 = this.f2249a;
        if (this.f2250c) {
            str = str2;
        } else {
            str = "set" + str2;
        }
        try {
            switch (AnonymousClass1.f2251a[this.d.ordinal()]) {
                case 1:
                case 6:
                    cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf(this.e));
                    return;
                case 2:
                    cls.getMethod(str, Boolean.TYPE).invoke(view, Boolean.valueOf(this.b));
                    return;
                case 3:
                    cls.getMethod(str, CharSequence.class).invoke(view, this.g);
                    return;
                case 4:
                    cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf(this.h));
                    return;
                case 5:
                    Method method = cls.getMethod(str, Drawable.class);
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor(this.h);
                    method.invoke(view, colorDrawable);
                    return;
                case 7:
                    cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(this.f));
                    return;
                case 8:
                    cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(this.f));
                    return;
                default:
                    return;
            }
        } catch (IllegalAccessException e) {
            Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            Log.e("TransitionLayout", e2.getMessage());
            Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
            StringBuilder sb = new StringBuilder();
            sb.append(cls.getName());
            sb.append(" must have a method ");
            sb.append(str);
            Log.e("TransitionLayout", sb.toString());
        } catch (InvocationTargetException e3) {
            Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
            e3.printStackTrace();
        }
    }

    public boolean diff(ConstraintAttribute constraintAttribute) {
        boolean z = false;
        if (constraintAttribute != null) {
            if (this.d != constraintAttribute.d) {
                return false;
            }
            switch (AnonymousClass1.f2251a[this.d.ordinal()]) {
                case 1:
                case 6:
                    z = false;
                    if (this.e == constraintAttribute.e) {
                        z = true;
                        break;
                    }
                    break;
                case 2:
                    boolean z2 = false;
                    if (this.b == constraintAttribute.b) {
                        z2 = true;
                    }
                    return z2;
                case 3:
                    boolean z3 = false;
                    if (this.e == constraintAttribute.e) {
                        z3 = true;
                    }
                    return z3;
                case 4:
                case 5:
                    boolean z4 = false;
                    if (this.h == constraintAttribute.h) {
                        z4 = true;
                    }
                    return z4;
                case 7:
                    boolean z5 = false;
                    if (this.f == constraintAttribute.f) {
                        z5 = true;
                    }
                    return z5;
                case 8:
                    boolean z6 = false;
                    if (this.f == constraintAttribute.f) {
                        z6 = true;
                    }
                    return z6;
                default:
                    return false;
            }
        }
        return z;
    }

    public int getColorValue() {
        return this.h;
    }

    public float getFloatValue() {
        return this.f;
    }

    public int getIntegerValue() {
        return this.e;
    }

    public String getName() {
        return this.f2249a;
    }

    public String getStringValue() {
        return this.g;
    }

    public AttributeType getType() {
        return this.d;
    }

    public float getValueToInterpolate() {
        switch (AnonymousClass1.f2251a[this.d.ordinal()]) {
            case 2:
                return this.b ? 1.0f : 0.0f;
            case 3:
                throw new RuntimeException("Cannot interpolate String");
            case 4:
            case 5:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 6:
                return this.e;
            case 7:
                return this.f;
            case 8:
                return this.f;
            default:
                return Float.NaN;
        }
    }

    public void getValuesToInterpolate(float[] fArr) {
        switch (AnonymousClass1.f2251a[this.d.ordinal()]) {
            case 2:
                fArr[0] = this.b ? 1.0f : 0.0f;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int i = this.h;
                float pow = (float) Math.pow(((i >> 16) & 255) / 255.0f, 2.2d);
                float pow2 = (float) Math.pow(((i >> 8) & 255) / 255.0f, 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = (float) Math.pow((i & 255) / 255.0f, 2.2d);
                fArr[3] = ((i >> 24) & 255) / 255.0f;
                return;
            case 6:
                fArr[0] = this.e;
                return;
            case 7:
                fArr[0] = this.f;
                return;
            case 8:
                fArr[0] = this.f;
                return;
            default:
                return;
        }
    }

    public boolean isBooleanValue() {
        return this.b;
    }

    public boolean isContinuous() {
        int i = AnonymousClass1.f2251a[this.d.ordinal()];
        return (i == 1 || i == 2 || i == 3) ? false : true;
    }

    public boolean isMethod() {
        return this.f2250c;
    }

    public int numberOfInterpolatedValues() {
        int i = AnonymousClass1.f2251a[this.d.ordinal()];
        return (i == 4 || i == 5) ? 4 : 1;
    }

    public void setColorValue(int i) {
        this.h = i;
    }

    public void setFloatValue(float f) {
        this.f = f;
    }

    public void setIntValue(int i) {
        this.e = i;
    }

    public void setStringValue(String str) {
        this.g = str;
    }

    public void setValue(Object obj) {
        switch (AnonymousClass1.f2251a[this.d.ordinal()]) {
            case 1:
            case 6:
                this.e = ((Integer) obj).intValue();
                return;
            case 2:
                this.b = ((Boolean) obj).booleanValue();
                return;
            case 3:
                this.g = (String) obj;
                return;
            case 4:
            case 5:
                this.h = ((Integer) obj).intValue();
                return;
            case 7:
                this.f = ((Float) obj).floatValue();
                return;
            case 8:
                this.f = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }

    public void setValue(float[] fArr) {
        boolean z = false;
        switch (AnonymousClass1.f2251a[this.d.ordinal()]) {
            case 1:
            case 6:
                this.e = (int) fArr[0];
                return;
            case 2:
                if (fArr[0] > 0.5d) {
                    z = true;
                }
                this.b = z;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int HSVToColor = Color.HSVToColor(fArr);
                this.h = HSVToColor;
                this.h = (a((int) (fArr[3] * 255.0f)) << 24) | (HSVToColor & 16777215);
                return;
            case 7:
                this.f = fArr[0];
                return;
            case 8:
                this.f = fArr[0];
                return;
            default:
                return;
        }
    }
}

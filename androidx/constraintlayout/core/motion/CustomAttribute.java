package androidx.constraintlayout.core.motion;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/CustomAttribute.class */
public class CustomAttribute {

    /* renamed from: a  reason: collision with root package name */
    String f1954a;
    boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1955c;
    private AttributeType d;
    private int e;
    private float f;
    private String g;
    private int h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.constraintlayout.core.motion.CustomAttribute$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/CustomAttribute$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1956a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0065 -> B:41:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0069 -> B:37:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006d -> B:49:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0071 -> B:43:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0075 -> B:39:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0079 -> B:35:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x007d -> B:47:0x0058). Please submit an issue!!! */
        static {
            int[] iArr = new int[AttributeType.values().length];
            f1956a = iArr;
            try {
                iArr[AttributeType.REFERENCE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1956a[AttributeType.BOOLEAN_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1956a[AttributeType.STRING_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1956a[AttributeType.COLOR_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f1956a[AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f1956a[AttributeType.INT_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f1956a[AttributeType.FLOAT_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f1956a[AttributeType.DIMENSION_TYPE.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/CustomAttribute$AttributeType.class */
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

    public CustomAttribute(CustomAttribute customAttribute, Object obj) {
        this.f1955c = false;
        this.f1954a = customAttribute.f1954a;
        this.d = customAttribute.d;
        setValue(obj);
    }

    public CustomAttribute(String str, AttributeType attributeType) {
        this.f1955c = false;
        this.f1954a = str;
        this.d = attributeType;
    }

    public CustomAttribute(String str, AttributeType attributeType, Object obj, boolean z) {
        this.f1955c = false;
        this.f1954a = str;
        this.d = attributeType;
        this.f1955c = z;
        setValue(obj);
    }

    private static int a(int i) {
        int i2 = (i & (i >> 31)) - 255;
        return (i2 & (i2 >> 31)) + 255;
    }

    public static int hsvToRgb(float f, float f2, float f3) {
        float f4 = f * 6.0f;
        int i = (int) f4;
        float f5 = f4 - i;
        float f6 = f3 * 255.0f;
        int i2 = (int) (((1.0f - f2) * f6) + 0.5f);
        int i3 = (int) (((1.0f - (f5 * f2)) * f6) + 0.5f);
        int i4 = (int) (((1.0f - ((1.0f - f5) * f2)) * f6) + 0.5f);
        int i5 = (int) (f6 + 0.5f);
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return 0;
                            }
                            return ((i5 << 16) + (i2 << 8) + i3) | (-16777216);
                        }
                        return ((i4 << 16) + (i2 << 8) + i5) | (-16777216);
                    }
                    return ((i2 << 16) + (i3 << 8) + i5) | (-16777216);
                }
                return ((i2 << 16) + (i5 << 8) + i4) | (-16777216);
            }
            return ((i3 << 16) + (i5 << 8) + i2) | (-16777216);
        }
        return ((i5 << 16) + (i4 << 8) + i2) | (-16777216);
    }

    public boolean diff(CustomAttribute customAttribute) {
        boolean z = false;
        if (customAttribute != null) {
            if (this.d != customAttribute.d) {
                return false;
            }
            switch (AnonymousClass1.f1956a[this.d.ordinal()]) {
                case 1:
                case 6:
                    z = false;
                    if (this.e == customAttribute.e) {
                        z = true;
                        break;
                    }
                    break;
                case 2:
                    boolean z2 = false;
                    if (this.b == customAttribute.b) {
                        z2 = true;
                    }
                    return z2;
                case 3:
                    boolean z3 = false;
                    if (this.e == customAttribute.e) {
                        z3 = true;
                    }
                    return z3;
                case 4:
                case 5:
                    boolean z4 = false;
                    if (this.h == customAttribute.h) {
                        z4 = true;
                    }
                    return z4;
                case 7:
                    boolean z5 = false;
                    if (this.f == customAttribute.f) {
                        z5 = true;
                    }
                    return z5;
                case 8:
                    boolean z6 = false;
                    if (this.f == customAttribute.f) {
                        z6 = true;
                    }
                    return z6;
                default:
                    return false;
            }
        }
        return z;
    }

    public AttributeType getType() {
        return this.d;
    }

    public float getValueToInterpolate() {
        switch (AnonymousClass1.f1956a[this.d.ordinal()]) {
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
        switch (AnonymousClass1.f1956a[this.d.ordinal()]) {
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

    public boolean isContinuous() {
        int i = AnonymousClass1.f1956a[this.d.ordinal()];
        return (i == 1 || i == 2 || i == 3) ? false : true;
    }

    public int numberOfInterpolatedValues() {
        int i = AnonymousClass1.f1956a[this.d.ordinal()];
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
        switch (AnonymousClass1.f1956a[this.d.ordinal()]) {
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
        boolean z = true;
        switch (AnonymousClass1.f1956a[this.d.ordinal()]) {
            case 1:
            case 6:
                this.e = (int) fArr[0];
                return;
            case 2:
                if (fArr[0] <= 0.5d) {
                    z = false;
                }
                this.b = z;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int hsvToRgb = hsvToRgb(fArr[0], fArr[1], fArr[2]);
                this.h = hsvToRgb;
                this.h = (a((int) (fArr[3] * 255.0f)) << 24) | (hsvToRgb & 16777215);
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

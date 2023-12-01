package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/CustomVariable.class */
public class CustomVariable {

    /* renamed from: a  reason: collision with root package name */
    String f1958a;
    boolean b;

    /* renamed from: c  reason: collision with root package name */
    private int f1959c;
    private int d;
    private float e;
    private String f;

    public CustomVariable(CustomVariable customVariable) {
        this.d = Integer.MIN_VALUE;
        this.e = Float.NaN;
        this.f = null;
        this.f1958a = customVariable.f1958a;
        this.f1959c = customVariable.f1959c;
        this.d = customVariable.d;
        this.e = customVariable.e;
        this.f = customVariable.f;
        this.b = customVariable.b;
    }

    public CustomVariable(CustomVariable customVariable, Object obj) {
        this.d = Integer.MIN_VALUE;
        this.e = Float.NaN;
        this.f = null;
        this.f1958a = customVariable.f1958a;
        this.f1959c = customVariable.f1959c;
        setValue(obj);
    }

    public CustomVariable(String str, int i) {
        this.d = Integer.MIN_VALUE;
        this.e = Float.NaN;
        this.f = null;
        this.f1958a = str;
        this.f1959c = i;
    }

    public CustomVariable(String str, int i, float f) {
        this.d = Integer.MIN_VALUE;
        this.e = Float.NaN;
        this.f = null;
        this.f1958a = str;
        this.f1959c = i;
        this.e = f;
    }

    public CustomVariable(String str, int i, int i2) {
        this.d = Integer.MIN_VALUE;
        this.e = Float.NaN;
        this.f = null;
        this.f1958a = str;
        this.f1959c = i;
        if (i == 901) {
            this.e = i2;
        } else {
            this.d = i2;
        }
    }

    public CustomVariable(String str, int i, Object obj) {
        this.d = Integer.MIN_VALUE;
        this.e = Float.NaN;
        this.f = null;
        this.f1958a = str;
        this.f1959c = i;
        setValue(obj);
    }

    public CustomVariable(String str, int i, String str2) {
        this.d = Integer.MIN_VALUE;
        this.e = Float.NaN;
        this.f = null;
        this.f1958a = str;
        this.f1959c = i;
        this.f = str2;
    }

    public CustomVariable(String str, int i, boolean z) {
        this.d = Integer.MIN_VALUE;
        this.e = Float.NaN;
        this.f = null;
        this.f1958a = str;
        this.f1959c = i;
        this.b = z;
    }

    private static int a(int i) {
        int i2 = (i & (i >> 31)) - 255;
        return (i2 & (i2 >> 31)) + 255;
    }

    public static String colorString(int i) {
        String str = "00000000" + Integer.toHexString(i);
        return "#" + str.substring(str.length() - 8);
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

    public static int rgbaTocColor(float f, float f2, float f3, float f4) {
        int a2 = a((int) (f * 255.0f));
        int a3 = a((int) (f2 * 255.0f));
        return (a2 << 16) | (a((int) (f4 * 255.0f)) << 24) | (a3 << 8) | a((int) (f3 * 255.0f));
    }

    public void applyToWidget(MotionWidget motionWidget) {
        int i = this.f1959c;
        switch (i) {
            case 900:
            case 902:
            case TypedValues.Custom.TYPE_REFERENCE /* 906 */:
                motionWidget.setCustomAttribute(this.f1958a, i, this.d);
                return;
            case 901:
            case 905:
                motionWidget.setCustomAttribute(this.f1958a, i, this.e);
                return;
            case 903:
                motionWidget.setCustomAttribute(this.f1958a, i, this.f);
                return;
            case 904:
                motionWidget.setCustomAttribute(this.f1958a, i, this.b);
                return;
            default:
                return;
        }
    }

    public CustomVariable copy() {
        return new CustomVariable(this);
    }

    public boolean diff(CustomVariable customVariable) {
        boolean z = false;
        if (customVariable != null) {
            int i = this.f1959c;
            if (i != customVariable.f1959c) {
                return false;
            }
            switch (i) {
                case 900:
                case TypedValues.Custom.TYPE_REFERENCE /* 906 */:
                    z = false;
                    if (this.d == customVariable.d) {
                        z = true;
                        break;
                    }
                    break;
                case 901:
                    boolean z2 = false;
                    if (this.e == customVariable.e) {
                        z2 = true;
                    }
                    return z2;
                case 902:
                    boolean z3 = false;
                    if (this.d == customVariable.d) {
                        z3 = true;
                    }
                    return z3;
                case 903:
                    boolean z4 = false;
                    if (this.d == customVariable.d) {
                        z4 = true;
                    }
                    return z4;
                case 904:
                    boolean z5 = false;
                    if (this.b == customVariable.b) {
                        z5 = true;
                    }
                    return z5;
                case 905:
                    boolean z6 = false;
                    if (this.e == customVariable.e) {
                        z6 = true;
                    }
                    return z6;
                default:
                    return false;
            }
        }
        return z;
    }

    public boolean getBooleanValue() {
        return this.b;
    }

    public int getColorValue() {
        return this.d;
    }

    public float getFloatValue() {
        return this.e;
    }

    public int getIntegerValue() {
        return this.d;
    }

    public int getInterpolatedColor(float[] fArr) {
        int a2 = a((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f));
        int a3 = a((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f));
        return (a((int) (fArr[3] * 255.0f)) << 24) | (a2 << 16) | (a3 << 8) | a((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f));
    }

    public String getName() {
        return this.f1958a;
    }

    public String getStringValue() {
        return this.f;
    }

    public int getType() {
        return this.f1959c;
    }

    public float getValueToInterpolate() {
        switch (this.f1959c) {
            case 900:
                return this.d;
            case 901:
                return this.e;
            case 902:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 903:
                throw new RuntimeException("Cannot interpolate String");
            case 904:
                return this.b ? 1.0f : 0.0f;
            case 905:
                return this.e;
            default:
                return Float.NaN;
        }
    }

    public void getValuesToInterpolate(float[] fArr) {
        switch (this.f1959c) {
            case 900:
                fArr[0] = this.d;
                return;
            case 901:
                fArr[0] = this.e;
                return;
            case 902:
                int i = this.d;
                float pow = (float) Math.pow(((i >> 16) & 255) / 255.0f, 2.2d);
                float pow2 = (float) Math.pow(((i >> 8) & 255) / 255.0f, 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = (float) Math.pow((i & 255) / 255.0f, 2.2d);
                fArr[3] = ((i >> 24) & 255) / 255.0f;
                return;
            case 903:
                throw new RuntimeException("Cannot interpolate String");
            case 904:
                fArr[0] = this.b ? 1.0f : 0.0f;
                return;
            case 905:
                fArr[0] = this.e;
                return;
            default:
                return;
        }
    }

    public boolean isContinuous() {
        int i = this.f1959c;
        return (i == 903 || i == 904 || i == 906) ? false : true;
    }

    public int numberOfInterpolatedValues() {
        return this.f1959c != 902 ? 1 : 4;
    }

    public void setBooleanValue(boolean z) {
        this.b = z;
    }

    public void setFloatValue(float f) {
        this.e = f;
    }

    public void setIntValue(int i) {
        this.d = i;
    }

    public void setInterpolatedValue(MotionWidget motionWidget, float[] fArr) {
        int i = this.f1959c;
        boolean z = true;
        switch (i) {
            case 900:
                motionWidget.setCustomAttribute(this.f1958a, i, (int) fArr[0]);
                return;
            case 901:
            case 905:
                motionWidget.setCustomAttribute(this.f1958a, i, fArr[0]);
                return;
            case 902:
                motionWidget.setCustomAttribute(this.f1958a, this.f1959c, (a((int) (fArr[3] * 255.0f)) << 24) | (a((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (a((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | a((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f)));
                return;
            case 903:
            case TypedValues.Custom.TYPE_REFERENCE /* 906 */:
                throw new RuntimeException("unable to interpolate " + this.f1958a);
            case 904:
                String str = this.f1958a;
                if (fArr[0] <= 0.5f) {
                    z = false;
                }
                motionWidget.setCustomAttribute(str, i, z);
                return;
            default:
                return;
        }
    }

    public void setStringValue(String str) {
        this.f = str;
    }

    public void setValue(Object obj) {
        switch (this.f1959c) {
            case 900:
            case TypedValues.Custom.TYPE_REFERENCE /* 906 */:
                this.d = ((Integer) obj).intValue();
                return;
            case 901:
                this.e = ((Float) obj).floatValue();
                return;
            case 902:
                this.d = ((Integer) obj).intValue();
                return;
            case 903:
                this.f = (String) obj;
                return;
            case 904:
                this.b = ((Boolean) obj).booleanValue();
                return;
            case 905:
                this.e = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }

    public void setValue(float[] fArr) {
        boolean z = true;
        switch (this.f1959c) {
            case 900:
            case TypedValues.Custom.TYPE_REFERENCE /* 906 */:
                this.d = (int) fArr[0];
                return;
            case 901:
            case 905:
                this.e = fArr[0];
                return;
            case 902:
                this.d = ((Math.round(fArr[3] * 255.0f) & 255) << 24) | ((Math.round(((float) Math.pow(fArr[0], 0.5d)) * 255.0f) & 255) << 16) | ((Math.round(((float) Math.pow(fArr[1], 0.5d)) * 255.0f) & 255) << 8) | (Math.round(((float) Math.pow(fArr[2], 0.5d)) * 255.0f) & 255);
                return;
            case 903:
                throw new RuntimeException("Cannot interpolate String");
            case 904:
                if (fArr[0] <= 0.5d) {
                    z = false;
                }
                this.b = z;
                return;
            default:
                return;
        }
    }

    public String toString() {
        String str = this.f1958a + ':';
        switch (this.f1959c) {
            case 900:
                return str + this.d;
            case 901:
                return str + this.e;
            case 902:
                return str + colorString(this.d);
            case 903:
                return str + this.f;
            case 904:
                return str + Boolean.valueOf(this.b);
            case 905:
                return str + this.e;
            default:
                return str + "????";
        }
    }
}

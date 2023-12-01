package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.Transition;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import com.huawei.hms.ads.jsb.constant.Constant;
import java.util.HashMap;
import java.util.Set;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/state/WidgetFrame.class */
public class WidgetFrame {
    public static float phone_orientation = Float.NaN;
    public float alpha;
    public int bottom;
    public float interpolatedPos;
    public int left;
    public final HashMap<String, CustomVariable> mCustom;
    public String name;
    public float pivotX;
    public float pivotY;
    public int right;
    public float rotationX;
    public float rotationY;
    public float rotationZ;
    public float scaleX;
    public float scaleY;
    public int top;
    public float translationX;
    public float translationY;
    public float translationZ;
    public int visibility;
    public ConstraintWidget widget;

    public WidgetFrame() {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.mCustom = new HashMap<>();
        this.name = null;
    }

    public WidgetFrame(WidgetFrame widgetFrame) {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.mCustom = new HashMap<>();
        this.name = null;
        this.widget = widgetFrame.widget;
        this.left = widgetFrame.left;
        this.top = widgetFrame.top;
        this.right = widgetFrame.right;
        this.bottom = widgetFrame.bottom;
        updateAttributes(widgetFrame);
    }

    public WidgetFrame(ConstraintWidget constraintWidget) {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.mCustom = new HashMap<>();
        this.name = null;
        this.widget = constraintWidget;
    }

    private static float a(float f, float f2, float f3, float f4) {
        boolean isNaN = Float.isNaN(f);
        boolean isNaN2 = Float.isNaN(f2);
        if (isNaN && isNaN2) {
            return Float.NaN;
        }
        if (isNaN) {
            f = f3;
        }
        if (isNaN2) {
            f2 = f3;
        }
        return f + (f4 * (f2 - f));
    }

    private void a(StringBuilder sb, ConstraintAnchor.Type type) {
        ConstraintAnchor anchor = this.widget.getAnchor(type);
        if (anchor == null || anchor.mTarget == null) {
            return;
        }
        sb.append("Anchor");
        sb.append(type.name());
        sb.append(": ['");
        String str = anchor.mTarget.getOwner().stringId;
        String str2 = str;
        if (str == null) {
            str2 = "#PARENT";
        }
        sb.append(str2);
        sb.append("', '");
        sb.append(anchor.mTarget.getType().name());
        sb.append("', '");
        sb.append(anchor.mMargin);
        sb.append("'],\n");
    }

    private static void a(StringBuilder sb, String str, float f) {
        if (Float.isNaN(f)) {
            return;
        }
        sb.append(str);
        sb.append(": ");
        sb.append(f);
        sb.append(",\n");
    }

    private static void a(StringBuilder sb, String str, int i) {
        sb.append(str);
        sb.append(": ");
        sb.append(i);
        sb.append(",\n");
    }

    public static void interpolate(int i, int i2, WidgetFrame widgetFrame, WidgetFrame widgetFrame2, WidgetFrame widgetFrame3, Transition transition, float f) {
        int i3;
        int i4;
        float f2;
        int i5;
        int i6;
        float f3 = 100.0f * f;
        int i7 = (int) f3;
        int i8 = widgetFrame2.left;
        int i9 = widgetFrame2.top;
        int i10 = widgetFrame3.left;
        int i11 = widgetFrame3.top;
        int i12 = widgetFrame2.right;
        int i13 = widgetFrame2.bottom;
        int i14 = widgetFrame3.right - i10;
        int i15 = widgetFrame3.bottom - i11;
        float f4 = widgetFrame2.alpha;
        float f5 = widgetFrame3.alpha;
        if (widgetFrame2.visibility == 8) {
            i8 = (int) (i8 - (i14 / 2.0f));
            i9 = (int) (i9 - (i15 / 2.0f));
            if (Float.isNaN(f4)) {
                i4 = i15;
                i3 = i14;
                f4 = 0.0f;
            } else {
                i3 = i14;
                i4 = i15;
            }
        } else {
            i3 = i12 - i8;
            i4 = i13 - i9;
        }
        float f6 = f5;
        int i16 = i10;
        int i17 = i11;
        if (widgetFrame3.visibility == 8) {
            int i18 = (int) (i10 - (i3 / 2.0f));
            int i19 = (int) (i11 - (i4 / 2.0f));
            boolean isNaN = Float.isNaN(f5);
            int i20 = i3;
            int i21 = i4;
            f6 = f5;
            i16 = i18;
            i17 = i19;
            i15 = i21;
            i14 = i20;
            if (isNaN) {
                f6 = 0.0f;
                i14 = i20;
                i15 = i21;
                i17 = i19;
                i16 = i18;
            }
        }
        float f7 = f4;
        if (Float.isNaN(f4)) {
            f7 = f4;
            if (!Float.isNaN(f6)) {
                f7 = 1.0f;
            }
        }
        float f8 = f6;
        if (!Float.isNaN(f7)) {
            f8 = f6;
            if (Float.isNaN(f6)) {
                f8 = 1.0f;
            }
        }
        float f9 = widgetFrame2.visibility == 4 ? 0.0f : f7;
        if (widgetFrame3.visibility == 4) {
            f8 = 0.0f;
        }
        if (widgetFrame.widget == null || !transition.hasPositionKeyframes()) {
            f2 = f;
        } else {
            Transition.KeyPosition findPreviousPosition = transition.findPreviousPosition(widgetFrame.widget.stringId, i7);
            Transition.KeyPosition findNextPosition = transition.findNextPosition(widgetFrame.widget.stringId, i7);
            Transition.KeyPosition keyPosition = findNextPosition;
            if (findPreviousPosition == findNextPosition) {
                keyPosition = null;
            }
            if (findPreviousPosition != null) {
                i8 = (int) (findPreviousPosition.d * i);
                i9 = (int) (findPreviousPosition.e * i2);
                i5 = findPreviousPosition.f2103a;
            } else {
                i5 = 0;
            }
            if (keyPosition != null) {
                i16 = (int) (keyPosition.d * i);
                i17 = (int) (keyPosition.e * i2);
                i6 = keyPosition.f2103a;
            } else {
                i6 = 100;
            }
            f2 = (f3 - i5) / (i6 - i5);
        }
        widgetFrame.widget = widgetFrame2.widget;
        int i22 = (int) (i8 + ((i16 - i8) * f2));
        widgetFrame.left = i22;
        int i23 = (int) (i9 + (f2 * (i17 - i9)));
        widgetFrame.top = i23;
        float f10 = 1.0f - f;
        widgetFrame.right = i22 + ((int) ((i3 * f10) + (i14 * f)));
        widgetFrame.bottom = i23 + ((int) ((f10 * i4) + (i15 * f)));
        widgetFrame.pivotX = a(widgetFrame2.pivotX, widgetFrame3.pivotX, 0.5f, f);
        widgetFrame.pivotY = a(widgetFrame2.pivotY, widgetFrame3.pivotY, 0.5f, f);
        widgetFrame.rotationX = a(widgetFrame2.rotationX, widgetFrame3.rotationX, 0.0f, f);
        widgetFrame.rotationY = a(widgetFrame2.rotationY, widgetFrame3.rotationY, 0.0f, f);
        widgetFrame.rotationZ = a(widgetFrame2.rotationZ, widgetFrame3.rotationZ, 0.0f, f);
        widgetFrame.scaleX = a(widgetFrame2.scaleX, widgetFrame3.scaleX, 1.0f, f);
        widgetFrame.scaleY = a(widgetFrame2.scaleY, widgetFrame3.scaleY, 1.0f, f);
        widgetFrame.translationX = a(widgetFrame2.translationX, widgetFrame3.translationX, 0.0f, f);
        widgetFrame.translationY = a(widgetFrame2.translationY, widgetFrame3.translationY, 0.0f, f);
        widgetFrame.translationZ = a(widgetFrame2.translationZ, widgetFrame3.translationZ, 0.0f, f);
        widgetFrame.alpha = a(f9, f8, 1.0f, f);
        Set<String> keySet = widgetFrame3.mCustom.keySet();
        widgetFrame.mCustom.clear();
        for (String str : keySet) {
            if (widgetFrame2.mCustom.containsKey(str)) {
                CustomVariable customVariable = widgetFrame2.mCustom.get(str);
                CustomVariable customVariable2 = widgetFrame3.mCustom.get(str);
                CustomVariable customVariable3 = new CustomVariable(customVariable);
                widgetFrame.mCustom.put(str, customVariable3);
                if (customVariable.numberOfInterpolatedValues() == 1) {
                    customVariable3.setValue(Float.valueOf(a(customVariable.getValueToInterpolate(), customVariable2.getValueToInterpolate(), 0.0f, f)));
                } else {
                    int numberOfInterpolatedValues = customVariable.numberOfInterpolatedValues();
                    float[] fArr = new float[numberOfInterpolatedValues];
                    float[] fArr2 = new float[numberOfInterpolatedValues];
                    customVariable.getValuesToInterpolate(fArr);
                    customVariable2.getValuesToInterpolate(fArr2);
                    int i24 = 0;
                    while (true) {
                        int i25 = i24;
                        if (i25 < numberOfInterpolatedValues) {
                            fArr[i25] = a(fArr[i25], fArr2[i25], 0.0f, f);
                            customVariable3.setValue(fArr);
                            i24 = i25 + 1;
                        }
                    }
                }
            }
        }
    }

    void a(CLElement cLElement) throws CLParsingException {
        CLObject cLObject = (CLObject) cLElement;
        int size = cLObject.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            CLKey cLKey = (CLKey) cLObject.get(i2);
            cLKey.content();
            CLElement value = cLKey.getValue();
            String content = value.content();
            if (content.matches("#[0-9a-fA-F]+")) {
                setCustomAttribute(cLKey.content(), 902, Integer.parseInt(content.substring(1), 16));
            } else if (value instanceof CLNumber) {
                setCustomAttribute(cLKey.content(), 901, value.getFloat());
            } else {
                setCustomAttribute(cLKey.content(), 903, content);
            }
            i = i2 + 1;
        }
    }

    public void addCustomColor(String str, int i) {
        setCustomAttribute(str, 902, i);
    }

    public void addCustomFloat(String str, float f) {
        setCustomAttribute(str, 901, f);
    }

    public float centerX() {
        int i = this.left;
        return i + ((this.right - i) / 2.0f);
    }

    public float centerY() {
        int i = this.top;
        return i + ((this.bottom - i) / 2.0f);
    }

    public CustomVariable getCustomAttribute(String str) {
        return this.mCustom.get(str);
    }

    public Set<String> getCustomAttributeNames() {
        return this.mCustom.keySet();
    }

    public int getCustomColor(String str) {
        if (this.mCustom.containsKey(str)) {
            return this.mCustom.get(str).getColorValue();
        }
        return -21880;
    }

    public float getCustomFloat(String str) {
        if (this.mCustom.containsKey(str)) {
            return this.mCustom.get(str).getFloatValue();
        }
        return Float.NaN;
    }

    public String getId() {
        ConstraintWidget constraintWidget = this.widget;
        return constraintWidget == null ? "unknown" : constraintWidget.stringId;
    }

    public int height() {
        return Math.max(0, this.bottom - this.top);
    }

    public boolean isDefaultTransform() {
        return Float.isNaN(this.rotationX) && Float.isNaN(this.rotationY) && Float.isNaN(this.rotationZ) && Float.isNaN(this.translationX) && Float.isNaN(this.translationY) && Float.isNaN(this.translationZ) && Float.isNaN(this.scaleX) && Float.isNaN(this.scaleY) && Float.isNaN(this.alpha);
    }

    public StringBuilder serialize(StringBuilder sb) {
        return serialize(sb, false);
    }

    public StringBuilder serialize(StringBuilder sb, boolean z) {
        sb.append("{\n");
        a(sb, "left", this.left);
        a(sb, Constant.MAP_KEY_TOP, this.top);
        a(sb, "right", this.right);
        a(sb, "bottom", this.bottom);
        a(sb, "pivotX", this.pivotX);
        a(sb, "pivotY", this.pivotY);
        a(sb, "rotationX", this.rotationX);
        a(sb, "rotationY", this.rotationY);
        a(sb, "rotationZ", this.rotationZ);
        a(sb, "translationX", this.translationX);
        a(sb, "translationY", this.translationY);
        a(sb, "translationZ", this.translationZ);
        a(sb, "scaleX", this.scaleX);
        a(sb, "scaleY", this.scaleY);
        a(sb, "alpha", this.alpha);
        a(sb, "visibility", this.visibility);
        a(sb, "interpolatedPos", this.interpolatedPos);
        if (this.widget != null) {
            ConstraintAnchor.Type[] values = ConstraintAnchor.Type.values();
            int length = values.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                a(sb, values[i2]);
                i = i2 + 1;
            }
        }
        if (z) {
            a(sb, "phone_orientation", phone_orientation);
        }
        if (z) {
            a(sb, "phone_orientation", phone_orientation);
        }
        if (this.mCustom.size() != 0) {
            sb.append("custom : {\n");
            for (String str : this.mCustom.keySet()) {
                CustomVariable customVariable = this.mCustom.get(str);
                sb.append(str);
                sb.append(": ");
                switch (customVariable.getType()) {
                    case 900:
                        sb.append(customVariable.getIntegerValue());
                        sb.append(",\n");
                        break;
                    case 901:
                    case 905:
                        sb.append(customVariable.getFloatValue());
                        sb.append(",\n");
                        break;
                    case 902:
                        sb.append("'");
                        sb.append(CustomVariable.colorString(customVariable.getIntegerValue()));
                        sb.append("',\n");
                        break;
                    case 903:
                        sb.append("'");
                        sb.append(customVariable.getStringValue());
                        sb.append("',\n");
                        break;
                    case 904:
                        sb.append("'");
                        sb.append(customVariable.getBooleanValue());
                        sb.append("',\n");
                        break;
                }
            }
            sb.append("}\n");
        }
        sb.append("}\n");
        return sb;
    }

    public void setCustomAttribute(String str, int i, float f) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setFloatValue(f);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i, f));
        }
    }

    public void setCustomAttribute(String str, int i, int i2) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setIntValue(i2);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i, i2));
        }
    }

    public void setCustomAttribute(String str, int i, String str2) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setStringValue(str2);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i, str2));
        }
    }

    public void setCustomAttribute(String str, int i, boolean z) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setBooleanValue(z);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i, z));
        }
    }

    public void setCustomValue(CustomAttribute customAttribute, float[] fArr) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean setValue(String str, CLElement cLElement) throws CLParsingException {
        boolean z;
        switch (str.hashCode()) {
            case -1881940865:
                if (str.equals("phone_orientation")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1383228885:
                if (str.equals("bottom")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1349088399:
                if (str.equals("custom")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1249320804:
                if (str.equals("rotationZ")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -987906986:
                if (str.equals("pivotX")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case -987906985:
                if (str.equals("pivotY")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 115029:
                if (str.equals(Constant.MAP_KEY_TOP)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 3317767:
                if (str.equals("left")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 108511772:
                if (str.equals("right")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 642850769:
                if (str.equals("interpolatedPos")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        switch (z) {
            case false:
                this.pivotX = cLElement.getFloat();
                return true;
            case true:
                this.pivotY = cLElement.getFloat();
                return true;
            case true:
                this.rotationX = cLElement.getFloat();
                return true;
            case true:
                this.rotationY = cLElement.getFloat();
                return true;
            case true:
                this.rotationZ = cLElement.getFloat();
                return true;
            case true:
                this.translationX = cLElement.getFloat();
                return true;
            case true:
                this.translationY = cLElement.getFloat();
                return true;
            case true:
                this.translationZ = cLElement.getFloat();
                return true;
            case true:
                this.scaleX = cLElement.getFloat();
                return true;
            case true:
                this.scaleY = cLElement.getFloat();
                return true;
            case true:
                this.alpha = cLElement.getFloat();
                return true;
            case true:
                this.interpolatedPos = cLElement.getFloat();
                return true;
            case true:
                phone_orientation = cLElement.getFloat();
                return true;
            case true:
                this.top = cLElement.getInt();
                return true;
            case true:
                this.left = cLElement.getInt();
                return true;
            case true:
                this.right = cLElement.getInt();
                return true;
            case true:
                this.bottom = cLElement.getInt();
                return true;
            case true:
                a(cLElement);
                return true;
            default:
                return false;
        }
    }

    public WidgetFrame update() {
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget != null) {
            this.left = constraintWidget.getLeft();
            this.top = this.widget.getTop();
            this.right = this.widget.getRight();
            this.bottom = this.widget.getBottom();
            updateAttributes(this.widget.frame);
        }
        return this;
    }

    public WidgetFrame update(ConstraintWidget constraintWidget) {
        if (constraintWidget == null) {
            return this;
        }
        this.widget = constraintWidget;
        update();
        return this;
    }

    public void updateAttributes(WidgetFrame widgetFrame) {
        this.pivotX = widgetFrame.pivotX;
        this.pivotY = widgetFrame.pivotY;
        this.rotationX = widgetFrame.rotationX;
        this.rotationY = widgetFrame.rotationY;
        this.rotationZ = widgetFrame.rotationZ;
        this.translationX = widgetFrame.translationX;
        this.translationY = widgetFrame.translationY;
        this.translationZ = widgetFrame.translationZ;
        this.scaleX = widgetFrame.scaleX;
        this.scaleY = widgetFrame.scaleY;
        this.alpha = widgetFrame.alpha;
        this.visibility = widgetFrame.visibility;
        this.mCustom.clear();
        if (widgetFrame != null) {
            for (CustomVariable customVariable : widgetFrame.mCustom.values()) {
                this.mCustom.put(customVariable.getName(), customVariable.copy());
            }
        }
    }

    public int width() {
        return Math.max(0, this.right - this.left);
    }
}

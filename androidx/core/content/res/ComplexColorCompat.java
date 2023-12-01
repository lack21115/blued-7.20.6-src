package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/content/res/ComplexColorCompat.class */
public final class ComplexColorCompat {

    /* renamed from: a  reason: collision with root package name */
    private final Shader f2427a;
    private final ColorStateList b;

    /* renamed from: c  reason: collision with root package name */
    private int f2428c;

    private ComplexColorCompat(Shader shader, ColorStateList colorStateList, int i) {
        this.f2427a = shader;
        this.b = colorStateList;
        this.f2428c = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ComplexColorCompat a(int i) {
        return new ComplexColorCompat(null, null, i);
    }

    static ComplexColorCompat a(ColorStateList colorStateList) {
        return new ComplexColorCompat(null, colorStateList, colorStateList.getDefaultColor());
    }

    private static ComplexColorCompat a(Resources resources, int i, Resources.Theme theme) throws IOException, XmlPullParserException {
        int next;
        XmlResourceParser xml = resources.getXml(i);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            String name = xml.getName();
            boolean z = true;
            int hashCode = name.hashCode();
            if (hashCode != 89650992) {
                if (hashCode == 1191572447 && name.equals("selector")) {
                    z = false;
                }
            } else if (name.equals("gradient")) {
                z = true;
            }
            if (z) {
                if (z) {
                    return a(GradientColorInflaterCompat.a(resources, xml, asAttributeSet, theme));
                }
                throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
            }
            return a(ColorStateListInflaterCompat.createFromXmlInner(resources, xml, asAttributeSet, theme));
        }
        throw new XmlPullParserException("No start tag found");
    }

    static ComplexColorCompat a(Shader shader) {
        return new ComplexColorCompat(shader, null, 0);
    }

    public static ComplexColorCompat inflate(Resources resources, int i, Resources.Theme theme) {
        try {
            return a(resources, i, theme);
        } catch (Exception e) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e);
            return null;
        }
    }

    public int getColor() {
        return this.f2428c;
    }

    public Shader getShader() {
        return this.f2427a;
    }

    public boolean isGradient() {
        return this.f2427a != null;
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        return this.f2427a == null && (colorStateList = this.b) != null && colorStateList.isStateful();
    }

    public boolean onStateChanged(int[] iArr) {
        ColorStateList colorStateList;
        int colorForState;
        if (!isStateful() || (colorForState = (colorStateList = this.b).getColorForState(iArr, colorStateList.getDefaultColor())) == this.f2428c) {
            return false;
        }
        this.f2428c = colorForState;
        return true;
    }

    public void setColor(int i) {
        this.f2428c = i;
    }

    public boolean willDraw() {
        return isGradient() || this.f2428c != 0;
    }
}

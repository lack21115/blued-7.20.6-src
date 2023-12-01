package java.awt.font;

import com.anythink.core.api.ATAdConst;
import java.text.AttributedCharacterIterator;

/* loaded from: source-2895416-dex2jar.jar:java/awt/font/TextAttribute.class */
public final class TextAttribute extends AttributedCharacterIterator.Attribute {
    private static final long serialVersionUID = 7744112784117861702L;
    public static final TextAttribute BACKGROUND = new TextAttribute("background");
    public static final TextAttribute BIDI_EMBEDDING = new TextAttribute("bidi_embedding");
    public static final TextAttribute CHAR_REPLACEMENT = new TextAttribute("char_replacement");
    public static final TextAttribute FAMILY = new TextAttribute("family");
    public static final TextAttribute FONT = new TextAttribute("font");
    public static final TextAttribute FOREGROUND = new TextAttribute("foreground");
    public static final TextAttribute INPUT_METHOD_HIGHLIGHT = new TextAttribute("input method highlight");
    public static final TextAttribute INPUT_METHOD_UNDERLINE = new TextAttribute("input method underline");
    public static final TextAttribute JUSTIFICATION = new TextAttribute("justification");
    public static final Float JUSTIFICATION_FULL = new Float(1.0f);
    public static final Float JUSTIFICATION_NONE = new Float(0.0f);
    public static final TextAttribute KERNING = new TextAttribute("kerning");
    public static final Integer KERNING_ON = 1;
    public static final TextAttribute LIGATURES = new TextAttribute("ligatures");
    public static final Integer LIGATURES_ON = 1;
    public static final TextAttribute NUMERIC_SHAPING = new TextAttribute("numeric_shaping");
    public static final TextAttribute POSTURE = new TextAttribute("posture");
    public static final Float POSTURE_REGULAR = new Float(0.0f);
    public static final Float POSTURE_OBLIQUE = new Float(0.2f);
    public static final TextAttribute RUN_DIRECTION = new TextAttribute("run_direction");
    public static final Boolean RUN_DIRECTION_LTR = false;
    public static final Boolean RUN_DIRECTION_RTL = true;
    public static final TextAttribute SIZE = new TextAttribute(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE);
    public static final TextAttribute STRIKETHROUGH = new TextAttribute("strikethrough");
    public static final Boolean STRIKETHROUGH_ON = true;
    public static final TextAttribute SUPERSCRIPT = new TextAttribute("superscript");
    public static final Integer SUPERSCRIPT_SUB = -1;
    public static final Integer SUPERSCRIPT_SUPER = 1;
    public static final TextAttribute SWAP_COLORS = new TextAttribute("swap_colors");
    public static final Boolean SWAP_COLORS_ON = true;
    public static final TextAttribute TRACKING = new TextAttribute("tracking");
    public static final Float TRACKING_LOOSE = Float.valueOf(0.04f);
    public static final Float TRACKING_TIGHT = Float.valueOf(-0.04f);
    public static final TextAttribute TRANSFORM = new TextAttribute("transform");
    public static final TextAttribute UNDERLINE = new TextAttribute("underline");
    public static final Integer UNDERLINE_ON = 0;
    public static final Integer UNDERLINE_LOW_ONE_PIXEL = 1;
    public static final Integer UNDERLINE_LOW_TWO_PIXEL = 2;
    public static final Integer UNDERLINE_LOW_DOTTED = 3;
    public static final Integer UNDERLINE_LOW_GRAY = 4;
    public static final Integer UNDERLINE_LOW_DASHED = 5;
    public static final TextAttribute WEIGHT = new TextAttribute("weight");
    public static final Float WEIGHT_EXTRA_LIGHT = new Float(0.5f);
    public static final Float WEIGHT_LIGHT = new Float(0.75f);
    public static final Float WEIGHT_DEMILIGHT = new Float(0.875f);
    public static final Float WEIGHT_REGULAR = new Float(1.0f);
    public static final Float WEIGHT_SEMIBOLD = new Float(1.25f);
    public static final Float WEIGHT_MEDIUM = new Float(1.5f);
    public static final Float WEIGHT_DEMIBOLD = new Float(1.75f);
    public static final Float WEIGHT_BOLD = new Float(2.0f);
    public static final Float WEIGHT_HEAVY = new Float(2.25f);
    public static final Float WEIGHT_EXTRABOLD = new Float(2.5f);
    public static final Float WEIGHT_ULTRABOLD = new Float(2.75f);
    public static final TextAttribute WIDTH = new TextAttribute("width");
    public static final Float WIDTH_CONDENSED = new Float(0.75f);
    public static final Float WIDTH_SEMI_CONDENSED = new Float(0.875f);
    public static final Float WIDTH_REGULAR = new Float(1.0f);
    public static final Float WIDTH_SEMI_EXTENDED = new Float(1.25f);
    public static final Float WIDTH_EXTENDED = new Float(1.5f);

    protected TextAttribute(String str) {
        super(str);
    }
}

package android.text;

import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.ParagraphStyle;
import android.text.style.QuoteSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import com.android.internal.util.ArrayUtils;
import com.huawei.openalliance.ad.constant.t;
import com.j256.ormlite.stmt.query.SimpleComparison;
import org.ccil.cowan.tagsoup.HTMLSchema;
import org.ccil.cowan.tagsoup.Parser;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

/* loaded from: source-9557208-dex2jar.jar:android/text/Html.class */
public class Html {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/text/Html$HtmlParser.class */
    public static class HtmlParser {
        private static final HTMLSchema schema = new HTMLSchema();

        private HtmlParser() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/text/Html$ImageGetter.class */
    public interface ImageGetter {
        Drawable getDrawable(String str);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/text/Html$TagHandler.class */
    public interface TagHandler {
        void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader);
    }

    private Html() {
    }

    public static String escapeHtml(CharSequence charSequence) {
        StringBuilder sb = new StringBuilder();
        withinStyle(sb, charSequence, 0, charSequence.length());
        return sb.toString();
    }

    public static Spanned fromHtml(String str) {
        return fromHtml(str, null, null);
    }

    public static Spanned fromHtml(String str, ImageGetter imageGetter, TagHandler tagHandler) {
        Parser parser = new Parser();
        try {
            parser.setProperty("http://www.ccil.org/~cowan/tagsoup/properties/schema", HtmlParser.schema);
            return new HtmlToSpannedConverter(str, imageGetter, tagHandler, parser).convert();
        } catch (SAXNotRecognizedException e) {
            throw new RuntimeException(e);
        } catch (SAXNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static String getOpenParaTagWithDirection(Spanned spanned, int i, int i2) {
        int i3 = i2 - i;
        byte[] newUnpaddedByteArray = ArrayUtils.newUnpaddedByteArray(i3);
        char[] obtain = TextUtils.obtain(i3);
        TextUtils.getChars(spanned, i, i2, obtain, 0);
        switch (AndroidBidi.bidi(2, obtain, newUnpaddedByteArray, i3, false)) {
            case -1:
                return "<p dir=\"rtl\">";
            default:
                return "<p dir=\"ltr\">";
        }
    }

    public static String toHtml(Spanned spanned) {
        StringBuilder sb = new StringBuilder();
        withinHtml(sb, spanned);
        return sb.toString();
    }

    private static void withinBlockquote(StringBuilder sb, Spanned spanned, int i, int i2) {
        sb.append(getOpenParaTagWithDirection(spanned, i, i2));
        while (true) {
            int i3 = i;
            if (i3 >= i2) {
                sb.append("</p>\n");
                return;
            }
            int indexOf = TextUtils.indexOf((CharSequence) spanned, '\n', i3, i2);
            i = indexOf;
            if (indexOf < 0) {
                i = i2;
            }
            int i4 = 0;
            while (i < i2 && spanned.charAt(i) == '\n') {
                i4++;
                i++;
            }
            withinParagraph(sb, spanned, i3, i - i4, i4, i == i2);
        }
    }

    private static void withinDiv(StringBuilder sb, Spanned spanned, int i, int i2) {
        while (i < i2) {
            int nextSpanTransition = spanned.nextSpanTransition(i, i2, QuoteSpan.class);
            QuoteSpan[] quoteSpanArr = (QuoteSpan[]) spanned.getSpans(i, nextSpanTransition, QuoteSpan.class);
            int length = quoteSpanArr.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length) {
                    break;
                }
                QuoteSpan quoteSpan = quoteSpanArr[i4];
                sb.append("<blockquote>");
                i3 = i4 + 1;
            }
            withinBlockquote(sb, spanned, i, nextSpanTransition);
            int length2 = quoteSpanArr.length;
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 < length2) {
                    QuoteSpan quoteSpan2 = quoteSpanArr[i6];
                    sb.append("</blockquote>\n");
                    i5 = i6 + 1;
                }
            }
            i = nextSpanTransition;
        }
    }

    private static void withinHtml(StringBuilder sb, Spanned spanned) {
        int length = spanned.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= spanned.length()) {
                return;
            }
            int nextSpanTransition = spanned.nextSpanTransition(i2, length, ParagraphStyle.class);
            ParagraphStyle[] paragraphStyleArr = (ParagraphStyle[]) spanned.getSpans(i2, nextSpanTransition, ParagraphStyle.class);
            String str = " ";
            boolean z = false;
            int i3 = 0;
            while (i3 < paragraphStyleArr.length) {
                String str2 = str;
                if (paragraphStyleArr[i3] instanceof AlignmentSpan) {
                    Layout.Alignment alignment = ((AlignmentSpan) paragraphStyleArr[i3]).getAlignment();
                    z = true;
                    str2 = alignment == Layout.Alignment.ALIGN_CENTER ? "align=\"center\" " + str : alignment == Layout.Alignment.ALIGN_OPPOSITE ? "align=\"right\" " + str : "align=\"left\" " + str;
                }
                i3++;
                str = str2;
            }
            if (z) {
                sb.append("<div ").append(str).append(SimpleComparison.GREATER_THAN_OPERATION);
            }
            withinDiv(sb, spanned, i2, nextSpanTransition);
            if (z) {
                sb.append("</div>");
            }
            i = nextSpanTransition;
        }
    }

    private static void withinParagraph(StringBuilder sb, Spanned spanned, int i, int i2, int i3, boolean z) {
        String str;
        int i4 = i;
        while (true) {
            int i5 = i4;
            if (i5 >= i2) {
                break;
            }
            int nextSpanTransition = spanned.nextSpanTransition(i5, i2, CharacterStyle.class);
            CharacterStyle[] characterStyleArr = (CharacterStyle[]) spanned.getSpans(i5, nextSpanTransition, CharacterStyle.class);
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= characterStyleArr.length) {
                    break;
                }
                if (characterStyleArr[i7] instanceof StyleSpan) {
                    int style = ((StyleSpan) characterStyleArr[i7]).getStyle();
                    if ((style & 1) != 0) {
                        sb.append("<b>");
                    }
                    if ((style & 2) != 0) {
                        sb.append("<i>");
                    }
                }
                if ((characterStyleArr[i7] instanceof TypefaceSpan) && ((TypefaceSpan) characterStyleArr[i7]).getFamily().equals("monospace")) {
                    sb.append("<tt>");
                }
                if (characterStyleArr[i7] instanceof SuperscriptSpan) {
                    sb.append("<sup>");
                }
                if (characterStyleArr[i7] instanceof SubscriptSpan) {
                    sb.append("<sub>");
                }
                if (characterStyleArr[i7] instanceof UnderlineSpan) {
                    sb.append("<u>");
                }
                if (characterStyleArr[i7] instanceof StrikethroughSpan) {
                    sb.append("<strike>");
                }
                if (characterStyleArr[i7] instanceof URLSpan) {
                    sb.append("<a href=\"");
                    sb.append(((URLSpan) characterStyleArr[i7]).getURL());
                    sb.append("\">");
                }
                if (characterStyleArr[i7] instanceof ImageSpan) {
                    sb.append("<img src=\"");
                    sb.append(((ImageSpan) characterStyleArr[i7]).getSource());
                    sb.append("\">");
                    i5 = nextSpanTransition;
                }
                if (characterStyleArr[i7] instanceof AbsoluteSizeSpan) {
                    sb.append("<font size =\"");
                    sb.append(((AbsoluteSizeSpan) characterStyleArr[i7]).getSize() / 6);
                    sb.append("\">");
                }
                if (characterStyleArr[i7] instanceof ForegroundColorSpan) {
                    sb.append("<font color =\"#");
                    String hexString = Integer.toHexString(((ForegroundColorSpan) characterStyleArr[i7]).getForegroundColor() + 16777216);
                    while (true) {
                        str = hexString;
                        if (str.length() >= 6) {
                            break;
                        }
                        hexString = "0" + str;
                    }
                    sb.append(str);
                    sb.append("\">");
                }
                i6 = i7 + 1;
            }
            withinStyle(sb, spanned, i5, nextSpanTransition);
            int length = characterStyleArr.length;
            while (true) {
                int i8 = length - 1;
                if (i8 >= 0) {
                    if (characterStyleArr[i8] instanceof ForegroundColorSpan) {
                        sb.append("</font>");
                    }
                    if (characterStyleArr[i8] instanceof AbsoluteSizeSpan) {
                        sb.append("</font>");
                    }
                    if (characterStyleArr[i8] instanceof URLSpan) {
                        sb.append("</a>");
                    }
                    if (characterStyleArr[i8] instanceof StrikethroughSpan) {
                        sb.append("</strike>");
                    }
                    if (characterStyleArr[i8] instanceof UnderlineSpan) {
                        sb.append("</u>");
                    }
                    if (characterStyleArr[i8] instanceof SubscriptSpan) {
                        sb.append("</sub>");
                    }
                    if (characterStyleArr[i8] instanceof SuperscriptSpan) {
                        sb.append("</sup>");
                    }
                    if ((characterStyleArr[i8] instanceof TypefaceSpan) && ((TypefaceSpan) characterStyleArr[i8]).getFamily().equals("monospace")) {
                        sb.append("</tt>");
                    }
                    if (characterStyleArr[i8] instanceof StyleSpan) {
                        int style2 = ((StyleSpan) characterStyleArr[i8]).getStyle();
                        if ((style2 & 1) != 0) {
                            sb.append("</b>");
                        }
                        if ((style2 & 2) != 0) {
                            sb.append("</i>");
                        }
                    }
                    length = i8;
                }
            }
            i4 = nextSpanTransition;
        }
        String str2 = z ? "" : "</p>\n" + getOpenParaTagWithDirection(spanned, i, i2);
        if (i3 == 1) {
            sb.append("<br>\n");
        } else if (i3 == 2) {
            sb.append(str2);
        } else {
            int i9 = 2;
            while (true) {
                int i10 = i9;
                if (i10 >= i3) {
                    sb.append(str2);
                    return;
                } else {
                    sb.append("<br>");
                    i9 = i10 + 1;
                }
            }
        }
    }

    private static void withinStyle(StringBuilder sb, CharSequence charSequence, int i, int i2) {
        int i3;
        while (i < i2) {
            char charAt = charSequence.charAt(i);
            if (charAt == '<') {
                sb.append("&lt;");
                i3 = i;
            } else if (charAt == '>') {
                sb.append("&gt;");
                i3 = i;
            } else if (charAt == '&') {
                sb.append("&amp;");
                i3 = i;
            } else if (charAt >= 55296 && charAt <= 57343) {
                i3 = i;
                if (charAt < 56320) {
                    i3 = i;
                    if (i + 1 < i2) {
                        char charAt2 = charSequence.charAt(i + 1);
                        i3 = i;
                        if (charAt2 >= 56320) {
                            i3 = i;
                            if (charAt2 <= 57343) {
                                i3 = i + 1;
                                sb.append("&#").append(65536 | ((charAt - 55296) << 10) | (charAt2 - 56320)).append(t.aE);
                            }
                        }
                    }
                }
            } else if (charAt > '~' || charAt < ' ') {
                sb.append("&#").append((int) charAt).append(t.aE);
                i3 = i;
            } else if (charAt == ' ') {
                while (i + 1 < i2 && charSequence.charAt(i + 1) == ' ') {
                    sb.append("&nbsp;");
                    i++;
                }
                sb.append(' ');
                i3 = i;
            } else {
                sb.append(charAt);
                i3 = i;
            }
            i = i3 + 1;
        }
    }
}

package android.text;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.TtmlUtils;
import android.text.Html;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.ParagraphStyle;
import android.text.style.QuoteSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import com.android.internal.R;
import com.cdo.oaps.ad.OapsKey;
import com.sobot.chat.widget.html.SobotCustomTagHandler;
import java.io.IOException;
import java.io.StringReader;
import org.ccil.cowan.tagsoup.Parser;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/text/HtmlToSpannedConverter.class */
public class HtmlToSpannedConverter implements ContentHandler {
    private static final float[] HEADER_SIZES = {1.5f, 1.4f, 1.3f, 1.2f, 1.1f, 1.0f};
    private Html.ImageGetter mImageGetter;
    private XMLReader mReader;
    private String mSource;
    private SpannableStringBuilder mSpannableStringBuilder = new SpannableStringBuilder();
    private Html.TagHandler mTagHandler;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/text/HtmlToSpannedConverter$Big.class */
    public static class Big {
        private Big() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/text/HtmlToSpannedConverter$Blockquote.class */
    public static class Blockquote {
        private Blockquote() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/text/HtmlToSpannedConverter$Bold.class */
    public static class Bold {
        private Bold() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/text/HtmlToSpannedConverter$Font.class */
    public static class Font {
        public String mColor;
        public String mFace;

        public Font(String str, String str2) {
            this.mColor = str;
            this.mFace = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/text/HtmlToSpannedConverter$Header.class */
    public static class Header {
        private int mLevel;

        public Header(int i) {
            this.mLevel = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/text/HtmlToSpannedConverter$Href.class */
    public static class Href {
        public String mHref;

        public Href(String str) {
            this.mHref = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/text/HtmlToSpannedConverter$Italic.class */
    public static class Italic {
        private Italic() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/text/HtmlToSpannedConverter$Monospace.class */
    public static class Monospace {
        private Monospace() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/text/HtmlToSpannedConverter$Small.class */
    public static class Small {
        private Small() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/text/HtmlToSpannedConverter$Sub.class */
    public static class Sub {
        private Sub() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/text/HtmlToSpannedConverter$Super.class */
    public static class Super {
        private Super() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/text/HtmlToSpannedConverter$Underline.class */
    public static class Underline {
        private Underline() {
        }
    }

    public HtmlToSpannedConverter(String str, Html.ImageGetter imageGetter, Html.TagHandler tagHandler, Parser parser) {
        this.mSource = str;
        this.mImageGetter = imageGetter;
        this.mTagHandler = tagHandler;
        this.mReader = parser;
    }

    private static void end(SpannableStringBuilder spannableStringBuilder, Class cls, Object obj) {
        int length = spannableStringBuilder.length();
        Object last = getLast(spannableStringBuilder, cls);
        int spanStart = spannableStringBuilder.getSpanStart(last);
        spannableStringBuilder.removeSpan(last);
        if (spanStart != length) {
            spannableStringBuilder.setSpan(obj, spanStart, length, 33);
        }
    }

    private static void endA(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length();
        Object last = getLast(spannableStringBuilder, Href.class);
        int spanStart = spannableStringBuilder.getSpanStart(last);
        spannableStringBuilder.removeSpan(last);
        if (spanStart != length) {
            Href href = (Href) last;
            if (href.mHref != null) {
                spannableStringBuilder.setSpan(new URLSpan(href.mHref), spanStart, length, 33);
            }
        }
    }

    private static void endFont(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length();
        Object last = getLast(spannableStringBuilder, Font.class);
        int spanStart = spannableStringBuilder.getSpanStart(last);
        spannableStringBuilder.removeSpan(last);
        if (spanStart != length) {
            Font font = (Font) last;
            if (!TextUtils.isEmpty(font.mColor)) {
                if (font.mColor.startsWith("@")) {
                    Resources system = Resources.getSystem();
                    int identifier = system.getIdentifier(font.mColor.substring(1), "color", "android");
                    if (identifier != 0) {
                        spannableStringBuilder.setSpan(new TextAppearanceSpan(null, 0, 0, system.getColorStateList(identifier), null), spanStart, length, 33);
                    }
                } else {
                    int htmlColor = Color.getHtmlColor(font.mColor);
                    if (htmlColor != -1) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan((-16777216) | htmlColor), spanStart, length, 33);
                    }
                }
            }
            if (font.mFace != null) {
                spannableStringBuilder.setSpan(new TypefaceSpan(font.mFace), spanStart, length, 33);
            }
        }
    }

    private static void endHeader(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length();
        Object last = getLast(spannableStringBuilder, Header.class);
        int spanStart = spannableStringBuilder.getSpanStart(last);
        spannableStringBuilder.removeSpan(last);
        while (length > spanStart && spannableStringBuilder.charAt(length - 1) == '\n') {
            length--;
        }
        if (spanStart != length) {
            spannableStringBuilder.setSpan(new RelativeSizeSpan(HEADER_SIZES[((Header) last).mLevel]), spanStart, length, 33);
            spannableStringBuilder.setSpan(new StyleSpan(1), spanStart, length, 33);
        }
    }

    private static Object getLast(Spanned spanned, Class cls) {
        Object[] spans = spanned.getSpans(0, spanned.length(), cls);
        if (spans.length == 0) {
            return null;
        }
        return spans[spans.length - 1];
    }

    private static void handleBr(SpannableStringBuilder spannableStringBuilder) {
        spannableStringBuilder.append("\n");
    }

    private void handleEndTag(String str) {
        if (str.equalsIgnoreCase("br")) {
            handleBr(this.mSpannableStringBuilder);
        } else if (str.equalsIgnoreCase("p")) {
            handleP(this.mSpannableStringBuilder);
        } else if (str.equalsIgnoreCase(TtmlUtils.TAG_DIV)) {
            handleP(this.mSpannableStringBuilder);
        } else if (str.equalsIgnoreCase("strong")) {
            end(this.mSpannableStringBuilder, Bold.class, new StyleSpan(1));
        } else if (str.equalsIgnoreCase("b")) {
            end(this.mSpannableStringBuilder, Bold.class, new StyleSpan(1));
        } else if (str.equalsIgnoreCase("em")) {
            end(this.mSpannableStringBuilder, Italic.class, new StyleSpan(2));
        } else if (str.equalsIgnoreCase("cite")) {
            end(this.mSpannableStringBuilder, Italic.class, new StyleSpan(2));
        } else if (str.equalsIgnoreCase("dfn")) {
            end(this.mSpannableStringBuilder, Italic.class, new StyleSpan(2));
        } else if (str.equalsIgnoreCase("i")) {
            end(this.mSpannableStringBuilder, Italic.class, new StyleSpan(2));
        } else if (str.equalsIgnoreCase("big")) {
            end(this.mSpannableStringBuilder, Big.class, new RelativeSizeSpan(1.25f));
        } else if (str.equalsIgnoreCase("small")) {
            end(this.mSpannableStringBuilder, Small.class, new RelativeSizeSpan(0.8f));
        } else if (str.equalsIgnoreCase(SobotCustomTagHandler.HTML_FONT)) {
            endFont(this.mSpannableStringBuilder);
        } else if (str.equalsIgnoreCase("blockquote")) {
            handleP(this.mSpannableStringBuilder);
            end(this.mSpannableStringBuilder, Blockquote.class, new QuoteSpan());
        } else if (str.equalsIgnoreCase("tt")) {
            end(this.mSpannableStringBuilder, Monospace.class, new TypefaceSpan("monospace"));
        } else if (str.equalsIgnoreCase("a")) {
            endA(this.mSpannableStringBuilder);
        } else if (str.equalsIgnoreCase("u")) {
            end(this.mSpannableStringBuilder, Underline.class, new UnderlineSpan());
        } else if (str.equalsIgnoreCase("sup")) {
            end(this.mSpannableStringBuilder, Super.class, new SuperscriptSpan());
        } else if (str.equalsIgnoreCase("sub")) {
            end(this.mSpannableStringBuilder, Sub.class, new SubscriptSpan());
        } else if (str.length() == 2 && Character.toLowerCase(str.charAt(0)) == 'h' && str.charAt(1) >= '1' && str.charAt(1) <= '6') {
            handleP(this.mSpannableStringBuilder);
            endHeader(this.mSpannableStringBuilder);
        } else if (this.mTagHandler != null) {
            this.mTagHandler.handleTag(false, str, this.mSpannableStringBuilder, this.mReader);
        }
    }

    private static void handleP(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length();
        if (length < 1 || spannableStringBuilder.charAt(length - 1) != '\n') {
            if (length != 0) {
                spannableStringBuilder.append("\n\n");
            }
        } else if (length < 2 || spannableStringBuilder.charAt(length - 2) != '\n') {
            spannableStringBuilder.append("\n");
        }
    }

    private void handleStartTag(String str, Attributes attributes) {
        if (str.equalsIgnoreCase("br")) {
            return;
        }
        if (str.equalsIgnoreCase("p")) {
            handleP(this.mSpannableStringBuilder);
        } else if (str.equalsIgnoreCase(TtmlUtils.TAG_DIV)) {
            handleP(this.mSpannableStringBuilder);
        } else if (str.equalsIgnoreCase("strong")) {
            start(this.mSpannableStringBuilder, new Bold());
        } else if (str.equalsIgnoreCase("b")) {
            start(this.mSpannableStringBuilder, new Bold());
        } else if (str.equalsIgnoreCase("em")) {
            start(this.mSpannableStringBuilder, new Italic());
        } else if (str.equalsIgnoreCase("cite")) {
            start(this.mSpannableStringBuilder, new Italic());
        } else if (str.equalsIgnoreCase("dfn")) {
            start(this.mSpannableStringBuilder, new Italic());
        } else if (str.equalsIgnoreCase("i")) {
            start(this.mSpannableStringBuilder, new Italic());
        } else if (str.equalsIgnoreCase("big")) {
            start(this.mSpannableStringBuilder, new Big());
        } else if (str.equalsIgnoreCase("small")) {
            start(this.mSpannableStringBuilder, new Small());
        } else if (str.equalsIgnoreCase(SobotCustomTagHandler.HTML_FONT)) {
            startFont(this.mSpannableStringBuilder, attributes);
        } else if (str.equalsIgnoreCase("blockquote")) {
            handleP(this.mSpannableStringBuilder);
            start(this.mSpannableStringBuilder, new Blockquote());
        } else if (str.equalsIgnoreCase("tt")) {
            start(this.mSpannableStringBuilder, new Monospace());
        } else if (str.equalsIgnoreCase("a")) {
            startA(this.mSpannableStringBuilder, attributes);
        } else if (str.equalsIgnoreCase("u")) {
            start(this.mSpannableStringBuilder, new Underline());
        } else if (str.equalsIgnoreCase("sup")) {
            start(this.mSpannableStringBuilder, new Super());
        } else if (str.equalsIgnoreCase("sub")) {
            start(this.mSpannableStringBuilder, new Sub());
        } else if (str.length() == 2 && Character.toLowerCase(str.charAt(0)) == 'h' && str.charAt(1) >= '1' && str.charAt(1) <= '6') {
            handleP(this.mSpannableStringBuilder);
            start(this.mSpannableStringBuilder, new Header(str.charAt(1) - '1'));
        } else if (str.equalsIgnoreCase("img")) {
            startImg(this.mSpannableStringBuilder, attributes, this.mImageGetter);
        } else if (this.mTagHandler != null) {
            this.mTagHandler.handleTag(true, str, this.mSpannableStringBuilder, this.mReader);
        }
    }

    private static void start(SpannableStringBuilder spannableStringBuilder, Object obj) {
        int length = spannableStringBuilder.length();
        spannableStringBuilder.setSpan(obj, length, length, 17);
    }

    private static void startA(SpannableStringBuilder spannableStringBuilder, Attributes attributes) {
        String value = attributes.getValue("", "href");
        int length = spannableStringBuilder.length();
        spannableStringBuilder.setSpan(new Href(value), length, length, 17);
    }

    private static void startFont(SpannableStringBuilder spannableStringBuilder, Attributes attributes) {
        String value = attributes.getValue("", "color");
        String value2 = attributes.getValue("", "face");
        int length = spannableStringBuilder.length();
        spannableStringBuilder.setSpan(new Font(value, value2), length, length, 17);
    }

    private static void startImg(SpannableStringBuilder spannableStringBuilder, Attributes attributes, Html.ImageGetter imageGetter) {
        String value = attributes.getValue("", OapsKey.KEY_SRC);
        Drawable drawable = null;
        if (imageGetter != null) {
            drawable = imageGetter.getDrawable(value);
        }
        Drawable drawable2 = drawable;
        if (drawable == null) {
            drawable2 = Resources.getSystem().getDrawable(R.drawable.unknown_image);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        }
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append("￼");
        spannableStringBuilder.setSpan(new ImageSpan(drawable2, value), length, spannableStringBuilder.length(), 33);
    }

    @Override // org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) throws SAXException {
        char charAt;
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                this.mSpannableStringBuilder.append((CharSequence) sb);
                return;
            }
            char c2 = cArr[i4 + i];
            if (c2 == ' ' || c2 == '\n') {
                int length = sb.length();
                if (length == 0) {
                    int length2 = this.mSpannableStringBuilder.length();
                    charAt = length2 == 0 ? '\n' : this.mSpannableStringBuilder.charAt(length2 - 1);
                } else {
                    charAt = sb.charAt(length - 1);
                }
                if (charAt != ' ' && charAt != '\n') {
                    sb.append(' ');
                }
            } else {
                sb.append(c2);
            }
            i3 = i4 + 1;
        }
    }

    public Spanned convert() {
        this.mReader.setContentHandler(this);
        try {
            this.mReader.parse(new InputSource(new StringReader(this.mSource)));
            Object[] spans = this.mSpannableStringBuilder.getSpans(0, this.mSpannableStringBuilder.length(), ParagraphStyle.class);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= spans.length) {
                    return this.mSpannableStringBuilder;
                }
                int spanStart = this.mSpannableStringBuilder.getSpanStart(spans[i2]);
                int spanEnd = this.mSpannableStringBuilder.getSpanEnd(spans[i2]);
                int i3 = spanEnd;
                if (spanEnd - 2 >= 0) {
                    i3 = spanEnd;
                    if (this.mSpannableStringBuilder.charAt(spanEnd - 1) == '\n') {
                        i3 = spanEnd;
                        if (this.mSpannableStringBuilder.charAt(spanEnd - 2) == '\n') {
                            i3 = spanEnd - 1;
                        }
                    }
                }
                if (i3 == spanStart) {
                    this.mSpannableStringBuilder.removeSpan(spans[i2]);
                } else {
                    this.mSpannableStringBuilder.setSpan(spans[i2], spanStart, i3, 51);
                }
                i = i2 + 1;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // org.xml.sax.ContentHandler
    public void endDocument() throws SAXException {
    }

    @Override // org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        handleEndTag(str2);
    }

    @Override // org.xml.sax.ContentHandler
    public void endPrefixMapping(String str) throws SAXException {
    }

    @Override // org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException {
    }

    @Override // org.xml.sax.ContentHandler
    public void processingInstruction(String str, String str2) throws SAXException {
    }

    @Override // org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator locator) {
    }

    @Override // org.xml.sax.ContentHandler
    public void skippedEntity(String str) throws SAXException {
    }

    @Override // org.xml.sax.ContentHandler
    public void startDocument() throws SAXException {
    }

    @Override // org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        handleStartTag(str2, attributes);
    }

    @Override // org.xml.sax.ContentHandler
    public void startPrefixMapping(String str, String str2) throws SAXException {
    }
}

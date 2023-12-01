package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R;
import androidx.core.provider.FontRequest;
import com.sobot.chat.widget.html.SobotCustomTagHandler;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/content/res/FontResourcesParserCompat.class */
public class FontResourcesParserCompat {
    public static final int FETCH_STRATEGY_ASYNC = 1;
    public static final int FETCH_STRATEGY_BLOCKING = 0;
    public static final int INFINITE_TIMEOUT_VALUE = -1;

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/content/res/FontResourcesParserCompat$FamilyResourceEntry.class */
    public interface FamilyResourceEntry {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/content/res/FontResourcesParserCompat$FetchStrategy.class */
    public @interface FetchStrategy {
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/content/res/FontResourcesParserCompat$FontFamilyFilesResourceEntry.class */
    public static final class FontFamilyFilesResourceEntry implements FamilyResourceEntry {

        /* renamed from: a  reason: collision with root package name */
        private final FontFileResourceEntry[] f2429a;

        public FontFamilyFilesResourceEntry(FontFileResourceEntry[] fontFileResourceEntryArr) {
            this.f2429a = fontFileResourceEntryArr;
        }

        public FontFileResourceEntry[] getEntries() {
            return this.f2429a;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/content/res/FontResourcesParserCompat$FontFileResourceEntry.class */
    public static final class FontFileResourceEntry {

        /* renamed from: a  reason: collision with root package name */
        private final String f2430a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f2431c;
        private String d;
        private int e;
        private int f;

        public FontFileResourceEntry(String str, int i, boolean z, String str2, int i2, int i3) {
            this.f2430a = str;
            this.b = i;
            this.f2431c = z;
            this.d = str2;
            this.e = i2;
            this.f = i3;
        }

        public String getFileName() {
            return this.f2430a;
        }

        public int getResourceId() {
            return this.f;
        }

        public int getTtcIndex() {
            return this.e;
        }

        public String getVariationSettings() {
            return this.d;
        }

        public int getWeight() {
            return this.b;
        }

        public boolean isItalic() {
            return this.f2431c;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/content/res/FontResourcesParserCompat$ProviderResourceEntry.class */
    public static final class ProviderResourceEntry implements FamilyResourceEntry {

        /* renamed from: a  reason: collision with root package name */
        private final FontRequest f2432a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2433c;
        private final String d;

        public ProviderResourceEntry(FontRequest fontRequest, int i, int i2) {
            this(fontRequest, i, i2, null);
        }

        public ProviderResourceEntry(FontRequest fontRequest, int i, int i2, String str) {
            this.f2432a = fontRequest;
            this.f2433c = i;
            this.b = i2;
            this.d = str;
        }

        public int getFetchStrategy() {
            return this.f2433c;
        }

        public FontRequest getRequest() {
            return this.f2432a;
        }

        public String getSystemFontFamilyName() {
            return this.d;
        }

        public int getTimeout() {
            return this.b;
        }
    }

    private FontResourcesParserCompat() {
    }

    private static FamilyResourceEntry a(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return b(xmlPullParser, resources);
        }
        a(xmlPullParser);
        return null;
    }

    private static List<byte[]> a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return arrayList;
            }
            arrayList.add(Base64.decode(strArr[i2], 0));
            i = i2 + 1;
        }
    }

    private static void a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    private static FamilyResourceEntry b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamily);
        String string = obtainAttributes.getString(R.styleable.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, 500);
        String string4 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderSystemFontFamily);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                a(xmlPullParser);
            }
            return new ProviderResourceEntry(new FontRequest(string, string2, string3, readCerts(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals(SobotCustomTagHandler.HTML_FONT)) {
                    arrayList.add(c(xmlPullParser, resources));
                } else {
                    a(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new FontFamilyFilesResourceEntry((FontFileResourceEntry[]) arrayList.toArray(new FontFileResourceEntry[arrayList.size()]));
    }

    private static FontFileResourceEntry c(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamilyFont);
        int i = obtainAttributes.getInt(obtainAttributes.hasValue(R.styleable.FontFamilyFont_fontWeight) ? R.styleable.FontFamilyFont_fontWeight : R.styleable.FontFamilyFont_android_fontWeight, 400);
        boolean z = 1 == obtainAttributes.getInt(obtainAttributes.hasValue(R.styleable.FontFamilyFont_fontStyle) ? R.styleable.FontFamilyFont_fontStyle : R.styleable.FontFamilyFont_android_fontStyle, 0);
        int i2 = obtainAttributes.hasValue(R.styleable.FontFamilyFont_ttcIndex) ? R.styleable.FontFamilyFont_ttcIndex : R.styleable.FontFamilyFont_android_ttcIndex;
        String string = obtainAttributes.getString(obtainAttributes.hasValue(R.styleable.FontFamilyFont_fontVariationSettings) ? R.styleable.FontFamilyFont_fontVariationSettings : R.styleable.FontFamilyFont_android_fontVariationSettings);
        int i3 = obtainAttributes.getInt(i2, 0);
        int i4 = obtainAttributes.hasValue(R.styleable.FontFamilyFont_font) ? R.styleable.FontFamilyFont_font : R.styleable.FontFamilyFont_android_font;
        int resourceId = obtainAttributes.getResourceId(i4, 0);
        String string2 = obtainAttributes.getString(i4);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            a(xmlPullParser);
        }
        return new FontFileResourceEntry(string2, i, z, string, i3, resourceId);
    }

    private static int getType(TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(i);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        return typedValue.type;
    }

    public static FamilyResourceEntry parse(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return a(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> readCerts(Resources resources, int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (getType(obtainTypedArray, 0) == 1) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= obtainTypedArray.length()) {
                        break;
                    }
                    int resourceId = obtainTypedArray.getResourceId(i3, 0);
                    if (resourceId != 0) {
                        arrayList.add(a(resources.getStringArray(resourceId)));
                    }
                    i2 = i3 + 1;
                }
            } else {
                arrayList.add(a(resources.getStringArray(i)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }
}

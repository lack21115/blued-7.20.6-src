package android.graphics;

import android.content.res.AssetManager;
import android.graphics.FontListParser;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.anythink.expressad.exoplayer.b;
import com.blued.das.live.LiveProtos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/Typeface.class */
public class Typeface {
    public static final int BOLD = 1;
    public static final int BOLD_ITALIC = 3;
    public static final Typeface DEFAULT = null;
    public static final Typeface DEFAULT_BOLD = null;
    private static Typeface DEFAULT_BOLD_INTERNAL;
    private static Typeface DEFAULT_INTERNAL;
    static final String FONTS_CONFIG = "fonts.xml";
    public static final int ITALIC = 2;
    public static final Typeface MONOSPACE = null;
    private static Typeface MONOSPACE_INTERNAL;
    public static final int NORMAL = 0;
    public static final Typeface SANS_SERIF = null;
    static final String SANS_SERIF_FAMILY_NAME = "sans-serif";
    private static Typeface SANS_SERIF_INTERNAL;
    public static final Typeface SERIF = null;
    private static Typeface SERIF_INTERNAL;
    static Typeface sDefaultTypeface;
    static Typeface[] sDefaults;
    static FontFamily[] sFallbackFonts;
    static Map<String, Typeface> sSystemFontMap;
    private int mStyle;
    public long native_instance;
    private static String TAG = "Typeface";
    private static final LongSparseArray<SparseArray<Typeface>> sTypefaceCache = new LongSparseArray<>(3);

    static {
        init(false);
        DEFAULT_INTERNAL = create((String) null, 0);
        DEFAULT_BOLD_INTERNAL = create((String) null, 1);
        SANS_SERIF_INTERNAL = create("sans-serif", 0);
        SERIF_INTERNAL = create(b.l, 0);
        MONOSPACE_INTERNAL = create("monospace", 0);
        Typeface typeface = DEFAULT_INTERNAL;
        throw new VerifyError("bad dex opcode");
    }

    private Typeface(long j) {
        this.mStyle = 0;
        if (j == 0) {
            throw new RuntimeException("native typeface cannot be made");
        }
        this.native_instance = j;
        this.mStyle = nativeGetStyle(j);
    }

    private static void addFallbackFontsForFamilyName(FontListParser.Config config, FontListParser.Config config2, String str) {
        for (FontListParser.Family family : config.families) {
            if (str.equals(family.name)) {
                family.name = null;
                config2.families.add(family);
                return;
            }
        }
    }

    private static void addMissingFontAliases(FontListParser.Config config, FontListParser.Config config2) {
        boolean z;
        int size = config2.aliases.size();
        for (FontListParser.Alias alias : config.aliases) {
            int i = 0;
            while (true) {
                int i2 = i;
                z = true;
                if (i2 >= size) {
                    break;
                }
                z = true;
                if (1 == 0) {
                    break;
                }
                String str = config2.aliases.get(i2).name;
                if (str != null && str.equals(alias.name)) {
                    z = false;
                    break;
                }
                i = i2 + 1;
            }
            if (z) {
                config2.aliases.add(alias);
            }
        }
    }

    private static void addMissingFontFamilies(FontListParser.Config config, FontListParser.Config config2) {
        boolean z;
        int size = config2.families.size();
        for (FontListParser.Family family : config.families) {
            int i = 0;
            while (true) {
                int i2 = i;
                z = true;
                if (i2 >= size) {
                    break;
                }
                z = true;
                if (1 == 0) {
                    break;
                }
                String str = config2.families.get(i2).name;
                if (str != null && str.equals(family.name)) {
                    z = false;
                    break;
                }
                i = i2 + 1;
            }
            if (z) {
                config2.families.add(family);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0043, code lost:
        if (r0 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
        if (r7 > 3) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Typeface create(android.graphics.Typeface r6, int r7) {
        /*
            r0 = r7
            if (r0 < 0) goto Lb
            r0 = r7
            r8 = r0
            r0 = r7
            r1 = 3
            if (r0 <= r1) goto Ld
        Lb:
            r0 = 0
            r8 = r0
        Ld:
            r0 = 0
            r9 = r0
            r0 = r6
            if (r0 == 0) goto L22
            r0 = r6
            int r0 = r0.mStyle
            r1 = r8
            if (r0 != r1) goto L1d
        L1b:
            r0 = r6
            return r0
        L1d:
            r0 = r6
            long r0 = r0.native_instance
            r9 = r0
        L22:
            android.util.LongSparseArray<android.util.SparseArray<android.graphics.Typeface>> r0 = android.graphics.Typeface.sTypefaceCache
            r1 = r9
            java.lang.Object r0 = r0.get(r1)
            android.util.SparseArray r0 = (android.util.SparseArray) r0
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L46
            r0 = r11
            r1 = r8
            java.lang.Object r0 = r0.get(r1)
            android.graphics.Typeface r0 = (android.graphics.Typeface) r0
            r12 = r0
            r0 = r12
            r6 = r0
            r0 = r12
            if (r0 != 0) goto L1b
        L46:
            android.graphics.Typeface r0 = new android.graphics.Typeface
            r1 = r0
            r2 = r9
            r3 = r8
            long r2 = nativeCreateFromTypeface(r2, r3)
            r1.<init>(r2)
            r12 = r0
            r0 = r11
            r6 = r0
            r0 = r11
            if (r0 != 0) goto L6d
            android.util.SparseArray r0 = new android.util.SparseArray
            r1 = r0
            r2 = 4
            r1.<init>(r2)
            r6 = r0
            android.util.LongSparseArray<android.util.SparseArray<android.graphics.Typeface>> r0 = android.graphics.Typeface.sTypefaceCache
            r1 = r9
            r2 = r6
            r0.put(r1, r2)
        L6d:
            r0 = r6
            r1 = r8
            r2 = r12
            r0.put(r1, r2)
            r0 = r12
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.graphics.Typeface.create(android.graphics.Typeface, int):android.graphics.Typeface");
    }

    public static Typeface create(String str, int i) {
        if (sSystemFontMap != null) {
            return create(sSystemFontMap.get(str), i);
        }
        return null;
    }

    public static Typeface createFromAsset(AssetManager assetManager, String str) {
        if (sFallbackFonts != null) {
            FontFamily fontFamily = new FontFamily();
            if (fontFamily.addFontFromAsset(assetManager, str)) {
                return createFromFamiliesWithDefault(new FontFamily[]{fontFamily});
            }
        }
        throw new RuntimeException("Font asset not found " + str);
    }

    public static Typeface createFromFamilies(FontFamily[] fontFamilyArr) {
        long[] jArr = new long[fontFamilyArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= fontFamilyArr.length) {
                return new Typeface(nativeCreateFromArray(jArr));
            }
            jArr[i2] = fontFamilyArr[i2].mNativePtr;
            i = i2 + 1;
        }
    }

    public static Typeface createFromFamiliesWithDefault(FontFamily[] fontFamilyArr) {
        long[] jArr = new long[fontFamilyArr.length + sFallbackFonts.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= fontFamilyArr.length) {
                break;
            }
            jArr[i2] = fontFamilyArr[i2].mNativePtr;
            i = i2 + 1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= sFallbackFonts.length) {
                return new Typeface(nativeCreateFromArray(jArr));
            }
            jArr[fontFamilyArr.length + i4] = sFallbackFonts[i4].mNativePtr;
            i3 = i4 + 1;
        }
    }

    public static Typeface createFromFile(File file) {
        return createFromFile(file.getAbsolutePath());
    }

    public static Typeface createFromFile(String str) {
        if (sFallbackFonts != null) {
            FontFamily fontFamily = new FontFamily();
            if (fontFamily.addFont(str)) {
                return createFromFamiliesWithDefault(new FontFamily[]{fontFamily});
            }
        }
        throw new RuntimeException("Font not found " + str);
    }

    public static Typeface defaultFromStyle(int i) {
        return sDefaults[i];
    }

    private static File getSystemFontConfigLocation() {
        return new File("/system/etc/");
    }

    private static File getSystemFontDirLocation() {
        return new File("/system/fonts/");
    }

    private static File getThemeFontConfigLocation() {
        return new File("/data/system/theme/fonts/");
    }

    private static File getThemeFontDirLocation() {
        return new File("/data/system/theme/fonts/");
    }

    private static void init(boolean z) {
        File file;
        File systemFontDirLocation;
        File systemFontConfigLocation = getSystemFontConfigLocation();
        File themeFontConfigLocation = getThemeFontConfigLocation();
        File file2 = new File(systemFontConfigLocation, "fonts.xml");
        File file3 = new File(themeFontConfigLocation, "fonts.xml");
        if (z || !file3.exists()) {
            file = file2;
            systemFontDirLocation = getSystemFontDirLocation();
        } else {
            file = file3;
            systemFontDirLocation = getThemeFontDirLocation();
        }
        try {
            FontListParser.Config parse = FontListParser.parse(file, systemFontDirLocation.getAbsolutePath());
            if (file == file3) {
                FontListParser.Config parse2 = FontListParser.parse(file2, getSystemFontDirLocation().getAbsolutePath());
                addFallbackFontsForFamilyName(parse2, parse, "sans-serif");
                addMissingFontFamilies(parse2, parse);
                addMissingFontAliases(parse2, parse);
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= parse.families.size()) {
                    break;
                }
                FontListParser.Family family = parse.families.get(i2);
                if (i2 == 0 || family.name == null) {
                    arrayList.add(makeFamilyFromParsed(family));
                }
                i = i2 + 1;
            }
            sFallbackFonts = (FontFamily[]) arrayList.toArray(new FontFamily[arrayList.size()]);
            setDefault(createFromFamilies(sFallbackFonts));
            HashMap hashMap = new HashMap();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= parse.families.size()) {
                    break;
                }
                FontListParser.Family family2 = parse.families.get(i4);
                if (family2.name != null) {
                    hashMap.put(family2.name, i4 == 0 ? sDefaultTypeface : createFromFamiliesWithDefault(new FontFamily[]{makeFamilyFromParsed(family2)}));
                }
                i3 = i4 + 1;
            }
            for (FontListParser.Alias alias : parse.aliases) {
                Typeface typeface = (Typeface) hashMap.get(alias.toName);
                Typeface typeface2 = typeface;
                int i5 = alias.weight;
                if (i5 != 400) {
                    typeface2 = new Typeface(nativeCreateWeightAlias(typeface.native_instance, i5));
                }
                hashMap.put(alias.name, typeface2);
            }
            sSystemFontMap = hashMap;
        } catch (FileNotFoundException e) {
            Log.e(TAG, "Error opening " + file, e);
        } catch (IOException e2) {
            Log.e(TAG, "Error reading " + file, e2);
        } catch (RuntimeException e3) {
            Log.w(TAG, "Didn't create default family (most likely, non-Minikin build)", e3);
        } catch (XmlPullParserException e4) {
            Log.e(TAG, "XML parse exception for " + file, e4);
        }
    }

    private static FontFamily makeFamilyFromParsed(FontListParser.Family family) {
        FontFamily fontFamily = new FontFamily(family.lang, family.variant);
        for (FontListParser.Font font : family.fonts) {
            fontFamily.addFontWeightStyle(font.fontName, font.weight, font.isItalic);
        }
        return fontFamily;
    }

    private static native long nativeCreateFromArray(long[] jArr);

    private static native long nativeCreateFromTypeface(long j, int i);

    private static native long nativeCreateWeightAlias(long j, int i);

    private static native int nativeGetStyle(long j);

    private static native void nativeSetDefault(long j);

    private static native void nativeUnref(long j);

    public static void recreateDefaults() {
        recreateDefaults(false);
    }

    public static void recreateDefaults(boolean z) {
        sTypefaceCache.clear();
        sSystemFontMap.clear();
        init(z);
        DEFAULT_INTERNAL = create((String) null, 0);
        DEFAULT_BOLD_INTERNAL = create((String) null, 1);
        SANS_SERIF_INTERNAL = create("sans-serif", 0);
        SERIF_INTERNAL = create(b.l, 0);
        MONOSPACE_INTERNAL = create("monospace", 0);
        DEFAULT.native_instance = DEFAULT_INTERNAL.native_instance;
        DEFAULT_BOLD.native_instance = DEFAULT_BOLD_INTERNAL.native_instance;
        SANS_SERIF.native_instance = SANS_SERIF_INTERNAL.native_instance;
        SERIF.native_instance = SERIF_INTERNAL.native_instance;
        MONOSPACE.native_instance = MONOSPACE_INTERNAL.native_instance;
        sDefaults[2] = create((String) null, 2);
        sDefaults[3] = create((String) null, 3);
    }

    private static void setDefault(Typeface typeface) {
        sDefaultTypeface = typeface;
        nativeSetDefault(typeface.native_instance);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Typeface typeface = (Typeface) obj;
        return this.mStyle == typeface.mStyle && this.native_instance == typeface.native_instance;
    }

    protected void finalize() throws Throwable {
        try {
            nativeUnref(this.native_instance);
        } finally {
            super.finalize();
        }
    }

    public int getStyle() {
        return this.mStyle;
    }

    public int hashCode() {
        return ((((int) (this.native_instance ^ (this.native_instance >>> 32))) + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + this.mStyle;
    }

    public final boolean isBold() {
        return (this.mStyle & 1) != 0;
    }

    public final boolean isItalic() {
        return (this.mStyle & 2) != 0;
    }
}

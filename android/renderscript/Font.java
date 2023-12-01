package android.renderscript;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Environment;
import com.anythink.expressad.exoplayer.b;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/renderscript/Font.class */
public class Font extends BaseObj {
    private static Map<String, FontFamily> sFontFamilyMap;
    private static final String[] sSansNames = {b.m, "arial", "helvetica", "tahoma", "verdana"};
    private static final String[] sSerifNames = {b.l, "times", "times new roman", "palatino", "georgia", "baskerville", "goudy", "fantasy", "cursive", "ITC Stone Serif"};
    private static final String[] sMonoNames = {"monospace", "courier", "courier new", "monaco"};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.renderscript.Font$1  reason: invalid class name */
    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/Font$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$renderscript$Font$Style = new int[Style.values().length];

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0038 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003c -> B:21:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0040 -> B:19:0x0014). Please submit an issue!!! */
        static {
            try {
                $SwitchMap$android$renderscript$Font$Style[Style.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$renderscript$Font$Style[Style.BOLD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$renderscript$Font$Style[Style.ITALIC.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$renderscript$Font$Style[Style.BOLD_ITALIC.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/Font$FontFamily.class */
    public static class FontFamily {
        String mBoldFileName;
        String mBoldItalicFileName;
        String mItalicFileName;
        String[] mNames;
        String mNormalFileName;

        private FontFamily() {
        }

        /* synthetic */ FontFamily(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/Font$Style.class */
    public enum Style {
        NORMAL,
        BOLD,
        ITALIC,
        BOLD_ITALIC
    }

    static {
        initFontFamilyMap();
    }

    Font(long j, RenderScript renderScript) {
        super(j, renderScript);
    }

    private static void addFamilyToMap(FontFamily fontFamily) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= fontFamily.mNames.length) {
                return;
            }
            sFontFamilyMap.put(fontFamily.mNames[i2], fontFamily);
            i = i2 + 1;
        }
    }

    public static Font create(RenderScript renderScript, Resources resources, String str, Style style, float f) {
        return createFromFile(renderScript, resources, Environment.getRootDirectory().getAbsolutePath() + "/fonts/" + getFontFileName(str, style), f);
    }

    public static Font createFromAsset(RenderScript renderScript, Resources resources, String str, float f) {
        renderScript.validate();
        long nFontCreateFromAsset = renderScript.nFontCreateFromAsset(resources.getAssets(), str, f, resources.getDisplayMetrics().densityDpi);
        if (nFontCreateFromAsset == 0) {
            throw new RSRuntimeException("Unable to create font from asset " + str);
        }
        return new Font(nFontCreateFromAsset, renderScript);
    }

    public static Font createFromFile(RenderScript renderScript, Resources resources, File file, float f) {
        return createFromFile(renderScript, resources, file.getAbsolutePath(), f);
    }

    public static Font createFromFile(RenderScript renderScript, Resources resources, String str, float f) {
        renderScript.validate();
        long nFontCreateFromFile = renderScript.nFontCreateFromFile(str, f, resources.getDisplayMetrics().densityDpi);
        if (nFontCreateFromFile == 0) {
            throw new RSRuntimeException("Unable to create font from file " + str);
        }
        return new Font(nFontCreateFromFile, renderScript);
    }

    public static Font createFromResource(RenderScript renderScript, Resources resources, int i, float f) {
        String str = "R." + Integer.toString(i);
        renderScript.validate();
        try {
            InputStream openRawResource = resources.openRawResource(i);
            int i2 = resources.getDisplayMetrics().densityDpi;
            if (openRawResource instanceof AssetManager.AssetInputStream) {
                long nFontCreateFromAssetStream = renderScript.nFontCreateFromAssetStream(str, f, i2, ((AssetManager.AssetInputStream) openRawResource).getNativeAsset());
                if (nFontCreateFromAssetStream == 0) {
                    throw new RSRuntimeException("Unable to create font from resource " + i);
                }
                return new Font(nFontCreateFromAssetStream, renderScript);
            }
            throw new RSRuntimeException("Unsupported asset stream created");
        } catch (Exception e) {
            throw new RSRuntimeException("Unable to open resource " + i);
        }
    }

    static String getFontFileName(String str, Style style) {
        FontFamily fontFamily = sFontFamilyMap.get(str);
        if (fontFamily != null) {
            switch (AnonymousClass1.$SwitchMap$android$renderscript$Font$Style[style.ordinal()]) {
                case 1:
                    return fontFamily.mNormalFileName;
                case 2:
                    return fontFamily.mBoldFileName;
                case 3:
                    return fontFamily.mItalicFileName;
                case 4:
                    return fontFamily.mBoldItalicFileName;
                default:
                    return "DroidSans.ttf";
            }
        }
        return "DroidSans.ttf";
    }

    private static void initFontFamilyMap() {
        sFontFamilyMap = new HashMap();
        FontFamily fontFamily = new FontFamily(null);
        fontFamily.mNames = sSansNames;
        fontFamily.mNormalFileName = "Roboto-Regular.ttf";
        fontFamily.mBoldFileName = "Roboto-Bold.ttf";
        fontFamily.mItalicFileName = "Roboto-Italic.ttf";
        fontFamily.mBoldItalicFileName = "Roboto-BoldItalic.ttf";
        addFamilyToMap(fontFamily);
        FontFamily fontFamily2 = new FontFamily(null);
        fontFamily2.mNames = sSerifNames;
        fontFamily2.mNormalFileName = "NotoSerif-Regular.ttf";
        fontFamily2.mBoldFileName = "NotoSerif-Bold.ttf";
        fontFamily2.mItalicFileName = "NotoSerif-Italic.ttf";
        fontFamily2.mBoldItalicFileName = "NotoSerif-BoldItalic.ttf";
        addFamilyToMap(fontFamily2);
        FontFamily fontFamily3 = new FontFamily(null);
        fontFamily3.mNames = sMonoNames;
        fontFamily3.mNormalFileName = "DroidSansMono.ttf";
        fontFamily3.mBoldFileName = "DroidSansMono.ttf";
        fontFamily3.mItalicFileName = "DroidSansMono.ttf";
        fontFamily3.mBoldItalicFileName = "DroidSansMono.ttf";
        addFamilyToMap(fontFamily3);
    }
}

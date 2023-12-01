package io.github.inflationx.calligraphy3;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Log;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/calligraphy3/TypefaceUtils.class */
public final class TypefaceUtils {
    private static final Map<String, Typeface> sCachedFonts = new HashMap();
    private static final Map<Typeface, CalligraphyTypefaceSpan> sCachedSpans = new HashMap();

    private TypefaceUtils() {
    }

    public static CalligraphyTypefaceSpan getSpan(Typeface typeface) {
        if (typeface == null) {
            return null;
        }
        synchronized (sCachedSpans) {
            if (sCachedSpans.containsKey(typeface)) {
                return sCachedSpans.get(typeface);
            }
            CalligraphyTypefaceSpan calligraphyTypefaceSpan = new CalligraphyTypefaceSpan(typeface);
            sCachedSpans.put(typeface, calligraphyTypefaceSpan);
            return calligraphyTypefaceSpan;
        }
    }

    public static boolean isLoaded(Typeface typeface) {
        return typeface != null && sCachedFonts.containsValue(typeface);
    }

    public static Typeface load(AssetManager assetManager, String str) {
        synchronized (sCachedFonts) {
            try {
                if (sCachedFonts.containsKey(str)) {
                    return sCachedFonts.get(str);
                }
                Typeface createFromFile = str.startsWith(BridgeUtil.SPLIT_MARK) ? Typeface.createFromFile(str) : Typeface.createFromAsset(assetManager, str);
                sCachedFonts.put(str, createFromFile);
                return createFromFile;
            } catch (Exception e) {
                Log.w("Calligraphy", "Can't create asset from " + str + ". Make sure you have passed in the correct path and file name.", e);
                sCachedFonts.put(str, null);
                return null;
            }
        }
    }
}

package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.provider.FontsContractCompat;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/graphics/TypefaceCompat.class */
public class TypefaceCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final TypefaceCompatBaseImpl f2408a;
    private static final LruCache<String, Typeface> b;

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/graphics/TypefaceCompat$ResourcesCallbackAdapter.class */
    public static class ResourcesCallbackAdapter extends FontsContractCompat.FontRequestCallback {

        /* renamed from: a  reason: collision with root package name */
        private ResourcesCompat.FontCallback f2409a;

        public ResourcesCallbackAdapter(ResourcesCompat.FontCallback fontCallback) {
            this.f2409a = fontCallback;
        }

        @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
        public void onTypefaceRequestFailed(int i) {
            ResourcesCompat.FontCallback fontCallback = this.f2409a;
            if (fontCallback != null) {
                fontCallback.onFontRetrievalFailed(i);
            }
        }

        @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
        public void onTypefaceRetrieved(Typeface typeface) {
            ResourcesCompat.FontCallback fontCallback = this.f2409a;
            if (fontCallback != null) {
                fontCallback.onFontRetrieved(typeface);
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f2408a = new TypefaceCompatApi29Impl();
        } else if (Build.VERSION.SDK_INT >= 28) {
            f2408a = new TypefaceCompatApi28Impl();
        } else if (Build.VERSION.SDK_INT >= 26) {
            f2408a = new TypefaceCompatApi26Impl();
        } else if (Build.VERSION.SDK_INT >= 24 && TypefaceCompatApi24Impl.isUsable()) {
            f2408a = new TypefaceCompatApi24Impl();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f2408a = new TypefaceCompatApi21Impl();
        } else {
            f2408a = new TypefaceCompatBaseImpl();
        }
        b = new LruCache<>(16);
    }

    private TypefaceCompat() {
    }

    private static Typeface a(Context context, Typeface typeface, int i) {
        FontResourcesParserCompat.FontFamilyFilesResourceEntry a2 = f2408a.a(typeface);
        if (a2 == null) {
            return null;
        }
        return f2408a.createFromFontFamilyFilesResourceEntry(context, a2, context.getResources(), i);
    }

    private static Typeface a(String str) {
        Typeface typeface = null;
        if (str != null) {
            if (str.isEmpty()) {
                return null;
            }
            Typeface create = Typeface.create(str, 0);
            Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
            typeface = null;
            if (create != null) {
                typeface = null;
                if (!create.equals(create2)) {
                    typeface = create;
                }
            }
        }
        return typeface;
    }

    private static String a(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i2;
    }

    public static void clearCache() {
        b.evictAll();
    }

    public static Typeface create(Context context, Typeface typeface, int i) {
        Typeface a2;
        if (context != null) {
            return (Build.VERSION.SDK_INT >= 21 || (a2 = a(context, typeface, i)) == null) ? Typeface.create(typeface, i) : a2;
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        return f2408a.createFromFontInfo(context, cancellationSignal, fontInfoArr, i);
    }

    public static Typeface createFromResourcesFamilyXml(Context context, FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry, Resources resources, int i, int i2, ResourcesCompat.FontCallback fontCallback, Handler handler, boolean z) {
        Typeface typeface;
        if (familyResourceEntry instanceof FontResourcesParserCompat.ProviderResourceEntry) {
            FontResourcesParserCompat.ProviderResourceEntry providerResourceEntry = (FontResourcesParserCompat.ProviderResourceEntry) familyResourceEntry;
            Typeface a2 = a(providerResourceEntry.getSystemFontFamilyName());
            if (a2 != null) {
                if (fontCallback != null) {
                    fontCallback.callbackSuccessAsync(a2, handler);
                }
                return a2;
            }
            typeface = FontsContractCompat.requestFont(context, providerResourceEntry.getRequest(), i2, !z ? fontCallback != null : providerResourceEntry.getFetchStrategy() != 0, z ? providerResourceEntry.getTimeout() : -1, ResourcesCompat.FontCallback.getHandler(handler), new ResourcesCallbackAdapter(fontCallback));
        } else {
            Typeface createFromFontFamilyFilesResourceEntry = f2408a.createFromFontFamilyFilesResourceEntry(context, (FontResourcesParserCompat.FontFamilyFilesResourceEntry) familyResourceEntry, resources, i2);
            typeface = createFromFontFamilyFilesResourceEntry;
            if (fontCallback != null) {
                if (createFromFontFamilyFilesResourceEntry != null) {
                    fontCallback.callbackSuccessAsync(createFromFontFamilyFilesResourceEntry, handler);
                    typeface = createFromFontFamilyFilesResourceEntry;
                } else {
                    fontCallback.callbackFailAsync(-3, handler);
                    typeface = createFromFontFamilyFilesResourceEntry;
                }
            }
        }
        if (typeface != null) {
            b.put(a(resources, i, i2), typeface);
        }
        return typeface;
    }

    public static Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        Typeface createFromResourcesFontFile = f2408a.createFromResourcesFontFile(context, resources, i, str, i2);
        if (createFromResourcesFontFile != null) {
            b.put(a(resources, i, i2), createFromResourcesFontFile);
        }
        return createFromResourcesFontFile;
    }

    public static Typeface findFromCache(Resources resources, int i, int i2) {
        return b.get(a(resources, i, i2));
    }
}

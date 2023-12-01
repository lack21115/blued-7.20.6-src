package com.airbnb.lottie.manager;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.model.MutablePair;
import com.airbnb.lottie.utils.Logger;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/manager/FontAssetManager.class */
public class FontAssetManager {
    private final AssetManager d;
    private FontAssetDelegate e;
    private final MutablePair<String> a = new MutablePair<>();
    private final Map<MutablePair<String>, Typeface> b = new HashMap();
    private final Map<String, Typeface> c = new HashMap();
    private String f = ".ttf";

    public FontAssetManager(Drawable.Callback callback, FontAssetDelegate fontAssetDelegate) {
        this.e = fontAssetDelegate;
        if (callback instanceof View) {
            this.d = ((View) callback).getContext().getAssets();
            return;
        }
        Logger.b("LottieDrawable must be inside of a view for images to work.");
        this.d = null;
    }

    private Typeface a(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i = (contains && contains2) ? 3 : contains ? 2 : contains2 ? 1 : 0;
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }

    private Typeface a(String str) {
        Typeface typeface = this.c.get(str);
        if (typeface != null) {
            return typeface;
        }
        Typeface typeface2 = null;
        FontAssetDelegate fontAssetDelegate = this.e;
        if (fontAssetDelegate != null) {
            typeface2 = fontAssetDelegate.a(str);
        }
        FontAssetDelegate fontAssetDelegate2 = this.e;
        Typeface typeface3 = typeface2;
        if (fontAssetDelegate2 != null) {
            typeface3 = typeface2;
            if (typeface2 == null) {
                String b = fontAssetDelegate2.b(str);
                typeface3 = typeface2;
                if (b != null) {
                    typeface3 = Typeface.createFromAsset(this.d, b);
                }
            }
        }
        Typeface typeface4 = typeface3;
        if (typeface3 == null) {
            typeface4 = Typeface.createFromAsset(this.d, "fonts/" + str + this.f);
        }
        this.c.put(str, typeface4);
        return typeface4;
    }

    public Typeface a(String str, String str2) {
        this.a.a(str, str2);
        Typeface typeface = this.b.get(this.a);
        if (typeface != null) {
            return typeface;
        }
        Typeface a = a(a(str), str2);
        this.b.put(this.a, a);
        return a;
    }

    public void a(FontAssetDelegate fontAssetDelegate) {
        this.e = fontAssetDelegate;
    }
}

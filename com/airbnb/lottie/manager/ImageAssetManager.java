package com.airbnb.lottie.manager;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.utils.Logger;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/manager/ImageAssetManager.class */
public class ImageAssetManager {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f4311a = new Object();
    private final Context b;

    /* renamed from: c  reason: collision with root package name */
    private String f4312c;
    private ImageAssetDelegate d;
    private final Map<String, LottieImageAsset> e;

    public ImageAssetManager(Drawable.Callback callback, String str, ImageAssetDelegate imageAssetDelegate, Map<String, LottieImageAsset> map) {
        this.f4312c = str;
        if (!TextUtils.isEmpty(str)) {
            String str2 = this.f4312c;
            if (str2.charAt(str2.length() - 1) != '/') {
                this.f4312c += '/';
            }
        }
        if (callback instanceof View) {
            this.b = ((View) callback).getContext();
            this.e = map;
            a(imageAssetDelegate);
            return;
        }
        Logger.b("LottieDrawable must be inside of a view for images to work.");
        this.e = new HashMap();
        this.b = null;
    }

    private Bitmap a(String str, Bitmap bitmap) {
        synchronized (f4311a) {
            this.e.get(str).a(bitmap);
        }
        return bitmap;
    }

    public Bitmap a(String str) {
        LottieImageAsset lottieImageAsset = this.e.get(str);
        if (lottieImageAsset == null) {
            return null;
        }
        Bitmap c2 = lottieImageAsset.c();
        if (c2 != null) {
            return c2;
        }
        ImageAssetDelegate imageAssetDelegate = this.d;
        if (imageAssetDelegate != null) {
            Bitmap a2 = imageAssetDelegate.a(lottieImageAsset);
            if (a2 != null) {
                a(str, a2);
            }
            return a2;
        }
        String b = lottieImageAsset.b();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (b.startsWith("data:") && b.indexOf("base64,") > 0) {
            try {
                byte[] decode = Base64.decode(b.substring(b.indexOf(44) + 1), 0);
                return a(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (IllegalArgumentException e) {
                Logger.a("data URL did not have correct base64 format.", e);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.f4312c)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            AssetManager assets = this.b.getAssets();
            return a(str, BitmapFactory.decodeStream(assets.open(this.f4312c + b), null, options));
        } catch (IOException e2) {
            Logger.a("Unable to open asset.", e2);
            return null;
        }
    }

    public void a(ImageAssetDelegate imageAssetDelegate) {
        this.d = imageAssetDelegate;
    }

    public boolean a(Context context) {
        return (context == null && this.b == null) || this.b.equals(context);
    }
}

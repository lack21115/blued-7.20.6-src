package com.bumptech.glide.load.resource.drawable;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/drawable/ResourceDrawableDecoder.class */
public class ResourceDrawableDecoder implements ResourceDecoder<Uri, Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f20986a;

    public ResourceDrawableDecoder(Context context) {
        this.f20986a = context.getApplicationContext();
    }

    private int a(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return b(context, uri);
        }
        if (pathSegments.size() == 1) {
            return a(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    private int a(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e);
        }
    }

    private Context a(Uri uri, String str) {
        if (str.equals(this.f20986a.getPackageName())) {
            return this.f20986a;
        }
        try {
            return this.f20986a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            if (str.contains(this.f20986a.getPackageName())) {
                return this.f20986a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e);
        }
    }

    private int b(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        int i = identifier;
        if (identifier == 0) {
            i = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (i != 0) {
            return i;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Drawable> a(Uri uri, int i, int i2, Options options) {
        Context a2 = a(uri, uri.getAuthority());
        return NonOwnedDrawableResource.a(DrawableDecoderCompat.a(this.f20986a, a2, a(a2, uri)));
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean a(Uri uri, Options options) {
        return uri.getScheme().equals(ContentResolver.SCHEME_ANDROID_RESOURCE);
    }
}

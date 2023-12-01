package com.bumptech.glide.request;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/RequestOptions.class */
public class RequestOptions extends BaseRequestOptions<RequestOptions> {

    /* renamed from: a  reason: collision with root package name */
    private static RequestOptions f7441a;
    private static RequestOptions b;

    public static RequestOptions c(Key key) {
        return new RequestOptions().b(key);
    }

    public static RequestOptions c(Transformation<Bitmap> transformation) {
        return new RequestOptions().b(transformation);
    }

    public static RequestOptions c(DiskCacheStrategy diskCacheStrategy) {
        return new RequestOptions().b(diskCacheStrategy);
    }

    public static RequestOptions c(Class<?> cls) {
        return new RequestOptions().b(cls);
    }

    public static RequestOptions g(boolean z) {
        if (z) {
            if (f7441a == null) {
                f7441a = new RequestOptions().d(true).h();
            }
            return f7441a;
        }
        if (b == null) {
            b = new RequestOptions().d(false).h();
        }
        return b;
    }
}

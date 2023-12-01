package com.bumptech.glide.load.resource;

import android.content.Context;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/UnitTransformation.class */
public final class UnitTransformation<T> implements Transformation<T> {
    private static final Transformation<?> b = new UnitTransformation();

    private UnitTransformation() {
    }

    public static <T> UnitTransformation<T> a() {
        return (UnitTransformation) b;
    }

    @Override // com.bumptech.glide.load.Transformation
    public Resource<T> a(Context context, Resource<T> resource, int i, int i2) {
        return resource;
    }

    @Override // com.bumptech.glide.load.Key
    public void a(MessageDigest messageDigest) {
    }
}

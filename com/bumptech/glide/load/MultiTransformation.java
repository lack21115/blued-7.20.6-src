package com.bumptech.glide.load;

import android.content.Context;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/MultiTransformation.class */
public class MultiTransformation<T> implements Transformation<T> {
    private final Collection<? extends Transformation<T>> b;

    @SafeVarargs
    public MultiTransformation(Transformation<T>... transformationArr) {
        if (transformationArr.length == 0) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.b = Arrays.asList(transformationArr);
    }

    @Override // com.bumptech.glide.load.Transformation
    public Resource<T> a(Context context, Resource<T> resource, int i, int i2) {
        Iterator<? extends Transformation<T>> it = this.b.iterator();
        Resource<T> resource2 = resource;
        while (true) {
            Resource<T> resource3 = resource2;
            if (!it.hasNext()) {
                return resource3;
            }
            Resource<T> a2 = it.next().a(context, resource3, i, i2);
            if (resource3 != null && !resource3.equals(resource) && !resource3.equals(a2)) {
                resource3.c();
            }
            resource2 = a2;
        }
    }

    @Override // com.bumptech.glide.load.Key
    public void a(MessageDigest messageDigest) {
        for (Transformation<T> transformation : this.b) {
            transformation.a(messageDigest);
        }
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof MultiTransformation) {
            return this.b.equals(((MultiTransformation) obj).b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.b.hashCode();
    }
}

package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.ViewTarget;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/GlideContext.class */
public class GlideContext extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    static final TransitionOptions<?, ?> f20651a = new GenericTransitionOptions();
    private final ArrayPool b;

    /* renamed from: c  reason: collision with root package name */
    private final Registry f20652c;
    private final ImageViewTargetFactory d;
    private final Glide.RequestOptionsFactory e;
    private final List<RequestListener<Object>> f;
    private final Map<Class<?>, TransitionOptions<?, ?>> g;
    private final Engine h;
    private final boolean i;
    private final int j;
    private RequestOptions k;

    public GlideContext(Context context, ArrayPool arrayPool, Registry registry, ImageViewTargetFactory imageViewTargetFactory, Glide.RequestOptionsFactory requestOptionsFactory, Map<Class<?>, TransitionOptions<?, ?>> map, List<RequestListener<Object>> list, Engine engine, boolean z, int i) {
        super(context.getApplicationContext());
        this.b = arrayPool;
        this.f20652c = registry;
        this.d = imageViewTargetFactory;
        this.e = requestOptionsFactory;
        this.f = list;
        this.g = map;
        this.h = engine;
        this.i = z;
        this.j = i;
    }

    public <T> TransitionOptions<?, T> a(Class<T> cls) {
        TransitionOptions<?, ?> transitionOptions = this.g.get(cls);
        TransitionOptions<?, ?> transitionOptions2 = transitionOptions;
        if (transitionOptions == null) {
            Iterator<Map.Entry<Class<?>, TransitionOptions<?, ?>>> it = this.g.entrySet().iterator();
            while (true) {
                transitionOptions2 = transitionOptions;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, TransitionOptions<?, ?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    transitionOptions = next.getValue();
                }
            }
        }
        TransitionOptions<?, ?> transitionOptions3 = transitionOptions2;
        if (transitionOptions2 == null) {
            transitionOptions3 = f20651a;
        }
        return (TransitionOptions<?, T>) transitionOptions3;
    }

    public <X> ViewTarget<ImageView, X> a(ImageView imageView, Class<X> cls) {
        return this.d.a(imageView, cls);
    }

    public List<RequestListener<Object>> a() {
        return this.f;
    }

    public RequestOptions b() {
        RequestOptions requestOptions;
        synchronized (this) {
            if (this.k == null) {
                this.k = this.e.a().i();
            }
            requestOptions = this.k;
        }
        return requestOptions;
    }

    public Engine c() {
        return this.h;
    }

    public Registry d() {
        return this.f20652c;
    }

    public int e() {
        return this.j;
    }

    public ArrayPool f() {
        return this.b;
    }

    public boolean g() {
        return this.i;
    }
}

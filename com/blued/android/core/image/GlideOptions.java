package com.blued.android.core.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/GlideOptions.class */
public final class GlideOptions extends RequestOptions implements Cloneable {
    /* renamed from: a */
    public GlideOptions n() {
        return super.n();
    }

    /* renamed from: a */
    public GlideOptions b(float f) {
        return super.b(f);
    }

    /* renamed from: a */
    public GlideOptions h(int i) {
        return super.h(i);
    }

    /* renamed from: a */
    public GlideOptions b(int i, int i2) {
        return super.b(i, i2);
    }

    /* renamed from: a */
    public GlideOptions b(Drawable drawable) {
        return super.b(drawable);
    }

    /* renamed from: a */
    public GlideOptions b(Priority priority) {
        return super.b(priority);
    }

    /* renamed from: a */
    public GlideOptions b(Key key) {
        return super.b(key);
    }

    public <Y> GlideOptions a(Option<Y> option, Y y) {
        return super.b(option, y);
    }

    /* renamed from: a */
    public GlideOptions b(Transformation<Bitmap> transformation) {
        return super.b(transformation);
    }

    /* renamed from: a */
    public GlideOptions b(DiskCacheStrategy diskCacheStrategy) {
        return super.b(diskCacheStrategy);
    }

    /* renamed from: a */
    public GlideOptions b(DownsampleStrategy downsampleStrategy) {
        return super.b(downsampleStrategy);
    }

    /* renamed from: a */
    public GlideOptions b(BaseRequestOptions<?> baseRequestOptions) {
        return super.b(baseRequestOptions);
    }

    /* renamed from: a */
    public GlideOptions b(Class<?> cls) {
        return super.b(cls);
    }

    /* renamed from: a */
    public GlideOptions f(boolean z) {
        return super.f(z);
    }

    @SafeVarargs
    /* renamed from: a */
    public final GlideOptions b(Transformation<Bitmap>... transformationArr) {
        return super.b(transformationArr);
    }

    /* renamed from: b */
    public GlideOptions m() {
        return super.m();
    }

    /* renamed from: b */
    public GlideOptions g(int i) {
        return super.g(i);
    }

    /* renamed from: b */
    public GlideOptions e(boolean z) {
        return super.e(z);
    }

    public /* synthetic */ BaseRequestOptions b(Option option, Object obj) {
        return a((Option<Option>) option, (Option) obj);
    }

    /* renamed from: c */
    public GlideOptions l() {
        return super.l();
    }

    /* renamed from: c */
    public GlideOptions f(int i) {
        return super.f(i);
    }

    /* renamed from: c */
    public GlideOptions d(boolean z) {
        return super.d(z);
    }

    /* renamed from: d */
    public GlideOptions k() {
        return super.k();
    }

    /* renamed from: d */
    public GlideOptions e(int i) {
        return super.e(i);
    }

    /* renamed from: e */
    public GlideOptions j() {
        return super.j();
    }

    /* renamed from: f */
    public GlideOptions i() {
        return super.i();
    }

    /* renamed from: g */
    public GlideOptions h() {
        return super.h();
    }
}

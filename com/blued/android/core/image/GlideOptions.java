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
    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: a */
    public GlideOptions n() {
        return (GlideOptions) super.clone();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: a */
    public GlideOptions b(float f) {
        return (GlideOptions) super.b(f);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: a */
    public GlideOptions h(int i) {
        return (GlideOptions) super.h(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: a */
    public GlideOptions b(int i, int i2) {
        return (GlideOptions) super.b(i, i2);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: a */
    public GlideOptions b(Drawable drawable) {
        return (GlideOptions) super.b(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: a */
    public GlideOptions b(Priority priority) {
        return (GlideOptions) super.b(priority);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: a */
    public GlideOptions b(Key key) {
        return (GlideOptions) super.b(key);
    }

    public <Y> GlideOptions a(Option<Y> option, Y y) {
        return (GlideOptions) super.b((Option<Option<Y>>) option, (Option<Y>) y);
    }

    public GlideOptions a(Transformation<Bitmap> transformation) {
        return (GlideOptions) super.b(transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: a */
    public GlideOptions b(DiskCacheStrategy diskCacheStrategy) {
        return (GlideOptions) super.b(diskCacheStrategy);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: a */
    public GlideOptions b(DownsampleStrategy downsampleStrategy) {
        return (GlideOptions) super.b(downsampleStrategy);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: a */
    public GlideOptions b(BaseRequestOptions<?> baseRequestOptions) {
        return (GlideOptions) super.b(baseRequestOptions);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: a */
    public GlideOptions b(Class<?> cls) {
        return (GlideOptions) super.b(cls);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: a */
    public GlideOptions f(boolean z) {
        return (GlideOptions) super.f(z);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @SafeVarargs
    /* renamed from: a */
    public final GlideOptions b(Transformation<Bitmap>... transformationArr) {
        return (GlideOptions) super.b(transformationArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: b */
    public GlideOptions m() {
        return (GlideOptions) super.m();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: b */
    public GlideOptions g(int i) {
        return (GlideOptions) super.g(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: b */
    public GlideOptions e(boolean z) {
        return (GlideOptions) super.e(z);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* synthetic */ RequestOptions b(Option option, Object obj) {
        return a((Option<Option>) option, (Option) obj);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* synthetic */ RequestOptions b(Transformation transformation) {
        return a((Transformation<Bitmap>) transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: c */
    public GlideOptions l() {
        return (GlideOptions) super.l();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: c */
    public GlideOptions f(int i) {
        return (GlideOptions) super.f(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: c */
    public GlideOptions d(boolean z) {
        return (GlideOptions) super.d(z);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: d */
    public GlideOptions k() {
        return (GlideOptions) super.k();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: d */
    public GlideOptions e(int i) {
        return (GlideOptions) super.e(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: e */
    public GlideOptions j() {
        return (GlideOptions) super.j();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: f */
    public GlideOptions i() {
        return (GlideOptions) super.i();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: g */
    public GlideOptions h() {
        return (GlideOptions) super.h();
    }
}

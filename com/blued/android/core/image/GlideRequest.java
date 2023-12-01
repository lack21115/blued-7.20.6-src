package com.blued.android.core.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import java.io.File;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/GlideRequest.class */
public class GlideRequest<TranscodeType> extends RequestBuilder<TranscodeType> implements Cloneable {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GlideRequest(Glide glide, RequestManager requestManager, Class<TranscodeType> cls, Context context) {
        super(glide, requestManager, cls, context);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: a */
    public GlideRequest<TranscodeType> m() {
        return (GlideRequest) super.m();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: a */
    public GlideRequest<TranscodeType> b(float f) {
        return (GlideRequest) super.b(f);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: a */
    public GlideRequest<TranscodeType> h(int i) {
        return (GlideRequest) super.h(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: a */
    public GlideRequest<TranscodeType> b(int i, int i2) {
        return (GlideRequest) super.b(i, i2);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: a */
    public GlideRequest<TranscodeType> b(Drawable drawable) {
        return (GlideRequest) super.b(drawable);
    }

    @Override // com.bumptech.glide.RequestBuilder
    /* renamed from: a */
    public GlideRequest<TranscodeType> b(Uri uri) {
        return (GlideRequest) super.b(uri);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: a */
    public GlideRequest<TranscodeType> b(Priority priority) {
        return (GlideRequest) super.b(priority);
    }

    @Override // com.bumptech.glide.RequestBuilder
    /* renamed from: a */
    public GlideRequest<TranscodeType> b(RequestBuilder<TranscodeType> requestBuilder) {
        return (GlideRequest) super.b((RequestBuilder) requestBuilder);
    }

    @Override // com.bumptech.glide.RequestBuilder
    /* renamed from: a */
    public GlideRequest<TranscodeType> b(TransitionOptions<?, ? super TranscodeType> transitionOptions) {
        return (GlideRequest) super.b((TransitionOptions) transitionOptions);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: a */
    public GlideRequest<TranscodeType> b(Key key) {
        return (GlideRequest) super.b(key);
    }

    public <Y> GlideRequest<TranscodeType> a(Option<Y> option, Y y) {
        return (GlideRequest) super.b((Option<Option<Y>>) option, (Option<Y>) y);
    }

    public GlideRequest<TranscodeType> a(Transformation<Bitmap> transformation) {
        return (GlideRequest) super.b(transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: a */
    public GlideRequest<TranscodeType> b(DiskCacheStrategy diskCacheStrategy) {
        return (GlideRequest) super.b(diskCacheStrategy);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: a */
    public GlideRequest<TranscodeType> b(DownsampleStrategy downsampleStrategy) {
        return (GlideRequest) super.b(downsampleStrategy);
    }

    public GlideRequest<TranscodeType> a(BaseRequestOptions<?> baseRequestOptions) {
        return (GlideRequest) super.b(baseRequestOptions);
    }

    @Override // com.bumptech.glide.RequestBuilder
    /* renamed from: a */
    public GlideRequest<TranscodeType> d(RequestListener<TranscodeType> requestListener) {
        return (GlideRequest) super.d(requestListener);
    }

    @Override // com.bumptech.glide.RequestBuilder
    /* renamed from: a */
    public GlideRequest<TranscodeType> b(File file) {
        return (GlideRequest) super.b(file);
    }

    public GlideRequest<TranscodeType> a(Class<?> cls) {
        return (GlideRequest) super.b(cls);
    }

    @Override // com.bumptech.glide.RequestBuilder
    /* renamed from: a */
    public GlideRequest<TranscodeType> b(Integer num) {
        return (GlideRequest) super.b(num);
    }

    @Override // com.bumptech.glide.RequestBuilder
    /* renamed from: a */
    public GlideRequest<TranscodeType> b(Object obj) {
        return (GlideRequest) super.b(obj);
    }

    @Override // com.bumptech.glide.RequestBuilder
    /* renamed from: a */
    public GlideRequest<TranscodeType> b(String str) {
        return (GlideRequest) super.b(str);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: a */
    public GlideRequest<TranscodeType> f(boolean z) {
        return (GlideRequest) super.f(z);
    }

    public GlideRequest<TranscodeType> a(Transformation<Bitmap>... transformationArr) {
        return (GlideRequest) super.b(transformationArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: b */
    public GlideRequest<TranscodeType> l() {
        return (GlideRequest) super.l();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: b */
    public GlideRequest<TranscodeType> g(int i) {
        return (GlideRequest) super.g(i);
    }

    @Override // com.bumptech.glide.RequestBuilder
    /* renamed from: b */
    public GlideRequest<TranscodeType> c(RequestListener<TranscodeType> requestListener) {
        return (GlideRequest) super.c(requestListener);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: b */
    public GlideRequest<TranscodeType> e(boolean z) {
        return (GlideRequest) super.e(z);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* synthetic */ BaseRequestOptions b(Option option, Object obj) {
        return a((Option<Option>) option, (Option) obj);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* synthetic */ BaseRequestOptions b(Transformation transformation) {
        return a((Transformation<Bitmap>) transformation);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.request.BaseRequestOptions
    public /* synthetic */ BaseRequestOptions b(BaseRequestOptions baseRequestOptions) {
        return a((BaseRequestOptions<?>) baseRequestOptions);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* synthetic */ BaseRequestOptions b(Class cls) {
        return a((Class<?>) cls);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* synthetic */ BaseRequestOptions b(Transformation[] transformationArr) {
        return a((Transformation<Bitmap>[]) transformationArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: c */
    public GlideRequest<TranscodeType> k() {
        return (GlideRequest) super.k();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: c */
    public GlideRequest<TranscodeType> f(int i) {
        return (GlideRequest) super.f(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: c */
    public GlideRequest<TranscodeType> d(boolean z) {
        return (GlideRequest) super.d(z);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public /* synthetic */ RequestBuilder c(BaseRequestOptions baseRequestOptions) {
        return a((BaseRequestOptions<?>) baseRequestOptions);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: d */
    public GlideRequest<TranscodeType> j() {
        return (GlideRequest) super.j();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: d */
    public GlideRequest<TranscodeType> e(int i) {
        return (GlideRequest) super.e(i);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: e */
    public GlideRequest<TranscodeType> n() {
        return (GlideRequest) super.n();
    }
}

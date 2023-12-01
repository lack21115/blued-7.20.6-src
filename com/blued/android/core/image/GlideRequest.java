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

    /* renamed from: a */
    public GlideRequest<TranscodeType> m() {
        return super.m();
    }

    /* renamed from: a */
    public GlideRequest<TranscodeType> b(float f) {
        return super.b(f);
    }

    /* renamed from: a */
    public GlideRequest<TranscodeType> h(int i) {
        return super.h(i);
    }

    /* renamed from: a */
    public GlideRequest<TranscodeType> b(int i, int i2) {
        return super.b(i, i2);
    }

    /* renamed from: a */
    public GlideRequest<TranscodeType> b(Drawable drawable) {
        return super.b(drawable);
    }

    /* renamed from: a */
    public GlideRequest<TranscodeType> b(Uri uri) {
        return (GlideRequest) super.b(uri);
    }

    /* renamed from: a */
    public GlideRequest<TranscodeType> b(Priority priority) {
        return super.b(priority);
    }

    /* renamed from: a */
    public GlideRequest<TranscodeType> b(RequestBuilder<TranscodeType> requestBuilder) {
        return (GlideRequest) super.b(requestBuilder);
    }

    /* renamed from: a */
    public GlideRequest<TranscodeType> b(TransitionOptions<?, ? super TranscodeType> transitionOptions) {
        return (GlideRequest) super.b(transitionOptions);
    }

    /* renamed from: a */
    public GlideRequest<TranscodeType> b(Key key) {
        return super.b(key);
    }

    public <Y> GlideRequest<TranscodeType> a(Option<Y> option, Y y) {
        return super.b(option, y);
    }

    public GlideRequest<TranscodeType> a(Transformation<Bitmap> transformation) {
        return super.b(transformation);
    }

    /* renamed from: a */
    public GlideRequest<TranscodeType> b(DiskCacheStrategy diskCacheStrategy) {
        return super.b(diskCacheStrategy);
    }

    /* renamed from: a */
    public GlideRequest<TranscodeType> b(DownsampleStrategy downsampleStrategy) {
        return super.b(downsampleStrategy);
    }

    public GlideRequest<TranscodeType> a(BaseRequestOptions<?> baseRequestOptions) {
        return (GlideRequest) super.c(baseRequestOptions);
    }

    /* renamed from: a */
    public GlideRequest<TranscodeType> d(RequestListener<TranscodeType> requestListener) {
        return (GlideRequest) super.d(requestListener);
    }

    /* renamed from: a */
    public GlideRequest<TranscodeType> b(File file) {
        return (GlideRequest) super.b(file);
    }

    public GlideRequest<TranscodeType> a(Class<?> cls) {
        return super.b(cls);
    }

    /* renamed from: a */
    public GlideRequest<TranscodeType> b(Integer num) {
        return (GlideRequest) super.b(num);
    }

    /* renamed from: a */
    public GlideRequest<TranscodeType> b(Object obj) {
        return (GlideRequest) super.b(obj);
    }

    /* renamed from: a */
    public GlideRequest<TranscodeType> b(String str) {
        return (GlideRequest) super.b(str);
    }

    /* renamed from: a */
    public GlideRequest<TranscodeType> f(boolean z) {
        return super.f(z);
    }

    public GlideRequest<TranscodeType> a(Transformation<Bitmap>... transformationArr) {
        return super.b(transformationArr);
    }

    /* renamed from: b */
    public GlideRequest<TranscodeType> l() {
        return super.l();
    }

    /* renamed from: b */
    public GlideRequest<TranscodeType> g(int i) {
        return super.g(i);
    }

    /* renamed from: b */
    public GlideRequest<TranscodeType> c(RequestListener<TranscodeType> requestListener) {
        return (GlideRequest) super.c(requestListener);
    }

    /* renamed from: b */
    public GlideRequest<TranscodeType> e(boolean z) {
        return super.e(z);
    }

    public /* synthetic */ BaseRequestOptions b(Option option, Object obj) {
        return a((Option<Option>) option, (Option) obj);
    }

    public /* synthetic */ BaseRequestOptions b(Transformation transformation) {
        return a((Transformation<Bitmap>) transformation);
    }

    public /* synthetic */ BaseRequestOptions b(BaseRequestOptions baseRequestOptions) {
        return a((BaseRequestOptions<?>) baseRequestOptions);
    }

    public /* synthetic */ BaseRequestOptions b(Class cls) {
        return a((Class<?>) cls);
    }

    public /* synthetic */ BaseRequestOptions b(Transformation[] transformationArr) {
        return a((Transformation<Bitmap>[]) transformationArr);
    }

    /* renamed from: c */
    public GlideRequest<TranscodeType> k() {
        return super.k();
    }

    /* renamed from: c */
    public GlideRequest<TranscodeType> f(int i) {
        return super.f(i);
    }

    /* renamed from: c */
    public GlideRequest<TranscodeType> d(boolean z) {
        return super.d(z);
    }

    public /* synthetic */ RequestBuilder c(BaseRequestOptions baseRequestOptions) {
        return a((BaseRequestOptions<?>) baseRequestOptions);
    }

    /* renamed from: d */
    public GlideRequest<TranscodeType> j() {
        return super.j();
    }

    /* renamed from: d */
    public GlideRequest<TranscodeType> e(int i) {
        return super.e(i);
    }

    /* renamed from: e */
    public GlideRequest<TranscodeType> n() {
        return (GlideRequest) super.f();
    }
}

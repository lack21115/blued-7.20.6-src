package com.blued.android.core.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.request.RequestOptions;
import java.io.File;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/GlideRequests.class */
public class GlideRequests extends RequestManager {
    public GlideRequests(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
        super(glide, lifecycle, requestManagerTreeNode, context);
    }

    @Override // com.bumptech.glide.RequestManager
    /* renamed from: a */
    public GlideRequest<Bitmap> f() {
        return (GlideRequest) super.f();
    }

    @Override // com.bumptech.glide.RequestManager
    /* renamed from: a */
    public <ResourceType> GlideRequest<ResourceType> b(Class<ResourceType> cls) {
        return new GlideRequest<>(this.f20667a, this, cls, this.b);
    }

    @Override // com.bumptech.glide.RequestManager
    /* renamed from: a */
    public GlideRequest<Drawable> b(Integer num) {
        return (GlideRequest) super.b(num);
    }

    @Override // com.bumptech.glide.RequestManager
    /* renamed from: a */
    public GlideRequest<Drawable> b(String str) {
        return (GlideRequest) super.b(str);
    }

    @Override // com.bumptech.glide.RequestManager
    public void a(RequestOptions requestOptions) {
        if (requestOptions instanceof GlideOptions) {
            super.a(requestOptions);
        } else {
            super.a(new GlideOptions().b(requestOptions));
        }
    }

    @Override // com.bumptech.glide.RequestManager
    /* renamed from: b */
    public GlideRequest<Drawable> e() {
        return (GlideRequest) super.e();
    }

    @Override // com.bumptech.glide.RequestManager
    /* renamed from: c */
    public GlideRequest<File> d() {
        return (GlideRequest) super.d();
    }
}

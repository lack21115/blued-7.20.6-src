package com.blued.android.core.imagecache.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.blued.android.core.imagecache.ImageLoadingListener;
import com.blued.android.core.imagecache.LoadJob;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.imagecache.RecyclingImageLoader;
import com.blued.android.core.imagecache.RecyclingMultiImageLoader;
import com.blued.blued_core.R;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/view/AutoAttachRecyclingImageView.class */
public class AutoAttachRecyclingImageView extends RecyclingImageView {

    /* renamed from: a  reason: collision with root package name */
    boolean f9657a;
    String[] b;

    /* renamed from: c  reason: collision with root package name */
    String f9658c;
    LoadOptions d;
    ImageLoadingListener e;
    LoadJob f;
    int g;

    public AutoAttachRecyclingImageView(Context context) {
        super(context);
        this.f9657a = false;
        this.g = 0;
    }

    public AutoAttachRecyclingImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoAttachRecyclingImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9657a = false;
        this.g = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AutoRecyclingImageView, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.AutoRecyclingImageView_recycling_src, 0);
        if (resourceId > 0) {
            setImageResource(resourceId);
        }
        obtainStyledAttributes.recycle();
    }

    public static LoadJob a(String str, LoadOptions loadOptions, ImageLoadingListener imageLoadingListener) {
        return RecyclingImageLoader.a(null, str, loadOptions, imageLoadingListener);
    }

    private void b(String[] strArr, LoadOptions loadOptions, ImageLoadingListener imageLoadingListener) {
        this.f9657a = false;
        this.f9658c = null;
        this.b = strArr;
        this.d = loadOptions;
        this.e = imageLoadingListener;
    }

    private void c(String str, LoadOptions loadOptions, ImageLoadingListener imageLoadingListener) {
        this.f9657a = false;
        this.f9658c = str;
        this.b = null;
        this.d = loadOptions;
        this.e = imageLoadingListener;
    }

    public LoadJob a(String[] strArr, LoadOptions loadOptions, ImageLoadingListener imageLoadingListener) {
        b(strArr, loadOptions, imageLoadingListener);
        LoadJob loadJob = this.f;
        if (loadJob != null) {
            loadJob.a();
            this.f = null;
        }
        RecyclingMultiImageLoader.a(this, strArr, loadOptions, imageLoadingListener);
        return null;
    }

    public void a() {
        int i;
        LoadJob loadJob = this.f;
        if (loadJob != null) {
            loadJob.a();
            this.f = null;
        }
        if (!TextUtils.isEmpty(this.f9658c)) {
            this.f = b(this.f9658c, this.d, this.e);
            return;
        }
        String[] strArr = this.b;
        if (strArr != null) {
            this.f = a(strArr, this.d, this.e);
        } else if (!LoadOptions.f9592a || (i = this.g) <= 0) {
        } else {
            setImageResource(i);
        }
    }

    public LoadJob b(String str, LoadOptions loadOptions, ImageLoadingListener imageLoadingListener) {
        c(str, loadOptions, imageLoadingListener);
        LoadJob loadJob = this.f;
        if (loadJob != null) {
            loadJob.a();
            this.f = null;
        }
        LoadJob a2 = RecyclingImageLoader.a(this, str, loadOptions, imageLoadingListener);
        this.f = a2;
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f9657a) {
            a();
            this.f9657a = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.core.imagecache.view.RecyclingImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f9657a = true;
        LoadJob loadJob = this.f;
        if (loadJob != null) {
            loadJob.a();
            this.f = null;
        }
    }

    @Override // com.blued.android.core.imagecache.view.RecyclingImageView, android.widget.ImageView
    public void setImageResource(int i) {
        this.g = i;
        super.setImageResource(i);
    }
}

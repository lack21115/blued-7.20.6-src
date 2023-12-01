package com.bumptech.glide.util;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.transition.Transition;
import java.util.Arrays;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/util/ViewPreloadSizeProvider.class */
public class ViewPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T>, SizeReadyCallback {

    /* renamed from: a  reason: collision with root package name */
    private int[] f21111a;
    private SizeViewTarget b;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/util/ViewPreloadSizeProvider$SizeViewTarget.class */
    static final class SizeViewTarget extends CustomViewTarget<View, Object> {
        @Override // com.bumptech.glide.request.target.CustomViewTarget
        public void a(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(Object obj, Transition<? super Object> transition) {
        }
    }

    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public void a(int i, int i2) {
        this.f21111a = new int[]{i, i2};
        this.b = null;
    }

    @Override // com.bumptech.glide.ListPreloader.PreloadSizeProvider
    public int[] a(T t, int i, int i2) {
        int[] iArr = this.f21111a;
        if (iArr == null) {
            return null;
        }
        return Arrays.copyOf(iArr, iArr.length);
    }
}

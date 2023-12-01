package com.blued.android.core.imagecache;

import com.blued.android.core.AppInfo;
import com.blued.android.core.imagecache.view.RecyclingImageView;
import com.blued.android.core.utils.Log;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/BaseImageLoadingListener.class */
public class BaseImageLoadingListener implements PreProcessImageLoadingListener {
    @Override // com.blued.android.core.imagecache.ImageLoadingListener
    public void a(int i, int i2) {
    }

    @Override // com.blued.android.core.imagecache.ImageLoadingListener
    public void a(String str, RecyclingImageView recyclingImageView, LoadOptions loadOptions) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        if ((r0 instanceof android.graphics.drawable.LayerDrawable) != false) goto L21;
     */
    @Override // com.blued.android.core.imagecache.ImageLoadingListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r9, com.blued.android.core.imagecache.view.RecyclingImageView r10, com.blued.android.core.imagecache.LoadOptions r11, android.graphics.drawable.Drawable r12, boolean r13) {
        /*
            r8 = this;
            r0 = r10
            if (r0 == 0) goto L7b
            r0 = r10
            android.graphics.drawable.Drawable r0 = r0.getDrawable()
            r14 = r0
            r0 = r12
            r1 = r14
            if (r0 == r1) goto L7b
            r0 = r11
            boolean r0 = r0.l
            if (r0 == 0) goto L75
            r0 = r13
            if (r0 != 0) goto L75
            r0 = r11
            boolean r0 = r0.k
            if (r0 != 0) goto L75
            r0 = r14
            if (r0 == 0) goto L34
            r0 = r14
            r9 = r0
            r0 = r14
            boolean r0 = r0 instanceof android.graphics.drawable.LayerDrawable
            if (r0 == 0) goto L47
        L34:
            android.graphics.drawable.ColorDrawable r0 = new android.graphics.drawable.ColorDrawable
            r1 = r0
            android.content.Context r2 = com.blued.android.core.AppInfo.d()
            android.content.res.Resources r2 = r2.getResources()
            r3 = 17170445(0x106000d, float:2.461195E-38)
            int r2 = r2.getColor(r3)
            r1.<init>(r2)
            r9 = r0
        L47:
            r0 = r10
            android.graphics.drawable.TransitionDrawable r1 = new android.graphics.drawable.TransitionDrawable
            r2 = r1
            r3 = 2
            android.graphics.drawable.Drawable[] r3 = new android.graphics.drawable.Drawable[r3]
            r4 = r3
            r5 = 0
            r6 = r9
            r4[r5] = r6
            r4 = r3
            r5 = 1
            r6 = r12
            r4[r5] = r6
            r2.<init>(r3)
            r0.setImageDrawable(r1)
            r0 = r10
            android.graphics.drawable.Drawable r0 = r0.getDrawable()
            r9 = r0
            r0 = r9
            boolean r0 = r0 instanceof android.graphics.drawable.TransitionDrawable
            if (r0 == 0) goto L7b
            r0 = r9
            android.graphics.drawable.TransitionDrawable r0 = (android.graphics.drawable.TransitionDrawable) r0
            r1 = 100
            r0.startTransition(r1)
            return
        L75:
            r0 = r10
            r1 = r12
            r0.setImageDrawable(r1)
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.core.imagecache.BaseImageLoadingListener.a(java.lang.String, com.blued.android.core.imagecache.view.RecyclingImageView, com.blued.android.core.imagecache.LoadOptions, android.graphics.drawable.Drawable, boolean):void");
    }

    @Override // com.blued.android.core.imagecache.ImageLoadingListener
    public void a(String str, RecyclingImageView recyclingImageView, LoadOptions loadOptions, FailReason failReason) {
        String str2 = FailReason.a(AppInfo.d(), failReason, true) + ", uri:" + str;
        if (ImageLoaderUtils.a) {
            Log.e("BaseImageLoading", str2);
        }
        if (recyclingImageView != null) {
            if (loadOptions.d <= 0) {
                if (loadOptions.d == 0) {
                    recyclingImageView.setImageDrawable(null);
                }
            } else if (loadOptions.e) {
                recyclingImageView.setImageResourceInner(loadOptions.d);
            } else {
                recyclingImageView.setImageResource(loadOptions.d);
            }
        }
    }

    @Override // com.blued.android.core.imagecache.ImageLoadingListener
    public boolean a() {
        return false;
    }

    @Override // com.blued.android.core.imagecache.ImageLoadingListener
    public void b(String str, RecyclingImageView recyclingImageView, LoadOptions loadOptions) {
    }
}

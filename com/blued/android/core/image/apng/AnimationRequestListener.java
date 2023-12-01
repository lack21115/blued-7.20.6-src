package com.blued.android.core.image.apng;

import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.apng.drawable.APNGDrawable;
import com.blued.android.core.utils.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/AnimationRequestListener.class */
public class AnimationRequestListener implements RequestListener {
    private int a;
    private ImageLoader.OnAnimationStateListener b;

    public AnimationRequestListener(int i, ImageLoader.OnAnimationStateListener onAnimationStateListener) {
        this.a = i;
        this.b = onAnimationStateListener;
    }

    public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z) {
        if (ImageLoader.a()) {
            Log.e("IMAGE", "animation : onLoadFailed");
            return false;
        }
        return false;
    }

    public boolean onResourceReady(Object obj, Object obj2, Target target, DataSource dataSource, boolean z) {
        if (ImageLoader.a()) {
            Log.e("IMAGE", "animation : onResourceReady");
        }
        if (obj != null) {
            if (obj instanceof APNGDrawable) {
                final APNGDrawable aPNGDrawable = (APNGDrawable) obj;
                aPNGDrawable.a(this.a);
                if (ImageLoader.a()) {
                    Log.e("IMAGE", "animation : APNG @" + aPNGDrawable);
                }
                if (this.b != null) {
                    if (ImageLoader.a()) {
                        Log.e("IMAGE", "apng : onAnimationStart @" + aPNGDrawable);
                    }
                    this.b.a();
                    aPNGDrawable.registerAnimationCallback(new Animatable2Compat.AnimationCallback() { // from class: com.blued.android.core.image.apng.AnimationRequestListener.1
                        public void onAnimationEnd(Drawable drawable) {
                            if (ImageLoader.a()) {
                                Log.e("IMAGE", "apng : onAnimationEnd @" + drawable);
                            }
                            aPNGDrawable.unregisterAnimationCallback(this);
                            if (AnimationRequestListener.this.b != null) {
                                AnimationRequestListener.this.b.b();
                            }
                        }

                        public void onAnimationStart(Drawable drawable) {
                        }
                    });
                    return false;
                }
                return false;
            } else if (obj instanceof GifDrawable) {
                final GifDrawable gifDrawable = (GifDrawable) obj;
                gifDrawable.a(this.a);
                if (ImageLoader.a()) {
                    Log.e("IMAGE", "animation : GIF @" + gifDrawable);
                }
                if (this.b != null) {
                    if (ImageLoader.a()) {
                        Log.e("IMAGE", "gif : onAnimationStart @" + gifDrawable);
                    }
                    this.b.a();
                    gifDrawable.registerAnimationCallback(new Animatable2Compat.AnimationCallback() { // from class: com.blued.android.core.image.apng.AnimationRequestListener.2
                        public void onAnimationEnd(Drawable drawable) {
                            if (ImageLoader.a()) {
                                Log.e("IMAGE", "gif : onAnimationEnd @" + drawable);
                            }
                            gifDrawable.unregisterAnimationCallback(this);
                            if (AnimationRequestListener.this.b != null) {
                                AnimationRequestListener.this.b.b();
                            }
                        }
                    });
                    return false;
                }
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}

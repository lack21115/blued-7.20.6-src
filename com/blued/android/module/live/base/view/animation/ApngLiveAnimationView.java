package com.blued.android.module.live.base.view.animation;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/animation/ApngLiveAnimationView.class */
public class ApngLiveAnimationView extends BaseLiveAnimationView {
    private String b;
    private Context c;
    private ImageView d;

    public ApngLiveAnimationView(Context context, String str, boolean z) {
        this.b = str;
        this.c = context;
        ImageView imageView = new ImageView(this.c);
        this.d = imageView;
        imageView.setScaleType(z ? ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_CENTER);
    }

    @Override // com.blued.android.module.live.base.view.animation.BaseLiveAnimationView
    public View a() {
        return this.d;
    }

    @Override // com.blued.android.module.live.base.view.animation.BaseLiveAnimationView
    public void a(IRequestHost iRequestHost) {
        Log.v("drb", "调用Apng播放接口 start()");
        ImageLoader.a(iRequestHost, this.b).f().a(new ImageLoader.OnAnimationStateListener() { // from class: com.blued.android.module.live.base.view.animation.ApngLiveAnimationView.1
            @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
            public void a() {
                Log.v("drb", "ApngLiveAnimationView onAnimationStart");
                if (ApngLiveAnimationView.this.a != null) {
                    ApngLiveAnimationView.this.a.a();
                }
            }

            @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
            public void b() {
                Log.v("drb", "ApngLiveAnimationView onAnimationEnd");
                if (ApngLiveAnimationView.this.a != null) {
                    ApngLiveAnimationView.this.a.b();
                }
            }
        }).a(this.d);
    }

    @Override // com.blued.android.module.live.base.view.animation.BaseLiveAnimationView
    public void a(String str) {
        this.b = str;
    }
}

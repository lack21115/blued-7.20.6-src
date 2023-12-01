package com.blued.android.module.live.base.view.animation;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live.base.view.animation.LiveAnimationViewFactory;
import com.blued.android.module.video_gift.AlphaVideoGiftView;
import com.blued.android.module.video_gift.FitViewHelper;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/animation/LiveMp4AnimationView.class */
public class LiveMp4AnimationView extends BaseLiveAnimationView {
    private String b;
    private Context c;
    private AlphaVideoGiftView d;

    public LiveMp4AnimationView(Context context, String str, LiveAnimationViewFactory.ScaleType scaleType) {
        this.b = str;
        this.c = context;
        this.d = new AlphaVideoGiftView(this.c, null);
        if (scaleType == LiveAnimationViewFactory.ScaleType.FIT_CENTER) {
            this.d.setScaleType(FitViewHelper.ScaleType.FIT_CENTER);
        } else if (scaleType == LiveAnimationViewFactory.ScaleType.FIT_BOTTOM) {
            this.d.setScaleType(FitViewHelper.ScaleType.FIT_WIDTH);
        } else {
            this.d.setScaleType(FitViewHelper.ScaleType.CENTER_CROP);
        }
    }

    @Override // com.blued.android.module.live.base.view.animation.BaseLiveAnimationView
    public View a() {
        return this.d;
    }

    @Override // com.blued.android.module.live.base.view.animation.BaseLiveAnimationView
    public void a(IRequestHost iRequestHost) {
        Log.v("drb", "调用mp4播放接口 start()");
        if (LiveDataManager.a().i()) {
            this.d.getMediaPlayer().setVolume(1.0f, 1.0f);
        } else {
            this.d.getMediaPlayer().setVolume(0.0f, 0.0f);
        }
        this.d.setOnVideoStateChangedListener(new AlphaVideoGiftView.OnVideoStateChangedListener() { // from class: com.blued.android.module.live.base.view.animation.LiveMp4AnimationView.1
            @Override // com.blued.android.module.video_gift.AlphaVideoGiftView.OnVideoStateChangedListener
            public void a() {
                Log.v("drb", "AlphaVideoGiftView onLoadingStarted");
                if (LiveMp4AnimationView.this.a != null) {
                    LiveMp4AnimationView.this.a.a();
                }
            }

            @Override // com.blued.android.module.video_gift.AlphaVideoGiftView.OnVideoStateChangedListener
            public void b() {
                Log.v("drb", "AlphaVideoGiftView onEnded");
                if (LiveMp4AnimationView.this.a != null) {
                    LiveMp4AnimationView.this.a.b();
                }
            }

            @Override // com.blued.android.module.video_gift.AlphaVideoGiftView.OnVideoStateChangedListener
            public void c() {
            }
        });
        if (TextUtils.isEmpty(this.b) || !this.b.contains("http")) {
            this.d.a(this.c, this.b);
        } else {
            this.d.a(this.c, iRequestHost, this.b);
        }
    }

    @Override // com.blued.android.module.live.base.view.animation.BaseLiveAnimationView
    public void a(String str) {
        this.b = str;
    }
}

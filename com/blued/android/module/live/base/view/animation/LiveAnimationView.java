package com.blued.android.module.live.base.view.animation;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live.base.view.animation.LiveAnimationViewFactory;
import java.util.Map;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/animation/LiveAnimationView.class */
public class LiveAnimationView extends FrameLayout {
    private Context a;
    private LiveAnimationViewFactory b;
    private LiveAnimationListener c;

    public LiveAnimationView(Context context) {
        this(context, null);
    }

    public LiveAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        removeView(view);
    }

    private void a(View view, LiveAnimationViewFactory.ScaleType scaleType) {
        removeAllViews();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (scaleType == LiveAnimationViewFactory.ScaleType.FIT_BOTTOM) {
            layoutParams.gravity = 80;
        } else {
            layoutParams.gravity = 17;
        }
        addView(view, layoutParams);
    }

    public void a(int i) {
        LiveAnimationViewFactory liveAnimationViewFactory = this.b;
        if (liveAnimationViewFactory != null) {
            liveAnimationViewFactory.a(i);
        }
    }

    public void a(IRequestHost iRequestHost, String str, String str2, String str3, String str4, LiveAnimationListener liveAnimationListener) {
        a(iRequestHost, str, str2, str3, str4, LiveAnimationViewFactory.ScaleType.FIT_CENTER, null, liveAnimationListener);
    }

    public void a(IRequestHost iRequestHost, String str, String str2, String str3, String str4, LiveAnimationViewFactory.ScaleType scaleType, LiveAnimationListener liveAnimationListener) {
        a(iRequestHost, str, str2, str3, str4, scaleType, null, liveAnimationListener);
    }

    public void a(IRequestHost iRequestHost, String str, String str2, String str3, String str4, LiveAnimationViewFactory.ScaleType scaleType, Map<String, Object> map, LiveAnimationListener liveAnimationListener) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str4) && TextUtils.isEmpty(str3)) {
            if (liveAnimationListener != null) {
                liveAnimationListener.b();
                return;
            }
            return;
        }
        this.c = liveAnimationListener;
        if (this.b == null) {
            this.b = new LiveAnimationViewFactory();
        }
        final BaseLiveAnimationView a = this.b.a(this.a, str, str2, str3, str4, scaleType);
        a.a(new LiveAnimationListener() { // from class: com.blued.android.module.live.base.view.animation.LiveAnimationView.1
            @Override // com.blued.android.module.live.base.view.animation.LiveAnimationListener
            public void a() {
                if (LiveAnimationView.this.c != null) {
                    LiveAnimationView.this.c.a();
                }
            }

            @Override // com.blued.android.module.live.base.view.animation.LiveAnimationListener
            public void b() {
                LiveAnimationView.this.a(a.a());
                if (LiveAnimationView.this.c != null) {
                    LiveAnimationView.this.c.b();
                }
            }
        });
        a(a.a(), scaleType);
        if ("luckybag".equals(str4) && (a instanceof LuckyBagView)) {
            if (map != null && map.containsKey("KEY_LUCKY_BAG_IMG_URL") && (map.get("KEY_LUCKY_BAG_IMG_URL") instanceof String)) {
                ((LuckyBagView) a).c((String) map.get("KEY_LUCKY_BAG_IMG_URL"));
            }
            if (map != null && map.containsKey("KEY_LUCKY_BAG_GIFT_IMG_URL") && (map.get("KEY_LUCKY_BAG_GIFT_IMG_URL") instanceof String)) {
                ((LuckyBagView) a).b((String) map.get("KEY_LUCKY_BAG_GIFT_IMG_URL"));
            }
        }
        a.a(iRequestHost);
    }
}

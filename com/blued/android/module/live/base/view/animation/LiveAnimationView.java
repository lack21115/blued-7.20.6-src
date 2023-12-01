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

    /* renamed from: a  reason: collision with root package name */
    private Context f11501a;
    private LiveAnimationViewFactory b;

    /* renamed from: c  reason: collision with root package name */
    private LiveAnimationListener f11502c;

    public LiveAnimationView(Context context) {
        this(context, null);
    }

    public LiveAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11501a = context;
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
        this.f11502c = liveAnimationListener;
        if (this.b == null) {
            this.b = new LiveAnimationViewFactory();
        }
        final BaseLiveAnimationView a2 = this.b.a(this.f11501a, str, str2, str3, str4, scaleType);
        a2.a(new LiveAnimationListener() { // from class: com.blued.android.module.live.base.view.animation.LiveAnimationView.1
            @Override // com.blued.android.module.live.base.view.animation.LiveAnimationListener
            public void a() {
                if (LiveAnimationView.this.f11502c != null) {
                    LiveAnimationView.this.f11502c.a();
                }
            }

            @Override // com.blued.android.module.live.base.view.animation.LiveAnimationListener
            public void b() {
                LiveAnimationView.this.a(a2.a());
                if (LiveAnimationView.this.f11502c != null) {
                    LiveAnimationView.this.f11502c.b();
                }
            }
        });
        a(a2.a(), scaleType);
        if ("luckybag".equals(str4) && (a2 instanceof LuckyBagView)) {
            if (map != null && map.containsKey("KEY_LUCKY_BAG_IMG_URL") && (map.get("KEY_LUCKY_BAG_IMG_URL") instanceof String)) {
                ((LuckyBagView) a2).c((String) map.get("KEY_LUCKY_BAG_IMG_URL"));
            }
            if (map != null && map.containsKey("KEY_LUCKY_BAG_GIFT_IMG_URL") && (map.get("KEY_LUCKY_BAG_GIFT_IMG_URL") instanceof String)) {
                ((LuckyBagView) a2).b((String) map.get("KEY_LUCKY_BAG_GIFT_IMG_URL"));
            }
        }
        a2.a(iRequestHost);
    }
}

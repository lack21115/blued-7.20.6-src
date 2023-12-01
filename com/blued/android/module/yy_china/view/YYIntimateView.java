package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.module.live.base.view.animation.AnimationListenerAdapter;
import com.blued.android.module.live.base.view.animation.LiveAnimationView;
import com.blued.android.module.live.base.view.animation.LiveAnimationViewFactory;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYIntimateView.class */
public class YYIntimateView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private LiveAnimationView f18266a;

    public YYIntimateView(Context context) {
        super(context);
        a();
    }

    public YYIntimateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public YYIntimateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_intimate_layout, (ViewGroup) this, true);
        this.f18266a = (LiveAnimationView) findViewById(R.id.apng_animation_layout);
    }

    public void a(final BaseYYStudioFragment baseYYStudioFragment, final String str) {
        this.f18266a.postDelayed(new Runnable() { // from class: com.blued.android.module.yy_china.view.YYIntimateView.1
            @Override // java.lang.Runnable
            public void run() {
                YYIntimateView.this.f18266a.a(baseYYStudioFragment.getFragmentActive(), "", "", str, "", LiveAnimationViewFactory.ScaleType.FIT_BOTTOM, new AnimationListenerAdapter() { // from class: com.blued.android.module.yy_china.view.YYIntimateView.1.1
                    @Override // com.blued.android.module.live.base.view.animation.AnimationListenerAdapter, com.blued.android.module.live.base.view.animation.LiveAnimationListener
                    public void b() {
                        baseYYStudioFragment.y();
                    }
                });
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }
}

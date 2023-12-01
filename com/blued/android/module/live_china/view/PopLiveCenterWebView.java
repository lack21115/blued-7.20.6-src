package com.blued.android.module.live_china.view;

import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.web.BluedWebView;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.web.LiveWebCallBack;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopLiveCenterWebView.class */
public class PopLiveCenterWebView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public View f15078a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public View f15079c;
    public Context d;
    public LayoutInflater e;
    private boolean f;
    private Dialog g;
    private BluedWebView h;
    private ImageView i;

    /* renamed from: com.blued.android.module.live_china.view.PopLiveCenterWebView$4  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopLiveCenterWebView$4.class */
    class AnonymousClass4 extends LiveWebCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PopLiveCenterWebView f15083a;

        @Override // com.blued.android.module.live_china.web.LiveWebCallBack, com.blued.android.framework.web.BluedWebView.WebCallback
        public void b(BluedWebView bluedWebView, String str, boolean z) {
            this.f15083a.f = true;
            DialogUtils.b(this.f15083a.g);
        }
    }

    /* renamed from: com.blued.android.module.live_china.view.PopLiveCenterWebView$5  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopLiveCenterWebView$5.class */
    class AnonymousClass5 implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f15084a;
        final /* synthetic */ PopLiveCenterWebView b;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.b.h.a(this.f15084a);
            DialogUtils.a(this.b.g);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public PopLiveCenterWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PopLiveCenterWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = false;
        this.d = context;
        c();
    }

    private void c() {
        this.e = LayoutInflater.from(this.d);
        a();
        View findViewById = this.f15078a.findViewById(R.id.tv_bg);
        this.b = findViewById;
        findViewById.setBackgroundColor(this.d.getResources().getColor(R.color.transparent));
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopLiveCenterWebView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PopLiveCenterWebView.this.b();
            }
        });
        View findViewById2 = this.f15078a.findViewById(R.id.ll_content);
        this.f15079c = findViewById2;
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopLiveCenterWebView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        ImageView imageView = (ImageView) this.f15078a.findViewById(R.id.live_pk_center_explain_close);
        this.i = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopLiveCenterWebView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PopLiveCenterWebView.this.b();
            }
        });
        this.g = DialogUtils.a(this.d);
    }

    private void d() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.b.startAnimation(alphaAnimation);
        this.f15079c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_center_out));
    }

    public void a() {
        this.f15078a = this.e.inflate(R.layout.pop_live_pk_center, this);
    }

    public void b() {
        if (this.f15079c.getVisibility() == 8) {
            return;
        }
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.PopLiveCenterWebView.6
            @Override // java.lang.Runnable
            public void run() {
                PopLiveCenterWebView.this.setVisibility(8);
            }
        }, 320L);
        d();
        this.f15079c.setVisibility(8);
    }
}

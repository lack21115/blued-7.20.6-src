package com.soft.blued.ui.discover.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.module.common.utils.ImgURLMap;
import com.blued.android.module.common.view.CubicInterpolator;
import com.blued.community.track.EventTrackSuperExpose;
import com.blued.das.superexpose.SuperExposeProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.login_register.model.AppConfigModel;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/discover/view/FeedPromotionDlg.class */
public class FeedPromotionDlg extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private View f29851a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f29852c;
    private TextView d;
    private TextView e;
    private View f;
    private View g;
    private int h;
    private String i;
    private AppConfigModel.FeedPromotion j;

    public FeedPromotionDlg(Context context, int i, AppConfigModel.FeedPromotion feedPromotion) {
        super(context, i);
        this.h = 0;
        this.j = feedPromotion;
        a();
    }

    private void a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dlg_feed_promotion_layout, (ViewGroup) null);
        this.f29851a = inflate;
        this.b = inflate.findViewById(R.id.dlg_feed_promotion_mask);
        AppConfigModel.FeedPromotion feedPromotion = this.j;
        if (feedPromotion != null) {
            this.h = feedPromotion.type;
        }
        if (b()) {
            View findViewById = this.f29851a.findViewById(R.id.dlg_feed_promotion_content);
            this.f = findViewById;
            findViewById.setVisibility(0);
            View findViewById2 = this.f29851a.findViewById(R.id.dlg_feed_promotion_close);
            this.g = findViewById2;
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.discover.view.-$$Lambda$FeedPromotionDlg$eEHie-Ct5hjLLodtRV897LOwHjA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedPromotionDlg.this.d(view);
                }
            });
            this.e = (TextView) this.f29851a.findViewById(R.id.dlg_feed_promotion_buy);
            if (BluedConfig.a().k() != null) {
                if (!TextUtils.isEmpty(BluedConfig.a().k().btn)) {
                    this.e.setText(BluedConfig.a().k().btn);
                }
                if (!TextUtils.isEmpty(BluedConfig.a().k().img)) {
                    ImageLoader.a((IRequestHost) null, BluedConfig.a().k().img).f().a(this.f29852c);
                }
            }
            TextView textView = (TextView) this.f29851a.findViewById(R.id.dlg_feed_promotion_tv);
            this.d = textView;
            textView.setText(BluedConfig.a().k().text);
            this.e.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.discover.view.-$$Lambda$FeedPromotionDlg$jVtPi-uNmCgpfrBTBL7_5SzUzj0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedPromotionDlg.this.c(view);
                }
            });
        } else {
            View findViewById3 = this.f29851a.findViewById(R.id.cl_promotion_dialog);
            this.f = findViewById3;
            findViewById3.setVisibility(0);
            TextView textView2 = (TextView) this.f29851a.findViewById(R.id.tv_feed_promotion_title);
            TextView textView3 = (TextView) this.f29851a.findViewById(R.id.tv_feed_promotion_subtitle);
            TextView textView4 = (TextView) this.f29851a.findViewById(R.id.tv_promotion_item_title);
            TextView textView5 = (TextView) this.f29851a.findViewById(R.id.tv_promotion_item_subtitle);
            TextView textView6 = (TextView) this.f29851a.findViewById(R.id.tv_promotion_item1_title);
            TextView textView7 = (TextView) this.f29851a.findViewById(R.id.tv_promotion_item1_subtitle1);
            TextView textView8 = (TextView) this.f29851a.findViewById(R.id.tv_promotion_pay);
            TextView textView9 = (TextView) this.f29851a.findViewById(2131371062);
            ImageView imageView = (ImageView) this.f29851a.findViewById(2131365207);
            textView2.setText(this.j.title);
            textView3.setText(this.j.subtitle);
            List<String> list = this.j.subhead;
            String[] split = list.get(0).split("-");
            String[] split2 = list.get(1).split("-");
            textView4.setText(split[0]);
            textView5.setText(split[1]);
            textView6.setText(split2[0]);
            textView7.setText(split2[1]);
            textView9.setText(Html.fromHtml(this.j.discount_text));
            textView8.setText(this.j.btn);
            textView8.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.discover.view.-$$Lambda$FeedPromotionDlg$gxfMzg0p96NQBk1OjLUakAi8X4w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedPromotionDlg.this.b(view);
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.discover.view.-$$Lambda$FeedPromotionDlg$qCIyIbuJfrYN6OUIVFPJDckfZks
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedPromotionDlg.this.a(view);
                }
            });
        }
        ImageView imageView2 = (ImageView) this.f29851a.findViewById(R.id.dlg_feed_promotion_iv);
        this.f29852c = imageView2;
        if (imageView2 != null) {
            ImageLoader.a((IRequestHost) null, ImgURLMap.f10885a.a("icon_feed_promotion_dialog_top_bg")).a(this.f29852c);
        }
        ImageView imageView3 = (ImageView) this.f29851a.findViewById(R.id.iv_promotion_bg);
        if (imageView3 != null) {
            ImageLoader.a((IRequestHost) null, (int) R.drawable.feed_promotion_tip_bg).a(imageView3);
        }
        ImageLoader.a((IRequestHost) null, ImgURLMap.f10885a.a("feed_promotion_blued_cover")).a((ImageView) this.f29851a.findViewById(R.id.iv_blued_cover));
        setContentView(this.f29851a);
        StatusBarHelper.a(getWindow());
        setCancelable(false);
        EventTrackSuperExpose.a(SuperExposeProtos.Event.AFTER_PUBLISH_PAGE_SUPER_EXPOSE_SHOW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Tracker.onClick(view);
        a(false, 0);
    }

    private void a(final boolean z, int i) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(370L);
        alphaAnimation.setInterpolator(new CubicInterpolator(0.66f, 0.01f, 0.34f, 1.0f));
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.soft.blued.ui.discover.view.FeedPromotionDlg.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (z) {
                    WebViewShowInfoFragment.show(FeedPromotionDlg.this.getContext(), FeedPromotionDlg.this.i, 0);
                    EventTrackSuperExpose.a(SuperExposeProtos.Event.AFTER_PUBLISH_PAGE_SUPER_EXPOSE_BUY);
                }
                FeedPromotionDlg.this.dismiss();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.f.startAnimation(alphaAnimation);
        this.f.postDelayed(new Runnable() { // from class: com.soft.blued.ui.discover.view.FeedPromotionDlg.2
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.5f, 0.0f);
                alphaAnimation2.setDuration(165L);
                alphaAnimation2.setInterpolator(new CubicInterpolator(0.17f, 0.17f, 0.83f, 1.0f));
                FeedPromotionDlg.this.b.startAnimation(alphaAnimation2);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        Tracker.onClick(view);
        a(true, 2);
    }

    private boolean b() {
        return this.h == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        Tracker.onClick(view);
        a(true, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        Tracker.onClick(view);
        a(false, 0);
    }

    public void a(String str) {
        this.i = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            getWindow().setAttributes(attributes);
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.5f);
        alphaAnimation.setInterpolator(new CubicInterpolator(0.48f, 0.05f, 0.83f, 0.83f));
        alphaAnimation.setDuration(330L);
        alphaAnimation.setFillAfter(true);
        this.b.startAnimation(alphaAnimation);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation2.setDuration(410L);
        alphaAnimation2.setInterpolator(new CubicInterpolator(0.66f, 0.01f, 0.34f, 1.0f));
        this.f.startAnimation(alphaAnimation2);
    }
}

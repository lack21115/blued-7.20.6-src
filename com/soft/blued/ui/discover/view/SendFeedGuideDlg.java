package com.soft.blued.ui.discover.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.module.common.view.CubicInterpolator;
import com.blued.community.model.BluedIngSelfFeed;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.manager.SendNotificationManager;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/discover/view/SendFeedGuideDlg.class */
public class SendFeedGuideDlg extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private View f29855a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private View f29856c;
    private View d;
    private BluedIngSelfFeed e;
    private Runnable f;

    public SendFeedGuideDlg(Context context, int i) {
        super(context, i);
        this.f = new Runnable() { // from class: com.soft.blued.ui.discover.view.SendFeedGuideDlg.4
            @Override // java.lang.Runnable
            public void run() {
                SendFeedGuideDlg.this.b();
            }
        };
        a();
    }

    private void a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dlg_send_feed_guide_layout, (ViewGroup) null);
        this.f29855a = inflate;
        this.f29856c = inflate.findViewById(R.id.dlg_send_feed_guide_content_layout);
        View findViewById = this.f29855a.findViewById(R.id.dlg_send_feed_guide_close);
        this.d = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.discover.view.-$$Lambda$SendFeedGuideDlg$CuG1EpzweHep_jfW7y8R4HFP-5s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SendFeedGuideDlg.this.a(view);
            }
        });
        this.b = this.f29855a.findViewById(R.id.dlg_send_feed_guide_mask_view);
        setContentView(this.f29855a);
        StatusBarHelper.a(getWindow());
        setCancelable(false);
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.soft.blued.ui.discover.view.SendFeedGuideDlg.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                SendNotificationManager.a().a((Object) SendFeedGuideDlg.this.e);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Tracker.onClick(view);
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        AppInfo.n().removeCallbacks(this.f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(370L);
        alphaAnimation.setInterpolator(new CubicInterpolator(0.66f, 0.01f, 0.34f, 1.0f));
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.soft.blued.ui.discover.view.SendFeedGuideDlg.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                SendFeedGuideDlg.this.dismiss();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.f29856c.startAnimation(alphaAnimation);
        this.f29856c.postDelayed(new Runnable() { // from class: com.soft.blued.ui.discover.view.SendFeedGuideDlg.3
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.5f, 0.0f);
                alphaAnimation2.setDuration(165L);
                alphaAnimation2.setInterpolator(new CubicInterpolator(0.17f, 0.17f, 0.83f, 1.0f));
                SendFeedGuideDlg.this.b.startAnimation(alphaAnimation2);
            }
        }, 200L);
    }

    public void a(BluedIngSelfFeed bluedIngSelfFeed) {
        this.e = bluedIngSelfFeed;
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
        this.f29856c.startAnimation(alphaAnimation2);
        AppInfo.n().postDelayed(this.f, 2000L);
    }
}

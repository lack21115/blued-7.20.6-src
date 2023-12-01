package com.blued.android.module.live_china.view.pkdared;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import javax.xml.datatype.DatatypeConstants;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/pkdared/PkDaredJoinView.class */
public class PkDaredJoinView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private View f15387a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private View f15388c;
    private ImageView d;
    private ImageView e;
    private TextView f;
    private TextView g;
    private View h;
    private View i;
    private View j;
    private View k;
    private View l;
    private View m;
    private View n;
    private View o;

    public PkDaredJoinView(Context context) {
        super(context);
        a(context);
    }

    public PkDaredJoinView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public PkDaredJoinView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void b() {
        int height = this.f15387a.getHeight();
        int height2 = ((View) getParent()).getHeight();
        a(this.b, true);
        a(this.f15388c, false);
        b(this.j, true);
        b(this.k, false);
        a(this.h);
        a(this.i);
        a(this.l, DatatypeConstants.MIN_TIMEZONE_OFFSET, 330);
        a(this.m, 400, 560);
        a(this.n, DatatypeConstants.MIN_TIMEZONE_OFFSET, 330);
        a(this.o, 400, 560);
        setTranslationY((height2 * 0.4f) - (height / 2.0f));
        animate().alpha(1.0f).setDuration(100L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(100L);
        ofFloat.setStartDelay(2260L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.view.pkdared.PkDaredJoinView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (PkDaredJoinView.this.getParent() != null) {
                    ((ViewGroup) PkDaredJoinView.this.getParent()).removeView(PkDaredJoinView.this);
                }
            }
        });
        ofFloat.start();
    }

    private void a(View view) {
        view.setAlpha(0.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.setStartDelay(480L);
        ofFloat.start();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        ofFloat2.setDuration(200L);
        ofFloat2.setStartDelay(2000L);
        ofFloat2.start();
    }

    private void a(View view, int i, int i2) {
        view.setAlpha(0.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "Alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i2);
        ofFloat.setStartDelay(i);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "Alpha", 1.0f, 0.45f);
        ofFloat2.setDuration(360L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "Alpha", 0.45f, 1.0f);
        ofFloat3.setDuration(360L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "Alpha", 1.0f, 0.45f);
        ofFloat4.setDuration(360L);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view, "Alpha", 0.45f, 0.0f);
        ofFloat5.setDuration(280L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5);
        animatorSet.start();
    }

    private void a(View view, boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", z ? -this.b.getWidth() : this.f15388c.getWidth(), 0.0f);
        ofFloat.setDuration(320L);
        ofFloat.setInterpolator(new OvershootInterpolator(1.2f));
        ofFloat.start();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationX", 0.0f, z ? -this.b.getWidth() : this.f15388c.getWidth());
        ofFloat2.setDuration(320L);
        ofFloat2.setStartDelay(2040L);
        ofFloat2.start();
    }

    private void b(View view, boolean z) {
        view.setScaleX(0.52f);
        view.setScaleY(0.52f);
        ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f).setDuration(200L).start();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 0.52f, 0.88f, 1.24f, 1.6f, 1.45f, 1.3f, 1.15f, 1.0f, 1.05f, 1.1f, 1.15f, 1.2f, 1.1333333f, 1.0666666f, 1.0f);
        ofFloat.setDuration(640L);
        ofFloat.setStartDelay(80L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.start();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 0.52f, 0.88f, 1.24f, 1.6f, 1.45f, 1.3f, 1.15f, 1.0f, 1.05f, 1.1f, 1.15f, 1.2f, 1.1333333f, 1.0666666f, 1.0f);
        ofFloat2.setDuration(640L);
        ofFloat2.setStartDelay(80L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.start();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        ofFloat3.setDuration(200L);
        ofFloat3.setStartDelay(2120L);
        ofFloat3.start();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "translationX", 0.0f, z ? -this.b.getWidth() : this.f15388c.getWidth());
        ofFloat4.setDuration(160L);
        ofFloat4.setStartDelay(2120L);
        ofFloat4.setInterpolator(new LinearInterpolator());
        ofFloat4.start();
    }

    protected void a(Context context) {
        LayoutInflater.from(getContext()).inflate(R.layout.live_pk_dared_join, this);
        this.f15387a = findViewById(R.id.rl_root);
        this.b = findViewById(R.id.rl_root_our);
        this.f15388c = findViewById(R.id.rl_root_opposite);
        this.d = (ImageView) findViewById(R.id.iv_avatar_our);
        this.e = (ImageView) findViewById(R.id.iv_avatar_opposite);
        this.f = (TextView) findViewById(R.id.tv_nickname_our);
        this.g = (TextView) findViewById(R.id.tv_nickname_opposite);
        this.h = findViewById(R.id.view_flare_light_our);
        this.i = findViewById(R.id.view_flare_light_opposite);
        this.j = findViewById(R.id.iv_v);
        this.k = findViewById(R.id.iv_s);
        this.l = findViewById(R.id.iv_star_1);
        this.m = findViewById(R.id.iv_star_2);
        this.n = findViewById(R.id.iv_star_3);
        this.o = findViewById(R.id.iv_star_4);
    }

    public void a(String str, String str2, IRequestHost iRequestHost) {
        setAlpha(0.0f);
        setVisibility(0);
        this.f.setText(LiveRoomManager.a().p().profile.name);
        ImageLoader.a(iRequestHost, (LiveRoomManager.a().p() == null || LiveRoomManager.a().p().profile == null || TextUtils.isEmpty(LiveRoomManager.a().p().profile.avatar)) ? "" : LiveRoomManager.a().p().profile.avatar).b(R.drawable.user_bg_round).c().a(3.0f, getContext().getResources().getColor(R.color.syc_dark_00D5FF)).a(this.d);
        this.g.setText(str);
        ImageLoader.a(iRequestHost, str2).b(R.drawable.user_bg_round).c().a(3.0f, getContext().getResources().getColor(R.color.syc_dark_FF99E1)).a(this.e);
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredJoinView$orBCdDp5gu_-f0j9Ud2bJT7JwXw
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredJoinView.this.b();
            }
        });
    }
}

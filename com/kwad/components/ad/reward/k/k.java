package com.kwad.components.ad.reward.k;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.bi;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/k/k.class */
public final class k extends w implements View.OnClickListener {
    private ImageView fp;
    private TextView lP;
    private com.kwad.components.ad.reward.j qt;
    private ImageView yH;
    private TextView yI;
    private TextView yJ;
    private TextView yK;
    private View yL;
    private Set<ImageView> yM = new HashSet();
    private TextView yN;
    private Animator yO;

    public k(com.kwad.components.ad.reward.j jVar) {
        this.qt = jVar;
    }

    private static Animator a(View view, long j, float f) {
        if (view == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Interpolator create = PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f);
        view.setPivotX(0.0f);
        view.setPivotY(view.getHeight());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f);
        ofFloat.setDuration(100L);
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, Key.ROTATION, 0.0f, f).setDuration(j);
        float f2 = -f;
        float[] fArr = {f, f2};
        long j2 = j * 2;
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, Key.ROTATION, fArr).setDuration(j2);
        duration2.setInterpolator(create);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, Key.ROTATION, f2, f).setDuration(j2);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(view, Key.ROTATION, f, f2).setDuration(j2);
        duration4.setInterpolator(create);
        animatorSet.playSequentially(ofFloat, duration, duration2, duration3, duration4, ObjectAnimator.ofFloat(view, Key.ROTATION, f2, 0.0f).setDuration(j));
        return animatorSet;
    }

    static /* synthetic */ Animator a(k kVar, View view) {
        return p(view);
    }

    static /* synthetic */ Animator a(k kVar, View view, long j, float f) {
        return a(view, 100L, 8.0f);
    }

    private void a(com.kwad.components.ad.reward.model.a aVar) {
        this.yI.setText(aVar.getTitle());
        this.lP.setText(aVar.hj());
        this.yJ.setText(aVar.hg());
        String gm = aVar.gm();
        Drawable drawable = this.fp.getResources().getDrawable(R.drawable.ksad_ic_default_user_avatar);
        KSImageLoader.loadCircleIcon(this.fp, gm, drawable);
        String aj = com.kwad.components.ad.c.b.aj();
        if (!bb.isNullString(aj)) {
            KSImageLoader.loadImage(this.yH, aj, aVar.ha());
        }
        if (!aVar.hh()) {
            this.yL.setVisibility(8);
            return;
        }
        this.yL.setVisibility(0);
        String hf = aVar.hf();
        if (!TextUtils.isEmpty(hf)) {
            this.yN.setText(String.format("%s已预约直播", hf));
        }
        if (aVar.hi() == null) {
            return;
        }
        List<String> hi = aVar.hi();
        Iterator<ImageView> it = this.yM.iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return;
            }
            ImageView next = it.next();
            if (i2 < hi.size()) {
                next.setVisibility(0);
                KSImageLoader.loadCircleIcon(next, hi.get(i2), drawable);
            }
            i = i2 + 1;
        }
    }

    private void initView() {
        if (this.sn == null) {
            return;
        }
        this.yK = (TextView) this.sn.findViewById(R.id.ksad_reward_live_subscribe_badge);
        this.yH = (ImageView) this.sn.findViewById(R.id.ksad_reward_live_subscribe_kwai_logo);
        this.fp = (ImageView) this.sn.findViewById(R.id.ksad_reward_live_subscribe_icon);
        this.yI = (TextView) this.sn.findViewById(R.id.ksad_reward_live_subscribe_name);
        this.lP = (TextView) this.sn.findViewById(R.id.ksad_reward_live_subscribe_desc);
        this.yJ = (TextView) this.sn.findViewById(R.id.ksad_reward_live_subscribe_btn_follow);
        this.yL = this.sn.findViewById(R.id.ksad_reward_live_subscribe_follower_area);
        ImageView imageView = (ImageView) this.sn.findViewById(R.id.ksad_reward_live_subscribe_follower_icon1);
        ImageView imageView2 = (ImageView) this.sn.findViewById(R.id.ksad_reward_live_subscribe_follower_icon2);
        ImageView imageView3 = (ImageView) this.sn.findViewById(R.id.ksad_reward_live_subscribe_follower_icon3);
        this.yM.add(imageView);
        this.yM.add(imageView2);
        this.yM.add(imageView3);
        this.yN = (TextView) this.sn.findViewById(R.id.ksad_reward_live_subscribe_count);
        this.sn.setOnClickListener(this);
        this.yJ.setOnClickListener(this);
    }

    private void jS() {
        this.yK.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.k.k.1
            @Override // java.lang.Runnable
            public final void run() {
                k kVar = k.this;
                kVar.yO = k.a(kVar, kVar.yK, 100L, 8.0f);
                k.this.yO.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.k.k.1.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (k.this.yO != null) {
                            k.this.yO.start();
                        }
                    }
                });
                k.this.yO.start();
            }
        }, 500L);
    }

    private void jT() {
        bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.k.k.2
            @Override // java.lang.Runnable
            public final void run() {
                k kVar = k.this;
                k.a(kVar, kVar.yL).start();
            }
        }, 2000L);
    }

    private static Animator p(View view) {
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationY", view.getResources().getDimension(R.dimen.ksad_live_subscribe_card_count_area_trans_y)).setDuration(250L);
        duration.setInterpolator(create);
        return duration;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.ad.reward.k.d
    public final void a(v vVar) {
        super.a(vVar);
        AdTemplate adTemplate = vVar.getAdTemplate();
        if (adTemplate != null) {
            a(com.kwad.components.ad.reward.model.a.u(adTemplate));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.ad.reward.k.d
    public final void ag(boolean z) {
        super.ag(z);
        Context context = this.sn.getContext();
        if (ai.DL()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.sn.getLayoutParams();
        layoutParams.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_live_subscribe_card_width_horizontal);
        this.sn.setLayoutParams(layoutParams);
    }

    public final void f(ViewGroup viewGroup) {
        super.a(viewGroup, R.id.ksad_reward_live_subscribe_stub, R.id.ksad_reward_live_subscribe_root);
        initView();
    }

    public final void jR() {
        jS();
        jT();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Tracker.onClick(view);
        if (view.equals(this.yJ)) {
            this.qt.a(1, view.getContext(), 29, 1);
        } else if (view.equals(this.sn)) {
            this.qt.a(1, view.getContext(), 53, 2);
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void onUnbind() {
        super.onUnbind();
        Animator animator = this.yO;
        if (animator != null) {
            animator.cancel();
            this.yO = null;
        }
    }
}

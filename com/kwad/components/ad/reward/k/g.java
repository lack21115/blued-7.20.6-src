package com.kwad.components.ad.reward.k;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/k/g.class */
public final class g extends w implements View.OnClickListener {
    private TextView he;
    private com.kwad.components.ad.reward.j qt;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/k/g$a.class */
    public interface a {
        void hw();
    }

    public g(com.kwad.components.ad.reward.j jVar) {
        this.qt = jVar;
    }

    private static Animator o(View view) {
        if (view == null) {
            return null;
        }
        int dimensionPixelSize = view.getContext().getResources().getDimensionPixelSize(R.dimen.ksad_live_card_tips_animation_y);
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationY", -dimensionPixelSize).setDuration(500L);
        duration.setInterpolator(create);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f).setDuration(2500L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, "translationY", 0.0f).setDuration(500L);
        duration3.setInterpolator(create);
        animatorSet.playSequentially(duration, duration2, duration3);
        return animatorSet;
    }

    public final void a(final a aVar, long j) {
        final Animator o = o(this.sn);
        if (o == null) {
            aVar.hw();
            return;
        }
        o.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.k.g.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.hw();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.hw();
                }
            }
        });
        this.sn.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.k.g.2
            @Override // java.lang.Runnable
            public final void run() {
                o.start();
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.ad.reward.k.d
    public final void a(v vVar) {
        String str;
        TextView textView;
        super.a(vVar);
        AdTemplate adTemplate = vVar.getAdTemplate();
        if (adTemplate == null || (str = com.kwad.sdk.core.response.a.b.bI(adTemplate).title) == null || (textView = this.he) == null) {
            return;
        }
        textView.setText(str);
    }

    public final void e(ViewGroup viewGroup) {
        super.a(viewGroup, R.id.ksad_card_tips_view, R.id.ksad_card_tips_root);
        if (this.he == null) {
            this.he = (TextView) this.sn.findViewById(R.id.ksad_card_tips_title);
        }
        this.sn.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.k.w, com.kwad.components.ad.reward.k.d
    public final ViewGroup gK() {
        return this.sn;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Tracker.onClick(view);
        if (view.equals(this.sn)) {
            com.kwad.components.ad.reward.j jVar = this.qt;
            jVar.a(1, jVar.mContext, 1, 1);
        }
    }
}

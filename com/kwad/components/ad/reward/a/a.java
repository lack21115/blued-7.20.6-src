package com.kwad.components.ad.reward.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.ad.reward.k.d;
import com.kwad.components.ad.reward.k.v;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.j.k;
import com.kwad.sdk.utils.bi;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/a/a.class */
public final class a extends d implements View.OnClickListener {
    private final ViewGroup gv;
    private TextView he;
    private TextView lP;
    private int[] qP;
    private View qQ;
    private ImageView qR;
    private TextView qS;
    private Button qT;
    private b qU;

    /* renamed from: com.kwad.components.ad.reward.a.a$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/a/a$1.class */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ v qV;
        final /* synthetic */ long qW;

        AnonymousClass1(v vVar, long j) {
            this.qV = vVar;
            this.qW = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a aVar = a.this;
            final Animator a2 = a.a(aVar, aVar.qQ);
            a2.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.a.a.1.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a2.removeListener(this);
                    com.kwad.sdk.core.report.a.b(AnonymousClass1.this.qV.getAdTemplate(), 169, (JSONObject) null);
                    a.a(a.this, a.this.qR, AnonymousClass1.this.qW).start();
                    bi.a(new Runnable() { // from class: com.kwad.components.ad.reward.a.a.1.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.gL();
                        }
                    }, null, AnonymousClass1.this.qW);
                }
            });
            a2.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.reward.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/a/a$a.class */
    public static final class C0320a {
        private CharSequence rc;
        private CharSequence rd;
        private CharSequence re;
        private CharSequence title;

        private C0320a(CouponInfo couponInfo) {
            this.title = couponInfo.displayTitle;
            this.rc = couponInfo.displayValue;
            this.rd = !TextUtils.isEmpty(couponInfo.displayBase) ? String.format("满%s可用", couponInfo.displayBase) : "";
            this.re = couponInfo.displayActionWords;
        }

        private static C0320a a(CouponInfo couponInfo) {
            if (couponInfo == null) {
                return null;
            }
            return new C0320a(couponInfo);
        }

        public static C0320a s(AdTemplate adTemplate) {
            AdProductInfo ct = com.kwad.sdk.core.response.a.a.ct(com.kwad.sdk.core.response.a.d.cb(adTemplate));
            if (ct == null || ct.couponList == null || ct.couponList.size() <= 0) {
                return null;
            }
            return a(ct.couponList.get(0));
        }

        public final CharSequence N(Context context) {
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(context.getResources().getDimensionPixelSize(R.dimen.ksad_coupon_dialog_value_prefix_text_size));
            SpannableString spannableString = new SpannableString("¥" + ((Object) this.rc));
            spannableString.setSpan(absoluteSizeSpan, 0, 1, 17);
            return spannableString;
        }

        public final CharSequence gM() {
            return this.rd;
        }

        public final CharSequence gN() {
            return this.re;
        }

        public final CharSequence getTitle() {
            return this.title;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/a/a$b.class */
    public interface b {
        void gO();

        void gP();
    }

    public a(Context context, ViewGroup viewGroup, int[] iArr) {
        this.qP = iArr;
        ViewGroup viewGroup2 = (ViewGroup) k.a(context, R.layout.ksad_reward_coupon_dialog, viewGroup, false);
        this.gv = viewGroup2;
        d(viewGroup2);
    }

    private static Animator a(ImageView imageView, long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "alpha", imageView.getAlpha(), 0.0f);
        ofFloat.setDuration(j);
        return ofFloat;
    }

    static /* synthetic */ Animator a(a aVar, View view) {
        return m(view);
    }

    static /* synthetic */ Animator a(a aVar, ImageView imageView, long j) {
        return a(imageView, j);
    }

    private void a(C0320a c0320a) {
        if (c0320a == null) {
            return;
        }
        TextView textView = this.he;
        if (textView != null) {
            textView.setText(c0320a.getTitle());
        }
        TextView textView2 = this.qS;
        if (textView2 != null) {
            textView2.setText(c0320a.N(this.gv.getContext()));
        }
        TextView textView3 = this.lP;
        if (textView3 != null) {
            textView3.setText(c0320a.gM());
        }
        Button button = this.qT;
        if (button != null) {
            button.setText(c0320a.gN());
        }
    }

    private void d(ViewGroup viewGroup) {
        this.qQ = viewGroup.findViewById(R.id.ksad_coupon_dialog_card);
        this.qR = (ImageView) viewGroup.findViewById(R.id.ksad_coupon_dialog_bg);
        this.he = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_title);
        this.qS = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_content);
        this.lP = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_desc);
        Button button = (Button) viewGroup.findViewById(R.id.ksad_coupon_dialog_btn_action);
        this.qT = button;
        button.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gL() {
        final Animator n = n(this.qQ);
        n.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.a.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                n.removeListener(this);
                if (a.this.qU != null) {
                    a.this.qU.gP();
                }
            }
        });
        n.start();
    }

    private static Animator m(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    private Animator n(View view) {
        ObjectAnimator objectAnimator;
        int[] C;
        Interpolator create = PathInterpolatorCompat.create(0.89f, 0.02f, 0.72f, 1.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.0f);
        ofFloat.setInterpolator(create);
        ofFloat2.setInterpolator(create);
        int[] iArr = this.qP;
        ObjectAnimator objectAnimator2 = null;
        if (iArr == null || iArr.length < 2 || (C = com.kwad.sdk.c.kwai.a.C(view)) == null) {
            objectAnimator = null;
        } else {
            Interpolator create2 = PathInterpolatorCompat.create(0.33f, 0.0f, 0.83f, 1.0f);
            objectAnimator2 = ObjectAnimator.ofFloat(view, "translationX", this.qP[0] - C[0]);
            objectAnimator = ObjectAnimator.ofFloat(view, "translationY", this.qP[1] - C[1]);
            objectAnimator2.setInterpolator(create2);
            objectAnimator.setInterpolator(create2);
        }
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f);
        ofFloat3.setDuration(200L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        ofFloat4.setDuration(200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat3, ofFloat4);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(500L);
        if (objectAnimator2 != null) {
            animatorSet2.playTogether(ofFloat, ofFloat2, animatorSet, objectAnimator2, objectAnimator);
            return animatorSet2;
        }
        animatorSet2.playTogether(ofFloat, ofFloat2, animatorSet);
        return animatorSet2;
    }

    public final void a(b bVar) {
        this.qU = bVar;
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void a(v vVar) {
        super.a(vVar);
        a(C0320a.s(vVar.getAdTemplate()));
        this.gv.post(new AnonymousClass1(vVar, com.kwad.components.ad.reward.kwai.b.gF()));
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup gK() {
        return this.gv;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        b bVar;
        Tracker.onClick(view);
        if (!view.equals(this.qT) || (bVar = this.qU) == null) {
            return;
        }
        bVar.gO();
    }
}

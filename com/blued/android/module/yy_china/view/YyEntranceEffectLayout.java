package com.blued.android.module.yy_china.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ItemYyEntranceEffectBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYImModel;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YyEntranceEffectLayout.class */
public class YyEntranceEffectLayout extends RelativeLayout {
    private static int d = 500;
    private static int e = 2900;
    private static int f = 500;

    /* renamed from: a  reason: collision with root package name */
    private ItemYyEntranceEffectBinding f18590a;
    private List<YYImModel> b;

    /* renamed from: c  reason: collision with root package name */
    private KeyBoardFragment f18591c;

    public YyEntranceEffectLayout(Context context) {
        this(context, null);
    }

    public YyEntranceEffectLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YyEntranceEffectLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18590a = ItemYyEntranceEffectBinding.a(LayoutInflater.from(context), this, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final YYImModel yYImModel) {
        if (yYImModel == null || yYImModel.source_profile == null) {
            return;
        }
        if (!YYRoomInfoManager.e().J()) {
            this.f18590a.h.setText(yYImModel.source_profile.getName());
            ImageLoader.a(this.f18591c.getFragmentActive(), yYImModel.source_profile.getAvatar()).b(R.drawable.user_bg_round).a(this.f18590a.f16707c);
        } else if (YYRoomInfoManager.e().g(yYImModel.source_profile.getUid())) {
            this.f18590a.h.setText(yYImModel.source_profile.getName());
            ImageLoader.a(this.f18591c.getFragmentActive(), yYImModel.source_profile.getAvatar()).b(R.drawable.user_bg_round).a(this.f18590a.f16707c);
        } else {
            this.f18590a.h.setText(this.f18591c.getResources().getString(R.string.masked_user_name));
            ImageLoader.a(this.f18591c.getFragmentActive(), R.drawable.icon_user_mask_without_text).a(this.f18590a.f16707c);
        }
        if (yYImModel.source_profile.enter_effects_forward == null || "".equals(yYImModel.source_profile.enter_effects_forward)) {
            ShapeHelper.a(this.f18590a.f, R.color.syc_00FD4848, R.color.syc_fff95b39);
            if (yYImModel.source_profile.wealth_level >= 30) {
                ShapeHelper.a(this.f18590a.f, R.color.syc_0050A6FF, R.color.syc_FF50A6FF);
            }
            if (yYImModel.source_profile.wealth_level >= 36) {
                ShapeHelper.a(this.f18590a.f, R.color.syc_009270F0, R.color.syc_FF9270F0);
            }
            if (yYImModel.source_profile.wealth_level >= 41) {
                ShapeHelper.a(this.f18590a.f, R.color.syc_00FD4848, R.color.syc_FFFD4848);
            }
            if (yYImModel.source_profile.wealth_level >= 46) {
                ShapeHelper.a(this.f18590a.f, R.color.syc_00FDDE01, R.color.syc_FFFDDE01);
            }
        } else {
            ImageLoader.a(this.f18591c.getFragmentActive(), yYImModel.source_profile.enter_effects_forward).a(new CustomTarget<Drawable>() { // from class: com.blued.android.module.yy_china.view.YyEntranceEffectLayout.1
                @Override // com.bumptech.glide.request.target.Target
                /* renamed from: a */
                public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                    YyEntranceEffectLayout.this.f18590a.f.setBackground(drawable);
                }

                @Override // com.bumptech.glide.request.target.Target
                public void onLoadCleared(Drawable drawable) {
                }
            });
        }
        if (yYImModel.source_profile.enter_effects == null || "".equals(yYImModel.source_profile.enter_effects)) {
            this.f18590a.d.setVisibility(8);
            this.f18590a.f16706a.post(new Runnable() { // from class: com.blued.android.module.yy_china.view.YyEntranceEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    YyEntranceEffectLayout.this.f18590a.f16706a.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    YyEntranceEffectLayout.this.f18590a.f16706a.layout(0, 0, YyEntranceEffectLayout.this.f18590a.f16706a.getMeasuredWidth(), YyEntranceEffectLayout.this.f18590a.f16706a.getMeasuredHeight());
                    YyEntranceEffectLayout yyEntranceEffectLayout = YyEntranceEffectLayout.this;
                    yyEntranceEffectLayout.a(yyEntranceEffectLayout.f18590a.f16706a.getMeasuredWidth(), yYImModel).start();
                }
            });
            return;
        }
        this.f18590a.d.setVisibility(0);
        ImageLoader.a(this.f18591c.getFragmentActive(), yYImModel.source_profile.enter_effects).a(new ImageLoadResult(this.f18591c.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YyEntranceEffectLayout.2
            @Override // com.blued.android.core.image.ImageLoadResult
            public void a() {
                super.a();
                YyEntranceEffectLayout.this.f18590a.f16706a.post(new Runnable() { // from class: com.blued.android.module.yy_china.view.YyEntranceEffectLayout.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        YyEntranceEffectLayout.this.f18590a.f16706a.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                        YyEntranceEffectLayout.this.f18590a.f16706a.layout(0, 0, YyEntranceEffectLayout.this.f18590a.f16706a.getMeasuredWidth(), YyEntranceEffectLayout.this.f18590a.f16706a.getMeasuredHeight());
                        YyEntranceEffectLayout.this.a(YyEntranceEffectLayout.this.f18590a.f16706a.getMeasuredWidth(), yYImModel).start();
                    }
                });
            }
        }).g(-1).e(1).a().a(this.f18590a.d);
    }

    public AnimatorSet a(float f2, final YYImModel yYImModel) {
        this.f18590a.f16706a.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(getResources().getDisplayMetrics().widthPixels, DensityUtils.a(getContext(), 20.0f));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.yy_china.view.YyEntranceEffectLayout.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) YyEntranceEffectLayout.this.f18590a.f16706a.getLayoutParams();
                layoutParams.leftMargin = (int) floatValue;
                YyEntranceEffectLayout.this.f18590a.f16706a.setLayoutParams(layoutParams);
            }
        });
        ofFloat.setDuration(d);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(DensityUtils.a(getContext(), 20.0f), DensityUtils.a(getContext(), 5.0f));
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.yy_china.view.YyEntranceEffectLayout.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) YyEntranceEffectLayout.this.f18590a.f16706a.getLayoutParams();
                layoutParams.leftMargin = (int) floatValue;
                YyEntranceEffectLayout.this.f18590a.f16706a.setLayoutParams(layoutParams);
            }
        });
        ofFloat2.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.yy_china.view.YyEntranceEffectLayout.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ofFloat2.setDuration(e);
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(DensityUtils.a(getContext(), 5.0f), -f2);
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.yy_china.view.YyEntranceEffectLayout.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) YyEntranceEffectLayout.this.f18590a.f16706a.getLayoutParams();
                layoutParams.leftMargin = (int) floatValue;
                YyEntranceEffectLayout.this.f18590a.f16706a.setLayoutParams(layoutParams);
            }
        });
        ofFloat3.setDuration(f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ofFloat);
        arrayList.add(ofFloat2);
        arrayList.add(ofFloat3);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(arrayList);
        this.f18590a.f16706a.postDelayed(new Runnable() { // from class: com.blued.android.module.yy_china.view.YyEntranceEffectLayout.8
            @Override // java.lang.Runnable
            public void run() {
                YyEntranceEffectLayout.this.f18590a.f16706a.setVisibility(8);
                if (YyEntranceEffectLayout.this.b.size() > 0) {
                    YyEntranceEffectLayout.this.b.remove(yYImModel);
                }
                if (YyEntranceEffectLayout.this.b.size() > 0) {
                    YyEntranceEffectLayout yyEntranceEffectLayout = YyEntranceEffectLayout.this;
                    yyEntranceEffectLayout.b((YYImModel) yyEntranceEffectLayout.b.get(0));
                }
            }
        }, d + e + f);
        return animatorSet;
    }

    public void a(KeyBoardFragment keyBoardFragment) {
        this.f18591c = keyBoardFragment;
        this.b = new ArrayList();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.blued.android.module.yy_china.model.YYImModel r5) {
        /*
            r4 = this;
            r0 = r5
            if (r0 == 0) goto L76
            r0 = r4
            com.blued.android.framework.activity.keyboardpage.KeyBoardFragment r0 = r0.f18591c
            if (r0 == 0) goto L76
            r0 = r5
            com.blued.android.module.yy_china.model.YYAudienceModel r0 = r0.source_profile
            if (r0 == 0) goto L4d
            com.blued.android.module.yy_china.manager.YYRoomInfoManager r0 = com.blued.android.module.yy_china.manager.YYRoomInfoManager.e()
            java.lang.String r0 = r0.k()
            r6 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r7 = r0
            r0 = r7
            r1 = r5
            com.blued.android.module.yy_china.model.YYAudienceModel r1 = r1.source_profile
            java.lang.String r1 = r1.getUid()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            java.lang.String r1 = ""
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            r1 = r7
            java.lang.String r1 = r1.toString()
            boolean r0 = android.text.TextUtils.equals(r0, r1)
            if (r0 == 0) goto L4d
            r0 = r4
            java.util.List<com.blued.android.module.yy_china.model.YYImModel> r0 = r0.b
            r1 = 0
            r2 = r5
            r0.add(r1, r2)
            goto L58
        L4d:
            r0 = r4
            java.util.List<com.blued.android.module.yy_china.model.YYImModel> r0 = r0.b
            r1 = r5
            boolean r0 = r0.add(r1)
        L58:
            r0 = r4
            java.util.List<com.blued.android.module.yy_china.model.YYImModel> r0 = r0.b
            int r0 = r0.size()
            r1 = 1
            if (r0 != r1) goto L76
            r0 = r4
            r1 = r4
            java.util.List<com.blued.android.module.yy_china.model.YYImModel> r1 = r1.b
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            com.blued.android.module.yy_china.model.YYImModel r1 = (com.blued.android.module.yy_china.model.YYImModel) r1
            r0.b(r1)
        L76:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.view.YyEntranceEffectLayout.a(com.blued.android.module.yy_china.model.YYImModel):void");
    }
}

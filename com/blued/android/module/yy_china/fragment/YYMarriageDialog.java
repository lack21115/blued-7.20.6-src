package com.blued.android.module.yy_china.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.svgaplayer.SVGACallback;
import com.blued.android.module.svgaplayer.SVGADrawable;
import com.blued.android.module.svgaplayer.SVGADynamicEntity;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAParser;
import com.blued.android.module.svgaplayer.SVGAVideoEntity;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogYyMarriageBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.BlindMatchUserModel;
import com.blued.android.module.yy_china.model.BlindMatchUserPairModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.google.android.material.imageview.ShapeableImageView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYMarriageDialog.class */
public final class YYMarriageDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private BaseFragment f17336a;
    private ArrayList<BlindMatchUserPairModel> b;

    /* renamed from: c  reason: collision with root package name */
    private DialogYyMarriageBinding f17337c;
    private float d;
    private YYRoomModel e;
    private ImageView f;
    private ImageView g;

    public YYMarriageDialog(BaseFragment fragment, ArrayList<BlindMatchUserPairModel> coupleList) {
        Intrinsics.e(fragment, "fragment");
        Intrinsics.e(coupleList, "coupleList");
        this.f17336a = fragment;
        this.b = coupleList;
        this.e = YYRoomInfoManager.e().b();
    }

    private final void a(final SVGAImageView sVGAImageView, String str) {
        sVGAImageView.setLoops(-1);
        SVGAParser.a(new SVGAParser(getContext()), str, new SVGAParser.ParseCompletion() { // from class: com.blued.android.module.yy_china.fragment.YYMarriageDialog$playSvgaBackground$1
            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onComplete(SVGAVideoEntity svgaVideoEntity) {
                Intrinsics.e(svgaVideoEntity, "svgaVideoEntity");
                SVGAImageView.this.setImageDrawable(new SVGADrawable(svgaVideoEntity, new SVGADynamicEntity()));
                SVGAImageView.this.a();
            }

            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onError() {
            }
        }, (SVGAParser.PlayCallback) null, 4, (Object) null);
    }

    private final void a(final SVGAImageView sVGAImageView, String str, final boolean z) {
        sVGAImageView.setVisibility(0);
        sVGAImageView.setLoops(1);
        SVGAParser.a(new SVGAParser(getContext()), str, new SVGAParser.ParseCompletion() { // from class: com.blued.android.module.yy_china.fragment.YYMarriageDialog$playSvga$1
            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onComplete(SVGAVideoEntity svgaVideoEntity) {
                Intrinsics.e(svgaVideoEntity, "svgaVideoEntity");
                SVGAImageView.this.setImageDrawable(new SVGADrawable(svgaVideoEntity, new SVGADynamicEntity()));
                SVGAImageView.this.a();
                final SVGAImageView sVGAImageView2 = SVGAImageView.this;
                final YYMarriageDialog yYMarriageDialog = this;
                final boolean z2 = z;
                sVGAImageView2.setCallback(new SVGACallback() { // from class: com.blued.android.module.yy_china.fragment.YYMarriageDialog$playSvga$1$onComplete$1
                    @Override // com.blued.android.module.svgaplayer.SVGACallback
                    public void onFinished() {
                        DialogYyMarriageBinding dialogYyMarriageBinding;
                        DialogYyMarriageBinding dialogYyMarriageBinding2;
                        SVGAImageView.this.b();
                        dialogYyMarriageBinding = yYMarriageDialog.f17337c;
                        SVGAImageView sVGAImageView3 = dialogYyMarriageBinding == null ? null : dialogYyMarriageBinding.f16433c;
                        if (sVGAImageView3 != null) {
                            sVGAImageView3.setVisibility(8);
                        }
                        if (!z2) {
                            yYMarriageDialog.k();
                            yYMarriageDialog.g();
                            return;
                        }
                        dialogYyMarriageBinding2 = yYMarriageDialog.f17337c;
                        SVGAImageView sVGAImageView4 = dialogYyMarriageBinding2 == null ? null : dialogYyMarriageBinding2.b;
                        if (sVGAImageView4 != null) {
                            sVGAImageView4.setVisibility(8);
                        }
                        yYMarriageDialog.j();
                    }

                    @Override // com.blued.android.module.svgaplayer.SVGACallback
                    public void onPause() {
                    }

                    @Override // com.blued.android.module.svgaplayer.SVGACallback
                    public void onRepeat() {
                    }

                    @Override // com.blued.android.module.svgaplayer.SVGACallback
                    public void onStep(int i, double d) {
                    }
                });
            }

            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onError() {
            }
        }, (SVGAParser.PlayCallback) null, 4, (Object) null);
    }

    private final void a(BlindMatchUserModel blindMatchUserModel, BlindMatchUserModel blindMatchUserModel2) {
        YYRoomInfoManager.e().b(this.f17336a.getFragmentActive(), this.f, blindMatchUserModel.uid, blindMatchUserModel.avatar);
        YYRoomInfoManager.e().b(this.f17336a.getFragmentActive(), this.g, blindMatchUserModel2.uid, blindMatchUserModel2.avatar);
    }

    private final void a(boolean z) {
        ImageView imageView = this.f;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        ImageView imageView2 = this.f;
        Float valueOf = imageView2 == null ? null : Float.valueOf(imageView2.getWidth());
        ImageView imageView3 = this.f;
        Intrinsics.a(valueOf);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView3, "translationX", -valueOf.floatValue(), valueOf.floatValue() + this.d);
        ofFloat.setDuration(350L);
        if (!z) {
            ofFloat.start();
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f, "scaleX", 1.0f, 1.1f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f, "scaleY", 1.0f, 1.1f, 1.0f);
        animatorSet.setDuration(300L);
        animatorSet.playTogether(ofFloat2, ofFloat3);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playSequentially(ofFloat, animatorSet);
        animatorSet2.start();
    }

    private final void b(boolean z) {
        ImageView imageView;
        ImageView imageView2 = this.g;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        Float valueOf = this.g == null ? null : Float.valueOf(imageView.getWidth());
        ImageView imageView3 = this.g;
        float f = AppInfo.l;
        Intrinsics.a(valueOf);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView3, "translationX", f + valueOf.floatValue(), -(valueOf.floatValue() + this.d));
        ofFloat.setDuration(350L);
        if (!z) {
            ofFloat.start();
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.g, "scaleX", 1.0f, 1.1f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.g, "scaleY", 1.0f, 1.1f, 1.0f);
        animatorSet.setDuration(300L);
        animatorSet.playTogether(ofFloat2, ofFloat3);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playSequentially(ofFloat, animatorSet);
        animatorSet2.start();
    }

    private final void f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        ConstraintLayout constraintLayout;
        ConstraintLayout constraintLayout2;
        if (this.b.isEmpty()) {
            dismissAllowingStateLoss();
            return;
        }
        BlindMatchUserPairModel remove = this.b.remove(0);
        Intrinsics.c(remove, "coupleList.removeAt(0)");
        BlindMatchUserPairModel blindMatchUserPairModel = remove;
        if (blindMatchUserPairModel.source == null || blindMatchUserPairModel.target == null) {
            g();
            return;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.item_couple_layout, (ViewGroup) null);
        if (inflate == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.imageview.ShapeableImageView");
        }
        ShapeableImageView shapeableImageView = (ShapeableImageView) inflate;
        this.f = shapeableImageView;
        if (shapeableImageView != null) {
            shapeableImageView.setId(R.id.couple_source);
        }
        View inflate2 = LayoutInflater.from(getContext()).inflate(R.layout.item_couple_layout, (ViewGroup) null);
        if (inflate2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.imageview.ShapeableImageView");
        }
        ShapeableImageView shapeableImageView2 = (ShapeableImageView) inflate2;
        this.g = shapeableImageView2;
        if (shapeableImageView2 != null) {
            shapeableImageView2.setId(R.id.couple_target);
        }
        DialogYyMarriageBinding dialogYyMarriageBinding = this.f17337c;
        if (dialogYyMarriageBinding != null && (constraintLayout2 = dialogYyMarriageBinding.d) != null) {
            constraintLayout2.addView(this.f);
        }
        DialogYyMarriageBinding dialogYyMarriageBinding2 = this.f17337c;
        if (dialogYyMarriageBinding2 != null && (constraintLayout = dialogYyMarriageBinding2.d) != null) {
            constraintLayout.addView(this.g);
        }
        ConstraintSet constraintSet = new ConstraintSet();
        DialogYyMarriageBinding dialogYyMarriageBinding3 = this.f17337c;
        constraintSet.clone(dialogYyMarriageBinding3 == null ? null : dialogYyMarriageBinding3.d);
        constraintSet.constrainHeight(R.id.couple_source, DensityUtils.a(getContext(), 108.0f));
        constraintSet.constrainWidth(R.id.couple_source, DensityUtils.a(getContext(), 108.0f));
        constraintSet.connect(R.id.couple_source, 1, 0, 1);
        constraintSet.connect(R.id.couple_source, 4, R.id.img_cheerful_view, 4, DensityUtils.a(getContext(), 60.0f));
        constraintSet.connect(R.id.couple_target, 2, 0, 2);
        constraintSet.connect(R.id.couple_target, 4, R.id.img_cheerful_view, 4, DensityUtils.a(getContext(), 60.0f));
        constraintSet.constrainHeight(R.id.couple_target, DensityUtils.a(getContext(), 108.0f));
        constraintSet.constrainWidth(R.id.couple_target, DensityUtils.a(getContext(), 108.0f));
        DialogYyMarriageBinding dialogYyMarriageBinding4 = this.f17337c;
        constraintSet.applyTo(dialogYyMarriageBinding4 == null ? null : dialogYyMarriageBinding4.d);
        ImageView imageView = this.f;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.g;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        BlindMatchUserModel target = blindMatchUserPairModel.target;
        Intrinsics.c(target, "target");
        BlindMatchUserModel source = blindMatchUserPairModel.source;
        Intrinsics.c(source, "source");
        a(target, source);
        if (blindMatchUserPairModel.isVip == 1) {
            i();
        } else {
            h();
        }
    }

    private final void h() {
        SVGAImageView sVGAImageView;
        DialogYyMarriageBinding dialogYyMarriageBinding = this.f17337c;
        SVGAImageView sVGAImageView2 = dialogYyMarriageBinding == null ? null : dialogYyMarriageBinding.f16433c;
        if (sVGAImageView2 != null) {
            sVGAImageView2.setVisibility(0);
        }
        DialogYyMarriageBinding dialogYyMarriageBinding2 = this.f17337c;
        if (dialogYyMarriageBinding2 != null && (sVGAImageView = dialogYyMarriageBinding2.f16433c) != null) {
            a(sVGAImageView, "animation_normal_match.svga", false);
        }
        a(false);
        b(false);
    }

    private final void i() {
        SVGAImageView sVGAImageView;
        SVGAImageView sVGAImageView2;
        DialogYyMarriageBinding dialogYyMarriageBinding = this.f17337c;
        SVGAImageView sVGAImageView3 = dialogYyMarriageBinding == null ? null : dialogYyMarriageBinding.f16433c;
        if (sVGAImageView3 != null) {
            sVGAImageView3.setVisibility(0);
        }
        DialogYyMarriageBinding dialogYyMarriageBinding2 = this.f17337c;
        SVGAImageView sVGAImageView4 = dialogYyMarriageBinding2 == null ? null : dialogYyMarriageBinding2.b;
        if (sVGAImageView4 != null) {
            sVGAImageView4.setVisibility(0);
        }
        DialogYyMarriageBinding dialogYyMarriageBinding3 = this.f17337c;
        if (dialogYyMarriageBinding3 != null && (sVGAImageView2 = dialogYyMarriageBinding3.b) != null) {
            a(sVGAImageView2, "animation_vip_wave.svga");
        }
        DialogYyMarriageBinding dialogYyMarriageBinding4 = this.f17337c;
        if (dialogYyMarriageBinding4 != null && (sVGAImageView = dialogYyMarriageBinding4.f16433c) != null) {
            a(sVGAImageView, "animation_vip_match.svga", true);
        }
        a(true);
        b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.g, "alpha", 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setDuration(200L);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.yy_china.fragment.YYMarriageDialog$exitAnim$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                YYMarriageDialog.this.k();
                YYMarriageDialog.this.g();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        ConstraintLayout constraintLayout;
        Animation animation;
        ConstraintLayout constraintLayout2;
        Animation animation2;
        ImageView imageView = this.g;
        if (imageView != null && (animation2 = imageView.getAnimation()) != null) {
            animation2.cancel();
        }
        DialogYyMarriageBinding dialogYyMarriageBinding = this.f17337c;
        if (dialogYyMarriageBinding != null && (constraintLayout2 = dialogYyMarriageBinding.d) != null) {
            constraintLayout2.removeView(this.g);
        }
        ImageView imageView2 = this.f;
        if (imageView2 != null && (animation = imageView2.getAnimation()) != null) {
            animation.cancel();
        }
        DialogYyMarriageBinding dialogYyMarriageBinding2 = this.f17337c;
        if (dialogYyMarriageBinding2 == null || (constraintLayout = dialogYyMarriageBinding2.d) == null) {
            return;
        }
        constraintLayout.removeView(this.f);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dialog_yy_marriage, viewGroup, true);
        Intrinsics.c(inflate, "inflater.inflate(R.layou…arriage, container, true)");
        this.f17337c = DialogYyMarriageBinding.a(inflate);
        f();
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        WindowManager.LayoutParams layoutParams = null;
        Window window = dialog == null ? null : dialog.getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        }
        if (layoutParams != null) {
            layoutParams.dimAmount = 0.0f;
        }
        if (window == null) {
            return;
        }
        window.setAttributes(layoutParams);
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        this.d = (AppInfo.l - DensityUtils.a(getContext(), 191.0f)) / 2;
        g();
    }
}

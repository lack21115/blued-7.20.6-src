package com.blued.android.module.yy_china.view;

import android.animation.Animator;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAPlayer;
import com.blued.android.module.yy_china.model.YYGlobalMsgMarqueeModel;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYVipMarriageNotice$showNotify$2.class */
public final class YYVipMarriageNotice$showNotify$2 implements Animator.AnimatorListener {
    final /* synthetic */ YYVipMarriageNotice a;
    final /* synthetic */ ActivityFragmentActive b;
    final /* synthetic */ ViewGroup c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public YYVipMarriageNotice$showNotify$2(YYVipMarriageNotice yYVipMarriageNotice, ActivityFragmentActive activityFragmentActive, ViewGroup viewGroup) {
        this.a = yYVipMarriageNotice;
        this.b = activityFragmentActive;
        this.c = viewGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ActivityFragmentActive active, YYVipMarriageNotice this$0, ViewGroup attachView) {
        Intrinsics.e(active, "$active");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(attachView, "$attachView");
        if (active.isActive()) {
            this$0.a(attachView);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        YYGlobalMsgMarqueeModel yYGlobalMsgMarqueeModel;
        LogUtils.d("notice", "fly in animation ending ... ");
        yYGlobalMsgMarqueeModel = this.a.c;
        if (yYGlobalMsgMarqueeModel == null) {
            return;
        }
        final ActivityFragmentActive activityFragmentActive = this.b;
        final YYVipMarriageNotice yYVipMarriageNotice = this.a;
        final ViewGroup viewGroup = this.c;
        if (TextUtils.isEmpty(yYGlobalMsgMarqueeModel.after_image)) {
            ImageLoader.c(activityFragmentActive, "couple_heartbeat.png").f().a(yYVipMarriageNotice.getBinding().a);
        } else {
            String str = yYGlobalMsgMarqueeModel.after_image;
            Intrinsics.c(str, "it.after_image");
            Locale locale = Locale.getDefault();
            Intrinsics.c(locale, "getDefault()");
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.c(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (StringsKt.b(lowerCase, "png", false, 2, (Object) null)) {
                ImageLoader.a((IRequestHost) null, yYGlobalMsgMarqueeModel.after_image).g(-1).f().a(yYVipMarriageNotice.getBinding().a);
            } else {
                String str2 = yYGlobalMsgMarqueeModel.after_image;
                Intrinsics.c(str2, "it.after_image");
                SVGAPlayer.Builder builder = new SVGAPlayer.Builder(str2);
                SVGAImageView sVGAImageView = yYVipMarriageNotice.getBinding().a;
                Intrinsics.c(sVGAImageView, "binding.imgAnimationView");
                builder.a(sVGAImageView);
            }
        }
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYVipMarriageNotice$showNotify$2$JQvc014EoQhhTrZ49QTZx-T2Blk
            @Override // java.lang.Runnable
            public final void run() {
                YYVipMarriageNotice$showNotify$2.a(ActivityFragmentActive.this, yYVipMarriageNotice, viewGroup);
            }
        }, yYGlobalMsgMarqueeModel.delay * 1000);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}

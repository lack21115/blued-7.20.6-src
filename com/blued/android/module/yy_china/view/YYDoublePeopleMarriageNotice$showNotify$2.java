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
import com.blued.android.module.yy_china.model.DoublePeopleNoticeImNode;
import com.blued.android.module.yy_china.model.DoublePeopleNoticeInfoNode;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYDoublePeopleMarriageNotice$showNotify$2.class */
public final class YYDoublePeopleMarriageNotice$showNotify$2 implements Animator.AnimatorListener {
    final /* synthetic */ YYDoublePeopleMarriageNotice a;
    final /* synthetic */ ActivityFragmentActive b;
    final /* synthetic */ ViewGroup c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public YYDoublePeopleMarriageNotice$showNotify$2(YYDoublePeopleMarriageNotice yYDoublePeopleMarriageNotice, ActivityFragmentActive activityFragmentActive, ViewGroup viewGroup) {
        this.a = yYDoublePeopleMarriageNotice;
        this.b = activityFragmentActive;
        this.c = viewGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ActivityFragmentActive active, YYDoublePeopleMarriageNotice this$0, ViewGroup attachView) {
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
        DoublePeopleNoticeImNode doublePeopleNoticeImNode;
        DoublePeopleNoticeInfoNode full_server_notification;
        LogUtils.d("notice", "fly in animation ending ... ");
        doublePeopleNoticeImNode = this.a.c;
        if (doublePeopleNoticeImNode == null || (full_server_notification = doublePeopleNoticeImNode.getFull_server_notification()) == null) {
            return;
        }
        final ActivityFragmentActive activityFragmentActive = this.b;
        final YYDoublePeopleMarriageNotice yYDoublePeopleMarriageNotice = this.a;
        final ViewGroup viewGroup = this.c;
        if (TextUtils.isEmpty(full_server_notification.getAfter_image())) {
            ImageLoader.c(activityFragmentActive, "couple_heartbeat.png").f().a(yYDoublePeopleMarriageNotice.getBinding().a);
        } else {
            String after_image = full_server_notification.getAfter_image();
            Locale locale = Locale.getDefault();
            Intrinsics.c(locale, "getDefault()");
            String lowerCase = after_image.toLowerCase(locale);
            Intrinsics.c(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (StringsKt.b(lowerCase, "png", false, 2, (Object) null)) {
                ImageLoader.a((IRequestHost) null, full_server_notification.getAfter_image()).g(-1).f().a(yYDoublePeopleMarriageNotice.getBinding().a);
            } else {
                SVGAPlayer.Builder builder = new SVGAPlayer.Builder(full_server_notification.getAfter_image());
                SVGAImageView sVGAImageView = yYDoublePeopleMarriageNotice.getBinding().a;
                Intrinsics.c(sVGAImageView, "binding.imgAnimationView");
                builder.a(sVGAImageView);
            }
        }
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYDoublePeopleMarriageNotice$showNotify$2$AWWK0ymI13ckFysOE6MRah3EhPw
            @Override // java.lang.Runnable
            public final void run() {
                YYDoublePeopleMarriageNotice$showNotify$2.a(ActivityFragmentActive.this, yYDoublePeopleMarriageNotice, viewGroup);
            }
        }, full_server_notification.getDelay() * 1000);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}

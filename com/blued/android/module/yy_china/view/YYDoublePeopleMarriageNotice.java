package com.blued.android.module.yy_china.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ViewDoublePeopleMarriageNoticeBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.DoublePeopleNoticeImNode;
import com.blued.android.module.yy_china.model.DoublePeopleNoticeInfoNode;
import com.blued.android.module.yy_china.view.YYDoublePeopleMarriageNotice;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYDoublePeopleMarriageNotice.class */
public final class YYDoublePeopleMarriageNotice extends ConstraintLayout {
    private ViewDoublePeopleMarriageNoticeBinding a;
    private AnimatorEndListener b;
    private DoublePeopleNoticeImNode c;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYDoublePeopleMarriageNotice$AnimatorEndListener.class */
    public interface AnimatorEndListener {
        void a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYDoublePeopleMarriageNotice(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYDoublePeopleMarriageNotice(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYDoublePeopleMarriageNotice(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        ViewDoublePeopleMarriageNoticeBinding a = ViewDoublePeopleMarriageNoticeBinding.a(LayoutInflater.from(getContext()), (ViewGroup) this, true);
        Intrinsics.c(a, "inflate(LayoutInflater.from(context), this, true)");
        this.a = a;
        setVisibility(8);
        this.a.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYDoublePeopleMarriageNotice$rfjTUr90KER7LpPPAhRlDtg9WiA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYDoublePeopleMarriageNotice.a(YYDoublePeopleMarriageNotice.this, context, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        LogUtils.d("notice", "hideNotify ... ");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a.f, "translationX", 0.0f, -getWidth());
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.yy_china.view.YYDoublePeopleMarriageNotice$hideNotify$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                YYDoublePeopleMarriageNotice.AnimatorEndListener animatorEndListener;
                LogUtils.d("notice", "hide animation ending ... ");
                ViewGroup.this.removeView((View) this.getBinding().f);
                animatorEndListener = this.b;
                if (animatorEndListener == null) {
                    return;
                }
                animatorEndListener.a();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYDoublePeopleMarriageNotice this$0, Context context, View view) {
        DoublePeopleNoticeInfoNode full_server_notification;
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(context, "$context");
        DoublePeopleNoticeImNode doublePeopleNoticeImNode = this$0.c;
        if (doublePeopleNoticeImNode == null || (full_server_notification = doublePeopleNoticeImNode.getFull_server_notification()) == null) {
            return;
        }
        int type = full_server_notification.getType();
        if (type == 0) {
            if (TextUtils.isEmpty(full_server_notification.getLink())) {
                return;
            }
            LiveEventBus.get("show_inner_dialog").post(full_server_notification.getLink());
        } else if (type != 1) {
            if (type != 2) {
                return;
            }
            LiveEventBus.get("EVENT_SHOW_LOAD_DIALOG").post("YYConfessedListDialog");
        } else if (TextUtils.isEmpty(full_server_notification.getLink())) {
        } else {
            YYRoomInfoManager.e().c().a(context, full_server_notification.getLink(), 9);
        }
    }

    public final void a(ViewGroup attachView, ActivityFragmentActive active) {
        Intrinsics.e(attachView, "attachView");
        Intrinsics.e(active, "active");
        setVisibility(0);
        DoublePeopleNoticeImNode doublePeopleNoticeImNode = this.c;
        if (doublePeopleNoticeImNode != null) {
            getBinding().g.setText(doublePeopleNoticeImNode.getFull_server_notification().getContent());
            ActivityFragmentActive activityFragmentActive = active;
            ImageLoader.a(activityFragmentActive, doublePeopleNoticeImNode.getFull_server_notification().getBackground()).f().g(-1).b(R.drawable.icon_vip_marriage_background).a(getBinding().b);
            if (!StringUtils.b(doublePeopleNoticeImNode.getUid_avatar())) {
                ImageLoader.a(activityFragmentActive, doublePeopleNoticeImNode.getUid_avatar()).c().a((ImageView) getBinding().d);
                getBinding().d.setVisibility(0);
            }
            if (!StringUtils.b(doublePeopleNoticeImNode.getTarget_avatar())) {
                ImageLoader.a(activityFragmentActive, doublePeopleNoticeImNode.getTarget_avatar()).c().a((ImageView) getBinding().e);
                getBinding().e.setVisibility(0);
            }
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a.f, "translationX", getWidth() + AppInfo.l, 0.0f);
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addListener(new YYDoublePeopleMarriageNotice$showNotify$2(this, active, attachView));
        ofFloat.start();
    }

    public final void a(DoublePeopleNoticeImNode notify) {
        Intrinsics.e(notify, "notify");
        this.c = notify;
    }

    public final ViewDoublePeopleMarriageNoticeBinding getBinding() {
        return this.a;
    }

    public final void setAnimatorEndListener(AnimatorEndListener callback) {
        Intrinsics.e(callback, "callback");
        this.b = callback;
    }

    public final void setBinding(ViewDoublePeopleMarriageNoticeBinding viewDoublePeopleMarriageNoticeBinding) {
        Intrinsics.e(viewDoublePeopleMarriageNoticeBinding, "<set-?>");
        this.a = viewDoublePeopleMarriageNoticeBinding;
    }
}

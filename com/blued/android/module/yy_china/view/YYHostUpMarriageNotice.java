package com.blued.android.module.yy_china.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ViewHostUpMarriageNoticeBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYHostUpMode;
import com.blued.android.module.yy_china.model.YYJumpRoomMode;
import com.blued.android.module.yy_china.view.YYVipMarriageNotice;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYHostUpMarriageNotice.class */
public final class YYHostUpMarriageNotice extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewHostUpMarriageNoticeBinding f18248a;
    private YYVipMarriageNotice.AnimatorEndListener b;

    /* renamed from: c  reason: collision with root package name */
    private YYHostUpMode f18249c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYHostUpMarriageNotice(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYHostUpMarriageNotice(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYHostUpMarriageNotice(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        ViewHostUpMarriageNoticeBinding a2 = ViewHostUpMarriageNoticeBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics.c(a2, "inflate(LayoutInflater.from(context), this, true)");
        this.f18248a = a2;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        LogUtils.d("notice", "hideNotify ... ");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f18248a.e, "translationX", 0.0f, -getWidth());
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.yy_china.view.YYHostUpMarriageNotice$hideNotify$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                YYVipMarriageNotice.AnimatorEndListener animatorEndListener;
                LogUtils.d("notice", "hide animation ending ... ");
                ViewGroup.this.removeView(this.getBinding().e);
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
    public static final void a(YYHostUpMarriageNotice this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYHostUpMode yYHostUpMode = this$0.f18249c;
        if (yYHostUpMode == null || YYRoomInfoManager.e().y()) {
            return;
        }
        if ((YYRoomInfoManager.e().b() != null && YYRoomInfoManager.e().b().room_id.equals(yYHostUpMode.getRoomid())) || StringUtils.b(yYHostUpMode.getRoomid()) || StringUtils.a("0", yYHostUpMode.getRoomid())) {
            return;
        }
        LiveEventBus.get("EVENT_JUMP_ROOM").post(new YYJumpRoomMode(yYHostUpMode.getRoomid(), "broadcast"));
    }

    public final void a(ViewGroup attachView, ActivityFragmentActive active) {
        Intrinsics.e(attachView, "attachView");
        Intrinsics.e(active, "active");
        setVisibility(0);
        YYHostUpMode yYHostUpMode = this.f18249c;
        if (yYHostUpMode != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(String.valueOf(yYHostUpMode.getName()));
            spannableStringBuilder.append((CharSequence) "   恭喜 ");
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFF170")), 0, spannableString.length(), 0);
            spannableStringBuilder.append((CharSequence) spannableString);
            spannableStringBuilder.append((CharSequence) "主播等级提升至");
            SpannableString spannableString2 = new SpannableString("LV." + yYHostUpMode.getAnchor_level() + " ！");
            spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#FFF170")), 0, spannableString2.length(), 0);
            spannableStringBuilder.append((CharSequence) spannableString2);
            getBinding().f.setText(spannableStringBuilder);
            ActivityFragmentActive activityFragmentActive = active;
            ImageLoader.a(activityFragmentActive, yYHostUpMode.getBroadcast_background()).f().g(-1).a(getBinding().f16858a);
            ImageLoader.a(activityFragmentActive, yYHostUpMode.getAvatar()).f().b(R.drawable.user_bg_round).c().a(getBinding().d);
            getBinding().e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYHostUpMarriageNotice$ESYWX18xoRCAiYjpyEBBxVr3AJM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYHostUpMarriageNotice.a(YYHostUpMarriageNotice.this, view);
                }
            });
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f18248a.e, "translationX", getWidth() + AppInfo.l, 0.0f);
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addListener(new YYHostUpMarriageNotice$showNotify$2(active, this, attachView));
        ofFloat.start();
    }

    public final void a(YYHostUpMode notify) {
        Intrinsics.e(notify, "notify");
        this.f18249c = notify;
    }

    public final ViewHostUpMarriageNoticeBinding getBinding() {
        return this.f18248a;
    }

    public final void setAnimatorEndListener(YYVipMarriageNotice.AnimatorEndListener callback) {
        Intrinsics.e(callback, "callback");
        this.b = callback;
    }

    public final void setBinding(ViewHostUpMarriageNoticeBinding viewHostUpMarriageNoticeBinding) {
        Intrinsics.e(viewHostUpMarriageNoticeBinding, "<set-?>");
        this.f18248a = viewHostUpMarriageNoticeBinding;
    }
}

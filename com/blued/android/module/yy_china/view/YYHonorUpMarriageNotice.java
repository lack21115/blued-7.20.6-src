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
import com.blued.android.module.yy_china.model.YYJumpRoomMode;
import com.blued.android.module.yy_china.model.YYUpMode;
import com.blued.android.module.yy_china.view.YYVipMarriageNotice;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYHonorUpMarriageNotice.class */
public final class YYHonorUpMarriageNotice extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewHostUpMarriageNoticeBinding f18236a;
    private YYVipMarriageNotice.AnimatorEndListener b;

    /* renamed from: c  reason: collision with root package name */
    private YYUpMode f18237c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYHonorUpMarriageNotice(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYHonorUpMarriageNotice(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYHonorUpMarriageNotice(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        ViewHostUpMarriageNoticeBinding a2 = ViewHostUpMarriageNoticeBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics.c(a2, "inflate(LayoutInflater.from(context), this, true)");
        this.f18236a = a2;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        LogUtils.d("notice", "hideNotify ... ");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f18236a.e, "translationX", 0.0f, -getWidth());
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.yy_china.view.YYHonorUpMarriageNotice$hideNotify$1
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
    public static final void a(YYHonorUpMarriageNotice this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYUpMode yYUpMode = this$0.f18237c;
        if (yYUpMode == null || YYRoomInfoManager.e().y()) {
            return;
        }
        if ((YYRoomInfoManager.e().b() != null && YYRoomInfoManager.e().b().room_id.equals(yYUpMode.getRoom_id())) || StringUtils.b(yYUpMode.getRoom_id()) || StringUtils.a("0", yYUpMode.getRoom_id())) {
            return;
        }
        LiveEventBus.get("EVENT_JUMP_ROOM").post(new YYJumpRoomMode(yYUpMode.getRoom_id(), "broadcast"));
    }

    public final void a(ViewGroup attachView, ActivityFragmentActive active) {
        Intrinsics.e(attachView, "attachView");
        Intrinsics.e(active, "active");
        setVisibility(0);
        YYUpMode yYUpMode = this.f18237c;
        if (yYUpMode != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(String.valueOf(yYUpMode.getName()));
            spannableStringBuilder.append((CharSequence) "   恭喜 ");
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFF170")), 0, spannableString.length(), 0);
            spannableStringBuilder.append((CharSequence) spannableString);
            spannableStringBuilder.append((CharSequence) "荣誉等级提升至");
            SpannableString spannableString2 = new SpannableString("LV." + yYUpMode.getLevel() + " ！");
            spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#FFF170")), 0, spannableString2.length(), 0);
            spannableStringBuilder.append((CharSequence) spannableString2);
            getBinding().f.setText(spannableStringBuilder);
            ActivityFragmentActive activityFragmentActive = active;
            ImageLoader.a(activityFragmentActive, yYUpMode.getBroadcast_background()).f().g(-1).a(getBinding().f16858a);
            ImageLoader.a(activityFragmentActive, yYUpMode.getAvatar()).f().b(R.drawable.user_bg_round).c().a(getBinding().d);
            getBinding().e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYHonorUpMarriageNotice$tHbGqs5IEPXORLqfPa7E4MvXcGg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYHonorUpMarriageNotice.a(YYHonorUpMarriageNotice.this, view);
                }
            });
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f18236a.e, "translationX", getWidth() + AppInfo.l, 0.0f);
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addListener(new YYHonorUpMarriageNotice$showNotify$2(active, this, attachView));
        ofFloat.start();
    }

    public final void a(YYUpMode notify) {
        Intrinsics.e(notify, "notify");
        this.f18237c = notify;
    }

    public final ViewHostUpMarriageNoticeBinding getBinding() {
        return this.f18236a;
    }

    public final void setAnimatorEndListener(YYVipMarriageNotice.AnimatorEndListener callback) {
        Intrinsics.e(callback, "callback");
        this.b = callback;
    }

    public final void setBinding(ViewHostUpMarriageNoticeBinding viewHostUpMarriageNoticeBinding) {
        Intrinsics.e(viewHostUpMarriageNoticeBinding, "<set-?>");
        this.f18236a = viewHostUpMarriageNoticeBinding;
    }
}

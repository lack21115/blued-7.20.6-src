package com.blued.android.module.yy_china.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
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
import com.blued.android.module.yy_china.databinding.ViewVipMarriageNoticeBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYGlobalMsgMarqueeModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYVipMarriageNotice;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYVipMarriageNotice.class */
public final class YYVipMarriageNotice extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewVipMarriageNoticeBinding f18550a;
    private AnimatorEndListener b;

    /* renamed from: c  reason: collision with root package name */
    private YYGlobalMsgMarqueeModel f18551c;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYVipMarriageNotice$AnimatorEndListener.class */
    public interface AnimatorEndListener {
        void a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYVipMarriageNotice(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYVipMarriageNotice(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYVipMarriageNotice(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        ViewVipMarriageNoticeBinding a2 = ViewVipMarriageNoticeBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics.c(a2, "inflate(LayoutInflater.from(context), this, true)");
        this.f18550a = a2;
        setVisibility(8);
        this.f18550a.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYVipMarriageNotice$DVahot-CXDVG5XzHaanxj01ZkFw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYVipMarriageNotice.a(YYVipMarriageNotice.this, context, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        LogUtils.d("notice", "hideNotify ... ");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f18550a.e, "translationX", 0.0f, -getWidth());
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.yy_china.view.YYVipMarriageNotice$hideNotify$1
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
    public static final void a(YYVipMarriageNotice this$0, Context context, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(context, "$context");
        YYGlobalMsgMarqueeModel yYGlobalMsgMarqueeModel = this$0.f18551c;
        if (yYGlobalMsgMarqueeModel == null || TextUtils.isEmpty(yYGlobalMsgMarqueeModel.link)) {
            return;
        }
        int i = yYGlobalMsgMarqueeModel.action_type;
        if (i == 0) {
            Uri parse = Uri.parse(yYGlobalMsgMarqueeModel.link);
            String queryParameter = parse.getQueryParameter(TTLiveConstants.ROOMID_KEY);
            LogUtils.d(Intrinsics.a("加成时刻：roomId:", (Object) queryParameter));
            String queryParameter2 = parse.getQueryParameter("redirect_url");
            LogUtils.d(Intrinsics.a("加成时刻：redirect_url：", (Object) queryParameter2));
            String str = queryParameter;
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (!TextUtils.equals(str, b == null ? null : b.room_id) || TextUtils.isEmpty(queryParameter2)) {
                YYRoomInfoManager.e().c().a(context, yYGlobalMsgMarqueeModel.link, 9);
            } else {
                LiveEventBus.get("show_inner_dialog").post(queryParameter2);
            }
        } else if (i == 1) {
            LiveEventBus.get("show_inner_dialog").post(yYGlobalMsgMarqueeModel.link);
        } else if (i == 100) {
            LiveEventBus.get("EVENT_SHOW_LOAD_DIALOG").post(yYGlobalMsgMarqueeModel.link);
        }
        YYRoomModel b2 = YYRoomInfoManager.e().b();
        if (b2 == null) {
            return;
        }
        EventTrackYY.h(ChatRoomProtos.Event.YY_BROADCAST_CLICK, b2.room_id, b2.uid, yYGlobalMsgMarqueeModel.source_type, yYGlobalMsgMarqueeModel.content);
    }

    public final void a(ViewGroup attachView, ActivityFragmentActive active) {
        Intrinsics.e(attachView, "attachView");
        Intrinsics.e(active, "active");
        setVisibility(0);
        YYGlobalMsgMarqueeModel yYGlobalMsgMarqueeModel = this.f18551c;
        if (yYGlobalMsgMarqueeModel != null) {
            getBinding().f.setText(yYGlobalMsgMarqueeModel.content);
            ActivityFragmentActive activityFragmentActive = active;
            ImageLoader.a(activityFragmentActive, yYGlobalMsgMarqueeModel.background).f().g(-1).b(R.drawable.icon_vip_marriage_background).a(getBinding().b);
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b != null) {
                EventTrackYY.h(ChatRoomProtos.Event.YY_BROADCAST_SHOW, b.room_id, b.uid, yYGlobalMsgMarqueeModel.source_type, yYGlobalMsgMarqueeModel.content);
            }
            if (!StringUtils.b(yYGlobalMsgMarqueeModel.user_avatar)) {
                ImageLoader.a(activityFragmentActive, yYGlobalMsgMarqueeModel.user_avatar).c().a(getBinding().d);
                getBinding().d.setVisibility(0);
            }
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f18550a.e, "translationX", getWidth() + AppInfo.l, 0.0f);
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addListener(new YYVipMarriageNotice$showNotify$2(this, active, attachView));
        ofFloat.start();
    }

    public final void a(YYGlobalMsgMarqueeModel notify) {
        Intrinsics.e(notify, "notify");
        this.f18551c = notify;
    }

    public final ViewVipMarriageNoticeBinding getBinding() {
        return this.f18550a;
    }

    public final void setAnimatorEndListener(AnimatorEndListener callback) {
        Intrinsics.e(callback, "callback");
        this.b = callback;
    }

    public final void setBinding(ViewVipMarriageNoticeBinding viewVipMarriageNoticeBinding) {
        Intrinsics.e(viewVipMarriageNoticeBinding, "<set-?>");
        this.f18550a = viewVipMarriageNoticeBinding;
    }
}

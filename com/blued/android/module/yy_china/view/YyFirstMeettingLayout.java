package com.blued.android.module.yy_china.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.yy_china.databinding.ItemYyFirstMeetBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYFirstMeetMessMode;
import com.blued.android.module.yy_china.model.YYFirstMeetMode;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YyFirstMeettingLayout.class */
public class YyFirstMeettingLayout extends RelativeLayout {
    private static int e = 500;
    private static int f = 2900;
    private static int g = 500;

    /* renamed from: a  reason: collision with root package name */
    private ItemYyFirstMeetBinding f18601a;
    private KeyBoardFragment b;

    /* renamed from: c  reason: collision with root package name */
    private YYFirstMeetMode f18602c;
    private boolean d;

    public YyFirstMeettingLayout(Context context) {
        this(context, null);
    }

    public YyFirstMeettingLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YyFirstMeettingLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = false;
        this.f18601a = ItemYyFirstMeetBinding.a(LayoutInflater.from(context), this, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(YYFirstMeetMode yYFirstMeetMode, View view) {
        if (this.b == null || ClickUtils.a(view.getId(), 2000L)) {
            return;
        }
        YYFirstMeetDialog yYFirstMeetDialog = new YYFirstMeetDialog();
        yYFirstMeetDialog.a(yYFirstMeetMode);
        yYFirstMeetDialog.show(this.b.getFragmentManager(), "YYFirstMeetDialog");
        a();
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            EventTrackYY.d(ChatRoomProtos.Event.YY_DING_TOAST_CLICK, b.room_id, b.uid);
        }
    }

    public AnimatorSet a(float f2) {
        this.f18601a.f16713a.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(getResources().getDisplayMetrics().widthPixels, DensityUtils.a(getContext(), 20.0f));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.yy_china.view.YyFirstMeettingLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (YyFirstMeettingLayout.this.d) {
                    return;
                }
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) YyFirstMeettingLayout.this.f18601a.f16713a.getLayoutParams();
                layoutParams.leftMargin = (int) floatValue;
                YyFirstMeettingLayout.this.f18601a.f16713a.setLayoutParams(layoutParams);
            }
        });
        ofFloat.setDuration(e);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(DensityUtils.a(getContext(), 20.0f), DensityUtils.a(getContext(), 5.0f));
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.yy_china.view.YyFirstMeettingLayout.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (YyFirstMeettingLayout.this.d) {
                    return;
                }
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) YyFirstMeettingLayout.this.f18601a.f16713a.getLayoutParams();
                layoutParams.leftMargin = (int) floatValue;
                YyFirstMeettingLayout.this.f18601a.f16713a.setLayoutParams(layoutParams);
            }
        });
        ofFloat2.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.yy_china.view.YyFirstMeettingLayout.4
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
        ofFloat2.setDuration(f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ofFloat);
        arrayList.add(ofFloat2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(arrayList);
        return animatorSet;
    }

    public void a() {
        if (((LinearLayout.LayoutParams) this.f18601a.f16713a.getLayoutParams()).leftMargin < 0) {
            return;
        }
        this.d = true;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(DensityUtils.a(getContext(), 5.0f), -this.f18601a.f16713a.getMeasuredWidth());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.yy_china.view.YyFirstMeettingLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) YyFirstMeettingLayout.this.f18601a.f16713a.getLayoutParams();
                layoutParams.leftMargin = (int) floatValue;
                YyFirstMeettingLayout.this.f18601a.f16713a.setLayoutParams(layoutParams);
            }
        });
        ofFloat.setDuration(g);
        ofFloat.start();
    }

    public void a(KeyBoardFragment keyBoardFragment) {
        this.b = keyBoardFragment;
    }

    public void a(final YYFirstMeetMode yYFirstMeetMode) {
        if (yYFirstMeetMode != null && this.b != null) {
            a(this.f18601a.f16713a.getMeasuredWidth()).start();
        }
        this.f18602c = yYFirstMeetMode;
        LiveEventBus.get("show_frist_meet").postDelay(new YYFirstMeetMessMode(1, this.f18602c), yYFirstMeetMode.getDuration() * 1000);
        setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YyFirstMeettingLayout$H5uMUjgTUQBlQ4nWu9ZvwmN0GLw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YyFirstMeettingLayout.this.a(yYFirstMeetMode, view);
            }
        });
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            EventTrackYY.d(ChatRoomProtos.Event.YY_DING_TOAST_SHOW, b.room_id, b.uid);
        }
    }
}

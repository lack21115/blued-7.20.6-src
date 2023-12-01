package com.blued.android.module.live_china.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import com.blued.android.module.live_china.databinding.LayoutOnlineUserTipsBinding;
import com.blued.android.module.live_china.fragment.LiveOnlineUserDialogFragment;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveOnlineUserTipsView.class */
public final class LiveOnlineUserTipsView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy f14689a;
    private CountDownTimer b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveOnlineUserTipsView(Context context) {
        super(context);
        Intrinsics.e(context, "context");
        this.f14689a = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<LayoutOnlineUserTipsBinding>() { // from class: com.blued.android.module.live_china.view.LiveOnlineUserTipsView$binding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LayoutOnlineUserTipsBinding invoke() {
                LayoutOnlineUserTipsBinding a2 = LayoutOnlineUserTipsBinding.a(LayoutInflater.from(LiveOnlineUserTipsView.this.getContext()), LiveOnlineUserTipsView.this, true);
                Intrinsics.c(a2, "inflate(LayoutInflater.from(context), this, true)");
                return a2;
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveOnlineUserTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.e(context, "context");
        this.f14689a = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<LayoutOnlineUserTipsBinding>() { // from class: com.blued.android.module.live_china.view.LiveOnlineUserTipsView$binding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LayoutOnlineUserTipsBinding invoke() {
                LayoutOnlineUserTipsBinding a2 = LayoutOnlineUserTipsBinding.a(LayoutInflater.from(LiveOnlineUserTipsView.this.getContext()), LiveOnlineUserTipsView.this, true);
                Intrinsics.c(a2, "inflate(LayoutInflater.from(context), this, true)");
                return a2;
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveOnlineUserTipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.f14689a = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<LayoutOnlineUserTipsBinding>() { // from class: com.blued.android.module.live_china.view.LiveOnlineUserTipsView$binding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LayoutOnlineUserTipsBinding invoke() {
                LayoutOnlineUserTipsBinding a2 = LayoutOnlineUserTipsBinding.a(LayoutInflater.from(LiveOnlineUserTipsView.this.getContext()), LiveOnlineUserTipsView.this, true);
                Intrinsics.c(a2, "inflate(LayoutInflater.from(context), this, true)");
                return a2;
            }
        });
    }

    private final void a(int i) {
        CountDownTimer countDownTimer = this.b;
        if (countDownTimer != null) {
            Intrinsics.a(countDownTimer);
            countDownTimer.cancel();
        }
        final long j = i * 1000;
        CountDownTimer countDownTimer2 = new CountDownTimer(j, this) { // from class: com.blued.android.module.live_china.view.LiveOnlineUserTipsView$startCountDownGoneView$1

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ long f14691a;
            final /* synthetic */ LiveOnlineUserTipsView b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(j, 1000L);
                this.f14691a = j;
                this.b = this;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                ConstraintLayout root = this.b.getBinding().getRoot();
                Intrinsics.c(root, "binding.root");
                BluedViewExKt.a(root);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
            }
        };
        this.b = countDownTimer2;
        if (countDownTimer2 == null) {
            return;
        }
        countDownTimer2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FragmentManager fragmentManager, LiveOnlineUserTipsView this$0, View view) {
        Intrinsics.e(fragmentManager, "$fragmentManager");
        Intrinsics.e(this$0, "this$0");
        LiveOnlineUserDialogFragment.f13080a.a(fragmentManager);
        ConstraintLayout root = this$0.getBinding().getRoot();
        Intrinsics.c(root, "binding.root");
        BluedViewExKt.a(root);
    }

    public final void a(int i, String type, final FragmentManager fragmentManager) {
        Intrinsics.e(type, "type");
        Intrinsics.e(fragmentManager, "fragmentManager");
        if (LiveRoomPreferences.C(type)) {
            ConstraintLayout root = getBinding().getRoot();
            Intrinsics.c(root, "binding.root");
            BluedViewExKt.b(root);
            LiveRoomPreferences.a(false, type);
            a(i);
        }
        getBinding().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveOnlineUserTipsView$JvQz1A7DSnh4WqBXltte16Xdeic
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveOnlineUserTipsView.a(FragmentManager.this, this, view);
            }
        });
    }

    public final LayoutOnlineUserTipsBinding getBinding() {
        return (LayoutOnlineUserTipsBinding) this.f14689a.getValue();
    }
}

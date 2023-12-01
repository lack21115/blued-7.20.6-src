package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.module.yy_china.databinding.ViewTakeOffMaskTimerBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/TakeOffMaskTimerView.class */
public final class TakeOffMaskTimerView extends ConstraintLayout {
    private final ViewTakeOffMaskTimerBinding a;
    private ViewGroup b;
    private String c;
    private CountDownTimer d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TakeOffMaskTimerView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TakeOffMaskTimerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TakeOffMaskTimerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        ViewTakeOffMaskTimerBinding a = ViewTakeOffMaskTimerBinding.a(LayoutInflater.from(getContext()), (ViewGroup) this, true);
        Intrinsics.c(a, "inflate(LayoutInflater.from(context), this, true)");
        this.a = a;
        this.c = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        ViewGroup viewGroup = this.b;
        if (viewGroup == null) {
            return;
        }
        viewGroup.removeView((View) this);
    }

    public final void a(ViewGroup parentView, final String userId, long j) {
        Intrinsics.e(parentView, "parentView");
        Intrinsics.e(userId, "userId");
        this.b = parentView;
        if (!TextUtils.isEmpty(userId)) {
            this.c = userId;
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            b.putTimerMaskedUsers(userId);
        }
        long j2 = j < 1000 ? 1000 * j : j;
        TextView textView = this.a.a;
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        sb.append('s');
        textView.setText(sb.toString());
        final long j3 = j2;
        CountDownTimer countDownTimer = new CountDownTimer(j3, this, userId) { // from class: com.blued.android.module.yy_china.view.TakeOffMaskTimerView$bindParentView$1
            final /* synthetic */ long a;
            final /* synthetic */ TakeOffMaskTimerView b;
            final /* synthetic */ String c;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(j3, 1000L);
                this.a = j3;
                this.b = this;
                this.c = userId;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                String str;
                YYRoomModel b2 = YYRoomInfoManager.e().b();
                if (b2 != null) {
                    b2.removeTimerMaskedUser(this.c);
                }
                Observable observable = LiveEventBus.get("take_off_mask");
                str = this.b.c;
                observable.post(str);
                this.b.a();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j4) {
                ViewTakeOffMaskTimerBinding viewTakeOffMaskTimerBinding;
                viewTakeOffMaskTimerBinding = this.b.a;
                TextView textView2 = viewTakeOffMaskTimerBinding.a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(j4 / 1000);
                sb2.append('s');
                textView2.setText(sb2.toString());
            }
        };
        this.d = countDownTimer;
        if (countDownTimer == null) {
            return;
        }
        countDownTimer.start();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CountDownTimer countDownTimer = this.d;
        if (countDownTimer == null) {
            return;
        }
        countDownTimer.cancel();
    }
}

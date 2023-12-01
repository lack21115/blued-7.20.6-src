package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
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

    /* renamed from: a  reason: collision with root package name */
    private final ViewTakeOffMaskTimerBinding f18008a;
    private ViewGroup b;

    /* renamed from: c  reason: collision with root package name */
    private String f18009c;
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
        ViewTakeOffMaskTimerBinding a2 = ViewTakeOffMaskTimerBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics.c(a2, "inflate(LayoutInflater.from(context), this, true)");
        this.f18008a = a2;
        this.f18009c = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        ViewGroup viewGroup = this.b;
        if (viewGroup == null) {
            return;
        }
        viewGroup.removeView(this);
    }

    public final void a(ViewGroup parentView, final String userId, long j) {
        Intrinsics.e(parentView, "parentView");
        Intrinsics.e(userId, "userId");
        this.b = parentView;
        if (!TextUtils.isEmpty(userId)) {
            this.f18009c = userId;
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            b.putTimerMaskedUsers(userId);
        }
        long j2 = j < 1000 ? 1000 * j : j;
        TextView textView = this.f18008a.f16880a;
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        sb.append('s');
        textView.setText(sb.toString());
        final long j3 = j2;
        CountDownTimer countDownTimer = new CountDownTimer(j3, this, userId) { // from class: com.blued.android.module.yy_china.view.TakeOffMaskTimerView$bindParentView$1

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ long f18010a;
            final /* synthetic */ TakeOffMaskTimerView b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f18011c;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(j3, 1000L);
                this.f18010a = j3;
                this.b = this;
                this.f18011c = userId;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                String str;
                YYRoomModel b2 = YYRoomInfoManager.e().b();
                if (b2 != null) {
                    b2.removeTimerMaskedUser(this.f18011c);
                }
                Observable<Object> observable = LiveEventBus.get("take_off_mask");
                str = this.b.f18009c;
                observable.post(str);
                this.b.a();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j4) {
                ViewTakeOffMaskTimerBinding viewTakeOffMaskTimerBinding;
                viewTakeOffMaskTimerBinding = this.b.f18008a;
                TextView textView2 = viewTakeOffMaskTimerBinding.f16880a;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CountDownTimer countDownTimer = this.d;
        if (countDownTimer == null) {
            return;
        }
        countDownTimer.cancel();
    }
}

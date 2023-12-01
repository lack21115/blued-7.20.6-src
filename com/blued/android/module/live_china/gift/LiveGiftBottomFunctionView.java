package com.blued.android.module.live_china.gift;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.IncludeLiveGiftBottomFuntionBinding;
import com.blued.android.module.live_china.view.BluedViewExKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/gift/LiveGiftBottomFunctionView.class */
public final class LiveGiftBottomFunctionView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy f13467a;
    private BaseFragment b;

    /* renamed from: c  reason: collision with root package name */
    private final String f13468c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveGiftBottomFunctionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveGiftBottomFunctionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.f13467a = LazyKt.a(new Function0<IncludeLiveGiftBottomFuntionBinding>() { // from class: com.blued.android.module.live_china.gift.LiveGiftBottomFunctionView$binding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final IncludeLiveGiftBottomFuntionBinding invoke() {
                return IncludeLiveGiftBottomFuntionBinding.a(LayoutInflater.from(LiveGiftBottomFunctionView.this.getContext()), LiveGiftBottomFunctionView.this, true);
            }
        });
        String string = getContext().getString(R.string.Live_SendPresent_recharge);
        Intrinsics.c(string, "context.getString(R.stri…ive_SendPresent_recharge)");
        this.f13468c = string;
    }

    public final IncludeLiveGiftBottomFuntionBinding getBinding() {
        return (IncludeLiveGiftBottomFuntionBinding) this.f13467a.getValue();
    }

    public final BaseFragment getMFragment() {
        return this.b;
    }

    public final String getStrFirstChargeTips() {
        return this.f13468c;
    }

    public final void setGivePrice(String givePrice) {
        TextView textView;
        Intrinsics.e(givePrice, "givePrice");
        IncludeLiveGiftBottomFuntionBinding binding = getBinding();
        if (binding != null && (textView = binding.f) != null) {
            BluedViewExKt.b(textView);
        }
        IncludeLiveGiftBottomFuntionBinding binding2 = getBinding();
        TextView textView2 = binding2 == null ? null : binding2.f;
        if (textView2 == null) {
            return;
        }
        textView2.setText(givePrice);
    }

    public final void setMFragment(BaseFragment baseFragment) {
        this.b = baseFragment;
    }

    public final void setPrice(String price) {
        Intrinsics.e(price, "price");
        IncludeLiveGiftBottomFuntionBinding binding = getBinding();
        TextView textView = binding == null ? null : binding.i;
        if (textView == null) {
            return;
        }
        textView.setText(price);
    }
}

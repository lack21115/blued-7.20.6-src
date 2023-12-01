package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ViewYyMemberEntertainmentBinding;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.view.YYBaseUserHeadView;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYMemberEntertainmentView.class */
public final class YYMemberEntertainmentView extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewYyMemberEntertainmentBinding f18315a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f18316c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYMemberEntertainmentView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYMemberEntertainmentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYMemberEntertainmentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        ViewYyMemberEntertainmentBinding a2 = ViewYyMemberEntertainmentBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics.c(a2, "inflate(LayoutInflater.from(context), this, true)");
        this.f18315a = a2;
        this.b = DensityUtils.a(getContext(), 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYMemberEntertainmentView this$0, ConstraintLayout.LayoutParams params) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(params, "$params");
        this$0.f18316c = this$0.f18315a.f16928a.getHeight();
        this$0.setLlNormalNumberMargin(params);
    }

    private final boolean a(YYSeatMemberModel yYSeatMemberModel) {
        boolean z = false;
        if (StringUtils.a(yYSeatMemberModel.getUid(), 0) > 0) {
            z = true;
        }
        return z;
    }

    private final void setLlNormalNumberMargin(ConstraintLayout.LayoutParams layoutParams) {
        layoutParams.topMargin = this.f18316c;
    }

    public final void a(IRequestHost iRequestHost, String str, String str2, YYImModel yYImModel) {
        this.f18315a.f16928a.a(iRequestHost, str, str2, yYImModel);
    }

    public final void a(YYSeatMemberModel member, IRequestHost iRequestHost) {
        Intrinsics.e(member, "member");
        this.f18315a.f16928a.a(member, iRequestHost);
        if (this.f18316c <= 0) {
            this.f18316c = this.f18315a.f16928a.getHeight();
        }
        ViewGroup.LayoutParams layoutParams = this.f18315a.b.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        final ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        if (this.f18316c <= 0) {
            this.f18315a.f16928a.post(new Runnable() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYMemberEntertainmentView$q0e6U9hg2kW_Vy-bgzVdn42-4-g
                @Override // java.lang.Runnable
                public final void run() {
                    YYMemberEntertainmentView.a(YYMemberEntertainmentView.this, layoutParams2);
                }
            });
        } else {
            setLlNormalNumberMargin(layoutParams2);
        }
        this.f18315a.d.setVisibility(0);
        int i = member.mic_position;
        if (i == 0) {
            this.f18315a.d.setText(a(member) ? "主持" : "主持位");
            this.f18315a.d.setBackgroundResource(R.drawable.shape_raduis_2dp_b3000000);
            this.f18315a.e.setMaxWidth(getResources().getDimensionPixelOffset(R.dimen.dp_105));
        } else if (i != 8) {
            TextView textView = this.f18315a.d;
            textView.setText(member.mic_position + "");
            this.f18315a.d.setBackgroundResource(R.drawable.shape_raduis_2dp_b3000000);
        } else {
            if (TextUtils.isEmpty(member.getName())) {
                this.f18315a.d.setText("贵宾位");
            } else {
                this.f18315a.d.setText("贵宾");
            }
            this.f18315a.d.setBackgroundResource(R.drawable.shape_raduis_3dp_ff8861_ffcc2a);
            this.f18315a.f16928a.a(R.color.syc_FF8861, R.color.syc_FFCC2A);
        }
        if (!TextUtils.isEmpty(member.getName())) {
            this.f18315a.e.setText(member.getName());
            return;
        }
        this.f18315a.e.setText((member.mic_position == 0 || member.mic_position == 8) ? "" : "号麦位");
        this.f18315a.f16929c.setText("0");
    }

    public final void a(YYBaseUserHeadView.GetViewX_Y_W_H getViewX_Y_W_H) {
        this.f18315a.f16928a.a(getViewX_Y_W_H);
    }

    public final void a(String beans, boolean z) {
        Intrinsics.e(beans, "beans");
        this.f18315a.f16929c.setVisibility(z ? 0 : 8);
        this.f18315a.f16929c.setText(beans);
    }

    public final void a(Set<String> set, YYSeatMemberModel yYSeatMemberModel) {
        this.f18315a.f16928a.a(set, yYSeatMemberModel);
    }

    public final ViewYyMemberEntertainmentBinding getBinding() {
        return this.f18315a;
    }

    public final void setBinding(ViewYyMemberEntertainmentBinding viewYyMemberEntertainmentBinding) {
        Intrinsics.e(viewYyMemberEntertainmentBinding, "<set-?>");
        this.f18315a = viewYyMemberEntertainmentBinding;
    }
}

package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ViewYyFansLevelBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYFansLevelView.class */
public final class YYFansLevelView extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewYyFansLevelBinding f18146a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYFansLevelView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYFansLevelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYFansLevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        ViewYyFansLevelBinding a2 = ViewYyFansLevelBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics.c(a2, "inflate(LayoutInflater.from(context), this, true)");
        this.f18146a = a2;
    }

    private final int a(int i) {
        return i <= 10 ? R.drawable.icon_yy_fans_less_10 : i <= 20 ? R.drawable.icon_yy_fans_less_20 : R.drawable.icon_yy_fans_less_30;
    }

    private final void a() {
        this.f18146a.f16909c.setTextColor(getContext().getResources().getColor(R.color.syc_dark_777777));
        this.f18146a.b.setImageResource(R.drawable.icon_yy_fans_unavailable);
        this.f18146a.f16908a.setImageResource(R.drawable.icon_yy_fans_heart_unavailable);
    }

    private final int b(int i) {
        return i <= 10 ? R.drawable.icon_yy_fans_heart_10 : i <= 20 ? R.drawable.icon_yy_fans_heart_20 : R.drawable.icon_yy_fans_heart_30;
    }

    private final int c(int i) {
        return i <= 10 ? R.color.syc_00AEE5 : i <= 20 ? R.color.syc_2979F7 : R.color.syc_F7295B;
    }

    public final void a(String str, String str2, boolean z) {
        String str3 = str2;
        this.f18146a.f16909c.setText(str3);
        this.f18146a.d.setText(String.valueOf(str));
        int a2 = StringUtils.a(str, 0);
        if (z) {
            this.f18146a.f16909c.setTextColor(getContext().getResources().getColor(c(StringUtils.a(str, 0))));
            this.f18146a.b.setImageResource(a(a2));
            this.f18146a.f16908a.setImageResource(b(a2));
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            setVisibility(8);
        } else {
            a();
        }
    }

    public final ViewYyFansLevelBinding getBinding() {
        return this.f18146a;
    }

    public final void setBinding(ViewYyFansLevelBinding viewYyFansLevelBinding) {
        Intrinsics.e(viewYyFansLevelBinding, "<set-?>");
        this.f18146a = viewYyFansLevelBinding;
    }
}

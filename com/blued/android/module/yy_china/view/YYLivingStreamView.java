package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.yy_china.databinding.ViewLivingStreamLayoutBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYLivingStreamView.class */
public final class YYLivingStreamView extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    private final ViewLivingStreamLayoutBinding f18293a;
    private IRequestHost b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYLivingStreamView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYLivingStreamView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYLivingStreamView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        ViewLivingStreamLayoutBinding a2 = ViewLivingStreamLayoutBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics.c(a2, "inflate(LayoutInflater.from(context), this, true)");
        this.f18293a = a2;
    }

    public final void a(IRequestHost active) {
        Intrinsics.e(active, "active");
        this.b = active;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            ImageLoader.c(this.b, "home_small_white.png").g().g(-1).a(this.f18293a.b);
        }
    }
}

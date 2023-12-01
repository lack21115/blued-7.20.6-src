package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveConstellationHonourKingViewBinding;
import com.blued.android.module.live_china.model.GiftConstellationHonourTopModel;
import com.blued.android.module.live_china.utils.LiveCloakingUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveConstellationHonourKingView.class */
public final class LiveConstellationHonourKingView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy f14430a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveConstellationHonourKingView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveConstellationHonourKingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveConstellationHonourKingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.f14430a = LazyKt.a(new Function0<LiveConstellationHonourKingViewBinding>() { // from class: com.blued.android.module.live_china.view.LiveConstellationHonourKingView$binding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LiveConstellationHonourKingViewBinding invoke() {
                LiveConstellationHonourKingViewBinding a2 = LiveConstellationHonourKingViewBinding.a(LayoutInflater.from(LiveConstellationHonourKingView.this.getContext()), LiveConstellationHonourKingView.this, true);
                Intrinsics.c(a2, "inflate(LayoutInflater.from(context), this, true)");
                return a2;
            }
        });
        a();
    }

    public final void a() {
    }

    public final void a(boolean z) {
        View view;
        int i;
        if (z) {
            view = getBinding().e;
            i = 8;
        } else {
            view = getBinding().e;
            i = 0;
        }
        view.setVisibility(i);
    }

    public final LiveConstellationHonourKingViewBinding getBinding() {
        return (LiveConstellationHonourKingViewBinding) this.f14430a.getValue();
    }

    public final void setData(GiftConstellationHonourTopModel topModel) {
        Intrinsics.e(topModel, "topModel");
        getBinding().h.setText(topModel.getHall_name());
        getBinding().g.setText(topModel.getAnchor_name());
        ImageLoader.a((IRequestHost) null, topModel.getAnchor_avatar()).b(R.drawable.user_bg_round).c().a(getBinding().f12169a);
        TextView textView = getBinding().i;
        String name = topModel.getName();
        boolean z = true;
        if (topModel.is_hide() != 1) {
            z = false;
        }
        textView.setText(LiveCloakingUtil.a(name, z));
        ImageLoader.a((IRequestHost) null, topModel.getAvatar()).b(R.drawable.user_bg_round).c().a(getBinding().f12170c);
    }
}

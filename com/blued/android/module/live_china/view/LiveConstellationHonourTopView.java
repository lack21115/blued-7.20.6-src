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
import com.blued.android.module.live_china.databinding.LiveConstellationHonourTopViewBinding;
import com.blued.android.module.live_china.model.GiftConstellationHonourTopModel;
import com.blued.android.module.live_china.utils.LiveCloakingUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveConstellationHonourTopView.class */
public final class LiveConstellationHonourTopView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy f14434a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveConstellationHonourTopView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveConstellationHonourTopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveConstellationHonourTopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.f14434a = LazyKt.a(new Function0<LiveConstellationHonourTopViewBinding>() { // from class: com.blued.android.module.live_china.view.LiveConstellationHonourTopView$binding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LiveConstellationHonourTopViewBinding invoke() {
                LiveConstellationHonourTopViewBinding a2 = LiveConstellationHonourTopViewBinding.a(LayoutInflater.from(LiveConstellationHonourTopView.this.getContext()), LiveConstellationHonourTopView.this, true);
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

    public final LiveConstellationHonourTopViewBinding getBinding() {
        return (LiveConstellationHonourTopViewBinding) this.f14434a.getValue();
    }

    public final void setData(GiftConstellationHonourTopModel topModel) {
        Intrinsics.e(topModel, "topModel");
        getBinding().k.setText(topModel.getHall_name());
        getBinding().h.setText(topModel.getAnchor_name());
        ImageLoader.a((IRequestHost) null, topModel.getAnchor_avatar()).b(R.drawable.user_bg_round).c().a(getBinding().f12173a);
        TextView textView = getBinding().l;
        String name = topModel.getName();
        boolean z = true;
        if (topModel.is_hide() != 1) {
            z = false;
        }
        textView.setText(LiveCloakingUtil.a(name, z));
        ImageLoader.a((IRequestHost) null, topModel.getAvatar()).b(R.drawable.user_bg_round).c().a(getBinding().f12174c);
        getBinding().f.setVisibility(8);
        if (topModel.getCount() > 0) {
            getBinding().f.setVisibility(0);
            getBinding().j.setText(topModel.getCount() + "个 ");
            getBinding().i.setText("登顶礼物登上" + topModel.getConstellation_name() + "之巅");
        }
    }
}

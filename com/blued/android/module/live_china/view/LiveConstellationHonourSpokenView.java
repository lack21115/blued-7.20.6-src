package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveConstellationHonourSpokenViewBinding;
import com.blued.android.module.live_china.model.GiftConstellationHonourSpokenModel;
import com.blued.android.module.live_china.utils.LiveCloakingUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveConstellationHonourSpokenView.class */
public final class LiveConstellationHonourSpokenView extends FrameLayout {
    private final Lazy a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveConstellationHonourSpokenView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveConstellationHonourSpokenView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveConstellationHonourSpokenView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.a = LazyKt.a(new Function0<LiveConstellationHonourSpokenViewBinding>() { // from class: com.blued.android.module.live_china.view.LiveConstellationHonourSpokenView$binding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LiveConstellationHonourSpokenViewBinding invoke() {
                LiveConstellationHonourSpokenViewBinding a = LiveConstellationHonourSpokenViewBinding.a(LayoutInflater.from(LiveConstellationHonourSpokenView.this.getContext()), LiveConstellationHonourSpokenView.this, true);
                Intrinsics.c(a, "inflate(LayoutInflater.from(context), this, true)");
                return a;
            }
        });
        a();
    }

    public final void a() {
    }

    public final void b() {
        getBinding().e.setVisibility(8);
    }

    public final LiveConstellationHonourSpokenViewBinding getBinding() {
        return (LiveConstellationHonourSpokenViewBinding) this.a.getValue();
    }

    public final void setData(GiftConstellationHonourSpokenModel spokenModel) {
        StringBuilder sb;
        float percent;
        Intrinsics.e(spokenModel, "spokenModel");
        getBinding().l.setText(spokenModel.getTitle());
        ImageLoader.a((IRequestHost) null, spokenModel.getAnchor_avatar()).b(R.drawable.user_bg_round).c().a(getBinding().a);
        getBinding().g.setText(spokenModel.getAnchor_name());
        ImageLoader.a((IRequestHost) null, spokenModel.getAvatar()).b(R.drawable.user_bg_round).c().a(getBinding().c);
        boolean z = false;
        getBinding().m.setText(LiveCloakingUtil.a(spokenModel.getName(), spokenModel.is_hide() == 1));
        getBinding().j.setText(String.valueOf(spokenModel.getScore()));
        if (spokenModel.getBonus() == 0) {
            getBinding().h.setText("未获得赠豆奖励");
            getBinding().i.setVisibility(8);
            return;
        }
        getBinding().i.setVisibility(0);
        getBinding().h.setText(spokenModel.getBonus() + "赠豆奖励");
        TextView textView = getBinding().i;
        if (spokenModel.getKing_percent() == 0.0f) {
            z = true;
        }
        if (z) {
            sb = new StringBuilder();
            percent = spokenModel.getPercent();
        } else {
            sb = new StringBuilder();
            sb.append(spokenModel.getPercent());
            sb.append("% + ");
            percent = spokenModel.getKing_percent();
        }
        sb.append(percent);
        sb.append('%');
        textView.setText(sb.toString());
    }
}

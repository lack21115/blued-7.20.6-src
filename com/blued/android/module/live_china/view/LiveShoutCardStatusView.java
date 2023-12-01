package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LayoutLiveShoutCardStatusBinding;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveShoutCardStatusView.class */
public final class LiveShoutCardStatusView extends FrameLayout {
    private final Lazy a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveShoutCardStatusView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveShoutCardStatusView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveShoutCardStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.a = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<LayoutLiveShoutCardStatusBinding>() { // from class: com.blued.android.module.live_china.view.LiveShoutCardStatusView$binding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LayoutLiveShoutCardStatusBinding invoke() {
                LayoutLiveShoutCardStatusBinding a = LayoutLiveShoutCardStatusBinding.a(LayoutInflater.from(LiveShoutCardStatusView.this.getContext()), LiveShoutCardStatusView.this, true);
                Intrinsics.c(a, "inflate(LayoutInflater.from(context), this, true)");
                return a;
            }
        });
        setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveShoutCardStatusView$I-gUeaZvDPRVk18NcK6HQFjvWEs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveShoutCardStatusView.a(LiveShoutCardStatusView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveShoutCardStatusView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        ToastUtils.a(this$0.getResources().getString(R.string.live_shout_card_send_tips));
    }

    public final void a(IRequestHost iRequestHost, boolean z, String statusMsg) {
        Intrinsics.e(iRequestHost, "iRequestHost");
        Intrinsics.e(statusMsg, "statusMsg");
        boolean z2 = true;
        if (z) {
            LiveRoomManager.a().b = 1;
            BluedViewExKt.b(this);
        } else {
            LiveRoomManager.a().b = 0;
            BluedViewExKt.a(this);
        }
        if (statusMsg.length() != 0) {
            z2 = false;
        }
        if (!z2) {
            ToastUtils.a(statusMsg);
        }
        ImageLoader.c(iRequestHost, "live_shout_card_send_ing.png").g(-1).f().a(getBinding().b);
    }

    public final LayoutLiveShoutCardStatusBinding getBinding() {
        return (LayoutLiveShoutCardStatusBinding) this.a.getValue();
    }
}

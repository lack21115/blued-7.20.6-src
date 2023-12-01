package com.blued.android.module.live_china.view.operation;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveOperationChildDefaultViewBinding;
import com.blued.android.module.live_china.model.LiveRoomFunctionItemModel;
import com.blued.android.module.live_china.model.LiveRoomOperationModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/operation/OperationChildDefaultView.class */
public final class OperationChildDefaultView extends RelativeLayout {
    private final Context a;
    private final Lazy b;
    private BaseFragment c;
    private LiveRoomOperationModel d;
    private CountDownTimer e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperationChildDefaultView(Context mContext) {
        super(mContext);
        Intrinsics.e(mContext, "mContext");
        this.a = mContext;
        this.b = LazyKt.a(new Function0<LiveOperationChildDefaultViewBinding>() { // from class: com.blued.android.module.live_china.view.operation.OperationChildDefaultView$vb$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LiveOperationChildDefaultViewBinding invoke() {
                LiveOperationChildDefaultViewBinding a = LiveOperationChildDefaultViewBinding.a(LayoutInflater.from(OperationChildDefaultView.this.getMContext()).inflate(R.layout.live_operation_child_default_view, OperationChildDefaultView.this));
                Intrinsics.c(a, "bind(\n            Layout…ult_view, this)\n        )");
                return a;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String a(LiveRoomOperationModel liveRoomOperationModel, long j) {
        if (liveRoomOperationModel.getCountdonw_type() == 0) {
            return ' ' + (j / 1000) + "s ";
        }
        long j2 = j / 1000;
        long j3 = 3600;
        long j4 = j2 / j3;
        String valueOf = j4 > 9 ? String.valueOf(j4) : Intrinsics.a("0", (Object) Long.valueOf(j4));
        long j5 = j2 % j3;
        long j6 = 60;
        long j7 = j5 / j6;
        String valueOf2 = j7 > 9 ? String.valueOf(j7) : Intrinsics.a("0", (Object) Long.valueOf(j7));
        long j8 = j5 % j6;
        String valueOf3 = j8 > 9 ? String.valueOf(j8) : Intrinsics.a("0", (Object) Long.valueOf(j8));
        if (liveRoomOperationModel.getCountdonw_type() == 1) {
            return valueOf2 + ':' + valueOf3;
        }
        return valueOf + ':' + valueOf2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        CountDownTimer countDownTimer = this.e;
        if (countDownTimer == null) {
            return;
        }
        countDownTimer.cancel();
        setTimer(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ActivityFragmentActive it, LiveRoomOperationModel model, OperationChildDefaultView this$0) {
        Intrinsics.e(it, "$it");
        Intrinsics.e(model, "$model");
        Intrinsics.e(this$0, "this$0");
        ImageLoader.a(it, model.getIcon()).a(this$0.getVb().b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(OperationChildDefaultView this$0, View view) {
        LiveRoomOperationModel liveRoomOperationModel;
        Intrinsics.e(this$0, "this$0");
        if (ClickUtils.a(view.getId()) || (liveRoomOperationModel = this$0.d) == null) {
            return;
        }
        LiveRoomFunctionItemModel liveRoomFunctionItemModel = new LiveRoomFunctionItemModel();
        liveRoomFunctionItemModel.setLink(liveRoomOperationModel.getLink());
        liveRoomFunctionItemModel.setLink_type(liveRoomOperationModel.getLink_type());
        LiveEventBusUtil.a(liveRoomFunctionItemModel);
    }

    private final void b() {
        getVb().c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.operation.-$$Lambda$OperationChildDefaultView$l0lULbBd99ARner0YiNGch03iwA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OperationChildDefaultView.a(OperationChildDefaultView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(LiveRoomOperationModel liveRoomOperationModel) {
        String title = liveRoomOperationModel.getTitle();
        if (title == null || title.length() == 0) {
            getVb().a.setVisibility(8);
            return;
        }
        getVb().e.setText(liveRoomOperationModel.getTitle());
        getVb().a.setVisibility(0);
    }

    private final void c(LiveRoomOperationModel liveRoomOperationModel) {
        getVb().a.setVisibility(0);
        long currentTimeMillis = System.currentTimeMillis();
        long get_countdown_timemillis = liveRoomOperationModel.getGet_countdown_timemillis();
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.a = (liveRoomOperationModel.getCountdown() * 1000) - (currentTimeMillis - get_countdown_timemillis);
        this.e = new OperationChildDefaultView$initTimer$1(longRef, this, liveRoomOperationModel).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveOperationChildDefaultViewBinding getVb() {
        return (LiveOperationChildDefaultViewBinding) this.b.getValue();
    }

    public final OperationChildDefaultView a(BaseFragment baseFragment, LiveRoomOperationModel liveRoomOperationModel) {
        if (liveRoomOperationModel == null || liveRoomOperationModel.getStatus() == 0) {
            return null;
        }
        this.d = liveRoomOperationModel;
        if (baseFragment == null) {
            return null;
        }
        this.c = baseFragment;
        if (a(liveRoomOperationModel)) {
            return this;
        }
        return null;
    }

    public final boolean a(final LiveRoomOperationModel model) {
        BaseFragment baseFragment;
        final ActivityFragmentActive fragmentActive;
        Intrinsics.e(model, "model");
        setModel(model);
        if (model.getIcon() != null && (baseFragment = this.c) != null && (fragmentActive = baseFragment.getFragmentActive()) != null) {
            post(new Runnable() { // from class: com.blued.android.module.live_china.view.operation.-$$Lambda$OperationChildDefaultView$82r0-z84yo8tXByxBCGRUVLfi_o
                @Override // java.lang.Runnable
                public final void run() {
                    OperationChildDefaultView.a(ActivityFragmentActive.this, model, this);
                }
            });
        }
        String badge_text = model.getBadge_text();
        if (badge_text == null || badge_text.length() == 0) {
            getVb().d.setVisibility(8);
        } else {
            getVb().d.setText(model.getBadge_text());
            getVb().d.setVisibility(0);
        }
        a();
        if (model.getCountdown() <= 0) {
            b(model);
        } else {
            c(model);
        }
        b();
        return true;
    }

    public final Context getMContext() {
        return this.a;
    }

    public final LiveRoomOperationModel getModel() {
        return this.d;
    }

    public final CountDownTimer getTimer() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.c = null;
        a();
    }

    public final void setModel(LiveRoomOperationModel liveRoomOperationModel) {
        this.d = liveRoomOperationModel;
    }

    public final void setTimer(CountDownTimer countDownTimer) {
        this.e = countDownTimer;
    }
}

package com.blued.android.module.live_china.view.operation;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveOperationDescViewBinding;
import com.blued.android.module.live_china.model.LiveRoomFunctionItemModel;
import com.blued.android.module.live_china.model.LiveRoomOperationModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.view.MarqueeTextView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/operation/LiveOperationDescView.class */
public final class LiveOperationDescView extends RelativeLayout {
    private final Context a;
    private final Lazy b;
    private CountDownTimer c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveOperationDescView(Context mContext) {
        this(mContext, null, 0, 6, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveOperationDescView(Context mContext, AttributeSet attributeSet) {
        this(mContext, attributeSet, 0, 4, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveOperationDescView(Context mContext, AttributeSet attributeSet, int i) {
        super(mContext, attributeSet, i);
        Intrinsics.e(mContext, "mContext");
        this.a = mContext;
        this.b = LazyKt.a(new Function0<LiveOperationDescViewBinding>() { // from class: com.blued.android.module.live_china.view.operation.LiveOperationDescView$vb$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LiveOperationDescViewBinding invoke() {
                LiveOperationDescViewBinding a = LiveOperationDescViewBinding.a(LayoutInflater.from(LiveOperationDescView.this.getMContext()).inflate(R.layout.live_operation_desc_view, LiveOperationDescView.this));
                Intrinsics.c(a, "bind(\n            Layout…esc_view, this)\n        )");
                return a;
            }
        });
        a();
    }

    public /* synthetic */ LiveOperationDescView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
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

    private final void a() {
        getVb().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.operation.-$$Lambda$LiveOperationDescView$TQPaedgHb5zq0D43y01HvaT8shk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveOperationDescView.a(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    private final void a(LiveRoomOperationModel liveRoomOperationModel) {
        String title = liveRoomOperationModel.getTitle();
        if (title == null || title.length() == 0) {
            getVb().a.setVisibility(8);
            return;
        }
        getVb().f.setText(liveRoomOperationModel.getTitle());
        getVb().a.setTranslationY(0.0f);
        getVb().a.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveRoomOperationModel liveRoomOperationModel, View view) {
        if (ClickUtils.a(view.getId()) || liveRoomOperationModel == null) {
            return;
        }
        LiveRoomFunctionItemModel liveRoomFunctionItemModel = new LiveRoomFunctionItemModel();
        liveRoomFunctionItemModel.setLink(liveRoomOperationModel.getLink());
        liveRoomFunctionItemModel.setLink_type(liveRoomOperationModel.getLink_type());
        LiveEventBusUtil.a(liveRoomFunctionItemModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveOperationDescView this$0, Runnable runnable) {
        Intrinsics.e(this$0, "this$0");
        this$0.b();
        if (runnable == null) {
            return;
        }
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveOperationDescView this$0, Runnable runnable, int i) {
        Intrinsics.e(this$0, "this$0");
        if (i > 1) {
            this$0.getVb().d.b();
            this$0.b();
            if (runnable == null) {
                return;
            }
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        CountDownTimer countDownTimer = this.c;
        if (countDownTimer == null) {
            return;
        }
        countDownTimer.cancel();
        setTimer(null);
    }

    private final void b(LiveRoomOperationModel liveRoomOperationModel) {
        getVb().a.setTranslationY(0.0f);
        getVb().a.setVisibility(0);
        long currentTimeMillis = System.currentTimeMillis();
        long get_countdown_timemillis = liveRoomOperationModel.getGet_countdown_timemillis();
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.a = (liveRoomOperationModel.getCountdown() * 1000) - (currentTimeMillis - get_countdown_timemillis);
        this.c = new LiveOperationDescView$initTimer$1(longRef, this, liveRoomOperationModel).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final LiveOperationDescView this$0, final Runnable runnable) {
        Intrinsics.e(this$0, "this$0");
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.operation.-$$Lambda$LiveOperationDescView$bAt67vMxWDz1rO_BLOgBWkWtIDA
            @Override // java.lang.Runnable
            public final void run() {
                LiveOperationDescView.a(LiveOperationDescView.this, runnable);
            }
        }, 240L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveOperationDescViewBinding getVb() {
        return (LiveOperationDescViewBinding) this.b.getValue();
    }

    public final void a(IRequestHost iRequestHost, final LiveRoomOperationModel liveRoomOperationModel) {
        if (liveRoomOperationModel != null) {
            String desc = liveRoomOperationModel.getDesc();
            if (desc != null) {
                getVb().d.setText(desc);
                getVb().d.b();
            }
            if (liveRoomOperationModel.getDesc_icon() != null && iRequestHost != null) {
                ImageLoader.a(iRequestHost, liveRoomOperationModel.getDesc_icon()).a(getVb().b);
            }
            String badge_text = liveRoomOperationModel.getBadge_text();
            if (badge_text == null || badge_text.length() == 0) {
                getVb().e.setVisibility(8);
            } else {
                getVb().e.setText(liveRoomOperationModel.getBadge_text());
                getVb().e.setVisibility(0);
            }
            b();
            if (liveRoomOperationModel.getCountdown() <= 0) {
                a(liveRoomOperationModel);
            } else {
                b(liveRoomOperationModel);
            }
        }
        getVb().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.operation.-$$Lambda$LiveOperationDescView$MJFPpcusK29otvbgoW1fkiUzeFA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveOperationDescView.a(LiveRoomOperationModel.this, view);
            }
        });
    }

    public final void a(final Runnable runnable) {
        getVb().d.setListener(new MarqueeTextView.callbackListener() { // from class: com.blued.android.module.live_china.view.operation.-$$Lambda$LiveOperationDescView$R3J-QuS68rhk5irWDNMzaIenB54
            @Override // com.blued.android.module.live_china.view.MarqueeTextView.callbackListener
            public final void onFinish(int i) {
                LiveOperationDescView.a(LiveOperationDescView.this, runnable, i);
            }
        });
        getVb().d.setErrorListener(new MarqueeTextView.callbackErrorListener() { // from class: com.blued.android.module.live_china.view.operation.-$$Lambda$LiveOperationDescView$aD9IvIxvQiP45JSi-249clm7SN0
            @Override // com.blued.android.module.live_china.view.MarqueeTextView.callbackErrorListener
            public final void onError() {
                LiveOperationDescView.b(LiveOperationDescView.this, runnable);
            }
        });
        getVb().d.setScrollSpeed(1.3f);
        getVb().d.setWaitTime(50L);
        getVb().d.a();
    }

    public final Context getMContext() {
        return this.a;
    }

    public final CountDownTimer getTimer() {
        return this.c;
    }

    public final void setTimer(CountDownTimer countDownTimer) {
        this.c = countDownTimer;
    }
}

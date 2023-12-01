package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.yy_china.databinding.YyExplorationViewBinding;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.fragment.YYWebViewDialogFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.IMJsonContents98Model;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.text.SimpleDateFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYExplorationView.class */
public final class YYExplorationView extends ConstraintLayout {
    private final YyExplorationViewBinding a;
    private CountDownTimer b;
    private final long c;
    private BaseYYStudioFragment d;
    private String e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYExplorationView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYExplorationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYExplorationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        YyExplorationViewBinding a = YyExplorationViewBinding.a(LayoutInflater.from(getContext()), (ViewGroup) this, true);
        Intrinsics.c(a, "inflate(LayoutInflater.from(context), this, true)");
        this.a = a;
        this.c = 1000L;
        this.e = "";
        setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYExplorationView$ugY0JEizhvx222xTjfWK34eXGQc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYExplorationView.a(YYExplorationView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYExplorationView this$0, View view) {
        FragmentManager parentFragmentManager;
        Intrinsics.e(this$0, "this$0");
        if (TextUtils.isEmpty(this$0.e)) {
            return;
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            EventTrackYY.d(ChatRoomProtos.Event.YY_ROOM_STAR_CLICK, b.room_id, b.uid);
        }
        YYWebViewDialogFragment yYWebViewDialogFragment = new YYWebViewDialogFragment();
        yYWebViewDialogFragment.a(this$0.d, this$0.e);
        BaseYYStudioFragment baseYYStudioFragment = this$0.d;
        if (baseYYStudioFragment == null || (parentFragmentManager = baseYYStudioFragment.getParentFragmentManager()) == null) {
            return;
        }
        yYWebViewDialogFragment.show(parentFragmentManager, "exploratory_detail_dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final YYExplorationView this$0, BaseYYStudioFragment baseYYStudioFragment, IMJsonContents98Model iMJsonContents98Model) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.getVisibility() != 0) {
            this$0.setVisibility(0);
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            EventTrackYY.d(ChatRoomProtos.Event.YY_ROOM_STAR_SHOW, b.room_id, b.uid);
        }
        this$0.e = iMJsonContents98Model.getLink();
        ImageLoader.a(baseYYStudioFragment.getFragmentActive(), iMJsonContents98Model.getIcon()).a(this$0.a.b);
        this$0.a.d.setText(iMJsonContents98Model.getMultiple());
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.a = iMJsonContents98Model.getCountdown();
        if (longRef.a < this$0.c) {
            longRef.a *= this$0.c;
        }
        TextView textView = this$0.a.c;
        SimpleDateFormat simpleDateFormat = TimeAndDateUtils.k.get();
        Intrinsics.a(simpleDateFormat);
        textView.setText(simpleDateFormat.format(Long.valueOf(longRef.a)));
        CountDownTimer countDownTimer = this$0.b;
        if (countDownTimer != null && countDownTimer != null) {
            countDownTimer.cancel();
        }
        final long j = this$0.c;
        CountDownTimer countDownTimer2 = new CountDownTimer(this$0, j) { // from class: com.blued.android.module.yy_china.view.YYExplorationView$initData$1$2
            final /* synthetic */ YYExplorationView b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(Ref.LongRef.this.a, j);
                this.b = this$0;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                this.b.setVisibility(8);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                YyExplorationViewBinding yyExplorationViewBinding;
                long j3;
                yyExplorationViewBinding = this.b.a;
                TextView textView2 = yyExplorationViewBinding.c;
                StringBuilder sb = new StringBuilder();
                j3 = this.b.c;
                sb.append(j2 / j3);
                sb.append('s');
                textView2.setText(sb.toString());
            }
        };
        this$0.b = countDownTimer2;
        if (countDownTimer2 == null) {
            return;
        }
        countDownTimer2.start();
    }

    public final void a(final BaseYYStudioFragment baseYYStudioFragment) {
        if (baseYYStudioFragment == null) {
            return;
        }
        this.d = baseYYStudioFragment;
        LiveEventBus.get("exploratory_period", IMJsonContents98Model.class).observe((LifecycleOwner) baseYYStudioFragment, new Observer() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYExplorationView$nAUIES-lrs1rZpjZkUTeghYcTBU
            public final void onChanged(Object obj) {
                YYExplorationView.a(YYExplorationView.this, baseYYStudioFragment, (IMJsonContents98Model) obj);
            }
        });
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CountDownTimer countDownTimer = this.b;
        if (countDownTimer == null) {
            return;
        }
        countDownTimer.cancel();
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        CountDownTimer countDownTimer = this.b;
        if (countDownTimer == null) {
            return;
        }
        countDownTimer.cancel();
    }
}

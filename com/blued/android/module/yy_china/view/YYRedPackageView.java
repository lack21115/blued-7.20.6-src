package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.yy_china.databinding.ViewRedPackageBinding;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.fragment.YYRedEnvelopeFragment;
import com.blued.android.module.yy_china.fragment.YYRedEnvelopeOpenedFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.IMJsonContents100Model;
import com.blued.android.module.yy_china.model.YYMsgRedEnvExtra;
import com.blued.android.module.yy_china.model.YYRedEnvOpenedModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.text.SimpleDateFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYRedPackageView.class */
public final class YYRedPackageView extends ConstraintLayout {
    private final ViewRedPackageBinding a;
    private CountDownTimer b;
    private YYMsgRedEnvExtra c;
    private BaseYYStudioFragment d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYRedPackageView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYRedPackageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYRedPackageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        ViewRedPackageBinding a = ViewRedPackageBinding.a(LayoutInflater.from(getContext()), (ViewGroup) this, true);
        Intrinsics.c(a, "inflate(LayoutInflater.from(context), this, true)");
        this.a = a;
        setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRedPackageView$jV7LZ3CefcN_h_V9wqUtwdCL5Fs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRedPackageView.a(YYRedPackageView.this, view);
            }
        });
    }

    private final void a() {
        YYMsgRedEnvExtra yYMsgRedEnvExtra = this.c;
        if (yYMsgRedEnvExtra == null || yYMsgRedEnvExtra == null) {
            return;
        }
        this.a.c.setText(Intrinsics.a("x", (Object) Integer.valueOf(yYMsgRedEnvExtra.num)));
        long a = StringUtils.a(yYMsgRedEnvExtra.countdown_time, 0L);
        if (yYMsgRedEnvExtra.num <= 0) {
            setVisibility(8);
            CountDownTimer countDownTimer = this.b;
            if (countDownTimer == null) {
                return;
            }
            countDownTimer.cancel();
            return;
        }
        setVisibility(0);
        if (a <= 0) {
            this.a.b.setText("领取");
            return;
        }
        long j = a;
        if (a < 1000) {
            j = a * 1000;
        }
        setCountDownText(j);
        a(j);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.blued.android.module.yy_china.view.YYRedPackageView$showTimer$1] */
    private final void a(final long j) {
        CountDownTimer countDownTimer = this.b;
        if (countDownTimer != null && countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.b = new CountDownTimer(j, this) { // from class: com.blued.android.module.yy_china.view.YYRedPackageView$showTimer$1
            final /* synthetic */ long a;
            final /* synthetic */ YYRedPackageView b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(j, 1000L);
                this.a = j;
                this.b = this;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                YYMsgRedEnvExtra yYMsgRedEnvExtra;
                ViewRedPackageBinding viewRedPackageBinding;
                yYMsgRedEnvExtra = this.b.c;
                if (yYMsgRedEnvExtra != null) {
                    yYMsgRedEnvExtra.countdown_time = "0";
                }
                viewRedPackageBinding = this.b.a;
                viewRedPackageBinding.b.setText("领取");
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                this.b.setCountDownText(j2);
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRedPackageView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || this$0.c == null) {
            return;
        }
        EventTrackYY.d(ChatRoomProtos.Event.YY_ROOM_REDBAG_CLICK, b.room_id, b.uid);
        this$0.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRedPackageView this$0, IMJsonContents100Model iMJsonContents100Model) {
        Intrinsics.e(this$0, "this$0");
        if (iMJsonContents100Model == null) {
            return;
        }
        int type = iMJsonContents100Model.getType();
        if (type == 1) {
            if (this$0.c == null) {
                this$0.c = iMJsonContents100Model.getBody();
            }
            if (this$0.getVisibility() != 0) {
                this$0.a();
                return;
            }
            YYMsgRedEnvExtra yYMsgRedEnvExtra = this$0.c;
            if (yYMsgRedEnvExtra != null) {
                yYMsgRedEnvExtra.num = (yYMsgRedEnvExtra == null ? null : Integer.valueOf(yYMsgRedEnvExtra.num + 1)).intValue();
            }
            ShapeTextView shapeTextView = this$0.a.c;
            YYMsgRedEnvExtra yYMsgRedEnvExtra2 = this$0.c;
            shapeTextView.setText(Intrinsics.a("x", (Object) (yYMsgRedEnvExtra2 == null ? null : Integer.valueOf(yYMsgRedEnvExtra2.num))));
        } else if (type == 2) {
            this$0.c = iMJsonContents100Model.getBody();
            this$0.a();
        } else if (type != 3) {
        } else {
            this$0.c = null;
            CountDownTimer countDownTimer = this$0.b;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this$0.b = null;
            this$0.setVisibility(8);
        }
    }

    private final void b() {
        FragmentManager parentFragmentManager;
        YYRedEnvelopeFragment yYRedEnvelopeFragment = new YYRedEnvelopeFragment(this.c, new YYRedEnvelopeFragment.OpenHongbaoListener() { // from class: com.blued.android.module.yy_china.view.YYRedPackageView$showDetailsDialog$prizeDialog$1
            @Override // com.blued.android.module.yy_china.fragment.YYRedEnvelopeFragment.OpenHongbaoListener
            public void a(YYRedEnvOpenedModel result) {
                BaseYYStudioFragment baseYYStudioFragment;
                FragmentManager parentFragmentManager2;
                Intrinsics.e(result, "result");
                YYRedEnvelopeOpenedFragment yYRedEnvelopeOpenedFragment = new YYRedEnvelopeOpenedFragment(result);
                baseYYStudioFragment = YYRedPackageView.this.d;
                if (baseYYStudioFragment == null || (parentFragmentManager2 = baseYYStudioFragment.getParentFragmentManager()) == null) {
                    return;
                }
                yYRedEnvelopeOpenedFragment.show(parentFragmentManager2, "open_red_envelope_dialog");
            }
        });
        BaseYYStudioFragment baseYYStudioFragment = this.d;
        if (baseYYStudioFragment == null || (parentFragmentManager = baseYYStudioFragment.getParentFragmentManager()) == null) {
            return;
        }
        yYRedEnvelopeFragment.show(parentFragmentManager, "red_envelope_dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCountDownText(long j) {
        YYMsgRedEnvExtra yYMsgRedEnvExtra = this.c;
        if (yYMsgRedEnvExtra != null) {
            yYMsgRedEnvExtra.countdown_time = String.valueOf(j);
        }
        SimpleDateFormat simpleDateFormat = TimeAndDateUtils.k.get();
        Intrinsics.a(simpleDateFormat);
        this.a.b.setText(simpleDateFormat.format(Long.valueOf(j)));
    }

    public final void a(BaseYYStudioFragment baseYYStudioFragment) {
        this.d = baseYYStudioFragment;
        if (baseYYStudioFragment == null) {
            return;
        }
        LiveEventBus.get("show_red_package", IMJsonContents100Model.class).observe((LifecycleOwner) baseYYStudioFragment, new Observer() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRedPackageView$J1c8LKpO9wC0TrdYZTfkWgOV5P0
            public final void onChanged(Object obj) {
                YYRedPackageView.a(YYRedPackageView.this, (IMJsonContents100Model) obj);
            }
        });
    }

    public void setVisibility(int i) {
        YYRoomModel b;
        super.setVisibility(i);
        if (i != 0 || (b = YYRoomInfoManager.e().b()) == null) {
            return;
        }
        EventTrackYY.d(ChatRoomProtos.Event.YY_ROOM_REDBAG_SHOW, b.room_id, b.uid);
    }
}

package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ViewHeartBoyLayoutBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYBorImJsonBodyInfoMode;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYHeartBoyView.class */
public final class YYHeartBoyView extends ConstraintLayout {
    private final ViewHeartBoyLayoutBinding a;
    private CountDownTimer b;
    private boolean c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYHeartBoyView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYHeartBoyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYHeartBoyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        ViewHeartBoyLayoutBinding a = ViewHeartBoyLayoutBinding.a(LayoutInflater.from(getContext()), (ViewGroup) this, true);
        Intrinsics.c(a, "inflate(LayoutInflater.from(context), this, true)");
        this.a = a;
        this.c = true;
        a.c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYHeartBoyView$WpI2doqWNnXnW_wT52neyJJnoxQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYHeartBoyView.a(YYHeartBoyView.this, view);
            }
        });
    }

    private final void a() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        YYRoomHttpUtils.z(b == null ? null : b.room_id, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.blued.android.module.yy_china.view.YYHeartBoyView$sendHeartBoyRequest$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                YYHeartBoyView.this.b();
            }
        }, (ActivityFragmentActive) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYHeartBoyView this$0, View view) {
        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode;
        String uid;
        Intrinsics.e(this$0, "this$0");
        if (!this$0.c) {
            ToastUtils.a("操作太频繁，请稍后重试~");
            return;
        }
        this$0.a();
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        ChatRoomProtos.Event event = ChatRoomProtos.Event.YY_ROB_SING_LIGHT_CLICK;
        String str = b.room_id;
        String str2 = b.uid;
        YYRoomModel b2 = YYRoomInfoManager.e().b();
        String str3 = "";
        if (b2 != null && (yYBorImJsonBodyInfoMode = b2.robMus) != null && (uid = yYBorImJsonBodyInfoMode.getUid()) != null) {
            str3 = uid;
        }
        EventTrackYY.a(event, str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        CountDownTimer countDownTimer = this.b;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.a.e.setText("5000s");
        c();
        CountDownTimer countDownTimer2 = new CountDownTimer(5000L, this) { // from class: com.blued.android.module.yy_china.view.YYHeartBoyView$showTimer$1
            final /* synthetic */ long a;
            final /* synthetic */ YYHeartBoyView b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r7, 1000L);
                this.a = r7;
                this.b = this;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                this.b.c = true;
                this.b.d();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                ViewHeartBoyLayoutBinding viewHeartBoyLayoutBinding;
                this.b.c = false;
                viewHeartBoyLayoutBinding = this.b.a;
                TextView textView = viewHeartBoyLayoutBinding.e;
                StringBuilder sb = new StringBuilder();
                sb.append((j / 1000) + 1);
                sb.append('s');
                textView.setText(sb.toString());
            }
        };
        this.b = countDownTimer2;
        if (countDownTimer2 == null) {
            return;
        }
        countDownTimer2.start();
    }

    private final void c() {
        this.a.a.setImageResource(R.drawable.icon_chorus_light_timer);
        this.a.b.setImageResource(R.drawable.icon_chorus_light_timer_bg);
        this.a.e.setVisibility(0);
        this.a.d.setTextColor(getResources().getColor(R.color.syc_tran30_FFFFFF));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        this.a.a.setImageResource(R.drawable.icon_chorus_light_bg);
        this.a.b.setImageResource(R.drawable.icon_chorus_light);
        this.a.e.setVisibility(8);
        this.a.d.setTextColor(getResources().getColor(R.color.syc_dark_b));
    }
}

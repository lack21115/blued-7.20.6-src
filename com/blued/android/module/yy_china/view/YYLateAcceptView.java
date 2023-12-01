package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYLateAcceptView.class */
public class YYLateAcceptView extends LinearLayout implements View.OnClickListener {
    private TextView a;
    private TextView b;
    private TextView c;
    private CountDownTimer d;
    private BaseYYStudioFragment e;
    private PopupWindow f;

    public YYLateAcceptView(Context context) {
        super(context);
        a();
    }

    public YYLateAcceptView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public YYLateAcceptView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.dialog_late_accept_layout, (ViewGroup) this, true);
        this.a = (TextView) findViewById(R.id.tv_apply_content);
        this.b = (TextView) findViewById(R.id.tv_apply_reject);
        this.c = (TextView) findViewById(R.id.tv_apply_now);
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        c();
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.c(i, b.room_id, new BluedUIHttpResponse<BluedEntityA<Object>>(this.e.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYLateAcceptView.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                YYLateAcceptView.this.e = null;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (YYLateAcceptView.this.f != null) {
                    YYLateAcceptView.this.f.dismiss();
                }
            }
        }, this.e.getFragmentActive());
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.blued.android.module.yy_china.view.YYLateAcceptView$1] */
    private void b() {
        c();
        this.d = new CountDownTimer(5000L, 1000L) { // from class: com.blued.android.module.yy_china.view.YYLateAcceptView.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b != null) {
                    EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_MIKE_POP_AUTO_SUCCESS, b.room_id, b.uid);
                }
                YYLateAcceptView.this.a(1);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                YYLateAcceptView.this.a.setText(String.format(YYLateAcceptView.this.getContext().getResources().getString(R.string.yy_late_apply_des), Long.valueOf((j / 1000) + 1)));
            }
        }.start();
    }

    private void c() {
        CountDownTimer countDownTimer = this.d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment) {
        this.e = baseYYStudioFragment;
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_MIKE_POP_SHOW, b.room_id, b.uid);
        }
        PopupWindow popupWindow = new PopupWindow(this, (int) (AppInfo.l * 0.8d), -2);
        this.f = popupWindow;
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        this.f.setTouchable(true);
        this.f.setOutsideTouchable(true);
        this.f.setFocusable(true);
        this.f.update();
        this.f.showAtLocation(baseYYStudioFragment.getActivity().getWindow().getDecorView(), 17, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.tv_apply_reject) {
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b != null) {
                EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_MIKE_POP_REFUSE_CLICK, b.room_id, b.uid);
            }
            a(0);
        } else if (view.getId() == R.id.tv_apply_now) {
            YYRoomModel b2 = YYRoomInfoManager.e().b();
            if (b2 != null) {
                EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_MIKE_POP_ACCEPT_CLICK, b2.room_id, b2.uid);
            }
            a(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
        PopupWindow popupWindow = this.f;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        this.e = null;
    }
}

package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYReportModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYCardOptionView.class */
public class YYCardOptionView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public PopYyDialog f18083a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f18084c;
    private TextView d;
    private TextView e;
    private BaseYYStudioFragment f;
    private YYUserInfo g;
    private YYUserInfo h;

    public YYCardOptionView(Context context) {
        super(context);
        a();
    }

    public YYCardOptionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public YYCardOptionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_card_option_layout, (ViewGroup) this, true);
        this.d = (TextView) findViewById(R.id.tv_cancel);
        this.f18084c = (TextView) findViewById(R.id.tv_report);
        this.b = (TextView) findViewById(R.id.tv_manager);
        this.e = (TextView) findViewById(R.id.tv_mute);
        YYUserInfo yYUserInfo = YYRoomInfoManager.e().f17578a;
        this.h = yYUserInfo;
        if (yYUserInfo == null) {
            return;
        }
        if (TextUtils.equals(yYUserInfo.chat_anchor, "1")) {
            this.b.setVisibility(0);
        } else {
            this.b.setVisibility(8);
        }
        if (TextUtils.equals(this.h.chat_anchor, "1") || TextUtils.equals(this.h.chat_anchor, "2")) {
            this.e.setVisibility(0);
        } else {
            this.e.setVisibility(8);
        }
        this.d.setOnClickListener(this);
        this.f18084c.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.e.setOnClickListener(this);
    }

    private void b() {
        YYUserInfo yYUserInfo;
        final YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || (yYUserInfo = this.g) == null) {
            return;
        }
        final int i = !TextUtils.equals(yYUserInfo.chat_anchor, "2") ? 1 : 0;
        if (i == 1) {
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_SET_MANAGER_CLICK, b.room_id, b.uid, this.g.getUid());
        }
        YYRoomHttpUtils.d(b.room_id, this.g.getUid(), i, new BluedUIHttpResponse(this.f.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYCardOptionView.1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i2, String str) {
                if (i2 == 40380012) {
                    EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_MANAGER_MAX_SHOW, b.room_id, b.uid, YYCardOptionView.this.g.getUid());
                }
                ToastUtils.a(str, 0);
                return super.onUIFailure(i2, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                if (i == 1) {
                    ToastUtils.a("设置成功", 0);
                }
                if (YYCardOptionView.this.f18083a != null) {
                    YYCardOptionView.this.f18083a.dismissAllowingStateLoss();
                }
            }
        }, this.f.getFragmentActive());
    }

    private void setMute(final String str) {
        YYUserInfo yYUserInfo;
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || (yYUserInfo = this.g) == null) {
            return;
        }
        if (TextUtils.equals(yYUserInfo.mute, "1")) {
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_PROFILE_FORBID_CLICK, b.room_id, b.uid, this.g.getUid());
        } else {
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_PROFILE_REMOVE_FORBID_CLICK, b.room_id, b.uid, this.g.getUid());
        }
        YYRoomHttpUtils.b(b.room_id, this.g.getUid(), str, new BluedUIHttpResponse(this.f.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYCardOptionView.2
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str2) {
                ToastUtils.a(str2, 0);
                return super.onUIFailure(i, str2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (YYCardOptionView.this.f18083a != null) {
                    YYCardOptionView.this.f18083a.dismissAllowingStateLoss();
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                String str2;
                if (TextUtils.equals("1", str)) {
                    str2 = YYCardOptionView.this.g.getName() + " 已被禁言，本场不可在公屏发言。";
                } else {
                    str2 = YYCardOptionView.this.g.getName() + " 已被解除禁言，恢复公屏发言权限。";
                }
                ToastUtils.a(str2, 0);
            }
        }, (IRequestHost) this.f.getFragmentActive());
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment, YYUserInfo yYUserInfo) {
        this.f = baseYYStudioFragment;
        this.g = yYUserInfo;
        if (yYUserInfo == null || this.h == null) {
            return;
        }
        if (TextUtils.equals(yYUserInfo.chat_anchor, "2")) {
            this.b.setText(getResources().getString(R.string.yy_undo_manager));
        } else {
            this.b.setText(getResources().getString(R.string.yy_do_manager));
        }
        if (TextUtils.equals(this.g.mute, "1")) {
            this.e.setText("解除禁言");
        } else {
            this.e.setText("禁言");
        }
        if (TextUtils.equals(this.h.chat_anchor, "1")) {
            this.e.setVisibility(0);
        } else if (!TextUtils.equals(this.h.chat_anchor, "1") && !TextUtils.equals(this.h.chat_anchor, "2")) {
            this.e.setVisibility(8);
        } else if (TextUtils.equals(this.g.chat_anchor, "1") || TextUtils.equals(this.g.chat_anchor, "2")) {
            this.e.setVisibility(8);
        } else {
            this.e.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        YYUserInfo yYUserInfo;
        Tracker.onClick(view);
        if (this.f == null) {
            return;
        }
        if (view.getId() == R.id.tv_cancel) {
            PopYyDialog popYyDialog = this.f18083a;
            if (popYyDialog != null) {
                popYyDialog.dismissAllowingStateLoss();
            }
        } else if (view.getId() != R.id.tv_report) {
            if (view.getId() == R.id.tv_manager) {
                b();
            } else if (view.getId() != R.id.tv_mute || (yYUserInfo = this.g) == null) {
            } else {
                if (TextUtils.equals(yYUserInfo.mute, "1")) {
                    setMute("0");
                } else {
                    setMute("1");
                }
            }
        } else {
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b != null) {
                EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_PROFILE_REPORT_CLICK, b.room_id, b.uid, this.g.getUid());
            }
            YYReportModel yYReportModel = new YYReportModel();
            yYReportModel.uid = this.g.getUid();
            yYReportModel.reportType = 0;
            LiveEventBus.get("common_report_user").post(yYReportModel);
            PopYyDialog popYyDialog2 = this.f18083a;
            if (popYyDialog2 != null) {
                popYyDialog2.dismissAllowingStateLoss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f = null;
    }
}

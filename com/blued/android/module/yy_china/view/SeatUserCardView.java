package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live.base.utils.LiveLogUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.trtc.TRTCSendLeaveMsg;
import com.blued.android.module.yy_china.model.trtc.TRTCSendPKMicrophoneStatusMsg;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.module.yy_china.trtc_audio.model.YYAudioConfig;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/SeatUserCardView.class */
public class SeatUserCardView extends YYUserCardView {

    /* renamed from: a  reason: collision with root package name */
    private TextView f17995a;
    private ShapeTextView b;

    /* renamed from: c  reason: collision with root package name */
    private ShapeTextView f17996c;
    private ShapeTextView d;
    private ShapeTextView e;
    private TextView f;
    private View g;
    private LinearLayout h;
    private ShapeLinearLayout i;

    public SeatUserCardView(Context context) {
        super(context);
    }

    public SeatUserCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SeatUserCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void c() {
        final YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || getUserModel() == null) {
            return;
        }
        LiveLogUtils.a("SeatUserCardView --> onClick --> leaveMic --> 麦上用户主动下麦 ... room id：" + b.room_id + "；uid：" + getUserModel().getUid());
        YYRoomHttpUtils.d(b.room_id, getUserModel().getUid(), (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Object>>(getFragment().getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.SeatUserCardView.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                if (SeatUserCardView.this.getMPopYyDialog() != null) {
                    SeatUserCardView.this.getMPopYyDialog().dismissAllowingStateLoss();
                }
                if (b == null) {
                    return;
                }
                LiveLogUtils.a("SeatUserCardView --> leaveMic 麦上用户主动下麦 接口请求成功 ... room id：" + b.room_id);
                AudioChannelManager.j().a(SeatUserCardView.this.getUserModel().getUid(), 0);
                EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_OUT_MIKE, b.room_id, b.uid);
                if (!TextUtils.equals(b.uid, YYRoomInfoManager.e().k())) {
                    AudioChannelManager.j().a(21);
                } else if (YYRoomInfoManager.e().y() || YYRoomInfoManager.e().j()) {
                    YYAudioConfig yYAudioConfig = new YYAudioConfig();
                    yYAudioConfig.f17862c = SeatUserCardView.this.getUserModel().getUid();
                    AudioChannelManager.j().b(5, AppInfo.f().toJson(yYAudioConfig));
                    if (AppInfo.h >= 713040) {
                        TRTCSendLeaveMsg tRTCSendLeaveMsg = new TRTCSendLeaveMsg();
                        tRTCSendLeaveMsg.cmdID = 5;
                        tRTCSendLeaveMsg.uid = SeatUserCardView.this.getUserModel().getUid();
                        AudioChannelManager.j().a(tRTCSendLeaveMsg);
                    }
                }
            }
        }, (IRequestHost) getFragment().getFragmentActive());
    }

    private void d() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || getUserModel() == null) {
            return;
        }
        int i = 1;
        if (getUserModel().is_open_mic_higher == 1) {
            i = 0;
        }
        LiveLogUtils.a("SeatUserCardView --> onClick --> openOrCloseMic --> 麦上用户 开麦/闭麦 ... room id：" + b.room_id + "；uid：" + getUserModel().getUid());
        final int i2 = i;
        YYRoomHttpUtils.e(b.room_id, getUserModel().getUid(), i, new BluedUIHttpResponse<BluedEntityA<Object>>(getFragment().getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.SeatUserCardView.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                StringBuilder sb = new StringBuilder();
                sb.append(SeatUserCardView.this.getUserModel().getName());
                if (SeatUserCardView.this.getUserModel().is_open_mic_higher == 1) {
                    SeatUserCardView.this.d.setText("解麦");
                    sb.append("已闭麦");
                } else {
                    SeatUserCardView.this.d.setText("闭麦");
                    sb.append("已解麦");
                }
                TRTCSendPKMicrophoneStatusMsg tRTCSendPKMicrophoneStatusMsg = new TRTCSendPKMicrophoneStatusMsg();
                tRTCSendPKMicrophoneStatusMsg.cmdID = 9;
                tRTCSendPKMicrophoneStatusMsg.userId = SeatUserCardView.this.getUserModel().getUid();
                tRTCSendPKMicrophoneStatusMsg.status = i2;
                AudioChannelManager.j().a(tRTCSendPKMicrophoneStatusMsg);
                ToastUtils.a(sb.toString(), 0);
                LiveLogUtils.a("SeatUserCardView --> openOrCloseMicrophone --> 麦上用户 开麦/闭麦 接口请求成功 ... message：" + sb.toString());
                if (SeatUserCardView.this.getMPopYyDialog() != null) {
                    SeatUserCardView.this.getMPopYyDialog().dismissAllowingStateLoss();
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i3, String str) {
                if (i3 == 4036703) {
                    ToastUtils.a(str, 0);
                }
                return super.onUIFailure(i3, str);
            }
        }, getFragment().getFragmentActive());
    }

    @Override // com.blued.android.module.yy_china.view.YYUserCardView
    public void a() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (getUserModel().is_open_mic_higher == 1) {
            this.d.setText("闭麦");
        } else {
            this.d.setText("解麦");
        }
        if (TextUtils.equals(getUserModel().getUid(), YYRoomInfoManager.e().k())) {
            this.g.setVisibility(8);
            this.f17995a.setVisibility(8);
            this.h.setVisibility(8);
            getBinding().P.setVisibility(8);
            if (b == null || !TextUtils.equals(getUserModel().getUid(), b.uid)) {
                this.i.setVisibility(0);
                this.f.setVisibility(0);
            } else if (TextUtils.equals(b.chat_type, "9")) {
                this.i.setVisibility(0);
            } else {
                this.i.setVisibility(8);
            }
        } else {
            this.i.setVisibility(0);
            if (TextUtils.equals(getURole(), "1")) {
                this.f.setVisibility(0);
                this.g.setVisibility(0);
                this.f17995a.setVisibility(0);
                this.h.setVisibility(0);
                this.d.setVisibility(0);
                this.e.setVisibility(0);
            } else if (TextUtils.equals(getURole(), "2")) {
                this.f17995a.setVisibility(0);
                this.h.setVisibility(0);
                if (b != null && TextUtils.equals(getUserModel().getUid(), b.uid)) {
                    this.d.setVisibility(8);
                    this.e.setVisibility(8);
                    this.f.setVisibility(8);
                    this.g.setVisibility(8);
                } else if (TextUtils.equals(getUserModel().chat_anchor, "2")) {
                    this.d.setVisibility(8);
                    this.e.setVisibility(8);
                    this.f.setVisibility(8);
                    this.g.setVisibility(8);
                } else {
                    this.g.setVisibility(0);
                    this.f.setVisibility(0);
                    this.e.setVisibility(0);
                    this.d.setVisibility(0);
                }
                if (TextUtils.equals(b.chat_type, "9")) {
                    this.g.setVisibility(0);
                    this.f.setVisibility(0);
                }
            } else {
                this.f.setVisibility(8);
                this.d.setVisibility(8);
                this.e.setVisibility(8);
                this.g.setVisibility(8);
                this.f17995a.setVisibility(0);
                this.h.setVisibility(0);
            }
        }
        if (b != null && !TextUtils.equals(b.room_id, getUserModel().room_id)) {
            this.h.setVisibility(8);
            this.i.setVisibility(8);
        }
        if (!YYRoomInfoManager.e().J() || YYRoomInfoManager.e().g(getUserModel().getUid())) {
            return;
        }
        this.f17996c.setVisibility(8);
    }

    @Override // com.blued.android.module.yy_china.view.YYUserCardView
    public void a(LinearLayout linearLayout) {
        linearLayout.addView((LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.view_seat_user_menu_layout, (ViewGroup) null));
        this.f17995a = (TextView) findViewById(R.id.tv_send_gift);
        this.b = (ShapeTextView) findViewById(R.id.tv_at_him);
        this.f17996c = (ShapeTextView) findViewById(R.id.tv_private_chat);
        this.d = (ShapeTextView) findViewById(R.id.tv_close_audio);
        this.e = (ShapeTextView) findViewById(R.id.tv_out);
        this.f = (TextView) findViewById(R.id.tv_down_seat);
        this.g = findViewById(R.id.tv_line);
        this.h = (LinearLayout) findViewById(R.id.ll_menu);
        this.i = (ShapeLinearLayout) findViewById(R.id.ll_up_gift);
        this.e.setOnClickListener(this);
        this.f17995a.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.f17996c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.f.setOnClickListener(this);
    }

    @Override // com.blued.android.module.yy_china.view.YYUserCardView, android.view.View.OnClickListener
    public void onClick(View view) {
        ChatRoomProtos.Event event;
        if (view.getId() == R.id.tv_at_him) {
            if (getUserModel() == null) {
                return;
            }
            LiveLogUtils.a("SeatUserCardView --> onClick --> 发送@消息 --> uid：" + getUserModel().getUid());
            event = ChatRoomProtos.Event.CHAT_ROOM_PROFILE_AT_CLICK;
            if (getMPopYyDialog() != null) {
                getMPopYyDialog().dismissAllowingStateLoss();
            }
            getFragment().a(getUserModel().getUid(), getUserModel().getName());
        } else if (view.getId() == R.id.tv_down_seat) {
            c();
            event = null;
        } else if (view.getId() == R.id.tv_private_chat) {
            if (getUserModel() == null) {
                return;
            }
            LiveLogUtils.a("SeatUserCardView --> onClick --> 发送私聊消息 --> uid：" + getUserModel().getUid());
            event = ChatRoomProtos.Event.CHAT_ROOM_PROFILE_MSG_CLICK;
            YYRoomInfoManager.e().c().a(getContext(), getUserModel().getUid(), getUserModel().getName(), getUserModel().getAvatar());
            getFragment().onBackPressed();
            getFragment().getActivity().finish();
        } else if (view.getId() == R.id.tv_close_audio) {
            ChatRoomProtos.Event event2 = getUserModel().is_open_mic == 0 ? ChatRoomProtos.Event.CHAT_ROOM_UNMUTE_BTN_CLICK : ChatRoomProtos.Event.CHAT_ROOM_MUTE_CLICK;
            d();
            event = event2;
            if (getMPopYyDialog() != null) {
                getMPopYyDialog().dismissAllowingStateLoss();
                event = event2;
            }
        } else if (view.getId() == R.id.tv_send_gift) {
            if (getUserModel() == null) {
                return;
            }
            LiveLogUtils.a("SeatUserCardView --> onClick --> 点击送礼 --> uid：" + getUserModel().getUid());
            event = ChatRoomProtos.Event.CHAT_ROOM_PROFILE_GIFT_CLICK;
            if (getMPopYyDialog() != null) {
                getMPopYyDialog().dismissAllowingStateLoss();
            }
            getFragment().a(true, "personal_profile", getUserModel().getUid());
        } else if (view.getId() == R.id.tv_out) {
            event = ChatRoomProtos.Event.CHAT_ROOM_KICK_OUT_CLICK;
            b();
        } else {
            super.onClick(view);
            event = null;
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || getUserModel() == null || event == null) {
            return;
        }
        EventTrackYY.a(event, b.room_id, b.uid, getUserModel().getUid());
    }
}

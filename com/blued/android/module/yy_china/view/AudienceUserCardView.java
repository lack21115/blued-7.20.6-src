package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live.base.utils.LiveLogUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.YYConstants;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYClickApplyEvent;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/AudienceUserCardView.class */
public class AudienceUserCardView extends YYUserCardView {
    private ShapeTextView a;
    private ShapeTextView b;
    private ShapeTextView c;
    private ShapeTextView d;
    private ShapeTextView e;
    private LinearLayout f;

    public AudienceUserCardView(Context context) {
        super(context);
    }

    public AudienceUserCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AudienceUserCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void c() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        int i = 0;
        if (!b.enableRequestMic()) {
            ToastUtils.a("相亲交友活动已开始，不可以邀请用户上麦喽！", 0);
            return;
        }
        if (TextUtils.equals(b.chat_type, "5")) {
            i = 2;
        }
        YYRoomHttpUtils.a(b.room_id, getUserModel().getUid(), i, new BluedUIHttpResponse<BluedEntityA<Object>>(getFragment().getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.AudienceUserCardView.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                ToastUtils.a("邀请上麦已发出，等待确认", 0);
                LiveLogUtils.a("AudienceUserCardView --> inviteMic --> 邀请用户上麦成功 --> uid：" + AudienceUserCardView.this.getUserModel().getUid());
                if (AudienceUserCardView.this.getMPopYyDialog() != null) {
                    AudienceUserCardView.this.getMPopYyDialog().dismissAllowingStateLoss();
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (AudienceUserCardView.this.getBinding() != null) {
                    AudienceUserCardView.this.getBinding().d.setVisibility(8);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                if (AudienceUserCardView.this.getBinding() != null) {
                    AudienceUserCardView.this.getBinding().d.setVisibility(0);
                }
            }
        }, getFragment().getFragmentActive());
    }

    @Override // com.blued.android.module.yy_china.view.YYUserCardView
    public void a() {
        if (TextUtils.equals(getUserModel().getUid(), YYRoomInfoManager.e().k())) {
            this.b.setVisibility(0);
            this.a.setVisibility(8);
            this.f.setVisibility(8);
            getBinding().P.setVisibility(8);
        } else if (TextUtils.equals(getURole(), "1")) {
            this.b.setVisibility(8);
            this.a.setVisibility(0);
            this.f.setVisibility(0);
            this.e.setVisibility(0);
            getBinding().P.setVisibility(0);
        } else if (TextUtils.equals(getURole(), "2")) {
            this.b.setVisibility(8);
            this.a.setVisibility(0);
            this.f.setVisibility(0);
            if (TextUtils.equals(getUserModel().chat_anchor, "2")) {
                this.e.setVisibility(8);
            } else {
                this.e.setVisibility(0);
            }
            getBinding().P.setVisibility(0);
        } else {
            this.b.setVisibility(8);
            this.e.setVisibility(8);
            this.a.setVisibility(8);
            this.f.setVisibility(0);
            getBinding().P.setVisibility(0);
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null && !TextUtils.equals(b.room_id, getUserModel().room_id)) {
            this.f.setVisibility(8);
            this.b.setVisibility(8);
            this.a.setVisibility(8);
        }
        if (!YYRoomInfoManager.e().J() || YYRoomInfoManager.e().g(getUserModel().getUid())) {
            return;
        }
        this.d.setVisibility(8);
    }

    @Override // com.blued.android.module.yy_china.view.YYUserCardView
    public void a(LinearLayout linearLayout) {
        linearLayout.addView((LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.view_audience_user_menu_layout, (ViewGroup) null));
        this.a = (ShapeTextView) findViewById(R.id.tv_invite_seat);
        this.b = (ShapeTextView) findViewById(R.id.tv_up_seat);
        this.c = (ShapeTextView) findViewById(R.id.tv_at_him);
        this.d = (ShapeTextView) findViewById(R.id.tv_private_chat);
        this.e = (ShapeTextView) findViewById(R.id.tv_out);
        this.f = (LinearLayout) findViewById(R.id.ll_menu);
        this.b.setOnClickListener(this);
        this.a.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
    }

    @Override // com.blued.android.module.yy_china.view.YYUserCardView, android.view.View.OnClickListener
    public void onClick(View view) {
        YYRoomModel b;
        if (view.getId() == R.id.tv_at_him) {
            if (getUserModel() == null) {
                return;
            }
            LiveLogUtils.a("AudienceUserCardView --> onClick --> 发送@消息 --> uid：" + getUserModel().getUid());
            if (getMPopYyDialog() != null) {
                getMPopYyDialog().dismissAllowingStateLoss();
            }
            getFragment().a(getUserModel().getUid(), getUserModel().getName());
        } else if (view.getId() == R.id.tv_invite_seat) {
            if (getUserModel() == null) {
                return;
            }
            LiveLogUtils.a("AudienceUserCardView --> onClick --> 邀请用户上麦 --> uid：" + getUserModel().getUid());
            c();
        } else if (view.getId() == R.id.tv_private_chat) {
            if (getUserModel() == null) {
                return;
            }
            LiveLogUtils.a("AudienceUserCardView --> onClick --> 发送私聊消息 --> uid：" + getUserModel().getUid());
            YYRoomInfoManager.e().c().a(getContext(), getUserModel().getUid(), getUserModel().getName(), getUserModel().getAvatar());
            getFragment().onBackPressed();
            getFragment().getActivity().finish();
        } else if (view.getId() != R.id.tv_up_seat) {
            if (view.getId() != R.id.tv_out) {
                super.onClick(view);
                return;
            }
            YYRoomModel b2 = YYRoomInfoManager.e().b();
            if (b2 != null && getUserModel() != null) {
                EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_KICK_OUT_CLICK, b2.room_id, b2.uid, getUserModel().getUid());
                LiveLogUtils.a("AudienceUserCardView --> onClick --> 将用户踢出直播间 --> uid：" + getUserModel().getUid());
            }
            b();
        } else if (YYRoomInfoManager.e().c().a(getContext(), (View.OnClickListener) null) || (b = YYRoomInfoManager.e().b()) == null) {
        } else {
            LiveLogUtils.a("AudienceUserCardView --> onClick --> 用户请求上麦 --> uid：" + getUserModel().getUid() + "；room_id：" + b.room_id + "；chat_type：" + b.chat_type);
            EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_PROFILE_MIKE_CLICK, b.room_id, b.uid);
            if (TextUtils.equals(b.chat_type, "5")) {
                LiveEventBus.get("common_apply_seat").post(new YYClickApplyEvent(YYConstants.ApplyFromSource.UserCard, "3"));
            } else if (TextUtils.equals(b.chat_type, "4")) {
                LiveEventBus.get("common_apply_seat").post(new YYClickApplyEvent(YYConstants.ApplyFromSource.UserCard, "2"));
            } else {
                LiveEventBus.get("common_apply_seat").post(new YYClickApplyEvent(YYConstants.ApplyFromSource.UserCard, "0"));
            }
        }
    }
}

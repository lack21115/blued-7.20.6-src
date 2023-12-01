package com.blued.android.module.yy_china.fragment;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live.base.manager.YYMusicManager;
import com.blued.android.module.live.base.music.model.LiveMusicModel;
import com.blued.android.module.live.base.utils.LiveAlterDialog;
import com.blued.android.module.live.base.utils.LiveLogUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.YYConstants;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYClickApplyEvent;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYLockModel;
import com.blued.android.module.yy_china.model.YYMsgKickInfoExtra;
import com.blued.android.module.yy_china.model.YYMsgMicInfoExtra;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.module.yy_china.trtc_audio.model.TrtcBackgroundMusicModel;
import com.blued.android.module.yy_china.trtc_audio.model.YYAudioConfig;
import com.blued.android.module.yy_china.trtc_audio.permission.PermissionHelper;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.KtvNewSongMessageView;
import com.blued.android.module.yy_china.view.YYBroadcastView;
import com.blued.android.module.yy_china.view.YYLateAcceptView;
import com.blued.android.module.yy_china.view.YYSubscriptionView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.tencent.txcopyrightedmedia.ITXCMMusicTrack;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/PlayingStudioFragment.class */
public class PlayingStudioFragment extends BaseYYStudioFragment {
    public boolean aj = false;
    private KtvNewSongMessageView ak;

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        YYRoomModel b;
        if (this.F || (b = YYRoomInfoManager.e().b()) == null || TextUtils.equals(b.relationship, "1") || TextUtils.equals(b.relationship, "3")) {
            return;
        }
        YYSubscriptionView yYSubscriptionView = new YYSubscriptionView(getContext());
        yYSubscriptionView.a(this);
        a(yYSubscriptionView, -2);
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.fragment.PlayingStudioFragment.2
            @Override // java.lang.Runnable
            public void run() {
                PlayingStudioFragment.this.y();
            }
        }, 8000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BluedUIHttpResponse X() {
        return new BluedUIHttpResponse<BluedEntityA<Object>>(getFragmentActive()) { // from class: com.blued.android.module.yy_china.fragment.PlayingStudioFragment.19
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
            }
        };
    }

    private PopupWindow a(View view, LinearLayout linearLayout) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int width = view.getWidth();
        int height = view.getHeight();
        linearLayout.measure(0, 0);
        int measuredWidth = linearLayout.getMeasuredWidth();
        int measuredHeight = linearLayout.getMeasuredHeight();
        int i = width / 2;
        int i2 = measuredWidth / 2;
        int i3 = height / 2;
        int a2 = DensityUtils.a(getContext(), 6.0f);
        int i4 = iArr[0];
        int i5 = iArr[1];
        PopupWindow popupWindow = new PopupWindow(linearLayout, measuredWidth, measuredHeight);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.showAtLocation(getActivity().getWindow().getDecorView(), 0, i4 + (i - i2), i5 + i3 + a2);
        return popupWindow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final YYMsgKickInfoExtra yYMsgKickInfoExtra) {
        if (yYMsgKickInfoExtra == null || TextUtils.isEmpty(yYMsgKickInfoExtra.audience_message)) {
            LiveLogUtils.a("PlayingStudioFragment --> EVENT_CLOSE_LIVING_ROOM --> audience 收到 主播关闭直播间 消息");
        } else {
            postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.fragment.PlayingStudioFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    LiveLogUtils.a("PlayingStudioFragment --> EVENT_CLOSE_LIVING_ROOM --> 收到关闭房间消息 --> 主播违规信息：" + AppInfo.f().toJson(yYMsgKickInfoExtra));
                    YYRoomModel b = YYRoomInfoManager.e().b();
                    if (b != null) {
                        EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_USER_OUT_MIKE_TOAST_SHOW, b.room_id, b.uid);
                    }
                    View inflate = LayoutInflater.from(PlayingStudioFragment.this.getContext()).inflate(R.layout.dialog_warning_layout, (ViewGroup) null);
                    TextView textView = (TextView) inflate.findViewById(R.id.tv_warn_title);
                    ((TextView) inflate.findViewById(R.id.tv_warn)).setText(yYMsgKickInfoExtra.audience_message);
                    textView.setText(yYMsgKickInfoExtra.title);
                    LiveAlterDialog.a(PlayingStudioFragment.this.getContext(), inflate, (View.OnClickListener) null, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.PlayingStudioFragment.9.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Tracker.onClick(view);
                            if (PlayingStudioFragment.this.getActivity() == null) {
                                return;
                            }
                            PlayingStudioFragment.this.getActivity().finish();
                        }
                    }, false, true);
                }
            }, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YYSeatMemberModel yYSeatMemberModel, int i) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.a(b.room_id, yYSeatMemberModel.position_status == -1 ? 0 : 1, i, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYLockModel>>(getFragmentActive()) { // from class: com.blued.android.module.yy_china.fragment.PlayingStudioFragment.16
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYLockModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                if (bluedEntityA.getSingleData().position_status == 0) {
                    ToastUtils.a("麦位已解封，其他用户可以点击麦位正常上麦", 0);
                } else {
                    ToastUtils.a("麦位已封禁，没有用户可以上此麦，再次点击麦位可以解开", 0);
                }
            }
        }, (IRequestHost) getFragmentActive());
    }

    private void b(View view, YYSeatMemberModel yYSeatMemberModel, final int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.view_yy_menu_layout, (ViewGroup) null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.tv_status);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.tv_invite);
        View findViewById = linearLayout.findViewById(R.id.ll_line);
        textView2.setVisibility(8);
        findViewById.setVisibility(8);
        textView.setText(getResources().getString(R.string.yy_up_seat));
        final PopupWindow a2 = a(view, linearLayout);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.PlayingStudioFragment.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                YYConstants.ApplyFromSource applyFromSource = YYConstants.ApplyFromSource.SeatView;
                YYClickApplyEvent yYClickApplyEvent = new YYClickApplyEvent(applyFromSource, i + "");
                yYClickApplyEvent.setShowApplicationDialog(false);
                LiveEventBus.get("common_apply_seat").post(yYClickApplyEvent);
                PopupWindow popupWindow = a2;
                if (popupWindow == null || !popupWindow.isShowing()) {
                    return;
                }
                a2.dismiss();
            }
        });
    }

    private void c(View view, final YYSeatMemberModel yYSeatMemberModel, final int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.view_yy_menu_layout, (ViewGroup) null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.tv_status);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.tv_invite);
        View findViewById = linearLayout.findViewById(R.id.ll_line);
        if (yYSeatMemberModel.position_status == 0) {
            textView.setText(getResources().getString(R.string.yy_seat_status_disable));
            textView2.setVisibility(0);
            findViewById.setVisibility(0);
        } else if (yYSeatMemberModel.position_status == -1) {
            textView.setText(getResources().getString(R.string.yy_seat_status_enable));
            textView2.setVisibility(8);
            findViewById.setVisibility(8);
        }
        if (yYSeatMemberModel.position_status == 0) {
            textView.setText(getResources().getString(R.string.yy_seat_status_disable));
        } else if (yYSeatMemberModel.position_status == -1) {
            textView.setText(getResources().getString(R.string.yy_seat_status_enable));
        }
        if (i == 0) {
            textView.setVisibility(8);
            findViewById.setVisibility(8);
        }
        final PopupWindow a2 = a(view, linearLayout);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.PlayingStudioFragment.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                PlayingStudioFragment.this.a(yYSeatMemberModel, i);
                PopupWindow popupWindow = a2;
                if (popupWindow == null || !popupWindow.isShowing()) {
                    return;
                }
                a2.dismiss();
            }
        });
        if (YYRoomInfoManager.e().i() || !YYRoomInfoManager.e().j()) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.PlayingStudioFragment.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    PlayingStudioFragment.this.c(i);
                    PopupWindow popupWindow = a2;
                    if (popupWindow == null || !popupWindow.isShowing()) {
                        return;
                    }
                    a2.dismiss();
                }
            });
            return;
        }
        textView2.setText(R.string.yy_up_seat);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.PlayingStudioFragment.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                YYConstants.ApplyFromSource applyFromSource = YYConstants.ApplyFromSource.BottomView;
                YYClickApplyEvent yYClickApplyEvent = new YYClickApplyEvent(applyFromSource, "" + i);
                yYClickApplyEvent.setShowApplicationDialog(false);
                LiveEventBus.get("common_apply_seat").post(yYClickApplyEvent);
                PopupWindow popupWindow = a2;
                if (popupWindow == null || !popupWindow.isShowing()) {
                    return;
                }
                a2.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        if (getContext() == null || getFragmentActive() == null || !getFragmentActive().isActive()) {
            return;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_invite_layout, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_invite_from);
        if (StringUtils.a(str2, 0) > 0) {
            textView.setText(String.format(getResources().getString(R.string.yy_msg_invite_with_position), str, str2));
        } else {
            textView.setText(String.format(getResources().getString(R.string.yy_msg_invite_title), str));
        }
        LiveAlterDialog.b(getContext(), inflate, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.PlayingStudioFragment.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b == null) {
                    return;
                }
                EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_REFUSE_CLICK, b.room_id, b.uid);
                YYRoomHttpUtils.f(b.room_id, 0, PlayingStudioFragment.this.X(), PlayingStudioFragment.this.getFragmentActive());
            }
        }, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.PlayingStudioFragment.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b == null) {
                    return;
                }
                EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_ACCEPT_CLICK, b.room_id, b.uid);
                YYRoomHttpUtils.f(b.room_id, 1, PlayingStudioFragment.this.X(), PlayingStudioFragment.this.getFragmentActive());
            }
        }, true, false);
    }

    private void f(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LiveLogUtils.a("PlayingStudioFragment --> leaveRoom --> 准备请求退出直播间接口 ... room_id： " + str);
        z();
        YYRoomInfoManager.e().a(str, new BluedUIHttpResponse<BluedEntityA<Object>>(getFragmentActive()) { // from class: com.blued.android.module.yy_china.fragment.PlayingStudioFragment.1

            /* renamed from: a  reason: collision with root package name */
            Dialog f17038a = null;

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                LiveLogUtils.a("PlayingStudioFragment --> leaveRoom --> 退出直播间接口请求成功 ... isFinish： " + PlayingStudioFragment.this.aj);
                PlayingStudioFragment.this.K();
                if (PlayingStudioFragment.this.aj) {
                    YYRoomInfoManager.e().x();
                    PlayingStudioFragment.this.getActivity().finish();
                } else {
                    PlayingStudioFragment.this.a(str, false, (YYMsgKickInfoExtra) null);
                }
                Dialog dialog = this.f17038a;
                if (dialog != null) {
                    dialog.cancel();
                }
                DialogUtils.b(this.f17038a);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str2) {
                LiveLogUtils.a("PlayingStudioFragment --> leaveRoom --> 退出直播间接口请求失败 ... errorMessage： " + str2);
                DialogUtils.b(this.f17038a);
                return super.onUIFailure(i, str2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                DialogUtils.b(this.f17038a);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                Dialog a2 = DialogUtils.a(PlayingStudioFragment.this.getContext());
                this.f17038a = a2;
                DialogUtils.a(a2);
            }
        }, getFragmentActive());
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseYYStudioFragment
    public void A() {
        LiveEventBus.get("invite_seat_msg", YYImModel.class).observe(this, new Observer<YYImModel>() { // from class: com.blued.android.module.yy_china.fragment.PlayingStudioFragment.3
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYImModel yYImModel) {
                final YYAudienceModel yYAudienceModel;
                if (YYRoomInfoManager.e().c().a(PlayingStudioFragment.this.getContext(), (View.OnClickListener) null) || (yYAudienceModel = yYImModel.source_profile) == null) {
                    return;
                }
                final YYMsgMicInfoExtra yYMsgMicInfoExtra = (YYMsgMicInfoExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), (Class<Object>) YYMsgMicInfoExtra.class);
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b != null) {
                    EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_INVITE_POP_SHOW, b.room_id, b.uid);
                }
                LiveLogUtils.a("PlayingStudioFragment --> EVENT_INVITE_SEAT_MSG --> 申请麦克风权限 --> yyAudienceModel：" + AppInfo.f().toJson(yYAudienceModel));
                PermissionHelper.a(new PermissionCallbacks() { // from class: com.blued.android.module.yy_china.fragment.PlayingStudioFragment.3.1
                    @Override // com.blued.android.framework.permission.PermissionCallbacks
                    public void U_() {
                        LiveLogUtils.a("PlayingStudioFragment --> EVENT_INVITE_SEAT_MSG --> 授权麦克风权限 ... ");
                        if (yYAudienceModel == null || yYMsgMicInfoExtra == null) {
                            return;
                        }
                        PlayingStudioFragment.this.c(yYAudienceModel.getName(), yYMsgMicInfoExtra.position);
                    }

                    @Override // com.blued.android.framework.permission.PermissionCallbacks
                    public void a(String[] strArr) {
                        LiveLogUtils.a("PlayingStudioFragment --> EVENT_INVITE_SEAT_MSG --> 拒绝麦克风权限 ... ");
                        AppMethods.a((CharSequence) "麦克风已被禁用，请在设置中授权麦克风使用");
                    }
                });
            }
        });
        LiveEventBus.get("close_living_room", YYMsgKickInfoExtra.class).observe(this, new Observer<YYMsgKickInfoExtra>() { // from class: com.blued.android.module.yy_china.fragment.PlayingStudioFragment.4
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYMsgKickInfoExtra yYMsgKickInfoExtra) {
                if (yYMsgKickInfoExtra.source_profile == null) {
                    PlayingStudioFragment.this.aj = false;
                    PlayingStudioFragment.this.G();
                    PlayingStudioFragment.this.a(yYMsgKickInfoExtra);
                    return;
                }
                LiveLogUtils.a("PlayingStudioFragment --> EVENT_CLOSE_LIVING_ROOM --> audience 收到 被房主移出了房间 消息");
                ToastUtils.a("你被" + yYMsgKickInfoExtra.source_profile.getChatAnchorName() + "移出了房间", 0);
                YYRoomInfoManager.e().x();
                PlayingStudioFragment.this.getActivity().finish();
            }
        });
        LiveEventBus.get("late_accept_msg", String.class).observe(this, new Observer<String>() { // from class: com.blued.android.module.yy_china.fragment.PlayingStudioFragment.5
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                new YYLateAcceptView(PlayingStudioFragment.this.getContext()).a(PlayingStudioFragment.this);
            }
        });
        LiveEventBus.get("send_apply_reject", String.class).observe(this, new Observer<String>() { // from class: com.blued.android.module.yy_china.fragment.PlayingStudioFragment.6
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b != null) {
                    EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_MIKE_REFUSE_SHOW, b.room_id, b.uid);
                }
            }
        });
        LiveEventBus.get("down_seat_msg", YYAudienceModel.class).observe(this, new Observer<YYAudienceModel>() { // from class: com.blued.android.module.yy_china.fragment.PlayingStudioFragment.7
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYAudienceModel yYAudienceModel) {
                LiveLogUtils.a("PlayingStudioFragment --> EVENT_DOWN_SEAT_MSG --> 被下麦");
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (yYAudienceModel == null || b == null || !TextUtils.equals(yYAudienceModel.getUid(), YYRoomInfoManager.e().k())) {
                    return;
                }
                EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_USER_OUT_MIKE_TOAST_SHOW, b.room_id, b.uid, yYAudienceModel.getUid());
            }
        });
        LiveEventBus.get("set_mute_status", String.class).observe(this, new Observer<String>() { // from class: com.blued.android.module.yy_china.fragment.PlayingStudioFragment.8
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                String str2 = TextUtils.equals("1", str) ? "你已被禁言，本场不可在公屏发言" : "你已被解除禁言，恢复公屏发言权限";
                ToastUtils.a(str2, 0);
                LiveLogUtils.a("PlayingStudioFragment --> Event_SET_MUTE_STATUS --> " + str2);
            }
        });
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseYYStudioFragment
    public void B() {
        YyMoreMenuView yyMoreMenuView = new YyMoreMenuView();
        yyMoreMenuView.a(this, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.PlayingStudioFragment.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveLogUtils.a("PlayingStudioFragment --> onClickMore --> 点击退出直播间 ... ");
                if (YYRoomInfoManager.e().b() != null) {
                    EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_EXIT_BTN_CLICK, YYRoomInfoManager.e().b().room_id, YYRoomInfoManager.e().b().uid);
                }
                PlayingStudioFragment.this.aj = true;
                PlayingStudioFragment.this.y();
                PlayingStudioFragment.this.G();
            }
        });
        yyMoreMenuView.show(getChildFragmentManager(), "YyMoreMenuView");
        if (YYRoomInfoManager.e().b() != null) {
            EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_RECOMMEND_SECOND_CLICK, YYRoomInfoManager.e().b().room_id, YYRoomInfoManager.e().b().uid);
        }
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseYYStudioFragment
    public void C() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomInfoManager.e().c().a(getContext(), getFragmentManager(), b, (Bitmap) null, "我在语音聊天室，邀请你加入");
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseYYStudioFragment
    public void D() {
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.fragment.PlayingStudioFragment.11
            @Override // java.lang.Runnable
            public void run() {
                PlayingStudioFragment.this.W();
            }
        }, 25000L);
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseYYStudioFragment
    protected void E() {
        this.n.a(false);
        if (YYRoomInfoManager.e().i()) {
            this.o.a(false);
        } else {
            this.o.a(true);
        }
        LiveMusicModel a2 = YYMusicManager.f11418a.c().a();
        if (a2 != null) {
            a(a2);
        }
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseYYStudioFragment
    public int F() {
        if (YYRoomInfoManager.e().f17578a == null) {
            return 0;
        }
        return StringUtils.a(YYRoomInfoManager.e().f17578a.chat_anchor, 0);
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseYYStudioFragment
    public void G() {
        LiveEventBus.get("dialog_cancel_event").post("");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            f(b.room_id);
            return;
        }
        YYRoomInfoManager.e().x();
        getActivity().finish();
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseYYStudioFragment
    public void H() {
        YYBroadcastView yYBroadcastView = new YYBroadcastView();
        yYBroadcastView.a(this, false, false);
        yYBroadcastView.show(getChildFragmentManager(), "broadcastView");
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseYYStudioFragment
    protected boolean I() {
        return false;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseYYStudioFragment
    public void J() {
        if (this.F) {
            AudioChannelManager.j().a(L());
            return;
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYAudioConfig yYAudioConfig = new YYAudioConfig();
        yYAudioConfig.f17862c = YYRoomInfoManager.e().k();
        yYAudioConfig.b = b.room_id;
        int i = 20;
        if (TextUtils.equals(b.chat_type, "9")) {
            if (b.getSeatMember(yYAudioConfig.f17862c) == null) {
                i = 21;
            }
            yYAudioConfig.d = i;
        } else {
            if (!YYRoomInfoManager.e().f17578a.chat_anchor.equals("1")) {
                i = 21;
            }
            yYAudioConfig.d = i;
        }
        yYAudioConfig.f17861a = b.user_sig;
        Logger.c("ulog", "客态 getUserInfo -- role  " + yYAudioConfig.d + "  uid " + yYAudioConfig.f17862c);
        AudioChannelManager.j().a(L());
        AudioChannelManager.j().a(yYAudioConfig);
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void J_() {
        this.p.setVisibility(8);
        this.p.b();
        l().a(0, "");
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void K_() {
        AudioChannelManager.j().d(1);
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void L_() {
    }

    public void V() {
        if (this.ak == null) {
            KtvNewSongMessageView a2 = KtvNewSongMessageView.f17951a.a(this.r);
            this.ak = a2;
            a2.setFrag(this);
        }
        this.ak.b();
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void a() {
        this.p.setPlaying(true);
        if (this.p.f18333a == null) {
            l().a(3, "");
        } else {
            l().a(3, this.p.f18333a.cover);
        }
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseYYStudioFragment
    public void a(View view, YYSeatMemberModel yYSeatMemberModel, int i) {
        YYRoomModel b;
        if (view == null || yYSeatMemberModel == null) {
            return;
        }
        if (yYSeatMemberModel.position_status == 1) {
            String uid = yYSeatMemberModel.getUid();
            String name = yYSeatMemberModel.getName();
            String avatar = yYSeatMemberModel.getAvatar();
            a(uid, name, avatar, F() + "", true);
        } else if (yYSeatMemberModel.position_status != 0) {
            if (yYSeatMemberModel.position_status == -1 && (b = YYRoomInfoManager.e().b()) != null && TextUtils.equals(b.chat_type, "9") && YYRoomInfoManager.e().j()) {
                c(view, yYSeatMemberModel, i);
            }
        } else {
            YYRoomModel b2 = YYRoomInfoManager.e().b();
            if (b2 != null) {
                if (TextUtils.equals(b2.chat_type, "8") || TextUtils.equals(b2.chat_type, "11")) {
                    if (b2.enableRequestMic() && i == 9) {
                        new YYApplyVipDialog().show(getParentFragmentManager(), "show_vip_dialog");
                        return;
                    } else if (!b2.enableRequestMic() && b2.getSeatMember(YYRoomInfoManager.e().k()) != null) {
                        ToastUtils.a("心动交友环节已开启，不允许切麦", 0);
                        return;
                    } else if (!b2.enableRequestMic()) {
                        ToastUtils.a("抱歉，本轮心动交友已经开启，请等待下一轮开启前再上麦。", 0);
                        return;
                    }
                }
                if (TextUtils.equals(b2.chat_type, "3") && b2.game_step > 0 && b2.getSeatMember(YYRoomInfoManager.e().k()) != null) {
                    ToastUtils.a("游戏已开启，不允许切麦", 0);
                    return;
                } else if (TextUtils.equals(b2.chat_type, "9") && YYRoomInfoManager.e().j()) {
                    c(view, yYSeatMemberModel, i);
                    return;
                }
            }
            if (YYRoomInfoManager.e().c().a(getContext(), (View.OnClickListener) null)) {
                return;
            }
            b(view, yYSeatMemberModel, i);
        }
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void a(LiveMusicModel liveMusicModel) {
        TrtcBackgroundMusicModel trtcBackgroundMusicModel = new TrtcBackgroundMusicModel();
        trtcBackgroundMusicModel.cmdID = 7;
        AudioChannelManager.j().a(trtcBackgroundMusicModel);
        this.p.setVisibility(0);
        this.p.setData(liveMusicModel);
        l().a(1, liveMusicModel.cover);
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void a(ChatRoomProtos.Event event, LiveProtos.Event event2, String str, String str2) {
        EventTrackYY.e(event, str, str2);
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void a(ChatRoomProtos.Event event, LiveProtos.Event event2, String str, String str2, String str3) {
        EventTrackYY.n(event, str, str2, str3);
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void a(ChatRoomProtos.Event event, LiveProtos.Event event2, String str, String str2, String str3, int i) {
        EventTrackYY.a(event, str, str2, str3, i);
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void a(ITXCMMusicTrack iTXCMMusicTrack) {
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void a(String str) {
        if (YYRoomInfoManager.e().b() != null) {
            EventTrackYY.e(ChatRoomProtos.Event.CHAT_ROOM_BG_MUSIC_ONE_PLAY_CLICK, YYRoomInfoManager.e().b().room_id, YYRoomInfoManager.e().b().uid, str);
        }
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void b(String str) {
        AudioChannelManager.j().a(1, str);
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void c() {
        this.p.b();
        l().a(0, "");
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void d() {
        this.p.setPlaying(false);
        if (this.p.f18333a == null) {
            l().a(3, "");
        } else {
            l().a(2, this.p.f18333a.cover);
        }
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseYYStudioFragment
    public void d(int i) {
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseYYStudioFragment
    public void d(String str) {
        this.aj = true;
        f(str);
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public String f() {
        return YYRoomInfoManager.e().b() != null ? YYRoomInfoManager.e().b().room_id : "";
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void g() {
        AudioChannelManager.j().b(1);
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void h() {
        AudioChannelManager.j().c(1);
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseYYStudioFragment, com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        return super.onBackPressed();
    }
}

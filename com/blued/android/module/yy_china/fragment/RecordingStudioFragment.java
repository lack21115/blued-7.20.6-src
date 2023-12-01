package com.blued.android.module.yy_china.fragment;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.android.internal.widget.LockPatternUtils;
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
import com.blued.android.module.yy_china.model.YYMatchingRoomModel;
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
import com.blued.android.module.yy_china.view.ApplyCloseRoomView;
import com.blued.android.module.yy_china.view.YYBroadcastView;
import com.blued.android.module.yy_china.view.YYCreatePKView;
import com.blued.android.module.yy_china.view.YYCreateWishView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.google.protobuf.Any;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.tencent.txcopyrightedmedia.ITXCMMusicTrack;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/RecordingStudioFragment.class */
public class RecordingStudioFragment extends BaseYYStudioFragment {
    private PopupWindow aj;

    /* renamed from: com.blued.android.module.yy_china.fragment.RecordingStudioFragment$16  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/RecordingStudioFragment$16.class */
    class AnonymousClass16 extends BluedUIHttpResponse<BluedEntityA<Any>> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<Any> bluedEntityA) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BluedUIHttpResponse V() {
        return new BluedUIHttpResponse<BluedEntityA<Object>>(getFragmentActive()) { // from class: com.blued.android.module.yy_china.fragment.RecordingStudioFragment.14
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        PopupWindow popupWindow = this.aj;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.aj.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YYSeatMemberModel yYSeatMemberModel, int i) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.a(b.room_id, yYSeatMemberModel.position_status == -1 ? 0 : 1, i, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYLockModel>>(getFragmentActive()) { // from class: com.blued.android.module.yy_china.fragment.RecordingStudioFragment.21
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, int i) {
        YYRoomHttpUtils.a(str, str2, str3, i, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Any>>(getFragmentActive()) { // from class: com.blued.android.module.yy_china.fragment.RecordingStudioFragment.15
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Any> bluedEntityA) {
            }
        }, getFragmentActive());
    }

    private void b(View view, final YYSeatMemberModel yYSeatMemberModel, final int i) {
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
        if (yYSeatMemberModel.isVip) {
            textView2.setVisibility(8);
        }
        if (YYRoomInfoManager.e().i() || !(YYRoomInfoManager.e().y() || YYRoomInfoManager.e().j())) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.RecordingStudioFragment.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    RecordingStudioFragment.this.c(i);
                    RecordingStudioFragment.this.W();
                }
            });
        } else {
            textView2.setText(R.string.yy_up_seat);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.RecordingStudioFragment.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    YYConstants.ApplyFromSource applyFromSource = YYConstants.ApplyFromSource.BottomView;
                    YYClickApplyEvent yYClickApplyEvent = new YYClickApplyEvent(applyFromSource, "" + i);
                    yYClickApplyEvent.setShowApplicationDialog(false);
                    LiveEventBus.get("common_apply_seat").post(yYClickApplyEvent);
                    RecordingStudioFragment.this.W();
                }
            });
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Logger.e("RecordingStudioFragment", "loc_x = " + iArr[0] + " ; loc_y = " + iArr[1]);
        int width = view.getWidth();
        int height = view.getHeight();
        linearLayout.measure(0, 0);
        int measuredWidth = linearLayout.getMeasuredWidth();
        int measuredHeight = linearLayout.getMeasuredHeight();
        int i2 = width / 2;
        int i3 = measuredWidth / 2;
        int i4 = height / 2;
        int a = DensityUtils.a(getContext(), 6.0f);
        int i5 = iArr[0] + (i2 - i3);
        int i6 = iArr[1] + i4 + a;
        Logger.e("RecordingStudioFragment", "moveX = " + i5 + " ; moveY = " + i6);
        PopupWindow popupWindow = new PopupWindow(linearLayout, measuredWidth, measuredHeight);
        this.aj = popupWindow;
        popupWindow.setFocusable(true);
        this.aj.setOutsideTouchable(true);
        this.aj.setBackgroundDrawable(new ColorDrawable(0));
        this.aj.showAtLocation(getActivity().getWindow().getDecorView(), 0, i5, i6);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.RecordingStudioFragment.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                RecordingStudioFragment.this.a(yYSeatMemberModel, i);
                RecordingStudioFragment.this.W();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, boolean z, YYMsgKickInfoExtra yYMsgKickInfoExtra) {
        Logger.e("RecordingStudioFragment", "leaveRoom 1 ... ");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        W();
        z();
        YYRoomInfoManager.e().C();
        Logger.e("RecordingStudioFragment", "leaveRoom 2 ... ");
        if (YYRoomInfoManager.e().b() == null || !TextUtils.equals(YYRoomInfoManager.e().b().chat_type, "9")) {
            c(str, z, yYMsgKickInfoExtra);
        } else if (z) {
            g(str);
        } else {
            c(str, z, yYMsgKickInfoExtra);
        }
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
        LiveAlterDialog.b(getContext(), inflate, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.RecordingStudioFragment.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b == null) {
                    return;
                }
                EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_REFUSE_CLICK, b.room_id, b.uid);
                YYRoomHttpUtils.f(b.room_id, 0, RecordingStudioFragment.this.V(), RecordingStudioFragment.this.getFragmentActive());
            }
        }, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.RecordingStudioFragment.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b == null) {
                    return;
                }
                EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_ACCEPT_CLICK, b.room_id, b.uid);
                YYRoomHttpUtils.f(b.room_id, 1, RecordingStudioFragment.this.V(), RecordingStudioFragment.this.getFragmentActive());
            }
        }, true, false);
    }

    private void c(final String str, final boolean z, final YYMsgKickInfoExtra yYMsgKickInfoExtra) {
        YYRoomHttpUtils.m(str, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Object>>(getFragmentActive()) { // from class: com.blued.android.module.yy_china.fragment.RecordingStudioFragment.3
            Dialog a = null;

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                LiveLogUtils.a("RecordingStudioFragment --> requestCloseRoom --> 关闭房间接口请求成功 ...");
                Logger.e("RecordingStudioFragment", "leaveRoom 3 ... ");
                RecordingStudioFragment.this.K();
                Logger.e("RecordingStudioFragment", "leaveRoom 4 ... ");
                RecordingStudioFragment.this.a(str, z, yYMsgKickInfoExtra);
                DialogUtils.b(this.a);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str2) {
                LiveLogUtils.a("RecordingStudioFragment --> requestCloseRoom --> 关闭房间接口请求失败 ... errorMessage：" + str2);
                DialogUtils.b(this.a);
                return super.onUIFailure(i, str2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z2) {
                super.onUIFinish(z2);
                DialogUtils.b(this.a);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                Dialog a = DialogUtils.a(RecordingStudioFragment.this.getContext());
                this.a = a;
                DialogUtils.a(a);
            }
        }, (IRequestHost) getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        b(str, true, (YYMsgKickInfoExtra) null);
    }

    private void g(String str) {
        YYRoomInfoManager.e().a(str, new BluedUIHttpResponse<BluedEntityA<Object>>(getFragmentActive()) { // from class: com.blued.android.module.yy_china.fragment.RecordingStudioFragment.4
            Dialog a = null;

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                RecordingStudioFragment.this.K();
                YYRoomInfoManager.e().x();
                RecordingStudioFragment.this.getActivity().finish();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str2) {
                LiveLogUtils.a("RecordingStudioFragment --> leaveRoom --> 退出直播间接口请求失败 ... errorMessage： " + str2);
                DialogUtils.b(this.a);
                return super.onUIFailure(i, str2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                DialogUtils.b(this.a);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                Dialog a = DialogUtils.a(RecordingStudioFragment.this.getContext());
                this.a = a;
                DialogUtils.a(a);
            }
        }, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(String str) {
        if (this.N != null) {
            this.N.setVisibility(0);
            TextView textView = this.N;
            textView.setText("" + str);
        }
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseYYStudioFragment
    public void A() {
        LiveEventBus.get("invite_seat_msg", YYImModel.class).observe(this, new Observer<YYImModel>() { // from class: com.blued.android.module.yy_china.fragment.RecordingStudioFragment.5
            /* renamed from: a */
            public void onChanged(YYImModel yYImModel) {
                final YYAudienceModel yYAudienceModel;
                if (YYRoomInfoManager.e().c().a(RecordingStudioFragment.this.getContext(), (View.OnClickListener) null) || (yYAudienceModel = yYImModel.source_profile) == null) {
                    return;
                }
                final YYMsgMicInfoExtra yYMsgMicInfoExtra = (YYMsgMicInfoExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgMicInfoExtra.class);
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b != null) {
                    EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_INVITE_POP_SHOW, b.room_id, b.uid);
                }
                LiveLogUtils.a("RecordingStudioFragment --> EVENT_INVITE_SEAT_MSG --> 申请麦克风权限 --> yyAudienceModel：" + AppInfo.f().toJson(yYAudienceModel));
                PermissionHelper.a(new PermissionCallbacks() { // from class: com.blued.android.module.yy_china.fragment.RecordingStudioFragment.5.1
                    @Override // com.blued.android.framework.permission.PermissionCallbacks
                    public void U_() {
                        LiveLogUtils.a("RecordingStudioFragment --> EVENT_INVITE_SEAT_MSG --> 授权麦克风权限 ... ");
                        if (yYAudienceModel == null || yYMsgMicInfoExtra == null) {
                            return;
                        }
                        RecordingStudioFragment.this.c(yYAudienceModel.getName(), yYMsgMicInfoExtra.position);
                    }

                    @Override // com.blued.android.framework.permission.PermissionCallbacks
                    public void a(String[] strArr) {
                        LiveLogUtils.a("RecordingStudioFragment --> EVENT_INVITE_SEAT_MSG --> 拒绝麦克风权限 ... ");
                        AppMethods.a((CharSequence) "麦克风已被禁用，请在设置中授权麦克风使用");
                    }
                });
            }
        });
        LiveEventBus.get("late_reject_msg", String.class).observe(this, new Observer<String>() { // from class: com.blued.android.module.yy_china.fragment.RecordingStudioFragment.6
            /* renamed from: a */
            public void onChanged(String str) {
                ToastUtils.a(str + "暂时不方便上麦", 0);
            }
        });
        LiveEventBus.get("down_seat_msg", YYAudienceModel.class).observe(this, new Observer<YYAudienceModel>() { // from class: com.blued.android.module.yy_china.fragment.RecordingStudioFragment.7
            /* renamed from: a */
            public void onChanged(YYAudienceModel yYAudienceModel) {
                if (yYAudienceModel != null) {
                    ToastUtils.a(yYAudienceModel.getName() + "已下麦", 0);
                    YYRoomModel b = YYRoomInfoManager.e().b();
                    if (b == null || !TextUtils.equals(yYAudienceModel.getUid(), b.uid)) {
                        return;
                    }
                    EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_OWNER_OUT_MIKE_TOAST_SHOW, b.room_id, b.uid);
                }
            }
        });
        LiveEventBus.get("close_living_room", YYMsgKickInfoExtra.class).observe(this, new Observer<YYMsgKickInfoExtra>() { // from class: com.blued.android.module.yy_china.fragment.RecordingStudioFragment.8
            /* renamed from: a */
            public void onChanged(YYMsgKickInfoExtra yYMsgKickInfoExtra) {
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b == null) {
                    return;
                }
                if (yYMsgKickInfoExtra == null || TextUtils.isEmpty(yYMsgKickInfoExtra.message)) {
                    LiveLogUtils.a("RecordingStudioFragment --> EVENT_CLOSE_LIVING_ROOM --> 收到关闭房间消息 --> room id：" + b.room_id);
                    return;
                }
                LiveLogUtils.a("RecordingStudioFragment --> EVENT_CLOSE_LIVING_ROOM --> 收到关闭房间消息 --> 违规信息：" + AppInfo.f().toJson(yYMsgKickInfoExtra) + " --> room_id：" + b.room_id);
                RecordingStudioFragment.this.b(b.room_id, false, yYMsgKickInfoExtra);
            }
        });
        LiveEventBus.get("show_create_pk", String.class).observe(this, new Observer<String>() { // from class: com.blued.android.module.yy_china.fragment.RecordingStudioFragment.9
            /* renamed from: a */
            public void onChanged(String str) {
                YYCreatePKView yYCreatePKView = new YYCreatePKView(RecordingStudioFragment.this.getContext());
                yYCreatePKView.a(RecordingStudioFragment.this);
                RecordingStudioFragment.this.a(yYCreatePKView, -2);
            }
        });
        LiveEventBus.get("show_create_wish", String.class).observe(this, new Observer<String>() { // from class: com.blued.android.module.yy_china.fragment.RecordingStudioFragment.10
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.blued.android.module.yy_china.view.YYCreateWishView, android.view.View] */
            /* renamed from: a */
            public void onChanged(String str) {
                ?? yYCreateWishView = new YYCreateWishView(RecordingStudioFragment.this.getContext());
                yYCreateWishView.a(RecordingStudioFragment.this);
                RecordingStudioFragment.this.a((View) yYCreateWishView, -2);
            }
        });
        LiveEventBus.get("show_room_pk_invitation", YYMatchingRoomModel.class).observe(this, new Observer<YYMatchingRoomModel>() { // from class: com.blued.android.module.yy_china.fragment.RecordingStudioFragment.11
            /* renamed from: a */
            public void onChanged(final YYMatchingRoomModel yYMatchingRoomModel) {
                View inflate = LayoutInflater.from(RecordingStudioFragment.this.getContext()).inflate(R.layout.dialog_invite_pk_layout, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.tv_invite_from);
                String string = RecordingStudioFragment.this.getResources().getString(R.string.yy_msg_invite_pk_description);
                textView.setText(String.format(string, "「" + yYMatchingRoomModel.name + "」"));
                final Dialog b = LiveAlterDialog.b(RecordingStudioFragment.this.getContext(), inflate, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.RecordingStudioFragment.11.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        YYRoomModel b2 = YYRoomInfoManager.e().b();
                        if (b2 == null) {
                            return;
                        }
                        RecordingStudioFragment.this.a(b2.room_id, yYMatchingRoomModel.room_id, yYMatchingRoomModel.uid, 0);
                    }
                }, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.RecordingStudioFragment.11.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        YYRoomModel b2 = YYRoomInfoManager.e().b();
                        if (b2 == null) {
                            return;
                        }
                        RecordingStudioFragment.this.a(b2.room_id, yYMatchingRoomModel.room_id, yYMatchingRoomModel.uid, 1);
                    }
                }, false, false);
                RecordingStudioFragment.this.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.fragment.RecordingStudioFragment.11.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Dialog dialog = b;
                        if (dialog == null || !dialog.isShowing()) {
                            return;
                        }
                        ToastUtils.a("该邀请已过期", 0);
                        b.cancel();
                    }
                }, LockPatternUtils.FAILED_ATTEMPT_TIMEOUT_MS);
            }
        });
        LiveEventBus.get("EVENT_EVEN_HOST_CREATE_TIME", String.class).observe(this, new Observer() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$RecordingStudioFragment$6Pz3jxguKg6OKsnJSXbk5FDinCc
            public final void onChanged(Object obj) {
                RecordingStudioFragment.this.h((String) obj);
            }
        });
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseYYStudioFragment
    public void B() {
        y();
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || !TextUtils.equals(b.chat_type, "9")) {
            G();
        } else {
            new YYCloseMenuDialog(this, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.RecordingStudioFragment.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    YYRoomModel b2 = YYRoomInfoManager.e().b();
                    if (b2 == null) {
                        return;
                    }
                    RecordingStudioFragment.this.f(b2.room_id);
                }
            }).show(getParentFragmentManager(), "show_close_dialog");
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
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseYYStudioFragment
    protected void E() {
        if (YYRoomInfoManager.e().i()) {
            this.o.a(false);
        } else {
            this.o.a(true);
        }
        LiveMusicModel a = YYMusicManager.a.c().a();
        if (a != null) {
            a(a);
        }
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseYYStudioFragment
    public int F() {
        return 1;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseYYStudioFragment
    public void G() {
        LiveLogUtils.a("RecordingStudioFragment --> closeChannel --> 主播点击关闭房间 ...");
        LiveAlterDialog.a(getContext(), R.layout.dialog_end_layout, (View.OnClickListener) null, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.RecordingStudioFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveLogUtils.a("RecordingStudioFragment --> closeChannel --> 关闭房间dialog显示 ...");
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b == null) {
                    return;
                }
                RecordingStudioFragment.this.f(b.room_id);
            }
        }, true, false);
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseYYStudioFragment
    public void H() {
        YYBroadcastView yYBroadcastView = new YYBroadcastView();
        yYBroadcastView.a(this, true, true);
        yYBroadcastView.show(getChildFragmentManager(), "broadcastView");
        O().a(-5);
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseYYStudioFragment
    protected boolean I() {
        return true;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseYYStudioFragment
    public void J() {
        if (this.F) {
            AudioChannelManager.j().a(L());
            return;
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || YYRoomInfoManager.e().a == null) {
            return;
        }
        YYAudioConfig yYAudioConfig = new YYAudioConfig();
        yYAudioConfig.c = YYRoomInfoManager.e().k();
        yYAudioConfig.b = b.room_id;
        int i = 21;
        if (TextUtils.equals(b.chat_type, "9")) {
            if (b.getSeatMember(yYAudioConfig.c) != null) {
                i = 20;
            }
            yYAudioConfig.d = i;
        } else {
            if (YYRoomInfoManager.e().a.chat_anchor.equals("1")) {
                i = 20;
            }
            yYAudioConfig.d = i;
        }
        yYAudioConfig.a = b.user_sig;
        if (yYAudioConfig.d == 20) {
            yYAudioConfig.e = 1;
        }
        yYAudioConfig.f = System.currentTimeMillis();
        Logger.b("ulog", "主态 getUserInfo -- role  " + yYAudioConfig.d + "  uid " + yYAudioConfig.c);
        StringBuilder sb = new StringBuilder();
        sb.append("RecordingStudioFragment --> initAudioEngine --> YYAudioConfig：");
        sb.append(AppInfo.f().toJson(yYAudioConfig));
        LiveLogUtils.a(sb.toString());
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

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void a() {
        this.p.setPlaying(true);
        if (this.p.a == null) {
            l().a(3, "");
        } else {
            l().a(3, this.p.a.cover);
        }
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseYYStudioFragment
    public void a(View view, YYSeatMemberModel yYSeatMemberModel, int i) {
        if (view == null || yYSeatMemberModel == null) {
            return;
        }
        if (yYSeatMemberModel.position_status != 1) {
            b(view, yYSeatMemberModel, i);
            return;
        }
        String uid = yYSeatMemberModel.getUid();
        String name = yYSeatMemberModel.getName();
        String avatar = yYSeatMemberModel.getAvatar();
        a(uid, name, avatar, F() + "", true);
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
        if (this.p.a == null) {
            l().a(3, "");
        } else {
            l().a(2, this.p.a.cover);
        }
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseYYStudioFragment
    public void d(int i) {
        ApplyCloseRoomView applyCloseRoomView = new ApplyCloseRoomView(getContext());
        applyCloseRoomView.a(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.RecordingStudioFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                RecordingStudioFragment.this.y();
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b == null) {
                    return;
                }
                RecordingStudioFragment.this.f(b.room_id);
            }
        }, this);
        applyCloseRoomView.a(i);
        a((View) applyCloseRoomView, -2, 17, false);
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseYYStudioFragment
    public void d(String str) {
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

    @Override // com.blued.android.module.yy_china.fragment.BaseYYStudioFragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseYYStudioFragment, com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        return super.onBackPressed();
    }
}

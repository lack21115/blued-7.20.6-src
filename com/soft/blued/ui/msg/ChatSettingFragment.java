package com.soft.blued.ui.msg;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.sdk.model.EmptyModel;
import com.blued.das.message.MessageProtos;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.customview.LabeledTextView;
import com.soft.blued.fragment.CommonWriteTextFragment;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.manager.SubscribeNumberManager;
import com.soft.blued.ui.msg.pop.PopSpecialCare;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.ui.user.fragment.ReportUserFragment;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.fragment.VipBubbleFragment;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.user.utils.BlackConfirmUtil;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/ChatSettingFragment.class */
public class ChatSettingFragment extends BaseFragment implements View.OnClickListener {
    private Context A;
    private Bundle B;
    private String C;
    private String D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private String L;
    private SessionModel N;
    private UserBasicModel O;
    private boolean P;
    private RelativeLayout Q;
    private LinearLayout R;
    private RelativeLayout S;
    private ShapeTextView T;
    private ImageView U;
    private ImageView V;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private View f17998c;
    private TextView d;
    private ImageView e;
    private ImageView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private ImageView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private LabeledTextView n;
    private ToggleButton o;
    private LabeledTextView p;
    private LinearLayout q;
    private TextView r;
    private ImageView s;
    private View t;
    private Dialog v;
    private String w;
    private short x;
    private SessionSettingModel y;
    private View z;

    /* renamed from: a  reason: collision with root package name */
    private String f17997a = ChatSettingFragment.class.getSimpleName();
    private boolean u = false;
    private String K = "";
    private String[] M = AppInfo.d().getResources().getStringArray(R.array.report_items);

    private void a() {
        CommonTopTitleNoTrans findViewById = this.z.findViewById(R.id.top_title);
        findViewById.a();
        findViewById.setCenterText(getString(R.string.biao_v4_chatsetting_title));
        findViewById.setLeftClickListener(this);
    }

    private void a(final String str) {
        UserHttpUtils.b(str, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<EmptyModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.msg.ChatSettingFragment.7
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<EmptyModel> bluedEntityA) {
                if (bluedEntityA.code == 40350001) {
                    AppMethods.d((int) R.string.msg_special_care_max_toast);
                    MessageProtos.Event event = MessageProtos.Event.MSG_SETTINGS_SPECIAL_CARE_LIMIT_SHOW;
                    EventTrackMessage.e(event, str + "");
                    return;
                }
                ChatSettingFragment.this.V.setSelected(true);
                ChatSettingFragment.this.K = "1";
                if (ChatSettingFragment.this.y != null) {
                    ChatSettingFragment.this.y.setSessionCommonStatus("1");
                    ChatManager.getInstance().setSessionSetting(ChatSettingFragment.this.y.getSessionType(), ChatSettingFragment.this.y.getSessionId(), ChatSettingFragment.this.y);
                    return;
                }
                SessionSettingModel sessionSettingModel = new SessionSettingModel();
                sessionSettingModel.setLoadName(Long.valueOf(UserInfo.getInstance().getLoginUserInfo().getUid()).longValue());
                sessionSettingModel.setSessionId(Long.valueOf(str).longValue());
                sessionSettingModel.setSessionType(ChatSettingFragment.this.x);
                sessionSettingModel.setSessionCommonStatus("1");
                ChatManager.getInstance().setSessionSetting(sessionSettingModel.getSessionType(), sessionSettingModel.getSessionId(), sessionSettingModel);
            }
        }, (IRequestHost) getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        GroupHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.msg.ChatSettingFragment.4
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), this.w, z, (IRequestHost) null);
    }

    private void b() {
        this.b = this.z.findViewById(R.id.rl_detail_setting);
        this.e = (ImageView) this.z.findViewById(R.id.chat_setting_avatar);
        this.f = (ImageView) this.z.findViewById(R.id.chat_setting_avatar_v);
        this.f17998c = this.z.findViewById(R.id.chat_setting_remark_root);
        this.g = (TextView) this.z.findViewById(R.id.chat_setting_remark);
        this.d = (TextView) this.z.findViewById(R.id.chat_setting_nickname);
        this.h = (TextView) this.z.findViewById(R.id.chat_setting_nickname_or_note);
        this.j = (ImageView) this.z.findViewById(2131364726);
        TextView textView = (TextView) this.z.findViewById(R.id.chat_setting_id);
        this.i = textView;
        textView.setVisibility(8);
        this.m = (TextView) this.z.findViewById(R.id.chat_setting_report);
        this.l = (TextView) this.z.findViewById(R.id.chat_setting_toblack);
        LabeledTextView labeledTextView = (LabeledTextView) this.z.findViewById(R.id.chat_setting_bg);
        this.n = labeledTextView;
        labeledTextView.a(Boolean.valueOf(BluedPreferences.e(0)));
        this.k = (TextView) this.z.findViewById(R.id.chat_setting_clearchat);
        this.o = (ToggleButton) this.z.findViewById(R.id.msg_setting_nocall_toggle);
        ImageView imageView = (ImageView) this.z.findViewById(R.id.msg_setting_lie_top);
        this.s = imageView;
        imageView.setOnClickListener(this);
        LabeledTextView labeledTextView2 = (LabeledTextView) this.z.findViewById(R.id.chat_setting_bubble);
        this.p = labeledTextView2;
        labeledTextView2.a(Boolean.valueOf(BluedPreferences.dF()));
        this.t = this.z.findViewById(R.id.red_point);
        if (!BluedPreferences.bX()) {
            this.t.setVisibility(0);
        }
        this.Q = (RelativeLayout) this.z.findViewById(R.id.rl_lie_top);
        this.R = (LinearLayout) this.z.findViewById(R.id.ll_setting_report);
        this.S = (RelativeLayout) this.z.findViewById(R.id.rl_special_care);
        this.T = this.z.findViewById(R.id.tv_special_care_remind);
        this.U = (ImageView) this.z.findViewById(R.id.iv_special_care_tips);
        ImageView imageView2 = (ImageView) this.z.findViewById(R.id.msg_setting_special_care);
        this.V = imageView2;
        imageView2.setOnClickListener(this);
        this.q = (LinearLayout) this.z.findViewById(R.id.ll_no_call);
        this.r = (TextView) this.z.findViewById(R.id.tv_no_call_line);
        this.b.setOnClickListener(this);
        this.f17998c.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.k.setOnClickListener(this);
    }

    private void b(final String str) {
        UserHttpUtils.c(str, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<EmptyModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.msg.ChatSettingFragment.8
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<EmptyModel> bluedEntityA) {
                ChatSettingFragment.this.V.setSelected(false);
                ChatSettingFragment.this.K = "0";
                if (ChatSettingFragment.this.y != null) {
                    ChatSettingFragment.this.y.setSessionCommonStatus("0");
                    ChatManager.getInstance().setSessionSetting(ChatSettingFragment.this.y.getSessionType(), ChatSettingFragment.this.y.getSessionId(), ChatSettingFragment.this.y);
                    return;
                }
                SessionSettingModel sessionSettingModel = new SessionSettingModel();
                sessionSettingModel.setLoadName(Long.valueOf(UserInfo.getInstance().getLoginUserInfo().getUid()).longValue());
                sessionSettingModel.setSessionId(Long.valueOf(str).longValue());
                sessionSettingModel.setSessionType(ChatSettingFragment.this.x);
                sessionSettingModel.setSessionCommonStatus("0");
                ChatManager.getInstance().setSessionSetting(sessionSettingModel.getSessionType(), sessionSettingModel.getSessionId(), sessionSettingModel);
            }
        }, (IRequestHost) getFragmentActive());
    }

    private void c() {
        this.v = DialogUtils.a(this.A);
        Bundle arguments = getArguments();
        this.B = arguments;
        if (arguments != null) {
            this.w = arguments.getString("passby_session_id");
            this.x = this.B.getShort("passby_session_type");
            this.L = this.B.getString("passby_is_in_blacklist");
            this.C = this.B.getString("passby_nick_name");
            this.D = this.B.getString("passby_nick_note");
            this.J = this.B.getInt("passby_remind_audio");
            this.E = this.B.getInt("passby_vip_grade");
            this.F = this.B.getInt("passby_is_vip_annual");
            this.G = this.B.getInt("passby_vip_exp_lvl");
            this.I = this.B.getInt("passby_show_vip_page");
            this.H = this.B.getInt("passby_is_hide_vip_look");
            this.O = this.B.getSerializable("user");
            this.P = this.B.getBoolean("IS_FROM_MSG_BOX", false);
            UserBasicModel userBasicModel = this.O;
            if (userBasicModel == null || userBasicModel.is_official != 1) {
                this.l.setVisibility(0);
            } else {
                this.l.setVisibility(8);
            }
            SessionModel snapSessionModel = ChatManager.getInstance().getSnapSessionModel(this.x, Long.valueOf(this.w).longValue());
            this.N = snapSessionModel;
            if (snapSessionModel != null) {
                this.y = snapSessionModel.sessionSettingModel;
                this.s.setSelected(this.N.lieTop == 1);
            } else {
                ChatManager.getInstance().getSessionModel(this.x, Long.valueOf(this.w).longValue(), new FetchDataListener<SessionModel>() { // from class: com.soft.blued.ui.msg.ChatSettingFragment.1
                    /* renamed from: a */
                    public void onFetchData(SessionModel sessionModel) {
                        if (sessionModel == null) {
                            return;
                        }
                        ChatSettingFragment.this.N = sessionModel;
                        ChatSettingFragment.this.y = sessionModel.sessionSettingModel;
                        ImageView imageView = ChatSettingFragment.this.s;
                        boolean z = true;
                        if (sessionModel.lieTop != 1) {
                            z = false;
                        }
                        imageView.setSelected(z);
                    }
                });
            }
            if (StringUtils.d(this.C) || StringUtils.d(this.D)) {
                if (StringUtils.d(this.C)) {
                    TextView textView = this.h;
                    textView.setText(this.w + "");
                } else {
                    this.h.setText(this.C);
                }
                this.d.setVisibility(8);
            } else {
                this.h.setText(this.D);
                TextView textView2 = this.d;
                textView2.setText(((Object) this.A.getResources().getText(2131886636)) + ": " + this.C);
                this.g.setText(this.D);
            }
            UserBasicModel userBasicModel2 = new UserBasicModel();
            userBasicModel2.vip_grade = this.E;
            userBasicModel2.is_vip_annual = this.F;
            userBasicModel2.is_hide_vip_look = this.H;
            userBasicModel2.vip_exp_lvl = this.G;
            UserRelationshipUtils.a(this.A, this.h, userBasicModel2);
            UserRelationshipUtils.a(this.j, userBasicModel2);
            TextView textView3 = this.i;
            textView3.setText("ID: " + this.w);
            if (this.J == 0) {
                this.o.setChecked(false);
            } else {
                this.o.setChecked(true);
            }
            SessionSettingModel sessionSettingModel = this.y;
            if (sessionSettingModel == null || TextUtils.isEmpty(sessionSettingModel.getSessionCommonStatus()) || !TextUtils.equals(this.y.getSessionCommonStatus(), "1")) {
                this.V.setSelected(false);
                this.K = "";
            } else {
                this.V.setSelected(true);
                this.K = this.y.getSessionCommonStatus();
            }
            this.o.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.msg.ChatSettingFragment.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    Tracker.onCheckedChanged(compoundButton, z);
                    if (z) {
                        ChatSettingFragment.this.J = 1;
                        if (ChatSettingFragment.this.y != null) {
                            ChatSettingFragment.this.y.setRemindAudio(1);
                            ChatManager.getInstance().setSessionSetting(ChatSettingFragment.this.y.getSessionType(), ChatSettingFragment.this.y.getSessionId(), ChatSettingFragment.this.y);
                        } else {
                            SessionSettingModel sessionSettingModel2 = new SessionSettingModel();
                            sessionSettingModel2.setLoadName(Long.valueOf(UserInfo.getInstance().getLoginUserInfo().getUid()).longValue());
                            sessionSettingModel2.setSessionId(Long.valueOf(ChatSettingFragment.this.w).longValue());
                            sessionSettingModel2.setSessionType(ChatSettingFragment.this.x);
                            sessionSettingModel2.setRemindAudio(1);
                            ChatManager.getInstance().setSessionSetting(sessionSettingModel2.getSessionType(), sessionSettingModel2.getSessionId(), sessionSettingModel2);
                        }
                    } else {
                        ChatSettingFragment.this.J = 0;
                        if (ChatSettingFragment.this.y != null) {
                            ChatSettingFragment.this.y.setRemindAudio(0);
                            ChatManager.getInstance().setSessionSetting(ChatSettingFragment.this.y.getSessionType(), ChatSettingFragment.this.y.getSessionId(), ChatSettingFragment.this.y);
                        } else {
                            SessionSettingModel sessionSettingModel3 = new SessionSettingModel();
                            sessionSettingModel3.setLoadName(Long.valueOf(UserInfo.getInstance().getLoginUserInfo().getUid()).longValue());
                            sessionSettingModel3.setSessionId(Long.valueOf(ChatSettingFragment.this.w).longValue());
                            sessionSettingModel3.setSessionType(ChatSettingFragment.this.x);
                            sessionSettingModel3.setRemindAudio(0);
                            ChatManager.getInstance().setSessionSetting(sessionSettingModel3.getSessionType(), sessionSettingModel3.getSessionId(), sessionSettingModel3);
                        }
                    }
                    ChatSettingFragment.this.a(z);
                }
            });
            ImageLoader.a(getFragmentActive(), this.B.getString("passby_avatar")).c().b(2131237310).a(this.e);
            UserInfoHelper.a(this.f, this.B.getInt("passby_vbadge"), 3);
            if (StringUtils.d(this.L) || !this.L.equals("1")) {
                this.l.setText(getResources().getString(R.string.biao_v4_chat_setting_toblack));
            } else {
                this.l.setText(getResources().getString(R.string.remove_from_black));
            }
        }
        if (this.P) {
            this.q.setVisibility(8);
            this.r.setVisibility(8);
        }
        if (SubscribeNumberManager.f18759a.a(this.w, Short.valueOf(this.x))) {
            this.f17998c.setVisibility(8);
            this.Q.setVisibility(8);
            this.R.setVisibility(8);
            this.l.setVisibility(8);
        }
        this.U.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.ChatSettingFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                new XPopup.Builder(ChatSettingFragment.this.A).a(PopupAnimation.a).d(true).a(new PopSpecialCare(ChatSettingFragment.this.A)).h();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c(String str) {
        String str2 = str;
        if (StringUtils.d(str)) {
            str2 = "";
        }
        Bundle bundle = new Bundle();
        bundle.putString(DownloadSettingKeys.RetryScheduleConfig.MAX_COUNT, BaseWrapper.ENTER_ID_SYSTEM_HELPER);
        bundle.putString("string_edit_hint", getResources().getString(R.string.please_input_user_comment));
        bundle.putString("string_edit", str2);
        bundle.putString("string_center", getResources().getString(R.string.common_string_notice));
        bundle.putBoolean("im_note", true);
        TerminalActivity.a(this, CommonWriteTextFragment.class, bundle, 100);
    }

    private void d() {
        Intent intent = new Intent();
        intent.putExtra("result_delete_msg", this.u);
        intent.putExtra("passby_is_in_blacklist", this.L);
        getActivity().setResult(-1, intent);
        getActivity().finish();
        if (BluedPreferences.bX()) {
            return;
        }
        BluedPreferences.bY();
        this.t.setVisibility(8);
    }

    private void e() {
        if (StringUtils.d(this.L) || this.L.equals("0")) {
            BlackConfirmUtil.f20634a.a(getContext(), this.K, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.ChatSettingFragment.9
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    UserHttpUtils.b((Context) ChatSettingFragment.this.getActivity(), (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Object>>(ChatSettingFragment.this.getFragmentActive()) { // from class: com.soft.blued.ui.msg.ChatSettingFragment.9.1
                        /* JADX INFO: Access modifiers changed from: protected */
                        /* renamed from: a */
                        public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                            AppMethods.d((int) R.string.add_black_success);
                            ChatSettingFragment.this.L = "1";
                            if (ChatSettingFragment.this.l != null && ChatSettingFragment.this.getActivity() != null) {
                                ChatSettingFragment.this.l.setText(ChatSettingFragment.this.getActivity().getResources().getString(R.string.remove_from_black));
                            }
                            ChatHelperV4.a().b(Long.valueOf(ChatSettingFragment.this.w).longValue());
                            UserInfoEntity userInfoEntity = new UserInfoEntity();
                            userInfoEntity.uid = ChatSettingFragment.this.w;
                            userInfoEntity.relationship = "4";
                            LiveEventBus.get("feed_relation_ship").post(userInfoEntity);
                            HomeArgumentHelper.a(ChatSettingFragment.this.A, "msg", (Bundle) null);
                        }

                        public boolean onUIFailure(int i2, String str) {
                            if (i2 == 403902) {
                                BlackConfirmUtil.f20634a.a(ChatSettingFragment.this.getContext());
                                return true;
                            }
                            return super.onUIFailure(i2, str);
                        }

                        public void onUIFinish() {
                            super.onUIFinish();
                            DialogUtils.b(ChatSettingFragment.this.v);
                        }

                        public void onUIStart() {
                            DialogUtils.a(ChatSettingFragment.this.v);
                            super.onUIStart();
                        }
                    }, UserInfo.getInstance().getLoginUserInfo().getUid(), ChatSettingFragment.this.w, (IRequestHost) ChatSettingFragment.this.getFragmentActive());
                }
            });
        } else {
            UserHttpUtils.c(getActivity(), new BluedUIHttpResponse<BluedEntityA<Object>>(getFragmentActive()) { // from class: com.soft.blued.ui.msg.ChatSettingFragment.10
                /* JADX INFO: Access modifiers changed from: protected */
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                    DialogUtils.b(ChatSettingFragment.this.v);
                    AppMethods.d((int) R.string.remove_black_success);
                    ChatSettingFragment.this.L = "0";
                    ChatSettingFragment.this.l.setText(ChatSettingFragment.this.getActivity().getResources().getString(R.string.biao_v4_chat_setting_toblack));
                    UserInfoEntity userInfoEntity = new UserInfoEntity();
                    userInfoEntity.uid = ChatSettingFragment.this.w;
                    userInfoEntity.relationship = "0";
                    LiveEventBus.get("feed_relation_ship").post(userInfoEntity);
                }

                public void onUIFinish() {
                    super.onUIFinish();
                    DialogUtils.b(ChatSettingFragment.this.v);
                }

                public void onUIStart() {
                    super.onUIStart();
                    DialogUtils.a(ChatSettingFragment.this.v);
                }
            }, UserInfo.getInstance().getLoginUserInfo().getUid(), this.w, getFragmentActive());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 100:
                    if (intent != null) {
                        final String stringExtra = intent.getStringExtra("string_edit");
                        MineHttpUtils.h(getActivity(), new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.msg.ChatSettingFragment.11
                            /* JADX INFO: Access modifiers changed from: protected */
                            /* renamed from: a */
                            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                                DialogUtils.b(ChatSettingFragment.this.v);
                                AppMethods.d((int) R.string.modify_note_success);
                                if (StringUtils.d(ChatSettingFragment.this.C) || StringUtils.d(stringExtra)) {
                                    if (StringUtils.d(ChatSettingFragment.this.C)) {
                                        TextView textView = ChatSettingFragment.this.h;
                                        textView.setText(ChatSettingFragment.this.w + "");
                                    } else {
                                        ChatSettingFragment.this.h.setText(ChatSettingFragment.this.C);
                                    }
                                    ChatSettingFragment.this.d.setVisibility(8);
                                    ChatSettingFragment.this.g.setText("");
                                } else {
                                    ChatSettingFragment.this.h.setText(stringExtra);
                                    TextView textView2 = ChatSettingFragment.this.d;
                                    textView2.setText(((Object) ChatSettingFragment.this.A.getResources().getText(2131886636)) + ": " + ChatSettingFragment.this.C);
                                    ChatSettingFragment.this.d.setVisibility(0);
                                    ChatSettingFragment.this.g.setText(stringExtra);
                                }
                                if (ChatSettingFragment.this.y != null) {
                                    ChatSettingFragment.this.y.setSessinoNote(StringUtils.d(stringExtra) ? "" : stringExtra);
                                    ChatManager.getInstance().setSessionSetting(ChatSettingFragment.this.y.getSessionType(), ChatSettingFragment.this.y.getSessionId(), ChatSettingFragment.this.y);
                                    return;
                                }
                                SessionSettingModel sessionSettingModel = new SessionSettingModel();
                                sessionSettingModel.setLoadName(Long.valueOf(UserInfo.getInstance().getLoginUserInfo().getUid()).longValue());
                                sessionSettingModel.setSessionId(Long.parseLong(ChatSettingFragment.this.w));
                                sessionSettingModel.setSessionType(ChatSettingFragment.this.x);
                                sessionSettingModel.setSessinoNote(StringUtils.d(stringExtra) ? "" : stringExtra);
                                ChatManager.getInstance().setSessionSetting(ChatSettingFragment.this.x, Long.parseLong(ChatSettingFragment.this.w), sessionSettingModel);
                            }

                            public void onUIFinish() {
                                super.onUIFinish();
                                DialogUtils.b(ChatSettingFragment.this.v);
                            }

                            public void onUIStart() {
                                super.onUIStart();
                                DialogUtils.a(ChatSettingFragment.this.v);
                            }
                        }, UserInfo.getInstance().getLoginUserInfo().getUid(), stringExtra, this.w, getFragmentActive());
                        return;
                    }
                    return;
                case 101:
                    if (intent == null || intent.getExtras() == null || !intent.getExtras().getBoolean("chat_setting", false)) {
                        return;
                    }
                    getActivity().finish();
                    return;
                case 102:
                    getActivity().setResult(-1, intent);
                    getActivity().finish();
                    return;
                default:
                    return;
            }
        }
    }

    public boolean onBackPressed() {
        d();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        boolean z = true;
        switch (view.getId()) {
            case R.id.chat_setting_bg /* 2131362822 */:
                EventTrackMessage.a(MessageProtos.Event.MSG_CHAT_SET_BACKGROUND_BTN_CLICK, MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, this.w);
                LabeledTextView labeledTextView = this.n;
                if (labeledTextView != null) {
                    labeledTextView.a((Boolean) false);
                }
                BluedPreferences.f(0);
                if (UserInfo.getInstance().getLoginUserInfo().vip_grade != 0 || BluedConfig.a().g().is_chat_backgrounds == 1) {
                    ChatBgSettingFragment.a(this, 0, Long.parseLong(this.w), this.x, 102);
                    return;
                } else {
                    PayUtils.a(this.A, 23, "chat_customize_bg");
                    return;
                }
            case R.id.chat_setting_bubble /* 2131362823 */:
                EventTrackMessage.a(MessageProtos.Event.MSG_SETTINGS_BUBBLE_CLICK);
                if (BluedPreferences.dF()) {
                    BluedPreferences.dG();
                    this.p.a((Boolean) false);
                }
                VipBubbleFragment.a(this.A, 0, "chat_setting_bubble");
                return;
            case R.id.chat_setting_clearchat /* 2131362824 */:
                Context context = this.A;
                CommonAlertDialog.a(context, context.getResources().getString(R.string.biao_new_signin_tip), this.A.getResources().getString(R.string.chat_delete_yesorno), this.A.getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.ChatSettingFragment.5
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                        ChatManager.getInstance().deleteSessionAndChatting((short) 2, Long.valueOf(ChatSettingFragment.this.w).longValue());
                        LiveEventBus.get(EventBusConstant.KEY_EVENT_CHECK_SHOW_HELLO_EXPRESSION).postDelay(null, 500L);
                        ChatSettingFragment.this.u = true;
                    }
                }, this.A.getResources().getString(R.string.common_cancel), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.ChatSettingFragment.6
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                    }
                }, (DialogInterface.OnDismissListener) null);
                return;
            case R.id.chat_setting_remark_root /* 2131362829 */:
                c(((Object) this.g.getText()) + "");
                return;
            case R.id.chat_setting_report /* 2131362830 */:
                FragmentActivity activity = getActivity();
                String str = this.w;
                String str2 = ((Object) this.h.getText()) + "";
                UserBasicModel userBasicModel = this.O;
                boolean z2 = true;
                if (userBasicModel != null) {
                    z2 = userBasicModel.is_official != 1;
                }
                ReportUserFragment.a(activity, str, str2, z2);
                return;
            case R.id.chat_setting_toblack /* 2131362835 */:
                e();
                return;
            case 2131363120:
                d();
                return;
            case R.id.msg_setting_lie_top /* 2131368582 */:
                EventTrackMessage.a(MessageProtos.Event.MSG_TO_UP_BTN_CLICK);
                if (!BluedPreferences.bX()) {
                    BluedPreferences.bY();
                    this.t.setVisibility(8);
                }
                SessionModel sessionModel = this.N;
                if (sessionModel != null) {
                    GroupUtil.a(sessionModel, this.s, (IRequestHost) getFragmentActive());
                    return;
                }
                return;
            case R.id.msg_setting_special_care /* 2131368584 */:
                if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0) {
                    z = TextUtils.equals(this.K, "1");
                    PayUtils.a(this.A, 36, "special_care", VipProtos.FromType.SPECIAL_CARE);
                } else if (TextUtils.equals(this.K, "1")) {
                    b(this.w);
                    z = false;
                } else {
                    a(this.w);
                }
                EventTrackMessage.b(MessageProtos.Event.MSG_SETTINGS_SPECIAL_CARE_CLICK, this.w + "", z);
                return;
            case R.id.rl_detail_setting /* 2131369270 */:
                UserBasicModel userBasicModel2 = new UserBasicModel();
                userBasicModel2.uid = this.w;
                userBasicModel2.is_show_vip_page = this.I;
                Bundle bundle = this.B;
                if (bundle != null) {
                    userBasicModel2.avatar = bundle.getString("passby_avatar");
                }
                if (this.O != null) {
                    userBasicModel2.age = this.O.age + "";
                    userBasicModel2.height = this.O.height + "";
                    userBasicModel2.weight = this.O.weight + "";
                    userBasicModel2.role = this.O.role + "";
                    userBasicModel2.distance = this.O.distance;
                    userBasicModel2.is_hide_distance = this.O.is_hide_distance;
                    userBasicModel2.is_hide_last_operate = this.O.is_hide_last_operate;
                }
                UserInfoFragmentNew.a((Fragment) this, userBasicModel2, "chat_setting", 101);
                return;
            default:
                return;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f17997a = ChatSettingFragment.class.getSimpleName();
        this.A = getActivity();
        View view = this.z;
        if (view == null) {
            this.z = layoutInflater.inflate(R.layout.fragment_chat_setting, viewGroup, false);
            a();
            b();
            c();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.z.getParent()).removeView(this.z);
        }
        return this.z;
    }
}

package com.soft.blued.ui.setting.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.blued.android.module.common.trace.EventTrackSettings;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.das.settings.SettingsProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.BluedConstant;
import com.soft.blued.R;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.utils.BluedPreferences;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/RemindSettingFragment.class */
public class RemindSettingFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private String f33579a = RemindSettingFragment.class.getSimpleName();
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private Context f33580c;
    private LinearLayout d;
    private TextView e;
    private ToggleButton f;
    private ToggleButton g;
    private ToggleButton h;
    private ToggleButton i;
    private ToggleButton j;
    private ToggleButton k;
    private ToggleButton l;
    private ToggleButton m;
    private ToggleButton n;
    private ToggleButton o;
    private ToggleButton p;
    private ToggleButton q;
    private ToggleButton r;
    private ToggleButton s;
    private ToggleButton t;
    private LinearLayout u;
    private LinearLayout v;
    private ToggleButton w;
    private ToggleButton x;
    private ToggleButton y;
    private SessionSettingModel z;

    /* renamed from: com.soft.blued.ui.setting.fragment.RemindSettingFragment$4  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/RemindSettingFragment$4.class */
    class AnonymousClass4 implements FetchDataListener<SessionSettingBaseModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RemindSettingFragment f33584a;

        @Override // com.blued.android.chat.listener.FetchDataListener
        /* renamed from: a */
        public void onFetchData(SessionSettingBaseModel sessionSettingBaseModel) {
            this.f33584a.z = (SessionSettingModel) sessionSettingBaseModel;
            if (this.f33584a.z == null) {
                this.f33584a.z = new SessionSettingModel();
                this.f33584a.z.setLoadName(Long.valueOf(UserInfo.getInstance().getLoginUserInfo().getUid()).longValue());
                this.f33584a.z.setSessionId(2L);
                this.f33584a.z.setSessionType((short) 1);
            }
            this.f33584a.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.setting.fragment.RemindSettingFragment.4.1
                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass4.this.f33584a.n.setChecked(AnonymousClass4.this.f33584a.z.getRemindAudio() == 0);
                    AnonymousClass4.this.f33584a.n.setOnCheckedChangeListener(AnonymousClass4.this.f33584a);
                }
            });
        }
    }

    private void a(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        MineHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.setting.fragment.RemindSettingFragment.3
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), map, (IRequestHost) null);
    }

    private void a(boolean z) {
        if (z) {
            this.d.setVisibility(0);
            this.e.setVisibility(0);
            return;
        }
        this.d.setVisibility(8);
        this.e.setVisibility(8);
    }

    public void a() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.b.findViewById(2131370749);
        commonTopTitleNoTrans.a();
        commonTopTitleNoTrans.f();
        commonTopTitleNoTrans.setCenterText(getString(R.string.remind_setting));
        commonTopTitleNoTrans.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.RemindSettingFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                RemindSettingFragment.this.getActivity().finish();
            }
        });
    }

    public void b() {
        this.u = (LinearLayout) this.b.findViewById(R.id.ll_group_remind_setting);
        if (BluedConstant.f28239a) {
            this.u.setVisibility(8);
        } else {
            this.u.setVisibility(0);
        }
        this.t = (ToggleButton) this.b.findViewById(R.id.tglbtn_other_push);
        this.e = (TextView) this.b.findViewById(R.id.tv_tip_blued_sound);
        this.d = (LinearLayout) this.b.findViewById(R.id.liner_using_blued_hint_onoff);
        this.i = (ToggleButton) this.b.findViewById(R.id.tglbtn_push_notice_onoff);
        this.g = (ToggleButton) this.b.findViewById(R.id.tglbtn_private_chat_hint_onoff);
        this.f = (ToggleButton) this.b.findViewById(R.id.tglbtn_using_blued_hint_onoff);
        this.h = (ToggleButton) this.b.findViewById(R.id.tglbtn_private_chat_vibrate_onoff);
        this.j = (ToggleButton) this.b.findViewById(R.id.tb_onoff_recommend_live);
        this.k = (ToggleButton) this.b.findViewById(R.id.tb_onoff_system);
        this.o = (ToggleButton) this.b.findViewById(R.id.tglbtn_onoff_live_push);
        this.l = (ToggleButton) this.b.findViewById(R.id.tb_onoff_message);
        this.m = (ToggleButton) this.b.findViewById(R.id.tb_onoff_followed);
        this.n = (ToggleButton) this.b.findViewById(R.id.tb_onoff_group_notify);
        this.p = (ToggleButton) this.b.findViewById(R.id.tglbtn_onoff_comments);
        this.q = (ToggleButton) this.b.findViewById(R.id.tb_onoff_visited);
        this.r = (ToggleButton) this.b.findViewById(R.id.tglbtn_onoff_feed_praise);
        this.s = (ToggleButton) this.b.findViewById(R.id.tglbtn_onoff_feed_at);
        this.w = (ToggleButton) this.b.findViewById(R.id.tb_onoff_circle_hot_notify);
        this.x = (ToggleButton) this.b.findViewById(R.id.tb_onoff_followed_new_feed_notify);
        this.y = (ToggleButton) this.b.findViewById(R.id.tb_onoff_open_chatroom_notify);
        this.v = (LinearLayout) this.b.findViewById(R.id.ll_message_notify);
        this.t.setChecked(BluedPreferences.aj());
        this.i.setChecked(BluedPreferences.ag());
        a(BluedPreferences.ae());
        this.g.setChecked(BluedPreferences.ae());
        this.f.setChecked(BluedPreferences.ac());
        this.h.setChecked(BluedPreferences.af());
        this.k.setChecked(BluedPreferences.ah());
        this.o.setChecked(BluedPreferences.ai());
        this.l.setChecked(BluedPreferences.ak());
        this.m.setChecked(BluedPreferences.al());
        this.n.setChecked(BluedPreferences.am());
        this.p.setChecked(BluedPreferences.an());
        this.j.setChecked(BluedPreferences.ar());
        this.q.setChecked(BluedPreferences.aq());
        this.r.setChecked(BluedPreferences.ao());
        this.s.setChecked(BluedPreferences.ap());
        this.w.setChecked(BluedPreferences.as());
        this.x.setChecked(BluedPreferences.at());
        this.y.setChecked(BluedPreferences.au());
        this.t.setOnCheckedChangeListener(this);
        this.j.setOnCheckedChangeListener(this);
        this.i.setOnCheckedChangeListener(this);
        this.g.setOnCheckedChangeListener(this);
        this.f.setOnCheckedChangeListener(this);
        this.h.setOnCheckedChangeListener(this);
        this.k.setOnCheckedChangeListener(this);
        this.o.setOnCheckedChangeListener(this);
        this.l.setOnCheckedChangeListener(this);
        this.m.setOnCheckedChangeListener(this);
        this.p.setOnCheckedChangeListener(this);
        this.q.setOnCheckedChangeListener(this);
        this.r.setOnCheckedChangeListener(this);
        this.s.setOnCheckedChangeListener(this);
        this.w.setOnCheckedChangeListener(this);
        this.x.setOnCheckedChangeListener(this);
        this.y.setOnCheckedChangeListener(this);
        this.n.setOnCheckedChangeListener(this);
        this.v.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.RemindSettingFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackSettings.a(SettingsProtos.Event.MINE_SETTINGS_MSG_CLICK);
                MessageNotifyFragment.a(RemindSettingFragment.this.getContext());
            }
        });
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        Tracker.onCheckedChanged(compoundButton, z);
        Map<String, String> a2 = BluedHttpTools.a();
        int id = compoundButton.getId();
        if (id == 2131370666) {
            BluedPreferences.p(z);
            a2.put("is_other_message_push", z ? "1" : "0");
        } else if (id != 2131370676) {
            switch (id) {
                case R.id.tb_onoff_circle_hot_notify /* 2131370589 */:
                    BluedPreferences.y(z);
                    a2.put("is_push_posting_post", z ? "1" : "0");
                    break;
                case R.id.tb_onoff_followed /* 2131370590 */:
                    BluedPreferences.r(z);
                    a2.put("is_followed_push", z ? "1" : "0");
                    break;
                case R.id.tb_onoff_followed_new_feed_notify /* 2131370591 */:
                    BluedPreferences.z(z);
                    a2.put("is_push_new_feed", z ? "1" : "0");
                    break;
                case R.id.tb_onoff_group_notify /* 2131370592 */:
                    SessionSettingModel sessionSettingModel = this.z;
                    if (sessionSettingModel != null) {
                        sessionSettingModel.setRemindAudio(!z ? 1 : 0);
                        ChatManager.getInstance().setSessionSetting(this.z.getSessionType(), this.z.getSessionId(), this.z);
                    }
                    BluedPreferences.s(z);
                    a2.put("is_groups_notify", z ? "1" : "0");
                    break;
                case R.id.tb_onoff_message /* 2131370593 */:
                    BluedPreferences.q(z);
                    a2.put("is_private_msg_push", z ? "1" : "0");
                    break;
                case R.id.tb_onoff_open_chatroom_notify /* 2131370594 */:
                    BluedPreferences.A(z);
                    a2.put("is_open_voice_notice", z ? "1" : "0");
                    break;
                case R.id.tb_onoff_recommend_live /* 2131370595 */:
                    BluedPreferences.x(z);
                    a2.put("is_recall_live_push", z ? "1" : "0");
                    break;
                case R.id.tb_onoff_system /* 2131370596 */:
                    BluedPreferences.n(z);
                    a2.put("is_system_push", z ? "1" : "0");
                    break;
                case R.id.tb_onoff_visited /* 2131370597 */:
                    BluedPreferences.w(z);
                    a2.put("is_visited_push", z ? "1" : "0");
                    break;
                default:
                    switch (id) {
                        case R.id.tglbtn_onoff_comments /* 2131370661 */:
                            BluedPreferences.t(z);
                            a2.put("is_comment_push", z ? "1" : "0");
                            break;
                        case R.id.tglbtn_onoff_feed_at /* 2131370662 */:
                            BluedPreferences.v(z);
                            a2.put("is_at_push", z ? "1" : "0");
                            break;
                        case R.id.tglbtn_onoff_feed_praise /* 2131370663 */:
                            BluedPreferences.u(z);
                            a2.put("is_like_push", z ? "1" : "0");
                            break;
                        case R.id.tglbtn_onoff_live_push /* 2131370664 */:
                            BluedPreferences.o(z);
                            a2.put("is_live_push", z ? "0" : "1");
                            break;
                        default:
                            switch (id) {
                                case R.id.tglbtn_private_chat_hint_onoff /* 2131370668 */:
                                    BluedPreferences.k(z);
                                    a(z);
                                    a2.put("is_open_sound", z ? "1" : "0");
                                    break;
                                case R.id.tglbtn_private_chat_vibrate_onoff /* 2131370669 */:
                                    BluedPreferences.l(z);
                                    a2.put("is_open_shake", z ? "1" : "0");
                                    break;
                                case R.id.tglbtn_push_notice_onoff /* 2131370670 */:
                                    BluedPreferences.m(z);
                                    a2.put("is_push_content", z ? "1" : "0");
                                    break;
                            }
                    }
            }
        } else {
            BluedPreferences.j(z);
            a2.put("is_bluedtone", z ? "1" : "0");
        }
        a(a2);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f33580c = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_remind_setting, viewGroup, false);
            b();
            a();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }
}

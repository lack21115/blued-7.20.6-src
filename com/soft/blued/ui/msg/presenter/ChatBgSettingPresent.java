package com.soft.blued.ui.msg.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.das.vip.VipProtos;
import com.soft.blued.R;
import com.soft.blued.base.mvp.MVPBasePresent;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.track.EventTrackVIP;
import com.soft.blued.ui.feed.fragment.PhotoSelectFragment;
import com.soft.blued.ui.msg.ChatBgSelectFragment;
import com.soft.blued.ui.msg.contract.IChatBgSettingIView;
import com.soft.blued.ui.msg.manager.ChatBgManager;
import com.soft.blued.utils.BluedPreferences;
import java.util.HashMap;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/presenter/ChatBgSettingPresent.class */
public class ChatBgSettingPresent extends MVPBasePresent<IChatBgSettingIView> {
    private long b = -1;

    /* renamed from: c  reason: collision with root package name */
    private short f32524c;
    private int d;
    private SessionSettingModel e;
    private String f;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SessionSettingModel sessionSettingModel, String str) {
        SessionSettingModel sessionSettingModel2 = sessionSettingModel;
        if (sessionSettingModel == null) {
            sessionSettingModel2 = new SessionSettingModel();
            sessionSettingModel2.setSessionId(this.b);
            sessionSettingModel2.setSessionType(this.f32524c);
            sessionSettingModel2.setLoadName(Long.valueOf(UserInfo.getInstance().getLoginUserInfo().getUid()).longValue());
        }
        String str2 = str;
        if (!TextUtils.isEmpty(str)) {
            str2 = str;
            if (!ChatBgManager.b(str)) {
                str2 = str;
                if (!str.toLowerCase().contains("file://")) {
                    str2 = RecyclingUtils.Scheme.FILE.b(str);
                }
            }
        }
        sessionSettingModel2.setChatBgUri(str2);
        ChatManager.getInstance().setSessionSetting(this.f32524c, Long.valueOf(this.b).longValue(), sessionSettingModel2);
        InstantLog.a("chat_bg_done");
    }

    @Override // com.soft.blued.base.mvp.MVPBasePresent
    public void a(Activity activity, int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 1000:
                case 1001:
                    break;
                default:
                    return;
                case 1002:
                    EventTrackVIP.a(VipProtos.Event.VIP_BACKFROUND_PHOTOGRAPH_BTN_CLICK);
                    break;
            }
            if (intent != null) {
                this.f = intent.getStringExtra("photo_path");
                if (this.d == 2) {
                    if (i == 1000) {
                        EventTrackVIP.a(VipProtos.Event.VIP_BACKFROUND_CHOOSE_PHOTO_BTN_CLICK);
                    }
                    if (ChatBgManager.b(this.f)) {
                        BluedPreferences.a(UserInfo.getInstance().getLoginUserInfo().getUid(), "");
                    } else {
                        if (!this.f.toLowerCase().contains("file://")) {
                            this.f = RecyclingUtils.Scheme.FILE.b(this.f);
                        }
                        BluedPreferences.a(UserInfo.getInstance().getLoginUserInfo().getUid(), this.f);
                    }
                    InstantLog.a("chat_bg_done");
                    IChatBgSettingIView ao_ = ao_();
                    if (ao_ != null) {
                        ao_.j();
                        return;
                    }
                    return;
                }
                SessionModel snapSessionModel = ChatManager.getInstance().getSnapSessionModel(this.f32524c, Long.valueOf(this.b).longValue());
                if (snapSessionModel != null) {
                    this.e = (SessionSettingModel) snapSessionModel.sessionSettingModel;
                }
                SessionSettingModel sessionSettingModel = this.e;
                if (sessionSettingModel == null) {
                    ChatManager.getInstance().getSessionSettingModel(this.f32524c, Long.valueOf(this.b).longValue(), new FetchDataListener<SessionSettingBaseModel>() { // from class: com.soft.blued.ui.msg.presenter.ChatBgSettingPresent.1
                        @Override // com.blued.android.chat.listener.FetchDataListener
                        /* renamed from: a */
                        public void onFetchData(SessionSettingBaseModel sessionSettingBaseModel) {
                            if (sessionSettingBaseModel != null) {
                                ChatBgSettingPresent.this.e = (SessionSettingModel) sessionSettingBaseModel;
                            }
                            ChatBgSettingPresent chatBgSettingPresent = ChatBgSettingPresent.this;
                            chatBgSettingPresent.a(chatBgSettingPresent.e, ChatBgSettingPresent.this.f);
                        }
                    });
                } else {
                    a(sessionSettingModel, this.f);
                }
                IChatBgSettingIView ao_2 = ao_();
                if (ao_2 != null) {
                    Activity activity2 = ao_2.getActivity();
                    ao_2.getActivity();
                    activity2.setResult(-1, new Intent());
                    ao_2.getActivity().finish();
                }
            }
        }
    }

    @Override // com.soft.blued.base.mvp.MVPBasePresent
    public void a(Bundle bundle) {
        IChatBgSettingIView ao_ = ao_();
        if (ao_ != null) {
            Bundle arguments = ao_.getArguments();
            if (arguments == null) {
                ao_.getActivity().finish();
                return;
            }
            this.b = arguments.getLong("passby_session_id", -1L);
            this.f32524c = arguments.getShort("passby_session_type");
            this.d = arguments.getInt("from");
        }
    }

    @Override // com.soft.blued.base.mvp.MVPBasePresent
    public void b(Bundle bundle) {
    }

    @Override // com.soft.blued.base.mvp.MVPBasePresent
    public void c() {
    }

    public void d() {
        IChatBgSettingIView ao_ = ao_();
        if (ao_ != null) {
            ChatBgSelectFragment.a(ao_.i(), this.d, this.b, this.f32524c, 1001);
        }
    }

    public void e() {
        IChatBgSettingIView ao_ = ao_();
        if (ao_ != null) {
            PhotoSelectFragment.a(ao_.i(), 12, 1000);
        }
    }

    public void f() {
        IChatBgSettingIView ao_ = ao_();
        if (ao_ != null) {
            PhotoSelectFragment.a(ao_.i(), 12, 1002, true);
        }
    }

    public void g() {
        HashMap hashMap = new HashMap();
        hashMap.put("chatBgUri", "");
        ChatManager.getInstance().updateAllSessionSetting(hashMap);
        InstantLog.a("chat_bg_done");
        AppMethods.d((int) R.string.setted_chat_bg_success);
    }
}

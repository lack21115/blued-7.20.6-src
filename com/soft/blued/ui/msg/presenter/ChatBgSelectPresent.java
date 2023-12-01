package com.soft.blued.ui.msg.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.blued.android.module.common.user.model.UserInfo;
import com.soft.blued.base.mvp.MVPBasePresent;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.ui.msg.adapter.ChatBgSelectAdapter;
import com.soft.blued.ui.msg.contract.IChatBgSelectIView;
import com.soft.blued.ui.msg.contract.IChatBgSelectOptionCallback;
import com.soft.blued.ui.msg.manager.ChatBgManager;
import com.soft.blued.ui.msg.model.MsgChattingBgModel;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/presenter/ChatBgSelectPresent.class */
public class ChatBgSelectPresent extends MVPBasePresent<IChatBgSelectIView> implements IChatBgSelectOptionCallback {
    private List<MsgChattingBgModel> b;

    /* renamed from: c  reason: collision with root package name */
    private ChatBgSelectAdapter f18830c;
    private SessionSettingModel d = null;
    private long e = -1;
    private short f;
    private int g;
    private String h;
    private boolean i;

    private void g() {
        if (this.g != 2) {
            SessionSettingModel sessionSettingModel = this.d;
            if (sessionSettingModel == null || TextUtils.isEmpty(sessionSettingModel.getChatBgUri())) {
                this.h = BluedPreferences.z(UserInfo.getInstance().getLoginUserInfo().getUid());
            } else {
                this.h = this.d.getChatBgUri();
            }
        } else {
            this.h = BluedPreferences.z(UserInfo.getInstance().getLoginUserInfo().getUid());
        }
        if (TextUtils.isEmpty(this.h) || ChatBgManager.b(this.h)) {
            return;
        }
        this.i = true;
    }

    @Override // com.soft.blued.ui.msg.contract.IChatBgSelectOptionCallback
    public IRequestHost a() {
        IChatBgSelectIView ao_ = ao_();
        if (ao_ != null) {
            return ao_.g();
        }
        return null;
    }

    @Override // com.soft.blued.base.mvp.MVPBasePresent
    public void a(Activity activity, int i, int i2, Intent intent) {
    }

    @Override // com.soft.blued.base.mvp.MVPBasePresent
    public void a(Bundle bundle) {
        IChatBgSelectIView ao_ = ao_();
        if (ao_ != null) {
            Bundle arguments = ao_.getArguments();
            if (arguments == null) {
                ao_.getActivity().finish();
                return;
            }
            this.g = arguments.getInt("from");
            this.e = arguments.getLong("passby_session_id", -1L);
            this.f = arguments.getShort("passby_session_type");
            ChatBgSelectAdapter chatBgSelectAdapter = new ChatBgSelectAdapter(a(), this);
            this.f18830c = chatBgSelectAdapter;
            ao_.a(chatBgSelectAdapter);
            this.b = new ArrayList();
            SessionModel snapSessionModel = ChatManager.getInstance().getSnapSessionModel(f(), e());
            if (snapSessionModel != null) {
                this.d = snapSessionModel.sessionSettingModel;
            }
            if (this.d == null) {
                ChatManager.getInstance().getSessionSettingModel(this.f, Long.valueOf(this.e).longValue(), new FetchDataListener<SessionSettingBaseModel>() { // from class: com.soft.blued.ui.msg.presenter.ChatBgSelectPresent.1
                    /* renamed from: a */
                    public void onFetchData(SessionSettingBaseModel sessionSettingBaseModel) {
                        ChatBgSelectPresent.this.d = (SessionSettingModel) sessionSettingBaseModel;
                    }
                });
            }
            g();
            d();
        }
    }

    @Override // com.soft.blued.ui.msg.contract.IChatBgSelectOptionCallback
    public boolean a(String str) {
        return str.equals(this.h);
    }

    @Override // com.soft.blued.ui.msg.contract.IChatBgSelectOptionCallback
    public boolean an_() {
        return this.i;
    }

    @Override // com.soft.blued.base.mvp.MVPBasePresent
    public void b(Bundle bundle) {
    }

    @Override // com.soft.blued.ui.msg.contract.IChatBgSelectOptionCallback
    public void b(String str) {
        IChatBgSelectIView ao_ = ao_();
        if (ao_ != null) {
            Intent intent = new Intent();
            intent.putExtra("photo_path", str);
            ao_.getActivity().setResult(-1, intent);
            ao_.getActivity().finish();
        }
    }

    @Override // com.soft.blued.base.mvp.MVPBasePresent
    public void c() {
    }

    public void d() {
        IChatBgSelectIView ao_ = ao_();
        if (ao_ != null) {
            ChatHttpUtils.a(new BluedUIHttpResponse<BluedEntity<MsgChattingBgModel, BluedEntityBaseExtra>>(a()) { // from class: com.soft.blued.ui.msg.presenter.ChatBgSelectPresent.2

                /* renamed from: a  reason: collision with root package name */
                boolean f18832a = false;

                public boolean onUIFailure(int i, String str) {
                    this.f18832a = true;
                    return super.onUIFailure(i, str);
                }

                public void onUIFinish() {
                    IChatBgSelectIView ao_2 = ChatBgSelectPresent.this.ao_();
                    if (ao_2 != null) {
                        ao_2.a(false);
                        ao_2.i();
                        if (ChatBgSelectPresent.this.b != null && ChatBgSelectPresent.this.b.size() > 0) {
                            if (ChatBgSelectPresent.this.f18830c != null) {
                                ChatBgSelectPresent.this.f18830c.a(ChatBgSelectPresent.this.b);
                            }
                        } else if (this.f18832a) {
                            ao_2.d();
                        } else {
                            ao_2.c();
                        }
                    }
                }

                public void onUIStart() {
                    IChatBgSelectIView ao_2 = ChatBgSelectPresent.this.ao_();
                    if (ao_2 != null) {
                        ao_2.a(true);
                    }
                }

                public void onUIUpdate(BluedEntity<MsgChattingBgModel, BluedEntityBaseExtra> bluedEntity) {
                    IChatBgSelectIView ao_2 = ChatBgSelectPresent.this.ao_();
                    if (ao_2 != null) {
                        ChatBgSelectPresent.this.b.clear();
                        MsgChattingBgModel msgChattingBgModel = new MsgChattingBgModel();
                        msgChattingBgModel.type = 1;
                        ChatBgSelectPresent.this.b.add(0, msgChattingBgModel);
                        ChatBgSelectPresent.this.b.addAll(1, bluedEntity.data);
                        if (ChatBgSelectPresent.this.b == null || ChatBgSelectPresent.this.b.size() <= 0) {
                            ao_2.c();
                        } else {
                            ao_2.b();
                        }
                    }
                }
            }, ao_.g());
        }
    }

    public long e() {
        return this.e;
    }

    public short f() {
        return this.f;
    }

    @Override // com.soft.blued.ui.msg.contract.IChatBgSelectOptionCallback
    public Context getContext() {
        IChatBgSelectIView ao_ = ao_();
        if (ao_ != null) {
            return ao_.getContext();
        }
        return null;
    }
}

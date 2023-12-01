package com.soft.blued.ui.group.presenter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionProfileModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.BluedAlbum;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.third.QiniuUploadUtils;
import com.blued.android.module.common.widget.menu.ActionSheet;
import com.blued.android.module.common.widget.menu.CommonShowBottomWindow;
import com.soft.blued.R;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.group.contract.IGroupInfoContract;
import com.soft.blued.ui.group.model.BluedCreatedGroupInfo;
import com.soft.blued.ui.group.model.BluedGroupLists;
import com.soft.blued.ui.msg.ChatBgSettingFragment;
import com.soft.blued.ui.share.BluedShareUtils;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.StringUtils;
import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/presenter/GroupInfoPresenter.class */
public class GroupInfoPresenter implements IGroupInfoContract.IPresenter {
    private Context f;
    private IGroupInfoContract.IView g;
    private LoadOptions h;
    private IRequestHost i;
    private Dialog j;
    private BluedCreatedGroupInfo k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private boolean r;
    private String s;
    private SessionSettingModel t;
    private String b = GroupInfoPresenter.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private int f30969c = 0;
    private final int d = 403009030;
    private final int e = 403009029;

    /* renamed from: a  reason: collision with root package name */
    public BluedUIHttpResponse f30968a = new BluedUIHttpResponse<BluedEntity>() { // from class: com.soft.blued.ui.group.presenter.GroupInfoPresenter.11
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(GroupInfoPresenter.this.j);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(GroupInfoPresenter.this.j);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity bluedEntity) {
            try {
                GroupInfoPresenter.this.k();
                AppMethods.d((int) R.string.group_modify_success);
                GroupInfoPresenter.this.a(false);
            } catch (Exception e) {
                AppMethods.a((CharSequence) GroupInfoPresenter.this.f.getResources().getString(2131887272));
                e.printStackTrace();
            }
        }
    };

    /* renamed from: com.soft.blued.ui.group.presenter.GroupInfoPresenter$8  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/presenter/GroupInfoPresenter$8.class */
    class AnonymousClass8 extends BluedUIHttpResponse<BluedEntityA<Object>> {
        AnonymousClass8() {
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
        }
    }

    public GroupInfoPresenter(Context context, IGroupInfoContract.IView iView, LoadOptions loadOptions, IRequestHost iRequestHost) {
        this.f = context;
        this.g = iView;
        this.h = loadOptions;
        this.i = iRequestHost;
        i();
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, BluedAlbum bluedAlbum) {
        QiniuUploadUtils.a(str, bluedAlbum, new QiniuUploadTools.QiNiuListener() { // from class: com.soft.blued.ui.group.presenter.GroupInfoPresenter.12
            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str2) {
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str2, double d) {
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str2, String str3) {
                GroupInfoPresenter.this.m = str2;
                GroupInfoPresenter.this.k();
                GroupInfoPresenter.this.i(str2);
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public boolean a() {
                return false;
            }
        });
    }

    private void c(final boolean z) {
        GroupHttpUtils.a(this.f, new BluedUIHttpResponse<BluedEntityA<BluedCreatedGroupInfo>>() { // from class: com.soft.blued.ui.group.presenter.GroupInfoPresenter.1

            /* renamed from: a  reason: collision with root package name */
            boolean f30970a;
            int b;

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedCreatedGroupInfo> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                GroupInfoPresenter.this.k = bluedEntityA.getSingleData();
                GroupInfoPresenter groupInfoPresenter = GroupInfoPresenter.this;
                groupInfoPresenter.m = groupInfoPresenter.k.groups_avatar;
                GroupInfoPresenter groupInfoPresenter2 = GroupInfoPresenter.this;
                groupInfoPresenter2.n = groupInfoPresenter2.k.groups_name;
                GroupInfoPresenter groupInfoPresenter3 = GroupInfoPresenter.this;
                groupInfoPresenter3.o = groupInfoPresenter3.k.groups_is_created;
                GroupInfoPresenter groupInfoPresenter4 = GroupInfoPresenter.this;
                groupInfoPresenter4.p = groupInfoPresenter4.k.groups_in_members;
                GroupInfoPresenter groupInfoPresenter5 = GroupInfoPresenter.this;
                groupInfoPresenter5.q = groupInfoPresenter5.k.groups_is_admins;
                GroupInfoPresenter.this.g.a(bluedEntityA.getSingleData());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable th, int i, String str) {
                super.onFailure(th, i, str);
                Logger.a(GroupInfoPresenter.this.b, "onFailure, error:", th);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                this.f30970a = true;
                this.b = i;
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                if (z) {
                    DialogUtils.b(GroupInfoPresenter.this.j);
                }
                if (this.f30970a) {
                    this.f30970a = false;
                    if (this.b == 403009030) {
                        GroupInfoPresenter.this.g.f();
                    }
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                if (z) {
                    DialogUtils.a(GroupInfoPresenter.this.j);
                }
            }
        }, this.l, "detail", this.i);
    }

    private void i() {
        this.j = DialogUtils.a(this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str) {
        if (this.k != null) {
            GroupHttpUtils.j(this.f, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>() { // from class: com.soft.blued.ui.group.presenter.GroupInfoPresenter.13
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<BluedAlbum> bluedEntityA) {
                    if (bluedEntityA == null || !bluedEntityA.hasData()) {
                        return;
                    }
                    GroupInfoPresenter.this.g.a(GroupInfoPresenter.this.s);
                    GroupInfoPresenter.this.k.groups_avatar = GroupInfoPresenter.this.s;
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish() {
                    super.onUIFinish();
                    DialogUtils.b(GroupInfoPresenter.this.j);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIStart() {
                    super.onUIStart();
                    DialogUtils.a(GroupInfoPresenter.this.j);
                }
            }, str, this.l, this.i);
        }
    }

    private void j() {
        Bundle a2 = this.g.a();
        if (a2 == null) {
            return;
        }
        this.l = a2.getString("gid");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        SessionProfileModel sessionProfileModel = new SessionProfileModel();
        sessionProfileModel.avatar = this.m;
        sessionProfileModel.nickname = this.n;
        ChatManager.getInstance().updateSessionInfoData((short) 3, Long.parseLong(this.l), sessionProfileModel);
    }

    public void a(int i) {
        SessionSettingModel sessionSettingModel = this.t;
        if (sessionSettingModel != null) {
            sessionSettingModel.setRemindAudio(i);
            ChatManager.getInstance().setSessionSetting(this.t.getSessionType(), this.t.getSessionId(), this.t);
        }
    }

    public void a(BaseFragment baseFragment, int i) {
        BluedPreferences.f(1);
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade != 0 || BluedConfig.a().g().is_chat_backgrounds == 1) {
            ChatBgSettingFragment.a(baseFragment, 1, this.t.getSessionId(), this.t.getSessionType(), i);
        } else {
            PayUtils.a(this.f, 23, "chat_customize_bg");
        }
    }

    public void a(final String str) {
        this.s = str;
        GroupHttpUtils.a(this.f, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>() { // from class: com.soft.blued.ui.group.presenter.GroupInfoPresenter.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedAlbum> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                GroupInfoPresenter.this.a(str, bluedEntityA.getSingleData());
            }
        }, this.l, this.i);
    }

    public void a(String str, final ImageView imageView) {
        final String b = BluedHttpUrl.b(this.l);
        final String string = this.f.getString(R.string.group_share_title);
        final String format = String.format(this.f.getString(R.string.group_share_content), str, this.l);
        if (this.k != null) {
            final BluedGroupLists bluedGroupLists = new BluedGroupLists();
            bluedGroupLists.groups_gid = this.k.groups_gid;
            bluedGroupLists.groups_is_admins = this.k.groups_is_admins;
            bluedGroupLists.groups_is_created = this.k.groups_is_created;
            bluedGroupLists.groups_name = this.k.groups_name;
            bluedGroupLists.groups_description = this.k.groups_description;
            if (StringUtils.d(this.k.groups_avatar)) {
                BluedShareUtils.b().a((Activity) this.f, 0, "http://7vznnm.com2.z0.glb.qiniucdn.com/blued-logo.png-500", null, null, b, string, format, format, 0, bluedGroupLists);
            } else {
                ImageFileLoader.a(this.i).a(this.r ? this.s : this.k.groups_avatar).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.soft.blued.ui.group.presenter.GroupInfoPresenter.2
                    @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                    public void onUIFinish(File file, Exception exc) {
                        Bitmap decodeFile = (file == null || !file.exists()) ? null : BitmapFactory.decodeFile(file.getPath());
                        BluedShareUtils b2 = BluedShareUtils.b();
                        Activity activity = (Activity) GroupInfoPresenter.this.f;
                        String str2 = GroupInfoPresenter.this.r ? GroupInfoPresenter.this.s : GroupInfoPresenter.this.k.groups_avatar;
                        ImageView imageView2 = imageView;
                        String str3 = b;
                        String str4 = string;
                        String str5 = format;
                        b2.a(activity, 0, str2, imageView2, decodeFile, str3, str4, str5, str5, 0, bluedGroupLists);
                    }
                }).a();
            }
        }
    }

    public void a(boolean z) {
        c(z);
    }

    @Override // com.blued.android.framework.mvp_similarity.BasePresenter
    public void ar_() {
    }

    public void b() {
        if ("1".equals(this.o) || "1".equals(this.q)) {
            CommonShowBottomWindow.a((FragmentActivity) this.f, TextUtils.isEmpty(this.k.groups_avatar) ? new String[]{this.f.getResources().getString(2131888666)} : new String[]{this.f.getResources().getString(2131888666), this.f.getResources().getString(2131888667)}, new ActionSheet.ActionSheetListener() { // from class: com.soft.blued.ui.group.presenter.GroupInfoPresenter.3
                @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
                public void a(ActionSheet actionSheet, int i) {
                    if (i == 0) {
                        if (PopMenuUtils.a(GroupInfoPresenter.this.f)) {
                            return;
                        }
                        GroupInfoPresenter.this.g.b();
                    } else if (StringUtils.d(GroupInfoPresenter.this.k.groups_avatar)) {
                        GroupInfoPresenter.this.g.a(new String[]{null});
                    } else {
                        GroupInfoPresenter.this.g.a(new String[]{GroupInfoPresenter.this.k.groups_avatar});
                    }
                }

                @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
                public void a(ActionSheet actionSheet, boolean z) {
                }
            });
        } else if (StringUtils.d(this.k.groups_avatar)) {
            this.g.a(new String[]{null});
        } else {
            this.g.a(new String[]{this.k.groups_avatar});
        }
    }

    public void b(final String str) {
        SessionModel snapSessionModel = ChatManager.getInstance().getSnapSessionModel((short) 3, Long.parseLong(str));
        if (snapSessionModel != null) {
            SessionSettingModel sessionSettingModel = (SessionSettingModel) snapSessionModel.sessionSettingModel;
            this.t = sessionSettingModel;
            if (sessionSettingModel != null) {
                if (sessionSettingModel.getRemindAudio() == 0) {
                    this.g.a(false);
                } else if (this.t.getRemindAudio() == 1) {
                    this.g.a(true);
                }
            }
        }
        ChatManager.getInstance().getSessionSettingModel((short) 3, Long.parseLong(str), new FetchDataListener<SessionSettingBaseModel>() { // from class: com.soft.blued.ui.group.presenter.GroupInfoPresenter.7
            @Override // com.blued.android.chat.listener.FetchDataListener
            /* renamed from: a */
            public void onFetchData(SessionSettingBaseModel sessionSettingBaseModel) {
                GroupInfoPresenter.this.t = (SessionSettingModel) sessionSettingBaseModel;
                if (GroupInfoPresenter.this.t != null) {
                    if (GroupInfoPresenter.this.t.getRemindAudio() == 0) {
                        GroupInfoPresenter.this.g.a(false);
                    } else if (GroupInfoPresenter.this.t.getRemindAudio() == 1) {
                        GroupInfoPresenter.this.g.a(true);
                    }
                }
                if (GroupInfoPresenter.this.t == null) {
                    SessionSettingModel sessionSettingModel2 = new SessionSettingModel();
                    sessionSettingModel2.setLoadName(Long.valueOf(UserInfo.getInstance().getLoginUserInfo().getUid()).longValue());
                    sessionSettingModel2.setSessionId(Long.valueOf(str).longValue());
                    sessionSettingModel2.setSessionType((short) 3);
                    GroupInfoPresenter.this.t = sessionSettingModel2;
                }
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void b(boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public void c(String str) {
        GroupHttpUtils.d(this.f, new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.group.presenter.GroupInfoPresenter.9
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public BluedEntityA<Object> parseData(String str2) {
                Logger.a(GroupInfoPresenter.this.b, "onSuccess, content:", str2);
                return (BluedEntityA) super.parseData(str2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                try {
                    AppMethods.d((int) R.string.group_join_success);
                    UserInfo.getInstance().getLoginUserInfo().setGroupsCount(1);
                    GroupInfoPresenter.this.g.e();
                } catch (Exception e) {
                    AppMethods.a((CharSequence) GroupInfoPresenter.this.f.getResources().getString(2131887272));
                    e.printStackTrace();
                }
                GroupInfoPresenter.this.f30969c = 0;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable th, int i, String str2) {
                super.onFailure(th, i, str2);
                GroupInfoPresenter.this.f30969c = 0;
                if (BluedHttpUtils.a(th, i, str2).first.intValue() == 403009029) {
                    GroupInfoPresenter.this.f30969c = 403009029;
                    GroupInfoPresenter.this.g.g();
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                Logger.a(GroupInfoPresenter.this.b, "onFinish");
                DialogUtils.b(GroupInfoPresenter.this.j);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                DialogUtils.a(GroupInfoPresenter.this.j);
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), str, this.i);
    }

    public boolean c() {
        return "1".equals(this.p) || "1".equals(this.q) || "1".equals(this.o);
    }

    public void d() {
        ChatManager.getInstance().deleteSessionAndChatting((short) 3, Long.parseLong(this.l));
    }

    public void d(String str) {
        GroupHttpUtils.f(this.f, new BluedUIHttpResponse<BluedEntity>() { // from class: com.soft.blued.ui.group.presenter.GroupInfoPresenter.10
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                AppMethods.d((int) R.string.btn_reportgroup);
            }
        }, this.l, str, this.i);
    }

    public void e() {
        GroupHttpUtils.f(this.f, new BluedUIHttpResponse<BluedEntity>() { // from class: com.soft.blued.ui.group.presenter.GroupInfoPresenter.5
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(GroupInfoPresenter.this.j);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(GroupInfoPresenter.this.j);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                GroupInfoPresenter.this.g.c();
            }
        }, this.k.groups_gid, this.i);
    }

    public void e(String str) {
        GroupHttpUtils.b(this.f, this.f30968a, this.l, "", "", str, "", this.i);
    }

    public void f() {
        GroupHttpUtils.e(this.f, new BluedUIHttpResponse<BluedEntity>() { // from class: com.soft.blued.ui.group.presenter.GroupInfoPresenter.6
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(GroupInfoPresenter.this.j);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(GroupInfoPresenter.this.j);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                GroupInfoPresenter.this.g.d();
            }
        }, this.k.groups_gid, this.i);
    }

    public void f(String str) {
        GroupHttpUtils.b(this.f, this.f30968a, this.l, "", str, "", "", this.i);
    }

    public void g() {
        ChatManager.getInstance().deleteSessionAndChattingWithSetting((short) 3, Long.parseLong(this.k.groups_gid));
    }

    public void g(String str) {
        GroupHttpUtils.b(this.f, this.f30968a, this.l, str, "", "", "", this.i);
    }

    public void h(String str) {
        this.r = true;
        this.k.groups_avatar = RecyclingUtils.Scheme.FILE.b(str);
    }

    public boolean h() {
        return this.f30969c == 403009029;
    }
}

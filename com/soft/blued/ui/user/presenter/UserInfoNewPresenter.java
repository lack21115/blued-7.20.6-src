package com.soft.blued.ui.user.presenter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.FileCache;
import com.blued.android.framework.utils.ImageUtils;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.BluedAlbum;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.BitmapUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.utils.third.QiniuUploadUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.das.live.LiveProtos;
import com.blued.das.profile.PersonalProfileProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.http.ProfileHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.track.EventTrackPersonalProfile;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.manager.SubscribeNumberManager;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.user.contract.IUserInfoNewContract;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import com.soft.blued.ui.user.model.MultiHeadMigration;
import com.soft.blued.ui.user.model.ServiceMenuModel;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.ui.user.utils.BlackConfirmUtil;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.io.File;
import java.util.ArrayList;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/presenter/UserInfoNewPresenter.class */
public class UserInfoNewPresenter implements IUserInfoNewContract.IPresenter, UserRelationshipUtils.IAddOrRemoveAttentionDone {

    /* renamed from: a  reason: collision with root package name */
    public Context f20587a;
    public IUserInfoNewContract.IView b;

    /* renamed from: c  reason: collision with root package name */
    public IRequestHost f20588c;
    public Dialog d;
    public boolean e;
    public String f;
    public boolean g;
    public boolean h;
    public boolean i;
    public MsgSourceEntity j;
    private UserBasicModel k;
    private UserInfoEntity l;
    private SessionSettingModel m;

    /* renamed from: com.soft.blued.ui.user.presenter.UserInfoNewPresenter$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/presenter/UserInfoNewPresenter$1.class */
    class AnonymousClass1 extends BluedUIHttpResponse<BluedEntityA<UserInfoEntity>> {
        AnonymousClass1(IRequestHost iRequestHost) {
            super(iRequestHost);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public BluedEntityA<UserInfoEntity> parseData(String str) {
            if (UserInfoNewPresenter.this.e) {
                FileCache.a(UserInfoFragmentNew.class.getSimpleName(), str);
            }
            return super.parseData(str);
        }

        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<UserInfoEntity> bluedEntityA) {
            if (bluedEntityA == null || !bluedEntityA.hasData()) {
                AppMethods.d(2131888227);
            } else {
                UserInfoNewPresenter.this.l = (UserInfoEntity) bluedEntityA.data.get(0);
                if (UserInfoNewPresenter.this.l != null) {
                    UserInfoNewPresenter.this.e = UserInfo.getInstance().getLoginUserInfo().getUid().equals(UserInfoNewPresenter.this.l.uid);
                    if (UserInfoNewPresenter.this.e) {
                        UserInfo.getInstance().getLoginUserInfo().setName(UserInfoNewPresenter.this.l.name);
                        UserInfo.getInstance().getLoginUserInfo().setDescription(UserInfoNewPresenter.this.l.description);
                        UserInfo.getInstance().getLoginUserInfo().setFollowedCount(UserInfoNewPresenter.this.l.followed_count);
                        UserInfo.getInstance().getLoginUserInfo().setMyTicktocksCount(UserInfoNewPresenter.this.l.my_ticktocks_count);
                        UserInfo.getInstance().getLoginUserInfo().setFriendCount(UserInfoNewPresenter.this.l.friends_count);
                        UserInfo.getInstance().getLoginUserInfo().setBlackCount(UserInfoNewPresenter.this.l.black_count);
                        UserInfo.getInstance().getLoginUserInfo().setBlackMax(UserInfoNewPresenter.this.l.black_allowed_count);
                        UserInfo.getInstance().getLoginUserInfo().setAvatar_pid(UserInfoNewPresenter.this.l.avatar_pid);
                        UserInfo.getInstance().getLoginUserInfo().setAvatar(UserInfoNewPresenter.this.l.avatar);
                        UserInfo.getInstance().getLoginUserInfo().setRich_level(UserInfoNewPresenter.this.l.rich_level);
                        UserInfo.getInstance().getLoginUserInfo().vip_grade = UserInfoNewPresenter.this.l.vip_grade;
                        UserInfo.getInstance().getLoginUserInfo().is_show_vip_page = UserInfoNewPresenter.this.l.is_show_vip_page;
                        UserInfo.getInstance().getLoginUserInfo().nickname_limit = UserInfoNewPresenter.this.l.nickname_limit;
                        UserInfo.getInstance().getLoginUserInfo().personal_display = UserInfoNewPresenter.this.l.personal_display;
                        UserInfo.getInstance().getLoginUserInfo().is_audited = UserInfoNewPresenter.this.l.is_audited;
                        UserInfo.getInstance().getLoginUserInfo().avatar_audited = UserInfoNewPresenter.this.l.avatar_audited;
                        UserInfo.getInstance().getLoginUserInfo().auditing_profile = UserInfoNewPresenter.this.l.auditing_profile;
                        if (UserInfoNewPresenter.this.l.access_private_photos == 2) {
                            BluedPreferences.H(true);
                        } else {
                            BluedPreferences.H(false);
                        }
                        UserInfoNewPresenter.this.q();
                    }
                    if (!TextUtils.isEmpty(UserInfoNewPresenter.this.l.uid) && SubscribeNumberManager.f18759a.a(UserInfoNewPresenter.this.l.uid, (Short) 2)) {
                        UserInfoNewPresenter userInfoNewPresenter = UserInfoNewPresenter.this;
                        userInfoNewPresenter.c(userInfoNewPresenter.l.uid);
                    }
                    UserInfoNewPresenter.this.b.a(UserInfoNewPresenter.this.l);
                    UserInfoNewPresenter.this.b.b(UserInfoNewPresenter.this.l);
                } else {
                    AppMethods.d(2131888227);
                }
            }
            UserInfoNewPresenter.this.b.a(UserInfoNewPresenter.this.l, 200);
        }

        public boolean onUIFailure(int i, String str) {
            UserInfoNewPresenter.this.b.a(UserInfoNewPresenter.this.l, i);
            return super.onUIFailure(i, str);
        }

        public void onUIStart() {
            super.onUIStart();
        }
    }

    public UserInfoNewPresenter(Context context, IUserInfoNewContract.IView iView, String str, boolean z, boolean z2, boolean z3, IRequestHost iRequestHost, MsgSourceEntity msgSourceEntity, UserBasicModel userBasicModel) {
        this.f20587a = context;
        this.b = iView;
        this.f20588c = iRequestHost;
        this.f = str;
        this.g = z;
        this.h = z2;
        this.i = z3;
        this.k = userBasicModel;
        this.d = DialogUtils.a(context);
        this.j = msgSourceEntity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(File file, Exception exc) {
        if (file == null) {
            return;
        }
        Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
        int min = Math.min(decodeFile.getWidth(), decodeFile.getHeight());
        double d = min > 540 ? min / LiveProtos.Event.LIVE_BAG_CHAT_MARK_SHOW_VALUE : 1.0d;
        Bitmap a2 = BitmapUtils.a(this.f20587a, TypefaceUtils.a(this.f20587a, this.l.name, d));
        Bitmap bitmap = decodeFile;
        if (a2 != null) {
            bitmap = this.e ? decodeFile : BitmapUtils.a(this.f20587a, decodeFile, a2, (int) (Math.max(d, 1.0d) * 10.0d), (int) (Math.max(d, 1.0d) * 10.0d));
        }
        if (bitmap == null) {
            return;
        }
        ImageUtils.a(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, BluedAlbum bluedAlbum) {
        QiniuUploadUtils.a(str, bluedAlbum, new QiniuUploadTools.QiNiuListener() { // from class: com.soft.blued.ui.user.presenter.UserInfoNewPresenter.7
            public void a(String str2) {
                if (UserInfoNewPresenter.this.f20588c.isActive()) {
                    DialogUtils.b(UserInfoNewPresenter.this.d);
                }
            }

            public void a(String str2, double d) {
            }

            public void a(String str2, String str3) {
                UserInfoNewPresenter.this.f(str2);
            }

            public boolean a() {
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final String str) {
        MineHttpUtils.d(this.f20587a, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(this.f20588c) { // from class: com.soft.blued.ui.user.presenter.UserInfoNewPresenter.8
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedAlbum> bluedEntityA) {
                UserInfoNewPresenter.this.l.background_photo = str;
                UserInfoNewPresenter.this.l.background_photo_auditing = 1;
                UserInfoNewPresenter.this.b.a(UserInfoNewPresenter.this.l);
                AppMethods.d((int) R.string.profile_background_upload_success);
            }

            public boolean onUIFailure(int i, String str2) {
                return super.onUIFailure(i, str2);
            }

            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(UserInfoNewPresenter.this.d);
            }
        }, str, this.f20588c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str) {
        BlackConfirmUtil.f20634a.a(this.f20587a, str, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.presenter.UserInfoNewPresenter.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                UserHttpUtils.b(UserInfoNewPresenter.this.f20587a, new BluedUIHttpResponse<BluedEntityA<Object>>(UserInfoNewPresenter.this.f20588c) { // from class: com.soft.blued.ui.user.presenter.UserInfoNewPresenter.11.1

                    /* renamed from: a  reason: collision with root package name */
                    boolean f20592a;

                    /* JADX INFO: Access modifiers changed from: protected */
                    /* renamed from: a */
                    public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                        AppMethods.d((int) R.string.add_black_success);
                        UserInfoNewPresenter.this.l.in_blacklist = "1";
                        if ("8".equals(UserInfoNewPresenter.this.l.relationship)) {
                            UserInfoNewPresenter.this.l.relationship = "12";
                        } else {
                            UserInfoNewPresenter.this.l.relationship = "4";
                        }
                        UserInfoNewPresenter.this.b.a(UserInfoNewPresenter.this.l);
                        UserInfo.getInstance().getLoginUserInfo().addBlackCount();
                        if (UserInfoNewPresenter.this.l.uid != null) {
                            ChatHelperV4.a().b(Long.parseLong(UserInfoNewPresenter.this.l.uid));
                            LiveEventBus.get("feed_relation_ship").post(UserInfoNewPresenter.this.l);
                        }
                        UserInfoNewPresenter.this.b.b();
                    }

                    public boolean onUIFailure(int i2, String str2) {
                        if (i2 == 403902) {
                            this.f20592a = true;
                            return true;
                        }
                        return super.onUIFailure(i2, str2);
                    }

                    public void onUIFinish() {
                        DialogUtils.b(UserInfoNewPresenter.this.d);
                        if (this.f20592a) {
                            BlackConfirmUtil.f20634a.a(UserInfoNewPresenter.this.f20587a);
                            this.f20592a = false;
                            if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 2) {
                                InstantLog.a("profile_max_blacklist", 1);
                                EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PROFILE_MAX_BLACKLIST, 1);
                            } else {
                                InstantLog.a("profile_max_blacklist", 0);
                                EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PROFILE_MAX_BLACKLIST, 0);
                            }
                        }
                        super.onUIFinish();
                    }

                    public void onUIStart() {
                        DialogUtils.a(UserInfoNewPresenter.this.d);
                        super.onUIStart();
                    }
                }, UserInfo.getInstance().getLoginUserInfo().getUid(), UserInfoNewPresenter.this.l.uid, UserInfoNewPresenter.this.f20588c);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str) {
        UserInfoEntity userInfoEntity = this.l;
        if (userInfoEntity == null || userInfoEntity.uid == null) {
            return;
        }
        SessionModel snapSessionModel = ChatManager.getInstance().getSnapSessionModel((short) 2, Long.valueOf(this.l.uid).longValue());
        if (snapSessionModel != null) {
            this.m = snapSessionModel.sessionSettingModel;
        } else {
            ChatManager.getInstance().getSessionSettingModel((short) 2, Long.valueOf(this.l.uid).longValue(), new FetchDataListener<SessionSettingBaseModel>() { // from class: com.soft.blued.ui.user.presenter.UserInfoNewPresenter.16
                /* renamed from: a */
                public void onFetchData(SessionSettingBaseModel sessionSettingBaseModel) {
                    UserInfoNewPresenter.this.m = (SessionSettingModel) sessionSettingBaseModel;
                }
            });
        }
        SessionSettingModel sessionSettingModel = this.m;
        if (sessionSettingModel != null) {
            sessionSettingModel.setSessinoNote(str);
            ChatManager.getInstance().setSessionSetting(this.m.getSessionType(), this.m.getSessionId(), this.m);
            return;
        }
        SessionSettingModel sessionSettingModel2 = new SessionSettingModel();
        sessionSettingModel2.setLoadName(Long.valueOf(UserInfo.getInstance().getLoginUserInfo().getUid()).longValue());
        sessionSettingModel2.setSessionId(Long.valueOf(this.l.uid).longValue());
        sessionSettingModel2.setSessionType((short) 2);
        sessionSettingModel2.setSessinoNote(str);
        ChatManager.getInstance().setSessionSetting(sessionSettingModel2.getSessionType(), sessionSettingModel2.getSessionId(), sessionSettingModel2);
    }

    @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
    public void a() {
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void a(UserBasicModel userBasicModel) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public void a(GiftGivingOptionForJsonParse giftGivingOptionForJsonParse) {
        ChatHelperV4.a().a(this.l.uid, this.l.name, this.l.avatar, this.l.vbadge, this.l.vip_grade, this.l.is_vip_annual, this.l.vip_exp_lvl, this.l.is_hide_vip_look, giftGivingOptionForJsonParse, this.j);
    }

    @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
    public void a(String str) {
        this.l.relationship = str;
        this.b.a(this.l);
    }

    public void a(boolean z) {
        if (!z) {
            UserHttpUtils.h(new BluedUIHttpResponse(this.f20588c) { // from class: com.soft.blued.ui.user.presenter.UserInfoNewPresenter.20
                public boolean onUIFailure(int i, String str, String str2) {
                    if (i == 10001) {
                        AppMethods.a(UserInfoNewPresenter.this.f20587a.getString(R.string.invisible_to_him_full));
                        EventTrackPersonalProfile.d(PersonalProfileProtos.Event.PERSONAL_MORE_HIDE_LIMIT_SHOW, UserInfoNewPresenter.this.e().uid);
                        return true;
                    }
                    return true;
                }

                public void onUIUpdate(BluedEntity bluedEntity) {
                    UserInfoNewPresenter.this.l.stealth_status = 1;
                    UserInfoNewPresenter.this.b.a(UserInfoNewPresenter.this.l);
                    AppMethods.a(UserInfoNewPresenter.this.f20587a.getString(R.string.invisible_to_him_success));
                    EventTrackPersonalProfile.d(PersonalProfileProtos.Event.PERSONAL_MORE_HIDE_SUCCESS_SHOW, UserInfoNewPresenter.this.e().uid);
                }
            }, this.l.uid, this.f20588c);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.l.uid);
        UserHttpUtils.a(new BluedUIHttpResponse(this.f20588c) { // from class: com.soft.blued.ui.user.presenter.UserInfoNewPresenter.19
            public void onUIUpdate(BluedEntity bluedEntity) {
                UserInfoNewPresenter.this.l.stealth_status = 0;
                UserInfoNewPresenter.this.b.a(UserInfoNewPresenter.this.l);
                AppMethods.a(UserInfoNewPresenter.this.f20587a.getString(R.string.invisible_to_him_cancel));
                EventTrackPersonalProfile.d(PersonalProfileProtos.Event.PERSONAL_MORE_HIDE_CANCEL_SUCCESS_SHOW, UserInfoNewPresenter.this.e().uid);
            }
        }, arrayList, this.f20588c);
    }

    public void ar_() {
    }

    @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
    public void b() {
    }

    @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
    public void b(String str) {
        this.l.relationship = str;
        this.b.a(this.l);
    }

    @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
    public void c() {
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        UserHttpUtils.f(new BluedUIHttpResponse<BluedEntityA<ServiceMenuModel>>(this.f20588c) { // from class: com.soft.blued.ui.user.presenter.UserInfoNewPresenter.3
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<ServiceMenuModel> bluedEntityA) {
                if (bluedEntityA != null) {
                    UserInfoNewPresenter.this.b.a(bluedEntityA.data);
                }
            }
        }, str, this.f20588c);
    }

    public void d() {
        UserInfoEntity userInfoEntity = this.l;
        if (userInfoEntity == null || StringUtils.d(userInfoEntity.uid) || this.l.uid.equals(UserInfo.getInstance().getLoginUserInfo().uid)) {
            return;
        }
        UserHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<UserFindResult>>(this.b.c()) { // from class: com.soft.blued.ui.user.presenter.UserInfoNewPresenter.2
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<UserFindResult> bluedEntityA) {
                if (bluedEntityA.hasData()) {
                    UserInfoNewPresenter.this.b.a(bluedEntityA.data, bluedEntityA.hasMore());
                } else {
                    ToastUtils.a(UserInfoNewPresenter.this.f20587a.getString(R.string.user_no_recommend_users));
                }
            }
        }, this.b.c(), this.l.uid, "1", "10");
    }

    public void d(final String str) {
        LoginRegisterHttpUtils.a(this.f20587a, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(this.f20588c) { // from class: com.soft.blued.ui.user.presenter.UserInfoNewPresenter.6
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedAlbum> bluedEntityA) {
                if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                UserInfoNewPresenter.this.a(str, (BluedAlbum) bluedEntityA.data.get(0));
            }

            public boolean onUIFailure(int i, String str2) {
                return super.onUIFailure(i, str2);
            }

            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(UserInfoNewPresenter.this.d);
            }

            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(UserInfoNewPresenter.this.d);
            }
        }, this.f20588c);
    }

    public UserInfoEntity e() {
        if (this.l == null) {
            UserInfoEntity userInfoEntity = new UserInfoEntity();
            this.l = userInfoEntity;
            UserBasicModel userBasicModel = this.k;
            if (userBasicModel != null) {
                userInfoEntity.uid = userBasicModel.uid;
                this.l.name = this.k.name;
                this.l.age = this.k.age;
                this.l.weight = this.k.weight;
                this.l.height = this.k.height;
                this.l.avatar = this.k.avatar;
                this.l.vbadge = this.k.vbadge;
                this.l.vip_grade = this.k.vip_grade;
                this.l.distance = this.k.distance;
                this.l.is_vip_annual = this.k.is_vip_annual;
                this.l.last_operate = this.k.last_operate;
                this.l.vip_exp_lvl = this.k.vip_exp_lvl;
            }
        }
        return this.l;
    }

    public void e(String str) {
        if (LiveFloatManager.a().x()) {
            return;
        }
        YYRoomInfoManager.e().a(this.f20587a, str, "personal_yy_icon");
    }

    public void f() {
        Context context = this.f20587a;
        CommonAlertDialog.a(context, context.getResources().getString(R.string.common_string_notice), 20, (String) null, (String) null, (String) null, this.l.note, this.f20587a.getString(R.string.please_input_user_comment), new CommonAlertDialog.TextOnClickListener() { // from class: com.soft.blued.ui.user.presenter.UserInfoNewPresenter.4
            public void a(final String str) {
                if (str.equals(UserInfoNewPresenter.this.l.note)) {
                    AppMethods.d((int) R.string.please_input_user_comment);
                } else {
                    MineHttpUtils.h(UserInfoNewPresenter.this.f20587a, new BluedUIHttpResponse<BluedEntityA<Object>>(UserInfoNewPresenter.this.f20588c) { // from class: com.soft.blued.ui.user.presenter.UserInfoNewPresenter.4.1
                        /* JADX INFO: Access modifiers changed from: protected */
                        /* renamed from: a */
                        public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                            AppMethods.d((int) R.string.modify_note_success);
                            UserInfoNewPresenter.this.l.note = str;
                            UserInfoNewPresenter.this.b.c(UserInfoNewPresenter.this.l);
                            UserInfoNewPresenter.this.h(str);
                        }

                        public void onUIFinish() {
                            DialogUtils.b(UserInfoNewPresenter.this.d);
                            super.onUIFinish();
                        }

                        public void onUIStart() {
                            DialogUtils.a(UserInfoNewPresenter.this.d);
                            super.onUIStart();
                        }
                    }, UserInfo.getInstance().getLoginUserInfo().getUid(), str, UserInfoNewPresenter.this.l.uid, UserInfoNewPresenter.this.f20588c);
                }
            }
        }, (DialogInterface.OnClickListener) null);
    }

    public boolean g() {
        if (this.l == null || TextUtils.equals(UserInfo.getInstance().getLoginUserInfo().uid, this.l.uid)) {
            return false;
        }
        return UserInfoHelper.a(this.l.relationship);
    }

    public boolean h() {
        UserInfoEntity userInfoEntity = this.l;
        boolean z = false;
        if (userInfoEntity == null) {
            return false;
        }
        if ("8".equalsIgnoreCase(userInfoEntity.relationship) || "12".equalsIgnoreCase(this.l.relationship)) {
            z = true;
        }
        return z;
    }

    public void i() {
        UserHttpUtils.c(new BluedUIHttpResponse<BluedEntityA>(this.f20588c) { // from class: com.soft.blued.ui.user.presenter.UserInfoNewPresenter.5
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA bluedEntityA) {
                AppMethods.d((int) R.string.del_success);
                UserInfoNewPresenter.this.l.background_photo = "";
                UserInfoNewPresenter.this.l.background_photo_auditing = 0;
                UserInfoNewPresenter.this.b.a(UserInfoNewPresenter.this.l);
            }

            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(UserInfoNewPresenter.this.d);
            }

            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(UserInfoNewPresenter.this.d);
            }
        }, this.f20588c);
    }

    public void j() {
        ImageFileLoader.a((IRequestHost) null).b(AvatarUtils.a(3, this.l.background_photo)).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.soft.blued.ui.user.presenter.-$$Lambda$UserInfoNewPresenter$Aij8wt4Bso5z1BQI7f0wX7qWlWE
            public final void onUIFinish(File file, Exception exc) {
                UserInfoNewPresenter.this.a(file, exc);
            }
        }).a();
    }

    public void k() {
        if (this.l == null || g()) {
            return;
        }
        UserRelationshipUtils.a(this.f20587a, this, this.l.uid, this.l.relationship, this.f, this.f20588c, false);
    }

    public void l() {
        UserInfoEntity userInfoEntity = this.l;
        if (userInfoEntity != null) {
            if ("0".equals(userInfoEntity.in_blacklist)) {
                ChatManager.getInstance().getSessionSettingModel((short) 2, Long.parseLong(this.l.uid), new FetchDataListener<SessionSettingBaseModel>() { // from class: com.soft.blued.ui.user.presenter.UserInfoNewPresenter.9
                    /* renamed from: a */
                    public void onFetchData(final SessionSettingBaseModel sessionSettingBaseModel) {
                        AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.user.presenter.UserInfoNewPresenter.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (sessionSettingBaseModel instanceof SessionSettingModel) {
                                    UserInfoNewPresenter.this.g(sessionSettingBaseModel.getSessionCommonStatus());
                                } else {
                                    UserInfoNewPresenter.this.g("0");
                                }
                            }
                        });
                    }
                });
                return;
            }
            DialogUtils.a(this.d);
            UserHttpUtils.c(this.f20587a, new BluedUIHttpResponse<BluedEntityA<Object>>(this.f20588c) { // from class: com.soft.blued.ui.user.presenter.UserInfoNewPresenter.10
                /* JADX INFO: Access modifiers changed from: protected */
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                    AppMethods.d((int) R.string.remove_black_success);
                    UserInfoNewPresenter.this.l.in_blacklist = "0";
                    if ("12".equals(UserInfoNewPresenter.this.l.relationship)) {
                        UserInfoNewPresenter.this.l.relationship = "8";
                    } else {
                        UserInfoNewPresenter.this.l.relationship = "0";
                    }
                    UserInfoNewPresenter.this.b.a(UserInfoNewPresenter.this.l);
                    UserInfo.getInstance().getLoginUserInfo().removeBlackCount();
                    if (UserInfoNewPresenter.this.l.uid != null) {
                        LiveEventBus.get("feed_relation_ship").post(UserInfoNewPresenter.this.l);
                    }
                }

                public void onUIFinish() {
                    DialogUtils.b(UserInfoNewPresenter.this.d);
                    super.onUIFinish();
                }

                public void onUIStart() {
                    super.onUIStart();
                }
            }, UserInfo.getInstance().getLoginUserInfo().getUid(), this.l.uid, this.f20588c);
        }
    }

    public void m() {
        ProfileHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.user.presenter.UserInfoNewPresenter.12
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public BluedEntityA<Object> parseData(String str) {
                return super.parseData(str);
            }

            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                try {
                    if (bluedEntityA == null) {
                        AppMethods.a(AppInfo.d().getResources().getString(2131887272));
                        return;
                    }
                    UserInfoNewPresenter.this.a(UserInfoNewPresenter.this.l);
                    AppMethods.d((int) R.string.operation_successful);
                } catch (Exception e) {
                    e.printStackTrace();
                    AppMethods.a(AppInfo.d().getResources().getString(2131887272));
                }
            }

            public void onUIFinish() {
                DialogUtils.b(UserInfoNewPresenter.this.d);
            }

            public void onUIStart() {
                DialogUtils.a(UserInfoNewPresenter.this.d);
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), this.l.uid, (IRequestHost) null);
    }

    public void n() {
        MineHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.user.presenter.UserInfoNewPresenter.13
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public BluedEntityA<Object> parseData(String str) {
                return super.parseData(str);
            }

            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                try {
                    if (bluedEntityA == null) {
                        AppMethods.a(AppInfo.d().getResources().getString(2131887272));
                        return;
                    }
                    UserInfoNewPresenter.this.a(UserInfoNewPresenter.this.l);
                    AppMethods.d((int) R.string.operation_successful);
                } catch (Exception e) {
                    e.printStackTrace();
                    AppMethods.a(AppInfo.d().getResources().getString(2131887272));
                }
            }

            public boolean onUIFailure(int i, String str) {
                AppMethods.a(str);
                return super.onUIFailure(i, str);
            }

            public void onUIFinish() {
                DialogUtils.b(UserInfoNewPresenter.this.d);
            }

            public void onUIStart() {
                DialogUtils.a(UserInfoNewPresenter.this.d);
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), this.l.uid, (IRequestHost) null);
    }

    public void o() {
        UserHttpUtils.a(this.f20587a, new UserRelationshipUtils.IAddOrRemoveAttentionDone() { // from class: com.soft.blued.ui.user.presenter.UserInfoNewPresenter.14
            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void a() {
            }

            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void a(String str) {
            }

            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void b() {
            }

            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void b(String str) {
                UserInfoNewPresenter.this.l.relationship = str;
                UserInfoNewPresenter.this.l.secretly_followed_status = 0;
                AppMethods.d((int) R.string.done);
            }

            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void c() {
            }
        }, this.l.uid, this.f, this.f20588c);
    }

    public void p() {
        UserHttpUtils.a(this.l.uid, this.f20588c, new BluedUIHttpResponse<BluedEntityA<UserInfoEntity>>() { // from class: com.soft.blued.ui.user.presenter.UserInfoNewPresenter.15
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<UserInfoEntity> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                UserInfoNewPresenter.this.l.secretly_followed_status = 1;
                UserInfoNewPresenter.this.b.a(UserInfoNewPresenter.this.l);
                AppMethods.d((int) R.string.secret_follow_success);
            }
        });
    }

    public void q() {
        ProfileHttpUtils.d(new BluedUIHttpResponse<BluedEntityA<MultiHeadMigration.DataBean>>(this.f20588c) { // from class: com.soft.blued.ui.user.presenter.UserInfoNewPresenter.17
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<MultiHeadMigration.DataBean> bluedEntityA) {
                if (bluedEntityA != null) {
                    MultiHeadMigration.DataBean dataBean = (MultiHeadMigration.DataBean) bluedEntityA.getSingleData();
                    if (!UserInfoNewPresenter.this.e || dataBean == null) {
                        return;
                    }
                    if (dataBean.vip_grade != 0 && dataBean.vip_avatar_num > 0) {
                        AppMethods.a(UserInfoNewPresenter.this.f20587a.getResources().getString(R.string.privacy_photo_album_moved_toast));
                    } else if (dataBean.vip_grade != 0 || dataBean.vip_avatar_num <= 0) {
                    } else {
                        AppMethods.a(UserInfoNewPresenter.this.f20587a.getResources().getString(R.string.privacy_photo_album_moved_toast_vip));
                    }
                }
            }
        }, UserInfo.getInstance().getLoginUserInfo().uid, this.f20588c);
    }

    public void r() {
        if (this.l == null) {
            return;
        }
        ChatHttpUtils.a(this.l.uid + "", "user", new BluedUIHttpResponse() { // from class: com.soft.blued.ui.user.presenter.UserInfoNewPresenter.18
            public void onUIUpdate(BluedEntity bluedEntity) {
                if (UserInfoNewPresenter.this.l != null) {
                    UserInfoNewPresenter.this.l.poke_days = 0;
                }
                UserInfoNewPresenter.this.b.d();
            }
        });
    }

    public boolean s() {
        UserInfoEntity userInfoEntity = this.l;
        boolean z = true;
        if (userInfoEntity == null || userInfoEntity.users_face != 1) {
            if (this.e) {
                return true;
            }
            z = false;
        }
        return z;
    }

    public boolean t() {
        UserInfoEntity userInfoEntity = this.l;
        return userInfoEntity != null && userInfoEntity.personal_display == 1;
    }
}

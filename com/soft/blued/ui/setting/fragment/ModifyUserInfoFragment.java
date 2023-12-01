package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.module.common.db.UserAccountsVDao;
import com.blued.android.module.common.trace.EventTrackSettings;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.AuditingProfileModel;
import com.blued.android.module.common.user.model.BluedAlbum;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.user.model.UserRestrictedDescModel;
import com.blued.android.module.common.user.model.UserTag;
import com.blued.android.module.common.user.model.UserTagAll;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.utils.ReflectionUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.area.AreaUtils;
import com.blued.android.module.common.utils.third.QiniuUploadUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.dialog.BluedAlertDialog;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.common.widget.menu.ActionSheet;
import com.blued.android.module.common.widget.menu.CommonShowBottomWindow;
import com.blued.community.view.PhotoGridView;
import com.blued.das.settings.SettingsProtos;
import com.bytedance.applog.tracker.Tracker;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.soft.blued.R;
import com.soft.blued.customview.DragGridBaseAdapter;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.http.ProfileHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.track.EventTrackPersonalProfile;
import com.soft.blued.ui.feed.fragment.PhotoSelectFragment;
import com.soft.blued.ui.find.observer.PersonalVerifyObserver;
import com.soft.blued.ui.msg.manager.SubscribeNumberManager;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.ui.setting.View.LeftIconSpan;
import com.soft.blued.ui.setting.View.ModifyUserInfoPopView;
import com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment;
import com.soft.blued.ui.setting.model.BluedBlackList;
import com.soft.blued.ui.user.model.MultiHeadMigration;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import net.simonvt.numberpicker.NumberPicker;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/ModifyUserInfoFragment.class */
public class ModifyUserInfoFragment extends BaseFragment implements View.OnClickListener {
    private static String[] av;
    private TextView A;
    private TextView B;
    private TextView C;
    private LinearLayout D;
    private LinearLayout E;
    private LinearLayout F;
    private LinearLayout G;
    private LinearLayout H;
    private LinearLayout I;
    private LinearLayout J;
    private LinearLayout K;
    private LinearLayout L;
    private LinearLayout M;
    private LinearLayout N;
    private LinearLayout O;
    private LinearLayout P;
    private LinearLayout Q;
    private LinearLayout R;
    private LinearLayout S;
    private LinearLayout T;
    private LinearLayout U;
    private LinearLayout V;
    private LinearLayout W;
    private LinearLayout X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a  reason: collision with root package name */
    ModifyUserInfoPopView f19742a;
    private ArrayList<String> aC;
    private BluedAlbum aD;
    private boolean aE;
    private ArrayList<String> aG;
    private ArrayList<String> aI;
    private ArrayList<String> aK;
    private String aL;
    private String aM;
    private ArrayList<String> aU;
    private String aV;
    private String aW;
    private String aX;
    private String aY;
    private String aZ;
    private TextView aa;
    private TextView ab;
    private TextView ac;
    private ImageView ad;
    private ImageView ae;
    private ImageView af;
    private LinearLayout ag;
    private ImageView ah;
    private ImageView ai;

    /* renamed from: ar  reason: collision with root package name */
    private PhotoGridView f19743ar;
    private UserDragGirdAdapter at;
    private LoadOptions au;
    private int aw;
    private int ax;
    private String ba;
    private CommonTopTitleNoTrans bc;
    private TextView bd;
    private ScrollView be;
    private View bf;
    private ImageView bg;
    private TextView bh;
    private TextView bi;
    private TextView bj;
    private String bk;
    private int bl;
    private Context d;
    private View e;
    private Dialog f;
    private ToggleButton h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private TextView y;
    private TextView z;
    private String g = ModifyUserInfoFragment.class.getSimpleName();
    private String aj = "0";
    private int ak = 0;
    private int al = 170;
    private int am = 60;
    private int an = 120;
    private int ao = 220;
    private int ap = 30;
    private int aq = 200;
    private List<BluedAlbum> as = new LinkedList();
    private String ay = "";
    private String az = "";
    private boolean aA = false;
    private ArrayList<String> aB = new ArrayList<>();
    private ArrayList<String> aF = new ArrayList<>();
    private ArrayList<String> aH = new ArrayList<>();
    private ArrayList<String> aJ = new ArrayList<>();
    private List<String> aN = new ArrayList();
    private List<String> aO = new ArrayList();
    private List<String> aP = new ArrayList();
    private List<String> aQ = new ArrayList();
    private List<String> aR = new ArrayList();
    private List<String> aS = new ArrayList();
    private ArrayList<String> aT = new ArrayList<>();
    private List<ViewGroup> bb = new ArrayList();
    private boolean bm = false;
    private boolean bn = false;
    public BluedUIHttpResponse b = new BluedUIHttpResponse<BluedEntityA<UserInfoEntity>>() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment.17
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<UserInfoEntity> bluedEntityA) {
            if (bluedEntityA == null) {
                AppMethods.d(2131888227);
                return;
            }
            DialogUtils.b(ModifyUserInfoFragment.this.f);
            UserInfoEntity userInfoEntity = (UserInfoEntity) bluedEntityA.data.get(0);
            if (userInfoEntity == null) {
                AppMethods.d(2131888227);
                return;
            }
            ModifyUserInfoFragment.this.a(userInfoEntity.is_audited, userInfoEntity.avatar_audited);
            if (userInfoEntity.vip_avatars != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < userInfoEntity.vip_avatars.size(); i++) {
                    BluedAlbum bluedAlbum = new BluedAlbum();
                    bluedAlbum.setPid(String.valueOf(userInfoEntity.vip_avatars.get(i).getPid()));
                    bluedAlbum.setUrl(userInfoEntity.vip_avatars.get(i).getUrl());
                    arrayList.add(bluedAlbum);
                }
                UserInfo.getInstance().getLoginUserInfo().setVip_avatars(arrayList);
                ModifyUserInfoFragment.this.a();
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    Map<String, String> f19744c = BluedHttpTools.a();
    private boolean bo = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment$15  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/ModifyUserInfoFragment$15.class */
    public class AnonymousClass15 implements QiniuUploadTools.QiNiuListener {

        /* renamed from: a  reason: collision with root package name */
        double f19752a = 0.0d;
        final /* synthetic */ String b;

        AnonymousClass15(String str) {
            this.b = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(double d, String str) {
            StringBuilder sb = new StringBuilder();
            double d2 = d * 100.0d;
            sb.append(Math.round(d2));
            sb.append("%");
            String sb2 = sb.toString();
            int b = ModifyUserInfoFragment.this.b(str);
            if (d2 >= 100.0d) {
                ((BluedAlbum) ModifyUserInfoFragment.this.as.get(b)).setProgress("99%");
            } else if (d > this.f19752a) {
                ((BluedAlbum) ModifyUserInfoFragment.this.as.get(b)).setProgress(sb2);
                this.f19752a = d;
            }
            ModifyUserInfoFragment.this.at.notifyDataSetChanged();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(String str, String str2, String str3) {
            ModifyUserInfoFragment.this.a(str, str2, str3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str) {
            AppMethods.a(ModifyUserInfoFragment.this.getResources().getString(2131887272));
            ((BluedAlbum) ModifyUserInfoFragment.this.as.get(ModifyUserInfoFragment.this.b(str))).setProgress(ModifyUserInfoFragment.this.getResources().getString(R.string.failure));
            ModifyUserInfoFragment.this.at.notifyDataSetChanged();
        }

        public void a(final String str) {
            ModifyUserInfoFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$ModifyUserInfoFragment$15$kxFM9b0h6-Olv5B_jOXxdAzy8wo
                @Override // java.lang.Runnable
                public final void run() {
                    ModifyUserInfoFragment.AnonymousClass15.this.b(str);
                }
            });
        }

        public void a(final String str, final double d) {
            if (ModifyUserInfoFragment.this.aE) {
                return;
            }
            ModifyUserInfoFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$ModifyUserInfoFragment$15$QV4WT8eol9ddzR42pgtGcvw6ot0
                @Override // java.lang.Runnable
                public final void run() {
                    ModifyUserInfoFragment.AnonymousClass15.this.a(d, str);
                }
            });
        }

        public void a(final String str, final String str2) {
            ModifyUserInfoFragment modifyUserInfoFragment = ModifyUserInfoFragment.this;
            final String str3 = this.b;
            modifyUserInfoFragment.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$ModifyUserInfoFragment$15$Ql-WOcmHZtO3L4ZtzcVTXwryCY8
                @Override // java.lang.Runnable
                public final void run() {
                    ModifyUserInfoFragment.AnonymousClass15.this.a(str, str3, str2);
                }
            });
        }

        public boolean a() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment$26  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/ModifyUserInfoFragment$26.class */
    public class AnonymousClass26 extends BluedUIHttpResponse<BluedEntityA<BluedLoginResult>> {
        AnonymousClass26(IRequestHost iRequestHost) {
            super(iRequestHost);
        }

        private String a(List<String> list) {
            if (TypeUtils.a(list)) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (String str : list) {
                spannableStringBuilder.append((CharSequence) (str + ","));
            }
            return spannableStringBuilder.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(DialogInterface dialogInterface) {
            ModifyUserInfoFragment.this.d();
        }

        private boolean a(List<String> list, List<String> list2) {
            if (TypeUtils.a(list) && TypeUtils.a(list2)) {
                return true;
            }
            return !TypeUtils.a(list) && !TypeUtils.a(list2) && list.size() == list2.size() && list.containsAll(list2) && list2.containsAll(list);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public BluedEntityA<BluedLoginResult> parseData(String str) {
            UserAccountsVDao.a().b(str);
            return super.parseData(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<BluedLoginResult> bluedEntityA) {
            if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                return;
            }
            BluedLoginResult bluedLoginResult = (BluedLoginResult) bluedEntityA.data.get(0);
            bluedLoginResult.setVip_avatars(UserInfo.getInstance().getLoginUserInfo().getVip_avatars());
            UserInfo.getInstance().getLoginUserInfo().is_show_vip_page = bluedLoginResult.is_show_vip_page;
            BluedConfig.a().b().is_show_vip_page = bluedLoginResult.is_show_vip_page;
            UserInfo.getInstance().getLoginUserInfo().setAvatar(bluedLoginResult.getAvatar());
            UserInfo.getInstance().getLoginUserInfo().setHeight(bluedLoginResult.getHeight());
            UserInfo.getInstance().getLoginUserInfo().setWeight(bluedLoginResult.getWeight());
            UserInfo.getInstance().getLoginUserInfo().setAge(bluedLoginResult.getAge());
            UserInfo.getInstance().getLoginUserInfo().setBirthday(bluedLoginResult.getBirthday());
            UserInfo.getInstance().getLoginUserInfo().setTags(bluedLoginResult.getTags());
            UserInfo.getInstance().getLoginUserInfo().setCity_settled(bluedLoginResult.getCity_settled());
            UserInfo.getInstance().getLoginUserInfo().setHometown(bluedLoginResult.getHometown());
            UserInfo.getInstance().getLoginUserInfo().setRole(bluedLoginResult.getRole());
            UserInfo.getInstance().getLoginUserInfo().setBlood_type(bluedLoginResult.getBlood_type());
            UserInfo.getInstance().getLoginUserInfo().setName(bluedLoginResult.getName());
            UserInfo.getInstance().getLoginUserInfo().setEthnicity(bluedLoginResult.getEthnicity());
            UserInfo.getInstance().getLoginUserInfo().setMate(bluedLoginResult.getMate());
            UserInfo.getInstance().getLoginUserInfo().health_test_result = bluedLoginResult.health_test_result;
            UserInfo.getInstance().getLoginUserInfo().health_test_time = bluedLoginResult.health_test_time;
            UserInfo.getInstance().getLoginUserInfo().health_prpe_use_situation = bluedLoginResult.health_prpe_use_situation;
            if (UserInfo.getInstance().getLoginUserInfo().auditing_profile == null) {
                UserInfo.getInstance().getLoginUserInfo().auditing_profile = new AuditingProfileModel();
            }
            UserInfo.getInstance().getLoginUserInfo().auditing_profile.description = ModifyUserInfoFragment.this.j.getText().toString();
            AppMethods.a(ModifyUserInfoFragment.this.getResources().getString(R.string.modify_user_info_success));
            String a2 = a(ModifyUserInfoFragment.this.aO);
            String a3 = a(ModifyUserInfoFragment.this.aS);
            String a4 = a(ModifyUserInfoFragment.this.aQ);
            BluedConfig.a().d();
            LogUtils.c("originRole:" + ModifyUserInfoFragment.this.aL + ", modifiedRole:" + ModifyUserInfoFragment.this.aM);
            LogUtils.c("originCharacter:" + a(ModifyUserInfoFragment.this.aN) + ", modifiedCharacter:" + a2);
            LogUtils.c("originPurpose:" + a(ModifyUserInfoFragment.this.aR) + ", modifiedPurpose:" + a3);
            LogUtils.c("originHobby:" + a(ModifyUserInfoFragment.this.aP) + ", modifiedHobby:" + a4);
            if (StringUtils.a(ModifyUserInfoFragment.this.aL, ModifyUserInfoFragment.this.aM) && a(ModifyUserInfoFragment.this.aN, ModifyUserInfoFragment.this.aO) && a(ModifyUserInfoFragment.this.aR, ModifyUserInfoFragment.this.aS) && a(ModifyUserInfoFragment.this.aP, ModifyUserInfoFragment.this.aQ)) {
                ModifyUserInfoFragment.this.d();
                return;
            }
            ModifyUserInfoFragment.this.bo = true;
            UserInfoPostFeedDlgFragment userInfoPostFeedDlgFragment = new UserInfoPostFeedDlgFragment();
            Bundle bundle = new Bundle();
            bundle.putString("user_role", ModifyUserInfoFragment.this.aM);
            bundle.putString("user_character", a2);
            bundle.putString("user_purpose", a3);
            bundle.putString("user_hobby", a4);
            userInfoPostFeedDlgFragment.setArguments(bundle);
            userInfoPostFeedDlgFragment.a(new DialogInterface.OnDismissListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$ModifyUserInfoFragment$26$QU7FLj_S4OcEhaaqTqj-JaIcCsY
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    ModifyUserInfoFragment.AnonymousClass26.this.a(dialogInterface);
                }
            });
            userInfoPostFeedDlgFragment.show(ModifyUserInfoFragment.this.getParentFragmentManager(), userInfoPostFeedDlgFragment.b());
        }

        public boolean onUIFailure(int i, String str) {
            AppMethods.a(str);
            return super.onUIFailure(i, str);
        }

        public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(ModifyUserInfoFragment.this.f);
        }

        public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(ModifyUserInfoFragment.this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment$32  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/ModifyUserInfoFragment$32.class */
    public class AnonymousClass32 extends BluedUIHttpResponse<BluedEntityA<BluedAlbum>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f19773a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass32(IRequestHost iRequestHost, String str) {
            super(iRequestHost);
            this.f19773a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            ModifyUserInfoFragment.this.bj.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<BluedAlbum> bluedEntityA) {
            ImageLoader.a(ModifyUserInfoFragment.this.getFragmentActive(), this.f19773a).b((int) R.drawable.feed_photo_add).c().a(ModifyUserInfoFragment.this.ah);
            ModifyUserInfoFragment.this.a(-1, 0);
            if (UserInfo.getInstance().getLoginUserInfo().auditing_profile == null) {
                UserInfo.getInstance().getLoginUserInfo().auditing_profile = new AuditingProfileModel();
            }
            UserInfo.getInstance().getLoginUserInfo().auditing_profile.latest_avatar = this.f19773a;
            BluedConfig.a().d();
            AppMethods.d((int) R.string.avatar_effect_after_audit);
            ModifyUserInfoFragment.this.bj.setText("100%");
            ModifyUserInfoFragment.this.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$ModifyUserInfoFragment$32$XXSgPOM9gIkHv0YkWwwbeSYrFzI
                @Override // java.lang.Runnable
                public final void run() {
                    ModifyUserInfoFragment.AnonymousClass32.this.a();
                }
            }, 2000L);
        }

        public boolean onUIFailure(int i, String str) {
            ModifyUserInfoFragment.this.bj.setText(R.string.failure);
            return super.onUIFailure(i, str);
        }

        public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(ModifyUserInfoFragment.this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment$9  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/ModifyUserInfoFragment$9.class */
    public class AnonymousClass9 implements ActionSheet.ActionSheetListener {
        AnonymousClass9() {
        }

        public void a(ActionSheet actionSheet, int i) {
            if (i == 0) {
                PermissionUtils.f(new PermissionCallbacks() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment.9.1
                    public void U_() {
                        if (4 == UserInfo.getInstance().getLoginUserInfo().getVBadge() || 7 == UserInfo.getInstance().getLoginUserInfo().getVBadge()) {
                            CommonAlertDialog.a(ModifyUserInfoFragment.this.d, (String) null, ModifyUserInfoFragment.this.getResources().getString(2131886918), ModifyUserInfoFragment.this.getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment.9.1.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i2) {
                                    Tracker.onClick(dialogInterface, i2);
                                    PhotoSelectFragment.a(ModifyUserInfoFragment.this, 2, 177);
                                }
                            }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                        } else {
                            PhotoSelectFragment.a(ModifyUserInfoFragment.this, 2, 177);
                        }
                    }

                    public void a(String[] strArr) {
                    }
                });
            } else if (i != 1) {
            } else {
                BasePhotoFragment.a(ModifyUserInfoFragment.this.d, new String[]{UserInfo.getInstance().getLoginUserInfo().getAvatar()}, 0, 3, ModifyUserInfoFragment.this.au);
            }
        }

        public void a(ActionSheet actionSheet, boolean z) {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/ModifyUserInfoFragment$UserDragGirdAdapter.class */
    public class UserDragGirdAdapter extends BaseAdapter implements DragGridBaseAdapter {
        private LayoutInflater b;

        /* renamed from: c  reason: collision with root package name */
        private ImageView f19783c;
        private TextView d;
        private TextView e;
        private int f = -1;

        /* renamed from: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment$UserDragGirdAdapter$3  reason: invalid class name */
        /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/ModifyUserInfoFragment$UserDragGirdAdapter$3.class */
        class AnonymousClass3 implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ BluedAlbum f19789a;
            final /* synthetic */ int b;

            AnonymousClass3(BluedAlbum bluedAlbum, int i) {
                this.f19789a = bluedAlbum;
                this.b = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackSettings.a(SettingsProtos.Event.MINE_EDIT_MORE_PHOTO_BTN_CLICK);
                if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0 && BluedConfig.a().g().is_vip_more_avatar == 0) {
                    PayUtils.a(ModifyUserInfoFragment.this.getActivity(), 10, "vip_user_avatar");
                    InstantLog.a("modify_vip_multi_avatar_click", 0);
                    return;
                }
                InstantLog.a("modify_vip_multi_avatar_click", 1);
                ModifyUserInfoFragment.this.aD = this.f19789a;
                ModifyUserInfoFragment.this.aD.position = this.b;
                UserRestrictedDescModel userRestrictedDescModel = UserInfo.getInstance().getLoginUserInfo().restricted_desc;
                if (userRestrictedDescModel != null && userRestrictedDescModel.isExist("avatar")) {
                    AppMethods.a(userRestrictedDescModel.getAvatar_desc());
                } else if (TextUtils.isEmpty(this.f19789a.getUrl())) {
                    PermissionUtils.f(new PermissionCallbacks() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment.UserDragGirdAdapter.3.1
                        public void U_() {
                            PhotoSelectFragment.a(ModifyUserInfoFragment.this, 2, 22);
                        }

                        public void a(String[] strArr) {
                        }
                    });
                } else {
                    String[] stringArray = ModifyUserInfoFragment.this.getResources().getStringArray(R.array.headpic_items);
                    stringArray[0] = ModifyUserInfoFragment.this.getResources().getString(R.string.change_photo);
                    CommonShowBottomWindow.a((FragmentActivity) ModifyUserInfoFragment.this.d, stringArray, new ActionSheet.ActionSheetListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment.UserDragGirdAdapter.3.2
                        public void a(ActionSheet actionSheet, int i) {
                            if (i == 0) {
                                PermissionUtils.f(new PermissionCallbacks() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment.UserDragGirdAdapter.3.2.1
                                    public void U_() {
                                        PhotoSelectFragment.a(ModifyUserInfoFragment.this, 2, 22);
                                    }

                                    public void a(String[] strArr) {
                                    }
                                });
                            } else if (i != 1) {
                                if (i != 2) {
                                    return;
                                }
                                ModifyUserInfoFragment.this.a(AnonymousClass3.this.f19789a.getPid());
                            } else {
                                ArrayList arrayList = new ArrayList();
                                for (BluedAlbum bluedAlbum : ModifyUserInfoFragment.this.as) {
                                    if (bluedAlbum.getPid() != null && com.soft.blued.utils.StringUtils.d(bluedAlbum.key)) {
                                        arrayList.add(bluedAlbum);
                                    }
                                }
                                String[] strArr = new String[arrayList.size()];
                                String[] strArr2 = new String[arrayList.size()];
                                int i2 = 0;
                                while (true) {
                                    int i3 = i2;
                                    if (i3 >= arrayList.size()) {
                                        BasePhotoFragment.a(ModifyUserInfoFragment.this.d, strArr, strArr2, AnonymousClass3.this.b, 13, UserInfo.getInstance().getLoginUserInfo().getName(), ModifyUserInfoFragment.this.au);
                                        return;
                                    }
                                    strArr[i3] = ((BluedAlbum) arrayList.get(i3)).getUrl();
                                    strArr2[i3] = ((BluedAlbum) arrayList.get(i3)).getPid();
                                    i2 = i3 + 1;
                                }
                            }
                        }

                        public void a(ActionSheet actionSheet, boolean z) {
                        }
                    });
                }
            }
        }

        public UserDragGirdAdapter(Context context) {
            this.b = LayoutInflater.from(context);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ModifyUserInfoFragment.this.as.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            View inflate = this.b.inflate(R.layout.fragment_modify_grid_item, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_shadow);
            this.d = textView;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.height = ModifyUserInfoFragment.this.aw;
            this.d.setLayoutParams(layoutParams);
            this.e = (TextView) inflate.findViewById(R.id.tv_progress);
            ImageView imageView = (ImageView) inflate.findViewById(2131364232);
            this.f19783c = imageView;
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.height = ModifyUserInfoFragment.this.aw;
            this.d.setLayoutParams(layoutParams2);
            final BluedAlbum bluedAlbum = (BluedAlbum) ModifyUserInfoFragment.this.as.get(i);
            if (com.soft.blued.utils.StringUtils.d(bluedAlbum.progress)) {
                this.e.setVisibility(8);
                this.d.setVisibility(8);
            } else {
                this.d.setVisibility(0);
                this.e.setVisibility(0);
                this.e.setText(bluedAlbum.progress);
            }
            if (TextUtils.isEmpty(bluedAlbum.getUrl())) {
                this.f19783c.setImageResource(R.drawable.feed_photo_add);
            } else {
                ImageLoader.a(ModifyUserInfoFragment.this.getFragmentActive(), bluedAlbum.getUrl()).b((int) R.drawable.feed_photo_add).a(this.f19783c);
            }
            this.d.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment.UserDragGirdAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    if (UserInfo.getInstance().getLoginUserInfo().vip_grade != 0 || BluedConfig.a().g().is_vip_more_avatar != 0) {
                        PermissionUtils.f(new PermissionCallbacks() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment.UserDragGirdAdapter.1.1
                            public void U_() {
                                InstantLog.a("modify_vip_multi_avatar_click", 1);
                                if (bluedAlbum.progress.equals(ModifyUserInfoFragment.this.getResources().getString(R.string.failure))) {
                                    ModifyUserInfoFragment.this.aD = bluedAlbum;
                                    ModifyUserInfoFragment.this.aD.position = i;
                                    PhotoSelectFragment.a(ModifyUserInfoFragment.this, 2, 22);
                                }
                            }

                            public void a(String[] strArr) {
                            }
                        });
                        return;
                    }
                    PayUtils.a(ModifyUserInfoFragment.this.getActivity(), 10, "vip_user_avatar");
                    InstantLog.a("modify_vip_multi_avatar_click", 0);
                }
            });
            this.e.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment.UserDragGirdAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0 && BluedConfig.a().g().is_vip_more_avatar == 0) {
                        PayUtils.a(ModifyUserInfoFragment.this.getActivity(), 10, "vip_user_avatar");
                        InstantLog.a("modify_vip_multi_avatar_click", 0);
                        return;
                    }
                    InstantLog.a("modify_vip_multi_avatar_click", 1);
                    if (bluedAlbum.progress.equals(ModifyUserInfoFragment.this.getResources().getString(R.string.failure))) {
                        ModifyUserInfoFragment.this.aD = bluedAlbum;
                        ModifyUserInfoFragment.this.aD.position = i;
                        PhotoSelectFragment.a(ModifyUserInfoFragment.this, 2, 22);
                    }
                }
            });
            this.f19783c.setOnClickListener(new AnonymousClass3(bluedAlbum, i));
            if (i == this.f) {
                inflate.setVisibility(4);
            }
            return inflate;
        }
    }

    private String a(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return stringBuffer.toString();
            }
            if ("en".equals(BlueAppLocal.a())) {
                StringBuilder sb = new StringBuilder();
                sb.append(com.soft.blued.utils.StringUtils.d(stringBuffer.toString()) ? "" : ", ");
                sb.append(arrayList.get(i2));
                stringBuffer.append(sb.toString());
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(com.soft.blued.utils.StringUtils.d(stringBuffer.toString()) ? "" : "、");
                sb2.append(arrayList.get(i2));
                stringBuffer.append(sb2.toString());
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        BluedLoginResult loginUserInfo = UserInfo.getInstance().getLoginUserInfo();
        if (loginUserInfo.is_audited == 0) {
            this.bi.setVisibility(0);
            if (loginUserInfo.avatar_audited == 0) {
                this.bi.setText(R.string.audited_picture_profile_in_review);
            } else {
                this.bi.setText(R.string.audited_profile_in_review);
            }
        } else if (loginUserInfo.avatar_audited != 0) {
            this.bi.setVisibility(8);
        } else {
            this.bi.setVisibility(0);
            this.bi.setText(R.string.audited_picture_in_review);
        }
    }

    public static void a(Context context, int i, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("show_avatar_items", Boolean.valueOf(z));
        bundle.putInt("fromPage", i);
        TerminalActivity.d(context, ModifyUserInfoFragment.class, bundle);
    }

    public static void a(Context context, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("show_avatar_items", Boolean.valueOf(z));
        TerminalActivity.d(context, ModifyUserInfoFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        Tracker.onCheckedChanged(compoundButton, z);
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade != 0) {
            EventTrackPersonalProfile.a(z);
        }
    }

    private void a(TextView textView, TextView textView2, ImageView imageView, boolean z) {
        if (z) {
            textView.setCompoundDrawablePadding(DensityUtil.a(2.0f));
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_modify_user_info_restricted, 0, 0, 0);
            textView.setTextColor(this.d.getResources().getColor(2131101617));
            if (textView2 != null) {
                textView2.setTextColor(this.d.getResources().getColor(2131101617));
            }
            if (imageView != null) {
                imageView.setImageResource(2131233206);
                return;
            }
            return;
        }
        textView.setCompoundDrawablePadding(0);
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        textView.setTextColor(this.d.getResources().getColor(2131101202));
        if (textView2 != null) {
            textView2.setTextColor(this.d.getResources().getColor(2131101202));
        }
        if (imageView != null) {
            imageView.setImageResource(2131233205);
        }
    }

    public static void a(BaseFragment baseFragment, int i) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("show_avatar_items", false);
        bundle.putInt("fromPage", i);
        TerminalActivity.a(baseFragment, ModifyUserInfoFragment.class, bundle, 701);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserInfoEntity userInfoEntity) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String str = userInfoEntity.avatar;
        String str2 = userInfoEntity.name;
        String str3 = userInfoEntity.description;
        AuditingProfileModel auditingProfileModel = userInfoEntity.auditing_profile;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        if (auditingProfileModel != null) {
            String str7 = str2;
            String str8 = str3;
            if (userInfoEntity.is_audited == 0) {
                if (!TextUtils.isEmpty(auditingProfileModel.name)) {
                    str2 = auditingProfileModel.name;
                }
                str7 = str2;
                str8 = str3;
                if (auditingProfileModel.description != null) {
                    str8 = auditingProfileModel.description;
                    str7 = str2;
                }
            }
            str4 = str;
            str5 = str7;
            str6 = str8;
            if (userInfoEntity.avatar_audited == 0) {
                str4 = str;
                str5 = str7;
                str6 = str8;
                if (!TextUtils.isEmpty(auditingProfileModel.latest_avatar)) {
                    str4 = auditingProfileModel.latest_avatar;
                    str6 = str8;
                    str5 = str7;
                }
            }
        }
        this.i.setText(str5);
        this.j.setText(str6);
        ImageLoader.a(getFragmentActive(), str4).b((int) R.drawable.feed_photo_add).c().a(this.ah);
        if (userInfoEntity.is_show_vip_page == 1) {
            this.h.setChecked(true);
        }
        this.k.setText(TimeAndDateUtils.b(userInfoEntity.birthday));
        int aF = BluedPreferences.aF();
        if (aF == 1) {
            this.l.setText(userInfoEntity.height + " / " + userInfoEntity.weight);
        } else if (aF == 2) {
            this.l.setText(com.soft.blued.utils.StringUtils.a(userInfoEntity.height, BlueAppLocal.c(), false) + " / " + com.soft.blued.utils.StringUtils.a(userInfoEntity.weight, BlueAppLocal.c()));
        }
        try {
            this.r.setText(com.soft.blued.utils.StringUtils.b(Integer.parseInt(userInfoEntity.ethnicity)));
        } catch (Exception e) {
        }
        String e2 = com.soft.blued.utils.StringUtils.e(userInfoEntity.role);
        this.aL = e2;
        this.aM = e2;
        this.m.setText(e2);
        String str9 = UserRelationshipUtils.c().get(userInfoEntity.blood_type);
        String str10 = str9;
        if (com.soft.blued.utils.StringUtils.d(str9)) {
            str10 = this.d.getResources().getString(R.string.hidden);
        }
        this.n.setText(str10);
        this.q.setText(AreaUtils.getAreaTxt(userInfoEntity.hometown, LocaleUtils.c()));
        if (!TextUtils.isEmpty(userInfoEntity.mate)) {
            int parseInt = Integer.parseInt(userInfoEntity.mate);
            if (parseInt == 1 || parseInt == 0) {
                this.t.setText(getResources().getString(R.string.do_not_show));
            } else {
                this.t.setText(com.soft.blued.utils.StringUtils.a(this.d, BlueAppLocal.c(), parseInt));
            }
        }
        try {
            Log.v("drb", "服务器返回 userInfo.mate:" + userInfoEntity.mate);
            int b = UserRelationshipUtils.b(this.d, this.t.getText().toString());
            Log.v("drb", "服务器返回解析后 userInfo.mate:" + b);
            UserInfo.getInstance().getLoginUserInfo().setMate(b + "");
        } catch (Exception e3) {
        }
        UserInfoHelper.a(this.ai, userInfoEntity.vbadge, 3);
        g();
        UserTagAll userTagAll = userInfoEntity.tags;
        if (userTagAll != null) {
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            this.aR.clear();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= userTagAll.i_want.size()) {
                    break;
                }
                this.aF.add(((UserTag) userTagAll.i_want.get(i2)).id);
                if ("EN".equals(BlueAppLocal.b())) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(com.soft.blued.utils.StringUtils.d(stringBuffer.toString()) ? "" : ", ");
                    sb.append(((UserTag) userTagAll.i_want.get(i2)).name);
                    stringBuffer.append(sb.toString());
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(com.soft.blued.utils.StringUtils.d(stringBuffer.toString()) ? "" : "、");
                    sb2.append(((UserTag) userTagAll.i_want.get(i2)).name);
                    stringBuffer.append(sb2.toString());
                }
                stringBuffer2.append(((UserTag) userTagAll.i_want.get(i2)).name + ",");
                this.aR.add(((UserTag) userTagAll.i_want.get(i2)).name);
                i = i2 + 1;
            }
            this.u.setText(stringBuffer.toString());
            this.aS.clear();
            this.aS.addAll(this.aR);
            StringBuffer stringBuffer3 = new StringBuffer();
            if (userTagAll.work != null) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= userTagAll.work.size()) {
                        break;
                    }
                    this.aH.add(((UserTag) userTagAll.work.get(i4)).id);
                    if ("EN".equals(BlueAppLocal.b())) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(com.soft.blued.utils.StringUtils.d(stringBuffer3.toString()) ? "" : ", ");
                        sb3.append(((UserTag) userTagAll.work.get(i4)).name);
                        stringBuffer3.append(sb3.toString());
                    } else {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(com.soft.blued.utils.StringUtils.d(stringBuffer3.toString()) ? "" : "、");
                        sb4.append(((UserTag) userTagAll.work.get(i4)).name);
                        stringBuffer3.append(sb4.toString());
                    }
                    i3 = i4 + 1;
                }
            }
            this.v.setText(stringBuffer3.toString());
            StringBuffer stringBuffer4 = new StringBuffer();
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= userTagAll.type.size()) {
                    break;
                }
                this.aJ.add(((UserTag) userTagAll.type.get(i6)).id);
                if ("EN".equals(BlueAppLocal.b())) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(com.soft.blued.utils.StringUtils.d(stringBuffer4.toString()) ? "" : ", ");
                    sb5.append(((UserTag) userTagAll.type.get(i6)).name);
                    stringBuffer4.append(sb5.toString());
                } else {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(com.soft.blued.utils.StringUtils.d(stringBuffer4.toString()) ? "" : "、");
                    sb6.append(((UserTag) userTagAll.type.get(i6)).name);
                    stringBuffer4.append(sb6.toString());
                }
                i5 = i6 + 1;
            }
            this.w.setText(stringBuffer4.toString());
            StringBuffer stringBuffer5 = new StringBuffer();
            StringBuffer stringBuffer6 = new StringBuffer();
            this.aN.clear();
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= userTagAll.character.size()) {
                    break;
                }
                this.aJ.add(((UserTag) userTagAll.character.get(i8)).id);
                if ("EN".equals(BlueAppLocal.b())) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(com.soft.blued.utils.StringUtils.d(stringBuffer5.toString()) ? "" : ", ");
                    sb7.append(((UserTag) userTagAll.character.get(i8)).name);
                    stringBuffer5.append(sb7.toString());
                } else {
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(com.soft.blued.utils.StringUtils.d(stringBuffer5.toString()) ? "" : "、");
                    sb8.append(((UserTag) userTagAll.character.get(i8)).name);
                    stringBuffer5.append(sb8.toString());
                }
                stringBuffer6.append(((UserTag) userTagAll.character.get(i8)).name + ",");
                this.aN.add(((UserTag) userTagAll.character.get(i8)).name);
                i7 = i8 + 1;
            }
            this.x.setText(stringBuffer5.toString());
            this.aO.clear();
            this.aO.addAll(this.aN);
            StringBuffer stringBuffer7 = new StringBuffer();
            StringBuffer stringBuffer8 = new StringBuffer();
            this.aP.clear();
            if (userTagAll.hobbies != null) {
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    if (i10 >= userTagAll.hobbies.size()) {
                        break;
                    }
                    this.aJ.add(((UserTag) userTagAll.hobbies.get(i10)).id);
                    if ("EN".equals(BlueAppLocal.b())) {
                        StringBuilder sb9 = new StringBuilder();
                        sb9.append(com.soft.blued.utils.StringUtils.d(stringBuffer7.toString()) ? "" : ", ");
                        sb9.append(((UserTag) userTagAll.hobbies.get(i10)).name);
                        stringBuffer7.append(sb9.toString());
                    } else {
                        StringBuilder sb10 = new StringBuilder();
                        sb10.append(com.soft.blued.utils.StringUtils.d(stringBuffer7.toString()) ? "" : "、");
                        sb10.append(((UserTag) userTagAll.hobbies.get(i10)).name);
                        stringBuffer7.append(sb10.toString());
                    }
                    stringBuffer8.append(((UserTag) userTagAll.hobbies.get(i10)).name + ",");
                    this.aP.add(((UserTag) userTagAll.hobbies.get(i10)).name);
                    i9 = i10 + 1;
                }
            }
            this.y.setText(stringBuffer7.toString());
            this.aQ.clear();
            this.aQ.addAll(this.aP);
            StringBuffer stringBuffer9 = new StringBuffer();
            if (userTagAll.recreation != null) {
                int i11 = 0;
                while (true) {
                    int i12 = i11;
                    if (i12 >= userTagAll.recreation.size()) {
                        break;
                    }
                    this.aJ.add(((UserTag) userTagAll.recreation.get(i12)).id);
                    if ("EN".equals(BlueAppLocal.b())) {
                        StringBuilder sb11 = new StringBuilder();
                        sb11.append(com.soft.blued.utils.StringUtils.d(stringBuffer9.toString()) ? "" : ", ");
                        sb11.append(((UserTag) userTagAll.recreation.get(i12)).name);
                        stringBuffer9.append(sb11.toString());
                    } else {
                        StringBuilder sb12 = new StringBuilder();
                        sb12.append(com.soft.blued.utils.StringUtils.d(stringBuffer9.toString()) ? "" : "、");
                        sb12.append(((UserTag) userTagAll.recreation.get(i12)).name);
                        stringBuffer9.append(sb12.toString());
                    }
                    i11 = i12 + 1;
                }
            }
            this.z.setText(stringBuffer9.toString());
            StringBuffer stringBuffer10 = new StringBuffer();
            if (userTagAll.love_type != null) {
                int i13 = 0;
                while (true) {
                    int i14 = i13;
                    if (i14 >= userTagAll.love_type.size()) {
                        break;
                    }
                    this.aT.add(((UserTag) userTagAll.love_type.get(i14)).id);
                    if ("EN".equals(BlueAppLocal.b())) {
                        StringBuilder sb13 = new StringBuilder();
                        sb13.append(com.soft.blued.utils.StringUtils.d(stringBuffer10.toString()) ? "" : ", ");
                        sb13.append(((UserTag) userTagAll.love_type.get(i14)).name);
                        stringBuffer10.append(sb13.toString());
                    } else {
                        StringBuilder sb14 = new StringBuilder();
                        sb14.append(com.soft.blued.utils.StringUtils.d(stringBuffer10.toString()) ? "" : "、");
                        sb14.append(((UserTag) userTagAll.love_type.get(i14)).name);
                        stringBuffer10.append(sb14.toString());
                    }
                    i13 = i14 + 1;
                }
            }
            this.A.setText(stringBuffer10.toString());
            StringBuffer stringBuffer11 = new StringBuffer();
            if (userTagAll.love_character != null) {
                int i15 = 0;
                while (true) {
                    int i16 = i15;
                    if (i16 >= userTagAll.love_character.size()) {
                        break;
                    }
                    this.aT.add(((UserTag) userTagAll.love_character.get(i16)).id);
                    if ("EN".equals(BlueAppLocal.b())) {
                        StringBuilder sb15 = new StringBuilder();
                        sb15.append(com.soft.blued.utils.StringUtils.d(stringBuffer11.toString()) ? "" : ", ");
                        sb15.append(((UserTag) userTagAll.love_character.get(i16)).name);
                        stringBuffer11.append(sb15.toString());
                    } else {
                        StringBuilder sb16 = new StringBuilder();
                        sb16.append(com.soft.blued.utils.StringUtils.d(stringBuffer11.toString()) ? "" : "、");
                        sb16.append(((UserTag) userTagAll.love_character.get(i16)).name);
                        stringBuffer11.append(sb16.toString());
                    }
                    i15 = i16 + 1;
                }
            }
            this.B.setText(stringBuffer11.toString());
            StringBuffer stringBuffer12 = new StringBuffer();
            int i17 = 0;
            while (true) {
                int i18 = i17;
                if (i18 >= userTagAll.type.size()) {
                    break;
                }
                this.aB.add(((UserTag) userTagAll.type.get(i18)).id);
                StringBuilder sb17 = new StringBuilder();
                sb17.append(com.soft.blued.utils.StringUtils.d(stringBuffer12.toString()) ? "" : ",");
                sb17.append(((UserTag) userTagAll.type.get(i18)).name);
                stringBuffer12.append(sb17.toString());
                i17 = i18 + 1;
            }
            int i19 = 0;
            while (true) {
                int i20 = i19;
                if (i20 >= userTagAll.character.size()) {
                    break;
                }
                this.aB.add(((UserTag) userTagAll.character.get(i20)).id);
                StringBuilder sb18 = new StringBuilder();
                sb18.append(com.soft.blued.utils.StringUtils.d(stringBuffer12.toString()) ? "" : ",");
                sb18.append(((UserTag) userTagAll.character.get(i20)).name);
                stringBuffer12.append(sb18.toString());
                i19 = i20 + 1;
            }
            StringBuffer stringBuffer13 = new StringBuffer();
            int i21 = 0;
            while (true) {
                int i22 = i21;
                if (i22 >= userTagAll.love_type.size()) {
                    break;
                }
                this.aB.add(((UserTag) userTagAll.love_type.get(i22)).id);
                StringBuilder sb19 = new StringBuilder();
                sb19.append(com.soft.blued.utils.StringUtils.d(stringBuffer13.toString()) ? "" : ",");
                sb19.append(((UserTag) userTagAll.love_type.get(i22)).name);
                stringBuffer13.append(sb19.toString());
                i21 = i22 + 1;
            }
            int i23 = 0;
            while (true) {
                int i24 = i23;
                if (i24 >= userTagAll.i_want.size()) {
                    break;
                }
                this.aB.add(((UserTag) userTagAll.i_want.get(i24)).id);
                StringBuilder sb20 = new StringBuilder();
                sb20.append(com.soft.blued.utils.StringUtils.d(stringBuffer13.toString()) ? "" : ",");
                sb20.append(((UserTag) userTagAll.i_want.get(i24)).name);
                stringBuffer13.append(sb20.toString());
                i23 = i24 + 1;
            }
            int i25 = 0;
            while (true) {
                int i26 = i25;
                if (i26 >= userTagAll.love_character.size()) {
                    break;
                }
                this.aB.add(((UserTag) userTagAll.love_character.get(i26)).id);
                StringBuilder sb21 = new StringBuilder();
                sb21.append(com.soft.blued.utils.StringUtils.d(stringBuffer13.toString()) ? "" : ",");
                sb21.append(((UserTag) userTagAll.love_character.get(i26)).name);
                stringBuffer13.append(sb21.toString());
                i25 = i26 + 1;
            }
            ArrayList<String> arrayList = this.aB;
            if (arrayList == null || arrayList.size() <= 0) {
                this.s.setText(getResources().getString(R.string.unconfigured));
            } else {
                this.s.setText(getResources().getString(R.string.configured));
            }
            if (!SubscribeNumberManager.f18759a.a(UserInfo.getInstance().getLoginUserInfo().uid, (Short) 2)) {
                this.bd.setVisibility(0);
                this.bd.setText(String.format(this.d.getResources().getString(R.string.complete_rate), BluedConfig.a().x() + ""));
            }
            this.aY = userInfoEntity.health_test_result;
            this.aZ = userInfoEntity.health_test_time;
            this.ba = userInfoEntity.health_prpe_use_situation;
            Log.v("drb", "服务端返回健康信息 healthResult：" + this.aY + " -- healthTime：" + this.aZ + " -- healthPrep：" + this.ba);
            if (TextUtils.equals(this.aY, "0")) {
                this.aY = "-1";
            }
            if (TextUtils.equals(this.aZ, "0")) {
                this.aZ = "-1";
            }
            if (TextUtils.equals(this.ba, "0")) {
                this.ba = "-1";
            }
            Log.v("drb", "服务端返回健康信息处理后 healthResult：" + this.aY + " -- healthTime：" + this.aZ + " -- healthPrep：" + this.ba);
            b(UserRelationshipUtils.e().get(TextUtils.isEmpty(this.aY) ? "" : this.aY), TextUtils.equals(this.aZ, "1") ? getString(R.string.hiv_detection_time14) : TextUtils.equals(this.aZ, "-1") ? getString(R.string.hiv_detection_time1) : TextUtils.isEmpty(this.aZ) ? "" : TimeAndDateUtils.e(this.aZ), UserRelationshipUtils.f().get(TextUtils.isEmpty(this.ba) ? "" : this.ba));
        }
        UserRestrictedDescModel userRestrictedDescModel = userInfoEntity.restricted_desc;
        if (userRestrictedDescModel != null) {
            z = userRestrictedDescModel.isExist("avatar");
            z2 = userRestrictedDescModel.isExist("photo");
            z3 = userRestrictedDescModel.isExist("description");
            z4 = userRestrictedDescModel.isExist(ContactsContract.Contacts.AggregationSuggestions.PARAMETER_MATCH_NICKNAME);
        } else {
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
        }
        if (!z && !z2 && !z3 && !z4) {
            this.Y.setVisibility(8);
        } else if (TextUtils.isEmpty(userRestrictedDescModel.getDesc())) {
            this.Y.setVisibility(8);
        } else {
            this.Y.setVisibility(0);
            SpannableString spannableString = new SpannableString("  " + userRestrictedDescModel.getDesc());
            Drawable drawable = this.d.getResources().getDrawable(R.drawable.icon_modify_user_info_restricted);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            spannableString.setSpan(new LeftIconSpan(drawable), 0, 1, 33);
            this.Y.setText(spannableString);
        }
        a(this.Z, (TextView) null, this.ad, z);
        a(this.aa, this.p, (ImageView) null, z2);
        a(this.ab, this.i, this.ae, z4);
        a(this.ac, this.j, this.af, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str) {
        MineHttpUtils.c(this.d, new BluedUIHttpResponse<BluedEntityA<BluedLoginResult>>(getFragmentActive()) { // from class: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment.14
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedLoginResult> bluedEntityA) {
                AppMethods.d((int) R.string.delete_success);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ModifyUserInfoFragment.this.as.size()) {
                        break;
                    } else if (str.equals(((BluedAlbum) ModifyUserInfoFragment.this.as.get(i2)).getPid())) {
                        ModifyUserInfoFragment.this.as.remove(i2);
                        ModifyUserInfoFragment.this.as.add(new BluedAlbum());
                        ModifyUserInfoFragment.this.at.notifyDataSetChanged();
                        break;
                    } else {
                        i = i2 + 1;
                    }
                }
                UserHttpUtils.a(ModifyUserInfoFragment.this.d, ModifyUserInfoFragment.this.b, UserInfo.getInstance().getLoginUserInfo().uid, "", false, 0, 0, 0, ModifyUserInfoFragment.this.getFragmentActive());
            }

            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(ModifyUserInfoFragment.this.f);
            }

            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(ModifyUserInfoFragment.this.f);
            }
        }, str, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, BluedAlbum bluedAlbum) {
        QiniuUploadUtils.a(str, bluedAlbum, new QiniuUploadTools.QiNiuListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment.28
            public void a(String str2) {
                if (CommonTools.a(ModifyUserInfoFragment.this)) {
                    DialogUtils.b(ModifyUserInfoFragment.this.f);
                }
            }

            public void a(String str2, double d) {
            }

            public void a(String str2, String str3) {
                ModifyUserInfoFragment.this.d(str2);
            }

            public boolean a() {
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, BluedAlbum bluedAlbum, String str2) {
        QiniuUploadUtils.a(str, bluedAlbum, new AnonymousClass15(str2));
    }

    private void a(final String str, final String str2) {
        this.bj.setVisibility(0);
        this.bj.setText("0%");
        LoginRegisterHttpUtils.a(this.d, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(getFragmentActive()) { // from class: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment.30
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedAlbum> bluedEntityA) {
                if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                ModifyUserInfoFragment.this.b(str, (BluedAlbum) bluedEntityA.data.get(0), str2);
                ModifyUserInfoFragment.this.bj.setText("5%");
            }

            public boolean onUIFailure(int i, String str3) {
                ModifyUserInfoFragment.this.bj.setText(R.string.failure);
                return super.onUIFailure(i, str3);
            }

            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(ModifyUserInfoFragment.this.f);
            }

            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(ModifyUserInfoFragment.this.f);
            }
        }, (IRequestHost) getFragmentActive());
    }

    private void a(final String str, final String str2, final int i) {
        LoginRegisterHttpUtils.a(this.d, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(getFragmentActive()) { // from class: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment.13
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedAlbum> bluedEntityA) {
                if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                BluedAlbum bluedAlbum = (BluedAlbum) bluedEntityA.data.get(0);
                ((BluedAlbum) ModifyUserInfoFragment.this.as.get(i)).key = bluedAlbum.key;
                ModifyUserInfoFragment.this.a(str, bluedAlbum, str2);
            }

            public boolean onUIFailure(int i2, String str3) {
                ModifyUserInfoFragment.this.bm = true;
                return super.onUIFailure(i2, str3);
            }

            public void onUIFinish() {
                super.onUIFinish();
                if (ModifyUserInfoFragment.this.bm) {
                    ((BluedAlbum) ModifyUserInfoFragment.this.as.get(i)).setProgress(ModifyUserInfoFragment.this.getResources().getString(R.string.failure));
                    ModifyUserInfoFragment.this.at.notifyDataSetChanged();
                }
            }

            public void onUIStart() {
                super.onUIStart();
                ModifyUserInfoFragment.this.bm = false;
                ((BluedAlbum) ModifyUserInfoFragment.this.as.get(i)).setProgress("0%");
                ((BluedAlbum) ModifyUserInfoFragment.this.as.get(i)).setUrl(RecyclingUtils.Scheme.c.b(str));
                ModifyUserInfoFragment.this.at.notifyDataSetChanged();
            }
        }, (IRequestHost) getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, final String str3) {
        MineHttpUtils.c(this.d, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(getFragmentActive()) { // from class: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment.16
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedAlbum> bluedEntityA) {
                int b = ModifyUserInfoFragment.this.b(str3);
                ((BluedAlbum) ModifyUserInfoFragment.this.as.get(b)).setProgress("100%");
                ModifyUserInfoFragment.this.at.notifyDataSetChanged();
                if (bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
                    ((BluedAlbum) ModifyUserInfoFragment.this.as.get(b)).setPid(((BluedAlbum) bluedEntityA.data.get(0)).getPid());
                    ((BluedAlbum) ModifyUserInfoFragment.this.as.get(b)).setProgress("");
                    ModifyUserInfoFragment.this.at.notifyDataSetChanged();
                }
                UserHttpUtils.a(ModifyUserInfoFragment.this.d, ModifyUserInfoFragment.this.b, UserInfo.getInstance().getLoginUserInfo().uid, "", false, 0, 0, 0, ModifyUserInfoFragment.this.getFragmentActive());
            }

            public boolean onUIFailure(int i, String str4) {
                ModifyUserInfoFragment.this.bn = true;
                return super.onUIFailure(i, str4);
            }

            public void onUIFinish() {
                super.onUIFinish();
                if (ModifyUserInfoFragment.this.bn) {
                    ((BluedAlbum) ModifyUserInfoFragment.this.as.get(ModifyUserInfoFragment.this.b(str3))).setProgress(ModifyUserInfoFragment.this.getResources().getString(R.string.failure));
                    ModifyUserInfoFragment.this.at.notifyDataSetChanged();
                }
            }

            public void onUIStart() {
                super.onUIStart();
                ModifyUserInfoFragment.this.bn = false;
            }
        }, str, str2, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(String str) {
        if (com.soft.blued.utils.StringUtils.d(str)) {
            return 0;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.as.size()) {
                return 0;
            }
            if (str.equals(this.as.get(i2).key)) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, BluedAlbum bluedAlbum, final String str2) {
        QiniuUploadUtils.a(str, bluedAlbum, new QiniuUploadTools.QiNiuListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment.31
            public void a(String str3) {
                if (CommonTools.a(ModifyUserInfoFragment.this)) {
                    ModifyUserInfoFragment.this.bj.setText(R.string.failure);
                    DialogUtils.b(ModifyUserInfoFragment.this.f);
                    AppMethods.d(2131887272);
                }
            }

            public void a(String str3, double d) {
                if (CommonTools.a(ModifyUserInfoFragment.this)) {
                    TextView textView = ModifyUserInfoFragment.this.bj;
                    textView.setText(Math.min(((int) (d * 100.0d)) + 5, 98) + "%");
                }
            }

            public void a(String str3, String str4) {
                ModifyUserInfoFragment.this.c(str3, str2, str4);
            }

            public boolean a() {
                return false;
            }
        });
    }

    private void b(String str, String str2, String str3) {
        Log.v("drb", "setHealthToLanguage result：" + str + " -- time：" + str2 + " -- prep：" + str3);
        if (com.soft.blued.utils.StringUtils.d(str) && com.soft.blued.utils.StringUtils.d(str2) && com.soft.blued.utils.StringUtils.d(str3)) {
            this.o.setText("");
            return;
        }
        String str4 = str;
        if (TextUtils.equals(str, getString(R.string.hiv_detection_result3))) {
            str4 = "";
        }
        String str5 = str2;
        if (TextUtils.equals(str2, getString(R.string.hiv_detection_result3))) {
            str5 = "";
        }
        String str6 = str3;
        if (TextUtils.equals(str3, getString(R.string.hiv_detection_result3))) {
            str6 = "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        if ("en".equals(BlueAppLocal.a())) {
            stringBuffer.append(str4);
            if (!com.soft.blued.utils.StringUtils.d(str5) && !com.soft.blued.utils.StringUtils.d(str4)) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(str5);
            if (!com.soft.blued.utils.StringUtils.d(str6) && (!com.soft.blued.utils.StringUtils.d(str4) || !com.soft.blued.utils.StringUtils.d(str5))) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(str6);
        } else {
            stringBuffer.append(str4);
            if (!com.soft.blued.utils.StringUtils.d(str5) && !com.soft.blued.utils.StringUtils.d(str4)) {
                stringBuffer.append("，");
            }
            stringBuffer.append(str5);
            if (!com.soft.blued.utils.StringUtils.d(str6) && (!com.soft.blued.utils.StringUtils.d(str4) || !com.soft.blued.utils.StringUtils.d(str5))) {
                stringBuffer.append("，");
            }
            stringBuffer.append(str6);
        }
        Log.v("drb", "setHealthToLanguage end ：" + stringBuffer.toString());
        this.o.setText(stringBuffer.toString());
    }

    private void c(final String str) {
        LoginRegisterHttpUtils.a(this.d, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(getFragmentActive()) { // from class: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment.27
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedAlbum> bluedEntityA) {
                if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                ModifyUserInfoFragment.this.a(str, (BluedAlbum) bluedEntityA.data.get(0));
            }

            public boolean onUIFailure(int i, String str2) {
                return super.onUIFailure(i, str2);
            }

            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(ModifyUserInfoFragment.this.f);
            }

            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(ModifyUserInfoFragment.this.f);
            }
        }, (IRequestHost) getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2, String str3) {
        MineHttpUtils.j(this.d, new AnonymousClass32(getFragmentActive(), str), UserInfo.getInstance().getLoginUserInfo().getUid(), str2, str, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final String str) {
        MineHttpUtils.d(this.d, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(getFragmentActive()) { // from class: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment.29
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedAlbum> bluedEntityA) {
                ModifyUserInfoFragment.this.bl = 1;
                ModifyUserInfoFragment.this.bk = str;
                ModifyUserInfoFragment.this.C.setText(R.string.profile_background_under_review);
                AppMethods.d((int) R.string.profile_background_reviewed);
            }

            public boolean onUIFailure(int i, String str2) {
                return super.onUIFailure(i, str2);
            }

            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(ModifyUserInfoFragment.this.f);
            }
        }, str, getFragmentActive());
    }

    private void f() {
        CommonTopTitleNoTrans findViewById = this.e.findViewById(R.id.top_title);
        this.bc = findViewById;
        findViewById.setCenterText(getString(R.string.modify_data));
        this.bc.setRightText(2131887320);
        this.bc.setLeftClickListener(this);
        this.bc.setRightClickListener(this);
        this.bc.setRightTextColor(2131102254);
        this.bc.setCenterTextColor(2131102254);
        TextView centerTextView = this.bc.getCenterTextView();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = DensityUtils.a(this.d, 5.0f);
        centerTextView.setLayoutParams(layoutParams);
        centerTextView.setTextSize(16.0f);
        this.bd = this.bc.getCenterBelowTextView();
        this.bc.f();
    }

    private void g() {
        ProfileHttpUtils.a(ChatManager.context, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<BluedBlackList.privacySettingEntity>>() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment.1
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedBlackList.privacySettingEntity> bluedEntityA) {
                if (bluedEntityA != null) {
                    try {
                        if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                            return;
                        }
                        if (((BluedBlackList.privacySettingEntity) bluedEntityA.data.get(0)).is_open_private_photos == 1) {
                            BluedPreferences.H(true);
                            ModifyUserInfoFragment.this.n();
                            return;
                        }
                        BluedPreferences.H(false);
                        ModifyUserInfoFragment.this.n();
                    } catch (Exception e) {
                        e.printStackTrace();
                        AppMethods.a(AppInfo.d().getResources().getString(2131887272));
                    }
                }
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), (IRequestHost) getFragmentActive());
    }

    private void h() {
        ArrayList arrayList = new ArrayList();
        if (com.soft.blued.utils.StringUtils.d(UserInfo.getInstance().getLoginUserInfo().getAvatar())) {
            arrayList.add(getResources().getString(R.string.upload_headpic));
        } else {
            String[] stringArray = getResources().getStringArray(R.array.headpic_items);
            arrayList.add(stringArray[0]);
            arrayList.add(stringArray[1]);
        }
        CommonShowBottomWindow.a((FragmentActivity) this.d, (String[]) arrayList.toArray(new String[arrayList.size()]), new AnonymousClass9());
    }

    private void i() {
        UserHttpUtils.a(ChatManager.context, new BluedUIHttpResponse<BluedEntityA<UserInfoEntity>>(getFragmentActive()) { // from class: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment.10
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<UserInfoEntity> bluedEntityA) {
                if (bluedEntityA == null) {
                    AppMethods.d(2131888227);
                    return;
                }
                UserInfoEntity userInfoEntity = (UserInfoEntity) bluedEntityA.getSingleData();
                if (userInfoEntity == null) {
                    AppMethods.d(2131888227);
                    return;
                }
                UserInfo.getInstance().getLoginUserInfo().is_audited = userInfoEntity.is_audited;
                UserInfo.getInstance().getLoginUserInfo().avatar_audited = userInfoEntity.avatar_audited;
                UserInfo.getInstance().getLoginUserInfo().auditing_profile = userInfoEntity.auditing_profile;
                UserInfo.getInstance().getLoginUserInfo().restricted_desc = userInfoEntity.restricted_desc;
                ModifyUserInfoFragment.this.a(userInfoEntity.is_audited, userInfoEntity.avatar_audited);
                UserInfo.getInstance().getLoginUserInfo().setAvatar_pid(userInfoEntity.avatar_pid);
                UserInfo.getInstance().getLoginUserInfo().setAvatar(userInfoEntity.avatar);
                UserInfo.getInstance().getLoginUserInfo().vip_grade = userInfoEntity.vip_grade;
                UserInfo.getInstance().getLoginUserInfo().is_show_vip_page = userInfoEntity.is_show_vip_page;
                BluedConfig.a().b().is_show_vip_page = userInfoEntity.is_show_vip_page;
                UserInfo.getInstance().getLoginUserInfo().nickname_limit = userInfoEntity.nickname_limit;
                if (UserInfo.getInstance().getLoginUserInfo().is_show_vip_page == 1) {
                    ModifyUserInfoFragment.this.h.setChecked(true);
                }
                ReflectionUtils.a(userInfoEntity, UserInfo.getInstance().getLoginUserInfo());
                if (userInfoEntity.album != null) {
                    UserInfo.getInstance().getLoginUserInfo().setAlbum(userInfoEntity.album);
                    ModifyUserInfoFragment.this.m();
                }
                ImageLoader.a(ModifyUserInfoFragment.this.getFragmentActive(), UserInfo.getInstance().getLoginUserInfo().getAvatar()).b((int) R.drawable.feed_photo_add).c().a(ModifyUserInfoFragment.this.ah);
                ModifyUserInfoFragment.this.bk = userInfoEntity.background_photo;
                if (TextUtils.isEmpty(userInfoEntity.background_photo)) {
                    ModifyUserInfoFragment.this.bl = 0;
                    ModifyUserInfoFragment.this.C.setText(R.string.profile_background_upload);
                } else if (userInfoEntity.background_photo_auditing == 1) {
                    ModifyUserInfoFragment.this.bl = 1;
                    ModifyUserInfoFragment.this.C.setText(R.string.profile_background_under_review);
                } else {
                    ModifyUserInfoFragment.this.bl = 2;
                    ModifyUserInfoFragment.this.C.setText(R.string.profile_background_uploaded);
                }
                if (userInfoEntity.health_test_info_show != 1) {
                    ModifyUserInfoFragment.this.J.setVisibility(8);
                } else if (!SubscribeNumberManager.f18759a.a(UserInfo.getInstance().getLoginUserInfo().uid, (Short) 2)) {
                    ModifyUserInfoFragment.this.J.setVisibility(0);
                }
                if (UserInfo.getInstance().getLoginUserInfo().vip_grade != 0) {
                    ModifyUserInfoFragment.this.k();
                }
                ModifyUserInfoFragment.this.a(userInfoEntity);
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), "", false, 0, 0, 0, getFragmentActive());
    }

    private void j() {
        UserHttpUtils.e(new BluedUIHttpResponse<BluedEntityA<MultiHeadMigration.DataBean>>(getFragmentActive()) { // from class: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment.11
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<MultiHeadMigration.DataBean> bluedEntityA) {
                MultiHeadMigration.DataBean dataBean;
                if (bluedEntityA == null || (dataBean = (MultiHeadMigration.DataBean) bluedEntityA.getSingleData()) == null) {
                    return;
                }
                if (dataBean.vip_grade != 0 && dataBean.vip_avatar_num > 0) {
                    AppMethods.a(ModifyUserInfoFragment.this.d.getResources().getString(R.string.privacy_photo_album_moved_toast));
                } else if (dataBean.vip_grade != 0 || dataBean.vip_avatar_num <= 0) {
                } else {
                    AppMethods.a(ModifyUserInfoFragment.this.d.getResources().getString(R.string.privacy_photo_album_moved_toast_vip));
                }
            }
        }, UserInfo.getInstance().getLoginUserInfo().uid, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (BluedPreferences.bi() == 1) {
            return;
        }
        int[] iArr = new int[2];
        this.p.getLocationOnScreen(iArr);
        int i = iArr[1];
        int height = this.p.getHeight();
        Context context = this.d;
        ModifyUserInfoPopView modifyUserInfoPopView = new ModifyUserInfoPopView(context, context.getResources().getString(R.string.profile_background_guide2), this.d.getResources().getString(R.string.know), 5, DensityUtils.a(this.d, 20.0f), i + height + 15, new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ModifyUserInfoFragment.this.f19742a.d();
                BluedPreferences.g(1);
            }
        });
        this.f19742a = modifyUserInfoPopView;
        modifyUserInfoPopView.c();
    }

    private void l() {
        this.bj = (TextView) this.e.findViewById(R.id.tv_upload_avatar_progress);
        this.bi = (TextView) this.e.findViewById(R.id.tv_auditing);
        this.f = DialogUtils.a(this.d);
        this.bh = (TextView) this.e.findViewById(R.id.tv_vip_page_desc);
        this.bg = (ImageView) this.e.findViewById(R.id.img_vip_page_icon);
        this.bh.setText(R.string.vip_page);
        this.bg.setImageResource(2131233998);
        this.p = (TextView) this.e.findViewById(R.id.tv_status_privacy_album);
        LinearLayout linearLayout = (LinearLayout) this.e.findViewById(R.id.ll_privacy_photo_album);
        this.ag = linearLayout;
        linearLayout.setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) this.e.findViewById(R.id.ll_nickname);
        this.D = linearLayout2;
        linearLayout2.setOnClickListener(this);
        LinearLayout linearLayout3 = (LinearLayout) this.e.findViewById(R.id.ll_description);
        this.E = linearLayout3;
        linearLayout3.setOnClickListener(this);
        LinearLayout linearLayout4 = (LinearLayout) this.e.findViewById(R.id.ll_birthday);
        this.F = linearLayout4;
        linearLayout4.setOnClickListener(this);
        LinearLayout linearLayout5 = (LinearLayout) this.e.findViewById(R.id.ll_height_weight);
        this.G = linearLayout5;
        linearLayout5.setOnClickListener(this);
        LinearLayout linearLayout6 = (LinearLayout) this.e.findViewById(R.id.ll_role);
        this.H = linearLayout6;
        linearLayout6.setOnClickListener(this);
        LinearLayout linearLayout7 = (LinearLayout) this.e.findViewById(R.id.ll_bloodtype);
        this.I = linearLayout7;
        linearLayout7.setOnClickListener(this);
        LinearLayout linearLayout8 = (LinearLayout) this.e.findViewById(R.id.ll_health_information);
        this.J = linearLayout8;
        linearLayout8.setOnClickListener(this);
        LinearLayout linearLayout9 = (LinearLayout) this.e.findViewById(R.id.ll_hometown);
        this.K = linearLayout9;
        linearLayout9.setOnClickListener(this);
        LinearLayout linearLayout10 = (LinearLayout) this.e.findViewById(R.id.ll_ethnicity);
        this.L = linearLayout10;
        linearLayout10.setOnClickListener(this);
        LinearLayout linearLayout11 = (LinearLayout) this.e.findViewById(R.id.ll_relation);
        this.O = linearLayout11;
        linearLayout11.setOnClickListener(this);
        LinearLayout linearLayout12 = (LinearLayout) this.e.findViewById(R.id.ll_header);
        this.M = linearLayout12;
        linearLayout12.setOnClickListener(this);
        LinearLayout linearLayout13 = (LinearLayout) this.e.findViewById(R.id.ll_tags);
        this.N = linearLayout13;
        linearLayout13.setOnClickListener(this);
        this.ah = (ImageView) this.e.findViewById(2131364232);
        this.ai = (ImageView) this.e.findViewById(R.id.img_verify);
        this.i = (TextView) this.e.findViewById(R.id.tv_nickname);
        this.j = (TextView) this.e.findViewById(R.id.tv_description);
        this.k = (TextView) this.e.findViewById(2131370989);
        this.l = (TextView) this.e.findViewById(2131371664);
        this.r = (TextView) this.e.findViewById(R.id.tv_ethnicity);
        this.m = (TextView) this.e.findViewById(2131372467);
        this.n = (TextView) this.e.findViewById(R.id.tv_bloodtype);
        this.o = (TextView) this.e.findViewById(R.id.tv_health_information);
        this.q = (TextView) this.e.findViewById(R.id.tv_hometown);
        this.s = (TextView) this.e.findViewById(R.id.tv_tags);
        this.t = (TextView) this.e.findViewById(R.id.tv_relation);
        this.P = (LinearLayout) this.e.findViewById(R.id.ll_making_friends);
        this.u = (TextView) this.e.findViewById(R.id.tv_making_friends);
        this.P.setOnClickListener(this);
        this.Q = (LinearLayout) this.e.findViewById(R.id.ll_job_industry);
        this.v = (TextView) this.e.findViewById(R.id.tv_job_industry);
        this.Q.setOnClickListener(this);
        this.R = (LinearLayout) this.e.findViewById(R.id.ll_my_shape);
        this.w = (TextView) this.e.findViewById(R.id.tv_my_shape);
        this.R.setOnClickListener(this);
        this.S = (LinearLayout) this.e.findViewById(R.id.ll_my_personality);
        this.x = (TextView) this.e.findViewById(R.id.tv_my_personality);
        this.S.setOnClickListener(this);
        this.T = (LinearLayout) this.e.findViewById(R.id.ll_hobby);
        this.y = (TextView) this.e.findViewById(R.id.tv_hobby);
        this.T.setOnClickListener(this);
        this.U = (LinearLayout) this.e.findViewById(R.id.ll_douban);
        this.z = (TextView) this.e.findViewById(R.id.tv_douban);
        this.U.setOnClickListener(this);
        this.V = (LinearLayout) this.e.findViewById(R.id.ll_like_shape);
        this.A = (TextView) this.e.findViewById(R.id.tv_like_shape);
        this.V.setOnClickListener(this);
        this.W = (LinearLayout) this.e.findViewById(R.id.ll_like_personality);
        this.B = (TextView) this.e.findViewById(R.id.tv_like_personality);
        this.W.setOnClickListener(this);
        this.be = (ScrollView) this.e.findViewById(2131369639);
        this.bf = this.e.findViewById(R.id.place_view);
        this.X = (LinearLayout) this.e.findViewById(R.id.ll_vip_user_bg);
        this.C = (TextView) this.e.findViewById(R.id.tv_vip_user_bg_state);
        this.X.setOnClickListener(this);
        FrameLayout frameLayout = (FrameLayout) this.e.findViewById(R.id.fl_personal);
        FrameLayout frameLayout2 = (FrameLayout) this.e.findViewById(R.id.fl_tags);
        FrameLayout frameLayout3 = (FrameLayout) this.e.findViewById(R.id.fl_my_type);
        this.bb.add(this.D);
        this.bb.add(this.E);
        this.bb.add(this.F);
        this.bb.add(this.G);
        this.bb.add(this.H);
        this.bb.add(this.I);
        this.bb.add(this.K);
        this.bb.add(this.L);
        this.bb.add(this.N);
        this.bb.add(this.O);
        this.bb.add(this.P);
        this.bb.add(this.Q);
        this.bb.add(this.R);
        this.bb.add(this.S);
        this.bb.add(this.T);
        this.bb.add(this.U);
        this.bb.add(this.V);
        this.bb.add(this.W);
        ToggleButton toggleButton = (ToggleButton) this.e.findViewById(R.id.tglbtn_vip_page);
        this.h = toggleButton;
        toggleButton.setOnClickListener(this);
        this.h.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$ModifyUserInfoFragment$juMWu7bjx5Ad0Z3jQF4aLXDEwIM
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ModifyUserInfoFragment.a(compoundButton, z);
            }
        });
        if (!TextUtils.isEmpty(UserInfo.getInstance().getLoginUserInfo().uid) && SubscribeNumberManager.f18759a.a(UserInfo.getInstance().getLoginUserInfo().uid, (Short) 2)) {
            this.ag.setVisibility(8);
            frameLayout.setVisibility(8);
            frameLayout2.setVisibility(8);
            frameLayout3.setVisibility(8);
            this.O.setVisibility(8);
            this.P.setVisibility(8);
            this.L.setVisibility(8);
            this.K.setVisibility(8);
            this.Q.setVisibility(8);
            this.I.setVisibility(8);
            this.J.setVisibility(8);
            this.R.setVisibility(8);
            this.S.setVisibility(8);
            this.T.setVisibility(8);
            this.U.setVisibility(8);
            this.V.setVisibility(8);
            this.W.setVisibility(8);
        }
        this.Y = (TextView) this.e.findViewById(R.id.tv_user_restricted);
        this.Z = (TextView) this.e.findViewById(R.id.tv_header_hint);
        this.aa = (TextView) this.e.findViewById(R.id.tv_private_album_hint);
        this.ab = (TextView) this.e.findViewById(R.id.tv_nickname_hint);
        this.ac = (TextView) this.e.findViewById(R.id.tv_description_hint);
        this.ad = (ImageView) this.e.findViewById(R.id.iv_goto_modify_header);
        this.ae = (ImageView) this.e.findViewById(R.id.iv_goto_modify_nickName);
        this.af = (ImageView) this.e.findViewById(R.id.iv_goto_modify_description);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.f19743ar = (PhotoGridView) this.e.findViewById(R.id.grid_view);
        UserDragGirdAdapter userDragGirdAdapter = new UserDragGirdAdapter(this.d);
        this.at = userDragGirdAdapter;
        this.f19743ar.setAdapter((ListAdapter) userDragGirdAdapter);
        this.f19743ar.setColumnWidth(this.aw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (BluedPreferences.bo()) {
            this.p.setText(getResources().getString(R.string.already_visible));
            this.p.setTextColor(this.d.getResources().getColor(2131102254));
            return;
        }
        this.p.setText(getResources().getString(R.string.already_hidden));
        this.p.setTextColor(this.d.getResources().getColor(2131101293));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x02ec -> B:67:0x00ae). Please submit an issue!!! */
    private void o() {
        int parseInt;
        int i;
        View inflate = LayoutInflater.from(this.d).inflate(2131561005, (ViewGroup) null);
        int aF = BluedPreferences.aF();
        if (aF == 1) {
            try {
                parseInt = Integer.parseInt((((Object) this.l.getText()) + "").split(" / ")[0]);
            } catch (Exception e) {
                parseInt = -1;
            }
        } else if (aF != 2) {
            parseInt = -1;
        } else {
            String str = (((Object) this.l.getText()) + "").split(" / ")[0];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                String[] strArr = av;
                parseInt = -1;
                if (i3 < strArr.length) {
                    if (strArr[i3].equals(str)) {
                        parseInt = i3;
                        break;
                    }
                    i2 = i3 + 1;
                }
            }
        }
        try {
            i = Integer.parseInt((((Object) this.l.getText()) + "").split(" / ")[1]);
        } catch (Exception e2) {
            i = 0;
        }
        NumberPicker findViewById = inflate.findViewById(2131364241);
        findViewById.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment.18
            public void onValueChange(NumberPicker numberPicker, int i4, int i5) {
                ModifyUserInfoFragment modifyUserInfoFragment = ModifyUserInfoFragment.this;
                modifyUserInfoFragment.aj = i5 + "";
                int aF2 = BluedPreferences.aF();
                if (aF2 != 1) {
                    if (aF2 != 2) {
                        return;
                    }
                    ModifyUserInfoFragment.this.aj = ModifyUserInfoFragment.av[i5];
                    return;
                }
                ModifyUserInfoFragment modifyUserInfoFragment2 = ModifyUserInfoFragment.this;
                modifyUserInfoFragment2.aj = i5 + "";
            }
        });
        if (aF == 1) {
            this.aj = parseInt + "";
        } else if (aF == 2) {
            if (parseInt < 0) {
                this.aj = av[0];
            } else {
                String[] strArr2 = av;
                if (parseInt > strArr2.length - 1) {
                    this.aj = strArr2[strArr2.length - 1];
                } else {
                    this.aj = strArr2[parseInt];
                }
            }
        }
        if (aF == 1) {
            this.an = 120;
            this.ao = 220;
            this.al = 170;
            findViewById.setDisplayedValues((String[]) null);
            this.ap = 30;
            this.aq = 200;
            this.am = 60;
        } else if (aF == 2) {
            this.an = 0;
            String[] strArr3 = av;
            this.ao = strArr3.length - 1;
            this.al = 20;
            findViewById.setDisplayedValues(strArr3);
            this.ap = 66;
            this.aq = 441;
            this.am = 132;
        }
        findViewById.setMinValue(this.an);
        findViewById.setMaxValue(this.ao);
        int i4 = this.an;
        if (parseInt < i4) {
            findViewById.setValue(i4);
        } else {
            int i5 = this.ao;
            if (parseInt > i5) {
                findViewById.setValue(i5);
            } else {
                findViewById.setValue(parseInt);
            }
        }
        findViewById.setFocusable(true);
        findViewById.setFocusableInTouchMode(true);
        NumberPicker findViewById2 = inflate.findViewById(2131373389);
        findViewById2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment.19
            public void onValueChange(NumberPicker numberPicker, int i6, int i7) {
                ModifyUserInfoFragment.this.ak = i7;
            }
        });
        this.ak = i;
        findViewById2.setMinValue(this.ap);
        findViewById2.setMaxValue(this.aq);
        int i6 = this.ap;
        if (i < i6) {
            findViewById2.setValue(i6);
        } else {
            int i7 = this.aq;
            if (i > i7) {
                findViewById2.setValue(i7);
            } else {
                findViewById2.setValue(i);
            }
        }
        findViewById2.setFocusable(true);
        findViewById2.setFocusableInTouchMode(true);
        String string = getResources().getString(2131886754);
        if (aF == 1) {
            string = getResources().getString(2131886754);
        } else if (aF == 2) {
            string = getResources().getString(R.string.heigt_weight_lbs);
        }
        CommonAlertDialog.a(this.d, inflate, string, "", "", getResources().getString(2131886752), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment.20
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i8) {
                Tracker.onClick(dialogInterface, i8);
                if ("0".equals(ModifyUserInfoFragment.this.aj)) {
                    ModifyUserInfoFragment modifyUserInfoFragment = ModifyUserInfoFragment.this;
                    modifyUserInfoFragment.aj = ModifyUserInfoFragment.this.al + "";
                    int aF2 = BluedPreferences.aF();
                    if (aF2 == 1) {
                        ModifyUserInfoFragment modifyUserInfoFragment2 = ModifyUserInfoFragment.this;
                        modifyUserInfoFragment2.aj = ModifyUserInfoFragment.this.al + "";
                    } else if (aF2 == 2) {
                        ModifyUserInfoFragment.this.aj = ModifyUserInfoFragment.av[ModifyUserInfoFragment.this.al];
                    }
                }
                if (ModifyUserInfoFragment.this.ak == 0) {
                    ModifyUserInfoFragment modifyUserInfoFragment3 = ModifyUserInfoFragment.this;
                    modifyUserInfoFragment3.ak = modifyUserInfoFragment3.am;
                }
                TextView textView = ModifyUserInfoFragment.this.l;
                textView.setText(ModifyUserInfoFragment.this.aj + " / " + ModifyUserInfoFragment.this.ak);
            }
        }, (DialogInterface.OnClickListener) null, (DialogInterface.OnCancelListener) null, true);
    }

    private void p() {
        UserHttpUtils.a(this.d, (BluedUIHttpResponse) new AnonymousClass26(getFragmentActive()), UserInfo.getInstance().getLoginUserInfo().getUid(), this.f19744c, (IRequestHost) getFragmentActive());
    }

    public void a() {
        if (UserInfo.getInstance().getLoginUserInfo() != null) {
            this.as = UserInfo.getInstance().getLoginUserInfo().getVip_avatars();
        }
        int i = 0;
        List<BluedAlbum> list = this.as;
        if (list != null) {
            i = list.size();
        } else {
            this.as = new LinkedList();
        }
        while (i < 6) {
            this.as.add(new BluedAlbum());
            i++;
        }
    }

    public void a(boolean z) {
        if (this.bo && z) {
            d();
            return;
        }
        c();
        if (!z) {
            if (this.j.getText().length() > 256) {
                AppMethods.a(getResources().getString(R.string.description_max_256));
            } else if (this.f19744c.size() != 0) {
                p();
            } else {
                d();
            }
        } else if (this.f19744c.size() > 1) {
            CommonAlertDialog.a(this.d, "", getResources().getString(R.string.confirm_submit_change), getResources().getString(R.string.continue_edit), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment.22
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                }
            }, getResources().getString(R.string.give_up), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment.23
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    ModifyUserInfoFragment.this.d();
                }
            }, (DialogInterface.OnDismissListener) null);
        } else if (a(this.aI, this.aH) && a(this.aG, this.aF) && a(this.aK, this.aJ) && a(this.aU, this.aT)) {
            d();
        } else {
            CommonAlertDialog.a(this.d, "", getResources().getString(R.string.confirm_submit_change), getResources().getString(R.string.continue_edit), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment.24
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                }
            }, getResources().getString(R.string.give_up), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment.25
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    ModifyUserInfoFragment.this.d();
                }
            }, (DialogInterface.OnDismissListener) null);
        }
    }

    public boolean a(List<String> list, List<String> list2) {
        boolean z = false;
        if (list == null) {
            return true;
        }
        if (list2 == null) {
            return false;
        }
        if (list.size() == list2.size()) {
            z = true;
            for (int i = 0; i < list.size(); i++) {
                z = z && list2.contains(list.get(i));
            }
        }
        return z;
    }

    public void b() {
        n();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public Map<String, String> c() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public void d() {
        int i = this.ax;
        if (i != 601) {
            if (i == 602) {
                PersonalVerifyObserver.a().b();
            }
            getActivity().finish();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("from", 601);
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 2) {
                this.j.setText(intent.getStringExtra("string_edit"));
            } else if (i == 4) {
                String stringExtra = intent.getStringExtra("areacode");
                this.az = stringExtra;
                this.q.setText(AreaUtils.getAreaTxt(stringExtra, BlueAppLocal.c(), true));
            } else if (i != 22) {
                if (i != 507) {
                    if (i != 177) {
                        if (i != 178) {
                            if (i != 501) {
                                if (i != 502) {
                                    switch (i) {
                                        case 510:
                                            if (intent != null) {
                                                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("choosed_label_list");
                                                this.aK = stringArrayListExtra;
                                                Iterator<String> it = stringArrayListExtra.iterator();
                                                while (it.hasNext()) {
                                                    String next = it.next();
                                                    Log.v("drb", "返回我的标签：" + next);
                                                }
                                                ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("choosed_shape_list_name");
                                                if (stringArrayListExtra2 == null || stringArrayListExtra2.size() <= 0) {
                                                    this.w.setText("");
                                                } else {
                                                    this.w.setText(a(stringArrayListExtra2));
                                                }
                                                ArrayList<String> stringArrayListExtra3 = intent.getStringArrayListExtra("choosed_personality_list_name");
                                                this.aO.clear();
                                                if (stringArrayListExtra3 == null || stringArrayListExtra3.size() <= 0) {
                                                    this.x.setText("");
                                                } else {
                                                    this.x.setText(a(stringArrayListExtra3));
                                                    this.aO.addAll(stringArrayListExtra3);
                                                }
                                                this.aQ.clear();
                                                ArrayList<String> stringArrayListExtra4 = intent.getStringArrayListExtra("choosed_hobby_list_name");
                                                if (stringArrayListExtra4 == null || stringArrayListExtra4.size() <= 0) {
                                                    this.y.setText("");
                                                } else {
                                                    this.y.setText(a(stringArrayListExtra4));
                                                    this.aQ.addAll(stringArrayListExtra4);
                                                }
                                                ArrayList<String> stringArrayListExtra5 = intent.getStringArrayListExtra("choosed_douban_list_name");
                                                if (stringArrayListExtra5 != null && stringArrayListExtra5.size() > 0) {
                                                    this.z.setText(a(stringArrayListExtra5));
                                                    break;
                                                } else {
                                                    this.z.setText("");
                                                    break;
                                                }
                                            }
                                            break;
                                        case 511:
                                            if (intent != null) {
                                                ArrayList<String> stringArrayListExtra6 = intent.getStringArrayListExtra("choosed_like_list");
                                                this.aU = stringArrayListExtra6;
                                                Iterator<String> it2 = stringArrayListExtra6.iterator();
                                                while (it2.hasNext()) {
                                                    String next2 = it2.next();
                                                    Log.v("drb", "返回我喜欢的标签：" + next2);
                                                }
                                                ArrayList<String> stringArrayListExtra7 = intent.getStringArrayListExtra("choosed_like_shape_list_name");
                                                if (stringArrayListExtra7 == null || stringArrayListExtra7.size() <= 0) {
                                                    this.A.setText("");
                                                } else {
                                                    this.A.setText(a(stringArrayListExtra7));
                                                }
                                                ArrayList<String> stringArrayListExtra8 = intent.getStringArrayListExtra("choosed_like_personality_list_name");
                                                if (stringArrayListExtra8 != null && stringArrayListExtra8.size() > 0) {
                                                    this.B.setText(a(stringArrayListExtra8));
                                                    break;
                                                } else {
                                                    this.B.setText("");
                                                    break;
                                                }
                                            }
                                            break;
                                        case 512:
                                            if (intent != null) {
                                                String stringExtra2 = intent.getStringExtra("background_photo");
                                                int intExtra = intent.getIntExtra("background_photo_auditing", 0);
                                                this.bk = stringExtra2;
                                                if (!TextUtils.isEmpty(stringExtra2)) {
                                                    if (intExtra != 1) {
                                                        this.bl = 2;
                                                        this.C.setText(R.string.profile_background_uploaded);
                                                        break;
                                                    } else {
                                                        this.bl = 1;
                                                        this.C.setText(R.string.profile_background_under_review);
                                                        break;
                                                    }
                                                } else {
                                                    this.bl = 0;
                                                    this.C.setText(R.string.profile_background_upload);
                                                    break;
                                                }
                                            }
                                            break;
                                        case 513:
                                            if (intent != null) {
                                                this.aV = intent.getStringExtra("health_result");
                                                this.aW = intent.getStringExtra("health_time");
                                                this.aX = intent.getStringExtra("health_prep");
                                                b(intent.getStringExtra("health_result_name"), intent.getStringExtra("health_time_name"), intent.getStringExtra("health_prep_name"));
                                                Log.v("drb", "onActivityResult unSaveHealthResult:" + this.aV);
                                                Log.v("drb", "onActivityResult unSaveHealthTime:" + this.aW);
                                                Log.v("drb", "onActivityResult unSaveHealthPrep:" + this.aX);
                                                break;
                                            }
                                            break;
                                    }
                                }
                            } else if (intent != null) {
                                ArrayList<String> stringArrayListExtra9 = intent.getStringArrayListExtra("CHOOSED_TAG_LIST");
                                this.aC = stringArrayListExtra9;
                                if (stringArrayListExtra9 == null || stringArrayListExtra9.size() <= 0) {
                                    this.s.setText(getResources().getString(R.string.unconfigured));
                                } else {
                                    this.s.setText(getResources().getString(R.string.configured));
                                }
                            }
                            if (intent != null) {
                                this.aG = intent.getStringArrayListExtra("choosed_make_friends_list");
                                this.aS.clear();
                                ArrayList<String> stringArrayListExtra10 = intent.getStringArrayListExtra("CHOOSED_MAKE_FRIENDS_LIST_NAME");
                                if (stringArrayListExtra10 == null || stringArrayListExtra10.size() <= 0) {
                                    this.u.setText("");
                                } else {
                                    this.u.setText(a(stringArrayListExtra10));
                                    this.aS.addAll(stringArrayListExtra10);
                                }
                            }
                        } else if (intent != null) {
                            String stringExtra3 = intent.getStringExtra("photo_path");
                            if (!com.soft.blued.utils.StringUtils.d(stringExtra3)) {
                                c(stringExtra3);
                            }
                        }
                    } else if (intent != null) {
                        String stringExtra4 = intent.getStringExtra("photo_path");
                        String avatar_pid = UserInfo.getInstance().getLoginUserInfo().getAvatar_pid();
                        if (com.soft.blued.utils.StringUtils.d(avatar_pid) || com.soft.blued.utils.StringUtils.d(stringExtra4)) {
                            a(stringExtra4, "");
                        } else {
                            a(stringExtra4, avatar_pid);
                            if (BluedPreferences.bD()) {
                                BluedPreferences.bE();
                                BluedAlertDialog a2 = CommonAlertDialog.a(this.d, (int) R.drawable.dialog_sync_avatar_tip, getString(R.string.sync_profile_photo), getString(R.string.sync_profile_photo_tip), getString(R.string.sync_profile_photo_ok), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment.21
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i3) {
                                        Tracker.onClick(dialogInterface, i3);
                                        GeneralFragment.a(ModifyUserInfoFragment.this.d);
                                    }
                                }, getString(R.string.sync_profile_photo_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null, 3);
                                a2.a(182.0f);
                                a2.a((int) R.drawable.icon_buy_vip_dialog_close);
                            }
                        }
                    }
                } else if (intent != null) {
                    this.aI = intent.getStringArrayListExtra("choosed_job_list");
                    ArrayList<String> stringArrayListExtra11 = intent.getStringArrayListExtra("choosed_job_list_name");
                    if (stringArrayListExtra11 == null || stringArrayListExtra11.size() <= 0) {
                        this.v.setText("");
                    } else {
                        this.v.setText(a(stringArrayListExtra11));
                    }
                }
            } else if (intent != null) {
                String stringExtra5 = intent.getStringExtra("photo_path");
                if (this.aD != null && !com.soft.blued.utils.StringUtils.d(stringExtra5)) {
                    a(stringExtra5, this.aD.getPid(), this.aD.position);
                }
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public boolean onBackPressed() {
        if (this.bo) {
            d();
            return true;
        }
        ModifyUserInfoPopView modifyUserInfoPopView = this.f19742a;
        if (modifyUserInfoPopView == null || !modifyUserInfoPopView.b()) {
            a(true);
            return true;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0636  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x063c  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onClick(android.view.View r10) {
        /*
            Method dump skipped, instructions count: 1655
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment.onClick(android.view.View):void");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.d = getActivity();
        View view = this.e;
        if (view == null) {
            this.e = layoutInflater.inflate(R.layout.fragment_modify_userinfo, viewGroup, false);
            if (getArguments() != null) {
                this.aA = getArguments().getBoolean("show_avatar_items");
                this.ax = getArguments().getInt("fromPage");
            }
            av = getResources().getStringArray(2130903084);
            this.aw = (this.d.getResources().getDisplayMetrics().widthPixels - DensityUtils.a(this.d, 66.0f)) / 3;
            f();
            l();
            b();
            m();
            i();
            j();
            if (this.aA) {
                h();
            }
        } else {
            ((ViewGroup) view.getParent()).removeView(this.e);
        }
        return this.e;
    }

    public void onDestroy() {
        super.onDestroy();
        this.aE = true;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.as.size()) {
                return;
            }
            int i3 = i2;
            if (!com.soft.blued.utils.StringUtils.d(this.as.get(i2).progress)) {
                this.as.remove(i2);
                i3 = i2 - 1;
            }
            i = i3 + 1;
        }
    }

    public void onResume() {
        super.onResume();
        b();
        a();
        UserDragGirdAdapter userDragGirdAdapter = this.at;
        if (userDragGirdAdapter != null) {
            userDragGirdAdapter.notifyDataSetChanged();
        }
    }
}

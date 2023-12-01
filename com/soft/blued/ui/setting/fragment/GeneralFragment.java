package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.anythink.expressad.video.dynview.a.a;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.grpc.backup.MsgBackupService;
import com.blued.android.config.FlexDebugSevConfig;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinObserver;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.pool.ThreadPriority;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.db.NewFeedDao;
import com.blued.android.module.common.trace.EventTrackSettings;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.das.settings.SettingsProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.LabeledTextView;
import com.soft.blued.http.ProfileHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.msg.ChatBgSettingFragment;
import com.soft.blued.ui.setting.model.BluedBlackList;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.CacheManager;
import com.soft.blued.utils.StringUtils;
import com.youzan.androidsdk.tool.WebParameter;
import java.io.File;
import java.util.Locale;
import java.util.Map;
import skin.support.observe.SkinObservable;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/GeneralFragment.class */
public class GeneralFragment extends BaseFragment implements View.OnClickListener, BluedSkinObserver {
    private LinearLayout A;
    private View B;
    private ShapeTextView C;
    private boolean D;
    private CommonTopTitleNoTrans F;
    private Dialog G;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private View f19673c;
    private ToggleButton d;
    private View e;
    private LinearLayout f;
    private LinearLayout g;
    private LinearLayout h;
    private TextView i;
    private TextView j;
    private View k;
    private TextView l;
    private TextView m;
    private ProgressBar n;
    private LinearLayout o;
    private LinearLayout p;
    private LabeledTextView q;
    private LinearLayout r;
    private LinearLayout s;
    private ShapeTextView t;
    private ToggleButton u;
    private ShapeTextView v;
    private ToggleButton w;
    private ShapeTextView x;
    private LinearLayout y;
    private TextView z;

    /* renamed from: a  reason: collision with root package name */
    public boolean f19672a = false;
    private CacheManager E = new CacheManager();
    private BluedUIHttpResponse H = new BluedUIHttpResponse<BluedEntityA<BluedBlackList.privacySettingEntity>>("my_privacy_setting", getFragmentActive()) { // from class: com.soft.blued.ui.setting.fragment.GeneralFragment.10
        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public BluedEntityA<BluedBlackList.privacySettingEntity> parseData(String str) {
            return super.parseData(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void onUICache(BluedEntityA<BluedBlackList.privacySettingEntity> bluedEntityA) {
            super.onUICache(bluedEntityA);
            GeneralFragment.this.a(bluedEntityA);
        }

        /* renamed from: b */
        public void onUIUpdate(BluedEntityA<BluedBlackList.privacySettingEntity> bluedEntityA) {
            GeneralFragment.this.a(bluedEntityA);
        }

        public void onFailure(Throwable th, int i, String str) {
            super.onFailure(th, i, str);
        }
    };

    public static void a(Context context) {
        TerminalActivity.d(context, GeneralFragment.class, (Bundle) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BluedEntityA<BluedBlackList.privacySettingEntity> bluedEntityA) {
        boolean z = false;
        if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
            this.D = false;
            this.d.setChecked(false);
        } else {
            if (((BluedBlackList.privacySettingEntity) bluedEntityA.data.get(0)).is_sync_avatar == 1) {
                z = true;
            }
            this.D = z;
            this.d.setChecked(z);
        }
        this.d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.setting.fragment.GeneralFragment.9
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                Tracker.onCheckedChanged(compoundButton, z2);
                String str = z2 ? "1" : "0";
                Map a2 = BluedHttpTools.a();
                a2.put("is_sync_avatar", str);
                ProfileHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.setting.fragment.GeneralFragment.9.1
                    /* renamed from: a */
                    public void onUIUpdate(BluedEntityA<Object> bluedEntityA2) {
                        if (bluedEntityA2 == null) {
                            try {
                                AppMethods.a(AppInfo.d().getResources().getString(2131887272));
                                GeneralFragment.this.d.setChecked(GeneralFragment.this.D);
                            } catch (Exception e) {
                                e.printStackTrace();
                                AppMethods.a(AppInfo.d().getResources().getString(2131887272));
                                GeneralFragment.this.d.setChecked(GeneralFragment.this.D);
                            }
                        }
                    }
                }, UserInfo.getInstance().getLoginUserInfo().getUid(), a2);
            }
        });
    }

    private void b() {
        CommonTopTitleNoTrans findViewById = this.f19673c.findViewById(R.id.top_title);
        this.F = findViewById;
        findViewById.f();
        this.F.a();
        this.F.setCenterText(getString(R.string.common_setting));
        this.F.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.GeneralFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                GeneralFragment.this.getActivity().finish();
            }
        });
    }

    private void c() {
        String str;
        this.G = DialogUtils.a(getContext());
        ToggleButton toggleButton = (ToggleButton) this.f19673c.findViewById(R.id.tb_sync_profile_photo);
        this.d = toggleButton;
        toggleButton.setOnClickListener(this);
        this.e = this.f19673c.findViewById(R.id.iv_sync_profile_photo_dot);
        if (BluedPreferences.bF()) {
            this.e.setVisibility(0);
        } else {
            this.e.setVisibility(8);
        }
        this.f = (LinearLayout) this.f19673c.findViewById(R.id.ll_unit_setting);
        this.i = (TextView) this.f19673c.findViewById(R.id.tv_unit_setted);
        this.g = (LinearLayout) this.f19673c.findViewById(R.id.ll_language_setting);
        this.j = (TextView) this.f19673c.findViewById(R.id.tv_language_setted);
        this.h = (LinearLayout) this.f19673c.findViewById(R.id.ll_change_blued_icon);
        this.k = this.f19673c.findViewById(R.id.arrow_clear_cache);
        this.l = (TextView) this.f19673c.findViewById(R.id.tv_img_cache_size);
        this.n = (ProgressBar) this.f19673c.findViewById(R.id.bar_clearing_cache);
        this.o = (LinearLayout) this.f19673c.findViewById(R.id.ll_clear_img_cache);
        this.m = (TextView) this.f19673c.findViewById(R.id.tv_clear_cache_title);
        this.p = (LinearLayout) this.f19673c.findViewById(R.id.ll_clear_chat_record);
        LabeledTextView labeledTextView = (LabeledTextView) this.f19673c.findViewById(R.id.chat_setting_bg);
        this.q = labeledTextView;
        labeledTextView.a(Boolean.valueOf(BluedPreferences.e(2)));
        this.t = this.f19673c.findViewById(R.id.iv_sync_common_return_dot);
        this.u = (ToggleButton) this.f19673c.findViewById(R.id.tb_common_return);
        this.v = this.f19673c.findViewById(R.id.iv_sync_common_listen_dot);
        this.w = (ToggleButton) this.f19673c.findViewById(R.id.tb_sync_common_listen);
        this.r = (LinearLayout) this.f19673c.findViewById(R.id.ll_backup_chat_record);
        this.s = (LinearLayout) this.f19673c.findViewById(R.id.ll_restore_chat_record);
        this.C = this.f19673c.findViewById(R.id.tv_new_function);
        if (!BluedPreferences.eW()) {
            this.C.setVisibility(0);
        }
        int aF = BluedPreferences.aF();
        if (aF == 1) {
            this.i.setText("cm/kg");
        } else if (aF == 2) {
            this.i.setText("ft/lb");
        }
        Locale c2 = LocaleUtils.c();
        String str2 = "";
        if (c2 != null) {
            str2 = c2.getLanguage();
            str = c2.getCountry();
        } else {
            str = "";
        }
        if (LocaleUtils.a() || TextUtils.isEmpty(str2)) {
            this.j.setText(getResources().getString(R.string.laguage_system));
        } else if (TextUtils.equals(a.V, str2) && TextUtils.equals("CN", str)) {
            this.j.setText(getResources().getString(R.string.laguage_zhcn));
        } else if (TextUtils.equals(a.V, str2) && (TextUtils.equals("TW", str) || TextUtils.equals(a.ae, str))) {
            this.j.setText(getResources().getString(R.string.laguage_zhtw));
        } else if (TextUtils.equals("en", str2)) {
            this.j.setText(getResources().getString(R.string.laguage_english));
        } else {
            this.j.setText(getResources().getString(R.string.laguage_system));
        }
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.u.setChecked(BluedPreferences.bZ());
        this.u.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.setting.fragment.GeneralFragment.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Tracker.onCheckedChanged(compoundButton, z);
                BluedPreferences.K(z);
            }
        });
        this.w.setChecked(BluedPreferences.aV());
        this.w.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.setting.fragment.GeneralFragment.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Tracker.onCheckedChanged(compoundButton, z);
                BluedPreferences.D(z);
            }
        });
        if (!BluedPreferences.cj()) {
            this.t.setVisibility(0);
            BluedPreferences.ck();
        }
        if (!BluedPreferences.ca()) {
            this.v.setVisibility(0);
            BluedPreferences.cb();
        }
        this.x = this.f19673c.findViewById(R.id.iv_dark_dot);
        if (BluedPreferences.cc()) {
            this.x.setVisibility(8);
        } else {
            this.x.setVisibility(0);
        }
        LinearLayout linearLayout = (LinearLayout) this.f19673c.findViewById(R.id.ll_skin);
        this.y = linearLayout;
        linearLayout.setOnClickListener(this);
        this.z = (TextView) this.f19673c.findViewById(R.id.tv_skin_model);
        int i = FlexDebugSevConfig.a().b().android_msg_backup;
        this.r.setVisibility(0);
        this.s.setVisibility(8);
        this.A = (LinearLayout) this.f19673c.findViewById(R.id.ll_text_size);
        this.B = this.f19673c.findViewById(R.id.iv_text_size_dot);
        if (FlexDebugSevConfig.a().b().android_font_adjust != 1) {
            this.A.setVisibility(8);
            return;
        }
        this.A.setVisibility(0);
        this.A.setOnClickListener(this);
        if (BluedPreferences.cd()) {
            this.B.setVisibility(8);
        } else {
            this.B.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.f19672a) {
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            this.n.setVisibility(0);
            this.o.setClickable(false);
            this.o.setOnClickListener(null);
            this.m.setTextColor(BluedSkinUtils.a(this.b, 2131100624));
            return;
        }
        this.k.setVisibility(0);
        this.l.setVisibility(0);
        this.n.setVisibility(8);
        this.o.setClickable(true);
        this.o.setOnClickListener(this);
        this.m.setTextColor(BluedSkinUtils.a(this.b, 2131101528));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ThreadManager.a().a(new ThreadExecutor("setImageCacheSize") { // from class: com.soft.blued.ui.setting.fragment.GeneralFragment.4
            public void execute() {
                final String a2 = GeneralFragment.this.E.a();
                GeneralFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.setting.fragment.GeneralFragment.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GeneralFragment.this.l.setText(a2);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        ThreadManager.a().a(new ThreadExecutor("clearCache", ThreadPriority.a) { // from class: com.soft.blued.ui.setting.fragment.GeneralFragment.5
            public void execute() {
                GeneralFragment.this.E.b();
                GeneralFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.setting.fragment.GeneralFragment.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AppMethods.d((int) R.string.clear_cache_successfully);
                        GeneralFragment.this.f19672a = false;
                        GeneralFragment.this.d();
                        GeneralFragment.this.e();
                    }
                });
            }
        });
    }

    private void g() {
        TextView textView = this.z;
        if (textView != null) {
            try {
                textView.setText(this.b.getResources().getString(BluedPreferences.dq()));
            } catch (Exception e) {
            }
        }
    }

    public void a() {
        ProfileHttpUtils.a(this.b, this.H, UserInfo.getInstance().getLoginUserInfo().getUid(), (IRequestHost) getFragmentActive());
    }

    public void a(SkinObservable skinObservable, Object obj) {
        Log.e("skin", "GeneralFragment updateSkin");
        CommonTopTitleNoTrans commonTopTitleNoTrans = this.F;
        if (commonTopTitleNoTrans != null) {
            commonTopTitleNoTrans.setCenterTextColor(2131102254);
            getActivity().findViewById(android.R.id.content).setBackgroundColor(BluedSkinUtils.a(getContext(), 2131101780));
        }
        g();
        StatusBarHelper.a(getActivity());
        StatusBarHelper.a(getActivity(), BluedSkinUtils.a(getContext(), AppInfo.k()));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case R.id.chat_setting_bg /* 2131362822 */:
                LabeledTextView labeledTextView = this.q;
                if (labeledTextView != null) {
                    labeledTextView.a((Boolean) false);
                }
                BluedPreferences.f(2);
                if (UserInfo.getInstance().getLoginUserInfo().vip_grade != 0 || BluedConfig.a().g().is_chat_backgrounds == 1) {
                    ChatBgSettingFragment.a(this, 2, 0);
                    InstantLog.a("setting_change_chat_bg_click", 1);
                } else {
                    InstantLog.a("setting_change_chat_bg_click", 0);
                    PayUtils.a(this.b, 23, "setting_common_background");
                }
                EventTrackSettings.a(SettingsProtos.Event.MINE_SETTINGS_COMMON_CHANGE_BG_CLICK);
                return;
            case R.id.ll_backup_chat_record /* 2131367651 */:
                EventTrackSettings.a(SettingsProtos.Event.MINE_BACKUP_RECORD_CLICK);
                BluedPreferences.eX();
                this.C.setVisibility(4);
                TerminalActivity.d(getContext(), MsgBackupFragment.class, (Bundle) null);
                return;
            case R.id.ll_change_blued_icon /* 2131367692 */:
                if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0 && BluedConfig.a().g().is_change_blued_icon == 0) {
                    PayUtils.a(getActivity(), 14, "setting_change_icon");
                    InstantLog.a("setting_change_icon_click", 0);
                } else {
                    InstantLog.a("setting_change_icon_click", 1);
                    ChangeBluedIconFragment.a(getActivity());
                }
                EventTrackSettings.a(SettingsProtos.Event.MINE_SETTINGS_COMMON_CHANGE_ICON_CLICK);
                return;
            case R.id.ll_clear_chat_record /* 2131367701 */:
                CommonAlertDialog.a(getActivity(), (String) null, getResources().getString(R.string.confirm_clear_chat_record), (String) null, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.GeneralFragment.8
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                        final ProgressDialog progressDialog = new ProgressDialog(GeneralFragment.this.getActivity());
                        progressDialog.show();
                        ThreadManager.a().a(new ThreadExecutor("ClearChatRecord") { // from class: com.soft.blued.ui.setting.fragment.GeneralFragment.8.1
                            public void execute() {
                                try {
                                    ChatManager.getInstance().deleteAllChattings();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                GeneralFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.setting.fragment.GeneralFragment.8.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (progressDialog != null) {
                                            progressDialog.dismiss();
                                        }
                                        AppMethods.d((int) R.string.cancel_success);
                                    }
                                });
                            }
                        });
                    }
                }, getString(2131886718), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                return;
            case R.id.ll_clear_img_cache /* 2131367702 */:
                CommonAlertDialog.a(getActivity(), getResources().getString(R.string.common_string_notice), getResources().getString(R.string.hint_clear_cache), getResources().getString(R.string.clear), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.GeneralFragment.7
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                        GeneralFragment.this.f19672a = true;
                        GeneralFragment.this.d();
                        GeneralFragment.this.f();
                        NewFeedDao.a().e();
                    }
                }, getString(2131886718), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                return;
            case R.id.ll_language_setting /* 2131367956 */:
                LanguageSelectFragment.a(getActivity());
                return;
            case R.id.ll_restore_chat_record /* 2131368192 */:
                if (MsgBackupService.isRunning()) {
                    ToastUtils.a("服务已运行");
                    return;
                } else if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    Context context = getContext();
                    MsgBackupService.startMsgRestoreService(context, 11, 2131232989, "消息恢复", "正在恢复聊天消息，请稍后", "恢复成功", (Environment.getExternalStorageDirectory() + File.separator + "blued" + File.separator + WebParameter.PATH_DATABASE) + File.separator + ("android_" + ChatManager.getInstance().getUid() + "_" + ChatManager.clientType.ordinal()));
                    return;
                } else {
                    return;
                }
            case R.id.ll_skin /* 2131368250 */:
                BluedPreferences.L(true);
                this.x.setVisibility(8);
                BluedSkinFragment.a(getActivity());
                return;
            case R.id.ll_text_size /* 2131368283 */:
                BluedPreferences.M(true);
                this.B.setVisibility(8);
                TextSizeSettingFragment.a(getActivity());
                return;
            case R.id.ll_unit_setting /* 2131368318 */:
                CommonAlertDialog.a(getActivity(), getString(R.string.unit_system), new String[]{"cm/kg", "ft/lb"}, new CommonAlertDialog.TextOnClickListener() { // from class: com.soft.blued.ui.setting.fragment.GeneralFragment.6
                    public void a(String str) {
                        if (StringUtils.d(str)) {
                            return;
                        }
                        GeneralFragment.this.i.setText(str);
                        if ("cm/kg".equals(str)) {
                            BluedPreferences.d(1);
                        } else if ("ft/lb".equals(str)) {
                            BluedPreferences.d(2);
                        }
                    }
                });
                return;
            case R.id.tb_sync_profile_photo /* 2131370601 */:
                BluedPreferences.bG();
                this.e.setVisibility(8);
                return;
            default:
                return;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = getActivity();
        View view = this.f19673c;
        if (view == null) {
            this.f19673c = layoutInflater.inflate(R.layout.fragment_general, viewGroup, false);
            b();
            c();
            a();
            d();
            e();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.f19673c.getParent()).removeView(this.f19673c);
        }
        return this.f19673c;
    }

    public void onDestroyView() {
        super.onDestroyView();
        BluedSkinUtils.b(this);
    }

    public void onResume() {
        super.onResume();
        BluedSkinUtils.a(this);
        g();
    }
}

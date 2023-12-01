package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.blued.android.module.common.face.TencentFaceVerify;
import com.blued.android.module.common.trace.EventTrackSettings;
import com.blued.android.module.common.user.model.UserHeaderVerifyStatus;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.user.model.VerifyStatus;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.similarity_operation_provider.BluedURIRouterAdapter;
import com.blued.das.settings.SettingsProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.http.ProfileHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.find.observer.PersonalVerifyObserver;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/PersonalVerifyFragment.class */
public class PersonalVerifyFragment extends BaseFragment implements View.OnClickListener, PersonalVerifyObserver.IPersonalVerifyObserver {

    /* renamed from: a  reason: collision with root package name */
    private Context f19836a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f19837c;
    private ShapeTextView d;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private Dialog r;
    private ImageView s;
    private ImageView t;
    private String e = "";
    private String p = "";
    private String q = "";
    private boolean u = false;

    public static void a(Context context) {
        TerminalActivity.d(context, PersonalVerifyFragment.class, (Bundle) null);
    }

    public static void a(Context context, int i) {
        EventTrackSettings.c(SettingsProtos.Event.PERSONAL_VERIFY_SHOW, i);
        InstantLog.a("personal_verify_show", Integer.valueOf(i));
        TerminalActivity.d(context, PersonalVerifyFragment.class, (Bundle) null);
    }

    private void c() {
        CommonTopTitleNoTrans findViewById = this.b.findViewById(R.id.top_title);
        findViewById.a();
        findViewById.setCenterText(getString(2131888665));
        findViewById.setLeftClickListener(this);
        findViewById.setCenterTextColor(2131102254);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        i();
        b();
    }

    private void e() {
        this.f19837c = (LinearLayout) this.b.findViewById(R.id.ll_verify_status);
        ShapeTextView findViewById = this.b.findViewById(R.id.ll_bottom_button);
        this.d = findViewById;
        findViewById.setTag((int) R.id.button_tab, false);
        this.d.setTag((int) R.id.button_click, false);
        this.d.setTag((int) R.id.request_tab, false);
        this.f = (TextView) this.b.findViewById(R.id.tv_point_1);
        this.g = (TextView) this.b.findViewById(R.id.tv_point_2);
        this.h = (TextView) this.b.findViewById(R.id.tv_point_3);
        this.i = (TextView) this.b.findViewById(R.id.tv_status_1);
        this.j = (TextView) this.b.findViewById(R.id.tv_status_2);
        this.k = (TextView) this.b.findViewById(R.id.tv_status_3);
        this.l = (TextView) this.b.findViewById(R.id.tv_text_1);
        this.m = (TextView) this.b.findViewById(R.id.tv_text_3);
        this.o = (TextView) this.b.findViewById(R.id.tv_right_line);
        TextView textView = (TextView) this.b.findViewById(R.id.tv_verify_hint);
        this.n = textView;
        textView.setText(getString(2131891340));
        ImageView imageView = (ImageView) this.b.findViewById(R.id.img_verify);
        this.t = imageView;
        imageView.setImageDrawable(this.f19836a.getResources().getDrawable(2131237327));
        this.s = (ImageView) this.b.findViewById(2131364232);
        ImageLoader.a(getFragmentActive(), AvatarUtils.a(0, UserInfo.getInstance().getLoginUserInfo().getAvatar())).b(2131237310).c().a(this.s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (Build.VERSION.SDK_INT < 16) {
            this.f.setBackgroundDrawable(this.f19836a.getResources().getDrawable(R.drawable.icon_verify_process1));
            this.g.setBackgroundDrawable(this.f19836a.getResources().getDrawable(R.drawable.icon_verify_process2));
            this.h.setBackgroundDrawable(this.f19836a.getResources().getDrawable(R.drawable.icon_verify_process_done));
        } else {
            this.f.setBackground(this.f19836a.getResources().getDrawable(R.drawable.icon_verify_process1));
            this.g.setBackground(this.f19836a.getResources().getDrawable(R.drawable.icon_verify_process2));
            this.h.setBackground(this.f19836a.getResources().getDrawable(R.drawable.icon_verify_process_done));
        }
        this.i.setText(this.f19836a.getResources().getString(2131892419));
        this.i.setTextColor(BluedSkinUtils.a(this.f19836a, 2131101766));
        this.j.setText(this.f19836a.getResources().getString(2131892566));
        this.j.setTextColor(BluedSkinUtils.a(this.f19836a, 2131101766));
        this.k.setText(this.f19836a.getResources().getString(2131886489));
        this.k.setTextColor(BluedSkinUtils.a(this.f19836a, 2131102360));
        this.l.setText(this.p);
        this.m.setText(this.f19836a.getResources().getString(2131886261));
        this.m.setTextColor(BluedSkinUtils.a(this.f19836a, 2131102360));
        this.o.setBackgroundColor(BluedSkinUtils.a(this.f19836a, 2131102362));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (Build.VERSION.SDK_INT < 16) {
            this.f.setBackgroundDrawable(this.f19836a.getResources().getDrawable(R.drawable.icon_verify_process1));
            this.g.setBackgroundDrawable(this.f19836a.getResources().getDrawable(R.drawable.icon_verify_process2));
            this.h.setBackgroundDrawable(this.f19836a.getResources().getDrawable(R.drawable.icon_verify_process_ing));
        } else {
            this.f.setBackground(this.f19836a.getResources().getDrawable(R.drawable.icon_verify_process1));
            this.g.setBackground(this.f19836a.getResources().getDrawable(R.drawable.icon_verify_process2));
            this.h.setBackground(this.f19836a.getResources().getDrawable(R.drawable.icon_verify_process_ing));
        }
        this.i.setText(this.f19836a.getResources().getString(2131892419));
        this.i.setTextColor(BluedSkinUtils.a(this.f19836a, 2131101766));
        this.j.setText(this.f19836a.getResources().getString(2131892566));
        this.j.setTextColor(BluedSkinUtils.a(this.f19836a, 2131101766));
        this.k.setText(this.f19836a.getResources().getString(2131886489));
        this.k.setTextColor(BluedSkinUtils.a(this.f19836a, 2131101766));
        this.l.setText(this.p);
        this.m.setText(this.f19836a.getResources().getString(2131886261));
        this.m.setTextColor(BluedSkinUtils.a(this.f19836a, 2131101766));
        this.o.setBackgroundColor(BluedSkinUtils.a(this.f19836a, 2131101766));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (Build.VERSION.SDK_INT < 16) {
            this.f.setBackgroundDrawable(this.f19836a.getResources().getDrawable(R.drawable.icon_verify_process1));
            this.g.setBackgroundDrawable(this.f19836a.getResources().getDrawable(R.drawable.icon_verify_process2));
            this.h.setBackgroundDrawable(this.f19836a.getResources().getDrawable(R.drawable.icon_verify_process_notyet));
        } else {
            this.f.setBackground(this.f19836a.getResources().getDrawable(R.drawable.icon_verify_process1));
            this.g.setBackground(this.f19836a.getResources().getDrawable(R.drawable.icon_verify_process2));
            this.h.setBackground(this.f19836a.getResources().getDrawable(R.drawable.icon_verify_process_notyet));
        }
        this.i.setText(this.f19836a.getResources().getString(2131892419));
        this.i.setTextColor(BluedSkinUtils.a(this.f19836a, 2131101766));
        this.j.setText(this.f19836a.getResources().getString(2131887505));
        this.j.setTextColor(BluedSkinUtils.a(this.f19836a, 2131101766));
        this.k.setText(this.f19836a.getResources().getString(2131892384));
        this.k.setTextColor(BluedSkinUtils.a(this.f19836a, 2131102251));
        this.l.setText(this.p);
        this.m.setText(this.q);
        this.m.setTextColor(BluedSkinUtils.a(this.f19836a, 2131102251));
        this.o.setBackgroundColor(this.f19836a.getResources().getColor(2131101766));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        ProfileHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<UserHeaderVerifyStatus>>(getFragmentActive()) { // from class: com.soft.blued.ui.setting.fragment.PersonalVerifyFragment.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<UserHeaderVerifyStatus> bluedEntityA) {
                if (PersonalVerifyFragment.this.d != null) {
                    PersonalVerifyFragment.this.d.setTag((int) R.id.request_tab, true);
                }
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                boolean z = false;
                UserHeaderVerifyStatus userHeaderVerifyStatus = (UserHeaderVerifyStatus) bluedEntityA.data.get(0);
                if (userHeaderVerifyStatus == null || PersonalVerifyFragment.this.d == null) {
                    return;
                }
                PersonalVerifyFragment.this.d.setTag((int) R.id.button_tab, true);
                UserInfo.getInstance().getLoginUserInfo().setHeaderVerifyStatus(userHeaderVerifyStatus);
                if (PersonalVerifyFragment.this.d.getTag((int) R.id.button_click) != null) {
                    z = ((Boolean) PersonalVerifyFragment.this.d.getTag((int) R.id.button_click)).booleanValue();
                }
                if (z) {
                    PersonalVerifyFragment.this.j();
                }
            }

            public boolean onUIFailure(int i, String str) {
                if (PersonalVerifyFragment.this.d != null) {
                    PersonalVerifyFragment.this.d.setTag((int) R.id.request_tab, true);
                }
                return super.onUIFailure(i, str);
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        switch (UserInfo.getInstance().getLoginUserInfo().getHeaderVerifyStatus().code) {
            case 200:
                PermissionUtils.b(new PermissionCallbacks() { // from class: com.soft.blued.ui.setting.fragment.PersonalVerifyFragment.3
                    public void U_() {
                        if (PersonalVerifyFragment.this.getActivity() != null) {
                            TencentFaceVerify.a.a(PersonalVerifyFragment.this.getActivity(), PersonalVerifyFragment.this.getFragmentActive(), new TencentFaceVerify.OnGetFaceVerifyChannelFinish() { // from class: com.soft.blued.ui.setting.fragment.PersonalVerifyFragment.3.1
                                public void a() {
                                    LiveDataManager.a().a(0);
                                    ShortVideoProxy.e().a(PersonalVerifyFragment.this.getContext(), 0, 0);
                                }

                                public void b() {
                                    PersonalVerifyFragment.this.d();
                                }
                            });
                            return;
                        }
                        LiveDataManager.a().a(0);
                        ShortVideoProxy.e().a(PersonalVerifyFragment.this.getContext(), 0, 0);
                    }

                    public void a(String[] strArr) {
                    }
                });
                return;
            case 201:
            case 202:
                k();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        CommonAlertDialog.a(getActivity(), (String) null, getResources().getString(2131891033), getResources().getString(R.string.upload), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.PersonalVerifyFragment.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                ModifyUserInfoFragment.a(PersonalVerifyFragment.this.f19836a, 602, true);
            }
        }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    @Override // com.soft.blued.ui.find.observer.PersonalVerifyObserver.IPersonalVerifyObserver
    public void a() {
        ImageLoader.a(getFragmentActive(), AvatarUtils.a(0, UserInfo.getInstance().getLoginUserInfo().getAvatar())).b(2131237310).c().a(this.s);
    }

    public void b() {
        GroupHttpUtils.k(getActivity(), new BluedUIHttpResponse<BluedEntityA<VerifyStatus>>(getFragmentActive()) { // from class: com.soft.blued.ui.setting.fragment.PersonalVerifyFragment.2
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<VerifyStatus> bluedEntityA) {
                if (bluedEntityA != null) {
                    if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                        PersonalVerifyFragment.this.p = "";
                        PersonalVerifyFragment.this.q = "";
                        PersonalVerifyFragment.this.e = "x";
                    } else {
                        UserInfo.getInstance().getLoginUserInfo().setVerify(new VerifyStatus[]{(VerifyStatus) bluedEntityA.data.get(0)});
                        PersonalVerifyFragment personalVerifyFragment = PersonalVerifyFragment.this;
                        personalVerifyFragment.p = TimeAndDateUtils.a(personalVerifyFragment.getActivity(), TimeAndDateUtils.c(((VerifyStatus) bluedEntityA.data.get(0)).add_time));
                        PersonalVerifyFragment personalVerifyFragment2 = PersonalVerifyFragment.this;
                        personalVerifyFragment2.q = TimeAndDateUtils.a(personalVerifyFragment2.getActivity(), TimeAndDateUtils.c(((VerifyStatus) bluedEntityA.data.get(0)).verified_time));
                        PersonalVerifyFragment.this.e = ((VerifyStatus) bluedEntityA.data.get(0)).has_audited;
                    }
                    if ("1".equals(PersonalVerifyFragment.this.e)) {
                        BluedURIRouterAdapter.openPersonalVerifyPage(PersonalVerifyFragment.this.getContext());
                        if (PersonalVerifyFragment.this.getActivity() != null) {
                            PersonalVerifyFragment.this.getActivity().finish();
                        }
                    }
                } else {
                    AppMethods.d(2131887272);
                }
                PersonalVerifyFragment.this.f19837c.setVisibility(0);
                if ("0".equals(PersonalVerifyFragment.this.e)) {
                    PersonalVerifyFragment.this.g();
                } else if ("2".equals(PersonalVerifyFragment.this.e)) {
                    PersonalVerifyFragment.this.h();
                } else if ("x".equals(PersonalVerifyFragment.this.e)) {
                    PersonalVerifyFragment.this.f19837c.setVisibility(8);
                } else if ("1".equals(PersonalVerifyFragment.this.e)) {
                    UserInfo.getInstance().getLoginUserInfo().setVBadge(4);
                    PersonalVerifyFragment.this.e = "0";
                    PersonalVerifyFragment.this.f();
                }
                if ("0".equals(PersonalVerifyFragment.this.e)) {
                    ShapeHelper.b(PersonalVerifyFragment.this.d, 2131102360);
                    PersonalVerifyFragment.this.d.setText(PersonalVerifyFragment.this.f19836a.getResources().getString(2131886578));
                    PersonalVerifyFragment.this.d.setClickable(false);
                    return;
                }
                ShapeHelper.b(PersonalVerifyFragment.this.d, 2131101766);
                PersonalVerifyFragment.this.d.setText(PersonalVerifyFragment.this.f19836a.getResources().getString(2131892102));
                PersonalVerifyFragment.this.d.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.PersonalVerifyFragment.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        InstantLog.a("start_video_verify_btn_click");
                        if (!(PersonalVerifyFragment.this.d.getTag((int) R.id.request_tab) != null ? ((Boolean) PersonalVerifyFragment.this.d.getTag((int) R.id.request_tab)).booleanValue() : false)) {
                            PersonalVerifyFragment.this.i();
                            return;
                        }
                        boolean z = false;
                        if (PersonalVerifyFragment.this.d.getTag((int) R.id.button_tab) != null) {
                            z = ((Boolean) PersonalVerifyFragment.this.d.getTag((int) R.id.button_tab)).booleanValue();
                        }
                        if (z) {
                            PersonalVerifyFragment.this.j();
                        } else if (StringUtils.d(UserInfo.getInstance().getLoginUserInfo().getAvatar())) {
                            PersonalVerifyFragment.this.k();
                        } else {
                            PersonalVerifyFragment.this.d.setTag((int) R.id.button_click, true);
                        }
                    }
                });
            }

            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(PersonalVerifyFragment.this.r);
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), getFragmentActive());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() != 2131363120) {
            return;
        }
        getActivity().finish();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f19836a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_personal_verify, viewGroup, false);
            this.r = DialogUtils.a(getActivity());
            PersonalVerifyObserver.a().a(this);
            c();
            e();
            d();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }

    public void onDestroy() {
        PersonalVerifyObserver.a().b(this);
        super.onDestroy();
    }

    public void onStart() {
        super.onStart();
        if (this.u) {
            d();
        } else {
            this.u = true;
        }
    }
}

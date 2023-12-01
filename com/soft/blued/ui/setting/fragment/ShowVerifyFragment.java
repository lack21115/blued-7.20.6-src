package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.app.share.ShareUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.user.model.VerifyStatus;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.area.AreaUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.utils.StringUtils;
import java.io.File;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/ShowVerifyFragment.class */
public class ShowVerifyFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f19913a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private String f19914c = "";
    private String d = "";
    private String e = "";
    private boolean f = false;
    private String g = "";
    private boolean h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private ImageView m;
    private LinearLayout n;
    private LinearLayout o;
    private ScrollView p;
    private Dialog q;
    private RelativeLayout r;

    public static void a(Context context, String str, String str2, String str3, String str4, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("USER_NAME", str);
        bundle.putSerializable("user_avatar", str2);
        bundle.putSerializable("user_verify_date", str3 + "");
        bundle.putSerializable("UID", str4);
        bundle.putBoolean("request_other_flag", z);
        TerminalActivity.d(context, ShowVerifyFragment.class, bundle);
    }

    private void b() {
        CommonTopTitleNoTrans findViewById = this.b.findViewById(R.id.top_title);
        findViewById.a();
        findViewById.setCenterText(getString(2131891257));
        findViewById.setRightImgDrawable(BluedSkinUtils.b(this.f19913a, 2131233917));
        findViewById.setLeftClickListener(this);
        findViewById.setRightClickListener(this);
        findViewById.setCenterTextColor(2131102254);
    }

    private void c() {
        if (StringUtils.d(this.e) && !StringUtils.d(this.g)) {
            a();
        }
        if (this.h) {
            f();
        }
    }

    private void d() {
        this.q = DialogUtils.a(getActivity());
        TextView textView = (TextView) this.b.findViewById(2131372046);
        this.i = textView;
        textView.setText(this.f19914c);
        this.j = (TextView) this.b.findViewById(R.id.tv_verify_description);
        e();
        this.r = (RelativeLayout) this.b.findViewById(2131363811);
        this.m = (ImageView) this.b.findViewById(2131364232);
        ImageLoader.a(getFragmentActive(), AvatarUtils.a(0, this.d)).b(2131237310).c().a(this.m);
        this.n = (LinearLayout) this.b.findViewById(R.id.ll_hint);
        this.p = (ScrollView) this.b.findViewById(2131369639);
        TextView textView2 = (TextView) this.b.findViewById(R.id.tv_start_verify);
        this.k = textView2;
        textView2.setOnClickListener(this);
        this.o = (LinearLayout) this.b.findViewById(R.id.ll_bottom_button);
        this.l = (TextView) this.b.findViewById(R.id.tv_verify_hint);
        this.l.setText(this.f19913a.getResources().getString(2131891340));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (StringUtils.d(this.e)) {
            this.j.setVisibility(8);
            return;
        }
        this.j.setVisibility(0);
        this.j.setText(getResources().getString(2131892555) + this.e + getResources().getString(2131892556));
    }

    private void f() {
        GroupHttpUtils.k(getActivity(), new BluedUIHttpResponse<BluedEntityA<VerifyStatus>>() { // from class: com.soft.blued.ui.setting.fragment.ShowVerifyFragment.4
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public BluedEntityA<VerifyStatus> parseData(String str) {
                return super.parseData(str);
            }

            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<VerifyStatus> bluedEntityA) {
                if (bluedEntityA != null) {
                    try {
                        if (bluedEntityA.hasData()) {
                            ShowVerifyFragment.this.f = "1".equals(((VerifyStatus) bluedEntityA.data.get(0)).has_audited);
                            if (ShowVerifyFragment.this.f) {
                                ShowVerifyFragment.this.k.setVisibility(8);
                                ShowVerifyFragment.this.o.setVisibility(8);
                                return;
                            }
                            ShowVerifyFragment.this.k.setVisibility(0);
                            ShowVerifyFragment.this.o.setVisibility(0);
                            return;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        AppMethods.a(AppInfo.d().getResources().getString(2131887272));
                        return;
                    }
                }
                ShowVerifyFragment.this.k.setVisibility(0);
                ShowVerifyFragment.this.o.setVisibility(0);
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), getFragmentActive());
    }

    public void a() {
        if (StringUtils.d(this.g)) {
            return;
        }
        GroupHttpUtils.k(getActivity(), new BluedUIHttpResponse<BluedEntityA<VerifyStatus>>() { // from class: com.soft.blued.ui.setting.fragment.ShowVerifyFragment.3
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public BluedEntityA<VerifyStatus> parseData(String str) {
                return super.parseData(str);
            }

            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<VerifyStatus> bluedEntityA) {
                if (bluedEntityA != null) {
                    try {
                        if (bluedEntityA.hasData()) {
                            ShowVerifyFragment.this.e = TimeAndDateUtils.b(TimeAndDateUtils.c(((VerifyStatus) bluedEntityA.data.get(0)).verified_time));
                            ShowVerifyFragment.this.e();
                            return;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        AppMethods.a(AppInfo.d().getResources().getString(2131887272));
                        return;
                    }
                }
                AppMethods.d(2131887272);
            }

            public void onUIFinish() {
                DialogUtils.b(ShowVerifyFragment.this.q);
            }

            public void onUIStart() {
                DialogUtils.a(ShowVerifyFragment.this.q);
            }
        }, this.g, getFragmentActive());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            getActivity().finish();
        } else if (id != 2131363126) {
            if (id != 2131372637) {
                return;
            }
            if (StringUtils.d(UserInfo.getInstance().getLoginUserInfo().getAvatar())) {
                CommonAlertDialog.a(getActivity(), (String) null, getResources().getString(2131891033), getResources().getString(R.string.upload), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.ShowVerifyFragment.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                        ModifyUserInfoFragment.a(ShowVerifyFragment.this.f19913a, true);
                    }
                }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
            } else {
                PersonalVerifyFragment.a(getActivity());
            }
        } else {
            final BluedLoginResult loginUserInfo = UserInfo.getInstance().getLoginUserInfo();
            String str = loginUserInfo.getAge() + getResources().getString(2131886374) + "/" + StringUtils.a(loginUserInfo.getHeight(), BlueAppLocal.c(), false) + "/" + StringUtils.b(loginUserInfo.getWeight(), BlueAppLocal.c(), false) + "/" + UserInfoHelper.a(this.f19913a, loginUserInfo.getRole());
            final String a2 = BluedHttpUrl.a(this.g);
            final String str2 = getResources().getString(2131891701) + this.f19914c + getResources().getString(2131891702);
            final String str3 = AreaUtils.getAreaTxt(UserInfo.getInstance().getLoginUserInfo().getCity_settled(), BlueAppLocal.c()) + "\n" + str;
            ImageFileLoader.a(getFragmentActive()).b(UserInfo.getInstance().getLoginUserInfo().getAvatar()).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.soft.blued.ui.setting.fragment.ShowVerifyFragment.1
                public void onUIFinish(File file, Exception exc) {
                    Bitmap decodeFile = (file == null || !file.exists()) ? null : BitmapFactory.decodeFile(file.getPath());
                    UserBasicModel userBasicModel = new UserBasicModel();
                    userBasicModel.uid = loginUserInfo.getUid();
                    userBasicModel.name = loginUserInfo.getName();
                    userBasicModel.description = loginUserInfo.getDescription();
                    ShareUtils.a().a(ShowVerifyFragment.this.f19913a, ShareUtils.a().a(ShowVerifyFragment.this.f19913a, ShowVerifyFragment.this.d, null, decodeFile, a2, str2, str3, str3, userBasicModel));
                }
            }).a();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f19913a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_show_verify, viewGroup, false);
            if (getArguments() != null) {
                this.f19914c = getArguments().getString("USER_NAME");
                this.d = getArguments().getString("user_avatar");
                this.e = getArguments().getString("user_verify_date");
                this.g = getArguments().getString("UID");
                this.h = getArguments().getBoolean("request_other_flag");
                if (!StringUtils.d(this.e)) {
                    this.e = TimeAndDateUtils.b(TimeAndDateUtils.c(this.e));
                }
            }
            d();
            c();
            b();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }
}

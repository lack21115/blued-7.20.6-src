package com.soft.blued.ui.login_register.View;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.common.db.UserAccountsVDao;
import com.blued.android.module.common.db.model.UserAccountsModel;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.das.login.LoginAndRegisterProtos;
import com.blued.login.auto.LoginServiceManager;
import com.blued.login.constant.LoginConstants;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.customview.TabPageIndicatorWithDot;
import com.soft.blued.log.track.EventTrackLoginAndRegister;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.login_register.LoginV1ForThreeActivity;
import com.soft.blued.ui.login_register.RegisterV1AreaCodeFragment;
import com.soft.blued.ui.login_register.utils.LoginTool;
import com.soft.blued.ui.setting.fragment.HelpCenterFragment;
import com.soft.blued.ui.setting.fragment.ServerAddressSettingFragment;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/View/LoginFragment.class */
public class LoginFragment extends KeyBoardFragment implements View.OnClickListener {
    private TextView A;
    private TextView B;
    private CheckBox C;
    private boolean D;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private final int f31492c = 0;
    private final int j = 1;
    private final int k = 2;
    private KeyboardListenLinearLayout l;
    private View m;
    private TextView n;
    private TabPageIndicatorWithDot o;
    private ViewPager p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private LoginWithPhoneFragment u;
    private LoginWithEmailFragment v;
    private MyAdapter w;
    private ImageView x;
    private LinearLayout y;
    private Bundle z;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/View/LoginFragment$AniInterface.class */
    public interface AniInterface {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/View/LoginFragment$MyAdapter.class */
    public class MyAdapter extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public Object f31495a;

        /* renamed from: c  reason: collision with root package name */
        private String[] f31496c;

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.f31496c = new String[]{LoginFragment.this.b.getResources().getString(2131886701), LoginFragment.this.b.getResources().getString(2131886664)};
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return 2;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            if (i != 0) {
                if (i != 1) {
                    return null;
                }
                return LoginFragment.this.v;
            }
            return LoginFragment.this.u;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.f31496c[i];
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (obj == null) {
                return;
            }
            Object obj2 = this.f31495a;
            if (obj2 == null || !obj2.equals(obj)) {
                if (obj instanceof LoginWithPhoneFragment) {
                    LoginWithPhoneFragment loginWithPhoneFragment = (LoginWithPhoneFragment) obj;
                    if (loginWithPhoneFragment.g != null) {
                        loginWithPhoneFragment.g.requestFocus();
                        this.f31495a = obj;
                    }
                } else if (obj instanceof LoginWithEmailFragment) {
                    LoginWithEmailFragment loginWithEmailFragment = (LoginWithEmailFragment) obj;
                    if (loginWithEmailFragment.d != null) {
                        loginWithEmailFragment.d.requestFocus();
                        this.f31495a = obj;
                    }
                }
            }
        }
    }

    private void h() {
        TextView textView = (TextView) this.m.findViewById(2131363120);
        this.n = textView;
        textView.setVisibility(8);
        KeyboardListenLinearLayout keyboardListenLinearLayout = (KeyboardListenLinearLayout) this.m.findViewById(2131366091);
        this.l = keyboardListenLinearLayout;
        keyboardListenLinearLayout.setBackgroundColor(BluedSkinUtils.a(this.b, 2131101780));
        this.p = (ViewPager) this.m.findViewById(R.id.viewpager_login_phone_email);
        this.o = (TabPageIndicatorWithDot) this.m.findViewById(R.id.tti_tab_indicator);
        this.q = (TextView) this.m.findViewById(R.id.tv_sign_up);
        this.r = (TextView) this.m.findViewById(R.id.tv_wechat_login);
        this.s = (TextView) this.m.findViewById(R.id.tv_forget_secret);
        this.t = (TextView) this.m.findViewById(R.id.tv_service_center);
        this.y = (LinearLayout) this.m.findViewById(R.id.ll_register);
        this.B = (TextView) this.m.findViewById(2131372706);
        this.C = (CheckBox) this.m.findViewById(2131362774);
        this.A = (TextView) this.m.findViewById(2131372705);
        ImageView imageView = (ImageView) this.m.findViewById(2131363123);
        this.x = imageView;
        imageView.setOnClickListener(this);
        Bundle arguments = getArguments();
        this.z = arguments;
        if (arguments != null) {
            this.n.setVisibility(8);
            this.y.setVisibility(8);
            this.x.setVisibility(0);
        }
        if (!TextUtils.isEmpty(BluedPreferences.bw())) {
            CommonAlertDialog.a(getActivity(), "", BluedPreferences.bw(), getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.login_register.View.LoginFragment.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    BluedPreferences.J("");
                }
            }, (DialogInterface.OnDismissListener) null, 0).a(false);
        }
        LoginTool.f31584a.a(this.A, this.B, false);
        this.C.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.login_register.View.LoginFragment.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Tracker.onCheckedChanged(compoundButton, z);
                if (z) {
                    LoginServiceManager.a().a("check_term", LoginFragment.this.getContext(), LoginFragment.this.C);
                }
                LoginFragment.this.D = z;
                LiveEventBus.get(EventBusConstant.KEY_EVENT_LOGIN_CHECK).post(Boolean.valueOf(z));
            }
        });
    }

    private void i() {
        a(this.l);
        this.l.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
    }

    private void j() {
        this.u = new LoginWithPhoneFragment();
        this.v = new LoginWithEmailFragment();
        this.u.setArguments(this.z);
        this.v.setArguments(this.z);
        MyAdapter myAdapter = new MyAdapter(getChildFragmentManager());
        this.w = myAdapter;
        this.p.setAdapter(myAdapter);
        this.o.setViewPager(this.p);
        UserAccountsModel e = UserAccountsVDao.a().e();
        if (e == null || e.getLoginType() != 0) {
            return;
        }
        this.p.setCurrentItem(1);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public boolean isActivitySwipeBackEnable() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100 && intent != null) {
            String stringExtra = intent.getStringExtra(RegisterV1AreaCodeFragment.j);
            if (StringUtils.d(stringExtra)) {
                return;
            }
            LoginConstants.f20505c = stringExtra;
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        AppUtils.a(AppInfo.d());
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case 2131363120:
                TerminalActivity.d(getActivity(), ServerAddressSettingFragment.class, null);
                return;
            case 2131363123:
                getActivity().finish();
                return;
            case 2131366091:
                KeyboardUtils.a(getActivity());
                return;
            case R.id.tv_forget_secret /* 2131371487 */:
                if (this.D) {
                    LoginRegisterTools.a(getActivity());
                    return;
                } else {
                    AppMethods.d(2131890421);
                    return;
                }
            case R.id.tv_service_center /* 2131372562 */:
                TerminalActivity.d(getActivity(), HelpCenterFragment.class, null);
                return;
            case R.id.tv_sign_up /* 2131372597 */:
                LoginServiceManager.a().a("to_register", getContext(), this.C);
                return;
            case R.id.tv_wechat_login /* 2131372956 */:
                if (!this.D) {
                    AppMethods.d(2131890421);
                    return;
                }
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_BTN_CLICK, LoginAndRegisterProtos.Source.WECHAT);
                Intent intent = new Intent(this.b, LoginV1ForThreeActivity.class);
                Bundle bundle = this.z;
                if (bundle != null) {
                    intent.putExtra("fragment_args", bundle);
                }
                intent.putExtra("from_three_plat", "plat_weixin");
                this.b.startActivity(intent);
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = getActivity();
        getActivity().getWindow().setBackgroundDrawable(this.b.getResources().getDrawable(2131237272));
        View view = this.m;
        if (view == null) {
            this.m = layoutInflater.inflate(R.layout.fragment_login_v1, viewGroup, false);
            h();
            j();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.m.getParent()).removeView(this.m);
        }
        return this.m;
    }

    @Override // com.blued.android.framework.activity.HomeTabFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        i();
    }
}

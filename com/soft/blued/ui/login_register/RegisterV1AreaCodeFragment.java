package com.soft.blued.ui.login_register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.module.common.utils.area.AreaCode;
import com.blued.android.module.common.utils.area.AreaUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.SearchView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.ui.login_register.AreaCode.AreaCodeSectionBar;
import com.soft.blued.ui.login_register.AreaCode.AreaCodeSelectorAdapter;
import com.soft.blued.ui.login_register.View.LoginWithPhoneFragment;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/RegisterV1AreaCodeFragment.class */
public class RegisterV1AreaCodeFragment extends KeyBoardFragment implements View.OnClickListener {
    public static String j = "select_area_code";
    public static String k = "from_page";
    public AreaCodeSelectorAdapter b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f31419c;
    private KeyboardListenLinearLayout m;
    private Context n;
    private CommonTopTitleNoTrans o;
    private ListView p;
    private AreaCodeSectionBar q;
    private SearchView r;
    private String l = RegisterV1AreaCodeFragment.class.getSimpleName();
    private List<AreaCode> s = new ArrayList();

    private void h() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.m.findViewById(2131370749);
        this.o = commonTopTitleNoTrans;
        commonTopTitleNoTrans.a();
        this.o.setCenterText(getString(2131886632));
        this.o.setLeftClickListener(this);
    }

    private void i() {
        this.q = (AreaCodeSectionBar) this.m.findViewById(R.id.ac_sb);
        this.p = (ListView) this.m.findViewById(R.id.ac_lv);
        if (getArguments() != null) {
            String string = getArguments().getString(k);
            if (StringUtils.d(string)) {
                return;
            }
            if (string.equals(RegisterV1ForPhoneFragment.class.getSimpleName())) {
                this.o.setCenterText(this.n.getResources().getString(2131886632));
            } else if (string.equals(LoginWithPhoneFragment.class.getSimpleName())) {
                this.o.setCenterText(this.n.getResources().getString(2131886629));
            }
        }
    }

    private void j() {
        SearchView searchView = (SearchView) this.m.findViewById(2131369680);
        this.r = searchView;
        this.f31419c = searchView.getEditView();
        this.r.setMaskLayerOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.RegisterV1AreaCodeFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                TerminalActivity.a(RegisterV1AreaCodeFragment.this, RegisterV1AreaCodeSearchFragment.class, (Bundle) null, 100);
            }
        });
    }

    private void k() {
        List<AreaCode> areaCodeList = AreaUtils.getAreaCodeList();
        this.s = areaCodeList;
        Collections.sort(areaCodeList);
        AreaCodeSelectorAdapter areaCodeSelectorAdapter = new AreaCodeSelectorAdapter(this.n, this.s);
        this.b = areaCodeSelectorAdapter;
        this.p.setAdapter((ListAdapter) areaCodeSelectorAdapter);
        this.q.setListView(this.p);
        this.p.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.login_register.RegisterV1AreaCodeFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j2) {
                Tracker.onItemClick(adapterView, view, i, j2);
                LoginRegisterHttpUtils.a("sel_country_mo");
                Intent intent = new Intent();
                intent.putExtra(RegisterV1AreaCodeFragment.j, ((AreaCode) RegisterV1AreaCodeFragment.this.s.get(i)).getCode());
                RegisterV1AreaCodeFragment.this.getActivity().setResult(-1, intent);
                RegisterV1AreaCodeFragment.this.getActivity().finish();
            }
        });
    }

    @Override // com.blued.android.framework.activity.keyboardpage.KeyBoardFragment
    public void j_(int i) {
        SearchView searchView;
        if (i != -3) {
            if (i == -2 && (searchView = this.r) != null) {
                searchView.a(false);
                return;
            }
            return;
        }
        SearchView searchView2 = this.r;
        if (searchView2 != null) {
            searchView2.a(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100 && intent != null) {
            String stringExtra = intent.getStringExtra(j);
            Intent intent2 = new Intent();
            intent2.putExtra(j, stringExtra);
            getActivity().setResult(-1, intent2);
            getActivity().finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() != 2131363120) {
            return;
        }
        getActivity().finish();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.n = getActivity();
        KeyboardListenLinearLayout keyboardListenLinearLayout = this.m;
        if (keyboardListenLinearLayout == null) {
            KeyboardListenLinearLayout keyboardListenLinearLayout2 = (KeyboardListenLinearLayout) layoutInflater.inflate(R.layout.fragment_register_areacode, viewGroup, false);
            this.m = keyboardListenLinearLayout2;
            keyboardListenLinearLayout2.setBackgroundColor(BluedSkinUtils.a(this.n, 2131101780));
            super.a(this.m);
            h();
            i();
            j();
            k();
        } else if (keyboardListenLinearLayout.getParent() != null) {
            ((ViewGroup) this.m.getParent()).removeView(this.m);
        }
        return this.m;
    }
}

package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.utils.area.AreaUtils;
import com.blued.android.module.common.utils.area.Country;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.user.adapter.CountryAdapter;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/ChooseCityFragment.class */
public class ChooseCityFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    public CountryAdapter f33821a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private View f33822c;
    private ListView e;
    private List<Country> d = new ArrayList();
    private String f = "";
    private String g = "";

    private void a() {
        this.e = (ListView) this.f33822c.findViewById(R.id.ac_lv);
    }

    public static void a(BaseFragment baseFragment, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("areacode", str);
        bundle.putString("areaname", str2);
        TerminalActivity.a(baseFragment, ChooseCityFragment.class, bundle, 1766);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Intent intent = new Intent();
        intent.putExtra("areacode", str);
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    private void b() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.f33822c.findViewById(2131370749);
        commonTopTitleNoTrans.a();
        commonTopTitleNoTrans.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.ChooseCityFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ChooseCityFragment.this.getActivity().finish();
            }
        });
        if (StringUtils.d(this.g)) {
            commonTopTitleNoTrans.setCenterText(getResources().getString(2131887002));
        } else {
            commonTopTitleNoTrans.setCenterText(this.g);
        }
    }

    private void c() {
        List<Country> areaSubList = AreaUtils.getAreaSubList(this.f);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= areaSubList.size()) {
                CountryAdapter countryAdapter = new CountryAdapter(this.b, this.d);
                this.f33821a = countryAdapter;
                this.e.setAdapter((ListAdapter) countryAdapter);
                this.e.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.user.fragment.ChooseCityFragment.2
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                        Tracker.onItemClick(adapterView, view, i3, j);
                        Country country = (Country) ChooseCityFragment.this.d.get(i3);
                        if ("1".equals(country.has_child)) {
                            ChooseCityFragment.a(ChooseCityFragment.this, country.nation_code, country.nation);
                        } else {
                            ChooseCityFragment.this.a(country.nation_code);
                        }
                    }
                });
                return;
            }
            this.d.add(areaSubList.get(i2));
            i = i2 + 1;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && intent != null && !StringUtils.d(intent.getStringExtra("areacode"))) {
            a(intent.getStringExtra("areacode"));
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = getActivity();
        if (this.f33822c == null) {
            this.f33822c = layoutInflater.inflate(R.layout.fragment_user_choosecity, viewGroup, false);
            if (getArguments() != null) {
                this.f = getArguments().getString("areacode");
                this.g = getArguments().getString("areaname");
            }
            a();
            b();
            c();
        }
        return this.f33822c;
    }
}

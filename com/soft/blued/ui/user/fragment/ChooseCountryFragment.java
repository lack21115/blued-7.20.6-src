package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.utils.area.AreaUtils;
import com.blued.android.module.common.utils.area.Country;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.SearchView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.BluedConstant;
import com.soft.blued.R;
import com.soft.blued.ui.login_register.AreaCode.AreaCodeSectionBar;
import com.soft.blued.ui.user.adapter.CountryAdapter;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/ChooseCountryFragment.class */
public class ChooseCountryFragment extends KeyBoardFragment {
    public CountryAdapter b;

    /* renamed from: c  reason: collision with root package name */
    public SearchView f20134c;
    private Context j;
    private View k;
    private List<Country> l = new ArrayList();
    private AreaCodeSectionBar m;
    private ListView n;
    private KeyboardListenLinearLayout o;
    private View p;

    public static void a(final BaseFragment baseFragment, final int i) {
        PermissionUtils.c(new PermissionCallbacks() { // from class: com.soft.blued.ui.user.fragment.ChooseCountryFragment.1
            public void U_() {
                TerminalActivity.a(baseFragment, ChooseCountryFragment.class, (Bundle) null, i);
            }

            public void a(String[] strArr) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Intent intent = new Intent();
        intent.putExtra("areacode", str);
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str) {
        String str2 = str;
        for (int length = str.length(); length < 5; length++) {
            str2 = "*".equals(str) ? "9" + str2 : "0" + str2;
        }
        return str2;
    }

    private void h() {
        this.m = (AreaCodeSectionBar) this.k.findViewById(R.id.ac_sb);
        this.n = (ListView) this.k.findViewById(R.id.ac_lv);
        this.o = this.k.findViewById(R.id.keyboardRelativeLayout);
        this.p = this.k.findViewById(R.id.keyboard_view);
        SearchView findViewById = this.k.findViewById(R.id.search_view);
        this.f20134c = findViewById;
        findViewById.setOnSearchInfoListener(new SearchView.OnSearchInfoListener() { // from class: com.soft.blued.ui.user.fragment.ChooseCountryFragment.2
            public void a() {
                KeyboardUtils.a(ChooseCountryFragment.this.getActivity());
            }

            public void a(String str) {
                if (ChooseCountryFragment.this.b != null) {
                    ChooseCountryFragment.this.b.b(str);
                    ChooseCountryFragment.this.b.notifyDataSetChanged();
                }
            }

            public void b() {
            }
        });
    }

    private void i() {
        CommonTopTitleNoTrans findViewById = this.k.findViewById(R.id.top_title);
        findViewById.a();
        findViewById.setCenterText(getString(2131887002));
        findViewById.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.ChooseCountryFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ChooseCountryFragment.this.getActivity().finish();
            }
        });
    }

    private void j() {
        List countryCodeList = AreaUtils.getCountryCodeList();
        Collections.sort(countryCodeList, new Comparator<Country>() { // from class: com.soft.blued.ui.user.fragment.ChooseCountryFragment.4
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Country country, Country country2) {
                return (ChooseCountryFragment.this.b(country.group_by) + country.abbr).compareTo(ChooseCountryFragment.this.b(country2.group_by) + country2.abbr);
            }
        });
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= countryCodeList.size()) {
                CountryAdapter countryAdapter = new CountryAdapter(this.j, this.l);
                this.b = countryAdapter;
                this.n.setAdapter((ListAdapter) countryAdapter);
                this.m.a(this.n, this.b);
                this.n.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.user.fragment.ChooseCountryFragment.5
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                        Tracker.onItemClick(adapterView, view, i3, j);
                        Country country = (Country) ChooseCountryFragment.this.l.get(i3);
                        if ("1".equals(country.has_child)) {
                            ChooseCountryFragment chooseCountryFragment = ChooseCountryFragment.this;
                            ChooseCityFragment.a(chooseCountryFragment, country.continent + "_" + country.nation_code, country.nation);
                            return;
                        }
                        ChooseCountryFragment chooseCountryFragment2 = ChooseCountryFragment.this;
                        chooseCountryFragment2.a(country.continent + "_" + country.nation_code + "_000000");
                    }
                });
                Country country = new Country(this.j.getResources().getString(2131887000).replace("_", ""), "156", "CN", "CN", "1", 1);
                country.group_by = getResources().getString(R.string.position_now);
                this.b.a(country);
                this.b.notifyDataSetChanged();
                return;
            }
            this.l.add((Country) countryCodeList.get(i2));
            i = i2 + 1;
        }
    }

    public void b(KeyboardListenLinearLayout keyboardListenLinearLayout) {
        super.a(keyboardListenLinearLayout);
    }

    public void j_(int i) {
        if (BluedConstant.e == BluedConstant.g || BluedConstant.e == BluedConstant.f) {
            return;
        }
        if (i == -3) {
            this.p.setVisibility(0);
            this.p.setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.ui.user.fragment.ChooseCountryFragment.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 0) {
                        return false;
                    }
                    Rect rect = new Rect();
                    ChooseCountryFragment.this.f20134c.getFocusedRect(rect);
                    if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                        return false;
                    }
                    KeyboardUtils.a(ChooseCountryFragment.this.getActivity());
                    return false;
                }
            });
            SearchView searchView = this.f20134c;
            if (searchView != null) {
                searchView.a(true);
            }
        } else if (i != -2) {
        } else {
            this.p.setVisibility(8);
            this.p.setOnTouchListener(null);
            SearchView searchView2 = this.f20134c;
            if (searchView2 != null) {
                searchView2.a(false);
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && intent != null && !StringUtils.d(intent.getStringExtra("areacode"))) {
            a(intent.getStringExtra("areacode"));
        }
        super.onActivityResult(i, i2, intent);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.j = getActivity();
        if (this.k == null) {
            this.k = layoutInflater.inflate(R.layout.fragment_user_choosecountry, viewGroup, false);
            h();
            i();
            b(this.o);
            j();
        }
        return this.k;
    }
}

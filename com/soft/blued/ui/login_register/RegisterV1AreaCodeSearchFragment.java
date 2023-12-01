package com.soft.blued.ui.login_register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.common.utils.area.AreaCode;
import com.blued.android.module.common.utils.area.AreaUtils;
import com.blued.android.module.common.view.SearchView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.BluedConstant;
import com.soft.blued.R;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.ui.login_register.AreaCode.AreaCodeSelectorSearchAdapter;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/RegisterV1AreaCodeSearchFragment.class */
public class RegisterV1AreaCodeSearchFragment extends KeyBoardFragment {
    public AreaCodeSelectorSearchAdapter b;

    /* renamed from: c  reason: collision with root package name */
    public SearchView f17732c;
    private View k;
    private Context l;
    private ListView m;
    private KeyboardListenLinearLayout n;
    private View o;
    private String j = RegisterV1AreaCodeSearchFragment.class.getSimpleName();
    private List<AreaCode> p = new ArrayList();
    private List<AreaCode> q = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public List<AreaCode> a(String str) {
        ArrayList arrayList = new ArrayList();
        List<AreaCode> areaCodeList = AreaUtils.getAreaCodeList();
        this.p = areaCodeList;
        ArrayList arrayList2 = arrayList;
        if (areaCodeList != null) {
            arrayList2 = arrayList;
            if (areaCodeList.size() > 0) {
                ArrayList arrayList3 = new ArrayList();
                Iterator<AreaCode> it = this.q.iterator();
                while (true) {
                    arrayList2 = arrayList3;
                    if (!it.hasNext()) {
                        break;
                    }
                    AreaCode next = it.next();
                    if (!TextUtils.isEmpty(next.getName()) && next.getName().toLowerCase().contains(str.toLowerCase())) {
                        arrayList3.add(next);
                    }
                }
            }
        }
        return arrayList2;
    }

    private void h() {
        ListView listView = (ListView) this.k.findViewById(R.id.ac_lv);
        this.m = listView;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.login_register.RegisterV1AreaCodeSearchFragment.1
            /* JADX WARN: Type inference failed for: r0v3, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Tracker.onItemClick(adapterView, view, i, j);
                LoginRegisterHttpUtils.a("sel_country_mo");
                AreaCode areaCode = (AreaCode) adapterView.getAdapter().getItem(i);
                if (areaCode != null) {
                    Intent intent = new Intent();
                    intent.putExtra(RegisterV1AreaCodeFragment.j, areaCode.getCode());
                    RegisterV1AreaCodeSearchFragment.this.getActivity().setResult(-1, intent);
                    RegisterV1AreaCodeSearchFragment.this.getActivity().finish();
                }
            }
        });
    }

    private void i() {
        this.n = this.k.findViewById(R.id.keyboardRelativeLayout);
        this.o = this.k.findViewById(R.id.keyboard_view);
        SearchView findViewById = this.k.findViewById(R.id.search_view);
        this.f17732c = findViewById;
        findViewById.setOnSearchInfoListener(new SearchView.OnSearchInfoListener() { // from class: com.soft.blued.ui.login_register.RegisterV1AreaCodeSearchFragment.2
            public void a() {
                KeyboardUtils.a(RegisterV1AreaCodeSearchFragment.this.getActivity());
            }

            public void a(String str) {
                if (StringUtils.d(str)) {
                    RegisterV1AreaCodeSearchFragment.this.b.a(RegisterV1AreaCodeSearchFragment.this.q, "");
                } else {
                    RegisterV1AreaCodeSearchFragment.this.b.a(RegisterV1AreaCodeSearchFragment.this.a(str), str);
                }
            }

            public void b() {
            }
        });
    }

    private void j() {
        List<AreaCode> areaCodeList = AreaUtils.getAreaCodeList();
        this.p = areaCodeList;
        this.q.addAll(areaCodeList);
        Collections.sort(this.p);
        AreaCodeSelectorSearchAdapter areaCodeSelectorSearchAdapter = new AreaCodeSelectorSearchAdapter(this.l, this.p);
        this.b = areaCodeSelectorSearchAdapter;
        this.m.setAdapter((ListAdapter) areaCodeSelectorSearchAdapter);
    }

    public void b(KeyboardListenLinearLayout keyboardListenLinearLayout) {
        super.a(keyboardListenLinearLayout);
    }

    public void j_(int i) {
        if (BluedConstant.e == BluedConstant.f || BluedConstant.e == BluedConstant.g) {
            return;
        }
        if (i == -3) {
            this.o.setVisibility(0);
            this.o.setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.ui.login_register.RegisterV1AreaCodeSearchFragment.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 0) {
                        return false;
                    }
                    if (motionEvent.getAction() != 0) {
                        return true;
                    }
                    KeyboardUtils.a(RegisterV1AreaCodeSearchFragment.this.getActivity());
                    return true;
                }
            });
            SearchView searchView = this.f17732c;
            if (searchView != null) {
                searchView.a(true);
            }
        } else if (i != -2) {
        } else {
            this.o.setVisibility(8);
            this.o.setOnTouchListener(null);
            SearchView searchView2 = this.f17732c;
            if (searchView2 != null) {
                searchView2.a(false);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.l = getActivity();
        View view = this.k;
        if (view == null) {
            this.k = layoutInflater.inflate(R.layout.fragment_register_areacode_search, viewGroup, false);
            h();
            i();
            j();
            this.n.setBackgroundColor(BluedSkinUtils.a(this.l, 2131101780));
            b(this.n);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.k.getParent()).removeView(this.k);
        }
        return this.k;
    }
}

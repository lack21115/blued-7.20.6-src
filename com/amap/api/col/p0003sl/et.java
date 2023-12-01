package com.amap.api.col.p0003sl;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AutoCompleteTextView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.amap.api.maps.offlinemap.DownLoadExpandListView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.amap.api.offlineservice.a;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.amap.api.col.3sl.et  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/et.class */
public final class et extends a implements TextWatcher, View.OnTouchListener, AbsListView.OnScrollListener, OfflineMapManager.OfflineLoadedListener, OfflineMapManager.OfflineMapDownloadListener {
    private ImageView b;
    private RelativeLayout c;
    private DownLoadExpandListView d;
    private ListView e;
    private ExpandableListView f;
    private ImageView g;
    private ImageView h;
    private AutoCompleteTextView i;
    private RelativeLayout j;
    private RelativeLayout k;
    private ImageView l;
    private ImageView m;
    private RelativeLayout n;
    private en p;
    private em r;
    private eo s;
    private ep x;
    private List<OfflineMapProvince> o = new ArrayList();
    private OfflineMapManager q = null;
    private boolean t = true;
    private boolean u = true;
    private int v = -1;
    private long w = 0;
    private boolean y = true;

    private void f() {
        try {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams.leftMargin = a(18.0f);
            this.m.setLayoutParams(layoutParams);
            this.i.setPadding(a(30.0f), 0, 0, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void g() {
        i();
        eo eoVar = new eo(this.q, this.a);
        this.s = eoVar;
        this.e.setAdapter((ListAdapter) eoVar);
    }

    private void h() {
        em emVar = new em(this.a, this, this.q, this.o);
        this.r = emVar;
        this.d.setAdapter(emVar);
        this.r.notifyDataSetChanged();
    }

    private void i() {
        ArrayList<OfflineMapProvince> offlineMapProvinceList = this.q.getOfflineMapProvinceList();
        this.o.clear();
        this.o.add(null);
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        ArrayList<OfflineMapCity> arrayList2 = new ArrayList<>();
        ArrayList<OfflineMapCity> arrayList3 = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= offlineMapProvinceList.size()) {
                OfflineMapProvince offlineMapProvince = new OfflineMapProvince();
                offlineMapProvince.setProvinceName("基本功能包+直辖市");
                offlineMapProvince.setCityList(arrayList3);
                this.o.set(0, offlineMapProvince);
                OfflineMapProvince offlineMapProvince2 = new OfflineMapProvince();
                offlineMapProvince2.setProvinceName("直辖市");
                offlineMapProvince2.setCityList(arrayList);
                OfflineMapProvince offlineMapProvince3 = new OfflineMapProvince();
                offlineMapProvince3.setProvinceName("港澳");
                offlineMapProvince3.setCityList(arrayList2);
                this.o.add(offlineMapProvince3);
                return;
            }
            OfflineMapProvince offlineMapProvince4 = offlineMapProvinceList.get(i2);
            if (offlineMapProvince4.getCityList().size() != 1) {
                this.o.add(i2 + 1, offlineMapProvince4);
            } else {
                String provinceName = offlineMapProvince4.getProvinceName();
                if (provinceName.contains("香港")) {
                    arrayList2.addAll(offlineMapProvince4.getCityList());
                } else if (provinceName.contains("澳门")) {
                    arrayList2.addAll(offlineMapProvince4.getCityList());
                } else if (provinceName.contains("全国概要图")) {
                    arrayList3.addAll(0, offlineMapProvince4.getCityList());
                } else {
                    arrayList3.addAll(offlineMapProvince4.getCityList());
                }
            }
            i = i2 + 1;
        }
    }

    private void j() {
        AutoCompleteTextView autoCompleteTextView = this.i;
        if (autoCompleteTextView == null || !autoCompleteTextView.isFocused()) {
            return;
        }
        this.i.clearFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) this.a.getSystemService("input_method");
        boolean z = false;
        if (inputMethodManager != null) {
            z = inputMethodManager.isActive();
        }
        if (z) {
            inputMethodManager.hideSoftInputFromWindow(this.i.getWindowToken(), 2);
        }
    }

    @Override // com.amap.api.offlineservice.a
    public final void a() {
        View a = ev.a(this.a, 2130903040);
        DownLoadExpandListView downLoadExpandListView = (DownLoadExpandListView) a.findViewById(2131165187);
        this.d = downLoadExpandListView;
        downLoadExpandListView.setOnTouchListener(this);
        this.j = (RelativeLayout) a.findViewById(2131165184);
        this.g = (ImageView) a.findViewById(2131165186);
        this.j.setOnClickListener(this.a);
        this.k = (RelativeLayout) a.findViewById(2131165189);
        this.h = (ImageView) a.findViewById(2131165190);
        this.k.setOnClickListener(this.a);
        this.n = (RelativeLayout) a.findViewById(2131165188);
        ImageView imageView = (ImageView) this.c.findViewById(2131165205);
        this.b = imageView;
        imageView.setOnClickListener(this.a);
        this.m = (ImageView) this.c.findViewById(2131165207);
        ImageView imageView2 = (ImageView) this.c.findViewById(2131165209);
        this.l = imageView2;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.amap.api.col.3sl.et.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                try {
                    et.this.i.setText("");
                    et.this.l.setVisibility(8);
                    et.this.a(false);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) et.this.m.getLayoutParams();
                    layoutParams.leftMargin = et.this.a(95.0f);
                    et.this.m.setLayoutParams(layoutParams);
                    et.this.i.setPadding(et.this.a(105.0f), 0, 0, 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.c.findViewById(2131165210).setOnTouchListener(this);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.c.findViewById(2131165208);
        this.i = autoCompleteTextView;
        autoCompleteTextView.addTextChangedListener(this);
        this.i.setOnTouchListener(this);
        this.e = (ListView) this.c.findViewById(2131165212);
        ExpandableListView expandableListView = (ExpandableListView) this.c.findViewById(2131165211);
        this.f = expandableListView;
        expandableListView.addHeaderView(a);
        this.f.setOnTouchListener(this);
        this.f.setOnScrollListener(this);
        try {
            OfflineMapManager offlineMapManager = new OfflineMapManager(this.a, this);
            this.q = offlineMapManager;
            offlineMapManager.setOnOfflineLoadedListener(this);
        } catch (Exception e) {
            Log.e("OfflineMapPage", "e=".concat(String.valueOf(e)));
        }
        i();
        en enVar = new en(this.o, this.q, this.a);
        this.p = enVar;
        this.f.setAdapter(enVar);
        this.f.setOnGroupCollapseListener(this.p);
        this.f.setOnGroupExpandListener(this.p);
        this.f.setGroupIndicator(null);
        if (this.t) {
            this.h.setBackgroundResource(2130837504);
            this.f.setVisibility(0);
        } else {
            this.h.setBackgroundResource(2130837508);
            this.f.setVisibility(8);
        }
        if (this.u) {
            this.g.setBackgroundResource(2130837504);
            this.d.setVisibility(0);
            return;
        }
        this.g.setBackgroundResource(2130837508);
        this.d.setVisibility(8);
    }

    @Override // com.amap.api.offlineservice.a
    public final void a(View view) {
        try {
            int id = view.getId();
            if (id == 2131165205) {
                this.a.closeScr();
            } else if (id == 2131165184) {
                if (this.u) {
                    this.d.setVisibility(8);
                    this.g.setBackgroundResource(2130837508);
                    this.u = false;
                    return;
                }
                this.d.setVisibility(0);
                this.g.setBackgroundResource(2130837504);
                this.u = true;
            } else if (id == 2131165189) {
                if (this.t) {
                    this.p.b();
                    this.h.setBackgroundResource(2130837508);
                    this.t = false;
                    return;
                }
                this.p.a();
                this.h.setBackgroundResource(2130837504);
                this.t = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(OfflineMapCity offlineMapCity) {
        try {
            if (this.x == null) {
                this.x = new ep(this.a, this.q);
            }
            this.x.a(offlineMapCity.getState(), offlineMapCity.getCity());
            this.x.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(boolean z) {
        if (z) {
            this.j.setVisibility(8);
            this.k.setVisibility(8);
            this.d.setVisibility(8);
            this.f.setVisibility(8);
            this.n.setVisibility(8);
            this.e.setVisibility(0);
            return;
        }
        this.j.setVisibility(0);
        this.k.setVisibility(0);
        this.n.setVisibility(0);
        this.d.setVisibility(this.u ? 0 : 8);
        this.f.setVisibility(this.t ? 0 : 8);
        this.e.setVisibility(8);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // com.amap.api.offlineservice.a
    public final RelativeLayout b() {
        if (this.c == null) {
            this.c = (RelativeLayout) ev.a(this.a, 2130903044);
        }
        return this.c;
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // com.amap.api.offlineservice.a
    public final void c() {
        this.q.destroy();
    }

    @Override // com.amap.api.offlineservice.a
    public final boolean d() {
        try {
            if (this.e.getVisibility() == 0) {
                this.i.setText("");
                this.l.setVisibility(8);
                a(false);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.d();
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public final void onCheckUpdate(boolean z, String str) {
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public final void onDownload(int i, int i2, String str) {
        if (i == 101) {
            try {
                Toast.makeText(this.a, "网络异常", 0).show();
                this.q.pause();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (i == 2) {
            this.r.a();
        }
        if (this.v == i) {
            if (System.currentTimeMillis() - this.w > 1200) {
                if (this.y) {
                    this.r.notifyDataSetChanged();
                }
                this.w = System.currentTimeMillis();
                return;
            }
            return;
        }
        if (this.p != null) {
            this.p.notifyDataSetChanged();
        }
        if (this.r != null) {
            this.r.notifyDataSetChanged();
        }
        if (this.s != null) {
            this.s.notifyDataSetChanged();
        }
        this.v = i;
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public final void onRemove(boolean z, String str, String str2) {
        em emVar = this.r;
        if (emVar != null) {
            emVar.b();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            this.y = false;
        } else {
            this.y = true;
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (TextUtils.isEmpty(charSequence)) {
            a(false);
            this.l.setVisibility(8);
            return;
        }
        this.l.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        List<OfflineMapProvince> list = this.o;
        if (list != null && list.size() > 0) {
            ArrayList<OfflineMapCity> arrayList2 = new ArrayList();
            for (OfflineMapProvince offlineMapProvince : this.o) {
                arrayList2.addAll(offlineMapProvince.getCityList());
            }
            for (OfflineMapCity offlineMapCity : arrayList2) {
                String city = offlineMapCity.getCity();
                String pinyin = offlineMapCity.getPinyin();
                String jianpin = offlineMapCity.getJianpin();
                if (charSequence.length() == 1) {
                    if (jianpin.startsWith(String.valueOf(charSequence))) {
                        arrayList.add(offlineMapCity);
                    }
                } else if (jianpin.startsWith(String.valueOf(charSequence)) || pinyin.startsWith(String.valueOf(charSequence)) || city.startsWith(String.valueOf(charSequence))) {
                    arrayList.add(offlineMapCity);
                }
            }
        }
        if (arrayList.size() <= 0) {
            Toast.makeText(this.a, "未找到相关城市", 0).show();
            return;
        }
        a(true);
        Collections.sort(arrayList, new Comparator<OfflineMapCity>() { // from class: com.amap.api.col.3sl.et.2
            private static int a(OfflineMapCity offlineMapCity2, OfflineMapCity offlineMapCity3) {
                char[] charArray = offlineMapCity2.getJianpin().toCharArray();
                char[] charArray2 = offlineMapCity3.getJianpin().toCharArray();
                return (charArray[0] >= charArray2[0] && charArray[1] >= charArray2[1]) ? 0 : 1;
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(OfflineMapCity offlineMapCity2, OfflineMapCity offlineMapCity3) {
                return a(offlineMapCity2, offlineMapCity3);
            }
        });
        eo eoVar = this.s;
        if (eoVar != null) {
            eoVar.a(arrayList);
            this.s.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        j();
        if (view.getId() == 2131165208) {
            f();
            return false;
        }
        return false;
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineLoadedListener
    public final void onVerifyComplete() {
        g();
        h();
    }
}

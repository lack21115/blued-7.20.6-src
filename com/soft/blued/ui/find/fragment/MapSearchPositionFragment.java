package com.soft.blued.ui.find.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.Tip;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.NetworkUtils;
import com.blued.android.framework.view.SearchEditText;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.ActivityChangeAnimationUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.view.SearchView;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.das.guy.GuyProtos;
import com.bytedance.applog.tracker.Tracker;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.ui.find.adapter.MapSearchPositionAdapter;
import com.soft.blued.ui.find.manager.MapSearchHistoryManager;
import com.soft.blued.ui.find.model.SearchPositionModel;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/MapSearchPositionFragment.class */
public class MapSearchPositionFragment extends KeyBoardFragment implements View.OnClickListener, Inputtips.InputtipsListener, PoiSearch.OnPoiSearchListener {
    private List<String> A;
    private List<SearchPositionModel> B;
    private String D;
    private PoiResult F;
    private PoiSearch.Query H;
    private PoiSearch I;
    private String J;
    private List<PoiItem> K;
    private List<PoiItem> L;
    private List<PoiItem> M;
    private List<Tip> N;
    private ViewPager O;
    private PositionPagerAdapter P;
    private TextView S;
    private TextView T;
    private int U;
    private OnBackListener W;
    public FindSearchMapActivity b;

    /* renamed from: c  reason: collision with root package name */
    public FindSearchMapFragment f16657c;
    private Context j;
    private View k;
    private Dialog l;
    private SearchView m;
    private SearchEditText n;
    private View o;
    private KeyboardListenLinearLayout p;
    private ConstraintLayout q;
    private NoDataAndLoadFailView r;
    private NoDataAndLoadFailView s;
    private LinearLayout t;
    private TextView u;
    private RecyclerView v;
    private MapSearchPositionAdapter w;
    private MapSearchPositionAdapter x;
    private List<String> y;
    private List<SearchPositionModel> z;
    private boolean C = false;
    private boolean E = false;
    private int G = 0;
    private List<String> Q = new ArrayList();
    private List<View> R = new ArrayList();
    private int V = 0;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/MapSearchPositionFragment$OnBackListener.class */
    public interface OnBackListener {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/MapSearchPositionFragment$PositionPagerAdapter.class */
    public class PositionPagerAdapter extends PagerAdapter {
        PositionPagerAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return MapSearchPositionFragment.this.Q.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            while (MapSearchPositionFragment.this.R.size() < MapSearchPositionFragment.this.Q.size()) {
                MapSearchPositionFragment.this.R.add(LayoutInflater.from(MapSearchPositionFragment.this.j).inflate(R.layout.search_position_pager, viewGroup, false));
            }
            View view = (View) MapSearchPositionFragment.this.R.get(i);
            MapSearchPositionFragment.this.v = (RecyclerView) view.findViewById(2131369105);
            MapSearchPositionFragment.this.v.setLayoutManager(new LinearLayoutManager(MapSearchPositionFragment.this.j));
            if (i == 0) {
                MapSearchPositionFragment.this.r = view.findViewById(R.id.nodataview);
                Log.v("drb", "findViewById nodataview");
                MapSearchPositionFragment.this.r.setNoDataStr((int) R.string.search_no);
                MapSearchPositionFragment.this.r.setBackgroundColorRes(2131102170);
                MapSearchPositionFragment.this.r.d();
                if (MapSearchPositionFragment.this.v.getAdapter() == null) {
                    MapSearchPositionFragment.this.v.setAdapter(MapSearchPositionFragment.this.w);
                }
            } else if (i == 1) {
                MapSearchPositionFragment.this.s = view.findViewById(R.id.nodataview);
                MapSearchPositionFragment.this.s.setNoDataStr((int) R.string.search_no);
                MapSearchPositionFragment.this.s.setBackgroundColorRes(2131102170);
                MapSearchPositionFragment.this.r.d();
                if (MapSearchPositionFragment.this.v.getAdapter() == null) {
                    MapSearchPositionFragment.this.v.setAdapter(MapSearchPositionFragment.this.x);
                }
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView((View) MapSearchPositionFragment.this.R.get(i));
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    private void a(boolean z) {
        if (this.z.size() == 0 && this.V == 0 && z) {
            this.t.setVisibility(0);
        } else {
            this.t.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, int i) {
        if (this.b != null) {
            if (z) {
                if (this.L.size() > i) {
                    this.b.a(this.L.get(i), this.D);
                }
            } else if (this.M.size() > i) {
                this.b.a(this.M.get(i), this.D);
            }
        }
        if (this.f16657c != null) {
            if (z) {
                if (this.L.size() > i) {
                    this.f16657c.a(this.L.get(i), this.D);
                }
            } else if (this.M.size() > i) {
                this.f16657c.a(this.M.get(i), this.D);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (StringUtils.d(str)) {
            return;
        }
        String trim = str.trim();
        if (this.y.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.y.size()) {
                    break;
                } else if (trim.equals(this.y.get(i2))) {
                    this.y.remove(i2);
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            this.y.add(0, trim);
            if (this.y.size() > 10) {
                List<String> list = this.y;
                list.remove(list.size() - 1);
            }
            StringBuilder sb = new StringBuilder();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.y.size()) {
                    break;
                }
                sb.append(this.y.get(i4) + ",");
                i3 = i4 + 1;
            }
            BluedPreferences.c(sb.toString());
        } else {
            this.y.add(trim);
            BluedPreferences.c(trim + ",");
        }
        this.w.a(this.y, true);
    }

    private int c(int i) {
        return BluedSkinUtils.a(this.j, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        if (i == 0) {
            this.S.setTextColor(c(2131102203));
            this.T.setTextColor(c(2131102205));
            a(false);
        } else if (i != 1) {
        } else {
            this.S.setTextColor(c(2131102205));
            this.T.setTextColor(c(2131102203));
            a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final int i) {
        Context context = this.j;
        CommonAlertDialog.a(context, (String) null, context.getResources().getString(R.string.clear_history), this.j.getResources().getString(R.string.clear_now), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.MapSearchPositionFragment.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Tracker.onClick(dialogInterface, i2);
                EventTrackGuy.b(GuyProtos.Event.MAP_FIND_SEARCH_CLEAR_HISTORY);
                if (i == 0) {
                    MapSearchPositionFragment.this.n();
                    MapSearchPositionFragment.this.y.clear();
                    MapSearchPositionFragment.this.w.a();
                    return;
                }
                MapSearchPositionFragment.this.n();
                MapSearchPositionFragment.this.z.clear();
                MapSearchPositionFragment.this.x.a();
            }
        }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    private List<String> f(int i) {
        ArrayList arrayList = new ArrayList(Arrays.asList((i == 0 ? BluedPreferences.p() : BluedPreferences.r()).split(",")));
        if (arrayList.size() == 1 && ((String) arrayList.get(0)).equals("")) {
            arrayList.clear();
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        return this.U == 0;
    }

    private void j() {
        String str = this.D;
        if (str == null) {
            str = "";
        }
        this.D = str;
        this.y = f(0);
        this.z = MapSearchHistoryManager.a().b().getModelList();
        this.A = new ArrayList();
        this.B = new ArrayList();
        this.L = new ArrayList();
        this.M = new ArrayList();
        this.N = new ArrayList();
        this.Q.addAll(Arrays.asList(this.j.getResources().getStringArray(R.array.search_position_title)));
    }

    private void k() {
        this.w = new MapSearchPositionAdapter(this.j, this.y, 0);
        this.x = new MapSearchPositionAdapter(this.j, this.z);
        this.w.a(new MapSearchPositionAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.find.fragment.MapSearchPositionFragment.2
            @Override // com.soft.blued.ui.find.adapter.MapSearchPositionAdapter.OnItemClickListener
            public void a(View view, int i, SearchPositionModel searchPositionModel) {
                if (searchPositionModel.isDel) {
                    MapSearchPositionFragment.this.e(0);
                } else if (MapSearchPositionFragment.this.C) {
                    if (MapSearchPositionFragment.this.A.size() > i) {
                        MapSearchPositionFragment mapSearchPositionFragment = MapSearchPositionFragment.this;
                        mapSearchPositionFragment.D = (String) mapSearchPositionFragment.A.get(i);
                    }
                    MapSearchPositionFragment mapSearchPositionFragment2 = MapSearchPositionFragment.this;
                    mapSearchPositionFragment2.b(mapSearchPositionFragment2.D);
                    MapSearchPositionFragment.this.a(true, i);
                } else {
                    if (NetworkUtils.b()) {
                        DialogUtils.a(MapSearchPositionFragment.this.l);
                    }
                    EventTrackGuy.b(GuyProtos.Event.MAP_FIND_SEARCH_HISTORY_CLICK);
                    MapSearchPositionFragment.this.n.setText((CharSequence) MapSearchPositionFragment.this.y.get(i));
                    MapSearchPositionFragment.this.n.setSelection(MapSearchPositionFragment.this.n.getText().length());
                    MapSearchPositionFragment mapSearchPositionFragment3 = MapSearchPositionFragment.this;
                    mapSearchPositionFragment3.b(mapSearchPositionFragment3.D);
                }
            }
        });
        this.x.a(new MapSearchPositionAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.find.fragment.MapSearchPositionFragment.3
            @Override // com.soft.blued.ui.find.adapter.MapSearchPositionAdapter.OnItemClickListener
            public void a(View view, int i, SearchPositionModel searchPositionModel) {
                if (searchPositionModel.isDel) {
                    MapSearchPositionFragment.this.e(1);
                } else if (!MapSearchPositionFragment.this.C) {
                    if (MapSearchPositionFragment.this.b != null) {
                        MapSearchPositionFragment.this.b.a(searchPositionModel);
                    }
                    if (MapSearchPositionFragment.this.f16657c != null) {
                        MapSearchPositionFragment.this.f16657c.a(searchPositionModel);
                    }
                } else {
                    MapSearchPositionFragment.this.D = searchPositionModel.name;
                    MapSearchPositionFragment mapSearchPositionFragment = MapSearchPositionFragment.this;
                    mapSearchPositionFragment.b(mapSearchPositionFragment.D);
                    if (MapSearchPositionFragment.this.M.size() > i) {
                        MapSearchPositionFragment.this.a(false, i);
                        return;
                    }
                    if (MapSearchPositionFragment.this.b != null) {
                        MapSearchPositionFragment.this.b.a(searchPositionModel);
                    }
                    if (MapSearchPositionFragment.this.f16657c != null) {
                        MapSearchPositionFragment.this.f16657c.a(searchPositionModel);
                    }
                }
            }
        });
    }

    private void l() {
        SearchView findViewById = this.k.findViewById(R.id.search_view);
        this.m = findViewById;
        findViewById.setRootBgColor(c(2131102170));
        this.n = this.m.getEditView();
        ShapeModel shapeModel = new ShapeModel();
        shapeModel.k = c(2131101689);
        shapeModel.H = DensityUtil.a(17.0f);
        this.m.setShapeModel(shapeModel);
        this.n.setImeOptions(3);
        this.n.setTextColor(getActivity().getResources().getColor(2131102203));
        this.o = this.k.findViewById(R.id.keyboard_view);
        this.m.setOnSearchInfoListener(new SearchView.OnSearchInfoListener() { // from class: com.soft.blued.ui.find.fragment.MapSearchPositionFragment.4
            public void a() {
                if (MapSearchPositionFragment.this.b != null) {
                    KeyboardUtils.a(MapSearchPositionFragment.this.getActivity());
                    MapSearchPositionFragment.this.b.c();
                }
                if (MapSearchPositionFragment.this.f16657c != null) {
                    KeyboardUtils.a(MapSearchPositionFragment.this.getActivity());
                    MapSearchPositionFragment.this.f16657c.d();
                }
            }

            public void a(String str) {
                Log.v("drb", "doSearch");
                if (MapSearchPositionFragment.this.i()) {
                    MapSearchPositionFragment.this.C = str.length() > 0;
                    if (!MapSearchPositionFragment.this.C) {
                        if (MapSearchPositionFragment.this.r != null) {
                            MapSearchPositionFragment.this.r.d();
                        }
                        MapSearchPositionFragment.this.w.a(MapSearchPositionFragment.this.y, true);
                    } else if (NetworkUtils.b()) {
                        MapSearchPositionFragment.this.a(str);
                        MapSearchPositionFragment.this.A.clear();
                        MapSearchPositionFragment.this.w.a(MapSearchPositionFragment.this.A, false);
                    } else if (MapSearchPositionFragment.this.r != null) {
                        MapSearchPositionFragment.this.r.b();
                    }
                    MapSearchPositionFragment.this.t.setVisibility(8);
                    return;
                }
                MapSearchPositionFragment.this.C = str.length() > 0;
                if (!MapSearchPositionFragment.this.C) {
                    if (MapSearchPositionFragment.this.s != null) {
                        MapSearchPositionFragment.this.s.d();
                    }
                    MapSearchPositionFragment.this.x.b(MapSearchPositionFragment.this.z, true);
                } else if (NetworkUtils.b()) {
                    MapSearchPositionFragment.this.a(str);
                    MapSearchPositionFragment.this.B.clear();
                    MapSearchPositionFragment.this.x.b(MapSearchPositionFragment.this.B, false);
                } else if (MapSearchPositionFragment.this.s != null) {
                    MapSearchPositionFragment.this.s.b();
                }
            }

            public void b() {
            }
        });
        this.n.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.soft.blued.ui.find.fragment.MapSearchPositionFragment.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                MapSearchPositionFragment mapSearchPositionFragment = MapSearchPositionFragment.this;
                mapSearchPositionFragment.D = mapSearchPositionFragment.n.getText().toString();
                if (!StringUtils.d(MapSearchPositionFragment.this.D) && i == 3) {
                    MapSearchPositionFragment mapSearchPositionFragment2 = MapSearchPositionFragment.this;
                    mapSearchPositionFragment2.b(mapSearchPositionFragment2.D);
                    KeyboardUtils.a(MapSearchPositionFragment.this.getActivity());
                    if (!NetworkUtils.b()) {
                        MapSearchPositionFragment.this.r.b();
                        return true;
                    }
                    MapSearchPositionFragment.this.E = true;
                    DialogUtils.a(MapSearchPositionFragment.this.l);
                    MapSearchPositionFragment mapSearchPositionFragment3 = MapSearchPositionFragment.this;
                    mapSearchPositionFragment3.a(mapSearchPositionFragment3.D);
                    return true;
                }
                return false;
            }
        });
    }

    private void m() {
        this.l = DialogUtils.a(this.j);
        this.q = (ConstraintLayout) this.k.findViewById(R.id.layout_search_history);
        this.O = (ViewPager) this.k.findViewById(R.id.view_pager);
        this.S = (TextView) this.k.findViewById(R.id.tv_search_record);
        this.T = (TextView) this.k.findViewById(R.id.tv_search_shadow_record);
        this.t = (LinearLayout) this.k.findViewById(R.id.layout_null_shadow_history);
        this.u = (TextView) this.k.findViewById(R.id.tv_go_setting);
        this.S.setOnClickListener(this);
        this.T.setOnClickListener(this);
        PositionPagerAdapter positionPagerAdapter = new PositionPagerAdapter();
        this.P = positionPagerAdapter;
        this.O.setAdapter(positionPagerAdapter);
        d(0);
        this.u.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.MapSearchPositionFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                WebViewShowInfoFragment.show(MapSearchPositionFragment.this.j, H5Url.a(46, new Object[]{UserInfo.getInstance().getLoginUserInfo().uid, "nearby_friend_set_shadow"}), 0);
            }
        });
        this.O.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.find.fragment.MapSearchPositionFragment.7
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                MapSearchPositionFragment.this.d(i);
                MapSearchPositionFragment.this.U = i;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (i()) {
            BluedPreferences.q();
        } else {
            BluedPreferences.t();
        }
    }

    public void a(OnBackListener onBackListener) {
        this.W = onBackListener;
    }

    protected void a(String str) {
        if (StringUtils.d(str)) {
            if (i()) {
                this.r.a();
                return;
            } else {
                this.s.a();
                return;
            }
        }
        String trim = str.trim();
        this.G = 0;
        PoiSearch.Query query = new PoiSearch.Query(trim, "", "");
        this.H = query;
        query.setPageSize(30);
        this.H.setPageNum(this.G);
        try {
            this.I = new PoiSearch(this.j, this.H);
        } catch (AMapException e) {
            e.printStackTrace();
        }
        this.I.setOnPoiSearchListener(this);
        this.I.searchPOIAsyn();
    }

    public void a(String str, String str2) {
        Log.v("drb", "setData searchPosition:" + str + " -- :" + str2);
        this.J = str2;
        this.D = str;
        this.n.setText(str);
        SearchEditText searchEditText = this.n;
        searchEditText.setSelection(searchEditText.getText().length());
        this.n.postDelayed(new Runnable() { // from class: com.soft.blued.ui.find.fragment.MapSearchPositionFragment.1
            @Override // java.lang.Runnable
            public void run() {
                MapSearchPositionFragment.this.n.setFocusable(true);
                MapSearchPositionFragment.this.n.setFocusableInTouchMode(true);
                MapSearchPositionFragment.this.n.requestFocus();
                KeyboardUtils.c(MapSearchPositionFragment.this.getActivity());
            }
        }, 500L);
        this.z = MapSearchHistoryManager.a().b().getModelList();
        this.x.a();
        this.x.b(this.z, true);
        this.x.notifyDataSetChanged();
    }

    public void b(int i) {
        this.V = i;
    }

    public void h() {
        KeyboardListenLinearLayout findViewById = this.k.findViewById(R.id.keyboardRelativeLayout);
        this.p = findViewById;
        super.a(findViewById);
    }

    public void j_(int i) {
        if (i != -3) {
            if (i != -2) {
                return;
            }
            this.o.setVisibility(8);
            this.o.setOnTouchListener(null);
            return;
        }
        SearchView searchView = this.m;
        if (searchView != null) {
            searchView.a(true);
        }
        this.o.setVisibility(0);
        this.o.setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.ui.find.fragment.MapSearchPositionFragment.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                Log.v("drb", "ACTION_DOWN");
                KeyboardUtils.b(MapSearchPositionFragment.this.getActivity(), MapSearchPositionFragment.this.n);
                return false;
            }
        });
    }

    public boolean onBackPressed() {
        OnBackListener onBackListener = this.W;
        if (onBackListener != null) {
            onBackListener.a();
            return true;
        } else if (getActivity() == null) {
            return false;
        } else {
            getActivity().finish();
            ActivityChangeAnimationUtils.c(getActivity());
            return true;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case R.id.tv_search_record /* 2131372518 */:
                d(0);
                this.O.setCurrentItem(0);
                return;
            case R.id.tv_search_shadow_record /* 2131372519 */:
                d(1);
                this.O.setCurrentItem(1);
                return;
            default:
                return;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.j = getActivity();
        View view = this.k;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.fragment_map_search_position, viewGroup, false);
            this.k = inflate;
            inflate.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131102170));
            j();
            m();
            k();
            l();
            h();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.k.getParent()).removeView(this.k);
        }
        return this.k;
    }

    public void onDestroy() {
        super.onDestroy();
        this.b = null;
        this.f16657c = null;
    }

    public void onGetInputtips(List<Tip> list, int i) {
        DialogUtils.b(this.l);
        if (this.C) {
            if (i != 1000) {
                if (i()) {
                    this.r.a();
                    return;
                } else {
                    this.s.a();
                    return;
                }
            }
            this.N.clear();
            this.A.clear();
            this.B.clear();
            for (Tip tip : list) {
                if (tip.getPoint() != null && tip.getPoint().getLatitude() != 0.0d && tip.getPoint().getLongitude() != 0.0d) {
                    this.N.add(tip);
                    if (i()) {
                        this.A.add(tip.getName());
                    } else {
                        this.B.add(new SearchPositionModel(tip.getName(), tip.getPoint().getLatitude(), tip.getPoint().getLongitude()));
                    }
                }
            }
            if (i()) {
                MapSearchPositionAdapter mapSearchPositionAdapter = this.w;
                if (mapSearchPositionAdapter != null) {
                    mapSearchPositionAdapter.notifyDataSetChanged();
                }
            } else {
                MapSearchPositionAdapter mapSearchPositionAdapter2 = this.x;
                if (mapSearchPositionAdapter2 != null) {
                    mapSearchPositionAdapter2.notifyDataSetChanged();
                }
            }
            if (this.N.size() == 0) {
                if (i()) {
                    this.r.a();
                } else {
                    this.s.a();
                }
            } else if (i()) {
                this.r.d();
            } else {
                this.s.d();
            }
            if (this.E) {
                this.E = false;
                if (i()) {
                    if (this.A.size() > 0) {
                        a(true, 0);
                    }
                } else if (this.B.size() > 0) {
                    a(false, 0);
                }
            }
        }
    }

    public void onPoiItemSearched(PoiItem poiItem, int i) {
    }

    public void onPoiSearched(PoiResult poiResult, int i) {
        DialogUtils.b(this.l);
        if (this.C) {
            if (i != 1000) {
                if (i()) {
                    this.r.a();
                } else {
                    this.s.a();
                }
            } else if (poiResult == null || poiResult.getQuery() == null) {
                if (i()) {
                    this.r.a();
                } else {
                    this.s.a();
                }
            } else if (poiResult.getQuery().equals(this.H)) {
                this.F = poiResult;
                poiResult.getSearchSuggestionCitys();
                List<PoiItem> list = this.K;
                if (list != null && list.size() > 0) {
                    this.K.clear();
                }
                this.K = this.F.getPois();
                if (i()) {
                    this.A.clear();
                    this.L.clear();
                    for (PoiItem poiItem : this.K) {
                        this.A.add(poiItem.getTitle());
                        this.L.add(poiItem);
                    }
                    MapSearchPositionAdapter mapSearchPositionAdapter = this.w;
                    if (mapSearchPositionAdapter != null) {
                        mapSearchPositionAdapter.a(this.A, false);
                        this.w.notifyDataSetChanged();
                    }
                    if (this.K.size() == 0) {
                        this.r.a();
                    } else {
                        this.r.d();
                    }
                    if (this.E) {
                        this.E = false;
                        if (this.A.size() > 0) {
                            a(true, 0);
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.B.clear();
                this.M.clear();
                for (PoiItem poiItem2 : this.K) {
                    this.B.add(new SearchPositionModel(poiItem2.getTitle(), poiItem2.getLatLonPoint().getLatitude(), poiItem2.getLatLonPoint().getLongitude()));
                    this.M.add(poiItem2);
                }
                MapSearchPositionAdapter mapSearchPositionAdapter2 = this.x;
                if (mapSearchPositionAdapter2 != null) {
                    mapSearchPositionAdapter2.b(this.B, false);
                    this.x.notifyDataSetChanged();
                }
                if (this.K.size() == 0) {
                    this.s.a();
                } else {
                    this.s.d();
                }
                if (this.E) {
                    this.E = false;
                    if (this.B.size() > 0) {
                        a(false, 0);
                    }
                }
            }
        }
    }
}

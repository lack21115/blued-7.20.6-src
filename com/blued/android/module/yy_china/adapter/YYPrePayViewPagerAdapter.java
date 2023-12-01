package com.blued.android.module.yy_china.adapter;

import android.content.Context;
import android.util.ArrayMap;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import com.blued.android.module.live.base.model.PayOption;
import com.blued.android.module.yy_china.adapter.YYPrePayPriceAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYPrePayViewPagerAdapter.class */
public class YYPrePayViewPagerAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public PayOption._pay_list f16210a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public int f16211c;
    private Context e;
    private List<PayOption._pay_list> f;
    private SelectModelCallBack j;
    private ArrayList<Long> k;
    private final int d = 6;
    private Map<Integer, RecyclerView> g = new ArrayMap();
    private Map<Integer, List<PayOption._pay_list>> h = new ArrayMap();
    private Map<Integer, YYPrePayPriceAdapter> i = new ArrayMap();

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYPrePayViewPagerAdapter$SelectModelCallBack.class */
    public interface SelectModelCallBack {
        void a(PayOption._pay_list _pay_listVar);
    }

    public YYPrePayViewPagerAdapter(Context context, List<PayOption._pay_list> list, int i, int i2, SelectModelCallBack selectModelCallBack) {
        int i3 = 0;
        this.f16211c = 0;
        this.e = context;
        this.f = list;
        this.j = selectModelCallBack;
        while (true) {
            if (i3 >= this.f.size()) {
                break;
            } else if (this.f.get(i3).money == 5.0d) {
                this.f16211c = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i > 0) {
            this.f16211c = i2;
        }
    }

    private View a(int i) {
        RecyclerView recyclerView = this.g.get(Integer.valueOf(i));
        RecyclerView recyclerView2 = recyclerView;
        if (recyclerView == null) {
            recyclerView2 = new RecyclerView(this.e);
            recyclerView2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.g.put(Integer.valueOf(i), recyclerView2);
        }
        return recyclerView2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void b(int i, View view, PayOption._pay_list _pay_listVar) {
        if (i == this.f16211c) {
            this.b = view;
            this.f16211c = i;
            this.f16210a = _pay_listVar;
            return;
        }
        View view2 = this.b;
        if (view2 != null) {
            view2.animate().alpha(0.0f).scaleX(0.9f).scaleY(0.9f).setDuration(70L);
        }
        view.setPivotX(view.getWidth() / 2);
        view.setPivotY(view.getHeight() / 2);
        view.setScaleX(0.9f);
        view.setScaleY(0.9f);
        view.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(70L);
        this.b = view;
        this.f16211c = i;
        this.f16210a = _pay_listVar;
        SelectModelCallBack selectModelCallBack = this.j;
        if (selectModelCallBack != null) {
            selectModelCallBack.a(_pay_listVar);
        }
    }

    private void b(int i) {
        Map<Integer, List<PayOption._pay_list>> map;
        Map<Integer, RecyclerView> map2 = this.g;
        if (map2 == null || map2.get(Integer.valueOf(i)) == null || (map = this.h) == null || this.i == null) {
            return;
        }
        ArrayList arrayList = map.get(Integer.valueOf(i));
        if (arrayList == null) {
            arrayList = new ArrayList();
        } else {
            arrayList.clear();
        }
        int i2 = i * 6;
        while (true) {
            int i3 = i2;
            if (i3 >= (i + 1) * 6 || i3 >= this.f.size()) {
                break;
            }
            if (i3 == this.f16211c) {
                this.f16210a = this.f.get(i3);
            }
            arrayList.add(this.f.get(i3));
            i2 = i3 + 1;
        }
        this.h.put(Integer.valueOf(i), arrayList);
        if (this.i.get(Integer.valueOf(i)) == null) {
            RecyclerView recyclerView = this.g.get(Integer.valueOf(i));
            YYPrePayPriceAdapter yYPrePayPriceAdapter = new YYPrePayPriceAdapter(this.e, this.f16211c, i, 6, new YYPrePayPriceAdapter.SelectItemCallBack() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYPrePayViewPagerAdapter$xnDBQBtt0Kloo_Wovc66rfBJSwc
                @Override // com.blued.android.module.yy_china.adapter.YYPrePayPriceAdapter.SelectItemCallBack
                public final void selectItem(int i4, View view, PayOption._pay_list _pay_listVar) {
                    YYPrePayViewPagerAdapter.this.b(i4, view, _pay_listVar);
                }
            });
            recyclerView.setLayoutManager(new GridLayoutManager(this.e, 3));
            recyclerView.setAdapter(yYPrePayPriceAdapter);
            this.i.put(Integer.valueOf(i), yYPrePayPriceAdapter);
        }
        this.i.get(Integer.valueOf(i)).f16208a = this.f16211c;
        this.i.get(Integer.valueOf(i)).setDataAndNotify(arrayList);
    }

    public void a() {
        if (this.g == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.g.size()) {
                return;
            }
            b(i2);
            i = i2 + 1;
        }
    }

    public void a(ArrayList<Long> arrayList) {
        this.k = arrayList;
        if (this.i == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.i.size()) {
                return;
            }
            if (this.i.get(Integer.valueOf(i2)) != null) {
                this.i.get(Integer.valueOf(i2)).b = arrayList;
            }
            b(i2);
            i = i2 + 1;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<PayOption._pay_list> list = this.f;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return this.f.size() % 6 == 0 ? this.f.size() / 6 : (this.f.size() / 6) + 1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        RecyclerView recyclerView = this.g.get(Integer.valueOf(i));
        RecyclerView recyclerView2 = recyclerView;
        if (recyclerView == null) {
            recyclerView2 = a(i);
        }
        b(i);
        if (recyclerView2.getParent() != null) {
            ((ViewGroup) recyclerView2.getParent()).removeView(recyclerView2);
        }
        viewGroup.addView(recyclerView2);
        return recyclerView2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}

package com.soft.blued.ui.live.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.model.LiveChargeCouponModel;
import com.blued.android.module.live.base.model.PayOption;
import com.soft.blued.ui.pay.adapter.LivePrePayPriceAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/adapter/LivePrePayViewPagerAdapter.class */
public class LivePrePayViewPagerAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public PayOption._pay_list f31101a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public int f31102c;
    private Context e;
    private List<PayOption._pay_list> f;
    private SelectModelCallBack j;
    private LiveChargeCouponModel k;
    private final int d = 6;
    private Map<Integer, RecyclerView> g = new HashMap();
    private Map<Integer, List<PayOption._pay_list>> h = new HashMap();
    private Map<Integer, LivePrePayPriceAdapter> i = new HashMap();

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/adapter/LivePrePayViewPagerAdapter$SelectModelCallBack.class */
    public interface SelectModelCallBack {
        void selectModel(PayOption._pay_list _pay_listVar);
    }

    public LivePrePayViewPagerAdapter(Context context, List<PayOption._pay_list> list, int i, LiveChargeCouponModel liveChargeCouponModel, SelectModelCallBack selectModelCallBack) {
        this.f31102c = 0;
        this.e = context;
        this.f = list;
        this.j = selectModelCallBack;
        this.k = liveChargeCouponModel;
        this.f31102c = i;
    }

    private View a(int i) {
        RecyclerView recyclerView = this.g.get(Integer.valueOf(i));
        RecyclerView recyclerView2 = recyclerView;
        if (recyclerView == null) {
            recyclerView2 = new RecyclerView(this.e);
            recyclerView2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            int a2 = DensityUtils.a(this.e, 12.0f);
            recyclerView2.setPadding(a2, 0, a2, 0);
            recyclerView2.setClipToPadding(false);
            this.g.put(Integer.valueOf(i), recyclerView2);
        }
        return recyclerView2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void b(int i, View view, PayOption._pay_list _pay_listVar) {
        if (i == this.f31102c) {
            this.b = view;
            this.f31102c = i;
            this.f31101a = _pay_listVar;
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
        this.f31102c = i;
        this.f31101a = _pay_listVar;
        SelectModelCallBack selectModelCallBack = this.j;
        if (selectModelCallBack != null) {
            selectModelCallBack.selectModel(_pay_listVar);
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
            if (i3 == this.f31102c) {
                this.f31101a = this.f.get(i3);
            }
            arrayList.add(this.f.get(i3));
            i2 = i3 + 1;
        }
        this.h.put(Integer.valueOf(i), arrayList);
        if (this.i.get(Integer.valueOf(i)) == null) {
            RecyclerView recyclerView = this.g.get(Integer.valueOf(i));
            LivePrePayPriceAdapter livePrePayPriceAdapter = new LivePrePayPriceAdapter(this.e, this.f31102c, i, 6, this.k, new LivePrePayPriceAdapter.SelectItemCallBack() { // from class: com.soft.blued.ui.live.adapter.-$$Lambda$LivePrePayViewPagerAdapter$RPIJ0CGAV5yQb9yIFEAeEeV5g_w
                @Override // com.soft.blued.ui.pay.adapter.LivePrePayPriceAdapter.SelectItemCallBack
                public final void selectItem(int i4, View view, PayOption._pay_list _pay_listVar) {
                    LivePrePayViewPagerAdapter.this.b(i4, view, _pay_listVar);
                }
            });
            recyclerView.setLayoutManager(new GridLayoutManager(this.e, 3));
            recyclerView.setAdapter(livePrePayPriceAdapter);
            this.i.put(Integer.valueOf(i), livePrePayPriceAdapter);
        }
        this.i.get(Integer.valueOf(i)).f32990a = this.f31102c;
        this.i.get(Integer.valueOf(i)).setDataAndNotify(arrayList);
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

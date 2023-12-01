package com.soft.blued.ui.user.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.view.AutoScrollViewPager;
import com.soft.blued.ui.user.adapter.VIPPrivilegeAdapter;
import com.soft.blued.ui.user.model.VIPPrivilegeModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/views/VIPPrivilegePageView.class */
public class VIPPrivilegePageView extends AutoScrollViewPager {

    /* renamed from: a  reason: collision with root package name */
    private Context f34402a;
    private IRequestHost b;

    /* renamed from: c  reason: collision with root package name */
    private List<VIPPrivilegeModel> f34403c;
    private ViewPagerAdapter d;
    private List<View> e;
    private IViewStateListener f;
    private List<VIPPrivilegeAdapter> g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/views/VIPPrivilegePageView$ViewPagerAdapter.class */
    public class ViewPagerAdapter extends PagerAdapter {
        private ViewPagerAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            ((ViewPager) viewGroup).removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return VIPPrivilegePageView.this.e.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            ((ViewPager) viewGroup).addView((View) VIPPrivilegePageView.this.e.get(i));
            return VIPPrivilegePageView.this.e.get(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public VIPPrivilegePageView(Context context) {
        super(context);
        this.e = new ArrayList();
        this.g = new ArrayList();
        this.f34402a = context;
    }

    public VIPPrivilegePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new ArrayList();
        this.g = new ArrayList();
        this.f34402a = context;
    }

    public void a(IRequestHost iRequestHost, List<VIPPrivilegeModel> list) {
        this.b = iRequestHost;
        this.f34403c = list;
    }

    public void d() {
        if (this.f34403c == null) {
            return;
        }
        if (this.d == null) {
            ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter();
            this.d = viewPagerAdapter;
            setAdapter(viewPagerAdapter);
            IViewStateListener iViewStateListener = this.f;
            if (iViewStateListener != null) {
                iViewStateListener.onSetAdapter();
            }
        }
        this.e.clear();
        this.g.clear();
        this.d.notifyDataSetChanged();
        int pageCount = getPageCount();
        int size = this.f34403c.size();
        int i = 4 > size ? size : 4;
        int i2 = 0;
        int i3 = 0;
        while (i2 < pageCount) {
            View inflate = LayoutInflater.from(this.f34402a).inflate(2131559410, (ViewGroup) null);
            GridView gridView = (GridView) inflate.findViewById(2131364131);
            ArrayList arrayList = new ArrayList();
            while (i3 < i) {
                arrayList.add(this.f34403c.get(i3));
                i3++;
            }
            while (arrayList.size() < 4) {
                arrayList.add(null);
            }
            VIPPrivilegeAdapter vIPPrivilegeAdapter = new VIPPrivilegeAdapter(this.f34402a, this.b, arrayList, gridView);
            gridView.setNumColumns(4);
            this.g.add(vIPPrivilegeAdapter);
            gridView.setAdapter((ListAdapter) vIPPrivilegeAdapter);
            this.e.add(inflate);
            int i4 = 4 + (i2 * 4);
            int i5 = i2 + 1;
            int i6 = (i5 * 4) + 4;
            i = i6;
            i2 = i5;
            i3 = i4;
            if (i6 >= size) {
                i = size;
                i2 = i5;
                i3 = i4;
            }
        }
        this.d.notifyDataSetChanged();
    }

    public int getPageCount() {
        return (int) Math.ceil(this.f34403c.size() / 4.0d);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        post(new Runnable() { // from class: com.soft.blued.ui.user.views.VIPPrivilegePageView.1
            @Override // java.lang.Runnable
            public void run() {
                VIPPrivilegePageView.this.d();
            }
        });
    }

    public void setIViewListener(IViewStateListener iViewStateListener) {
        this.f = iViewStateListener;
    }
}

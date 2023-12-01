package com.soft.blued.ui.msg.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.DensityUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.R;
import com.soft.blued.customview.CirclePageIndicator;
import com.soft.blued.customview.SpacesItemDecoration;
import com.soft.blued.ui.msg.model.Selectable;
import com.soft.blued.utils.RecyclerViewUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/fragment/BasePagerGridFragment.class */
public abstract class BasePagerGridFragment<P extends MvpPresenter, A extends BaseQuickAdapter, M extends Selectable> extends MvpFragment<P> {

    /* renamed from: a  reason: collision with root package name */
    protected List<M> f32331a;
    protected FrameLayout[] b;

    /* renamed from: c  reason: collision with root package name */
    protected List<A> f32332c = new ArrayList();
    protected int d;
    protected int e;
    public M f;
    private BasePagerGridFragment<P, A, M>.ViewHolder g;
    private Unbinder k;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/fragment/BasePagerGridFragment$GridPagerAdapter.class */
    public static class GridPagerAdapter extends PagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final FrameLayout[] f32334a;

        public GridPagerAdapter(FrameLayout[] frameLayoutArr) {
            this.f32334a = frameLayoutArr;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(View view, int i, Object obj) {
            ((ViewGroup) view).removeView(this.f32334a[i]);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f32334a.length;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return super.getItemPosition(obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(View view, int i) {
            FrameLayout frameLayout = this.f32334a[i];
            if (frameLayout.getParent() != null) {
                ((ViewGroup) frameLayout.getParent()).removeView(frameLayout);
            }
            ((ViewGroup) view).addView(this.f32334a[i]);
            return frameLayout;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/fragment/BasePagerGridFragment$ViewHolder.class */
    public class ViewHolder {
        @BindView
        public RecyclerView recyclerView;

        ViewHolder() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/fragment/BasePagerGridFragment$ViewHolder_ViewBinding.class */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.recyclerView = (RecyclerView) Utils.a(view, 2131369096, "field 'recyclerView'", RecyclerView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            ViewHolder viewHolder = this.b;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            viewHolder.recyclerView = null;
        }
    }

    private FrameLayout a(int i) {
        View inflate = View.inflate(getContext(), R.layout.item_im_gift_gird, null);
        BasePagerGridFragment<P, A, M>.ViewHolder viewHolder = new ViewHolder();
        this.g = viewHolder;
        this.k = ButterKnife.a(viewHolder, inflate);
        RecyclerView recyclerView = this.g.recyclerView;
        RecyclerViewUtil.a(recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), c()));
        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(0, 0, DensityUtils.a(getContext(), 4.0f), DensityUtils.a(getContext(), 4.0f));
        spacesItemDecoration.a(5);
        recyclerView.addItemDecoration(spacesItemDecoration);
        ArrayList arrayList = new ArrayList();
        if (i != this.d) {
            arrayList.addAll(this.f32331a.subList(this.e, b() * i));
            this.e += b();
        } else {
            List<M> list = this.f32331a;
            arrayList.addAll(list.subList(this.e, list.size()));
        }
        A a2 = a(arrayList);
        this.f32332c.add(a2);
        a2.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.msg.fragment.BasePagerGridFragment.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                if (BasePagerGridFragment.this.f == null || !BasePagerGridFragment.this.f.equals(baseQuickAdapter.getData().get(i2))) {
                    BasePagerGridFragment.this.d();
                    BasePagerGridFragment.this.b((BasePagerGridFragment) ((Selectable) baseQuickAdapter.getData().get(i2)));
                    baseQuickAdapter.notifyItemChanged(i2);
                }
            }
        });
        recyclerView.setAdapter(a2);
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = DensityUtils.a(getContext(), 4.0f);
        layoutParams.rightMargin = DensityUtils.a(getContext(), 4.0f);
        frameLayout.addView(recyclerView, layoutParams);
        return frameLayout;
    }

    protected abstract A a(List<M> list);

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ViewPager viewPager, CirclePageIndicator circlePageIndicator) {
        int i;
        List<M> list = this.f32331a;
        if (list == null) {
            return;
        }
        int size = list.size();
        int b = (size / b()) + (size % b() == 0 ? 0 : 1);
        this.d = b;
        viewPager.setOffscreenPageLimit(b);
        this.b = new FrameLayout[this.d];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            i = this.d;
            if (i3 >= i) {
                break;
            }
            int i4 = i3 + 1;
            this.b[i3] = a(i4);
            i2 = i4;
        }
        if (i <= 1) {
            circlePageIndicator.setVisibility(4);
        } else {
            circlePageIndicator.setVisibility(0);
        }
        viewPager.setAdapter(new GridPagerAdapter(this.b));
        circlePageIndicator.setViewPager(viewPager);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(M m) {
        if (m != null) {
            for (A a2 : this.f32332c) {
                int indexOf = a2.getData().indexOf(m);
                if (indexOf != -1) {
                    a2.notifyItemChanged(indexOf);
                    return;
                }
            }
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void af_() {
        super.af_();
        Unbinder unbinder = this.k;
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b() {
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(M m) {
        this.f = m;
        m.chosen = true;
    }

    protected int c() {
        return 4;
    }

    protected void d() {
        M m = this.f;
        if (m != null) {
            m.chosen = false;
            Iterator<A> it = this.f32332c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                A next = it.next();
                int indexOf = next.getData().indexOf(this.f);
                if (indexOf != -1) {
                    next.notifyItemChanged(indexOf);
                    break;
                }
            }
            this.f = null;
        }
    }

    public void e() {
        b((BasePagerGridFragment<P, A, M>) this.f);
    }
}

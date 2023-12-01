package com.soft.blued.ui.user.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.NetworkUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.view.TabTitleTrackIndicatorWithDot;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.photo.manager.AlbumViewDataManager;
import com.soft.blued.ui.user.adapter.PictureTabAdapter;
import com.soft.blued.ui.user.contract.InterestGalleryContract;
import com.soft.blued.ui.user.model.PictureTabModel;
import com.soft.blued.ui.user.presenter.InterestGalleryPresenter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/InterestGalleryFragment.class */
public class InterestGalleryFragment extends BaseFragment implements PictureTabAdapter.MyItemClickListener, InterestGalleryContract.IView {

    /* renamed from: a  reason: collision with root package name */
    private final int f33866a = 4;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private Context f33867c;
    private TextView d;
    private ImageView e;
    private ViewPager f;
    private PopupWindow g;
    private FrameLayout h;
    private LinearLayout i;
    private NoDataAndLoadFailView j;
    private CommonTopTitleNoTrans k;
    private TabTitleTrackIndicatorWithDot l;
    private InterestGalleryContract.IPresenter m;
    private PictureTabAdapter n;
    private TabIndicatorAdapter o;
    private String p;
    private List<PictureTabModel> q;
    private int r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/InterestGalleryFragment$GridItemSpaceDecoration.class */
    public class GridItemSpaceDecoration extends RecyclerView.ItemDecoration {
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f33875c;

        public GridItemSpaceDecoration(int i, int i2) {
            this.b = i;
            this.f33875c = i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int i = this.b;
            int i2 = childAdapterPosition % i;
            rect.left = (this.f33875c * i2) / i;
            int i3 = this.f33875c;
            rect.right = i3 - (((i2 + 1) * i3) / this.b);
            if (childAdapterPosition >= this.b) {
                rect.top = this.f33875c * 2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/InterestGalleryFragment$TabIndicatorAdapter.class */
    public class TabIndicatorAdapter extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        PicturesWallFragment f33876a;

        public TabIndicatorAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public PicturesWallFragment a() {
            return this.f33876a;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        /* renamed from: a */
        public PicturesWallFragment getItem(int i) {
            return PicturesWallFragment.a(((PictureTabModel) InterestGalleryFragment.this.q.get(i)).classify_id + "");
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (InterestGalleryFragment.this.q == null) {
                return 0;
            }
            return InterestGalleryFragment.this.q.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return ((PictureTabModel) InterestGalleryFragment.this.q.get(i)).name;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (obj instanceof PicturesWallFragment) {
                this.f33876a = (PicturesWallFragment) obj;
            }
        }
    }

    private void a(View view) {
        if (this.b == null) {
            return;
        }
        this.q = new ArrayList();
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(R.id.cttnt_title);
        this.k = commonTopTitleNoTrans;
        commonTopTitleNoTrans.setCenterText(R.string.interest_gallery);
        this.k.setLeftImg(2131233902);
        this.k.a();
        this.k.setCenterClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.InterestGalleryFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                if (InterestGalleryFragment.this.o == null || InterestGalleryFragment.this.o.a() == null) {
                    return;
                }
                InterestGalleryFragment.this.o.a().h();
            }
        });
        this.k.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.InterestGalleryFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                ((Activity) InterestGalleryFragment.this.f33867c).finish();
            }
        });
        this.d = (TextView) view.findViewById(R.id.tv_divider);
        this.i = (LinearLayout) view.findViewById(2131363930);
        this.h = (FrameLayout) view.findViewById(R.id.fl_progress);
        this.e = (ImageView) view.findViewById(R.id.iv_open_tabs);
        this.f = (ViewPager) view.findViewById(R.id.vp_picture_pages);
        this.l = (TabTitleTrackIndicatorWithDot) view.findViewById(R.id.tttiwd_picture_tabs);
        this.j = (NoDataAndLoadFailView) view.findViewById(R.id.ll_no_internet);
        TabIndicatorAdapter tabIndicatorAdapter = new TabIndicatorAdapter(getFragmentManager());
        this.o = tabIndicatorAdapter;
        this.f.setAdapter(tabIndicatorAdapter);
        this.l.setViewPager(this.f);
        b();
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.InterestGalleryFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                InterestGalleryFragment.this.g.showAsDropDown(InterestGalleryFragment.this.k);
            }
        });
        this.f.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.user.fragment.InterestGalleryFragment.4
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                InterestGalleryFragment.this.r = i;
            }
        });
    }

    private void b() {
        View inflate = LayoutInflater.from(this.f33867c).inflate(R.layout.pop_window_interest_pictures_tab, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(2131365207);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.rv_tab_grid);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f33867c, 4);
        GridItemSpaceDecoration gridItemSpaceDecoration = new GridItemSpaceDecoration(4, DensityUtils.a(this.f33867c, 7.5f));
        PopupWindow popupWindow = new PopupWindow(-1, -2);
        this.g = popupWindow;
        popupWindow.setContentView(inflate);
        this.g.setTouchable(true);
        this.g.setFocusable(true);
        this.g.setBackgroundDrawable(new BitmapDrawable());
        this.g.setOutsideTouchable(true);
        this.g.update();
        PictureTabAdapter pictureTabAdapter = new PictureTabAdapter(this.f33867c, this.q);
        this.n = pictureTabAdapter;
        recyclerView.setAdapter(pictureTabAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addItemDecoration(gridItemSpaceDecoration);
        this.n.a(this);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.InterestGalleryFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                InterestGalleryFragment.this.g.dismiss();
            }
        });
        this.g.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.soft.blued.ui.user.fragment.InterestGalleryFragment.6
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                InterestGalleryFragment.this.f.setCurrentItem(InterestGalleryFragment.this.r);
            }
        });
    }

    @Override // com.soft.blued.ui.user.contract.InterestGalleryContract.IView
    public void a() {
        this.h.setVisibility(8);
        if (NetworkUtils.b()) {
            this.d.setVisibility(0);
            this.i.setVisibility(0);
            this.f.setVisibility(0);
            this.j.d();
            return;
        }
        this.d.setVisibility(8);
        this.i.setVisibility(8);
        this.f.setVisibility(8);
        this.j.b();
    }

    @Override // com.soft.blued.ui.user.adapter.PictureTabAdapter.MyItemClickListener
    public void a(View view, int i) {
        this.r = i;
        this.g.dismiss();
    }

    @Override // com.soft.blued.ui.user.contract.InterestGalleryContract.IView
    public void a(List<PictureTabModel> list) {
        this.q.clear();
        this.q.addAll(list);
        this.o.notifyDataSetChanged();
        this.l.a();
        this.n.notifyDataSetChanged();
        if (list.size() == 1) {
            this.i.setVisibility(8);
        } else {
            this.i.setVisibility(0);
        }
        for (int i = 0; i < this.q.size(); i++) {
            if (Integer.parseInt(this.p) == this.q.get(i).classify_id) {
                this.r = i;
                this.f.setCurrentItem(i);
                return;
            }
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f33867c = context;
        if (getArguments() != null) {
            this.p = getArguments().getString("tab_id", "0");
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        InstantLog.a("picture_lib_in");
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = layoutInflater.inflate(R.layout.fragment_interest_gallery, viewGroup, false);
        this.m = new InterestGalleryPresenter(this, getFragmentActive());
        a(this.b);
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AlbumViewDataManager.a().a(false);
        InstantLog.a("picture_lib_out");
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.m.ar_();
    }
}

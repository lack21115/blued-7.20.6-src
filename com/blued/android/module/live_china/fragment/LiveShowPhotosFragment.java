package com.blued.android.module.live_china.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveShowPhotoAdapter;
import com.blued.android.module.live_china.adapter.PhotoFolderAdapter;
import com.blued.android.module.live_china.presenter.LiveShowPhotosPresenter;
import com.blued.android.module.live_china.same.Logger;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveShowPhotosFragment.class */
public class LiveShowPhotosFragment extends MvpFragment<LiveShowPhotosPresenter> implements View.OnClickListener {
    TextView a;
    LinearLayout b;
    RecyclerView c;
    LinearLayout d;
    TextView e;
    SmartRefreshLayout f;
    ListView g;
    TextView k;
    TextView l;
    private PhotoFolderAdapter m;
    private LiveShowPhotoAdapter n;
    private int o;

    private ValueAnimator a(int i, int i2) {
        this.g.clearAnimation();
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.fragment.LiveShowPhotosFragment.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                Logger.d("LiveShowPhotosFragment", "onAnimationUpdate value = " + intValue);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) LiveShowPhotosFragment.this.g.getLayoutParams();
                layoutParams.height = intValue;
                LiveShowPhotosFragment.this.g.setLayoutParams(layoutParams);
            }
        });
        ofInt.setDuration(300L);
        ofInt.setInterpolator(new LinearInterpolator());
        return ofInt;
    }

    private void b() {
        PhotoFolderAdapter photoFolderAdapter = new PhotoFolderAdapter(j().m());
        this.m = photoFolderAdapter;
        this.g.setAdapter((ListAdapter) photoFolderAdapter);
        this.g.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveShowPhotosFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Tracker.onItemClick(adapterView, view, i, j);
                LiveShowPhotosFragment.this.e.setText(LiveShowPhotosFragment.this.j().m().get(i));
                LiveShowPhotosFragment.this.n.a();
                LiveShowPhotosFragment.this.n.a(i);
                if (i == 0) {
                    LiveShowPhotosFragment.this.f.c(false);
                } else {
                    LiveShowPhotosFragment.this.f.c(true);
                }
                LiveShowPhotosFragment.this.j().b(i);
                LiveShowPhotosFragment.this.d();
            }
        });
    }

    private void c() {
        this.g.measure(0, 0);
        int measuredHeight = this.g.getMeasuredHeight();
        ((RelativeLayout.LayoutParams) this.g.getLayoutParams()).height = 1;
        this.g.setVisibility(0);
        a(1, measuredHeight).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.g.measure(0, 0);
        ValueAnimator a = a(this.g.getMeasuredHeight(), 0);
        a.addListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.fragment.LiveShowPhotosFragment.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LiveShowPhotosFragment.this.g.setVisibility(8);
            }
        });
        a.start();
    }

    private void d(List<String> list) {
        this.d.setVisibility(8);
        this.c.setVisibility(0);
        this.n.setNewData(list);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.a = (TextView) this.i.findViewById(R.id.tv_cancel);
        this.b = (LinearLayout) this.i.findViewById(R.id.ll_center_view);
        this.c = this.i.findViewById(R.id.rv_photos);
        this.d = (LinearLayout) this.i.findViewById(R.id.no_data_view);
        this.e = (TextView) this.i.findViewById(R.id.tv_folder_name);
        this.f = this.i.findViewById(R.id.refresh_layout);
        this.g = (ListView) this.i.findViewById(R.id.folder_list);
        this.k = (TextView) this.i.findViewById(R.id.no_data_retry);
        this.l = (TextView) this.i.findViewById(R.id.no_data_text);
        this.a.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.k.setOnClickListener(this);
        b();
        this.f.a(new OnRefreshLoadMoreListener() { // from class: com.blued.android.module.live_china.fragment.LiveShowPhotosFragment.1
            public void onLoadMore(RefreshLayout refreshLayout) {
                LiveShowPhotosFragment.this.j().f();
            }

            public void onRefresh(RefreshLayout refreshLayout) {
                LiveShowPhotosFragment.this.j().e();
            }
        });
        this.n = new LiveShowPhotoAdapter(this);
        this.c.setLayoutManager(new GridLayoutManager(getContext(), 3));
        this.c.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.blued.android.module.live_china.fragment.LiveShowPhotosFragment.2
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                rect.left = LiveShowPhotosFragment.this.o;
                rect.top = LiveShowPhotosFragment.this.o;
                if (recyclerView.getChildLayoutPosition(view) % 3 == 0) {
                    rect.left = 0;
                }
            }
        });
        this.c.setAdapter(this.n);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, boolean z) {
        boolean z2;
        super.a(str, z);
        Logger.d("LiveShowPhotosFragment", "dismissDataLoading ... ");
        int hashCode = str.hashCode();
        if (hashCode != -1290256561) {
            if (hashCode == 623698297 && str.equals("_load_type_loadmore_")) {
                z2 = true;
            }
            z2 = true;
        } else {
            if (str.equals("_load_type_refresh_")) {
                z2 = false;
            }
            z2 = true;
        }
        if (!z2) {
            this.f.g();
        } else if (z2) {
            this.f.h();
        }
        LiveShowPhotoAdapter liveShowPhotoAdapter = this.n;
        if (liveShowPhotoAdapter == null || liveShowPhotoAdapter.getItemCount() <= 0) {
            this.d.setVisibility(0);
            this.c.setVisibility(8);
            if (z) {
                this.k.setVisibility(8);
                this.l.setVisibility(0);
                return;
            }
            this.k.setVisibility(0);
            this.l.setVisibility(8);
        }
    }

    public void a(List<String> list) {
        d(list);
    }

    public void b(List<String> list) {
        d(list);
    }

    public void c(List<String> list) {
        this.n.a();
        d(list);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_live_show_photos;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void o() {
        super.o();
        Logger.d("LiveShowPhotosFragment", "enableLoadMore ... ");
        this.f.b(true);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f.c(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.tv_cancel) {
            LiveEventBus.get("live_dialog_cancel").post("cancel");
        } else if (view.getId() != R.id.ll_center_view) {
            if (view.getId() == R.id.no_data_retry) {
                j().e();
            }
        } else if (this.g.getVisibility() == 0) {
            d();
        } else {
            c();
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.o = DisplayUtil.a(AppInfo.d(), 3.0f);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void p() {
        super.p();
        Logger.d("LiveShowPhotosFragment", "disableLoadMore ... ");
        this.f.b(false);
    }
}

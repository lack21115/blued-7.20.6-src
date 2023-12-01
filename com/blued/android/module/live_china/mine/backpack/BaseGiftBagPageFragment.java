package com.blued.android.module.live_china.mine.backpack;

import android.view.View;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.blued.android.framework.ui.SimpleFragment;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.R;
import com.blued.android.module.common.adapter.BaseGiftAdapter;
import com.blued.android.module.common.event.CommonGiftPageChangeEvent;
import com.blued.android.module.common.model.BaseGiftModel;
import com.blued.android.module.common.model.CommonGiftPackageModel;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/backpack/BaseGiftBagPageFragment.class */
public abstract class BaseGiftBagPageFragment<T extends BaseGiftModel> extends SimpleFragment {

    /* renamed from: a  reason: collision with root package name */
    protected RecyclerView f13883a;
    protected BaseGiftAdapter b;

    /* renamed from: c  reason: collision with root package name */
    protected View f13884c;
    protected String e;
    protected final List<T> d = new ArrayList();
    protected int f = 0;
    protected int g = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        List a2 = b().a(this.f);
        this.d.clear();
        if (a2 != null) {
            this.d.addAll(a2);
        }
        LogUtils.c("packageIndex: " + this.e + ", pageIndex: " + this.f + ", dataList.size:" + this.d.size());
        d();
        this.b.setDataAndNotify(this.d);
        if (this.d.isEmpty()) {
            this.f13884c.setVisibility(0);
        } else {
            this.f13884c.setVisibility(8);
        }
    }

    private void d() {
        CommonGiftPackageModel c2 = b().c();
        if (c2 != null) {
            RecyclerView.LayoutManager layoutManager = this.f13883a.getLayoutManager();
            if (layoutManager == null) {
                this.f13883a.setLayoutManager(a(c2));
            }
            if (layoutManager instanceof GridLayoutManager) {
                ((GridLayoutManager) layoutManager).setSpanCount(c2.getColumn());
            }
        }
    }

    protected RecyclerView.LayoutManager a(CommonGiftPackageModel commonGiftPackageModel) {
        return new GridLayoutManager(getContext(), commonGiftPackageModel.getColumn(), 1, false);
    }

    public abstract void a();

    protected BaseGiftBagParentFragment b() {
        return (BaseGiftBagParentFragment) getParentFragment();
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        return b().onBackPressed();
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onInitListener() {
        super.onInitListener();
        LiveEventBus.get("gift_page_change", CommonGiftPageChangeEvent.class).observe(this, new Observer<CommonGiftPageChangeEvent>() { // from class: com.blued.android.module.live_china.mine.backpack.BaseGiftBagPageFragment.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(CommonGiftPageChangeEvent commonGiftPageChangeEvent) {
                if (commonGiftPageChangeEvent != null && BaseGiftBagPageFragment.this.g == commonGiftPageChangeEvent.packageTabIndex && BaseGiftBagPageFragment.this.f == commonGiftPageChangeEvent.pageIndex) {
                    LogUtils.c("GIFT_PAGE_CHANGE: " + BaseGiftBagPageFragment.this.f);
                    BaseGiftBagPageFragment.this.c();
                }
            }
        });
        LiveEventBus.get("gift_page_data_change", Object.class).observe(this, new Observer<Object>() { // from class: com.blued.android.module.live_china.mine.backpack.BaseGiftBagPageFragment.2
            @Override // androidx.lifecycle.Observer
            public void onChanged(Object obj) {
                LogUtils.c("GIFT_PAGE_DATA_CHANGE: " + BaseGiftBagPageFragment.this.f);
                BaseGiftBagPageFragment.this.c();
            }
        });
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onInitView() {
        super.onInitView();
        this.f13883a = (RecyclerView) this.rootView.findViewById(R.id.base_gift_page_grid);
        a();
        this.f13883a.setAdapter(this.b);
        if (this.f13883a.getItemAnimator() != null) {
            ((SimpleItemAnimator) this.f13883a.getItemAnimator()).setSupportsChangeAnimations(false);
        }
        View findViewById = this.rootView.findViewById(R.id.base_gift_page_no_data_layout);
        this.f13884c = findViewById;
        findViewById.setVisibility(0);
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onLoadData() {
        super.onLoadData();
        c();
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onParseArguments() {
        super.onParseArguments();
        this.e = this.args.getString("package_index");
        this.f = this.args.getInt("gift_index");
        this.g = this.args.getInt("package_tab_index");
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public int onSetRootViewId() {
        return R.layout.fragment_base_gift_page;
    }
}

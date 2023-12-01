package com.blued.android.module.live_china.mine.backpack;

import android.view.View;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
    protected RecyclerView a;
    protected BaseGiftAdapter b;
    protected View c;
    protected String e;
    protected final List<T> d = new ArrayList();
    protected int f = 0;
    protected int g = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        List a = b().a(this.f);
        this.d.clear();
        if (a != null) {
            this.d.addAll(a);
        }
        LogUtils.c("packageIndex: " + this.e + ", pageIndex: " + this.f + ", dataList.size:" + this.d.size());
        d();
        this.b.setDataAndNotify(this.d);
        if (this.d.isEmpty()) {
            this.c.setVisibility(0);
        } else {
            this.c.setVisibility(8);
        }
    }

    private void d() {
        CommonGiftPackageModel c = b().c();
        if (c != null) {
            GridLayoutManager layoutManager = this.a.getLayoutManager();
            if (layoutManager == null) {
                this.a.setLayoutManager(a(c));
            }
            if (layoutManager instanceof GridLayoutManager) {
                layoutManager.setSpanCount(c.getColumn());
            }
        }
    }

    protected RecyclerView.LayoutManager a(CommonGiftPackageModel commonGiftPackageModel) {
        return new GridLayoutManager(getContext(), commonGiftPackageModel.getColumn(), 1, false);
    }

    public abstract void a();

    protected BaseGiftBagParentFragment b() {
        return getParentFragment();
    }

    public boolean onBackPressed() {
        return b().onBackPressed();
    }

    public void onInitListener() {
        super.onInitListener();
        LiveEventBus.get("gift_page_change", CommonGiftPageChangeEvent.class).observe(this, new Observer<CommonGiftPageChangeEvent>() { // from class: com.blued.android.module.live_china.mine.backpack.BaseGiftBagPageFragment.1
            /* renamed from: a */
            public void onChanged(CommonGiftPageChangeEvent commonGiftPageChangeEvent) {
                if (commonGiftPageChangeEvent != null && BaseGiftBagPageFragment.this.g == commonGiftPageChangeEvent.packageTabIndex && BaseGiftBagPageFragment.this.f == commonGiftPageChangeEvent.pageIndex) {
                    LogUtils.c("GIFT_PAGE_CHANGE: " + BaseGiftBagPageFragment.this.f);
                    BaseGiftBagPageFragment.this.c();
                }
            }
        });
        LiveEventBus.get("gift_page_data_change", Object.class).observe(this, new Observer<Object>() { // from class: com.blued.android.module.live_china.mine.backpack.BaseGiftBagPageFragment.2
            public void onChanged(Object obj) {
                LogUtils.c("GIFT_PAGE_DATA_CHANGE: " + BaseGiftBagPageFragment.this.f);
                BaseGiftBagPageFragment.this.c();
            }
        });
    }

    public void onInitView() {
        super.onInitView();
        this.a = this.rootView.findViewById(R.id.base_gift_page_grid);
        a();
        this.a.setAdapter(this.b);
        if (this.a.getItemAnimator() != null) {
            this.a.getItemAnimator().setSupportsChangeAnimations(false);
        }
        View findViewById = this.rootView.findViewById(R.id.base_gift_page_no_data_layout);
        this.c = findViewById;
        findViewById.setVisibility(0);
    }

    public void onLoadData() {
        super.onLoadData();
        c();
    }

    public void onParseArguments() {
        super.onParseArguments();
        this.e = this.args.getString("package_index");
        this.f = this.args.getInt("gift_index");
        this.g = this.args.getInt("package_tab_index");
    }

    public int onSetRootViewId() {
        return R.layout.fragment_base_gift_page;
    }
}

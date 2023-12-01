package com.blued.android.module.common.fragment;

import android.view.View;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.ui.SimpleFragment;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.R;
import com.blued.android.module.common.adapter.BaseGiftAdapter;
import com.blued.android.module.common.event.CommonGiftPageChangeEvent;
import com.blued.android.module.common.event.GiftItemChangeEvent;
import com.blued.android.module.common.model.BaseGiftModel;
import com.blued.android.module.common.model.CommonGiftPackageModel;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/fragment/BaseGiftPageFragment.class */
public abstract class BaseGiftPageFragment<T extends BaseGiftModel> extends SimpleFragment {
    public RecyclerView a;
    public BaseGiftAdapter b;
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

    protected BaseGiftParentFragment b() {
        return getParentFragment();
    }

    public boolean onBackPressed() {
        return b().onBackPressed();
    }

    public void onInitListener() {
        super.onInitListener();
        LiveEventBus.get("gift_page_change", CommonGiftPageChangeEvent.class).observe(this, new Observer<CommonGiftPageChangeEvent>() { // from class: com.blued.android.module.common.fragment.BaseGiftPageFragment.1
            /* renamed from: a */
            public void onChanged(CommonGiftPageChangeEvent commonGiftPageChangeEvent) {
                if (commonGiftPageChangeEvent != null && BaseGiftPageFragment.this.g == commonGiftPageChangeEvent.packageTabIndex && BaseGiftPageFragment.this.f == commonGiftPageChangeEvent.pageIndex) {
                    LogUtils.c("GIFT_PAGE_CHANGE: " + BaseGiftPageFragment.this.f);
                    BaseGiftPageFragment.this.c();
                }
            }
        });
        LiveEventBus.get("gift_page_data_change", Object.class).observe(this, new Observer<Object>() { // from class: com.blued.android.module.common.fragment.BaseGiftPageFragment.2
            public void onChanged(Object obj) {
                LogUtils.c("GIFT_PAGE_DATA_CHANGE: " + BaseGiftPageFragment.this.f);
                BaseGiftPageFragment.this.c();
            }
        });
        LiveEventBus.get("gift_item_update_by_root", GiftItemChangeEvent.class).observe(this, new Observer<GiftItemChangeEvent>() { // from class: com.blued.android.module.common.fragment.BaseGiftPageFragment.3
            /* renamed from: a */
            public void onChanged(GiftItemChangeEvent giftItemChangeEvent) {
                if (giftItemChangeEvent == null || BaseGiftPageFragment.this.g != giftItemChangeEvent.packageTabIndex || BaseGiftPageFragment.this.f != giftItemChangeEvent.pageIndex || giftItemChangeEvent.giftModel == null) {
                    return;
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= BaseGiftPageFragment.this.d.size()) {
                        return;
                    }
                    if (StringUtils.a(BaseGiftPageFragment.this.d.get(i2).index, giftItemChangeEvent.giftModel.index)) {
                        BaseGiftPageFragment.this.b.updateItemAndNotify(i2, giftItemChangeEvent.giftModel);
                        LogUtils.c("GIFT_ITEM_UPDATE_BY_ROOT: " + giftItemChangeEvent.giftModel.index);
                        return;
                    }
                    i = i2 + 1;
                }
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

package com.blued.android.module.common.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.R;
import com.blued.android.module.common.event.CommonGiftPageChangeEvent;
import com.blued.android.module.common.model.BaseGiftModel;
import com.blued.android.module.common.model.CommonGiftPackageModel;
import com.blued.android.module.common.view.LiveGiftIndicatorView;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/fragment/BaseGiftParentFragment.class */
public abstract class BaseGiftParentFragment<T extends BaseGiftModel> extends BaseViewPagerParentFragment {

    /* renamed from: a  reason: collision with root package name */
    public LiveGiftIndicatorView f10808a;
    protected View b;

    /* renamed from: c  reason: collision with root package name */
    protected ImageView f10809c;
    protected TextView d;
    public String e;
    protected int f = 0;
    protected boolean g = true;

    private int a(CommonGiftPackageModel commonGiftPackageModel) {
        if (commonGiftPackageModel == null || commonGiftPackageModel.goods.size() <= 0) {
            return 0;
        }
        return (int) Math.ceil(commonGiftPackageModel.goods.size() / (commonGiftPackageModel.getColumn() * commonGiftPackageModel.getLine()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(CommonGiftPageChangeEvent commonGiftPageChangeEvent) {
        if (commonGiftPageChangeEvent == null || this.f != commonGiftPageChangeEvent.packageTabIndex) {
            return;
        }
        this.h.setCurrentItem(commonGiftPageChangeEvent.pageIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        if (str == null || !str.equalsIgnoreCase(this.e)) {
            return;
        }
        this.h.setCurrentItem(0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str) {
        if (str == null || !str.equals(this.e)) {
            return;
        }
        LogUtils.c("GIFT_PACKAGE_CHANGE: " + str);
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str) {
        LogUtils.c("GIFT_DATA_CHANGE: " + str);
        a();
    }

    protected abstract BaseFragment a(int i, @Nonnull Bundle bundle);

    public List a(int i) {
        ArrayList arrayList = new ArrayList();
        if (d().b.size() > this.f) {
            CommonGiftPackageModel commonGiftPackageModel = (CommonGiftPackageModel) d().b.get(this.f);
            int column = commonGiftPackageModel.getColumn() * commonGiftPackageModel.getLine();
            int i2 = i * column;
            while (true) {
                int i3 = i2;
                if (i3 >= commonGiftPackageModel.goods.size()) {
                    break;
                }
                arrayList.add(commonGiftPackageModel.goods.get(i3));
                if (arrayList.size() == column) {
                    return arrayList;
                }
                i2 = i3 + 1;
            }
        }
        return arrayList;
    }

    @Override // com.blued.android.module.common.fragment.BaseViewPagerParentFragment
    protected void a() {
        CommonGiftPackageModel c2 = c();
        if (c2 != null) {
            int a2 = a(c2);
            LogUtils.c("packageIndex: " + this.e + ", goods.size:" + c2.goods.size() + ", getPageCount: " + a2 + ", fragmentCount:" + this.j.size() + ", getCurrentItem:" + this.h.getCurrentItem());
            if (a2 > this.j.size()) {
                int size = this.j.size();
                while (true) {
                    int i = size;
                    if (i >= a2) {
                        break;
                    }
                    this.j.add(b(i));
                    this.k.add(String.valueOf(i));
                    size = i + 1;
                }
            } else if (this.j.size() > a2) {
                int size2 = this.j.size();
                while (true) {
                    int i2 = size2 - 1;
                    if (i2 < a2) {
                        break;
                    }
                    this.j.remove(i2);
                    size2 = i2;
                }
            }
            this.f10808a.a(a2);
            this.f10808a.setIndicatorCount(a2);
            if (!this.g) {
                this.f10808a.setVisibility(8);
            } else if (a2 < 1) {
                this.f10808a.setVisibility(4);
            } else {
                this.f10808a.setVisibility(0);
            }
            LiveEventBus.get("gift_page_data_change").post(null);
        } else {
            this.j.clear();
        }
        e();
        if (this.j.size() != 0) {
            this.b.setVisibility(8);
            return;
        }
        b();
        this.b.setVisibility(0);
    }

    public void a(boolean z) {
        LogUtils.c("size; " + this.j.size());
        if (this.j.size() > 0) {
            this.h.setCurrentItem(0, z);
        }
    }

    @Override // com.blued.android.module.common.fragment.BaseViewPagerParentFragment
    protected BaseFragment b(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("gift_index", i);
        bundle.putString("package_index", this.e);
        bundle.putInt("package_tab_index", this.f);
        BaseFragment a2 = a(i, bundle);
        a2.setArguments(bundle);
        LogUtils.c("instanceFragment: " + this.e + BridgeUtil.UNDERLINE_STR + i);
        return a2;
    }

    public void b() {
    }

    public void b(boolean z) {
        LogUtils.c("size; " + this.j.size());
        if (this.j.size() > 0) {
            this.h.setCurrentItem(this.j.size() - 1, z);
        }
    }

    public CommonGiftPackageModel c() {
        if (d().b.size() > this.f) {
            return (CommonGiftPackageModel) d().b.get(this.f);
        }
        return null;
    }

    protected BaseGiftRootFragment d() {
        return (BaseGiftRootFragment) getParentFragment();
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        LogUtils.c("");
        return d().onBackPressed();
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onInitListener() {
        super.onInitListener();
        LiveEventBus.get("gift_data_change", String.class).observe(this, new Observer() { // from class: com.blued.android.module.common.fragment.-$$Lambda$BaseGiftParentFragment$RIR5xFkYD59EHSU5gIvZaY1mvEQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseGiftParentFragment.this.c((String) obj);
            }
        });
        LiveEventBus.get("gift_package_change", String.class).observe(this, new Observer() { // from class: com.blued.android.module.common.fragment.-$$Lambda$BaseGiftParentFragment$e1zorwy6vEJtdiU2EAIzC5WgWcM
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseGiftParentFragment.this.b((String) obj);
            }
        });
        LiveEventBus.get("gift_package_selected", String.class).observe(this, new Observer() { // from class: com.blued.android.module.common.fragment.-$$Lambda$BaseGiftParentFragment$y_OrFL8cQZ0Z11ZvJQmodQkx_7Q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseGiftParentFragment.this.a((String) obj);
            }
        });
        LiveEventBus.get("gift_page_selected", CommonGiftPageChangeEvent.class).observe(this, new Observer() { // from class: com.blued.android.module.common.fragment.-$$Lambda$BaseGiftParentFragment$eRzrsgYHdBgNoAZt0CplPfq_H0M
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseGiftParentFragment.this.a((CommonGiftPageChangeEvent) obj);
            }
        });
    }

    @Override // com.blued.android.module.common.fragment.BaseViewPagerParentFragment, com.blued.android.framework.ui.SimpleFragment
    public void onInitView() {
        super.onInitView();
        LiveGiftIndicatorView liveGiftIndicatorView = (LiveGiftIndicatorView) this.rootView.findViewById(R.id.base_gift_indicator_view);
        this.f10808a = liveGiftIndicatorView;
        if (this.g) {
            liveGiftIndicatorView.setVisibility(0);
        } else {
            liveGiftIndicatorView.setVisibility(8);
        }
        this.b = this.rootView.findViewById(R.id.base_gift_parent_no_data_layout);
        this.f10809c = (ImageView) this.rootView.findViewById(R.id.base_gift_parent_no_data_iv);
        this.d = (TextView) this.rootView.findViewById(R.id.base_gift_parent_no_data_tv);
        this.h.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.common.fragment.BaseGiftParentFragment.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                BaseGiftParentFragment.this.f10808a.b(i);
            }
        });
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onLoadData() {
        super.onLoadData();
        a();
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onParseArguments() {
        this.e = this.args.getString("package_index");
        this.f = this.args.getInt("package_tab_index");
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public int onSetRootViewId() {
        return R.layout.fragment_base_gift_parent;
    }
}

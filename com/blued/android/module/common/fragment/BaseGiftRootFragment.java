package com.blued.android.module.common.fragment;

import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.R;
import com.blued.android.module.common.event.CommonGiftPageChangeEvent;
import com.blued.android.module.common.event.GiftItemChangeEvent;
import com.blued.android.module.common.model.BaseGiftModel;
import com.blued.android.module.common.model.CommonGiftPackageModel;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.view.CommonGiftTabView;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.OverridingMethodsMustInvokeSuper;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/fragment/BaseGiftRootFragment.class */
public abstract class BaseGiftRootFragment<T extends CommonGiftPackageModel> extends BaseViewPagerParentFragment {

    /* renamed from: a  reason: collision with root package name */
    protected CommonGiftTabView f10811a;

    /* renamed from: c  reason: collision with root package name */
    public String f10812c;
    protected final List<T> b = new ArrayList();
    protected int d = 0;
    protected boolean e = false;
    protected String f = null;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(BaseGiftModel baseGiftModel) {
        if (baseGiftModel == null || baseGiftModel.index == null) {
            return;
        }
        String[] split = baseGiftModel.index.split(BridgeUtil.UNDERLINE_STR);
        if (split.length > 1) {
            int a2 = CommonStringUtils.a(split[0]);
            int a3 = CommonStringUtils.a(split[1]);
            LogUtils.c("GIFT_ITEM_UPDATE: " + baseGiftModel.index);
            if (this.b.size() <= a2 || this.b.get(a2).goods.size() <= a3) {
                return;
            }
            BaseGiftModel baseGiftModel2 = (BaseGiftModel) this.b.get(a2).goods.get(a3);
            if (StringUtils.a(baseGiftModel2.getCompareParam(), baseGiftModel.getCompareParam())) {
                if (!this.b.get(a2).deleteItemIfZeroCount || baseGiftModel2.getDeleteItemCount() > 0) {
                    this.b.get(a2).goods.set(a3, baseGiftModel);
                    LiveEventBus.get("gift_item_update_by_root").post(new GiftItemChangeEvent(a2, a(a2, a3), baseGiftModel));
                    return;
                }
                this.b.get(a2).goods.remove(a3);
                LogUtils.c("GIFT_ITEM_UPDATE: remove " + baseGiftModel.index);
                this.f10812c = null;
                a(this.b.get(a2));
                LiveEventBus.get("gift_package_change").post(this.b.get(a2).index);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z) {
        if (str == null) {
            return;
        }
        String str2 = this.f10812c;
        if (str2 != null) {
            String[] split = str2.split(BridgeUtil.UNDERLINE_STR);
            if (split.length > 1) {
                int a2 = CommonStringUtils.a(split[0]);
                int a3 = CommonStringUtils.a(split[1]);
                if (this.b.size() > a2 && this.b.get(a2).goods.size() > a3) {
                    ((BaseGiftModel) this.b.get(a2).goods.get(a3)).isSelected = false;
                    LiveEventBus.get("gift_page_change").post(new CommonGiftPageChangeEvent(a2, a(a2, a3)));
                    LogUtils.c("Uncheck: " + a2 + ", " + a3);
                }
            }
        }
        this.f10812c = str;
        String[] split2 = str.split(BridgeUtil.UNDERLINE_STR);
        if (split2.length > 1) {
            int a4 = CommonStringUtils.a(split2[0]);
            int a5 = CommonStringUtils.a(split2[1]);
            if (this.b.size() > a4 && this.b.get(a4).goods.size() > a5) {
                BaseGiftModel baseGiftModel = (BaseGiftModel) this.b.get(a4).goods.get(a5);
                if (!baseGiftModel.isSelected) {
                    baseGiftModel.isSelected = true;
                    LiveEventBus.get("gift_page_change").post(new CommonGiftPageChangeEvent(a4, a(a4, a5)));
                    LiveEventBus.get("gift_page_selected").post(new CommonGiftPageChangeEvent(a4, a(a4, a5)));
                    LogUtils.c("Checked: " + a4 + ", " + a5);
                    a(baseGiftModel, z);
                }
            }
            if (a4 < this.b.size()) {
                this.h.setCurrentItem(a4, false);
                this.f10811a.setToolBtnSelect(a4);
            }
        }
    }

    public int a(int i, int i2) {
        if (i >= this.b.size() || i2 >= this.b.get(i).goods.size()) {
            return -1;
        }
        return i2 / (this.b.get(i).getLine() * this.b.get(i).getColumn());
    }

    protected abstract BaseFragment a(CommonGiftPackageModel commonGiftPackageModel, @Nonnull Bundle bundle);

    public BaseGiftModel a(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(BridgeUtil.UNDERLINE_STR);
        if (split.length > 1) {
            int a2 = CommonStringUtils.a(split[0]);
            int a3 = CommonStringUtils.a(split[1]);
            if (this.b.size() <= a2 || this.b.get(a2).goods.size() <= a3) {
                return null;
            }
            return (BaseGiftModel) this.b.get(a2).goods.get(a3);
        }
        return null;
    }

    public void a(int i) {
        CommonGiftTabView commonGiftTabView = this.f10811a;
        if (commonGiftTabView != null) {
            commonGiftTabView.a(i);
        }
    }

    public void a(BaseGiftModel baseGiftModel, boolean z) {
    }

    public void a(CommonGiftPackageModel commonGiftPackageModel) {
        if (commonGiftPackageModel != null) {
            LogUtils.c("setGoodsIndexes:" + commonGiftPackageModel.index + ", " + commonGiftPackageModel.name);
        }
        int line = commonGiftPackageModel.getLine() * commonGiftPackageModel.getColumn();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= commonGiftPackageModel.goods.size()) {
                return;
            }
            BaseGiftModel baseGiftModel = (BaseGiftModel) commonGiftPackageModel.goods.get(i2);
            baseGiftModel.index = commonGiftPackageModel.index + BridgeUtil.UNDERLINE_STR + i2;
            baseGiftModel.packageIndex = commonGiftPackageModel.index;
            baseGiftModel.packageTabIndex = commonGiftPackageModel.tabIndex;
            baseGiftModel.pageIndex = i2 / line;
            baseGiftModel.positionInPage = i2 % line;
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(List<CommonGiftPackageModel> list) {
        if (list == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            CommonGiftPackageModel commonGiftPackageModel = list.get(i2);
            commonGiftPackageModel.index = String.valueOf(i2);
            commonGiftPackageModel.tabIndex = i2;
            a(commonGiftPackageModel);
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.module.common.fragment.BaseViewPagerParentFragment
    protected BaseFragment b(int i) {
        T t = this.b.get(i);
        Bundle bundle = new Bundle();
        if (t != null) {
            bundle.putString("package_index", t.index);
            bundle.putInt("package_tab_index", t.tabIndex);
        }
        BaseFragment a2 = a(t, bundle);
        a2.setArguments(bundle);
        LogUtils.c("instanceFragment: " + i);
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CommonGiftPackageModel b(String str) {
        int a2;
        if (str == null) {
            return null;
        }
        String[] split = str.split(BridgeUtil.UNDERLINE_STR);
        if (split.length <= 1 || this.b.size() <= (a2 = CommonStringUtils.a(split[0]))) {
            return null;
        }
        return this.b.get(a2);
    }

    public String b() {
        if (this.f == null) {
            this.f = c();
        }
        return this.f;
    }

    protected String c() {
        return "0_0";
    }

    public void c(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(String str) {
        LiveEventBus.get("gift_item_selected").post(str);
    }

    public void d() {
        LogUtils.c("dataListSize: " + this.b.size() + ", fragmentList: " + this.j.size());
        if (this.b.size() > this.j.size()) {
            int size = this.j.size();
            while (true) {
                int i = size;
                if (i >= this.b.size()) {
                    break;
                }
                this.j.add(b(i));
                size = i + 1;
            }
        } else if (this.j.size() > this.b.size()) {
            int size2 = this.j.size();
            while (true) {
                int i2 = size2 - 1;
                if (i2 < this.b.size()) {
                    break;
                }
                this.j.remove(i2);
                size2 = i2;
            }
        }
        e();
        LiveEventBus.get("gift_data_change").post("All");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.module.common.fragment.BaseViewPagerParentFragment
    public void e() {
        super.e();
        this.f10811a.setData(this.b);
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    @OverridingMethodsMustInvokeSuper
    public void onInitListener() {
        super.onInitListener();
        this.h.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.common.fragment.BaseGiftRootFragment.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1) {
                    BaseGiftRootFragment.this.e = true;
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                BaseGiftRootFragment.this.f10811a.setToolBtnSelect(i);
                BaseGiftRootFragment.this.c(i);
                if (BaseGiftRootFragment.this.e && BaseGiftRootFragment.this.j.size() > i && BaseGiftRootFragment.this.j.get(i) != null && BaseGiftRootFragment.this.j.get(i).isAdded() && (BaseGiftRootFragment.this.j.get(i) instanceof BaseGiftParentFragment)) {
                    if (BaseGiftRootFragment.this.d < i) {
                        ((BaseGiftParentFragment) BaseGiftRootFragment.this.j.get(i)).a(false);
                    } else {
                        ((BaseGiftParentFragment) BaseGiftRootFragment.this.j.get(i)).b(false);
                    }
                }
                BaseGiftRootFragment.this.e = false;
                BaseGiftRootFragment.this.d = i;
            }
        });
        LiveEventBus.get("gift_item_selected", String.class).observe(this, new Observer<String>() { // from class: com.blued.android.module.common.fragment.BaseGiftRootFragment.2
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                BaseGiftRootFragment.this.a(str, false);
            }
        });
        LiveEventBus.get("gift_item_clicked", String.class).observe(this, new Observer<String>() { // from class: com.blued.android.module.common.fragment.BaseGiftRootFragment.3
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                BaseGiftRootFragment.this.a(str, true);
            }
        });
        LiveEventBus.get("gift_item_update", BaseGiftModel.class).observe(this, new Observer() { // from class: com.blued.android.module.common.fragment.-$$Lambda$BaseGiftRootFragment$6pmjS5bsfF1VR7BIKZ6CQhcmsQY
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseGiftRootFragment.this.a((BaseGiftModel) obj);
            }
        });
        LiveEventBus.get("gift_package_selected", String.class).observe(this, new Observer<String>() { // from class: com.blued.android.module.common.fragment.BaseGiftRootFragment.4
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                int i;
                if (str == null) {
                    return;
                }
                Iterator<T> it = BaseGiftRootFragment.this.b.iterator();
                int i2 = 0;
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    } else if (StringUtils.a(str, it.next().index)) {
                        BaseGiftRootFragment.this.h.setCurrentItem(i);
                        break;
                    } else {
                        i2 = i + 1;
                    }
                }
                BaseGiftRootFragment.this.f10811a.setToolBtnSelect(i);
                BaseGiftRootFragment.this.c(i);
                BaseGiftRootFragment.this.b.get(i).hasNew = false;
            }
        });
    }

    @Override // com.blued.android.module.common.fragment.BaseViewPagerParentFragment, com.blued.android.framework.ui.SimpleFragment
    public void onInitView() {
        super.onInitView();
        this.f10811a = (CommonGiftTabView) this.rootView.findViewById(R.id.base_gift_toolbar_view);
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public int onSetRootViewId() {
        return R.layout.fragment_base_gift;
    }
}

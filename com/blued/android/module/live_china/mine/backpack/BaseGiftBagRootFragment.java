package com.blued.android.module.live_china.mine.backpack;

import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.R;
import com.blued.android.module.common.fragment.BaseGiftParentFragment;
import com.blued.android.module.common.fragment.BaseViewPagerParentFragment;
import com.blued.android.module.common.model.BaseGiftModel;
import com.blued.android.module.common.model.CommonGiftPackageModel;
import com.blued.android.module.common.view.CommonGiftTabView;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.OverridingMethodsMustInvokeSuper;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/backpack/BaseGiftBagRootFragment.class */
public abstract class BaseGiftBagRootFragment<T extends CommonGiftPackageModel> extends BaseViewPagerParentFragment {
    protected CommonGiftTabView a;
    protected final List<T> b = new ArrayList();
    protected int c = 0;
    protected boolean d = false;
    protected String e = null;

    protected abstract BaseFragment a(CommonGiftPackageModel commonGiftPackageModel, @Nonnull Bundle bundle);

    protected void a(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
    public BaseFragment b(int i) {
        T t = this.b.get(i);
        Bundle bundle = new Bundle();
        if (t != null) {
            bundle.putString("package_index", t.index);
            bundle.putInt("package_tab_index", t.tabIndex);
        }
        BaseFragment a = a(t, bundle);
        a.setArguments(bundle);
        LogUtils.c("instanceFragment: " + i);
        return a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
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

    @Override // com.blued.android.module.common.fragment.BaseViewPagerParentFragment
    public void e() {
        super.e();
        this.a.setData(this.b);
    }

    @OverridingMethodsMustInvokeSuper
    public void onInitListener() {
        super.onInitListener();
        this.h.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.live_china.mine.backpack.BaseGiftBagRootFragment.1
            public void onPageScrollStateChanged(int i) {
                if (i == 1) {
                    BaseGiftBagRootFragment.this.d = true;
                }
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                BaseGiftBagRootFragment.this.a.setToolBtnSelect(i);
                BaseGiftBagRootFragment.this.a(i);
                if (BaseGiftBagRootFragment.this.d && BaseGiftBagRootFragment.this.j.size() > i && BaseGiftBagRootFragment.this.j.get(i) != null && ((BaseFragment) BaseGiftBagRootFragment.this.j.get(i)).isAdded() && (BaseGiftBagRootFragment.this.j.get(i) instanceof BaseGiftParentFragment)) {
                    if (BaseGiftBagRootFragment.this.c < i) {
                        ((BaseGiftParentFragment) BaseGiftBagRootFragment.this.j.get(i)).a(false);
                    } else {
                        ((BaseGiftParentFragment) BaseGiftBagRootFragment.this.j.get(i)).b(false);
                    }
                }
                BaseGiftBagRootFragment.this.d = false;
                BaseGiftBagRootFragment.this.c = i;
            }
        });
        LiveEventBus.get("gift_package_selected", String.class).observe(this, new Observer<String>() { // from class: com.blued.android.module.live_china.mine.backpack.BaseGiftBagRootFragment.2
            /* renamed from: a */
            public void onChanged(String str) {
                int i;
                if (str == null) {
                    return;
                }
                Iterator<T> it = BaseGiftBagRootFragment.this.b.iterator();
                int i2 = 0;
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    } else if (StringUtils.a(str, it.next().index)) {
                        BaseGiftBagRootFragment.this.h.setCurrentItem(i);
                        break;
                    } else {
                        i2 = i + 1;
                    }
                }
                BaseGiftBagRootFragment.this.a.setToolBtnSelect(i);
                BaseGiftBagRootFragment.this.a(i);
                BaseGiftBagRootFragment.this.b.get(i).hasNew = false;
            }
        });
    }

    @Override // com.blued.android.module.common.fragment.BaseViewPagerParentFragment
    public void onInitView() {
        super.onInitView();
        this.a = (CommonGiftTabView) this.rootView.findViewById(R.id.base_gift_toolbar_view);
    }

    public int onSetRootViewId() {
        return R.layout.fragment_base_gift;
    }
}

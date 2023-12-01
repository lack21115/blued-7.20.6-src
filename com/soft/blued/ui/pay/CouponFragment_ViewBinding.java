package com.soft.blued.ui.pay;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/CouponFragment_ViewBinding.class */
public class CouponFragment_ViewBinding implements Unbinder {
    private CouponFragment b;

    public CouponFragment_ViewBinding(CouponFragment couponFragment, View view) {
        this.b = couponFragment;
        couponFragment.title = (CommonTopTitleNoTrans) Utils.a(view, 2131370694, "field 'title'", CommonTopTitleNoTrans.class);
        couponFragment.couponListView = (RecyclerView) Utils.a(view, 2131366888, "field 'couponListView'", RecyclerView.class);
        couponFragment.tvUseBtn = (ShapeTextView) Utils.a(view, 2131372865, "field 'tvUseBtn'", ShapeTextView.class);
        couponFragment.noDataAndLoadFailView = (NoDataAndLoadFailView) Utils.a(view, 2131368727, "field 'noDataAndLoadFailView'", NoDataAndLoadFailView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        CouponFragment couponFragment = this.b;
        if (couponFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        couponFragment.title = null;
        couponFragment.couponListView = null;
        couponFragment.tvUseBtn = null;
        couponFragment.noDataAndLoadFailView = null;
    }
}

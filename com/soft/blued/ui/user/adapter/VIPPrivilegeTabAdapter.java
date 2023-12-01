package com.soft.blued.ui.user.adapter;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.soft.blued.R;
import com.soft.blued.ui.user.model.VIPCenterNewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/VIPPrivilegeTabAdapter.class */
public final class VIPPrivilegeTabAdapter extends BaseQuickAdapter<VIPCenterNewModel.PrivilegeModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final int f33809a;

    public VIPPrivilegeTabAdapter(int i) {
        super((int) R.layout.item_vip_center_privilege_tab);
        this.f33809a = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder helper, VIPCenterNewModel.PrivilegeModel item) {
        Intrinsics.e(helper, "helper");
        Intrinsics.e(item, "item");
        ShapeTextView shapeTextView = (ShapeTextView) helper.getView(2131372672);
        shapeTextView.setText(item.title);
        ViewGroup.LayoutParams layoutParams = shapeTextView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        if (helper.getAdapterPosition() == 0) {
            layoutParams2.setMarginStart(DensityUtil.a(15.0f));
        } else {
            layoutParams2.setMarginStart(DensityUtil.a(12.0f));
        }
        shapeTextView.setLayoutParams(layoutParams2);
        if (!item.checked) {
            ShapeTextView shapeTextView2 = shapeTextView;
            ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView2, (int) R.color.syc_879298);
            ShapeHelper.b(shapeTextView2, R.color.syc_f4f4f4);
            return;
        }
        ShapeTextView shapeTextView3 = shapeTextView;
        ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView3, 2131102170);
        if (this.f33809a == 1) {
            ShapeHelper.b(shapeTextView3, R.color.syc_E2A371);
        } else {
            ShapeHelper.b(shapeTextView3, R.color.syc_20A7FD);
        }
    }
}

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
    private final int f20118a;

    public VIPPrivilegeTabAdapter(int i) {
        super((int) R.layout.item_vip_center_privilege_tab);
        this.f20118a = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, VIPCenterNewModel.PrivilegeModel privilegeModel) {
        Intrinsics.e(baseViewHolder, "helper");
        Intrinsics.e(privilegeModel, "item");
        ShapeHelper.ShapeView shapeView = (ShapeTextView) baseViewHolder.getView(R.id.tv_tab_name);
        shapeView.setText(privilegeModel.title);
        ViewGroup.LayoutParams layoutParams = shapeView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        if (baseViewHolder.getAdapterPosition() == 0) {
            layoutParams2.setMarginStart(DensityUtil.a(15.0f));
        } else {
            layoutParams2.setMarginStart(DensityUtil.a(12.0f));
        }
        shapeView.setLayoutParams(layoutParams2);
        if (!privilegeModel.checked) {
            ShapeHelper.ShapeView shapeView2 = shapeView;
            ShapeHelper.a(shapeView2, (int) R.color.syc_879298);
            ShapeHelper.b(shapeView2, (int) R.color.syc_f4f4f4);
            return;
        }
        ShapeHelper.ShapeView shapeView3 = shapeView;
        ShapeHelper.a(shapeView3, 2131102170);
        if (this.f20118a == 1) {
            ShapeHelper.b(shapeView3, (int) R.color.syc_E2A371);
        } else {
            ShapeHelper.b(shapeView3, (int) R.color.syc_20A7FD);
        }
    }
}

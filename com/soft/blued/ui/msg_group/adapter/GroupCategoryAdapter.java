package com.soft.blued.ui.msg_group.adapter;

import androidx.core.content.ContextCompat;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.group.GroupCategoryModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/adapter/GroupCategoryAdapter.class */
public final class GroupCategoryAdapter extends BaseQuickAdapter<GroupCategoryModel, BaseViewHolder> {
    public GroupCategoryAdapter() {
        super((int) R.layout.item_group_category);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, GroupCategoryModel groupCategoryModel) {
        Intrinsics.e(baseViewHolder, "helper");
        Intrinsics.e(groupCategoryModel, "item");
        ShapeHelper.ShapeView shapeView = (ShapeTextView) baseViewHolder.getView(2131370786);
        shapeView.setText(groupCategoryModel.getName());
        if (groupCategoryModel.isSelected()) {
            ShapeHelper.b(shapeView, 2131101766);
            shapeView.setTextColor(ContextCompat.getColor(this.mContext, 2131102170));
        } else {
            shapeView.setTextColor(ContextCompat.getColor(this.mContext, 2131102254));
            ShapeHelper.b(shapeView, 2131101796);
        }
        baseViewHolder.addOnClickListener(2131370786);
    }
}

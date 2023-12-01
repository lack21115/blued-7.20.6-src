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
    public void convert(BaseViewHolder helper, GroupCategoryModel item) {
        Intrinsics.e(helper, "helper");
        Intrinsics.e(item, "item");
        ShapeTextView shapeTextView = (ShapeTextView) helper.getView(2131370786);
        shapeTextView.setText(item.getName());
        if (item.isSelected()) {
            ShapeHelper.b(shapeTextView, 2131101766);
            shapeTextView.setTextColor(ContextCompat.getColor(this.mContext, 2131102170));
        } else {
            shapeTextView.setTextColor(ContextCompat.getColor(this.mContext, 2131102254));
            ShapeHelper.b(shapeTextView, 2131101796);
        }
        helper.addOnClickListener(2131370786);
    }
}

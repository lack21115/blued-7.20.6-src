package com.blued.android.module.common.widget.menu;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.module.common.R;
import com.blued.android.module.common.databinding.ItemActionsheetDefulatBinding;
import com.blued.android.module.common.databinding.ItemActionsheetOldBinding;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/menu/ActionSheetAdapter.class */
public class ActionSheetAdapter extends BaseMultiItemQuickAdapter<ActionSheetItem, ActionSheetViewHolder> {
    public ActionSheetAdapter(List<ActionSheetItem> list) {
        super(list);
        addItemType(-1, R.layout.item_actionsheet_defulat);
        addItemType(0, R.layout.item_actionsheet_old);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public ActionSheetViewHolder onCreateDefViewHolder(ViewGroup viewGroup, int i) {
        ViewBinding a;
        if (i == -1) {
            a = ItemActionsheetDefulatBinding.a(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        } else if (i != 0) {
            return (ActionSheetViewHolder) super.onCreateDefViewHolder(viewGroup, i);
        } else {
            a = ItemActionsheetOldBinding.a(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        }
        return new ActionSheetViewHolder(a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(ActionSheetViewHolder actionSheetViewHolder, ActionSheetItem actionSheetItem) {
        actionSheetItem.a(actionSheetViewHolder);
        if (actionSheetViewHolder.itemView instanceof ShapeHelper.ShapeView) {
            ShapeHelper.ShapeView shapeView = (ShapeHelper.ShapeView) actionSheetViewHolder.itemView;
            if (getHeaderLayoutCount() == 0 && actionSheetViewHolder.getAdapterPosition() == 0) {
                ShapeHelper.a(shapeView, DensityUtils.a(actionSheetViewHolder.itemView.getContext(), 10.0f), DensityUtils.a(actionSheetViewHolder.itemView.getContext(), 10.0f), 0.0f, 0.0f);
            } else {
                ShapeHelper.a(shapeView, 0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }
}

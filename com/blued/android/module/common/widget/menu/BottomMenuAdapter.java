package com.blued.android.module.common.widget.menu;

import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.R;
import com.blued.android.module.common.widget.menu.BottomMenuPop;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/menu/BottomMenuAdapter.class */
public class BottomMenuAdapter extends BaseQuickAdapter<BottomMenuPop.MenuItemInfo, BaseViewHolder> {
    public BottomMenuAdapter(List<BottomMenuPop.MenuItemInfo> list) {
        super(R.layout.item_pop_bottom_menu, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, BottomMenuPop.MenuItemInfo menuItemInfo) {
        if (menuItemInfo == null) {
            return;
        }
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv);
        textView.setText(menuItemInfo.a);
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.icon);
        if (menuItemInfo.c != 0) {
            imageView.setVisibility(0);
            imageView.setImageResource(menuItemInfo.c);
        } else {
            imageView.setVisibility(8);
        }
        if (menuItemInfo.b != 0) {
            textView.setTextColor(BluedSkinUtils.a(this.mContext, menuItemInfo.b));
        }
        baseViewHolder.getView(R.id.rl_root).setOnClickListener(menuItemInfo.d);
    }
}

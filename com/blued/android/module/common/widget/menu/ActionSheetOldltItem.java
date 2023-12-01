package com.blued.android.module.common.widget.menu;

import android.widget.LinearLayout;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.R;
import com.blued.android.module.common.databinding.ItemActionsheetOldBinding;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.common.widget.menu.BluedActionSheet;

@Deprecated
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/menu/ActionSheetOldltItem.class */
public class ActionSheetOldltItem extends ActionSheetItem<ItemActionsheetOldBinding> {
    public int h;
    public String f = "";
    public int g = R.color.syc_h;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;

    @Override // com.blued.android.module.common.widget.menu.ActionSheetItem
    /* renamed from: a */
    public ActionSheetOldltItem b(BluedActionSheet.OnClickActionSheetListener onClickActionSheetListener) {
        return (ActionSheetOldltItem) super.b(onClickActionSheetListener);
    }

    @Override // com.blued.android.module.common.widget.menu.ActionSheetItem
    public void a(ItemActionsheetOldBinding itemActionsheetOldBinding) {
        itemActionsheetOldBinding.g.setText(this.f);
        if (this.i) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) itemActionsheetOldBinding.g.getLayoutParams();
            layoutParams.setMargins(itemActionsheetOldBinding.b.getMeasuredWidth(), 0, 0, 0);
            itemActionsheetOldBinding.g.setLayoutParams(layoutParams);
            itemActionsheetOldBinding.b.setVisibility(0);
            itemActionsheetOldBinding.c.setVisibility(4);
        } else {
            itemActionsheetOldBinding.b.setVisibility(8);
            itemActionsheetOldBinding.c.setVisibility(8);
        }
        itemActionsheetOldBinding.g.setTextColor(BluedSkinUtils.a(itemActionsheetOldBinding.g.getContext(), this.g));
        if (this.j) {
            itemActionsheetOldBinding.f.setVisibility(0);
        } else {
            itemActionsheetOldBinding.f.setVisibility(8);
        }
        if (this.k) {
            itemActionsheetOldBinding.e.setVisibility(0);
        } else {
            itemActionsheetOldBinding.e.setVisibility(8);
        }
        if (this.l) {
            itemActionsheetOldBinding.d.setVisibility(0);
        } else {
            itemActionsheetOldBinding.d.setVisibility(8);
        }
        if (this.h != 0) {
            itemActionsheetOldBinding.f.setImageResource(this.h);
            itemActionsheetOldBinding.f.setVisibility(0);
        }
        if (itemActionsheetOldBinding.getRoot().getResources().getString(R.string.sticky_feed).equalsIgnoreCase(this.f)) {
            itemActionsheetOldBinding.f.setVisibility(0);
        } else if (itemActionsheetOldBinding.getRoot().getResources().getString(R.string.dynamic_skin_setting).equalsIgnoreCase(this.f)) {
            itemActionsheetOldBinding.f.setVisibility(0);
        } else if (itemActionsheetOldBinding.getRoot().getResources().getString(R.string.dynamic_skin_look).equalsIgnoreCase(this.f)) {
            itemActionsheetOldBinding.f.setVisibility(0);
        } else if (itemActionsheetOldBinding.getRoot().getResources().getString(R.string.cancel_sticky_feed).equalsIgnoreCase(this.f)) {
            itemActionsheetOldBinding.f.setVisibility(0);
        } else if (itemActionsheetOldBinding.getRoot().getResources().getString(R.string.msg_item_secret).equalsIgnoreCase(this.f)) {
            itemActionsheetOldBinding.f.setVisibility(0);
            itemActionsheetOldBinding.f.setImageResource(R.drawable.common_icon_svip);
        } else if (itemActionsheetOldBinding.getRoot().getResources().getString(R.string.feed_super_exposure_post).equals(this.f)) {
            itemActionsheetOldBinding.d.setVisibility(0);
        } else if (itemActionsheetOldBinding.getRoot().getResources().getString(R.string.privacy_photo_album_recover_dilatation).equalsIgnoreCase(this.f)) {
            itemActionsheetOldBinding.f.setVisibility(0);
        } else if (itemActionsheetOldBinding.getRoot().getResources().getString(R.string.customize_avatar_decoration).equalsIgnoreCase(this.f)) {
            if (!CommonPreferences.n()) {
                itemActionsheetOldBinding.e.setVisibility(0);
            }
            itemActionsheetOldBinding.f.setVisibility(0);
        } else if (itemActionsheetOldBinding.getRoot().getResources().getString(R.string.view_avatar_decoration).equalsIgnoreCase(this.f)) {
            itemActionsheetOldBinding.f.setVisibility(0);
        }
    }

    public int getItemType() {
        return 0;
    }
}

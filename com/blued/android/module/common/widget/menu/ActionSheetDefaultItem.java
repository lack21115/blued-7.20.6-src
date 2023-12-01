package com.blued.android.module.common.widget.menu;

import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.R;
import com.blued.android.module.common.databinding.ItemActionsheetDefulatBinding;
import com.blued.android.module.common.widget.menu.BluedActionSheet;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/menu/ActionSheetDefaultItem.class */
public class ActionSheetDefaultItem extends ActionSheetItem<ItemActionsheetDefulatBinding> {
    private int h;
    private int i;
    private int j;
    private String f = "";
    private int g = R.color.syc_h;
    private boolean k = false;
    private boolean l = true;

    public static ActionSheetDefaultItem a() {
        return new ActionSheetDefaultItem();
    }

    public ActionSheetDefaultItem a(int i) {
        this.g = i;
        return this;
    }

    @Override // com.blued.android.module.common.widget.menu.ActionSheetItem
    /* renamed from: a */
    public ActionSheetDefaultItem b(BluedActionSheet.OnClickActionSheetListener onClickActionSheetListener) {
        return (ActionSheetDefaultItem) super.b(onClickActionSheetListener);
    }

    public ActionSheetDefaultItem a(String str) {
        this.f = str;
        return this;
    }

    public ActionSheetDefaultItem a(boolean z) {
        this.l = z;
        if (this.f11204a != 0) {
            ((ItemActionsheetDefulatBinding) this.f11204a).getRoot().setClickable(z);
        }
        return this;
    }

    @Override // com.blued.android.module.common.widget.menu.ActionSheetItem
    public void a(ItemActionsheetDefulatBinding itemActionsheetDefulatBinding) {
        itemActionsheetDefulatBinding.getRoot().setClickable(this.l);
        itemActionsheetDefulatBinding.f.setText(this.f);
        if (this.l) {
            itemActionsheetDefulatBinding.f.setTextColor(BluedSkinUtils.a(itemActionsheetDefulatBinding.f.getContext(), this.g));
            itemActionsheetDefulatBinding.f.setAlpha(1.0f);
        } else {
            itemActionsheetDefulatBinding.f.setTextColor(BluedSkinUtils.a(itemActionsheetDefulatBinding.f.getContext(), R.color.syc_k));
            itemActionsheetDefulatBinding.f.setAlpha(0.5f);
        }
        if (this.h != 0) {
            itemActionsheetDefulatBinding.b.setImageResource(this.h);
            itemActionsheetDefulatBinding.b.setVisibility(0);
        } else {
            itemActionsheetDefulatBinding.b.setVisibility(8);
        }
        if (this.i != 0) {
            itemActionsheetDefulatBinding.f10730c.setImageResource(this.i);
            itemActionsheetDefulatBinding.f10730c.setVisibility(0);
        } else {
            itemActionsheetDefulatBinding.f10730c.setVisibility(8);
        }
        if (this.j != 0) {
            itemActionsheetDefulatBinding.e.setImageResource(this.j);
            itemActionsheetDefulatBinding.e.setVisibility(0);
        } else {
            itemActionsheetDefulatBinding.e.setVisibility(8);
        }
        if (this.k) {
            itemActionsheetDefulatBinding.d.setVisibility(0);
        } else {
            itemActionsheetDefulatBinding.d.setVisibility(8);
        }
    }

    public ActionSheetDefaultItem b(int i) {
        this.h = i;
        return this;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return -1;
    }
}

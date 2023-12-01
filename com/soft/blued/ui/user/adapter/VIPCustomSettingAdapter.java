package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.NinePatchUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.user.model.VIPCustomSettingBase;
import java.util.ArrayList;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/VIPCustomSettingAdapter.class */
public class VIPCustomSettingAdapter extends BaseQuickAdapter<VIPCustomSettingBase, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f33794a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f33795c;
    public int d;
    public int e;
    public String f;
    public Drawable g;
    public int h;

    public VIPCustomSettingAdapter(Context context, int i, String str, Drawable drawable, int i2, int i3) {
        super(i3, new ArrayList());
        this.f33795c = 3;
        this.f33794a = context;
        this.e = i;
        this.f = str;
        this.g = drawable;
        this.h = i2;
        int i4 = context.getResources().getDisplayMetrics().widthPixels;
        this.d = i4;
        this.b = (i4 - DensityUtils.a(this.f33794a, 36.0f)) / this.f33795c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, VIPCustomSettingBase vIPCustomSettingBase) {
        View view = baseViewHolder.getView(2131369461);
        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
        layoutParams.width = (AppInfo.l - DensityUtils.a(this.f33794a, 36.0f)) / 3;
        int adapterPosition = baseViewHolder.getAdapterPosition();
        if (adapterPosition == 0 || adapterPosition == 1 || adapterPosition == 2) {
            layoutParams.topMargin = DensityUtils.a(this.f33794a, 10.0f);
        } else {
            layoutParams.topMargin = DensityUtils.a(this.f33794a, 0.0f);
        }
        view.setLayoutParams(layoutParams);
        View view2 = baseViewHolder.getView(2131365126);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) view2.getLayoutParams();
        layoutParams2.width = layoutParams.width;
        layoutParams2.height = layoutParams.width;
        view2.setLayoutParams(layoutParams2);
        if (vIPCustomSettingBase.lastSelected) {
            baseViewHolder.setVisible(R.id.iv_current_selected, true);
        } else {
            baseViewHolder.setVisible(R.id.iv_current_selected, false);
        }
        if (vIPCustomSettingBase.selected == 1) {
            baseViewHolder.setVisible(R.id.iv_selected_bg, true);
        } else {
            baseViewHolder.setVisible(R.id.iv_selected_bg, false);
        }
        if (baseViewHolder.getAdapterPosition() == 0) {
            baseViewHolder.setImageDrawable(2131365518, this.g);
        } else {
            ImageLoader.a((IRequestHost) null, vIPCustomSettingBase.front_cover).a((ImageView) baseViewHolder.getView(2131365518));
        }
        baseViewHolder.setText(2131372046, vIPCustomSettingBase.name);
        baseViewHolder.setText(2131371262, vIPCustomSettingBase.corner_text);
        if (vIPCustomSettingBase.is_termination == 1) {
            baseViewHolder.setVisible(R.id.tv_vip, false);
            baseViewHolder.setVisible(R.id.tv_time_limit, true);
        } else {
            if (vIPCustomSettingBase.isDefault) {
                baseViewHolder.setVisible(R.id.tv_vip, false);
                baseViewHolder.setVisible(2131371262, false);
            } else if (TextUtils.isEmpty(vIPCustomSettingBase.corner_text)) {
                baseViewHolder.setVisible(2131371262, false);
                baseViewHolder.setVisible(R.id.tv_vip, true);
            } else {
                baseViewHolder.getView(2131371262).setBackground(NinePatchUtils.f10891a.a(R.drawable.icon_lv_9_bg));
                baseViewHolder.setVisible(2131371262, true);
                baseViewHolder.setVisible(R.id.tv_vip, false);
            }
            baseViewHolder.setVisible(R.id.tv_time_limit, false);
        }
        if (this.h == 1) {
            baseViewHolder.setVisible(R.id.iv_widget_bg, true);
        } else {
            baseViewHolder.setVisible(R.id.iv_widget_bg, false);
        }
    }
}

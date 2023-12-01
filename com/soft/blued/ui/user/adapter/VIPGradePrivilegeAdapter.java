package com.soft.blued.ui.user.adapter;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.user.model.VIPRightOption;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/VIPGradePrivilegeAdapter.class */
public final class VIPGradePrivilegeAdapter extends BaseQuickAdapter<VIPRightOption, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final ActivityFragmentActive f20105a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f20106c;
    private final int d;
    private int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VIPGradePrivilegeAdapter(ActivityFragmentActive activityFragmentActive, int i, int i2, int i3) {
        super((int) R.layout.item_new_vip_center_privilege);
        Intrinsics.e(activityFragmentActive, "fragmentActive");
        this.f20105a = activityFragmentActive;
        this.b = i;
        this.f20106c = i2;
        this.d = i3;
        this.e = i2;
    }

    public final void a(int i) {
        this.e = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, VIPRightOption vIPRightOption) {
        Intrinsics.e(baseViewHolder, "helper");
        Intrinsics.e(vIPRightOption, "item");
        ConstraintLayout constraintLayout = (ConstraintLayout) baseViewHolder.getView(R.id.item_view);
        ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
        layoutParams.width = (int) (this.b / 4.5f);
        layoutParams.height = -2;
        constraintLayout.setLayoutParams(layoutParams);
        ImageLoader.a(this.f20105a, vIPRightOption.icon).a((ImageView) baseViewHolder.getView(R.id.iv_privilege));
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_lock);
        if (this.e > this.f20106c) {
            imageView.setVisibility(0);
            if (this.d == 1) {
                imageView.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_vip_center_lock));
            } else {
                imageView.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_svip_center_lock));
            }
        } else {
            imageView.setVisibility(8);
        }
        if (!TextUtils.isEmpty(vIPRightOption.title)) {
            baseViewHolder.setTextColor(R.id.tv_privilege_name, this.mContext.getResources().getColor(2131102170));
            baseViewHolder.setText(R.id.tv_privilege_name, vIPRightOption.title);
        }
        if (TextUtils.isEmpty(vIPRightOption.unit)) {
            baseViewHolder.setGone(R.id.tv_unit, false);
            return;
        }
        baseViewHolder.setGone(R.id.tv_unit, true);
        baseViewHolder.setText(R.id.tv_unit, vIPRightOption.unit);
    }
}

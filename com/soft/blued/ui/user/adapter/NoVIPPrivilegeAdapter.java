package com.soft.blued.ui.user.adapter;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.soft.blued.R;
import com.soft.blued.ui.user.model.VIPRightOption;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/NoVIPPrivilegeAdapter.class */
public final class NoVIPPrivilegeAdapter extends BaseQuickAdapter<VIPRightOption, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f20050a = new Companion(null);
    private final ActivityFragmentActive b;

    /* renamed from: c  reason: collision with root package name */
    private final int f20051c;
    private final int d;
    private final int e;
    private int f;
    private int g;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/NoVIPPrivilegeAdapter$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoVIPPrivilegeAdapter(ActivityFragmentActive activityFragmentActive, int i, int i2, int i3) {
        super((int) R.layout.item_new_vip_center_privilege);
        Intrinsics.e(activityFragmentActive, "fragmentActive");
        this.b = activityFragmentActive;
        this.f20051c = i;
        this.d = i2;
        this.e = i3;
    }

    public final int a() {
        return this.f;
    }

    public final void a(int i) {
        this.f = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, VIPRightOption vIPRightOption) {
        Intrinsics.e(baseViewHolder, "helper");
        Intrinsics.e(vIPRightOption, "item");
        ConstraintLayout constraintLayout = (ConstraintLayout) baseViewHolder.getView(R.id.item_view);
        ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
        int i = this.d;
        if (i > 0) {
            layoutParams.width = i / 4;
            layoutParams.height = this.d / 4;
        } else {
            layoutParams.width = DensityUtil.a(60.0f);
            layoutParams.height = DensityUtil.a(60.0f);
        }
        if (this.e == 2) {
            layoutParams.height = -2;
        }
        constraintLayout.setLayoutParams(layoutParams);
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_privilege);
        ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
        if (layoutParams2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) layoutParams2;
        layoutParams3.width = DensityUtil.a(40.0f);
        layoutParams3.height = DensityUtil.a(40.0f);
        imageView.setLayoutParams(layoutParams3);
        String str = vIPRightOption.icon_vip;
        if (this.f20051c == 2) {
            str = vIPRightOption.icon_svip;
        }
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_tag);
        textView.setVisibility(8);
        ShapeTextView view = baseViewHolder.getView(R.id.tv_unit_shape);
        view.setVisibility(8);
        if (this.e == 2) {
            str = vIPRightOption.icon;
            if (!TextUtils.isEmpty(vIPRightOption.corner)) {
                textView.setVisibility(0);
                textView.setText(vIPRightOption.corner);
            }
            if (!TextUtils.isEmpty(vIPRightOption.unit)) {
                view.setVisibility(0);
                view.setText(vIPRightOption.unit);
            }
            ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.iv_lock);
            if (this.g > this.f) {
                imageView2.setVisibility(0);
                if (this.f20051c == 1) {
                    imageView2.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_vip_center_lock));
                } else {
                    imageView2.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_svip_center_lock));
                }
            } else {
                imageView2.setVisibility(8);
            }
        }
        ImageLoader.a(this.b, str).a(imageView);
        if (TextUtils.isEmpty(vIPRightOption.title)) {
            return;
        }
        baseViewHolder.setText(R.id.tv_privilege_name, vIPRightOption.title);
    }

    public final void b(int i) {
        this.g = i;
    }
}

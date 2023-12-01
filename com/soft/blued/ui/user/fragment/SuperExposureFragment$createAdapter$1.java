package com.soft.blued.ui.user.fragment;

import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.module.common.adapter.CommonAdapter;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.databinding.FragmentSuperExposureBinding;
import com.soft.blued.ui.mine.model.SuperExposureCouponModel;
import com.soft.blued.ui.mine.model.SuperExposurePayItemModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/SuperExposureFragment$createAdapter$1.class */
public final class SuperExposureFragment$createAdapter$1 extends CommonAdapter<SuperExposurePayItemModel> {
    final /* synthetic */ SuperExposureFragment d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperExposureFragment$createAdapter$1(SuperExposureFragment superExposureFragment, SuperExposureFragment$createAdapter$2 superExposureFragment$createAdapter$2) {
        super((List) null, superExposureFragment$createAdapter$2);
        this.d = superExposureFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SuperExposurePayItemModel superExposurePayItemModel, int i, SuperExposureFragment superExposureFragment, View view) {
        FragmentSuperExposureBinding x;
        Tracker.onClick(view);
        Intrinsics.e(superExposurePayItemModel, "$model");
        Intrinsics.e(superExposureFragment, "this$0");
        if (TextUtils.isEmpty(superExposurePayItemModel.content)) {
            if (i != superExposureFragment.s()) {
                x = superExposureFragment.x();
                LinearLayout linearLayout = x == null ? null : x.ah;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
            }
            superExposureFragment.b(i);
            if (superExposureFragment.t() >= 0) {
                superExposureFragment.u().get(superExposureFragment.t()).money = "0";
            }
            if (superExposureFragment.w().get(superExposurePayItemModel.id) != null) {
                superExposureFragment.a(superExposureFragment.w().get(superExposurePayItemModel.id));
            } else {
                superExposureFragment.f(superExposurePayItemModel.id);
                superExposureFragment.b((SuperExposureCouponModel) null);
            }
        } else {
            superExposureFragment.c(i);
            superExposureFragment.a(superExposurePayItemModel);
            superExposureFragment.b((SuperExposureCouponModel) null);
        }
        superExposureFragment.M();
        superExposureFragment.v().a(superExposureFragment.u());
    }

    public void a(CommonAdapter.ViewHolder viewHolder, final SuperExposurePayItemModel superExposurePayItemModel, final int i) {
        Intrinsics.e(viewHolder, "holder");
        Intrinsics.e(superExposurePayItemModel, "model");
        viewHolder.c((int) R.id.item_super_exposure_pay_content_layout, i == this.d.s() ? 2131237220 : 2131237219).b((int) R.id.item_super_exposure_pay_corner, TextUtils.isEmpty(superExposurePayItemModel.corner) ? 8 : 0).a((int) R.id.item_super_exposure_pay_corner, superExposurePayItemModel.corner).a((int) R.id.item_super_exposure_pay_price, superExposurePayItemModel.money).a((int) R.id.item_super_exposure_pay_origin_price, superExposurePayItemModel.originalShow).a((int) R.id.item_super_exposure_pay_label_tv, superExposurePayItemModel.label).b((int) R.id.item_super_exposure_pay_origin_price, TextUtils.isEmpty(superExposurePayItemModel.originalShow) ? 8 : 0);
        if (superExposurePayItemModel.storage_num > 0) {
            viewHolder.b((int) R.id.tv_times, 0).a((int) R.id.tv_times, String.valueOf(superExposurePayItemModel.storage_num));
        } else {
            viewHolder.b((int) R.id.tv_times, 8);
        }
        TextView textView = (TextView) viewHolder.a((int) R.id.item_super_exposure_pay_origin_price);
        TextPaint paint = textView == null ? null : textView.getPaint();
        if (paint != null) {
            paint.setFlags(16);
        }
        if (!TextUtils.isEmpty(superExposurePayItemModel.content)) {
            this.d.c(i);
        }
        if (!TextUtils.isEmpty(superExposurePayItemModel.content) && !TextUtils.isEmpty(superExposurePayItemModel.money)) {
            String str = superExposurePayItemModel.money;
            Intrinsics.c(str, "model.money");
            if (((int) Double.parseDouble(str)) > 0) {
                viewHolder.b((int) R.id.item_super_exposure_pay_define_price_layout, 0).b((int) R.id.item_super_exposure_pay_define_edit, 8);
                View a2 = viewHolder.a();
                final SuperExposureFragment superExposureFragment = this.d;
                a2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$createAdapter$1$F8X4nQ887MGxRpimcsvGaPAcEgk
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SuperExposureFragment$createAdapter$1.a(SuperExposurePayItemModel.this, i, superExposureFragment, view);
                    }
                });
            }
        }
        viewHolder.b((int) R.id.item_super_exposure_pay_define_price_layout, 8).b((int) R.id.item_super_exposure_pay_define_edit, 0);
        View a22 = viewHolder.a();
        final SuperExposureFragment superExposureFragment2 = this.d;
        a22.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$createAdapter$1$F8X4nQ887MGxRpimcsvGaPAcEgk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuperExposureFragment$createAdapter$1.a(SuperExposurePayItemModel.this, i, superExposureFragment2, view);
            }
        });
    }
}

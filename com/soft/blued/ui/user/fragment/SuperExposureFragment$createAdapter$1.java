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
    public static final void a(SuperExposurePayItemModel model, int i, SuperExposureFragment this$0, View view) {
        FragmentSuperExposureBinding x;
        Tracker.onClick(view);
        Intrinsics.e(model, "$model");
        Intrinsics.e(this$0, "this$0");
        if (TextUtils.isEmpty(model.content)) {
            if (i != this$0.s()) {
                x = this$0.x();
                LinearLayout linearLayout = x == null ? null : x.ah;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
            }
            this$0.b(i);
            if (this$0.t() >= 0) {
                this$0.u().get(this$0.t()).money = "0";
            }
            if (this$0.w().get(model.id) != null) {
                this$0.a(this$0.w().get(model.id));
            } else {
                this$0.f(model.id);
                this$0.b((SuperExposureCouponModel) null);
            }
        } else {
            this$0.c(i);
            this$0.a(model);
            this$0.b((SuperExposureCouponModel) null);
        }
        this$0.M();
        this$0.v().a(this$0.u());
    }

    @Override // com.blued.android.module.common.adapter.CommonAdapter
    public void a(CommonAdapter.ViewHolder holder, final SuperExposurePayItemModel model, final int i) {
        Intrinsics.e(holder, "holder");
        Intrinsics.e(model, "model");
        holder.c(R.id.item_super_exposure_pay_content_layout, i == this.d.s() ? 2131237220 : 2131237219).b(R.id.item_super_exposure_pay_corner, TextUtils.isEmpty(model.corner) ? 8 : 0).a(R.id.item_super_exposure_pay_corner, model.corner).a(R.id.item_super_exposure_pay_price, model.money).a(R.id.item_super_exposure_pay_origin_price, model.originalShow).a(R.id.item_super_exposure_pay_label_tv, model.label).b(R.id.item_super_exposure_pay_origin_price, TextUtils.isEmpty(model.originalShow) ? 8 : 0);
        if (model.storage_num > 0) {
            holder.b(2131372734, 0).a(2131372734, String.valueOf(model.storage_num));
        } else {
            holder.b(2131372734, 8);
        }
        TextView textView = (TextView) holder.a(R.id.item_super_exposure_pay_origin_price);
        TextPaint paint = textView == null ? null : textView.getPaint();
        if (paint != null) {
            paint.setFlags(16);
        }
        if (!TextUtils.isEmpty(model.content)) {
            this.d.c(i);
        }
        if (!TextUtils.isEmpty(model.content) && !TextUtils.isEmpty(model.money)) {
            String str = model.money;
            Intrinsics.c(str, "model.money");
            if (((int) Double.parseDouble(str)) > 0) {
                holder.b(R.id.item_super_exposure_pay_define_price_layout, 0).b(R.id.item_super_exposure_pay_define_edit, 8);
                View a2 = holder.a();
                final SuperExposureFragment superExposureFragment = this.d;
                a2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$createAdapter$1$F8X4nQ887MGxRpimcsvGaPAcEgk
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SuperExposureFragment$createAdapter$1.a(SuperExposurePayItemModel.this, i, superExposureFragment, view);
                    }
                });
            }
        }
        holder.b(R.id.item_super_exposure_pay_define_price_layout, 8).b(R.id.item_super_exposure_pay_define_edit, 0);
        View a22 = holder.a();
        final SuperExposureFragment superExposureFragment2 = this.d;
        a22.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$createAdapter$1$F8X4nQ887MGxRpimcsvGaPAcEgk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuperExposureFragment$createAdapter$1.a(SuperExposurePayItemModel.this, i, superExposureFragment2, view);
            }
        });
    }
}

package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.user.model.VIPBuyOption;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/VIPItemRoundNewAdapter.class */
public final class VIPItemRoundNewAdapter extends BaseQuickAdapter<VIPBuyOption, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f33800a;
    private onGoodClick b;

    /* renamed from: c  reason: collision with root package name */
    private int f33801c;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/VIPItemRoundNewAdapter$onGoodClick.class */
    public interface onGoodClick {
        void onclick(VIPBuyOption vIPBuyOption);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VIPItemRoundNewAdapter(Context mContext) {
        super((int) R.layout.item_vip_pay_option_round);
        Intrinsics.e(mContext, "mContext");
        this.f33800a = mContext;
        this.f33801c = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VIPItemRoundNewAdapter this$0, VIPBuyOption data, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(data, "$data");
        List<VIPBuyOption> data2 = this$0.getData();
        Intrinsics.c(data2, "getData()");
        for (VIPBuyOption vIPBuyOption : data2) {
            vIPBuyOption.choosen = false;
        }
        data.choosen = true;
        this$0.notifyDataSetChanged();
        onGoodClick ongoodclick = this$0.b;
        if (ongoodclick == null) {
            return;
        }
        ongoodclick.onclick(data);
    }

    public final VIPBuyOption a() {
        List<VIPBuyOption> data = getData();
        Intrinsics.c(data, "data");
        for (VIPBuyOption vIPBuyOption : data) {
            if (vIPBuyOption.choosen) {
                return vIPBuyOption;
            }
        }
        return null;
    }

    public final void a(int i) {
        this.f33801c = i;
    }

    public final void a(int i, boolean z) {
        if (getData().size() > i) {
            List<VIPBuyOption> data = getData();
            Intrinsics.c(data, "data");
            for (VIPBuyOption vIPBuyOption : data) {
                vIPBuyOption.choosen = false;
            }
            getData().get(i).choosen = z;
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder helper, final VIPBuyOption data) {
        Intrinsics.e(helper, "helper");
        Intrinsics.e(data, "data");
        VIPBuyOption._item _itemVar = data.item;
        ShapeTextView shapeTextView = (ShapeTextView) helper.getView(R.id.tv_favourate);
        if (TextUtils.isEmpty(_itemVar.tag_up)) {
            shapeTextView.setVisibility(8);
        } else {
            shapeTextView.setVisibility(0);
            shapeTextView.setText(_itemVar.tag_up);
        }
        ((TextView) helper.getView(2131372046)).setText(_itemVar.name);
        helper.setText(R.id.tv_amount, Intrinsics.a("", (Object) Integer.valueOf((int) data.money)));
        TextView textView = (TextView) helper.getView(R.id.tv_amount_per_month);
        textView.setPaintFlags(textView.getPaintFlags() | 16);
        String a2 = Intrinsics.a("", (Object) Integer.valueOf((int) data.original_money));
        helper.setText(R.id.tv_amount_per_month, BlueAppLocal.a().equals("en") ? Intrinsics.a("￥", (Object) a2) : Intrinsics.a(a2, (Object) "元"));
        ShapeTextView shapeTextView2 = (ShapeTextView) helper.getView(2131372678);
        ShapeModel shapeModel = new ShapeModel();
        shapeModel.K = DensityUtils.a(this.f33800a, 6.0f);
        shapeModel.L = DensityUtils.a(this.f33800a, 6.0f);
        if (this.f33801c == 2) {
            if (data.choosen) {
                shapeModel.k = BluedSkinUtils.a(this.f33800a, 2131101766);
                shapeModel.b = BluedSkinUtils.a(this.f33800a, 2131101780);
            } else {
                shapeModel.k = BluedSkinUtils.a(this.f33800a, 2131101769);
                shapeModel.b = BluedSkinUtils.a(this.f33800a, 2131101766);
            }
        } else if (data.choosen) {
            shapeModel.k = BluedSkinUtils.a(this.f33800a, (int) R.color.syc_E88236);
            shapeModel.b = BluedSkinUtils.a(this.f33800a, 2131101780);
        } else {
            shapeModel.k = BluedSkinUtils.a(this.f33800a, (int) R.color.syc_E88236_10);
            shapeModel.b = BluedSkinUtils.a(this.f33800a, (int) R.color.syc_E88236);
        }
        shapeTextView2.setShapeModel(shapeModel);
        if (TextUtils.isEmpty(_itemVar.tag_bottom)) {
            shapeTextView2.setVisibility(4);
        } else {
            shapeTextView2.setVisibility(0);
            shapeTextView2.setText(_itemVar.tag_bottom);
        }
        ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) helper.getView(R.id.ll_item);
        ShapeModel shapeModel2 = new ShapeModel();
        if (this.f33801c == 2) {
            if (data.choosen) {
                shapeModel2.n = BluedSkinUtils.a(this.f33800a, 2131101766);
                shapeModel2.q = DensityUtils.a(this.f33800a, 3.0f);
                shapeModel2.H = DensityUtils.a(this.f33800a, 6.0f);
                shapeModel2.k = BluedSkinUtils.a(this.f33800a, 2131101780);
                shapeConstraintLayout.setShapeModel(shapeModel2);
            } else {
                shapeModel2.H = DensityUtils.a(this.f33800a, 6.0f);
                shapeModel2.k = BluedSkinUtils.a(this.f33800a, 2131102360);
                shapeConstraintLayout.setShapeModel(shapeModel2);
            }
        } else if (data.choosen) {
            shapeModel2.n = BluedSkinUtils.a(this.f33800a, (int) R.color.syc_E88236);
            shapeModel2.q = DensityUtils.a(this.f33800a, 3.0f);
            shapeModel2.H = DensityUtils.a(this.f33800a, 6.0f);
            shapeModel2.k = BluedSkinUtils.a(this.f33800a, 2131101780);
            shapeConstraintLayout.setShapeModel(shapeModel2);
        } else {
            shapeModel2.H = DensityUtils.a(this.f33800a, 6.0f);
            shapeModel2.k = BluedSkinUtils.a(this.f33800a, 2131102360);
            shapeConstraintLayout.setShapeModel(shapeModel2);
        }
        shapeConstraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.adapter.-$$Lambda$VIPItemRoundNewAdapter$O9oPqGlmDgDqi72JGaXTqdE3bZo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPItemRoundNewAdapter.a(VIPItemRoundNewAdapter.this, data, view);
            }
        });
    }

    public final void a(onGoodClick clickListener) {
        Intrinsics.e(clickListener, "clickListener");
        this.b = clickListener;
    }
}

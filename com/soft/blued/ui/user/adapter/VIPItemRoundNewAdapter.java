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
    private final Context f20109a;
    private onGoodClick b;

    /* renamed from: c  reason: collision with root package name */
    private int f20110c;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/VIPItemRoundNewAdapter$onGoodClick.class */
    public interface onGoodClick {
        void onclick(VIPBuyOption vIPBuyOption);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VIPItemRoundNewAdapter(Context context) {
        super((int) R.layout.item_vip_pay_option_round);
        Intrinsics.e(context, "mContext");
        this.f20109a = context;
        this.f20110c = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VIPItemRoundNewAdapter vIPItemRoundNewAdapter, VIPBuyOption vIPBuyOption, View view) {
        Tracker.onClick(view);
        Intrinsics.e(vIPItemRoundNewAdapter, "this$0");
        Intrinsics.e(vIPBuyOption, "$data");
        List<VIPBuyOption> data = vIPItemRoundNewAdapter.getData();
        Intrinsics.c(data, "getData()");
        for (VIPBuyOption vIPBuyOption2 : data) {
            vIPBuyOption2.choosen = false;
        }
        vIPBuyOption.choosen = true;
        vIPItemRoundNewAdapter.notifyDataSetChanged();
        onGoodClick ongoodclick = vIPItemRoundNewAdapter.b;
        if (ongoodclick == null) {
            return;
        }
        ongoodclick.onclick(vIPBuyOption);
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
        this.f20110c = i;
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
    public void convert(BaseViewHolder baseViewHolder, final VIPBuyOption vIPBuyOption) {
        Intrinsics.e(baseViewHolder, "helper");
        Intrinsics.e(vIPBuyOption, "data");
        VIPBuyOption._item _itemVar = vIPBuyOption.item;
        ShapeTextView view = baseViewHolder.getView(R.id.tv_favourate);
        if (TextUtils.isEmpty(_itemVar.tag_up)) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
            view.setText(_itemVar.tag_up);
        }
        ((TextView) baseViewHolder.getView(2131372046)).setText(_itemVar.name);
        baseViewHolder.setText(R.id.tv_amount, Intrinsics.a("", Integer.valueOf((int) vIPBuyOption.money)));
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_amount_per_month);
        textView.setPaintFlags(textView.getPaintFlags() | 16);
        String a2 = Intrinsics.a("", Integer.valueOf((int) vIPBuyOption.original_money));
        baseViewHolder.setText(R.id.tv_amount_per_month, BlueAppLocal.a().equals("en") ? Intrinsics.a("￥", a2) : Intrinsics.a(a2, "元"));
        ShapeTextView view2 = baseViewHolder.getView(R.id.tv_tag);
        ShapeModel shapeModel = new ShapeModel();
        shapeModel.K = DensityUtils.a(this.f20109a, 6.0f);
        shapeModel.L = DensityUtils.a(this.f20109a, 6.0f);
        if (this.f20110c == 2) {
            if (vIPBuyOption.choosen) {
                shapeModel.k = BluedSkinUtils.a(this.f20109a, 2131101766);
                shapeModel.b = BluedSkinUtils.a(this.f20109a, 2131101780);
            } else {
                shapeModel.k = BluedSkinUtils.a(this.f20109a, 2131101769);
                shapeModel.b = BluedSkinUtils.a(this.f20109a, 2131101766);
            }
        } else if (vIPBuyOption.choosen) {
            shapeModel.k = BluedSkinUtils.a(this.f20109a, (int) R.color.syc_E88236);
            shapeModel.b = BluedSkinUtils.a(this.f20109a, 2131101780);
        } else {
            shapeModel.k = BluedSkinUtils.a(this.f20109a, (int) R.color.syc_E88236_10);
            shapeModel.b = BluedSkinUtils.a(this.f20109a, (int) R.color.syc_E88236);
        }
        view2.setShapeModel(shapeModel);
        if (TextUtils.isEmpty(_itemVar.tag_bottom)) {
            view2.setVisibility(4);
        } else {
            view2.setVisibility(0);
            view2.setText(_itemVar.tag_bottom);
        }
        ShapeConstraintLayout view3 = baseViewHolder.getView(R.id.ll_item);
        ShapeModel shapeModel2 = new ShapeModel();
        if (this.f20110c == 2) {
            if (vIPBuyOption.choosen) {
                shapeModel2.n = BluedSkinUtils.a(this.f20109a, 2131101766);
                shapeModel2.q = DensityUtils.a(this.f20109a, 3.0f);
                shapeModel2.H = DensityUtils.a(this.f20109a, 6.0f);
                shapeModel2.k = BluedSkinUtils.a(this.f20109a, 2131101780);
                view3.setShapeModel(shapeModel2);
            } else {
                shapeModel2.H = DensityUtils.a(this.f20109a, 6.0f);
                shapeModel2.k = BluedSkinUtils.a(this.f20109a, 2131102360);
                view3.setShapeModel(shapeModel2);
            }
        } else if (vIPBuyOption.choosen) {
            shapeModel2.n = BluedSkinUtils.a(this.f20109a, (int) R.color.syc_E88236);
            shapeModel2.q = DensityUtils.a(this.f20109a, 3.0f);
            shapeModel2.H = DensityUtils.a(this.f20109a, 6.0f);
            shapeModel2.k = BluedSkinUtils.a(this.f20109a, 2131101780);
            view3.setShapeModel(shapeModel2);
        } else {
            shapeModel2.H = DensityUtils.a(this.f20109a, 6.0f);
            shapeModel2.k = BluedSkinUtils.a(this.f20109a, 2131102360);
            view3.setShapeModel(shapeModel2);
        }
        view3.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.adapter.-$$Lambda$VIPItemRoundNewAdapter$O9oPqGlmDgDqi72JGaXTqdE3bZo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                VIPItemRoundNewAdapter.a(VIPItemRoundNewAdapter.this, vIPBuyOption, view4);
            }
        });
    }

    public final void a(onGoodClick ongoodclick) {
        Intrinsics.e(ongoodclick, "clickListener");
        this.b = ongoodclick;
    }
}

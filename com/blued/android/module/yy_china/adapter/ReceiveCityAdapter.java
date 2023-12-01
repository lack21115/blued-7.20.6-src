package com.blued.android.module.yy_china.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ItemTripReceiverLayoutBinding;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/ReceiveCityAdapter.class */
public final class ReceiveCityAdapter extends AbstractReceiverAdapter {
    private ItemTripReceiverLayoutBinding a;
    private int b;
    private int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReceiveCityAdapter(Context context, ActivityFragmentActive fragmentActive) {
        super(context, fragmentActive, R.layout.item_trip_receiver_layout);
        Intrinsics.e(context, "context");
        Intrinsics.e(fragmentActive, "fragmentActive");
        this.b = DensityUtils.a(context, 15.0f);
        this.c = DensityUtils.a(context, 8.0f);
    }

    @Override // com.blued.android.module.yy_china.adapter.AbstractReceiverAdapter
    public CardView a() {
        ItemTripReceiverLayoutBinding itemTripReceiverLayoutBinding = this.a;
        if (itemTripReceiverLayoutBinding == null) {
            return null;
        }
        return itemTripReceiverLayoutBinding.d;
    }

    @Override // com.blued.android.module.yy_china.adapter.AbstractReceiverAdapter
    public ImageView b() {
        ItemTripReceiverLayoutBinding itemTripReceiverLayoutBinding = this.a;
        if (itemTripReceiverLayoutBinding == null) {
            return null;
        }
        return itemTripReceiverLayoutBinding.b;
    }

    @Override // com.blued.android.module.yy_china.adapter.AbstractReceiverAdapter
    public void b(BaseViewHolder baseViewHolder, YYSeatMemberModel yYSeatMemberModel) {
        View view;
        ViewGroup.LayoutParams layoutParams;
        ItemTripReceiverLayoutBinding a = (baseViewHolder == null || (view = baseViewHolder.itemView) == null) ? null : ItemTripReceiverLayoutBinding.a(view);
        this.a = a;
        if (a == null) {
            layoutParams = null;
        } else {
            ConstraintLayout constraintLayout = a.c;
            layoutParams = constraintLayout == null ? null : constraintLayout.getLayoutParams();
        }
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        }
        RecyclerView.LayoutParams layoutParams2 = layoutParams;
        if (baseViewHolder != null && baseViewHolder.getAdapterPosition() == 0) {
            layoutParams2.leftMargin = this.b;
        } else {
            layoutParams2.leftMargin = 0;
        }
        layoutParams2.rightMargin = this.c;
    }

    @Override // com.blued.android.module.yy_china.adapter.AbstractReceiverAdapter
    public TextView c() {
        ItemTripReceiverLayoutBinding itemTripReceiverLayoutBinding = this.a;
        if (itemTripReceiverLayoutBinding == null) {
            return null;
        }
        return itemTripReceiverLayoutBinding.e;
    }

    @Override // com.blued.android.module.yy_china.adapter.AbstractReceiverAdapter
    public ImageView d() {
        ItemTripReceiverLayoutBinding itemTripReceiverLayoutBinding = this.a;
        if (itemTripReceiverLayoutBinding == null) {
            return null;
        }
        return itemTripReceiverLayoutBinding.a;
    }
}

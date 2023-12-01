package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.common.user.model.UserTag;
import com.soft.blued.R;
import com.soft.blued.databinding.ItemUserTagNewBinding;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/UserTagAdapterNew.class */
public final class UserTagAdapterNew extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f20082a;
    private List<? extends UserTag> b;

    /* renamed from: c  reason: collision with root package name */
    private Context f20083c;

    public UserTagAdapterNew(Context context, List<? extends UserTag> list) {
        this.f20082a = LayoutInflater.from(context);
        this.b = list == null ? new ArrayList() : list;
        this.f20083c = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<? extends UserTag> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        List<? extends UserTag> list;
        View inflate = LayoutInflater.from(this.f20083c).inflate(R.layout.item_user_tag_new, viewGroup, false);
        ItemUserTagNewBinding a2 = ItemUserTagNewBinding.a(inflate);
        Intrinsics.c(a2, "bind(rootView)");
        Context context = this.f20083c;
        if (context != null && (list = this.b) != null) {
            ViewGroup.LayoutParams layoutParams = a2.f15649a.getLayoutParams();
            Intrinsics.c(layoutParams, "vb.itemView.layoutParams");
            layoutParams.width = (context.getResources().getDisplayMetrics().widthPixels - DensityUtils.a(context, 50.0f)) / 4;
            a2.f15649a.setLayoutParams(layoutParams);
            ShapeModel shapeModel = new ShapeModel();
            shapeModel.H = DensityUtils.a(context, 15.0f);
            shapeModel.q = DensityUtils.a(context, 2.0f);
            if (list.get(i).checked == 1) {
                shapeModel.k = BluedSkinUtils.a(context, 2131101780);
                shapeModel.n = BluedSkinUtils.a(context, 2131101766);
            } else {
                shapeModel.k = BluedSkinUtils.a(context, 2131102360);
                shapeModel.n = BluedSkinUtils.a(context, 2131102360);
            }
            a2.f15649a.setShapeModel(shapeModel);
            a2.b.setText(list.get(i).name);
            return inflate;
        }
        return inflate;
    }
}

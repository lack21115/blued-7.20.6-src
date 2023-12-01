package com.soft.blued.ui.find.adapter;

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
import com.soft.blued.databinding.ItemFilterCommonItemForGridViewBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/FilterCommonAdapterForGridView.class */
public final class FilterCommonAdapterForGridView extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f30038a;
    private List<? extends UserTag> b;

    public FilterCommonAdapterForGridView(Context context, List<? extends UserTag> list) {
        Intrinsics.e(context, "context");
        Intrinsics.e(list, "list");
        this.f30038a = context;
        this.b = list;
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
    public View getView(int i, View view, ViewGroup parent) {
        List<? extends UserTag> list;
        Intrinsics.e(parent, "parent");
        View inflate = LayoutInflater.from(this.f30038a).inflate(R.layout.item_filter_common_item_for_grid_view, parent, false);
        Intrinsics.c(inflate, "from(mContext).inflate(R…grid_view, parent, false)");
        Context context = this.f30038a;
        if (context != null && (list = this.b) != null) {
            ItemFilterCommonItemForGridViewBinding a2 = ItemFilterCommonItemForGridViewBinding.a(inflate);
            Intrinsics.c(a2, "bind(it)");
            UserTag userTag = list.get(i);
            ShapeModel shapeModel = new ShapeModel();
            shapeModel.H = DensityUtils.a(context, 12.0f);
            shapeModel.q = DensityUtils.a(context, 2.0f);
            if (userTag.checked == 1) {
                shapeModel.k = BluedSkinUtils.a(context, 2131101780);
                shapeModel.n = BluedSkinUtils.a(context, 2131101766);
            } else {
                shapeModel.k = BluedSkinUtils.a(context, 2131102360);
                shapeModel.n = BluedSkinUtils.a(context, 2131102360);
            }
            a2.f29174a.setShapeModel(shapeModel);
            a2.f29175c.setText(userTag.name);
            a2.b.setText(userTag.desc);
            return inflate;
        }
        return inflate;
    }
}

package com.soft.blued.ui.find.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.user.model.ConstellationModel;
import com.soft.blued.R;
import com.soft.blued.databinding.ItemFilterNewConstellationBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/FilterConstellationAdapter.class */
public final class FilterConstellationAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f30039a;
    private List<? extends ConstellationModel> b;

    /* renamed from: c  reason: collision with root package name */
    private int f30040c;

    public FilterConstellationAdapter(Context context, List<? extends ConstellationModel> list) {
        Intrinsics.e(context, "context");
        Intrinsics.e(list, "list");
        this.f30039a = context;
        this.b = list;
    }

    public final void a(int i) {
        this.f30040c = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<? extends ConstellationModel> list = this.b;
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
        List<? extends ConstellationModel> list;
        View rootView = LayoutInflater.from(this.f30039a).inflate(R.layout.item_filter_new_constellation, viewGroup, false);
        ItemFilterNewConstellationBinding a2 = ItemFilterNewConstellationBinding.a(rootView);
        Intrinsics.c(a2, "bind(rootView)");
        Context context = this.f30039a;
        if (context != null && (list = this.b) != null) {
            ViewGroup.LayoutParams layoutParams = a2.f29176a.getLayoutParams();
            Intrinsics.c(layoutParams, "vb.itemView.layoutParams");
            layoutParams.width = (context.getResources().getDisplayMetrics().widthPixels - DensityUtils.a(this.f30039a, 65.0f)) / 5;
            a2.f29176a.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = a2.b.getLayoutParams();
            layoutParams2.width = layoutParams.width;
            layoutParams2.height = layoutParams.width;
            a2.b.setLayoutParams(layoutParams2);
            ConstellationModel constellationModel = list.get(i);
            String str = BluedSkinUtils.c() ? constellationModel.icon : constellationModel.dark_icon;
            if (constellationModel.checked == 0) {
                str = BluedSkinUtils.c() ? constellationModel.icon_gray : constellationModel.dark_icon_gray;
            }
            ImageLoader.a((IRequestHost) null, str).a(a2.b);
            if (!TextUtils.isEmpty(constellationModel.name)) {
                a2.f29177c.setText(constellationModel.name);
            }
            a(a2.f29176a.getLayoutParams().height);
        }
        Intrinsics.c(rootView, "rootView");
        return rootView;
    }
}

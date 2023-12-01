package com.blued.android.module.yy_china.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAPlayer;
import com.blued.android.module.yy_china.databinding.ItemYyRelaiionshipRoomUiBinding;
import com.blued.android.module.yy_china.model.YYRelationShipRoomLevelInfoMode;
import com.blued.android.module.yy_china.model.YYRelationShipRoomUserLeveLInfoUiMode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/RelationRoomViewPageAdapter.class */
public final class RelationRoomViewPageAdapter extends PagerAdapter {
    private final List<YYRelationShipRoomLevelInfoMode> a;
    private int b;
    private final int c;

    private final int a() {
        return this.a.size();
    }

    private final void a(ItemYyRelaiionshipRoomUiBinding itemYyRelaiionshipRoomUiBinding, int i) {
        String str = null;
        if (i >= this.b) {
            itemYyRelaiionshipRoomUiBinding.b.setVisibility(0);
            YYRelationShipRoomUserLeveLInfoUiMode resource_options = this.a.get(i).getResource_options();
            SVGAPlayer.Builder builder = new SVGAPlayer.Builder(resource_options == null ? null : resource_options.getIcon_static());
            SVGAImageView sVGAImageView = itemYyRelaiionshipRoomUiBinding.a;
            Intrinsics.c(sVGAImageView, "v.iv");
            builder.a(sVGAImageView);
            return;
        }
        itemYyRelaiionshipRoomUiBinding.b.setVisibility(8);
        YYRelationShipRoomUserLeveLInfoUiMode resource_options2 = this.a.get(i).getResource_options();
        if (resource_options2 != null) {
            str = resource_options2.getIcon_animated();
        }
        SVGAPlayer.Builder builder2 = new SVGAPlayer.Builder(str);
        SVGAImageView sVGAImageView2 = itemYyRelaiionshipRoomUiBinding.a;
        Intrinsics.c(sVGAImageView2, "v.iv");
        builder2.a(sVGAImageView2);
    }

    public void destroyItem(ViewGroup container, int i, Object ob) {
        Intrinsics.e(container, "container");
        Intrinsics.e(ob, "ob");
        container.removeView((View) ob);
    }

    public int getCount() {
        return a() * this.c;
    }

    public Object instantiateItem(ViewGroup container, int i) {
        Intrinsics.e(container, "container");
        int a = a();
        ItemYyRelaiionshipRoomUiBinding a2 = ItemYyRelaiionshipRoomUiBinding.a(LayoutInflater.from(container.getContext()));
        Intrinsics.c(a2, "inflate(LayoutInflater.from(container.context))");
        a(a2, i % a);
        container.addView((View) a2.getRoot(), new ViewGroup.LayoutParams(-1, -1));
        ConstraintLayout root = a2.getRoot();
        Intrinsics.c(root, "v.getRoot()");
        return root;
    }

    public boolean isViewFromObject(View view, Object ob) {
        Intrinsics.e(view, "view");
        Intrinsics.e(ob, "ob");
        return Intrinsics.a(view, ob);
    }
}

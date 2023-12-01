package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.util.Log;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAPlayer;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ItemYyRelaiionshipRoomUiBinding;
import com.blued.android.module.yy_china.model.YYRelationShipRoomLevelInfoMode;
import com.blued.android.module.yy_china.model.YYRelationShipRoomUserLeveLInfoUiMode;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/RealtionRoomVIewFragment.class */
public final class RealtionRoomVIewFragment extends MvpFragment<MvpPresenter> {
    private ItemYyRelaiionshipRoomUiBinding a;
    private int b;
    private int c;
    private final ArrayList<YYRelationShipRoomLevelInfoMode> d = new ArrayList<>();

    private final void e() {
        ItemYyRelaiionshipRoomUiBinding itemYyRelaiionshipRoomUiBinding = this.a;
        if (itemYyRelaiionshipRoomUiBinding != null) {
            String str = null;
            if (c() < b()) {
                itemYyRelaiionshipRoomUiBinding.b.setVisibility(8);
                if (c() < d().size()) {
                    YYRelationShipRoomUserLeveLInfoUiMode resource_options = d().get(c()).getResource_options();
                    if (resource_options != null) {
                        str = resource_options.getIcon_animated();
                    }
                    SVGAPlayer.Builder builder = new SVGAPlayer.Builder(str);
                    SVGAImageView sVGAImageView = itemYyRelaiionshipRoomUiBinding.a;
                    Intrinsics.c(sVGAImageView, "v.iv");
                    builder.a(sVGAImageView);
                }
            } else {
                itemYyRelaiionshipRoomUiBinding.b.setVisibility(0);
                if (c() < d().size()) {
                    YYRelationShipRoomUserLeveLInfoUiMode resource_options2 = d().get(c()).getResource_options();
                    SVGAPlayer.Builder builder2 = new SVGAPlayer.Builder(resource_options2 == null ? null : resource_options2.getIcon_static());
                    SVGAImageView sVGAImageView2 = itemYyRelaiionshipRoomUiBinding.a;
                    Intrinsics.c(sVGAImageView2, "v.iv");
                    builder2.a(sVGAImageView2);
                }
            }
        }
        Log.e("@@@@@@@", "initView: ");
    }

    public final void a(int i) {
        this.b = i;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.a = ItemYyRelaiionshipRoomUiBinding.a(this.i);
        e();
    }

    public final int b() {
        return this.b;
    }

    public final void b(int i) {
        this.c = i;
    }

    public final int c() {
        return this.c;
    }

    public final ArrayList<YYRelationShipRoomLevelInfoMode> d() {
        return this.d;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.item_yy_relaiionship_room_ui;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onResume() {
        super.onResume();
        e();
    }
}

package com.blued.android.module.live.base.music.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.live.base.R;
import com.blued.android.module.live.base.databinding.ItemYyBackgroundMusicInfoBinding;
import com.blued.android.module.live.base.manager.YYMusicManager;
import com.blued.android.module.live.base.music.BlackMusicListener;
import com.blued.android.module.live.base.music.model.YYKtvMusicModel;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/music/adapter/YYBackgroundMusicListAdapter.class */
public final class YYBackgroundMusicListAdapter extends BaseMultiItemQuickAdapter<YYKtvMusicModel, BaseViewHolder> {
    private YYMusicEventCallBack a;
    private BlackMusicListener b;

    public YYBackgroundMusicListAdapter() {
        super((List) null);
        addItemType(0, R.layout.item_yy_background_music_info);
        addItemType(1, R.layout.live_music_item_no_more_view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYBackgroundMusicListAdapter this$0, YYKtvMusicModel yYKtvMusicModel, View view) {
        Intrinsics.e(this$0, "this$0");
        YYMusicEventCallBack yYMusicEventCallBack = this$0.a;
        if (yYMusicEventCallBack != null) {
            String str = yYKtvMusicModel.musicId;
            Intrinsics.c(str, "item.musicId");
            if (Intrinsics.a((Object) yYMusicEventCallBack.c(str), (Object) true)) {
                yYMusicEventCallBack.b(yYKtvMusicModel);
            } else {
                String str2 = yYKtvMusicModel.musicId;
                Intrinsics.c(str2, "item.musicId");
                if (Intrinsics.a((Object) yYMusicEventCallBack.a(str2), (Object) false)) {
                    YYMusicManager.a.c().a(this$0.getData());
                    yYMusicEventCallBack.a(yYKtvMusicModel);
                }
            }
            BlackMusicListener b = this$0.b();
            if (b != null) {
                b.a(yYKtvMusicModel.musicId);
            }
        }
        this$0.notifyDataSetChanged();
    }

    private final void b(BaseViewHolder baseViewHolder, final YYKtvMusicModel yYKtvMusicModel) {
        boolean a;
        boolean a2;
        boolean a3;
        ItemYyBackgroundMusicInfoBinding a4 = ItemYyBackgroundMusicInfoBinding.a(baseViewHolder.itemView);
        Intrinsics.c(a4, "bind(helper.itemView)");
        if (yYKtvMusicModel == null) {
            return;
        }
        ImageLoader.a((IRequestHost) null, yYKtvMusicModel.coverUrl).a((ImageView) a4.g);
        if (TextUtils.isEmpty(yYKtvMusicModel.musicName)) {
            a4.h.setText(this.mContext.getString(R.string.live_music_no_name));
        } else {
            a4.h.setText(yYKtvMusicModel.musicName);
        }
        if (TextUtils.isEmpty(yYKtvMusicModel.artist)) {
            a4.i.setText(this.mContext.getString(R.string.live_music_no_owner));
        } else {
            a4.i.setText(yYKtvMusicModel.artist);
        }
        a4.c.setVisibility(TextUtils.equals("Featured", yYKtvMusicModel.recommendType) ? 0 : 8);
        ShapeModel shapeModel = new ShapeModel();
        if (YYMusicManager.a.c().c()) {
            shapeModel.t = ContextCompat.getColor(this.mContext, R.color.syc_dark_922cee);
            shapeModel.v = ContextCompat.getColor(this.mContext, R.color.syc_dark_ff3aaa);
        } else {
            shapeModel.t = ContextCompat.getColor(this.mContext, R.color.syc_00E0AB);
            shapeModel.v = ContextCompat.getColor(this.mContext, R.color.syc_3883FD);
        }
        shapeModel.b = ContextCompat.getColor(this.mContext, R.color.syc_dark_b);
        shapeModel.H = DensityUtils.a(this.mContext, 16.0f);
        a4.f.setShapeModel(shapeModel);
        a4.d.setShapeModel(shapeModel);
        if (a() != null) {
            YYMusicEventCallBack a5 = a();
            if (a5 == null) {
                a = false;
            } else {
                String str = yYKtvMusicModel.musicId;
                Intrinsics.c(str, "item.musicId");
                a = Intrinsics.a((Object) a5.a(str), (Object) true);
            }
            if (!a) {
                YYMusicEventCallBack a6 = a();
                if (a6 == null) {
                    a2 = false;
                } else {
                    String str2 = yYKtvMusicModel.musicId;
                    Intrinsics.c(str2, "item.musicId");
                    a2 = Intrinsics.a((Object) a6.c(str2), (Object) true);
                }
                if (!a2) {
                    YYMusicEventCallBack a7 = a();
                    if (a7 == null) {
                        a3 = false;
                    } else {
                        String str3 = yYKtvMusicModel.musicId;
                        Intrinsics.c(str3, "item.musicId");
                        a3 = Intrinsics.a((Object) a7.b(str3), (Object) true);
                    }
                    if (a3) {
                        a4.f.setVisibility(8);
                        a4.e.setVisibility(8);
                        a4.d.setVisibility(0);
                    } else {
                        a4.f.setVisibility(0);
                        a4.e.setVisibility(8);
                        a4.d.setVisibility(8);
                    }
                }
            }
            a4.f.setVisibility(8);
            a4.e.setVisibility(0);
            a4.d.setVisibility(8);
            YYMusicManager.a.c().a(getData());
        } else {
            a4.f.setVisibility(0);
            a4.e.setVisibility(8);
            a4.d.setVisibility(8);
        }
        a4.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live.base.music.adapter.-$$Lambda$YYBackgroundMusicListAdapter$_Mg4q4Mplj7D5njv7fGRA8f1o6A
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYBackgroundMusicListAdapter.a(YYBackgroundMusicListAdapter.this, yYKtvMusicModel, view);
            }
        });
    }

    public final YYMusicEventCallBack a() {
        return this.a;
    }

    public final void a(BlackMusicListener blackMusicListener) {
        this.b = blackMusicListener;
    }

    public final void a(YYMusicEventCallBack yYMusicEventCallBack) {
        this.a = yYMusicEventCallBack;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, YYKtvMusicModel yYKtvMusicModel) {
        if (baseViewHolder != null && baseViewHolder.getItemViewType() == 0) {
            b(baseViewHolder, yYKtvMusicModel);
        }
    }

    public final void a(List<? extends YYKtvMusicModel> list) {
        if (list != null) {
            Logger.b("==abc", Intrinsics.a("models.szie:", (Object) Integer.valueOf(list.size())));
        }
        setNewData(list);
        setEnableLoadMore(false);
    }

    public final BlackMusicListener b() {
        return this.b;
    }

    public final int c() {
        if (getData() != null) {
            return getData().size();
        }
        return 0;
    }
}

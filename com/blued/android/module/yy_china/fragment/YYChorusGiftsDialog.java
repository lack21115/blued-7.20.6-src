package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogChorusGiftsLayoutBinding;
import com.blued.android.module.yy_china.fragment.YYChorusGiftsDialog;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYChorusGoodsModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYChorusGiftsDialog.class */
public final class YYChorusGiftsDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private DialogChorusGiftsLayoutBinding f17128a;
    private GiftsAdapter b;

    /* renamed from: c  reason: collision with root package name */
    private YYChorusGoodsModel f17129c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYChorusGiftsDialog$GiftsAdapter.class */
    public final class GiftsAdapter extends BaseQuickAdapter<YYChorusGoodsModel, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYChorusGiftsDialog f17130a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GiftsAdapter(YYChorusGiftsDialog this$0) {
            super(R.layout.item_chorus_gift_layout);
            Intrinsics.e(this$0, "this$0");
            this.f17130a = this$0;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, YYChorusGoodsModel yYChorusGoodsModel) {
            ImageView imageView = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.img_item_selected_bg);
            ImageView imageView2 = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.img_item_gift);
            TextView textView = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_gift_name);
            TextView textView2 = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_gift_price);
            if (yYChorusGoodsModel == null) {
                return;
            }
            YYChorusGiftsDialog yYChorusGiftsDialog = this.f17130a;
            if (yYChorusGoodsModel.getSelected()) {
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
            } else if (imageView != null) {
                imageView.setVisibility(4);
            }
            ImageLoader.a(yYChorusGiftsDialog.a(), yYChorusGoodsModel.images_static).a(imageView2);
            if (textView != null) {
                textView.setText(yYChorusGoodsModel.name);
            }
            if (textView2 == null) {
                return;
            }
            textView2.setText(String.valueOf(yYChorusGoodsModel.beans));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYChorusGiftsDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYChorusGiftsDialog this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        GiftsAdapter giftsAdapter = this$0.b;
        GiftsAdapter giftsAdapter2 = giftsAdapter;
        if (giftsAdapter == null) {
            Intrinsics.c("mAdapter");
            giftsAdapter2 = null;
        }
        for (YYChorusGoodsModel yYChorusGoodsModel : giftsAdapter2.getData()) {
            yYChorusGoodsModel.setSelected(false);
        }
        GiftsAdapter giftsAdapter3 = this$0.b;
        GiftsAdapter giftsAdapter4 = giftsAdapter3;
        if (giftsAdapter3 == null) {
            Intrinsics.c("mAdapter");
            giftsAdapter4 = null;
        }
        this$0.f17129c = giftsAdapter4.getData().get(i);
        GiftsAdapter giftsAdapter5 = this$0.b;
        GiftsAdapter giftsAdapter6 = giftsAdapter5;
        if (giftsAdapter5 == null) {
            Intrinsics.c("mAdapter");
            giftsAdapter6 = null;
        }
        giftsAdapter6.getData().get(i).setSelected(true);
        GiftsAdapter giftsAdapter7 = this$0.b;
        if (giftsAdapter7 == null) {
            Intrinsics.c("mAdapter");
            giftsAdapter7 = null;
        }
        giftsAdapter7.notifyDataSetChanged();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0080, code lost:
        if (r0 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01e7, code lost:
        if (r0 == null) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void a(java.lang.String r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 535
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YYChorusGiftsDialog.a(java.lang.String, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYChorusGiftsDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.f17129c == null) {
            return;
        }
        this$0.a("", false);
    }

    private final void f() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        String str = b == null ? null : b.room_id;
        final ActivityFragmentActive a2 = a();
        YYRoomHttpUtils.V(str, new BluedUIHttpResponse<BluedEntityA<YYChorusGoodsModel>>(a2) { // from class: com.blued.android.module.yy_china.fragment.YYChorusGiftsDialog$loadGiftList$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYChorusGoodsModel> bluedEntityA) {
                YYChorusGiftsDialog.GiftsAdapter giftsAdapter;
                if (bluedEntityA == null) {
                    return;
                }
                bluedEntityA.data.get(0).setSelected(true);
                YYChorusGiftsDialog.this.f17129c = bluedEntityA.data.get(0);
                giftsAdapter = YYChorusGiftsDialog.this.b;
                YYChorusGiftsDialog.GiftsAdapter giftsAdapter2 = giftsAdapter;
                if (giftsAdapter == null) {
                    Intrinsics.c("mAdapter");
                    giftsAdapter2 = null;
                }
                giftsAdapter2.setNewData(bluedEntityA.data);
            }
        }, a());
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        DialogChorusGiftsLayoutBinding dialogChorusGiftsLayoutBinding = null;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_chorus_gifts_layout, (ViewGroup) null);
        DialogChorusGiftsLayoutBinding a2 = DialogChorusGiftsLayoutBinding.a(inflate);
        Intrinsics.c(a2, "bind(view)");
        this.f17128a = a2;
        if (a2 == null) {
            Intrinsics.c("mBinding");
        } else {
            dialogChorusGiftsLayoutBinding = a2;
        }
        dialogChorusGiftsLayoutBinding.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYChorusGiftsDialog$_WVFRO1LRjoZK8rq49hUMvYzIrU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYChorusGiftsDialog.a(YYChorusGiftsDialog.this, view);
            }
        });
        return inflate;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        this.b = new GiftsAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        DialogChorusGiftsLayoutBinding dialogChorusGiftsLayoutBinding = this.f17128a;
        DialogChorusGiftsLayoutBinding dialogChorusGiftsLayoutBinding2 = dialogChorusGiftsLayoutBinding;
        if (dialogChorusGiftsLayoutBinding == null) {
            Intrinsics.c("mBinding");
            dialogChorusGiftsLayoutBinding2 = null;
        }
        dialogChorusGiftsLayoutBinding2.f16306c.setLayoutManager(gridLayoutManager);
        DialogChorusGiftsLayoutBinding dialogChorusGiftsLayoutBinding3 = this.f17128a;
        DialogChorusGiftsLayoutBinding dialogChorusGiftsLayoutBinding4 = dialogChorusGiftsLayoutBinding3;
        if (dialogChorusGiftsLayoutBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogChorusGiftsLayoutBinding4 = null;
        }
        RecyclerView recyclerView = dialogChorusGiftsLayoutBinding4.f16306c;
        GiftsAdapter giftsAdapter = this.b;
        GiftsAdapter giftsAdapter2 = giftsAdapter;
        if (giftsAdapter == null) {
            Intrinsics.c("mAdapter");
            giftsAdapter2 = null;
        }
        recyclerView.setAdapter(giftsAdapter2);
        GiftsAdapter giftsAdapter3 = this.b;
        GiftsAdapter giftsAdapter4 = giftsAdapter3;
        if (giftsAdapter3 == null) {
            Intrinsics.c("mAdapter");
            giftsAdapter4 = null;
        }
        giftsAdapter4.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYChorusGiftsDialog$8XWxXc14Njiou2r1cWfbRIbLJY8
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                YYChorusGiftsDialog.a(YYChorusGiftsDialog.this, baseQuickAdapter, view2, i);
            }
        });
        DialogChorusGiftsLayoutBinding dialogChorusGiftsLayoutBinding5 = this.f17128a;
        if (dialogChorusGiftsLayoutBinding5 == null) {
            Intrinsics.c("mBinding");
            dialogChorusGiftsLayoutBinding5 = null;
        }
        dialogChorusGiftsLayoutBinding5.f16305a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYChorusGiftsDialog$GrNboiCVlvgEi94hUfOhmLbps9s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYChorusGiftsDialog.b(YYChorusGiftsDialog.this, view2);
            }
        });
        f();
    }
}

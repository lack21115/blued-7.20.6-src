package com.blued.android.module.yy_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.anythink.core.common.g.c;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.live.base.constants.LiveEventBusConstant;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.YYConstants;
import com.blued.android.module.yy_china.databinding.FragmentPageCarBinding;
import com.blued.android.module.yy_china.fragment.YYDecorateCarFragment;
import com.blued.android.module.yy_china.listener.ITextWatcher;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.ConfigBean;
import com.blued.android.module.yy_china.model.GoodsModel;
import com.blued.android.module.yy_china.model.HonorInfo;
import com.blued.android.module.yy_china.model.YYCarBasicModel;
import com.blued.android.module.yy_china.model.YYCarItemModel;
import com.blued.android.module.yy_china.model.YYCarPreviewModel;
import com.blued.android.module.yy_china.model.YYCarTabModel;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYPayGoodsModel;
import com.blued.android.module.yy_china.model.YYPayRequestModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.utils.YYPayUtils;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.JsonObject;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYDecorateCarFragment.class */
public final class YYDecorateCarFragment extends BaseLazyFragment {
    private FragmentPageCarBinding b;
    private TabAdapter c;
    private CarAdapter d;
    private ColorAdapter e;
    private ReceiverAdapter f;
    private YYCarPreviewModel g;
    private YYCarBasicModel h;
    private YYCarItemModel i;
    private final String a = "YYDecorateCarFragment";
    private String j = "";
    private int k = -1;
    private String l = "0";
    private String m = "";
    private boolean n = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYDecorateCarFragment$CarAdapter.class */
    public final class CarAdapter extends BaseQuickAdapter<YYCarItemModel, BaseViewHolder> {
        final /* synthetic */ YYDecorateCarFragment a;
        private final int b;
        private final int c;
        private final int d;
        private final int e;
        private final int f;
        private final int g;
        private final int h;
        private final int i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CarAdapter(YYDecorateCarFragment this$0) {
            super(R.layout.item_car_style_layout);
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
            this.b = DensityUtils.a(this.a.getContext(), 73.0f);
            this.c = DensityUtils.a(this.a.getContext(), 51.0f);
            this.d = DensityUtils.a(this.a.getContext(), 81.0f);
            this.e = DensityUtils.a(this.a.getContext(), 56.0f);
            this.f = DensityUtils.a(this.a.getContext(), 25.0f);
            this.g = DensityUtils.a(this.a.getContext(), 17.0f);
            this.h = DensityUtils.a(this.a.getContext(), 10.0f);
            this.i = DensityUtils.a(this.a.getContext(), 20.0f);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, YYCarItemModel yYCarItemModel) {
            ConstraintLayout view = baseViewHolder == null ? null : baseViewHolder.getView(R.id.item_root_view);
            ImageView imageView = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.img_car);
            ImageView imageView2 = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.img_car_name);
            TextView textView = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_car_price);
            ViewGroup.LayoutParams layoutParams = imageView == null ? null : imageView.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.LayoutParams layoutParams2 = layoutParams;
            ViewGroup.LayoutParams layoutParams3 = imageView2 == null ? null : imageView2.getLayoutParams();
            if (layoutParams3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.LayoutParams layoutParams4 = layoutParams3;
            if (yYCarItemModel == null) {
                return;
            }
            YYDecorateCarFragment yYDecorateCarFragment = this.a;
            if (textView != null) {
                textView.setText(yYCarItemModel.getBeans());
            }
            ImageLoader.a(yYDecorateCarFragment.getFragmentActive(), yYCarItemModel.getIcon()).a(imageView);
            if (yYCarItemModel.getSelected()) {
                layoutParams2.width = this.d;
                layoutParams2.height = this.e;
                layoutParams2.topMargin = this.g;
                if (view != null) {
                    view.setBackgroundResource(R.drawable.icon_car_item_selected);
                }
                layoutParams4.leftMargin = this.i;
                layoutParams4.bottomMargin = this.i;
                ImageLoader.a(yYDecorateCarFragment.getFragmentActive(), yYCarItemModel.getName_selected_icon()).a(imageView2);
                return;
            }
            layoutParams2.width = this.b;
            layoutParams2.height = this.c;
            layoutParams2.topMargin = this.f;
            if (view != null) {
                view.setBackgroundResource(R.drawable.icon_car_item_normal);
            }
            layoutParams4.leftMargin = this.h;
            layoutParams4.bottomMargin = this.g;
            ImageLoader.a(yYDecorateCarFragment.getFragmentActive(), yYCarItemModel.getName_un_selected_icon()).a(imageView2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYDecorateCarFragment$ColorAdapter.class */
    public final class ColorAdapter extends BaseQuickAdapter<YYCarItemModel, BaseViewHolder> {
        final /* synthetic */ YYDecorateCarFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ColorAdapter(YYDecorateCarFragment this$0) {
            super(R.layout.item_car_color_layout);
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, YYCarItemModel yYCarItemModel) {
            ConstraintLayout view = baseViewHolder == null ? null : baseViewHolder.getView(R.id.item_root_view);
            TextView textView = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_color_name);
            ImageView imageView = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.item_car_color);
            if (yYCarItemModel == null) {
                return;
            }
            YYDecorateCarFragment yYDecorateCarFragment = this.a;
            if (textView != null) {
                textView.setText(yYCarItemModel.getName());
            }
            ImageLoader.a(yYDecorateCarFragment.getFragmentActive(), yYCarItemModel.getImage()).a(imageView);
            if (view == null) {
                return;
            }
            view.setBackgroundResource(yYCarItemModel.getSelected() ? R.drawable.icon_car_color_selected : R.drawable.icon_car_color_normal);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYDecorateCarFragment$ReceiverAdapter.class */
    public final class ReceiverAdapter extends BaseQuickAdapter<YYSeatMemberModel, BaseViewHolder> {
        final /* synthetic */ YYDecorateCarFragment a;
        private int b;
        private int c;
        private int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReceiverAdapter(YYDecorateCarFragment this$0) {
            super(R.layout.item_car_receiver_layout);
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
            this.b = DensityUtils.a(this.a.getContext(), 8.0f);
            this.c = DensityUtils.a(this.a.getContext(), 1.0f);
            this.d = DensityUtils.a(this.a.getContext(), 14.0f);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, YYSeatMemberModel yYSeatMemberModel) {
            ConstraintLayout view = baseViewHolder == null ? null : baseViewHolder.getView(R.id.item_root_view);
            ImageView imageView = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.img_receiver_portrait);
            ImageView imageView2 = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.img_checked_symbol);
            TextView textView = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_role_text);
            CardView view2 = baseViewHolder == null ? null : baseViewHolder.getView(R.id.ll_portrait_layout);
            if (yYSeatMemberModel != null && yYSeatMemberModel.isSelected) {
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
                if (view2 != null) {
                    view2.setContentPadding(0, 0, 0, 0);
                }
            } else {
                if (imageView2 != null) {
                    imageView2.setVisibility(4);
                }
                if (view2 != null) {
                    int i = this.c;
                    view2.setContentPadding(i, i, i, i);
                }
            }
            YYRoomInfoManager.e().a(this.a.getFragmentActive(), imageView, yYSeatMemberModel == null ? null : yYSeatMemberModel.getUid(), yYSeatMemberModel == null ? null : yYSeatMemberModel.getAvatar());
            ViewGroup.LayoutParams layoutParams = view == null ? null : view.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            }
            RecyclerView.LayoutParams layoutParams2 = layoutParams;
            if (baseViewHolder.getAdapterPosition() == 0) {
                layoutParams2.leftMargin = this.d;
            } else {
                layoutParams2.leftMargin = 0;
            }
            layoutParams2.rightMargin = this.b;
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b == null) {
                return;
            }
            if ((baseViewHolder != null && baseViewHolder.getAdapterPosition() == 0) && TextUtils.equals(b.chat_type, "9")) {
                if (yYSeatMemberModel != null && yYSeatMemberModel.mic_position == 0) {
                    if (textView != null) {
                        textView.setText("主持人");
                    }
                    if (textView == null) {
                        return;
                    }
                    textView.setVisibility(0);
                    return;
                }
            }
            if (!TextUtils.equals(yYSeatMemberModel == null ? null : yYSeatMemberModel.getUid(), b.uid)) {
                if (textView == null) {
                    return;
                }
                textView.setVisibility(4);
                return;
            }
            if (textView != null) {
                textView.setText("房主");
            }
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYDecorateCarFragment$TabAdapter.class */
    public final class TabAdapter extends BaseQuickAdapter<YYCarTabModel, BaseViewHolder> {
        final /* synthetic */ YYDecorateCarFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TabAdapter(YYDecorateCarFragment this$0) {
            super(R.layout.view_decorate_car_tab);
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, YYCarTabModel yYCarTabModel) {
            TextView textView = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_tab_name);
            ImageView imageView = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.img_checked_tab);
            View view = baseViewHolder == null ? null : baseViewHolder.getView(R.id.img_point);
            if (yYCarTabModel == null) {
                return;
            }
            YYDecorateCarFragment yYDecorateCarFragment = this.a;
            if (textView != null) {
                textView.setText(yYCarTabModel.getName());
            }
            int i = 0;
            if (yYCarTabModel.getStatus() == 1) {
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                if (textView != null) {
                    textView.setTextColor(yYDecorateCarFragment.getResources().getColor(R.color.syc_00EBFF));
                }
                if (textView != null) {
                    textView.setTextSize(17.0f);
                }
            } else {
                if (imageView != null) {
                    imageView.setVisibility(4);
                }
                if (textView != null) {
                    textView.setTextColor(yYDecorateCarFragment.getResources().getColor(R.color.syc_3B97EF));
                }
                if (textView != null) {
                    textView.setTextSize(15.0f);
                }
            }
            if (view == null) {
                return;
            }
            if (yYCarTabModel.getComplete_status() != 1) {
                i = 4;
            }
            view.setVisibility(i);
        }
    }

    private final void a(int i) {
        this.k = i;
        o();
        TabAdapter tabAdapter = this.c;
        TabAdapter tabAdapter2 = tabAdapter;
        if (tabAdapter == null) {
            Intrinsics.c("tabAdapter");
            tabAdapter2 = null;
        }
        ((YYCarTabModel) tabAdapter2.getData().get(3)).setComplete_status(1);
        FragmentPageCarBinding fragmentPageCarBinding = this.b;
        FragmentPageCarBinding fragmentPageCarBinding2 = fragmentPageCarBinding;
        if (fragmentPageCarBinding == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding2 = null;
        }
        fragmentPageCarBinding2.s.setBackgroundResource(i == 0 ? R.drawable.icon_car_portrait_selected : R.drawable.icon_car_portrait_normal);
        FragmentPageCarBinding fragmentPageCarBinding3 = this.b;
        if (fragmentPageCarBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding3 = null;
        }
        fragmentPageCarBinding3.t.setBackgroundResource(i == 0 ? R.drawable.icon_car_portrait_normal : R.drawable.icon_car_portrait_selected);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYDecorateCarFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.c();
        FragmentPageCarBinding fragmentPageCarBinding = this$0.b;
        FragmentPageCarBinding fragmentPageCarBinding2 = fragmentPageCarBinding;
        if (fragmentPageCarBinding == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding2 = null;
        }
        fragmentPageCarBinding2.z.clearFocus();
        FragmentPageCarBinding fragmentPageCarBinding3 = this$0.b;
        if (fragmentPageCarBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding3 = null;
        }
        this$0.a(StringsKt.b((CharSequence) fragmentPageCarBinding3.z.getText().toString()).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYDecorateCarFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Boolean valueOf;
        Intrinsics.e(this$0, "this$0");
        CarAdapter carAdapter = this$0.d;
        CarAdapter carAdapter2 = carAdapter;
        if (carAdapter == null) {
            Intrinsics.c("carAdapter");
            carAdapter2 = null;
        }
        YYCarItemModel yYCarItemModel = (YYCarItemModel) carAdapter2.getData().get(i);
        YYCarItemModel yYCarItemModel2 = this$0.i;
        if (TextUtils.equals(yYCarItemModel2 == null ? null : yYCarItemModel2.getId(), yYCarItemModel == null ? null : yYCarItemModel.getId())) {
            CarAdapter carAdapter3 = this$0.d;
            CarAdapter carAdapter4 = carAdapter3;
            if (carAdapter3 == null) {
                Intrinsics.c("carAdapter");
                carAdapter4 = null;
            }
            YYCarItemModel yYCarItemModel3 = (YYCarItemModel) carAdapter4.getData().get(i);
            Intrinsics.a(yYCarItemModel == null ? null : Boolean.valueOf(yYCarItemModel.getSelected()));
            yYCarItemModel3.setSelected(!valueOf.booleanValue());
            CarAdapter carAdapter5 = this$0.d;
            CarAdapter carAdapter6 = carAdapter5;
            if (carAdapter5 == null) {
                Intrinsics.c("carAdapter");
                carAdapter6 = null;
            }
            carAdapter6.notifyItemChanged(i);
            CarAdapter carAdapter7 = this$0.d;
            CarAdapter carAdapter8 = carAdapter7;
            if (carAdapter7 == null) {
                Intrinsics.c("carAdapter");
                carAdapter8 = null;
            }
            if (!((YYCarItemModel) carAdapter8.getData().get(i)).getSelected()) {
                this$0.i = null;
                TabAdapter tabAdapter = this$0.c;
                if (tabAdapter == null) {
                    Intrinsics.c("tabAdapter");
                    tabAdapter = null;
                }
                ((YYCarTabModel) tabAdapter.getData().get(0)).setComplete_status(0);
            }
        } else {
            CarAdapter carAdapter9 = this$0.d;
            CarAdapter carAdapter10 = carAdapter9;
            if (carAdapter9 == null) {
                Intrinsics.c("carAdapter");
                carAdapter10 = null;
            }
            for (YYCarItemModel yYCarItemModel4 : carAdapter10.getData()) {
                yYCarItemModel4.setSelected(false);
            }
            CarAdapter carAdapter11 = this$0.d;
            CarAdapter carAdapter12 = carAdapter11;
            if (carAdapter11 == null) {
                Intrinsics.c("carAdapter");
                carAdapter12 = null;
            }
            ((YYCarItemModel) carAdapter12.getData().get(i)).setSelected(true);
            CarAdapter carAdapter13 = this$0.d;
            CarAdapter carAdapter14 = carAdapter13;
            if (carAdapter13 == null) {
                Intrinsics.c("carAdapter");
                carAdapter14 = null;
            }
            this$0.i = (YYCarItemModel) carAdapter14.getData().get(i);
            TabAdapter tabAdapter2 = this$0.c;
            TabAdapter tabAdapter3 = tabAdapter2;
            if (tabAdapter2 == null) {
                Intrinsics.c("tabAdapter");
                tabAdapter3 = null;
            }
            ((YYCarTabModel) tabAdapter3.getData().get(0)).setComplete_status(1);
            CarAdapter carAdapter15 = this$0.d;
            if (carAdapter15 == null) {
                Intrinsics.c("carAdapter");
                carAdapter15 = null;
            }
            carAdapter15.notifyDataSetChanged();
        }
        this$0.o();
        this$0.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYDecorateCarFragment this$0, String noName_0, Bundle noName_1) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(noName_0, "$noName_0");
        Intrinsics.e(noName_1, "$noName_1");
        LogUtils.d(Intrinsics.a(this$0.a, (Object) " close keyboard ..."));
        this$0.c();
    }

    private final void a(final String str) {
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        YYRoomHttpUtils.x(str, "53", new BluedUIHttpResponse<BluedEntityA<Object>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YYDecorateCarFragment$checkWords$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                FragmentPageCarBinding fragmentPageCarBinding;
                YYDecorateCarFragment.TabAdapter tabAdapter;
                String str2;
                YYDecorateCarFragment.this.j = str;
                fragmentPageCarBinding = YYDecorateCarFragment.this.b;
                FragmentPageCarBinding fragmentPageCarBinding2 = fragmentPageCarBinding;
                if (fragmentPageCarBinding == null) {
                    Intrinsics.c("mBinding");
                    fragmentPageCarBinding2 = null;
                }
                fragmentPageCarBinding2.L.setText(str);
                tabAdapter = YYDecorateCarFragment.this.c;
                YYDecorateCarFragment.TabAdapter tabAdapter2 = tabAdapter;
                if (tabAdapter2 == null) {
                    Intrinsics.c("tabAdapter");
                    tabAdapter2 = null;
                }
                str2 = YYDecorateCarFragment.this.j;
                ((YYCarTabModel) tabAdapter2.getData().get(2)).setComplete_status(!TextUtils.isEmpty(str2) ? 1 : 0);
                YYDecorateCarFragment.this.o();
                ToastUtils.a("保存成功");
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str2) {
                FragmentPageCarBinding fragmentPageCarBinding;
                YYDecorateCarFragment.TabAdapter tabAdapter;
                fragmentPageCarBinding = YYDecorateCarFragment.this.b;
                FragmentPageCarBinding fragmentPageCarBinding2 = fragmentPageCarBinding;
                if (fragmentPageCarBinding == null) {
                    Intrinsics.c("mBinding");
                    fragmentPageCarBinding2 = null;
                }
                fragmentPageCarBinding2.z.setText("");
                YYDecorateCarFragment.this.j = "";
                tabAdapter = YYDecorateCarFragment.this.c;
                YYDecorateCarFragment.TabAdapter tabAdapter2 = tabAdapter;
                if (tabAdapter2 == null) {
                    Intrinsics.c("tabAdapter");
                    tabAdapter2 = null;
                }
                ((YYCarTabModel) tabAdapter2.getData().get(2)).setComplete_status(0);
                return super.onUIFailure(i, str2);
            }
        }, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final String str, final boolean z, final ArrayList<YYSeatMemberModel> arrayList, boolean z2) {
        GoodsModel goods_id;
        YYRoomModel b;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        final YYGiftModel yYGiftModel = new YYGiftModel();
        YYCarBasicModel yYCarBasicModel = this.h;
        yYGiftModel.goods_id = (yYCarBasicModel == null || (goods_id = yYCarBasicModel.getGoods_id()) == null) ? null : goods_id.getAndroid();
        yYGiftModel.beans = StringUtils.a(this.m, 0L);
        yYGiftModel.goods_type = 0;
        yYGiftModel.count = 1;
        yYGiftModel.hit_id = 0L;
        YYCarPreviewModel yYCarPreviewModel = this.g;
        yYGiftModel.images_static = yYCarPreviewModel == null ? null : yYCarPreviewModel.getIcon();
        YYCarPreviewModel yYCarPreviewModel2 = this.g;
        yYGiftModel.images_mp4 = yYCarPreviewModel2 == null ? null : yYCarPreviewModel2.getSpecial_effects();
        yYGiftModel.is_luck_gift = 2;
        yYGiftModel.description = this.j;
        YYPayRequestModel yYPayRequestModel = new YYPayRequestModel();
        yYPayRequestModel.gift = yYGiftModel;
        yYPayRequestModel.beans = yYGiftModel.beans;
        yYPayRequestModel.giftCount = 1;
        yYPayRequestModel.goods_id = yYGiftModel.goods_id;
        yYPayRequestModel.goods_type = yYGiftModel.goods_type;
        yYPayRequestModel.hit_id = 0L;
        yYPayRequestModel.payCode = str;
        yYPayRequestModel.remember_me = z;
        YYRoomModel b2 = YYRoomInfoManager.e().b();
        yYPayRequestModel.room_id = b2 == null ? null : b2.room_id;
        yYPayRequestModel.target_uid = arrayList.get(0).getUid();
        yYPayRequestModel.pay_from = 1;
        JsonObject jsonObject = new JsonObject();
        YYCarItemModel yYCarItemModel = this.i;
        jsonObject.addProperty("skin_id", yYCarItemModel == null ? "0" : yYCarItemModel == null ? null : yYCarItemModel.getId());
        jsonObject.addProperty("color_id", this.l);
        int i = this.k;
        String f = i != 0 ? i != 1 ? "" : f() : e();
        jsonObject.addProperty(ReqAckPackage.REQ_RESPONSE_KEY.AVATAR, f);
        jsonObject.addProperty(c.Y, this.j);
        yYGiftModel.goodsDescribe = f;
        yYPayRequestModel.extra_contents = jsonObject.toString();
        if (z2 && (b = YYRoomInfoManager.e().b()) != null) {
            EventTrackYY.k(ChatRoomProtos.Event.YY_MADE_CAR_PAGE_SEND_CLICK, b.room_id, b.uid, yYPayRequestModel.extra_contents, this.m);
        }
        YYPayUtils.a(yYPayRequestModel, YYConstants.PayFromSource.Pay_Gift, this, getFragmentActive(), new YYPayUtils.PayGiftStatusListener() { // from class: com.blued.android.module.yy_china.fragment.YYDecorateCarFragment$toPayGoods$2
            @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
            public void a(int i2, String str2) {
                this.g = null;
            }

            @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
            public void a(YYPayGoodsModel yYPayGoodsModel) {
                YYSeatMemberModel remove = arrayList.remove(0);
                Intrinsics.c(remove, "targetUsers.removeAt(0)");
                YYImMsgManager.a().a(yYGiftModel, remove, yYPayGoodsModel, false);
                if (arrayList.size() > 0) {
                    this.a(str, z, arrayList, false);
                } else {
                    LiveEventBus.get(LiveEventBusConstant.d).post("");
                }
            }
        });
    }

    private final void b() {
        FragmentPageCarBinding fragmentPageCarBinding = this.b;
        FragmentPageCarBinding fragmentPageCarBinding2 = fragmentPageCarBinding;
        if (fragmentPageCarBinding == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding2 = null;
        }
        fragmentPageCarBinding2.m.setEnabled(false);
        FragmentPageCarBinding fragmentPageCarBinding3 = this.b;
        FragmentPageCarBinding fragmentPageCarBinding4 = fragmentPageCarBinding3;
        if (fragmentPageCarBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding4 = null;
        }
        fragmentPageCarBinding4.z.addTextChangedListener(new ITextWatcher() { // from class: com.blued.android.module.yy_china.fragment.YYDecorateCarFragment$initSignatureLayout$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj;
                FragmentPageCarBinding fragmentPageCarBinding5;
                FragmentPageCarBinding fragmentPageCarBinding6;
                FragmentPageCarBinding fragmentPageCarBinding7;
                FragmentPageCarBinding fragmentPageCarBinding8;
                YYDecorateCarFragment.TabAdapter tabAdapter;
                FragmentPageCarBinding fragmentPageCarBinding9;
                FragmentPageCarBinding fragmentPageCarBinding10;
                if (!TextUtils.isEmpty((editable == null || (obj = editable.toString()) == null) ? null : StringsKt.b((CharSequence) obj).toString())) {
                    fragmentPageCarBinding5 = YYDecorateCarFragment.this.b;
                    FragmentPageCarBinding fragmentPageCarBinding11 = fragmentPageCarBinding5;
                    if (fragmentPageCarBinding5 == null) {
                        Intrinsics.c("mBinding");
                        fragmentPageCarBinding11 = null;
                    }
                    if (!fragmentPageCarBinding11.m.isEnabled()) {
                        fragmentPageCarBinding7 = YYDecorateCarFragment.this.b;
                        FragmentPageCarBinding fragmentPageCarBinding12 = fragmentPageCarBinding7;
                        if (fragmentPageCarBinding7 == null) {
                            Intrinsics.c("mBinding");
                            fragmentPageCarBinding12 = null;
                        }
                        fragmentPageCarBinding12.m.setEnabled(true);
                    }
                    fragmentPageCarBinding6 = YYDecorateCarFragment.this.b;
                    FragmentPageCarBinding fragmentPageCarBinding13 = fragmentPageCarBinding6;
                    if (fragmentPageCarBinding13 == null) {
                        Intrinsics.c("mBinding");
                        fragmentPageCarBinding13 = null;
                    }
                    fragmentPageCarBinding13.m.setImageResource(R.drawable.icon_car_signature_save_light);
                    return;
                }
                fragmentPageCarBinding8 = YYDecorateCarFragment.this.b;
                FragmentPageCarBinding fragmentPageCarBinding14 = fragmentPageCarBinding8;
                if (fragmentPageCarBinding8 == null) {
                    Intrinsics.c("mBinding");
                    fragmentPageCarBinding14 = null;
                }
                fragmentPageCarBinding14.m.setImageResource(R.drawable.icon_car_signature_save_normal);
                YYDecorateCarFragment.this.j = "";
                tabAdapter = YYDecorateCarFragment.this.c;
                YYDecorateCarFragment.TabAdapter tabAdapter2 = tabAdapter;
                if (tabAdapter == null) {
                    Intrinsics.c("tabAdapter");
                    tabAdapter2 = null;
                }
                ((YYCarTabModel) tabAdapter2.getData().get(2)).setComplete_status(0);
                fragmentPageCarBinding9 = YYDecorateCarFragment.this.b;
                FragmentPageCarBinding fragmentPageCarBinding15 = fragmentPageCarBinding9;
                if (fragmentPageCarBinding9 == null) {
                    Intrinsics.c("mBinding");
                    fragmentPageCarBinding15 = null;
                }
                fragmentPageCarBinding15.L.setText("");
                YYDecorateCarFragment.this.o();
                fragmentPageCarBinding10 = YYDecorateCarFragment.this.b;
                FragmentPageCarBinding fragmentPageCarBinding16 = fragmentPageCarBinding10;
                if (fragmentPageCarBinding16 == null) {
                    Intrinsics.c("mBinding");
                    fragmentPageCarBinding16 = null;
                }
                fragmentPageCarBinding16.m.setEnabled(false);
            }
        });
        FragmentPageCarBinding fragmentPageCarBinding5 = this.b;
        if (fragmentPageCarBinding5 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding5 = null;
        }
        fragmentPageCarBinding5.m.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYDecorateCarFragment$wIu9MzN1HWauVW50GoilNYsiTpg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYDecorateCarFragment.a(YYDecorateCarFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i) {
        FragmentPageCarBinding fragmentPageCarBinding = this.b;
        FragmentPageCarBinding fragmentPageCarBinding2 = fragmentPageCarBinding;
        if (fragmentPageCarBinding == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding2 = null;
        }
        fragmentPageCarBinding2.u.setVisibility(i == 1 ? 0 : 8);
        FragmentPageCarBinding fragmentPageCarBinding3 = this.b;
        FragmentPageCarBinding fragmentPageCarBinding4 = fragmentPageCarBinding3;
        if (fragmentPageCarBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding4 = null;
        }
        fragmentPageCarBinding4.n.setVisibility(i == 2 ? 0 : 8);
        FragmentPageCarBinding fragmentPageCarBinding5 = this.b;
        FragmentPageCarBinding fragmentPageCarBinding6 = fragmentPageCarBinding5;
        if (fragmentPageCarBinding5 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding6 = null;
        }
        fragmentPageCarBinding6.q.setVisibility(i == 3 ? 0 : 8);
        FragmentPageCarBinding fragmentPageCarBinding7 = this.b;
        if (fragmentPageCarBinding7 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding7 = null;
        }
        fragmentPageCarBinding7.p.setVisibility(i == 4 ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYDecorateCarFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        ArrayList<YYSeatMemberModel> arrayList = new ArrayList<>();
        ReceiverAdapter receiverAdapter = this$0.f;
        ReceiverAdapter receiverAdapter2 = receiverAdapter;
        if (receiverAdapter == null) {
            Intrinsics.c("receiverAdapter");
            receiverAdapter2 = null;
        }
        for (YYSeatMemberModel yYSeatMemberModel : receiverAdapter2.getData()) {
            if (yYSeatMemberModel.isSelected) {
                arrayList.add(yYSeatMemberModel);
            }
        }
        if (arrayList.isEmpty()) {
            ToastUtils.a("当前聊天室无可送礼对象，请稍后重试");
        } else {
            this$0.a("", false, arrayList, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYDecorateCarFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Boolean valueOf;
        Intrinsics.e(this$0, "this$0");
        ColorAdapter colorAdapter = this$0.e;
        ColorAdapter colorAdapter2 = colorAdapter;
        if (colorAdapter == null) {
            Intrinsics.c("colorAdapter");
            colorAdapter2 = null;
        }
        YYCarItemModel yYCarItemModel = (YYCarItemModel) colorAdapter2.getData().get(i);
        if (TextUtils.equals(this$0.l, yYCarItemModel == null ? null : yYCarItemModel.getId())) {
            ColorAdapter colorAdapter3 = this$0.e;
            ColorAdapter colorAdapter4 = colorAdapter3;
            if (colorAdapter3 == null) {
                Intrinsics.c("colorAdapter");
                colorAdapter4 = null;
            }
            YYCarItemModel yYCarItemModel2 = (YYCarItemModel) colorAdapter4.getData().get(i);
            Intrinsics.a(yYCarItemModel == null ? null : Boolean.valueOf(yYCarItemModel.getSelected()));
            yYCarItemModel2.setSelected(!valueOf.booleanValue());
            ColorAdapter colorAdapter5 = this$0.e;
            ColorAdapter colorAdapter6 = colorAdapter5;
            if (colorAdapter5 == null) {
                Intrinsics.c("colorAdapter");
                colorAdapter6 = null;
            }
            colorAdapter6.notifyItemChanged(i);
            ColorAdapter colorAdapter7 = this$0.e;
            ColorAdapter colorAdapter8 = colorAdapter7;
            if (colorAdapter7 == null) {
                Intrinsics.c("colorAdapter");
                colorAdapter8 = null;
            }
            if (!((YYCarItemModel) colorAdapter8.getData().get(i)).getSelected()) {
                this$0.l = "0";
                TabAdapter tabAdapter = this$0.c;
                if (tabAdapter == null) {
                    Intrinsics.c("tabAdapter");
                    tabAdapter = null;
                }
                ((YYCarTabModel) tabAdapter.getData().get(1)).setComplete_status(0);
            }
        } else {
            ColorAdapter colorAdapter9 = this$0.e;
            ColorAdapter colorAdapter10 = colorAdapter9;
            if (colorAdapter9 == null) {
                Intrinsics.c("colorAdapter");
                colorAdapter10 = null;
            }
            for (YYCarItemModel yYCarItemModel3 : colorAdapter10.getData()) {
                yYCarItemModel3.setSelected(false);
            }
            ColorAdapter colorAdapter11 = this$0.e;
            ColorAdapter colorAdapter12 = colorAdapter11;
            if (colorAdapter11 == null) {
                Intrinsics.c("colorAdapter");
                colorAdapter12 = null;
            }
            ((YYCarItemModel) colorAdapter12.getData().get(i)).setSelected(true);
            ColorAdapter colorAdapter13 = this$0.e;
            ColorAdapter colorAdapter14 = colorAdapter13;
            if (colorAdapter13 == null) {
                Intrinsics.c("colorAdapter");
                colorAdapter14 = null;
            }
            this$0.l = ((YYCarItemModel) colorAdapter14.getData().get(i)).getId();
            TabAdapter tabAdapter2 = this$0.c;
            TabAdapter tabAdapter3 = tabAdapter2;
            if (tabAdapter2 == null) {
                Intrinsics.c("tabAdapter");
                tabAdapter3 = null;
            }
            ((YYCarTabModel) tabAdapter3.getData().get(1)).setComplete_status(1);
            ColorAdapter colorAdapter15 = this$0.e;
            if (colorAdapter15 == null) {
                Intrinsics.c("colorAdapter");
                colorAdapter15 = null;
            }
            colorAdapter15.notifyDataSetChanged();
        }
        this$0.o();
        this$0.p();
    }

    private final void c() {
        View currentFocus;
        FragmentActivity activity = getActivity();
        Object systemService = activity == null ? null : activity.getSystemService("input_method");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        FragmentPageCarBinding fragmentPageCarBinding = this.b;
        FragmentPageCarBinding fragmentPageCarBinding2 = fragmentPageCarBinding;
        if (fragmentPageCarBinding == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding2 = null;
        }
        KeyboardUtils.b(fragmentPageCarBinding2.z);
        Context context = getContext();
        FragmentPageCarBinding fragmentPageCarBinding3 = this.b;
        FragmentPageCarBinding fragmentPageCarBinding4 = fragmentPageCarBinding3;
        if (fragmentPageCarBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding4 = null;
        }
        KeyboardUtils.b(context, fragmentPageCarBinding4.z);
        KeyboardUtils.a(getActivity());
        FragmentPageCarBinding fragmentPageCarBinding5 = this.b;
        FragmentPageCarBinding fragmentPageCarBinding6 = fragmentPageCarBinding5;
        if (fragmentPageCarBinding5 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding6 = null;
        }
        fragmentPageCarBinding6.z.clearFocus();
        FragmentActivity activity2 = getActivity();
        inputMethodManager.hideSoftInputFromWindow((activity2 == null || (currentFocus = activity2.getCurrentFocus()) == null) ? null : currentFocus.getWindowToken(), 2);
        FragmentPageCarBinding fragmentPageCarBinding7 = this.b;
        if (fragmentPageCarBinding7 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding7 = null;
        }
        inputMethodManager.restartInput(fragmentPageCarBinding7.z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYDecorateCarFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYDecorateCarFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        this$0.c();
        TabAdapter tabAdapter = this$0.c;
        TabAdapter tabAdapter2 = tabAdapter;
        if (tabAdapter == null) {
            Intrinsics.c("tabAdapter");
            tabAdapter2 = null;
        }
        YYCarTabModel yYCarTabModel = (YYCarTabModel) tabAdapter2.getItem(i);
        TabAdapter tabAdapter3 = this$0.c;
        TabAdapter tabAdapter4 = tabAdapter3;
        if (tabAdapter3 == null) {
            Intrinsics.c("tabAdapter");
            tabAdapter4 = null;
        }
        for (YYCarTabModel yYCarTabModel2 : tabAdapter4.getData()) {
            yYCarTabModel2.setStatus(0);
        }
        TabAdapter tabAdapter5 = this$0.c;
        TabAdapter tabAdapter6 = tabAdapter5;
        if (tabAdapter5 == null) {
            Intrinsics.c("tabAdapter");
            tabAdapter6 = null;
        }
        ((YYCarTabModel) tabAdapter6.getData().get(i)).setStatus(1);
        TabAdapter tabAdapter7 = this$0.c;
        if (tabAdapter7 == null) {
            Intrinsics.c("tabAdapter");
            tabAdapter7 = null;
        }
        tabAdapter7.notifyDataSetChanged();
        if (yYCarTabModel == null) {
            return;
        }
        this$0.b(yYCarTabModel.getId());
    }

    private final void d() {
        FragmentPageCarBinding fragmentPageCarBinding = this.b;
        FragmentPageCarBinding fragmentPageCarBinding2 = fragmentPageCarBinding;
        if (fragmentPageCarBinding == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding2 = null;
        }
        FrameLayout frameLayout = fragmentPageCarBinding2.b;
        FragmentPageCarBinding fragmentPageCarBinding3 = this.b;
        FragmentPageCarBinding fragmentPageCarBinding4 = fragmentPageCarBinding3;
        if (fragmentPageCarBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding4 = null;
        }
        frameLayout.setVisibility(fragmentPageCarBinding4.A.getVisibility() == 0 ? 8 : 0);
        FragmentPageCarBinding fragmentPageCarBinding5 = this.b;
        FragmentPageCarBinding fragmentPageCarBinding6 = fragmentPageCarBinding5;
        if (fragmentPageCarBinding5 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding6 = null;
        }
        TextView textView = fragmentPageCarBinding6.A;
        FragmentPageCarBinding fragmentPageCarBinding7 = this.b;
        if (fragmentPageCarBinding7 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding7 = null;
        }
        textView.setVisibility(fragmentPageCarBinding7.A.getVisibility() == 0 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(YYDecorateCarFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(YYDecorateCarFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        YYSeatMemberModel yYSeatMemberModel;
        Intrinsics.e(this$0, "this$0");
        ReceiverAdapter receiverAdapter = this$0.f;
        ReceiverAdapter receiverAdapter2 = receiverAdapter;
        if (receiverAdapter == null) {
            Intrinsics.c("receiverAdapter");
            receiverAdapter2 = null;
        }
        ((YYSeatMemberModel) receiverAdapter2.getData().get(i)).isSelected = !yYSeatMemberModel.isSelected;
        ReceiverAdapter receiverAdapter3 = this$0.f;
        if (receiverAdapter3 == null) {
            Intrinsics.c("receiverAdapter");
            receiverAdapter3 = null;
        }
        receiverAdapter3.notifyItemChanged(i);
    }

    private final String e() {
        String m = YYRoomInfoManager.e().m();
        Intrinsics.c(m, "getInstance().selfAvatar");
        return m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(YYDecorateCarFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FragmentPageCarBinding fragmentPageCarBinding = this$0.b;
        FragmentPageCarBinding fragmentPageCarBinding2 = fragmentPageCarBinding;
        if (fragmentPageCarBinding == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding2 = null;
        }
        fragmentPageCarBinding2.b.setVisibility(8);
        FragmentPageCarBinding fragmentPageCarBinding3 = this$0.b;
        if (fragmentPageCarBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding3 = null;
        }
        fragmentPageCarBinding3.A.setVisibility(8);
    }

    private final String f() {
        List<YYSeatMemberModel> list;
        List<YYSeatMemberModel> list2;
        YYSeatMemberModel yYSeatMemberModel;
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (((b == null || (list = b.mics) == null) ? null : list.get(0)) == null) {
            return "";
        }
        YYRoomModel b2 = YYRoomInfoManager.e().b();
        if (b2 == null || (list2 = b2.mics) == null || (yYSeatMemberModel = list2.get(0)) == null) {
            return null;
        }
        return yYSeatMemberModel.getAvatar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(YYDecorateCarFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FragmentPageCarBinding fragmentPageCarBinding = null;
        if (this$0.k != 0) {
            ImageWrapper b = ImageLoader.a(this$0.getFragmentActive(), this$0.e()).b(R.drawable.icon_car_default_img_slogan);
            FragmentPageCarBinding fragmentPageCarBinding2 = this$0.b;
            if (fragmentPageCarBinding2 == null) {
                Intrinsics.c("mBinding");
            } else {
                fragmentPageCarBinding = fragmentPageCarBinding2;
            }
            b.a(fragmentPageCarBinding.c);
            this$0.a(0);
            return;
        }
        this$0.k = -1;
        TabAdapter tabAdapter = this$0.c;
        TabAdapter tabAdapter2 = tabAdapter;
        if (tabAdapter == null) {
            Intrinsics.c("tabAdapter");
            tabAdapter2 = null;
        }
        ((YYCarTabModel) tabAdapter2.getData().get(3)).setComplete_status(0);
        FragmentPageCarBinding fragmentPageCarBinding3 = this$0.b;
        FragmentPageCarBinding fragmentPageCarBinding4 = fragmentPageCarBinding3;
        if (fragmentPageCarBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding4 = null;
        }
        fragmentPageCarBinding4.s.setBackgroundResource(R.drawable.icon_car_portrait_normal);
        ImageWrapper b2 = ImageLoader.a(this$0.getFragmentActive(), "").b(R.drawable.icon_car_default_img_slogan);
        FragmentPageCarBinding fragmentPageCarBinding5 = this$0.b;
        if (fragmentPageCarBinding5 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding5 = null;
        }
        b2.a(fragmentPageCarBinding5.c);
        this$0.o();
    }

    private final void g() {
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        YYRoomHttpUtils.t(new BluedUIHttpResponse<BluedEntityA<YYCarBasicModel>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YYDecorateCarFragment$loadBasicData$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYCarBasicModel> bluedEntityA) {
                YYCarBasicModel yYCarBasicModel;
                YYDecorateCarFragment.TabAdapter tabAdapter;
                FragmentPageCarBinding fragmentPageCarBinding;
                FragmentPageCarBinding fragmentPageCarBinding2;
                FragmentPageCarBinding fragmentPageCarBinding3;
                FragmentPageCarBinding fragmentPageCarBinding4;
                FragmentPageCarBinding fragmentPageCarBinding5;
                FragmentPageCarBinding fragmentPageCarBinding6;
                YYDecorateCarFragment.TabAdapter tabAdapter2;
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                YYDecorateCarFragment.this.h = bluedEntityA.getSingleData();
                yYCarBasicModel = YYDecorateCarFragment.this.h;
                if (yYCarBasicModel != null) {
                    YYDecorateCarFragment yYDecorateCarFragment = YYDecorateCarFragment.this;
                    tabAdapter = yYDecorateCarFragment.c;
                    YYDecorateCarFragment.TabAdapter tabAdapter3 = tabAdapter;
                    if (tabAdapter == null) {
                        Intrinsics.c("tabAdapter");
                        tabAdapter3 = null;
                    }
                    tabAdapter3.setNewData(yYCarBasicModel.getTab());
                    yYDecorateCarFragment.g = yYCarBasicModel.getDefault_car();
                    yYDecorateCarFragment.i = null;
                    fragmentPageCarBinding = yYDecorateCarFragment.b;
                    FragmentPageCarBinding fragmentPageCarBinding7 = fragmentPageCarBinding;
                    if (fragmentPageCarBinding == null) {
                        Intrinsics.c("mBinding");
                        fragmentPageCarBinding7 = null;
                    }
                    TextView textView = fragmentPageCarBinding7.K;
                    StringBuilder sb = new StringBuilder();
                    sb.append("注：专属签名价值");
                    ConfigBean beans = yYCarBasicModel.getBeans();
                    sb.append((Object) (beans == null ? null : beans.getSign()));
                    sb.append("弯豆");
                    textView.setText(sb.toString());
                    fragmentPageCarBinding2 = yYDecorateCarFragment.b;
                    FragmentPageCarBinding fragmentPageCarBinding8 = fragmentPageCarBinding2;
                    if (fragmentPageCarBinding2 == null) {
                        Intrinsics.c("mBinding");
                        fragmentPageCarBinding8 = null;
                    }
                    TextView textView2 = fragmentPageCarBinding8.H;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("注：专属头像价值");
                    ConfigBean beans2 = yYCarBasicModel.getBeans();
                    sb2.append((Object) (beans2 == null ? null : beans2.getAvatar()));
                    sb2.append("弯豆");
                    textView2.setText(sb2.toString());
                    fragmentPageCarBinding3 = yYDecorateCarFragment.b;
                    FragmentPageCarBinding fragmentPageCarBinding9 = fragmentPageCarBinding3;
                    if (fragmentPageCarBinding3 == null) {
                        Intrinsics.c("mBinding");
                        fragmentPageCarBinding9 = null;
                    }
                    TextView textView3 = fragmentPageCarBinding9.y;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("注：专属颜色价值");
                    ConfigBean beans3 = yYCarBasicModel.getBeans();
                    sb3.append((Object) (beans3 == null ? null : beans3.getColor()));
                    sb3.append("弯豆");
                    textView3.setText(sb3.toString());
                    ImageWrapper a = ImageLoader.a(yYDecorateCarFragment.getFragmentActive(), yYCarBasicModel.getDefault_car().getImage());
                    fragmentPageCarBinding4 = yYDecorateCarFragment.b;
                    FragmentPageCarBinding fragmentPageCarBinding10 = fragmentPageCarBinding4;
                    if (fragmentPageCarBinding4 == null) {
                        Intrinsics.c("mBinding");
                        fragmentPageCarBinding10 = null;
                    }
                    a.a(fragmentPageCarBinding10.e);
                    HonorInfo honor_info = yYCarBasicModel.getHonor_info();
                    fragmentPageCarBinding5 = yYDecorateCarFragment.b;
                    FragmentPageCarBinding fragmentPageCarBinding11 = fragmentPageCarBinding5;
                    if (fragmentPageCarBinding5 == null) {
                        Intrinsics.c("mBinding");
                        fragmentPageCarBinding11 = null;
                    }
                    TextView textView4 = fragmentPageCarBinding11.E;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(StringUtils.a(honor_info.getScore_double(), 0.0f));
                    sb4.append((char) 20493);
                    textView4.setText(sb4.toString());
                    fragmentPageCarBinding6 = yYDecorateCarFragment.b;
                    FragmentPageCarBinding fragmentPageCarBinding12 = fragmentPageCarBinding6;
                    if (fragmentPageCarBinding6 == null) {
                        Intrinsics.c("mBinding");
                        fragmentPageCarBinding12 = null;
                    }
                    fragmentPageCarBinding12.A.setText(honor_info.getIntroduce());
                    yYDecorateCarFragment.o();
                    tabAdapter2 = yYDecorateCarFragment.c;
                    YYDecorateCarFragment.TabAdapter tabAdapter4 = tabAdapter2;
                    if (tabAdapter4 == null) {
                        Intrinsics.c("tabAdapter");
                        tabAdapter4 = null;
                    }
                    yYDecorateCarFragment.b(((YYCarTabModel) tabAdapter4.getData().get(0)).getId());
                }
                YYDecorateCarFragment.this.h();
                YYDecorateCarFragment.this.i();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                YYDecorateCarFragment.this.n = true;
                return super.onUIFailure(i, str);
            }
        }, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(YYDecorateCarFragment this$0, View view) {
        String str;
        Intrinsics.e(this$0, "this$0");
        FragmentPageCarBinding fragmentPageCarBinding = null;
        if (this$0.k != 1) {
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b != null && (str = b.avatar) != null) {
                ImageWrapper b2 = ImageLoader.a(this$0.getFragmentActive(), str).b(R.drawable.icon_car_default_img_slogan);
                FragmentPageCarBinding fragmentPageCarBinding2 = this$0.b;
                if (fragmentPageCarBinding2 == null) {
                    Intrinsics.c("mBinding");
                } else {
                    fragmentPageCarBinding = fragmentPageCarBinding2;
                }
                b2.a(fragmentPageCarBinding.c);
            }
            this$0.a(1);
            return;
        }
        this$0.k = -1;
        TabAdapter tabAdapter = this$0.c;
        TabAdapter tabAdapter2 = tabAdapter;
        if (tabAdapter == null) {
            Intrinsics.c("tabAdapter");
            tabAdapter2 = null;
        }
        ((YYCarTabModel) tabAdapter2.getData().get(3)).setComplete_status(0);
        FragmentPageCarBinding fragmentPageCarBinding3 = this$0.b;
        FragmentPageCarBinding fragmentPageCarBinding4 = fragmentPageCarBinding3;
        if (fragmentPageCarBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding4 = null;
        }
        fragmentPageCarBinding4.t.setBackgroundResource(R.drawable.icon_car_portrait_normal);
        ImageWrapper b3 = ImageLoader.a(this$0.getFragmentActive(), "").b(R.drawable.icon_car_default_img_slogan);
        FragmentPageCarBinding fragmentPageCarBinding5 = this$0.b;
        if (fragmentPageCarBinding5 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding5 = null;
        }
        b3.a(fragmentPageCarBinding5.c);
        this$0.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        YYRoomHttpUtils.u(new BluedUIHttpResponse<BluedEntityA<YYCarItemModel>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YYDecorateCarFragment$loadCars$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYCarItemModel> bluedEntityA) {
                YYDecorateCarFragment.CarAdapter carAdapter;
                YYDecorateCarFragment.TabAdapter tabAdapter;
                YYDecorateCarFragment.TabAdapter tabAdapter2;
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                carAdapter = YYDecorateCarFragment.this.d;
                YYDecorateCarFragment.CarAdapter carAdapter2 = carAdapter;
                if (carAdapter == null) {
                    Intrinsics.c("carAdapter");
                    carAdapter2 = null;
                }
                carAdapter2.setNewData(bluedEntityA.data);
                tabAdapter = YYDecorateCarFragment.this.c;
                YYDecorateCarFragment.TabAdapter tabAdapter3 = tabAdapter;
                if (tabAdapter == null) {
                    Intrinsics.c("tabAdapter");
                    tabAdapter3 = null;
                }
                ((YYCarTabModel) tabAdapter3.getData().get(0)).setStatus(1);
                tabAdapter2 = YYDecorateCarFragment.this.c;
                YYDecorateCarFragment.TabAdapter tabAdapter4 = tabAdapter2;
                if (tabAdapter4 == null) {
                    Intrinsics.c("tabAdapter");
                    tabAdapter4 = null;
                }
                tabAdapter4.notifyDataSetChanged();
            }
        }, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        YYRoomHttpUtils.v(new BluedUIHttpResponse<BluedEntityA<YYCarItemModel>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YYDecorateCarFragment$loadColors$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYCarItemModel> bluedEntityA) {
                YYDecorateCarFragment.ColorAdapter colorAdapter;
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                colorAdapter = YYDecorateCarFragment.this.e;
                YYDecorateCarFragment.ColorAdapter colorAdapter2 = colorAdapter;
                if (colorAdapter == null) {
                    Intrinsics.c("colorAdapter");
                    colorAdapter2 = null;
                }
                colorAdapter2.setNewData(bluedEntityA.data);
            }
        }, getFragmentActive());
    }

    private final void j() {
        this.d = new CarAdapter(this);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        FragmentPageCarBinding fragmentPageCarBinding = this.b;
        FragmentPageCarBinding fragmentPageCarBinding2 = fragmentPageCarBinding;
        if (fragmentPageCarBinding == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding2 = null;
        }
        fragmentPageCarBinding2.u.setLayoutManager(linearLayoutManager);
        FragmentPageCarBinding fragmentPageCarBinding3 = this.b;
        FragmentPageCarBinding fragmentPageCarBinding4 = fragmentPageCarBinding3;
        if (fragmentPageCarBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding4 = null;
        }
        RecyclerView recyclerView = fragmentPageCarBinding4.u;
        RecyclerView.Adapter adapter = this.d;
        CarAdapter carAdapter = adapter;
        if (adapter == null) {
            Intrinsics.c("carAdapter");
            carAdapter = null;
        }
        recyclerView.setAdapter(carAdapter);
        CarAdapter carAdapter2 = this.d;
        if (carAdapter2 == null) {
            Intrinsics.c("carAdapter");
            carAdapter2 = null;
        }
        carAdapter2.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYDecorateCarFragment$Uxnzon6_0rpRlN4TnpJcRSnKwaY
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                YYDecorateCarFragment.a(YYDecorateCarFragment.this, baseQuickAdapter, view, i);
            }
        });
    }

    private final void k() {
        YYSeatMemberModel yYSeatMemberModel;
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            List<YYSeatMemberModel> list = b.mics;
            if (list != null && (yYSeatMemberModel = list.get(0)) != null) {
                if (TextUtils.equals(yYSeatMemberModel.getUid(), YYRoomInfoManager.e().k())) {
                    FragmentPageCarBinding fragmentPageCarBinding = this.b;
                    FragmentPageCarBinding fragmentPageCarBinding2 = fragmentPageCarBinding;
                    if (fragmentPageCarBinding == null) {
                        Intrinsics.c("mBinding");
                        fragmentPageCarBinding2 = null;
                    }
                    fragmentPageCarBinding2.t.setVisibility(4);
                } else {
                    FragmentPageCarBinding fragmentPageCarBinding3 = this.b;
                    FragmentPageCarBinding fragmentPageCarBinding4 = fragmentPageCarBinding3;
                    if (fragmentPageCarBinding3 == null) {
                        Intrinsics.c("mBinding");
                        fragmentPageCarBinding4 = null;
                    }
                    fragmentPageCarBinding4.t.setVisibility(0);
                    ImageWrapper b2 = ImageLoader.a(getFragmentActive(), b.avatar).b(R.drawable.user_bg_round);
                    FragmentPageCarBinding fragmentPageCarBinding5 = this.b;
                    FragmentPageCarBinding fragmentPageCarBinding6 = fragmentPageCarBinding5;
                    if (fragmentPageCarBinding5 == null) {
                        Intrinsics.c("mBinding");
                        fragmentPageCarBinding6 = null;
                    }
                    b2.a((ImageView) fragmentPageCarBinding6.k);
                }
                ImageWrapper b3 = ImageLoader.a(getFragmentActive(), e()).b(R.drawable.user_bg_round);
                FragmentPageCarBinding fragmentPageCarBinding7 = this.b;
                FragmentPageCarBinding fragmentPageCarBinding8 = fragmentPageCarBinding7;
                if (fragmentPageCarBinding7 == null) {
                    Intrinsics.c("mBinding");
                    fragmentPageCarBinding8 = null;
                }
                b3.a((ImageView) fragmentPageCarBinding8.j);
            }
            if (TextUtils.equals(b.chat_type, "9")) {
                FragmentPageCarBinding fragmentPageCarBinding9 = this.b;
                FragmentPageCarBinding fragmentPageCarBinding10 = fragmentPageCarBinding9;
                if (fragmentPageCarBinding9 == null) {
                    Intrinsics.c("mBinding");
                    fragmentPageCarBinding10 = null;
                }
                fragmentPageCarBinding10.I.setImageResource(R.drawable.icon_car_portrait_hoster);
            } else {
                FragmentPageCarBinding fragmentPageCarBinding11 = this.b;
                FragmentPageCarBinding fragmentPageCarBinding12 = fragmentPageCarBinding11;
                if (fragmentPageCarBinding11 == null) {
                    Intrinsics.c("mBinding");
                    fragmentPageCarBinding12 = null;
                }
                fragmentPageCarBinding12.I.setImageResource(R.drawable.icon_car_portrait_owner);
            }
        }
        ImageWrapper b4 = ImageLoader.a(getFragmentActive(), "").b(R.drawable.icon_car_default_img_slogan);
        FragmentPageCarBinding fragmentPageCarBinding13 = this.b;
        FragmentPageCarBinding fragmentPageCarBinding14 = fragmentPageCarBinding13;
        if (fragmentPageCarBinding13 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding14 = null;
        }
        b4.a(fragmentPageCarBinding14.c);
        FragmentPageCarBinding fragmentPageCarBinding15 = this.b;
        FragmentPageCarBinding fragmentPageCarBinding16 = fragmentPageCarBinding15;
        if (fragmentPageCarBinding15 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding16 = null;
        }
        fragmentPageCarBinding16.s.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYDecorateCarFragment$MHhBpF1QD4C5rkWxYdx1p5XZK8s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYDecorateCarFragment.f(YYDecorateCarFragment.this, view);
            }
        });
        FragmentPageCarBinding fragmentPageCarBinding17 = this.b;
        if (fragmentPageCarBinding17 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding17 = null;
        }
        fragmentPageCarBinding17.t.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYDecorateCarFragment$XH5qyS1NLM-ry-Vi2oF8eQSUVhU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYDecorateCarFragment.g(YYDecorateCarFragment.this, view);
            }
        });
    }

    private final void l() {
        this.e = new ColorAdapter(this);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        FragmentPageCarBinding fragmentPageCarBinding = this.b;
        FragmentPageCarBinding fragmentPageCarBinding2 = fragmentPageCarBinding;
        if (fragmentPageCarBinding == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding2 = null;
        }
        fragmentPageCarBinding2.v.setLayoutManager(linearLayoutManager);
        FragmentPageCarBinding fragmentPageCarBinding3 = this.b;
        FragmentPageCarBinding fragmentPageCarBinding4 = fragmentPageCarBinding3;
        if (fragmentPageCarBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding4 = null;
        }
        RecyclerView recyclerView = fragmentPageCarBinding4.v;
        RecyclerView.Adapter adapter = this.e;
        ColorAdapter colorAdapter = adapter;
        if (adapter == null) {
            Intrinsics.c("colorAdapter");
            colorAdapter = null;
        }
        recyclerView.setAdapter(colorAdapter);
        ColorAdapter colorAdapter2 = this.e;
        if (colorAdapter2 == null) {
            Intrinsics.c("colorAdapter");
            colorAdapter2 = null;
        }
        colorAdapter2.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYDecorateCarFragment$BypLh5T5-t1XZlBsdhYSZxxRtpI
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                YYDecorateCarFragment.b(YYDecorateCarFragment.this, baseQuickAdapter, view, i);
            }
        });
    }

    private final void m() {
        this.c = new TabAdapter(this);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        FragmentPageCarBinding fragmentPageCarBinding = this.b;
        FragmentPageCarBinding fragmentPageCarBinding2 = fragmentPageCarBinding;
        if (fragmentPageCarBinding == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding2 = null;
        }
        fragmentPageCarBinding2.x.setLayoutManager(linearLayoutManager);
        FragmentPageCarBinding fragmentPageCarBinding3 = this.b;
        FragmentPageCarBinding fragmentPageCarBinding4 = fragmentPageCarBinding3;
        if (fragmentPageCarBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding4 = null;
        }
        RecyclerView recyclerView = fragmentPageCarBinding4.x;
        RecyclerView.Adapter adapter = this.c;
        TabAdapter tabAdapter = adapter;
        if (adapter == null) {
            Intrinsics.c("tabAdapter");
            tabAdapter = null;
        }
        recyclerView.setAdapter(tabAdapter);
        TabAdapter tabAdapter2 = this.c;
        if (tabAdapter2 == null) {
            Intrinsics.c("tabAdapter");
            tabAdapter2 = null;
        }
        tabAdapter2.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYDecorateCarFragment$MaBAL1MPm7RongoxKwf4wnZh0jU
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                YYDecorateCarFragment.c(YYDecorateCarFragment.this, baseQuickAdapter, view, i);
            }
        });
    }

    private final void n() {
        List<YYSeatMemberModel> hasPeopleMicsExceptMyself;
        this.f = new ReceiverAdapter(this);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        FragmentPageCarBinding fragmentPageCarBinding = this.b;
        FragmentPageCarBinding fragmentPageCarBinding2 = fragmentPageCarBinding;
        if (fragmentPageCarBinding == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding2 = null;
        }
        fragmentPageCarBinding2.w.setLayoutManager(linearLayoutManager);
        FragmentPageCarBinding fragmentPageCarBinding3 = this.b;
        FragmentPageCarBinding fragmentPageCarBinding4 = fragmentPageCarBinding3;
        if (fragmentPageCarBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding4 = null;
        }
        RecyclerView recyclerView = fragmentPageCarBinding4.w;
        RecyclerView.Adapter adapter = this.f;
        ReceiverAdapter receiverAdapter = adapter;
        if (adapter == null) {
            Intrinsics.c("receiverAdapter");
            receiverAdapter = null;
        }
        recyclerView.setAdapter(receiverAdapter);
        ReceiverAdapter receiverAdapter2 = this.f;
        ReceiverAdapter receiverAdapter3 = receiverAdapter2;
        if (receiverAdapter2 == null) {
            Intrinsics.c("receiverAdapter");
            receiverAdapter3 = null;
        }
        receiverAdapter3.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYDecorateCarFragment$k5OYSXY2ScQ45qK68-41T2yVUiI
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                YYDecorateCarFragment.d(YYDecorateCarFragment.this, baseQuickAdapter, view, i);
            }
        });
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null && (hasPeopleMicsExceptMyself = b.getHasPeopleMicsExceptMyself()) != null) {
            if (hasPeopleMicsExceptMyself.isEmpty()) {
                return;
            }
            if (!TextUtils.equals(hasPeopleMicsExceptMyself.get(0).getUid(), YYRoomInfoManager.e().k())) {
                hasPeopleMicsExceptMyself.get(0).isSelected = true;
            } else if (hasPeopleMicsExceptMyself.size() > 1) {
                hasPeopleMicsExceptMyself.get(1).isSelected = true;
            }
            ReceiverAdapter receiverAdapter4 = this.f;
            ReceiverAdapter receiverAdapter5 = receiverAdapter4;
            if (receiverAdapter4 == null) {
                Intrinsics.c("receiverAdapter");
                receiverAdapter5 = null;
            }
            receiverAdapter5.setNewData(hasPeopleMicsExceptMyself);
        }
        ReceiverAdapter receiverAdapter6 = this.f;
        ReceiverAdapter receiverAdapter7 = receiverAdapter6;
        if (receiverAdapter6 == null) {
            Intrinsics.c("receiverAdapter");
            receiverAdapter7 = null;
        }
        if (receiverAdapter7.getData().size() <= 1) {
            FragmentPageCarBinding fragmentPageCarBinding5 = this.b;
            FragmentPageCarBinding fragmentPageCarBinding6 = fragmentPageCarBinding5;
            if (fragmentPageCarBinding5 == null) {
                Intrinsics.c("mBinding");
                fragmentPageCarBinding6 = null;
            }
            fragmentPageCarBinding6.J.setVisibility(4);
            FragmentPageCarBinding fragmentPageCarBinding7 = this.b;
            if (fragmentPageCarBinding7 == null) {
                Intrinsics.c("mBinding");
                fragmentPageCarBinding7 = null;
            }
            fragmentPageCarBinding7.w.setVisibility(8);
            return;
        }
        FragmentPageCarBinding fragmentPageCarBinding8 = this.b;
        FragmentPageCarBinding fragmentPageCarBinding9 = fragmentPageCarBinding8;
        if (fragmentPageCarBinding8 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding9 = null;
        }
        fragmentPageCarBinding9.J.setVisibility(0);
        FragmentPageCarBinding fragmentPageCarBinding10 = this.b;
        if (fragmentPageCarBinding10 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding10 = null;
        }
        fragmentPageCarBinding10.w.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        ConfigBean beans;
        ConfigBean beans2;
        ConfigBean beans3;
        ConfigBean beans4;
        YYCarBasicModel yYCarBasicModel = this.h;
        int a = StringUtils.a((yYCarBasicModel == null || (beans = yYCarBasicModel.getBeans()) == null) ? null : beans.getBase(), 0);
        YYCarItemModel yYCarItemModel = this.i;
        if (yYCarItemModel != null) {
            a += StringUtils.a(yYCarItemModel.getBeans(), 0);
        }
        int i = a;
        if (!TextUtils.isEmpty(this.j)) {
            YYCarBasicModel yYCarBasicModel2 = this.h;
            i = a + StringUtils.a((yYCarBasicModel2 == null || (beans4 = yYCarBasicModel2.getBeans()) == null) ? null : beans4.getSign(), 0);
        }
        int i2 = i;
        if (this.k >= 0) {
            YYCarBasicModel yYCarBasicModel3 = this.h;
            i2 = i + StringUtils.a((yYCarBasicModel3 == null || (beans3 = yYCarBasicModel3.getBeans()) == null) ? null : beans3.getAvatar(), 0);
        }
        int i3 = i2;
        if (StringUtils.a(this.l, 0) > 0) {
            YYCarBasicModel yYCarBasicModel4 = this.h;
            i3 = i2 + StringUtils.a((yYCarBasicModel4 == null || (beans2 = yYCarBasicModel4.getBeans()) == null) ? null : beans2.getColor(), 0);
        }
        TabAdapter tabAdapter = this.c;
        TabAdapter tabAdapter2 = tabAdapter;
        if (tabAdapter == null) {
            Intrinsics.c("tabAdapter");
            tabAdapter2 = null;
        }
        tabAdapter2.notifyDataSetChanged();
        this.m = String.valueOf(i3);
        FragmentPageCarBinding fragmentPageCarBinding = this.b;
        if (fragmentPageCarBinding == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding = null;
        }
        TextView textView = fragmentPageCarBinding.M;
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String string = getResources().getString(R.string.yy_car_value);
        Intrinsics.c(string, "resources.getString(R.string.yy_car_value)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
        Intrinsics.c(format, "format(format, *args)");
        textView.setText(format);
    }

    private final void p() {
        YYCarItemModel yYCarItemModel = this.i;
        String id = yYCarItemModel == null ? "0" : yYCarItemModel == null ? null : yYCarItemModel.getId();
        String str = this.l;
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        YYRoomHttpUtils.w(id, str, new BluedUIHttpResponse<BluedEntityA<YYCarPreviewModel>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YYDecorateCarFragment$loadPreview$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYCarPreviewModel> bluedEntityA) {
                FragmentPageCarBinding fragmentPageCarBinding;
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                YYDecorateCarFragment.this.g = bluedEntityA.getSingleData();
                ImageWrapper a = ImageLoader.a(YYDecorateCarFragment.this.getFragmentActive(), bluedEntityA.getSingleData().getImage());
                fragmentPageCarBinding = YYDecorateCarFragment.this.b;
                FragmentPageCarBinding fragmentPageCarBinding2 = fragmentPageCarBinding;
                if (fragmentPageCarBinding == null) {
                    Intrinsics.c("mBinding");
                    fragmentPageCarBinding2 = null;
                }
                a.a(fragmentPageCarBinding2.e);
            }
        }, getFragmentActive());
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseLazyFragment
    public void a() {
        super.a();
        g();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fragment_page_car, (ViewGroup) null);
        FragmentPageCarBinding a = FragmentPageCarBinding.a(inflate);
        Intrinsics.c(a, "bind(view)");
        this.b = a;
        j();
        b();
        k();
        l();
        m();
        n();
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        LogUtils.d(Intrinsics.a(this.a, (Object) " onViewCreated ..."));
        getParentFragmentManager().setFragmentResultListener("close_keyboard", (LifecycleOwner) this, new FragmentResultListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYDecorateCarFragment$u7y76T1Z5DlPL9ubueXfu5YkbWY
            public final void onFragmentResult(String str, Bundle bundle2) {
                YYDecorateCarFragment.a(YYDecorateCarFragment.this, str, bundle2);
            }
        });
        FragmentPageCarBinding fragmentPageCarBinding = this.b;
        FragmentPageCarBinding fragmentPageCarBinding2 = fragmentPageCarBinding;
        if (fragmentPageCarBinding == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding2 = null;
        }
        fragmentPageCarBinding2.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYDecorateCarFragment$WEkcf_NLhru4Pw4RVfASVnAb7Rk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYDecorateCarFragment.a(view2);
            }
        });
        FragmentPageCarBinding fragmentPageCarBinding3 = this.b;
        FragmentPageCarBinding fragmentPageCarBinding4 = fragmentPageCarBinding3;
        if (fragmentPageCarBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding4 = null;
        }
        fragmentPageCarBinding4.a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYDecorateCarFragment$dunHAAX-tWSFRgqRyBERkC7lnHw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYDecorateCarFragment.b(YYDecorateCarFragment.this, view2);
            }
        });
        FragmentPageCarBinding fragmentPageCarBinding5 = this.b;
        FragmentPageCarBinding fragmentPageCarBinding6 = fragmentPageCarBinding5;
        if (fragmentPageCarBinding5 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding6 = null;
        }
        fragmentPageCarBinding6.l.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYDecorateCarFragment$0OkHEftuSBo3484ZsMyqHWXZbWU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYDecorateCarFragment.c(YYDecorateCarFragment.this, view2);
            }
        });
        FragmentPageCarBinding fragmentPageCarBinding7 = this.b;
        FragmentPageCarBinding fragmentPageCarBinding8 = fragmentPageCarBinding7;
        if (fragmentPageCarBinding7 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding8 = null;
        }
        fragmentPageCarBinding8.C.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYDecorateCarFragment$OaP_5jYARITACpXWiaRys35BHH0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYDecorateCarFragment.d(YYDecorateCarFragment.this, view2);
            }
        });
        FragmentPageCarBinding fragmentPageCarBinding9 = this.b;
        if (fragmentPageCarBinding9 == null) {
            Intrinsics.c("mBinding");
            fragmentPageCarBinding9 = null;
        }
        fragmentPageCarBinding9.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYDecorateCarFragment$lWvXE710JVbsjl26QjnPmW8GB6I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYDecorateCarFragment.e(YYDecorateCarFragment.this, view2);
            }
        });
    }
}

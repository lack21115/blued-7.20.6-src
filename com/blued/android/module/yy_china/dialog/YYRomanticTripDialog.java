package com.blued.android.module.yy_china.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.live.base.constants.LiveEventBusConstant;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.YYConstants;
import com.blued.android.module.yy_china.adapter.ReceiveCityAdapter;
import com.blued.android.module.yy_china.databinding.DialogRomanticTripLayoutBinding;
import com.blued.android.module.yy_china.dialog.YYRomanticTripDialog;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYPayGoodsModel;
import com.blued.android.module.yy_china.model.YYPayRequestModel;
import com.blued.android.module.yy_china.model.YYRomanticCityListModel;
import com.blued.android.module.yy_china.model.YYRomanticCityModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.utils.YYPayUtils;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/dialog/YYRomanticTripDialog.class */
public final class YYRomanticTripDialog extends BaseFullScreenDialog {

    /* renamed from: c  reason: collision with root package name */
    private DialogRomanticTripLayoutBinding f16995c;
    private CityAdapter d;
    private ReceiveCityAdapter e;
    private YYGiftModel f;

    /* renamed from: a  reason: collision with root package name */
    private String f16994a = "https://web.bldimg.com/image-manager/1687333382_65703.png";
    private String b = "https://web.bldimg.com/image-manager/1687920355_97281.png";
    private String g = "";
    private String h = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/dialog/YYRomanticTripDialog$CityAdapter.class */
    public final class CityAdapter extends BaseMultiItemQuickAdapter<YYRomanticCityModel, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYRomanticTripDialog f16996a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final int f16997c;
        private final int d;
        private boolean e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CityAdapter(YYRomanticTripDialog this$0) {
            super(new ArrayList());
            Intrinsics.e(this$0, "this$0");
            this.f16996a = this$0;
            this.b = DensityUtils.a(this.f16996a.getContext(), 23.0f);
            this.f16997c = DensityUtils.a(this.f16996a.getContext(), 19.0f);
            this.d = DensityUtils.a(this.f16996a.getContext(), 14.0f);
            addItemType(1, R.layout.item_city_layout);
            addItemType(0, R.layout.item_city_notice_layout);
        }

        private final void b(BaseViewHolder baseViewHolder, YYRomanticCityModel yYRomanticCityModel) {
            ImageView imageView = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.img_city);
            ImageView imageView2 = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.img_lock);
            ImageView imageView3 = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.img_unlock);
            TextView textView = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_city_count);
            if (yYRomanticCityModel == null) {
                return;
            }
            ImageLoader.a(this.f16996a.a(), yYRomanticCityModel.getImage()).a(imageView);
            if (yYRomanticCityModel.getTotal_count() <= 0) {
                if (imageView3 != null) {
                    imageView3.setVisibility(8);
                }
                if (imageView2 == null) {
                    return;
                }
                imageView2.setVisibility(0);
                return;
            }
            if (imageView3 != null) {
                imageView3.setVisibility(0);
            }
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            if (textView == null) {
                return;
            }
            textView.setText(Intrinsics.a("x", (Object) Integer.valueOf(yYRomanticCityModel.getTotal_count())));
        }

        private final void c(BaseViewHolder baseViewHolder, YYRomanticCityModel yYRomanticCityModel) {
            TextView textView = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_notice_text);
            if (textView != null) {
                textView.setText(yYRomanticCityModel == null ? null : yYRomanticCityModel.getNotice());
            }
            if (baseViewHolder != null && baseViewHolder.getAdapterPosition() == getData().size() - 1) {
                if (textView == null) {
                    return;
                }
                textView.setPadding(0, 0, 0, this.b);
            } else if (this.e) {
                if (textView == null) {
                    return;
                }
                textView.setPadding(0, 0, 0, this.d);
            } else {
                if (textView != null) {
                    textView.setPadding(0, this.f16997c, 0, this.d);
                }
                this.e = true;
            }
        }

        public final int a(int i) {
            return getItemViewType(i) != 0 ? 1 : 2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, YYRomanticCityModel yYRomanticCityModel) {
            if (baseViewHolder != null) {
                int itemViewType = baseViewHolder.getItemViewType();
                if (itemViewType == 0) {
                    c(baseViewHolder, yYRomanticCityModel);
                } else if (itemViewType != 1) {
                } else {
                    b(baseViewHolder, yYRomanticCityModel);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRomanticTripDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYRomanticGuidebookDialog yYRomanticGuidebookDialog = new YYRomanticGuidebookDialog();
        Bundle bundleOf = BundleKt.bundleOf(new Pair[0]);
        bundleOf.putString("user_id", this$0.g);
        bundleOf.putString("user_name", this$0.h);
        yYRomanticGuidebookDialog.setArguments(bundleOf);
        FragmentManager parentFragmentManager = this$0.getParentFragmentManager();
        Intrinsics.c(parentFragmentManager, "parentFragmentManager");
        yYRomanticGuidebookDialog.show(parentFragmentManager, "guidebook_dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRomanticTripDialog this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        YYSeatMemberModel yYSeatMemberModel;
        Intrinsics.e(this$0, "this$0");
        ReceiveCityAdapter receiveCityAdapter = this$0.e;
        ReceiveCityAdapter receiveCityAdapter2 = receiveCityAdapter;
        if (receiveCityAdapter == null) {
            Intrinsics.c("userAdapter");
            receiveCityAdapter2 = null;
        }
        receiveCityAdapter2.getData().get(i).isSelected = !yYSeatMemberModel.isSelected;
        ReceiveCityAdapter receiveCityAdapter3 = this$0.e;
        if (receiveCityAdapter3 == null) {
            Intrinsics.c("userAdapter");
            receiveCityAdapter3 = null;
        }
        receiveCityAdapter3.notifyItemChanged(i);
        this$0.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final String str, final boolean z, final ArrayList<YYSeatMemberModel> arrayList, boolean z2) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        YYPayRequestModel yYPayRequestModel = new YYPayRequestModel();
        YYGiftModel yYGiftModel = this.f;
        if (yYGiftModel != null) {
            yYPayRequestModel.gift = yYGiftModel;
            yYPayRequestModel.beans = yYGiftModel.beans;
            yYPayRequestModel.goods_id = yYGiftModel.goods_id;
            yYPayRequestModel.goods_type = yYGiftModel.goods_type;
        }
        yYPayRequestModel.giftCount = 1;
        yYPayRequestModel.hit_id = 0L;
        yYPayRequestModel.payCode = str;
        yYPayRequestModel.remember_me = z;
        YYRoomModel b = YYRoomInfoManager.e().b();
        yYPayRequestModel.room_id = b == null ? null : b.room_id;
        yYPayRequestModel.target_uid = arrayList.get(0).getUid();
        yYPayRequestModel.pay_from = 1;
        YYPayUtils.a(yYPayRequestModel, YYConstants.PayFromSource.Pay_Gift, this, a(), new YYPayUtils.PayGiftStatusListener() { // from class: com.blued.android.module.yy_china.dialog.YYRomanticTripDialog$toPayBill$2
            @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
            public void a(int i, String str2) {
            }

            @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
            public void a(YYPayGoodsModel yYPayGoodsModel) {
                YYGiftModel yYGiftModel2;
                YYSeatMemberModel remove = arrayList.remove(0);
                Intrinsics.c(remove, "targetUsers.removeAt(0)");
                YYSeatMemberModel yYSeatMemberModel = remove;
                yYSeatMemberModel.isSelected = false;
                YYImMsgManager a2 = YYImMsgManager.a();
                yYGiftModel2 = this.f;
                a2.a(yYGiftModel2, yYSeatMemberModel, yYPayGoodsModel, false);
                if (arrayList.size() > 0) {
                    this.a(str, z, arrayList, false);
                } else {
                    LiveEventBus.get(LiveEventBusConstant.d).post("");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(View view) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            EventTrackYY.d(ChatRoomProtos.Event.YY_ROMANTIC_RULE_PAGE_SHOW, b.room_id, b.uid);
        }
        LiveEventBus.get("show_inner_dialog").post(YYRoomInfoManager.e().c().a(17));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYRomanticTripDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYRomanticTripDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        ArrayList<YYSeatMemberModel> arrayList = new ArrayList<>();
        ReceiveCityAdapter receiveCityAdapter = this$0.e;
        ReceiveCityAdapter receiveCityAdapter2 = receiveCityAdapter;
        if (receiveCityAdapter == null) {
            Intrinsics.c("userAdapter");
            receiveCityAdapter2 = null;
        }
        for (YYSeatMemberModel yYSeatMemberModel : receiveCityAdapter2.getData()) {
            if (yYSeatMemberModel.isSelected) {
                arrayList.add(yYSeatMemberModel);
            }
        }
        ReceiveCityAdapter receiveCityAdapter3 = this$0.e;
        if (receiveCityAdapter3 == null) {
            Intrinsics.c("userAdapter");
            receiveCityAdapter3 = null;
        }
        if (receiveCityAdapter3.getData().size() <= 0) {
            ToastUtils.a("当前聊天室无可送礼对象，请稍后重试");
        } else if (arrayList.isEmpty()) {
            ToastUtils.a("请至少选择一个送礼对象");
        } else {
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b != null) {
                EventTrackYY.d(ChatRoomProtos.Event.YY_ROMANTIC_LIGHT_PAGE_GO_CLICK, b.room_id, b.uid);
            }
            this$0.a("", false, arrayList, true);
        }
    }

    private final void f() {
        this.d = new CityAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.blued.android.module.yy_china.dialog.YYRomanticTripDialog$initRecyclerView$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                YYRomanticTripDialog.CityAdapter cityAdapter;
                cityAdapter = YYRomanticTripDialog.this.d;
                YYRomanticTripDialog.CityAdapter cityAdapter2 = cityAdapter;
                if (cityAdapter == null) {
                    Intrinsics.c("cityAdapter");
                    cityAdapter2 = null;
                }
                return cityAdapter2.a(i);
            }
        });
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding = this.f16995c;
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding2 = dialogRomanticTripLayoutBinding;
        if (dialogRomanticTripLayoutBinding == null) {
            Intrinsics.c("mBinding");
            dialogRomanticTripLayoutBinding2 = null;
        }
        RecyclerView recyclerView = dialogRomanticTripLayoutBinding2.k;
        CityAdapter cityAdapter = this.d;
        CityAdapter cityAdapter2 = cityAdapter;
        if (cityAdapter == null) {
            Intrinsics.c("cityAdapter");
            cityAdapter2 = null;
        }
        recyclerView.setAdapter(cityAdapter2);
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding3 = this.f16995c;
        if (dialogRomanticTripLayoutBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticTripLayoutBinding3 = null;
        }
        dialogRomanticTripLayoutBinding3.k.setLayoutManager(gridLayoutManager);
    }

    private final void g() {
        List<YYSeatMemberModel> hasPeopleMicsExceptMyself;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding = this.f16995c;
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding2 = dialogRomanticTripLayoutBinding;
        if (dialogRomanticTripLayoutBinding == null) {
            Intrinsics.c("mBinding");
            dialogRomanticTripLayoutBinding2 = null;
        }
        Context context = dialogRomanticTripLayoutBinding2.l.getContext();
        Intrinsics.c(context, "mBinding.rvUserList.context");
        ActivityFragmentActive fragmentActive = a();
        Intrinsics.c(fragmentActive, "fragmentActive");
        this.e = new ReceiveCityAdapter(context, fragmentActive);
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding3 = this.f16995c;
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding4 = dialogRomanticTripLayoutBinding3;
        if (dialogRomanticTripLayoutBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticTripLayoutBinding4 = null;
        }
        RecyclerView recyclerView = dialogRomanticTripLayoutBinding4.l;
        ReceiveCityAdapter receiveCityAdapter = this.e;
        ReceiveCityAdapter receiveCityAdapter2 = receiveCityAdapter;
        if (receiveCityAdapter == null) {
            Intrinsics.c("userAdapter");
            receiveCityAdapter2 = null;
        }
        recyclerView.setAdapter(receiveCityAdapter2);
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding5 = this.f16995c;
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding6 = dialogRomanticTripLayoutBinding5;
        if (dialogRomanticTripLayoutBinding5 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticTripLayoutBinding6 = null;
        }
        dialogRomanticTripLayoutBinding6.l.setLayoutManager(linearLayoutManager);
        ReceiveCityAdapter receiveCityAdapter3 = this.e;
        ReceiveCityAdapter receiveCityAdapter4 = receiveCityAdapter3;
        if (receiveCityAdapter3 == null) {
            Intrinsics.c("userAdapter");
            receiveCityAdapter4 = null;
        }
        receiveCityAdapter4.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.android.module.yy_china.dialog.-$$Lambda$YYRomanticTripDialog$JNmExDRNc6CUZBwamP8UIcuQVMc
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                YYRomanticTripDialog.a(YYRomanticTripDialog.this, baseQuickAdapter, view, i);
            }
        });
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null && (hasPeopleMicsExceptMyself = b.getHasPeopleMicsExceptMyself()) != null) {
            if (hasPeopleMicsExceptMyself.isEmpty()) {
                i();
                return;
            }
            if (!TextUtils.equals(hasPeopleMicsExceptMyself.get(0).getUid(), YYRoomInfoManager.e().k())) {
                hasPeopleMicsExceptMyself.get(0).isSelected = true;
            } else if (hasPeopleMicsExceptMyself.size() > 1) {
                hasPeopleMicsExceptMyself.get(1).isSelected = true;
            }
            ReceiveCityAdapter receiveCityAdapter5 = this.e;
            ReceiveCityAdapter receiveCityAdapter6 = receiveCityAdapter5;
            if (receiveCityAdapter5 == null) {
                Intrinsics.c("userAdapter");
                receiveCityAdapter6 = null;
            }
            receiveCityAdapter6.setNewData(hasPeopleMicsExceptMyself);
        }
        ReceiveCityAdapter receiveCityAdapter7 = this.e;
        if (receiveCityAdapter7 == null) {
            Intrinsics.c("userAdapter");
            receiveCityAdapter7 = null;
        }
        if (receiveCityAdapter7.getData().size() <= 1) {
            i();
        } else {
            j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0096, code lost:
        if (com.blued.android.module.yy_china.manager.YYRoomInfoManager.e().z() != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void h() {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.dialog.YYRomanticTripDialog.h():void");
    }

    private final void i() {
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding = this.f16995c;
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding2 = dialogRomanticTripLayoutBinding;
        if (dialogRomanticTripLayoutBinding == null) {
            Intrinsics.c("mBinding");
            dialogRomanticTripLayoutBinding2 = null;
        }
        dialogRomanticTripLayoutBinding2.o.setVisibility(8);
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding3 = this.f16995c;
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding4 = dialogRomanticTripLayoutBinding3;
        if (dialogRomanticTripLayoutBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticTripLayoutBinding4 = null;
        }
        dialogRomanticTripLayoutBinding4.l.setVisibility(8);
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding5 = this.f16995c;
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding6 = dialogRomanticTripLayoutBinding5;
        if (dialogRomanticTripLayoutBinding5 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticTripLayoutBinding6 = null;
        }
        dialogRomanticTripLayoutBinding6.h.setVisibility(8);
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding7 = this.f16995c;
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding8 = dialogRomanticTripLayoutBinding7;
        if (dialogRomanticTripLayoutBinding7 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticTripLayoutBinding8 = null;
        }
        ViewGroup.LayoutParams layoutParams = dialogRomanticTripLayoutBinding8.b.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ((ConstraintLayout.LayoutParams) layoutParams).topMargin = DensityUtils.a(getContext(), 26.0f);
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding9 = this.f16995c;
        if (dialogRomanticTripLayoutBinding9 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticTripLayoutBinding9 = null;
        }
        ViewGroup.LayoutParams layoutParams2 = dialogRomanticTripLayoutBinding9.f16399a.getLayoutParams();
        if (layoutParams2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ((ConstraintLayout.LayoutParams) layoutParams2).height = DensityUtils.a(getContext(), 24.5f);
    }

    private final void j() {
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding = this.f16995c;
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding2 = dialogRomanticTripLayoutBinding;
        if (dialogRomanticTripLayoutBinding == null) {
            Intrinsics.c("mBinding");
            dialogRomanticTripLayoutBinding2 = null;
        }
        dialogRomanticTripLayoutBinding2.o.setVisibility(0);
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding3 = this.f16995c;
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding4 = dialogRomanticTripLayoutBinding3;
        if (dialogRomanticTripLayoutBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticTripLayoutBinding4 = null;
        }
        dialogRomanticTripLayoutBinding4.l.setVisibility(0);
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding5 = this.f16995c;
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding6 = dialogRomanticTripLayoutBinding5;
        if (dialogRomanticTripLayoutBinding5 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticTripLayoutBinding6 = null;
        }
        dialogRomanticTripLayoutBinding6.h.setVisibility(0);
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding7 = this.f16995c;
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding8 = dialogRomanticTripLayoutBinding7;
        if (dialogRomanticTripLayoutBinding7 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticTripLayoutBinding8 = null;
        }
        ViewGroup.LayoutParams layoutParams = dialogRomanticTripLayoutBinding8.b.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ((ConstraintLayout.LayoutParams) layoutParams).topMargin = DensityUtils.a(getContext(), 18.0f);
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding9 = this.f16995c;
        if (dialogRomanticTripLayoutBinding9 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticTripLayoutBinding9 = null;
        }
        ViewGroup.LayoutParams layoutParams2 = dialogRomanticTripLayoutBinding9.f16399a.getLayoutParams();
        if (layoutParams2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ((ConstraintLayout.LayoutParams) layoutParams2).height = DensityUtils.a(getContext(), 26.0f);
    }

    private final void k() {
        final ActivityFragmentActive a2 = a();
        YYRoomHttpUtils.x(new BluedUIHttpResponse<BluedEntityA<YYRomanticCityListModel>>(a2) { // from class: com.blued.android.module.yy_china.dialog.YYRomanticTripDialog$loadCityList$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYRomanticCityListModel> bluedEntityA) {
                YYRomanticTripDialog.CityAdapter cityAdapter;
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                YYRomanticCityListModel singleData = bluedEntityA.getSingleData();
                singleData.getRegions().add(new YYRomanticCityModel("", "", "", "", 0, 0, "• 每送出一个浪漫之旅礼物可以点亮一个地点，送出更多足迹礼物，有机会点亮稀有地点；当点亮所有地点，可获得专属坐骑。"));
                singleData.getRegions().add(new YYRomanticCityModel("", "", "", "", 0, 0, "• 活动周期：每周一00:00:00到每周日23:59:59，一周一清空。"));
                cityAdapter = YYRomanticTripDialog.this.d;
                YYRomanticTripDialog.CityAdapter cityAdapter2 = cityAdapter;
                if (cityAdapter == null) {
                    Intrinsics.c("cityAdapter");
                    cityAdapter2 = null;
                }
                cityAdapter2.setNewData(singleData.getRegions());
                YYRomanticTripDialog.this.f = singleData.getGoods_info();
                YYRomanticTripDialog.this.h();
            }
        }, a());
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            this.g = String.valueOf(arguments == null ? null : arguments.getString("user_id"));
            Bundle arguments2 = getArguments();
            this.h = String.valueOf(arguments2 == null ? null : arguments2.getString("user_name"));
            return;
        }
        String k = YYRoomInfoManager.e().k();
        Intrinsics.c(k, "getInstance().selfId");
        this.g = k;
        String l = YYRoomInfoManager.e().l();
        Intrinsics.c(l, "getInstance().selfName");
        this.h = l;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_romantic_trip_layout, (ViewGroup) null);
        DialogRomanticTripLayoutBinding a2 = DialogRomanticTripLayoutBinding.a(inflate);
        Intrinsics.c(a2, "bind(view)");
        this.f16995c = a2;
        f();
        g();
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return inflate;
        }
        EventTrackYY.d(ChatRoomProtos.Event.YY_ROMANTIC_PAGE_SHOW, b.room_id, b.uid);
        return inflate;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        ImageWrapper a2 = ImageLoader.a(a(), this.f16994a);
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding = this.f16995c;
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding2 = dialogRomanticTripLayoutBinding;
        if (dialogRomanticTripLayoutBinding == null) {
            Intrinsics.c("mBinding");
            dialogRomanticTripLayoutBinding2 = null;
        }
        a2.a(dialogRomanticTripLayoutBinding2.e);
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding3 = this.f16995c;
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding4 = dialogRomanticTripLayoutBinding3;
        if (dialogRomanticTripLayoutBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticTripLayoutBinding4 = null;
        }
        dialogRomanticTripLayoutBinding4.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.dialog.-$$Lambda$YYRomanticTripDialog$1I3CXNJXWMjYIZTXQ7gqajk3jWo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYRomanticTripDialog.a(view2);
            }
        });
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding5 = this.f16995c;
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding6 = dialogRomanticTripLayoutBinding5;
        if (dialogRomanticTripLayoutBinding5 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticTripLayoutBinding6 = null;
        }
        dialogRomanticTripLayoutBinding6.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.dialog.-$$Lambda$YYRomanticTripDialog$KTkNhh1ZI-S-1yHK2kjI9g9-ZIs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYRomanticTripDialog.a(YYRomanticTripDialog.this, view2);
            }
        });
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding7 = this.f16995c;
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding8 = dialogRomanticTripLayoutBinding7;
        if (dialogRomanticTripLayoutBinding7 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticTripLayoutBinding8 = null;
        }
        dialogRomanticTripLayoutBinding8.f16400c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.dialog.-$$Lambda$YYRomanticTripDialog$2lA18pfJqis5dX9ep8vyD7auDH8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYRomanticTripDialog.b(YYRomanticTripDialog.this, view2);
            }
        });
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding9 = this.f16995c;
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding10 = dialogRomanticTripLayoutBinding9;
        if (dialogRomanticTripLayoutBinding9 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticTripLayoutBinding10 = null;
        }
        dialogRomanticTripLayoutBinding10.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.dialog.-$$Lambda$YYRomanticTripDialog$Se3plUmzxLrbApxPrVerWSrOYIc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYRomanticTripDialog.c(YYRomanticTripDialog.this, view2);
            }
        });
        DialogRomanticTripLayoutBinding dialogRomanticTripLayoutBinding11 = this.f16995c;
        if (dialogRomanticTripLayoutBinding11 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticTripLayoutBinding11 = null;
        }
        dialogRomanticTripLayoutBinding11.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.dialog.-$$Lambda$YYRomanticTripDialog$KL7JjYJIglbXciZPx9iZ7ac0WE4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYRomanticTripDialog.b(view2);
            }
        });
        k();
    }
}

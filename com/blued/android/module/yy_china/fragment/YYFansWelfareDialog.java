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
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.YYConstants;
import com.blued.android.module.yy_china.databinding.DialogFansViewBinding;
import com.blued.android.module.yy_china.fragment.YYFansWelfareDialog;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYBenefitsModel;
import com.blued.android.module.yy_china.model.YYFansBenefitModel;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYPayGoodsModel;
import com.blued.android.module.yy_china.model.YYPayRequestModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.utils.YYPayUtils;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYFansWelfareDialog.class */
public final class YYFansWelfareDialog extends YYBaseFansDialog {

    /* renamed from: a  reason: collision with root package name */
    private BaseFragment f17235a;
    private final YYUserInfo b;

    /* renamed from: c  reason: collision with root package name */
    private DialogFansViewBinding f17236c;
    private FansBenefitAdapter d;
    private YYGiftModel e;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYFansWelfareDialog$FansBenefitAdapter.class */
    public final class FansBenefitAdapter extends BaseQuickAdapter<YYBenefitsModel, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYFansWelfareDialog f17237a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FansBenefitAdapter(YYFansWelfareDialog this$0) {
            super(R.layout.item_fans_benefit);
            Intrinsics.e(this$0, "this$0");
            this.f17237a = this$0;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, YYBenefitsModel yYBenefitsModel) {
            ImageView imageView = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.img_prize_picture);
            TextView textView = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_prize_name);
            TextView textView2 = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_prize_usage);
            if (yYBenefitsModel == null) {
                return;
            }
            YYFansWelfareDialog yYFansWelfareDialog = this.f17237a;
            if (textView != null) {
                textView.setText(yYBenefitsModel.content);
            }
            if (textView2 != null) {
                textView2.setText(yYBenefitsModel.requirement);
            }
            ImageLoader.a(yYFansWelfareDialog.a(), yYBenefitsModel.icon).b(R.drawable.gift_default_icon).a(imageView);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYFansWelfareDialog(BaseFragment fragment, YYUserInfo us) {
        super(fragment, us);
        Intrinsics.e(fragment, "fragment");
        Intrinsics.e(us, "us");
        this.f17235a = fragment;
        this.b = us;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
        ToastUtils.a("仅支持在该主播开播的房间加入该主播粉丝团");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v3, types: [T, com.blued.android.module.yy_china.model.YYPayRequestModel] */
    public static final void a(final YYFansWelfareDialog this$0, View view) {
        long longValue;
        Intrinsics.e(this$0, "this$0");
        if (this$0.e == null) {
            return;
        }
        ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_FANS_PANEL_JOIN_CLICK;
        YYRoomModel h = this$0.h();
        String str = h == null ? null : h.room_id;
        YYUserInfo g = this$0.g();
        String uid = g == null ? null : g.getUid();
        YYUserInfo g2 = this$0.g();
        EventTrackYY.k(event, str, uid, g2 == null ? null : g2.getUid());
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f42545a = new YYPayRequestModel();
        YYGiftModel yYGiftModel = this$0.e;
        if (yYGiftModel != null) {
            yYGiftModel.hit_id = System.currentTimeMillis();
        }
        ((YYPayRequestModel) objectRef.f42545a).gift = this$0.e;
        YYPayRequestModel yYPayRequestModel = (YYPayRequestModel) objectRef.f42545a;
        YYGiftModel yYGiftModel2 = this$0.e;
        if ((yYGiftModel2 == null ? null : Long.valueOf(yYGiftModel2.beans)) == null) {
            longValue = 0;
        } else {
            YYGiftModel yYGiftModel3 = this$0.e;
            Long valueOf = yYGiftModel3 == null ? null : Long.valueOf(yYGiftModel3.beans);
            Intrinsics.a(valueOf);
            longValue = valueOf.longValue();
        }
        yYPayRequestModel.beans = longValue;
        ((YYPayRequestModel) objectRef.f42545a).giftCount = 1;
        YYPayRequestModel yYPayRequestModel2 = (YYPayRequestModel) objectRef.f42545a;
        YYGiftModel yYGiftModel4 = this$0.e;
        yYPayRequestModel2.goods_id = yYGiftModel4 == null ? null : yYGiftModel4.goods_id;
        YYPayRequestModel yYPayRequestModel3 = (YYPayRequestModel) objectRef.f42545a;
        YYGiftModel yYGiftModel5 = this$0.e;
        Integer valueOf2 = yYGiftModel5 == null ? null : Integer.valueOf(yYGiftModel5.goods_type);
        Intrinsics.a(valueOf2);
        yYPayRequestModel3.goods_type = valueOf2.intValue();
        ((YYPayRequestModel) objectRef.f42545a).hit_id = 0L;
        ((YYPayRequestModel) objectRef.f42545a).payCode = "";
        ((YYPayRequestModel) objectRef.f42545a).remember_me = false;
        YYPayRequestModel yYPayRequestModel4 = (YYPayRequestModel) objectRef.f42545a;
        YYRoomModel h2 = this$0.h();
        yYPayRequestModel4.room_id = h2 == null ? null : h2.room_id;
        YYPayRequestModel yYPayRequestModel5 = (YYPayRequestModel) objectRef.f42545a;
        YYUserInfo g3 = this$0.g();
        yYPayRequestModel5.target_uid = g3 == null ? null : g3.getUid();
        ((YYPayRequestModel) objectRef.f42545a).pay_from = 1;
        YYPayUtils.a((YYPayRequestModel) objectRef.f42545a, YYConstants.PayFromSource.Pay_Gift, this$0.f(), this$0.f().getFragmentActive(), new YYPayUtils.PayGiftStatusListener() { // from class: com.blued.android.module.yy_china.fragment.YYFansWelfareDialog$initView$1$1
            @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
            public void a(int i, String errorMessage) {
                Intrinsics.e(errorMessage, "errorMessage");
            }

            @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
            public void a(YYPayGoodsModel goodsModel) {
                YYGiftModel yYGiftModel6;
                Intrinsics.e(goodsModel, "goodsModel");
                YYSeatMemberModel yYSeatMemberModel = YYRoomInfoManager.e().o().get(objectRef.f42545a.target_uid);
                if (yYSeatMemberModel == null) {
                    return;
                }
                YYImMsgManager a2 = YYImMsgManager.a();
                yYGiftModel6 = this$0.e;
                a2.a(yYGiftModel6, yYSeatMemberModel, goodsModel, false);
            }
        });
        this$0.dismissAllowingStateLoss();
    }

    private final void l() {
        YYUserInfo g = g();
        if (g == null) {
            return;
        }
        ImageWrapper b = ImageLoader.a(a(), g.getAvatar()).b(R.drawable.user_bg_round);
        DialogFansViewBinding dialogFansViewBinding = this.f17236c;
        b.a(dialogFansViewBinding == null ? null : dialogFansViewBinding.d);
        DialogFansViewBinding dialogFansViewBinding2 = this.f17236c;
        TextView textView = dialogFansViewBinding2 == null ? null : dialogFansViewBinding2.m;
        if (textView == null) {
            return;
        }
        textView.setText(Intrinsics.a(g.getName(), (Object) "的粉丝团"));
    }

    private final void m() {
        this.d = new FansBenefitAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        DialogFansViewBinding dialogFansViewBinding = this.f17236c;
        RecyclerView recyclerView = dialogFansViewBinding == null ? null : dialogFansViewBinding.j;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(gridLayoutManager);
        }
        DialogFansViewBinding dialogFansViewBinding2 = this.f17236c;
        RecyclerView recyclerView2 = dialogFansViewBinding2 == null ? null : dialogFansViewBinding2.j;
        if (recyclerView2 == null) {
            return;
        }
        recyclerView2.setAdapter(this.d);
    }

    private final void n() {
        ShapeLinearLayout shapeLinearLayout;
        YYRoomModel h = h();
        if (Intrinsics.a((Object) (h == null ? null : h.uid), (Object) g().getUid())) {
            DialogFansViewBinding dialogFansViewBinding = this.f17236c;
            if (dialogFansViewBinding == null || (shapeLinearLayout = dialogFansViewBinding.f16334a) == null) {
                return;
            }
            shapeLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYFansWelfareDialog$2Sbx0PVTuXTdHJRJiWerRFNE-rw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYFansWelfareDialog.a(YYFansWelfareDialog.this, view);
                }
            });
            return;
        }
        DialogFansViewBinding dialogFansViewBinding2 = this.f17236c;
        if (dialogFansViewBinding2 == null) {
            return;
        }
        ShapeHelper.a(dialogFansViewBinding2.f16334a, R.color.syc_7C7C7C, R.color.syc_ADADAD);
        dialogFansViewBinding2.f16334a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYFansWelfareDialog$quAQ-s5_h3Q58S1RUhvpZXGMelE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYFansWelfareDialog.a(view);
            }
        });
    }

    private final void o() {
        YYUserInfo g = g();
        String uid = g == null ? null : g.getUid();
        final ActivityFragmentActive a2 = a();
        YYRoomHttpUtils.p(uid, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYFansBenefitModel>>(a2) { // from class: com.blued.android.module.yy_china.fragment.YYFansWelfareDialog$getFansBenefit$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYFansBenefitModel> bluedEntityA) {
                YYFansBenefitModel singleData;
                DialogFansViewBinding dialogFansViewBinding;
                YYFansWelfareDialog.FansBenefitAdapter fansBenefitAdapter;
                DialogFansViewBinding dialogFansViewBinding2;
                DialogFansViewBinding dialogFansViewBinding3;
                if (bluedEntityA == null || !bluedEntityA.hasData() || (singleData = bluedEntityA.getSingleData()) == null) {
                    return;
                }
                YYFansWelfareDialog yYFansWelfareDialog = YYFansWelfareDialog.this;
                dialogFansViewBinding = yYFansWelfareDialog.f17236c;
                TextView textView = dialogFansViewBinding == null ? null : dialogFansViewBinding.k;
                if (textView != null) {
                    textView.setText(singleData.fans_count);
                }
                ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_FANS_PANEL_SHOW;
                YYRoomModel h = yYFansWelfareDialog.h();
                String str = h == null ? null : h.room_id;
                YYRoomModel h2 = yYFansWelfareDialog.h();
                String str2 = h2 == null ? null : h2.uid;
                YYUserInfo g2 = yYFansWelfareDialog.g();
                EventTrackYY.a(event, str, str2, g2 == null ? null : g2.getUid(), ChatRoomProtos.UserType.NOT_FANS);
                fansBenefitAdapter = yYFansWelfareDialog.d;
                if (fansBenefitAdapter != null) {
                    fansBenefitAdapter.setNewData(singleData.benefits);
                }
                YYGiftModel yYGiftModel = singleData.android_ticket_goods;
                if (yYGiftModel == null) {
                    return;
                }
                yYFansWelfareDialog.e = yYGiftModel;
                ImageWrapper b = ImageLoader.a(yYFansWelfareDialog.a(), yYGiftModel.images_static).b(R.drawable.gift_default_icon);
                dialogFansViewBinding2 = yYFansWelfareDialog.f17236c;
                b.a(dialogFansViewBinding2 == null ? null : dialogFansViewBinding2.f16335c);
                dialogFansViewBinding3 = yYFansWelfareDialog.f17236c;
                TextView textView2 = dialogFansViewBinding3 == null ? null : dialogFansViewBinding3.l;
                if (textView2 == null) {
                    return;
                }
                textView2.setText("并加入（" + yYGiftModel.beans + "弯豆）");
            }
        }, a());
    }

    @Override // com.blued.android.module.yy_china.fragment.YYBaseFansDialog
    public BaseFragment f() {
        return this.f17235a;
    }

    @Override // com.blued.android.module.yy_china.fragment.YYBaseFansDialog
    public YYUserInfo g() {
        return this.b;
    }

    @Override // com.blued.android.module.yy_china.fragment.YYBaseFansDialog
    public View j() {
        DialogFansViewBinding dialogFansViewBinding = this.f17236c;
        return dialogFansViewBinding == null ? null : dialogFansViewBinding.e;
    }

    @Override // com.blued.android.module.yy_china.fragment.YYBaseFansDialog
    public View k() {
        DialogFansViewBinding dialogFansViewBinding = this.f17236c;
        if (dialogFansViewBinding == null) {
            return null;
        }
        return dialogFansViewBinding.b;
    }

    @Override // com.blued.android.module.yy_china.fragment.YYBaseFansDialog, com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        o();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dialog_fans_view, viewGroup, true);
        Intrinsics.c(inflate, "inflater.inflate(R.layou…ns_view, container, true)");
        this.f17236c = DialogFansViewBinding.a(inflate);
        l();
        n();
        m();
        return inflate;
    }
}

package com.blued.android.module.yy_china.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.YYConstants;
import com.blued.android.module.yy_china.adapter.YYRedPackageItemAdapter;
import com.blued.android.module.yy_china.databinding.DialogRedPackageBinding;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYPayGoodsModel;
import com.blued.android.module.yy_china.model.YYPayRequestModel;
import com.blued.android.module.yy_china.model.YYRedPackageDetails;
import com.blued.android.module.yy_china.model.YYRedPackageDetailsExtra;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.utils.YYPayUtils;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRedPackageDialog.class */
public final class YYRedPackageDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private DialogRedPackageBinding f17417a;
    private YYRedPackageDetails b;

    /* renamed from: c  reason: collision with root package name */
    private YYRedPackageItemAdapter f17418c;
    private YYGiftModel d;
    private ArrayList<YYSeatMemberModel> e;
    private String f = "";

    public YYRedPackageDialog(ArrayList<YYSeatMemberModel> arrayList) {
        this.e = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRedPackageDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRedPackageDialog this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        List<YYRedPackageDetails> data;
        Intrinsics.e(this$0, "this$0");
        YYRedPackageItemAdapter yYRedPackageItemAdapter = this$0.f17418c;
        if (yYRedPackageItemAdapter == null || (data = yYRedPackageItemAdapter.getData()) == null) {
            return;
        }
        for (YYRedPackageDetails yYRedPackageDetails : data) {
            yYRedPackageDetails.set_checked(0);
        }
        this$0.b = data.get(i);
        data.get(i).set_checked(1);
        YYRedPackageItemAdapter yYRedPackageItemAdapter2 = this$0.f17418c;
        if (yYRedPackageItemAdapter2 == null) {
            return;
        }
        yYRedPackageItemAdapter2.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, com.blued.android.module.yy_china.model.YYPayRequestModel] */
    public final void a(ArrayList<YYSeatMemberModel> arrayList, final String str, final boolean z) {
        YYRoomModel b;
        YYSeatMemberModel yYSeatMemberModel;
        if (this.b == null || (b = YYRoomInfoManager.e().b()) == null) {
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f42545a = new YYPayRequestModel();
        YYGiftModel yYGiftModel = this.d;
        if (yYGiftModel != null) {
            yYGiftModel.hit_id = System.currentTimeMillis();
        }
        ((YYPayRequestModel) objectRef.f42545a).gift = this.d;
        YYPayRequestModel yYPayRequestModel = (YYPayRequestModel) objectRef.f42545a;
        YYRedPackageDetails yYRedPackageDetails = this.b;
        yYPayRequestModel.beans = StringUtils.a(yYRedPackageDetails == null ? null : yYRedPackageDetails.getTotal_beans(), 0L);
        ((YYPayRequestModel) objectRef.f42545a).giftCount = 1;
        YYPayRequestModel yYPayRequestModel2 = (YYPayRequestModel) objectRef.f42545a;
        YYGiftModel yYGiftModel2 = this.d;
        yYPayRequestModel2.goods_id = yYGiftModel2 == null ? null : yYGiftModel2.goods_id;
        YYPayRequestModel yYPayRequestModel3 = (YYPayRequestModel) objectRef.f42545a;
        YYGiftModel yYGiftModel3 = this.d;
        Integer valueOf = yYGiftModel3 == null ? null : Integer.valueOf(yYGiftModel3.goods_type);
        Intrinsics.a(valueOf);
        yYPayRequestModel3.goods_type = valueOf.intValue();
        ((YYPayRequestModel) objectRef.f42545a).hit_id = 0L;
        ((YYPayRequestModel) objectRef.f42545a).payCode = str;
        ((YYPayRequestModel) objectRef.f42545a).remember_me = z;
        ((YYPayRequestModel) objectRef.f42545a).room_id = b.room_id;
        ((YYPayRequestModel) objectRef.f42545a).target_uid = (arrayList == null || (yYSeatMemberModel = arrayList.get(0)) == null) ? null : yYSeatMemberModel.getUid();
        ((YYPayRequestModel) objectRef.f42545a).pay_from = 1;
        YYPayRequestModel yYPayRequestModel4 = (YYPayRequestModel) objectRef.f42545a;
        YYRedPackageDetails yYRedPackageDetails2 = this.b;
        yYPayRequestModel4.redPacket_group_id = yYRedPackageDetails2 == null ? null : yYRedPackageDetails2.getId();
        YYPayUtils.a((YYPayRequestModel) objectRef.f42545a, YYConstants.PayFromSource.Pay_Gift, this, a(), new YYPayUtils.PayGiftStatusListener() { // from class: com.blued.android.module.yy_china.fragment.YYRedPackageDialog$toPay$1
            @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
            public void a(int i, String errorMessage) {
                Intrinsics.e(errorMessage, "errorMessage");
                this.dismissAllowingStateLoss();
            }

            @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
            public void a(YYPayGoodsModel goodsModel) {
                YYGiftModel yYGiftModel4;
                ArrayList arrayList2;
                ArrayList arrayList3;
                ArrayList arrayList4;
                ArrayList arrayList5;
                ArrayList arrayList6;
                Intrinsics.e(goodsModel, "goodsModel");
                YYSeatMemberModel yYSeatMemberModel2 = YYRoomInfoManager.e().o().get(objectRef.f42545a.target_uid);
                if (yYSeatMemberModel2 == null) {
                    return;
                }
                YYImMsgManager a2 = YYImMsgManager.a();
                yYGiftModel4 = this.d;
                a2.a(yYGiftModel4, yYSeatMemberModel2, goodsModel, false);
                arrayList2 = this.e;
                if (arrayList2 != null) {
                    arrayList3 = this.e;
                    Intrinsics.a(arrayList3);
                    if (arrayList3.size() > 0) {
                        arrayList4 = this.e;
                        if (arrayList4 != null) {
                            YYSeatMemberModel yYSeatMemberModel3 = (YYSeatMemberModel) arrayList4.remove(0);
                        }
                        arrayList5 = this.e;
                        Intrinsics.a(arrayList5);
                        if (arrayList5.size() > 0) {
                            YYRedPackageDialog yYRedPackageDialog = this;
                            arrayList6 = yYRedPackageDialog.e;
                            yYRedPackageDialog.a(arrayList6, str, z);
                            return;
                        }
                    }
                }
                this.dismissAllowingStateLoss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYRedPackageDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYRedPackageDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        ArrayList<YYSeatMemberModel> arrayList = this$0.e;
        if (arrayList == null) {
            return;
        }
        if (arrayList.isEmpty()) {
            ToastUtils.a("当前无可赠送用户");
        } else if (arrayList.size() == 1 && YYRoomInfoManager.e().y() && TextUtils.equals(arrayList.get(0).getUid(), YYRoomInfoManager.e().k())) {
            ToastUtils.a("当前无可赠送用户");
        } else {
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b != null) {
                ChatRoomProtos.Event event = ChatRoomProtos.Event.YY_ROOM_REDBAG_PAGE_SEND_CLICK;
                String str = b.room_id;
                String str2 = b.uid;
                YYRedPackageDetails yYRedPackageDetails = this$0.b;
                EventTrackYY.r(event, str, str2, yYRedPackageDetails == null ? null : yYRedPackageDetails.getTotal_beans());
            }
            this$0.a(arrayList, "", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(YYRedPackageDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            EventTrackYY.d(ChatRoomProtos.Event.YY_ROOM_REDBAG_PAGE_RULE_CLICK, b.room_id, b.uid);
        }
        YYRedPackageGuideDialog yYRedPackageGuideDialog = new YYRedPackageGuideDialog(this$0.f);
        FragmentManager parentFragmentManager = this$0.getParentFragmentManager();
        Intrinsics.c(parentFragmentManager, "parentFragmentManager");
        yYRedPackageGuideDialog.show(parentFragmentManager, "red_package_guide_dialog");
    }

    private final void f() {
        ShapeTextView shapeTextView;
        ImageView imageView;
        ImageView imageView2;
        View view;
        DialogRedPackageBinding dialogRedPackageBinding = this.f17417a;
        if (dialogRedPackageBinding != null && (view = dialogRedPackageBinding.d) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRedPackageDialog$1nGpFknLx1D1jUSq0hGsxNutM-g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYRedPackageDialog.a(YYRedPackageDialog.this, view2);
                }
            });
        }
        DialogRedPackageBinding dialogRedPackageBinding2 = this.f17417a;
        if (dialogRedPackageBinding2 != null && (imageView2 = dialogRedPackageBinding2.e) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRedPackageDialog$BL1Psd_W13OyvY5flSqxECPrp8U
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYRedPackageDialog.b(YYRedPackageDialog.this, view2);
                }
            });
        }
        DialogRedPackageBinding dialogRedPackageBinding3 = this.f17417a;
        if (dialogRedPackageBinding3 != null && (imageView = dialogRedPackageBinding3.b) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRedPackageDialog$NpqT7L9QtxUzp31VYDq7tZk7OrM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYRedPackageDialog.c(YYRedPackageDialog.this, view2);
                }
            });
        }
        DialogRedPackageBinding dialogRedPackageBinding4 = this.f17417a;
        if (dialogRedPackageBinding4 == null || (shapeTextView = dialogRedPackageBinding4.f16383a) == null) {
            return;
        }
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRedPackageDialog$ztgMUY4Sy8sIvcxjaTo1EkRVkPg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYRedPackageDialog.d(YYRedPackageDialog.this, view2);
            }
        });
    }

    private final void g() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        DialogRedPackageBinding dialogRedPackageBinding = this.f17417a;
        RecyclerView recyclerView = dialogRedPackageBinding == null ? null : dialogRedPackageBinding.g;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        this.f17418c = new YYRedPackageItemAdapter();
        DialogRedPackageBinding dialogRedPackageBinding2 = this.f17417a;
        RecyclerView recyclerView2 = dialogRedPackageBinding2 == null ? null : dialogRedPackageBinding2.g;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.f17418c);
        }
        YYRedPackageItemAdapter yYRedPackageItemAdapter = this.f17418c;
        if (yYRedPackageItemAdapter == null) {
            return;
        }
        yYRedPackageItemAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRedPackageDialog$UEfBRg1NJb4Y7fYj5zRZZufk-eM
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                YYRedPackageDialog.a(YYRedPackageDialog.this, baseQuickAdapter, view, i);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if ((i == 4221005 || i == 4221004) && intent != null) {
                a(this.e, intent.getStringExtra("password"), intent.getBooleanExtra("remember_me", false));
            } else if (i != 4221002 || intent == null) {
            } else {
                boolean booleanExtra = intent.getBooleanExtra("remember_me", false);
                a(this.e, intent.getStringExtra("password"), booleanExtra);
            }
        }
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dialog_red_package, viewGroup, true);
        Intrinsics.c(inflate, "inflater.inflate(R.layou…package, container, true)");
        this.f17417a = DialogRedPackageBinding.a(inflate);
        f();
        g();
        return inflate;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            ChatRoomProtos.Event event = ChatRoomProtos.Event.YY_ROOM_REDBAG_PAGE_SHOW;
            String str = b.room_id;
            String str2 = b.uid;
            YYRedPackageDetails yYRedPackageDetails = this.b;
            EventTrackYY.r(event, str, str2, yYRedPackageDetails == null ? null : yYRedPackageDetails.getTotal_beans());
        }
        final ActivityFragmentActive a2 = a();
        YYRoomHttpUtils.e((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntity<YYRedPackageDetails, YYRedPackageDetailsExtra>>(a2) { // from class: com.blued.android.module.yy_china.fragment.YYRedPackageDialog$onViewCreated$2
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<YYRedPackageDetails, YYRedPackageDetailsExtra> bluedEntity) {
                YYRedPackageDetails yYRedPackageDetails2;
                YYRedPackageItemAdapter yYRedPackageItemAdapter;
                DialogRedPackageBinding dialogRedPackageBinding;
                if (bluedEntity == null) {
                    return;
                }
                YYRedPackageDialog yYRedPackageDialog = YYRedPackageDialog.this;
                Iterator<YYRedPackageDetails> it = bluedEntity.data.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    YYRedPackageDetails next = it.next();
                    if (next != null && next.is_checked() == 1) {
                        yYRedPackageDialog.b = next;
                        break;
                    }
                }
                yYRedPackageDetails2 = yYRedPackageDialog.b;
                if (yYRedPackageDetails2 == null) {
                    yYRedPackageDialog.b = bluedEntity.data.get(0);
                    bluedEntity.data.get(0).set_checked(1);
                }
                yYRedPackageItemAdapter = yYRedPackageDialog.f17418c;
                if (yYRedPackageItemAdapter != null) {
                    yYRedPackageItemAdapter.setNewData(bluedEntity.data);
                }
                YYRedPackageDetailsExtra yYRedPackageDetailsExtra = bluedEntity.extra;
                if (yYRedPackageDetailsExtra == null) {
                    return;
                }
                yYRedPackageDialog.f = yYRedPackageDetailsExtra.getClose_time();
                yYRedPackageDialog.d = yYRedPackageDetailsExtra.getGoods_info();
                dialogRedPackageBinding = yYRedPackageDialog.f17417a;
                TextView textView = dialogRedPackageBinding == null ? null : dialogRedPackageBinding.h;
                if (textView == null) {
                    return;
                }
                textView.setText("注：发送红包" + yYRedPackageDetailsExtra.getClose_time() + "s后可领，为聊天室积攒人气");
            }
        }, a());
    }
}

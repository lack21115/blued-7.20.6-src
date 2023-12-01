package com.blued.android.module.yy_china.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogNewUserGiftInfoBinding;
import com.blued.android.module.yy_china.databinding.ItemNewUserGiftInfoBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.NewComesNewGiftModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYNewUserGiftINfoDialog.class */
public final class YYNewUserGiftINfoDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private DialogNewUserGiftInfoBinding f18341a;
    private NewComesNewGiftModel b;

    /* renamed from: c  reason: collision with root package name */
    private int f18342c;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYNewUserGiftINfoDialog$CAdapter.class */
    public final class CAdapter extends BaseQuickAdapter<NewComesNewGiftModel, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYNewUserGiftINfoDialog f18343a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CAdapter(YYNewUserGiftINfoDialog this$0) {
            super(R.layout.item_new_user_gift_info, new ArrayList());
            Intrinsics.e(this$0, "this$0");
            this.f18343a = this$0;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder helper, NewComesNewGiftModel newComesNewGiftModel) {
            Intrinsics.e(helper, "helper");
            ItemNewUserGiftInfoBinding a2 = ItemNewUserGiftInfoBinding.a(helper.itemView);
            Intrinsics.c(a2, "bind(helper.itemView)");
            if (newComesNewGiftModel == null) {
                return;
            }
            ImageLoader.a(this.f18343a.a(), newComesNewGiftModel.getPic()).a(a2.f16634a);
            TextView textView = a2.f16635c;
            textView.setText(newComesNewGiftModel.getName() + " * " + newComesNewGiftModel.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYNewUserGiftINfoDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYNewUserGiftINfoDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYNewUserGiftINfoDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_NEW_GIFT_PROP_CLICK, this$0.f18342c);
        YYRoomInfoManager.e().c().a(this$0.getContext(), YYRoomInfoManager.e().c(6), 0);
    }

    private final void f() {
        TextView textView;
        ImageView imageView;
        ShapeTextView shapeTextView;
        DialogNewUserGiftInfoBinding dialogNewUserGiftInfoBinding = this.f18341a;
        if (dialogNewUserGiftInfoBinding != null && (shapeTextView = dialogNewUserGiftInfoBinding.d) != null) {
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYNewUserGiftINfoDialog$CG2sVKodTF3nf31fc_MRv1_NEZU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYNewUserGiftINfoDialog.a(YYNewUserGiftINfoDialog.this, view);
                }
            });
        }
        DialogNewUserGiftInfoBinding dialogNewUserGiftInfoBinding2 = this.f18341a;
        if (dialogNewUserGiftInfoBinding2 != null && (imageView = dialogNewUserGiftInfoBinding2.b) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYNewUserGiftINfoDialog$yuDjwtjR56OL2p91gnTq0EIVdcU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYNewUserGiftINfoDialog.b(YYNewUserGiftINfoDialog.this, view);
                }
            });
        }
        DialogNewUserGiftInfoBinding dialogNewUserGiftInfoBinding3 = this.f18341a;
        RecyclerView recyclerView = dialogNewUserGiftInfoBinding3 == null ? null : dialogNewUserGiftInfoBinding3.f16371c;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        CAdapter cAdapter = new CAdapter(this);
        DialogNewUserGiftInfoBinding dialogNewUserGiftInfoBinding4 = this.f18341a;
        RecyclerView recyclerView2 = dialogNewUserGiftInfoBinding4 == null ? null : dialogNewUserGiftInfoBinding4.f16371c;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(cAdapter);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.b);
        cAdapter.setNewData(arrayList);
        EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_NEW_GIFT_GET_SUCCESS, this.f18342c);
        NewComesNewGiftModel newComesNewGiftModel = this.b;
        if (Intrinsics.a((Object) (newComesNewGiftModel == null ? null : newComesNewGiftModel.getType()), (Object) "goods_coupon")) {
            DialogNewUserGiftInfoBinding dialogNewUserGiftInfoBinding5 = this.f18341a;
            TextView textView2 = dialogNewUserGiftInfoBinding5 == null ? null : dialogNewUserGiftInfoBinding5.e;
            if (textView2 == null) {
                return;
            }
            textView2.setText("奖励已下发至您的背包");
            return;
        }
        DialogNewUserGiftInfoBinding dialogNewUserGiftInfoBinding6 = this.f18341a;
        TextView textView3 = dialogNewUserGiftInfoBinding6 == null ? null : dialogNewUserGiftInfoBinding6.e;
        if (textView3 != null) {
            textView3.setText("奖励已下发至您的道具，点击跳转至我的道具");
        }
        DialogNewUserGiftInfoBinding dialogNewUserGiftInfoBinding7 = this.f18341a;
        if (dialogNewUserGiftInfoBinding7 == null || (textView = dialogNewUserGiftInfoBinding7.e) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYNewUserGiftINfoDialog$ipNek_9wDE9eLfd5Q5ad9hxEAlQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYNewUserGiftINfoDialog.c(YYNewUserGiftINfoDialog.this, view);
            }
        });
    }

    public final YYNewUserGiftINfoDialog a(NewComesNewGiftModel da, Integer num) {
        Intrinsics.e(da, "da");
        this.b = da;
        Integer valueOf = num == null ? null : Integer.valueOf(num.intValue() + 1);
        Intrinsics.a(valueOf);
        this.f18342c = valueOf.intValue();
        return this;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dialog_new_user_gift_info, viewGroup, true);
        this.f18341a = DialogNewUserGiftInfoBinding.a(inflate);
        f();
        return inflate;
    }
}

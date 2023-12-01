package com.blued.android.module.yy_china.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.YYConstants;
import com.blued.android.module.yy_china.databinding.DialogKtvSendGiftNumBinding;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYKtvCardModel;
import com.blued.android.module.yy_china.model.YYPayGoodsModel;
import com.blued.android.module.yy_china.model.YYPayRequestModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.utils.YYPayUtils;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYKtvSendGiftSongNumView.class */
public final class YYKtvSendGiftSongNumView extends BottomSheetDialogFragment {
    private DialogKtvSendGiftNumBinding a;
    private BaseYYStudioFragment b;
    private YYKtvCardModel c;
    private long d;
    private long e;
    private int f;
    private YYGiftModel g;

    private final void a(ShapeTextView shapeTextView, final int i) {
        if (shapeTextView != null) {
            shapeTextView.setVisibility(0);
        }
        if (shapeTextView != null) {
            String string = getString(R.string.yy_ktv_send_bttn);
            Intrinsics.c(string, "getString(R.string.yy_ktv_send_bttn)");
            String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(i)}, 1));
            Intrinsics.c(format, "format(this, *args)");
            shapeTextView.setText(format);
        }
        if (shapeTextView == null) {
            return;
        }
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYKtvSendGiftSongNumView$LQfEd69nByrecq968be8lsXBb8Y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYKtvSendGiftSongNumView.a(YYKtvSendGiftSongNumView.this, i, view);
            }
        });
    }

    private final void a(final YYGiftModel yYGiftModel, String str, boolean z, int i) {
        YYRoomModel b;
        String str2;
        if (yYGiftModel == null) {
            return;
        }
        final YYPayRequestModel yYPayRequestModel = new YYPayRequestModel();
        yYGiftModel.hit_id = System.currentTimeMillis();
        if (YYRoomInfoManager.e().b() == null || (b = YYRoomInfoManager.e().b()) == null) {
            return;
        }
        yYPayRequestModel.gift = yYGiftModel;
        yYPayRequestModel.beans = yYGiftModel.beans;
        yYPayRequestModel.giftCount = i;
        yYPayRequestModel.goods_id = yYGiftModel.goods_id;
        yYPayRequestModel.goods_type = yYGiftModel.goods_type;
        long currentTimeMillis = System.currentTimeMillis();
        if (i > 1) {
            this.d = 1L;
            yYGiftModel.hit_batch = 1;
            yYGiftModel.double_hit = 1;
        }
        if (yYGiftModel.double_hit == 1) {
            YYGiftModel yYGiftModel2 = this.g;
            if (yYGiftModel2 != null) {
                Intrinsics.a(yYGiftModel2);
                str2 = yYGiftModel2.goods_id;
            } else {
                str2 = "";
            }
            if (!StringUtils.a(str2, yYGiftModel.goods_id) || this.d <= 0 || currentTimeMillis - this.e >= 8000) {
                this.d = currentTimeMillis;
                this.e = currentTimeMillis;
                this.f = i;
            } else {
                this.e = currentTimeMillis;
                this.f++;
            }
            yYGiftModel.hit_count = this.f;
        } else {
            this.d = 0L;
            yYGiftModel.hit_count = i;
        }
        yYPayRequestModel.hit_id = this.d;
        yYPayRequestModel.payCode = str;
        yYPayRequestModel.remember_me = z;
        yYPayRequestModel.room_id = b.room_id;
        yYPayRequestModel.target_uid = b.uid;
        yYPayRequestModel.pay_from = 1;
        yYGiftModel.hit_id = this.d;
        YYConstants.PayFromSource payFromSource = YYConstants.PayFromSource.Pay_Gift;
        BaseYYStudioFragment baseYYStudioFragment = this.b;
        YYPayUtils.a(yYPayRequestModel, payFromSource, baseYYStudioFragment, baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive(), new YYPayUtils.PayGiftStatusListener() { // from class: com.blued.android.module.yy_china.view.YYKtvSendGiftSongNumView$buyGift$1
            @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
            public void a(int i2, String errorMessage) {
                Intrinsics.e(errorMessage, "errorMessage");
            }

            @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
            public void a(YYPayGoodsModel goodsModel) {
                Intrinsics.e(goodsModel, "goodsModel");
                YYKtvSendGiftSongNumView.this.g = yYGiftModel;
                YYSeatMemberModel yYSeatMemberModel = YYRoomInfoManager.e().o().get(yYPayRequestModel.target_uid);
                if (yYSeatMemberModel == null) {
                    return;
                }
                YYImMsgManager.a().a(yYGiftModel, yYSeatMemberModel, goodsModel, false);
                YYKtvSendGiftSongNumView.this.dismissAllowingStateLoss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYKtvSendGiftSongNumView this$0, int i, View view) {
        Intrinsics.e(this$0, "this$0");
        YYKtvCardModel yYKtvCardModel = this$0.c;
        this$0.a(yYKtvCardModel == null ? null : yYKtvCardModel.goods_info, "", false, i);
    }

    private final void i() {
        j();
        YYRoomModel b = YYRoomInfoManager.e().b();
        String str = b == null ? null : b.room_id;
        final ActivityFragmentActive a = a();
        YYRoomHttpUtils.k(str, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYKtvCardModel>>(a) { // from class: com.blued.android.module.yy_china.view.YYKtvSendGiftSongNumView$loaData$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYKtvCardModel> bluedEntityA) {
                YYKtvSendGiftSongNumView.this.a(bluedEntityA == null ? null : bluedEntityA.getSingleData());
                YYKtvSendGiftSongNumView.this.j();
            }
        }, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        YYKtvCardModel yYKtvCardModel = this.c;
        if (yYKtvCardModel == null) {
            return;
        }
        if (YYRoomInfoManager.e().y()) {
            DialogKtvSendGiftNumBinding h = h();
            if (h != null && (textView6 = h.f) != null) {
                textView6.setText(getString(R.string.yy_ktv_available_amount_cont, new Object[]{yYKtvCardModel.goods_info.name, yYKtvCardModel.sing_limit}));
            }
        } else {
            DialogKtvSendGiftNumBinding h2 = h();
            if (h2 != null && (textView = h2.f) != null) {
                textView.setText(getString(R.string.yy_ktv_available_amount_cont_user, new Object[]{yYKtvCardModel.sing_limit}));
            }
        }
        ImageWrapper a = ImageLoader.a(a(), yYKtvCardModel.goods_info.images_static);
        DialogKtvSendGiftNumBinding h3 = h();
        a.a(h3 == null ? null : h3.a);
        DialogKtvSendGiftNumBinding h4 = h();
        if (h4 != null && (textView5 = h4.h) != null) {
            textView5.setText(getString(R.string.yy_ktv_available_amount_mess, new Object[]{yYKtvCardModel.goods_info.name}));
        }
        if (yYKtvCardModel.send_item.size() > 0) {
            DialogKtvSendGiftNumBinding h5 = h();
            ShapeTextView shapeTextView = h5 == null ? null : h5.c;
            Integer num = yYKtvCardModel.send_item.get(0);
            Intrinsics.c(num, "it.send_item.get(0)");
            a(shapeTextView, num.intValue());
        }
        if (yYKtvCardModel.send_item.size() > 1) {
            DialogKtvSendGiftNumBinding h6 = h();
            ShapeTextView shapeTextView2 = h6 == null ? null : h6.d;
            Integer num2 = yYKtvCardModel.send_item.get(1);
            Intrinsics.c(num2, "it.send_item.get(1)");
            a(shapeTextView2, num2.intValue());
        }
        if (yYKtvCardModel.send_item.size() > 2) {
            DialogKtvSendGiftNumBinding h7 = h();
            ShapeTextView shapeTextView3 = h7 == null ? null : h7.e;
            Integer num3 = yYKtvCardModel.send_item.get(2);
            Intrinsics.c(num3, "it.send_item.get(2)");
            a(shapeTextView3, num3.intValue());
        }
        if (YYRoomInfoManager.e().y()) {
            DialogKtvSendGiftNumBinding h8 = h();
            LinearLayout linearLayout = h8 == null ? null : h8.b;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            DialogKtvSendGiftNumBinding h9 = h();
            if (h9 != null && (textView4 = h9.g) != null) {
                textView4.setText(getString(R.string.yy_ktv_available_amount_fell_cont, new Object[]{String.valueOf(yYKtvCardModel.free_sing_limit)}));
            }
            DialogKtvSendGiftNumBinding h10 = h();
            if (h10 != null && (textView3 = h10.h) != null) {
                textView3.setText(getString(R.string.yy_ktv_available_amount_mess_free));
            }
            DialogKtvSendGiftNumBinding h11 = h();
            if (h11 == null || (textView2 = h11.i) == null) {
                return;
            }
            textView2.setText(getString(R.string.yy_ktv_available_amount_mess, new Object[]{yYKtvCardModel.goods_info.name}));
        }
    }

    public final void a(BaseYYStudioFragment baseYYStudioFragment) {
        this.b = baseYYStudioFragment;
    }

    public final void a(YYKtvCardModel yYKtvCardModel) {
        this.c = yYKtvCardModel;
    }

    @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment
    public boolean f() {
        return false;
    }

    public final DialogKtvSendGiftNumBinding h() {
        return this.a;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        this.a = DialogKtvSendGiftNumBinding.a(inflater.inflate(R.layout.dialog_ktv_send_gift_num, viewGroup, true));
        i();
        DialogKtvSendGiftNumBinding dialogKtvSendGiftNumBinding = this.a;
        return (View) (dialogKtvSendGiftNumBinding == null ? null : dialogKtvSendGiftNumBinding.getRoot());
    }
}

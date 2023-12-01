package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.BluedSharedPreferences;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.live.base.utils.LiveAlterDialog;
import com.blued.android.module.yy_china.BluedGuideDialog;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.YYConstants;
import com.blued.android.module.yy_china.databinding.ViewClickOneGiftSendBinding;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.IMJsonContents109Model;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYPayGoodsModel;
import com.blued.android.module.yy_china.model.YYPayRequestModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.utils.YYPayUtils;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/ClickOneGiftSendView.class */
public class ClickOneGiftSendView extends ConstraintLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final String f17908a;
    private ViewClickOneGiftSendBinding b;

    /* renamed from: c  reason: collision with root package name */
    private YYGiftModel f17909c;
    private YYRoomModel d;
    private KeyBoardFragment e;
    private long f;
    private long g;
    private int h;
    private YYGiftModel i;
    private IMJsonContents109Model j;
    private BluedGuideDialog k;

    public ClickOneGiftSendView(Context context) {
        this(context, null);
    }

    public ClickOneGiftSendView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClickOneGiftSendView(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17908a = "SP_ONE_SEND_GIFT";
        this.f = 0L;
        this.g = 0L;
        this.h = 0;
        this.d = YYRoomInfoManager.e().b();
        ViewClickOneGiftSendBinding a2 = ViewClickOneGiftSendBinding.a(LayoutInflater.from(context), this);
        this.b = a2;
        a2.d.setImageResource(R.color.color_5731D1);
        this.b.f16844a.setOnClickListener(this);
        this.b.b.setOnClickListener(this);
        this.b.f16845c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.ClickOneGiftSendView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                int[] iArr = new int[2];
                ClickOneGiftSendView.this.b.f16845c.getLocationOnScreen(iArr);
                ClickOneGiftSendView.this.k = new BluedGuideDialog(context);
                BluedGuideDialog.GuideBuilder guideBuilder = new BluedGuideDialog.GuideBuilder();
                guideBuilder.b(1);
                guideBuilder.a(2);
                guideBuilder.a(5.0f);
                guideBuilder.b(14.0f);
                guideBuilder.c(R.drawable.icon_yy_arrow_down_white);
                guideBuilder.f(DensityUtils.a(context, 345.0f));
                guideBuilder.g(DensityUtils.a(context, 71.0f));
                guideBuilder.d(R.color.syc_dark_b);
                guideBuilder.e(R.color.syc_dark_000000);
                if (ClickOneGiftSendView.this.j != null) {
                    guideBuilder.a(ClickOneGiftSendView.this.j.getGoods_desc());
                }
                ClickOneGiftSendView.this.k.a(guideBuilder);
                ClickOneGiftSendView.this.k.showAtLocation(ClickOneGiftSendView.this.b.f16845c, 0, DensityUtils.a(context, 32.0f), (iArr[1] - ClickOneGiftSendView.this.k.a()) - DensityUtils.a(context, 5.0f));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final YYGiftModel yYGiftModel, String str, boolean z) {
        YYRoomModel b;
        if (yYGiftModel == null) {
            return;
        }
        if (yYGiftModel.sendGiftStatus == 1) {
            if (System.currentTimeMillis() - yYGiftModel.sendGiftStatusLoadingTime <= 5000) {
                return;
            }
            yYGiftModel.sendGiftStatus = 0;
        }
        yYGiftModel.sendGiftStatus = 1;
        final YYPayRequestModel yYPayRequestModel = new YYPayRequestModel();
        long currentTimeMillis = System.currentTimeMillis();
        yYGiftModel.hit_id = currentTimeMillis;
        yYGiftModel.sendGiftStatusLoadingTime = currentTimeMillis;
        if (yYGiftModel == null || YYRoomInfoManager.e().b() == null || (b = YYRoomInfoManager.e().b()) == null) {
            return;
        }
        yYPayRequestModel.gift = yYGiftModel;
        yYPayRequestModel.beans = yYGiftModel.beans;
        yYPayRequestModel.giftCount = 1;
        yYPayRequestModel.goods_id = yYGiftModel.goods_id;
        yYPayRequestModel.goods_type = yYGiftModel.goods_type;
        long currentTimeMillis2 = System.currentTimeMillis();
        if (yYGiftModel.double_hit == 1) {
            YYGiftModel yYGiftModel2 = this.i;
            if (!StringUtils.a(yYGiftModel2 != null ? yYGiftModel2.goods_id : "", yYGiftModel.goods_id) || this.f <= 0 || currentTimeMillis2 - this.g >= 8000) {
                this.f = currentTimeMillis2;
                this.g = currentTimeMillis2;
                this.h = 1;
            } else {
                this.g = currentTimeMillis2;
                this.h++;
            }
            yYGiftModel.hit_count = this.h;
        } else {
            this.f = 0L;
            yYGiftModel.hit_count = 1;
        }
        yYPayRequestModel.hit_id = this.f;
        yYPayRequestModel.payCode = str;
        yYPayRequestModel.remember_me = z;
        yYPayRequestModel.room_id = b.room_id;
        yYPayRequestModel.target_uid = b.uid;
        yYPayRequestModel.pay_from = 1;
        yYGiftModel.hit_id = this.f;
        YYConstants.PayFromSource payFromSource = YYConstants.PayFromSource.Pay_Gift;
        KeyBoardFragment keyBoardFragment = this.e;
        YYPayUtils.a(yYPayRequestModel, payFromSource, keyBoardFragment, keyBoardFragment.getFragmentActive(), new YYPayUtils.PayGiftStatusListener() { // from class: com.blued.android.module.yy_china.view.ClickOneGiftSendView.5
            @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
            public void a(int i, String str2) {
                yYGiftModel.sendGiftStatus = 2;
            }

            @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
            public void a(YYPayGoodsModel yYPayGoodsModel) {
                yYGiftModel.sendGiftStatus = 3;
                ClickOneGiftSendView.this.i = yYGiftModel;
                YYSeatMemberModel yYSeatMemberModel = YYRoomInfoManager.e().o().get(yYPayRequestModel.target_uid);
                if (yYSeatMemberModel == null) {
                    return;
                }
                YYImMsgManager.a().a(yYGiftModel, yYSeatMemberModel, yYPayGoodsModel, false);
            }
        });
    }

    private void a(final YYRoomModel yYRoomModel) {
        YYRoomHttpUtils.l(yYRoomModel.room_id, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYGiftModel>>(this.e.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.ClickOneGiftSendView.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYGiftModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.isEmpty()) {
                    return;
                }
                ClickOneGiftSendView.this.f17909c = bluedEntityA.data.get(0);
                ImageLoader.a(ClickOneGiftSendView.this.e.getFragmentActive(), ClickOneGiftSendView.this.f17909c.images_static).a(ClickOneGiftSendView.this.b.d);
                ClickOneGiftSendView.this.setVisibility(0);
                if (yYRoomModel != null) {
                    EventTrackYY.o(ChatRoomProtos.Event.CHAT_ROOM_OUT_GOODS_SHOW, yYRoomModel.room_id, yYRoomModel.uid, ClickOneGiftSendView.this.f17909c.goods_id);
                }
            }
        }, (IRequestHost) this.e.getFragmentActive());
    }

    public void a() {
        LiveAlterDialog.a(this.e.getContext(), LayoutInflater.from(getContext()).inflate(R.layout.dialog_apply_send_one_gift_layout, (ViewGroup) null), new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.ClickOneGiftSendView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (ClickOneGiftSendView.this.d == null || ClickOneGiftSendView.this.j != null) {
                    return;
                }
                EventTrackYY.o(ChatRoomProtos.Event.CHAT_ROOM_OUT_GOODS_POP_CANCEL_CLICK, ClickOneGiftSendView.this.d.room_id, ClickOneGiftSendView.this.d.uid, ClickOneGiftSendView.this.f17909c.goods_id);
            }
        }, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.ClickOneGiftSendView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ClickOneGiftSendView clickOneGiftSendView = ClickOneGiftSendView.this;
                clickOneGiftSendView.a(clickOneGiftSendView.f17909c, "", false);
                BluedSharedPreferences.a().c().a("SP_ONE_SEND_GIFT", true).a();
                if (ClickOneGiftSendView.this.d == null || ClickOneGiftSendView.this.j != null) {
                    return;
                }
                EventTrackYY.o(ChatRoomProtos.Event.CHAT_ROOM_OUT_GOODS_POP_SEND_CLICK, ClickOneGiftSendView.this.d.room_id, ClickOneGiftSendView.this.d.uid, ClickOneGiftSendView.this.f17909c.goods_id);
            }
        }, true, false);
    }

    public void a(KeyBoardFragment keyBoardFragment, IMJsonContents109Model iMJsonContents109Model) {
        this.e = keyBoardFragment;
        if (this.d == null) {
            return;
        }
        this.j = iMJsonContents109Model;
        if (iMJsonContents109Model == null) {
            this.j = null;
            this.b.f.setVisibility(0);
            this.b.g.setVisibility(8);
            a(this.d);
            return;
        }
        setVisibility(0);
        this.b.f.setVisibility(8);
        this.b.g.setVisibility(0);
        YYGiftModel yYGiftModel = new YYGiftModel();
        this.f17909c = yYGiftModel;
        yYGiftModel.goods_id = iMJsonContents109Model.getAndroid_goods_id();
        this.f17909c.images_static = iMJsonContents109Model.getGoods_image();
        this.b.h.setText(iMJsonContents109Model.getCount());
        this.b.f16844a.setVisibility(YYRoomInfoManager.e().y() ? 8 : 0);
        if (StringUtils.a(iMJsonContents109Model.getCount(), 0) > StringUtils.a(iMJsonContents109Model.getTotal_count(), 0)) {
            this.b.i.setVisibility(8);
        } else {
            this.b.i.setVisibility(0);
            TextView textView = this.b.i;
            textView.setText(BridgeUtil.SPLIT_MARK + iMJsonContents109Model.getTotal_count());
        }
        ImageLoader.a(keyBoardFragment.getFragmentActive(), iMJsonContents109Model.getGoods_image()).a(this.b.e);
    }

    public void b() {
        this.g = 0L;
        this.f = 0L;
        this.h = 1;
        this.i = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if ((view.getId() == R.id.btn_pay || view.getId() == R.id.btn_sent) && this.f17909c != null) {
            if (this.d != null && view.getId() == R.id.btn_sent) {
                EventTrackYY.o(ChatRoomProtos.Event.CHAT_ROOM_OUT_GOODS_CLICK, this.d.room_id, this.d.uid, this.f17909c.goods_id);
            }
            if (BluedSharedPreferences.a().a("SP_ONE_SEND_GIFT", false)) {
                a(this.f17909c, "", false);
            } else {
                a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BluedGuideDialog bluedGuideDialog = this.k;
        if (bluedGuideDialog != null) {
            bluedGuideDialog.dismiss();
        }
    }
}

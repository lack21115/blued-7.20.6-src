package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ViewYyCreateSoloGiftBinding;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYWishGoodsModel;
import com.blued.android.module.yy_china.utils.PopupwindowFactory;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYWishListView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYSetSoloGiftView.class */
public class YYSetSoloGiftView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private BaseYYStudioFragment f18486a;
    private PopupWindow b;

    /* renamed from: c  reason: collision with root package name */
    private HashSet<String> f18487c;
    private YYRoomModel d;
    private ViewYyCreateSoloGiftBinding e;

    public YYSetSoloGiftView(Context context) {
        super(context);
        a();
    }

    public YYSetSoloGiftView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public YYSetSoloGiftView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.e = ViewYyCreateSoloGiftBinding.a(LayoutInflater.from(getContext()), this, true);
        if (YYRoomInfoManager.e().y()) {
            this.e.g.setEnabled(false);
            this.e.f16902a.setVisibility(8);
            this.e.b.setVisibility(0);
            this.e.e.setVisibility(8);
            this.e.f16903c.setVisibility(8);
            this.e.i.setText(getResources().getString(R.string.yy_not_gift));
            this.e.g.setText(getResources().getString(R.string.yy_set_up_gift));
            ShapeHelper.a(this.e.f, R.color.syc_272727, R.color.syc_272727);
            ShapeHelper.a(this.e.g, R.color.syc_272727, R.color.syc_272727);
        } else {
            this.e.b.setVisibility(8);
            this.e.e.setVisibility(0);
            this.e.f16903c.setVisibility(8);
            this.e.f16902a.setVisibility(0);
            this.e.i.setText(getResources().getString(R.string.yy_send_gift_and_enter));
            this.e.g.setText(getResources().getString(R.string.yy_send_gifts));
            ShapeHelper.a(this.e.f, R.color.syc_tran20_00E0AB, R.color.syc_tran20_3883FD);
        }
        this.e.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYSetSoloGiftView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYSetSoloGiftView.this.d();
            }
        });
        this.e.f16903c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYSetSoloGiftView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYSetSoloGiftView.this.f18487c.clear();
                YYSetSoloGiftView.this.b();
            }
        });
        this.e.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYSetSoloGiftView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (YYSetSoloGiftView.this.f18486a != null) {
                    YYSetSoloGiftView.this.f18486a.y();
                }
                if (YYRoomInfoManager.e().y()) {
                    YYSetSoloGiftView.this.c();
                    return;
                }
                EventTrackYY.d(ChatRoomProtos.Event.SINGLE_ROOM_GIFT_SEND_CLICK, YYSetSoloGiftView.this.d.room_id, YYSetSoloGiftView.this.d.uid);
                YYSetSoloGiftView.this.f18486a.a(true, "", YYSetSoloGiftView.this.getGoodsId(), YYSetSoloGiftView.this.d == null ? "" : YYSetSoloGiftView.this.d.uid);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        HashSet<String> hashSet = this.f18487c;
        boolean z = (hashSet == null || hashSet.isEmpty()) ? false : true;
        this.e.g.setEnabled(z);
        this.e.b.setVisibility(z ? 8 : 0);
        this.e.e.setVisibility(z ? 0 : 8);
        this.e.f16902a.setVisibility(z ? 0 : 8);
        this.e.f16903c.setVisibility(z ? 0 : 8);
        ShapeHelper.a(this.e.f, R.color.syc_tran20_00E0AB, R.color.syc_tran20_3883FD);
        ShapeHelper.a(this.e.g, z ? R.color.syc_00E0AB : R.color.syc_272727, z ? R.color.syc_3883FD : R.color.syc_272727);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        YYRoomModel yYRoomModel = this.d;
        if (yYRoomModel == null) {
            return;
        }
        YYRoomHttpUtils.a(yYRoomModel.room_id, 2, "", getGoodsId(), new BluedUIHttpResponse<BluedEntityA<Object>>(this.f18486a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYSetSoloGiftView.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                if (YYSetSoloGiftView.this.d != null) {
                    YYSetSoloGiftView.this.d.setSoloGift = true;
                }
                LiveEventBus.get("event_solo_set_gift").post("");
            }
        }, this.f18486a.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        YYWishListView yYWishListView = new YYWishListView(getContext());
        yYWishListView.a(this.f18486a, this.f18487c);
        yYWishListView.setOkListener(new YYWishListView.OnConfirmListener() { // from class: com.blued.android.module.yy_china.view.YYSetSoloGiftView.6
            @Override // com.blued.android.module.yy_china.view.YYWishListView.OnConfirmListener
            public void a(YYGiftModel yYGiftModel, int i) {
                if (yYGiftModel == null) {
                    return;
                }
                YYSetSoloGiftView.this.f18487c.add(yYGiftModel.goods_id);
                ImageLoader.a((IRequestHost) null, yYGiftModel.images_static).a(YYSetSoloGiftView.this.e.d);
                YYSetSoloGiftView.this.e.h.setText(yYGiftModel.name);
                YYSetSoloGiftView.this.b();
                YYSetSoloGiftView.this.b.dismiss();
            }
        });
        this.b = new PopupwindowFactory.Builder(getContext()).a(yYWishListView).a(80).c(-2).b(-1).d(R.color.transparent).h();
    }

    private void getGiftInfo() {
        YYRoomModel yYRoomModel = this.d;
        if (yYRoomModel == null) {
            return;
        }
        YYRoomHttpUtils.S(yYRoomModel.room_id, new BluedUIHttpResponse<BluedEntityA<YYWishGoodsModel>>(this.f18486a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYSetSoloGiftView.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYWishGoodsModel> bluedEntityA) {
                YYWishGoodsModel singleData;
                if (bluedEntityA == null || !bluedEntityA.hasData() || (singleData = bluedEntityA.getSingleData()) == null) {
                    return;
                }
                if (YYSetSoloGiftView.this.f18487c == null) {
                    YYSetSoloGiftView.this.f18487c = new HashSet();
                }
                YYSetSoloGiftView.this.f18487c.add(singleData.goods_id);
                ImageLoader.a((IRequestHost) null, singleData.images_static).a(YYSetSoloGiftView.this.e.d);
                YYSetSoloGiftView.this.e.h.setText(singleData.name);
            }
        }, this.f18486a.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getGoodsId() {
        HashSet<String> hashSet = this.f18487c;
        String str = "";
        if (hashSet != null) {
            if (hashSet.isEmpty()) {
                return "";
            }
            Iterator<String> it = this.f18487c.iterator();
            str = "";
            if (it.hasNext()) {
                str = it.next();
            }
        }
        return str;
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment) {
        this.f18486a = baseYYStudioFragment;
        this.f18487c = new HashSet<>();
        this.d = YYRoomInfoManager.e().b();
        if (YYRoomInfoManager.e().y()) {
            return;
        }
        this.e.b.setVisibility(8);
        this.e.e.setVisibility(0);
        this.e.f16903c.setVisibility(8);
        this.e.g.setEnabled(true);
        getGiftInfo();
    }
}

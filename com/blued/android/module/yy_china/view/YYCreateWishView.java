package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYWishAdapter;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.fragment.YYTypingDialogFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYWishGoodsModel;
import com.blued.android.module.yy_china.model.YYWishRequestModel;
import com.blued.android.module.yy_china.utils.PopupwindowFactory;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYWishListView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYCreateWishView.class */
public class YYCreateWishView extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f18123a;
    private ShapeTextView b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f18124c;
    private YYWishAdapter d;
    private BaseYYStudioFragment e;
    private PopupWindow f;
    private Set<String> g;

    public YYCreateWishView(Context context) {
        super(context);
        a();
    }

    public YYCreateWishView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public YYCreateWishView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_create_wish, (ViewGroup) this, true);
        this.f18123a = (RecyclerView) findViewById(R.id.rv_wish_list);
        this.b = (ShapeTextView) findViewById(R.id.tv_create_wish);
        this.f18124c = (TextView) findViewById(R.id.tv_wish_descript);
        this.b.setText(getResources().getString(R.string.yy_create_wish));
        b();
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYCreateWishView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (YYCreateWishView.this.e != null) {
                    YYCreateWishView.this.e.y();
                }
                YYCreateWishView.this.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i) {
        YYWishListView yYWishListView = new YYWishListView(getContext());
        yYWishListView.a(this.e, this.g);
        yYWishListView.setOkListener(new YYWishListView.OnConfirmListener() { // from class: com.blued.android.module.yy_china.view.YYCreateWishView.4
            @Override // com.blued.android.module.yy_china.view.YYWishListView.OnConfirmListener
            public void a(YYGiftModel yYGiftModel, int i2) {
                YYWishGoodsModel yYWishGoodsModel;
                if (yYGiftModel == null || (yYWishGoodsModel = YYCreateWishView.this.d.getData().get(i)) == null) {
                    return;
                }
                YYCreateWishView.this.g.add(yYGiftModel.goods_id);
                yYWishGoodsModel.goods_id = yYGiftModel.goods_id;
                yYWishGoodsModel.wish_total = i2 + "";
                yYWishGoodsModel.wish_current = "0";
                yYWishGoodsModel.name = yYGiftModel.name;
                yYWishGoodsModel.images_static = yYGiftModel.images_static;
                yYWishGoodsModel.enableDelete = true;
                YYCreateWishView.this.d.notifyItemChanged(i);
                YYCreateWishView.this.c();
                YYCreateWishView.this.f.dismiss();
            }
        });
        this.f = new PopupwindowFactory.Builder(getContext()).a(yYWishListView).a(80).c(-2).b(-1).d(R.color.transparent).h();
    }

    private void b() {
        this.d = new YYWishAdapter();
        this.f18123a.setLayoutManager(new GridLayoutManager(getContext(), 3));
        this.f18123a.setAdapter(this.d);
        this.d.a(new YYWishAdapter.OnAddOrDeleteGiftListener() { // from class: com.blued.android.module.yy_china.view.YYCreateWishView.2
            @Override // com.blued.android.module.yy_china.adapter.YYWishAdapter.OnAddOrDeleteGiftListener
            public void a(int i) {
                YYCreateWishView.this.a(i);
            }

            @Override // com.blued.android.module.yy_china.adapter.YYWishAdapter.OnAddOrDeleteGiftListener
            public void b(int i) {
                YYWishGoodsModel yYWishGoodsModel = YYCreateWishView.this.d.getData().get(i);
                if (YYCreateWishView.this.g.contains(yYWishGoodsModel.goods_id)) {
                    YYCreateWishView.this.g.remove(yYWishGoodsModel.goods_id);
                }
                yYWishGoodsModel.cleanGoods();
                YYCreateWishView.this.d.notifyItemChanged(i);
                YYCreateWishView.this.c();
            }

            @Override // com.blued.android.module.yy_china.adapter.YYWishAdapter.OnAddOrDeleteGiftListener
            public void c(final int i) {
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b != null) {
                    EventTrackYY.e(ChatRoomProtos.Event.CHAT_ROOM_OWNER_CUSTOM_CLICK, b.room_id);
                }
                new YYTypingDialogFragment("", new YYTypingDialogFragment.IEditorCallback() { // from class: com.blued.android.module.yy_china.view.YYCreateWishView.2.1
                    @Override // com.blued.android.module.yy_china.fragment.YYTypingDialogFragment.IEditorCallback
                    public void a(String str, String str2) {
                        YYCreateWishView.this.d.getData().get(i).wish_total = str2;
                        YYCreateWishView.this.d.notifyItemChanged(i);
                    }
                }).show(YYCreateWishView.this.e.getParentFragmentManager(), "wish_count");
            }
        });
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        boolean z;
        YYWishAdapter yYWishAdapter = this.d;
        if (yYWishAdapter == null) {
            return;
        }
        Iterator<YYWishGoodsModel> it = yYWishAdapter.getData().iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            } else if (!TextUtils.isEmpty(it.next().goods_id)) {
                z = true;
                break;
            }
        }
        this.f18124c.setText(z ? "最少可添加1个礼物，最多可添加3个礼物" : "礼物未添加，添加后用户打赏礼物即可达成心愿");
        this.b.setEnabled(z);
        this.b.setAlpha(z ? 1.0f : 0.45f);
        ShapeHelper.b(this.b, z ? R.color.syc_tran70_151515 : R.color.syc_272727);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        EventTrackYY.e(ChatRoomProtos.Event.CHAT_ROOM_OWNER_GIFT_CREATE_CLICK, b.room_id);
        YYWishAdapter yYWishAdapter = this.d;
        if (yYWishAdapter == null || yYWishAdapter.getData() == null || this.d.getData().isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (YYWishGoodsModel yYWishGoodsModel : this.d.getData()) {
            if (yYWishGoodsModel != null && !TextUtils.isEmpty(yYWishGoodsModel.goods_id)) {
                YYWishRequestModel yYWishRequestModel = new YYWishRequestModel();
                yYWishRequestModel.goods_count = yYWishGoodsModel.wish_total;
                yYWishRequestModel.goods_id = yYWishGoodsModel.goods_id;
                arrayList.add(yYWishRequestModel);
            }
        }
        YYRoomHttpUtils.a(b.room_id, arrayList, new BluedUIHttpResponse<BluedEntityA<Object>>(this.e.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYCreateWishView.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                YYRoomInfoManager.e().b = true;
            }
        }, this.e.getFragmentActive());
    }

    private void e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new YYWishGoodsModel());
        arrayList.add(new YYWishGoodsModel());
        arrayList.add(new YYWishGoodsModel());
        this.d.setNewData(arrayList);
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment) {
        this.e = baseYYStudioFragment;
        this.g = new HashSet();
    }
}

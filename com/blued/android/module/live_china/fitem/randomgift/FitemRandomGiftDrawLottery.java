package com.blued.android.module.live_china.fitem.randomgift;

import android.content.Context;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.LiveRandomGiftLotteryDialog;
import com.blued.android.module.live_china.fragment.LiveRandomGiftLotteryRecordDialog;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.RandomGiftDialogRewardModel;
import com.blued.android.module.live_china.model.RandomGiftItemModel;
import com.blued.android.module.live_china.utils.LiveUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/randomgift/FitemRandomGiftDrawLottery.class */
public final class FitemRandomGiftDrawLottery extends FreedomItem {
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private RandomGiftDialogRewardModel f12684c;
    private final ArrayList<FitemRandomGiftDrawLotteryItem> d;
    private FreedomAdapter e;

    public FitemRandomGiftDrawLottery(String goods_id, RandomGiftDialogRewardModel model) {
        Intrinsics.e(goods_id, "goods_id");
        Intrinsics.e(model, "model");
        this.b = goods_id;
        this.f12684c = model;
        this.d = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BaseViewHolder vh, FitemRandomGiftDrawLottery this$0, View view) {
        Intrinsics.e(vh, "$vh");
        Intrinsics.e(this$0, "this$0");
        if (vh.f10931a.a("FragmentManager", (String) null) == null) {
            return;
        }
        Object a2 = vh.f10931a.a("FragmentManager", (String) null);
        if (a2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentManager");
        }
        LiveRandomGiftLotteryRecordDialog.f13183a.a((FragmentManager) a2, this$0.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemRandomGiftDrawLottery this$0, BaseViewHolder vh, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(vh, "$vh");
        EventTrackLive.a(LiveProtos.Event.LIVE_USER_RANDOM_GIFT_PAGE_LOTTERY_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        if (this$0.f12684c.getRemain_count() <= 0) {
            ToastUtils.b(R.string.live_random_gift_draw_lottery_toast);
            return;
        }
        LiveRandomGiftLotteryDialog.Companion companion = LiveRandomGiftLotteryDialog.f13180a;
        Object a2 = vh.f10931a.a("BaseFragment", (String) null);
        Intrinsics.c(a2, "vh.adapter.getVar<BaseFr…t?>(\"BaseFragment\", null)");
        companion.a((Fragment) a2, this$0.b);
    }

    private final void f() {
        if (this.f12684c.getRemain_count() <= 0) {
            this.f10935a.c(R.id.tv_subtitle);
        } else {
            this.f10935a.a(R.id.tv_subtitle, (CharSequence) AppInfo.d().getString(R.string.live_random_gift_draw_lottery_subtitle, LiveRoomManager.a().h(), String.valueOf(this.f12684c.getRemain_count()))).a(R.id.tv_subtitle, LiveUtils.a(this.f10935a.b(R.id.tv_subtitle), "#FF6A00", false)).d(R.id.tv_subtitle);
        }
        ShapeTextView shapeTextView = (ShapeTextView) this.f10935a.a(R.id.tv_draw_lottery);
        ShapeModel shapeModel = shapeTextView.getShapeModel();
        if (this.f12684c.getRemain_count() > 0) {
            shapeModel.b = ContextCompat.getColor(this.f10935a.f10931a.b, R.color.syc_dark_891401);
            shapeModel.t = ContextCompat.getColor(this.f10935a.f10931a.b, R.color.syc_dark_FDE63B);
            shapeModel.v = ContextCompat.getColor(this.f10935a.f10931a.b, R.color.syc_dark_FBA917);
        } else {
            shapeModel.b = ContextCompat.getColor(this.f10935a.f10931a.b, R.color.syc_dark_777777);
            shapeModel.t = ContextCompat.getColor(this.f10935a.f10931a.b, R.color.syc_dark_C3C3C3);
            shapeModel.v = ContextCompat.getColor(this.f10935a.f10931a.b, R.color.syc_dark_C3C3C3);
        }
        shapeTextView.setShapeModel(shapeModel);
    }

    private final void g() {
        RecyclerView recyclerView = (RecyclerView) this.f10935a.a(R.id.rv_list);
        recyclerView.setLayoutManager(new GridLayoutManager(this.f10935a.f10931a.b, 4));
        this.e = new FreedomAdapter(this.f10935a.f10931a.b, this.f10935a.b, this.d);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(this.e);
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_random_gift_draw_lottery;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, final BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(vh, "vh");
        EventTrackLive.a(LiveProtos.Event.LIVE_USER_RANDOM_GIFT_PAGE_LOTTERY_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        vh.a(R.id.tv_title, true).a(R.id.tv_draw_lottery, true).a(R.id.tv_belted, (CharSequence) AppInfo.d().getString(R.string.live_random_gift_draw_lottery_belted)).a(R.id.tv_belted, LiveUtils.a(vh.b(R.id.tv_belted), "#FF6A00", false)).a(R.id.tv_record, new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.randomgift.-$$Lambda$FitemRandomGiftDrawLottery$tU1IwpsU44NefK2zqISIwBAv9aU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemRandomGiftDrawLottery.a(BaseViewHolder.this, this, view);
            }
        });
        f();
        this.f10935a.a(R.id.tv_draw_lottery, new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.randomgift.-$$Lambda$FitemRandomGiftDrawLottery$x1Js4Wnt7G_e0sml8xPBEhCBgY8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemRandomGiftDrawLottery.a(FitemRandomGiftDrawLottery.this, vh, view);
            }
        });
        this.d.clear();
        ArrayList<RandomGiftItemModel> list2 = this.f12684c.getList();
        if (list2 != null) {
            for (RandomGiftItemModel randomGiftItemModel : list2) {
                if (randomGiftItemModel != null) {
                    this.d.add(new FitemRandomGiftDrawLotteryItem(randomGiftItemModel));
                }
            }
            RandomGiftItemModel randomGiftItemModel2 = list2.get(0);
            String current_random_weight = randomGiftItemModel2 == null ? null : randomGiftItemModel2.getCurrent_random_weight();
            if (current_random_weight != null ? current_random_weight.length() == 0 : true) {
                vh.c(R.id.tv_list_title_current_probability);
            } else {
                vh.d(R.id.tv_list_title_current_probability);
            }
        }
        g();
    }

    public final void b(int i) {
        this.f12684c.setRemain_count(i);
        f();
    }

    public final String e() {
        return this.b;
    }
}

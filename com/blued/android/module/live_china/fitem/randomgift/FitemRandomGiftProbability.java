package com.blued.android.module.live_china.fitem.randomgift;

import android.content.Context;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.RandomGiftDialogAnimationModel;
import com.blued.android.module.live_china.model.RandomGiftItemModel;
import com.blued.android.module.live_china.utils.LiveUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/randomgift/FitemRandomGiftProbability.class */
public final class FitemRandomGiftProbability extends FreedomItem {
    private RandomGiftDialogAnimationModel b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<FitemRandomGiftProbabilityItem> f12690c;
    private FreedomAdapter d;

    public FitemRandomGiftProbability(RandomGiftDialogAnimationModel model) {
        Intrinsics.e(model, "model");
        this.b = model;
        this.f12690c = new ArrayList<>();
    }

    private final void e() {
        RecyclerView recyclerView = (RecyclerView) this.f10935a.a(R.id.rv_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f10935a.f10931a.b));
        this.d = new FreedomAdapter(this.f10935a.f10931a.b, this.f10935a.b, this.f12690c);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(this.d);
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_random_gift_probability;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(vh, "vh");
        vh.a(R.id.tv_title, true).a(R.id.tv_list_title_name, true).a(R.id.tv_list_title_current_probability, true).a(R.id.tv_list_title_probability, true);
        String random_weight_incr = this.b.getRandom_weight_incr();
        if (random_weight_incr == null || random_weight_incr.length() == 0) {
            vh.c(R.id.ll_info_root);
        } else {
            vh.d(R.id.ll_info_root).a(R.id.tv_info_title, true).a(R.id.tv_info_subtitle, (CharSequence) AppInfo.d().getString(R.string.live_random_gift_probability_info_subtitle, this.b.getRandom_weight_incr())).a(R.id.tv_info_subtitle, LiveUtils.a(vh.b(R.id.tv_info_subtitle), "#FF9219", false)).a(R.id.tv_info_content, (CharSequence) this.b.getRandom_weight_incr_desc());
            EventTrackLive.a(LiveProtos.Event.LIVE_USER_RANDOM_GIFT_PAGE_UP_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        }
        this.f12690c.clear();
        ArrayList<RandomGiftItemModel> list2 = this.b.getList();
        if (list2 != null) {
            for (RandomGiftItemModel randomGiftItemModel : list2) {
                this.f12690c.add(new FitemRandomGiftProbabilityItem(randomGiftItemModel));
            }
            String current_random_weight = list2.get(0).getCurrent_random_weight();
            if (current_random_weight != null ? current_random_weight.length() == 0 : true) {
                vh.c(R.id.tv_list_title_current_probability);
            } else {
                vh.d(R.id.tv_list_title_current_probability);
            }
        }
        e();
    }
}

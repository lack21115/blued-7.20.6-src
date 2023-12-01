package com.blued.android.module.live_china.fitem;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.manager.LiveDataListManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.RankHourDataModel;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemRankHour.class */
public class FitemRankHour extends FreedomItem {
    public RankHourDataModel b;

    public FitemRankHour(RankHourDataModel rankHourDataModel) {
        this.b = rankHourDataModel;
    }

    private View.OnClickListener a(final BaseFragment baseFragment) {
        if (baseFragment == null) {
            return null;
        }
        return new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.-$$Lambda$FitemRankHour$eGFMh4LrVYUKWd6iDRxL1RlN-A0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemRankHour.this.a(baseFragment, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(BaseFragment baseFragment, View view) {
        if (this.b.getLive() == LiveRoomManager.a().d()) {
            return;
        }
        if (baseFragment instanceof RecordingOnliveFragment) {
            AppMethods.a((CharSequence) "当前正在开播无法切换直播间");
        } else if (!(baseFragment instanceof PlayingOnliveFragment) || LiveRoomManager.a().p() == null) {
        } else {
            LiveDataListManager.a().b(new LiveRoomData(this.b.getLive(), 0, "live_room_ranking", String.valueOf(this.b.getUid()), this.b.getName(), this.b.getAvatar(), 0));
        }
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_rank_hour;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder baseViewHolder, List<FreedomItem> list, int i) {
        baseViewHolder.a(R.id.iv_avatar, this.b.getAvatar(), R.drawable.user_bg_round, true).a(R.id.tv_name, (CharSequence) this.b.getName()).a(R.id.tv_rank, (CharSequence) String.valueOf(this.b.getBonus())).a(R.id.tv_rank_index, (CharSequence) String.valueOf(i + 3));
        if (TextUtils.isEmpty(this.b.getAvatar_frame())) {
            baseViewHolder.b(R.id.iv_avatar_frame, false);
        } else {
            baseViewHolder.a(R.id.iv_avatar_frame, this.b.getAvatar_frame(), this.b.getAvatar_frame_type() != 0, -1).b(R.id.iv_avatar_frame, true);
        }
        if (this.b.getLive() == 0) {
            baseViewHolder.c(R.id.rl_avatar, false).c(R.id.tv_name, false).c(R.id.iv_bounce, false).b(R.id.iv_bounce, false);
            return;
        }
        ImageLoader.c(baseViewHolder.b, "live_rank_hour_bounce.png").e(baseViewHolder.a(R.id.iv_bounce).hashCode()).g(-1).a((ImageView) baseViewHolder.a(R.id.iv_bounce));
        View.OnClickListener a2 = a((BaseFragment) baseViewHolder.f10931a.a("BaseFragment", (String) null));
        if (a2 != null) {
            baseViewHolder.a(R.id.rl_avatar, a2).a(R.id.tv_name, a2).a(R.id.iv_bounce, a2).b(R.id.iv_bounce, true);
        }
    }
}

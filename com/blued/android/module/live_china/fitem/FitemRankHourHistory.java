package com.blued.android.module.live_china.fitem;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
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
import com.blued.android.module.live_china.model.RankHourHistoryDataModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemRankHourHistory.class */
public final class FitemRankHourHistory extends FreedomItem {
    private RankHourHistoryDataModel b;

    public FitemRankHourHistory(RankHourHistoryDataModel model) {
        Intrinsics.e(model, "model");
        this.b = model;
    }

    private final View.OnClickListener a(final BaseFragment baseFragment, final RankHourDataModel rankHourDataModel) {
        if (baseFragment == null || rankHourDataModel == null) {
            return null;
        }
        return new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.-$$Lambda$FitemRankHourHistory$glBPTRy0R4RPUYuWhYMz775saY8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemRankHourHistory.a(RankHourDataModel.this, baseFragment, view);
            }
        };
    }

    private final void a(Context context, BaseViewHolder baseViewHolder) {
        int i;
        RankHourDataModel top = this.b.getTop();
        int hour = top == null ? -1 : (int) (top.getHour() / 10.0f);
        int i2 = hour;
        if (hour == -1) {
            RankHourDataModel potential = this.b.getPotential();
            i2 = potential == null ? hour : (int) (potential.getHour() / 10.0f);
        }
        baseViewHolder.c(R.id.iv_time_hour, i2 != 0 ? i2 != 1 ? i2 != 2 ? R.drawable.live_rank_hour_number_black_0 : R.drawable.live_rank_hour_number_black_2 : R.drawable.live_rank_hour_number_black_1 : R.drawable.live_rank_hour_number_black_0);
        RankHourDataModel top2 = this.b.getTop();
        int hour2 = top2 == null ? -1 : (int) (top2.getHour() % 10.0f);
        int i3 = hour2;
        if (hour2 == -1) {
            RankHourDataModel potential2 = this.b.getPotential();
            i3 = potential2 == null ? hour2 : (int) (potential2.getHour() % 10.0f);
        }
        int i4 = R.id.iv_time_minute;
        switch (i3) {
            case 0:
                i = R.drawable.live_rank_hour_number_black_0;
                break;
            case 1:
                i = R.drawable.live_rank_hour_number_black_1;
                break;
            case 2:
                i = R.drawable.live_rank_hour_number_black_2;
                break;
            case 3:
                i = R.drawable.live_rank_hour_number_black_3;
                break;
            case 4:
                i = R.drawable.live_rank_hour_number_black_4;
                break;
            case 5:
                i = R.drawable.live_rank_hour_number_black_5;
                break;
            case 6:
                i = R.drawable.live_rank_hour_number_black_6;
                break;
            case 7:
                i = R.drawable.live_rank_hour_number_black_7;
                break;
            case 8:
                i = R.drawable.live_rank_hour_number_black_8;
                break;
            case 9:
                i = R.drawable.live_rank_hour_number_black_9;
                break;
            default:
                i = R.drawable.live_rank_hour_number_black_0;
                break;
        }
        baseViewHolder.c(i4, i);
    }

    private final void a(Context context, RankHourDataModel rankHourDataModel, BaseViewHolder baseViewHolder, View view, ImageView imageView, ImageView imageView2, TextView textView, ImageView imageView3) {
        if (rankHourDataModel == null) {
            baseViewHolder.a(imageView, R.drawable.live_rank_hour_default_avatar).a(imageView2).a(textView, R.string.live_rank_vacancy).a(textView, true).a(imageView3);
            return;
        }
        String avatar = rankHourDataModel.getAvatar();
        if (avatar == null || avatar.length() == 0) {
            baseViewHolder.a(imageView, R.drawable.live_rank_hour_default_avatar);
        } else {
            baseViewHolder.a(imageView, rankHourDataModel.getAvatar(), R.drawable.live_rank_hour_default_avatar, true);
        }
        if (TextUtils.isEmpty(rankHourDataModel.getName())) {
            baseViewHolder.a(textView, R.string.live_rank_vacancy);
        } else {
            baseViewHolder.a(textView, rankHourDataModel.getName());
        }
        baseViewHolder.a(textView, true);
        if (TextUtils.isEmpty(rankHourDataModel.getAvatar_frame())) {
            baseViewHolder.a((View) imageView2, false);
        } else {
            baseViewHolder.a(imageView2, rankHourDataModel.getAvatar_frame(), rankHourDataModel.getAvatar_frame_type() != 0, -1).a((View) imageView2, true);
        }
        if (rankHourDataModel.getLive() == 0) {
            baseViewHolder.b(view, false).a((View) imageView3, false);
            return;
        }
        ImageLoader.c(baseViewHolder.b, imageView3.getId() == R.id.iv_left_bounce ? "live_rank_hour_bounce_white.png" : "live_rank_hour_bounce.png").g().g(-1).a(imageView3);
        View.OnClickListener a2 = a((BaseFragment) baseViewHolder.f10931a.a("BaseFragment", (String) null), rankHourDataModel);
        if (a2 == null) {
            return;
        }
        baseViewHolder.a(view, a2).a((View) imageView3, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(RankHourDataModel rankHourDataModel, BaseFragment baseFragment, View view) {
        if (rankHourDataModel.getLive() == LiveRoomManager.a().d()) {
            return;
        }
        if (baseFragment instanceof RecordingOnliveFragment) {
            AppMethods.a((CharSequence) "当前正在开播无法切换直播间");
        } else if (!(baseFragment instanceof PlayingOnliveFragment) || LiveRoomManager.a().p() == null) {
        } else {
            LiveDataListManager.a().b(new LiveRoomData(rankHourDataModel.getLive(), 0, "live_room_ranking", String.valueOf(rankHourDataModel.getUid()), rankHourDataModel.getName(), rankHourDataModel.getAvatar(), 0));
        }
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_rank_hour_history;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        a(context, vh);
        RankHourDataModel top = this.b.getTop();
        View a2 = vh.a(R.id.rl_left_root);
        Intrinsics.c(a2, "vh.getView(R.id.rl_left_root)");
        View a3 = vh.a(R.id.iv_left_avatar);
        Intrinsics.c(a3, "vh.getView(R.id.iv_left_avatar)");
        ImageView imageView = (ImageView) a3;
        View a4 = vh.a(R.id.iv_left_avatar_frame);
        Intrinsics.c(a4, "vh.getView(R.id.iv_left_avatar_frame)");
        ImageView imageView2 = (ImageView) a4;
        View a5 = vh.a(R.id.tv_left_name);
        Intrinsics.c(a5, "vh.getView(R.id.tv_left_name)");
        TextView textView = (TextView) a5;
        View a6 = vh.a(R.id.iv_left_bounce);
        Intrinsics.c(a6, "vh.getView(R.id.iv_left_bounce)");
        a(context, top, vh, a2, imageView, imageView2, textView, (ImageView) a6);
        RankHourDataModel potential = this.b.getPotential();
        View a7 = vh.a(R.id.rl_right_root);
        Intrinsics.c(a7, "vh.getView(R.id.rl_right_root)");
        View a8 = vh.a(R.id.iv_right_avatar);
        Intrinsics.c(a8, "vh.getView(R.id.iv_right_avatar)");
        ImageView imageView3 = (ImageView) a8;
        View a9 = vh.a(R.id.iv_right_avatar_frame);
        Intrinsics.c(a9, "vh.getView(R.id.iv_right_avatar_frame)");
        ImageView imageView4 = (ImageView) a9;
        View a10 = vh.a(R.id.tv_right_name);
        Intrinsics.c(a10, "vh.getView(R.id.tv_right_name)");
        TextView textView2 = (TextView) a10;
        View a11 = vh.a(R.id.iv_right_bounce);
        Intrinsics.c(a11, "vh.getView(R.id.iv_right_bounce)");
        a(context, potential, vh, a7, imageView3, imageView4, textView2, (ImageView) a11);
    }
}

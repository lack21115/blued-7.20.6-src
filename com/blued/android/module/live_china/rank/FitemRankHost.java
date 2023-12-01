package com.blued.android.module.live_china.rank;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.RankAllDataModel;
import com.blued.android.module.live_china.model.RankTopDataModel;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/rank/FitemRankHost.class */
public class FitemRankHost extends FreedomItem {
    private static String e = "https://web.bldimg.com/image-manager/1689832311_97803.webp";
    private static String f = "https://web.bldimg.com/image-manager/1690374197_40405.png";
    public RankAllDataModel b;

    /* renamed from: c  reason: collision with root package name */
    public String f14054c;
    private Boolean d;

    public FitemRankHost(RankAllDataModel rankAllDataModel, String str, int i) {
        this.d = false;
        if (rankAllDataModel != null && rankAllDataModel.getTop() != null && rankAllDataModel.getTop().size() > 0) {
            Collections.reverse(rankAllDataModel.getTop());
        }
        this.b = rankAllDataModel;
        this.f14054c = str;
        boolean z = false;
        if ("union".equals(str)) {
            z = false;
            if (i == 0) {
                z = true;
            }
        }
        this.d = Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, boolean z, Long l, String str, String str2, String str3, boolean z2) {
        if (z || z2) {
            return;
        }
        if (LiveRoomManager.a().K()) {
            AppMethods.a((CharSequence) "当前正在开播无法切换直播间");
        } else if (l.longValue() == 0) {
            LiveRoomInfo.a().a(context, str, str2, str3, 0, 1);
        } else {
            LiveRoomData liveRoomData = new LiveRoomData(l.longValue(), 0, "live_room_ranking", str, str2, str3, 0);
            LiveFloatManager.a().b(false);
            LiveRoomInfo.a().a(context, liveRoomData, 0, (List<LiveRoomData>) null, (Bundle) null);
        }
    }

    private void a(BaseViewHolder baseViewHolder, int i) {
        baseViewHolder.a(R.id.iv_list_bg).setVisibility(0);
        if (i == 2) {
            if ("anchor".equals(this.f14054c)) {
                baseViewHolder.a(R.id.iv_list_bg, "https://web.bldimg.com/image-manager/1689746509_61515.webp");
            } else if ("fans".equals(this.f14054c)) {
                baseViewHolder.a(R.id.iv_list_bg, "https://web.bldimg.com/image-manager/1689748217_31565.webp");
            } else {
                baseViewHolder.a(R.id.iv_list_bg, "https://web.bldimg.com/image-manager/1689748478_31652.webp");
            }
        } else if (i != 3) {
            baseViewHolder.a(R.id.iv_list_bg).setVisibility(4);
        } else if ("anchor".equals(this.f14054c)) {
            baseViewHolder.a(R.id.iv_list_bg, "https://web.bldimg.com/image-manager/1689746509_29829.webp");
        } else if ("fans".equals(this.f14054c)) {
            baseViewHolder.a(R.id.iv_list_bg, "https://web.bldimg.com/image-manager/1689748217_58064.webp");
        } else {
            baseViewHolder.a(R.id.iv_list_bg, "https://web.bldimg.com/image-manager/1689748478_62227.webp");
        }
    }

    private void a(BaseViewHolder baseViewHolder, final ArrayList<RankTopDataModel> arrayList, final Context context, final boolean z) {
        c(baseViewHolder, arrayList, z);
        b(baseViewHolder, arrayList, z);
        a(baseViewHolder, arrayList, z);
        baseViewHolder.a(R.id.rl_avatar_one).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.rank.FitemRankHost.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ArrayList arrayList2 = arrayList;
                if (arrayList2 == null || arrayList2.size() <= 0) {
                    return;
                }
                RankTopDataModel rankTopDataModel = (RankTopDataModel) arrayList.get(0);
                FitemRankHost.this.a(context, ((RankTopDataModel) arrayList.get(0)).is_hide() == 1, Long.valueOf(rankTopDataModel.getLid()), String.valueOf(rankTopDataModel.getUid()), "", rankTopDataModel.getAvatar(), z);
            }
        });
        baseViewHolder.a(R.id.rl_avatar_two).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.rank.FitemRankHost.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ArrayList arrayList2 = arrayList;
                if (arrayList2 == null || arrayList2.size() <= 1) {
                    return;
                }
                RankTopDataModel rankTopDataModel = (RankTopDataModel) arrayList.get(1);
                FitemRankHost.this.a(context, ((RankTopDataModel) arrayList.get(1)).is_hide() == 1, Long.valueOf(rankTopDataModel.getLid()), String.valueOf(rankTopDataModel.getUid()), "", rankTopDataModel.getAvatar(), z);
            }
        });
        baseViewHolder.a(R.id.rl_avatar_three).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.rank.FitemRankHost.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ArrayList arrayList2 = arrayList;
                if (arrayList2 == null || arrayList2.size() <= 2) {
                    return;
                }
                RankTopDataModel rankTopDataModel = (RankTopDataModel) arrayList.get(2);
                FitemRankHost fitemRankHost = FitemRankHost.this;
                Context context2 = context;
                boolean z2 = true;
                if (((RankTopDataModel) arrayList.get(2)).is_hide() != 1) {
                    z2 = false;
                }
                fitemRankHost.a(context2, z2, Long.valueOf(rankTopDataModel.getLid()), String.valueOf(rankTopDataModel.getUid()), "", rankTopDataModel.getAvatar(), z);
            }
        });
    }

    private static void a(BaseViewHolder baseViewHolder, ArrayList<RankTopDataModel> arrayList, boolean z) {
        if (arrayList == null || arrayList.size() < 3) {
            baseViewHolder.a(R.id.rl_avatar_three).setVisibility(4);
            return;
        }
        baseViewHolder.a(R.id.rl_avatar_three).setVisibility(0);
        if (z) {
            baseViewHolder.a(R.id.iv_avatar_three_icon, e, R.drawable.live_rank_hour_default_avatar, true, 1.0f, -1, f);
            baseViewHolder.a(R.id.iv_avatar_two_shadow).setVisibility(4);
            baseViewHolder.a(R.id.iv_avatar_two_bonus).setVisibility(4);
            return;
        }
        RankTopDataModel rankTopDataModel = arrayList.get(2);
        boolean z2 = true;
        if (rankTopDataModel.is_hide() != 1) {
            z2 = false;
        }
        baseViewHolder.a(R.id.iv_avatar_three_icon, z2 ? e : rankTopDataModel.getAvatar(), R.drawable.live_rank_hour_default_avatar, true, 1.0f, -1, f);
        if (rankTopDataModel.getLid() <= 0 || z2) {
            baseViewHolder.a(R.id.iv_avatar_three_shadow).setVisibility(4);
            baseViewHolder.a(R.id.iv_avatar_three_bonus).setVisibility(4);
            return;
        }
        baseViewHolder.a(R.id.iv_avatar_three_shadow).setVisibility(0);
        baseViewHolder.a(R.id.iv_avatar_three_bonus).setVisibility(0);
        ImageLoader.c(baseViewHolder.b, "live_rank_hour_bounce_white.png").e(baseViewHolder.a(R.id.iv_avatar_three_bonus).hashCode()).g(-1).a((ImageView) baseViewHolder.a(R.id.iv_avatar_three_bonus));
    }

    private static void b(BaseViewHolder baseViewHolder, ArrayList<RankTopDataModel> arrayList, boolean z) {
        if (arrayList == null || arrayList.size() < 2) {
            baseViewHolder.a(R.id.rl_avatar_two).setVisibility(4);
            return;
        }
        baseViewHolder.a(R.id.rl_avatar_two).setVisibility(0);
        if (z) {
            baseViewHolder.a(R.id.iv_avatar_two_icon, e, R.drawable.live_rank_hour_default_avatar, true, 1.0f, -1, f);
            baseViewHolder.a(R.id.iv_avatar_two_shadow).setVisibility(4);
            baseViewHolder.a(R.id.iv_avatar_two_bonus).setVisibility(4);
            return;
        }
        boolean z2 = true;
        RankTopDataModel rankTopDataModel = arrayList.get(1);
        if (rankTopDataModel.is_hide() != 1) {
            z2 = false;
        }
        baseViewHolder.a(R.id.iv_avatar_two_icon, z2 ? e : rankTopDataModel.getAvatar(), R.drawable.live_rank_hour_default_avatar, true, 1.0f, -1, f);
        if (rankTopDataModel.getLid() <= 0 || z2) {
            baseViewHolder.a(R.id.iv_avatar_two_shadow).setVisibility(4);
            baseViewHolder.a(R.id.iv_avatar_two_bonus).setVisibility(4);
            return;
        }
        baseViewHolder.a(R.id.iv_avatar_two_shadow).setVisibility(0);
        baseViewHolder.a(R.id.iv_avatar_two_bonus).setVisibility(0);
        ImageLoader.c(baseViewHolder.b, "live_rank_hour_bounce_white.png").e(baseViewHolder.a(R.id.iv_avatar_two_bonus).hashCode()).g(-1).a((ImageView) baseViewHolder.a(R.id.iv_avatar_two_bonus));
    }

    private static void c(BaseViewHolder baseViewHolder, ArrayList<RankTopDataModel> arrayList, boolean z) {
        if (arrayList != null) {
            boolean z2 = true;
            if (arrayList.size() >= 1) {
                baseViewHolder.a(R.id.rl_avatar_one).setVisibility(0);
                if (z) {
                    baseViewHolder.a(R.id.iv_avatar_one_icon, e, R.drawable.live_rank_hour_default_avatar, true, 1.0f, -1, f);
                    baseViewHolder.a(R.id.iv_avatar_one_shadow).setVisibility(4);
                    baseViewHolder.a(R.id.iv_avatar_one_bonus).setVisibility(4);
                    return;
                }
                RankTopDataModel rankTopDataModel = arrayList.get(0);
                if (rankTopDataModel.is_hide() != 1) {
                    z2 = false;
                }
                baseViewHolder.a(R.id.iv_avatar_one_icon, z2 ? e : rankTopDataModel.getAvatar(), R.drawable.live_rank_hour_default_avatar, true, 1.0f, -1, f);
                if (rankTopDataModel.getLid() <= 0 || z2) {
                    baseViewHolder.a(R.id.iv_avatar_one_shadow).setVisibility(4);
                    baseViewHolder.a(R.id.iv_avatar_one_bonus).setVisibility(4);
                    return;
                }
                baseViewHolder.a(R.id.iv_avatar_one_shadow).setVisibility(0);
                baseViewHolder.a(R.id.iv_avatar_one_bonus).setVisibility(0);
                ImageLoader.c(baseViewHolder.b, "live_rank_hour_bounce_white.png").e(baseViewHolder.a(R.id.iv_avatar_one_bonus).hashCode()).g(-1).a((ImageView) baseViewHolder.a(R.id.iv_avatar_one_bonus));
                return;
            }
        }
        baseViewHolder.a(R.id.rl_avatar_one).setVisibility(4);
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_rank_host;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(final Context context, BaseViewHolder baseViewHolder, List<FreedomItem> list, int i) {
        String str;
        RankAllDataModel rankAllDataModel = this.b;
        if (rankAllDataModel == null) {
            return;
        }
        ArrayList<RankTopDataModel> top = rankAllDataModel.getTop();
        boolean z = this.b.is_hide() == 1;
        if (z) {
            str = "火力值MAX";
        } else if (this.d.booleanValue()) {
            str = "活跃值" + DistanceUtils.a(Long.valueOf(this.b.getScore()));
        } else {
            str = "距前一名" + DistanceUtils.a(Long.valueOf(this.b.getDiff_score())) + "火力值";
        }
        String name = z ? "fans".equals(this.f14054c) ? "用户暂时神隐" : "主播想静静" : this.b.getName();
        String avatar = z ? e : this.b.getAvatar();
        if (!TextUtils.isEmpty(this.b.getAvatar_frame())) {
            this.b.getAvatar_frame();
        }
        if (this.d.booleanValue()) {
            baseViewHolder.b(R.id.iv_union_avatar, true);
            baseViewHolder.b(R.id.iv_avatar, false);
            baseViewHolder.a(R.id.iv_union_avatar, this.b.getBadge_image(), R.drawable.live_rank_hour_default_avatar).a(R.id.tv_desc, (CharSequence) ("活跃值" + this.b.getScore()));
        } else {
            baseViewHolder.b(R.id.iv_union_avatar, false);
            baseViewHolder.b(R.id.iv_avatar, true);
            baseViewHolder.a(R.id.iv_avatar, avatar, R.drawable.live_rank_hour_default_avatar, true, 1.0f, -1).a(R.id.tv_rank_union_name, (CharSequence) this.b.getGuild_name()).a(R.id.tv_desc, (CharSequence) str);
        }
        baseViewHolder.b(R.id.tv_rank_union_name, (TextUtils.isEmpty(this.b.getGuild_name()) || z) ? false : true);
        baseViewHolder.a(R.id.tv_name, (CharSequence) name).a(R.id.tv_rank_index, (CharSequence) String.valueOf(i + 2));
        if (this.b.getLid() <= 0 || z) {
            baseViewHolder.a(R.id.rl_host_avatar_living).setVisibility(4);
        } else {
            baseViewHolder.a(R.id.rl_host_avatar_living).setVisibility(0);
            ImageLoader.c(baseViewHolder.b, "live_rank_hour_bounce_white.png").e(baseViewHolder.a(R.id.iv_host_living_avatar_icon).hashCode()).g(-1).a((ImageView) baseViewHolder.a(R.id.iv_host_living_avatar_icon));
        }
        a(baseViewHolder, i);
        a(baseViewHolder, top, context, z);
        final boolean z2 = z;
        baseViewHolder.a(R.id.iv_avatar).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.rank.FitemRankHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FitemRankHost fitemRankHost = FitemRankHost.this;
                fitemRankHost.a(context, z2, Long.valueOf(fitemRankHost.b.getLid()), FitemRankHost.this.b.getUid(), FitemRankHost.this.b.getName(), FitemRankHost.this.b.getAvatar(), z2);
            }
        });
    }
}

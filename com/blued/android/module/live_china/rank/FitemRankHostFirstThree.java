package com.blued.android.module.live_china.rank;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
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
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/rank/FitemRankHostFirstThree.class */
public final class FitemRankHostFirstThree extends FreedomItem {
    private ArrayList<RankAllDataModel> b;

    /* renamed from: c  reason: collision with root package name */
    private String f14064c;
    private int d;
    private final boolean e;
    private final boolean f;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/rank/FitemRankHostFirstThree$ConstField.class */
    public static final class ConstField {

        /* renamed from: a  reason: collision with root package name */
        public static final ConstField f14065a = new ConstField();
        private static String b = "https://web.bldimg.com/image-manager/1689832311_97803.webp";

        /* renamed from: c  reason: collision with root package name */
        private static String f14066c = "https://web.bldimg.com/image-manager/1689735948_31980.webp";
        private static String d = "https://web.bldimg.com/image-manager/1689837258_82766.webp";
        private static String e = "https://web.bldimg.com/image-manager/1689735948_24059.webp";
        private static String f = "https://web.bldimg.com/image-manager/1689735948_88202.webp";
        private static String g = "https://web.bldimg.com/image-manager/1690460677_11166.png";
        private static String h = "https://web.bldimg.com/image-manager/1690460677_64512.png";
        private static String i = "https://web.bldimg.com/image-manager/1690460677_44946.png";
        private static String j = "https://web.bldimg.com/image-manager/1690374197_40405.png";

        private ConstField() {
        }

        public final String a() {
            return b;
        }

        public final String b() {
            return f14066c;
        }

        public final String c() {
            return d;
        }

        public final String d() {
            return e;
        }

        public final String e() {
            return f;
        }

        public final String f() {
            return g;
        }

        public final String g() {
            return h;
        }

        public final String h() {
            return i;
        }

        public final String i() {
            return j;
        }
    }

    public FitemRankHostFirstThree(ArrayList<RankAllDataModel> modelList, String str, int i) {
        Intrinsics.e(modelList, "modelList");
        this.b = modelList;
        this.f14064c = str;
        this.d = i;
        this.e = Intrinsics.a((Object) str, (Object) "union") && this.d == 0;
        this.f = Intrinsics.a((Object) this.f14064c, (Object) "union");
    }

    /* JADX WARN: Type inference failed for: r1v10, types: [T, java.util.ArrayList] */
    private final void a(final Context context, BaseViewHolder baseViewHolder, final RankAllDataModel rankAllDataModel) {
        String a2;
        if (rankAllDataModel == null || rankAllDataModel.isFake()) {
            baseViewHolder.c(R.id.iv_first_one_avatar, this.e ? R.drawable.live_rank_union_defalut : R.drawable.live_rank_hour_default_avatar).a(R.id.iv_first_one_avatar_frame, ConstField.f14065a.f()).a(R.id.iv_first_one_top, !this.f ? ConstField.f14065a.b() : ConstField.f14065a.c()).a(R.id.tv_first_one_name, R.string.live_rank_vacancy).a(R.id.tv_first_one_desc, "--").a(R.id.tv_first_one_name, true);
            baseViewHolder.a(R.id.ll_first_one_avatars_root).setVisibility(4);
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f42545a = rankAllDataModel.getTop();
        boolean z = rankAllDataModel.is_hide() == 1;
        String name = z ? Intrinsics.a((Object) "fans", (Object) this.f14064c) ? "用户暂时神隐" : "主播想静静" : rankAllDataModel.getName();
        if (z) {
            a2 = "火力值MAX";
        } else if (this.e) {
            a2 = Intrinsics.a("活跃值", (Object) Long.valueOf(rankAllDataModel.getScore()));
        } else {
            a2 = "领先" + ((Object) DistanceUtils.a(Long.valueOf(rankAllDataModel.getDiff_score()))) + "火力值";
        }
        String f = ConstField.f14065a.f();
        if (this.e) {
            baseViewHolder.a(R.id.iv_union_first_avatar, rankAllDataModel.getBadge_image()).a(R.id.tv_first_one_name, (CharSequence) rankAllDataModel.getName());
            baseViewHolder.a(R.id.rl_first_one_avatar).setVisibility(8);
        } else {
            baseViewHolder.a(R.id.iv_first_one_avatar, !z ? rankAllDataModel.getAvatar() : ConstField.f14065a.a(), R.drawable.live_rank_hour_default_avatar, true).a(R.id.iv_first_one_avatar_frame, f).a(R.id.tv_first_one_name, (CharSequence) name);
        }
        baseViewHolder.a(R.id.iv_first_one_top, !this.f ? ConstField.f14065a.b() : ConstField.f14065a.c()).a(R.id.tv_first_one_name, true).a(R.id.tv_first_one_desc, (CharSequence) a2).a(R.id.iv_first_one_avatar0, (objectRef.f42545a == 0 || ((ArrayList) objectRef.f42545a).size() < 1 || ((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(0)).is_hide() != 0 || z) ? ConstField.f14065a.a() : ((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(0)).getAvatar(), R.drawable.live_rank_hour_default_avatar, true, 1.0f, -1, ConstField.f14065a.i()).a(R.id.iv_first_one_avatar1, (objectRef.f42545a == 0 || ((ArrayList) objectRef.f42545a).size() < 2 || ((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(1)).is_hide() != 0 || z) ? ConstField.f14065a.a() : ((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(1)).getAvatar(), R.drawable.live_rank_hour_default_avatar, true, 1.0f, -1, ConstField.f14065a.i()).a(R.id.iv_first_one_avatar2, (objectRef.f42545a == 0 || ((ArrayList) objectRef.f42545a).size() < 3 || ((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(2)).is_hide() != 0 || z) ? ConstField.f14065a.a() : ((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(2)).getAvatar(), R.drawable.live_rank_hour_default_avatar, true, 1.0f, -1, ConstField.f14065a.i());
        if (rankAllDataModel.getLid() <= 0 || z) {
            baseViewHolder.a(R.id.rl_host_first_living).setVisibility(8);
        } else {
            baseViewHolder.a(R.id.rl_host_first_living).setVisibility(0);
            ImageWrapper g = ImageLoader.c(baseViewHolder.b, "live_rank_hour_bounce_white.png").e(baseViewHolder.a(R.id.iv_first_one_live_icon).hashCode()).g(-1);
            View a3 = baseViewHolder.a(R.id.iv_first_one_live_icon);
            if (a3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
            }
            g.a((ImageView) a3);
        }
        if (objectRef.f42545a == 0 || ((ArrayList) objectRef.f42545a).size() < 1) {
            baseViewHolder.a(R.id.rl_first_living0).setVisibility(8);
        } else {
            baseViewHolder.a(R.id.rl_first_living0).setVisibility(0);
            if (((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(0)).getLid() == 0 || ((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(0)).is_hide() != 0 || z) {
                baseViewHolder.a(R.id.iv_first_one_shadow0).setVisibility(4);
                baseViewHolder.a(R.id.iv_first_one_bonus0).setVisibility(4);
            } else {
                baseViewHolder.a(R.id.iv_first_one_shadow0).setVisibility(0);
                baseViewHolder.a(R.id.iv_first_one_bonus0).setVisibility(0);
                ImageWrapper g2 = ImageLoader.c(baseViewHolder.b, "live_rank_hour_bounce_white.png").e(baseViewHolder.a(R.id.iv_first_one_bonus0).hashCode()).g(-1);
                View a4 = baseViewHolder.a(R.id.iv_first_one_bonus0);
                if (a4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
                }
                g2.a((ImageView) a4);
            }
        }
        if (objectRef.f42545a == 0 || ((ArrayList) objectRef.f42545a).size() < 2) {
            baseViewHolder.a(R.id.rl_first_living1).setVisibility(8);
        } else {
            baseViewHolder.a(R.id.rl_first_living1).setVisibility(0);
            if (((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(1)).getLid() == 0 || ((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(1)).is_hide() != 0 || z) {
                baseViewHolder.a(R.id.iv_first_one_shadow1).setVisibility(4);
                baseViewHolder.a(R.id.iv_first_one_bonus1).setVisibility(4);
            } else {
                baseViewHolder.a(R.id.iv_first_one_shadow1).setVisibility(0);
                baseViewHolder.a(R.id.iv_first_one_bonus1).setVisibility(0);
                ImageWrapper g3 = ImageLoader.c(baseViewHolder.b, "live_rank_hour_bounce_white.png").e(baseViewHolder.a(R.id.iv_first_one_bonus1).hashCode()).g(-1);
                View a5 = baseViewHolder.a(R.id.iv_first_one_bonus1);
                if (a5 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
                }
                g3.a((ImageView) a5);
            }
        }
        if (objectRef.f42545a == 0 || ((ArrayList) objectRef.f42545a).size() < 3) {
            baseViewHolder.a(R.id.rl_first_living2).setVisibility(8);
        } else {
            baseViewHolder.a(R.id.rl_first_living2).setVisibility(0);
            if (((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(2)).getLid() == 0 || ((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(2)).is_hide() != 0 || z) {
                baseViewHolder.a(R.id.iv_first_one_shadow2).setVisibility(4);
                baseViewHolder.a(R.id.iv_first_one_bonus2).setVisibility(4);
            } else {
                baseViewHolder.a(R.id.iv_first_one_shadow2).setVisibility(0);
                baseViewHolder.a(R.id.iv_first_one_bonus2).setVisibility(0);
                ImageWrapper g4 = ImageLoader.c(baseViewHolder.b, "live_rank_hour_bounce_white.png").e(baseViewHolder.a(R.id.iv_first_one_bonus2).hashCode()).g(-1);
                View a6 = baseViewHolder.a(R.id.iv_first_one_bonus2);
                if (a6 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
                }
                g4.a((ImageView) a6);
            }
        }
        final boolean z2 = z;
        baseViewHolder.a(R.id.rl_first_one_avatar).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$FitemRankHostFirstThree$oBtQQCkP6Tokl2iAeYYfLak49IE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemRankHostFirstThree.a(FitemRankHostFirstThree.this, context, rankAllDataModel, z2, view);
            }
        });
        final boolean z3 = z;
        baseViewHolder.a(R.id.rl_first_living0).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$FitemRankHostFirstThree$lEPC4kejtY_oDle4kqW8jwlsuaY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemRankHostFirstThree.a(Ref.ObjectRef.this, this, context, z3, view);
            }
        });
        final boolean z4 = z;
        baseViewHolder.a(R.id.rl_first_living1).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$FitemRankHostFirstThree$BpAyZkhpCRMji8VaY_Y_1DSzul8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemRankHostFirstThree.b(Ref.ObjectRef.this, this, context, z4, view);
            }
        });
        final boolean z5 = z;
        baseViewHolder.a(R.id.rl_first_living2).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$FitemRankHostFirstThree$r-DRvIYPevlLpk-RUV8PKXjGI7Q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemRankHostFirstThree.c(Ref.ObjectRef.this, this, context, z5, view);
            }
        });
    }

    private final void a(Context context, boolean z, long j, String str, String str2, String str3, boolean z2) {
        if (z || z2) {
            return;
        }
        if (LiveRoomManager.a().K()) {
            AppMethods.a((CharSequence) "当前正在开播无法查看");
        } else if (j == 0) {
            LiveRoomInfo.a().a(context, str, str2, str3, 0, 1);
        } else {
            LiveRoomData liveRoomData = new LiveRoomData(j, 0, "live_room_ranking", str, str2, str3, 0);
            LiveFloatManager.a().b(false);
            LiveRoomInfo.a().a(context, liveRoomData, 0, (List<LiveRoomData>) null, (Bundle) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemRankHostFirstThree this$0, Context context, RankAllDataModel rankAllDataModel, boolean z, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(context, "$context");
        this$0.a(context, rankAllDataModel.is_hide() == 1, rankAllDataModel.getLid(), rankAllDataModel.getUid(), rankAllDataModel.getName(), rankAllDataModel.getAvatar(), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Ref.ObjectRef top, FitemRankHostFirstThree this$0, Context context, boolean z, View view) {
        Intrinsics.e(top, "$top");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(context, "$context");
        if (top.f42545a == 0 || ((ArrayList) top.f42545a).size() < 1) {
            return;
        }
        this$0.a(context, ((RankTopDataModel) ((ArrayList) top.f42545a).get(0)).is_hide() == 1, ((RankTopDataModel) ((ArrayList) top.f42545a).get(0)).getLid(), String.valueOf(((RankTopDataModel) ((ArrayList) top.f42545a).get(0)).getUid()), "", ((RankTopDataModel) ((ArrayList) top.f42545a).get(0)).getAvatar(), z);
    }

    /* JADX WARN: Type inference failed for: r1v10, types: [T, java.util.ArrayList] */
    private final void b(final Context context, BaseViewHolder baseViewHolder, final RankAllDataModel rankAllDataModel) {
        String a2;
        if (rankAllDataModel == null || rankAllDataModel.isFake()) {
            baseViewHolder.c(R.id.iv_first_two_avatar, this.e ? R.drawable.live_rank_union_defalut : R.drawable.live_rank_hour_default_avatar).a(R.id.iv_first_two_avatar_frame, ConstField.f14065a.g()).a(R.id.iv_first_two_top, ConstField.f14065a.d()).a(R.id.tv_first_two_name, R.string.live_rank_vacancy).a(R.id.tv_first_two_desc, "--").a(R.id.tv_first_two_name, true);
            baseViewHolder.a(R.id.ll_first_two_avatars_root).setVisibility(4);
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f42545a = rankAllDataModel.getTop();
        boolean z = rankAllDataModel.is_hide() == 1;
        String name = z ? Intrinsics.a((Object) "fans", (Object) this.f14064c) ? "用户暂时神隐" : "主播想静静" : rankAllDataModel.getName();
        if (z) {
            a2 = "火力值MAX";
        } else if (this.e) {
            a2 = Intrinsics.a("活跃值", (Object) Long.valueOf(rankAllDataModel.getScore()));
        } else {
            a2 = "距前一名" + ((Object) DistanceUtils.a(Long.valueOf(rankAllDataModel.getDiff_score()))) + "火力值";
        }
        String g = ConstField.f14065a.g();
        if (this.e) {
            baseViewHolder.a(R.id.iv_union_second_avatar, rankAllDataModel.getBadge_image()).a(R.id.tv_first_two_name, (CharSequence) rankAllDataModel.getName());
            baseViewHolder.a(R.id.rl_first_two_avatar).setVisibility(8);
        } else {
            baseViewHolder.a(R.id.iv_first_two_avatar, !z ? rankAllDataModel.getAvatar() : ConstField.f14065a.a(), R.drawable.live_rank_hour_default_avatar, true).a(R.id.iv_first_two_avatar_frame, g, true, -1).a(R.id.tv_first_two_name, (CharSequence) name);
        }
        baseViewHolder.a(R.id.iv_first_two_top, ConstField.f14065a.d()).a(R.id.tv_first_two_desc, (CharSequence) a2).a(R.id.tv_first_two_name, true).a(R.id.iv_first_two_avatar0, (objectRef.f42545a == 0 || ((ArrayList) objectRef.f42545a).size() < 1 || ((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(0)).is_hide() != 0 || z) ? ConstField.f14065a.a() : ((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(0)).getAvatar(), R.drawable.live_rank_hour_default_avatar, true, 1.0f, -1, ConstField.f14065a.i()).a(R.id.iv_first_two_avatar1, (objectRef.f42545a == 0 || ((ArrayList) objectRef.f42545a).size() < 2 || ((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(1)).is_hide() != 0 || z) ? ConstField.f14065a.a() : ((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(1)).getAvatar(), R.drawable.live_rank_hour_default_avatar, true, 1.0f, -1, ConstField.f14065a.i()).a(R.id.iv_first_two_avatar2, (objectRef.f42545a == 0 || ((ArrayList) objectRef.f42545a).size() < 3 || ((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(2)).is_hide() != 0 || z) ? ConstField.f14065a.a() : ((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(2)).getAvatar(), R.drawable.live_rank_hour_default_avatar, true, 1.0f, -1, ConstField.f14065a.i());
        if (rankAllDataModel.getLid() <= 0 || z) {
            baseViewHolder.a(R.id.rl_host_second_living).setVisibility(8);
        } else {
            baseViewHolder.a(R.id.rl_host_second_living).setVisibility(0);
            ImageWrapper g2 = ImageLoader.c(baseViewHolder.b, "live_rank_hour_bounce_white.png").e(baseViewHolder.a(R.id.iv_first_two_live_icon).hashCode()).g(-1);
            View a3 = baseViewHolder.a(R.id.iv_first_two_live_icon);
            if (a3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
            }
            g2.a((ImageView) a3);
        }
        if (objectRef.f42545a == 0 || ((ArrayList) objectRef.f42545a).size() < 1) {
            baseViewHolder.a(R.id.rl_second_living0).setVisibility(8);
        } else {
            baseViewHolder.a(R.id.rl_second_living0).setVisibility(0);
            if (((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(0)).getLid() == 0 || ((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(0)).is_hide() != 0 || z) {
                baseViewHolder.a(R.id.iv_first_two_shadow0).setVisibility(4);
                baseViewHolder.a(R.id.iv_first_two_bonus0).setVisibility(4);
            } else {
                baseViewHolder.a(R.id.iv_first_two_shadow0).setVisibility(0);
                baseViewHolder.a(R.id.iv_first_two_bonus0).setVisibility(0);
                ImageWrapper g3 = ImageLoader.c(baseViewHolder.b, "live_rank_hour_bounce_white.png").e(baseViewHolder.a(R.id.iv_first_two_bonus0).hashCode()).g(-1);
                View a4 = baseViewHolder.a(R.id.iv_first_two_bonus0);
                if (a4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
                }
                g3.a((ImageView) a4);
            }
        }
        if (objectRef.f42545a == 0 || ((ArrayList) objectRef.f42545a).size() < 2) {
            baseViewHolder.a(R.id.rl_second_living1).setVisibility(8);
        } else {
            baseViewHolder.a(R.id.rl_second_living1).setVisibility(0);
            if (((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(1)).getLid() == 0 || ((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(1)).is_hide() != 0 || z) {
                baseViewHolder.a(R.id.iv_first_two_shadow1).setVisibility(4);
                baseViewHolder.a(R.id.iv_first_two_bonus1).setVisibility(4);
            } else {
                baseViewHolder.a(R.id.iv_first_two_shadow1).setVisibility(0);
                baseViewHolder.a(R.id.iv_first_two_bonus1).setVisibility(0);
                ImageWrapper g4 = ImageLoader.c(baseViewHolder.b, "live_rank_hour_bounce_white.png").e(baseViewHolder.a(R.id.iv_first_two_bonus1).hashCode()).g(-1);
                View a5 = baseViewHolder.a(R.id.iv_first_two_bonus1);
                if (a5 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
                }
                g4.a((ImageView) a5);
            }
        }
        if (objectRef.f42545a == 0 || ((ArrayList) objectRef.f42545a).size() < 3) {
            baseViewHolder.a(R.id.rl_second_living2).setVisibility(8);
        } else {
            baseViewHolder.a(R.id.rl_second_living2).setVisibility(0);
            if (((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(2)).getLid() == 0 || ((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(2)).is_hide() != 0 || z) {
                baseViewHolder.a(R.id.iv_first_two_shadow2).setVisibility(4);
                baseViewHolder.a(R.id.iv_first_two_bonus2).setVisibility(4);
            } else {
                baseViewHolder.a(R.id.iv_first_two_shadow2).setVisibility(0);
                baseViewHolder.a(R.id.iv_first_two_bonus2).setVisibility(0);
                ImageWrapper g5 = ImageLoader.c(baseViewHolder.b, "live_rank_hour_bounce_white.png").e(baseViewHolder.a(R.id.iv_first_two_bonus2).hashCode()).g(-1);
                View a6 = baseViewHolder.a(R.id.iv_first_two_bonus2);
                if (a6 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
                }
                g5.a((ImageView) a6);
            }
        }
        final boolean z2 = z;
        baseViewHolder.a(R.id.rl_first_two_avatar).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$FitemRankHostFirstThree$DnqTk88O3IypGc8hsD80DYHDxHI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemRankHostFirstThree.b(FitemRankHostFirstThree.this, context, rankAllDataModel, z2, view);
            }
        });
        final boolean z3 = z;
        baseViewHolder.a(R.id.rl_second_living0).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$FitemRankHostFirstThree$je1MaEWFOJNQcK8V2I21n_h5qxc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemRankHostFirstThree.d(Ref.ObjectRef.this, this, context, z3, view);
            }
        });
        final boolean z4 = z;
        baseViewHolder.a(R.id.rl_second_living1).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$FitemRankHostFirstThree$5RLfaOe4QOVAmwpgUPuZ2qwkAiw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemRankHostFirstThree.e(Ref.ObjectRef.this, this, context, z4, view);
            }
        });
        final boolean z5 = z;
        baseViewHolder.a(R.id.rl_second_living2).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$FitemRankHostFirstThree$PX5xZQdhAKUtB_ceDITed1n_1UI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemRankHostFirstThree.f(Ref.ObjectRef.this, this, context, z5, view);
            }
        });
    }

    private final void b(BaseViewHolder baseViewHolder) {
        String str = this.f14064c;
        if (Intrinsics.a((Object) str, (Object) "anchor")) {
            baseViewHolder.a(R.id.iv_bg, "https://web.bldimg.com/image-manager/1690455782_36146.png");
        } else if (Intrinsics.a((Object) str, (Object) "fans")) {
            baseViewHolder.a(R.id.iv_bg, "https://web.bldimg.com/image-manager/1689906039_44781.webp");
        } else {
            baseViewHolder.a(R.id.iv_bg, "https://web.bldimg.com/image-manager/1689906039_63283.webp");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FitemRankHostFirstThree this$0, Context context, RankAllDataModel rankAllDataModel, boolean z, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(context, "$context");
        this$0.a(context, rankAllDataModel.is_hide() == 1, rankAllDataModel.getLid(), rankAllDataModel.getUid(), rankAllDataModel.getName(), rankAllDataModel.getAvatar(), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Ref.ObjectRef top, FitemRankHostFirstThree this$0, Context context, boolean z, View view) {
        Intrinsics.e(top, "$top");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(context, "$context");
        if (top.f42545a == 0 || ((ArrayList) top.f42545a).size() < 2) {
            return;
        }
        this$0.a(context, ((RankTopDataModel) ((ArrayList) top.f42545a).get(1)).is_hide() == 1, ((RankTopDataModel) ((ArrayList) top.f42545a).get(1)).getLid(), String.valueOf(((RankTopDataModel) ((ArrayList) top.f42545a).get(1)).getUid()), "", ((RankTopDataModel) ((ArrayList) top.f42545a).get(1)).getAvatar(), z);
    }

    /* JADX WARN: Type inference failed for: r1v10, types: [T, java.util.ArrayList] */
    private final void c(final Context context, BaseViewHolder baseViewHolder, final RankAllDataModel rankAllDataModel) {
        String a2;
        if (rankAllDataModel == null || rankAllDataModel.isFake()) {
            baseViewHolder.c(R.id.iv_first_three_avatar, this.e ? R.drawable.live_rank_union_defalut : R.drawable.live_rank_hour_default_avatar).a(R.id.iv_first_three_avatar_frame, ConstField.f14065a.h()).a(R.id.iv_first_three_top, ConstField.f14065a.e()).a(R.id.tv_first_three_name, R.string.live_rank_vacancy).a(R.id.tv_first_three_desc, "--").a(R.id.tv_first_three_name, true);
            baseViewHolder.a(R.id.ll_first_three_avatars_root).setVisibility(4);
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f42545a = rankAllDataModel.getTop();
        boolean z = rankAllDataModel.is_hide() == 1;
        String name = z ? Intrinsics.a((Object) "fans", (Object) this.f14064c) ? "用户暂时神隐" : "主播想静静" : rankAllDataModel.getName();
        if (z) {
            a2 = "火力值MAX";
        } else if (this.e) {
            a2 = Intrinsics.a("活跃值", (Object) Long.valueOf(rankAllDataModel.getScore()));
        } else {
            a2 = "距前一名" + ((Object) DistanceUtils.a(Long.valueOf(rankAllDataModel.getDiff_score()))) + "火力值";
        }
        String h = ConstField.f14065a.h();
        if (this.e) {
            baseViewHolder.a(R.id.iv_union_third_avatar, rankAllDataModel.getBadge_image()).a(R.id.tv_first_three_name, (CharSequence) rankAllDataModel.getName());
            baseViewHolder.a(R.id.rl_first_three_avatar).setVisibility(8);
        } else {
            baseViewHolder.a(R.id.iv_first_three_avatar, !z ? rankAllDataModel.getAvatar() : ConstField.f14065a.a(), R.drawable.live_rank_hour_default_avatar, true).a(R.id.iv_first_three_avatar_frame, h, true, -1).a(R.id.tv_first_three_name, (CharSequence) name);
        }
        baseViewHolder.a(R.id.iv_first_three_top, ConstField.f14065a.e()).a(R.id.tv_first_three_name, true).a(R.id.tv_first_three_desc, (CharSequence) a2).a(R.id.tv_first_three_name, true).a(R.id.iv_first_three_avatar0, (objectRef.f42545a == 0 || ((ArrayList) objectRef.f42545a).size() < 1 || ((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(0)).is_hide() != 0 || z) ? ConstField.f14065a.a() : ((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(0)).getAvatar(), R.drawable.live_rank_hour_default_avatar, true, 1.0f, -1, ConstField.f14065a.i()).a(R.id.iv_first_three_avatar1, (objectRef.f42545a == 0 || ((ArrayList) objectRef.f42545a).size() < 2 || ((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(1)).is_hide() != 0 || z) ? ConstField.f14065a.a() : ((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(1)).getAvatar(), R.drawable.live_rank_hour_default_avatar, true, 1.0f, -1, ConstField.f14065a.i()).a(R.id.iv_first_three_avatar2, (objectRef.f42545a == 0 || ((ArrayList) objectRef.f42545a).size() < 3 || ((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(2)).is_hide() != 0 || z) ? ConstField.f14065a.a() : ((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(2)).getAvatar(), R.drawable.live_rank_hour_default_avatar, true, 1.0f, -1, ConstField.f14065a.i());
        if (rankAllDataModel.getLid() <= 0 || z) {
            baseViewHolder.a(R.id.rl_host_third_living).setVisibility(8);
        } else {
            baseViewHolder.a(R.id.rl_host_third_living).setVisibility(0);
            ImageWrapper g = ImageLoader.c(baseViewHolder.b, "live_rank_hour_bounce_white.png").e(baseViewHolder.a(R.id.iv_first_three_live_icon).hashCode()).g(-1);
            View a3 = baseViewHolder.a(R.id.iv_first_three_live_icon);
            if (a3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
            }
            g.a((ImageView) a3);
        }
        if (objectRef.f42545a == 0 || ((ArrayList) objectRef.f42545a).size() < 1) {
            baseViewHolder.a(R.id.rl_third_living0).setVisibility(8);
        } else {
            baseViewHolder.a(R.id.rl_third_living0).setVisibility(0);
            if (((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(0)).getLid() == 0 || ((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(0)).is_hide() != 0 || z) {
                baseViewHolder.a(R.id.iv_first_three_shadow0).setVisibility(4);
                baseViewHolder.a(R.id.iv_first_three_bonus0).setVisibility(4);
            } else {
                baseViewHolder.a(R.id.iv_first_three_shadow0).setVisibility(0);
                baseViewHolder.a(R.id.iv_first_three_bonus0).setVisibility(0);
                ImageWrapper g2 = ImageLoader.c(baseViewHolder.b, "live_rank_hour_bounce_white.png").e(baseViewHolder.a(R.id.iv_first_three_bonus0).hashCode()).g(-1);
                View a4 = baseViewHolder.a(R.id.iv_first_three_bonus0);
                if (a4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
                }
                g2.a((ImageView) a4);
            }
        }
        if (objectRef.f42545a == 0 || ((ArrayList) objectRef.f42545a).size() < 2) {
            baseViewHolder.a(R.id.rl_third_living1).setVisibility(8);
        } else {
            baseViewHolder.a(R.id.rl_third_living1).setVisibility(0);
            if (((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(1)).getLid() == 0 || ((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(1)).is_hide() != 0 || z) {
                baseViewHolder.a(R.id.iv_first_three_shadow1).setVisibility(4);
                baseViewHolder.a(R.id.iv_first_three_bonus1).setVisibility(4);
            } else {
                baseViewHolder.a(R.id.iv_first_three_shadow1).setVisibility(0);
                baseViewHolder.a(R.id.iv_first_three_bonus1).setVisibility(0);
                ImageWrapper g3 = ImageLoader.c(baseViewHolder.b, "live_rank_hour_bounce_white.png").e(baseViewHolder.a(R.id.iv_first_three_bonus1).hashCode()).g(-1);
                View a5 = baseViewHolder.a(R.id.iv_first_three_bonus1);
                if (a5 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
                }
                g3.a((ImageView) a5);
            }
        }
        if (objectRef.f42545a == 0 || ((ArrayList) objectRef.f42545a).size() < 3) {
            baseViewHolder.a(R.id.rl_third_living2).setVisibility(8);
        } else {
            baseViewHolder.a(R.id.rl_third_living2).setVisibility(0);
            if (((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(2)).getLid() == 0 || ((RankTopDataModel) ((ArrayList) objectRef.f42545a).get(2)).is_hide() != 0 || z) {
                baseViewHolder.a(R.id.iv_first_three_shadow2).setVisibility(4);
                baseViewHolder.a(R.id.iv_first_three_bonus2).setVisibility(4);
            } else {
                baseViewHolder.a(R.id.iv_first_three_shadow2).setVisibility(0);
                baseViewHolder.a(R.id.iv_first_three_bonus2).setVisibility(0);
                ImageWrapper g4 = ImageLoader.c(baseViewHolder.b, "live_rank_hour_bounce_white.png").e(baseViewHolder.a(R.id.iv_first_three_bonus2).hashCode()).g(-1);
                View a6 = baseViewHolder.a(R.id.iv_first_three_bonus2);
                if (a6 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
                }
                g4.a((ImageView) a6);
            }
        }
        final boolean z2 = z;
        baseViewHolder.a(R.id.rl_first_three_avatar).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$FitemRankHostFirstThree$uGGOcem0VXezUhnhbgbYfBu5wz8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemRankHostFirstThree.c(FitemRankHostFirstThree.this, context, rankAllDataModel, z2, view);
            }
        });
        final boolean z3 = z;
        baseViewHolder.a(R.id.rl_third_living0).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$FitemRankHostFirstThree$j2eCA23HChECoYurnCmHIuAxatY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemRankHostFirstThree.g(Ref.ObjectRef.this, this, context, z3, view);
            }
        });
        final boolean z4 = z;
        baseViewHolder.a(R.id.rl_third_living1).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$FitemRankHostFirstThree$G8OeJ9Q0_Kh0DYh9q39rRwxWfTU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemRankHostFirstThree.h(Ref.ObjectRef.this, this, context, z4, view);
            }
        });
        final boolean z5 = z;
        baseViewHolder.a(R.id.rl_third_living2).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$FitemRankHostFirstThree$zQ_gCpzKMjXVQIIhvuG3JMg1JcU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemRankHostFirstThree.i(Ref.ObjectRef.this, this, context, z5, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(FitemRankHostFirstThree this$0, Context context, RankAllDataModel rankAllDataModel, boolean z, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(context, "$context");
        this$0.a(context, rankAllDataModel.is_hide() == 1, rankAllDataModel.getLid(), rankAllDataModel.getUid(), rankAllDataModel.getName(), rankAllDataModel.getAvatar(), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Ref.ObjectRef top, FitemRankHostFirstThree this$0, Context context, boolean z, View view) {
        Intrinsics.e(top, "$top");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(context, "$context");
        if (top.f42545a == 0 || ((ArrayList) top.f42545a).size() < 3) {
            return;
        }
        this$0.a(context, ((RankTopDataModel) ((ArrayList) top.f42545a).get(2)).is_hide() == 1, ((RankTopDataModel) ((ArrayList) top.f42545a).get(2)).getLid(), String.valueOf(((RankTopDataModel) ((ArrayList) top.f42545a).get(2)).getUid()), "", ((RankTopDataModel) ((ArrayList) top.f42545a).get(2)).getAvatar(), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Ref.ObjectRef top, FitemRankHostFirstThree this$0, Context context, boolean z, View view) {
        Intrinsics.e(top, "$top");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(context, "$context");
        if (top.f42545a == 0 || ((ArrayList) top.f42545a).size() < 1) {
            return;
        }
        this$0.a(context, ((RankTopDataModel) ((ArrayList) top.f42545a).get(0)).is_hide() == 1, ((RankTopDataModel) ((ArrayList) top.f42545a).get(0)).getLid(), String.valueOf(((RankTopDataModel) ((ArrayList) top.f42545a).get(0)).getUid()), "", ((RankTopDataModel) ((ArrayList) top.f42545a).get(0)).getAvatar(), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Ref.ObjectRef top, FitemRankHostFirstThree this$0, Context context, boolean z, View view) {
        Intrinsics.e(top, "$top");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(context, "$context");
        if (top.f42545a == 0 || ((ArrayList) top.f42545a).size() < 2) {
            return;
        }
        this$0.a(context, ((RankTopDataModel) ((ArrayList) top.f42545a).get(1)).is_hide() == 1, ((RankTopDataModel) ((ArrayList) top.f42545a).get(1)).getLid(), String.valueOf(((RankTopDataModel) ((ArrayList) top.f42545a).get(1)).getUid()), "", ((RankTopDataModel) ((ArrayList) top.f42545a).get(1)).getAvatar(), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Ref.ObjectRef top, FitemRankHostFirstThree this$0, Context context, boolean z, View view) {
        Intrinsics.e(top, "$top");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(context, "$context");
        if (top.f42545a == 0 || ((ArrayList) top.f42545a).size() < 3) {
            return;
        }
        this$0.a(context, ((RankTopDataModel) ((ArrayList) top.f42545a).get(2)).is_hide() == 1, ((RankTopDataModel) ((ArrayList) top.f42545a).get(2)).getLid(), String.valueOf(((RankTopDataModel) ((ArrayList) top.f42545a).get(2)).getUid()), "", ((RankTopDataModel) ((ArrayList) top.f42545a).get(2)).getAvatar(), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Ref.ObjectRef top, FitemRankHostFirstThree this$0, Context context, boolean z, View view) {
        Intrinsics.e(top, "$top");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(context, "$context");
        if (top.f42545a == 0 || ((ArrayList) top.f42545a).size() < 1) {
            return;
        }
        this$0.a(context, ((RankTopDataModel) ((ArrayList) top.f42545a).get(0)).is_hide() == 1, ((RankTopDataModel) ((ArrayList) top.f42545a).get(0)).getLid(), String.valueOf(((RankTopDataModel) ((ArrayList) top.f42545a).get(0)).getUid()), "", ((RankTopDataModel) ((ArrayList) top.f42545a).get(0)).getAvatar(), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Ref.ObjectRef top, FitemRankHostFirstThree this$0, Context context, boolean z, View view) {
        Intrinsics.e(top, "$top");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(context, "$context");
        if (top.f42545a == 0 || ((ArrayList) top.f42545a).size() < 2) {
            return;
        }
        this$0.a(context, ((RankTopDataModel) ((ArrayList) top.f42545a).get(1)).is_hide() == 1, ((RankTopDataModel) ((ArrayList) top.f42545a).get(1)).getLid(), String.valueOf(((RankTopDataModel) ((ArrayList) top.f42545a).get(1)).getUid()), "", ((RankTopDataModel) ((ArrayList) top.f42545a).get(1)).getAvatar(), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Ref.ObjectRef top, FitemRankHostFirstThree this$0, Context context, boolean z, View view) {
        Intrinsics.e(top, "$top");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(context, "$context");
        if (top.f42545a == 0 || ((ArrayList) top.f42545a).size() < 3) {
            return;
        }
        this$0.a(context, ((RankTopDataModel) ((ArrayList) top.f42545a).get(2)).is_hide() == 1, ((RankTopDataModel) ((ArrayList) top.f42545a).get(2)).getLid(), String.valueOf(((RankTopDataModel) ((ArrayList) top.f42545a).get(2)).getUid()), "", ((RankTopDataModel) ((ArrayList) top.f42545a).get(2)).getAvatar(), z);
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_rank_host_first_three;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        RankAllDataModel rankAllDataModel;
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        b(vh);
        a(context, vh, this.b.isEmpty() ? null : this.b.get(0));
        b(context, vh, (!this.b.isEmpty() && this.b.size() >= 2) ? this.b.get(1) : null);
        if (this.b.isEmpty()) {
            rankAllDataModel = null;
        } else {
            rankAllDataModel = null;
            if (this.b.size() >= 3) {
                rankAllDataModel = this.b.get(2);
            }
        }
        c(context, vh, rankAllDataModel);
    }
}

package com.blued.android.module.live_china.fitem;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Grego;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemRankHourFirstThree.class */
public final class FitemRankHourFirstThree extends FreedomItem {
    private ArrayList<RankHourDataModel> b;
    private boolean c;
    private boolean d;
    private long e;

    public FitemRankHourFirstThree(ArrayList<RankHourDataModel> modelList, boolean z, boolean z2, long j) {
        Intrinsics.e(modelList, "modelList");
        this.b = modelList;
        this.c = z;
        this.d = z2;
        this.e = j;
    }

    private final View.OnClickListener a(final BaseFragment baseFragment, final RankHourDataModel rankHourDataModel) {
        if (baseFragment == null || rankHourDataModel == null) {
            return null;
        }
        return new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.-$$Lambda$FitemRankHourFirstThree$xgk_QDiKJZFne_x3RIL1SIQ-2f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemRankHourFirstThree.a(RankHourDataModel.this, baseFragment, view);
            }
        };
    }

    private final void a(Context context, BaseViewHolder baseViewHolder) {
        String str;
        TextView textView = (TextView) baseViewHolder.a(R.id.tv_title);
        if (this.d) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String string = context.getResources().getString(R.string.live_rank_summit_time);
            Intrinsics.c(string, "context.getResources().g…ng.live_rank_summit_time)");
            String format = String.format(string, Arrays.copyOf(new Object[]{f(), g()}, 2));
            Intrinsics.c(format, "format(format, *args)");
            str = format;
        } else {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.a;
            String string2 = context.getResources().getString(R.string.live_rank_last_summit_time);
            Intrinsics.c(string2, "context.getResources().g…ve_rank_last_summit_time)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{e(), f()}, 2));
            Intrinsics.c(format2, "format(format, *args)");
            str = format2;
        }
        textView.setText(str);
        if (this.c && this.d) {
            textView.setBackgroundResource(R.drawable.live_rank_hour_time_tag_top);
        } else if (this.c || !this.d) {
            textView.setBackgroundResource(R.drawable.live_rank_hour_time_tag_previous);
        } else {
            textView.setBackgroundResource(R.drawable.live_rank_hour_time_tag_potential);
        }
    }

    private final void a(Context context, BaseViewHolder baseViewHolder, RankHourDataModel rankHourDataModel) {
        baseViewHolder.b(R.id.iv_first_one_wing, this.c).c(R.id.iv_bg, this.c ? R.drawable.live_rank_hour_top_bg : R.drawable.live_rank_hour_potential_bg);
        if (rankHourDataModel == null) {
            baseViewHolder.c(R.id.iv_first_one_avatar, R.drawable.live_rank_hour_default_avatar).a(R.id.tv_first_one_name, R.string.live_rank_vacancy).a(R.id.tv_first_one_name, true).c(R.id.iv_first_one_bounce).a(R.id.tv_first_one_rank, "0");
            return;
        }
        baseViewHolder.a(R.id.iv_first_one_avatar, rankHourDataModel.getAvatar(), R.drawable.live_rank_hour_default_avatar, true).a(R.id.tv_first_one_name, (CharSequence) rankHourDataModel.getName()).a(R.id.tv_first_one_name, true).a(R.id.tv_first_one_rank, (CharSequence) String.valueOf(rankHourDataModel.getBonus()));
        if (TextUtils.isEmpty(rankHourDataModel.getAvatar_frame())) {
            baseViewHolder.b(R.id.iv_first_one_avatar_frame, false);
        } else {
            baseViewHolder.a(R.id.iv_first_one_avatar_frame, rankHourDataModel.getAvatar_frame(), rankHourDataModel.getAvatar_frame_type() != 0, -1).b(R.id.iv_first_one_avatar_frame, true);
        }
        if (rankHourDataModel.getLive() == 0) {
            baseViewHolder.c(R.id.rl_first_one_avatar, false).c(R.id.tv_first_one_name, false).c(R.id.iv_first_one_bounce, false).b(R.id.iv_first_one_bounce, false);
            return;
        }
        ImageWrapper g = ImageLoader.c(baseViewHolder.b, "live_rank_hour_bounce.png").e(baseViewHolder.a(R.id.iv_first_one_bounce).hashCode()).g(-1);
        View a = baseViewHolder.a(R.id.iv_first_one_bounce);
        if (a == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
        }
        g.a((ImageView) a);
        View.OnClickListener a2 = a((BaseFragment) baseViewHolder.a.a("BaseFragment", (String) null), rankHourDataModel);
        if (a2 == null) {
            return;
        }
        baseViewHolder.a(R.id.rl_first_one_avatar, a2).a(R.id.tv_first_one_name, a2).a(R.id.iv_first_one_bounce, a2).b(R.id.iv_first_one_bounce, true);
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

    private final void b(Context context, BaseViewHolder baseViewHolder, RankHourDataModel rankHourDataModel) {
        if (rankHourDataModel == null) {
            baseViewHolder.c(R.id.iv_first_tow_avatar, R.drawable.live_rank_hour_default_avatar).a(R.id.tv_first_tow_name, R.string.live_rank_vacancy).a(R.id.tv_first_tow_name, true).c(R.id.iv_first_tow_bounce).a(R.id.tv_first_tow_rank, "0");
            return;
        }
        baseViewHolder.a(R.id.iv_first_tow_avatar, rankHourDataModel.getAvatar(), R.drawable.live_rank_hour_default_avatar, true).a(R.id.tv_first_tow_name, (CharSequence) rankHourDataModel.getName()).a(R.id.tv_first_tow_name, true).a(R.id.tv_first_tow_rank, (CharSequence) String.valueOf(rankHourDataModel.getBonus()));
        if (TextUtils.isEmpty(rankHourDataModel.getAvatar_frame())) {
            baseViewHolder.b(R.id.iv_first_tow_avatar_frame, false);
        } else {
            baseViewHolder.a(R.id.iv_first_tow_avatar_frame, rankHourDataModel.getAvatar_frame(), rankHourDataModel.getAvatar_frame_type() != 0, -1).b(R.id.iv_first_tow_avatar_frame, true);
        }
        if (rankHourDataModel.getLive() == 0) {
            baseViewHolder.c(R.id.rl_first_tow_avatar, false).c(R.id.tv_first_tow_name, false).c(R.id.iv_first_tow_bounce, false).b(R.id.iv_first_tow_bounce, false);
            return;
        }
        ImageWrapper g = ImageLoader.c(baseViewHolder.b, "live_rank_hour_bounce.png").e(baseViewHolder.a(R.id.iv_first_tow_bounce).hashCode()).g(-1);
        View a = baseViewHolder.a(R.id.iv_first_tow_bounce);
        if (a == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
        }
        g.a((ImageView) a);
        View.OnClickListener a2 = a((BaseFragment) baseViewHolder.a.a("BaseFragment", (String) null), rankHourDataModel);
        if (a2 == null) {
            return;
        }
        baseViewHolder.a(R.id.rl_first_tow_avatar, a2).a(R.id.tv_first_tow_name, a2).a(R.id.iv_first_tow_bounce, a2).b(R.id.iv_first_tow_bounce, true);
    }

    private final void c(Context context, BaseViewHolder baseViewHolder, RankHourDataModel rankHourDataModel) {
        if (rankHourDataModel == null) {
            baseViewHolder.c(R.id.iv_first_three_avatar, R.drawable.live_rank_hour_default_avatar).a(R.id.tv_first_three_name, R.string.live_rank_vacancy).a(R.id.tv_first_three_name, true).c(R.id.iv_first_three_bounce).a(R.id.tv_first_three_rank, "0");
            return;
        }
        baseViewHolder.a(R.id.iv_first_three_avatar, rankHourDataModel.getAvatar(), R.drawable.live_rank_hour_default_avatar, true).a(R.id.tv_first_three_name, (CharSequence) rankHourDataModel.getName()).a(R.id.tv_first_three_name, true).a(R.id.tv_first_three_rank, (CharSequence) String.valueOf(rankHourDataModel.getBonus()));
        if (TextUtils.isEmpty(rankHourDataModel.getAvatar_frame())) {
            baseViewHolder.b(R.id.iv_first_three_avatar_frame, false);
        } else {
            baseViewHolder.a(R.id.iv_first_three_avatar_frame, rankHourDataModel.getAvatar_frame(), rankHourDataModel.getAvatar_frame_type() != 0, -1).b(R.id.iv_first_three_avatar_frame, true);
        }
        if (rankHourDataModel.getLive() == 0) {
            baseViewHolder.c(R.id.rl_first_three_avatar, false).c(R.id.tv_first_three_name, false).c(R.id.iv_first_three_bounce, false).b(R.id.iv_first_three_bounce, false);
            return;
        }
        ImageWrapper g = ImageLoader.c(baseViewHolder.b, "live_rank_hour_bounce.png").e(baseViewHolder.a(R.id.iv_first_three_bounce).hashCode()).g(-1);
        View a = baseViewHolder.a(R.id.iv_first_three_bounce);
        if (a == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
        }
        g.a((ImageView) a);
        View.OnClickListener a2 = a((BaseFragment) baseViewHolder.a.a("BaseFragment", (String) null), rankHourDataModel);
        if (a2 == null) {
            return;
        }
        baseViewHolder.a(R.id.rl_first_three_avatar, a2).a(R.id.tv_first_three_name, a2).a(R.id.iv_first_three_bounce, a2).b(R.id.iv_first_three_bounce, true);
    }

    private final String e() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTimeInMillis((this.e * 1000) - ((long) Grego.MILLIS_PER_HOUR));
        return BlueAppLocal.d() ? new SimpleDateFormat("HH", BlueAppLocal.c()).format(calendar.getTime()) : new SimpleDateFormat("HH", Locale.ENGLISH).format(calendar.getTime());
    }

    private final String f() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTimeInMillis(this.e * 1000);
        return BlueAppLocal.d() ? new SimpleDateFormat("HH", BlueAppLocal.c()).format(calendar.getTime()) : new SimpleDateFormat("HH", Locale.ENGLISH).format(calendar.getTime());
    }

    private final String g() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTimeInMillis((this.e * 1000) + ((long) Grego.MILLIS_PER_HOUR));
        return BlueAppLocal.d() ? new SimpleDateFormat("HH", BlueAppLocal.c()).format(calendar.getTime()) : new SimpleDateFormat("HH", Locale.ENGLISH).format(calendar.getTime());
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_rank_hour_first_three;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b7, code lost:
        if (r0.isEmpty() != false) goto L30;
     */
    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.content.Context r6, com.blued.android.module.common.utils.freedom.BaseViewHolder r7, java.util.List<com.blued.android.module.common.utils.freedom.FreedomItem> r8, int r9) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fitem.FitemRankHourFirstThree.a(android.content.Context, com.blued.android.module.common.utils.freedom.BaseViewHolder, java.util.List, int):void");
    }
}

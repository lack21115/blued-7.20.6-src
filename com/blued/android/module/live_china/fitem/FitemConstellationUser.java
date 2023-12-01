package com.blued.android.module.live_china.fitem;

import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.ConstellationItemDataModel;
import com.blued.android.module.live_china.utils.LiveCloakingUtil;
import com.blued.android.module.live_china.view.BluedViewExKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemConstellationUser.class */
public final class FitemConstellationUser extends FreedomItem {
    private final ConstellationItemDataModel b;
    private final String c;

    public FitemConstellationUser(ConstellationItemDataModel model) {
        Intrinsics.e(model, "model");
        this.b = model;
        this.c = "https://web.bldimg.com/image-manager/1688543781_46784.webp";
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_constellation_user;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        String string;
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        String anchor_avatar = this.b.getAnchor_avatar();
        if (anchor_avatar == null || anchor_avatar.length() == 0) {
            this.b.setAnchor_avatar(this.c);
        }
        String anchor_name = this.b.getAnchor_name();
        if (anchor_name == null || anchor_name.length() == 0) {
            ConstellationItemDataModel constellationItemDataModel = this.b;
            String string2 = context.getString(R.string.live_constellation_empty);
            Intrinsics.c(string2, "context.getString(R.stri…live_constellation_empty)");
            constellationItemDataModel.setAnchor_name(string2);
        }
        String avatar = this.b.getAvatar();
        if (avatar == null || avatar.length() == 0) {
            this.b.setAvatar(this.c);
        }
        String name = this.b.getName();
        if (name == null || name.length() == 0) {
            ConstellationItemDataModel constellationItemDataModel2 = this.b;
            String string3 = context.getString(R.string.live_constellation_empty);
            Intrinsics.c(string3, "context.getString(R.stri…live_constellation_empty)");
            constellationItemDataModel2.setName(string3);
        }
        vh.a(R.id.tv_my_ranking, (CharSequence) (this.b.getRank() < 0 ? "50+" : String.valueOf(this.b.getRank()))).a(R.id.iv_my_anchor_avatar, this.b.getAnchor_avatar(), 0, true, 0.5f, -1).a(R.id.tv_my_anchor_nickname, (CharSequence) this.b.getAnchor_name()).b(R.id.tv_my_anchor_crown, this.b.is_king() == 1).a(R.id.iv_bottom_mvp_avatar, this.b.getAvatar(), 0, true, 0.5f, -1).a(R.id.tv_bottom_mvp_nickname, (CharSequence) LiveCloakingUtil.a(this.b.getName(), this.b.is_hide())).b(R.id.tv_bottom_mvp_crown, this.b.is_king() == 1).a(R.id.tv_constellation_value, (CharSequence) String.valueOf(this.b.getScore())).b(R.id.iv_shade, this.b.is_king() == 1);
        if (this.b.is_king() == 1) {
            vh.a(R.id.iv_shade, "https://web.bldimg.com/image-manager/1688106136_20466.webp");
        }
        TextView tv = (TextView) vh.a(R.id.tv_award_info);
        if (this.b.getRanking() != 1) {
            Intrinsics.c(tv, "tv");
            BluedViewExKt.a(tv);
            return;
        }
        tv.setGravity(this.b.getBonus() <= 0 ? 1 : 5);
        if (this.b.getBonus() <= 0) {
            string = context.getResources().getString(R.string.live_constellation_not_award_bean);
        } else if (this.b.getKing_percent() > 0.0f) {
            Resources resources = context.getResources();
            int i2 = R.string.live_constellation_award_bean_extra;
            int bonus = this.b.getBonus();
            StringBuilder sb = new StringBuilder();
            sb.append(this.b.getPercent());
            sb.append('%');
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.b.getKing_percent());
            sb3.append('%');
            string = resources.getString(i2, String.valueOf(bonus), sb2, sb3.toString());
        } else {
            Resources resources2 = context.getResources();
            int i3 = R.string.live_constellation_award_bean;
            int bonus2 = this.b.getBonus();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(this.b.getPercent());
            sb4.append('%');
            string = resources2.getString(i3, String.valueOf(bonus2), sb4.toString());
        }
        tv.setText(string);
        Intrinsics.c(tv, "tv");
        BluedViewExKt.b(tv);
    }
}

package com.blued.android.module.live_china.fitem;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveFansGroupModel;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemFansGroupPlaying.class */
public class FitemFansGroupPlaying extends FreedomItem {
    public LiveFansGroupModel b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f12532c = false;
    public TextView d;
    public View e;
    public View f;
    public View g;

    public FitemFansGroupPlaying(LiveFansGroupModel liveFansGroupModel) {
        this.b = liveFansGroupModel;
    }

    private void b(BaseViewHolder baseViewHolder) {
        this.f = baseViewHolder.a(R.id.cl_select_border);
        this.g = baseViewHolder.a(R.id.view_select_border_coutent);
        this.f.animate().cancel();
        this.g.animate().cancel();
        if (!this.f12532c) {
            this.f.setScaleX(0.9f);
            this.f.setScaleY(0.9f);
            this.f.setAlpha(0.0f);
            this.g.setScaleX(1.15f);
            this.g.setScaleY(1.15f);
            return;
        }
        this.f.setScaleX(1.0f);
        this.f.setScaleY(1.0f);
        this.f.setAlpha(1.0f);
        this.g.setScaleX(1.0f);
        this.g.setScaleY(1.0f);
        this.g.setAlpha(1.0f);
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_fans_group_playing;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder baseViewHolder, List<FreedomItem> list, int i) {
        BaseViewHolder a2 = baseViewHolder.a(R.id.iv_avatar, this.b.group_cover, R.drawable.user_bg_round, true).a(R.id.tv_title, (CharSequence) this.b.group_title).a(R.id.tv_subtitle, (CharSequence) this.b.group_desc);
        int i2 = R.id.tv_count;
        a2.a(i2, (CharSequence) (this.b.group_now_population + BridgeUtil.SPLIT_MARK + this.b.group_max_population)).b(R.id.tv_already_join, this.b.apply_status == 3).a(R.id.tv_fans_badge, true);
        this.e = baseViewHolder.a(R.id.tv_count);
        this.e = baseViewHolder.a(R.id.tv_already_join);
        this.d = (TextView) baseViewHolder.a(R.id.tv_count);
        b(baseViewHolder);
    }

    public void a(boolean z) {
        this.f12532c = z;
        View view = this.f;
        if (view == null || this.g == null) {
            return;
        }
        if (z && view.getAlpha() != 1.0f) {
            this.f.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(70L).start();
            this.g.animate().scaleX(1.0f).scaleY(1.0f).setDuration(170L).start();
        } else if (z || this.f.getAlpha() == 0.0f) {
        } else {
            this.f.animate().alpha(0.0f).scaleX(0.9f).scaleY(0.9f).setDuration(70L).start();
            this.g.animate().scaleX(1.15f).scaleY(1.15f).setDuration(170L).start();
        }
    }

    public void e() {
        a(false);
        View view = this.e;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void f() {
        LiveFansGroupModel liveFansGroupModel = this.b;
        if (liveFansGroupModel == null) {
            return;
        }
        liveFansGroupModel.group_now_population++;
        TextView textView = this.d;
        if (textView == null) {
            return;
        }
        textView.setText(this.b.group_now_population + BridgeUtil.SPLIT_MARK + this.b.group_max_population);
    }
}

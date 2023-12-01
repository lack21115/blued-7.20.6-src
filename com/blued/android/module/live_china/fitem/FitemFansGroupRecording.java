package com.blued.android.module.live_china.fitem;

import android.content.Context;
import android.view.View;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveFansGroupModel;
import com.blued.android.module.live_china.presenter.LiveFansGroupRecordingPresent;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemFansGroupRecording.class */
public class FitemFansGroupRecording extends FreedomItem {
    public LiveFansGroupModel b;

    /* renamed from: c  reason: collision with root package name */
    public LiveFansGroupRecordingPresent f12533c;

    public FitemFansGroupRecording(LiveFansGroupModel liveFansGroupModel, LiveFansGroupRecordingPresent liveFansGroupRecordingPresent) {
        this.b = liveFansGroupModel;
        this.f12533c = liveFansGroupRecordingPresent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (this.f12533c != null) {
            view.setClickable(false);
            this.f12533c.d(this.b.group_id);
        }
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_fans_group_recording;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder baseViewHolder, List<FreedomItem> list, int i) {
        BaseViewHolder a2 = baseViewHolder.a(R.id.iv_avatar, this.b.group_cover, R.drawable.user_bg_round, true).a(R.id.tv_title, (CharSequence) this.b.group_title).a(R.id.tv_subtitle, (CharSequence) this.b.group_desc);
        int i2 = R.id.tv_count;
        a2.a(i2, (CharSequence) (this.b.group_now_population + BridgeUtil.SPLIT_MARK + this.b.group_max_population)).a(R.id.tv_fans_badge, true);
        if (this.b.upgrade_status == 1) {
            baseViewHolder.c(R.id.tv_upgrade);
            return;
        }
        baseViewHolder.d(R.id.tv_upgrade);
        baseViewHolder.a(R.id.tv_upgrade, new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.-$$Lambda$FitemFansGroupRecording$QbqETtKmT2vOWgEfMpMEngbO6dY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemFansGroupRecording.this.a(view);
            }
        });
    }
}

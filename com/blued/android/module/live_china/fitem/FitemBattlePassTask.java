package com.blued.android.module.live_china.fitem;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.LiveBattleShopDialog;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.BattlePassTaskDataModel;
import com.blued.android.module.live_china.model.LiveRoomFunctionItemModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemBattlePassTask.class */
public final class FitemBattlePassTask extends FreedomItem {
    private final Fragment b;
    private final BattlePassTaskDataModel c;

    public FitemBattlePassTask(Fragment fragment, BattlePassTaskDataModel model) {
        Intrinsics.e(fragment, "fragment");
        Intrinsics.e(model, "model");
        this.b = fragment;
        this.c = model;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemBattlePassTask this$0, BaseViewHolder vh, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(vh, "$vh");
        if (this$0.c.getState() == 1) {
            this$0.b(vh);
        } else if (this$0.c.getState() == 2) {
            this$0.e();
        }
    }

    private final void b(BaseViewHolder baseViewHolder) {
        if (ClickUtils.a(baseViewHolder.a(R.id.iv_btn).getId())) {
            return;
        }
        EventTrackLive.b(LiveProtos.Event.LIVE_BATTLE_PASS_TASK_GO_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), String.valueOf(this.c.getId()));
        LiveEventBusUtil.g();
        BattlePassTaskDataModel battlePassTaskDataModel = this.c;
        if (battlePassTaskDataModel == null) {
            return;
        }
        String action_type = battlePassTaskDataModel.getAction_type();
        if (action_type == null || action_type.length() == 0) {
            return;
        }
        LiveRoomFunctionItemModel liveRoomFunctionItemModel = new LiveRoomFunctionItemModel();
        liveRoomFunctionItemModel.setLink(battlePassTaskDataModel.getAction_type());
        liveRoomFunctionItemModel.setLink_type(3);
        LiveEventBusUtil.a(liveRoomFunctionItemModel);
    }

    private final void e() {
        EventTrackLive.b(LiveProtos.Event.LIVE_BATTLE_PASS_TASK_GET_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), String.valueOf(this.c.getId()));
        LiveBattleShopDialog.a.a(this.b, this.c.getId());
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_battle_pass_task;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, final BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        BaseViewHolder a = vh.a(R.id.tv_exp, (CharSequence) Intrinsics.a("x", (Object) Integer.valueOf(this.c.getExp()))).a(R.id.tv_desc, (CharSequence) this.c.getTask()).a(R.id.tv_current, (CharSequence) String.valueOf(this.c.getCurrent()));
        int i2 = R.id.tv_target;
        a.a(i2, (CharSequence) ('/' + this.c.getTarget() + this.c.getUnit())).a(R.id.tv_exp, true).a(R.id.tv_desc, true).a(R.id.tv_current, true).a(R.id.tv_target, true).a(R.id.iv_btn, new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.-$$Lambda$FitemBattlePassTask$9rckgzN0nQduCeM58hzSHjLixZ4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemBattlePassTask.a(FitemBattlePassTask.this, vh, view);
            }
        });
        int state = this.c.getState();
        if (state == 1) {
            vh.c(R.id.iv_btn, R.drawable.selector_battle_task_go_tasks);
        } else if (state == 2) {
            vh.c(R.id.iv_btn, R.drawable.selector_battle_task_get);
        } else if (state != 3) {
        } else {
            vh.c(R.id.iv_btn, R.drawable.selector_battle_task_finish);
        }
    }
}

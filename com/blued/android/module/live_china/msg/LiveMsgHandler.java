package com.blued.android.module.live_china.msg;

import com.blued.android.module.live_china.fragment.LiveBaseFragment;
import com.blued.android.module.live_china.model.FunctionRedPModelJson;
import com.blued.android.module.live_china.model.LiveAnnounceModel;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveHornModelNew;
import com.blued.android.module.live_china.model.LiveInviteUserModel;
import com.blued.android.module.live_china.model.LiveKickUserModel;
import com.blued.android.module.live_china.model.LivePKProgressModel;
import com.blued.android.module.live_china.model.LivePKResultModel;
import com.blued.android.module.live_china.model.LivePkRoundModel;
import com.blued.android.module.live_china.model.LivePkTypeModel;
import com.blued.android.module.live_china.model.LiveRewardModel;
import com.blued.android.module.live_china.model.LiveRoomTipsModel;
import com.blued.android.module.live_china.model.LiveShakeModel;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/msg/LiveMsgHandler.class */
public abstract class LiveMsgHandler {
    protected LiveBaseFragment d;
    protected boolean e = false;

    public LiveMsgHandler(LiveBaseFragment liveBaseFragment) {
        this.d = liveBaseFragment;
    }

    protected abstract void a(int i, int i2, int i3, float f);

    protected abstract void a(long j, int i);

    protected abstract void a(FunctionRedPModelJson functionRedPModelJson);

    protected abstract void a(LiveAnnounceModel liveAnnounceModel);

    /* JADX WARN: Code restructure failed: missing block: B:200:0x0848, code lost:
        if (android.text.TextUtils.isEmpty(r0.gift_mp4) == false) goto L212;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.blued.android.module.live_china.model.LiveChattingModel r19) {
        /*
            Method dump skipped, instructions count: 4524
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.msg.LiveMsgHandler.a(com.blued.android.module.live_china.model.LiveChattingModel):void");
    }

    protected abstract void a(LiveFriendModel liveFriendModel);

    protected abstract void a(LiveHornModelNew liveHornModelNew, LiveGiftModel liveGiftModel);

    protected abstract void a(LiveInviteUserModel liveInviteUserModel);

    protected abstract void a(LiveKickUserModel liveKickUserModel);

    protected abstract void a(LivePKProgressModel livePKProgressModel);

    protected abstract void a(LivePKResultModel livePKResultModel);

    protected abstract void a(LivePkRoundModel livePkRoundModel);

    protected abstract void a(LivePkTypeModel livePkTypeModel);

    protected abstract void a(LiveRewardModel liveRewardModel);

    protected abstract void a(LiveRoomTipsModel liveRoomTipsModel);

    protected abstract void a(LiveShakeModel liveShakeModel);

    protected abstract void a(String str);

    protected abstract void a(String str, String str2);

    protected abstract void a(List<LiveInviteUserModel> list, LiveInviteUserModel liveInviteUserModel);

    public void b(LiveFriendModel liveFriendModel) {
    }

    protected abstract void b(List<LiveInviteUserModel> list);

    protected abstract void c(LiveFriendModel liveFriendModel);

    protected abstract void c(List<LiveInviteUserModel> list);

    protected abstract void d(List<LiveInviteUserModel> list);

    protected abstract void e(List<LiveInviteUserModel> list);

    public void h() {
    }

    protected abstract void i();

    protected abstract void j();

    protected abstract void k();

    protected abstract void l();
}

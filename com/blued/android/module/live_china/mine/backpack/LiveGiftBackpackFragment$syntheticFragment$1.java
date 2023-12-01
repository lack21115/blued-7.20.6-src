package com.blued.android.module.live_china.mine.backpack;

import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.live_china.mine.LiveGiftFragment;
import com.blued.android.module.live_china.model.LiveSyntheticFragmentSuccessModel;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/backpack/LiveGiftBackpackFragment$syntheticFragment$1.class */
public final class LiveGiftBackpackFragment$syntheticFragment$1 extends BluedUIHttpResponse<BluedEntityA<LiveSyntheticFragmentSuccessModel>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LiveGiftBackpackFragment f13910a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveGiftBackpackFragment$syntheticFragment$1(LiveGiftBackpackFragment liveGiftBackpackFragment, ActivityFragmentActive activityFragmentActive) {
        super(activityFragmentActive);
        this.f13910a = liveGiftBackpackFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGiftBackpackFragment this$0) {
        LiveGiftFragment I;
        Intrinsics.e(this$0, "this$0");
        I = this$0.I();
        if (I == null) {
            return;
        }
        I.ak();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.http.BluedUIHttpResponse
    /* renamed from: a */
    public void onUIUpdate(BluedEntityA<LiveSyntheticFragmentSuccessModel> bluedEntityA) {
        LiveSyntheticFragmentSuccessModel singleData;
        if (bluedEntityA == null || (singleData = bluedEntityA.getSingleData()) == null) {
            return;
        }
        final LiveGiftBackpackFragment liveGiftBackpackFragment = this.f13910a;
        liveGiftBackpackFragment.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$syntheticFragment$1$N2wYRgu6t3sQni_P1qw8S19aTNc
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftBackpackFragment$syntheticFragment$1.a(LiveGiftBackpackFragment.this);
            }
        }, 200L);
        LiveEventBus.get("live_gift_fragment_play_svga", LiveSyntheticFragmentSuccessModel.class).post(singleData);
    }
}

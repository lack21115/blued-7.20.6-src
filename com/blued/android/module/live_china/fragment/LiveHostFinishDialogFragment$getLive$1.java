package com.blued.android.module.live_china.fragment;

import android.content.DialogInterface;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.BluedLiveState;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveHostFinishDialogFragment$getLive$1.class */
public final class LiveHostFinishDialogFragment$getLive$1 extends BluedUIHttpResponse<BluedEntityA<BluedLiveState>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LiveHostFinishDialogFragment f12974a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveHostFinishDialogFragment$getLive$1(LiveHostFinishDialogFragment liveHostFinishDialogFragment, ActivityFragmentActive activityFragmentActive) {
        super(activityFragmentActive);
        this.f12974a = liveHostFinishDialogFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveHostFinishDialogFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.e(this$0, "this$0");
        LiveRoomInfo.a().c(this$0.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.http.BluedUIHttpResponse
    /* renamed from: a */
    public void onUIUpdate(BluedEntityA<BluedLiveState> parseData) {
        Intrinsics.e(parseData, "parseData");
        if (parseData.data == null || parseData.getSingleData() == null) {
            return;
        }
        BluedLiveState singleData = parseData.getSingleData();
        Intrinsics.a(singleData);
        if (singleData.idcard_verify_status == 1 && singleData.has_bankcard == 1) {
            return;
        }
        String string = this.f12974a.getString(R.string.live_apply_improve_title);
        String string2 = this.f12974a.getString(R.string.live_apply_improve_des);
        String string3 = this.f12974a.getString(R.string.live_apply_improve_ok);
        final LiveHostFinishDialogFragment liveHostFinishDialogFragment = this.f12974a;
        CommonAlertDialog.a(this.f12974a.getActivity(), string, string2, string3, new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveHostFinishDialogFragment$getLive$1$bIcZUBymy8nVN9lR6tMgmNLn8Wo
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LiveHostFinishDialogFragment$getLive$1.a(LiveHostFinishDialogFragment.this, dialogInterface, i);
            }
        }, this.f12974a.getString(R.string.live_apply_improve_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }
}

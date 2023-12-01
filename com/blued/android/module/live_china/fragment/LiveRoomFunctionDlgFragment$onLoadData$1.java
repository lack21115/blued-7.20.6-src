package com.blued.android.module.live_china.fragment;

import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.adapter.CommonAdapter;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveRoomFunctionModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRoomFunctionDlgFragment$onLoadData$1.class */
public final class LiveRoomFunctionDlgFragment$onLoadData$1 extends BluedUIHttpResponse<BluedEntityA<LiveRoomFunctionModel>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LiveRoomFunctionDlgFragment f13244a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LiveRoomFunctionDlgFragment$onLoadData$1(LiveRoomFunctionDlgFragment liveRoomFunctionDlgFragment, ActivityFragmentActive activityFragmentActive) {
        super(activityFragmentActive);
        this.f13244a = liveRoomFunctionDlgFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.http.BluedUIHttpResponse
    /* renamed from: a */
    public void onUIUpdate(BluedEntityA<LiveRoomFunctionModel> entity) {
        Intrinsics.e(entity, "entity");
        if (entity.data == null) {
            return;
        }
        LiveRoomFunctionDlgFragment liveRoomFunctionDlgFragment = this.f13244a;
        LiveRoomManager.a().a(liveRoomFunctionDlgFragment.k(), entity.data);
        if (LiveRoomManager.a().d(liveRoomFunctionDlgFragment.k()).size() >= 3) {
            liveRoomFunctionDlgFragment.h().f11971a.getLayoutParams().height = DisplayUtil.a(liveRoomFunctionDlgFragment.getActivity(), 380.0f);
        } else {
            liveRoomFunctionDlgFragment.h().f11971a.getLayoutParams().height = DisplayUtil.a(liveRoomFunctionDlgFragment.getActivity(), 260.0f);
        }
        CommonAdapter<LiveRoomFunctionModel> i = liveRoomFunctionDlgFragment.i();
        if (i == null) {
            return;
        }
        i.a(LiveRoomManager.a().d(liveRoomFunctionDlgFragment.k()));
    }
}

package com.blued.android.module.live_china.manager;

import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.live_china.fragment.LiveBaseFragment;
import com.blued.android.module.live_china.model.LiveRoomOperationDataModel;
import com.blued.android.module.live_china.model.LiveRoomOperationModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.view.operation.LiveBottomOperationView;
import com.blued.android.module.live_china.view.operation.LiveOperationView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/LiveOperationManager.class */
public final class LiveOperationManager {

    /* renamed from: a  reason: collision with root package name */
    private final LiveBaseFragment f13664a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private LiveRoomOperationDataModel f13665c;
    private ArrayList<LiveOperationView> d = new ArrayList<>();
    private ArrayList<LiveBottomOperationView> e = new ArrayList<>();

    public LiveOperationManager(LiveBaseFragment liveBaseFragment, boolean z) {
        this.f13664a = liveBaseFragment;
        this.b = z;
    }

    public final ArrayList<LiveOperationView> a() {
        return this.d;
    }

    public final void a(LiveRoomOperationDataModel liveRoomOperationDataModel) {
        this.f13665c = liveRoomOperationDataModel;
    }

    public final void a(LiveBottomOperationView view) {
        ArrayList<LiveRoomOperationModel> right;
        Intrinsics.e(view, "view");
        this.e.add(view);
        LiveRoomOperationDataModel liveRoomOperationDataModel = this.f13665c;
        if (liveRoomOperationDataModel == null || (right = liveRoomOperationDataModel.getRight()) == null) {
            return;
        }
        view.setData(right);
    }

    public final void a(LiveOperationView view) {
        ArrayList<LiveRoomOperationModel> left;
        Intrinsics.e(view, "view");
        this.d.add(view);
        LiveRoomOperationDataModel liveRoomOperationDataModel = this.f13665c;
        if (liveRoomOperationDataModel == null || (left = liveRoomOperationDataModel.getLeft()) == null) {
            return;
        }
        view.setData(left);
    }

    public final ArrayList<LiveBottomOperationView> b() {
        return this.e;
    }

    public final void c() {
        String e = LiveRoomManager.a().e();
        boolean z = this.b;
        String g = LiveRoomManager.a().g();
        LiveBaseFragment liveBaseFragment = this.f13664a;
        final ActivityFragmentActive fragmentActive = liveBaseFragment == null ? null : liveBaseFragment.getFragmentActive();
        LiveRoomHttpUtils.a(e, z, g, new BluedUIHttpResponse<BluedEntityA<LiveRoomOperationDataModel>>(fragmentActive) { // from class: com.blued.android.module.live_china.manager.LiveOperationManager$getData$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveRoomOperationDataModel> bluedEntity) {
                Intrinsics.e(bluedEntity, "bluedEntity");
                LiveRoomOperationDataModel singleData = bluedEntity.getSingleData();
                if (singleData == null) {
                    return;
                }
                LiveOperationManager liveOperationManager = LiveOperationManager.this;
                liveOperationManager.a(singleData);
                ArrayList<LiveRoomOperationModel> left = singleData.getLeft();
                if (left != null) {
                    for (LiveRoomOperationModel liveRoomOperationModel : left) {
                        liveRoomOperationModel.setCurrent_weight(liveRoomOperationModel.getWeight());
                        liveRoomOperationModel.setGet_countdown_timemillis(System.currentTimeMillis());
                    }
                    for (LiveOperationView liveOperationView : liveOperationManager.a()) {
                        liveOperationView.setData(left);
                    }
                }
                ArrayList<LiveRoomOperationModel> right = singleData.getRight();
                if (right == null) {
                    return;
                }
                for (LiveRoomOperationModel liveRoomOperationModel2 : right) {
                    liveRoomOperationModel2.setCurrent_weight(liveRoomOperationModel2.getWeight());
                }
                for (LiveBottomOperationView liveBottomOperationView : liveOperationManager.b()) {
                    liveBottomOperationView.setData(right);
                }
            }
        });
    }
}

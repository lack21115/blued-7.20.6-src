package com.soft.blued.ui.setting.vm;

import androidx.lifecycle.MutableLiveData;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.android.module.live_china.model.LiveSettingModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/vm/LiveSettingViewModel.class */
public final class LiveSettingViewModel extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    private MutableLiveData<List<LiveSettingModel>> f19960a = new MutableLiveData<>();

    public final void a(int i, int i2, final ActivityFragmentActive activityFragmentActive) {
        Intrinsics.e(activityFragmentActive, "fragmentActive");
        LiveRoomHttpUtils.b(i, i2, new BluedUIHttpResponse<BluedEntityA<LiveSettingModel>>(activityFragmentActive) { // from class: com.soft.blued.ui.setting.vm.LiveSettingViewModel$onSetDataLiveSetting$1

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ActivityFragmentActive f19962a;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super((IRequestHost) activityFragmentActive);
                this.f19962a = activityFragmentActive;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveSettingModel> bluedEntityA) {
                Intrinsics.e(bluedEntityA, "bluedEntity");
            }
        });
    }

    public final void a(final ActivityFragmentActive activityFragmentActive) {
        Intrinsics.e(activityFragmentActive, "fragmentActive");
        LiveRoomHttpUtils.G(new BluedUIHttpResponse<BluedEntityA<LiveSettingModel>>(activityFragmentActive, this) { // from class: com.soft.blued.ui.setting.vm.LiveSettingViewModel$onLoadDataLiveSetting$1

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ActivityFragmentActive f19961a;
            final /* synthetic */ LiveSettingViewModel b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super((IRequestHost) activityFragmentActive);
                this.f19961a = activityFragmentActive;
                this.b = this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveSettingModel> bluedEntityA) {
                Intrinsics.e(bluedEntityA, "bluedEntity");
                if (bluedEntityA.data == null) {
                    return;
                }
                this.b.d().setValue(bluedEntityA.data);
            }
        });
    }

    public final MutableLiveData<List<LiveSettingModel>> d() {
        return this.f19960a;
    }
}

package com.soft.blued.ui.setting.vm;

import androidx.lifecycle.MutableLiveData;
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
    private MutableLiveData<List<LiveSettingModel>> f33651a = new MutableLiveData<>();

    public final void a(int i, int i2, final ActivityFragmentActive fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        LiveRoomHttpUtils.b(i, i2, new BluedUIHttpResponse<BluedEntityA<LiveSettingModel>>() { // from class: com.soft.blued.ui.setting.vm.LiveSettingViewModel$onSetDataLiveSetting$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(ActivityFragmentActive.this);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveSettingModel> bluedEntity) {
                Intrinsics.e(bluedEntity, "bluedEntity");
            }
        });
    }

    public final void a(final ActivityFragmentActive fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        LiveRoomHttpUtils.G(new BluedUIHttpResponse<BluedEntityA<LiveSettingModel>>(this) { // from class: com.soft.blued.ui.setting.vm.LiveSettingViewModel$onLoadDataLiveSetting$1
            final /* synthetic */ LiveSettingViewModel b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(ActivityFragmentActive.this);
                this.b = this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveSettingModel> bluedEntity) {
                Intrinsics.e(bluedEntity, "bluedEntity");
                if (bluedEntity.data == null) {
                    return;
                }
                this.b.d().setValue(bluedEntity.data);
            }
        });
    }

    public final MutableLiveData<List<LiveSettingModel>> d() {
        return this.f33651a;
    }
}

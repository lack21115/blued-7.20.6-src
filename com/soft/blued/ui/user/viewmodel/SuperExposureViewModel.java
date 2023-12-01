package com.soft.blued.ui.user.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.ui.mine.model.SuperExposureModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/viewmodel/SuperExposureViewModel.class */
public final class SuperExposureViewModel extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    private final MutableLiveData<SuperExposureModel> f20663a = new MutableLiveData<>();

    public final BluedUIHttpResponse<?> a(final ActivityFragmentActive activityFragmentActive) {
        Intrinsics.e(activityFragmentActive, "fragmentActive");
        return new BluedUIHttpResponse<BluedEntityA<SuperExposureModel>>(activityFragmentActive, this) { // from class: com.soft.blued.ui.user.viewmodel.SuperExposureViewModel$getCallBack$1

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ActivityFragmentActive f20664a;
            final /* synthetic */ SuperExposureViewModel b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super("SuperExposureModel", (IRequestHost) activityFragmentActive);
                this.f20664a = activityFragmentActive;
                this.b = this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUICache(BluedEntityA<SuperExposureModel> bluedEntityA) {
                super.onUICache((BluedEntity) bluedEntityA);
                this.b.d().setValue(bluedEntityA == null ? null : (SuperExposureModel) bluedEntityA.getSingleData());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: b */
            public void onUIUpdate(BluedEntityA<SuperExposureModel> bluedEntityA) {
                this.b.d().setValue(bluedEntityA == null ? null : (SuperExposureModel) bluedEntityA.getSingleData());
            }

            public void onUIFinish(boolean z) {
                this.b.a(z);
            }
        };
    }

    public final void a(long j, ActivityFragmentActive activityFragmentActive) {
        Intrinsics.e(activityFragmentActive, "fragmentActive");
        PayHttpUtils.a(a(activityFragmentActive), j, (IRequestHost) activityFragmentActive);
    }

    public final MutableLiveData<SuperExposureModel> d() {
        return this.f20663a;
    }
}

package com.soft.blued.ui.user.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
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
    private final MutableLiveData<SuperExposureModel> f34354a = new MutableLiveData<>();

    public final BluedUIHttpResponse<?> a(final ActivityFragmentActive fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        return new BluedUIHttpResponse<BluedEntityA<SuperExposureModel>>(this) { // from class: com.soft.blued.ui.user.viewmodel.SuperExposureViewModel$getCallBack$1
            final /* synthetic */ SuperExposureViewModel b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super("SuperExposureModel", ActivityFragmentActive.this);
                this.b = this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUICache(BluedEntityA<SuperExposureModel> bluedEntityA) {
                super.onUICache(bluedEntityA);
                this.b.d().setValue(bluedEntityA == null ? null : bluedEntityA.getSingleData());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: b */
            public void onUIUpdate(BluedEntityA<SuperExposureModel> bluedEntityA) {
                this.b.d().setValue(bluedEntityA == null ? null : bluedEntityA.getSingleData());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                this.b.a(z);
            }
        };
    }

    public final void a(long j, ActivityFragmentActive fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        PayHttpUtils.a(a(fragmentActive), j, fragmentActive);
    }

    public final MutableLiveData<SuperExposureModel> d() {
        return this.f34354a;
    }
}

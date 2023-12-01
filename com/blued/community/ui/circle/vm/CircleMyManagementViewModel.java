package com.blued.community.ui.circle.vm;

import androidx.lifecycle.MutableLiveData;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.community.http.CircleHttpUtils;
import com.blued.community.ui.circle.model.MyCircleExtra;
import com.blued.community.ui.circle.model.MyCircleModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/vm/CircleMyManagementViewModel.class */
public final class CircleMyManagementViewModel extends BaseViewModel {
    private final MutableLiveData<List<MyCircleModel>> a = new MutableLiveData<>();
    private int b = 1;

    private final void c(final IRequestHost iRequestHost) {
        CircleHttpUtils.b(new BluedUIHttpResponse<BluedEntity<MyCircleModel, MyCircleExtra>>(this) { // from class: com.blued.community.ui.circle.vm.CircleMyManagementViewModel$getData$1
            final /* synthetic */ CircleMyManagementViewModel b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(IRequestHost.this);
                this.b = this;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (!z) {
                    CircleMyManagementViewModel circleMyManagementViewModel = this.b;
                    circleMyManagementViewModel.a(circleMyManagementViewModel.e() - 1);
                }
                this.b.a(z);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<MyCircleModel, MyCircleExtra> bluedEntity) {
                if (bluedEntity == null || !bluedEntity.hasData()) {
                    return;
                }
                this.b.d().setValue(bluedEntity.data);
                this.b.b(bluedEntity.hasMore());
            }
        }, this.b);
    }

    public final void a(int i) {
        this.b = i;
    }

    public final void a(IRequestHost fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        this.b = 1;
        c(fragmentActive);
    }

    public final void b(IRequestHost fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        this.b++;
        c(fragmentActive);
    }

    public final MutableLiveData<List<MyCircleModel>> d() {
        return this.a;
    }

    public final int e() {
        return this.b;
    }
}

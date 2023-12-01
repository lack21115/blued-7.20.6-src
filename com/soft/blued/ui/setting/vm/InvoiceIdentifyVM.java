package com.soft.blued.ui.setting.vm;

import androidx.lifecycle.MutableLiveData;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.soft.blued.http.MineHttpUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/vm/InvoiceIdentifyVM.class */
public final class InvoiceIdentifyVM extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    private IRequestHost f19958a;
    private final MutableLiveData<Boolean> b = new MutableLiveData<>();

    public final void a(String str, String str2) {
        Intrinsics.e(str, "card_name");
        Intrinsics.e(str2, "card_number");
        final IRequestHost iRequestHost = this.f19958a;
        MineHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<Object>>(iRequestHost) { // from class: com.soft.blued.ui.setting.vm.InvoiceIdentifyVM$submitIdentifyInfo$1
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
            }

            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                InvoiceIdentifyVM.this.d().postValue(Boolean.valueOf(z));
            }
        }, str, str2);
    }

    public final MutableLiveData<Boolean> d() {
        return this.b;
    }
}

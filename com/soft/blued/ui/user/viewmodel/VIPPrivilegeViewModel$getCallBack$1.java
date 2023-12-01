package com.soft.blued.ui.user.viewmodel;

import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.soft.blued.ui.mine.model.VIPPrivilegeDataModel;
import kotlin.Metadata;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/viewmodel/VIPPrivilegeViewModel$getCallBack$1.class */
public final class VIPPrivilegeViewModel$getCallBack$1 extends BluedUIHttpResponse<BluedEntityA<VIPPrivilegeDataModel>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VIPPrivilegeViewModel f34361a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.http.BluedUIHttpResponse
    /* renamed from: a */
    public BluedEntityA<VIPPrivilegeDataModel> parseData(String str) {
        return (BluedEntityA) super.parseData(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.http.BluedUIHttpResponse
    /* renamed from: a */
    public void onUICache(BluedEntityA<VIPPrivilegeDataModel> bluedEntityA) {
        super.onUICache(bluedEntityA);
        this.f34361a.d().setValue(bluedEntityA == null ? null : bluedEntityA.getSingleData());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.http.BluedUIHttpResponse
    /* renamed from: b */
    public void onUIUpdate(BluedEntityA<VIPPrivilegeDataModel> bluedEntityA) {
        this.f34361a.d().setValue(bluedEntityA == null ? null : bluedEntityA.getSingleData());
    }

    @Override // com.blued.android.framework.http.BluedUIHttpResponse
    public void onUIFinish(boolean z) {
        this.f34361a.a(z);
    }
}

package com.soft.blued.ui.user.viewmodel;

import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.soft.blued.ui.mine.model.VIPPrivilegeDataModel;
import kotlin.Metadata;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/viewmodel/VIPPrivilegeViewModel$getCallBack$1.class */
public final class VIPPrivilegeViewModel$getCallBack$1 extends BluedUIHttpResponse<BluedEntityA<VIPPrivilegeDataModel>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VIPPrivilegeViewModel f20670a;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public BluedEntityA<VIPPrivilegeDataModel> parseData(String str) {
        return super.parseData(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void onUICache(BluedEntityA<VIPPrivilegeDataModel> bluedEntityA) {
        super.onUICache((BluedEntity) bluedEntityA);
        this.f20670a.d().setValue(bluedEntityA == null ? null : (VIPPrivilegeDataModel) bluedEntityA.getSingleData());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void onUIUpdate(BluedEntityA<VIPPrivilegeDataModel> bluedEntityA) {
        this.f20670a.d().setValue(bluedEntityA == null ? null : (VIPPrivilegeDataModel) bluedEntityA.getSingleData());
    }

    public void onUIFinish(boolean z) {
        this.f20670a.a(z);
    }
}

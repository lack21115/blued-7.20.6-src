package com.blued.android.module.yy_china.model;

import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.yy_china.model.ClientSendMessTaskModel;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/ClientSendMessTaskNewModel$loadTask$1.class */
public final class ClientSendMessTaskNewModel$loadTask$1 extends BluedUIHttpResponse<BluedEntityA<YYDailyTaskModel>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivityFragmentActive f17610a;
    final /* synthetic */ ClientSendMessTaskNewModel b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClientSendMessTaskNewModel$loadTask$1(ActivityFragmentActive activityFragmentActive, ClientSendMessTaskNewModel clientSendMessTaskNewModel) {
        super(activityFragmentActive);
        this.f17610a = activityFragmentActive;
        this.b = clientSendMessTaskNewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a() {
        ClientSendMessTaskModel.ClientTaskDataListener a2 = ClientSendMessTaskNewModel.Companion.a();
        if (a2 == null) {
            return;
        }
        a2.a(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.http.BluedUIHttpResponse
    /* renamed from: a */
    public void onUIUpdate(BluedEntityA<YYDailyTaskModel> bluedEntityA) {
        if (bluedEntityA == null) {
            return;
        }
        if (bluedEntityA.getSingleData() == null) {
            ClientSendMessTaskModel.ClientTaskDataListener a2 = ClientSendMessTaskNewModel.Companion.a();
            if (a2 == null) {
                return;
            }
            a2.a(bluedEntityA.getSingleData());
            return;
        }
        ClientSendMessTaskModel.ClientTaskDataListener a3 = ClientSendMessTaskNewModel.Companion.a();
        if (a3 != null) {
            a3.a(bluedEntityA.getSingleData());
        }
        if (this.b.getAllTsak().size() == 0 || (this.b.getAllTsak().size() > 0 && this.b.getAllTsak().get(0).getEndTime() != bluedEntityA.getSingleData().getEnd_time())) {
            this.b.getAllTsak().clear();
            ArrayList<ClientSendMessTaskItemModel> allTsak = this.b.getAllTsak();
            YYDailyTaskModel singleData = bluedEntityA.getSingleData();
            Intrinsics.c(singleData, "result.singleData");
            allTsak.add(new ClientSendMessTaskItemModel(singleData));
        } else {
            ClientSendMessTaskItemModel clientSendMessTaskItemModel = this.b.getAllTsak().get(0);
            YYDailyTaskModel singleData2 = bluedEntityA.getSingleData();
            Intrinsics.c(singleData2, "result.singleData");
            clientSendMessTaskItemModel.setTaskInfo(singleData2);
        }
        this.b.setTaskStatus(1);
        ArrayList<ClientSendMessTaskItemModel> allTsak2 = this.b.getAllTsak();
        ClientSendMessTaskNewModel clientSendMessTaskNewModel = this.b;
        for (ClientSendMessTaskItemModel clientSendMessTaskItemModel2 : allTsak2) {
            Iterator<ClientSendMessageInfoDataModel> it = clientSendMessTaskNewModel.getLoadRoom().iterator();
            while (it.hasNext()) {
                ClientSendMessageInfoDataModel one = it.next();
                long time = one.getTime();
                Intrinsics.c(one, "one");
                clientSendMessTaskItemModel2.addMessage(time, one);
            }
        }
        this.b.getLoadRoom().clear();
    }

    @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
    public void onFailure(Throwable th) {
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.yy_china.model.-$$Lambda$ClientSendMessTaskNewModel$loadTask$1$F2PBUlWdsCv4viPay-9pYLF2MVk
            @Override // java.lang.Runnable
            public final void run() {
                ClientSendMessTaskNewModel$loadTask$1.a();
            }
        });
    }
}

package com.blued.android.module.yy_china.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/ClientSendMessTaskItemListModel.class */
public final class ClientSendMessTaskItemListModel {
    private final ArrayList<ClientSendMessTaskItemModel> data;

    public ClientSendMessTaskItemListModel(ArrayList<ClientSendMessTaskItemModel> data) {
        Intrinsics.e(data, "data");
        this.data = data;
    }

    public static /* synthetic */ ClientSendMessTaskItemListModel copy$default(ClientSendMessTaskItemListModel clientSendMessTaskItemListModel, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = clientSendMessTaskItemListModel.data;
        }
        return clientSendMessTaskItemListModel.copy(arrayList);
    }

    public final ArrayList<ClientSendMessTaskItemModel> component1() {
        return this.data;
    }

    public final ClientSendMessTaskItemListModel copy(ArrayList<ClientSendMessTaskItemModel> data) {
        Intrinsics.e(data, "data");
        return new ClientSendMessTaskItemListModel(data);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ClientSendMessTaskItemListModel) && Intrinsics.a(this.data, ((ClientSendMessTaskItemListModel) obj).data);
    }

    public final ArrayList<ClientSendMessTaskItemModel> getData() {
        return this.data;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return "ClientSendMessTaskItemListModel(data=" + this.data + ')';
    }
}

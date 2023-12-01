package com.blued.android.module.yy_china.model;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.module.common.utils.BluedSharedPreferences;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.ClientSendMessTaskModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/ClientSendMessTaskNewModel.class */
public final class ClientSendMessTaskNewModel {
    public static final Companion Companion = new Companion(null);
    private static ClientSendMessTaskModel.ClientTaskDataListener li;
    private final String SP_DATA_KEY = "ClientSendMessTaskNewModel1";
    private final ArrayList<ClientSendMessTaskItemModel> allTsak = new ArrayList<>();
    private int taskStatus = -1;
    private final ArrayList<ClientSendMessageInfoDataModel> loadRoom = new ArrayList<>();

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/ClientSendMessTaskNewModel$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ClientSendMessTaskModel.ClientTaskDataListener a() {
            return ClientSendMessTaskNewModel.li;
        }

        public final ClientSendMessTaskNewModel a(ClientSendMessTaskModel.ClientTaskDataListener listener, ActivityFragmentActive requestActive) {
            Intrinsics.e(listener, "listener");
            Intrinsics.e(requestActive, "requestActive");
            a(listener);
            ClientSendMessTaskNewModel clientSendMessTaskNewModel = new ClientSendMessTaskNewModel();
            clientSendMessTaskNewModel.loadData(requestActive);
            return clientSendMessTaskNewModel;
        }

        public final void a(ClientSendMessTaskModel.ClientTaskDataListener clientTaskDataListener) {
            ClientSendMessTaskNewModel.li = clientTaskDataListener;
        }
    }

    private final void loadTask(ActivityFragmentActive activityFragmentActive) {
        this.taskStatus = 0;
        YYRoomHttpUtils.b((BluedUIHttpResponse) new ClientSendMessTaskNewModel$loadTask$1(activityFragmentActive, this), activityFragmentActive);
    }

    public final void addMessage(long j, ActivityFragmentActive requestActive) {
        Intrinsics.e(requestActive, "requestActive");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        String str = b.room_id;
        Intrinsics.c(str, "roomModel.room_id");
        String str2 = b.type_id;
        Intrinsics.c(str2, "roomModel.type_id");
        addMessage(j, new ClientSendMessageInfoDataModel(str, str2, j), requestActive);
    }

    public final void addMessage(long j, ClientSendMessageInfoDataModel me2, ActivityFragmentActive requestActive) {
        Intrinsics.e(me2, "me");
        Intrinsics.e(requestActive, "requestActive");
        boolean z = true;
        if (this.taskStatus >= 1) {
            int i = 0;
            z = false;
            for (ClientSendMessTaskItemModel clientSendMessTaskItemModel : this.allTsak) {
                int addMessage = clientSendMessTaskItemModel.addMessage(j, me2);
                int i2 = i;
                if (addMessage == -1) {
                    i2 = i + 1;
                }
                i = i2;
                if (addMessage != 0) {
                    z = true;
                    i = i2;
                }
            }
            if (i > 0) {
                this.taskStatus = 0;
                loadTask(requestActive);
            }
        } else {
            this.loadRoom.add(me2);
        }
        if (z) {
            String json = AppInfo.f().toJson(new ClientSendMessTaskItemListModel(this.allTsak));
            BluedSharedPreferences a = BluedSharedPreferences.a(this.SP_DATA_KEY);
            Intrinsics.c(a, "getSharedPreferences(SP_DATA_KEY)");
            new BluedSharedPreferences.Editor().a(YYRoomInfoManager.e().k(), json);
        }
    }

    public final ArrayList<ClientSendMessTaskItemModel> getAllTsak() {
        return this.allTsak;
    }

    public final ArrayList<ClientSendMessageInfoDataModel> getLoadRoom() {
        return this.loadRoom;
    }

    public final String getSP_DATA_KEY() {
        return this.SP_DATA_KEY;
    }

    public final int getTaskStatus() {
        return this.taskStatus;
    }

    public final void loadData(ActivityFragmentActive requestActive) {
        Intrinsics.e(requestActive, "requestActive");
        String a = BluedSharedPreferences.a(this.SP_DATA_KEY).a(YYRoomInfoManager.e().k(), "");
        if (!TextUtils.isEmpty(a)) {
            this.allTsak.addAll(((ClientSendMessTaskItemListModel) AppInfo.f().fromJson(a, ClientSendMessTaskItemListModel.class)).getData());
        }
        loadTask(requestActive);
    }

    public final void setTaskStatus(int i) {
        this.taskStatus = i;
    }
}

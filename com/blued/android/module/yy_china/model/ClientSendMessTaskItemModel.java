package com.blued.android.module.yy_china.model;

import androidx.collection.ArrayMap;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/ClientSendMessTaskItemModel.class */
public final class ClientSendMessTaskItemModel {
    private long endTime;
    private final ArrayList<ClientSendMessageInfoDataModel> messAll;
    private final ArrayMap<String, ClientSendMessageInfoDataModel> messRoom;
    private long startTime;
    private YYDailyTaskModel taskInfo;

    public ClientSendMessTaskItemModel(YYDailyTaskModel data) {
        Intrinsics.e(data, "data");
        this.startTime = data.getStart_time();
        this.endTime = data.getEnd_time();
        if (data.getStatus() == 1) {
            this.startTime = -1L;
        }
        this.taskInfo = data;
        this.messAll = new ArrayList<>();
        this.messRoom = new ArrayMap<>();
    }

    public final int addMessage(long j, ClientSendMessageInfoDataModel me2) {
        Intrinsics.e(me2, "me");
        long j2 = this.endTime;
        if (j > j2) {
            return -1;
        }
        if (this.startTime >= 0 || j >= j2) {
            if ("speak_amount".equals(this.taskInfo.getItem())) {
                if (this.taskInfo.getAppoint() == null || this.taskInfo.getAppoint().size() <= 0) {
                    this.messAll.add(me2);
                } else {
                    for (String str : this.taskInfo.getAppoint()) {
                        if (Intrinsics.a((Object) me2.getRoomType(), (Object) str)) {
                            getMessAll().add(me2);
                        }
                    }
                }
                if (this.messAll.size() >= this.taskInfo.getCondition()) {
                    YYRoomHttpUtils.m(String.valueOf(j), (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYTaskModel>>() { // from class: com.blued.android.module.yy_china.model.ClientSendMessTaskItemModel$addMessage$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(null);
                        }

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.blued.android.framework.http.BluedUIHttpResponse
                        /* renamed from: a */
                        public void onUIUpdate(BluedEntityA<YYTaskModel> bluedEntityA) {
                            ClientSendMessTaskItemModel.this.setStartTime(-1L);
                        }
                    }, (ActivityFragmentActive) null);
                    return 1;
                }
                return 1;
            }
            if (this.taskInfo.getAppoint() == null || this.taskInfo.getAppoint().size() <= 0) {
                this.messRoom.put(me2.getRoomId(), me2);
            } else {
                for (String str2 : this.taskInfo.getAppoint()) {
                    if (Intrinsics.a((Object) me2.getRoomType(), (Object) str2)) {
                        getMessRoom().put(me2.getRoomId(), me2);
                    }
                }
            }
            if (this.messRoom.size() >= this.taskInfo.getCondition()) {
                YYRoomHttpUtils.m(String.valueOf(j), (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYTaskModel>>() { // from class: com.blued.android.module.yy_china.model.ClientSendMessTaskItemModel$addMessage$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(null);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    /* renamed from: a */
                    public void onUIUpdate(BluedEntityA<YYTaskModel> bluedEntityA) {
                        ClientSendMessTaskItemModel.this.setStartTime(-1L);
                    }
                }, (ActivityFragmentActive) null);
                return 1;
            }
            return 1;
        }
        return 0;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final ArrayList<ClientSendMessageInfoDataModel> getMessAll() {
        return this.messAll;
    }

    public final ArrayMap<String, ClientSendMessageInfoDataModel> getMessRoom() {
        return this.messRoom;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final YYDailyTaskModel getTaskInfo() {
        return this.taskInfo;
    }

    public final void setEndTime(long j) {
        this.endTime = j;
    }

    public final void setStartTime(long j) {
        this.startTime = j;
    }

    public final void setTaskInfo(YYDailyTaskModel yYDailyTaskModel) {
        Intrinsics.e(yYDailyTaskModel, "<set-?>");
        this.taskInfo = yYDailyTaskModel;
    }
}

package com.blued.android.module.yy_china.model;

import androidx.collection.ArrayMap;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.BluedSharedPreferences;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.ClientSendMessTaskModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/ClientSendMessTaskModel.class */
public final class ClientSendMessTaskModel {
    public static final Companion Companion = new Companion(null);
    private static ClientTaskDataListener li;
    private long endTime;
    private long startTime;
    private final String SP_DATA_KEY = "ClientSendMessTaskMode";
    private final ArrayList<YYDailyTaskModel> allTsak = new ArrayList<>();
    private final ArrayList<ClientSendMessageInfoDataModel> allRoom = new ArrayList<>();
    private final ArrayMap<String, android.util.ArrayMap<String, ClientSendMessageInfoDataModel>> difRoom = new ArrayMap<>();
    private final ArrayMap<String, ArrayList<ClientSendMessageInfoDataModel>> typeRoom = new ArrayMap<>();

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/ClientSendMessTaskModel$ClientTaskDataListener.class */
    public interface ClientTaskDataListener {
        void a(YYDailyTaskModel yYDailyTaskModel);
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/ClientSendMessTaskModel$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ClientTaskDataListener a() {
            return ClientSendMessTaskModel.li;
        }
    }

    public final void addMessage(long j) {
        YYRoomModel b;
        if ((this.startTime >= 0 || j >= this.endTime) && (b = YYRoomInfoManager.e().b()) != null) {
            String str = b.room_id;
            Intrinsics.c(str, "roomModel.room_id");
            String str2 = b.room_type;
            Intrinsics.c(str2, "roomModel.room_type");
            ClientSendMessageInfoDataModel clientSendMessageInfoDataModel = new ClientSendMessageInfoDataModel(str, str2, j);
            this.allRoom.add(clientSendMessageInfoDataModel);
            android.util.ArrayMap arrayMap = (android.util.ArrayMap) this.difRoom.get(b.type_id);
            android.util.ArrayMap arrayMap2 = arrayMap;
            if (arrayMap == null) {
                arrayMap2 = new android.util.ArrayMap();
                this.difRoom.put(b.type_id, arrayMap2);
            }
            arrayMap2.put(b.room_id, clientSendMessageInfoDataModel);
            ArrayList arrayList = (ArrayList) this.typeRoom.get(b.type_id);
            ArrayList arrayList2 = arrayList;
            if (arrayList == null) {
                arrayList2 = new ArrayList();
                this.typeRoom.put(b.type_id, arrayList2);
            }
            arrayList2.add(clientSendMessageInfoDataModel);
            if (j > this.endTime) {
                loadTask();
            } else {
                checkTask(String.valueOf(j));
            }
            String json = AppInfo.f().toJson(this);
            BluedSharedPreferences a = BluedSharedPreferences.a(this.SP_DATA_KEY);
            Intrinsics.c(a, "getSharedPreferences(SP_DATA_KEY)");
            new BluedSharedPreferences.Editor().a(YYRoomInfoManager.e().k(), json);
        }
    }

    public final void checkTask(String time) {
        boolean z;
        int i;
        int i2;
        Intrinsics.e(time, "time");
        for (YYDailyTaskModel yYDailyTaskModel : this.allTsak) {
            if ("speak_amount".equals(yYDailyTaskModel.getItem())) {
                if (yYDailyTaskModel.getAppoint() == null || yYDailyTaskModel.getAppoint().size() <= 0) {
                    if (getAllRoom().size() >= yYDailyTaskModel.getCondition()) {
                        z = true;
                    }
                    z = false;
                } else {
                    Iterator<String> it = yYDailyTaskModel.getAppoint().iterator();
                    int i3 = 0;
                    while (true) {
                        i2 = i3;
                        if (!it.hasNext()) {
                            break;
                        }
                        ArrayList arrayList = (ArrayList) getTypeRoom().get(it.next());
                        i3 = arrayList == null ? i2 + 0 : i2 + arrayList.size();
                    }
                    if (i2 >= yYDailyTaskModel.getCondition()) {
                        z = true;
                    }
                    z = false;
                }
            } else if (yYDailyTaskModel.getAppoint() == null || yYDailyTaskModel.getAppoint().size() <= 0) {
                Iterator it2 = getDifRoom().entrySet().iterator();
                it2.hasNext();
                if (((android.util.ArrayMap) ((Map.Entry) it2.next()).getValue()).size() + 0 >= yYDailyTaskModel.getCondition()) {
                    z = true;
                }
                z = false;
            } else {
                Iterator<String> it3 = yYDailyTaskModel.getAppoint().iterator();
                int i4 = 0;
                while (true) {
                    i = i4;
                    if (!it3.hasNext()) {
                        break;
                    }
                    android.util.ArrayMap arrayMap = (android.util.ArrayMap) getDifRoom().get(it3.next());
                    i4 = arrayMap == null ? i + 0 : i + arrayMap.size();
                }
                if (i >= yYDailyTaskModel.getCondition()) {
                    z = true;
                }
                z = false;
            }
            if (z) {
                YYRoomHttpUtils.m(time, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYTaskModel>>() { // from class: com.blued.android.module.yy_china.model.ClientSendMessTaskModel$checkTask$1$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(null);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    /* renamed from: a */
                    public void onUIUpdate(BluedEntityA<YYTaskModel> bluedEntityA) {
                        ClientSendMessTaskModel.this.setStartTime(-1L);
                    }
                }, (ActivityFragmentActive) null);
            }
        }
    }

    public final void clearOldMessData(final long j) {
        CollectionsKt.a((List) this.allRoom, (Function1) new Function1<ClientSendMessageInfoDataModel, Boolean>() { // from class: com.blued.android.module.yy_china.model.ClientSendMessTaskModel$clearOldMessData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final Boolean invoke(ClientSendMessageInfoDataModel it) {
                Intrinsics.e(it, "it");
                return Boolean.valueOf(it.getTime() < j);
            }
        });
        for (Map.Entry entry : this.difRoom.entrySet()) {
            Object value = entry.getValue();
            Intrinsics.c(value, "next.value");
            Iterator it = ((Map) value).entrySet().iterator();
            while (it.hasNext() && ((ClientSendMessageInfoDataModel) ((Map.Entry) it.next()).getValue()).getTime() < j) {
                it.remove();
            }
        }
        for (Map.Entry entry2 : this.typeRoom.entrySet()) {
            Object value2 = entry2.getValue();
            Intrinsics.c(value2, "next.value");
            CollectionsKt.a((List) value2, (Function1) new Function1<ClientSendMessageInfoDataModel, Boolean>() { // from class: com.blued.android.module.yy_china.model.ClientSendMessTaskModel$clearOldMessData$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: a */
                public final Boolean invoke(ClientSendMessageInfoDataModel it2) {
                    Intrinsics.e(it2, "it");
                    return Boolean.valueOf(it2.getTime() < j);
                }
            });
        }
        String json = AppInfo.f().toJson(this);
        BluedSharedPreferences a = BluedSharedPreferences.a(this.SP_DATA_KEY);
        Intrinsics.c(a, "getSharedPreferences(SP_DATA_KEY)");
        new BluedSharedPreferences.Editor().a(YYRoomInfoManager.e().k(), json);
    }

    public final ArrayList<ClientSendMessageInfoDataModel> getAllRoom() {
        return this.allRoom;
    }

    public final ArrayList<YYDailyTaskModel> getAllTsak() {
        return this.allTsak;
    }

    public final ArrayMap<String, android.util.ArrayMap<String, ClientSendMessageInfoDataModel>> getDifRoom() {
        return this.difRoom;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final String getSP_DATA_KEY() {
        return this.SP_DATA_KEY;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final ArrayMap<String, ArrayList<ClientSendMessageInfoDataModel>> getTypeRoom() {
        return this.typeRoom;
    }

    public final void loadData() {
        String a = BluedSharedPreferences.a(this.SP_DATA_KEY).a(YYRoomInfoManager.e().k(), "");
        if (!"".equals(a)) {
            ClientSendMessTaskModel clientSendMessTaskModel = (ClientSendMessTaskModel) AppInfo.f().fromJson(a, ClientSendMessTaskModel.class);
            this.allRoom.addAll(clientSendMessTaskModel.allRoom);
            this.difRoom.putAll(MapsKt.c(clientSendMessTaskModel.difRoom));
            this.typeRoom.putAll(MapsKt.c(clientSendMessTaskModel.typeRoom));
        }
        loadTask();
    }

    public final void loadTask() {
        YYRoomHttpUtils.b((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYDailyTaskModel>>() { // from class: com.blued.android.module.yy_china.model.ClientSendMessTaskModel$loadTask$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYDailyTaskModel> bluedEntityA) {
                if (bluedEntityA == null) {
                    return;
                }
                ClientSendMessTaskModel.this.getAllTsak().addAll(bluedEntityA.data);
                if (bluedEntityA.getSingleData() != null) {
                    ClientSendMessTaskModel.ClientTaskDataListener a = ClientSendMessTaskModel.Companion.a();
                    if (a != null) {
                        a.a(bluedEntityA.getSingleData());
                    }
                    if (bluedEntityA.getSingleData().getStatus() == 1) {
                        ClientSendMessTaskModel.this.setStartTime(-1L);
                        ClientSendMessTaskModel.this.setEndTime(bluedEntityA.getSingleData().getEnd_time());
                        return;
                    }
                    ClientSendMessTaskModel.this.setStartTime(bluedEntityA.getSingleData().getStart_time());
                    ClientSendMessTaskModel.this.setEndTime(bluedEntityA.getSingleData().getEnd_time());
                    ClientSendMessTaskModel clientSendMessTaskModel = ClientSendMessTaskModel.this;
                    clientSendMessTaskModel.clearOldMessData(clientSendMessTaskModel.getStartTime());
                    ClientSendMessTaskModel.this.checkTask(String.valueOf(System.currentTimeMillis() / 1000));
                }
            }
        }, (ActivityFragmentActive) null);
    }

    public final void setEndTime(long j) {
        this.endTime = j;
    }

    public final void setStartTime(long j) {
        this.startTime = j;
    }
}

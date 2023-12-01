package com.soft.blued.ui.msg.viewModel;

import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.base.mvi.BaseListViewModel;
import com.soft.blued.ui.msg.model.ServiceMsgModel;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/viewModel/ServiceMsgViewModel.class */
public final class ServiceMsgViewModel extends BaseListViewModel<ServiceMsgModel> {
    private ChattingModel b;

    /* renamed from: a  reason: collision with root package name */
    private List<ChattingModel> f18926a = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private String f18927c = "";
    private MutableLiveData<Boolean> d = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ServiceMsgViewModel serviceMsgViewModel) {
        Intrinsics.e(serviceMsgViewModel, "this$0");
        List<ChattingModel> list = serviceMsgViewModel.f18926a;
        serviceMsgViewModel.a(list, list.size() == serviceMsgViewModel.getMPageSize());
        if (!serviceMsgViewModel.f18926a.isEmpty()) {
            List<ChattingModel> list2 = serviceMsgViewModel.f18926a;
            serviceMsgViewModel.b = list2.get(list2.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final ServiceMsgViewModel serviceMsgViewModel, List list) {
        Intrinsics.e(serviceMsgViewModel, "this$0");
        if (list == null) {
            return;
        }
        serviceMsgViewModel.a().clear();
        List<ChattingModel> a2 = serviceMsgViewModel.a();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            ChattingModel chattingModel = (ChattingModel) obj;
            if (chattingModel.msgType != 1 ? chattingModel.msgType == 68 : true) {
                arrayList.add(obj);
            }
        }
        a2.addAll(arrayList);
        AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.msg.viewModel.-$$Lambda$ServiceMsgViewModel$8NZyUTI_w9ZP1BvgqOfiocVi6p0
            @Override // java.lang.Runnable
            public final void run() {
                ServiceMsgViewModel.a(ServiceMsgViewModel.this);
            }
        });
    }

    private final ServiceMsgModel b(ChattingModel chattingModel) {
        ServiceMsgModel serviceMsgModel = new ServiceMsgModel();
        serviceMsgModel.dbId = chattingModel.dbId;
        serviceMsgModel.fromId = chattingModel.fromId;
        serviceMsgModel.toId = chattingModel.toId;
        serviceMsgModel.fromNickName = chattingModel.fromNickName;
        serviceMsgModel.fromAvatar = chattingModel.fromAvatar;
        serviceMsgModel.fromDistance = chattingModel.fromDistance;
        serviceMsgModel.fromVBadge = chattingModel.fromVBadge;
        serviceMsgModel.fromOnline = chattingModel.fromOnline;
        serviceMsgModel.fromVipGrade = chattingModel.fromVipGrade;
        serviceMsgModel.fromVipAnnual = chattingModel.fromVipAnnual;
        serviceMsgModel.fromVipExpLvl = chattingModel.fromVipExpLvl;
        serviceMsgModel.fromHideVipLook = chattingModel.fromHideVipLook;
        serviceMsgModel.setMsgExtra(chattingModel.getMsgExtra());
        serviceMsgModel.sessionId = chattingModel.sessionId;
        serviceMsgModel.sessionType = chattingModel.sessionType;
        serviceMsgModel.msgPreviousId = chattingModel.msgPreviousId;
        serviceMsgModel.msgIsDelete = chattingModel.msgIsDelete;
        serviceMsgModel.msgContent = chattingModel.msgContent;
        serviceMsgModel.msgTimestamp = chattingModel.msgTimestamp;
        serviceMsgModel.msgLocalId = chattingModel.msgLocalId;
        serviceMsgModel.msgId = chattingModel.msgId;
        serviceMsgModel.msgType = chattingModel.msgType;
        serviceMsgModel.app = chattingModel.app;
        serviceMsgModel.msgStateCode = chattingModel.msgStateCode;
        serviceMsgModel.msgVideoCoverUrlLocal = chattingModel.msgVideoCoverUrlLocal;
        serviceMsgModel.msgTextTranslateIsShow = chattingModel.msgTextTranslateIsShow;
        serviceMsgModel.msgTextTranslateContent = chattingModel.msgTextTranslateContent;
        serviceMsgModel.msgTextTranslateStatus = chattingModel.msgTextTranslateStatus;
        return serviceMsgModel;
    }

    public final List<ChattingModel> a() {
        return this.f18926a;
    }

    public final void a(ChattingModel chattingModel) {
        this.b = chattingModel;
    }

    public final void a(List<ChattingModel> list, boolean z) {
        Intrinsics.e(list, "serviceMsgList");
        if (list.size() > 0) {
            List<ChattingModel> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.a(list2, 10));
            for (ChattingModel chattingModel : list2) {
                arrayList.add(b(chattingModel));
            }
            List c2 = CollectionsKt.c(CollectionsKt.j(arrayList));
            ChattingModel b = b();
            if (b != null && c2.contains(b(b))) {
                c2.remove(b(b));
            }
            loadListSucceed(c2, z);
        } else {
            loadListSucceed(new ArrayList(), z);
        }
        boolean z2 = true;
        c().setValue(Boolean.valueOf((list.size() <= 1 || !BluedPreferences.eQ()) ? false : false));
        Log.e("lyl", Intrinsics.a("size  >>>>   ", Integer.valueOf(list.size())));
    }

    public final ChattingModel b() {
        return this.b;
    }

    public final MutableLiveData<Boolean> c() {
        return this.d;
    }

    public void init(Bundle bundle) {
        super.init(bundle);
        String obj = BluedConfig.a().b().official_account.toString();
        if (obj.length() > 0) {
            String substring = obj.substring(1, obj.length() - 1);
            Intrinsics.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            this.f18927c = substring;
        }
        Log.e("LiangYunLong", obj);
    }

    public void refreshData() {
        this.b = null;
        super.refreshData();
    }

    public void requestData() {
        ChatManager.getInstance().loadServiceSessionMsgList((short) 2, this.f18927c, this.b, getMPageSize(), new FetchDataListener() { // from class: com.soft.blued.ui.msg.viewModel.-$$Lambda$ServiceMsgViewModel$HU2ls_Tj13OlXIXooLKCUbWN9ys
            public final void onFetchData(Object obj) {
                ServiceMsgViewModel.a(ServiceMsgViewModel.this, (List) obj);
            }
        });
    }
}

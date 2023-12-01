package com.blued.android.module.live_china.view_model;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveFirstChargeInfo;
import com.blued.android.module.live_china.model.LiveLiangModel;
import com.blued.android.module.live_china.model.LiveTabInfo;
import com.blued.android.module.live_china.model.LiveTabModel;
import com.blued.android.module.live_china.model.MultiDialogModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view_model/LiveMainViewModel.class */
public final class LiveMainViewModel extends BaseViewModel {
    private final MutableLiveData<LiveTabInfo> a = new MutableLiveData<>();
    private final MutableLiveData<List<LiveLiangModel>> b = new MutableLiveData<>();
    private final MutableLiveData<MultiDialogModel> c = new MutableLiveData<>();
    private final MutableLiveData<Integer> d = new MutableLiveData<>();
    private String e = "";
    private int f;
    private LiveTabInfo g;

    private final void e(final IRequestHost iRequestHost) {
        LiveRoomHttpUtils.u(new BluedUIHttpResponse<BluedEntity<LiveTabModel, LiveTabModel>>(this) { // from class: com.blued.android.module.live_china.view_model.LiveMainViewModel$getTabs$1
            final /* synthetic */ LiveMainViewModel b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(IRequestHost.this);
                this.b = this;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                this.b.i();
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveTabModel, LiveTabModel> parseData) {
                Intrinsics.e(parseData, "parseData");
                if (parseData.data != null) {
                    LiveTabInfo liveTabInfo = new LiveTabInfo();
                    List<LiveTabModel> list = liveTabInfo.liveTabs;
                    List<LiveTabModel> list2 = parseData.data;
                    Intrinsics.c(list2, "parseData.data");
                    list.addAll(list2);
                    this.b.g = liveTabInfo;
                }
                this.b.i();
            }
        }, iRequestHost);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        if (this.g == null) {
            this.g = new LiveTabInfo();
        }
        LiveTabInfo liveTabInfo = this.g;
        Intrinsics.a(liveTabInfo);
        if (liveTabInfo.liveTabs == null) {
            ArrayList arrayList = new ArrayList();
            LiveTabInfo liveTabInfo2 = this.g;
            Intrinsics.a(liveTabInfo2);
            liveTabInfo2.liveTabs = arrayList;
        }
        LiveTabInfo liveTabInfo3 = this.g;
        Intrinsics.a(liveTabInfo3);
        List<LiveTabModel> list = liveTabInfo3.liveTabs;
        Intrinsics.a(list);
        boolean z = false;
        if (list.size() == 0) {
            LiveTabModel liveTabModel = new LiveTabModel("0", AppInfo.d().getString(R.string.live_gift_hot), 0, 0);
            liveTabModel.data_point = "hot";
            liveTabModel.en_name = "Hot";
            LiveTabInfo liveTabInfo4 = this.g;
            Intrinsics.a(liveTabInfo4);
            List<LiveTabModel> list2 = liveTabInfo4.liveTabs;
            Intrinsics.a(list2);
            list2.add(liveTabModel);
        }
        LiveTabInfo liveTabInfo5 = (LiveTabInfo) this.a.getValue();
        List<LiveTabModel> list3 = liveTabInfo5 == null ? null : liveTabInfo5.liveTabs;
        if (list3 == null) {
            Log.i("==okr", "data empty");
            z = true;
        } else {
            Log.i("==okr", Intrinsics.a("data.size:", (Object) Integer.valueOf(list3.size())));
            int size = list3.size();
            LiveTabInfo liveTabInfo6 = this.g;
            Intrinsics.a(liveTabInfo6);
            if (size != liveTabInfo6.liveTabs.size()) {
                z = true;
            } else {
                LiveTabInfo liveTabInfo7 = this.g;
                Intrinsics.a(liveTabInfo7);
                int i = 0;
                for (LiveTabModel liveTabModel2 : liveTabInfo7.liveTabs) {
                    int i2 = i + 1;
                    if (i >= list3.size() || (TextUtils.equals(liveTabModel2.id, list3.get(i).id) && liveTabModel2.red_point == list3.get(i).red_point)) {
                        i = i2;
                    } else {
                        i = i2;
                        z = true;
                    }
                }
            }
        }
        LiveTabInfo liveTabInfo8 = this.g;
        Intrinsics.a(liveTabInfo8);
        List<LiveTabModel> list4 = liveTabInfo8.liveTabs;
        Intrinsics.a(list4);
        this.f = list4.size();
        Log.i("==okr", Intrinsics.a("changed:", (Object) Boolean.valueOf(z)));
        if (z) {
            MutableLiveData<LiveTabInfo> mutableLiveData = this.a;
            LiveTabInfo liveTabInfo9 = this.g;
            Intrinsics.a(liveTabInfo9);
            mutableLiveData.setValue(liveTabInfo9);
        }
    }

    @Override // com.blued.android.module.common.base.mvvm.BaseViewModel
    public void a(Bundle bundle) {
        super.a(bundle);
        this.e = bundle == null ? null : bundle.getString("live_pay_beans_details", "");
    }

    public final void a(IRequestHost fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        e(fragmentActive);
    }

    public final void a(String str) {
        this.e = str;
    }

    public final void b(final IRequestHost fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        LiveRoomHttpUtils.y(new BluedUIHttpResponse<BluedEntityA<LiveLiangModel>>(this) { // from class: com.blued.android.module.live_china.view_model.LiveMainViewModel$getLiveLiangInfo$1
            final /* synthetic */ LiveMainViewModel b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(IRequestHost.this);
                this.b = this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveLiangModel> parseData) {
                Intrinsics.e(parseData, "parseData");
                if (parseData.data == null || parseData.data.size() <= 0) {
                    this.b.e().setValue(new ArrayList());
                    return;
                }
                LiveRoomManager.a().a(parseData.data.get(0));
                this.b.e().setValue(parseData.data);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String errorMessage) {
                Intrinsics.e(errorMessage, "errorMessage");
                this.b.e().setValue(new ArrayList());
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
            }
        });
    }

    public final void c(final IRequestHost fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        LiveRoomHttpUtils.a(0, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<MultiDialogModel>>(0, this) { // from class: com.blued.android.module.live_china.view_model.LiveMainViewModel$getLiveMultiDialogInfo$1
            final /* synthetic */ int b;
            final /* synthetic */ LiveMainViewModel c;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(IRequestHost.this);
                this.b = r5;
                this.c = this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<MultiDialogModel> parseData) {
                Intrinsics.e(parseData, "parseData");
                if (parseData.data == null || parseData.getSingleData() == null) {
                    return;
                }
                MultiDialogModel singleData = parseData.getSingleData();
                Intrinsics.a(singleData);
                singleData.from_type = this.b;
                MultiDialogModel singleData2 = parseData.getSingleData();
                Intrinsics.a(singleData2);
                singleData2.isInit = true;
                LiveRoomManager.a().a(parseData.getSingleData());
                this.c.f().setValue(parseData.getSingleData());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String errorMessage) {
                Intrinsics.e(errorMessage, "errorMessage");
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                this.c.b(IRequestHost.this);
                super.onUIFinish();
            }
        });
    }

    public final MutableLiveData<LiveTabInfo> d() {
        return this.a;
    }

    public final void d(final IRequestHost fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        LiveRoomHttpUtils.r(new BluedUIHttpResponse<BluedEntityA<LiveFirstChargeInfo>>(this) { // from class: com.blued.android.module.live_china.view_model.LiveMainViewModel$getFirstChargeState$1
            final /* synthetic */ LiveMainViewModel b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(IRequestHost.this);
                this.b = this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveFirstChargeInfo> bluedEntity) {
                Intrinsics.e(bluedEntity, "bluedEntity");
                if (bluedEntity.getSingleData() != null) {
                    int i = bluedEntity.getSingleData().count;
                    LiveRoomPreferences.e(i);
                    if (i == 0) {
                        LiveRoomHttpUtils.e();
                    }
                    this.b.g().setValue(Integer.valueOf(i));
                }
            }
        }, fragmentActive);
    }

    public final MutableLiveData<List<LiveLiangModel>> e() {
        return this.b;
    }

    public final MutableLiveData<MultiDialogModel> f() {
        return this.c;
    }

    public final MutableLiveData<Integer> g() {
        return this.d;
    }

    public final String h() {
        return this.e;
    }
}

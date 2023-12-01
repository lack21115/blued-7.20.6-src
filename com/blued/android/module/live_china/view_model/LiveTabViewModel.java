package com.blued.android.module.live_china.view_model;

import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.AnchorLiveStateModel;
import com.blued.android.module.live_china.model.BannerModel;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.model.LiveListCommonModel;
import com.blued.android.module.live_china.model.LiveListModelExtra;
import com.blued.android.module.live_china.model.LiveTwoFloorModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view_model/LiveTabViewModel.class */
public final class LiveTabViewModel extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    private MutableLiveData<List<LiveTwoFloorModel>> f15481a = new MutableLiveData<>();
    private MutableLiveData<AnchorLiveStateModel> b = new MutableLiveData<>();

    /* renamed from: c  reason: collision with root package name */
    private MutableLiveData<List<BluedLiveListData>> f15482c = new MutableLiveData<>();
    private LiveListCommonModel d = new LiveListCommonModel();
    private List<BluedLiveListData> e = new ArrayList();
    private List<BannerModel> f = new ArrayList();
    private List<String> g = new ArrayList();
    private List<BluedLiveListData> h = new ArrayList();

    private final void c(final IRequestHost iRequestHost) {
        LiveRoomHttpUtils.c(new BluedUIHttpResponse<BluedEntity<BluedLiveListData, LiveListModelExtra>>(this) { // from class: com.blued.android.module.live_china.view_model.LiveTabViewModel$getLiveList$1
            final /* synthetic */ LiveTabViewModel b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(IRequestHost.this);
                this.b = this;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                this.b.f().setValue(this.b.j());
                this.b.a(false);
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                this.b.g().hasRequestData = true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<BluedLiveListData, LiveListModelExtra> parseData) {
                Intrinsics.e(parseData, "parseData");
                try {
                    if (parseData.data == null || parseData.data.size() <= 0) {
                        if (this.b.g().getPage() == 1) {
                            this.b.h().clear();
                        } else {
                            this.b.g().setPage(this.b.g().getPage() - 1);
                        }
                        this.b.g().setHasData(false);
                    } else {
                        if (parseData.hasMore()) {
                            this.b.g().setHasData(true);
                        } else {
                            this.b.g().setHasData(false);
                        }
                        Log.i("==xpmm", Intrinsics.a("data size:", (Object) Integer.valueOf(parseData.data.size())));
                        if (this.b.g().getPage() == 1) {
                            this.b.h().clear();
                            List<BluedLiveListData> h = this.b.h();
                            List<BluedLiveListData> list = parseData.data;
                            Intrinsics.c(list, "parseData.data");
                            h.addAll(list);
                        } else {
                            List<BluedLiveListData> h2 = this.b.h();
                            List<BluedLiveListData> list2 = parseData.data;
                            Intrinsics.c(list2, "parseData.data");
                            h2.addAll(list2);
                        }
                    }
                    Log.i("==xpmm", Intrinsics.a("size:", (Object) Integer.valueOf(parseData.data.size())));
                    if (this.b.g().getPage() == 1) {
                        if (parseData.extra == null || parseData.extra.banner == null) {
                            this.b.i().clear();
                        } else {
                            this.b.i().clear();
                            List<BannerModel> i = this.b.i();
                            List<BannerModel> list3 = parseData.extra.banner;
                            Intrinsics.c(list3, "parseData.extra.banner");
                            i.addAll(list3);
                        }
                    }
                    this.b.k();
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.b.g().getPage() != 1) {
                        this.b.g().setPage(this.b.g().getPage() - 1);
                    }
                    this.b.f().setValue(this.b.j());
                    AppMethods.a((CharSequence) AppInfo.d().getResources().getString(R.string.common_net_error));
                }
                this.b.a(true);
            }
        }, this.d.tabId, String.valueOf(this.d.getPage()), iRequestHost);
    }

    public final void a(IRequestHost fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        b(fragmentActive);
        a(fragmentActive, true);
    }

    public final void a(IRequestHost fragmentActive, boolean z) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        if (!z) {
            LiveListCommonModel liveListCommonModel = this.d;
            liveListCommonModel.setPage(liveListCommonModel.getPage() + 1);
            if (this.d.getHasData() || this.d.getPage() == 1) {
                c(fragmentActive);
                return;
            }
            LiveListCommonModel liveListCommonModel2 = this.d;
            liveListCommonModel2.setPage(liveListCommonModel2.getPage() - 1);
            AppMethods.a((CharSequence) AppInfo.d().getResources().getString(R.string.common_nomore_data));
            a(true);
            return;
        }
        LiveListCommonModel liveListCommonModel3 = this.d;
        if (liveListCommonModel3 != null) {
            liveListCommonModel3.setPage(1);
        }
        LiveListCommonModel liveListCommonModel4 = this.d;
        if (liveListCommonModel4 != null) {
            liveListCommonModel4.setRecommendPage(0);
        }
        LiveListCommonModel liveListCommonModel5 = this.d;
        if (liveListCommonModel5 != null) {
            liveListCommonModel5.setCanReCommend(false);
        }
        LiveListCommonModel liveListCommonModel6 = this.d;
        if (liveListCommonModel6 != null) {
            liveListCommonModel6.setHasData(true);
        }
        c(fragmentActive);
    }

    public final void a(String str, final IRequestHost iRequestHost) {
        LiveRoomHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<AnchorLiveStateModel>>(this) { // from class: com.blued.android.module.live_china.view_model.LiveTabViewModel$getAnchorLiveState$1
            final /* synthetic */ LiveTabViewModel b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(IRequestHost.this);
                this.b = this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<AnchorLiveStateModel> parseData) {
                Intrinsics.e(parseData, "parseData");
                if (!parseData.hasData() || parseData.getSingleData() == null) {
                    return;
                }
                try {
                    this.b.e().setValue(parseData.getSingleData());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, str, iRequestHost);
    }

    public final void a(String tabId, String tabName) {
        Intrinsics.e(tabId, "tabId");
        Intrinsics.e(tabName, "tabName");
        LiveListCommonModel d = LiveRoomUtils.d(tabId);
        LiveListCommonModel liveListCommonModel = d;
        if (d == null) {
            liveListCommonModel = new LiveListCommonModel();
            liveListCommonModel.setPage(1);
            liveListCommonModel.tabId = tabId;
            liveListCommonModel.tabName = tabName;
            liveListCommonModel.setHasData(true);
            LiveRoomUtils.a(tabId, liveListCommonModel);
        }
        this.d = liveListCommonModel;
        List<BluedLiveListData> a2 = LiveRoomUtils.a(tabId);
        ArrayList arrayList = a2;
        if (a2 == null) {
            arrayList = new ArrayList();
            LiveRoomUtils.a(tabId, arrayList);
        }
        this.e.clear();
        this.e.addAll(arrayList);
        List<BannerModel> b = LiveRoomUtils.b(tabId);
        ArrayList arrayList2 = b;
        if (b == null) {
            arrayList2 = new ArrayList();
            LiveRoomUtils.b(tabId, arrayList2);
        }
        this.f.clear();
        this.f.addAll(arrayList2);
    }

    public final boolean a(BluedLiveListData bluedLiveListData) {
        return bluedLiveListData != null && bluedLiveListData.recommend_type == 2 && bluedLiveListData.carousel != null && bluedLiveListData.carousel.size() >= 4;
    }

    public final boolean a(List<? extends BluedLiveListData> list) {
        if (list == null) {
            return true;
        }
        return !(list.size() == 1 && a(list.get(0))) && list.size() < 2;
    }

    public final void b(final IRequestHost fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        LiveListCommonModel liveListCommonModel = this.d;
        if (TextUtils.equals(liveListCommonModel == null ? null : liveListCommonModel.tabId, "11")) {
            return;
        }
        LiveRoomHttpUtils.t(new BluedUIHttpResponse<BluedEntityA<LiveTwoFloorModel>>(this) { // from class: com.blued.android.module.live_china.view_model.LiveTabViewModel$getTwoLevel$1
            final /* synthetic */ LiveTabViewModel b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(IRequestHost.this);
                this.b = this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveTwoFloorModel> parseData) {
                Intrinsics.e(parseData, "parseData");
                if (parseData.data != null) {
                    this.b.d().setValue(parseData.data);
                    return;
                }
                this.b.d().setValue(new ArrayList());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
            }
        }, fragmentActive);
    }

    public final MutableLiveData<List<LiveTwoFloorModel>> d() {
        return this.f15481a;
    }

    public final MutableLiveData<AnchorLiveStateModel> e() {
        return this.b;
    }

    public final MutableLiveData<List<BluedLiveListData>> f() {
        return this.f15482c;
    }

    public final LiveListCommonModel g() {
        return this.d;
    }

    public final List<BluedLiveListData> h() {
        return this.e;
    }

    public final List<BannerModel> i() {
        return this.f;
    }

    public final List<BluedLiveListData> j() {
        return this.h;
    }

    public final void k() {
        LiveRoomUtils.a(this.d.tabId, this.e);
        LiveRoomUtils.b(this.d.tabId, this.f);
        l();
        m();
        this.f15482c.setValue(this.h);
        b(this.d.getHasData());
    }

    public final void l() {
        this.g.clear();
        ArrayList arrayList = new ArrayList();
        List<BluedLiveListData> list = this.e;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                BluedLiveListData bluedLiveListData = this.e.get(i);
                if (bluedLiveListData != null && bluedLiveListData.recommend_type == 1 && bluedLiveListData.recommend_ad != null) {
                    String str = bluedLiveListData.recommend_ad.link;
                    Intrinsics.c(str, "item.recommend_ad.link");
                    if (TextUtils.isEmpty(str)) {
                        arrayList.add(this.e.get(i));
                    } else {
                        List<String> list2 = this.g;
                        Intrinsics.a(list2);
                        if (!list2.contains(str)) {
                            List<String> list3 = this.g;
                            if (list3 != null) {
                                list3.add(str);
                            }
                            arrayList.add(this.e.get(i));
                        }
                    }
                } else if (bluedLiveListData != null) {
                    String str2 = bluedLiveListData.lid;
                    List<String> list4 = this.g;
                    Intrinsics.a(list4);
                    if (list4.contains(str2)) {
                        Log.i("==xpmm", Intrinsics.a("same lid:", (Object) str2));
                    } else {
                        List<String> list5 = this.g;
                        if (list5 != null) {
                            list5.add(str2);
                        }
                        arrayList.add(this.e.get(i));
                    }
                }
            }
        }
        this.e.clear();
        this.e.addAll(arrayList);
    }

    public final void m() {
        ArrayList<List> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (BluedLiveListData bluedLiveListData : this.e) {
            if (a(bluedLiveListData)) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(bluedLiveListData);
                arrayList.add(arrayList3);
            } else if (arrayList2.size() == 2 || arrayList2.size() == 0) {
                arrayList2 = new ArrayList();
                arrayList2.add(bluedLiveListData);
                arrayList.add(arrayList2);
            } else {
                arrayList2.add(bluedLiveListData);
            }
        }
        if (arrayList.size() > 0 && a((List) arrayList.get(arrayList.size() - 1))) {
            arrayList.remove(arrayList.size() - 1);
        }
        if (arrayList.size() > 0) {
            int size = arrayList.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                List list = (List) arrayList.get(i2);
                Iterator it = list.iterator();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (it.hasNext()) {
                        BluedLiveListData bluedLiveListData2 = (BluedLiveListData) it.next();
                        BluedLiveListData bluedLiveListData3 = (BluedLiveListData) list.get(i4);
                        if (a(bluedLiveListData2)) {
                            if ((bluedLiveListData2.carousel != null ? bluedLiveListData2.carousel.size() : 0) > 4) {
                                List<BluedLiveListData> subList = bluedLiveListData2.carousel.subList(0, 3);
                                Log.i("==xpmm", Intrinsics.a("tempList size:", (Object) Integer.valueOf(subList.size())));
                                bluedLiveListData2.carousel = subList;
                            }
                            bluedLiveListData3.liveType = 12;
                        } else {
                            bluedLiveListData3.liveType = 0;
                        }
                        bluedLiveListData3.position = i4;
                        bluedLiveListData3.positionReal = i;
                        i++;
                        i3 = i4 + 1;
                    }
                }
            }
        }
        List<BannerModel> list2 = this.f;
        if (list2 != null && list2.size() > 0) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (BannerModel bannerModel : this.f) {
                if (linkedHashMap.get(Integer.valueOf(bannerModel.show_layer)) == 0) {
                    ArrayList arrayList4 = new ArrayList();
                    arrayList4.add(bannerModel);
                    linkedHashMap.put(Integer.valueOf(bannerModel.show_layer), arrayList4);
                } else {
                    List list3 = (List) linkedHashMap.get(Integer.valueOf(bannerModel.show_layer));
                    if (list3 != null) {
                        list3.add(bannerModel);
                    }
                }
            }
            ArrayList arrayList5 = new ArrayList();
            for (Number number : linkedHashMap.keySet()) {
                arrayList5.add(Integer.valueOf(number.intValue()));
            }
            Collections.sort(arrayList5);
            Iterator<E> it2 = arrayList5.iterator();
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (!it2.hasNext()) {
                    break;
                }
                int intValue = ((Number) it2.next()).intValue();
                BluedLiveListData bluedLiveListData4 = new BluedLiveListData();
                bluedLiveListData4.liveType = 11;
                bluedLiveListData4.banner_list = (List) linkedHashMap.get(Integer.valueOf(intValue));
                int i7 = intValue - 1;
                bluedLiveListData4.positionReal = i7;
                ArrayList arrayList6 = new ArrayList();
                arrayList6.add(bluedLiveListData4);
                int i8 = intValue + i6;
                if (i7 >= arrayList.size()) {
                    arrayList.add(arrayList.size(), arrayList6);
                } else if (i7 <= 0) {
                    arrayList.add(0, arrayList6);
                } else if (i8 >= arrayList.size()) {
                    arrayList.add(arrayList.size(), arrayList6);
                } else if (i8 <= 0) {
                    arrayList.add(0, arrayList6);
                } else {
                    arrayList.add(i8, arrayList6);
                }
                i5 = i6 + 1;
            }
        }
        ArrayList arrayList7 = new ArrayList();
        for (List<BluedLiveListData> list4 : arrayList) {
            for (BluedLiveListData bluedLiveListData5 : list4) {
                arrayList7.add(bluedLiveListData5);
            }
        }
        this.h.clear();
        this.h.addAll(arrayList7);
    }
}

package com.blued.community.ui.event.vm;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.community.http.EventHttpUtils;
import com.blued.community.ui.event.model.EventDetailsModel;
import com.blued.community.utils.CityHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/vm/EventListViewModel.class */
public final class EventListViewModel extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    private int f19582a = 1;
    private final MutableLiveData<List<EventDetailsModel>> b = new MutableLiveData<>();

    /* renamed from: c  reason: collision with root package name */
    private List<? extends EventDetailsModel> f19583c = new ArrayList();
    private final MutableLiveData<Boolean> d = new MutableLiveData<>();

    @Override // com.blued.android.module.common.base.mvvm.BaseViewModel
    public void a(Bundle bundle) {
        super.a(bundle);
        a(true, (ActivityFragmentActive) null);
    }

    public final void a(List<? extends EventDetailsModel> list) {
        Intrinsics.e(list, "<set-?>");
        this.f19583c = list;
    }

    public final void a(final boolean z, final ActivityFragmentActive activityFragmentActive) {
        if (z) {
            this.f19582a = 1;
        } else {
            this.f19582a++;
        }
        EventHttpUtils eventHttpUtils = EventHttpUtils.f19079a;
        BluedUIHttpResponse<BluedEntityA<EventDetailsModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<EventDetailsModel>>(z, this) { // from class: com.blued.community.ui.event.vm.EventListViewModel$getEventListData$1
            final /* synthetic */ boolean b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ EventListViewModel f19585c;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(ActivityFragmentActive.this);
                this.b = z;
                this.f19585c = this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Code restructure failed: missing block: B:18:0x00c3, code lost:
                if ((r0 == null || r0.length() == 0) != false) goto L15;
             */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onUIUpdate(com.blued.android.framework.http.parser.BluedEntityA<com.blued.community.ui.event.model.EventDetailsModel> r5) {
                /*
                    r4 = this;
                    r0 = r5
                    java.lang.String r1 = "result"
                    kotlin.jvm.internal.Intrinsics.e(r0, r1)
                    r0 = r5
                    boolean r0 = r0.hasData()
                    if (r0 == 0) goto Ld4
                    r0 = r4
                    boolean r0 = r0.b
                    if (r0 == 0) goto L31
                    r0 = r4
                    com.blued.community.ui.event.vm.EventListViewModel r0 = r0.f19585c
                    r9 = r0
                    r0 = r5
                    java.util.List<T> r0 = r0.data
                    r10 = r0
                    r0 = r10
                    java.lang.String r1 = "result.data"
                    kotlin.jvm.internal.Intrinsics.c(r0, r1)
                    r0 = r9
                    r1 = r10
                    r0.a(r1)
                    goto L5d
                L31:
                    r0 = r4
                    com.blued.community.ui.event.vm.EventListViewModel r0 = r0.f19585c
                    r9 = r0
                    r0 = r9
                    java.util.List r0 = r0.e()
                    java.util.Collection r0 = (java.util.Collection) r0
                    r10 = r0
                    r0 = r5
                    java.util.List<T> r0 = r0.data
                    r11 = r0
                    r0 = r11
                    java.lang.String r1 = "result.data"
                    kotlin.jvm.internal.Intrinsics.c(r0, r1)
                    r0 = r9
                    r1 = r10
                    r2 = r11
                    java.lang.Iterable r2 = (java.lang.Iterable) r2
                    java.util.List r1 = kotlin.collections.CollectionsKt.b(r1, r2)
                    r0.a(r1)
                L5d:
                    r0 = r4
                    com.blued.community.ui.event.vm.EventListViewModel r0 = r0.f19585c
                    androidx.lifecycle.MutableLiveData r0 = r0.d()
                    r1 = r4
                    com.blued.community.ui.event.vm.EventListViewModel r1 = r1.f19585c
                    java.util.List r1 = r1.e()
                    r0.postValue(r1)
                    r0 = r4
                    com.blued.community.ui.event.vm.EventListViewModel r0 = r0.f19585c
                    androidx.lifecycle.MutableLiveData r0 = r0.f()
                    r9 = r0
                    r0 = r4
                    com.blued.community.ui.event.vm.EventListViewModel r0 = r0.f19585c
                    java.util.List r0 = r0.e()
                    java.util.Collection r0 = (java.util.Collection) r0
                    boolean r0 = r0.isEmpty()
                    r8 = r0
                    r0 = 1
                    r7 = r0
                    r0 = r8
                    r1 = 1
                    r0 = r0 ^ r1
                    if (r0 == 0) goto Lc9
                    r0 = r4
                    com.blued.community.ui.event.vm.EventListViewModel r0 = r0.f19585c
                    java.util.List r0 = r0.e()
                    r1 = 0
                    java.lang.Object r0 = r0.get(r1)
                    com.blued.community.ui.event.model.EventDetailsModel r0 = (com.blued.community.ui.event.model.EventDetailsModel) r0
                    java.lang.String r0 = r0.other_tips
                    java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                    r10 = r0
                    r0 = r10
                    if (r0 == 0) goto Lc0
                    r0 = r10
                    int r0 = r0.length()
                    if (r0 != 0) goto Lbb
                    goto Lc0
                Lbb:
                    r0 = 0
                    r6 = r0
                    goto Lc2
                Lc0:
                    r0 = 1
                    r6 = r0
                Lc2:
                    r0 = r6
                    if (r0 == 0) goto Lc9
                    goto Lcb
                Lc9:
                    r0 = 0
                    r7 = r0
                Lcb:
                    r0 = r9
                    r1 = r7
                    java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
                    r0.postValue(r1)
                Ld4:
                    r0 = r4
                    com.blued.community.ui.event.vm.EventListViewModel r0 = r0.f19585c
                    r1 = r5
                    boolean r1 = r1.hasMore()
                    com.blued.community.ui.event.vm.EventListViewModel.a(r0, r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.community.ui.event.vm.EventListViewModel$getEventListData$1.onUIUpdate(com.blued.android.framework.http.parser.BluedEntityA):void");
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z2) {
                super.onUIFinish(z2);
                this.f19585c.a(z2);
            }
        };
        int i = this.f19582a;
        String latitude = UserInfo.getInstance().getLoginUserInfo().getLatitude();
        Intrinsics.c(latitude, "getInstance().loginUserInfo.latitude");
        String longitude = UserInfo.getInstance().getLoginUserInfo().getLongitude();
        Intrinsics.c(longitude, "getInstance().loginUserInfo.longitude");
        String f = CityHelper.a().f();
        Intrinsics.c(f, "getInstance().eventLatitude");
        String d = CityHelper.a().d();
        Intrinsics.c(d, "getInstance().eventLongitude");
        eventHttpUtils.a(bluedUIHttpResponse, i, latitude, longitude, f, d, activityFragmentActive);
    }

    public final MutableLiveData<List<EventDetailsModel>> d() {
        return this.b;
    }

    public final List<EventDetailsModel> e() {
        return this.f19583c;
    }

    public final MutableLiveData<Boolean> f() {
        return this.d;
    }
}

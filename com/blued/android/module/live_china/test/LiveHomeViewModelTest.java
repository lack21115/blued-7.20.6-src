package com.blued.android.module.live_china.test;

import androidx.lifecycle.MutableLiveData;
import com.blued.android.core.net.HttpManager;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/test/LiveHomeViewModelTest.class */
public final class LiveHomeViewModelTest extends BaseViewModel {
    private final MutableLiveData<List<BluedLiveListDataTest>> a = new MutableLiveData<>();

    public final MutableLiveData<List<BluedLiveListDataTest>> d() {
        return this.a;
    }

    public final void e() {
        HttpManager.a(Intrinsics.a(LiveRoomInfo.a().k(), (Object) "/live/cates/0?page=1"), new BluedUIHttpResponse<BluedEntityA<BluedLiveListDataTest>>() { // from class: com.blued.android.module.live_china.test.LiveHomeViewModelTest$getLiveList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedLiveListDataTest> bluedEntityA) {
                LiveHomeViewModelTest.this.d().setValue(bluedEntityA == null ? null : bluedEntityA.data);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
            }
        }, null).b(BluedHttpTools.a(true)).h();
    }

    public final void f() {
        String a = Intrinsics.a(LiveRoomInfo.a().k(), (Object) "/live/followed-list");
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("page", "1");
        HttpManager.a(a, new BluedUIHttpResponse<BluedEntityA<BluedLiveListDataTest>>() { // from class: com.blued.android.module.live_china.test.LiveHomeViewModelTest$getLiveFollowList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedLiveListDataTest> bluedEntityA) {
                LiveHomeViewModelTest.this.d().setValue(bluedEntityA == null ? null : bluedEntityA.data);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
            }
        }, null).b(BluedHttpTools.a(true)).a(a2).h();
    }
}

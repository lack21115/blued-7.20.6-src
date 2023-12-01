package com.blued.android.module.yy_china.presenter;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.android.module.yy_china.adapter.YYRoomListsAdapter;
import com.blued.android.module.yy_china.model.YYChatRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/presenter/YYChatRoomsListItemViewModel.class */
public final class YYChatRoomsListItemViewModel extends BaseViewModel {
    private String b;
    private String c;
    private int i;
    private List<String> j;
    private final String a = "YYChatRoomsListItemView";
    private final MutableLiveData<List<YYChatRoomModel>> d = new MutableLiveData<>();
    private final MutableLiveData<List<YYChatRoomModel>> e = new MutableLiveData<>();
    private final MutableLiveData<Boolean> f = new MutableLiveData<>();
    private final MutableLiveData<Boolean> g = new MutableLiveData<>();
    private final MutableLiveData<Boolean> h = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public final List<YYChatRoomModel> a(List<? extends YYChatRoomModel> list) {
        List<String> list2;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (YYChatRoomModel yYChatRoomModel : list) {
            if (yYChatRoomModel != null && yYChatRoomModel.data != null) {
                if (yYChatRoomModel.type == YYRoomListsAdapter.a.a()) {
                    List<String> list3 = this.j;
                    Intrinsics.a(list3);
                    if (list3.contains(yYChatRoomModel.data.room_id)) {
                        Logger.e(this.a, Intrinsics.a("去重room——id：", (Object) yYChatRoomModel.data.room_id));
                    }
                }
                if (yYChatRoomModel.type == YYRoomListsAdapter.a.a() && (list2 = this.j) != null) {
                    String str = yYChatRoomModel.data.room_id;
                    Intrinsics.c(str, "room.data.room_id");
                    list2.add(str);
                }
                arrayList.add(yYChatRoomModel);
            }
        }
        String str2 = this.a;
        List<String> list4 = this.j;
        Intrinsics.a(list4);
        Object[] array = list4.toArray(new String[0]);
        if (array != null) {
            Logger.e(str2, Intrinsics.a("room_id_list：", (Object) Arrays.toString(array)));
            return arrayList;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int b(List<? extends YYChatRoomModel> list) {
        if (list == null) {
            return -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).type == YYRoomListsAdapter.a.a()) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.blued.android.module.common.base.mvvm.BaseViewModel
    public void a(Bundle bundle) {
        super.a(bundle);
        if (bundle == null) {
            return;
        }
        a(bundle.getString("room_type", "0"));
        b(bundle.getString("from_source", ""));
    }

    public final void a(final ActivityFragmentActive fragmentActive, boolean z) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        if (z) {
            this.i = 1;
        }
        final int i = this.i;
        YYRoomHttpUtils.a(this.b, i, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYChatRoomModel>>(this, i) { // from class: com.blued.android.module.yy_china.presenter.YYChatRoomsListItemViewModel$getRoomDatasByType$1
            final /* synthetic */ YYChatRoomsListItemViewModel b;
            final /* synthetic */ int c;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(ActivityFragmentActive.this);
                this.b = this;
                this.c = i;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUICache(BluedEntityA<YYChatRoomModel> parseData) {
                Intrinsics.e(parseData, "parseData");
                super.onUICache(parseData);
                Logger.e(this.b.d(), "getRoomList onUICache ... ");
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Code restructure failed: missing block: B:14:0x0093, code lost:
                r0 = r6.b.b(r0);
             */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: b */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onUIUpdate(com.blued.android.framework.http.parser.BluedEntityA<com.blued.android.module.yy_china.model.YYChatRoomModel> r7) {
                /*
                    Method dump skipped, instructions count: 298
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.presenter.YYChatRoomsListItemViewModel$getRoomDatasByType$1.onUIUpdate(com.blued.android.framework.http.parser.BluedEntityA):void");
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z2) {
                super.onUIFinish(z2);
                Logger.e(this.b.d(), "getRoomList onUIFinish ... ");
            }
        }, (IRequestHost) fragmentActive);
    }

    public final void a(String str) {
        this.b = str;
    }

    public final void b(String str) {
        this.c = str;
    }

    public final String d() {
        return this.a;
    }

    public final String e() {
        return this.b;
    }

    public final String f() {
        return this.c;
    }

    public final MutableLiveData<List<YYChatRoomModel>> g() {
        return this.d;
    }

    public final MutableLiveData<List<YYChatRoomModel>> h() {
        return this.e;
    }

    public final MutableLiveData<Boolean> i() {
        return this.f;
    }

    public final MutableLiveData<Boolean> j() {
        return this.g;
    }

    public final MutableLiveData<Boolean> k() {
        return this.h;
    }
}

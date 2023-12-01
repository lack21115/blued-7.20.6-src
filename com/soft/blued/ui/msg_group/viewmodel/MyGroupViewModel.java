package com.soft.blued.ui.msg_group.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.android.module.common.extensions.BluedViewExtKt;
import com.blued.android.module.common.group.GroupInfoModel;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.ui.msg.model.GroupGuideModel;
import com.soft.blued.ui.msg_group.model.GroupIdentifyModel;
import com.soft.blued.ui.msg_group.model.GroupPrivilegeModel;
import com.soft.blued.ui.msg_group.model.MyGroupModel;
import com.soft.blued.ui.msg_group.utils.GroupHelper;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/viewmodel/MyGroupViewModel.class */
public final class MyGroupViewModel extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    private final MutableLiveData<List<GroupInfoModel>> f19168a = new MutableLiveData<>();
    private int b = BluedViewExtKt.a(58);

    /* renamed from: c  reason: collision with root package name */
    private final MutableLiveData<GroupIdentifyModel> f19169c = new MutableLiveData<>();
    private final MutableLiveData<GroupPrivilegeModel> d = new MutableLiveData<>();
    private final MutableLiveData<Integer> e = new MutableLiveData<>();
    private final MutableLiveData<String> f = new MutableLiveData<>();
    private final MutableLiveData<GroupGuideModel> g = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(MyGroupModel myGroupModel) {
        List<GroupInfoModel> a2 = GroupHelper.f19136a.a(myGroupModel, true);
        List<GroupInfoModel> list = a2;
        if (!(list == null || list.isEmpty())) {
            this.b += BluedViewExtKt.a(176);
        }
        this.f19168a.postValue(a2);
        ArrayList arrayList = new ArrayList();
        int size = myGroupModel.groups.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            if (myGroupModel.groups.get(i2).type == 3 && myGroupModel.groups.get(i2).group_role == 1 && myGroupModel.groups.get(i2).group_now_population > myGroupModel.groups.get(i2).group_max_population) {
                GroupInfoModel groupInfoModel = myGroupModel.groups.get(i2);
                Intrinsics.c(groupInfoModel, "myGroup.groups[i]");
                arrayList.add(groupInfoModel);
            }
            i = i2 + 1;
        }
        if (arrayList.size() > 0) {
            long eF = BluedPreferences.eF();
            if (eF == 0 || eF + 86400000 < System.currentTimeMillis()) {
                BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new MyGroupViewModel$initData$1(arrayList, this, null), 3, (Object) null);
            }
        }
    }

    public final void a(String str) {
        Intrinsics.e(str, "gid");
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new MyGroupViewModel$upgradeGroup$1(str, this, null), 3, (Object) null);
    }

    public final MutableLiveData<List<GroupInfoModel>> d() {
        return this.f19168a;
    }

    public final int e() {
        return this.b;
    }

    public final MutableLiveData<GroupIdentifyModel> f() {
        return this.f19169c;
    }

    public final MutableLiveData<GroupPrivilegeModel> g() {
        return this.d;
    }

    public final MutableLiveData<Integer> h() {
        return this.e;
    }

    public final MutableLiveData<String> i() {
        return this.f;
    }

    public final MutableLiveData<GroupGuideModel> j() {
        return this.g;
    }

    public final void k() {
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new MyGroupViewModel$getIdentifyInfo$1(this, null), 3, (Object) null);
    }

    public final void l() {
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new MyGroupViewModel$getMyGroup$1(this, null), 3, (Object) null);
    }

    public final void m() {
        ChatHttpUtils.f(new BluedUIHttpResponse<BluedEntityA<GroupGuideModel>>() { // from class: com.soft.blued.ui.msg_group.viewmodel.MyGroupViewModel$getGroupGuideData$1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<GroupGuideModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                MyGroupViewModel.this.j().setValue(bluedEntityA.getSingleData());
            }
        });
    }
}

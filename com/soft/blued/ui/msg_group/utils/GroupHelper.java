package com.soft.blued.ui.msg_group.utils;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelProvider;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.module.common.group.GroupInfoModel;
import com.soft.blued.ui.msg_group.model.GroupPrivilegeModel;
import com.soft.blued.ui.msg_group.model.MyGroupModel;
import com.soft.blued.ui.msg_group.pop.PopGroupRecover;
import com.soft.blued.ui.msg_group.viewmodel.MyGroupViewModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/utils/GroupHelper.class */
public final class GroupHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final GroupHelper f32827a = new GroupHelper();
    private static MyGroupViewModel b;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/utils/GroupHelper$MyGroupsComparator.class */
    public static final class MyGroupsComparator implements Comparator<GroupInfoModel> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(GroupInfoModel groupInfoModel, GroupInfoModel groupInfoModel2) {
            if (groupInfoModel != null && groupInfoModel.type == 4) {
                if (!(groupInfoModel2 != null && groupInfoModel2.type == 4)) {
                    return 1;
                }
            }
            if (!(groupInfoModel != null && groupInfoModel.type == 4)) {
                if (groupInfoModel2 != null && groupInfoModel2.type == 4) {
                    return -1;
                }
            }
            if (groupInfoModel != null && groupInfoModel.group_role == 1) {
                if (!(groupInfoModel2 != null && groupInfoModel2.group_role == 1)) {
                    return -1;
                }
            }
            if (!(groupInfoModel != null && groupInfoModel.group_role == 1)) {
                if (groupInfoModel2 != null && groupInfoModel2.group_role == 1) {
                    return 1;
                }
            }
            if (groupInfoModel != null && groupInfoModel.group_role == 2) {
                if (!(groupInfoModel2 != null && groupInfoModel2.group_role == 2)) {
                    return -1;
                }
            }
            if (groupInfoModel != null && groupInfoModel.group_role == 2) {
                return 0;
            }
            return groupInfoModel2 != null && groupInfoModel2.group_role == 2 ? 1 : 0;
        }
    }

    private GroupHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FragmentActivity it, Context context, GroupPrivilegeModel groupPrivilegeModel) {
        Intrinsics.e(it, "$it");
        Intrinsics.e(context, "$context");
        if (b == null || groupPrivilegeModel == null) {
            return;
        }
        XPopup.Builder a2 = new XPopup.Builder(it).a(PopupAnimation.ScaleAlphaFromCenter);
        MyGroupViewModel myGroupViewModel = b;
        Intrinsics.a(myGroupViewModel);
        a2.a((BasePopupView) new PopGroupRecover(context, myGroupViewModel, groupPrivilegeModel)).h();
    }

    public final List<GroupInfoModel> a(MyGroupModel myGroup, boolean z) {
        Intrinsics.e(myGroup, "myGroup");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<GroupInfoModel> list = myGroup.groups;
        Intrinsics.c(list, "myGroup.groups");
        arrayList.addAll(list);
        Collections.sort(arrayList, new MyGroupsComparator());
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            if (z) {
                ((GroupInfoModel) arrayList.get(i2)).itemType = 5;
            } else {
                ((GroupInfoModel) arrayList.get(i2)).itemType = 0;
            }
            if (((GroupInfoModel) arrayList.get(i2)).type == 4) {
                if (z && arrayList3.size() + arrayList4.size() + arrayList5.size() >= 6) {
                    break;
                }
                arrayList5.add(arrayList.get(i2));
            } else if (!z || arrayList3.size() + arrayList4.size() < 3) {
                if (((GroupInfoModel) arrayList.get(i2)).group_role == 1) {
                    arrayList3.add(arrayList.get(i2));
                } else {
                    arrayList4.add(arrayList.get(i2));
                }
            }
            i = i2 + 1;
        }
        ArrayList arrayList6 = arrayList3;
        if (!arrayList6.isEmpty()) {
            GroupInfoModel groupInfoModel = new GroupInfoModel();
            groupInfoModel.itemType = 1;
            if (!z) {
                arrayList2.add(groupInfoModel);
            }
            arrayList2.addAll(arrayList6);
            if (!z && myGroup.buy_privilege == 1) {
                GroupInfoModel groupInfoModel2 = new GroupInfoModel();
                groupInfoModel2.itemType = 4;
                arrayList2.add(groupInfoModel2);
            }
        }
        ArrayList arrayList7 = arrayList4;
        if (!arrayList7.isEmpty()) {
            GroupInfoModel groupInfoModel3 = new GroupInfoModel();
            groupInfoModel3.itemType = 2;
            groupInfoModel3.max_join = myGroup.max_join;
            if (!z) {
                arrayList2.add(groupInfoModel3);
            }
            arrayList2.addAll(arrayList7);
        }
        ArrayList arrayList8 = arrayList5;
        if (!arrayList8.isEmpty()) {
            GroupInfoModel groupInfoModel4 = new GroupInfoModel();
            groupInfoModel4.itemType = z ? 6 : 3;
            arrayList2.add(groupInfoModel4);
            arrayList2.addAll(arrayList8);
        }
        return arrayList2;
    }

    public final void a(final Context context) {
        MutableLiveData<GroupPrivilegeModel> g;
        Intrinsics.e(context, "context");
        if (context instanceof FragmentActivity) {
            final FragmentActivity fragmentActivity = (FragmentActivity) context;
            b = (MyGroupViewModel) new ViewModelProvider(fragmentActivity).get(MyGroupViewModel.class);
            fragmentActivity.getLifecycle().addObserver(new LifecycleObserver() { // from class: com.soft.blued.ui.msg_group.utils.GroupHelper$attachActivity$1$1
                @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                public final void onDestroy() {
                    GroupHelper groupHelper = GroupHelper.f32827a;
                    GroupHelper.b = null;
                }
            });
            MyGroupViewModel myGroupViewModel = b;
            if (myGroupViewModel != null && (g = myGroupViewModel.g()) != null) {
                g.observe(fragmentActivity, new Observer() { // from class: com.soft.blued.ui.msg_group.utils.-$$Lambda$GroupHelper$iXzre-lNizxBLGbYDH3zDiwWHJE
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        GroupHelper.a(FragmentActivity.this, context, (GroupPrivilegeModel) obj);
                    }
                });
            }
            MyGroupViewModel myGroupViewModel2 = b;
            if (myGroupViewModel2 == null) {
                return;
            }
            myGroupViewModel2.l();
        }
    }
}

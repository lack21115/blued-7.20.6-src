package com.soft.blued.ui.msg_group;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.msg_group.adapter.MyGroupAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/TestFragment.class */
public final class TestFragment extends MvpFragment<MvpPresenter> {

    /* renamed from: a  reason: collision with root package name */
    public MyGroupAdapter f18931a;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x005e, code lost:
        if (r0 == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0064, code lost:
        r6 = r6.groups;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003a, code lost:
        if (r0 == null) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.blued.android.framework.http.parser.BluedEntityA<com.soft.blued.ui.msg_group.model.MyGroupModel> r6, com.blued.android.framework.http.parser.BluedEntityA<com.soft.blued.ui.user.model.UserInfoEntity> r7) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg_group.TestFragment.a(com.blued.android.framework.http.parser.BluedEntityA, com.blued.android.framework.http.parser.BluedEntityA):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(TestFragment testFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(testFragment, "this$0");
        testFragment.t();
    }

    private final void a(List<GroupInfoModel> list) {
        int i;
        int i2;
        List<GroupInfoModel> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        int size = list.size();
        int i3 = -1;
        int i4 = -1;
        int i5 = 0;
        while (true) {
            i = i3;
            i2 = i4;
            if (i5 >= size) {
                break;
            }
            i = i3;
            if (list.get(i5).group_role == 1) {
                i = i3;
                if (i3 == -1) {
                    i = i5;
                }
            }
            i2 = i4;
            if (list.get(i5).group_role != 1) {
                i2 = i4;
                if (i4 == -1) {
                    i2 = i5;
                }
            }
            if (i2 != -1) {
                break;
            }
            i5++;
            i3 = i;
            i4 = i2;
        }
        int i6 = i2;
        if (i != -1) {
            GroupInfoModel groupInfoModel = new GroupInfoModel();
            groupInfoModel.itemType = 1;
            list.add(i, groupInfoModel);
            i6 = i2;
            if (i2 != -1) {
                i6 = i2 + 1;
            }
        }
        if (i6 != -1) {
            GroupInfoModel groupInfoModel2 = new GroupInfoModel();
            groupInfoModel2.itemType = 2;
            groupInfoModel2.max_join = 3;
            list.add(i6, groupInfoModel2);
        }
        b().setNewData(list);
    }

    private final void c() {
        BuildersKt.a(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new TestFragment$requestApi$1(this, null), 3, (Object) null);
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        CommonTopTitleNoTrans findViewById = this.i.findViewById(2131370694);
        RecyclerView recyclerView = (RecyclerView) this.i.findViewById(R.id.group_list);
        findViewById.setCenterText(getString(R.string.my_groups));
        findViewById.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.-$$Lambda$TestFragment$OmE_wSnu0pTImQWcOTHFEEuozcs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestFragment.a(TestFragment.this, view);
            }
        });
        a(new MyGroupAdapter(getFragmentActive()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(b());
        c();
    }

    public final void a(MyGroupAdapter myGroupAdapter) {
        Intrinsics.e(myGroupAdapter, "<set-?>");
        this.f18931a = myGroupAdapter;
    }

    public final MyGroupAdapter b() {
        MyGroupAdapter myGroupAdapter = this.f18931a;
        if (myGroupAdapter != null) {
            return myGroupAdapter;
        }
        Intrinsics.c("adapter");
        return null;
    }

    public int g() {
        return R.layout.fm_my_group_new;
    }
}

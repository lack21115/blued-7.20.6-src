package com.blued.community.auto;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.blued.android.module.common.user.view.GroupJoinView;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/auto/ICommunityOtherService.class */
public interface ICommunityOtherService {
    View a(Context context);

    String a();

    void a(Fragment fragment);

    void a(ActivityFragmentActive activityFragmentActive, BluedADExtra bluedADExtra, View view, View view2);

    void a(GroupJoinView groupJoinView, int i, List<GroupInfoModel> list, ActivityFragmentActive activityFragmentActive);

    void a(Long l, int i);

    void a(List<GroupInfoModel> list);

    void a(boolean z);

    void b(Context context, int i, String str);

    boolean b(int i);

    String c(int i);

    void c();

    String d(int i);

    void d();

    void e(int i);

    int f(int i);

    void h();

    boolean i();
}

package com.soft.blued.ui.community.auto;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.blued.ad.ADConstants;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.module.chat.manager.SessionDataManager;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.blued.android.module.common.user.view.GroupJoinView;
import com.blued.community.auto.ICommunityOtherService;
import com.soft.blued.R;
import com.soft.blued.customview.BannerADView;
import com.soft.blued.manager.SendNotificationManager;
import com.soft.blued.ui.discover.observer.DiscoverSquareViewModel;
import com.soft.blued.ui.find.fragment.NearbyHomeFragment;
import com.soft.blued.ui.find.observer.NearbyViewModel;
import com.soft.blued.ui.find.observer.PersonalVerifyObserver;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.manager.DateTodayManager;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.ui.user.manager.AvatarWidgetManager;
import com.soft.blued.ui.user.manager.DynamicSkinManager;
import com.soft.blued.ui.user.presenter.PayUtils;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/community/auto/CommunityOtherServiceImpl.class */
public class CommunityOtherServiceImpl implements ICommunityOtherService {
    public View a(Context context) {
        return new BannerADView(context);
    }

    public String a() {
        return "MAIN";
    }

    public void a(Fragment fragment) {
        if (fragment instanceof NearbyHomeFragment) {
            ((NearbyHomeFragment) fragment).x();
        }
    }

    public void a(ActivityFragmentActive activityFragmentActive, BluedADExtra bluedADExtra, final View view, final View view2) {
        if (view instanceof BannerADView) {
            ((BannerADView) view).a(activityFragmentActive, bluedADExtra, ADConstants.AD_POSITION.FEED_DETAILS, new BannerADView.ADListener() { // from class: com.soft.blued.ui.community.auto.CommunityOtherServiceImpl.1
                @Override // com.soft.blued.customview.BannerADView.ADListener
                public void a() {
                    View view3 = view;
                    if (view3 == null || view2 == null) {
                        return;
                    }
                    view3.setVisibility(8);
                    view2.setVisibility(8);
                }

                @Override // com.soft.blued.customview.BannerADView.ADListener
                public void b() {
                    View view3 = view;
                    if (view3 == null || view2 == null) {
                        return;
                    }
                    view3.setVisibility(8);
                    view2.setVisibility(8);
                }
            });
        }
    }

    public void a(GroupJoinView groupJoinView, int i, List<GroupInfoModel> list, ActivityFragmentActive activityFragmentActive) {
        GroupUtil.a(groupJoinView, i, 1, list, activityFragmentActive);
    }

    public void a(Long l, int i) {
        SessionDataManager.getInstance().updateFollower(l.longValue(), i);
    }

    public void a(List<GroupInfoModel> list) {
        GroupUtil.b(list);
    }

    public void a(boolean z) {
        SendNotificationManager.a().b = z;
    }

    public void b(Context context, int i, String str) {
        PayUtils.a(context, i, str);
    }

    public boolean b(int i) {
        return i != 0;
    }

    public String c(int i) {
        return DynamicSkinManager.a().a(i);
    }

    public void c() {
        PersonalVerifyObserver.a().b();
    }

    public String d(int i) {
        return AvatarWidgetManager.a().a(i);
    }

    public void d() {
        if (HomeActivity.f17295c != null) {
            ((NearbyViewModel) ViewModelProviders.of((FragmentActivity) HomeActivity.f17295c).get(NearbyViewModel.class)).d.postValue(null);
        }
    }

    public void e(int i) {
        ChatHelperV4.a().a(i);
    }

    public int f(int i) {
        return i != 1 ? i != 2 ? i != 3 ? R.drawable.icon_living : R.drawable.icon_live_blind_dating : R.drawable.icon_live_friending : R.drawable.icon_live_pking;
    }

    public void h() {
        if (HomeActivity.f17295c != null) {
            ((DiscoverSquareViewModel) ViewModelProviders.of((FragmentActivity) HomeActivity.f17295c).get(DiscoverSquareViewModel.class)).b.postValue(null);
        }
    }

    public boolean i() {
        if (DateTodayManager.f18714a.e()) {
            AppMethods.d((int) R.string.date_today_flash_toast);
            return true;
        }
        return false;
    }
}

package com.soft.blued.ui.mine.presenter;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.common.user.model.UserInfo;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.http.ProfileHttpUtils;
import com.soft.blued.ui.home.HomeTabClick;
import com.soft.blued.ui.mine.model.MineEntryInfo;
import com.soft.blued.ui.setting.model.BluedBlackList;
import com.soft.blued.ui.user.model.UserInfoEntity;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/presenter/MinePresenter.class */
public class MinePresenter extends MvpPresenter implements HomeTabClick.TabClickListener {
    private String h;
    private UserInfoEntity i;
    private boolean j;
    private boolean k;

    private void d(IFetchDataListener iFetchDataListener) {
        MineHttpUtils.a(e(iFetchDataListener), UserInfo.getInstance().getLoginUserInfo().getUid(), g());
    }

    private BluedUIHttpResponse e(final IFetchDataListener iFetchDataListener) {
        return new BluedUIHttpResponse<BluedEntityA<MineEntryInfo>>("my_page", g()) { // from class: com.soft.blued.ui.mine.presenter.MinePresenter.4
            private void a(MineEntryInfo mineEntryInfo) {
                MinePresenter.this.h = mineEntryInfo.getVipCenterUrl();
                MinePresenter.this.i = mineEntryInfo.user;
                if (mineEntryInfo.user != null && UserInfo.getInstance().getLoginUserInfo() != null) {
                    UserInfo.getInstance().getLoginUserInfo().vip_grade = mineEntryInfo.user.vip_grade;
                    UserInfo.getInstance().getLoginUserInfo().is_vip_annual = mineEntryInfo.user.is_vip_annual;
                    UserInfo.getInstance().getLoginUserInfo().is_show_vip_page = mineEntryInfo.user.is_show_vip_page;
                    UserInfo.getInstance().getLoginUserInfo().setBlackCount(mineEntryInfo.black_count);
                    UserInfo.getInstance().getLoginUserInfo().setBlackMax(mineEntryInfo.black_allowed_count);
                    UserInfo.getInstance().getLoginUserInfo().is_invisible_all = mineEntryInfo.user.is_invisible_all;
                    UserInfo.getInstance().getLoginUserInfo().is_invisible_half = mineEntryInfo.user.is_invisible_half;
                    if (mineEntryInfo.user.vip_avatars != null && mineEntryInfo.user.vip_avatars.size() > 0) {
                        UserInfo.getInstance().getLoginUserInfo().setVip_avatars(mineEntryInfo.user.vip_avatars);
                    }
                }
                UserInfoEntity userInfoEntity = mineEntryInfo.user;
                if (userInfoEntity == null || UserInfo.getInstance().getLoginUserInfo() == null) {
                    return;
                }
                UserInfo.getInstance().getLoginUserInfo().setName(userInfoEntity.name);
                UserInfo.getInstance().getLoginUserInfo().setAvatar(userInfoEntity.avatar);
                UserInfo.getInstance().getLoginUserInfo().setVBadge(userInfoEntity.vbadge);
                UserInfo.getInstance().getLoginUserInfo().setFollowedCount(userInfoEntity.followed_count);
                UserInfo.getInstance().getLoginUserInfo().setFollowerCount(userInfoEntity.followers_count);
                UserInfo.getInstance().getLoginUserInfo().setMyTicktocksCount(userInfoEntity.my_ticktocks_count);
                UserInfo.getInstance().getLoginUserInfo().setRich_level(userInfoEntity.rich_level);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUICache(BluedEntityA<MineEntryInfo> bluedEntityA) {
                super.onUICache(bluedEntityA);
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                a((MineEntryInfo) bluedEntityA.getSingleData());
                MinePresenter.this.a("MY_PAGE", (MineEntryInfo) bluedEntityA.getSingleData());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: b */
            public void onUIUpdate(BluedEntityA<MineEntryInfo> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                a((MineEntryInfo) bluedEntityA.getSingleData());
                MinePresenter.this.a("MY_PAGE", (MineEntryInfo) bluedEntityA.getSingleData());
            }

            public void onUIFinish(boolean z) {
                super.onUIFinish();
                IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                if (iFetchDataListener2 != null) {
                    iFetchDataListener2.a(z);
                }
            }
        };
    }

    private BluedUIHttpResponse f(IFetchDataListener iFetchDataListener) {
        return new BluedUIHttpResponse<BluedEntityA<BluedBlackList.privacySettingEntity>>("my_privacy_setting", g()) { // from class: com.soft.blued.ui.mine.presenter.MinePresenter.5
            private void c(BluedEntityA<BluedBlackList.privacySettingEntity> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                MinePresenter.this.j = ((BluedBlackList.privacySettingEntity) bluedEntityA.data.get(0)).is_hide_last_operate == 1;
                MinePresenter minePresenter = MinePresenter.this;
                boolean z = false;
                if (((BluedBlackList.privacySettingEntity) bluedEntityA.data.get(0)).is_hide_distance == 1) {
                    z = true;
                }
                minePresenter.k = z;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public BluedEntityA<BluedBlackList.privacySettingEntity> parseData(String str) {
                return super.parseData(str);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUICache(BluedEntityA<BluedBlackList.privacySettingEntity> bluedEntityA) {
                super.onUICache(bluedEntityA);
                c(bluedEntityA);
            }

            /* renamed from: b */
            public void onUIUpdate(BluedEntityA<BluedBlackList.privacySettingEntity> bluedEntityA) {
                c(bluedEntityA);
            }

            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                MinePresenter.this.f_("PRIVACY");
            }
        };
    }

    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
    }

    public void a(final LifecycleOwner lifecycleOwner) {
        super.a(lifecycleOwner);
        HomeTabClick.a("mine", this);
        lifecycleOwner.getLifecycle().addObserver(new LifecycleObserver() { // from class: com.soft.blued.ui.mine.presenter.MinePresenter.1
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public void onDestroy() {
                HomeTabClick.b("mine", MinePresenter.this);
                lifecycleOwner.getLifecycle().removeObserver(this);
            }
        });
        LiveEventBus.get("feed_avatar_widget", Integer.class).observe(lifecycleOwner, new Observer<Integer>() { // from class: com.soft.blued.ui.mine.presenter.MinePresenter.2
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Integer num) {
                MinePresenter.this.a("PRIVACY", num);
            }
        });
        LiveEventBus.get(EventBusConstant.KEY_EVENT_REFRESH_USER_VIP_INFO, Boolean.class).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.soft.blued.ui.mine.presenter.MinePresenter.3
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Boolean bool) {
                MinePresenter.this.a((IFetchDataListener) null);
            }
        });
    }

    public void a(IFetchDataListener iFetchDataListener) {
        d(iFetchDataListener);
        c(iFetchDataListener);
    }

    public void a(final boolean z, final boolean z2) {
        Map a2 = BluedHttpTools.a();
        a2.put("is_hide_last_operate", z ? "1" : "0");
        a2.put("is_hide_distance", z2 ? "1" : "0");
        ProfileHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>(g()) { // from class: com.soft.blued.ui.mine.presenter.MinePresenter.6
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                if (bluedEntityA == null) {
                    AppMethods.a(AppInfo.d().getResources().getString(2131887272));
                    return;
                }
                AppMethods.a(AppInfo.d().getResources().getString(R.string.lock_pattern_success_set));
                MinePresenter.this.j = z;
                MinePresenter.this.k = z2;
                MinePresenter.this.f_("PRIVACY");
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), a2);
    }

    public void b(IFetchDataListener iFetchDataListener) {
    }

    public void c(IFetchDataListener iFetchDataListener) {
        ProfileHttpUtils.a(h(), f(iFetchDataListener), UserInfo.getInstance().getLoginUserInfo().getUid(), g());
    }

    @Override // com.soft.blued.ui.home.HomeTabClick.TabClickListener
    public void c(String str) {
        if ("mine".equals(str)) {
            a("TAB_CLICK", false);
        }
    }

    public boolean c() {
        return true;
    }

    @Override // com.soft.blued.ui.home.HomeTabClick.TabClickListener
    public void d(String str) {
        c(str);
    }

    public void k() {
        e(null).refresh();
        f(null).refresh();
    }

    public String[] l() {
        return new String[]{"MY_PAGE"};
    }

    public String m() {
        return this.h;
    }

    public UserInfoEntity n() {
        UserInfoEntity userInfoEntity = this.i;
        UserInfoEntity userInfoEntity2 = userInfoEntity;
        if (userInfoEntity == null) {
            userInfoEntity2 = new UserInfoEntity();
        }
        return userInfoEntity2;
    }
}

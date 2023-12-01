package com.soft.blued.ui.mine.vm;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.UserInfo;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.ui.mine.model.MineAdModel;
import com.soft.blued.ui.mine.model.MinePageAdModel;
import com.soft.blued.ui.mine.model.MinePageModel;
import com.soft.blued.ui.msg.model.GroupGuideModel;
import com.soft.blued.ui.user.model.UserInfoEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/vm/MineViewModel.class */
public final class MineViewModel extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    private final MutableLiveData<MinePageModel> f31654a = new MutableLiveData<>();
    private final MutableLiveData<MinePageAdModel> b = new MutableLiveData<>();

    /* renamed from: c  reason: collision with root package name */
    private final MutableLiveData<GroupGuideModel> f31655c = new MutableLiveData<>();

    private final void c(ActivityFragmentActive activityFragmentActive) {
        MineHttpUtils.a(f(activityFragmentActive), activityFragmentActive);
    }

    private final void d(ActivityFragmentActive activityFragmentActive) {
        MineHttpUtils.b(e(activityFragmentActive), activityFragmentActive);
    }

    private final BluedUIHttpResponse<?> e(final ActivityFragmentActive activityFragmentActive) {
        return new BluedUIHttpResponse<BluedEntityA<MineAdModel>>(this) { // from class: com.soft.blued.ui.mine.vm.MineViewModel$getLaunchCallBack$1
            final /* synthetic */ MineViewModel b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(ActivityFragmentActive.this);
                this.b = this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<MineAdModel> bluedEntityA) {
                if (bluedEntityA != null && bluedEntityA.hasData()) {
                    MineAdModel singleData = bluedEntityA.getSingleData();
                    if ((singleData == null ? null : singleData.get_10002()) != null) {
                        List<MinePageAdModel> _10002 = singleData.get_10002();
                        boolean z = true;
                        if (_10002 != null) {
                            z = _10002.isEmpty();
                        }
                        if (z) {
                            return;
                        }
                        List<MinePageAdModel> _100022 = singleData.get_10002();
                        Intrinsics.a(_100022);
                        MinePageAdModel minePageAdModel = _100022.get(0);
                        this.b.e().setValue(minePageAdModel);
                        Log.v("drb", Intrinsics.a("浮窗广告数据：", (Object) minePageAdModel));
                    }
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
            }
        };
    }

    private final BluedUIHttpResponse<?> f(final ActivityFragmentActive activityFragmentActive) {
        return new BluedUIHttpResponse<BluedEntityA<MinePageModel>>(this) { // from class: com.soft.blued.ui.mine.vm.MineViewModel$getCallBack$1
            final /* synthetic */ MineViewModel b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super("mine_page", ActivityFragmentActive.this);
                this.b = this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public BluedEntityA<MinePageModel> parseData(String str) {
                return (BluedEntityA) super.parseData(str);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUICache(BluedEntityA<MinePageModel> bluedEntityA) {
                MinePageModel singleData;
                super.onUICache(bluedEntityA);
                UserInfoEntity userInfoEntity = (bluedEntityA == null || (singleData = bluedEntityA.getSingleData()) == null) ? null : singleData.user;
                if (userInfoEntity != null) {
                    userInfoEntity.visit_increase = null;
                }
                this.b.d().setValue(bluedEntityA == null ? null : bluedEntityA.getSingleData());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: b */
            public void onUIUpdate(BluedEntityA<MinePageModel> bluedEntityA) {
                MinePageModel singleData;
                UserInfoEntity userInfoEntity;
                BluedLoginResult loginUserInfo;
                if (bluedEntityA != null && (singleData = bluedEntityA.getSingleData()) != null && (userInfoEntity = singleData.user) != null && (loginUserInfo = UserInfo.getInstance().getLoginUserInfo()) != null) {
                    loginUserInfo.vip_grade = userInfoEntity.vip_grade;
                    loginUserInfo.expire_type = userInfoEntity.expire_type;
                    loginUserInfo.is_vip_annual = userInfoEntity.is_vip_annual;
                    loginUserInfo.is_show_vip_page = userInfoEntity.is_show_vip_page;
                    loginUserInfo.is_invisible_all = userInfoEntity.is_invisible_all;
                    loginUserInfo.is_invisible_half = userInfoEntity.is_invisible_half;
                    if (userInfoEntity.vip_avatars != null && userInfoEntity.vip_avatars.size() > 0) {
                        loginUserInfo.setVip_avatars(userInfoEntity.vip_avatars);
                    }
                    loginUserInfo.avatar_audited = userInfoEntity.avatar_audited;
                    loginUserInfo.is_audited = userInfoEntity.is_audited;
                    loginUserInfo.setName(userInfoEntity.name);
                    loginUserInfo.setAvatar(userInfoEntity.avatar);
                    loginUserInfo.setVBadge(userInfoEntity.vbadge);
                    loginUserInfo.setFollowedCount(userInfoEntity.followed_count);
                    loginUserInfo.setFollowerCount(userInfoEntity.followers_count);
                    loginUserInfo.setMyTicktocksCount(userInfoEntity.my_ticktocks_count);
                    loginUserInfo.setRich_level(userInfoEntity.rich_level);
                    loginUserInfo.avatar_frame = userInfoEntity.avatar_frame;
                    loginUserInfo.avatar_frame_type = userInfoEntity.avatar_frame_type;
                    loginUserInfo.setGroupsCount(String.valueOf(userInfoEntity.groups_count));
                    loginUserInfo.is_audited = userInfoEntity.is_audited;
                    loginUserInfo.avatar_audited = userInfoEntity.avatar_audited;
                    loginUserInfo.auditing_profile = userInfoEntity.auditing_profile;
                }
                this.b.d().setValue(bluedEntityA == null ? null : bluedEntityA.getSingleData());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                this.b.a(z);
            }
        };
    }

    public final void a(ActivityFragmentActive fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        c(fragmentActive);
        d(fragmentActive);
        b(fragmentActive);
    }

    public final void b(final ActivityFragmentActive fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        ChatHttpUtils.f(new BluedUIHttpResponse<BluedEntityA<GroupGuideModel>>(this) { // from class: com.soft.blued.ui.mine.vm.MineViewModel$getGroupGuideData$1
            final /* synthetic */ MineViewModel b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(ActivityFragmentActive.this);
                this.b = this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<GroupGuideModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                this.b.f().setValue(bluedEntityA.getSingleData());
            }
        });
    }

    public final MutableLiveData<MinePageModel> d() {
        return this.f31654a;
    }

    public final MutableLiveData<MinePageAdModel> e() {
        return this.b;
    }

    public final MutableLiveData<GroupGuideModel> f() {
        return this.f31655c;
    }
}

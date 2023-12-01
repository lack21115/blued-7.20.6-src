package com.soft.blued.user;

import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.ui.xpop.interfaces.SimpleCallback;
import com.blued.android.module.common.db.UserAccountsVDao;
import com.blued.android.module.common.db.model.UserAccountsModel;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.CommonPreferences;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.mine.model.UserUnreadMsgModel;
import com.soft.blued.ui.mine.pop.UnreadMsgPop;
import com.soft.blued.utils.BluedPreferences;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/user/UserInfoUtils.class */
public class UserInfoUtils {
    public static void a(final HomeActivity.TabItem tabItem) {
        if (tabItem == null) {
            return;
        }
        ThreadManager.a().a(new ThreadExecutor("getUnreadMsgCnt") { // from class: com.soft.blued.user.UserInfoUtils.1
            public void execute() {
                CopyOnWriteArrayList h = UserAccountsVDao.a().h();
                if (h == null || h.size() <= 1) {
                    return;
                }
                UserAccountsModel userAccountsModel = (UserAccountsModel) h.get(1);
                if (userAccountsModel.getUid().equals(UserInfo.getInstance().getLoginUserInfo().uid)) {
                    return;
                }
                UserHttpUtils.d(new BluedUIHttpResponse<BluedEntityA<UserUnreadMsgModel>>(null) { // from class: com.soft.blued.user.UserInfoUtils.1.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    /* renamed from: a */
                    public void onUIUpdate(BluedEntityA<UserUnreadMsgModel> bluedEntityA) {
                        if (!bluedEntityA.hasData() || ((UserUnreadMsgModel) bluedEntityA.data.get(0)).has_unread == 0) {
                            tabItem.i.setVisibility(4);
                            BluedPreferences.Z(false);
                            return;
                        }
                        BluedPreferences.t(((UserUnreadMsgModel) bluedEntityA.data.get(0)).has_unread);
                        BluedPreferences.Z(true);
                        CommonPreferences.a(true);
                        tabItem.i.setVisibility(0);
                        if (BluedPreferences.dJ()) {
                            return;
                        }
                        new XPopup.Builder(tabItem.f17320a.getContext()).a(new SimpleCallback() { // from class: com.soft.blued.user.UserInfoUtils.1.1.1
                            public void c(BasePopupView basePopupView) {
                                BluedPreferences.dK();
                            }
                        }).a(PopupAnimation.a).a(PopupPosition.c).d(false).b(false).a(tabItem.f17320a).a(new UnreadMsgPop(tabItem.f17320a.getContext())).h();
                    }
                }, userAccountsModel.getUid(), null);
            }
        });
    }
}

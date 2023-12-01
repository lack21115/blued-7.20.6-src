package com.blued.android.module.common.db;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.module.common.db.model.UserAccountsModel;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.CommonPreferences;
import com.google.gson.Gson;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/db/UserAccountsVDao.class */
public class UserAccountsVDao {
    private static UserAccountsVDao a;
    private Dao<UserAccountsModel, Integer> b;
    private String c;

    public static UserAccountsVDao a() {
        if (a == null) {
            synchronized (UserAccountsVDao.class) {
                try {
                    if (a == null) {
                        a = new UserAccountsVDao();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    public UserAccountsModel a(int i) {
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            queryBuilder.where().eq("loginType", Integer.valueOf(i));
            queryBuilder.orderBy("lastHandleTime", false);
            List query = queryBuilder.query();
            if (query == null || query.size() <= 0) {
                return null;
            }
            return (UserAccountsModel) query.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public UserAccountsModel a(String str) {
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            queryBuilder.where().eq("uid", str);
            List query = queryBuilder.query();
            if (query == null || query.size() <= 0) {
                return null;
            }
            return (UserAccountsModel) query.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a(UserAccountsModel userAccountsModel) {
        try {
            Dao<UserAccountsModel, Integer> b = b();
            QueryBuilder queryBuilder = b.queryBuilder();
            queryBuilder.where().eq("uid", userAccountsModel.getUid());
            List query = queryBuilder.query();
            if (query == null || query.size() <= 0) {
                b.create(userAccountsModel);
                return;
            }
            UserAccountsModel userAccountsModel2 = (UserAccountsModel) query.get(0);
            userAccountsModel2.setLoginresult(userAccountsModel.getLoginresult());
            userAccountsModel2.setUid(userAccountsModel.getUid());
            userAccountsModel2.setUsername(userAccountsModel.getUsername());
            userAccountsModel2.setLastHandleTime(userAccountsModel.getLastHandleTime());
            userAccountsModel2.setAccessToken(userAccountsModel.getAccessToken());
            userAccountsModel2.setLoginType(userAccountsModel.getLoginType());
            if (!TextUtils.isEmpty(userAccountsModel.getAliasUserId())) {
                userAccountsModel2.setAliasUserId(userAccountsModel.getAliasUserId());
            }
            b.update(userAccountsModel2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Dao<UserAccountsModel, Integer> b() {
        try {
            if (this.b == null) {
                this.b = BluedBaseDataHelper.a().getDao(UserAccountsModel.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.b;
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Dao<UserAccountsModel, Integer> b = b();
            List queryForAll = b.queryForAll();
            if (queryForAll == null || queryForAll.size() <= 0) {
                return;
            }
            UserAccountsModel userAccountsModel = (UserAccountsModel) queryForAll.get(0);
            userAccountsModel.setLoginresult(str);
            b.update(userAccountsModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public UserAccountsModel c() {
        try {
            List queryForAll = b().queryForAll();
            return (queryForAll == null || queryForAll.size() <= 0) ? (queryForAll == null || queryForAll.size() == 0) ? null : null : (UserAccountsModel) queryForAll.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.c)) {
            return;
        }
        UserAccountsModel a2 = a().a(str);
        if (a2 != null) {
            a2.setAccessToken(this.c);
            try {
                a().b().update(a2);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        this.c = null;
    }

    public UserAccountsModel d() {
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            queryBuilder.orderBy("lastHandleTime", false);
            List query = queryBuilder.query();
            if (query == null || query.size() <= 0) {
                return null;
            }
            return (UserAccountsModel) query.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public UserAccountsModel e() {
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            queryBuilder.where().eq("loginType", 0).or().eq("loginType", 1);
            queryBuilder.orderBy("lastHandleTime", false);
            List query = queryBuilder.query();
            if (query == null || query.size() <= 0) {
                return null;
            }
            return (UserAccountsModel) query.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void f() {
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            queryBuilder.where().eq("uid", UserInfo.getInstance().getLoginUserInfo().getUid());
            List query = queryBuilder.query();
            if (query == null || query.size() <= 0) {
                return;
            }
            UserAccountsModel userAccountsModel = (UserAccountsModel) query.get(0);
            userAccountsModel.setAccessToken("");
            this.b.update(userAccountsModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void g() {
        try {
            if (TextUtils.isEmpty(CommonPreferences.f())) {
                return;
            }
            UserAccountsModel userAccountsModel = new UserAccountsModel();
            userAccountsModel.setExtra("");
            userAccountsModel.setLoginresult("");
            userAccountsModel.setUid("");
            userAccountsModel.setUsername(CommonPreferences.f());
            userAccountsModel.setLastHandleTime(System.currentTimeMillis());
            userAccountsModel.setLoginType(CommonPreferences.g());
            userAccountsModel.setAccessToken("");
            a().a(userAccountsModel);
            CommonPreferences.u("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CopyOnWriteArrayList<UserAccountsModel> h() {
        Dao<UserAccountsModel, Integer> b;
        UserAccountsModel userAccountsModel;
        CopyOnWriteArrayList<UserAccountsModel> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            b = b();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (b == null) {
            return copyOnWriteArrayList;
        }
        QueryBuilder queryBuilder = b.queryBuilder();
        queryBuilder.orderBy("lastHandleTime", false);
        List query = queryBuilder.query();
        if (!TypeUtils.a((List<?>) query) && AppInfo.m()) {
            Gson f = AppInfo.f();
            Iterator it = query.iterator();
            int i = 0;
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    break;
                }
                LogUtils.c("AllAccount(" + i2 + "): " + f.toJson((UserAccountsModel) it.next()));
                i = i2 + 1;
            }
        }
        UserAccountsModel userAccountsModel2 = null;
        Iterator it2 = query.iterator();
        do {
            if (!it2.hasNext()) {
                return copyOnWriteArrayList;
            }
            UserAccountsModel userAccountsModel3 = (UserAccountsModel) it2.next();
            if (userAccountsModel3.getUid().equals(UserInfo.getInstance().getLoginUserInfo().uid)) {
                userAccountsModel3.setBluedLoginResult(UserInfo.getInstance().getLoginUserInfo());
                copyOnWriteArrayList.add(0, userAccountsModel3);
                userAccountsModel = userAccountsModel3;
            } else {
                userAccountsModel = userAccountsModel2;
                if (userAccountsModel2 != null) {
                    userAccountsModel = userAccountsModel2;
                    if (!TextUtils.isEmpty(userAccountsModel2.getAliasUserId())) {
                        userAccountsModel = userAccountsModel2;
                        if (userAccountsModel2.getAliasUserId().equals(userAccountsModel3.getUid())) {
                            userAccountsModel3.setBluedLoginResult(UserInfo.getInstance().getLoginResultForV1(userAccountsModel3));
                            copyOnWriteArrayList.add(userAccountsModel3);
                            userAccountsModel = userAccountsModel2;
                        }
                    }
                }
            }
            userAccountsModel2 = userAccountsModel;
        } while (copyOnWriteArrayList.size() != 2);
        return copyOnWriteArrayList;
    }

    public void i() {
        this.c = UserInfo.getInstance().getAccessToken();
        UserInfo.getInstance().logout(false);
    }
}

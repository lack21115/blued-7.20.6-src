package com.blued.android.module.common.db;

import com.blued.android.module.common.db.model.NewFeedModel;
import com.blued.android.module.common.user.model.UserInfo;
import com.j256.ormlite.dao.Dao;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/db/NewFeedDao.class */
public class NewFeedDao {
    private static NewFeedDao a;
    private Dao<NewFeedModel, Integer> b;

    public static NewFeedDao a() {
        if (a == null) {
            synchronized (NewFeedDao.class) {
                try {
                    if (a == null) {
                        a = new NewFeedDao();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    public void a(int i) {
        try {
            b().deleteById(Integer.valueOf(i));
        } catch (Exception e) {
        }
    }

    public void a(NewFeedModel newFeedModel) {
        try {
            b().create(newFeedModel);
        } catch (Exception e) {
        }
    }

    public Dao<NewFeedModel, Integer> b() {
        try {
            if (this.b == null) {
                this.b = BluedBaseDataHelper.a().getDao(NewFeedModel.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.b;
    }

    public void b(NewFeedModel newFeedModel) {
        try {
            b().createOrUpdate(newFeedModel);
        } catch (Exception e) {
        }
    }

    public List<NewFeedModel> c() {
        try {
            return b().queryBuilder().where().eq("loadName", UserInfo.getInstance().getLoginUserInfo().getUid()).query();
        } catch (Exception e) {
            return new ArrayList();
        }
    }

    public void c(NewFeedModel newFeedModel) {
        try {
            b().update(newFeedModel);
        } catch (Exception e) {
        }
    }

    public List<NewFeedModel> d() {
        ArrayList arrayList = new ArrayList();
        for (NewFeedModel newFeedModel : c()) {
            if (newFeedModel.is_draft != 1) {
                arrayList.add(newFeedModel);
            }
        }
        return arrayList;
    }

    public void d(NewFeedModel newFeedModel) {
        try {
            b().delete(newFeedModel);
        } catch (Exception e) {
        }
    }

    public void e() {
        try {
            for (NewFeedModel newFeedModel : c()) {
                if (newFeedModel.is_draft == 1) {
                    a(newFeedModel.getId());
                }
            }
        } catch (Exception e) {
        }
    }
}

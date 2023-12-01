package com.soft.blued.ui.setting.Presenter;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.common.user.model.UserInfo;
import com.soft.blued.http.MineHttpUtils;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Presenter/MessageNotifyPresenter.class */
public class MessageNotifyPresenter extends MvpPresenter {
    public void a(IFetchDataListener iFetchDataListener) {
    }

    public void a(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        MineHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.setting.Presenter.MessageNotifyPresenter.1
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), map, (IRequestHost) null);
    }

    public void b(IFetchDataListener iFetchDataListener) {
    }
}

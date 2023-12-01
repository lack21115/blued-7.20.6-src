package com.soft.blued.ui.msg.presenter;

import com.blued.android.chat.ChatManager;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/presenter/SelectSessionPresenter.class */
public class SelectSessionPresenter extends MvpPresenter {
    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(final IFetchDataListener iFetchDataListener) {
        ChatManager.getInstance().getSessionModelList(new FetchDataListener<List<SessionModel>>() { // from class: com.soft.blued.ui.msg.presenter.SelectSessionPresenter.1
            @Override // com.blued.android.chat.listener.FetchDataListener
            /* renamed from: a */
            public void onFetchData(List<SessionModel> list) {
                ChatHelperV4.a(list, true);
                iFetchDataListener.a("data_session", list);
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
    }
}

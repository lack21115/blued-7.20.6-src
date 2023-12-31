package com.soft.blued.ui.msg_group.presenter;

import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.soft.blued.http.MsgGroupHttpUtils;
import com.soft.blued.ui.msg_group.model.MyGroupModel;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/presenter/MyGroupPresenter.class */
public class MyGroupPresenter extends MvpPresenter {
    public int h = 1;
    int i = 20;
    public int j;

    private void c(final IFetchDataListener iFetchDataListener) {
        MsgGroupHttpUtils.a(g(), this.h, this.i, new BluedUIHttpResponse<BluedEntityA<MyGroupModel>>(g()) { // from class: com.soft.blued.ui.msg_group.presenter.MyGroupPresenter.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<MyGroupModel> bluedEntityA) {
                if (bluedEntityA.hasData()) {
                    MyGroupPresenter.this.j = ((MyGroupModel) bluedEntityA.data.get(0)).max_join;
                    iFetchDataListener.a("data_group", ((MyGroupModel) bluedEntityA.data.get(0)).groups);
                    iFetchDataListener.b(bluedEntityA.hasMore());
                }
            }

            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (!z) {
                    MyGroupPresenter.this.h--;
                }
                iFetchDataListener.a(z);
            }

            public void onUIStart() {
                super.onUIStart();
                iFetchDataListener.a();
            }
        });
    }

    public void a(IFetchDataListener iFetchDataListener) {
        this.h = 1;
        c(iFetchDataListener);
    }

    public void b(IFetchDataListener iFetchDataListener) {
        this.h++;
        c(iFetchDataListener);
    }
}

package com.soft.blued.ui.notify.presenter;

import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.community.http.CircleHttpUtils;
import com.soft.blued.ui.notify.model.CircleNotify;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/notify/presenter/CircleNotifyListPresenter.class */
public class CircleNotifyListPresenter extends MvpPresenter {
    private int h = 1;
    private int i = 20;
    private boolean j;

    static /* synthetic */ int c(CircleNotifyListPresenter circleNotifyListPresenter) {
        int i = circleNotifyListPresenter.h;
        circleNotifyListPresenter.h = i - 1;
        return i;
    }

    private void c(final IFetchDataListener iFetchDataListener) {
        if (this.h == 1) {
            this.j = true;
        }
        if (this.j) {
            CircleHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<CircleNotify>>(g()) { // from class: com.soft.blued.ui.notify.presenter.CircleNotifyListPresenter.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<CircleNotify> bluedEntityA) {
                    if (bluedEntityA == null) {
                        CircleNotifyListPresenter.this.j = false;
                        return;
                    }
                    if (bluedEntityA.hasData()) {
                        iFetchDataListener.a("notify_list", bluedEntityA.data);
                    }
                    CircleNotifyListPresenter.this.j = bluedEntityA.hasMore();
                    IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                    if (iFetchDataListener2 != null) {
                        iFetchDataListener2.b(CircleNotifyListPresenter.this.j);
                    }
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish(boolean z) {
                    if (!z && CircleNotifyListPresenter.this.h != 1) {
                        CircleNotifyListPresenter.c(CircleNotifyListPresenter.this);
                    }
                    iFetchDataListener.a(z);
                }
            }, this.h, this.i, g());
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
        this.h = 1;
        c(iFetchDataListener);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
        this.h++;
        c(iFetchDataListener);
    }
}

package com.soft.blued.ui.notify.presenter;

import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.community.model.FeedNotice;
import com.soft.blued.http.FindHttpUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/notify/presenter/AttentionNotifyPresenter.class */
public class AttentionNotifyPresenter extends MvpPresenter {
    private boolean j;
    public int h = 1;
    private int i = 20;
    private boolean k = true;

    public String a(int i) {
        return h().getResources().getString(i);
    }

    public void a(long j) {
        FindHttpUtils.a(new BluedUIHttpResponse(g()) { // from class: com.soft.blued.ui.notify.presenter.AttentionNotifyPresenter.2
            public void onUIUpdate(BluedEntity bluedEntity) {
                AttentionNotifyPresenter.this.a("ATTENTION_NOTICE_CLEAR", false);
            }
        }, g(), "followers", String.valueOf(j));
    }

    public void a(IFetchDataListener iFetchDataListener) {
        this.h = 1;
        c(iFetchDataListener);
    }

    public void b(IFetchDataListener iFetchDataListener) {
        c(iFetchDataListener);
    }

    public void c(final IFetchDataListener iFetchDataListener) {
        FindHttpUtils.a(new BluedUIHttpResponse<BluedEntity<FeedNotice, BluedEntityBaseExtra>>(g()) { // from class: com.soft.blued.ui.notify.presenter.AttentionNotifyPresenter.1
            public boolean onUIFailure(int i, String str) {
                AttentionNotifyPresenter.this.j = false;
                AttentionNotifyPresenter.this.k = false;
                return super.onUIFailure(i, str);
            }

            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                iFetchDataListener.a(z);
                if (AttentionNotifyPresenter.this.k) {
                    return;
                }
                AttentionNotifyPresenter.this.a("SHOW_LOAD_ERROR", false);
            }

            public void onUIStart() {
                super.onUIStart();
            }

            public void onUIUpdate(BluedEntity<FeedNotice, BluedEntityBaseExtra> bluedEntity) {
                if (bluedEntity == null || bluedEntity.data == null || bluedEntity.data.isEmpty()) {
                    AttentionNotifyPresenter.this.j = false;
                    return;
                }
                AttentionNotifyPresenter.this.j = bluedEntity.hasMore();
                iFetchDataListener.a("ATTENTION_NOTICE_LIST", bluedEntity.data);
                iFetchDataListener.b(AttentionNotifyPresenter.this.j);
                if (AttentionNotifyPresenter.this.j) {
                    AttentionNotifyPresenter.this.h++;
                }
            }
        }, "followers", this.h, this.i, g());
    }
}

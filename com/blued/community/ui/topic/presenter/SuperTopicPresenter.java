package com.blued.community.ui.topic.presenter;

import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.community.ui.topic.model.BluedTopicExtra;

/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/topic/presenter/SuperTopicPresenter.class */
public class SuperTopicPresenter extends MvpPresenter {
    private int h = 1;
    private int i = 20;
    private boolean j = true;

    static /* synthetic */ int b(SuperTopicPresenter superTopicPresenter) {
        int i = superTopicPresenter.h;
        superTopicPresenter.h = i - 1;
        return i;
    }

    private void c(IFetchDataListener iFetchDataListener) {
        FeedHttpUtils.b(h(), d(iFetchDataListener), this.h + "", this.i + "", g());
    }

    private BluedUIHttpResponse d(final IFetchDataListener iFetchDataListener) {
        return new BluedUIHttpResponse<BluedEntity<BluedTopic, BluedTopicExtra>>(g()) { // from class: com.blued.community.ui.topic.presenter.SuperTopicPresenter.1
            private void a(BluedEntity<BluedTopic, BluedTopicExtra> bluedEntity) {
                if (bluedEntity != null) {
                    IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                    if (iFetchDataListener2 != null) {
                        iFetchDataListener2.a("data_list", bluedEntity.data);
                    } else {
                        SuperTopicPresenter.this.a("data_list", (String) bluedEntity.data);
                    }
                    SuperTopicPresenter.this.j = bluedEntity.hasMore();
                } else {
                    SuperTopicPresenter.this.j = false;
                }
                IFetchDataListener iFetchDataListener3 = iFetchDataListener;
                if (iFetchDataListener3 != null) {
                    iFetchDataListener3.b(SuperTopicPresenter.this.j);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUICache(BluedEntity<BluedTopic, BluedTopicExtra> bluedEntity) {
                a(bluedEntity);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (!z) {
                    SuperTopicPresenter.b(SuperTopicPresenter.this);
                }
                IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                if (iFetchDataListener2 != null) {
                    iFetchDataListener2.a(z);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<BluedTopic, BluedTopicExtra> bluedEntity) {
                a(bluedEntity);
            }
        };
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

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void k() {
        d((IFetchDataListener) null).refresh();
    }
}

package com.blued.community.ui.circle.presenter;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.community.http.CircleHttpUtils;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.circle.model.CircleHotPostExtra;
import com.blued.community.ui.circle.model.MyCircleExtra;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.blued.community.ui.topic.model.BluedTopicExtra;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/presenter/CirclePresenter.class */
public class CirclePresenter extends MvpPresenter {
    public int h = 1;
    public boolean i;

    private void c(final IFetchDataListener iFetchDataListener) {
        CircleHttpUtils.a(new BluedUIHttpResponse<BluedEntity<BluedIngSelfFeed, BluedTopicExtra>>(g()) { // from class: com.blued.community.ui.circle.presenter.CirclePresenter.2
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                CirclePresenter.this.a("data_base_talk_list_error", false);
                if (CirclePresenter.this.h > 0) {
                    CirclePresenter.this.h--;
                }
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                if (iFetchDataListener2 != null) {
                    iFetchDataListener2.a(z);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<BluedIngSelfFeed, BluedTopicExtra> bluedEntity) {
                if (bluedEntity != null) {
                    CirclePresenter.this.i = bluedEntity.hasMore();
                    iFetchDataListener.a("data_base_talk_list", bluedEntity.data);
                    iFetchDataListener.b(CirclePresenter.this.i);
                }
            }
        }, this.h, 20);
    }

    private void d(final IFetchDataListener iFetchDataListener) {
        CircleHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<MyCircleModel>>(g()) { // from class: com.blued.community.ui.circle.presenter.CirclePresenter.3
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<MyCircleModel> bluedEntityA) {
                if (bluedEntityA != null) {
                    iFetchDataListener.a("data_my_new_base_list", bluedEntityA.data);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                CirclePresenter.this.a("data_my_new_base_list_error", false);
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                CirclePresenter.this.a("data_my_new_base_list_finish", false);
            }
        }, 1);
    }

    private void e(final IFetchDataListener iFetchDataListener) {
        CircleHttpUtils.a(new BluedUIHttpResponse<BluedEntity<MyCircleModel, MyCircleExtra>>(g()) { // from class: com.blued.community.ui.circle.presenter.CirclePresenter.4
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    return;
                }
                CirclePresenter.this.f_("data_recommend_list_error");
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<MyCircleModel, MyCircleExtra> bluedEntity) {
                if (bluedEntity != null) {
                    iFetchDataListener.a("data_recommend_list", bluedEntity.data);
                }
            }
        }, g());
    }

    private void f(final IFetchDataListener iFetchDataListener) {
        CircleHttpUtils.b(new BluedUIHttpResponse<BluedEntity<BluedIngSelfFeed, CircleHotPostExtra>>(g()) { // from class: com.blued.community.ui.circle.presenter.CirclePresenter.5
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    return;
                }
                iFetchDataListener.a("data_hot_rank_list", null);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<BluedIngSelfFeed, CircleHotPostExtra> bluedEntity) {
                if (bluedEntity != null) {
                    iFetchDataListener.a("data_hot_rank_list", bluedEntity.data);
                    if (bluedEntity.extra != null) {
                        CirclePresenter.this.a("data_hot_rank_time", (String) Long.valueOf(bluedEntity.extra.update_time));
                    } else {
                        CirclePresenter.this.a("data_hot_rank_time", (String) null);
                    }
                }
            }
        }, g());
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(LifecycleOwner lifecycleOwner) {
        super.a(lifecycleOwner);
        LiveEventBus.get("circle_delete_feed", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.community.ui.circle.presenter.CirclePresenter.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                CirclePresenter.this.a("data_delete_feed", str, false);
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
        this.h = 1;
        c(iFetchDataListener);
        d(iFetchDataListener);
        e(iFetchDataListener);
        f(iFetchDataListener);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
        if (!this.i) {
            iFetchDataListener.b(false);
            return;
        }
        this.h++;
        c(iFetchDataListener);
    }
}

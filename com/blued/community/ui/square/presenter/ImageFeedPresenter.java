package com.blued.community.ui.square.presenter;

import androidx.lifecycle.LifecycleOwner;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedParse;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.blued.community.ui.feed.manager.FeedMethods;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/presenter/ImageFeedPresenter.class */
public class ImageFeedPresenter extends MvpPresenter {
    private FeedListAdapterForRecyclerView h;
    private int i;
    private int j = 12;
    private boolean k = true;

    static /* synthetic */ int b(ImageFeedPresenter imageFeedPresenter) {
        int i = imageFeedPresenter.i;
        imageFeedPresenter.i = i - 1;
        return i;
    }

    private void c(IFetchDataListener iFetchDataListener) {
        FeedHttpUtils.c(h(), d(iFetchDataListener), this.i + "", this.j + "", g());
    }

    private BluedUIHttpResponse d(final IFetchDataListener iFetchDataListener) {
        return new BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>>("image_feed", g()) { // from class: com.blued.community.ui.square.presenter.ImageFeedPresenter.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public BluedEntityA<BluedIngSelfFeed> parseData(String str) {
                BluedEntityA<BluedIngSelfFeed> bluedEntityA = (BluedEntityA) super.parseData(str);
                if (bluedEntityA != null) {
                    if (!bluedEntityA.hasData()) {
                        return bluedEntityA;
                    }
                    for (BluedIngSelfFeed bluedIngSelfFeed : bluedEntityA.data) {
                        bluedIngSelfFeed.feedParse = new FeedParse(ImageFeedPresenter.this.h(), bluedIngSelfFeed, 10);
                    }
                }
                return bluedEntityA;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUICache(BluedEntityA<BluedIngSelfFeed> bluedEntityA) {
                super.onUICache(bluedEntityA);
                if (bluedEntityA != null) {
                    ImageFeedPresenter.this.a("feed_list", (String) bluedEntityA.data);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: b */
            public void onUIUpdate(BluedEntityA<BluedIngSelfFeed> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    ImageFeedPresenter.this.k = false;
                } else {
                    IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                    if (iFetchDataListener2 != null) {
                        iFetchDataListener2.a("feed_list", bluedEntityA.data);
                    } else {
                        ImageFeedPresenter.this.a("feed_list", (String) bluedEntityA.data);
                    }
                    ImageFeedPresenter.this.k = bluedEntityA.hasMore();
                }
                IFetchDataListener iFetchDataListener3 = iFetchDataListener;
                if (iFetchDataListener3 != null) {
                    iFetchDataListener3.b(ImageFeedPresenter.this.k);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                if (!z) {
                    ImageFeedPresenter.b(ImageFeedPresenter.this);
                }
                IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                if (iFetchDataListener2 != null) {
                    iFetchDataListener2.a(z);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                if (iFetchDataListener2 != null) {
                    iFetchDataListener2.a();
                }
            }
        };
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(LifecycleOwner lifecycleOwner) {
        super.a(lifecycleOwner);
        FeedMethods.a(lifecycleOwner, this.h);
        CircleMethods.a(lifecycleOwner, this.h);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
        this.i = 1;
        c(iFetchDataListener);
    }

    public void a(FeedListAdapterForRecyclerView feedListAdapterForRecyclerView) {
        this.h = feedListAdapterForRecyclerView;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
        this.i++;
        c(iFetchDataListener);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void k() {
        d((IFetchDataListener) null).refresh();
    }
}

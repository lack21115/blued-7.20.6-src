package com.blued.community.ui.video.observer;

import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedUserInfoModel;
import com.blued.community.ui.comment.model.FeedComment;
import com.blued.community.ui.feed.model.FeedRepost;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/observer/IFeedDetailContract.class */
public class IFeedDetailContract {

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/observer/IFeedDetailContract$IPresenter.class */
    public interface IPresenter extends BasePresenter {
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/observer/IFeedDetailContract$IView.class */
    public interface IView extends BaseView<IPresenter> {
        void a(List<FeedUserInfoModel> list);

        void a(List<BluedIngSelfFeed> list, int i, boolean z);

        void b(int i);

        void c(BluedIngSelfFeed bluedIngSelfFeed);

        void d(int i);

        void d(List<FeedUserInfoModel> list);

        void e(List<FeedComment> list);

        void f(List<FeedComment> list);

        void g(List<FeedRepost> list);

        void h(List<FeedRepost> list);

        void l();

        void m();

        void n();

        void q();

        void r();

        void s();

        void t();

        void u();
    }
}

package com.blued.community.ui.comment.contract;

import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;
import com.blued.community.ui.comment.adapter.CommentListAdapter;
import com.blued.community.ui.comment.model.FeedComment;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/comment/contract/IHotCommentsContract.class */
public class IHotCommentsContract {

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/comment/contract/IHotCommentsContract$IPresenter.class */
    public interface IPresenter extends BasePresenter {
        void a(String str);

        void a(String str, boolean z);

        void a(boolean z);

        void b();

        void b(String str);

        void c();

        CommentListAdapter.FeedCommentListner d();
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/comment/contract/IHotCommentsContract$IView.class */
    public interface IView extends BaseView<IPresenter> {
        void a();

        void a(String str);

        void a(List<FeedComment> list);

        void b();

        void b(List<FeedComment> list);

        void c();

        void d();

        void e();

        void f();

        void g();
    }
}

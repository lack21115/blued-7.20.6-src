package com.soft.blued.ui.notify.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import butterknife.BindView;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.community.model.FeedNotice;
import com.bytedance.applog.tracker.Tracker;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.soft.blued.R;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.ui.notify.adapter.MsgAttentionNotifyListAdapter;
import com.soft.blued.ui.notify.presenter.AttentionNotifyPresenter;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/notify/fragment/MsgAttentionNotifyFragment.class */
public class MsgAttentionNotifyFragment extends MvpFragment<AttentionNotifyPresenter> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private String f32898a = "MsgAttentionNotifyFragment";
    private MsgAttentionNotifyListAdapter b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f32899c;
    @BindView
    NoDataAndLoadFailView llNodataChats;
    @BindView
    ListView lv_friend;
    @BindView
    SmartRefreshLayout msgFrientPullrefresh;
    @BindView
    CommonTopTitleNoTrans topTitle;

    private void d() {
        if (this.b.a().isEmpty()) {
            this.llNodataChats.a();
        } else {
            this.llNodataChats.d();
        }
    }

    private void e() {
        this.topTitle.setCenterText(getString(R.string.msg_follow_to_me));
        this.topTitle.setRightImg(R.drawable.icon_title_delete);
        this.topTitle.setLeftClickListener(this);
        this.topTitle.setRightClickListener(this);
    }

    private void v() {
        MsgAttentionNotifyListAdapter msgAttentionNotifyListAdapter = new MsgAttentionNotifyListAdapter(getFragmentActive(), getContext());
        this.b = msgAttentionNotifyListAdapter;
        this.lv_friend.setAdapter((ListAdapter) msgAttentionNotifyListAdapter);
        this.msgFrientPullrefresh.a(new OnRefreshLoadMoreListener() { // from class: com.soft.blued.ui.notify.fragment.MsgAttentionNotifyFragment.1
            @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
                MsgAttentionNotifyFragment.this.j().f();
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                MsgAttentionNotifyFragment.this.j().e();
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        e();
        v();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, boolean z) {
        super.a(str, z);
        if (str == null) {
            return;
        }
        boolean z2 = true;
        int hashCode = str.hashCode();
        if (hashCode != -1290256561) {
            if (hashCode == 623698297 && str.equals("_load_type_loadmore_")) {
                z2 = true;
            }
        } else if (str.equals("_load_type_refresh_")) {
            z2 = false;
        }
        if (!z2) {
            this.msgFrientPullrefresh.j();
        } else if (z2) {
            this.msgFrientPullrefresh.h();
        }
        d();
        FindHttpUtils.a((BluedUIHttpResponse) null, "followers", String.valueOf(this.b.b()), getFragmentActive());
    }

    public void a(List<FeedNotice> list) {
        this.llNodataChats.d();
        this.b.a(list, j().h);
    }

    public void b() {
        Dialog dialog = this.f32899c;
        if (dialog != null) {
            dialog.cancel();
        }
        AppMethods.d((int) R.string.done);
        this.b.c();
        this.llNodataChats.a();
    }

    public void c() {
        this.llNodataChats.b();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_msg_attention_notify;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void g_(String str) {
        super.g_(str);
        Dialog a2 = DialogUtils.a(getContext());
        this.f32899c = a2;
        a2.show();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void o() {
        super.o();
        this.msgFrientPullrefresh.l(true);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            getActivity().finish();
        } else if (id != 2131363126) {
        } else {
            CommonAlertDialog.a(getContext(), j().a(2131891156), j().a(R.string.biao_msg_notify_attention_title_clear_all), j().a(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.notify.fragment.MsgAttentionNotifyFragment.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    if (MsgAttentionNotifyFragment.this.f32899c != null) {
                        MsgAttentionNotifyFragment.this.f32899c.show();
                    }
                    MsgAttentionNotifyFragment.this.j().a(MsgAttentionNotifyFragment.this.b.b());
                }
            }, j().a(2131887258), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void p() {
        super.p();
        this.msgFrientPullrefresh.l(false);
    }
}

package com.soft.blued.ui.discover.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.community.model.FeedNotice;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.notify.adapter.ViewPointNoticeAdapter;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/discover/fragment/ViewpointNoticeLikeListFragment.class */
public class ViewpointNoticeLikeListFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    private View f16130a;
    private NoDataAndLoadFailView b;

    /* renamed from: c  reason: collision with root package name */
    private ListView f16131c;
    private RenrenPullToRefreshListView d;
    private ViewPointNoticeAdapter e;
    private Context f;
    private int g = 0;
    private int h = 20;
    private boolean i = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.discover.fragment.ViewpointNoticeLikeListFragment$3  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/discover/fragment/ViewpointNoticeLikeListFragment$3.class */
    public class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            InstantLog.b("delete_all", 2);
            CommonAlertDialog.a(ViewpointNoticeLikeListFragment.this.f, ViewpointNoticeLikeListFragment.this.f.getResources().getString(R.string.one_key_delete), String.format(ViewpointNoticeLikeListFragment.this.f.getResources().getString(R.string.one_key_delete_description), ViewpointNoticeLikeListFragment.this.f.getResources().getString(R.string.like_me_list)), ViewpointNoticeLikeListFragment.this.f.getResources().getString(2131887320), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.discover.fragment.ViewpointNoticeLikeListFragment.3.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    FindHttpUtils.a(new BluedUIHttpResponse() { // from class: com.soft.blued.ui.discover.fragment.ViewpointNoticeLikeListFragment.3.1.1
                        public void onUIUpdate(BluedEntity bluedEntity) {
                            AppMethods.d((int) R.string.done);
                            ViewpointNoticeLikeListFragment.this.e.b();
                            ViewpointNoticeLikeListFragment.this.b.a();
                            ViewpointNoticeLikeListFragment.this.d.p();
                        }
                    }, (IRequestHost) ViewpointNoticeLikeListFragment.this.getFragmentActive(), "liked", String.valueOf(ViewpointNoticeLikeListFragment.this.e.a()));
                }
            }, ViewpointNoticeLikeListFragment.this.f.getResources().getString(2131886885), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
        }
    }

    public static void a(Context context) {
        TerminalActivity.d(context, ViewpointNoticeLikeListFragment.class, (Bundle) null);
    }

    static /* synthetic */ int g(ViewpointNoticeLikeListFragment viewpointNoticeLikeListFragment) {
        int i = viewpointNoticeLikeListFragment.g;
        viewpointNoticeLikeListFragment.g = i - 1;
        return i;
    }

    public void a() {
        RenrenPullToRefreshListView findViewById = this.f16130a.findViewById(R.id.list_view);
        this.d = findViewById;
        ListView listView = (ListView) findViewById.getRefreshableView();
        this.f16131c = listView;
        listView.setClipToPadding(false);
        this.f16131c.setScrollBarStyle(33554432);
        this.f16131c.setHeaderDividersEnabled(false);
        this.f16131c.setDividerHeight(0);
        ViewPointNoticeAdapter viewPointNoticeAdapter = new ViewPointNoticeAdapter(this.f, getFragmentActive(), false);
        this.e = viewPointNoticeAdapter;
        viewPointNoticeAdapter.a(1);
        this.f16131c.setAdapter((ListAdapter) this.e);
        this.f16131c.setEmptyView(this.b);
        this.d.postDelayed(new Runnable() { // from class: com.soft.blued.ui.discover.fragment.ViewpointNoticeLikeListFragment.1
            @Override // java.lang.Runnable
            public void run() {
                ViewpointNoticeLikeListFragment.this.d.k();
            }
        }, 100L);
        this.d.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener() { // from class: com.soft.blued.ui.discover.fragment.ViewpointNoticeLikeListFragment.2
            public void a() {
                ViewpointNoticeLikeListFragment.this.a(true);
            }

            public void b() {
                ViewpointNoticeLikeListFragment.this.a(false);
            }
        });
    }

    public void a(boolean z) {
        if (z) {
            this.g = 1;
        } else {
            this.g++;
        }
        FindHttpUtils.a((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntity<FeedNotice, BluedEntityBaseExtra>>(getFragmentActive()) { // from class: com.soft.blued.ui.discover.fragment.ViewpointNoticeLikeListFragment.5

            /* renamed from: a  reason: collision with root package name */
            boolean f16138a = false;

            public boolean onUIFailure(int i, String str) {
                this.f16138a = true;
                return super.onUIFailure(i, str);
            }

            public void onUIFinish() {
                if (!this.f16138a) {
                    ViewpointNoticeLikeListFragment.this.d.j();
                    ViewpointNoticeLikeListFragment.this.d.q();
                    FindHttpUtils.a((BluedUIHttpResponse) null, "liked", String.valueOf(ViewpointNoticeLikeListFragment.this.e.a()), (IRequestHost) ViewpointNoticeLikeListFragment.this.getFragmentActive());
                    return;
                }
                this.f16138a = false;
                ViewpointNoticeLikeListFragment.this.b.b();
                ViewpointNoticeLikeListFragment.this.e.notifyDataSetChanged();
                if (ViewpointNoticeLikeListFragment.this.g > 1) {
                    ViewpointNoticeLikeListFragment.g(ViewpointNoticeLikeListFragment.this);
                }
            }

            public void onUIUpdate(BluedEntity<FeedNotice, BluedEntityBaseExtra> bluedEntity) {
                if (bluedEntity == null || bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                    ViewpointNoticeLikeListFragment.this.b.a();
                    ViewpointNoticeLikeListFragment.this.e.notifyDataSetChanged();
                    ViewpointNoticeLikeListFragment.this.i = false;
                } else {
                    ViewpointNoticeLikeListFragment.this.i = bluedEntity.hasMore();
                    if (ViewpointNoticeLikeListFragment.this.g == 1) {
                        ChatHelperV4.a().a(3L);
                        ChatHelperV4.a().a(11L);
                        ChatHelperV4.a().a(22L);
                        ViewpointNoticeLikeListFragment.this.e.a(bluedEntity.data);
                    } else {
                        ViewpointNoticeLikeListFragment.this.e.b(bluedEntity.data);
                    }
                }
                if (ViewpointNoticeLikeListFragment.this.i) {
                    ViewpointNoticeLikeListFragment.this.d.o();
                } else {
                    ViewpointNoticeLikeListFragment.this.d.p();
                }
            }
        }, "liked", this.g, this.h, (IRequestHost) getFragmentActive());
    }

    public void b() {
        CommonTopTitleNoTrans findViewById = this.f16130a.findViewById(2131370694);
        findViewById.setCenterText((int) R.string.like_me_list);
        findViewById.setRightImg((int) R.drawable.icon_title_delete);
        findViewById.setRightClickListener(new AnonymousClass3());
        findViewById.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.discover.fragment.ViewpointNoticeLikeListFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ViewpointNoticeLikeListFragment.this.getActivity().finish();
            }
        });
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f = getActivity();
        View view = this.f16130a;
        if (view == null) {
            this.f16130a = layoutInflater.inflate(R.layout.fragment_common_list, viewGroup, false);
            NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(this.f);
            this.b = noDataAndLoadFailView;
            noDataAndLoadFailView.setNoDataImg(2131233633);
            this.b.setNoDataStr((int) R.string.group_nolikeds);
            a();
            b();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.f16130a.getParent()).removeView(this.f16130a);
        }
        return this.f16130a;
    }
}

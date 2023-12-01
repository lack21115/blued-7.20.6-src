package com.soft.blued.ui.notify.presenter;

import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.community.model.FeedNotice;
import com.blued.community.track.EventTrackFeed;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.discover.observer.SystemNoticeViewModel;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.notify.fragment.SystemNoticeAdapter;
import com.soft.blued.ui.notify.model.ViewpointNoticeCount;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/notify/presenter/SystemNoticePresenter.class */
public class SystemNoticePresenter extends MvpPresenter {
    public SystemNoticeViewModel h;
    private SystemNoticeAdapter k;
    private ViewpointNoticeCount p;
    private String l = ContactsContract.StreamItemsColumns.COMMENTS;
    private int m = 1;
    private int n = 20;
    private boolean o = false;
    public boolean i = false;
    public boolean j = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j) {
        EventTrackFeed.b(FeedProtos.Event.MSG_NOTICE_DELETE_CLICK);
        InstantLog.b("delete_all", 1);
        CommonAlertDialog.a(h(), AppUtils.a(2131891156), AppUtils.a(2131887475), AppUtils.a(2131887320), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.notify.presenter.SystemNoticePresenter.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                FindHttpUtils.a(new BluedUIHttpResponse(SystemNoticePresenter.this.g()) { // from class: com.soft.blued.ui.notify.presenter.SystemNoticePresenter.7.1
                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    public void onUIUpdate(BluedEntity bluedEntity) {
                        SystemNoticePresenter.this.a("VIEW_POINT_CLEAR", false);
                        SystemNoticePresenter.this.a("VIEW_POINT_LIST", (String) null);
                    }
                }, SystemNoticePresenter.this.g(), ContactsContract.StreamItemsColumns.COMMENTS, String.valueOf(j));
            }
        }, AppUtils.a(2131886885), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    private void c(IFetchDataListener iFetchDataListener) {
        FindHttpUtils.a(d(iFetchDataListener), this.l, this.m, this.n, g());
    }

    private BluedUIHttpResponse d(final IFetchDataListener iFetchDataListener) {
        return new BluedUIHttpResponse<BluedEntity<FeedNotice, BluedEntityBaseExtra>>(this.m == 1 ? "system_notice" : "", g()) { // from class: com.soft.blued.ui.notify.presenter.SystemNoticePresenter.5
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUICache(BluedEntity<FeedNotice, BluedEntityBaseExtra> bluedEntity) {
                super.onUICache(bluedEntity);
                if (bluedEntity == null || !bluedEntity.hasData()) {
                    return;
                }
                SystemNoticePresenter.this.a("VIEW_POINT_LIST", (String) bluedEntity.data);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (!z) {
                    SystemNoticePresenter.e(SystemNoticePresenter.this);
                }
                IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                if (iFetchDataListener2 != null) {
                    iFetchDataListener2.a(z);
                }
                FindHttpUtils.a((BluedUIHttpResponse) null, SystemNoticePresenter.this.l, String.valueOf(SystemNoticePresenter.this.k.a()), SystemNoticePresenter.this.g());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<FeedNotice, BluedEntityBaseExtra> bluedEntity) {
                if (bluedEntity == null || !bluedEntity.hasData()) {
                    SystemNoticePresenter.this.o = false;
                    return;
                }
                if (SystemNoticePresenter.this.m == 1) {
                    ChatHelperV4.a().a(3L);
                    ChatHelperV4.a().a(11L);
                    ChatHelperV4.a().a(22L);
                }
                SystemNoticePresenter.this.o = bluedEntity.hasMore();
                IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                if (iFetchDataListener2 != null) {
                    iFetchDataListener2.a("VIEW_POINT_LIST", bluedEntity.data);
                    iFetchDataListener.b(SystemNoticePresenter.this.o);
                }
            }
        };
    }

    static /* synthetic */ int e(SystemNoticePresenter systemNoticePresenter) {
        int i = systemNoticePresenter.m;
        systemNoticePresenter.m = i - 1;
        return i;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
        this.h = (SystemNoticeViewModel) ViewModelProviders.of(fragmentActivity).get(SystemNoticeViewModel.class);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(LifecycleOwner lifecycleOwner) {
        super.a(lifecycleOwner);
        LiveEventBus.get(EventBusConstant.KEY_EVENT_CLICK_RIGHT_DELETE, View.class).observe(lifecycleOwner, new Observer<View>() { // from class: com.soft.blued.ui.notify.presenter.SystemNoticePresenter.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(View view) {
                if (SystemNoticePresenter.this.k != null) {
                    SystemNoticePresenter systemNoticePresenter = SystemNoticePresenter.this;
                    systemNoticePresenter.a(systemNoticePresenter.k.a());
                }
            }
        });
        LiveEventBus.get(EventBusConstant.KEY_EVENT_CLEAR_MESSAGE_NOTIFY, Void.class).observe(lifecycleOwner, new Observer<Void>() { // from class: com.soft.blued.ui.notify.presenter.SystemNoticePresenter.2
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Void r5) {
                SystemNoticePresenter.this.p = new ViewpointNoticeCount();
                SystemNoticePresenter systemNoticePresenter = SystemNoticePresenter.this;
                systemNoticePresenter.a("VIEW_POINT", (String) systemNoticePresenter.p);
                SystemNoticePresenter.this.a("CLEAR_NOTIFY", false);
                SystemNoticePresenter.this.n();
                SystemNoticePresenter.this.o();
                SystemNoticePresenter.this.p();
                SystemNoticePresenter.this.q();
                SystemNoticePresenter.this.r();
                SystemNoticePresenter.this.s();
            }
        });
        SystemNoticeViewModel systemNoticeViewModel = (SystemNoticeViewModel) ViewModelProviders.of((FragmentActivity) h()).get(SystemNoticeViewModel.class);
        systemNoticeViewModel.h.observe(lifecycleOwner, new Observer<ViewpointNoticeCount>() { // from class: com.soft.blued.ui.notify.presenter.SystemNoticePresenter.3
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(ViewpointNoticeCount viewpointNoticeCount) {
                if (SystemNoticePresenter.this.p == null) {
                    SystemNoticePresenter.this.p = new ViewpointNoticeCount();
                }
                SystemNoticePresenter.this.p.followers = Math.max(SystemNoticePresenter.this.p.followers, viewpointNoticeCount.followers);
                SystemNoticePresenter.this.p.liked = Math.max(SystemNoticePresenter.this.p.liked, viewpointNoticeCount.liked);
                SystemNoticePresenter.this.p.groups = Math.max(SystemNoticePresenter.this.p.groups, viewpointNoticeCount.groups);
                SystemNoticePresenter.this.p.circle = Math.max(SystemNoticePresenter.this.p.circle, viewpointNoticeCount.circle);
                SystemNoticePresenter systemNoticePresenter = SystemNoticePresenter.this;
                systemNoticePresenter.a("VIEW_POINT", (String) systemNoticePresenter.p);
            }
        });
        systemNoticeViewModel.g.observe(lifecycleOwner, new Observer<Integer>() { // from class: com.soft.blued.ui.notify.presenter.SystemNoticePresenter.4
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Integer num) {
                if (SystemNoticePresenter.this.i && SystemNoticePresenter.this.j) {
                    SystemNoticePresenter.this.e();
                }
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
        this.m = 1;
        m();
        c(iFetchDataListener);
    }

    public void a(SystemNoticeAdapter systemNoticeAdapter) {
        this.k = systemNoticeAdapter;
    }

    public void a(ViewpointNoticeCount viewpointNoticeCount) {
        ChatManager.getInstance().updateSessionNoReadNum((short) 1, 5L, viewpointNoticeCount.followers);
        ChatManager.getInstance().updateSessionNoReadNum((short) 1, 21L, viewpointNoticeCount.liked);
        ChatManager.getInstance().updateSessionNoReadNum((short) 1, 2L, viewpointNoticeCount.groups);
        ChatManager.getInstance().updateSessionNoReadNum((short) 1, 24L, viewpointNoticeCount.circle);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
        this.m++;
        c(iFetchDataListener);
    }

    public void b(ViewpointNoticeCount viewpointNoticeCount) {
        if (viewpointNoticeCount != null) {
            this.h.b = viewpointNoticeCount;
        }
        this.h.f.postValue(Integer.valueOf(this.h.b.getSum() + this.h.f29847c));
        this.h.d.postValue(Integer.valueOf(this.h.f29846a + this.h.b.getSum() + this.h.f29847c));
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void k() {
        super.k();
        d((IFetchDataListener) null).refresh();
    }

    public void m() {
        FindHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<ViewpointNoticeCount>>(g()) { // from class: com.soft.blued.ui.notify.presenter.SystemNoticePresenter.6
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<ViewpointNoticeCount> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.isEmpty() || bluedEntityA.data.get(0) == null) {
                    return;
                }
                SystemNoticePresenter.this.p = bluedEntityA.getSingleData();
                SystemNoticePresenter.this.p.isHttp = true;
                SystemNoticePresenter systemNoticePresenter = SystemNoticePresenter.this;
                systemNoticePresenter.a("VIEW_POINT", (String) systemNoticePresenter.p);
                SystemNoticePresenter systemNoticePresenter2 = SystemNoticePresenter.this;
                systemNoticePresenter2.a(systemNoticePresenter2.p);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                return super.onUIFailure(i, str);
            }
        }, g());
    }

    public void n() {
        ChatManager.getInstance().updateSessionNoReadNum((short) 1, 5L, 0);
        ChatManager.getInstance().updateSessionNoReadNum((short) 1, 21L, 0);
        ChatManager.getInstance().updateSessionNoReadNum((short) 1, 2L, 0);
        ChatManager.getInstance().updateSessionNoReadNum((short) 1, 24L, 0);
    }

    public void o() {
        this.h.b.followers = 0;
        ChatManager.getInstance().ignoredNoReadNum((short) 1, 5L);
        FindHttpUtils.a((BluedUIHttpResponse) null, "followers", String.valueOf(System.currentTimeMillis() / 1000), (IRequestHost) null);
        b((ViewpointNoticeCount) null);
    }

    public void p() {
        this.h.b.liked = 0;
        ChatManager.getInstance().ignoredNoReadNum((short) 1, 21L);
        FindHttpUtils.a((BluedUIHttpResponse) null, "liked", (IRequestHost) null);
        b((ViewpointNoticeCount) null);
    }

    public void q() {
        this.h.b.groups = 0;
        ChatManager.getInstance().ignoredNoReadNum((short) 1, 2L);
        FindHttpUtils.a((BluedUIHttpResponse) null, "groups", (IRequestHost) null);
        b((ViewpointNoticeCount) null);
    }

    public void r() {
        this.h.b.circle = 0;
        ChatManager.getInstance().ignoredNoReadNum((short) 1, 24L);
        FindHttpUtils.a((BluedUIHttpResponse) null, "circle", (IRequestHost) null);
        b((ViewpointNoticeCount) null);
    }

    public void s() {
        ChatHelperV4.a().a(3L);
        ChatHelperV4.a().a(11L);
        ChatHelperV4.a().a(22L);
    }
}

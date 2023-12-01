package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.RoomMemberAdapter;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.listener.OnItemClickRoomMemberListener;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.observer.FollowStatusObserver;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.util.Collection;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/RoomMemberListView.class */
public class RoomMemberListView extends LinearLayout implements FollowStatusObserver {

    /* renamed from: a  reason: collision with root package name */
    private BaseYYStudioFragment f17985a;
    private SmartRefreshLayout b;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f17986c;
    private FrameLayout d;
    private RoomMemberAdapter e;
    private int f;
    private boolean g;
    private int h;
    private int i;
    private YYNoDataView j;
    private int k;

    public RoomMemberListView(Context context) {
        super(context);
        this.g = false;
        this.h = 1;
        this.k = 0;
        a();
    }

    public RoomMemberListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = false;
        this.h = 1;
        this.k = 0;
        a();
    }

    public RoomMemberListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = false;
        this.h = 1;
        this.k = 0;
        a();
    }

    private void a() {
        this.f = DensityUtils.a(getContext(), 16.0f);
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_room_members_layout, (ViewGroup) this, true);
        this.b = (SmartRefreshLayout) findViewById(R.id.refresh_view);
        this.f17986c = (RecyclerView) findViewById(R.id.recycler_view);
        this.d = (FrameLayout) findViewById(R.id.fl_loading_view);
        YYNoDataView yYNoDataView = new YYNoDataView(getContext());
        this.j = yYNoDataView;
        yYNoDataView.setNoDataImg(R.drawable.icon_nodata_img);
        this.j.setNoDataStr(R.string.yy_no_member);
        this.b.a(new OnRefreshLoadMoreListener() { // from class: com.blued.android.module.yy_china.view.RoomMemberListView.1
            @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
                RoomMemberListView.this.b();
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                RoomMemberListView.this.h = 1;
                RoomMemberListView.this.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YYAudienceModel yYAudienceModel) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        if (!b.enableRequestMic()) {
            ToastUtils.a("相亲交友活动已开始，不可以邀请用户上麦喽！", 0);
            return;
        }
        if (TextUtils.equals(b.chat_type, "5")) {
            this.k = 2;
        }
        YYRoomHttpUtils.a(b.room_id, yYAudienceModel.getUid(), this.k, new BluedUIHttpResponse<BluedEntityA<Object>>(this.f17985a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.RoomMemberListView.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                ToastUtils.a("邀请上麦已发出，等待确认", 0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                RoomMemberListView.this.d.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                RoomMemberListView.this.d.setVisibility(0);
            }
        }, this.f17985a.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.c(b.room_id, this.h, new BluedUIHttpResponse<BluedEntityA<YYAudienceModel>>(this.f17985a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.RoomMemberListView.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYAudienceModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                if (RoomMemberListView.this.h == 1) {
                    RoomMemberListView.this.e.setNewData(bluedEntityA.data);
                } else {
                    RoomMemberListView.this.e.addData((Collection) bluedEntityA.data);
                }
                if (bluedEntityA.hasMore()) {
                    RoomMemberListView.f(RoomMemberListView.this);
                    RoomMemberListView.this.b.l(true);
                } else {
                    RoomMemberListView.this.b.l(false);
                }
                RoomMemberListView.this.b.j();
                RoomMemberListView.this.b.h();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                RoomMemberListView.this.b.j();
                RoomMemberListView.this.b.h();
            }
        }, this.f17985a.getFragmentActive());
    }

    static /* synthetic */ int f(RoomMemberListView roomMemberListView) {
        int i = roomMemberListView.h;
        roomMemberListView.h = i + 1;
        return i;
    }

    public void a(final BaseYYStudioFragment baseYYStudioFragment, int i) {
        this.f17985a = baseYYStudioFragment;
        this.i = i;
        this.e = new RoomMemberAdapter(baseYYStudioFragment, i);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.f17986c.setLayoutManager(linearLayoutManager);
        this.f17986c.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.blued.android.module.yy_china.view.RoomMemberListView.2
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = RoomMemberListView.this.f;
                }
                rect.bottom = RoomMemberListView.this.f;
            }
        });
        this.f17986c.setAdapter(this.e);
        this.e.setEmptyView(this.j);
        this.e.a(new OnItemClickRoomMemberListener() { // from class: com.blued.android.module.yy_china.view.RoomMemberListView.3
            @Override // com.blued.android.module.yy_china.listener.OnItemClickRoomMemberListener
            public void a(final YYAudienceModel yYAudienceModel, int i2) {
                if (TextUtils.equals(yYAudienceModel.relationship, "2") || TextUtils.equals("0", yYAudienceModel.relationship)) {
                    YYRoomInfoManager.e().b(RoomMemberListView.this.getContext(), yYAudienceModel.getUid(), "", baseYYStudioFragment.getFragmentActive());
                } else if (yYAudienceModel.is_idol != 1) {
                    YYRoomInfoManager.e().a(RoomMemberListView.this.getContext(), yYAudienceModel.getUid(), "", baseYYStudioFragment.getFragmentActive());
                } else {
                    CommonAlertDialog.a(RoomMemberListView.this.getContext(), "", "你已加入对方的粉丝团，不再关注后，将自动退出他的粉丝团，且相关粉丝团权益失效。确定不再关注他？", "确定", new DialogInterface.OnClickListener() { // from class: com.blued.android.module.yy_china.view.RoomMemberListView.3.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            Tracker.onClick(dialogInterface, i3);
                            YYRoomInfoManager.e().a(RoomMemberListView.this.getContext(), yYAudienceModel.getUid(), "", baseYYStudioFragment.getFragmentActive());
                        }
                    }, RoomMemberListView.this.getContext().getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.yy_china.view.RoomMemberListView.3.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            Tracker.onClick(dialogInterface, i3);
                            dialogInterface.dismiss();
                        }
                    }, (DialogInterface.OnDismissListener) null);
                }
            }

            @Override // com.blued.android.module.yy_china.listener.OnItemClickRoomMemberListener
            public void b(YYAudienceModel yYAudienceModel, int i2) {
                RoomMemberListView.this.a(yYAudienceModel);
            }
        });
        this.g = true;
        baseYYStudioFragment.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.view.RoomMemberListView.4
            @Override // java.lang.Runnable
            public void run() {
                RoomMemberListView.this.b.i();
            }
        }, 300L);
    }

    @Override // com.blued.android.module.yy_china.observer.FollowStatusObserver
    public void a_(String str, String str2) {
        int a2 = this.e.a(str);
        this.e.getData().get(a2).relationship = str2;
        this.e.notifyItemChanged(a2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Logger.e("observer", "RoomMemberListView onAttachedToWindow ... ");
        YYObserverManager.a().a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Logger.e("observer", "RoomMemberListView onDetachedFromWindow ... ");
        YYObserverManager.a().b(this);
    }

    public void setPosition(int i) {
        this.k = i;
    }
}

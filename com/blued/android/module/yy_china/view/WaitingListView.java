package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.widget.refresh.BluedLoadMoreView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.WaitingAdapter;
import com.blued.android.module.yy_china.databinding.ViewYyWaittingListViewBinding;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.listener.ClickApplyHandleListener;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYWishGoodsModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/WaitingListView.class */
public class WaitingListView extends LinearLayout {
    private ViewYyWaittingListViewBinding a;
    private int b;
    private WaitingAdapter c;
    private BaseYYStudioFragment d;
    private YYNoDataView e;
    private int f;
    private YYRoomModel g;

    public WaitingListView(Context context) {
        super(context);
        this.f = 1;
        a();
    }

    public WaitingListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 1;
        a();
    }

    public WaitingListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 1;
        a();
    }

    private void a() {
        this.a = ViewYyWaittingListViewBinding.a(LayoutInflater.from(getContext()), this, true);
        this.b = DensityUtils.a(getContext(), 16.0f);
        YYRoomModel b = YYRoomInfoManager.e().b();
        this.g = b;
        if (b != null) {
            String str = b.chat_type;
            boolean z = true;
            int hashCode = str.hashCode();
            if (hashCode != 52) {
                if (hashCode == 53 && str.equals("5")) {
                    z = false;
                }
            } else if (str.equals("4")) {
                z = true;
            }
            if (!z) {
                this.a.d.setText("粉丝麦位排队通道");
            } else if (!z) {
                this.a.d.setText(R.string.yy_up_list_title);
            } else {
                this.a.d.setText(R.string.yy_up_list);
            }
        }
        YYNoDataView yYNoDataView = new YYNoDataView(getContext());
        this.e = yYNoDataView;
        yYNoDataView.setNoDataImg(R.drawable.icon_nodata_img);
        this.e.setNoDataStr(R.string.yy_no_person);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.a.a.setLayoutManager(linearLayoutManager);
        this.a.a.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.blued.android.module.yy_china.view.WaitingListView.1
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = WaitingListView.this.b;
                }
                rect.bottom = WaitingListView.this.b;
            }
        });
        BluedLoadMoreView bluedLoadMoreView = new BluedLoadMoreView(getContext());
        bluedLoadMoreView.setBackgroundColorRes(R.color.transparent);
        this.a.b.a(bluedLoadMoreView);
        this.a.b.a(new OnRefreshLoadMoreListener() { // from class: com.blued.android.module.yy_china.view.WaitingListView.2
            public void onLoadMore(RefreshLayout refreshLayout) {
                WaitingListView.this.getWattingList();
            }

            public void onRefresh(RefreshLayout refreshLayout) {
                WaitingListView.this.f = 1;
                WaitingListView.this.getWattingList();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YYAudienceModel yYAudienceModel, int i, final int i2) {
        YYRoomModel yYRoomModel = this.g;
        if (yYRoomModel == null) {
            return;
        }
        if (!yYRoomModel.enableRequestMic()) {
            ToastUtils.a("相亲交友活动已开始，不可以同意用户上麦喽！", 0);
            return;
        }
        if (i == 1) {
            if (this.g.isSaleChannel()) {
                EventTrackYY.c(ChatRoomProtos.Event.CHAT_ROOM_AUCTION_APPLY_LIST_AGREE_CLICK, this.g.room_id, yYAudienceModel.getUid());
            } else {
                EventTrackYY.b(ChatRoomProtos.Event.CHAT_ROOM_MIKE_USER_ACCEPT_CLICK, this.g.room_id, this.g.uid, yYAudienceModel.getUid(), this.g.chat_type);
            }
        } else if (this.g.isSaleChannel()) {
            EventTrackYY.c(ChatRoomProtos.Event.CHAT_ROOM_AUCTION_APPLY_LIST_REFUSE_CLICK, this.g.room_id, yYAudienceModel.getUid());
        } else {
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_MIKE_USER_REFUSE_CLICK, this.g.room_id, this.g.uid, yYAudienceModel.getUid());
        }
        YYRoomHttpUtils.c(this.g.room_id, yYAudienceModel.getUid(), i, new BluedUIHttpResponse<BluedEntityA<Object>>(this.d.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.WaitingListView.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                WaitingListView.this.c.a(i2);
                YYObserverManager.a().b(WaitingListView.this.c.getData().size());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i3, String str, String str2) {
                WaitingListView.this.c.b(i2);
                if (i3 == 40380009) {
                    WaitingListView.this.c.a(i2);
                    YYObserverManager.a().b(WaitingListView.this.c.getData().size());
                }
                return super.onUIFailure(i3, str, str2);
            }
        }, this.d.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        YYRoomModel yYRoomModel = this.g;
        if (yYRoomModel == null || this.d == null) {
            return;
        }
        YYRoomHttpUtils.S(yYRoomModel.room_id, new BluedUIHttpResponse<BluedEntityA<YYWishGoodsModel>>(this.d.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.WaitingListView.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYWishGoodsModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                WaitingListView.this.a.c.setVisibility(0);
                WaitingListView.this.a.c.setText(String.format(WaitingListView.this.getResources().getString(R.string.yy_solo_gift_info), bluedEntityA.getSingleData().name, bluedEntityA.getSingleData().beans));
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                if (i == 40380002) {
                    com.blued.android.module.common.utils.ToastUtils.a("房间已关闭");
                    WaitingListView.this.d.G();
                }
                return super.onUIFailure(i, str);
            }
        }, this.d.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getWattingList() {
        YYRoomModel yYRoomModel = this.g;
        if (yYRoomModel == null || this.d == null) {
            return;
        }
        YYRoomHttpUtils.e(yYRoomModel.room_id, this.f, new BluedUIHttpResponse<BluedEntity<YYAudienceModel, BluedEntityBaseExtra>>(this.d.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.WaitingListView.5
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                WaitingListView.this.a.b.g();
                WaitingListView.this.a.b.h();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<YYAudienceModel, BluedEntityBaseExtra> bluedEntity) {
                if (bluedEntity == null) {
                    return;
                }
                if (WaitingListView.this.f == 1) {
                    if (TextUtils.equals("5", WaitingListView.this.g.chat_type)) {
                        WaitingListView.this.b();
                    } else {
                        WaitingListView.this.a.c.setVisibility(8);
                    }
                    WaitingListView.this.g.setWaittingCount(bluedEntity.extra.total);
                    YYObserverManager.a().b(bluedEntity.extra.total);
                }
                if (bluedEntity == null || !bluedEntity.hasData()) {
                    return;
                }
                if (WaitingListView.this.f == 1) {
                    WaitingListView.this.c.setNewData(bluedEntity.data);
                } else {
                    WaitingListView.this.c.addData(bluedEntity.data);
                }
                if (!bluedEntity.hasMore()) {
                    WaitingListView.this.a.b.b(false);
                    return;
                }
                WaitingListView.h(WaitingListView.this);
                WaitingListView.this.a.b.b(true);
            }
        }, this.d.getFragmentActive());
    }

    static /* synthetic */ int h(WaitingListView waitingListView) {
        int i = waitingListView.f;
        waitingListView.f = i + 1;
        return i;
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment) {
        this.d = baseYYStudioFragment;
        this.c = new WaitingAdapter(baseYYStudioFragment);
        this.a.a.setAdapter(this.c);
        this.c.setEmptyView(this.e);
        this.c.bindToRecyclerView(this.a.a);
        this.c.a(new ClickApplyHandleListener() { // from class: com.blued.android.module.yy_china.view.WaitingListView.3
            @Override // com.blued.android.module.yy_china.listener.ClickApplyHandleListener
            public void a(YYAudienceModel yYAudienceModel, int i, int i2) {
                WaitingListView.this.a(yYAudienceModel, i, i2);
            }
        });
        baseYYStudioFragment.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.view.WaitingListView.4
            @Override // java.lang.Runnable
            public void run() {
                WaitingListView.this.a.b.i();
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.d = null;
    }
}

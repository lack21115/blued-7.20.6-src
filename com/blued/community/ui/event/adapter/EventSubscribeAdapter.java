package com.blued.community.ui.event.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.extensions.BluedViewExtKt;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.http.EventHttpUtils;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.event.fragment.EventDetailsFragment;
import com.blued.community.ui.event.model.EventDetailsModel;
import com.blued.community.ui.event.model.EventLogData;
import com.blued.community.ui.event.model.PersonalEventModel;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.message.MessageProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/adapter/EventSubscribeAdapter.class */
public final class EventSubscribeAdapter extends BaseQuickAdapter<PersonalEventModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final IRequestHost f19522a;
    private final int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventSubscribeAdapter(IRequestHost fragmentActive) {
        super(R.layout.item_event_subscribe);
        Intrinsics.e(fragmentActive, "fragmentActive");
        this.f19522a = fragmentActive;
        this.b = ((AppInfo.l - BluedViewExtKt.a(65)) / 3) - BluedViewExtKt.a(12);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String a(com.blued.community.ui.event.model.PersonalEventModel r6) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.community.ui.event.adapter.EventSubscribeAdapter.a(com.blued.community.ui.event.model.PersonalEventModel):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventSubscribeAdapter this$0, PersonalEventModel item, int i, DialogInterface dialogInterface, int i2) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        this$0.b(item, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventSubscribeAdapter this$0, PersonalEventModel item, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        CommunityServiceManager.b().a(this$0.mContext, item.uid, "feed_list_event", MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventSubscribeAdapter this$0, PersonalEventModel item, BaseViewHolder helper, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        Intrinsics.e(helper, "$helper");
        this$0.a(item, helper.getAdapterPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventSubscribeAdapter this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        Object obj = baseQuickAdapter.getData().get(i);
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.community.ui.event.model.EventDetailsModel");
        }
        EventDetailsModel eventDetailsModel = (EventDetailsModel) obj;
        EventLogData eventLogData = new EventLogData();
        eventLogData.setEventId(eventDetailsModel.id);
        eventLogData.setEventManagerUid(eventDetailsModel.uid);
        eventLogData.setSourcePage(FeedProtos.SourcePage.ACTIVITY_SUBSCRIBE);
        EventDetailsFragment.Companion companion = EventDetailsFragment.f19534a;
        Context mContext = this$0.mContext;
        Intrinsics.c(mContext, "mContext");
        companion.a(mContext, eventDetailsModel.id, eventLogData);
    }

    private final void a(final PersonalEventModel personalEventModel, final int i) {
        CommonAlertDialog.a(this.mContext, this.mContext.getString(R.string.event_cancel_sub_dialog_title), this.mContext.getString(R.string.event_cancel_sub_dialog_content), this.mContext.getString(R.string.common_ok), new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.event.adapter.-$$Lambda$EventSubscribeAdapter$d3zcYxN-kgsKDTY76Z2n-T4PNh4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                EventSubscribeAdapter.a(EventSubscribeAdapter.this, personalEventModel, i, dialogInterface, i2);
            }
        }, this.mContext.getString(R.string.common_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    private final void b(final PersonalEventModel personalEventModel, final int i) {
        final IRequestHost iRequestHost = this.f19522a;
        BluedUIHttpResponse<BluedEntityA<Object>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<Object>>(iRequestHost) { // from class: com.blued.community.ui.event.adapter.EventSubscribeAdapter$cancelSub$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> parseData) {
                List list;
                Intrinsics.e(parseData, "parseData");
                if (i >= 0) {
                    list = this.mData;
                    list.remove(personalEventModel);
                }
                this.notifyDataSetChanged();
            }
        };
        String str = personalEventModel.uid;
        Intrinsics.c(str, "item.uid");
        EventHttpUtils.d(bluedUIHttpResponse, str, this.f19522a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(final BaseViewHolder helper, final PersonalEventModel item) {
        Intrinsics.e(helper, "helper");
        Intrinsics.e(item, "item");
        ImageWrapper c2 = ImageLoader.a(this.f19522a, item.avatar).b(R.drawable.user_bg_round).d(R.drawable.user_bg_round).c();
        View view = helper.getView(R.id.iv_avatar);
        if (view == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
        }
        c2.a((ImageView) view);
        helper.setText(R.id.tv_name, item.name);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.blued.community.ui.event.adapter.-$$Lambda$EventSubscribeAdapter$gNNEbOH7I6D6iLBJpkrf4Dwxpt8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EventSubscribeAdapter.a(EventSubscribeAdapter.this, item, view2);
            }
        };
        helper.setOnClickListener(R.id.iv_avatar, onClickListener);
        helper.setOnClickListener(R.id.tv_name, onClickListener);
        String a2 = a(item);
        helper.setGone(R.id.tv_desc, !TextUtils.isEmpty(a2)).setText(R.id.tv_desc, a2);
        helper.getView(R.id.tv_cancel_sub).setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.adapter.-$$Lambda$EventSubscribeAdapter$YqN-LYrSeN9MgbzRzggb4O-7Owc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EventSubscribeAdapter.a(EventSubscribeAdapter.this, item, helper, view2);
            }
        });
        RecyclerView recyclerView = (RecyclerView) helper.getView(R.id.rv_event);
        if (item.activity != null || item.activity.size() > 0) {
            recyclerView.setVisibility(0);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext);
            linearLayoutManager.setOrientation(0);
            recyclerView.setLayoutManager(linearLayoutManager);
            EventSubscribeRecentEventAdapter eventSubscribeRecentEventAdapter = new EventSubscribeRecentEventAdapter(this.f19522a, this.b);
            eventSubscribeRecentEventAdapter.setNewData(item.activity);
            eventSubscribeRecentEventAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.blued.community.ui.event.adapter.-$$Lambda$EventSubscribeAdapter$vUeh0MSb_sxULkPb2vNMFm5e-wk
                @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
                public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                    EventSubscribeAdapter.a(EventSubscribeAdapter.this, baseQuickAdapter, view2, i);
                }
            });
            recyclerView.setAdapter(eventSubscribeRecentEventAdapter);
        } else {
            recyclerView.setVisibility(8);
        }
        EventTrackFeed.k(FeedProtos.Event.ACTIVITY_MINE_SUBSCRIBE_USER_SHOW, item.uid);
    }
}

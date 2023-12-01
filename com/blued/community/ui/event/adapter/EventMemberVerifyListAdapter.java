package com.blued.community.ui.event.adapter;

import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.widget.dialog.BluedAlertDialog;
import com.blued.community.R;
import com.blued.community.http.EventHttpUtils;
import com.blued.community.manager.CommunityManager;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.event.fragment.EventUserInfoDlgFragment;
import com.blued.community.ui.event.model.EventLogData;
import com.blued.community.ui.event.model.EventMemberModel;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/adapter/EventMemberVerifyListAdapter.class */
public final class EventMemberVerifyListAdapter extends BaseQuickAdapter<EventMemberModel, BaseViewHolder> {
    private final FragmentManager a;
    private final IRequestHost b;
    private final boolean c;
    private final String d;
    private final int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventMemberVerifyListAdapter(FragmentManager fragmentManager, IRequestHost fragmentActive, boolean z, String eventId, int i) {
        super(R.layout.item_event_member);
        Intrinsics.e(fragmentManager, "fragmentManager");
        Intrinsics.e(fragmentActive, "fragmentActive");
        Intrinsics.e(eventId, "eventId");
        this.a = fragmentManager;
        this.b = fragmentActive;
        this.c = z;
        this.d = eventId;
        this.e = i;
    }

    private final String a(long j) {
        if (!TimeAndDateUtils.g(j)) {
            SimpleDateFormat simpleDateFormat = TimeAndDateUtils.a.get();
            if (simpleDateFormat == null) {
                return null;
            }
            return simpleDateFormat.format(new Date(j));
        } else if (TimeAndDateUtils.f(j)) {
            SimpleDateFormat simpleDateFormat2 = TimeAndDateUtils.f.get();
            if (simpleDateFormat2 == null) {
                return null;
            }
            return simpleDateFormat2.format(new Date(j));
        } else if (TimeAndDateUtils.h(j)) {
            return this.mContext.getResources().getString(R.string.yesterday);
        } else {
            SimpleDateFormat simpleDateFormat3 = TimeAndDateUtils.g.get();
            if (simpleDateFormat3 == null) {
                return null;
            }
            return simpleDateFormat3.format(new Date(j));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventMemberVerifyListAdapter this$0, EventMemberModel item, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        this$0.a(item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventMemberVerifyListAdapter this$0, EventMemberModel item, BaseViewHolder helper, DialogInterface dialogInterface, int i) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        Intrinsics.e(helper, "$helper");
        this$0.a(false, item, helper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventMemberVerifyListAdapter this$0, EventMemberModel item, BaseViewHolder helper, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        Intrinsics.e(helper, "$helper");
        this$0.a(true, item, helper);
        EventTrackFeed.a(FeedProtos.Event.ACTIVITY_AUDIT_TRUE_CLICK, this$0.d, this$0.e, item.uid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventMemberVerifyListAdapter this$0, BaseViewHolder helper, EventMemberModel item, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(helper, "$helper");
        Intrinsics.e(item, "$item");
        this$0.b(helper, item);
    }

    private final void a(EventMemberModel eventMemberModel) {
        EventLogData eventLogData = new EventLogData();
        eventLogData.setEventId(this.d);
        eventLogData.setUid(eventMemberModel.uid);
        eventLogData.setSourcePage(this.c ? FeedProtos.SourcePage.VERIFY_FINISH_PAGE : FeedProtos.SourcePage.TO_VERIFY_PAGE);
        EventUserInfoDlgFragment.a.a(this.a, eventMemberModel.uid, this.d, eventLogData);
    }

    private final void a(final boolean z, final EventMemberModel eventMemberModel, final BaseViewHolder baseViewHolder) {
        EventHttpUtils eventHttpUtils = EventHttpUtils.a;
        BluedUIHttpResponse<BluedEntityA<Objects>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<Objects>>() { // from class: com.blued.community.ui.event.adapter.EventMemberVerifyListAdapter$examineUser$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Objects> bluedEntityA) {
                if (z) {
                    eventMemberModel.status = 1;
                    this.notifyItemChanged(baseViewHolder.getAdapterPosition());
                } else {
                    this.remove(baseViewHolder.getAdapterPosition());
                }
                LiveEventBus.get("event_examine_user").post(true);
            }
        };
        String str = this.d;
        String str2 = eventMemberModel.uid;
        Intrinsics.c(str2, "model.uid");
        eventHttpUtils.c(bluedUIHttpResponse, str, str2, z ? "1" : "2", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EventMemberVerifyListAdapter this$0, EventMemberModel item, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        this$0.a(item);
    }

    private final void b(final BaseViewHolder baseViewHolder, final EventMemberModel eventMemberModel) {
        EventTrackFeed.a(FeedProtos.Event.ACTIVITY_AUDIT_FALSE_CLICK, this.d, this.e, eventMemberModel.uid);
        BluedAlertDialog.Builder builder = new BluedAlertDialog.Builder(this.mContext);
        builder.d(R.string.event_ignore_dialog_title).e(R.string.event_ignore_dialog_content).a(R.string.event_ignore_dialog_confirm_btn, new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.event.adapter.-$$Lambda$EventMemberVerifyListAdapter$K4lvfoHrUlEnAEuzE4_GACCZcJE
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                EventMemberVerifyListAdapter.a(EventMemberVerifyListAdapter.this, eventMemberModel, baseViewHolder, dialogInterface, i);
            }
        }).f(R.color.syc_g).b(R.string.cancel, (DialogInterface.OnClickListener) null).g(R.color.syc_h).a(0);
        BluedAlertDialog a = builder.a();
        a.setCanceledOnTouchOutside(false);
        a.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(final BaseViewHolder helper, final EventMemberModel item) {
        Intrinsics.e(helper, "helper");
        Intrinsics.e(item, "item");
        ImageView imageView = (ImageView) helper.getView(R.id.iv_member_avatar);
        ImageLoader.a(this.b, item.user_info.avatar).b(R.drawable.user_bg_round).d(R.drawable.user_bg_round).c().a(imageView);
        ImageView imageView2 = (ImageView) helper.getView(R.id.img_verify);
        boolean z = false;
        if (item.user_info.vbadge > 0) {
            UserInfoHelper.b(imageView2, item.user_info.vbadge);
            imageView2.setVisibility(0);
        } else {
            imageView2.setVisibility(8);
        }
        helper.setText(R.id.tv_member_name, item.user_info.name);
        helper.setOnClickListener(R.id.cl_user_info, new View.OnClickListener() { // from class: com.blued.community.ui.event.adapter.-$$Lambda$EventMemberVerifyListAdapter$Iu3a2hR6YDgPwHCx6NKc2LqA7o4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventMemberVerifyListAdapter.a(EventMemberVerifyListAdapter.this, item, view);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.adapter.-$$Lambda$EventMemberVerifyListAdapter$fXMPAwJXwb4nDFN7IaoPx-WdbO0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventMemberVerifyListAdapter.b(EventMemberVerifyListAdapter.this, item, view);
            }
        });
        helper.setText(R.id.tv_event_time, Intrinsics.a("报名时间：", (Object) a(TimeAndDateUtils.j(item.create_time)))).setText(R.id.tv_member_distance, DistanceUtils.a(item.user_info.distance, BlueAppLocal.c(), false));
        if (this.c) {
            BaseViewHolder gone = helper.setGone(R.id.ll_manager_btn, false);
            int i = R.id.tv_signed;
            if (item.is_sign == 1) {
                z = true;
            }
            gone.setGone(i, z);
            return;
        }
        helper.setGone(R.id.ll_manager_btn, true).setGone(R.id.tv_signed, false);
        ShapeTextView shapeTextView = (ShapeTextView) helper.getView(R.id.tv_adopt_btn);
        TextView textView = (TextView) helper.getView(R.id.tv_ignore);
        if (item.status != 1) {
            shapeTextView.setText(this.mContext.getString(R.string.event_approve_btn));
            ShapeTextView shapeTextView2 = shapeTextView;
            ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView2, R.color.syc_a);
            ShapeHelper.d(shapeTextView2, R.color.syc_a_50);
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.adapter.-$$Lambda$EventMemberVerifyListAdapter$-yTxvCXjECcBw0UZd-lRGZDkY-s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventMemberVerifyListAdapter.a(EventMemberVerifyListAdapter.this, item, helper, view);
                }
            });
            textView.setVisibility(0);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.adapter.-$$Lambda$EventMemberVerifyListAdapter$SH0CHYjHuzY_bCP2JMCyPoiCBC4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventMemberVerifyListAdapter.a(EventMemberVerifyListAdapter.this, helper, item, view);
                }
            });
            return;
        }
        shapeTextView.setText(this.mContext.getString(R.string.event_approved_btn));
        if (CommunityManager.a.a().s()) {
            ShapeTextView shapeTextView3 = shapeTextView;
            ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView3, R.color.syc_454545);
            ShapeHelper.d(shapeTextView3, R.color.syc_dark_434343);
        } else {
            ShapeTextView shapeTextView4 = shapeTextView;
            ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView4, R.color.syc_dark_BABABA);
            ShapeHelper.d(shapeTextView4, R.color.syc_dark_E2E2E2);
        }
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.adapter.-$$Lambda$EventMemberVerifyListAdapter$er7yL-k9zxfwbEMAlTEC404ispM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventMemberVerifyListAdapter.a(view);
            }
        });
        textView.setVisibility(4);
    }
}

package com.blued.community.ui.event.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.manager.CommunityConstants;
import com.blued.community.manager.CommunityManager;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.event.fragment.EventDetailsFragment;
import com.blued.community.ui.event.manager.EventMethods;
import com.blued.community.ui.event.model.EventDetailsModel;
import com.blued.community.ui.event.model.EventLogData;
import com.blued.community.utils.ViewUtils;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/adapter/EventListAdapter.class */
public final class EventListAdapter extends BaseQuickAdapter<EventDetailsModel, BaseViewHolder> {
    private final IRequestHost a;
    private final FragmentManager b;
    private final BaseFragment c;
    private final int d;
    private final int e;
    private final int f;
    private boolean g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventListAdapter(IRequestHost fragmentActive, FragmentManager fragmentManager, BaseFragment fragment, int i) {
        super(R.layout.item_event_list);
        Intrinsics.e(fragmentActive, "fragmentActive");
        Intrinsics.e(fragmentManager, "fragmentManager");
        Intrinsics.e(fragment, "fragment");
        this.a = fragmentActive;
        this.b = fragmentManager;
        this.c = fragment;
        this.d = i;
        this.e = 1;
        this.f = 2;
        LiveEventBus.get("EVENT_BUS_ACTIVITY_SIGN_IN_SUCCESS", String.class).observe(this.c, new Observer() { // from class: com.blued.community.ui.event.adapter.-$$Lambda$EventListAdapter$m3IuxA21m1VrMzY3D7SXMrliJmo
            public final void onChanged(Object obj) {
                EventListAdapter.a(EventListAdapter.this, (String) obj);
            }
        });
        LiveEventBus.get("EVENT_BUS_ACTIVITY_SCORED", EventDetailsModel.class).observe(this.c, new Observer() { // from class: com.blued.community.ui.event.adapter.-$$Lambda$EventListAdapter$ctOw2z8kl9F3Xdw6CP7ZWbP3yQA
            public final void onChanged(Object obj) {
                EventListAdapter.a(EventListAdapter.this, (EventDetailsModel) obj);
            }
        });
        LiveEventBus.get("EVENT_BUS_EVENT_APPLY_SUCC", EventDetailsModel.class).observe(this.c, new Observer() { // from class: com.blued.community.ui.event.adapter.-$$Lambda$EventListAdapter$dC65gEuv-Pxf5drnPpzNfEaJhWA
            public final void onChanged(Object obj) {
                EventListAdapter.b(EventListAdapter.this, (EventDetailsModel) obj);
            }
        });
    }

    public /* synthetic */ EventListAdapter(IRequestHost iRequestHost, FragmentManager fragmentManager, BaseFragment baseFragment, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(iRequestHost, fragmentManager, baseFragment, (i2 & 8) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventListAdapter this$0, EventDetailsModel eventDetailsModel) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.d != this$0.f) {
            int size = this$0.getData().size();
            for (int i = 0; i < size; i++) {
                if (eventDetailsModel.id.equals(((EventDetailsModel) this$0.getData().get(i)).id)) {
                    ((EventDetailsModel) this$0.getData().get(i)).evaluate_status = 1;
                    ((EventDetailsModel) this$0.getData().get(i)).activity_evaluate = eventDetailsModel.activity_evaluate;
                    ((EventDetailsModel) this$0.getData().get(i)).activity_score = eventDetailsModel.activity_score;
                    this$0.notifyItemChanged(i);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventListAdapter this$0, EventDetailsModel item, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        this$0.a(item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventListAdapter this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.d != this$0.f) {
            int size = this$0.getData().size();
            for (int i = 0; i < size; i++) {
                if (str.equals(((EventDetailsModel) this$0.getData().get(i)).id)) {
                    ((EventDetailsModel) this$0.getData().get(i)).is_sign_in = 1;
                    this$0.notifyItemChanged(i);
                    return;
                }
            }
        }
    }

    private final void a(EventDetailsModel eventDetailsModel) {
        EventLogData eventLogData = new EventLogData();
        eventLogData.setEventId(eventDetailsModel.id);
        eventLogData.setEventManagerUid(eventDetailsModel.uid);
        int i = this.d;
        if (i == this.f) {
            eventLogData.setSourcePage(FeedProtos.SourcePage.ACTIVITY_LAUNCH);
        } else if (i == this.e) {
            eventLogData.setSourcePage(FeedProtos.SourcePage.ACTIVITY_JOIN);
        } else {
            eventLogData.setSourcePage(FeedProtos.SourcePage.ACTIVITY_LIST);
        }
        EventDetailsFragment.Companion companion = EventDetailsFragment.a;
        Context mContext = this.mContext;
        Intrinsics.c(mContext, "mContext");
        companion.a(mContext, eventDetailsModel.id, eventLogData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventDetailsModel item, EventListAdapter this$0, View view) {
        Intrinsics.e(item, "$item");
        Intrinsics.e(this$0, "this$0");
        if (item.status != 5) {
            this$0.a(item);
            EventTrackFeed.j(FeedProtos.Event.ACTIVITY_AGG_PAGE_ACTIVITY_CLICK, item.id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BaseViewHolder helper, View view) {
        Intrinsics.e(helper, "$helper");
        View view2 = helper.getView(R.id.tv_event_address_shadow);
        if (view2.getWidth() < view.getWidth()) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = view2.getWidth();
            view.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EventListAdapter this$0, EventDetailsModel eventDetailsModel) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.d != this$0.f) {
            int size = this$0.getData().size();
            for (int i = 0; i < size; i++) {
                if (eventDetailsModel.id.equals(((EventDetailsModel) this$0.getData().get(i)).id)) {
                    ((EventDetailsModel) this$0.getData().get(i)).apply_status = eventDetailsModel.apply_status;
                    ((EventDetailsModel) this$0.getData().get(i)).join_num = eventDetailsModel.join_num;
                    this$0.notifyItemChanged(i);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EventListAdapter this$0, EventDetailsModel item, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        this$0.a(item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EventDetailsModel item, EventListAdapter this$0, View view) {
        Intrinsics.e(item, "$item");
        Intrinsics.e(this$0, "this$0");
        if (item.status == 4) {
            CommunityServiceManager.b().a(this$0.mContext, H5Url.a(73), CommunityConstants.WebShowType.DEFAULT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(EventListAdapter this$0, EventDetailsModel item, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        this$0.a(item);
        EventTrackFeed.j(FeedProtos.Event.ACTIVITY_COMMENT_CLICK, item.id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(EventListAdapter this$0, EventDetailsModel item, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        this$0.a(item);
        EventTrackFeed.j(FeedProtos.Event.ACTIVITY_COMMENT_CLICK, item.id);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(final BaseViewHolder helper, final EventDetailsModel item) {
        String format;
        String str;
        Intrinsics.e(helper, "helper");
        Intrinsics.e(item, "item");
        helper.setText(R.id.tv_event_name, item.name);
        ImageLoader.a(this.a, item.pic).b(R.drawable.event_avatar_square).a(10.0f).a((ImageView) helper.getView(R.id.iv_event_avatar));
        helper.setGone(R.id.tv_event_tag_official, item.is_official == 1);
        ShapeTextView shapeTextView = (ShapeTextView) helper.getView(R.id.tv_event_tag_official);
        ShapeTextView shapeTextView2 = (ShapeTextView) helper.getView(R.id.tv_event_tag);
        shapeTextView.getBackground().setAlpha(30);
        if (BluedSkinUtils.c()) {
            shapeTextView2.getBackground().setAlpha(30);
        } else {
            shapeTextView2.getBackground().setAlpha(60);
        }
        shapeTextView2.setText(item.type_name);
        helper.setText(R.id.tv_event_time, TimeAndDateUtils.c(TimeAndDateUtils.j(item.activity_date), this.g));
        helper.setGone(R.id.content_view_parent_cv, true);
        if (TextUtils.isEmpty(item.other_tips)) {
            helper.setGone(R.id.ll_city_divider, false).setGone(R.id.tv_city_divider, false);
        } else {
            helper.setGone(R.id.ll_city_divider, true).setGone(R.id.tv_city_divider, true).setText(R.id.tv_city_divider, item.other_tips);
            helper.setGone(R.id.content_view_parent_cv, !TextUtils.isEmpty(item.id));
        }
        ImageView imageView = (ImageView) helper.getView(R.id.iv_event_address);
        if (item.mode_id == 1) {
            imageView.setImageDrawable(BluedSkinUtils.b(this.mContext, R.drawable.icon_event_location_list));
            if (!TextUtils.isEmpty(item.city) && !TextUtils.isEmpty(item.location)) {
                str = item.city + (char) 183 + ((Object) item.location);
            } else if (!TextUtils.isEmpty(item.city)) {
                str = item.city;
                Intrinsics.c(str, "item.city");
            } else if (TextUtils.isEmpty(item.location)) {
                str = "";
            } else {
                str = item.location;
                Intrinsics.c(str, "item.location");
            }
            String str2 = str;
            helper.setText(R.id.tv_event_address, str2);
            helper.setText(R.id.tv_event_address_shadow, str2);
            helper.setGone(R.id.iv_event_address, !TextUtils.isEmpty(str2));
            helper.setText(R.id.tv_distance, Intrinsics.a(" | ", (Object) EventMethods.b(item.distance)));
            helper.setGone(R.id.tv_distance, item.show_distance == 1);
        } else {
            imageView.setImageDrawable(BluedSkinUtils.b(this.mContext, R.drawable.icon_online_event_address_list));
            helper.setText(R.id.tv_event_address, this.mContext.getString(R.string.event_online_event));
            helper.setText(R.id.tv_event_address_shadow, this.mContext.getString(R.string.event_online_event));
            helper.setGone(R.id.tv_distance, false);
        }
        final View view = helper.getView(R.id.tv_event_address);
        view.post(new Runnable() { // from class: com.blued.community.ui.event.adapter.-$$Lambda$EventListAdapter$DNjki99g6ROilh7PjqPcq0PvKZY
            @Override // java.lang.Runnable
            public final void run() {
                EventListAdapter.a(helper, view);
            }
        });
        float f = item.join_num / item.quota_num;
        if (f == 0.0f) {
            format = this.mContext.getString(R.string.wait_you_be_1);
            Intrinsics.c(format, "{\n                mConte…t_you_be_1)\n            }");
        } else if (f < 0.8f) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String string = this.mContext.getString(R.string.x_joiners, String.valueOf(item.join_num));
            Intrinsics.c(string, "mContext.getString(R.str…item.join_num.toString())");
            format = String.format(string, Arrays.copyOf(new Object[0], 0));
            Intrinsics.c(format, "format(format, *args)");
        } else {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.a;
            String string2 = this.mContext.getString(R.string.x_spaces_available, String.valueOf(item.quota_num - item.join_num));
            Intrinsics.c(string2, "mContext.getString(R.str…tem.join_num).toString())");
            format = String.format(string2, Arrays.copyOf(new Object[0], 0));
            Intrinsics.c(format, "format(format, *args)");
        }
        helper.setText(R.id.tv_event_numbers, format);
        if (item.joiners == null || f >= 0.8f) {
            helper.setGone(R.id.container_stack_users, false);
        } else {
            helper.setGone(R.id.container_stack_users, true);
            Context context = this.mContext;
            IRequestHost iRequestHost = this.a;
            View view2 = helper.getView(R.id.container_stack_users);
            Intrinsics.c(view2, "helper.getView(R.id.container_stack_users)");
            ViewUtils.a(context, iRequestHost, (LinearLayout) view2, item.joiners, 3, item.join_num, 18.0f, 5.5f);
        }
        helper.setText(R.id.tv_event_tag, item.type_name);
        boolean c = CommunityManager.a.a().c(item.uid);
        ShapeTextView shapeTextView3 = (ShapeTextView) helper.getView(R.id.tv_event_sign_up);
        ShapeTextView shapeTextView4 = (ShapeTextView) helper.getView(R.id.tv_event_score);
        ImageView imageView2 = (ImageView) helper.getView(R.id.iv_event_sign_up_status);
        int a = EventMethods.a(item);
        if (a != 0) {
            imageView2.setImageResource(a);
        }
        shapeTextView3.setVisibility(8);
        shapeTextView4.setVisibility(8);
        imageView2.setVisibility(8);
        if (!c) {
            int i = item.status;
            if (i == 1) {
                int i2 = item.apply_status;
                if (i2 != 0) {
                    if (i2 == 1) {
                        if (item.mode_id == 1 && item.is_sure_sign_in == 1 && item.is_sign_in == 0) {
                            shapeTextView3.setVisibility(0);
                            shapeTextView3.setText(R.string.go_to_sign_in);
                            shapeTextView3.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.adapter.-$$Lambda$EventListAdapter$qMGvEThn6pc6TIiJyL3IOaNyiao
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view3) {
                                    EventListAdapter.b(EventListAdapter.this, item, view3);
                                }
                            });
                        } else if (item.evaluate_status == 0 && (item.mode_id == 2 || item.is_sign_in == 1)) {
                            EventTrackFeed.j(FeedProtos.Event.ACTIVITY_COMMENT_SHOW, item.id);
                            shapeTextView4.setVisibility(0);
                            shapeTextView4.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.adapter.-$$Lambda$EventListAdapter$OZ3_QkbDm29EsdnMrCyQbKe6IU0
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view3) {
                                    EventListAdapter.c(EventListAdapter.this, item, view3);
                                }
                            });
                        }
                    }
                } else if (item.join_num < item.quota_num) {
                    shapeTextView3.setVisibility(0);
                    shapeTextView3.setText(R.string.event_sign_up_btn_content);
                    shapeTextView3.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.adapter.-$$Lambda$EventListAdapter$bc2LEIHqXSjX293TuZ1pH8fkTJ4
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            EventListAdapter.a(EventListAdapter.this, item, view3);
                        }
                    });
                }
            } else if (i == 3 && item.apply_status == 1 && item.evaluate_status == 0 && (item.mode_id == 2 || item.is_sign_in == 1)) {
                EventTrackFeed.j(FeedProtos.Event.ACTIVITY_COMMENT_SHOW, item.id);
                shapeTextView4.setVisibility(0);
                shapeTextView4.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.adapter.-$$Lambda$EventListAdapter$LgPd7n3S-k0kThzRoyXhmVDJELI
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        EventListAdapter.d(EventListAdapter.this, item, view3);
                    }
                });
            }
            if (shapeTextView3.getVisibility() == 8 && shapeTextView4.getVisibility() == 8 && a != 0) {
                imageView2.setVisibility(0);
            }
        } else if (a == 0 || !(item.status == 0 || item.status == 1 || item.status == 3)) {
            imageView2.setVisibility(8);
        } else {
            imageView2.setVisibility(0);
        }
        helper.getView(R.id.content_view).setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.adapter.-$$Lambda$EventListAdapter$JBdjwMpQuoEXUUKxWaOGJtEtR1s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                EventListAdapter.a(EventDetailsModel.this, this, view3);
            }
        });
        if (item.status == 4 || item.status == 5) {
            helper.setGone(R.id.tv_event_froze, true).setGone(R.id.view_event_froze, true).setGone(R.id.tv_event_standard, true).setGone(R.id.tv_event_tag, false).setGone(R.id.tv_event_tag_official, false).setGone(R.id.tv_event_time, false).setGone(R.id.tv_event_address, false).setGone(R.id.tv_distance, false).setGone(R.id.iv_event_address, false);
            if (item.status == 4) {
                helper.setText(R.id.tv_event_froze, this.mContext.getString(R.string.event_froze));
            } else {
                helper.setText(R.id.tv_event_froze, this.mContext.getString(R.string.event_dissolved));
            }
            ((TextView) helper.getView(R.id.tv_event_numbers)).setVisibility(4);
            if (item.status == 4) {
                helper.getView(R.id.view_event_froze).setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.adapter.-$$Lambda$EventListAdapter$v2dF0KztXpHh52ym3jlIQ6odFw8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        EventListAdapter.b(EventDetailsModel.this, this, view3);
                    }
                });
            } else {
                helper.setGone(R.id.tv_event_standard, false);
            }
        }
        if (item.isShowUrlVisited) {
            return;
        }
        EventTrackFeed.j(FeedProtos.Event.ACTIVITY_AGG_PAGE_ACTIVITY_SHOW, item.id);
        item.isShowUrlVisited = true;
    }

    public final void a(boolean z) {
        this.g = z;
    }
}

package com.blued.community.ui.event.adapter;

import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.View;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.RegExpUtils;
import com.blued.android.module.common.utils.LinkMovementClickMethod;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.event.fragment.EventDetailsFragment;
import com.blued.community.ui.event.fragment.EventUserInfoDlgFragment;
import com.blued.community.ui.event.model.EventLogData;
import com.blued.community.ui.feed.fragment.FeedDetailsFragment;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.feed.model.FeedDetailParams;
import com.blued.community.utils.AtUserHelper;
import com.blued.community.utils.MarkDownLinkHelper;
import com.blued.community.utils.StringUtils;
import com.blued.community.view.TextViewFixTouchForDynamic;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/adapter/EventReviewAdapter.class */
public final class EventReviewAdapter extends BaseQuickAdapter<BluedIngSelfFeed, BaseViewHolder> {
    private final BaseFragment a;
    private String b;
    private String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventReviewAdapter(BaseFragment fragment) {
        super(R.layout.item_event_review);
        Intrinsics.e(fragment, "fragment");
        this.a = fragment;
    }

    private final CharSequence a(final Context context, String str) {
        return StringUtils.a(AtUserHelper.a(MarkDownLinkHelper.a(context, StringUtils.a(str, DensityUtils.a(context, 14.0f), 0), true, R.color.syc_m, true, (MarkDownLinkHelper.MDLinkOnClickListener) null), BluedSkinUtils.a(context, R.color.syc_m), new AtUserHelper.AtUserLinkOnClickListener() { // from class: com.blued.community.ui.event.adapter.-$$Lambda$EventReviewAdapter$ZKOAbdtButM5IQnUmJJq1wx1dbU
            public final void onClick(String str2, String str3) {
                EventReviewAdapter.a(context, str2, str3);
            }
        }), true, new boolean[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Context context, String str, String str2) {
        Intrinsics.e(context, "$context");
        if (!TextUtils.isEmpty(str)) {
            CommunityServiceManager.b().a(context, str, FeedMethods.a(-1, 0));
        } else if (TextUtils.isEmpty(str2)) {
        } else {
            CommunityServiceManager.b().b(context, str2, FeedMethods.a(-1, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BluedIngSelfFeed item, EventReviewAdapter this$0, View view) {
        Intrinsics.e(item, "$item");
        Intrinsics.e(this$0, "this$0");
        EventLogData eventLogData = new EventLogData();
        eventLogData.setEventId(item.activity_id);
        eventLogData.setEventManagerUid(item.uid);
        eventLogData.setSourcePage(FeedProtos.SourcePage.ACTIVITY_FEED_DETAIL);
        EventDetailsFragment.Companion companion = EventDetailsFragment.a;
        Context mContext = this$0.mContext;
        Intrinsics.c(mContext, "mContext");
        companion.a(mContext, item.activity_data.id, eventLogData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventReviewAdapter this$0, BluedIngSelfFeed item, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        EventLogData eventLogData = new EventLogData();
        eventLogData.setEventId(this$0.c);
        eventLogData.setEventManagerUid(item.feed_uid);
        eventLogData.setSourcePage(FeedProtos.SourcePage.ACTIVITY_DETAIL);
        EventUserInfoDlgFragment.a.a(this$0.a.getParentFragmentManager(), item.feed_uid, this$0.c, eventLogData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventReviewAdapter this$0, BluedIngSelfFeed item, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        CommunityServiceManager.b().a(this$0.mContext, item, i, 0, (LoadOptions) null, item.user_name, 25);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(TextViewFixTouchForDynamic contentView, EventReviewAdapter this$0, View view) {
        Intrinsics.e(contentView, "$contentView");
        Intrinsics.e(this$0, "this$0");
        String obj = contentView.getText().toString();
        if (Build.VERSION.SDK_INT < 11 || Build.VERSION.SDK_INT == 18) {
            Object systemService = this$0.mContext.getSystemService("clipboard");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.text.ClipboardManager");
            }
            ((ClipboardManager) systemService).setText(RegExpUtils.a(obj));
        } else {
            Object systemService2 = this$0.mContext.getSystemService("clipboard");
            if (systemService2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
            }
            try {
                ((android.content.ClipboardManager) systemService2).setPrimaryClip(ClipData.newPlainText("simple text", RegExpUtils.a(obj)));
            } catch (Exception e) {
            }
        }
        AppMethods.a((CharSequence) this$0.mContext.getResources().getString(R.string.copy));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EventReviewAdapter this$0, BluedIngSelfFeed item, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        this$0.a(item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(EventReviewAdapter this$0, BluedIngSelfFeed item, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        this$0.a(item);
    }

    protected final void a(View contain, final TextViewFixTouchForDynamic contentView, CharSequence charSequence) {
        Intrinsics.e(contain, "contain");
        Intrinsics.e(contentView, "contentView");
        contentView.setMaxWidth(AppInfo.l - DensityUtils.a(this.mContext, 80.0f));
        contentView.setMoeTextColor(BluedSkinUtils.a(this.mContext, R.color.syc_h), false);
        contentView.setMaxLines(5);
        contentView.setExpandText(charSequence);
        contentView.setMovementMethod(LinkMovementClickMethod.a());
        contain.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.blued.community.ui.event.adapter.-$$Lambda$EventReviewAdapter$X_Iw3FUAmcW7s2dDKpX72WkpV_M
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean a;
                a = EventReviewAdapter.a(contentView, this, view);
                return a;
            }
        });
    }

    public final void a(BluedIngSelfFeed item) {
        Intrinsics.e(item, "item");
        FeedDetailsFragment.a(this.mContext, item, 25, new FeedDetailParams(0));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:69:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void convert(com.chad.library.adapter.base.BaseViewHolder r19, final com.blued.community.model.BluedIngSelfFeed r20) {
        /*
            Method dump skipped, instructions count: 1251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.community.ui.event.adapter.EventReviewAdapter.convert(com.chad.library.adapter.base.BaseViewHolder, com.blued.community.model.BluedIngSelfFeed):void");
    }

    public final void a(String str) {
        this.b = str;
    }

    public final void b(String str) {
        this.c = str;
    }
}

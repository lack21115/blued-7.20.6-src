package com.blued.community.ui.feed.manager;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.blued.ad.ADConstants;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.db.NewFeedDao;
import com.blued.android.module.common.db.model.NewFeedModel;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.view.FollowStatusView;
import com.blued.android.module.common.utils.ADClosePopOptionsHelper;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.common.widget.menu.ActionSheet;
import com.blued.android.module.common.widget.menu.ActionSheetDefaultItem;
import com.blued.android.module.common.widget.menu.BluedActionSheet;
import com.blued.android.module.common.widget.menu.CommonShowBottomWindow;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.http.CommunityHttpUtils;
import com.blued.community.http.EventHttpUtils;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.manager.CommunityConstants;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedParse;
import com.blued.community.track.ByteDanceEvent;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.community.ui.circle.model.CircleJoinState;
import com.blued.community.ui.circle.view.CircleJoinView;
import com.blued.community.ui.comment.model.FeedComment;
import com.blued.community.ui.event.model.EventDetailsModel;
import com.blued.community.ui.event.model.EventLogData;
import com.blued.community.ui.eventbus.BusFeedInteractModel;
import com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.blued.community.ui.feed.model.FeedRepost;
import com.blued.community.ui.feed.observer.IFeedDataObserver;
import com.blued.community.ui.send.fragment.EventScoreAddPostFragment;
import com.blued.community.ui.send.fragment.FeedAddPostFragment;
import com.blued.community.ui.send.model.FeedTemplateTitleModel;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.community.utils.CommunityPreferences;
import com.blued.community.utils.StringUtils;
import com.blued.community.utils.UserInfoUtils;
import com.blued.community.utils.ViewUtils;
import com.blued.community.view.VerticalCenterImageSpan;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.message.MessageProtos;
import com.blued.das.profile.PersonalProfileProtos;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/manager/FeedMethods.class */
public class FeedMethods {

    /* renamed from: a  reason: collision with root package name */
    public static int f19823a = -1;
    public static ArrayMap<String, String> b = new ArrayMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static int f19824c = 2500;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.community.ui.feed.manager.FeedMethods$14  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/manager/FeedMethods$14.class */
    public class AnonymousClass14 implements ActionSheet.ActionSheetListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentActivity f19830a;
        final /* synthetic */ int[] b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BluedIngSelfFeed f19831c;
        final /* synthetic */ IRequestHost d;

        AnonymousClass14(FragmentActivity fragmentActivity, int[] iArr, BluedIngSelfFeed bluedIngSelfFeed, IRequestHost iRequestHost) {
            this.f19830a = fragmentActivity;
            this.b = iArr;
            this.f19831c = bluedIngSelfFeed;
            this.d = iRequestHost;
        }

        @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
        public void a(ActionSheet actionSheet, final int i) {
            FragmentActivity fragmentActivity = this.f19830a;
            CommonAlertDialog.a(fragmentActivity, (String) null, fragmentActivity.getResources().getString(R.string.feed_confirm_edit_read_auth_hint), this.f19830a.getResources().getString(R.string.feed_confirm_edit), new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.feed.manager.FeedMethods.14.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Tracker.onClick(dialogInterface, i2);
                    final int i3 = AnonymousClass14.this.b[i];
                    final Dialog a2 = DialogUtils.a(AnonymousClass14.this.f19830a);
                    FeedHttpUtils.b(AnonymousClass14.this.f19831c.feed_id, i3, new BluedUIHttpResponse<BluedEntity>() { // from class: com.blued.community.ui.feed.manager.FeedMethods.14.1.1
                        @Override // com.blued.android.framework.http.BluedUIHttpResponse
                        public void onUIFinish() {
                            super.onUIFinish();
                            DialogUtils.b(a2);
                        }

                        @Override // com.blued.android.framework.http.BluedUIHttpResponse
                        public void onUIStart() {
                            super.onUIStart();
                            DialogUtils.a(a2);
                        }

                        @Override // com.blued.android.framework.http.BluedUIHttpResponse
                        public void onUIUpdate(BluedEntity bluedEntity) {
                            AppMethods.a((CharSequence) AnonymousClass14.this.f19830a.getResources().getString(R.string.community_done));
                            AnonymousClass14.this.f19831c.reading_scope = i3;
                            LiveEventBus.get("feed_read_setting").post(AnonymousClass14.this.f19831c);
                        }
                    }, AnonymousClass14.this.d);
                }
            }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
        }

        @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
        public void a(ActionSheet actionSheet, boolean z) {
        }
    }

    /* renamed from: com.blued.community.ui.feed.manager.FeedMethods$16  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/manager/FeedMethods$16.class */
    class AnonymousClass16 implements ADClosePopOptionsHelper.ADOptionsListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f19839a;
        final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f19840c;
        final /* synthetic */ int d;
        final /* synthetic */ Context e;
        final /* synthetic */ ADConstants.AD_POSITION f;
        final /* synthetic */ ADRemovedListener g;

        @Override // com.blued.android.module.common.utils.ADClosePopOptionsHelper.ADOptionsListener
        public void a() {
        }

        @Override // com.blued.android.module.common.utils.ADClosePopOptionsHelper.ADOptionsListener
        public void b() {
            EventTrackFeed.a(FeedProtos.Event.CITY_AD_CLOSE_OPEN_VIP_CLICK, this.f19839a, this.b, this.f19840c, this.d);
            CommunityServiceManager.b().a(this.e, 2, this.f, 27, VipProtos.FromType.UNKNOWN_FROM);
        }

        @Override // com.blued.android.module.common.utils.ADClosePopOptionsHelper.ADOptionsListener
        public void c() {
            EventTrackFeed.a(FeedProtos.Event.CITY_AD_CLOSE_TRUE_CLICK, this.f19839a, this.b, this.f19840c, this.d);
        }

        @Override // com.blued.android.module.common.utils.ADClosePopOptionsHelper.ADOptionsListener
        public void d() {
            this.g.a();
        }

        @Override // com.blued.android.module.common.utils.ADClosePopOptionsHelper.ADOptionsListener
        public int e() {
            return CommunityServiceManager.a().y();
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/manager/FeedMethods$ADRemovedListener.class */
    public interface ADRemovedListener {
        void a();
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/manager/FeedMethods$UserNameClickSpan.class */
    public static class UserNameClickSpan extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        Context f19863a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        String f19864c;
        String d;
        String e;
        String f;
        int g;

        public UserNameClickSpan(Context context, String str, String str2, String str3, String str4, String str5, int i) {
            this.f19863a = context;
            this.b = str;
            this.f19864c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
            this.g = i;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Selection.removeSelection((Spannable) ((TextView) view).getText());
            if (!StringUtils.c(this.f19864c)) {
                AppMethods.d(R.string.circle_anonymous_not_to_user_info);
            } else if (TextUtils.isEmpty(this.f19864c)) {
                CommunityServiceManager.b().b(this.f19863a, this.d, this.f);
            } else {
                CommunityServiceManager.b().a(this.f19863a, this.f19864c, this.f);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (this.g == 0) {
                this.g = BluedSkinUtils.a(this.f19863a, R.color.syc_h);
            }
            textPaint.setColor(BluedSkinUtils.a(this.f19863a, this.g));
            textPaint.setUnderlineText(false);
        }
    }

    public static int a(float f) {
        return DisplayUtil.a(AppInfo.d(), f);
    }

    public static StaticLayout a(CharSequence charSequence, TextPaint textPaint, int i) {
        return a(charSequence, textPaint, i, 1.0f, 1.0f);
    }

    public static StaticLayout a(CharSequence charSequence, TextPaint textPaint, int i, float f, float f2) {
        if (charSequence == null) {
            return null;
        }
        return Build.VERSION.SDK_INT >= 23 ? StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f, f2).setBreakStrategy(1).setHyphenationFrequency(2).build() : new StaticLayout(charSequence, 0, charSequence.length(), textPaint, i, Layout.Alignment.ALIGN_NORMAL, f, f2, true);
    }

    public static LogData a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
        return a(bluedIngSelfFeed, i, false, (String) null, -1);
    }

    public static LogData a(BluedIngSelfFeed bluedIngSelfFeed, int i, boolean z, String str, int i2) {
        LogData logData = new LogData();
        if (bluedIngSelfFeed == null) {
            return logData;
        }
        logData.distance = b(bluedIngSelfFeed, i).getDistance();
        boolean z2 = true;
        if (bluedIngSelfFeed.in_promotion != 1) {
            z2 = false;
        }
        logData.is_feed_super_exposure = z2;
        logData.feed_id = bluedIngSelfFeed.feed_id;
        logData.target_uid = bluedIngSelfFeed.feed_uid;
        logData.is_hot_feed = bluedIngSelfFeed.is_hot_feed;
        logData.strong_insert_data = bluedIngSelfFeed.strong_insert_data;
        if (!TextUtils.isEmpty(bluedIngSelfFeed.activity_id) && CommonStringUtils.c(bluedIngSelfFeed.activity_id) > 0) {
            logData.activity_id = bluedIngSelfFeed.activity_id;
        }
        if (!TextUtils.isEmpty(bluedIngSelfFeed.circle_id) && CommonStringUtils.c(bluedIngSelfFeed.circle_id) > 0) {
            logData.circle_id = bluedIngSelfFeed.circle_id;
        }
        logData.feedFrom = i;
        logData.is_new_face = bluedIngSelfFeed.is_new_face;
        logData.recommend_time = bluedIngSelfFeed.recommend_time;
        logData.listMode = "";
        if (!TextUtils.isEmpty(str)) {
            logData.topic_id = str;
        }
        if (i2 != -1) {
            logData.topic_category = i2 + "";
        }
        logData.super_tag_image = bluedIngSelfFeed.super_tag_image;
        logData.is_questionnaire = bluedIngSelfFeed.is_questionnaire;
        logData.is_vote = bluedIngSelfFeed.is_vote;
        logData.tt_type = bluedIngSelfFeed.tt_type;
        return logData;
    }

    public static FeedTemplateTitleModel a(ArrayList<FeedTemplateTitleModel> arrayList, String str) {
        boolean z;
        if (TypeUtils.a((List<?>) arrayList)) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        String q = CommunityPreferences.q(str);
        LogUtils.c(str + "--> getFeedGuideNextTemplateTitlePids: " + q);
        String str2 = q;
        if (q == null) {
            str2 = "";
        }
        String[] split = str2.split(",");
        Iterator<FeedTemplateTitleModel> it = arrayList.iterator();
        while (it.hasNext()) {
            FeedTemplateTitleModel next = it.next();
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                z = false;
                if (i2 >= length) {
                    break;
                } else if (split[i2].contentEquals(String.valueOf(next.getP_id()))) {
                    z = true;
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            if (!z) {
                arrayList2.add(next);
            }
        }
        if (arrayList2.size() <= 0 || arrayList2.get(0) == 0) {
            return null;
        }
        CommunityPreferences.a(str, str2 + ((FeedTemplateTitleModel) arrayList2.get(0)).getP_id() + ",");
        LogUtils.c(str + "--> setGuideTitleModel: " + ((FeedTemplateTitleModel) arrayList2.get(0)).getText());
        return (FeedTemplateTitleModel) arrayList2.get(0);
    }

    public static FeedProtos.SourcePage a(int i) {
        return i != 0 ? (i == 1 || i == 11) ? FeedProtos.SourcePage.FEED_PERSONAL_FEED : FeedProtos.SourcePage.ACTIVITY_FEED : FeedProtos.SourcePage.FEED_PLAZA_FOLLOW;
    }

    public static CharSequence a(Context context, int i, FeedComment feedComment, int i2, int i3) {
        if (TextUtils.isEmpty(feedComment.comment_id)) {
            return "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(feedComment.comment_content);
        StringBuilder sb = new StringBuilder();
        sb.append((Object) spannableStringBuilder);
        sb.append("");
        return TextUtils.isEmpty(sb.toString()) ? "" : StringUtils.a(StringUtils.a(StringUtils.a(spannableStringBuilder, i, 1), true, true, false, null, true, "", a(i2, 0)), true, new boolean[0]);
    }

    public static CharSequence a(Context context, int i, FeedComment feedComment, int i2, int i3, int i4) {
        if (TextUtils.isEmpty(feedComment.comment_id)) {
            return "";
        }
        String replace = feedComment.reply_name != null ? feedComment.reply_name.replace(":", "") : "";
        String str = feedComment.comment_content;
        String str2 = feedComment.reply_uid;
        String str3 = feedComment.reply_avatar;
        String str4 = context.getResources().getString(R.string.reply) + " ";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str4 + replace + ": " + str);
        try {
            int length = str4.length() + spannableStringBuilder.toString().indexOf(str4);
            spannableStringBuilder.setSpan(new UserNameClickSpan(context, spannableStringBuilder.toString().substring(length >= spannableStringBuilder.toString().length() ? spannableStringBuilder.toString().length() - 1 : length, spannableStringBuilder.toString().indexOf(":")), str2, replace, str3, a(i3, 0), i4), length, spannableStringBuilder.toString().indexOf(":") + 1, 17);
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        sb.append((Object) spannableStringBuilder);
        sb.append("");
        return TextUtils.isEmpty(sb.toString()) ? "" : StringUtils.a(StringUtils.a(StringUtils.a(spannableStringBuilder, i, 1), true, true, false, null, true, "", a(i3, 0)), true, new boolean[0]);
    }

    public static String a(int i, int i2) {
        if (i != 0) {
            if (i != 2) {
                if (i != 14) {
                    if (i != 19) {
                        if (i != 4) {
                            if (i != 5) {
                                if (i != 6) {
                                    if (i != 29) {
                                        if (i != 30) {
                                            switch (i) {
                                                case 10:
                                                    return "feed_image";
                                                case 11:
                                                    return "PAGE_FEED_MINE";
                                                case 12:
                                                    return "PAGE_FEED_LIKE";
                                                default:
                                                    return "";
                                            }
                                        }
                                        return "sunject_latest";
                                    }
                                    return "sunject_recommend";
                                }
                                return "feed_square";
                            }
                            return "topic_detail";
                        }
                        return "feed_nearby";
                    }
                    return "feed_city_time";
                }
                return "PAGE_FEED_DETAIL_MORE";
            }
            return "feed_detail";
        }
        return "feed_followed";
    }

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        String[] stringArray = context.getResources().getStringArray(R.array.comment_hint);
        return stringArray[(int) (Math.random() * (stringArray.length - 1))];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(int i, BluedIngSelfFeed bluedIngSelfFeed, String str, Context context, FollowStatusView followStatusView, IRequestHost iRequestHost, BluedActionSheet bluedActionSheet) {
        EventTrackFeed.a(EventTrackFeed.f(i), bluedIngSelfFeed.circle_id, bluedIngSelfFeed.feed_id, "follow", bluedIngSelfFeed.feed_uid, str);
        a(context, followStatusView, bluedIngSelfFeed, i, iRequestHost);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(int i, BluedIngSelfFeed bluedIngSelfFeed, String str, Context context, BluedActionSheet bluedActionSheet) {
        EventTrackFeed.a(EventTrackFeed.f(i), bluedIngSelfFeed.circle_id, bluedIngSelfFeed.feed_id, "report", bluedIngSelfFeed.feed_uid, str);
        CommunityServiceManager.b().a(context, CommunityConstants.ReportType.CIRCLE, bluedIngSelfFeed.user_name, bluedIngSelfFeed.feed_id, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(int i, BluedIngSelfFeed bluedIngSelfFeed, String str, FeedListAdapterForRecyclerView feedListAdapterForRecyclerView, int i2, BluedActionSheet bluedActionSheet) {
        EventTrackFeed.a(EventTrackFeed.f(i), bluedIngSelfFeed.circle_id, bluedIngSelfFeed.feed_id, ReqAckPackage.REQ_RESPONSE_KEY.NOTE, bluedIngSelfFeed.feed_uid, str);
        if (bluedIngSelfFeed.isIs_unliked_users_url_visited) {
            return;
        }
        if (bluedIngSelfFeed.unliked_users_url != null && bluedIngSelfFeed.unliked_users_url.length > 0) {
            CommunityHttpUtils.a(bluedIngSelfFeed.unliked_users_url);
        }
        bluedIngSelfFeed.isIs_unliked_users_url_visited = true;
        feedListAdapterForRecyclerView.remove(i2);
        LiveEventBus.get("feed_delete").post(bluedIngSelfFeed);
    }

    public static void a(Context context, int i, ImageView imageView, TextView textView) {
        if (i == 1) {
            imageView.setImageResource(R.drawable.feed_visible_fans);
            textView.setText(context.getString(R.string.feed_visible_friends));
        } else if (i != 2) {
            imageView.setImageResource(R.drawable.feed_visible_all);
            textView.setText(context.getString(R.string.feed_public));
        } else {
            imageView.setImageResource(R.drawable.feed_visible_self);
            textView.setText(context.getString(R.string.feed_visible_self));
        }
    }

    public static void a(Context context, TextView textView, FeedComment feedComment, String str, int i) {
        String str2 = feedComment.reply_name;
        String str3 = feedComment.comment_content;
        String str4 = feedComment.reply_uid;
        String str5 = feedComment.reply_avatar;
        String string = context.getResources().getString(R.string.reply);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + str2 + ": " + str3);
        spannableStringBuilder.setSpan(new UserNameClickSpan(context, spannableStringBuilder.toString().substring(spannableStringBuilder.toString().indexOf(string) + string.length(), spannableStringBuilder.toString().indexOf(":")), str4, str2, str5, str, i), spannableStringBuilder.toString().indexOf(string) + string.length(), spannableStringBuilder.toString().indexOf(":"), 17);
        StringUtils.a(textView, spannableStringBuilder, 0, str);
    }

    public static void a(Context context, UserBasicModel userBasicModel, LogData logData, MessageProtos.StrangerSource strangerSource) {
        CommunityServiceManager.b().a(context, userBasicModel, logData, false, 0, strangerSource);
    }

    public static void a(Context context, final FollowStatusView followStatusView, final BluedIngSelfFeed bluedIngSelfFeed, int i, IRequestHost iRequestHost) {
        LogData logData = new LogData();
        logData.logService = "square_attention_click";
        logData.target_uid = bluedIngSelfFeed.feed_uid;
        logData.type = bluedIngSelfFeed.recommend_text;
        CommunityServiceManager.d().a(logData);
        if (followStatusView != null) {
            followStatusView.setRelationShip("1");
        }
        CommunityHttpUtils.b(context, new CommunityHttpUtils.IAddOrRemoveAttentionDone() { // from class: com.blued.community.ui.feed.manager.FeedMethods.22
            @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
            public void a() {
            }

            @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
            public void a(String str) {
                BluedIngSelfFeed.this.relationship = "1";
                BluedIngSelfFeed.this.forceShowFollowedStatus = true;
                AppMethods.d(R.string.community_follow_success);
            }

            @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
            public void b() {
            }

            @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
            public void b(String str) {
            }

            @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
            public void c() {
                FollowStatusView followStatusView2 = followStatusView;
                if (followStatusView2 != null) {
                    followStatusView2.setRelationShip("0");
                }
            }
        }, bluedIngSelfFeed.feed_uid, "shine_video_list", iRequestHost);
        EventTrackFeed.a(bluedIngSelfFeed.feed_uid, bluedIngSelfFeed.feed_id, TextUtils.isEmpty(bluedIngSelfFeed.super_did) ? "" : bluedIngSelfFeed.super_did, EventTrackFeed.c(i), true, bluedIngSelfFeed.live > 0, bluedIngSelfFeed.in_promotion == 1, bluedIngSelfFeed.strong_insert_data);
    }

    public static void a(Context context, BluedIngSelfFeed bluedIngSelfFeed, int i) {
        a(context, bluedIngSelfFeed, false, i, (String) null, -1, false);
    }

    public static void a(Context context, final BluedIngSelfFeed bluedIngSelfFeed, int i, final CircleJoinView circleJoinView, final TextView textView, String str, IRequestHost iRequestHost) {
        EventTrackFeed.a(bluedIngSelfFeed.circle_id, bluedIngSelfFeed.feed_id, EventTrackFeed.k(i), bluedIngSelfFeed.allow_join == 0, bluedIngSelfFeed.classify_id, str);
        if (bluedIngSelfFeed.is_applied == 1) {
            AppMethods.d(R.string.circle_comment_apply_tip);
            return;
        }
        FragmentManager fragmentManager = null;
        if (context instanceof AppCompatActivity) {
            fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
        }
        final boolean z = i == 6;
        final boolean z2 = i == 18;
        CircleMethods.a(context, new CircleMethods.JoinViewChangeListener() { // from class: com.blued.community.ui.feed.manager.FeedMethods.23
            @Override // com.blued.community.ui.circle.manager.CircleMethods.JoinViewChangeListener
            public void joinViewChange(CircleJoinState circleJoinState) {
                BluedIngSelfFeed.this.setJoinState(circleJoinState);
                CircleJoinView circleJoinView2 = circleJoinView;
                if (circleJoinView2 != null) {
                    circleJoinView2.setJoinStatus(BluedIngSelfFeed.this.getJoinState());
                }
                if (BluedIngSelfFeed.this.isMember()) {
                    FeedMethods.b(circleJoinView, textView, z, z2);
                }
            }
        }, bluedIngSelfFeed.getJoinState(), iRequestHost, fragmentManager, false, true);
    }

    public static void a(Context context, BluedIngSelfFeed bluedIngSelfFeed, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2, String str, IRequestHost iRequestHost) {
        EventDetailsModel eventDetailsModel = new EventDetailsModel();
        eventDetailsModel.join_num = bluedIngSelfFeed.activity_join_num;
        eventDetailsModel.quota_num = bluedIngSelfFeed.activity_quota_num;
        eventDetailsModel.joiners = bluedIngSelfFeed.activity_joiners;
        eventDetailsModel.max_evaluate = bluedIngSelfFeed.activity_max_evaluate;
        textView.setText(bluedIngSelfFeed.activity_guide_text);
        textView2.setText(bluedIngSelfFeed.activity_guide_text);
        imageView.setVisibility(8);
        linearLayout.setVisibility(8);
        textView.setVisibility(8);
        textView2.setVisibility(8);
        switch (bluedIngSelfFeed.activity_guide_type) {
            case 1:
            case 2:
                eventDetailsModel.joiners = bluedIngSelfFeed.followed_joiners;
                ViewUtils.a(context, iRequestHost, linearLayout, eventDetailsModel.joiners, 3, 1, 18.0f, 4.0f);
                linearLayout.setVisibility(0);
                textView2.setVisibility(0);
                return;
            case 3:
            case 6:
                imageView.setVisibility(0);
                textView.setVisibility(0);
                imageView.setImageDrawable(BluedSkinUtils.b(context, R.drawable.icon_eventcard_people));
                return;
            case 4:
                imageView.setVisibility(0);
                textView.setVisibility(0);
                imageView.setImageDrawable(BluedSkinUtils.b(context, R.drawable.icon_eventcard_clock));
                return;
            case 5:
                ViewUtils.a(context, iRequestHost, linearLayout, eventDetailsModel.joiners, 3, eventDetailsModel.join_num, 18.0f, 4.0f);
                linearLayout.setVisibility(0);
                textView2.setVisibility(0);
                return;
            default:
                imageView.setVisibility(8);
                textView.setVisibility(8);
                linearLayout.setVisibility(8);
                textView2.setVisibility(8);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final Context context, final BluedIngSelfFeed bluedIngSelfFeed, IRequestHost iRequestHost) {
        CommunityServiceManager.d().a(PersonalProfileProtos.Event.PERSONAL_PROFILE_FEED_MORE_TOP_CLICK, bluedIngSelfFeed.feed_id);
        FeedHttpUtils.a(new BluedUIHttpResponse() { // from class: com.blued.community.ui.feed.manager.FeedMethods.18

            /* renamed from: c  reason: collision with root package name */
            private boolean f19844c = false;

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                if (i == 4031201) {
                    this.f19844c = true;
                    return true;
                }
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                if (!this.f19844c || context == null) {
                    CommunityServiceManager.d().b("feed_stay_top_click", 1);
                } else {
                    CommunityServiceManager.e().b(context, 9, "feed_stay_top");
                    CommunityServiceManager.d().b("feed_stay_top_click", 0);
                    this.f19844c = false;
                }
                super.onUIFinish();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                BluedIngSelfFeed.this.feed_views = 1;
                LiveEventBus.get("feed_topping").post(BluedIngSelfFeed.this);
                AppMethods.d(R.string.community_done);
            }
        }, bluedIngSelfFeed.feed_id, iRequestHost);
    }

    public static void a(Context context, BluedIngSelfFeed bluedIngSelfFeed, boolean z, int i, String str, int i2, boolean z2) {
        if (bluedIngSelfFeed == null || context == null) {
            return;
        }
        String a2 = a(i, bluedIngSelfFeed.is_vote);
        UserBasicModel b2 = b(bluedIngSelfFeed);
        LogData logData = new LogData();
        logData.logService = "feed_avatar_click";
        logData.id = bluedIngSelfFeed.feed_id;
        logData.type = bluedIngSelfFeed.recommend_text;
        logData.target_uid = bluedIngSelfFeed.feed_uid;
        logData.from = b(i) + "";
        if (!TextUtils.isEmpty(str)) {
            logData.topic_id = str;
        }
        if (i2 != -1) {
            logData.topic_category = i2 + "";
        }
        CommunityServiceManager.d().a(logData);
        if (bluedIngSelfFeed.live > 0 && z2) {
            CommunityServiceManager.b().a(context, b2, bluedIngSelfFeed.live, a2);
            return;
        }
        MessageProtos.StrangerSource b3 = b(i, bluedIngSelfFeed.in_promotion);
        CommunityServiceManager.b().a(context, b2, bluedIngSelfFeed, a2, false, (View) null, a(bluedIngSelfFeed, i, z, str, i2), b3);
        CommunityHttpUtils.a(bluedIngSelfFeed.click_url);
    }

    public static void a(SpannableStringBuilder spannableStringBuilder, String str, String str2, int i, int i2, int i3) {
        Drawable drawable;
        int indexOf;
        if (spannableStringBuilder == null || TextUtils.isEmpty(str) || !str.contains(str2) || i == 0 || (drawable = AppInfo.d().getResources().getDrawable(i)) == null || (indexOf = str.indexOf(str2)) < 0) {
            return;
        }
        drawable.setBounds(0, 0, AppMethods.a(i2), AppMethods.a(i3));
        spannableStringBuilder.setSpan(new VerticalCenterImageSpan(drawable, 2), indexOf, str2.length() + indexOf, 33);
    }

    public static void a(EditText editText) {
        if (editText == null) {
            return;
        }
        editText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.blued.community.ui.feed.manager.FeedMethods.25
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (charSequence.equals(" ")) {
                    return "";
                }
                return null;
            }
        }});
    }

    public static void a(ImageView imageView, int i) {
        if (imageView == null) {
            return;
        }
        if (i != 1) {
            imageView.setVisibility(8);
            return;
        }
        imageView.setVisibility(0);
        imageView.setImageResource(R.drawable.feed_author_icon);
    }

    public static void a(TextView textView, FeedComment feedComment, String str) {
        StringUtils.a(textView, feedComment.comment_content, 0, str);
    }

    public static void a(FragmentActivity fragmentActivity, BluedIngSelfFeed bluedIngSelfFeed, IRequestHost iRequestHost) {
        int i;
        int[] a2 = a();
        String[] stringArray = fragmentActivity.getResources().getStringArray(R.array.feed_read_auth_list);
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= a2.length) {
                i = -1;
                break;
            } else if (a2[i] == bluedIngSelfFeed.reading_scope) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        CommonShowBottomWindow.a(fragmentActivity, stringArray, i, new AnonymousClass14(fragmentActivity, a2, bluedIngSelfFeed, iRequestHost));
    }

    public static void a(LifecycleOwner lifecycleOwner, final IFeedDataObserver iFeedDataObserver) {
        if (iFeedDataObserver == null) {
            return;
        }
        LiveEventBus.get("feed_delete", BluedIngSelfFeed.class).observe(lifecycleOwner, new Observer<BluedIngSelfFeed>() { // from class: com.blued.community.ui.feed.manager.FeedMethods.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(BluedIngSelfFeed bluedIngSelfFeed) {
                if (bluedIngSelfFeed == null) {
                    return;
                }
                IFeedDataObserver.this.a(bluedIngSelfFeed);
            }
        });
        LiveEventBus.get("feed_comment_setting", BluedIngSelfFeed.class).observe(lifecycleOwner, new Observer<BluedIngSelfFeed>() { // from class: com.blued.community.ui.feed.manager.FeedMethods.2
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(BluedIngSelfFeed bluedIngSelfFeed) {
                if (bluedIngSelfFeed == null) {
                    return;
                }
                IFeedDataObserver.this.a(bluedIngSelfFeed.feed_id, bluedIngSelfFeed.allow_comments);
            }
        });
        LiveEventBus.get("feed_read_setting", BluedIngSelfFeed.class).observe(lifecycleOwner, new Observer<BluedIngSelfFeed>() { // from class: com.blued.community.ui.feed.manager.FeedMethods.3
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(BluedIngSelfFeed bluedIngSelfFeed) {
                if (bluedIngSelfFeed == null) {
                    return;
                }
                IFeedDataObserver.this.b(bluedIngSelfFeed.feed_id, bluedIngSelfFeed.reading_scope);
            }
        });
        LiveEventBus.get("feed_like_change", BluedIngSelfFeed.class).observe(lifecycleOwner, new Observer<BluedIngSelfFeed>() { // from class: com.blued.community.ui.feed.manager.FeedMethods.4
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(BluedIngSelfFeed bluedIngSelfFeed) {
                if (bluedIngSelfFeed == null) {
                    return;
                }
                IFeedDataObserver.this.c(bluedIngSelfFeed.feed_id, bluedIngSelfFeed.iliked);
            }
        });
        LiveEventBus.get("feed_add_comment", FeedComment.class).observe(lifecycleOwner, new Observer<FeedComment>() { // from class: com.blued.community.ui.feed.manager.FeedMethods.5
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(FeedComment feedComment) {
                if (feedComment == null) {
                    return;
                }
                IFeedDataObserver.this.a(feedComment);
            }
        });
        LiveEventBus.get("feed_delete_comment", FeedComment.class).observe(lifecycleOwner, new Observer<FeedComment>() { // from class: com.blued.community.ui.feed.manager.FeedMethods.6
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(FeedComment feedComment) {
                if (feedComment == null) {
                    return;
                }
                IFeedDataObserver.this.a(feedComment.feed_id, feedComment.comment_id);
            }
        });
        LiveEventBus.get("feed_add_repost", FeedRepost.class).observe(lifecycleOwner, new Observer<FeedRepost>() { // from class: com.blued.community.ui.feed.manager.FeedMethods.7
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(FeedRepost feedRepost) {
                if (feedRepost == null) {
                    return;
                }
                IFeedDataObserver.this.a(feedRepost);
            }
        });
        LiveEventBus.get("feed_delete_repost", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.community.ui.feed.manager.FeedMethods.8
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                if (str == null) {
                    return;
                }
                IFeedDataObserver.this.c(str);
            }
        });
        LiveEventBus.get("feed_relation_ship", UserBasicModel.class).observe(lifecycleOwner, new Observer<UserBasicModel>() { // from class: com.blued.community.ui.feed.manager.FeedMethods.9
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(UserBasicModel userBasicModel) {
                if (userBasicModel == null) {
                    return;
                }
                IFeedDataObserver.this.b(userBasicModel.uid, userBasicModel.relationship);
            }
        });
        LiveEventBus.get("feed_vote_change", BluedIngSelfFeed.class).observe(lifecycleOwner, new Observer<BluedIngSelfFeed>() { // from class: com.blued.community.ui.feed.manager.FeedMethods.10
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(BluedIngSelfFeed bluedIngSelfFeed) {
                if (bluedIngSelfFeed == null) {
                    return;
                }
                IFeedDataObserver.this.b(bluedIngSelfFeed);
            }
        });
        LiveEventBus.get("feed_dynamic_skin", Integer.class).observe(lifecycleOwner, new Observer<Integer>() { // from class: com.blued.community.ui.feed.manager.FeedMethods.11
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Integer num) {
                IFeedDataObserver.this.c(num.intValue());
            }
        });
        LiveEventBus.get("feed_avatar_widget", Integer.class).observe(lifecycleOwner, new Observer<Integer>() { // from class: com.blued.community.ui.feed.manager.FeedMethods.12
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Integer num) {
                IFeedDataObserver.this.d(num.intValue());
            }
        });
        LiveEventBus.get("feed_topping", BluedIngSelfFeed.class).observe(lifecycleOwner, new Observer<BluedIngSelfFeed>() { // from class: com.blued.community.ui.feed.manager.FeedMethods.13
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(BluedIngSelfFeed bluedIngSelfFeed) {
                IFeedDataObserver.this.d(bluedIngSelfFeed.feed_id, bluedIngSelfFeed.feed_views);
            }
        });
        LiveEventBus.get("EVENT_BUS_FEED_INTERACT", BusFeedInteractModel.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.community.ui.feed.manager.-$$Lambda$FeedMethods$3_8Fx5vuGb2QQ21HlVcQkgTB1CI
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeedMethods.a(IFeedDataObserver.this, (BusFeedInteractModel) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(IRequestHost iRequestHost, final BluedIngSelfFeed bluedIngSelfFeed, final FeedListAdapterForRecyclerView feedListAdapterForRecyclerView, final int i, BluedActionSheet bluedActionSheet) {
        EventHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<String>>(iRequestHost) { // from class: com.blued.community.ui.feed.manager.FeedMethods.17
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<String> bluedEntityA) {
                AppMethods.d(R.string.event_sub_owner_event_success);
                bluedIngSelfFeed.is_subscribe = 1;
                feedListAdapterForRecyclerView.notifyItemChanged(i);
            }
        }, bluedIngSelfFeed.feed_uid, iRequestHost);
        EventLogData eventLogData = new EventLogData();
        eventLogData.setEventId(bluedIngSelfFeed.activity_id);
        eventLogData.setEventManagerUid(bluedIngSelfFeed.feed_uid);
        EventTrackFeed.a(FeedProtos.Event.ACTIVITY_FEED_SUBSCRIBE_CLICK, eventLogData);
    }

    public static void a(BluedIngSelfFeed bluedIngSelfFeed, int i, int i2, String str, int i3, String str2, long j, boolean z) {
        if (bluedIngSelfFeed.isShowUrlVisited) {
            return;
        }
        if ((i == 5 || i == 29 || i == 30) && i3 >= 0) {
            CommunityServiceManager.d().a(bluedIngSelfFeed.feed_id, str, i3, bluedIngSelfFeed.feed_uid);
        } else {
            CommunityServiceManager.d().a(b(i), bluedIngSelfFeed.feed_id, bluedIngSelfFeed.recommend_text, bluedIngSelfFeed.feed_uid);
        }
        if (bluedIngSelfFeed.show_url != null && bluedIngSelfFeed.show_url.length > 0) {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= bluedIngSelfFeed.show_url.length) {
                    break;
                }
                CommunityHttpUtils.a(bluedIngSelfFeed.show_url[i5]);
                i4 = i5 + 1;
            }
        }
        bluedIngSelfFeed.isShowUrlVisited = true;
        TextUtils.isEmpty(bluedIngSelfFeed.promotion_bubble);
        String str3 = TextUtils.isEmpty(bluedIngSelfFeed.super_did) ? "" : bluedIngSelfFeed.super_did;
        if (i == 6 && a(bluedIngSelfFeed)) {
            bluedIngSelfFeed.is_top = bluedIngSelfFeed.is_top_new;
        }
        boolean z2 = bluedIngSelfFeed.is_top_hot == 1;
        boolean z3 = bluedIngSelfFeed.isAfterRecommendRefreshGuide;
        EventTrackFeed.a(FeedProtos.Event.FEED_DRAW, i, str3, String.valueOf(bluedIngSelfFeed.live), bluedIngSelfFeed.is_top == 1, i2, z2, bluedIngSelfFeed.isAnonymous(), bluedIngSelfFeed.is_strong_insert == 1, bluedIngSelfFeed.is_hot_feed == 1, EventTrackFeed.a(bluedIngSelfFeed), str2, bluedIngSelfFeed, z3, j, z);
        ByteDanceEvent.a(FeedProtos.Event.FEED_DRAW.name(), bluedIngSelfFeed, EventTrackFeed.d(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(BluedIngSelfFeed bluedIngSelfFeed, Context context, BluedActionSheet bluedActionSheet) {
        EventTrackFeed.b(FeedProtos.Event.FEED_SETTING_DYNAMIC_SKIN_LOOK_BTN_CLICK, bluedIngSelfFeed.feed_id);
        CommunityServiceManager.b().a(context, 0, "feed_dynamic_skin_look_guest");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final BluedIngSelfFeed bluedIngSelfFeed, IRequestHost iRequestHost) {
        FeedHttpUtils.b(new BluedUIHttpResponse() { // from class: com.blued.community.ui.feed.manager.FeedMethods.19
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                BluedIngSelfFeed.this.feed_views = 0;
                LiveEventBus.get("feed_topping").post(BluedIngSelfFeed.this);
                AppMethods.d(R.string.community_done);
                CommunityServiceManager.e().c();
            }
        }, bluedIngSelfFeed.feed_id, iRequestHost);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(FeedListAdapterForRecyclerView feedListAdapterForRecyclerView, int i, BluedIngSelfFeed bluedIngSelfFeed, BluedActionSheet bluedActionSheet) {
        feedListAdapterForRecyclerView.remove(i);
        CommunityHttpUtils.a(bluedIngSelfFeed.hidden_url);
        LiveEventBus.get("feed_delete").post(bluedIngSelfFeed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(IFeedDataObserver iFeedDataObserver, BusFeedInteractModel busFeedInteractModel) {
        if (busFeedInteractModel == null) {
            return;
        }
        iFeedDataObserver.a(busFeedInteractModel);
    }

    public static void a(List<BluedIngSelfFeed> list, BluedTopic bluedTopic, int i) {
        if (bluedTopic == null || list == null || list.size() == 0) {
            return;
        }
        long a2 = TimeAndDateUtils.a();
        if (a2 > CommunityPreferences.i(i)) {
            CommunityPreferences.b(i, a2);
            CommunityPreferences.a(i, 0);
        }
        int j = CommunityPreferences.j(i);
        LogUtils.c("insertFeedPostSubjectGuide: " + CommunityPreferences.i(i) + ", count:" + j);
        if (j >= 3) {
            return;
        }
        int i2 = bluedTopic.insert_floor;
        int i3 = i2;
        if (list.size() > bluedTopic.insert_floor) {
            i3 = i2;
            if (list.get(bluedTopic.insert_floor).is_ads == 1) {
                i3 = bluedTopic.insert_floor + 1;
            }
        }
        LogUtils.c("insertFeedPostSubjectGuide: insertPosition=" + i3);
        BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed) list.get(0).clone();
        bluedIngSelfFeed.feed_id = "0";
        bluedIngSelfFeed.feed_uid = "0";
        bluedIngSelfFeed.super_did = bluedTopic.super_did;
        bluedIngSelfFeed.super_topics_name = bluedTopic.name;
        bluedIngSelfFeed.feed_type = 29;
        bluedIngSelfFeed.insertSubjectPostGuide = bluedTopic;
        bluedIngSelfFeed.isShowUrlVisited = false;
        if (i3 > list.size()) {
            list.add(bluedIngSelfFeed);
        } else {
            list.add(i3, bluedIngSelfFeed);
        }
        CommunityPreferences.a(i, j + 1);
    }

    public static boolean a(final Context context, final FollowStatusView followStatusView, final BluedIngSelfFeed bluedIngSelfFeed, final int i, final FeedListAdapterForRecyclerView feedListAdapterForRecyclerView, final int i2, final String str, final IRequestHost iRequestHost) {
        EventTrackFeed.a(FeedProtos.Event.FEED_NOTE_MORE_CLICK, EventTrackFeed.f(i), bluedIngSelfFeed.circle_id, bluedIngSelfFeed.feed_id, str);
        boolean z = false;
        boolean z2 = i == 1;
        if (i == 4 || i == 19) {
            z = true;
        }
        if (z2) {
            CommunityServiceManager.d().a(PersonalProfileProtos.Event.PERSONAL_PROFILE_FEED_MORE_CLICK, bluedIngSelfFeed.feed_id);
        }
        BluedActionSheet.Builder builder = new BluedActionSheet.Builder(context);
        if (bluedIngSelfFeed.isMyFeed()) {
            builder.a(ActionSheetDefaultItem.a().a(context.getString(R.string.feed_visible)).a(!bluedIngSelfFeed.isAnonymous()).b(new BluedActionSheet.OnClickActionSheetListener() { // from class: com.blued.community.ui.feed.manager.-$$Lambda$FeedMethods$bJUr86LiirUBCiCWJ73E3OXtBdg
                @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnClickActionSheetListener
                public final void onClickActionSheet(BluedActionSheet bluedActionSheet) {
                    FeedMethods.c(Context.this, bluedIngSelfFeed, iRequestHost, bluedActionSheet);
                }
            }));
            if (bluedIngSelfFeed.can_promotion == 1) {
                builder.a(ActionSheetDefaultItem.a().a(context.getString(R.string.feed_super_exposure_post)).b(R.drawable.icon_feed_super_exposure_post).b(new BluedActionSheet.OnClickActionSheetListener() { // from class: com.blued.community.ui.feed.manager.-$$Lambda$FeedMethods$_xKjdvnN5bwtj_Jc1MFTfDe8Mac
                    @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnClickActionSheetListener
                    public final void onClickActionSheet(BluedActionSheet bluedActionSheet) {
                        FeedMethods.c(BluedIngSelfFeed.this, context, bluedActionSheet);
                    }
                }));
            }
            if (bluedIngSelfFeed.is_bubble_ticktock != 1) {
                builder.a(context.getString(R.string.comment_setting), new BluedActionSheet.OnClickActionSheetListener() { // from class: com.blued.community.ui.feed.manager.-$$Lambda$FeedMethods$W2NhIDP6caYiYeDtp_VaIndybjg
                    @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnClickActionSheetListener
                    public final void onClickActionSheet(BluedActionSheet bluedActionSheet) {
                        FeedMethods.b(Context.this, bluedIngSelfFeed, iRequestHost, bluedActionSheet);
                    }
                });
            }
            if (z2 && bluedIngSelfFeed.is_bubble_ticktock != 1) {
                if (bluedIngSelfFeed.feed_views == 0) {
                    builder.a(ActionSheetDefaultItem.a().a(context.getString(R.string.sticky_feed)).b(R.drawable.common_icon_vip).b(new BluedActionSheet.OnClickActionSheetListener() { // from class: com.blued.community.ui.feed.manager.-$$Lambda$FeedMethods$fqA2hEL2D2_HtRNkLgs3TKFM0tY
                        @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnClickActionSheetListener
                        public final void onClickActionSheet(BluedActionSheet bluedActionSheet) {
                            FeedMethods.a(Context.this, bluedIngSelfFeed, iRequestHost);
                        }
                    }));
                } else {
                    builder.a(ActionSheetDefaultItem.a().a(context.getString(R.string.cancel_sticky_feed)).b(R.drawable.common_icon_vip).b(new BluedActionSheet.OnClickActionSheetListener() { // from class: com.blued.community.ui.feed.manager.-$$Lambda$FeedMethods$ubHNoFbDeAhpMYmY0M997cT0GR8
                        @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnClickActionSheetListener
                        public final void onClickActionSheet(BluedActionSheet bluedActionSheet) {
                            FeedMethods.a(BluedIngSelfFeed.this, iRequestHost);
                        }
                    }));
                }
            }
            if (bluedIngSelfFeed.is_bubble_ticktock != 1) {
                builder.a(ActionSheetDefaultItem.a().a(context.getString(R.string.dynamic_skin_setting)).b(R.drawable.common_icon_vip).b(new BluedActionSheet.OnClickActionSheetListener() { // from class: com.blued.community.ui.feed.manager.-$$Lambda$FeedMethods$ghvbDAcSdBDGijid6dWjl-xBlQY
                    @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnClickActionSheetListener
                    public final void onClickActionSheet(BluedActionSheet bluedActionSheet) {
                        FeedMethods.b(BluedIngSelfFeed.this, context, bluedActionSheet);
                    }
                }));
            }
            builder.a(context.getString(R.string.delete), new BluedActionSheet.OnClickActionSheetListener() { // from class: com.blued.community.ui.feed.manager.-$$Lambda$FeedMethods$MruS1-jkImdW7aGSAlXmZDdAc3U
                @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnClickActionSheetListener
                public final void onClickActionSheet(BluedActionSheet bluedActionSheet) {
                    FeedMethods.b(Context.this, bluedIngSelfFeed, feedListAdapterForRecyclerView, i2, iRequestHost);
                }
            });
        } else {
            if (bluedIngSelfFeed.hasDynamicSkin()) {
                builder.a(ActionSheetDefaultItem.a().a(context.getString(R.string.dynamic_skin_look)).b(R.drawable.common_icon_vip).b(new BluedActionSheet.OnClickActionSheetListener() { // from class: com.blued.community.ui.feed.manager.-$$Lambda$FeedMethods$t8GUM-HiobmPpvzjWE8talk-U1k
                    @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnClickActionSheetListener
                    public final void onClickActionSheet(BluedActionSheet bluedActionSheet) {
                        FeedMethods.a(BluedIngSelfFeed.this, context, bluedActionSheet);
                    }
                }));
            }
            if (z && !bluedIngSelfFeed.isMyFeed() && !TextUtils.isEmpty(bluedIngSelfFeed.activity_id) && !TextUtils.isEmpty(bluedIngSelfFeed.strong_insert_data) && bluedIngSelfFeed.is_subscribe == 0) {
                builder.a(ActionSheetDefaultItem.a().a(context.getString(R.string.event_sub_organizer)).a(R.color.syc_m).b(new BluedActionSheet.OnClickActionSheetListener() { // from class: com.blued.community.ui.feed.manager.-$$Lambda$FeedMethods$IKMi8ERZMoyje9O2b-Cb1DknMqA
                    @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnClickActionSheetListener
                    public final void onClickActionSheet(BluedActionSheet bluedActionSheet) {
                        FeedMethods.a(IRequestHost.this, bluedIngSelfFeed, feedListAdapterForRecyclerView, i2, bluedActionSheet);
                    }
                }));
            }
            if ((z || i == 26) && !bluedIngSelfFeed.isMyFeed() && !bluedIngSelfFeed.isAnonymous() && ((TextUtils.isEmpty(bluedIngSelfFeed.activity_id) || TextUtils.isEmpty(bluedIngSelfFeed.strong_insert_data)) && !"1".equalsIgnoreCase(bluedIngSelfFeed.relationship) && !"3".equalsIgnoreCase(bluedIngSelfFeed.relationship))) {
                builder.a(ActionSheetDefaultItem.a().a(context.getString(R.string.attention)).a(R.color.syc_m).b(new BluedActionSheet.OnClickActionSheetListener() { // from class: com.blued.community.ui.feed.manager.-$$Lambda$FeedMethods$aWiMaTkCFdBFIKepCrrkLreoVPo
                    @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnClickActionSheetListener
                    public final void onClickActionSheet(BluedActionSheet bluedActionSheet) {
                        FeedMethods.a(i, bluedIngSelfFeed, str, context, followStatusView, iRequestHost, bluedActionSheet);
                    }
                }));
            }
            if (bluedIngSelfFeed.is_activity == 1) {
                builder.a(context.getString(R.string.dont_like_this_event), new BluedActionSheet.OnClickActionSheetListener() { // from class: com.blued.community.ui.feed.manager.-$$Lambda$FeedMethods$KRUMiHr_A3S9TdObwahc5-t0A9w
                    @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnClickActionSheetListener
                    public final void onClickActionSheet(BluedActionSheet bluedActionSheet) {
                        FeedMethods.a(FeedListAdapterForRecyclerView.this, i2, bluedIngSelfFeed, bluedActionSheet);
                    }
                });
            }
            if (bluedIngSelfFeed.unliked_users_url != null && bluedIngSelfFeed.unliked_users_url.length > 0) {
                builder.a(context.getString(R.string.dont_like_this_person_feed), new BluedActionSheet.OnClickActionSheetListener() { // from class: com.blued.community.ui.feed.manager.-$$Lambda$FeedMethods$krzU1LNUleFAY7bKUYr7rNJ26Tw
                    @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnClickActionSheetListener
                    public final void onClickActionSheet(BluedActionSheet bluedActionSheet) {
                        FeedMethods.c(i, bluedIngSelfFeed, str, feedListAdapterForRecyclerView, i2, bluedActionSheet);
                    }
                });
            }
            if (bluedIngSelfFeed.unliked_url != null && bluedIngSelfFeed.unliked_url.length > 0 && i != 19 && bluedIngSelfFeed.is_activity != 1) {
                builder.a(context.getString(R.string.dont_like_this_post_feed), new BluedActionSheet.OnClickActionSheetListener() { // from class: com.blued.community.ui.feed.manager.-$$Lambda$FeedMethods$VXLAIPC9aBaZCgRv3gxyU7wQJqo
                    @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnClickActionSheetListener
                    public final void onClickActionSheet(BluedActionSheet bluedActionSheet) {
                        FeedMethods.b(i, bluedIngSelfFeed, str, feedListAdapterForRecyclerView, i2, bluedActionSheet);
                    }
                });
            }
            builder.a(context.getString(R.string.report), new BluedActionSheet.OnClickActionSheetListener() { // from class: com.blued.community.ui.feed.manager.-$$Lambda$FeedMethods$MwFSHu__HNnuJa0WkPsExHQFywE
                @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnClickActionSheetListener
                public final void onClickActionSheet(BluedActionSheet bluedActionSheet) {
                    FeedMethods.b(i, bluedIngSelfFeed, str, context, bluedActionSheet);
                }
            });
        }
        builder.d();
        return true;
    }

    public static boolean a(final Context context, final CircleJoinView circleJoinView, final TextView textView, final BluedIngSelfFeed bluedIngSelfFeed, final int i, final FeedListAdapterForRecyclerView feedListAdapterForRecyclerView, final int i2, final String str, final IRequestHost iRequestHost) {
        EventTrackFeed.a(FeedProtos.Event.NOTE_MORE_BTN_CLICK, bluedIngSelfFeed.circle_id, bluedIngSelfFeed.feed_id, EventTrackFeed.j(i), str);
        EventTrackFeed.a(FeedProtos.Event.FEED_NOTE_MORE_CLICK, EventTrackFeed.g(i), bluedIngSelfFeed.circle_id, bluedIngSelfFeed.feed_id, str);
        boolean z = i == 4 || i == 19;
        boolean z2 = i == 6;
        BluedActionSheet.Builder builder = new BluedActionSheet.Builder(context);
        if (z && bluedIngSelfFeed.isNotMember()) {
            builder.a(ActionSheetDefaultItem.a().a(bluedIngSelfFeed.allow_join == 1 ? context.getString(R.string.circle_join) : context.getString(R.string.circle_apply_join)).a(R.color.syc_m).b(new BluedActionSheet.OnClickActionSheetListener() { // from class: com.blued.community.ui.feed.manager.-$$Lambda$FeedMethods$vuvRCYpDCu4wtrbKrny2OFwf9c8
                @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnClickActionSheetListener
                public final void onClickActionSheet(BluedActionSheet bluedActionSheet) {
                    FeedMethods.a(Context.this, bluedIngSelfFeed, i, circleJoinView, textView, "", iRequestHost);
                }
            }));
        }
        if (z2 || z) {
            builder.a(context.getString(R.string.circle_dislike_post), new BluedActionSheet.OnClickActionSheetListener() { // from class: com.blued.community.ui.feed.manager.-$$Lambda$FeedMethods$022Ef9s0UXDb3NBFwq25Tirv7uQ
                @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnClickActionSheetListener
                public final void onClickActionSheet(BluedActionSheet bluedActionSheet) {
                    FeedMethods.a(i, bluedIngSelfFeed, str, feedListAdapterForRecyclerView, i2, bluedActionSheet);
                }
            });
        }
        builder.a(context.getString(R.string.report), new BluedActionSheet.OnClickActionSheetListener() { // from class: com.blued.community.ui.feed.manager.-$$Lambda$FeedMethods$dKHI5j3qSJtdK2eXRQHGC_XlATc
            @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnClickActionSheetListener
            public final void onClickActionSheet(BluedActionSheet bluedActionSheet) {
                FeedMethods.a(i, bluedIngSelfFeed, str, context, bluedActionSheet);
            }
        });
        builder.d();
        return true;
    }

    public static boolean a(TextView textView, String str, boolean z) {
        if (z && TextUtils.equals(str, UserInfoUtils.c())) {
            textView.setText(R.string.feed_anonymous_self);
            return true;
        }
        return false;
    }

    public static boolean a(BluedIngSelfFeed bluedIngSelfFeed) {
        String[] r;
        if (bluedIngSelfFeed == null || (r = CommunityServiceManager.a().r()) == null || r.length < 4) {
            return false;
        }
        return TextUtils.equals(r[1], bluedIngSelfFeed.feed_uid) && TextUtils.equals(r[3], bluedIngSelfFeed.feed_id);
    }

    public static boolean a(BluedTopic bluedTopic, List<BluedTopic> list) {
        if (bluedTopic == null || list == null) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return false;
            }
            BluedTopic bluedTopic2 = list.get(i2);
            if (com.blued.android.framework.utils.StringUtils.a(bluedTopic.super_did, bluedTopic2.super_did) || com.blued.android.framework.utils.StringUtils.a(bluedTopic.name, bluedTopic2.name)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static int[] a() {
        return new int[]{0, 1, 2};
    }

    public static int[] a(Context context, int i, int i2, boolean z) {
        int a2;
        int i3;
        int a3 = DensityUtils.a(context, 20.0f);
        int a4 = DensityUtils.a(context, 4.0f);
        int a5 = z ? DensityUtils.a(context, 20.0f) : 0;
        if (i == i2) {
            a2 = (((((AppInfo.l - a3) - (a4 * 2)) * 2) / 3) + a4) - a5;
            i3 = a2;
        } else if (i < i2) {
            a2 = (((((AppInfo.l - a3) - (a4 * 2)) * 2) / 3) + a4) - a5;
            i3 = (a2 * 3) / 2;
        } else {
            a2 = (AppInfo.l - DensityUtils.a(context, 20.0f)) - a5;
            i3 = (a2 * 2) / 3;
        }
        return new int[]{a2, i3};
    }

    public static int b(int i) {
        int i2;
        if (i == 0) {
            i2 = 2;
        } else if (i == 1) {
            return 3;
        } else {
            if (i == 4) {
                return 0;
            }
            i2 = 4;
            if (i != 5) {
                if (i == 6) {
                    return 1;
                }
                if (i == 19) {
                    return 0;
                }
                i2 = 4;
                if (i != 29) {
                    i2 = 4;
                    if (i != 30) {
                        return 0;
                    }
                }
            }
        }
        return i2;
    }

    public static UserBasicModel b(BluedIngSelfFeed bluedIngSelfFeed) {
        UserBasicModel userBasicModel = new UserBasicModel();
        if (bluedIngSelfFeed == null) {
            return userBasicModel;
        }
        userBasicModel.uid = bluedIngSelfFeed.feed_uid;
        userBasicModel.avatar = bluedIngSelfFeed.user_avatar;
        userBasicModel.name = bluedIngSelfFeed.user_name;
        userBasicModel.age = bluedIngSelfFeed.age + "";
        userBasicModel.height = bluedIngSelfFeed.height + "";
        userBasicModel.weight = bluedIngSelfFeed.weight + "";
        userBasicModel.role = bluedIngSelfFeed.role + "";
        userBasicModel.distance = bluedIngSelfFeed.distance;
        userBasicModel.vip_grade = bluedIngSelfFeed.vip_grade;
        userBasicModel.vbadge = bluedIngSelfFeed.vbadge;
        userBasicModel.is_hide_distance = bluedIngSelfFeed.is_hide_distance;
        userBasicModel.is_hide_last_operate = bluedIngSelfFeed.is_hide_last_operate;
        userBasicModel.is_show_vip_page = bluedIngSelfFeed.is_show_vip_page;
        userBasicModel.is_vip_annual = bluedIngSelfFeed.is_vip_annual;
        userBasicModel.vip_exp_lvl = bluedIngSelfFeed.vip_exp_lvl;
        if (TextUtils.isEmpty(userBasicModel.uid)) {
            userBasicModel.uid = bluedIngSelfFeed.uid;
        }
        return userBasicModel;
    }

    public static FeedParse b(BluedIngSelfFeed bluedIngSelfFeed, int i) {
        if (bluedIngSelfFeed.feedParse == null) {
            bluedIngSelfFeed.feedParse = new FeedParse(AppInfo.d(), bluedIngSelfFeed, i, "");
        }
        return bluedIngSelfFeed.feedParse;
    }

    public static BluedTopic b(ArrayList<BluedTopic> arrayList, String str) {
        BluedTopic bluedTopic;
        if (TypeUtils.a((List<?>) arrayList)) {
            return null;
        }
        String r = CommunityPreferences.r(str);
        LogUtils.c(str + "--> getFeedGuideNextTopicPids: " + r);
        String str2 = r;
        if (r == null) {
            str2 = "";
        }
        Iterator<BluedTopic> it = arrayList.iterator();
        while (true) {
            bluedTopic = null;
            if (!it.hasNext()) {
                break;
            }
            bluedTopic = it.next();
            if (bluedTopic != null && !TextUtils.isEmpty(bluedTopic.super_did) && !str2.contains(bluedTopic.super_did)) {
                LogUtils.c(str + "--> setUsedTopicModel: " + bluedTopic.name);
                CommunityPreferences.b(str, str2 + bluedTopic.super_did + ",");
                break;
            }
        }
        return bluedTopic;
    }

    public static MessageProtos.StrangerSource b(int i, int i2) {
        MessageProtos.StrangerSource strangerSource = MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
        if (i != 2) {
            if (i == 10) {
                return MessageProtos.StrangerSource.FIND_PLAZA_IMAGE;
            }
            if (i != 14) {
                return i != 19 ? i != 4 ? i != 5 ? i != 6 ? i != 29 ? i != 30 ? strangerSource : MessageProtos.StrangerSource.TOPIC_NEW : MessageProtos.StrangerSource.TOPIC_RECOMMEND : i2 == 1 ? MessageProtos.StrangerSource.APPRECIATE_FIND : MessageProtos.StrangerSource.FEED_FIND_PLAZA : MessageProtos.StrangerSource.SUPER_TOPIC_DETAIL : i2 == 1 ? MessageProtos.StrangerSource.APPRECIATE_NEARBY : MessageProtos.StrangerSource.FIND_PLAZA_NEARBY : i2 == 1 ? MessageProtos.StrangerSource.APPRECIATE_NEARBY : MessageProtos.StrangerSource.CITY_TIME;
            }
        }
        return MessageProtos.StrangerSource.PAGE_FEED_DETAIL_MORE;
    }

    public static CharSequence b(Context context, int i, FeedComment feedComment, int i2, int i3) {
        String str;
        if (TextUtils.isEmpty(feedComment.comment_id)) {
            return "";
        }
        String str2 = feedComment.note;
        String replace = feedComment.user_name != null ? feedComment.user_name.replace(":", "") : "";
        String replace2 = feedComment.reply_name != null ? feedComment.reply_name.replace(":", "") : "";
        String str3 = feedComment.comment_content;
        String str4 = feedComment.comment_uid;
        String str5 = feedComment.reply_uid;
        String str6 = feedComment.user_avatar;
        String str7 = feedComment.reply_avatar;
        String str8 = " " + context.getResources().getString(R.string.reply) + " ";
        if (TextUtils.isEmpty(str2)) {
            str = replace + str8 + replace2 + ": " + str3;
        } else {
            str = StringUtils.a(str2, replace) + str8 + replace2 + ": " + str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new UserNameClickSpan(context, spannableStringBuilder.toString().substring(0, spannableStringBuilder.toString().indexOf(str8)), str4, replace, str6, a(i2, 0), i3), 0, spannableStringBuilder.toString().indexOf(str8), 17);
        try {
            int indexOf = spannableStringBuilder.toString().indexOf(str8) + str8.length();
            int i4 = indexOf;
            if (indexOf >= spannableStringBuilder.toString().length()) {
                i4 = spannableStringBuilder.toString().length() - 1;
            }
            spannableStringBuilder.setSpan(new UserNameClickSpan(context, spannableStringBuilder.toString().substring(i4, spannableStringBuilder.toString().indexOf(":")), str5, replace2, str7, a(i2, 0), i3), spannableStringBuilder.toString().indexOf(str8) + str8.length(), spannableStringBuilder.toString().indexOf(":") + 1, 17);
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        sb.append((Object) spannableStringBuilder);
        sb.append("");
        return TextUtils.isEmpty(sb.toString()) ? "" : StringUtils.a(StringUtils.a(StringUtils.a(spannableStringBuilder, i, 1), true, true, false, null, true, "", a(i2, 0)), true, new boolean[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(int i, BluedIngSelfFeed bluedIngSelfFeed, String str, Context context, BluedActionSheet bluedActionSheet) {
        EventTrackFeed.a(EventTrackFeed.f(i), bluedIngSelfFeed.circle_id, bluedIngSelfFeed.feed_id, "report", bluedIngSelfFeed.feed_uid, str);
        CommunityServiceManager.b().a(context, CommunityConstants.ReportType.FEED, bluedIngSelfFeed.user_name, bluedIngSelfFeed.feed_id, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(int i, BluedIngSelfFeed bluedIngSelfFeed, String str, FeedListAdapterForRecyclerView feedListAdapterForRecyclerView, int i2, BluedActionSheet bluedActionSheet) {
        EventTrackFeed.a(EventTrackFeed.f(i), bluedIngSelfFeed.circle_id, bluedIngSelfFeed.feed_id, IAdInterListener.AdProdType.PRODUCT_FEEDS, bluedIngSelfFeed.feed_uid, str);
        if (bluedIngSelfFeed.is_unliked_url_visited) {
            return;
        }
        if (bluedIngSelfFeed.unliked_url != null && bluedIngSelfFeed.unliked_url.length > 0) {
            CommunityHttpUtils.a(bluedIngSelfFeed.unliked_url);
        }
        bluedIngSelfFeed.is_unliked_url_visited = true;
        feedListAdapterForRecyclerView.remove(i2);
        LiveEventBus.get("feed_delete").post(bluedIngSelfFeed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(Context context, BluedIngSelfFeed bluedIngSelfFeed, IRequestHost iRequestHost, BluedActionSheet bluedActionSheet) {
        b((FragmentActivity) context, bluedIngSelfFeed, iRequestHost);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final Context context, final BluedIngSelfFeed bluedIngSelfFeed, final FeedListAdapterForRecyclerView feedListAdapterForRecyclerView, final int i, final IRequestHost iRequestHost) {
        CommonAlertDialog.a(context, context.getResources().getString(R.string.community_notice), context.getResources().getString(R.string.feed_confirm_delete_hint), context.getResources().getString(R.string.feed_confirm_delete), new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.feed.manager.FeedMethods.20
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Tracker.onClick(dialogInterface, i2);
                FeedMethods.c(Context.this, bluedIngSelfFeed, feedListAdapterForRecyclerView, i, iRequestHost);
            }
        }, context.getResources().getString(R.string.feed_wait_edit), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    public static void b(final FragmentActivity fragmentActivity, final BluedIngSelfFeed bluedIngSelfFeed, final IRequestHost iRequestHost) {
        int i;
        String[] stringArray = fragmentActivity.getResources().getStringArray(R.array.feed_comment_authlist);
        final String[] stringArray2 = fragmentActivity.getResources().getStringArray(R.array.feed_comment_authlist_key);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            i = 0;
            if (i3 >= stringArray2.length) {
                break;
            }
            if (stringArray2[i3].equals(bluedIngSelfFeed.allow_comments + "")) {
                i = i3;
                break;
            }
            i2 = i3 + 1;
        }
        CommonShowBottomWindow.a(fragmentActivity, stringArray, i, new ActionSheet.ActionSheetListener() { // from class: com.blued.community.ui.feed.manager.FeedMethods.15
            @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
            public void a(ActionSheet actionSheet, int i4) {
                final int a2 = CommonStringUtils.a(stringArray2[i4]);
                EventTrackFeed.c(FeedProtos.Event.FEED_SETTING_COMMENT_CLICK, bluedIngSelfFeed.feed_id, a2);
                final Dialog a3 = DialogUtils.a(fragmentActivity);
                FeedHttpUtils.a(bluedIngSelfFeed.feed_id, a2, new BluedUIHttpResponse<BluedEntity>() { // from class: com.blued.community.ui.feed.manager.FeedMethods.15.1
                    @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                    public void onFailure(Throwable th, int i5, String str) {
                        super.onFailure(th, i5, str);
                        AppMethods.a((CharSequence) fragmentActivity.getResources().getString(R.string.operate_failed));
                    }

                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    public void onUIFinish() {
                        super.onUIFinish();
                        DialogUtils.b(a3);
                    }

                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    public void onUIStart() {
                        super.onUIStart();
                        DialogUtils.a(a3);
                    }

                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    public void onUIUpdate(BluedEntity bluedEntity) {
                        AppMethods.a((CharSequence) fragmentActivity.getResources().getString(R.string.community_done));
                        bluedIngSelfFeed.allow_comments = a2;
                        LiveEventBus.get("feed_comment_setting").post(bluedIngSelfFeed);
                    }
                }, iRequestHost);
            }

            @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
            public void a(ActionSheet actionSheet, boolean z) {
            }
        });
        EventTrackFeed.b(FeedProtos.Event.FEED_SETTING_COMMENT_SHOW, bluedIngSelfFeed.feed_id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(BluedIngSelfFeed bluedIngSelfFeed, Context context, BluedActionSheet bluedActionSheet) {
        EventTrackFeed.b(FeedProtos.Event.FEED_SETTING_DYNAMIC_SKIN_SETTINGS_BTN_CLICK, bluedIngSelfFeed.feed_id);
        CommunityServiceManager.b().a(context, 0, "feed_dynamic_skin_setting_main");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final CircleJoinView circleJoinView, final TextView textView, final boolean z, final boolean z2) {
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.community.ui.feed.manager.FeedMethods.24
            @Override // java.lang.Runnable
            public void run() {
                TextView textView2;
                CircleJoinView circleJoinView2 = CircleJoinView.this;
                if (circleJoinView2 != null) {
                    circleJoinView2.setVisibility(8);
                }
                if ((z || z2) && (textView2 = textView) != null) {
                    textView2.setText(R.string.circle_joined_recommend);
                }
            }
        }, 1000L);
    }

    public static boolean b() {
        for (NewFeedModel newFeedModel : NewFeedDao.a().c()) {
            if (TextUtils.isEmpty(newFeedModel.circle_id) && newFeedModel.is_draft == 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(Context context) {
        NewFeedModel newFeedModel = null;
        for (NewFeedModel newFeedModel2 : NewFeedDao.a().c()) {
            if (TextUtils.isEmpty(newFeedModel2.circle_id) && newFeedModel2.is_draft == 1) {
                newFeedModel = newFeedModel2;
            }
        }
        if (newFeedModel != null) {
            if (newFeedModel.is_evaluate_activity == 1) {
                EventScoreAddPostFragment.b.a(context, newFeedModel);
                return true;
            }
            FeedAddPostFragment.a(context, newFeedModel);
            return true;
        }
        return false;
    }

    public static int[] b(Context context, int i, int i2, boolean z) {
        int i3 = i;
        if (i == 0) {
            i3 = 480;
        }
        int i4 = i2;
        if (i2 == 0) {
            i4 = 480;
        }
        int[] iArr = new int[2];
        iArr[0] = Math.min(c(232), i3);
        if (i3 == i4) {
            iArr[1] = iArr[0];
            return iArr;
        }
        float f = i4 / i3;
        float f2 = f;
        if (f < 0.667f) {
            f2 = 0.667f;
        }
        float f3 = f2;
        if (f2 > 1.5f) {
            f3 = 1.5f;
        }
        iArr[1] = (int) (iArr[0] * f3);
        return iArr;
    }

    public static int c(int i) {
        return DisplayUtil.a(AppInfo.d(), i);
    }

    public static CharSequence c(Context context, int i, FeedComment feedComment, int i2, int i3) {
        String str;
        if (TextUtils.isEmpty(feedComment.comment_id)) {
            return "";
        }
        String str2 = feedComment.note;
        String replace = feedComment.user_name != null ? feedComment.user_name.replace(":", "") : "";
        String str3 = feedComment.comment_content;
        String str4 = feedComment.comment_uid;
        String str5 = feedComment.user_avatar;
        if (TextUtils.isEmpty(str2)) {
            str = replace + ": " + str3;
        } else {
            str = StringUtils.a(str2, replace) + ": " + str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new UserNameClickSpan(context, spannableStringBuilder.toString().substring(0, spannableStringBuilder.toString().indexOf(":") + 1), str4, replace, str5, a(i2, 0), i3), 0, spannableStringBuilder.toString().indexOf(":") + 1, 17);
        StringBuilder sb = new StringBuilder();
        sb.append((Object) spannableStringBuilder);
        sb.append("");
        return TextUtils.isEmpty(sb.toString()) ? "" : StringUtils.a(StringUtils.a(StringUtils.a(spannableStringBuilder, i, 1), true, true, false, null, true, "", a(i2, 0)), true, new boolean[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(int i, BluedIngSelfFeed bluedIngSelfFeed, String str, FeedListAdapterForRecyclerView feedListAdapterForRecyclerView, int i2, BluedActionSheet bluedActionSheet) {
        EventTrackFeed.a(EventTrackFeed.f(i), bluedIngSelfFeed.circle_id, bluedIngSelfFeed.feed_id, "user", bluedIngSelfFeed.feed_uid, str);
        if (bluedIngSelfFeed.isIs_unliked_users_url_visited) {
            return;
        }
        if (bluedIngSelfFeed.unliked_users_url != null && bluedIngSelfFeed.unliked_users_url.length > 0) {
            CommunityHttpUtils.a(bluedIngSelfFeed.unliked_users_url);
        }
        bluedIngSelfFeed.isIs_unliked_users_url_visited = true;
        feedListAdapterForRecyclerView.remove(i2);
        LiveEventBus.get("feed_delete").post(bluedIngSelfFeed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(Context context, BluedIngSelfFeed bluedIngSelfFeed, IRequestHost iRequestHost, BluedActionSheet bluedActionSheet) {
        a((FragmentActivity) context, bluedIngSelfFeed, iRequestHost);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, final BluedIngSelfFeed bluedIngSelfFeed, final FeedListAdapterForRecyclerView feedListAdapterForRecyclerView, final int i, IRequestHost iRequestHost) {
        final Dialog a2 = DialogUtils.a(context);
        FeedHttpUtils.a(context, new BluedUIHttpResponse<BluedEntity>() { // from class: com.blued.community.ui.feed.manager.FeedMethods.21
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(a2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(a2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                FeedListAdapterForRecyclerView.this.remove(i);
                if (bluedIngSelfFeed.repost != null) {
                    LiveEventBus.get("feed_delete_repost").post(bluedIngSelfFeed.repost.feed_id);
                }
                AppMethods.d(R.string.del_success);
            }
        }, bluedIngSelfFeed.feed_id, iRequestHost);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(BluedIngSelfFeed bluedIngSelfFeed, Context context, BluedActionSheet bluedActionSheet) {
        CommunityServiceManager.d().a(PersonalProfileProtos.Event.PERSONAL_PROFILE_FEED_MORE_EXPOSE_CLICK, bluedIngSelfFeed.feed_id);
        CommunityServiceManager.b().d(context, bluedIngSelfFeed.feed_id);
    }

    public static boolean c() {
        for (NewFeedModel newFeedModel : NewFeedDao.a().c()) {
            if (TextUtils.isEmpty(newFeedModel.circle_id) && newFeedModel.is_draft == 1) {
                NewFeedDao.a().a(newFeedModel.getId());
                return true;
            }
        }
        return false;
    }

    public static String d(int i) {
        String[] stringArray = AppInfo.d().getResources().getStringArray(R.array.feed_interact_str);
        int i2 = i - 1;
        return (i2 < 0 || i2 >= stringArray.length) ? "很赞" : stringArray[i2];
    }

    public static void d() {
        if (CommunityPreferences.g() && CommunityServiceManager.a().w()) {
            CommunityPreferences.h();
            AppMethods.d(R.string.feed_like_comment_tip);
        }
    }

    public static String e() {
        return "feed_like_anim_794.png";
    }

    public static String e(int i) {
        return i == 2 ? "feed_interact_1.png" : i == 3 ? "feed_interact_2.png" : i == 4 ? "feed_interact_3.png" : i == 5 ? "feed_interact_4.png" : "feed_interact_0.png";
    }

    public static int f(int i) {
        return i == 2 ? R.drawable.feed_interact_static_1 : i == 3 ? R.drawable.feed_interact_static_2 : i == 4 ? R.drawable.feed_interact_static_3 : i == 5 ? R.drawable.feed_interact_static_4 : R.drawable.feed_interact_static_0;
    }

    public static String f() {
        return "feed_like_big_anim_708.png";
    }

    public static String g() {
        List<String> t = CommunityServiceManager.a().t();
        if (t == null) {
            return null;
        }
        if (t.size() == 1) {
            return t.get(0);
        }
        if (t.size() <= 0) {
            return null;
        }
        int nextInt = new Random().nextInt(t.size());
        while (true) {
            int i = nextInt;
            if (f19823a != i) {
                f19823a = i;
                return t.get(i);
            }
            nextInt = new Random().nextInt(t.size());
        }
    }

    public static String h() {
        String u = CommunityServiceManager.a().u();
        if (TextUtils.isEmpty(u)) {
            return null;
        }
        return u;
    }

    public static ArrayMap<String, String> i() {
        String[] stringArray = AppInfo.d().getResources().getStringArray(R.array.register_time_key);
        String[] stringArray2 = AppInfo.d().getResources().getStringArray(R.array.register_time);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= stringArray.length) {
                return b;
            }
            b.put(stringArray[i2], stringArray2[i2]);
            i = i2 + 1;
        }
    }

    public static LogData j() {
        return new LogData();
    }
}

package com.blued.community.model;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.utils.AtUserHelper;
import com.blued.community.utils.MarkDownLinkHelper;
import com.blued.community.utils.StringUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/model/FeedParse.class */
public class FeedParse implements Serializable {
    private static int COMMENT_TEXT_SIZE;
    private static int CONTENT_TEXT_SIZE;
    private List<CharSequence> commentList;
    private String distance;
    private String feedComment;
    private CharSequence feedContent;
    private String feedDig;
    private String feedFeedShow;
    private int feedFrom;
    private CharSequence feedRepostContent;
    private String feedTimestamp;
    private CharSequence guessFeedContent;
    private int oldComment;
    private int oldDig;
    private long oldFeedShow;
    private String topicName;

    public FeedParse(Context context, BluedIngSelfFeed bluedIngSelfFeed, int i) {
        this(context, bluedIngSelfFeed, i, "");
    }

    public FeedParse(Context context, BluedIngSelfFeed bluedIngSelfFeed, int i, String str) {
        String str2;
        this.feedFrom = i;
        this.topicName = str;
        COMMENT_TEXT_SIZE = DensityUtils.a(context, 14.0f);
        CONTENT_TEXT_SIZE = DensityUtils.a(context, 14.0f);
        if (TextUtils.isEmpty(bluedIngSelfFeed.feed_timestamp)) {
            this.feedTimestamp = "";
        } else if (i == 6 || i == 18 || i == 14 || i == 10 || i == 4 || i == 19) {
            this.feedTimestamp = TimeAndDateUtils.b(context, TimeAndDateUtils.c(bluedIngSelfFeed.feed_timestamp));
        } else {
            this.feedTimestamp = TimeAndDateUtils.c(context, TimeAndDateUtils.c(bluedIngSelfFeed.feed_timestamp));
        }
        if (TextUtils.isEmpty(bluedIngSelfFeed.distance)) {
            this.distance = "";
        } else {
            this.distance = DistanceUtils.a(bluedIngSelfFeed.distance, BlueAppLocal.c(), false);
        }
        if (bluedIngSelfFeed.isRepost()) {
            this.feedRepostContent = parseContent(context, bluedIngSelfFeed.feed_content, i);
            String str3 = bluedIngSelfFeed.repost.feed_content;
            if (bluedIngSelfFeed.repost.feed_is_delete == 1) {
                str2 = !TextUtils.isEmpty(bluedIngSelfFeed.repost.feed_limit_desc) ? bluedIngSelfFeed.repost.feed_limit_desc : context.getResources().getString(R.string.feed_deleted);
            } else if (bluedIngSelfFeed.repost.is_feed_anonym == 1) {
                str2 = bluedIngSelfFeed.repost.user_name + "：" + str3;
            } else {
                str2 = StringUtils.b(bluedIngSelfFeed.repost.user_name, bluedIngSelfFeed.repost.feed_uid) + "：" + str3;
            }
            this.feedContent = parseContent(context, str2, i);
        } else if (!TextUtils.isEmpty(bluedIngSelfFeed.feed_content)) {
            this.feedContent = parseContent(context, bluedIngSelfFeed.feed_content, i);
        }
        this.oldDig = bluedIngSelfFeed.feed_dig;
        this.feedDig = parseDig(context, bluedIngSelfFeed.feed_dig);
        this.oldComment = bluedIngSelfFeed.feed_comment;
        this.feedComment = parseComment(context, bluedIngSelfFeed.feed_comment);
        this.commentList = new ArrayList();
        if (bluedIngSelfFeed.comments != null && bluedIngSelfFeed.comments.size() > 0) {
            if ("1".equals(bluedIngSelfFeed.comments.get(0).is_reply)) {
                this.commentList.add(FeedMethods.b(context, COMMENT_TEXT_SIZE, bluedIngSelfFeed.comments.get(0), i, R.color.syc_h));
            } else {
                this.commentList.add(FeedMethods.c(context, COMMENT_TEXT_SIZE, bluedIngSelfFeed.comments.get(0), i, R.color.syc_h));
            }
            if (bluedIngSelfFeed.comments.size() >= 2) {
                if ("1".equals(bluedIngSelfFeed.comments.get(1).is_reply)) {
                    this.commentList.add(FeedMethods.b(context, COMMENT_TEXT_SIZE, bluedIngSelfFeed.comments.get(1), i, R.color.syc_h));
                } else {
                    this.commentList.add(FeedMethods.c(context, COMMENT_TEXT_SIZE, bluedIngSelfFeed.comments.get(1), i, R.color.syc_h));
                }
            }
        }
        this.oldFeedShow = bluedIngSelfFeed.feed_show;
        this.feedFeedShow = parseFeedShow(context, bluedIngSelfFeed.feed_show);
    }

    private String parseComment(Context context, int i) {
        return i > 0 ? DistanceUtils.a(context, Integer.toString(i)) : context.getString(R.string.comment);
    }

    public static CharSequence parseContent(final Context context, String str, final int i) {
        return StringUtils.a(AtUserHelper.a(MarkDownLinkHelper.a(context, StringUtils.a(str, CONTENT_TEXT_SIZE, 0), true, R.color.syc_m, true, (MarkDownLinkHelper.MDLinkOnClickListener) null), BluedSkinUtils.a(context, R.color.syc_m), new AtUserHelper.AtUserLinkOnClickListener() { // from class: com.blued.community.model.FeedParse.1
            public void onClick(String str2, String str3) {
                if (!TextUtils.isEmpty(str2)) {
                    CommunityServiceManager.b().a(context, str2, FeedMethods.a(i, 0));
                } else if (TextUtils.isEmpty(str3)) {
                } else {
                    CommunityServiceManager.b().b(context, str3, FeedMethods.a(i, 0));
                }
            }
        }), true, new boolean[0]);
    }

    private String parseDig(Context context, int i) {
        return i > 0 ? DistanceUtils.a(context, Integer.toString(i)) : context.getString(R.string.zan);
    }

    private String parseFeedShow(Context context, long j) {
        return DistanceUtils.a(context, String.valueOf(j));
    }

    public List<CharSequence> getCommentList() {
        return this.commentList;
    }

    public String getDistance() {
        return this.distance;
    }

    public String getFeedComment(Context context, int i) {
        if (i != this.oldComment || this.feedComment == null) {
            this.oldComment = i;
            this.feedComment = parseComment(context, i);
        }
        return this.feedComment;
    }

    public CharSequence getFeedContent() {
        return this.feedContent;
    }

    public String getFeedDig(Context context, int i) {
        if (i != this.oldDig || this.feedDig == null) {
            this.oldDig = i;
            this.feedDig = parseDig(context, i);
        }
        return this.feedDig;
    }

    public String getFeedFeedShow(Context context, long j) {
        if (j != this.oldFeedShow || this.feedFeedShow == null) {
            this.oldFeedShow = j;
            this.feedFeedShow = parseFeedShow(context, j);
        }
        return this.feedFeedShow;
    }

    public CharSequence getFeedRepostContent() {
        return this.feedRepostContent;
    }

    public String getFeedTimestamp() {
        return this.feedTimestamp;
    }
}

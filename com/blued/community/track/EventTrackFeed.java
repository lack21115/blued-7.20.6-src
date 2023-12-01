package com.blued.community.track;

import android.text.TextUtils;
import com.anythink.expressad.d.a.b;
import com.app.share.model.ShareEntity;
import com.blued.android.module.common.db.model.NewFeedModel;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.community.manager.CommunityManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedNotice;
import com.blued.community.ui.circle.manager.CircleConstants;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.blued.community.ui.comment.model.FeedComment;
import com.blued.community.ui.event.model.EventLogData;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.community.utils.MarkDownLinkHelper;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.guy.GuyProtos;
import com.blued.das.profile.PersonalProfileProtos;
import com.blued.track.bytedance.ByteDanceLogUtils;
import com.blued.track.trackUtils.EventTrackUtils;
import com.soft.blued.ui.find.model.UserFindResult;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/track/EventTrackFeed.class */
public class EventTrackFeed {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.community.track.EventTrackFeed$1  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/track/EventTrackFeed$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f19112a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00dd -> B:109:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00e1 -> B:103:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00e5 -> B:81:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00e9 -> B:77:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00ed -> B:89:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00f1 -> B:85:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00f5 -> B:99:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x00f9 -> B:93:0x0064). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00fd -> B:107:0x0070). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0101 -> B:101:0x007c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x0105 -> B:79:0x0088). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0109 -> B:75:0x0094). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x010d -> B:87:0x00a0). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0111 -> B:83:0x00ac). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x0115 -> B:97:0x00b8). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x0119 -> B:91:0x00c4). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x011d -> B:105:0x00d0). Please submit an issue!!! */
        static {
            int[] iArr = new int[CircleConstants.CIRCLE_FROM_PAGE.values().length];
            f19112a = iArr;
            try {
                iArr[CircleConstants.CIRCLE_FROM_PAGE.CIRCLE_NOTIFY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f19112a[CircleConstants.CIRCLE_FROM_PAGE.FEED_LIST_ADAPTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f19112a[CircleConstants.CIRCLE_FROM_PAGE.LINK.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f19112a[CircleConstants.CIRCLE_FROM_PAGE.RECOMMEND_CIRCLE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f19112a[CircleConstants.CIRCLE_FROM_PAGE.EXPLORE_MORE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f19112a[CircleConstants.CIRCLE_FROM_PAGE.FIND_CIRCLE_MINE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f19112a[CircleConstants.CIRCLE_FROM_PAGE.JOINED_CIRCLE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f19112a[CircleConstants.CIRCLE_FROM_PAGE.FIND_CIRCLE_DISCUSS_LIST.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f19112a[CircleConstants.CIRCLE_FROM_PAGE.CIRCLE_POST_DETAILS.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f19112a[CircleConstants.CIRCLE_FROM_PAGE.HOME_RECOMMEND_CIRCLE.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f19112a[CircleConstants.CIRCLE_FROM_PAGE.CITY_JOIN_CIRCLE_FEED.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f19112a[CircleConstants.CIRCLE_FROM_PAGE.RECOMMEND_JOIN_CIRCLE_FEED.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f19112a[CircleConstants.CIRCLE_FROM_PAGE.USER_INFO_JOIN_CIRCLE_FEED.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f19112a[CircleConstants.CIRCLE_FROM_PAGE.FEED_DETAIL_JOIN_CIRCLE_FEED.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f19112a[CircleConstants.CIRCLE_FROM_PAGE.CIRCLE_MORE_LIST.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f19112a[CircleConstants.CIRCLE_FROM_PAGE.NOTE_TOP_JOIN.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                f19112a[CircleConstants.CIRCLE_FROM_PAGE.NOTE_FIXED_JOIN.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                f19112a[CircleConstants.CIRCLE_FROM_PAGE.NOTE_DOWN_JOIN.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
        }
    }

    public static int a(int i, int i2) {
        return i2 + 1;
    }

    public static FeedProtos.CircleSource a(CircleConstants.CIRCLE_FROM_PAGE circle_from_page) {
        FeedProtos.CircleSource circleSource = FeedProtos.CircleSource.UNKNOWN_CIRCLE_SOURCE;
        if (circle_from_page == null) {
            return circleSource;
        }
        int i = AnonymousClass1.f19112a[circle_from_page.ordinal()];
        if (i != 1) {
            switch (i) {
                case 4:
                    return FeedProtos.CircleSource.PLAZA_RECOMMEND_CIRCLE;
                case 5:
                    return FeedProtos.CircleSource.FIND_CIRCLE_LIST;
                case 6:
                    return FeedProtos.CircleSource.FIND_CIRCLE_MINE;
                case 7:
                    return FeedProtos.CircleSource.FIND_CIRCLE_MINE_ALL;
                case 8:
                    return FeedProtos.CircleSource.FIND_CIRCLE_DISCUSS_LIST;
                case 9:
                    return FeedProtos.CircleSource.CIRCLE_NOTE_DETAIL_NAME;
                case 10:
                    return FeedProtos.CircleSource.FIND_CIRCLE_RECOMMEND;
                case 11:
                    return FeedProtos.CircleSource.CITY_FEED_ENTER;
                case 12:
                    return FeedProtos.CircleSource.RECOMMEND_FEED_ENTER;
                case 13:
                    return FeedProtos.CircleSource.PERSONAL_PROFILE_CIRCLE;
                case 14:
                    return FeedProtos.CircleSource.DETAIL_FEED_ENTER;
                case 15:
                    return FeedProtos.CircleSource.CIRCLE_MORE_LIST;
                case 16:
                    return FeedProtos.CircleSource.NOTE_TOP_JOIN;
                case 17:
                    return FeedProtos.CircleSource.NOTE_FIXED_JOIN;
                case 18:
                    return FeedProtos.CircleSource.NOTE_DOWN_JOIN;
                default:
                    return circleSource;
            }
        }
        return FeedProtos.CircleSource.CIRCLE_APPLY_AGREE_MSG;
    }

    public static FeedProtos.CircleSource a(CircleConstants.CIRCLE_FROM_PAGE circle_from_page, int i, int i2, int i3) {
        FeedProtos.CircleSource circleSource = FeedProtos.CircleSource.UNKNOWN_CIRCLE_SOURCE;
        if (circle_from_page == null) {
            return circleSource;
        }
        int i4 = AnonymousClass1.f19112a[circle_from_page.ordinal()];
        if (i4 != 1) {
            return i4 != 2 ? i4 != 3 ? a(circle_from_page) : m(i3) : k(i2);
        }
        return i != 1 ? i != 2 ? (i == 3 || i == 4) ? FeedProtos.CircleSource.MANAGE_VICE_CAPTAIN_MSG : circleSource : FeedProtos.CircleSource.CIRCLE_INVITE_MSG : FeedProtos.CircleSource.CIRCLE_APPLY_AGREE_MSG;
    }

    public static FeedProtos.FeedClass a(FeedComment feedComment) {
        return feedComment == null ? FeedProtos.FeedClass.FEED_WORD : (feedComment.comment_pics == null || feedComment.comment_pics.length == 0) ? FeedProtos.FeedClass.FEED_WORD : FeedProtos.FeedClass.FEED_IMAGE;
    }

    public static FeedProtos.FeedFrom a(int i) {
        FeedProtos.FeedFrom feedFrom = FeedProtos.FeedFrom.UNKNOWN_FEED_FROM;
        if (i == 11) {
            feedFrom = FeedProtos.FeedFrom.PERSONAL;
        }
        return feedFrom;
    }

    public static FeedProtos.FeedProto.Builder a(FeedProtos.Event event, BluedIngSelfFeed bluedIngSelfFeed) {
        FeedProtos.FeedProto.Builder newBuilder = FeedProtos.FeedProto.newBuilder();
        if (event != null && bluedIngSelfFeed != null) {
            FeedProtos.FeedProto.Builder isEssence = newBuilder.setEvent(event).setCircleId(a(bluedIngSelfFeed.circle_id)).setNoteId(a(bluedIngSelfFeed.feed_id)).setIsTop(bluedIngSelfFeed.is_top == 1).setNoteType(c(bluedIngSelfFeed)).setFeedClass(b(bluedIngSelfFeed)).setNoteFrom(a(bluedIngSelfFeed.note_from)).setIsAnonymousPublish(bluedIngSelfFeed.is_anonym == 1).setIsEssence(bluedIngSelfFeed.is_essence == 1);
            boolean z = false;
            if (bluedIngSelfFeed.allow_join == 0) {
                z = true;
            }
            isEssence.setIsApply(z).setId(bluedIngSelfFeed.classify_id + "");
        }
        return newBuilder;
    }

    public static FeedProtos.FeedProto.Builder a(FeedProtos.Event event, BluedIngSelfFeed bluedIngSelfFeed, int i) {
        return a(event, bluedIngSelfFeed, i, a());
    }

    public static FeedProtos.FeedProto.Builder a(FeedProtos.Event event, BluedIngSelfFeed bluedIngSelfFeed, int i, int i2) {
        return a(event, bluedIngSelfFeed, i).setNum(a(i, i2));
    }

    public static FeedProtos.FeedProto.Builder a(FeedProtos.Event event, BluedIngSelfFeed bluedIngSelfFeed, int i, int i2, long j) {
        return a(event, bluedIngSelfFeed, i, i2).setRefreshId(String.valueOf(j));
    }

    public static FeedProtos.FeedProto.Builder a(FeedProtos.Event event, BluedIngSelfFeed bluedIngSelfFeed, int i, int i2, boolean z, long j) {
        return a(event, bluedIngSelfFeed, i, z, j).setNum(a(i, i2));
    }

    public static FeedProtos.FeedProto.Builder a(FeedProtos.Event event, BluedIngSelfFeed bluedIngSelfFeed, int i, String str) {
        return a(event, bluedIngSelfFeed, i, str, 0L);
    }

    public static FeedProtos.FeedProto.Builder a(FeedProtos.Event event, BluedIngSelfFeed bluedIngSelfFeed, int i, String str, long j) {
        FeedProtos.FeedProto.Builder newBuilder = FeedProtos.FeedProto.newBuilder();
        if (event != null && bluedIngSelfFeed != null) {
            FeedProtos.FeedProto.Builder isRecommend = newBuilder.setEvent(event).setFeedId(a(bluedIngSelfFeed.feed_id)).setTopicId(a(TextUtils.isEmpty(bluedIngSelfFeed.super_did) ? "" : bluedIngSelfFeed.super_did)).setFeedClass(b(bluedIngSelfFeed)).setFeedPage(d(i)).setSourcePage(f(i)).setTargetUid(a(bluedIngSelfFeed.feed_uid)).setIsExposure(bluedIngSelfFeed.in_promotion == 1).setIsMulti(bluedIngSelfFeed.feed_pics != null && bluedIngSelfFeed.feed_pics.length > 1).setCircleId(a(bluedIngSelfFeed.circle_id)).setLiveId(a(bluedIngSelfFeed.lid)).setIsLive(bluedIngSelfFeed.live > 0).setIsTop(bluedIngSelfFeed.is_top == 1).setIsIcon(bluedIngSelfFeed.is_top_hot == 1).setIsAnonymousPublish(bluedIngSelfFeed.isAnonymous()).setIsJoin(bluedIngSelfFeed.is_strong_insert == 1).setIsHot(bluedIngSelfFeed.is_hot_feed == 1).setDistance(a(bluedIngSelfFeed.distance)).setMode(a(str)).setType(a(bluedIngSelfFeed.strong_insert_data)).setIsLike(bluedIngSelfFeed.iliked == 0).setRecommendType(a(bluedIngSelfFeed.recommend_text)).setActivityId(a(bluedIngSelfFeed.activity_id)).setGuideType(bluedIngSelfFeed.tips > 0 ? String.valueOf(bluedIngSelfFeed.tips) : "").setFeedType(a(bluedIngSelfFeed)).setIsNew(bluedIngSelfFeed.isNewFace()).setWord(a(bluedIngSelfFeed.tips_text)).setRefreshId(String.valueOf(j)).setLogoId(a(bluedIngSelfFeed.super_tag_image)).setIsRecommend(bluedIngSelfFeed.is_op_recommend == 1);
            boolean z = false;
            if (bluedIngSelfFeed.is_top_feed == 1) {
                z = true;
            }
            isRecommend.setIsTopFeed(z);
        }
        return newBuilder;
    }

    public static FeedProtos.FeedProto.Builder a(FeedProtos.Event event, BluedIngSelfFeed bluedIngSelfFeed, int i, boolean z, long j) {
        return a(event, bluedIngSelfFeed, i, "", j);
    }

    public static FeedProtos.FeedProto.Builder a(FeedProtos.Event event, BluedIngSelfFeed bluedIngSelfFeed, FeedProtos.NoteSource noteSource) {
        FeedProtos.FeedProto.Builder a2 = a(event, bluedIngSelfFeed);
        if (noteSource != null) {
            a2.setNoteSource(noteSource);
            ByteDanceEvent.a(event.name(), noteSource);
        }
        return a2;
    }

    public static FeedProtos.FeedProto.Builder a(FeedProtos.Event event, BluedIngSelfFeed bluedIngSelfFeed, FeedProtos.NoteSource noteSource, boolean z, String str) {
        return a(event, bluedIngSelfFeed, noteSource).setIsTop(z).setIsJoin(bluedIngSelfFeed.isJoin()).setIsApply(bluedIngSelfFeed.allow_join == 0).setMode(a(str));
    }

    public static FeedProtos.FeedProto.Builder a(FeedProtos.Event event, BluedIngSelfFeed bluedIngSelfFeed, FeedProtos.SourcePage sourcePage) {
        FeedProtos.FeedProto.Builder a2 = a(event, bluedIngSelfFeed, 0);
        if (a2 != null) {
            a2.setSourcePage(sourcePage);
        }
        return a2;
    }

    public static FeedProtos.FeedProto.Builder a(FeedProtos.Event event, FeedProtos.CircleSource circleSource, MyCircleModel myCircleModel) {
        FeedProtos.FeedProto.Builder newBuilder = FeedProtos.FeedProto.newBuilder();
        if (event != null && circleSource != null && myCircleModel != null) {
            FeedProtos.FeedProto.Builder isApply = newBuilder.setEvent(event).setCircleId(a(myCircleModel.circle_id)).setCircleSource(circleSource).setIsApply(myCircleModel.allow_join == 0);
            isApply.setId(a(myCircleModel.classify_id + ""));
        }
        return newBuilder;
    }

    public static FeedProtos.FeedType a(NewFeedModel newFeedModel) {
        FeedProtos.FeedType feedType = FeedProtos.FeedType.COMMON;
        FeedProtos.FeedType feedType2 = feedType;
        if (newFeedModel != null) {
            if (newFeedModel.is_vote == 1) {
                return FeedProtos.FeedType.VOTE_FEED;
            }
            if (newFeedModel.is_questionnaire == 1) {
                return FeedProtos.FeedType.QA_FEED;
            }
            if (newFeedModel.tt_type == 3) {
                return FeedProtos.FeedType.DESC_FEED;
            }
            if (newFeedModel.tt_type == 5) {
                return FeedProtos.FeedType.BIRTHDAY_FEED;
            }
            if (newFeedModel.tt_type == 6) {
                return FeedProtos.FeedType.ANNIVERSARY_FEED;
            }
            if (!TextUtils.isEmpty(newFeedModel.activity_id)) {
                return FeedProtos.FeedType.FEED_ACTIVITY;
            }
            feedType2 = feedType;
            if (newFeedModel.is_super_topics == 1) {
                feedType2 = FeedProtos.FeedType.SUPER_TOPIC;
            }
        }
        return feedType2;
    }

    public static FeedProtos.FeedType a(BluedIngSelfFeed bluedIngSelfFeed) {
        FeedProtos.FeedType feedType = FeedProtos.FeedType.COMMON;
        FeedProtos.FeedType feedType2 = feedType;
        if (bluedIngSelfFeed != null) {
            if (bluedIngSelfFeed.is_bubble_ticktock == 1) {
                return FeedProtos.FeedType.FEED_PUNCH;
            }
            if (bluedIngSelfFeed.is_vote == 1) {
                return FeedProtos.FeedType.VOTE_FEED;
            }
            if (bluedIngSelfFeed.is_questionnaire == 1) {
                return FeedProtos.FeedType.QA_FEED;
            }
            if (bluedIngSelfFeed.tt_type == 3) {
                return FeedProtos.FeedType.DESC_FEED;
            }
            if (bluedIngSelfFeed.tt_type == 5) {
                return FeedProtos.FeedType.BIRTHDAY_FEED;
            }
            if (bluedIngSelfFeed.tt_type == 6) {
                return FeedProtos.FeedType.ANNIVERSARY_FEED;
            }
            if (bluedIngSelfFeed.activity_data != null) {
                return FeedProtos.FeedType.FEED_ACTIVITY;
            }
            feedType2 = feedType;
            if (bluedIngSelfFeed.is_super_topics == 1) {
                feedType2 = FeedProtos.FeedType.SUPER_TOPIC;
            }
        }
        return feedType2;
    }

    public static FeedProtos.SourcePage a(ShareEntity shareEntity) {
        return shareEntity.h ? f(shareEntity.i) : shareEntity.j ? FeedProtos.SourcePage.FEED_PERSONAL_MORE : shareEntity.k ? FeedProtos.SourcePage.SHARE_LIVE : shareEntity.l ? g(shareEntity.i) : shareEntity.m ? FeedProtos.SourcePage.CIRCLE_DETAIL_SHARE : shareEntity.n ? FeedProtos.SourcePage.ACTIVITY_DETAIL : FeedProtos.SourcePage.UNKNOWN_SOURCE_PAGE;
    }

    public static String a() {
        return CommunityManager.f19086a.a().t();
    }

    public static String a(String str) {
        return EventTrackUtils.a(str);
    }

    public static void a(NewFeedModel newFeedModel, String str, boolean z, boolean z2, String str2, int i, String str3, String str4, String str5, int i2) {
        if (newFeedModel != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(FeedProtos.Event.FEED_PUBLISH_CONFIRM_BTN_CLICK).setFeedType(a(newFeedModel)).setTopicId(a(newFeedModel.super_did)).setMusicId(a(str)).setIsComment(z).setIsAnonymousPublish(z2).setId(a(str2)).setNum(i).setQaId(a(str3)).setPicId(a(str4)).setDescId(a(str5)).setFeedFrom(a(i2)).build());
        }
    }

    public static void a(BluedIngSelfFeed bluedIngSelfFeed, int i, String str) {
        FeedProtos.FeedProto.Builder a2 = a(FeedProtos.Event.FEED_COMMENT_SEND_BTN_CLICK, bluedIngSelfFeed, i);
        if (a2 != null) {
            a2.setTopicId(a(str)).setMode(a());
        }
        a(a2);
        FeedProtos.SourcePage f = f(i);
        if (f == null || bluedIngSelfFeed == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("source_page", f.name());
            jSONObject.put("feed_id", bluedIngSelfFeed.feed_id);
            jSONObject.put("type", bluedIngSelfFeed.strong_insert_data);
            ByteDanceEvent.a("FEED_COMMENT_SEND_BTN_CLICK", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void a(BluedIngSelfFeed bluedIngSelfFeed, int i, boolean z) {
        a(bluedIngSelfFeed, f(i), z);
    }

    public static void a(BluedIngSelfFeed bluedIngSelfFeed, FeedProtos.SourcePage sourcePage, boolean z) {
        FeedProtos.FeedProto.Builder a2 = a(FeedProtos.Event.FEED_LIKE_BTN_CLICK, bluedIngSelfFeed, sourcePage);
        if (a2 != null) {
            a2.setIsGuide(z);
        }
        a(a2);
        if (sourcePage != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("source_page", sourcePage.name());
                jSONObject.put("type", bluedIngSelfFeed != null ? bluedIngSelfFeed.strong_insert_data : "");
                ByteDanceEvent.a(FeedProtos.Event.FEED_LIKE_BTN_CLICK.name(), jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(ChatRoomProtos.Event event, String str, String str2, int i) {
        if (event != null) {
            EventTrackUtils.a(ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setRoomUid(a(str2)).setSource(n(i)).build());
        }
    }

    public static void a(FeedProtos.Event event) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).build());
        }
    }

    public static void a(FeedProtos.Event event, int i) {
        String str = "punch";
        if (i != 1102 || CommunityManager.f19086a.a().a() == null) {
            if (i != 1101) {
                str = i == 6 ? "shape" : "update";
            }
        } else if (CommunityManager.f19086a.a().a().extra_bubble_type == 2) {
            str = "new_activity";
        } else if (CommunityManager.f19086a.a().a().extra_bubble_type == 1) {
            str = "predestined";
        } else if (CommunityManager.f19086a.a().a().extra_bubble_type != 3) {
            str = CommunityManager.f19086a.a().a().extra_bubble_type == 4 ? "lost" : CommunityManager.f19086a.a().a().extra_bubble_type == 5 ? "location_newface" : CommunityManager.f19086a.a().a().extra_bubble_type == 6 ? UserFindResult.USER_SORT_BY.ONLINE : null;
        }
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setMode(a(a())).setType(a(str)).build());
        }
    }

    public static void a(FeedProtos.Event event, int i, int i2, String str, BluedTopic bluedTopic) {
        String str2;
        if (event != null) {
            FeedProtos.FeedProto.Builder newBuilder = FeedProtos.FeedProto.newBuilder();
            if (i == 4) {
                str2 = "4";
            } else if (i == 3) {
                str2 = "3";
            } else if (i == 2) {
                str2 = "1";
            } else if (i == 1) {
                str2 = "2";
            } else if (i == 5) {
                str2 = "5";
            } else if (i == 6) {
                str2 = "6";
            } else if (i == 7) {
                str2 = "7";
            } else if (i == 8) {
                str2 = "8";
            } else if (i == 9) {
                str2 = "9";
            } else if (i == 14) {
                if (i2 == 13 || i2 == 12) {
                    str2 = "11";
                } else {
                    if (i2 == 10 || i2 == 11) {
                        str2 = bluedTopic != null ? "13" : "12";
                    }
                    str2 = "";
                }
            } else if (i == 15) {
                str2 = "14";
            } else if (i == 17) {
                str2 = "16";
            } else if (i == 19) {
                str2 = "17";
            } else {
                if (i == 18) {
                    str2 = "15";
                }
                str2 = "";
            }
            newBuilder.setEvent(event).setType(str2).setId(a(str));
            a(newBuilder);
        }
    }

    public static void a(FeedProtos.Event event, int i, String str, String str2, String str3) {
        if (event != null) {
            FeedProtos.FeedProto.Builder event2 = FeedProtos.FeedProto.newBuilder().setEvent(event);
            EventTrackUtils.a(event2.setTabId(i + "").setLinkUrl(a(str)).setIconType(a(str2)).setLabel(a(str3)).build());
        }
    }

    public static void a(FeedProtos.Event event, int i, String str, String str2, boolean z, int i2, boolean z2, boolean z3, boolean z4, boolean z5, FeedProtos.FeedType feedType, String str3, BluedIngSelfFeed bluedIngSelfFeed, boolean z6, long j, boolean z7) {
        String str4;
        boolean z8;
        if (event != null) {
            if (bluedIngSelfFeed.is_share_super_topics == 1 && bluedIngSelfFeed.share_s_t_des != null) {
                z8 = MarkDownLinkHelper.a(bluedIngSelfFeed.share_s_t_des);
                str4 = bluedIngSelfFeed.share_s_t_did;
            } else if (!bluedIngSelfFeed.isRepost() || bluedIngSelfFeed.repost.share_s_t_des == null) {
                boolean a2 = (!bluedIngSelfFeed.isRepost() || bluedIngSelfFeed.repost == null || bluedIngSelfFeed.repost.feed_content == null) ? false : MarkDownLinkHelper.a(bluedIngSelfFeed.repost.feed_content);
                boolean z9 = a2;
                if (!a2) {
                    z9 = MarkDownLinkHelper.a(bluedIngSelfFeed.feed_content);
                }
                str4 = "";
                z8 = z9;
            } else {
                z8 = MarkDownLinkHelper.a(bluedIngSelfFeed.repost.share_s_t_des);
                str4 = bluedIngSelfFeed.repost.share_s_t_did;
            }
            FeedProtos.FeedProto.Builder isTopFeed = FeedProtos.FeedProto.newBuilder().setEvent(event).setTopicId(a(str)).setFeedId(a(bluedIngSelfFeed.feed_id)).setFeedClass(b(bluedIngSelfFeed)).setFeedPage(d(i)).setTargetUid(a(bluedIngSelfFeed.feed_uid)).setIsExposure(bluedIngSelfFeed.in_promotion == 1).setIsMulti(bluedIngSelfFeed.feed_pics != null && bluedIngSelfFeed.feed_pics.length > 1).setCircleId(a(bluedIngSelfFeed.join_circle_id)).setLiveId(a(str2)).setIsTop(z).setNum(l(i2)).setIsIcon(z2).setIsAnonymousPublish(z3).setIsJoin(z4).setIsHot(z5).setDistance(a(bluedIngSelfFeed.distance)).setFeedType(feedType).setMode(a(str3)).setGuideType(bluedIngSelfFeed.tips > 0 ? String.valueOf(bluedIngSelfFeed.tips) : "").setIsGuide(z6).setRefreshId(String.valueOf(j)).setType(a(bluedIngSelfFeed.strong_insert_data)).setActivityId(a(bluedIngSelfFeed.activity_id)).setIsNew(bluedIngSelfFeed.isNewFace()).setWord(a(bluedIngSelfFeed.tips_text)).setIsLottery(z8).setId(a(str4)).setIsYy(z7).setLogoId(a(bluedIngSelfFeed.super_tag_image)).setIsTopFeed(bluedIngSelfFeed.is_top_feed == 1);
            boolean z10 = false;
            if (bluedIngSelfFeed.is_op_recommend == 1) {
                z10 = true;
            }
            a(isTopFeed.setIsRecommend(z10).setCurrentId(a(bluedIngSelfFeed.current_track_subject_id)).setOption(a(bluedIngSelfFeed.is_vote == 1 ? String.valueOf(bluedIngSelfFeed.ivoted) : "")).setCount(CommonStringUtils.a(bluedIngSelfFeed.tt_click_sum)));
            ByteDanceEvent.a(FeedProtos.Event.FEED_DRAW.name(), bluedIngSelfFeed, d(i));
        }
    }

    public static void a(FeedProtos.Event event, BluedIngSelfFeed bluedIngSelfFeed, int i, int i2, boolean z, long j, int i3) {
        FeedProtos.FeedProto.Builder a2 = a(event, bluedIngSelfFeed, i, i2, z, j);
        if (bluedIngSelfFeed.is_third_ads == 1) {
            a2.setId(String.valueOf(bluedIngSelfFeed.ads_id));
        } else {
            a2.setId(a(bluedIngSelfFeed.feed_id));
        }
        a(a2);
        ByteDanceEvent.a(event.name(), i2, i3);
    }

    public static void a(FeedProtos.Event event, BluedIngSelfFeed bluedIngSelfFeed, int i, String str, long j, int i2) {
        if (event == null || bluedIngSelfFeed == null) {
            return;
        }
        EventTrackUtils.a(a(event, bluedIngSelfFeed, i, str).setRefreshId(String.valueOf(j)).setNum(a(i, i2)).build());
    }

    public static void a(FeedProtos.Event event, BluedIngSelfFeed bluedIngSelfFeed, int i, boolean z) {
        b(event, bluedIngSelfFeed, i, z, 0L);
    }

    public static void a(FeedProtos.Event event, BluedIngSelfFeed bluedIngSelfFeed, int i, boolean z, long j, int i2) {
        a(event, bluedIngSelfFeed, i, "", j, i2);
    }

    public static void a(FeedProtos.Event event, BluedIngSelfFeed bluedIngSelfFeed, FeedProtos.CircleSource circleSource) {
        a(a(event, bluedIngSelfFeed).setMode("").setCircleSource(circleSource));
    }

    public static void a(FeedProtos.Event event, BluedIngSelfFeed bluedIngSelfFeed, FeedProtos.NoteSource noteSource, boolean z, int i, long j) {
        a(a(event, bluedIngSelfFeed, noteSource).setMode("").setNum(l(i)).setRefreshId(String.valueOf(j)));
    }

    public static void a(FeedProtos.Event event, BluedIngSelfFeed bluedIngSelfFeed, String str) {
        if (event == null || bluedIngSelfFeed == null) {
            return;
        }
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setFeedId(a(bluedIngSelfFeed.feed_id)).setTargetUid(a(bluedIngSelfFeed.feed_uid)).setId(a(str)).build());
    }

    public static void a(FeedProtos.Event event, BluedIngSelfFeed bluedIngSelfFeed, String str, FeedProtos.FeedClass feedClass, FeedProtos.FeedPage feedPage) {
        if (event == null || feedClass == null || feedPage == null || bluedIngSelfFeed == null) {
            return;
        }
        FeedProtos.FeedProto.Builder liveId = FeedProtos.FeedProto.newBuilder().setEvent(event).setTopicId(a(str)).setFeedId(a(bluedIngSelfFeed.feed_id)).setFeedClass(feedClass).setFeedPage(feedPage).setTargetUid(a(bluedIngSelfFeed.feed_uid)).setIsExposure(bluedIngSelfFeed.in_promotion == 1).setIsMulti(bluedIngSelfFeed.feed_pics != null && bluedIngSelfFeed.feed_pics.length > 1).setCircleId(a(bluedIngSelfFeed.join_circle_id)).setLiveId(a(""));
        boolean z = false;
        if (bluedIngSelfFeed.is_top_hot == 1) {
            z = true;
        }
        EventTrackUtils.a(liveId.setIsIcon(z).setDistance(a(bluedIngSelfFeed.distance)).build());
        ByteDanceEvent.a(FeedProtos.Event.FEED_DRAW.name(), bluedIngSelfFeed, feedPage);
    }

    public static void a(FeedProtos.Event event, FeedNotice feedNotice) {
        if (event == null || feedNotice == null) {
            return;
        }
        String str = feedNotice.feed_id;
        FeedProtos.FeedType feedType = FeedProtos.FeedType.COMMON;
        if (feedNotice.type == 12) {
            feedType = FeedProtos.FeedType.FEED_PUNCH;
        }
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setCommentId(a(feedNotice.comment_id)).setCircleId(a(feedNotice.circle_id)).setFeedId(a(str)).setType(String.valueOf(feedNotice.type)).setFeedType(feedType).setTargetUid(a(feedNotice.uid)).build());
    }

    public static void a(FeedProtos.Event event, EventLogData eventLogData) {
        EventLogData eventLogData2 = eventLogData;
        if (eventLogData == null) {
            eventLogData2 = new EventLogData();
        }
        if (event != null) {
            String a2 = a(eventLogData2.getUid());
            if (event == FeedProtos.Event.ACTIVITY_DETAIL_PAGE_SHOW) {
                a2 = a(eventLogData2.getEventId());
            }
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setActivityId(a(eventLogData2.getEventId())).setTargetUid(a(eventLogData2.getEventManagerUid())).setId(a2).setMode(a(eventLogData2.mode)).setSourcePage(eventLogData2.getSourcePage() != null ? eventLogData2.getSourcePage() : FeedProtos.SourcePage.UNKNOWN_SOURCE_PAGE).build());
        }
    }

    public static void a(FeedProtos.Event event, FeedProtos.AddType addType, FeedProtos.FeedType feedType) {
        if (event == null || addType == null) {
            return;
        }
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setAddType(addType).setFeedType(feedType).build());
    }

    public static void a(FeedProtos.Event event, FeedProtos.CircleSource circleSource) {
        if (event == null || circleSource == null) {
            return;
        }
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setCircleSource(circleSource).build());
    }

    public static void a(FeedProtos.Event event, FeedProtos.DetailFrom detailFrom, String str, boolean z, boolean z2) {
        if (event == null || detailFrom == null) {
            return;
        }
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setDetailFrom(detailFrom).setTopicId(str).setIsAnonymousPublish(z).setIsLottery(z2).build());
    }

    public static void a(FeedProtos.Event event, FeedProtos.DetailFrom detailFrom, String str, boolean z, boolean z2, FeedProtos.FeedPage feedPage, boolean z3) {
        if (event == null || detailFrom == null) {
            return;
        }
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setDetailFrom(detailFrom).setTopicId(str).setIsAnonymousPublish(z).setIsLottery(z2).setFeedPage(feedPage).setIsFollow(z3).build());
    }

    public static void a(FeedProtos.Event event, FeedProtos.DetailFrom detailFrom, String str, boolean z, boolean z2, boolean z3) {
        if (event == null || detailFrom == null) {
            return;
        }
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setDetailFrom(detailFrom).setTopicId(str).setIsAnonymousPublish(z).setIsLottery(z2).setIsFollow(z3).build());
    }

    public static void a(FeedProtos.Event event, FeedProtos.FeedFrom feedFrom) {
        if (event == null || feedFrom == null) {
            return;
        }
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setFeedFrom(feedFrom).build());
    }

    public static void a(FeedProtos.Event event, FeedProtos.FeedFrom feedFrom, String str, boolean z, boolean z2, String str2) {
        if (event == null || feedFrom == null) {
            return;
        }
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setFeedFrom(feedFrom).setTopicId(a(str)).setIsTrue(z).setIsAnonymousPublish(z2).setMode(a(str2)).build());
    }

    public static void a(FeedProtos.Event event, FeedProtos.FeedFrom feedFrom, boolean z, String str) {
        a(event, feedFrom, "", z, false, str);
    }

    public static void a(FeedProtos.Event event, FeedProtos.ShareChannel shareChannel, FeedProtos.SourcePage sourcePage, String str, BluedIngSelfFeed bluedIngSelfFeed) {
        a(event, shareChannel, "", "", "", "", "", sourcePage, str, false, "", false, false, "", false, bluedIngSelfFeed);
    }

    public static void a(FeedProtos.Event event, FeedProtos.ShareChannel shareChannel, String str, String str2, String str3, String str4, String str5, FeedProtos.SourcePage sourcePage, String str6, boolean z, String str7, boolean z2, boolean z3, String str8, boolean z4, BluedIngSelfFeed bluedIngSelfFeed) {
        a(event, shareChannel, str, str2, str3, str4, str5, sourcePage, str6, z, str7, z2, z3, str8, z4, bluedIngSelfFeed, a(bluedIngSelfFeed));
    }

    public static void a(FeedProtos.Event event, FeedProtos.ShareChannel shareChannel, String str, String str2, String str3, String str4, String str5, FeedProtos.SourcePage sourcePage, String str6, boolean z, String str7, boolean z2, boolean z3, String str8, boolean z4, BluedIngSelfFeed bluedIngSelfFeed, FeedProtos.FeedType feedType) {
        if (event == null || shareChannel == null || sourcePage == null) {
            return;
        }
        FeedProtos.FeedProto.Builder isTopFeed = FeedProtos.FeedProto.newBuilder().setEvent(event).setShareChannel(shareChannel).setTargetUid(a(str)).setTopicId(a(str3)).setFeedId(a(str2)).setLiveId(a(str4)).setCircleId(a(str5)).setSourcePage(sourcePage).setLinkUrl(a(str6)).setIsExposure(z).setRecommendType(a(str7)).setIsAnonymousPublish(z2).setIsTop(z3).setId(a(str8)).setActivityId(a(str8)).setIsHot(z4).setFeedType(feedType).setType(bluedIngSelfFeed != null ? a(bluedIngSelfFeed.strong_insert_data) : "").setLogoId(bluedIngSelfFeed != null ? a(bluedIngSelfFeed.super_tag_image) : "").setIsTopFeed(bluedIngSelfFeed != null && bluedIngSelfFeed.is_top_feed == 1);
        boolean z5 = false;
        if (bluedIngSelfFeed != null) {
            z5 = false;
            if (bluedIngSelfFeed.is_op_recommend == 1) {
                z5 = true;
            }
        }
        EventTrackUtils.a(isTopFeed.setIsRecommend(z5).build());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("source_page", sourcePage);
            jSONObject.put("feed_id", str2);
            jSONObject.put("type", bluedIngSelfFeed == null ? "" : bluedIngSelfFeed.strong_insert_data);
            ByteDanceEvent.a(event.name(), jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void a(FeedProtos.Event event, FeedProtos.SourcePage sourcePage) {
        if (event == null || sourcePage == null) {
            return;
        }
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setSourcePage(sourcePage).setMode(CommunityManager.f19086a.a().t()).build());
    }

    public static void a(FeedProtos.Event event, FeedProtos.SourcePage sourcePage, int i) {
        if (event != null) {
            FeedProtos.FeedProto.Builder sourcePage2 = FeedProtos.FeedProto.newBuilder().setEvent(event).setSourcePage(sourcePage);
            EventTrackUtils.a(sourcePage2.setId(a(i + "")).build());
        }
    }

    public static void a(FeedProtos.Event event, FeedProtos.SourcePage sourcePage, String str) {
        if (event == null || sourcePage == null) {
            return;
        }
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setSourcePage(sourcePage).setId(a(str)).setMode(CommunityManager.f19086a.a().t()).build());
    }

    public static void a(FeedProtos.Event event, FeedProtos.SourcePage sourcePage, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setSourcePage(sourcePage).setCircleId(a(str)).setId(a(str2)).setMode(a(str3)).build());
        }
    }

    public static void a(FeedProtos.Event event, FeedProtos.TabType tabType) {
        if (event == null || tabType == null) {
            return;
        }
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setTabType(tabType).build());
    }

    public static void a(FeedProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setMode(a(str)).build());
        }
    }

    public static void a(FeedProtos.Event event, String str, int i) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setTopicId(a(str)).setFeedFrom(a(i)).build());
        }
    }

    public static void a(FeedProtos.Event event, String str, int i, long j, int i2) {
        FeedProtos.FeedProto.Builder newBuilder = FeedProtos.FeedProto.newBuilder();
        if (event != null) {
            newBuilder.setEvent(event).setTopicId(a(str)).setNum(i).setRefreshId(String.valueOf(j)).setFeedPage(d(i2));
            a(newBuilder);
        }
    }

    public static void a(FeedProtos.Event event, String str, int i, String str2) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setId(a(str)).setNum(i).setTargetUid(a(str2)).build());
        }
    }

    public static void a(FeedProtos.Event event, String str, int i, String str2, int i2) {
        a(event, str, i, str2, i2, 0L);
    }

    public static void a(FeedProtos.Event event, String str, int i, String str2, int i2, long j) {
        if (event == null || str == null) {
            return;
        }
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setMode(a(str2)).setId(a(str)).setNum(a(0, i)).setRefreshId(String.valueOf(j)).build());
        ByteDanceEvent.a(event.name(), i, i2);
    }

    public static void a(FeedProtos.Event event, String str, int i, String str2, String str3, BluedIngSelfFeed bluedIngSelfFeed, int i2, long j) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setId(a(str)).setNum(a(i2, i)).setType(a(str2)).setMode(a(str3)).setFeedPage(d(i2)).setWord(bluedIngSelfFeed != null ? a(bluedIngSelfFeed.activity_guide_text) : "").setLabel(bluedIngSelfFeed != null ? a(bluedIngSelfFeed.activity_guide_tag) : "").setRefreshId(String.valueOf(j)).build());
            ByteDanceEvent.a(event.name(), new JSONObject());
        }
    }

    public static void a(FeedProtos.Event event, String str, FeedProtos.CircleSource circleSource, boolean z, boolean z2, int i) {
        if (event == null || circleSource == null) {
            return;
        }
        FeedProtos.FeedProto.Builder isApply = FeedProtos.FeedProto.newBuilder().setEvent(event).setCircleId(a(str)).setCircleSource(circleSource).setIsJoin(z).setIsApply(z2);
        EventTrackUtils.a(isApply.setId(a(i + "")).build());
    }

    public static void a(FeedProtos.Event event, String str, FeedProtos.FeedFrom feedFrom, String str2) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setCircleId(a(str)).setFeedFrom(feedFrom).setId(a(str2)).build());
        }
    }

    public static void a(FeedProtos.Event event, String str, FeedProtos.FeedPage feedPage) {
        if (event == null || feedPage == null) {
            return;
        }
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setFeedId(a(str)).setFeedPage(feedPage).build());
    }

    public static void a(FeedProtos.Event event, String str, FeedProtos.InteractiveType interactiveType, FeedProtos.Location location, String str2, String str3) {
        if (event == null || interactiveType == null || location == null) {
            return;
        }
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setFeedId(a(str)).setInteractiveType(interactiveType).setLocation(location).setCommentId(a(str2)).setTargetUid(a(str3)).build());
    }

    public static void a(FeedProtos.Event event, String str, FeedProtos.Location location) {
        if (event == null || location == null) {
            return;
        }
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setFeedId(a(str)).setLocation(location).build());
    }

    public static void a(FeedProtos.Event event, String str, FeedProtos.NoteSource noteSource) {
        if (event == null || noteSource == null) {
            return;
        }
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setNoteId(a(str)).setNoteSource(noteSource).build());
    }

    public static void a(FeedProtos.Event event, String str, FeedProtos.NoteSource noteSource, String str2, String str3, boolean z, FeedProtos.FeedClass feedClass, FeedProtos.NoteType noteType, boolean z2, boolean z3) {
        if (event == null || noteSource == null || noteType == null) {
            return;
        }
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setCommentId(a(str)).setNoteSource(noteSource).setNoteId(a(str2)).setCircleId(a(str3)).setIsAt(z).setFeedClass(feedClass).setNoteType(noteType).setIsAnonymousPublish(z2).setIsAnonymousComment(z3).build());
    }

    public static void a(FeedProtos.Event event, String str, FeedProtos.NoteSource noteSource, String str2, String str3, boolean z, FeedProtos.NoteType noteType, boolean z2, boolean z3) {
        if (event == null || noteSource == null || noteType == null) {
            return;
        }
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setCommentId(a(str)).setNoteSource(noteSource).setNoteId(a(str2)).setCircleId(a(str3)).setIsAt(z).setNoteType(noteType).setIsAnonymousPublish(z2).setIsAnonymousComment(z3).build());
    }

    public static void a(FeedProtos.Event event, String str, FeedProtos.NoteType noteType, boolean z, boolean z2, boolean z3) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setNoteType(noteType).setCircleId(a(str)).setIsAnonymousPublish(z).setIsAnonymousComment(z2).setIsAt(z3).build());
        }
    }

    public static void a(FeedProtos.Event event, String str, FeedProtos.SourcePage sourcePage, String str2) {
        if (event == null || sourcePage == null) {
            return;
        }
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setId(a(str)).setSourcePage(sourcePage).setMode(str2).build());
    }

    public static void a(FeedProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setFeedId(a(str)).setTargetUid(a(str2)).build());
        }
    }

    public static void a(FeedProtos.Event event, String str, String str2, int i) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setId(a(str)).setGroupId(a(str2)).setNum(i).build());
        }
    }

    public static void a(FeedProtos.Event event, String str, String str2, int i, long j) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setRoomId(a(str)).setRoomUid(a(str2)).setNum(a(0, i)).setRefreshId(String.valueOf(j)).build());
        }
    }

    public static void a(FeedProtos.Event event, String str, String str2, FeedProtos.CircleSource circleSource, boolean z, boolean z2, FeedProtos.UserType userType, int i) {
        if (event == null || circleSource == null || userType == null) {
            return;
        }
        FeedProtos.FeedProto.Builder userType2 = FeedProtos.FeedProto.newBuilder().setEvent(event).setCircleId(a(str)).setNoteId(a(str2)).setCircleSource(circleSource).setIsJoin(z).setIsApply(z2).setUserType(userType);
        EventTrackUtils.a(userType2.setId(a(i + "")).build());
    }

    public static void a(FeedProtos.Event event, String str, String str2, FeedProtos.FeedPage feedPage) {
        if (event == null || feedPage == null) {
            return;
        }
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setFeedId(a(str)).setCircleId(a(str2)).setFeedPage(feedPage).build());
    }

    public static void a(FeedProtos.Event event, String str, String str2, FeedProtos.FeedPage feedPage, boolean z, String str3, boolean z2, boolean z3) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setFeedId(a(str)).setTargetUid(a(str2)).setFeedPage(feedPage).setIsIcon(z).setType(a(str3)).setIsTrue(z2).setMode(a()).setIsDouble(z3).build());
        }
    }

    public static void a(FeedProtos.Event event, String str, String str2, FeedProtos.FeedTopicPage feedTopicPage) {
        if (event == null || feedTopicPage == null) {
            return;
        }
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setFeedId(a(str)).setTopicId(a(str2)).setFeedTopicPage(feedTopicPage).build());
    }

    public static void a(FeedProtos.Event event, String str, String str2, FeedProtos.NoteSource noteSource, String str3) {
        if (event == null || noteSource == null) {
            return;
        }
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setMode(a(str3)).setCircleId(a(str)).setNoteId(a(str2)).setNoteSource(noteSource).build());
        ByteDanceEvent.a(event.name(), noteSource);
    }

    public static void a(FeedProtos.Event event, String str, String str2, FeedProtos.SourcePage sourcePage) {
        if (event == null || sourcePage == null) {
            return;
        }
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setSourcePage(sourcePage).setId(a(str)).setTargetUid(a(str2)).build());
    }

    public static void a(FeedProtos.Event event, String str, String str2, FeedProtos.SourcePage sourcePage, int i) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setFeedId(a(str)).setTargetUid(a(str2)).setSourcePage(sourcePage).build());
        }
    }

    public static void a(FeedProtos.Event event, String str, String str2, FeedProtos.SourcePage sourcePage, boolean z, String str3, boolean z2) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setFeedId(a(str)).setTargetUid(a(str2)).setSourcePage(sourcePage).setIsIcon(z).setType(a(str3)).setMode(z2 ? "2" : "").build());
        }
    }

    public static void a(FeedProtos.Event event, String str, String str2, FeedProtos.UserType userType) {
        if (event == null || userType == null) {
            return;
        }
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setCircleId(a(str)).setTargetUid(a(str2)).setUserType(userType).build());
    }

    public static void a(FeedProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setTargetUid(a(str2)).setFeedId(a(str)).setCommentId(a(str3)).build());
        }
    }

    public static void a(FeedProtos.Event event, String str, String str2, String str3, FeedProtos.FollowLocation followLocation, boolean z, boolean z2) {
        if (event == null || followLocation == null) {
            return;
        }
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setTargetUid(a(str)).setTopicId(a(str3)).setFeedId(a(str2)).setFollowLocation(followLocation).setIsFollow(z).setIsLive(z2).build());
    }

    public static void a(FeedProtos.Event event, String str, String str2, String str3, FeedProtos.OptType optType, FeedProtos.NoteType noteType, boolean z) {
        if (event == null || optType == null || noteType == null) {
            return;
        }
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setCircleId(a(str)).setNoteId(a(str2)).setTargetUid(a(str3)).setOptType(optType).setNoteType(noteType).setIsAnonymousPublish(z).build());
    }

    public static void a(FeedProtos.Event event, String str, String str2, String str3, FeedProtos.SourcePage sourcePage) {
        if (event == null || sourcePage == null) {
            return;
        }
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setFeedId(a(str)).setTopicId(a(str2)).setLiveId(a(str3)).setSourcePage(sourcePage).build());
    }

    public static void a(FeedProtos.Event event, String str, String str2, String str3, String str4, String str5) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setCircleId(a(str2)).setNoteId(a(str3)).setFeedId(a(str3)).setTargetUid(a(str4)).setCommentId(a(str)).setType(a(str5)).build());
        }
    }

    public static void a(FeedProtos.Event event, String str, String str2, String str3, String str4, boolean z) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setCircleId(a(str2)).setNoteId(a(str3)).setFeedId(a(str3)).setTargetUid(a(str4)).setCommentId(a(str)).setIsAnonymousComment(z).build());
        }
    }

    public static void a(FeedProtos.Event event, String str, String str2, boolean z) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setCircleId(a(str)).setTargetUid(a(str2)).setIsInvite(z).build());
        }
    }

    public static void a(FeedProtos.Event event, String str, boolean z) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setLinkUrl(a(str)).build());
        }
    }

    public static void a(FeedProtos.Event event, String str, boolean z, int i, long j) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setTargetUid(a(str)).setIsLive(z).setRefreshId(String.valueOf(j)).setNum(a(0, i)).build());
        }
    }

    public static void a(FeedProtos.FeedProto.Builder builder) {
        if (builder != null) {
            EventTrackUtils.a(builder.build());
        }
    }

    public static void a(FeedProtos.SourcePage sourcePage, String str, String str2, String str3, String str4, String str5) {
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(FeedProtos.Event.FEED_NOTE_MORE_OPERATE_BTN_CLICK).setSourcePage(sourcePage).setCircleId(a(str)).setId(a(str2)).setTargetUid(a(str4)).setType(str3).setMode(a(str5)).build());
    }

    public static void a(GuyProtos.Event event, int i, String str, String str2, String str3, String str4) {
        if (event != null) {
            GuyProtos.SortType sortType = GuyProtos.SortType.UNKNOWN_SORT_TYPE;
            EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).setId(a(str4)).setSortType(i == 12 ? GuyProtos.SortType.CITY_TOP : i == 1 ? GuyProtos.SortType.ONLINE_TIME_SORT : GuyProtos.SortType.DISTANCE_SORT).setUrl(a(str)).setName(a(str2)).setType(a(str3)).build());
        }
    }

    public static void a(PersonalProfileProtos.Event event, BluedIngSelfFeed bluedIngSelfFeed, boolean z, PersonalProfileProtos.Source source) {
        if (event == null || bluedIngSelfFeed == null) {
            return;
        }
        PersonalProfileProtos.PersonalProfileProto.Builder strategy = PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(event).setTargetUid(a(bluedIngSelfFeed.feed_uid)).setFeedId(a(bluedIngSelfFeed.feed_id)).setIsVideo(z).setSource(source).setIsIcon(bluedIngSelfFeed.is_top_hot == 1).setIsHot(bluedIngSelfFeed.is_hot_feed == 1).setDistance(a(bluedIngSelfFeed.distance)).setStrategy(a(bluedIngSelfFeed.strong_insert_data));
        boolean z2 = false;
        if (bluedIngSelfFeed.is_new_face == 1) {
            z2 = true;
        }
        EventTrackUtils.a(strategy.setIsNew(z2).build());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("source", source.name());
            jSONObject.put("is_video", z);
            jSONObject.put("feed_id", a(bluedIngSelfFeed.feed_id));
            ByteDanceEvent.a(event.name(), jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void a(String str, String str2, FeedProtos.CircleSource circleSource, boolean z, int i, String str3) {
        if (circleSource != null) {
            FeedProtos.FeedProto.Builder isApply = FeedProtos.FeedProto.newBuilder().setEvent(FeedProtos.Event.CIRCLE_JOIN_BTN_CLICK).setCircleId(a(str)).setNoteId(a(str2)).setCircleSource(circleSource).setIsApply(z);
            EventTrackUtils.a(isApply.setId(a(str + "")).setMode(a(str3)).build());
        }
    }

    public static void a(String str, String str2, String str3, FeedProtos.FollowLocation followLocation, boolean z, boolean z2, boolean z3, String str4) {
        if (followLocation != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(FeedProtos.Event.OTHER_FOLLOW_CLICK).setTargetUid(a(str)).setTopicId(a(str3)).setFeedId(a(str2)).setFollowLocation(followLocation).setIsFollow(z).setIsLive(z2).setType(a(str4)).setIsExposure(z3).build());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("follow_location", followLocation.name());
                jSONObject.put("feed_id", str2);
                jSONObject.put("type", str4);
                ByteDanceEvent.a("OTHER_FOLLOW_CLICK", jSONObject);
            } catch (JSONException e) {
            }
        }
    }

    public static void a(String str, String str2, String str3, boolean z, boolean z2, FeedProtos.FeedClass feedClass, FeedProtos.NoteType noteType, boolean z3, boolean z4, FeedProtos.NoteSource noteSource, String str4) {
        if (feedClass == null || noteType == null || noteSource == null) {
            return;
        }
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(FeedProtos.Event.CIRCLE_NOTE_LIKE).setCircleId(a(str)).setNoteId(a(str2)).setCommentId(a(str3)).setIsLike(z).setIsAt(z2).setFeedClass(feedClass).setNoteType(noteType).setMode(a(str4)).setIsAnonymousPublish(z3).setIsAnonymousComment(z4).setNoteSource(noteSource).build());
        ByteDanceEvent.a("CIRCLE_NOTE_LIKE", noteSource);
    }

    public static FeedProtos.DetailFrom b(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 4) {
                    if (i == 5) {
                        return FeedProtos.DetailFrom.FIND_SUPER_TOPIC_LIST;
                    }
                    if (i == 6) {
                        return FeedProtos.DetailFrom.FIND_PLAZA;
                    }
                    if (i == 10) {
                        return FeedProtos.DetailFrom.FIND_IMAGE_PAGE;
                    }
                    if (i == 14) {
                        return FeedProtos.DetailFrom.FEED_MORE_PAGE;
                    }
                    if (i == 18) {
                        return FeedProtos.DetailFrom.FIND_HOT;
                    }
                    if (i != 19) {
                        return FeedProtos.DetailFrom.UNKNOWN_DETAIL_FROM;
                    }
                }
                return FeedProtos.DetailFrom.FIND_NEARBY;
            }
            return FeedProtos.DetailFrom.PERSONAL_PAGE;
        }
        return FeedProtos.DetailFrom.FIND_FOLLOW;
    }

    public static FeedProtos.FeedClass b(BluedIngSelfFeed bluedIngSelfFeed) {
        FeedProtos.FeedClass feedClass = FeedProtos.FeedClass.UNKNOWN_FEED_CLASS;
        if (bluedIngSelfFeed.feed_type == -99) {
            bluedIngSelfFeed.feed_type = bluedIngSelfFeed.getItemType();
        }
        int i = bluedIngSelfFeed.feed_type;
        return i != 0 ? (i == 1 || i == 2) ? FeedProtos.FeedClass.FEED_IMAGE : i != 3 ? i != 8 ? i != 16 ? feedClass : FeedProtos.FeedClass.FEED_LIVE : FeedProtos.FeedClass.FEED_VOTE : FeedProtos.FeedClass.FEED_VIDEO : (bluedIngSelfFeed.feed_pics == null || bluedIngSelfFeed.feed_pics.length == 0) ? FeedProtos.FeedClass.FEED_WORD : FeedProtos.FeedClass.FEED_IMAGE;
    }

    public static void b(FeedProtos.Event event) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).build());
        }
    }

    public static void b(FeedProtos.Event event, int i) {
        if (event != null) {
            FeedProtos.FeedProto.Builder event2 = FeedProtos.FeedProto.newBuilder().setEvent(event);
            EventTrackUtils.a(event2.setImageId(i + "").build());
        }
    }

    public static void b(FeedProtos.Event event, BluedIngSelfFeed bluedIngSelfFeed, int i) {
        if (event == null || bluedIngSelfFeed == null) {
            return;
        }
        EventTrackUtils.a(a(event, bluedIngSelfFeed, i).build());
    }

    public static void b(FeedProtos.Event event, BluedIngSelfFeed bluedIngSelfFeed, int i, boolean z, long j) {
        a(event, bluedIngSelfFeed, i, z, j, -1);
    }

    public static void b(FeedProtos.Event event, BluedIngSelfFeed bluedIngSelfFeed, FeedProtos.NoteSource noteSource) {
        a(event, bluedIngSelfFeed, noteSource, CommunityManager.f19086a.a().e(), -1, 0L);
    }

    public static void b(FeedProtos.Event event, BluedIngSelfFeed bluedIngSelfFeed, FeedProtos.SourcePage sourcePage) {
        if (event == null || bluedIngSelfFeed == null) {
            return;
        }
        EventTrackUtils.a(a(event, bluedIngSelfFeed, 0).setSourcePage(sourcePage).build());
    }

    public static void b(FeedProtos.Event event, FeedProtos.CircleSource circleSource, MyCircleModel myCircleModel) {
        a(a(event, circleSource, myCircleModel));
    }

    public static void b(FeedProtos.Event event, FeedProtos.SourcePage sourcePage, int i) {
        if (event == null || sourcePage == null) {
            return;
        }
        EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setSourcePage(sourcePage).setNum(i).build());
    }

    public static void b(FeedProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setFeedId(a(str)).build());
        }
    }

    public static void b(FeedProtos.Event event, String str, int i) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setId(a(str)).setNum(i).build());
        }
    }

    public static void b(FeedProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setTargetUid(a(str2)).setFeedId(a(str)).build());
        }
    }

    public static void b(FeedProtos.Event event, String str, String str2, int i) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setQaId(a(str)).setPicId(a(str2)).setFeedFrom(a(i)).build());
        }
    }

    public static void b(FeedProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setId(a(str)).setType(a(str2)).setMode(a(str3)).build());
        }
    }

    public static FeedProtos.FollowLocation c(int i) {
        if (i != 2) {
            if (i == 10) {
                return FeedProtos.FollowLocation.FOLLOW_PLAZA_IMAGE;
            }
            if (i == 12) {
                return FeedProtos.FollowLocation.FOLLOW_FEED_LIKE;
            }
            if (i != 14) {
                if (i != 4) {
                    if (i != 5) {
                        if (i == 6) {
                            return FeedProtos.FollowLocation.FOLLOW_PLAZA_RECOMMEND_FEED;
                        }
                        if (i == 18) {
                            return FeedProtos.FollowLocation.UNKNOWN_FOLLOW_LOCATION;
                        }
                        if (i == 19) {
                            return FeedProtos.FollowLocation.FOLLOW_CITY_TIME;
                        }
                        if (i != 29 && i != 30) {
                            return null;
                        }
                    }
                    return FeedProtos.FollowLocation.FOLLOW_SUPER_TOPIC_FEED;
                }
                return FeedProtos.FollowLocation.FOLLOW_PLAZA_NEARBY;
            }
        }
        return FeedProtos.FollowLocation.FOLLOW_FEED_DETAIL_MORE;
    }

    public static FeedProtos.NoteType c(BluedIngSelfFeed bluedIngSelfFeed) {
        if (bluedIngSelfFeed != null) {
            if (bluedIngSelfFeed.is_posts_vote == 1) {
                return FeedProtos.NoteType.VOTE_TEXT;
            }
            if (bluedIngSelfFeed.is_markdown == 1) {
                return FeedProtos.NoteType.NOTE_MIX;
            }
            if (bluedIngSelfFeed.is_video_posts == 1) {
                return FeedProtos.NoteType.NOTE_VIDEO;
            }
        }
        return FeedProtos.NoteType.NOTE_COMMON;
    }

    public static void c(FeedProtos.Event event) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).build());
        }
    }

    public static void c(FeedProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setType(str).build());
        }
    }

    public static void c(FeedProtos.Event event, String str, int i) {
        String str2 = i == 4 ? "me" : i == 3 ? "fans" : i == 2 ? "follow" : i == 1 ? "follow_fans" : i == 0 ? "all" : b.dO;
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setFeedId(a(str)).setId(a(str2)).build());
        }
    }

    public static void c(FeedProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setLiveId(a(str2)).setTargetUid(a(str)).build());
        }
    }

    public static void c(FeedProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setFeedId(a(str)).setTargetUid(a(str2)).setId(a(str3)).build());
        }
    }

    public static FeedProtos.FeedPage d(int i) {
        FeedProtos.FeedPage feedPage = FeedProtos.FeedPage.UNKNOWN_FEED_PAGE;
        switch (i) {
            case 0:
                return FeedProtos.FeedPage.PLAZA_FOLLOW;
            case 1:
                return FeedProtos.FeedPage.PERSONAL_FEED;
            case 2:
            case 14:
                return FeedProtos.FeedPage.FEED_DETAIL_MORE;
            case 3:
            case 7:
            case 13:
            case 15:
            case 16:
            case 17:
            case 27:
            case 28:
            default:
                return FeedProtos.FeedPage.UNKNOWN_FEED_PAGE;
            case 4:
                return FeedProtos.FeedPage.PLAZA_NEARBY;
            case 5:
                return FeedProtos.FeedPage.SUPER_TOPIC_FEED;
            case 6:
                return FeedProtos.FeedPage.PLAZA_RECOMMEND;
            case 8:
                return FeedProtos.FeedPage.FLASH_DETAIL;
            case 9:
                return FeedProtos.FeedPage.PERSONAL_PHOTO;
            case 10:
                return FeedProtos.FeedPage.PLAZA_IMAGE;
            case 11:
                return FeedProtos.FeedPage.FEED_MINE;
            case 12:
                return FeedProtos.FeedPage.FEED_LIKE;
            case 18:
                return FeedProtos.FeedPage.PLAZA_HOT;
            case 19:
                return FeedProtos.FeedPage.CITY_TIME;
            case 20:
                return FeedProtos.FeedPage.FEED_IMAGE_FULL_SCREEN;
            case 21:
                return FeedProtos.FeedPage.PERSONAL_VIDEO_FULL_SCREEN;
            case 22:
                return FeedProtos.FeedPage.NOTICE_PAGE;
            case 23:
            case 24:
                return FeedProtos.FeedPage.INTERACTION_PAGE;
            case 25:
                return FeedProtos.FeedPage.ACTIVITY_DETAIL_EVALUATE;
            case 26:
                return FeedProtos.FeedPage.PUNCH_FEED_ALL;
            case 29:
                return FeedProtos.FeedPage.TOPIC_RECOMMEND;
            case 30:
                return FeedProtos.FeedPage.TOPIC_NEW;
        }
    }

    public static void d(FeedProtos.Event event) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setFeedPage(FeedProtos.FeedPage.PLAZA_NEARBY).build());
        }
    }

    public static void d(FeedProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setId(a(str)).build());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", a(str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ByteDanceLogUtils.a(event.name(), jSONObject);
        }
    }

    public static void d(FeedProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setCircleId(a(str)).setNoteId(a(str2)).build());
        }
    }

    public static PersonalProfileProtos.Source e(int i) {
        PersonalProfileProtos.Source source = PersonalProfileProtos.Source.UNKNOWN_FOLLOW_SOURCE;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 4) {
                        if (i != 5) {
                            if (i != 6) {
                                if (i != 8) {
                                    if (i != 14) {
                                        if (i != 19) {
                                            switch (i) {
                                                case 10:
                                                    return PersonalProfileProtos.Source.FIND_PLAZA_IMAGE;
                                                case 11:
                                                    return PersonalProfileProtos.Source.PAGE_FEED_MINE;
                                                case 12:
                                                    return PersonalProfileProtos.Source.PAGE_FEED_LIKE;
                                                default:
                                                    switch (i) {
                                                        case 27:
                                                            return PersonalProfileProtos.Source.PERSONAL_PHOTO;
                                                        case 28:
                                                            return PersonalProfileProtos.Source.PERSONAL_FEED;
                                                        case 29:
                                                            return PersonalProfileProtos.Source.TOPIC_RECOMMEND;
                                                        case 30:
                                                            return PersonalProfileProtos.Source.TOPIC_NEW;
                                                        default:
                                                            return source;
                                                    }
                                            }
                                        }
                                        return PersonalProfileProtos.Source.CITY_TIME;
                                    }
                                    return PersonalProfileProtos.Source.PAGE_FEED_DETAIL_MORE;
                                }
                                return PersonalProfileProtos.Source.FIND_PLAZA_FLASH;
                            }
                            return PersonalProfileProtos.Source.FIND_PLAZA_RECOMMEND;
                        }
                        return PersonalProfileProtos.Source.FIND_TOPIC_FEED;
                    }
                    return PersonalProfileProtos.Source.FIND_PLAZA_NEARBY;
                }
                return PersonalProfileProtos.Source.FEED_DETAIL;
            }
            return PersonalProfileProtos.Source.PERSONAL_VIDEO_FULL_SCREEN;
        }
        return PersonalProfileProtos.Source.FIND_PLAZA_FOLLOW;
    }

    public static void e(FeedProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setFeedId(a(str)).build());
        }
    }

    public static void e(FeedProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setCircleId(a(str)).setTargetUid(a(str2)).build());
        }
    }

    public static FeedProtos.SourcePage f(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 4) {
                        if (i != 5) {
                            if (i != 6) {
                                if (i != 8) {
                                    if (i != 14) {
                                        if (i != 29) {
                                            if (i != 30) {
                                                switch (i) {
                                                    case 10:
                                                        return FeedProtos.SourcePage.FEED_PLAZA_IMAGE;
                                                    case 11:
                                                        return FeedProtos.SourcePage.PAGE_FEED_MINE;
                                                    case 12:
                                                        return FeedProtos.SourcePage.PAGE_FEED_LIKE;
                                                    default:
                                                        switch (i) {
                                                            case 18:
                                                                return FeedProtos.SourcePage.FEED_PLAZA_HOT;
                                                            case 19:
                                                                return FeedProtos.SourcePage.FEED_CITY_TIME;
                                                            case 20:
                                                                return FeedProtos.SourcePage.FEED_IMAGE_FULL_SCREEN_SOURCE;
                                                            case 21:
                                                                return FeedProtos.SourcePage.PERSONAL_VIDEO_FULL_SCREEN_SOURCE;
                                                            case 22:
                                                                return FeedProtos.SourcePage.FEED_NOTICE_PAGE;
                                                            default:
                                                                return FeedProtos.SourcePage.UNKNOWN_SOURCE_PAGE;
                                                        }
                                                }
                                            }
                                            return FeedProtos.SourcePage.FEED_TOPIC_NEW;
                                        }
                                        return FeedProtos.SourcePage.FEED_TOPIC_RECOMMEND;
                                    }
                                    return FeedProtos.SourcePage.PAGE_FEED_DETAIL_MORE;
                                }
                                return FeedProtos.SourcePage.FEED_PLAZA_FLASH;
                            }
                            return FeedProtos.SourcePage.FEED_PLAZA_RECOMMEND;
                        }
                        return FeedProtos.SourcePage.FEED_SUPER_TOPIC_FEED;
                    }
                    return FeedProtos.SourcePage.FEED_PLAZA_NEARBY;
                }
                return FeedProtos.SourcePage.FEED_DETAIL_PAGE;
            }
            return FeedProtos.SourcePage.FEED_PERSONAL_FEED;
        }
        return FeedProtos.SourcePage.FEED_PLAZA_FOLLOW;
    }

    public static void f(FeedProtos.Event event, String str) {
        a(event, str, 0);
    }

    public static void f(FeedProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setCircleId(a(str)).setTargetUid(a(str2)).build());
        }
    }

    public static FeedProtos.SourcePage g(int i) {
        if (i != 4) {
            if (i == 6) {
                return FeedProtos.SourcePage.PLAZA_RECOMMEND_NOTE_SHARE;
            }
            if (i == 15) {
                return FeedProtos.SourcePage.NOTE_DETAIL_SHARE;
            }
            if (i != 19) {
                return FeedProtos.SourcePage.UNKNOWN_SOURCE_PAGE;
            }
        }
        return FeedProtos.SourcePage.CITY_NOTE_PAGE;
    }

    public static void g(FeedProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setKeyword(a(str)).build());
        }
    }

    public static void g(FeedProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setCircleId(a(str)).setNoteId(a(str2)).build());
        }
    }

    public static FeedProtos.SourcePage h(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 4) {
                    if (i == 5) {
                        return FeedProtos.SourcePage.FEED_SUPER_TOPIC_FEED_DETAIL;
                    }
                    if (i == 6) {
                        return FeedProtos.SourcePage.FEED_PLAZA_RECOMMEND_DETAIL;
                    }
                    if (i == 8) {
                        return FeedProtos.SourcePage.FEED_PLAZA_FLASH_DETAIL;
                    }
                    if (i == 10) {
                        return FeedProtos.SourcePage.FEED_PLAZA_IMAGE_DETAIL;
                    }
                    if (i == 18) {
                        return FeedProtos.SourcePage.FEED_PLAZA_HOT;
                    }
                    if (i != 19) {
                        return i != 29 ? i != 30 ? f(i) : FeedProtos.SourcePage.FEED_TOPIC_NEW : FeedProtos.SourcePage.FEED_TOPIC_RECOMMEND;
                    }
                }
                return FeedProtos.SourcePage.FEED_PLAZA_NEARBY_DETAIL;
            }
            return FeedProtos.SourcePage.FEED_PERSONAL_FEED_DETAIL;
        }
        return FeedProtos.SourcePage.FEED_PLAZA_FOLLOW_DETAIL;
    }

    public static void h(FeedProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setCircleId(a(str)).build());
        }
    }

    public static void h(FeedProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setId(a(str)).setImageId(a(str2)).build());
        }
    }

    public static FeedProtos.UserType i(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? FeedProtos.UserType.UNKNOWN_USER_TYPE : FeedProtos.UserType.CIRCLE_NOT_MEMBER : FeedProtos.UserType.VICE_CAPTAIN : FeedProtos.UserType.CIRCLE_CAPTAIN : FeedProtos.UserType.COMMON_USER;
    }

    public static void i(FeedProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setType(a(str)).build());
        }
    }

    public static void i(FeedProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setId(a(str)).setLinkUrl(a(str2)).build());
        }
    }

    public static FeedProtos.NoteSource j(int i) {
        return i != 1 ? i != 4 ? i != 6 ? i != 19 ? FeedProtos.NoteSource.UNKNOWN_NOTE_SOURCE : FeedProtos.NoteSource.CITY_TIME_NOTE : FeedProtos.NoteSource.CIRCLE_RECOMMEND_LIST : FeedProtos.NoteSource.CITY_NOTE : FeedProtos.NoteSource.PERSONAL_PROFILE;
    }

    public static void j(FeedProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setId(a(str)).build());
        }
    }

    public static void j(FeedProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setLinkUrl(a(str)).setId(a(str2)).build());
        }
    }

    public static FeedProtos.CircleSource k(int i) {
        FeedProtos.CircleSource circleSource = FeedProtos.CircleSource.UNKNOWN_CIRCLE_SOURCE;
        if (i != 1) {
            if (i != 4) {
                if (i == 6) {
                    return FeedProtos.CircleSource.PLAZA_RECOMMEND_NOTE;
                }
                if (i != 19) {
                    return circleSource;
                }
            }
            return FeedProtos.CircleSource.CITY_NOTE_CIRCLE;
        }
        return FeedProtos.CircleSource.PERSONAL_PROFILE_CIRCLE;
    }

    public static void k(FeedProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setTargetUid(a(str)).build());
        }
    }

    public static void k(FeedProtos.Event event, String str, String str2) {
        b(event, str, str2, 0);
    }

    public static int l(int i) {
        return a(0, i);
    }

    public static void l(FeedProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setId(a(str)).build());
        }
    }

    public static void l(FeedProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setQaId(a(str)).setTopicId(a(str2)).build());
        }
    }

    private static FeedProtos.CircleSource m(int i) {
        return i != 1 ? FeedProtos.CircleSource.UNKNOWN_CIRCLE_SOURCE : FeedProtos.CircleSource.CIRCLE_HOT_POST;
    }

    public static void m(FeedProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setDescId(a(str)).build());
        }
    }

    private static String n(int i) {
        return i != 0 ? i != 4 ? i != 6 ? i != 19 ? "" : "city_time" : "plaza_recommend" : "city_all" : "plaza_follow";
    }

    public static void n(FeedProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(FeedProtos.FeedProto.newBuilder().setEvent(event).setId(a(str)).build());
        }
    }
}

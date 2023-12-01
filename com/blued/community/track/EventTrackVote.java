package com.blued.community.track;

import com.blued.community.model.BluedIngSelfFeed;
import com.blued.das.client.vote.VoteProtos;
import com.blued.track.trackUtils.EventTrackUtils;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/track/EventTrackVote.class */
public class EventTrackVote {
    public static VoteProtos.FeedPage a(int i) {
        VoteProtos.FeedPage feedPage = VoteProtos.FeedPage.UNKNOWN_FEED_PAGE;
        if (i != 1) {
            if (i != 2) {
                if (i == 4) {
                    return VoteProtos.FeedPage.PLAZA_NEARBY;
                }
                if (i == 6) {
                    return VoteProtos.FeedPage.PLAZA_RECOMMEND;
                }
                if (i != 14) {
                    return i != 19 ? VoteProtos.FeedPage.UNKNOWN_FEED_PAGE : VoteProtos.FeedPage.CITY_TIME;
                }
            }
            return VoteProtos.FeedPage.FEED_DETAIL_MORE;
        }
        return VoteProtos.FeedPage.PERSONAL_FEED;
    }

    private static String a(String str) {
        return EventTrackUtils.a(str);
    }

    public static void a(VoteProtos.Event event) {
        if (event != null) {
            EventTrackUtils.a(VoteProtos.VoteProto.newBuilder().setEvent(event).build());
        }
    }

    public static void a(VoteProtos.Event event, BluedIngSelfFeed bluedIngSelfFeed, VoteProtos.PhotoOption photoOption, int i) {
        if (event == null || photoOption == null || bluedIngSelfFeed == null) {
            return;
        }
        EventTrackUtils.a(VoteProtos.VoteProto.newBuilder().setEvent(event).setPhotoOption(photoOption).setTargetUid(a(bluedIngSelfFeed.feed_uid)).setFeedId(a(bluedIngSelfFeed.feed_id)).setFeedPage(a(i)).build());
    }

    public static void a(VoteProtos.Event event, VoteProtos.FeedType feedType) {
        if (event == null || feedType == null) {
            return;
        }
        EventTrackUtils.a(VoteProtos.VoteProto.newBuilder().setEvent(event).setFeedType(feedType).build());
    }

    public static void a(VoteProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(VoteProtos.VoteProto.newBuilder().setEvent(event).setTargetUid(a(str)).setFeedId(a(str2)).build());
        }
    }
}

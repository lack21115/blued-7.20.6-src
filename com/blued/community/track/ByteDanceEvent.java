package com.blued.community.track;

import com.anythink.expressad.a;
import com.anythink.expressad.foundation.d.l;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.das.client.feed.FeedProtos;
import com.blued.track.bytedance.ByteDanceLogUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/track/ByteDanceEvent.class */
public final class ByteDanceEvent {

    /* renamed from: a  reason: collision with root package name */
    public static final ByteDanceEvent f19111a = new ByteDanceEvent();

    private ByteDanceEvent() {
    }

    @JvmStatic
    public static final void a(String name, int i, int i2) {
        Intrinsics.e(name, "name");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(l.d, i);
            jSONObject.put(a.g, i2);
            a(name, jSONObject);
        } catch (Exception e) {
        }
    }

    @JvmStatic
    public static final void a(String name, BluedIngSelfFeed data, FeedProtos.FeedPage page) {
        Intrinsics.e(name, "name");
        Intrinsics.e(data, "data");
        Intrinsics.e(page, "page");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("feed_page", page.name());
            if (data.getItemType() == 16) {
                jSONObject.put("feed_class", "FEED_LIVE");
            } else if (Intrinsics.a((Object) data.is_videos, (Object) "1")) {
                jSONObject.put("feed_class", "FEED_VIDEO");
            } else {
                if (data.feed_pics != null) {
                    String[] strArr = data.feed_pics;
                    Intrinsics.c(strArr, "data.feed_pics");
                    if (!(strArr.length == 0)) {
                        jSONObject.put("feed_class", "FEED_IMAGE");
                    }
                }
                jSONObject.put("feed_class", "FEED_WORD");
            }
            jSONObject.put("type", data.strong_insert_data);
            jSONObject.put("feed_id", data.feed_id);
            a(name, jSONObject);
        } catch (Exception e) {
        }
    }

    @JvmStatic
    public static final void a(String name, FeedProtos.FeedPage feedPage) {
        Intrinsics.e(name, "name");
        Intrinsics.e(feedPage, "feedPage");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("feed_page", feedPage.name());
            a(name, jSONObject);
        } catch (Exception e) {
        }
    }

    @JvmStatic
    public static final void a(String name, FeedProtos.NoteSource noteSource) {
        Intrinsics.e(name, "name");
        Intrinsics.e(noteSource, "noteSource");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("note_source", noteSource.name());
            a(name, jSONObject);
        } catch (Exception e) {
        }
    }

    @JvmStatic
    public static final void a(String name, JSONObject json) {
        Intrinsics.e(name, "name");
        Intrinsics.e(json, "json");
        ByteDanceLogUtils.a(name, json);
    }
}

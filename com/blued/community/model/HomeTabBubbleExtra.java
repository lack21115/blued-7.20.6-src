package com.blued.community.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/model/HomeTabBubbleExtra.class */
public final class HomeTabBubbleExtra extends BluedEntityBaseExtra {
    public int adv_activity_id;
    public String double_click_feed_avatar;
    private int double_click_feed_id;
    private int double_click_feed_uid;
    public int extra_activity_id;
    public String extra_bubble_id;
    public String extra_bubble_img;
    public String extra_bubble_text;
    public int extra_bubble_type;
    public String predestined_person_feed_ttids;
    public String predestined_person_feed_uids;

    public final int getDouble_click_feed_id() {
        return this.double_click_feed_id;
    }

    public final int getDouble_click_feed_uid() {
        return this.double_click_feed_uid;
    }

    public final void setDouble_click_feed_id(int i) {
        this.double_click_feed_id = i;
    }

    public final void setDouble_click_feed_uid(int i) {
        this.double_click_feed_uid = i;
    }
}

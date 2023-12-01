package com.blued.community.ui.square.model;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.utils.CommunityPreferences;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/model/DiscoverSquareExtra.class */
public class DiscoverSquareExtra extends BluedEntityBaseExtra {
    public List<Explore> explore_list;
    public String super_num;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/model/DiscoverSquareExtra$Explore.class */
    public static class Explore {
        private String a_label;
        @SerializedName("name")
        public int index;
        private String label;
        public String png;
        private String title;
        public String url;
        private String usedCorner;
        public int loop = 1;
        private String usedCornerType = "png";

        public Explore(int i) {
            this.index = i;
        }

        public String getApngSpCountStr() {
            return "DiscoverEntryApngShowCount_" + this.index;
        }

        public String getCornerImg() {
            if (TextUtils.isEmpty(this.usedCorner)) {
                if (!TextUtils.isEmpty(this.a_label) && !this.a_label.equalsIgnoreCase(CommunityPreferences.y(getApngSpCountStr()))) {
                    CommunityPreferences.a(getApngSpCountStr(), 0);
                }
                if (TextUtils.isEmpty(this.a_label) || CommunityPreferences.v(getApngSpCountStr()) >= 2) {
                    this.usedCorner = this.label;
                    this.usedCornerType = "png";
                } else {
                    this.usedCorner = this.a_label;
                    this.usedCornerType = "apng";
                    CommunityPreferences.c(getApngSpCountStr(), this.a_label);
                }
            }
            return this.usedCorner;
        }

        public String getCornerType() {
            return this.usedCornerType;
        }

        public String getName() {
            if (TextUtils.isEmpty(this.title)) {
                int i = 0;
                int i2 = this.index;
                if (i2 == 1) {
                    i = R.string.base;
                } else if (i2 == 2) {
                    i = CommunityServiceManager.a().D() == 1 ? R.string.subject_title : R.string.super_topic;
                } else if (i2 == 4) {
                    i = R.string.post_shine_video;
                } else if (i2 == 5) {
                    i = R.string.image_feed;
                } else if (i2 == 6) {
                    i = R.string.yy_chat_rooms;
                } else if (i2 == 7) {
                    i = R.string.hot_feed;
                }
                return i != 0 ? AppInfo.d().getString(i) : "";
            }
            return this.title;
        }

        public void resetCornerImg() {
            this.usedCorner = null;
            this.usedCornerType = null;
        }
    }

    public static List<Explore> getDefaultExplores() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Explore(1));
        arrayList.add(new Explore(2));
        arrayList.add(new Explore(4));
        return arrayList;
    }
}

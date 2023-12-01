package com.soft.blued.ui.find.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/VisitorCountExtra.class */
public class VisitorCountExtra extends BluedEntityBaseExtra {
    public long history;
    public List<_history_track> history_track;
    public long increase;
    public String label;
    public int new_user;
    public UserData often_see_you;
    public int ratio;
    public UserData seen_each_other;
    public int show_shadow_btn;
    public long today;
    public int visitors_is_complete_rate;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/VisitorCountExtra$UserData.class */
    public class UserData {
        public String avatar;
        public String times;
        public String uid;

        public UserData() {
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/VisitorCountExtra$_history_track.class */
    public static class _history_track {
        public long count;
        public String date;
    }
}

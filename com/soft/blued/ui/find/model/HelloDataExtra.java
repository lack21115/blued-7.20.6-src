package com.soft.blued.ui.find.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/HelloDataExtra.class */
public class HelloDataExtra extends BluedEntityBaseExtra {
    public String main_title;
    public float multiples;
    public int promote_person_num;
    public int show_call_btn;
    public String subheading;
    public int table_type;
    public List<UserFindResult> top_data;
    public int total_call_num;
    public int view_type;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/HelloDataExtra$MsgHelloType.class */
    public interface MsgHelloType {
        public static final int DATA = 2;
        public static final int USER = 1;
    }
}

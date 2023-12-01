package com.soft.blued.ui.find.model;

import java.io.Serializable;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/CallMeStatusData.class */
public class CallMeStatusData implements Serializable {
    public String button;
    public String button_top;
    public int call_status;
    public int call_type;
    public int countdown;
    public String free_bubble;
    public int free_count;
    public int is_quietly;
    public float multiples;
    public int pay_count;
    public int promote_person_num;
    public List<Visitor> visitors;
    public int visits;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/CallMeStatusData$Visitor.class */
    public static class Visitor implements Serializable {
        public String avatar;
    }
}

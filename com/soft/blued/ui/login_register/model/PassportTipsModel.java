package com.soft.blued.ui.login_register.model;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/model/PassportTipsModel.class */
public class PassportTipsModel {
    public String tips = "";
    public int is_open_dialog = -1;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/model/PassportTipsModel$TIPS_STATUS.class */
    public interface TIPS_STATUS {
        public static final int CLOSE = 0;
        public static final int OPEN = 1;
        public static final int UNDECIDE = -1;
    }
}

package com.soft.blued.ui.login_register.model;

import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/model/UpdateTerms.class */
public class UpdateTerms {
    public List<Button> button;
    public String description;
    public int is_open;
    public List<Link> jump_links;
    public String title;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/model/UpdateTerms$Button.class */
    public static class Button {
        public int click_type;
        public String click_url;
        public String text;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/model/UpdateTerms$Link.class */
    public static class Link {
        public String link;
        public String text;
    }
}

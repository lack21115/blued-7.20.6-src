package com.soft.blued.ui.msg.model;

import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/MsgExtraForTextTypeEntity.class */
public class MsgExtraForTextTypeEntity {
    public String activity_work_id;
    public String htmlContent;
    public MsgSourceEntity msgSource;
    public String quote;
    public String quote_seqnum;
    public SecureNotify secureNotify;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/MsgExtraForTextTypeEntity$SecureNotify.class */
    public static class SecureNotify {
        public String collapse_desc;
        public String collapse_desc_en_us;
        public String collapse_desc_zh_cn;
        public String collapse_desc_zh_tw;
        public String contents;
        public String contents_en_us;
        public String contents_zh_cn;
        public String contents_zh_tw;
        public List<String> highlight_keywords;
        public List<String> highlight_keywords_en_us;
        public List<String> highlight_keywords_zh_cn;
        public List<String> highlight_keywords_zh_tw;
        public String icon;
        public String link;
        public String link_title;
        public String link_title_en_us;
        public String link_title_zh_cn;
        public String link_title_zh_tw;
        public List<SecureContent> multi_contents;
        public List<SecureContent> multi_contents_en_us;
        public List<SecureContent> multi_contents_zh_cn;
        public List<SecureContent> multi_contents_zh_tw;
        public int notify_type;
        public String report_title;
        public String report_title_en_us;
        public String report_title_zh_cn;
        public String report_title_zh_tw;
        public String title;
        public String title_en_us;
        public String title_zh_cn;
        public String title_zh_tw;

        /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/MsgExtraForTextTypeEntity$SecureNotify$SecureContent.class */
        public static class SecureContent {
            public String background_link;
            public String body;
            public String link;
            public String link_title;
            public String title;
        }
    }
}

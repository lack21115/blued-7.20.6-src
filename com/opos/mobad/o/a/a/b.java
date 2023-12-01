package com.opos.mobad.o.a.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/a/a/b.class */
public enum b {
    TAG_REPEAT_CONTENT(0, "重复展示"),
    TAG_LOW_QUALITY_CONTENT(1, "内容质量低"),
    TAG_LOW_RELATIVE_CONTENT(2, "与我相关性低"),
    TAG_VULGAR_CONTENT(3, "内容低俗"),
    TAG_FAKE_CONTENT(4, "内容虚假"),
    TAG_AFFECT_OPERATION_CONTENT(5, "影响操作"),
    TAG_INDUCE_CLICK_CONTENT(6, "诱导点击"),
    TAG_OTHER_CONTENT(7, "其他反馈事项"),
    TAG_CANNOT_CLOSE(8, "无法关闭"),
    TAG_DISPLAY_EXCEPTION(9, "内容展示异常（黑屏/卡顿）");
    
    private int k;
    private String l;

    b(int i, String str) {
        this.k = i;
        this.l = str;
    }

    public int a() {
        return this.k;
    }

    public String b() {
        return this.l;
    }
}

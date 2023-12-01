package com.igexin.sdk.message;

import android.text.TextUtils;
import com.igexin.sdk.Tag;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/sdk/message/QueryTagCmdMessage.class */
public class QueryTagCmdMessage extends GTCmdMessage {
    private String code;
    private String sn;
    private Tag[] tags;

    public QueryTagCmdMessage(String str, String str2, String str3, int i) {
        super(i);
        this.sn = str;
        this.code = str2;
        if (TextUtils.isEmpty(str3) || str3.equals("none")) {
            return;
        }
        String[] split = str3.split(" ");
        Tag[] tagArr = new Tag[split.length];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= split.length) {
                this.tags = tagArr;
                return;
            }
            Tag tag = new Tag();
            tag.setName(split[i3]);
            tagArr[i3] = tag;
            i2 = i3 + 1;
        }
    }

    public String getCode() {
        return this.code;
    }

    public String getSn() {
        return this.sn;
    }

    public Tag[] getTags() {
        return this.tags;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setSn(String str) {
        this.sn = str;
    }

    public void setTags(Tag[] tagArr) {
        this.tags = tagArr;
    }
}

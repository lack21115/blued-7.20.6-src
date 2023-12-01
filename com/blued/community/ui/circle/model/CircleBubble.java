package com.blued.community.ui.circle.model;

import android.text.TextUtils;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import java.io.Serializable;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/model/CircleBubble.class */
public class CircleBubble extends BluedEntityBaseExtra implements Serializable {
    private static final long serialVersionUID = 1;
    public String bubbleId;
    public String bubble_code;
    public String img;
    public String link;
    public String title;

    public String getMarkDownLink() {
        if (TextUtils.isEmpty(this.title)) {
            return "";
        }
        if (TextUtils.isEmpty(this.link)) {
            return this.title;
        }
        return "[" + this.title + "](" + this.link + ")";
    }
}

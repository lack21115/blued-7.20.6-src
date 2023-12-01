package com.blued.community.widget.vote.text.model;

import java.io.Serializable;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/widget/vote/text/model/CircleTextVote.class */
public class CircleTextVote implements Serializable {
    private static final long serialVersionUID = 1;
    public int count;
    public String option;
    public boolean select = false;

    public CircleTextVote() {
    }

    public CircleTextVote(String str) {
        this.option = str;
    }
}

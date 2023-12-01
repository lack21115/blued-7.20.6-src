package com.soft.blued.ui.msg.model;

import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/MsgContentTranslatedEntity.class */
public class MsgContentTranslatedEntity {
    public String from;
    public String to;
    public List<TranslateResult> trans_result;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/MsgContentTranslatedEntity$TranslateResult.class */
    public class TranslateResult {
        public String dst;
        public String src;

        public TranslateResult() {
        }
    }
}

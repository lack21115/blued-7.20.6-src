package com.tencent.cos.xml.model.tag;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/IntelligentTieringConfiguration.class */
public class IntelligentTieringConfiguration {
    public String status;
    public Transition transition;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/IntelligentTieringConfiguration$Transition.class */
    public static class Transition {
        public int days;
        public int requestFrequent;
    }

    public IntelligentTieringConfiguration() {
    }

    public IntelligentTieringConfiguration(String str, int i) {
        this.status = str;
        Transition transition = new Transition();
        this.transition = transition;
        transition.days = i;
        this.transition.requestFrequent = 1;
    }
}

package com.tencent.cos.xml.model.tag;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/RestoreConfigure.class */
public class RestoreConfigure {
    public CASJobParameters casJobParameters;
    public int days;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/RestoreConfigure$CASJobParameters.class */
    public static class CASJobParameters {
        public String tier = Tier.Standard.getTier();

        public String toString() {
            return "{CASJobParameters:\nTier:" + this.tier + "\n}";
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/RestoreConfigure$Tier.class */
    public enum Tier {
        Expedited("Expedited"),
        Standard("Standard"),
        Bulk("Bulk");
        
        private String tier;

        Tier(String str) {
            this.tier = str;
        }

        public String getTier() {
            return this.tier;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{RestoreRequest:\n");
        sb.append("Days:");
        sb.append(this.days);
        sb.append("\n");
        CASJobParameters cASJobParameters = this.casJobParameters;
        if (cASJobParameters != null) {
            sb.append(cASJobParameters.toString());
            sb.append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}

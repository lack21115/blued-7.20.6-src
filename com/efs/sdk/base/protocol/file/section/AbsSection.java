package com.efs.sdk.base.protocol.file.section;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/protocol/file/section/AbsSection.class */
public abstract class AbsSection {
    public static final String SEP_LINE_BREAK = "linebreak";
    public static final String SEP_ORIGIN_LINE_BREAK = "\n";
    String type;
    String name = "";
    String version = "1.0";
    String sep = "";

    public AbsSection(String str) {
        this.type = str;
    }

    public abstract String changeToStr();

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getDeclarationLine() {
        return "section:" + this.name + "," + this.type + "," + this.version + "," + this.sep;
    }

    public void setSep(String str) {
        if (str.equals("\n")) {
            this.sep = SEP_LINE_BREAK;
        } else {
            this.sep = str;
        }
    }
}

package com.efs.sdk.base.protocol.file.section;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/protocol/file/section/JSONSection.class */
public class JSONSection extends AbsSection {
    private String body;

    public JSONSection(String str) {
        super("json");
        this.name = str;
    }

    @Override // com.efs.sdk.base.protocol.file.section.AbsSection
    public String changeToStr() {
        return getDeclarationLine() + "\n" + this.body + "\n";
    }

    public void setBody(String str) {
        this.body = str;
    }
}

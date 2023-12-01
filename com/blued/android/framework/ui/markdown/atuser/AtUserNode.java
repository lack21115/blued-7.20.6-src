package com.blued.android.framework.ui.markdown.atuser;

import org.commonmark.node.CustomNode;
import org.commonmark.node.Delimited;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/markdown/atuser/AtUserNode.class */
public class AtUserNode extends CustomNode implements Delimited {
    private final String a;
    private final String b;

    public AtUserNode(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public String a() {
        return this.a;
    }

    public String p_() {
        return this.b;
    }

    @Override // org.commonmark.node.Node
    public String toString() {
        return "AtUserNode {userName='" + this.a + "', userId='" + this.b + "'}";
    }
}

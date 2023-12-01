package org.apache.harmony.xml.dom;

import org.w3c.dom.Comment;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/dom/CommentImpl.class */
public final class CommentImpl extends CharacterDataImpl implements Comment {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CommentImpl(DocumentImpl documentImpl, String str) {
        super(documentImpl, str);
    }

    public boolean containsDashDash() {
        return this.buffer.indexOf("--") != -1;
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public String getNodeName() {
        return "#comment";
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public short getNodeType() {
        return (short) 8;
    }
}

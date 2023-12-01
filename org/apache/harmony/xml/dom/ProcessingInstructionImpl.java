package org.apache.harmony.xml.dom;

import org.w3c.dom.DOMException;
import org.w3c.dom.ProcessingInstruction;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/dom/ProcessingInstructionImpl.class */
public final class ProcessingInstructionImpl extends LeafNodeImpl implements ProcessingInstruction {
    private String data;
    private String target;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProcessingInstructionImpl(DocumentImpl documentImpl, String str, String str2) {
        super(documentImpl);
        this.target = str;
        this.data = str2;
    }

    @Override // org.w3c.dom.ProcessingInstruction
    public String getData() {
        return this.data;
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public String getNodeName() {
        return this.target;
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public short getNodeType() {
        return (short) 7;
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public String getNodeValue() {
        return this.data;
    }

    @Override // org.w3c.dom.ProcessingInstruction
    public String getTarget() {
        return this.target;
    }

    @Override // org.w3c.dom.ProcessingInstruction
    public void setData(String str) throws DOMException {
        this.data = str;
    }
}

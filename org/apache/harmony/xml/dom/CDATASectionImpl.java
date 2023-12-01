package org.apache.harmony.xml.dom;

import com.j256.ormlite.stmt.query.SimpleComparison;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Node;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/dom/CDATASectionImpl.class */
public final class CDATASectionImpl extends TextImpl implements CDATASection {
    public CDATASectionImpl(DocumentImpl documentImpl, String str) {
        super(documentImpl, str);
    }

    @Override // org.apache.harmony.xml.dom.TextImpl, org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public String getNodeName() {
        return "#cdata-section";
    }

    @Override // org.apache.harmony.xml.dom.TextImpl, org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public short getNodeType() {
        return (short) 4;
    }

    public boolean needsSplitting() {
        return this.buffer.indexOf("]]>") != -1;
    }

    public TextImpl replaceWithText() {
        TextImpl textImpl = new TextImpl(this.document, getData());
        this.parent.insertBefore(textImpl, this);
        this.parent.removeChild(this);
        return textImpl;
    }

    public void split() {
        if (!needsSplitting()) {
            return;
        }
        Node parentNode = getParentNode();
        String[] split = getData().split("\\]\\]>");
        parentNode.insertBefore(new CDATASectionImpl(this.document, split[0] + "]]"), this);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= split.length - 1) {
                setData(SimpleComparison.GREATER_THAN_OPERATION + split[split.length - 1]);
                return;
            } else {
                parentNode.insertBefore(new CDATASectionImpl(this.document, SimpleComparison.GREATER_THAN_OPERATION + split[i2] + "]]"), this);
                i = i2 + 1;
            }
        }
    }
}

package org.apache.harmony.xml.dom;

import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/dom/TextImpl.class */
public class TextImpl extends CharacterDataImpl implements Text {
    public TextImpl(DocumentImpl documentImpl, String str) {
        super(documentImpl, str);
    }

    private TextImpl firstTextNodeInCurrentRun() {
        short nodeType;
        TextImpl textImpl = this;
        Node previousSibling = getPreviousSibling();
        while (true) {
            Node node = previousSibling;
            if (node == null || !((nodeType = node.getNodeType()) == 3 || nodeType == 4)) {
                break;
            }
            textImpl = (TextImpl) node;
            previousSibling = node.getPreviousSibling();
        }
        return textImpl;
    }

    private TextImpl nextTextNode() {
        Node nextSibling = getNextSibling();
        if (nextSibling == null) {
            return null;
        }
        short nodeType = nextSibling.getNodeType();
        return (nodeType == 3 || nodeType == 4) ? (TextImpl) nextSibling : null;
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public String getNodeName() {
        return "#text";
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public short getNodeType() {
        return (short) 3;
    }

    @Override // org.w3c.dom.Text
    public final String getWholeText() {
        StringBuilder sb = new StringBuilder();
        TextImpl firstTextNodeInCurrentRun = firstTextNodeInCurrentRun();
        while (true) {
            TextImpl textImpl = firstTextNodeInCurrentRun;
            if (textImpl == null) {
                return sb.toString();
            }
            textImpl.appendDataTo(sb);
            firstTextNodeInCurrentRun = textImpl.nextTextNode();
        }
    }

    @Override // org.w3c.dom.Text
    public final boolean isElementContentWhitespace() {
        return false;
    }

    public final TextImpl minimize() {
        if (getLength() == 0) {
            this.parent.removeChild(this);
            return null;
        }
        Node previousSibling = getPreviousSibling();
        if (previousSibling == null || previousSibling.getNodeType() != 3) {
            return this;
        }
        TextImpl textImpl = (TextImpl) previousSibling;
        textImpl.buffer.append(this.buffer);
        this.parent.removeChild(this);
        return textImpl;
    }

    @Override // org.w3c.dom.Text
    public final Text replaceWholeText(String str) throws DOMException {
        Node parentNode = getParentNode();
        TextImpl textImpl = null;
        TextImpl firstTextNodeInCurrentRun = firstTextNodeInCurrentRun();
        while (true) {
            TextImpl textImpl2 = firstTextNodeInCurrentRun;
            if (textImpl2 == null) {
                return textImpl;
            }
            if (textImpl2 != this || str == null || str.length() <= 0) {
                TextImpl nextTextNode = textImpl2.nextTextNode();
                parentNode.removeChild(textImpl2);
                firstTextNodeInCurrentRun = nextTextNode;
            } else {
                setData(str);
                textImpl = this;
                firstTextNodeInCurrentRun = textImpl2.nextTextNode();
            }
        }
    }

    @Override // org.w3c.dom.Text
    public final Text splitText(int i) throws DOMException {
        TextImpl createTextNode = this.document.createTextNode(substringData(i, getLength() - i));
        deleteData(0, i);
        Node nextSibling = getNextSibling();
        if (nextSibling == null) {
            getParentNode().appendChild(createTextNode);
            return this;
        }
        getParentNode().insertBefore(createTextNode, nextSibling);
        return this;
    }
}

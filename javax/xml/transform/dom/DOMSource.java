package javax.xml.transform.dom;

import javax.xml.transform.Source;
import org.w3c.dom.Node;

/* loaded from: source-2895416-dex2jar.jar:javax/xml/transform/dom/DOMSource.class */
public class DOMSource implements Source {
    public static final String FEATURE = "http://javax.xml.transform.dom.DOMSource/feature";
    private Node node;
    private String systemID;

    public DOMSource() {
    }

    public DOMSource(Node node) {
        setNode(node);
    }

    public DOMSource(Node node, String str) {
        setNode(node);
        setSystemId(str);
    }

    public Node getNode() {
        return this.node;
    }

    @Override // javax.xml.transform.Source
    public String getSystemId() {
        return this.systemID;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    @Override // javax.xml.transform.Source
    public void setSystemId(String str) {
        this.systemID = str;
    }
}

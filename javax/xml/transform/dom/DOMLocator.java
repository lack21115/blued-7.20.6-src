package javax.xml.transform.dom;

import javax.xml.transform.SourceLocator;
import org.w3c.dom.Node;

/* loaded from: source-2895416-dex2jar.jar:javax/xml/transform/dom/DOMLocator.class */
public interface DOMLocator extends SourceLocator {
    Node getOriginatingNode();
}

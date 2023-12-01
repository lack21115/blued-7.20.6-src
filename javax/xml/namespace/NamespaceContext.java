package javax.xml.namespace;

import java.util.Iterator;

/* loaded from: source-2895416-dex2jar.jar:javax/xml/namespace/NamespaceContext.class */
public interface NamespaceContext {
    String getNamespaceURI(String str);

    String getPrefix(String str);

    Iterator getPrefixes(String str);
}

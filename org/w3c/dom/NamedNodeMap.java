package org.w3c.dom;

/* loaded from: source-2895416-dex2jar.jar:org/w3c/dom/NamedNodeMap.class */
public interface NamedNodeMap {
    int getLength();

    Node getNamedItem(String str);

    Node getNamedItemNS(String str, String str2) throws DOMException;

    Node item(int i);

    Node removeNamedItem(String str) throws DOMException;

    Node removeNamedItemNS(String str, String str2) throws DOMException;

    Node setNamedItem(Node node) throws DOMException;

    Node setNamedItemNS(Node node) throws DOMException;
}

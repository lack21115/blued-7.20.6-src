package org.w3c.dom.ls;

import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;

/* loaded from: source-2895416-dex2jar.jar:org/w3c/dom/ls/LSSerializer.class */
public interface LSSerializer {
    DOMConfiguration getDomConfig();

    LSSerializerFilter getFilter();

    String getNewLine();

    void setFilter(LSSerializerFilter lSSerializerFilter);

    void setNewLine(String str);

    boolean write(Node node, LSOutput lSOutput) throws LSException;

    String writeToString(Node node) throws DOMException, LSException;

    boolean writeToURI(Node node, String str) throws LSException;
}

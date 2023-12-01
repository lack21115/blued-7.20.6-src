package org.w3c.dom;

/* loaded from: source-2895416-dex2jar.jar:org/w3c/dom/DOMLocator.class */
public interface DOMLocator {
    int getByteOffset();

    int getColumnNumber();

    int getLineNumber();

    Node getRelatedNode();

    String getUri();

    int getUtf16Offset();
}

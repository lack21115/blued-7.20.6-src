package org.w3c.dom;

/* loaded from: source-2895416-dex2jar.jar:org/w3c/dom/DocumentType.class */
public interface DocumentType extends Node {
    NamedNodeMap getEntities();

    String getInternalSubset();

    String getName();

    NamedNodeMap getNotations();

    String getPublicId();

    String getSystemId();
}

package org.w3c.dom;

/* loaded from: source-2895416-dex2jar.jar:org/w3c/dom/DOMImplementation.class */
public interface DOMImplementation {
    Document createDocument(String str, String str2, DocumentType documentType) throws DOMException;

    DocumentType createDocumentType(String str, String str2, String str3) throws DOMException;

    Object getFeature(String str, String str2);

    boolean hasFeature(String str, String str2);
}

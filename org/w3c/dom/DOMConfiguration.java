package org.w3c.dom;

/* loaded from: source-2895416-dex2jar.jar:org/w3c/dom/DOMConfiguration.class */
public interface DOMConfiguration {
    boolean canSetParameter(String str, Object obj);

    Object getParameter(String str) throws DOMException;

    DOMStringList getParameterNames();

    void setParameter(String str, Object obj) throws DOMException;
}

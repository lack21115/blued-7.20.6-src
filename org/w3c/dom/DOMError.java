package org.w3c.dom;

/* loaded from: source-2895416-dex2jar.jar:org/w3c/dom/DOMError.class */
public interface DOMError {
    public static final short SEVERITY_ERROR = 2;
    public static final short SEVERITY_FATAL_ERROR = 3;
    public static final short SEVERITY_WARNING = 1;

    DOMLocator getLocation();

    String getMessage();

    Object getRelatedData();

    Object getRelatedException();

    short getSeverity();

    String getType();
}

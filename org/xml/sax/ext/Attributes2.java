package org.xml.sax.ext;

import org.xml.sax.Attributes;

/* loaded from: source-2895416-dex2jar.jar:org/xml/sax/ext/Attributes2.class */
public interface Attributes2 extends Attributes {
    boolean isDeclared(int i);

    boolean isDeclared(String str);

    boolean isDeclared(String str, String str2);

    boolean isSpecified(int i);

    boolean isSpecified(String str);

    boolean isSpecified(String str, String str2);
}

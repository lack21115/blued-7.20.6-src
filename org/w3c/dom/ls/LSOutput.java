package org.w3c.dom.ls;

import java.io.OutputStream;
import java.io.Writer;

/* loaded from: source-2895416-dex2jar.jar:org/w3c/dom/ls/LSOutput.class */
public interface LSOutput {
    OutputStream getByteStream();

    Writer getCharacterStream();

    String getEncoding();

    String getSystemId();

    void setByteStream(OutputStream outputStream);

    void setCharacterStream(Writer writer);

    void setEncoding(String str);

    void setSystemId(String str);
}

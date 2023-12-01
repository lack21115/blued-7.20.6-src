package java.net;

import java.io.IOException;

/* loaded from: source-2895416-dex2jar.jar:java/net/ContentHandler.class */
public abstract class ContentHandler {
    public abstract Object getContent(URLConnection uRLConnection) throws IOException;

    public Object getContent(URLConnection uRLConnection, Class[] clsArr) throws IOException {
        Object content = getContent(uRLConnection);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= clsArr.length) {
                return null;
            }
            if (clsArr[i2].isInstance(content)) {
                return content;
            }
            i = i2 + 1;
        }
    }
}

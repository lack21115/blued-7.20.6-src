package java.lang;

import java.io.IOException;

/* loaded from: source-2895416-dex2jar.jar:java/lang/Appendable.class */
public interface Appendable {
    Appendable append(char c) throws IOException;

    Appendable append(CharSequence charSequence) throws IOException;

    Appendable append(CharSequence charSequence, int i, int i2) throws IOException;
}

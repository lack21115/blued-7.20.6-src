package android.content.res;

import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-9557208-dex2jar.jar:android/content/res/XmlResourceParser.class */
public interface XmlResourceParser extends XmlPullParser, AttributeSet, AutoCloseable {
    void close();
}

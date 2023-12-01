package androidx.appcompat.app;

import android.util.AttributeSet;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/LayoutIncludeDetector.class */
class LayoutIncludeDetector {

    /* renamed from: a  reason: collision with root package name */
    private final Deque<WeakReference<XmlPullParser>> f1593a = new ArrayDeque();

    private static XmlPullParser a(Deque<WeakReference<XmlPullParser>> deque) {
        while (!deque.isEmpty()) {
            XmlPullParser xmlPullParser = deque.peek().get();
            if (!a(xmlPullParser)) {
                return xmlPullParser;
            }
            deque.pop();
        }
        return null;
    }

    private static boolean a(XmlPullParser xmlPullParser) {
        boolean z = true;
        if (xmlPullParser != null) {
            z = true;
            try {
                if (xmlPullParser.getEventType() != 3) {
                    if (xmlPullParser.getEventType() == 1) {
                        return true;
                    }
                    z = false;
                }
            } catch (XmlPullParserException e) {
                return true;
            }
        }
        return z;
    }

    private static boolean a(XmlPullParser xmlPullParser, XmlPullParser xmlPullParser2) {
        if (xmlPullParser2 == null || xmlPullParser == xmlPullParser2) {
            return false;
        }
        try {
            if (xmlPullParser2.getEventType() == 2) {
                return "include".equals(xmlPullParser2.getName());
            }
            return false;
        } catch (XmlPullParserException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(AttributeSet attributeSet) {
        if (attributeSet instanceof XmlPullParser) {
            XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
            if (xmlPullParser.getDepth() == 1) {
                XmlPullParser a2 = a(this.f1593a);
                this.f1593a.push(new WeakReference<>(xmlPullParser));
                return a(xmlPullParser, a2);
            }
            return false;
        }
        return false;
    }
}

package android.sax;

import java.util.ArrayList;
import org.xml.sax.Locator;
import org.xml.sax.SAXParseException;

/* loaded from: source-9557208-dex2jar.jar:android/sax/Element.class */
public class Element {
    Children children;
    final int depth;
    EndElementListener endElementListener;
    EndTextElementListener endTextElementListener;
    final String localName;
    final Element parent;
    ArrayList<Element> requiredChilden;
    StartElementListener startElementListener;
    final String uri;
    boolean visited;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Element(Element element, String str, String str2, int i) {
        this.parent = element;
        this.uri = str;
        this.localName = str2;
        this.depth = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String toString(String str, String str2) {
        StringBuilder append = new StringBuilder().append("'");
        if (!str.equals("")) {
            str2 = str + ":" + str2;
        }
        return append.append(str2).append("'").toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkRequiredChildren(Locator locator) throws SAXParseException {
        ArrayList<Element> arrayList = this.requiredChilden;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            Element element = arrayList.get(i);
            if (!element.visited) {
                throw new BadXmlException("Element named " + this + " is missing required child element named " + element + ".", locator);
            }
            size = i;
        }
    }

    public Element getChild(String str) {
        return getChild("", str);
    }

    public Element getChild(String str, String str2) {
        if (this.endTextElementListener != null) {
            throw new IllegalStateException("This element already has an end text element listener. It cannot have children.");
        }
        if (this.children == null) {
            this.children = new Children();
        }
        return this.children.getOrCreate(this, str, str2);
    }

    public Element requireChild(String str) {
        return requireChild("", str);
    }

    public Element requireChild(String str, String str2) {
        Element child = getChild(str, str2);
        if (this.requiredChilden == null) {
            this.requiredChilden = new ArrayList<>();
            this.requiredChilden.add(child);
        } else if (!this.requiredChilden.contains(child)) {
            this.requiredChilden.add(child);
            return child;
        }
        return child;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetRequiredChildren() {
        ArrayList<Element> arrayList = this.requiredChilden;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            arrayList.get(i).visited = false;
            size = i;
        }
    }

    public void setElementListener(ElementListener elementListener) {
        setStartElementListener(elementListener);
        setEndElementListener(elementListener);
    }

    public void setEndElementListener(EndElementListener endElementListener) {
        if (this.endElementListener != null) {
            throw new IllegalStateException("End element listener has already been set.");
        }
        this.endElementListener = endElementListener;
    }

    public void setEndTextElementListener(EndTextElementListener endTextElementListener) {
        if (this.endTextElementListener != null) {
            throw new IllegalStateException("End text element listener has already been set.");
        }
        if (this.children != null) {
            throw new IllegalStateException("This element already has children. It cannot have an end text element listener.");
        }
        this.endTextElementListener = endTextElementListener;
    }

    public void setStartElementListener(StartElementListener startElementListener) {
        if (this.startElementListener != null) {
            throw new IllegalStateException("Start element listener has already been set.");
        }
        this.startElementListener = startElementListener;
    }

    public void setTextElementListener(TextElementListener textElementListener) {
        setStartElementListener(textElementListener);
        setEndTextElementListener(textElementListener);
    }

    public String toString() {
        return toString(this.uri, this.localName);
    }
}

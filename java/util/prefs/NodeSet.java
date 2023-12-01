package java.util.prefs;

import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/util/prefs/NodeSet.class */
public class NodeSet implements NodeList {
    ArrayList<Node> list = new ArrayList<>();

    public NodeSet(Iterator<Node> it) {
        while (it.hasNext()) {
            this.list.add(it.next());
        }
    }

    @Override // org.w3c.dom.NodeList
    public int getLength() {
        return this.list.size();
    }

    @Override // org.w3c.dom.NodeList
    public Node item(int i) {
        try {
            return this.list.get(i);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}

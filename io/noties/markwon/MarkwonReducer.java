package io.noties.markwon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.commonmark.node.Node;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/MarkwonReducer.class */
public abstract class MarkwonReducer {

    /* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/MarkwonReducer$DirectChildren.class */
    static class DirectChildren extends MarkwonReducer {
        DirectChildren() {
        }

        @Override // io.noties.markwon.MarkwonReducer
        public List<Node> reduce(Node node) {
            Node j = node.j();
            if (j == null) {
                return Collections.singletonList(node);
            }
            ArrayList arrayList = new ArrayList();
            while (true) {
                Node node2 = j;
                if (node2 == null) {
                    return arrayList;
                }
                arrayList.add(node2);
                j = node2.h();
                node2.l();
            }
        }
    }

    public static MarkwonReducer directChildren() {
        return new DirectChildren();
    }

    public abstract List<Node> reduce(Node node);
}

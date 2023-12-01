package io.noties.markwon.inlineparser;

import org.commonmark.node.Node;
import org.commonmark.node.Text;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/inlineparser/InlineParserUtils.class */
public abstract class InlineParserUtils {
    private InlineParserUtils() {
    }

    public static void mergeChildTextNodes(Node node) {
        if (node.j() == node.k()) {
            return;
        }
        mergeTextNodesInclusive(node.j(), node.k());
    }

    public static void mergeIfNeeded(Text text, Text text2, int i) {
        if (text == null || text2 == null || text == text2) {
            return;
        }
        StringBuilder sb = new StringBuilder(i);
        sb.append(text.a());
        Node h = text.h();
        Node h2 = text2.h();
        while (true) {
            Node node = h;
            if (node == h2) {
                text.a(sb.toString());
                return;
            }
            sb.append(((Text) node).a());
            h = node.h();
            node.l();
        }
    }

    public static void mergeTextNodesBetweenExclusive(Node node, Node node2) {
        if (node == node2 || node.h() == node2) {
            return;
        }
        mergeTextNodesInclusive(node.h(), node2.i());
    }

    public static void mergeTextNodesInclusive(Node node, Node node2) {
        Text text;
        Text text2;
        int i;
        Text text3 = null;
        int i2 = 0;
        Node node3 = node;
        Text text4 = null;
        while (true) {
            text = text4;
            text2 = text3;
            i = i2;
            if (node3 == null) {
                break;
            }
            if (node3 instanceof Text) {
                Text text5 = (Text) node3;
                Text text6 = text4;
                if (text4 == null) {
                    text6 = text5;
                }
                i2 += text5.a().length();
                text4 = text6;
                text3 = text5;
            } else {
                mergeIfNeeded(text4, text3, i2);
                text4 = null;
                text3 = null;
                i2 = 0;
            }
            if (node3 == node2) {
                text = text4;
                text2 = text3;
                i = i2;
                break;
            }
            node3 = node3.h();
        }
        mergeIfNeeded(text, text2, i);
    }
}

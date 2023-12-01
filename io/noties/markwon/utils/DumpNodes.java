package io.noties.markwon.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.commonmark.node.Block;
import org.commonmark.node.Node;
import org.commonmark.node.Visitor;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/utils/DumpNodes.class */
public abstract class DumpNodes {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/utils/DumpNodes$Indent.class */
    public static class Indent {
        private int count;

        private Indent() {
        }

        void appendTo(StringBuilder sb) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.count) {
                    return;
                }
                sb.append(' ');
                sb.append(' ');
                i = i2 + 1;
            }
        }

        void decrement() {
            this.count--;
        }

        void increment() {
            this.count++;
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/utils/DumpNodes$NodeProcessor.class */
    public interface NodeProcessor {
        String process(Node node);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/utils/DumpNodes$NodeProcessorToString.class */
    public static class NodeProcessorToString implements NodeProcessor {
        private NodeProcessorToString() {
        }

        @Override // io.noties.markwon.utils.DumpNodes.NodeProcessor
        public String process(Node node) {
            return node.toString();
        }
    }

    private DumpNodes() {
    }

    public static String dump(Node node) {
        return dump(node, null);
    }

    public static String dump(Node node, NodeProcessor nodeProcessor) {
        if (nodeProcessor == null) {
            nodeProcessor = new NodeProcessorToString();
        }
        final Indent indent = new Indent();
        final StringBuilder sb = new StringBuilder();
        final NodeProcessor nodeProcessor2 = nodeProcessor;
        node.a((Visitor) Proxy.newProxyInstance(Visitor.class.getClassLoader(), new Class[]{Visitor.class}, new InvocationHandler() { // from class: io.noties.markwon.utils.DumpNodes.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) {
                Node node2 = (Node) objArr[0];
                Indent.this.appendTo(sb);
                sb.append(nodeProcessor2.process(node2));
                if (!(node2 instanceof Block)) {
                    sb.append('\n');
                    return null;
                }
                sb.append(" [\n");
                Indent.this.increment();
                DumpNodes.visitChildren((Visitor) obj, node2);
                Indent.this.decrement();
                Indent.this.appendTo(sb);
                sb.append("]\n");
                return null;
            }
        }));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void visitChildren(Visitor visitor, Node node) {
        Node j = node.j();
        while (true) {
            Node node2 = j;
            if (node2 == null) {
                return;
            }
            Node h = node2.h();
            node2.a(visitor);
            j = h;
        }
    }
}

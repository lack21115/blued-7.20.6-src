package org.commonmark.node;

import com.alipay.sdk.util.i;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/node/Node.class */
public abstract class Node {
    private Node a = null;
    private Node b = null;
    private Node c = null;
    private Node d = null;
    private Node e = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Node node) {
        this.a = node;
    }

    public abstract void a(Visitor visitor);

    protected String aF_() {
        return "";
    }

    public Node b() {
        return this.a;
    }

    public void b(Node node) {
        node.l();
        node.a(this);
        Node node2 = this.c;
        if (node2 == null) {
            this.b = node;
            this.c = node;
            return;
        }
        node2.e = node;
        node.d = node2;
        this.c = node;
    }

    public void c(Node node) {
        node.l();
        Node node2 = this.e;
        node.e = node2;
        if (node2 != null) {
            node2.d = node;
        }
        node.d = this;
        this.e = node;
        Node node3 = this.a;
        node.a = node3;
        if (node.e == null) {
            node3.c = node;
        }
    }

    public void d(Node node) {
        node.l();
        Node node2 = this.d;
        node.d = node2;
        if (node2 != null) {
            node2.e = node;
        }
        node.e = this;
        this.d = node;
        Node node3 = this.a;
        node.a = node3;
        if (node.d == null) {
            node3.b = node;
        }
    }

    public Node h() {
        return this.e;
    }

    public Node i() {
        return this.d;
    }

    public Node j() {
        return this.b;
    }

    public Node k() {
        return this.c;
    }

    public void l() {
        Node node = this.d;
        if (node != null) {
            node.e = this.e;
        } else {
            Node node2 = this.a;
            if (node2 != null) {
                node2.b = this.e;
            }
        }
        Node node3 = this.e;
        if (node3 != null) {
            node3.d = this.d;
        } else {
            Node node4 = this.a;
            if (node4 != null) {
                node4.c = this.d;
            }
        }
        this.a = null;
        this.e = null;
        this.d = null;
    }

    public String toString() {
        return getClass().getSimpleName() + "{" + aF_() + i.d;
    }
}

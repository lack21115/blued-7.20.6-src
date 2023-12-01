package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/graph/Traverser.class */
public abstract class Traverser<N> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/common/graph/Traverser$GraphTraverser.class */
    public static final class GraphTraverser<N> extends Traverser<N> {
        private final SuccessorsFunction<N> graph;

        /* loaded from: source-8110460-dex2jar.jar:com/google/common/graph/Traverser$GraphTraverser$BreadthFirstIterator.class */
        final class BreadthFirstIterator extends UnmodifiableIterator<N> {
            private final Queue<N> queue = new ArrayDeque();
            private final Set<N> visited = new HashSet();

            BreadthFirstIterator(Iterable<? extends N> iterable) {
                for (N n : iterable) {
                    if (this.visited.add(n)) {
                        this.queue.add(n);
                    }
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return !this.queue.isEmpty();
            }

            @Override // java.util.Iterator
            public N next() {
                N remove = this.queue.remove();
                for (N n : GraphTraverser.this.graph.successors(remove)) {
                    if (this.visited.add(n)) {
                        this.queue.add(n);
                    }
                }
                return remove;
            }
        }

        /* loaded from: source-8110460-dex2jar.jar:com/google/common/graph/Traverser$GraphTraverser$DepthFirstIterator.class */
        final class DepthFirstIterator extends AbstractIterator<N> {
            private final Order order;
            private final Deque<GraphTraverser<N>.DepthFirstIterator.NodeAndSuccessors> stack = new ArrayDeque();
            private final Set<N> visited = new HashSet();

            /* JADX INFO: Access modifiers changed from: package-private */
            /* loaded from: source-8110460-dex2jar.jar:com/google/common/graph/Traverser$GraphTraverser$DepthFirstIterator$NodeAndSuccessors.class */
            public final class NodeAndSuccessors {
                @NullableDecl
                final N node;
                final Iterator<? extends N> successorIterator;

                NodeAndSuccessors(@NullableDecl N n, Iterable<? extends N> iterable) {
                    this.node = n;
                    this.successorIterator = iterable.iterator();
                }
            }

            DepthFirstIterator(Iterable<? extends N> iterable, Order order) {
                this.stack.push(new NodeAndSuccessors(null, iterable));
                this.order = order;
            }

            /* JADX WARN: Code restructure failed: missing block: B:9:0x0050, code lost:
                if (r4.order != com.google.common.graph.Traverser.Order.PREORDER) goto L25;
             */
            @Override // com.google.common.collect.AbstractIterator
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public N computeNext() {
                /*
                    r4 = this;
                L0:
                    r0 = r4
                    java.util.Deque<com.google.common.graph.Traverser$GraphTraverser<N>$DepthFirstIterator$NodeAndSuccessors> r0 = r0.stack
                    boolean r0 = r0.isEmpty()
                    if (r0 == 0) goto L11
                    r0 = r4
                    java.lang.Object r0 = r0.endOfData()
                    return r0
                L11:
                    r0 = r4
                    java.util.Deque<com.google.common.graph.Traverser$GraphTraverser<N>$DepthFirstIterator$NodeAndSuccessors> r0 = r0.stack
                    java.lang.Object r0 = r0.getFirst()
                    com.google.common.graph.Traverser$GraphTraverser$DepthFirstIterator$NodeAndSuccessors r0 = (com.google.common.graph.Traverser.GraphTraverser.DepthFirstIterator.NodeAndSuccessors) r0
                    r10 = r0
                    r0 = r4
                    java.util.Set<N> r0 = r0.visited
                    r1 = r10
                    N r1 = r1.node
                    boolean r0 = r0.add(r1)
                    r8 = r0
                    r0 = r10
                    java.util.Iterator<? extends N> r0 = r0.successorIterator
                    boolean r0 = r0.hasNext()
                    r9 = r0
                    r0 = 1
                    r6 = r0
                    r0 = r9
                    r1 = 1
                    r0 = r0 ^ r1
                    r7 = r0
                    r0 = r8
                    if (r0 == 0) goto L53
                    r0 = r6
                    r5 = r0
                    r0 = r4
                    com.google.common.graph.Traverser$Order r0 = r0.order
                    com.google.common.graph.Traverser$Order r1 = com.google.common.graph.Traverser.Order.PREORDER
                    if (r0 == r1) goto L68
                L53:
                    r0 = r7
                    if (r0 == 0) goto L66
                    r0 = r4
                    com.google.common.graph.Traverser$Order r0 = r0.order
                    com.google.common.graph.Traverser$Order r1 = com.google.common.graph.Traverser.Order.POSTORDER
                    if (r0 != r1) goto L66
                    r0 = r6
                    r5 = r0
                    goto L68
                L66:
                    r0 = 0
                    r5 = r0
                L68:
                    r0 = r7
                    if (r0 == 0) goto L79
                    r0 = r4
                    java.util.Deque<com.google.common.graph.Traverser$GraphTraverser<N>$DepthFirstIterator$NodeAndSuccessors> r0 = r0.stack
                    java.lang.Object r0 = r0.pop()
                    goto La2
                L79:
                    r0 = r10
                    java.util.Iterator<? extends N> r0 = r0.successorIterator
                    java.lang.Object r0 = r0.next()
                    r11 = r0
                    r0 = r4
                    java.util.Set<N> r0 = r0.visited
                    r1 = r11
                    boolean r0 = r0.contains(r1)
                    if (r0 != 0) goto La2
                    r0 = r4
                    java.util.Deque<com.google.common.graph.Traverser$GraphTraverser<N>$DepthFirstIterator$NodeAndSuccessors> r0 = r0.stack
                    r1 = r4
                    r2 = r11
                    com.google.common.graph.Traverser$GraphTraverser$DepthFirstIterator$NodeAndSuccessors r1 = r1.withSuccessors(r2)
                    r0.push(r1)
                La2:
                    r0 = r5
                    if (r0 == 0) goto L0
                    r0 = r10
                    N r0 = r0.node
                    if (r0 == 0) goto L0
                    r0 = r10
                    N r0 = r0.node
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.Traverser.GraphTraverser.DepthFirstIterator.computeNext():java.lang.Object");
            }

            GraphTraverser<N>.DepthFirstIterator.NodeAndSuccessors withSuccessors(N n) {
                return new NodeAndSuccessors(n, GraphTraverser.this.graph.successors(n));
            }
        }

        GraphTraverser(SuccessorsFunction<N> successorsFunction) {
            super();
            this.graph = (SuccessorsFunction) Preconditions.checkNotNull(successorsFunction);
        }

        private void checkThatNodeIsInGraph(N n) {
            this.graph.successors(n);
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> breadthFirst(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            for (N n : iterable) {
                checkThatNodeIsInGraph(n);
            }
            return new Iterable<N>() { // from class: com.google.common.graph.Traverser.GraphTraverser.1
                @Override // java.lang.Iterable
                public Iterator<N> iterator() {
                    return new BreadthFirstIterator(iterable);
                }
            };
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> breadthFirst(N n) {
            Preconditions.checkNotNull(n);
            return breadthFirst((Iterable) ImmutableSet.of(n));
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPostOrder(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            for (N n : iterable) {
                checkThatNodeIsInGraph(n);
            }
            return new Iterable<N>() { // from class: com.google.common.graph.Traverser.GraphTraverser.3
                @Override // java.lang.Iterable
                public Iterator<N> iterator() {
                    return new DepthFirstIterator(iterable, Order.POSTORDER);
                }
            };
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPostOrder(N n) {
            Preconditions.checkNotNull(n);
            return depthFirstPostOrder((Iterable) ImmutableSet.of(n));
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPreOrder(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            for (N n : iterable) {
                checkThatNodeIsInGraph(n);
            }
            return new Iterable<N>() { // from class: com.google.common.graph.Traverser.GraphTraverser.2
                @Override // java.lang.Iterable
                public Iterator<N> iterator() {
                    return new DepthFirstIterator(iterable, Order.PREORDER);
                }
            };
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPreOrder(N n) {
            Preconditions.checkNotNull(n);
            return depthFirstPreOrder((Iterable) ImmutableSet.of(n));
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/common/graph/Traverser$Order.class */
    enum Order {
        PREORDER,
        POSTORDER
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/common/graph/Traverser$TreeTraverser.class */
    public static final class TreeTraverser<N> extends Traverser<N> {
        private final SuccessorsFunction<N> tree;

        /* loaded from: source-8110460-dex2jar.jar:com/google/common/graph/Traverser$TreeTraverser$BreadthFirstIterator.class */
        final class BreadthFirstIterator extends UnmodifiableIterator<N> {
            private final Queue<N> queue = new ArrayDeque();

            BreadthFirstIterator(Iterable<? extends N> iterable) {
                for (N n : iterable) {
                    this.queue.add(n);
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return !this.queue.isEmpty();
            }

            @Override // java.util.Iterator
            public N next() {
                N remove = this.queue.remove();
                Iterables.addAll(this.queue, TreeTraverser.this.tree.successors(remove));
                return remove;
            }
        }

        /* loaded from: source-8110460-dex2jar.jar:com/google/common/graph/Traverser$TreeTraverser$DepthFirstPostOrderIterator.class */
        final class DepthFirstPostOrderIterator extends AbstractIterator<N> {
            private final ArrayDeque<TreeTraverser<N>.DepthFirstPostOrderIterator.NodeAndChildren> stack;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* loaded from: source-8110460-dex2jar.jar:com/google/common/graph/Traverser$TreeTraverser$DepthFirstPostOrderIterator$NodeAndChildren.class */
            public final class NodeAndChildren {
                final Iterator<? extends N> childIterator;
                @NullableDecl
                final N node;

                NodeAndChildren(@NullableDecl N n, Iterable<? extends N> iterable) {
                    this.node = n;
                    this.childIterator = iterable.iterator();
                }
            }

            DepthFirstPostOrderIterator(Iterable<? extends N> iterable) {
                ArrayDeque<TreeTraverser<N>.DepthFirstPostOrderIterator.NodeAndChildren> arrayDeque = new ArrayDeque<>();
                this.stack = arrayDeque;
                arrayDeque.addLast(new NodeAndChildren(null, iterable));
            }

            @Override // com.google.common.collect.AbstractIterator
            public N computeNext() {
                while (!this.stack.isEmpty()) {
                    TreeTraverser<N>.DepthFirstPostOrderIterator.NodeAndChildren last = this.stack.getLast();
                    if (last.childIterator.hasNext()) {
                        this.stack.addLast(withChildren(last.childIterator.next()));
                    } else {
                        this.stack.removeLast();
                        if (last.node != null) {
                            return last.node;
                        }
                    }
                }
                return (N) endOfData();
            }

            TreeTraverser<N>.DepthFirstPostOrderIterator.NodeAndChildren withChildren(N n) {
                return new NodeAndChildren(n, TreeTraverser.this.tree.successors(n));
            }
        }

        /* loaded from: source-8110460-dex2jar.jar:com/google/common/graph/Traverser$TreeTraverser$DepthFirstPreOrderIterator.class */
        final class DepthFirstPreOrderIterator extends UnmodifiableIterator<N> {
            private final Deque<Iterator<? extends N>> stack;

            DepthFirstPreOrderIterator(Iterable<? extends N> iterable) {
                ArrayDeque arrayDeque = new ArrayDeque();
                this.stack = arrayDeque;
                arrayDeque.addLast(iterable.iterator());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return !this.stack.isEmpty();
            }

            @Override // java.util.Iterator
            public N next() {
                Iterator<? extends N> last = this.stack.getLast();
                N n = (N) Preconditions.checkNotNull(last.next());
                if (!last.hasNext()) {
                    this.stack.removeLast();
                }
                Iterator<? extends N> it = TreeTraverser.this.tree.successors(n).iterator();
                if (it.hasNext()) {
                    this.stack.addLast(it);
                }
                return n;
            }
        }

        TreeTraverser(SuccessorsFunction<N> successorsFunction) {
            super();
            this.tree = (SuccessorsFunction) Preconditions.checkNotNull(successorsFunction);
        }

        private void checkThatNodeIsInTree(N n) {
            this.tree.successors(n);
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> breadthFirst(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            for (N n : iterable) {
                checkThatNodeIsInTree(n);
            }
            return new Iterable<N>() { // from class: com.google.common.graph.Traverser.TreeTraverser.1
                @Override // java.lang.Iterable
                public Iterator<N> iterator() {
                    return new BreadthFirstIterator(iterable);
                }
            };
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> breadthFirst(N n) {
            Preconditions.checkNotNull(n);
            return breadthFirst((Iterable) ImmutableSet.of(n));
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPostOrder(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            for (N n : iterable) {
                checkThatNodeIsInTree(n);
            }
            return new Iterable<N>() { // from class: com.google.common.graph.Traverser.TreeTraverser.3
                @Override // java.lang.Iterable
                public Iterator<N> iterator() {
                    return new DepthFirstPostOrderIterator(iterable);
                }
            };
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPostOrder(N n) {
            Preconditions.checkNotNull(n);
            return depthFirstPostOrder((Iterable) ImmutableSet.of(n));
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPreOrder(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            for (N n : iterable) {
                checkThatNodeIsInTree(n);
            }
            return new Iterable<N>() { // from class: com.google.common.graph.Traverser.TreeTraverser.2
                @Override // java.lang.Iterable
                public Iterator<N> iterator() {
                    return new DepthFirstPreOrderIterator(iterable);
                }
            };
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPreOrder(N n) {
            Preconditions.checkNotNull(n);
            return depthFirstPreOrder((Iterable) ImmutableSet.of(n));
        }
    }

    private Traverser() {
    }

    public static <N> Traverser<N> forGraph(SuccessorsFunction<N> successorsFunction) {
        Preconditions.checkNotNull(successorsFunction);
        return new GraphTraverser(successorsFunction);
    }

    public static <N> Traverser<N> forTree(SuccessorsFunction<N> successorsFunction) {
        Preconditions.checkNotNull(successorsFunction);
        if (successorsFunction instanceof BaseGraph) {
            Preconditions.checkArgument(((BaseGraph) successorsFunction).isDirected(), "Undirected graphs can never be trees.");
        }
        if (successorsFunction instanceof Network) {
            Preconditions.checkArgument(((Network) successorsFunction).isDirected(), "Undirected networks can never be trees.");
        }
        return new TreeTraverser(successorsFunction);
    }

    public abstract Iterable<N> breadthFirst(Iterable<? extends N> iterable);

    public abstract Iterable<N> breadthFirst(N n);

    public abstract Iterable<N> depthFirstPostOrder(Iterable<? extends N> iterable);

    public abstract Iterable<N> depthFirstPostOrder(N n);

    public abstract Iterable<N> depthFirstPreOrder(Iterable<? extends N> iterable);

    public abstract Iterable<N> depthFirstPreOrder(N n);
}

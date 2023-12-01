package io.noties.markwon;

import io.noties.markwon.MarkwonSpansFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.commonmark.node.Node;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/MarkwonSpansFactoryImpl.class */
class MarkwonSpansFactoryImpl implements MarkwonSpansFactory {
    private final Map<Class<? extends Node>, SpanFactory> factories;

    /* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/MarkwonSpansFactoryImpl$BuilderImpl.class */
    static class BuilderImpl implements MarkwonSpansFactory.Builder {
        private final Map<Class<? extends Node>, SpanFactory> factories = new HashMap(3);

        @Override // io.noties.markwon.MarkwonSpansFactory.Builder
        @Deprecated
        public <N extends Node> MarkwonSpansFactory.Builder addFactory(Class<N> cls, SpanFactory spanFactory) {
            return prependFactory(cls, spanFactory);
        }

        @Override // io.noties.markwon.MarkwonSpansFactory.Builder
        public <N extends Node> MarkwonSpansFactory.Builder appendFactory(Class<N> cls, SpanFactory spanFactory) {
            SpanFactory spanFactory2 = this.factories.get(cls);
            if (spanFactory2 == null) {
                this.factories.put(cls, spanFactory);
                return this;
            } else if (spanFactory2 instanceof CompositeSpanFactory) {
                ((CompositeSpanFactory) spanFactory2).factories.add(0, spanFactory);
                return this;
            } else {
                this.factories.put(cls, new CompositeSpanFactory(spanFactory, spanFactory2));
                return this;
            }
        }

        @Override // io.noties.markwon.MarkwonSpansFactory.Builder
        public MarkwonSpansFactory build() {
            return new MarkwonSpansFactoryImpl(Collections.unmodifiableMap(this.factories));
        }

        @Override // io.noties.markwon.MarkwonSpansFactory.Builder
        public <N extends Node> SpanFactory getFactory(Class<N> cls) {
            return this.factories.get(cls);
        }

        @Override // io.noties.markwon.MarkwonSpansFactory.Builder
        public <N extends Node> MarkwonSpansFactory.Builder prependFactory(Class<N> cls, SpanFactory spanFactory) {
            SpanFactory spanFactory2 = this.factories.get(cls);
            if (spanFactory2 == null) {
                this.factories.put(cls, spanFactory);
                return this;
            } else if (spanFactory2 instanceof CompositeSpanFactory) {
                ((CompositeSpanFactory) spanFactory2).factories.add(spanFactory);
                return this;
            } else {
                this.factories.put(cls, new CompositeSpanFactory(spanFactory2, spanFactory));
                return this;
            }
        }

        @Override // io.noties.markwon.MarkwonSpansFactory.Builder
        public <N extends Node> SpanFactory requireFactory(Class<N> cls) {
            SpanFactory factory = getFactory(cls);
            if (factory != null) {
                return factory;
            }
            throw new NullPointerException(cls.getName());
        }

        @Override // io.noties.markwon.MarkwonSpansFactory.Builder
        public <N extends Node> MarkwonSpansFactory.Builder setFactory(Class<N> cls, SpanFactory spanFactory) {
            if (spanFactory == null) {
                this.factories.remove(cls);
                return this;
            }
            this.factories.put(cls, spanFactory);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/MarkwonSpansFactoryImpl$CompositeSpanFactory.class */
    public static class CompositeSpanFactory implements SpanFactory {
        final List<SpanFactory> factories;

        CompositeSpanFactory(SpanFactory spanFactory, SpanFactory spanFactory2) {
            ArrayList arrayList = new ArrayList(3);
            this.factories = arrayList;
            arrayList.add(spanFactory);
            this.factories.add(spanFactory2);
        }

        @Override // io.noties.markwon.SpanFactory
        public Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps) {
            int size = this.factories.size();
            Object[] objArr = new Object[size];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return objArr;
                }
                objArr[i2] = this.factories.get(i2).getSpans(markwonConfiguration, renderProps);
                i = i2 + 1;
            }
        }
    }

    MarkwonSpansFactoryImpl(Map<Class<? extends Node>, SpanFactory> map) {
        this.factories = map;
    }

    @Override // io.noties.markwon.MarkwonSpansFactory
    public <N extends Node> SpanFactory get(Class<N> cls) {
        return this.factories.get(cls);
    }

    @Override // io.noties.markwon.MarkwonSpansFactory
    public <N extends Node> SpanFactory require(Class<N> cls) {
        SpanFactory spanFactory = get(cls);
        if (spanFactory != null) {
            return spanFactory;
        }
        throw new NullPointerException(cls.getName());
    }
}

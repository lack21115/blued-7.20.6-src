package io.noties.markwon;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/RenderPropsImpl.class */
class RenderPropsImpl implements RenderProps {
    private final Map<Prop, Object> values = new HashMap(3);

    @Override // io.noties.markwon.RenderProps
    public <T> void clear(Prop<T> prop) {
        this.values.remove(prop);
    }

    @Override // io.noties.markwon.RenderProps
    public void clearAll() {
        this.values.clear();
    }

    @Override // io.noties.markwon.RenderProps
    public <T> T get(Prop<T> prop) {
        return (T) this.values.get(prop);
    }

    @Override // io.noties.markwon.RenderProps
    public <T> T get(Prop<T> prop, T t) {
        T t2 = (T) this.values.get(prop);
        return t2 != null ? t2 : t;
    }

    @Override // io.noties.markwon.RenderProps
    public <T> void set(Prop<T> prop, T t) {
        if (t == null) {
            this.values.remove(prop);
        } else {
            this.values.put(prop, t);
        }
    }
}

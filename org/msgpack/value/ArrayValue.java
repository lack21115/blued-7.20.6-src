package org.msgpack.value;

import java.util.Iterator;
import java.util.List;

/* loaded from: source-3503164-dex2jar.jar:org/msgpack/value/ArrayValue.class */
public interface ArrayValue extends Iterable<Value>, Value {
    Value get(int i);

    Value getOrNilValue(int i);

    @Override // java.lang.Iterable
    Iterator<Value> iterator();

    List<Value> list();

    int size();
}

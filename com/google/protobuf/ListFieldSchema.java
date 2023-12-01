package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/ListFieldSchema.class */
public abstract class ListFieldSchema {
    private static final ListFieldSchema FULL_INSTANCE = new ListFieldSchemaFull();
    private static final ListFieldSchema LITE_INSTANCE = new ListFieldSchemaLite();

    /* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/ListFieldSchema$ListFieldSchemaFull.class */
    static final class ListFieldSchemaFull extends ListFieldSchema {
        private static final Class<?> UNMODIFIABLE_LIST_CLASS = Collections.unmodifiableList(Collections.emptyList()).getClass();

        private ListFieldSchemaFull() {
            super();
        }

        static <E> List<E> getList(Object obj, long j) {
            return (List) UnsafeUtil.getObject(obj, j);
        }

        private static <L> List<L> mutableListAt(Object obj, long j, int i) {
            List list;
            List<L> list2 = getList(obj, j);
            if (list2.isEmpty()) {
                List lazyStringArrayList = list2 instanceof LazyStringList ? new LazyStringArrayList(i) : ((list2 instanceof PrimitiveNonBoxingCollection) && (list2 instanceof Internal.ProtobufList)) ? ((Internal.ProtobufList) list2).mutableCopyWithCapacity(i) : new ArrayList(i);
                UnsafeUtil.putObject(obj, j, lazyStringArrayList);
                return lazyStringArrayList;
            }
            if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list2.getClass())) {
                List arrayList = new ArrayList(list2.size() + i);
                arrayList.addAll(list2);
                UnsafeUtil.putObject(obj, j, arrayList);
                list = arrayList;
            } else if (!(list2 instanceof UnmodifiableLazyStringList)) {
                Internal.ProtobufList protobufList = list2;
                if (list2 instanceof PrimitiveNonBoxingCollection) {
                    protobufList = list2;
                    if (list2 instanceof Internal.ProtobufList) {
                        Internal.ProtobufList protobufList2 = (Internal.ProtobufList) list2;
                        protobufList = list2;
                        if (!protobufList2.isModifiable()) {
                            protobufList = protobufList2.mutableCopyWithCapacity(list2.size() + i);
                            UnsafeUtil.putObject(obj, j, protobufList);
                        }
                    }
                }
                return protobufList;
            } else {
                List lazyStringArrayList2 = new LazyStringArrayList(list2.size() + i);
                lazyStringArrayList2.addAll((UnmodifiableLazyStringList) list2);
                UnsafeUtil.putObject(obj, j, lazyStringArrayList2);
                list = lazyStringArrayList2;
            }
            return list;
        }

        @Override // com.google.protobuf.ListFieldSchema
        void makeImmutableListAt(Object obj, long j) {
            LazyStringList unmodifiableList;
            List list = (List) UnsafeUtil.getObject(obj, j);
            if (list instanceof LazyStringList) {
                unmodifiableList = ((LazyStringList) list).getUnmodifiableView();
            } else if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list.getClass())) {
                return;
            } else {
                if ((list instanceof PrimitiveNonBoxingCollection) && (list instanceof Internal.ProtobufList)) {
                    Internal.ProtobufList protobufList = (Internal.ProtobufList) list;
                    if (protobufList.isModifiable()) {
                        protobufList.makeImmutable();
                        return;
                    }
                    return;
                }
                unmodifiableList = Collections.unmodifiableList(list);
            }
            UnsafeUtil.putObject(obj, j, unmodifiableList);
        }

        @Override // com.google.protobuf.ListFieldSchema
        <E> void mergeListsAt(Object obj, Object obj2, long j) {
            List list = getList(obj2, j);
            List mutableListAt = mutableListAt(obj, j, list.size());
            int size = mutableListAt.size();
            int size2 = list.size();
            if (size > 0 && size2 > 0) {
                mutableListAt.addAll(list);
            }
            if (size > 0) {
                list = mutableListAt;
            }
            UnsafeUtil.putObject(obj, j, list);
        }

        @Override // com.google.protobuf.ListFieldSchema
        <L> List<L> mutableListAt(Object obj, long j) {
            return mutableListAt(obj, j, 10);
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/ListFieldSchema$ListFieldSchemaLite.class */
    static final class ListFieldSchemaLite extends ListFieldSchema {
        private ListFieldSchemaLite() {
            super();
        }

        static <E> Internal.ProtobufList<E> getProtobufList(Object obj, long j) {
            return (Internal.ProtobufList) UnsafeUtil.getObject(obj, j);
        }

        @Override // com.google.protobuf.ListFieldSchema
        void makeImmutableListAt(Object obj, long j) {
            getProtobufList(obj, j).makeImmutable();
        }

        @Override // com.google.protobuf.ListFieldSchema
        <E> void mergeListsAt(Object obj, Object obj2, long j) {
            Internal.ProtobufList protobufList = getProtobufList(obj, j);
            Internal.ProtobufList<E> protobufList2 = getProtobufList(obj2, j);
            int size = protobufList.size();
            int size2 = protobufList2.size();
            Internal.ProtobufList<E> protobufList3 = protobufList;
            if (size > 0) {
                protobufList3 = protobufList;
                if (size2 > 0) {
                    protobufList3 = protobufList;
                    if (!protobufList.isModifiable()) {
                        protobufList3 = protobufList.mutableCopyWithCapacity(size2 + size);
                    }
                    protobufList3.addAll(protobufList2);
                }
            }
            Internal.ProtobufList<E> protobufList4 = protobufList2;
            if (size > 0) {
                protobufList4 = protobufList3;
            }
            UnsafeUtil.putObject(obj, j, protobufList4);
        }

        @Override // com.google.protobuf.ListFieldSchema
        <L> List<L> mutableListAt(Object obj, long j) {
            Internal.ProtobufList protobufList = getProtobufList(obj, j);
            Internal.ProtobufList protobufList2 = protobufList;
            if (!protobufList.isModifiable()) {
                int size = protobufList.size();
                protobufList2 = protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
                UnsafeUtil.putObject(obj, j, protobufList2);
            }
            return protobufList2;
        }
    }

    private ListFieldSchema() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ListFieldSchema full() {
        return FULL_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ListFieldSchema lite() {
        return LITE_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void makeImmutableListAt(Object obj, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> void mergeListsAt(Object obj, Object obj2, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> List<L> mutableListAt(Object obj, long j);
}

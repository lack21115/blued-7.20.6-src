package com.google.common.reflect;

import com.google.common.collect.Sets;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8110460-dex2jar.jar:com/google/common/reflect/TypeVisitor.class */
public abstract class TypeVisitor {
    private final Set<Type> visited = Sets.newHashSet();

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00aa, code lost:
        throw new java.lang.AssertionError("Unknown type: " + r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void visit(java.lang.reflect.Type... r5) {
        /*
            r4 = this;
            r0 = r5
            int r0 = r0.length
            r7 = r0
            r0 = 0
            r6 = r0
        L5:
            r0 = r6
            r1 = r7
            if (r0 >= r1) goto Lc1
            r0 = r5
            r1 = r6
            r0 = r0[r1]
            r8 = r0
            r0 = r8
            if (r0 == 0) goto Lba
            r0 = r4
            java.util.Set<java.lang.reflect.Type> r0 = r0.visited
            r1 = r8
            boolean r0 = r0.add(r1)
            if (r0 != 0) goto L25
            goto Lba
        L25:
            r0 = r8
            boolean r0 = r0 instanceof java.lang.reflect.TypeVariable     // Catch: java.lang.Throwable -> Lab
            if (r0 == 0) goto L39
            r0 = r4
            r1 = r8
            java.lang.reflect.TypeVariable r1 = (java.lang.reflect.TypeVariable) r1     // Catch: java.lang.Throwable -> Lab
            r0.visitTypeVariable(r1)     // Catch: java.lang.Throwable -> Lab
            goto Lba
        L39:
            r0 = r8
            boolean r0 = r0 instanceof java.lang.reflect.WildcardType     // Catch: java.lang.Throwable -> Lab
            if (r0 == 0) goto L4d
            r0 = r4
            r1 = r8
            java.lang.reflect.WildcardType r1 = (java.lang.reflect.WildcardType) r1     // Catch: java.lang.Throwable -> Lab
            r0.visitWildcardType(r1)     // Catch: java.lang.Throwable -> Lab
            goto Lba
        L4d:
            r0 = r8
            boolean r0 = r0 instanceof java.lang.reflect.ParameterizedType     // Catch: java.lang.Throwable -> Lab
            if (r0 == 0) goto L61
            r0 = r4
            r1 = r8
            java.lang.reflect.ParameterizedType r1 = (java.lang.reflect.ParameterizedType) r1     // Catch: java.lang.Throwable -> Lab
            r0.visitParameterizedType(r1)     // Catch: java.lang.Throwable -> Lab
            goto Lba
        L61:
            r0 = r8
            boolean r0 = r0 instanceof java.lang.Class     // Catch: java.lang.Throwable -> Lab
            if (r0 == 0) goto L75
            r0 = r4
            r1 = r8
            java.lang.Class r1 = (java.lang.Class) r1     // Catch: java.lang.Throwable -> Lab
            r0.visitClass(r1)     // Catch: java.lang.Throwable -> Lab
            goto Lba
        L75:
            r0 = r8
            boolean r0 = r0 instanceof java.lang.reflect.GenericArrayType     // Catch: java.lang.Throwable -> Lab
            if (r0 == 0) goto L89
            r0 = r4
            r1 = r8
            java.lang.reflect.GenericArrayType r1 = (java.lang.reflect.GenericArrayType) r1     // Catch: java.lang.Throwable -> Lab
            r0.visitGenericArrayType(r1)     // Catch: java.lang.Throwable -> Lab
            goto Lba
        L89:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lab
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> Lab
            r5 = r0
            r0 = r5
            java.lang.String r1 = "Unknown type: "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lab
            r0 = r5
            r1 = r8
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lab
            java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> Lab
            r1 = r0
            r2 = r5
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Lab
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lab
            throw r0     // Catch: java.lang.Throwable -> Lab
        Lab:
            r5 = move-exception
            r0 = r4
            java.util.Set<java.lang.reflect.Type> r0 = r0.visited
            r1 = r8
            boolean r0 = r0.remove(r1)
            r0 = r5
            throw r0
        Lba:
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L5
        Lc1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.reflect.TypeVisitor.visit(java.lang.reflect.Type[]):void");
    }

    void visitClass(Class<?> cls) {
    }

    void visitGenericArrayType(GenericArrayType genericArrayType) {
    }

    void visitParameterizedType(ParameterizedType parameterizedType) {
    }

    void visitTypeVariable(TypeVariable<?> typeVariable) {
    }

    void visitWildcardType(WildcardType wildcardType) {
    }
}

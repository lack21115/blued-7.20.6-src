package com.google.gson.internal.reflect;

import java.lang.reflect.AccessibleObject;

/* loaded from: source-8110460-dex2jar.jar:com/google/gson/internal/reflect/PreJava9ReflectionAccessor.class */
final class PreJava9ReflectionAccessor extends ReflectionAccessor {
    @Override // com.google.gson.internal.reflect.ReflectionAccessor
    public void makeAccessible(AccessibleObject accessibleObject) {
        accessibleObject.setAccessible(true);
    }
}

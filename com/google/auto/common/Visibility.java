package com.google.auto.common;

import com.google.common.base.Enums;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import java.util.Set;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;

/* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/Visibility.class */
public enum Visibility {
    PRIVATE,
    DEFAULT,
    PROTECTED,
    PUBLIC;
    
    private static final ElementKind MODULE = (ElementKind) Enums.getIfPresent(ElementKind.class, "MODULE").orNull();

    public static Visibility effectiveVisibilityOfElement(Element element) {
        Preconditions.checkNotNull(element);
        Visibility visibility = PUBLIC;
        while (element != null) {
            visibility = (Visibility) Ordering.natural().min(visibility, ofElement(element));
            element = element.getEnclosingElement();
        }
        return visibility;
    }

    public static Visibility ofElement(Element element) {
        Preconditions.checkNotNull(element);
        if (element.getKind().equals(ElementKind.PACKAGE) || element.getKind().equals(MODULE)) {
            return PUBLIC;
        }
        Set modifiers = element.getModifiers();
        return modifiers.contains(Modifier.PRIVATE) ? PRIVATE : modifiers.contains(Modifier.PROTECTED) ? PROTECTED : modifiers.contains(Modifier.PUBLIC) ? PUBLIC : DEFAULT;
    }
}

package com.google.auto.common;

import com.google.auto.common.Overrides;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.SetMultimap;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.ElementFilter;
import javax.lang.model.util.Elements;
import javax.lang.model.util.SimpleElementVisitor6;
import javax.lang.model.util.Types;

/* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/MoreElements.class */
public final class MoreElements {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.auto.common.MoreElements$2  reason: invalid class name */
    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/MoreElements$2.class */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$auto$common$Visibility;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0020 -> B:11:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[Visibility.values().length];
            $SwitchMap$com$google$auto$common$Visibility = iArr;
            try {
                iArr[Visibility.PRIVATE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$auto$common$Visibility[Visibility.DEFAULT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/MoreElements$CastingElementVisitor.class */
    static abstract class CastingElementVisitor<T> extends SimpleElementVisitor6<T, Void> {
        private final String label;

        CastingElementVisitor(String str) {
            this.label = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final T defaultAction(Element element, Void r6) {
            throw new IllegalArgumentException(element + " does not represent a " + this.label);
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/MoreElements$ExecutableElementVisitor.class */
    static final class ExecutableElementVisitor extends CastingElementVisitor<ExecutableElement> {
        private static final ExecutableElementVisitor INSTANCE = new ExecutableElementVisitor();

        ExecutableElementVisitor() {
            super("executable element");
        }

        public ExecutableElement visitExecutable(ExecutableElement executableElement, Void r4) {
            return executableElement;
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/MoreElements$PackageElementVisitor.class */
    static final class PackageElementVisitor extends CastingElementVisitor<PackageElement> {
        private static final PackageElementVisitor INSTANCE = new PackageElementVisitor();

        PackageElementVisitor() {
            super("package element");
        }

        public PackageElement visitPackage(PackageElement packageElement, Void r4) {
            return packageElement;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/MoreElements$TypeElementVisitor.class */
    public static final class TypeElementVisitor extends CastingElementVisitor<TypeElement> {
        private static final TypeElementVisitor INSTANCE = new TypeElementVisitor();

        TypeElementVisitor() {
            super("type element");
        }

        public TypeElement visitType(TypeElement typeElement, Void r4) {
            return typeElement;
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/MoreElements$VariableElementVisitor.class */
    static final class VariableElementVisitor extends CastingElementVisitor<VariableElement> {
        private static final VariableElementVisitor INSTANCE = new VariableElementVisitor();

        VariableElementVisitor() {
            super("variable element");
        }

        public VariableElement visitVariable(VariableElement variableElement, Void r4) {
            return variableElement;
        }
    }

    private MoreElements() {
    }

    public static ExecutableElement asExecutable(Element element) {
        return (ExecutableElement) element.accept(ExecutableElementVisitor.INSTANCE, (Object) null);
    }

    public static PackageElement asPackage(Element element) {
        return (PackageElement) element.accept(PackageElementVisitor.INSTANCE, (Object) null);
    }

    public static TypeElement asType(Element element) {
        return (TypeElement) element.accept(TypeElementVisitor.INSTANCE, (Object) null);
    }

    public static VariableElement asVariable(Element element) {
        return (VariableElement) element.accept(VariableElementVisitor.INSTANCE, (Object) null);
    }

    public static Optional<AnnotationMirror> getAnnotationMirror(Element element, Class<? extends Annotation> cls) {
        String canonicalName = cls.getCanonicalName();
        for (AnnotationMirror annotationMirror : element.getAnnotationMirrors()) {
            if (asType(annotationMirror.getAnnotationType().asElement()).getQualifiedName().contentEquals(canonicalName)) {
                return Optional.of(annotationMirror);
            }
        }
        return Optional.absent();
    }

    private static ImmutableSet<ExecutableElement> getLocalAndInheritedMethods(TypeElement typeElement, Overrides overrides) {
        LinkedHashMultimap create = LinkedHashMultimap.create();
        getLocalAndInheritedMethods(getPackage(typeElement), typeElement, create);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Collection collection : create.asMap().values()) {
            ImmutableList copyOf = ImmutableList.copyOf(collection);
            int i = 0;
            while (i < copyOf.size()) {
                ExecutableElement executableElement = (ExecutableElement) copyOf.get(i);
                int i2 = i + 1;
                int i3 = i2;
                while (true) {
                    int i4 = i3;
                    i = i2;
                    if (i4 < copyOf.size()) {
                        if (overrides.overrides((ExecutableElement) copyOf.get(i4), executableElement, typeElement)) {
                            linkedHashSet.add(executableElement);
                        }
                        i3 = i4 + 1;
                    }
                }
            }
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(create.values());
        linkedHashSet2.removeAll(linkedHashSet);
        return ImmutableSet.copyOf((Collection) linkedHashSet2);
    }

    @Deprecated
    public static ImmutableSet<ExecutableElement> getLocalAndInheritedMethods(TypeElement typeElement, Elements elements) {
        return getLocalAndInheritedMethods(typeElement, new Overrides.NativeOverrides(elements));
    }

    public static ImmutableSet<ExecutableElement> getLocalAndInheritedMethods(TypeElement typeElement, Types types, Elements elements) {
        return getLocalAndInheritedMethods(typeElement, new Overrides.ExplicitOverrides(types));
    }

    private static void getLocalAndInheritedMethods(PackageElement packageElement, TypeElement typeElement, SetMultimap<String, ExecutableElement> setMultimap) {
        for (TypeMirror typeMirror : typeElement.getInterfaces()) {
            getLocalAndInheritedMethods(packageElement, MoreTypes.asTypeElement(typeMirror), setMultimap);
        }
        if (typeElement.getSuperclass().getKind() != TypeKind.NONE) {
            getLocalAndInheritedMethods(packageElement, MoreTypes.asTypeElement(typeElement.getSuperclass()), setMultimap);
        }
        for (ExecutableElement executableElement : ElementFilter.methodsIn(typeElement.getEnclosedElements())) {
            if (!executableElement.getModifiers().contains(Modifier.STATIC) && methodVisibleFromPackage(executableElement, packageElement)) {
                setMultimap.put(executableElement.getSimpleName().toString(), executableElement);
            }
        }
    }

    public static PackageElement getPackage(Element element) {
        while (element.getKind() != ElementKind.PACKAGE) {
            element = element.getEnclosingElement();
        }
        return (PackageElement) element;
    }

    public static <T extends Element> Predicate<T> hasModifiers(final Set<Modifier> set) {
        return (Predicate<T>) new Predicate<T>() { // from class: com.google.auto.common.MoreElements.1
            /* JADX WARN: Incorrect types in method signature: (TT;)Z */
            @Override // com.google.common.base.Predicate
            public boolean apply(Element element) {
                return element.getModifiers().containsAll(Set.this);
            }
        };
    }

    public static <T extends Element> Predicate<T> hasModifiers(Modifier... modifierArr) {
        return hasModifiers(ImmutableSet.copyOf(modifierArr));
    }

    public static boolean isAnnotationPresent(Element element, Class<? extends Annotation> cls) {
        return getAnnotationMirror(element, cls).isPresent();
    }

    public static boolean isType(Element element) {
        return element.getKind().isClass() || element.getKind().isInterface();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean methodVisibleFromPackage(ExecutableElement executableElement, PackageElement packageElement) {
        int i = AnonymousClass2.$SwitchMap$com$google$auto$common$Visibility[Visibility.ofElement(executableElement).ordinal()];
        if (i != 1) {
            if (i != 2) {
                return true;
            }
            return getPackage(executableElement).equals(packageElement);
        }
        return false;
    }
}

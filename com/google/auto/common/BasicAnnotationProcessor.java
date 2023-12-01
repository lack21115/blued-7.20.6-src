package com.google.auto.common;

import com.google.common.base.Ascii;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.UnmodifiableIterator;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.SimpleElementVisitor6;
import javax.tools.Diagnostic;

/* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/BasicAnnotationProcessor.class */
public abstract class BasicAnnotationProcessor extends AbstractProcessor {
    private Elements elements;
    private Messager messager;
    private ImmutableList<? extends ProcessingStep> steps;
    private final Set<ElementName> deferredElementNames = new LinkedHashSet();
    private final SetMultimap<ProcessingStep, ElementName> elementsDeferredBySteps = LinkedHashMultimap.create();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/BasicAnnotationProcessor$ElementName.class */
    public static final class ElementName {
        private final Kind kind;
        private final String name;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/BasicAnnotationProcessor$ElementName$Kind.class */
        public enum Kind {
            PACKAGE_NAME,
            TYPE_NAME
        }

        private ElementName(Kind kind, String str) {
            this.kind = (Kind) Preconditions.checkNotNull(kind);
            this.name = (String) Preconditions.checkNotNull(str);
        }

        static ElementName forAnnotatedElement(Element element) {
            return element.getKind() == ElementKind.PACKAGE ? forPackageName(((PackageElement) element).getQualifiedName().toString()) : forTypeName(BasicAnnotationProcessor.getEnclosingType(element).getQualifiedName().toString());
        }

        static ElementName forPackageName(String str) {
            return new ElementName(Kind.PACKAGE_NAME, str);
        }

        static ElementName forTypeName(String str) {
            return new ElementName(Kind.TYPE_NAME, str);
        }

        public boolean equals(Object obj) {
            if (obj instanceof ElementName) {
                ElementName elementName = (ElementName) obj;
                boolean z = false;
                if (this.kind == elementName.kind) {
                    z = false;
                    if (this.name.equals(elementName.name)) {
                        z = true;
                    }
                }
                return z;
            }
            return false;
        }

        Optional<? extends Element> getElement(Elements elements) {
            return Optional.fromNullable(this.kind == Kind.PACKAGE_NAME ? elements.getPackageElement(this.name) : elements.getTypeElement(this.name));
        }

        public int hashCode() {
            return Objects.hash(this.kind, this.name);
        }

        String name() {
            return this.name;
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/BasicAnnotationProcessor$ProcessingStep.class */
    public interface ProcessingStep {
        Set<? extends Class<? extends Annotation>> annotations();

        Set<? extends Element> process(SetMultimap<Class<? extends Annotation>, Element> setMultimap);
    }

    private ImmutableMap<String, Optional<? extends Element>> deferredElements() {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (ElementName elementName : this.deferredElementNames) {
            builder.put(elementName.name(), elementName.getElement(this.elements));
        }
        return builder.build();
    }

    private static void findAnnotatedElements(Element element, ImmutableSet<? extends Class<? extends Annotation>> immutableSet, ImmutableSetMultimap.Builder<Class<? extends Annotation>, Element> builder) {
        for (Element element2 : element.getEnclosedElements()) {
            if (!element2.getKind().isClass() && !element2.getKind().isInterface()) {
                findAnnotatedElements(element2, immutableSet, builder);
            }
        }
        if (element instanceof ExecutableElement) {
            for (Element element3 : ((ExecutableElement) element).getParameters()) {
                findAnnotatedElements(element3, immutableSet, builder);
            }
        }
        UnmodifiableIterator<? extends Class<? extends Annotation>> it = immutableSet.iterator();
        while (it.hasNext()) {
            Class<? extends Annotation> next = it.next();
            if (MoreElements.isAnnotationPresent(element, next)) {
                builder.put((ImmutableSetMultimap.Builder<Class<? extends Annotation>, Element>) next, (Class<? extends Annotation>) element);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TypeElement getEnclosingType(Element element) {
        return (TypeElement) element.accept(new SimpleElementVisitor6<TypeElement, Void>() { // from class: com.google.auto.common.BasicAnnotationProcessor.2
            /* JADX INFO: Access modifiers changed from: protected */
            public TypeElement defaultAction(Element element2, Void r6) {
                return (TypeElement) element2.getEnclosingElement().accept(this, r6);
            }

            public TypeElement visitPackage(PackageElement packageElement, Void r5) {
                throw new IllegalArgumentException();
            }

            public TypeElement visitType(TypeElement typeElement, Void r4) {
                return typeElement;
            }
        }, (Object) null);
    }

    private ImmutableSet<? extends Class<? extends Annotation>> getSupportedAnnotationClasses() {
        Preconditions.checkState(this.steps != null);
        ImmutableSet.Builder builder = ImmutableSet.builder();
        UnmodifiableIterator<? extends ProcessingStep> it = this.steps.iterator();
        while (it.hasNext()) {
            builder.addAll((Iterable) it.next().annotations());
        }
        return builder.build();
    }

    private ImmutableSetMultimap<Class<? extends Annotation>, Element> indexByAnnotation(Set<ElementName> set) {
        ImmutableSet<? extends Class<? extends Annotation>> supportedAnnotationClasses = getSupportedAnnotationClasses();
        ImmutableSetMultimap.Builder builder = ImmutableSetMultimap.builder();
        for (ElementName elementName : set) {
            Optional<? extends Element> element = elementName.getElement(this.elements);
            if (element.isPresent()) {
                findAnnotatedElements(element.get(), supportedAnnotationClasses, builder);
            }
        }
        return builder.build();
    }

    private void process(ImmutableSetMultimap<Class<? extends Annotation>, Element> immutableSetMultimap) {
        UnmodifiableIterator<? extends ProcessingStep> it = this.steps.iterator();
        while (it.hasNext()) {
            ProcessingStep next = it.next();
            ImmutableSetMultimap build = new ImmutableSetMultimap.Builder().putAll((Multimap) indexByAnnotation(this.elementsDeferredBySteps.get((SetMultimap<ProcessingStep, ElementName>) next))).putAll((Multimap) Multimaps.filterKeys((SetMultimap) immutableSetMultimap, Predicates.in(next.annotations()))).build();
            if (build.isEmpty()) {
                this.elementsDeferredBySteps.removeAll((Object) next);
            } else {
                this.elementsDeferredBySteps.replaceValues((SetMultimap<ProcessingStep, ElementName>) next, Iterables.transform(next.process(build), new Function<Element, ElementName>() { // from class: com.google.auto.common.BasicAnnotationProcessor.1
                    @Override // com.google.common.base.Function
                    public ElementName apply(Element element) {
                        return ElementName.forAnnotatedElement(element);
                    }
                }));
            }
        }
    }

    private String processingErrorMessage(String str) {
        return String.format("[%s:MiscError] %s was unable to process %s because not all of its dependencies could be resolved. Check for compilation errors or a circular dependency with generated code.", getClass().getSimpleName(), getClass().getCanonicalName(), str);
    }

    private void reportMissingElements(Map<String, ? extends Optional<? extends Element>> map, Collection<ElementName> collection) {
        ImmutableMap immutableMap = map;
        if (!collection.isEmpty()) {
            ImmutableMap.Builder builder = ImmutableMap.builder();
            builder.putAll(map);
            for (ElementName elementName : collection) {
                if (!map.containsKey(elementName.name())) {
                    builder.put(elementName.name(), elementName.getElement(this.elements));
                }
            }
            immutableMap = builder.build();
        }
        for (Map.Entry<String, ? extends Optional<? extends Element>> entry : immutableMap.entrySet()) {
            Optional<? extends Element> value = entry.getValue();
            if (value.isPresent()) {
                Messager messager = this.processingEnv.getMessager();
                Diagnostic.Kind kind = Diagnostic.Kind.ERROR;
                messager.printMessage(kind, processingErrorMessage("this " + Ascii.toLowerCase(value.get().getKind().name())), value.get());
            } else {
                this.processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, processingErrorMessage(entry.getKey()));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0131, code lost:
        if (com.google.auto.common.SuperficialValidation.validateElement(r0) != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x019b, code lost:
        if (com.google.auto.common.SuperficialValidation.validateElement(r0) != false) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0151 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01bb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01a4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.google.common.collect.ImmutableSetMultimap<java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element> validElements(com.google.common.collect.ImmutableMap<java.lang.String, com.google.common.base.Optional<? extends javax.lang.model.element.Element>> r5, javax.annotation.processing.RoundEnvironment r6) {
        /*
            Method dump skipped, instructions count: 464
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.auto.common.BasicAnnotationProcessor.validElements(com.google.common.collect.ImmutableMap, javax.annotation.processing.RoundEnvironment):com.google.common.collect.ImmutableSetMultimap");
    }

    /* renamed from: getSupportedAnnotationTypes */
    public final ImmutableSet<String> m6263getSupportedAnnotationTypes() {
        ImmutableSet.Builder builder = ImmutableSet.builder();
        UnmodifiableIterator<? extends Class<? extends Annotation>> it = getSupportedAnnotationClasses().iterator();
        while (it.hasNext()) {
            builder.add((ImmutableSet.Builder) it.next().getCanonicalName());
        }
        return builder.build();
    }

    public final void init(ProcessingEnvironment processingEnvironment) {
        synchronized (this) {
            super.init(processingEnvironment);
            this.elements = processingEnvironment.getElementUtils();
            this.messager = processingEnvironment.getMessager();
            this.steps = ImmutableList.copyOf(initSteps());
        }
    }

    protected abstract Iterable<? extends ProcessingStep> initSteps();

    @Deprecated
    protected void postProcess() {
    }

    protected void postRound(RoundEnvironment roundEnvironment) {
        if (roundEnvironment.processingOver()) {
            return;
        }
        postProcess();
    }

    public final boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        Preconditions.checkState(this.elements != null);
        Preconditions.checkState(this.messager != null);
        Preconditions.checkState(this.steps != null);
        ImmutableMap<String, Optional<? extends Element>> deferredElements = deferredElements();
        this.deferredElementNames.clear();
        if (roundEnvironment.processingOver()) {
            postRound(roundEnvironment);
            reportMissingElements(deferredElements, this.elementsDeferredBySteps.values());
            return false;
        }
        process(validElements(deferredElements, roundEnvironment));
        postRound(roundEnvironment);
        return false;
    }
}

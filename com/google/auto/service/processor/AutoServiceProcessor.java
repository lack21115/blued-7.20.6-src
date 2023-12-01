package com.google.auto.service.processor;

import com.google.auto.common.AnnotationMirrors;
import com.google.auto.common.MoreElements;
import com.google.auto.common.MoreTypes;
import com.google.auto.service.AutoService;
import com.google.auto.service.processor.AutoServiceProcessor;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Stream;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedOptions;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleAnnotationValueVisitor8;
import javax.tools.Diagnostic;
import javax.tools.FileObject;
import javax.tools.StandardLocation;

@SupportedOptions({"debug", "verify"})
/* loaded from: source-8110460-dex2jar.jar:com/google/auto/service/processor/AutoServiceProcessor.class */
public class AutoServiceProcessor extends AbstractProcessor {
    static final String MISSING_SERVICES_ERROR = "No service interfaces provided for element!";
    private Multimap<String, String> providers = HashMultimap.create();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.auto.service.processor.AutoServiceProcessor$1  reason: invalid class name */
    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/service/processor/AutoServiceProcessor$1.class */
    public class AnonymousClass1 extends SimpleAnnotationValueVisitor8<ImmutableSet<DeclaredType>, Void> {
        AnonymousClass1() {
        }

        public /* synthetic */ Stream lambda$visitArray$0$AutoServiceProcessor$1(AnnotationValue annotationValue) {
            return ((ImmutableSet) annotationValue.accept(this, (Object) null)).stream();
        }

        public ImmutableSet<DeclaredType> visitArray(List<? extends AnnotationValue> list, Void r7) {
            return (ImmutableSet) list.stream().flatMap(new Function() { // from class: com.google.auto.service.processor.-$$Lambda$AutoServiceProcessor$1$EKVwPyX4p6l2GcsBXdQApcF_0Zk
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return AutoServiceProcessor.AnonymousClass1.this.lambda$visitArray$0$AutoServiceProcessor$1((AnnotationValue) obj);
                }
            }).collect(ImmutableSet.toImmutableSet());
        }

        public /* bridge */ /* synthetic */ Object visitArray(List list, Object obj) {
            return visitArray((List<? extends AnnotationValue>) list, (Void) obj);
        }

        public ImmutableSet<DeclaredType> visitType(TypeMirror typeMirror, Void r4) {
            return ImmutableSet.of(MoreTypes.asDeclared(typeMirror));
        }
    }

    private boolean checkImplementer(TypeElement typeElement, TypeElement typeElement2) {
        String str = (String) this.processingEnv.getOptions().get("verify");
        if (str == null || !Boolean.valueOf(str).booleanValue()) {
            return true;
        }
        return this.processingEnv.getTypeUtils().isSubtype(typeElement.asType(), typeElement2.asType());
    }

    private void error(String str, Element element, AnnotationMirror annotationMirror) {
        this.processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, str, element, annotationMirror);
    }

    private void fatalError(String str) {
        Messager messager = this.processingEnv.getMessager();
        Diagnostic.Kind kind = Diagnostic.Kind.ERROR;
        messager.printMessage(kind, "FATAL ERROR: " + str);
    }

    private void generateConfigFiles() {
        FileObject createResource;
        Filer filer = this.processingEnv.getFiler();
        for (String str : this.providers.keySet()) {
            String str2 = "META-INF/services/" + str;
            log("Working on resource file: " + str2);
            try {
                TreeSet newTreeSet = Sets.newTreeSet();
                try {
                    FileObject resource = filer.getResource(StandardLocation.CLASS_OUTPUT, "", str2);
                    log("Looking for existing resource file at " + resource.toUri());
                    Set<String> readServiceFile = ServicesFiles.readServiceFile(resource.openInputStream());
                    log("Existing service entries: " + readServiceFile);
                    newTreeSet.addAll(readServiceFile);
                } catch (IOException e) {
                    log("Resource file did not already exist.");
                }
                HashSet hashSet = new HashSet(this.providers.get(str));
                if (newTreeSet.containsAll(hashSet)) {
                    log("No new service entries being added.");
                    return;
                }
                newTreeSet.addAll(hashSet);
                log("New service file contents: " + newTreeSet);
                OutputStream openOutputStream = filer.createResource(StandardLocation.CLASS_OUTPUT, "", str2, new Element[0]).openOutputStream();
                ServicesFiles.writeServiceFile(newTreeSet, openOutputStream);
                openOutputStream.close();
                log("Wrote to: " + createResource.toUri());
            } catch (IOException e2) {
                fatalError("Unable to create " + str2 + ", " + e2);
                return;
            }
        }
    }

    private String getBinaryName(TypeElement typeElement) {
        return getBinaryNameImpl(typeElement, typeElement.getSimpleName().toString());
    }

    private String getBinaryNameImpl(TypeElement typeElement, String str) {
        PackageElement enclosingElement = typeElement.getEnclosingElement();
        if (!(enclosingElement instanceof PackageElement)) {
            TypeElement typeElement2 = (TypeElement) enclosingElement;
            return getBinaryNameImpl(typeElement2, typeElement2.getSimpleName() + "$" + str);
        }
        PackageElement packageElement = enclosingElement;
        if (packageElement.isUnnamed()) {
            return str;
        }
        return packageElement.getQualifiedName() + "." + str;
    }

    private ImmutableSet<DeclaredType> getValueFieldOfClasses(AnnotationMirror annotationMirror) {
        return (ImmutableSet) AnnotationMirrors.getAnnotationValue(annotationMirror, "value").accept(new AnonymousClass1(), (Object) null);
    }

    private void log(String str) {
        if (this.processingEnv.getOptions().containsKey("debug")) {
            this.processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, str);
        }
    }

    private void processAnnotations(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        Set<Element> elementsAnnotatedWith = roundEnvironment.getElementsAnnotatedWith(AutoService.class);
        log(set.toString());
        log(elementsAnnotatedWith.toString());
        for (Element element : elementsAnnotatedWith) {
            TypeElement typeElement = (TypeElement) element;
            AnnotationMirror annotationMirror = MoreElements.getAnnotationMirror(element, AutoService.class).get();
            ImmutableSet<DeclaredType> valueFieldOfClasses = getValueFieldOfClasses(annotationMirror);
            if (valueFieldOfClasses.isEmpty()) {
                error(MISSING_SERVICES_ERROR, element, annotationMirror);
            } else {
                for (DeclaredType declaredType : valueFieldOfClasses) {
                    TypeElement asTypeElement = MoreTypes.asTypeElement(declaredType);
                    log("provider interface: " + asTypeElement.getQualifiedName());
                    log("provider implementer: " + typeElement.getQualifiedName());
                    if (checkImplementer(typeElement, asTypeElement)) {
                        this.providers.put(getBinaryName(asTypeElement), getBinaryName(typeElement));
                    } else {
                        error("ServiceProviders must implement their service provider interface. " + typeElement.getQualifiedName() + " does not implement " + asTypeElement.getQualifiedName(), element, annotationMirror);
                    }
                }
            }
        }
    }

    private boolean processImpl(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        if (roundEnvironment.processingOver()) {
            generateConfigFiles();
            return true;
        }
        processAnnotations(set, roundEnvironment);
        return true;
    }

    /* renamed from: getSupportedAnnotationTypes */
    public ImmutableSet<String> m6290getSupportedAnnotationTypes() {
        return ImmutableSet.of(AutoService.class.getName());
    }

    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        try {
            return processImpl(set, roundEnvironment);
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            fatalError(stringWriter.toString());
            return true;
        }
    }
}

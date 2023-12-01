package okio.internal;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.jar.JarFile;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Path;
import okio.Sink;
import okio.Source;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/internal/ResourceFileSystem.class */
public final class ResourceFileSystem extends FileSystem {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    private static final Path ROOT = Path.Companion.get$default(Path.Companion, BridgeUtil.SPLIT_MARK, false, 1, (Object) null);
    private final Lazy roots$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:okio/internal/ResourceFileSystem$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean keepPath(Path path) {
            return !StringsKt.c(path.name(), ".class", true);
        }

        public final Path getROOT() {
            return ResourceFileSystem.ROOT;
        }

        public final Path removeBase(Path path, Path base) {
            Intrinsics.e(path, "<this>");
            Intrinsics.e(base, "base");
            return getROOT().resolve(StringsKt.a(StringsKt.a(path.toString(), (CharSequence) base.toString()), '\\', '/', false, 4, (Object) null));
        }

        public final List<Pair<FileSystem, Path>> toClasspathRoots(ClassLoader classLoader) {
            Intrinsics.e(classLoader, "<this>");
            Enumeration<URL> resources = classLoader.getResources("");
            Intrinsics.c(resources, "getResources(\"\")");
            ArrayList list = Collections.list(resources);
            Intrinsics.c(list, "java.util.Collections.list(this)");
            ArrayList<URL> arrayList = list;
            ArrayList arrayList2 = new ArrayList();
            for (URL it : arrayList) {
                Companion companion = ResourceFileSystem.Companion;
                Intrinsics.c(it, "it");
                Pair<FileSystem, Path> fileRoot = companion.toFileRoot(it);
                if (fileRoot != null) {
                    arrayList2.add(fileRoot);
                }
            }
            ArrayList arrayList3 = arrayList2;
            Enumeration<URL> resources2 = classLoader.getResources(JarFile.MANIFEST_NAME);
            Intrinsics.c(resources2, "getResources(\"META-INF/MANIFEST.MF\")");
            ArrayList list2 = Collections.list(resources2);
            Intrinsics.c(list2, "java.util.Collections.list(this)");
            ArrayList<URL> arrayList4 = list2;
            ArrayList arrayList5 = new ArrayList();
            for (URL it2 : arrayList4) {
                Companion companion2 = ResourceFileSystem.Companion;
                Intrinsics.c(it2, "it");
                Pair<FileSystem, Path> jarRoot = companion2.toJarRoot(it2);
                if (jarRoot != null) {
                    arrayList5.add(jarRoot);
                }
            }
            return CollectionsKt.b((Collection) arrayList3, (Iterable) arrayList5);
        }

        public final Pair<FileSystem, Path> toFileRoot(URL url) {
            Intrinsics.e(url, "<this>");
            if (Intrinsics.a((Object) url.getProtocol(), (Object) "file")) {
                return TuplesKt.a(FileSystem.SYSTEM, Path.Companion.get$default(Path.Companion, new File(url.toURI()), false, 1, (Object) null));
            }
            return null;
        }

        public final Pair<FileSystem, Path> toJarRoot(URL url) {
            int b;
            Intrinsics.e(url, "<this>");
            String url2 = url.toString();
            Intrinsics.c(url2, "toString()");
            if (StringsKt.a(url2, "jar:file:", false, 2, (Object) null) && (b = StringsKt.b((CharSequence) url2, "!", 0, false, 6, (Object) null)) != -1) {
                Path.Companion companion = Path.Companion;
                String substring = url2.substring(4, b);
                Intrinsics.c(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return TuplesKt.a(ZipKt.openZip(Path.Companion.get$default(companion, new File(URI.create(substring)), false, 1, (Object) null), FileSystem.SYSTEM, new Function1<ZipEntry, Boolean>() { // from class: okio.internal.ResourceFileSystem$Companion$toJarRoot$zip$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(ZipEntry entry) {
                        Intrinsics.e(entry, "entry");
                        return Boolean.valueOf(ResourceFileSystem.Companion.keepPath(entry.getCanonicalPath()));
                    }
                }), getROOT());
            }
            return null;
        }
    }

    public ResourceFileSystem(final ClassLoader classLoader, boolean z) {
        Intrinsics.e(classLoader, "classLoader");
        this.roots$delegate = LazyKt.a(new Function0<List<? extends Pair<? extends FileSystem, ? extends Path>>>() { // from class: okio.internal.ResourceFileSystem$roots$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Pair<? extends FileSystem, ? extends Path>> invoke() {
                return ResourceFileSystem.Companion.toClasspathRoots(ClassLoader.this);
            }
        });
        if (z) {
            getRoots().size();
        }
    }

    private final Path canonicalizeInternal(Path path) {
        return ROOT.resolve(path, true);
    }

    private final List<Pair<FileSystem, Path>> getRoots() {
        return (List) this.roots$delegate.getValue();
    }

    private final String toRelativePath(Path path) {
        return canonicalizeInternal(path).relativeTo(ROOT).toString();
    }

    @Override // okio.FileSystem
    public Sink appendingSink(Path file, boolean z) {
        Intrinsics.e(file, "file");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void atomicMove(Path source, Path target) {
        Intrinsics.e(source, "source");
        Intrinsics.e(target, "target");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public Path canonicalize(Path path) {
        Intrinsics.e(path, "path");
        return canonicalizeInternal(path);
    }

    @Override // okio.FileSystem
    public void createDirectory(Path dir, boolean z) {
        Intrinsics.e(dir, "dir");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void createSymlink(Path source, Path target) {
        Intrinsics.e(source, "source");
        Intrinsics.e(target, "target");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void delete(Path path, boolean z) {
        Intrinsics.e(path, "path");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public List<Path> list(Path dir) {
        Intrinsics.e(dir, "dir");
        String relativePath = toRelativePath(dir);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z = false;
        for (Pair<FileSystem, Path> pair : getRoots()) {
            FileSystem c = pair.c();
            Path d = pair.d();
            try {
                LinkedHashSet linkedHashSet2 = linkedHashSet;
                List<Path> list = c.list(d.resolve(relativePath));
                ArrayList arrayList = new ArrayList();
                for (Path path : list) {
                    if (Companion.keepPath(path)) {
                        arrayList.add(path);
                    }
                }
                ArrayList<Path> arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.a((Iterable) arrayList2, 10));
                for (Path path2 : arrayList2) {
                    arrayList3.add(Companion.removeBase(path2, d));
                }
                CollectionsKt.a((Collection) linkedHashSet2, (Iterable) arrayList3);
                z = true;
            } catch (IOException e) {
            }
        }
        if (z) {
            return CollectionsKt.f(linkedHashSet);
        }
        throw new FileNotFoundException(Intrinsics.a("file not found: ", (Object) dir));
    }

    @Override // okio.FileSystem
    public List<Path> listOrNull(Path dir) {
        Intrinsics.e(dir, "dir");
        String relativePath = toRelativePath(dir);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<Pair<FileSystem, Path>> it = getRoots().iterator();
        boolean z = false;
        while (true) {
            ArrayList arrayList = null;
            if (!it.hasNext()) {
                break;
            }
            Pair<FileSystem, Path> next = it.next();
            FileSystem c = next.c();
            Path d = next.d();
            List<Path> listOrNull = c.listOrNull(d.resolve(relativePath));
            if (listOrNull != null) {
                List<Path> list = listOrNull;
                ArrayList arrayList2 = new ArrayList();
                for (Path path : list) {
                    if (Companion.keepPath(path)) {
                        arrayList2.add(path);
                    }
                }
                ArrayList<Path> arrayList3 = arrayList2;
                ArrayList arrayList4 = new ArrayList(CollectionsKt.a((Iterable) arrayList3, 10));
                for (Path path2 : arrayList3) {
                    arrayList4.add(Companion.removeBase(path2, d));
                }
                arrayList = arrayList4;
            }
            if (arrayList != null) {
                CollectionsKt.a((Collection) linkedHashSet, (Iterable) arrayList);
                z = true;
            }
        }
        return z ? CollectionsKt.f(linkedHashSet) : null;
    }

    @Override // okio.FileSystem
    public FileMetadata metadataOrNull(Path path) {
        Intrinsics.e(path, "path");
        if (Companion.keepPath(path)) {
            String relativePath = toRelativePath(path);
            for (Pair<FileSystem, Path> pair : getRoots()) {
                FileMetadata metadataOrNull = pair.c().metadataOrNull(pair.d().resolve(relativePath));
                if (metadataOrNull != null) {
                    return metadataOrNull;
                }
            }
            return null;
        }
        return null;
    }

    @Override // okio.FileSystem
    public FileHandle openReadOnly(Path file) {
        Intrinsics.e(file, "file");
        if (Companion.keepPath(file)) {
            String relativePath = toRelativePath(file);
            for (Pair<FileSystem, Path> pair : getRoots()) {
                try {
                    return pair.c().openReadOnly(pair.d().resolve(relativePath));
                } catch (FileNotFoundException e) {
                }
            }
            throw new FileNotFoundException(Intrinsics.a("file not found: ", (Object) file));
        }
        throw new FileNotFoundException(Intrinsics.a("file not found: ", (Object) file));
    }

    @Override // okio.FileSystem
    public FileHandle openReadWrite(Path file, boolean z, boolean z2) {
        Intrinsics.e(file, "file");
        throw new IOException("resources are not writable");
    }

    @Override // okio.FileSystem
    public Sink sink(Path file, boolean z) {
        Intrinsics.e(file, "file");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public Source source(Path file) {
        Intrinsics.e(file, "file");
        if (Companion.keepPath(file)) {
            String relativePath = toRelativePath(file);
            for (Pair<FileSystem, Path> pair : getRoots()) {
                try {
                    return pair.c().source(pair.d().resolve(relativePath));
                } catch (FileNotFoundException e) {
                }
            }
            throw new FileNotFoundException(Intrinsics.a("file not found: ", (Object) file));
        }
        throw new FileNotFoundException(Intrinsics.a("file not found: ", (Object) file));
    }
}

package kotlin.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/io/FileTreeWalk.class */
public final class FileTreeWalk implements Sequence<File> {

    /* renamed from: a  reason: collision with root package name */
    private final File f42488a;
    private final FileWalkDirection b;

    /* renamed from: c  reason: collision with root package name */
    private final Function1<File, Boolean> f42489c;
    private final Function1<File, Unit> d;
    private final Function2<File, IOException, Unit> e;
    private final int f;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/io/FileTreeWalk$DirectoryState.class */
    public static abstract class DirectoryState extends WalkState {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DirectoryState(File rootDir) {
            super(rootDir);
            Intrinsics.e(rootDir, "rootDir");
            if (_Assertions.b) {
                boolean isDirectory = rootDir.isDirectory();
                if (_Assertions.b && !isDirectory) {
                    throw new AssertionError("rootDir must be verified to be directory beforehand.");
                }
            }
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/io/FileTreeWalk$FileTreeWalkIterator.class */
    final class FileTreeWalkIterator extends AbstractIterator<File> {
        private final ArrayDeque<WalkState> b = new ArrayDeque<>();

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata
        /* loaded from: source-3503164-dex2jar.jar:kotlin/io/FileTreeWalk$FileTreeWalkIterator$BottomUpDirectoryState.class */
        public final class BottomUpDirectoryState extends DirectoryState {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ FileTreeWalkIterator f42491a;
            private boolean b;

            /* renamed from: c  reason: collision with root package name */
            private File[] f42492c;
            private int d;
            private boolean e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BottomUpDirectoryState(FileTreeWalkIterator fileTreeWalkIterator, File rootDir) {
                super(rootDir);
                Intrinsics.e(rootDir, "rootDir");
                this.f42491a = fileTreeWalkIterator;
            }

            @Override // kotlin.io.FileTreeWalk.WalkState
            public File a() {
                if (!this.e && this.f42492c == null) {
                    Function1 function1 = FileTreeWalk.this.f42489c;
                    boolean z = false;
                    if (function1 != null) {
                        z = false;
                        if (!((Boolean) function1.invoke(b())).booleanValue()) {
                            z = true;
                        }
                    }
                    if (z) {
                        return null;
                    }
                    File[] listFiles = b().listFiles();
                    this.f42492c = listFiles;
                    if (listFiles == null) {
                        Function2 function2 = FileTreeWalk.this.e;
                        if (function2 != null) {
                            function2.invoke(b(), new AccessDeniedException(b(), null, "Cannot list files in a directory", 2, null));
                        }
                        this.e = true;
                    }
                }
                File[] fileArr = this.f42492c;
                if (fileArr != null) {
                    int i = this.d;
                    Intrinsics.a(fileArr);
                    if (i < fileArr.length) {
                        File[] fileArr2 = this.f42492c;
                        Intrinsics.a(fileArr2);
                        int i2 = this.d;
                        this.d = i2 + 1;
                        return fileArr2[i2];
                    }
                }
                if (!this.b) {
                    this.b = true;
                    return b();
                }
                Function1 function12 = FileTreeWalk.this.d;
                if (function12 != null) {
                    function12.invoke(b());
                    return null;
                }
                return null;
            }
        }

        @Metadata
        /* loaded from: source-3503164-dex2jar.jar:kotlin/io/FileTreeWalk$FileTreeWalkIterator$SingleFileState.class */
        final class SingleFileState extends WalkState {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ FileTreeWalkIterator f42493a;
            private boolean b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SingleFileState(FileTreeWalkIterator fileTreeWalkIterator, File rootFile) {
                super(rootFile);
                Intrinsics.e(rootFile, "rootFile");
                this.f42493a = fileTreeWalkIterator;
                if (_Assertions.b) {
                    boolean isFile = rootFile.isFile();
                    if (_Assertions.b && !isFile) {
                        throw new AssertionError("rootFile must be verified to be file beforehand.");
                    }
                }
            }

            @Override // kotlin.io.FileTreeWalk.WalkState
            public File a() {
                if (this.b) {
                    return null;
                }
                this.b = true;
                return b();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata
        /* loaded from: source-3503164-dex2jar.jar:kotlin/io/FileTreeWalk$FileTreeWalkIterator$TopDownDirectoryState.class */
        public final class TopDownDirectoryState extends DirectoryState {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ FileTreeWalkIterator f42494a;
            private boolean b;

            /* renamed from: c  reason: collision with root package name */
            private File[] f42495c;
            private int d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TopDownDirectoryState(FileTreeWalkIterator fileTreeWalkIterator, File rootDir) {
                super(rootDir);
                Intrinsics.e(rootDir, "rootDir");
                this.f42494a = fileTreeWalkIterator;
            }

            /* JADX WARN: Code restructure failed: missing block: B:35:0x00c9, code lost:
                if (r0.length == 0) goto L34;
             */
            @Override // kotlin.io.FileTreeWalk.WalkState
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public java.io.File a() {
                /*
                    Method dump skipped, instructions count: 257
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FileTreeWalk.FileTreeWalkIterator.TopDownDirectoryState.a():java.io.File");
            }
        }

        @Metadata
        /* loaded from: source-3503164-dex2jar.jar:kotlin/io/FileTreeWalk$FileTreeWalkIterator$WhenMappings.class */
        public final /* synthetic */ class WhenMappings {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f42496a;

            static {
                int[] iArr = new int[FileWalkDirection.values().length];
                iArr[FileWalkDirection.TOP_DOWN.ordinal()] = 1;
                iArr[FileWalkDirection.BOTTOM_UP.ordinal()] = 2;
                f42496a = iArr;
            }
        }

        public FileTreeWalkIterator() {
            if (FileTreeWalk.this.f42488a.isDirectory()) {
                this.b.push(a(FileTreeWalk.this.f42488a));
            } else if (FileTreeWalk.this.f42488a.isFile()) {
                this.b.push(new SingleFileState(this, FileTreeWalk.this.f42488a));
            } else {
                b();
            }
        }

        private final DirectoryState a(File file) {
            int i = WhenMappings.f42496a[FileTreeWalk.this.b.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return new BottomUpDirectoryState(this, file);
                }
                throw new NoWhenBranchMatchedException();
            }
            return new TopDownDirectoryState(this, file);
        }

        private final File c() {
            File a2;
            while (true) {
                WalkState peek = this.b.peek();
                if (peek == null) {
                    return null;
                }
                a2 = peek.a();
                if (a2 == null) {
                    this.b.pop();
                } else if (Intrinsics.a(a2, peek.b()) || !a2.isDirectory()) {
                    break;
                } else if (this.b.size() >= FileTreeWalk.this.f) {
                    return a2;
                } else {
                    this.b.push(a(a2));
                }
            }
            return a2;
        }

        @Override // kotlin.collections.AbstractIterator
        public void a() {
            File c2 = c();
            if (c2 != null) {
                a((FileTreeWalkIterator) c2);
            } else {
                b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/io/FileTreeWalk$WalkState.class */
    public static abstract class WalkState {

        /* renamed from: a  reason: collision with root package name */
        private final File f42497a;

        public WalkState(File root) {
            Intrinsics.e(root, "root");
            this.f42497a = root;
        }

        public abstract File a();

        public final File b() {
            return this.f42497a;
        }
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<File> iterator() {
        return new FileTreeWalkIterator();
    }
}

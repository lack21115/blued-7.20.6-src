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
    private final File a;
    private final FileWalkDirection b;
    private final Function1<File, Boolean> c;
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
            final /* synthetic */ FileTreeWalkIterator a;
            private boolean b;
            private File[] c;
            private int d;
            private boolean e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BottomUpDirectoryState(FileTreeWalkIterator fileTreeWalkIterator, File rootDir) {
                super(rootDir);
                Intrinsics.e(rootDir, "rootDir");
                this.a = fileTreeWalkIterator;
            }

            @Override // kotlin.io.FileTreeWalk.WalkState
            public File a() {
                if (!this.e && this.c == null) {
                    Function1 function1 = FileTreeWalk.this.c;
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
                    this.c = listFiles;
                    if (listFiles == null) {
                        Function2 function2 = FileTreeWalk.this.e;
                        if (function2 != null) {
                            function2.invoke(b(), new AccessDeniedException(b(), null, "Cannot list files in a directory", 2, null));
                        }
                        this.e = true;
                    }
                }
                File[] fileArr = this.c;
                if (fileArr != null) {
                    int i = this.d;
                    Intrinsics.a(fileArr);
                    if (i < fileArr.length) {
                        File[] fileArr2 = this.c;
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
            final /* synthetic */ FileTreeWalkIterator a;
            private boolean b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SingleFileState(FileTreeWalkIterator fileTreeWalkIterator, File rootFile) {
                super(rootFile);
                Intrinsics.e(rootFile, "rootFile");
                this.a = fileTreeWalkIterator;
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
            final /* synthetic */ FileTreeWalkIterator a;
            private boolean b;
            private File[] c;
            private int d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TopDownDirectoryState(FileTreeWalkIterator fileTreeWalkIterator, File rootDir) {
                super(rootDir);
                Intrinsics.e(rootDir, "rootDir");
                this.a = fileTreeWalkIterator;
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
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[FileWalkDirection.values().length];
                iArr[FileWalkDirection.TOP_DOWN.ordinal()] = 1;
                iArr[FileWalkDirection.BOTTOM_UP.ordinal()] = 2;
                a = iArr;
            }
        }

        public FileTreeWalkIterator() {
            if (FileTreeWalk.this.a.isDirectory()) {
                this.b.push(a(FileTreeWalk.this.a));
            } else if (FileTreeWalk.this.a.isFile()) {
                this.b.push(new SingleFileState(this, FileTreeWalk.this.a));
            } else {
                b();
            }
        }

        private final DirectoryState a(File file) {
            int i = WhenMappings.a[FileTreeWalk.this.b.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return new BottomUpDirectoryState(this, file);
                }
                throw new NoWhenBranchMatchedException();
            }
            return new TopDownDirectoryState(this, file);
        }

        private final File c() {
            File a;
            while (true) {
                WalkState peek = this.b.peek();
                if (peek == null) {
                    return null;
                }
                a = peek.a();
                if (a == null) {
                    this.b.pop();
                } else if (Intrinsics.a(a, peek.b()) || !a.isDirectory()) {
                    break;
                } else if (this.b.size() >= FileTreeWalk.this.f) {
                    return a;
                } else {
                    this.b.push(a(a));
                }
            }
            return a;
        }

        @Override // kotlin.collections.AbstractIterator
        public void a() {
            File c = c();
            if (c != null) {
                a((FileTreeWalkIterator) c);
            } else {
                b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/io/FileTreeWalk$WalkState.class */
    public static abstract class WalkState {
        private final File a;

        public WalkState(File root) {
            Intrinsics.e(root, "root");
            this.a = root;
        }

        public abstract File a();

        public final File b() {
            return this.a;
        }
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<File> iterator() {
        return new FileTreeWalkIterator();
    }
}

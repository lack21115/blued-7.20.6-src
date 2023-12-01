package libcore.io;

/* loaded from: source-2895416-dex2jar.jar:libcore/io/Libcore.class */
public final class Libcore {
    public static Os os = new BlockGuardOs(new Posix());

    private Libcore() {
    }
}

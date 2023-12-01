package java.lang;

import java.io.FileDescriptor;
import java.net.InetAddress;
import java.security.Permission;

/* loaded from: source-2895416-dex2jar.jar:java/lang/SecurityManager.class */
public class SecurityManager {
    @Deprecated
    protected boolean inCheck;

    public void checkAccept(String str, int i) {
    }

    public void checkAccess(Thread thread) {
    }

    public void checkAccess(ThreadGroup threadGroup) {
    }

    public void checkAwtEventQueueAccess() {
    }

    public void checkConnect(String str, int i) {
    }

    public void checkConnect(String str, int i, Object obj) {
    }

    public void checkCreateClassLoader() {
    }

    public void checkDelete(String str) {
    }

    public void checkExec(String str) {
    }

    public void checkExit(int i) {
    }

    public void checkLink(String str) {
    }

    public void checkListen(int i) {
    }

    public void checkMemberAccess(Class<?> cls, int i) {
    }

    public void checkMulticast(InetAddress inetAddress) {
    }

    @Deprecated
    public void checkMulticast(InetAddress inetAddress, byte b) {
    }

    public void checkPackageAccess(String str) {
    }

    public void checkPackageDefinition(String str) {
    }

    public void checkPermission(Permission permission) {
    }

    public void checkPermission(Permission permission, Object obj) {
    }

    public void checkPrintJobAccess() {
    }

    public void checkPropertiesAccess() {
    }

    public void checkPropertyAccess(String str) {
    }

    public void checkRead(FileDescriptor fileDescriptor) {
    }

    public void checkRead(String str) {
    }

    public void checkRead(String str, Object obj) {
    }

    public void checkSecurityAccess(String str) {
    }

    public void checkSetFactory() {
    }

    public void checkSystemClipboardAccess() {
    }

    public boolean checkTopLevelWindow(Object obj) {
        return true;
    }

    public void checkWrite(FileDescriptor fileDescriptor) {
    }

    public void checkWrite(String str) {
    }

    @Deprecated
    protected int classDepth(String str) {
        return -1;
    }

    @Deprecated
    protected int classLoaderDepth() {
        return -1;
    }

    @Deprecated
    protected ClassLoader currentClassLoader() {
        return null;
    }

    @Deprecated
    protected Class<?> currentLoadedClass() {
        return null;
    }

    protected Class[] getClassContext() {
        return null;
    }

    @Deprecated
    public boolean getInCheck() {
        return this.inCheck;
    }

    public Object getSecurityContext() {
        return null;
    }

    public ThreadGroup getThreadGroup() {
        return Thread.currentThread().getThreadGroup();
    }

    @Deprecated
    protected boolean inClass(String str) {
        return false;
    }

    @Deprecated
    protected boolean inClassLoader() {
        return false;
    }
}

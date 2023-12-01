package java.util;

/* loaded from: source-2895416-dex2jar.jar:java/util/Stack.class */
public class Stack<E> extends Vector<E> {
    private static final long serialVersionUID = 1224463164541339165L;

    public boolean empty() {
        return isEmpty();
    }

    public E peek() {
        E e;
        synchronized (this) {
            try {
                e = (E) this.elementData[this.elementCount - 1];
            } catch (IndexOutOfBoundsException e2) {
                throw new EmptyStackException();
            }
        }
        return e;
    }

    public E pop() {
        E e;
        synchronized (this) {
            if (this.elementCount == 0) {
                throw new EmptyStackException();
            }
            int i = this.elementCount - 1;
            this.elementCount = i;
            e = (E) this.elementData[i];
            this.elementData[i] = null;
            this.modCount++;
        }
        return e;
    }

    public E push(E e) {
        addElement(e);
        return e;
    }

    public int search(Object obj) {
        int i;
        synchronized (this) {
            Object[] objArr = this.elementData;
            int i2 = this.elementCount;
            if (obj != null) {
                int i3 = i2;
                while (true) {
                    int i4 = i3 - 1;
                    if (i4 < 0) {
                        break;
                    } else if (obj.equals(objArr[i4])) {
                        i = i2 - i4;
                        break;
                    } else {
                        i3 = i4;
                    }
                }
                i = -1;
            } else {
                int i5 = i2;
                while (true) {
                    int i6 = i5 - 1;
                    if (i6 < 0) {
                        break;
                    } else if (objArr[i6] == null) {
                        i = i2 - i6;
                        break;
                    } else {
                        i5 = i6;
                    }
                }
                i = -1;
            }
        }
        return i;
    }
}

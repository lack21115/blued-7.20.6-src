package android.renderscript;

import android.renderscript.Script;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/renderscript/ScriptGroup.class */
public final class ScriptGroup extends BaseObj {
    IO[] mInputs;
    IO[] mOutputs;

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/ScriptGroup$Builder.class */
    public static final class Builder {
        private int mKernelCount;
        private RenderScript mRS;
        private ArrayList<Node> mNodes = new ArrayList<>();
        private ArrayList<ConnectLine> mLines = new ArrayList<>();

        public Builder(RenderScript renderScript) {
            this.mRS = renderScript;
        }

        private Node findNode(Script.KernelID kernelID) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mNodes.size()) {
                    return null;
                }
                Node node = this.mNodes.get(i2);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < node.mKernels.size()) {
                        if (kernelID == node.mKernels.get(i4)) {
                            return node;
                        }
                        i3 = i4 + 1;
                    }
                }
                i = i2 + 1;
            }
        }

        private Node findNode(Script script) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mNodes.size()) {
                    return null;
                }
                if (script == this.mNodes.get(i2).mScript) {
                    return this.mNodes.get(i2);
                }
                i = i2 + 1;
            }
        }

        private void mergeDAGs(int i, int i2) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.mNodes.size()) {
                    return;
                }
                if (this.mNodes.get(i4).dagNumber == i2) {
                    this.mNodes.get(i4).dagNumber = i;
                }
                i3 = i4 + 1;
            }
        }

        private void validateCycle(Node node, Node node2) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= node.mOutputs.size()) {
                    return;
                }
                ConnectLine connectLine = node.mOutputs.get(i2);
                if (connectLine.mToK != null) {
                    Node findNode = findNode(connectLine.mToK.mScript);
                    if (findNode.equals(node2)) {
                        throw new RSInvalidStateException("Loops in group not allowed.");
                    }
                    validateCycle(findNode, node2);
                }
                if (connectLine.mToF != null) {
                    Node findNode2 = findNode(connectLine.mToF.mScript);
                    if (findNode2.equals(node2)) {
                        throw new RSInvalidStateException("Loops in group not allowed.");
                    }
                    validateCycle(findNode2, node2);
                }
                i = i2 + 1;
            }
        }

        private void validateDAG() {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mNodes.size()) {
                    Node node = this.mNodes.get(i2);
                    if (node.mInputs.size() == 0) {
                        if (node.mOutputs.size() == 0 && this.mNodes.size() > 1) {
                            throw new RSInvalidStateException("Groups cannot contain unconnected scripts");
                        }
                        validateDAGRecurse(node, i2 + 1);
                    }
                    i = i2 + 1;
                } else {
                    int i3 = this.mNodes.get(0).dagNumber;
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= this.mNodes.size()) {
                            return;
                        }
                        if (this.mNodes.get(i5).dagNumber != i3) {
                            throw new RSInvalidStateException("Multiple DAGs in group not allowed.");
                        }
                        i4 = i5 + 1;
                    }
                }
            }
        }

        private void validateDAGRecurse(Node node, int i) {
            if (node.dagNumber != 0 && node.dagNumber != i) {
                mergeDAGs(node.dagNumber, i);
                return;
            }
            node.dagNumber = i;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= node.mOutputs.size()) {
                    return;
                }
                ConnectLine connectLine = node.mOutputs.get(i3);
                if (connectLine.mToK != null) {
                    validateDAGRecurse(findNode(connectLine.mToK.mScript), i);
                }
                if (connectLine.mToF != null) {
                    validateDAGRecurse(findNode(connectLine.mToF.mScript), i);
                }
                i2 = i3 + 1;
            }
        }

        public Builder addConnection(Type type, Script.KernelID kernelID, Script.FieldID fieldID) {
            Node findNode = findNode(kernelID);
            if (findNode == null) {
                throw new RSInvalidStateException("From script not found.");
            }
            Node findNode2 = findNode(fieldID.mScript);
            if (findNode2 == null) {
                throw new RSInvalidStateException("To script not found.");
            }
            ConnectLine connectLine = new ConnectLine(type, kernelID, fieldID);
            this.mLines.add(new ConnectLine(type, kernelID, fieldID));
            findNode.mOutputs.add(connectLine);
            findNode2.mInputs.add(connectLine);
            validateCycle(findNode, findNode);
            return this;
        }

        public Builder addConnection(Type type, Script.KernelID kernelID, Script.KernelID kernelID2) {
            Node findNode = findNode(kernelID);
            if (findNode == null) {
                throw new RSInvalidStateException("From script not found.");
            }
            Node findNode2 = findNode(kernelID2);
            if (findNode2 == null) {
                throw new RSInvalidStateException("To script not found.");
            }
            ConnectLine connectLine = new ConnectLine(type, kernelID, kernelID2);
            this.mLines.add(new ConnectLine(type, kernelID, kernelID2));
            findNode.mOutputs.add(connectLine);
            findNode2.mInputs.add(connectLine);
            validateCycle(findNode, findNode);
            return this;
        }

        public Builder addKernel(Script.KernelID kernelID) {
            if (this.mLines.size() != 0) {
                throw new RSInvalidStateException("Kernels may not be added once connections exist.");
            }
            if (findNode(kernelID) != null) {
                return this;
            }
            this.mKernelCount++;
            Node findNode = findNode(kernelID.mScript);
            Node node = findNode;
            if (findNode == null) {
                node = new Node(kernelID.mScript);
                this.mNodes.add(node);
            }
            node.mKernels.add(kernelID);
            return this;
        }

        public ScriptGroup create() {
            if (this.mNodes.size() == 0) {
                throw new RSInvalidStateException("Empty script groups are not allowed");
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mNodes.size()) {
                    break;
                }
                this.mNodes.get(i2).dagNumber = 0;
                i = i2 + 1;
            }
            validateDAG();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            long[] jArr = new long[this.mKernelCount];
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= this.mNodes.size()) {
                    break;
                }
                Node node = this.mNodes.get(i5);
                int i6 = 0;
                while (i6 < node.mKernels.size()) {
                    Script.KernelID kernelID = node.mKernels.get(i6);
                    jArr[i3] = kernelID.getID(this.mRS);
                    boolean z = false;
                    boolean z2 = false;
                    int i7 = 0;
                    while (true) {
                        int i8 = i7;
                        if (i8 >= node.mInputs.size()) {
                            break;
                        }
                        if (node.mInputs.get(i8).mToK == kernelID) {
                            z = true;
                        }
                        i7 = i8 + 1;
                    }
                    int i9 = 0;
                    while (true) {
                        int i10 = i9;
                        if (i10 >= node.mOutputs.size()) {
                            break;
                        }
                        if (node.mOutputs.get(i10).mFrom == kernelID) {
                            z2 = true;
                        }
                        i9 = i10 + 1;
                    }
                    if (!z) {
                        arrayList.add(new IO(kernelID));
                    }
                    if (!z2) {
                        arrayList2.add(new IO(kernelID));
                    }
                    i6++;
                    i3++;
                }
                i4 = i5 + 1;
            }
            if (i3 != this.mKernelCount) {
                throw new RSRuntimeException("Count mismatch, should not happen.");
            }
            long[] jArr2 = new long[this.mLines.size()];
            long[] jArr3 = new long[this.mLines.size()];
            long[] jArr4 = new long[this.mLines.size()];
            long[] jArr5 = new long[this.mLines.size()];
            int i11 = 0;
            while (true) {
                int i12 = i11;
                if (i12 >= this.mLines.size()) {
                    break;
                }
                ConnectLine connectLine = this.mLines.get(i12);
                jArr2[i12] = connectLine.mFrom.getID(this.mRS);
                if (connectLine.mToK != null) {
                    jArr3[i12] = connectLine.mToK.getID(this.mRS);
                }
                if (connectLine.mToF != null) {
                    jArr4[i12] = connectLine.mToF.getID(this.mRS);
                }
                jArr5[i12] = connectLine.mAllocationType.getID(this.mRS);
                i11 = i12 + 1;
            }
            long nScriptGroupCreate = this.mRS.nScriptGroupCreate(jArr, jArr2, jArr3, jArr4, jArr5);
            if (nScriptGroupCreate == 0) {
                throw new RSRuntimeException("Object creation error, should not happen.");
            }
            ScriptGroup scriptGroup = new ScriptGroup(nScriptGroupCreate, this.mRS);
            scriptGroup.mOutputs = new IO[arrayList2.size()];
            int i13 = 0;
            while (true) {
                int i14 = i13;
                if (i14 >= arrayList2.size()) {
                    break;
                }
                scriptGroup.mOutputs[i14] = (IO) arrayList2.get(i14);
                i13 = i14 + 1;
            }
            scriptGroup.mInputs = new IO[arrayList.size()];
            int i15 = 0;
            while (true) {
                int i16 = i15;
                if (i16 >= arrayList.size()) {
                    return scriptGroup;
                }
                scriptGroup.mInputs[i16] = (IO) arrayList.get(i16);
                i15 = i16 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/ScriptGroup$ConnectLine.class */
    public static class ConnectLine {
        Type mAllocationType;
        Script.KernelID mFrom;
        Script.FieldID mToF;
        Script.KernelID mToK;

        ConnectLine(Type type, Script.KernelID kernelID, Script.FieldID fieldID) {
            this.mFrom = kernelID;
            this.mToF = fieldID;
            this.mAllocationType = type;
        }

        ConnectLine(Type type, Script.KernelID kernelID, Script.KernelID kernelID2) {
            this.mFrom = kernelID;
            this.mToK = kernelID2;
            this.mAllocationType = type;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/ScriptGroup$IO.class */
    static class IO {
        Allocation mAllocation;
        Script.KernelID mKID;

        IO(Script.KernelID kernelID) {
            this.mKID = kernelID;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/ScriptGroup$Node.class */
    public static class Node {
        int dagNumber;
        Node mNext;
        Script mScript;
        ArrayList<Script.KernelID> mKernels = new ArrayList<>();
        ArrayList<ConnectLine> mInputs = new ArrayList<>();
        ArrayList<ConnectLine> mOutputs = new ArrayList<>();

        Node(Script script) {
            this.mScript = script;
        }
    }

    ScriptGroup(long j, RenderScript renderScript) {
        super(j, renderScript);
    }

    public void execute() {
        this.mRS.nScriptGroupExecute(getID(this.mRS));
    }

    public void setInput(Script.KernelID kernelID, Allocation allocation) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mInputs.length) {
                throw new RSIllegalArgumentException("Script not found");
            }
            if (this.mInputs[i2].mKID == kernelID) {
                this.mInputs[i2].mAllocation = allocation;
                this.mRS.nScriptGroupSetInput(getID(this.mRS), kernelID.getID(this.mRS), this.mRS.safeID(allocation));
                return;
            }
            i = i2 + 1;
        }
    }

    public void setOutput(Script.KernelID kernelID, Allocation allocation) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mOutputs.length) {
                throw new RSIllegalArgumentException("Script not found");
            }
            if (this.mOutputs[i2].mKID == kernelID) {
                this.mOutputs[i2].mAllocation = allocation;
                this.mRS.nScriptGroupSetOutput(getID(this.mRS), kernelID.getID(this.mRS), this.mRS.safeID(allocation));
                return;
            }
            i = i2 + 1;
        }
    }
}

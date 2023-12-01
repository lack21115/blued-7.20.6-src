package android.filterfw.core;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/ProgramVariable.class */
public class ProgramVariable {
    private Program mProgram;
    private String mVarName;

    public ProgramVariable(Program program, String str) {
        this.mProgram = program;
        this.mVarName = str;
    }

    public Program getProgram() {
        return this.mProgram;
    }

    public Object getValue() {
        if (this.mProgram == null) {
            throw new RuntimeException("Attempting to get program variable '" + this.mVarName + "' but the program is null!");
        }
        return this.mProgram.getHostValue(this.mVarName);
    }

    public String getVariableName() {
        return this.mVarName;
    }

    public void setValue(Object obj) {
        if (this.mProgram == null) {
            throw new RuntimeException("Attempting to set program variable '" + this.mVarName + "' but the program is null!");
        }
        this.mProgram.setHostValue(this.mVarName, obj);
    }
}

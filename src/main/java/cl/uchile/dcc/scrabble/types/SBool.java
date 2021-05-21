package cl.uchile.dcc.scrabble.types;

import java.util.Objects;

/** Represents an internal Boolean type for Scrabble */
public class SBool implements IConcatenable, ILogicOperable {
    private boolean value;

    /**
     * SBool constructor
     * @param value Boolean value to represent
     */
    public SBool(boolean value){
        this.value = value;
    }

    /**
     * Acts like a getValue()
     * @return value of internal boolean
     */
    public boolean toBool(){
        return this.value;
    }

    /**
     * Setter for internal boolean
     * @param value New internal boolean value
     */
    public void setBool(boolean value){
        this.value = value;
    }

    /**
     * @param obj Object to check for equality
     * @return true iff the other object is an SBool representing the same boolean value, false otherwise
     */
    @Override
    public boolean equals(Object obj){
        if (obj instanceof SBool){
            SBool o = (SBool) obj;
            return this.toBool() == o.toBool();
        }
        else{
            return false;
        }
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(SBool.class);
    }

    /**
     * Returns the string representation of the internal boolean
     * @return "true" or "false"
     */
    @Override
    public String toString(){
        return String.valueOf(this.toBool());
    }

    /** @return a copy of this SBool */
    public SBool copy() {
        return new SBool(this.toBool());
    }

    /** @return SString containing the internal boolean value (as a String) */
    public SString asSString(){
        return new SString(this.toString());
    }

    public SString concatenateWithSString(SString other) {
        return new SString(other.toString() + this.toString());
    }

    public SBool not() {
        return new SBool(!this.toBool());
    }

    public ILogicOperable and(ILogicOperable other) {
        return other.andSBool(this);
    }

    public SBool andSBool(SBool other) {
        return new SBool(this.toBool() && other.toBool());
    }

    public SBinary andSBinary(SBinary other) {
        return other.andSBool(this);
    }

    public ILogicOperable or(ILogicOperable other) {
        return other.orSBool(this);
    }

    public SBool orSBool(SBool other) {
        return new SBool(this.toBool() || other.toBool());
    }

    public SBinary orSBinary(SBinary other) {
        return other.orSBool(this);
    }
}

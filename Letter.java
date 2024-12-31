/**
 * This class represents a single letter(deconstructed from a string) that will be used in the game.
 * Each game letter also has an accompanying integer label which indicates whether it is used, unused,
 * or correct with respect to the mystery word.
 * @author Ariana F
 * @since 2023-07-16
 */
public class Letter {
    private char letter;
    private int label;
    private static final int UNSET = 0;
    private static final int UNUSED = 1;
    private static final int USED = 2;
    private static final int CORRECT = 3;

    /**Initialize label to UNSET and set the value of instance variable letter to c
     * @param c
     */
    public Letter(char c) {
        this.label = Letter.UNSET;
        this.letter = c;
    }

    /**checks whether otherObject is of the class Letter, if not false is returned.
     * If true, then the “letter” attributes of otherObject and this object are compared.
     * return true and false of the "letter" attributes
     * @param otherObject
     * @return
     */
    @Override
    public boolean equals(Object otherObject) {
        if (otherObject instanceof Letter) {
            Letter otherLetter = (Letter) otherObject;
            return this.letter== otherLetter.letter;
        }
        else{
            return false;
        }
    }

    /** Returns decorators based on "label" attribute
     * @return
     */
    public String decorator() {
        switch (label) {
            case USED:
                return "+";
            case UNUSED:
                return "-";
            case CORRECT:
                return "!";
            case UNSET:
                return " ";
            default:
                return "";
        }
    }

    /** An overridden method. The String returned is of the form “dCd”, where C is the
     * “letter” attribute of this object and d is the String returned by the decorator()
     * method.
     * @return
     */
    @Override
    public String toString() {
        return decorator()+letter+decorator();
    }

    /**used to change the value of attribute “label” to UNUSED
     */
    public void setUnused() {
        this.label = UNUSED;
    }

    /**used to change the value of attribute “label” to USED
     */
    public void setUsed() {
        this.label = USED;
    }

    /**used to change the value of attribute “label” to CORRECT
     */
    public void setCorrect() {
        this.label = CORRECT;
    }

    /**returns true if the attribute “label” is set to UNUSED
     * otherwise returns false
     * @return
     */
    public boolean isUnused() {
        if (this.label == UNUSED) {
            return true;
        }
        return false;
    }

    /**Produces an array of objects of the class Letter. For each character in String s
     * a Letter object is created and stored in the array. The Letter objects
     * stored in array are in the same order as it is in the string.
     * @param s
     * @return
     */
    public static Letter[] fromString(String s) {
        Letter[] object= new Letter[s.length()];
        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            object[i] = new Letter(c);
        }
        return object;
    }
}



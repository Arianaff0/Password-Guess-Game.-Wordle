/**
 * This is a child class of Letter.
 * @author Ariana Feng
 * @since 2023-07-16
 */
public class ExtendedLetter extends Letter {
    private String content;
    private int family;
    private boolean related;
    private static int SINGLETON = -1;

    /**Initialize instance variables of the superclass
     * and other variables in this class
     * @param s
     */
    public ExtendedLetter(String s) {
        super('c');
        content = s;
        related=false;
        family = SINGLETON;
    }

    /**Initialize instance variables of the superclass
     * and other variables in this class
     * @param s
     * @param fam
     */
    public ExtendedLetter(String s, int fam) {
        super('c');
        content = s;
        related=false;
        family= fam;
    }

    /** return false if the other is not an instanceOf ExtendedLetter
     * Compares this.family and other family (cast), and compares content.
     * @param other
     * @return
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof ExtendedLetter) {
            ExtendedLetter extendedOther = (ExtendedLetter) other;
            if (this.family== extendedOther.family) {
                related= true;
            }
            if (this.content.equals(extendedOther.content)) {
                return true;
            }
        }
        return false;
    }


    /** String repr of ExtendedLetter object
     * @return
     */
    @Override
    public String toString() {
//        System.out.println(content+ " " +related);
        if (isUnused() && related) {
            return "."+content+".";
        }
        else {
            return decorator()+content+decorator();
        }
    }

    /** creates array of Letter objects
     * @param content
     * @param codes
     * @return
     */
    public static Letter[] fromStrings(String[] content, int[] codes) {
        Letter[] letters = new Letter[content.length];
        for (int i=0; i<content.length; i++) {
            if (codes == null) {
                letters[i] = new ExtendedLetter(content[i]);
            }
            else {
                letters[i] = new ExtendedLetter(content[i], codes[i]);
            }
        }
        return letters;
    }

}

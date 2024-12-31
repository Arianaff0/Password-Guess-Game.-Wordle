/**
 * This class represents a word in the game comprised of Letter objects
 * which is stored in a linked list formed by objects in class LinearNode.
 * Each node stores a Letter.
 * @author Ariana F
 * @since 2023-07-16
 */
public class Word {
    private LinearNode<Letter> firstLetter;

    /** constructor, initialize word object so Letter objects
     * in array "letters" is stored in a linked list.
     * @param letters
     */
    public Word(Letter[] letters) {
        if (letters.length==0) {
            firstLetter = null;
        }
        else {
            firstLetter = new LinearNode<>(letters[0]);
            LinearNode<Letter> currentNode = firstLetter;

            for (int i =1; i<letters.length; i++) {
                LinearNode<Letter> newNode = new LinearNode<>(letters[i]);
                currentNode.setNext(newNode);
                currentNode = newNode;
            }
        }
    }

    /** Creates a String of the form: “Word: L1 L2 L3 … Lk”, where each Li is the string
     produced by invoking the toSting method on each Letter object of this Word
     * @return
     */
    public String toString() {
        StringBuilder builder = new StringBuilder("Word: ");
        LinearNode<Letter> currentNode = firstLetter;
        while (currentNode != null) {
            builder.append(currentNode.getElement().toString());
            builder.append(" ");
            currentNode = currentNode.getNext();
        }
        return builder.toString();
    }

    /** Updates each of Letters’ “label” attribute contained in this Word
     * object with respect to the mystery word
     * @param mystery
     * @return
     */
    public boolean labelWord(Word mystery){
        LinearNode<Letter> mysteryNode = mystery.firstLetter; //OBJECT
        LinearNode<Letter> currentNode = this.firstLetter; //CODE
        boolean isEqual = true;
        boolean isLast = false;
        while(true){
            if(currentNode == null || mysteryNode == null){
                if(currentNode == null && mysteryNode == null){
                    break;
                }
                isEqual = false;
                break;
            }
            if(currentNode.getElement().equals(mysteryNode.getElement())){
                currentNode.getElement().setCorrect();
            }
            else{
                if(contains(mystery, currentNode.getElement())) {
                    currentNode.getElement().setUsed();
                }
                else{
                    currentNode.getElement().setUnused();
                }
                isEqual = false;
            }

            if (currentNode.getNext() != null)
                currentNode = currentNode.getNext();

            if (mysteryNode.getNext() != null)
                mysteryNode = mysteryNode.getNext();

            if (isLast == true)
                return isEqual;

            if (currentNode.getNext() == null)
                isLast = true;

        }
        return isEqual;
    }

    /**
     * private helper method for labelWord
     * @param word
     * @param element
     * @return
     */
    private boolean contains(Word word, Letter element) {
        LinearNode<Letter> currentNode = word.firstLetter;

        while (currentNode != null) {
            if (currentNode.getElement().equals(element)) {
                return true;
            }
            currentNode = currentNode.getNext();
        }

        return false;
    }
}

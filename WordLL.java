/**
 * This class is a central repository for information about a WordLL game: It stores a mystery word
 * and all word guesses tried so far. It keeps a history of the past word guesses in a linked
 * structure.
 * @author Ariana F
 * @since 2023-07-16
 * 150 Word Summary below
 */
public class WordLL {
    private Word mysteryWord;
    private LinearNode<Word> history;

    /**Initialize an empty history
     * set the mysteryWord attribute to the parameter mystery
     * @param mystery
     */
    public WordLL(Word mystery) {
        this.history = null;
        this.mysteryWord = mystery;
    }

    /**takes a Word as an argument to test against this games’ mystery word
     * updates the label of all the letters contained within Word guess (using labelWord)
     * and adds Word guess to the front the of history
     * @param guess
     * @return
     */
    public boolean tryWord(Word guess) {
        guess.labelWord(mysteryWord);

        LinearNode<Word> newNode = new LinearNode<>(guess);
        newNode.setNext(history);
        history = newNode;

        return guess.equals(mysteryWord);
    }

    /**
     * String repr of past guesses with most recent guess first.
     * @return
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        LinearNode<Word> currentNode = history;
        while (currentNode != null) {
            builder.append(currentNode.getElement().toString());
            builder.append("\n");
            currentNode = currentNode.getNext();
        }
        return builder.toString();
    }

}

/**
 * Basically WordLL has two instance variables, mysteryWord and history.
 * history is a linked list, and the datatype of that linked list is an
 * object of Word, which is another linked list. The history basically stores the
 * history of all the word guesses. WordLL has a mysteryWord, Word object, which
 * is a linked list of the letters of that mysteryWord.
 * history is null means that it is pointing to no nodes. In the tryWord method,
 * you call the labelWord method on the guess Word object. Then it compares the guess
 * and mysteryWord objects and updates the decorator symbols of guess. newNode is a new
 * LinearNode object that has guess as its element. newNode.setNext(history) sets history
 * as NewNode's next node. history = newNode is how you connect the nodes. In the toString
 * method, currentNode.getElement returns the Word element stored in the node. So the
 * toString method being called after is the toString in class Word.
 */

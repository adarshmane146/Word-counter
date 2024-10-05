-----------------------------------------------------------------------------TEAM  YESEBU AND ADARSH-------------------------------------------------------------
WE  HAVE CREATED A JAVA PROGRAM  WHICH HELPS  USERS TO COUNT THE NUMBER OF WORDS ,LETTERS AND PARAGRAPH.
IT IS  BUILT USING SWING.

Let us know about import statements : 
/////////////import javax.swing.*;
            import java.awt.*;
            import java.awt.event.*;////////////////////////////////
[1]javax.swing*: This package contains classes for building graphical user interfaces.
[2]java.awt*: This package contains classes for components that are dependent on the native system.
[3]java.awt.event*: This package provides classes for handling events like button clicks.

Let us know about the class:
///////////////////public class WordCounter extends JFrame implements ActionListener ///////////////////
WordCounter: This class extends JFrame, meaning it is a type of window.
implements ActionListener: This means the class will handle action events (like button clicks).
Instance Variables:
//////////////private JTextArea t1;
              private JLabel wl1, cll, pll;////////////
I am using three main  Components which  includes the following :

[1]JTextArea: A multi-line text area for users to enter text.
[2]JLabel: Labels to display the word, character, and paragraph counts.
[3]JButton: A button to trigger the counting process.

Constructor:
//////////////public WordCounter() {
        setTitle("I AM THE WORD COUNTER");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);/////////////////
[1]setTitle: Sets the title of the window.
[2]setSize: Sets the dimensions of the window.
[3]setDefaultCloseOperation: Ensures the application exits when the window is closed.
[4]setLocationRelativeTo(null): Centers the window on the screen.

Text Area and Scroll Pane:
////////////////////  t1 = new JTextArea(); 
                  t1.setLineWrap(true);
                  t1.setWrapStyleWord(true);
                  JScrollPane scrollPane = new JScrollPane(t1);/////////////////
[1]A JTextArea is created for text input.
[2]setLineWrap: Enables line wrapping.
[3]setWrapStyleWord: Ensures words are not split when wrapping.
[4]JScrollPane: Wraps the text area, allowing scrolling if the text exceeds the viewable area.

Labels and Button:
////////////////////// wl1 = new JLabel("Number of Words: 0");
        cll = new JLabel("Number of Characters: 0");
        pll = new JLabel("Number of Paragraphs: 0");
        JButton countButton = new JButton("Let's Count");
       countButton.addActionListener(this);/////////////////////////////////
[1]JLabel: Three labels are initialized to display the counts, starting at zero.
[2]JButton: A button is created, and the current class is set to listen for action events from this button.


Panel and Layout:
////////////////////////////////////JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.add(wl1);
        panel.add(cll);
        panel.add(pll);
        panel.add(countButton); /////////////////////////////////

[1]A JPanel with a GridLayout is created to organize the labels and button vertically.
[2]The labels and button are added to this panel.   
        
Adding Components to the Frame:
/////////////////////////add(scrollPane, BorderLayout.CENTER);
                         add(panel, BorderLayout.SOUTH);///////////////////

[1]The scroll pane containing the text area is added to the center of the frame.
[2]The panel is added to the bottom of the frame.

Action Listener:
////////////////////////////////////// @Override
    public void actionPerformed(ActionEvent e) {
        String text = t1.getText();
        int wordCount = countWords(text);
        int charCount = text.length();
        int paraCount = countParagraphs(text);
        wl1.setText("Words: " + wordCount);
        cll.setText("Characters: " + charCount); // Fixed the variable name
        pll.setText("Paragraphs: " + paraCount);/////////////////////////////////////////
[1]The above  method is called when the button is clicked.
[2]It retrieves the text from the text area and calculates the counts for words, characters, and paragraphs.
[3]The labels are updated to display the new counts.

Count Methods:
///////////////////private int countWords(String text) {
        if (text.isEmpty()) {
            return 0;
        }
        String[] words = text.trim().split("\\s+");
        return words.length;
    }
       private int countParagraphs(String text) {
        if (text.isEmpty()) {
            return 0;
        }
        String[] paragraphs = text.split("\\n+");
        return paragraphs.length;
    }//////////////////////////////////

[1]countWords: Splits the text into words based on whitespace and returns the count. It uses trim() to remove leading and trailing whitespace.
[2]countParagraphs: Splits the text into paragraphs based on newline characters and returns the count.

Now moving on to the main method:
 //////////////////////////////public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new WordCounter().setVisible(true);
        });
    }
}/////////////////////////////////////////////////////////

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WordCounter extends JFrame implements ActionListener {

    private JTextArea t1;
    private JLabel wl1, cll, pll;

    public WordCounter() {
        setTitle("I AM THE WORD COUNTER");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        t1 = new JTextArea(); 
        t1.setLineWrap(true);
        t1.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(t1);

        wl1 = new JLabel("Number of Words: 0");
        cll = new JLabel("Number of Characters: 0");
        pll = new JLabel("Number of Paragraphs: 0");

        JButton countButton = new JButton("Let's Count");
        countButton.addActionListener(this); 

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.add(wl1);
        panel.add(cll);
        panel.add(pll);
        panel.add(countButton);

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = t1.getText();
        int wordCount = countWords(text);
        int charCount = text.length();
        int paraCount = countParagraphs(text);

        wl1.setText("Words: " + wordCount);
        cll.setText("Characters: " + charCount); // Fixed the variable name
        pll.setText("Paragraphs: " + paraCount);
    }

    private int countWords(String text) {
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
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new WordCounter().setVisible(true);
        });
    }
}
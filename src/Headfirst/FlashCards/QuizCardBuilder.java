package Headfirst.FlashCards;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class QuizCardBuilder {
private ArrayList <QuizCard> cardlist = new ArrayList<>();
private JTextArea question;
private JTextArea answer;
private JFrame frame;

public static void main (String [] args) {
    new QuizCardBuilder().go();
} // end main

    public void go() {
    frame = new JFrame("Quiz Card Builder");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    JPanel mainPanel = new JPanel();
    Font bigFont = new Font("Dialog", Font.BOLD, 24);
    // can be Serif, SansSerif, Monospaced, Dialog, and DialogInput.

        question = createTextArea (bigFont);
        JScrollPane qScroller = createScroller (question);
        answer = createTextArea (bigFont);
        JScrollPane aScroller = createScroller (answer);

        mainPanel.add(new JLabel("Question: "));
        mainPanel.add (qScroller);
        mainPanel.add(new JLabel("Answer: "));
        mainPanel.add (aScroller);

        JButton nextButton = new JButton("Next Card");
        nextButton.addActionListener(e -> nextCard());
        //when the usuer clicks Next card the nextcard method is called
        mainPanel.add(nextButton);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem newMenu = new JMenuItem("New");
        newMenu.addActionListener(e -> clearAll());
        // when the user clicks clear the clearAll method is called

        JMenuItem saveMenu = new JMenuItem("Save");
        newMenu.addActionListener(e -> saveCard());

        fileMenu.add(newMenu);
        fileMenu.add(saveMenu);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        /*
        Making a menu bar, file menu. Then putting new and save into the file menu
        Add the menu to the bar, and tell the frame to use it.
        Menu items fire the action event
         */

        frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
        frame.setSize(500,600);
        frame.setVisible(true);
    } // end method go

    private JScrollPane createScroller (JTextArea textArea) {
    JScrollPane scroller = new JScrollPane(textArea);
    scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    return scroller;
    } // end Method createScroller

    private JTextArea createTextArea(Font font) {
    JTextArea textArea = new JTextArea(6,20);
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    textArea.setFont(font);
    return textArea;
    } // end method createtextarea

    private void nextCard() {
    QuizCard card = new QuizCard(question.getText(),answer.getText());
    cardlist.add(card);
    clearCard();
    } // end method nextCard

    private void saveCard() {
    QuizCard card = new QuizCard (question.getText(),answer.getText());
    cardlist.add(card);

    JFileChooser fileSave = new JFileChooser();
    fileSave.showSaveDialog(frame);
    saveFile(fileSave.getSelectedFile());
    /*
    Brings up dialog box and waits on this line until the user chooses save from the box
    All the file dialog nav etc is done by filechooser!
     */
    } // end method saveCard

    private void clearAll() {
    cardlist.clear();
    clearCard();
    } // end method clear all

    private void clearCard() {
    question.setText("");
    answer.setText("");
    question.requestFocus();
    } // end method clearcard

    private void saveFile(File file) {
    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        //chain buffered writer on to a new file writer to make writing more effiecient
        for (QuizCard card : cardlist) {
            writer.write("Question : " + card.getQuestion() + "\n");
            writer.write("Answer: " + card.getAnswer() + "\n");
        } // end for list
        writer.close();
    } // end try
        catch (IOException e){
        System.out.println("Couldnt write the cardlist out: " + e.getMessage());
        } //end catch
    } // end method savefile
} // end class quizcardbuilder

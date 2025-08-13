package ch16_revisit;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class QuizCardBuilder {
  private ArrayList<QuizCard> cardList = new ArrayList<>();
  private JTextArea question;
  private JTextArea answer;
  private JFrame frame;

  public static void main(String[] args) {
    new QuizCardBuilder().go();
  }

//Builds and displays GUI incl making & Registering event listeners  
  public void go() {
//GUI code      
    frame = new JFrame("Quiz Card Builder");
    JPanel mainPanel = new JPanel();
    Font bigFont = new Font("sanserif", Font.BOLD, 24);

    question = createTextArea(bigFont);
    JScrollPane qScroller = createScroller(question);

    answer = createTextArea(bigFont);
    JScrollPane aScroller = createScroller(answer);

    
    mainPanel.add(new JLabel("Question:"));
    mainPanel.add(qScroller);

    mainPanel.add(new JLabel("Answer:"));
    mainPanel.add(aScroller);

    JButton nextButton = new JButton("Next Card");
    nextButton.addActionListener(e -> nextCard());//calls method below
    mainPanel.add(nextButton);

//Make menu bar ad file menu    
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");

//Menu items fire an Action Event    
    JMenuItem newMenuItem = new JMenuItem("New");
    newMenuItem.addActionListener(e -> clearAll());//calls method below

    JMenuItem saveMenuItem = new JMenuItem("Save");
    saveMenuItem.addActionListener(e -> saveCard());//calls method below

//Add 'New' & 'Save' menu items into file menu    
    fileMenu.add(newMenuItem);
    fileMenu.add(saveMenuItem);
//Add file menue to menu bar    
    menuBar.add(fileMenu);
//Frame must use menu bar    
    frame.setJMenuBar(menuBar);

    frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
    frame.setSize(500, 600);
    frame.setVisible(true);
  }

//Helper method to create scroll pane  
  private JScrollPane createScroller(JTextArea textArea) {
    JScrollPane scroller = new JScrollPane(textArea);
    scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    return scroller;
  }

//Helper method to create text area
  private JTextArea createTextArea(Font font) {
    JTextArea textArea = new JTextArea(6, 20);//6lines(height) and 20cols(width)
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    textArea.setFont(font);
    return textArea;
  }

//When user hits the button, the user wants to store that card in the list and
//start a new card so we add the current card to the list and clear the 
// text areas  
  private void nextCard() {
    QuizCard card = new QuizCard(question.getText(), answer.getText());
    cardList.add(card);
    clearCard();
  }

//Called when user chooses 'Save' from the File menu meaing the user wants to
//save all the cards in the current list as a 'set'   
  private void saveCard() {
    QuizCard card = new QuizCard(question.getText(), answer.getText());
    cardList.add(card);

//Brings up file dialogue box & waits on this line until user chooses 'Save'
//from dialogue box
    JFileChooser fileSave = new JFileChooser();
    fileSave.showSaveDialog(frame);
    saveFile(fileSave.getSelectedFile());
  }

//For a new set of cards, we clear out the card list ad text areas  
  private void clearAll() {
    cardList.clear();
    clearCard();
  }

//To clear the screen when the user chooses 'New' from the 
//  File menu or moves to the next card  
  private void clearCard() {
    question.setText("");
    answer.setText("");
    question.requestFocus();
  }

// Called by the SaveMenuListener, it does the actual file writing
// so we iterate through the list of cards and write each one out to a text
//  file in a parseable way i.e. with clear separations between parts
  private void saveFile(File file) { //file object the user is saving
    try {
//chain FileWriter to BufferedWriter object        
      BufferedWriter writer = new BufferedWriter(new FileWriter(file));
//Go through ArrayList of cards and write them out, one card per line with
//question & answer separated by a '/' and then add newline at end of card
      for (QuizCard card : cardList) {
        writer.write(card.getQuestion() + "/");
        writer.write(card.getAnswer() + "\n");
      }
      writer.close();
    } catch (IOException e) {
      System.out.println("Couldn't write the cardList out: " + e.getMessage());
    }
  }
}
       
           
          
          
       
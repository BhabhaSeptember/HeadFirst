package ch16_revisit;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class QuizCardPlayer {
  private ArrayList<QuizCard> cardList;
  private int currentCardIndex;
  private QuizCard currentCard;
  private JTextArea display;
  private JFrame frame;
  private JButton nextButton;
  private boolean isShowAnswer;

  public static void main(String[] args) {
    QuizCardPlayer reader = new QuizCardPlayer();
    reader.go();
  }

//Build & Display the GUI  
  public void go() {
    frame = new JFrame("Quiz Card Player");
    JPanel mainPanel = new JPanel();
    Font bigFont = new Font("sanserif", Font.BOLD, 24);

//display represents textArea instance variable    
    display = new JTextArea(10, 20);
    display.setFont(bigFont);
    display.setLineWrap(true);
    display.setEditable(false);

    JScrollPane scroller = new JScrollPane(display);
    scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    mainPanel.add(scroller);

//JButton instance variable    
    nextButton = new JButton("Show Question");
    nextButton.addActionListener(e -> nextCard());//calls method below
    mainPanel.add(nextButton);

    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");

    JMenuItem loadMenuItem = new JMenuItem("Load card set");
    loadMenuItem.addActionListener(e -> open());//calls method below

    fileMenu.add(loadMenuItem);
    menuBar.add(fileMenu);
    frame.setJMenuBar(menuBar);

    frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
    frame.setSize(500, 400);
    frame.setVisible(true);
  }

//If this is a question, show the answer, otherwise show the next question
//Set a flag to show if we're viewing a question or an answer  
  private void nextCard() {
    if (isShowAnswer) { //boolean instance variable
      // show the answer because they’ve seen the question
      display.setText(currentCard.getAnswer());
      nextButton.setText("Next Card");
      isShowAnswer = false;
    } else {
      // show the next question
      if (currentCardIndex < cardList.size()) {
        showNextCard();
      } else {
        // there are no more cards!
        display.setText("That was last card");
        nextButton.setEnabled(false);
      }
    }
  }

//Brings up a file dialogue box
//Lets user navigate to & choose a card set/file to open 
  private void open() {
    JFileChooser fileOpen = new JFileChooser();
    fileOpen.showOpenDialog(frame);
    loadFile(fileOpen.getSelectedFile());
  }

//Must build an ArrayList of cards by reading them from a text file that is
//called from the OpenMenuListener event handler
//Read file, one line at a time and tell makeCard() method to make a new
//card out of the line  
  private void loadFile(File file) {
    cardList = new ArrayList<>();//QuizCard ArrayList instance variable
    currentCardIndex = 0;
    try {
//Make BufferedReader and chain it to a newFileReader that has the File object
//which the user selected from the dialogue box
      BufferedReader reader = new BufferedReader(new FileReader(file));
//Reading one line at a time (each line holds question & answer) and make card 
//makeCard() method parses it into QuizCard and adds to ArrayList
      String line;
      while ((line = reader.readLine()) != null) {
        makeCard(line);
      }
      reader.close();
    } catch (IOException e) {
      System.out.println("Couldn't write the cardList out: " + e.getMessage());
    }
    // now time to start by showing the first card
    showNextCard();
  }

//Called by loadFile() method and takes a line from the text file and parses
//it into two pieces (question & answer) then creates a new QuizCard and
//adds it to the ArrayList called CardList  
  private void makeCard(String lineToParse) {
    String[] result = lineToParse.split("/");
    QuizCard card = new QuizCard(result[0], result[1]);
    cardList.add(card);
    System.out.println("made a card");
  }

  private void showNextCard() {
    currentCard = cardList.get(currentCardIndex);
    currentCardIndex++;
    display.setText(currentCard.getQuestion());
    nextButton.setText("Show Answer");
    isShowAnswer = true;
  }
}
      




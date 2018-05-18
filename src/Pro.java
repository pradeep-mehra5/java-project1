import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.awt.*;
import java.lang.*;
import java.awt.Color;
import java.util.Random;

public class Pro
{   static JFrame f,frame;
    JButton start; //start button
    JButton cancel;  //cancel button
    JLabel label;    //for setting background image


    Pro()                                                                       //First Frame Constructor
    {
        f=new JFrame("Starting..");                                        //starting Frame
        f.setResizable(false);
        f.setLocation(250,120);
        start=new JButton("START");
        start.setBounds(300,180,200,40);
        start.setBackground(Color.black);
        start.setForeground(Color.white);
        start.setBorder(new RoundedBorder(20));
        start.addActionListener(new Action());
        cancel=new JButton("EXIT");
        cancel.setBackground(Color.black);
        cancel.setBorder(new RoundedBorder(20));
        cancel.setForeground(Color.white);
        cancel.setBounds(300,255,200,40);
        cancel.addActionListener(e -> f.dispose());
        label=new JLabel("Welcome to the Game..!!");
        label.setFont(new Font("Papyrus",Font.BOLD,40));
        label.setForeground(Color.white);
        label.setBounds(145,50,500,75);
        f.add(start);
        f.add(cancel);
        f.add(label);
        f.setSize(800,440);
        f.setLayout(new BorderLayout());
        JLabel background= new JLabel(new ImageIcon("img2.jpg"));
        f.add(background);
        background.setLayout(new FlowLayout());
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args)
    {
        new Pro();
    }
    static class Action implements  ActionListener
    { public void actionPerformed(ActionEvent e)
    {     f.dispose();                                                                      //dispose first frame and show second frame on start button click
        String[] words={"whether","you", "are", "hunting" , "for" ,"useful" ,"crossword" ,     //array of strings to be given as inputs
                "answers", "words", "which" ,"break" ,"common", "spelling", "rules"
                , "or" ,"simply" ,"astonishing","brilliant","sequel","software","unusual"
                ,"words", "to" ,"impress" ,"your" ,"friends", "this" ,"page" ,"has" ,
                "the" ,"wordlists" , "looking" ,"for","not" ,"all" ,"just" ,"for"
                ,"fun", "though" ,"roar","freedom","beautiful","affection","adjective",
                "management","reckless","liberal","project","luck","overwhelming","gladiator"
                ,"received","messaged","technology","imaginary","benefits","applet","swing",
                "sword","these","obviously","metaphor" ,"advanced","rookie","stubborn","magnify",
                "acceleration","although","wordlists" ,"will" ,"also" ,"give" ,"you" ,"the" ,
                "corresponding" ,"British" ,"word" ,"an" ,"Americanism" , "vice" ,"versa",
                "help", "make" ,"piece" ,"of" ,"writing" ,"more" ,"literary" ,"and" ,"reveal"
                ,"some", "phobias", "you" ,"did", "know" ,"existed", "You" ,"can" ,"explore"
                ,"our", "below"};
        String firstRow[] = {"Q","W","E","R","T","Y","U","I","O","P"};                        //keyboard depiction
        String secondRow[] = {"A","S","D","F","G","H","J","K","L","Enter"};
        String thirdRow[] = {"","Z","X","C","V","B","N","M","",""};
        JButton[] first = new JButton[firstRow.length];
        JButton[] second = new JButton[secondRow.length];
        JButton[] third = new JButton[thirdRow.length];


        JLabel wordsCorrect=new JLabel("Words Correctly Typed :");
        JLabel wordsTot=new JLabel("Total Words :");
        final String tempStr=words[new Random().nextInt(words.length)];
        JLabel word=new JLabel(tempStr);                                                     //JLabel showing the word as input
        JLabel ctr1=new JLabel("0");
        JLabel ctr2=new JLabel("0");
        JLabel message=new JLabel("Press ESCAPE submit before time limit");
        JLabel time=new JLabel("Time Limit : 60s");
        time.setFont(new Font("Verdana",Font.BOLD,15));
        frame=new JFrame("Typing Game");
        frame.setLocation(250,120);
        JButton quit=new JButton(new ImageIcon("quit.jpg"));  //button to quit the game
        JTextField tf=new JTextField();
        message.setFont(new Font("Brush Script",Font.ITALIC,15));
        message.setForeground(Color.black);
        wordsCorrect.setFont(new Font("Verdana",Font.BOLD,12));
        wordsTot.setFont(new Font("Verdana",Font.BOLD,12));
        ctr1.setFont(new Font("Verdana",Font.BOLD,25));
        ctr2.setFont(new Font("Verdana",Font.BOLD,25));
        word.setHorizontalAlignment(JLabel.CENTER);
        word.setFont(new Font("Elephant",Font.BOLD,30));

        //SETBOUNDS FOR ALL ELEMENTS
        ctr1.setBounds(250,0,50,50);
        ctr2.setBounds(650,0,50,50);
        time.setBounds(650,50,200,30);
        word.setBounds(270,100,250,70);
        wordsCorrect.setBounds(50,15,200,20);
        wordsTot.setBounds(500,17,100,20);
        quit.setBounds(740,415,50,50);
        tf.setBounds(265,200,270,50);
        message.setBounds(20,435,450,30);
        tf.getInputMap().put(KeyStroke.getKeyStroke("BACK_SPACE"), "none");
        tf.setBackground(new Color(0,0,0));
        tf.setForeground(Color.white);
        tf.setHorizontalAlignment(JTextField.CENTER);
        Font font1 = new Font("SansSerif", Font.BOLD, 20);
        tf.setFont(font1);
        Timer t=new Timer(60000,ac->{
            try {
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_ESCAPE);                               //after 60 seconds there is an automatic ESCAPE press to submit the game
            } catch (AWTException awte) {
                awte.printStackTrace();
            }});
        t.start();



        int x=135;
        for(int i=0;i<10;i++)
        {
            first[i]=new JButton(firstRow[i]);
            first[i].setBounds(x,275,50,50);
            x+=52;
            frame.add(first[i]);
            first[i].setBackground(Color.black);
            first[i].setForeground(Color.white);
            first[i].setBorder(new RoundedBorder(10));
        }
        x=135;
        for(int i=0;i<10;i++) {
            second[i] = new JButton(secondRow[i]);
            second[i].setBounds(x, 327, 50, 50);
            x += 52;
            frame.add(second[i]);
            second[i].setBackground(Color.black);
            second[i].setForeground(Color.white);
            second[i].setBorder(new RoundedBorder(10));
        }
        x=135;
        for(int i=0;i<10;i++)
        {
            third[i]=new JButton(thirdRow[i]);
            third[i].setBounds(x,379,50,50);
            x+=52;
            frame.add(third[i]);
            third[i].setBorder(new RoundedBorder(10));
            third[i].setBackground(Color.black);
            third[i].setForeground(Color.white);
        }

        tf.addKeyListener(new KeyAdapter() {
            int  cor=0;                                            //variable for counting correct words
            int tot=0;                                             //variable for counting total words
            int num=0,i;
            String wordshown=tempStr;                            //string shown at a time as input in JLabel
            @Override
            public void keyPressed(KeyEvent e) {

                if (num == 1) {
                    first[i].setBackground(Color.black);
                    first[i].setForeground(Color.white);
                } else if (num == 2) {
                    second[i].setForeground(Color.white);
                    second[i].setBackground(Color.black);
                } else if (num == 3) {
                    third[i].setBackground(Color.black);
                    third[i].setForeground(Color.white);
                }

                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {                                        //on pressing ESCAPE the game manually submits
                    frame.getContentPane().setBackground(new Color(253, 142, 142));
                    tf.setVisible(false);
                    wordsCorrect.setVisible(false);
                    wordsTot.setVisible(false);
                    word.setVisible(false);
                    ctr1.setVisible(false);
                    ctr2.setVisible(false);
                    quit.setVisible(false);
                    time.setVisible(false);
                    for (int temp = 0; temp < 10; temp++) {
                        first[temp].setVisible(false);
                        second[temp].setVisible(false);
                        third[temp].setVisible(false);
                    }
                    message.setVisible(false);
                    JButton exit, restart;
                    JLabel score, accuracy;
                    exit = new JButton("EXIT");
                    restart = new JButton("RESTART");
                    score = new JLabel("Your score is :" + cor +" words");
                    score.setFont(new Font("Papyrus", Font.BOLD, 25));
                    score.setForeground(Color.white);
                    score.setBounds(250, 100, 300, 40);
                    accuracy = new JLabel("Your Accuracy is :" + ((cor * 100) / tot) + " %");
                    accuracy.setBounds(250, 200, 350, 40);
                    accuracy.setForeground(Color.white);
                    exit.setFont(new Font("Showcard Gothic", Font.BOLD, 17));
                    restart.setFont(new Font("Showcard Gothic", Font.BOLD, 17));
                    score.setForeground(Color.black);
                    accuracy.setForeground(Color.black);
                    accuracy.setFont(new Font("Papyrus", Font.BOLD, 25));
                    exit.setBackground(Color.white);
                    restart.setBackground(Color.white);
                    exit.setForeground(Color.red);
                    restart.setForeground(Color.red);
                    exit.setBorder(new RoundedBorder(15));
                    restart.setBorder(new RoundedBorder(15));
                    exit.setBounds(250, 300, 120, 40);
                    restart.setBounds(400, 300, 120, 40);
                    exit.addActionListener(temp -> {
                        frame.dispose();
                    });
                    restart.addActionListener(emp -> {
                        f.setVisible(true);
                        frame.dispose(); });
                    frame.add(exit);
                    frame.add(restart);
                    frame.add(score);
                    frame.add(accuracy);
                    frame.setSize(800, 440);
                    frame.setLayout(new BorderLayout());
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {//after ENTER check if the word is correct
                    String temp = tf.getText();
                    if (temp.equals(wordshown))
                     {cor++;}                                                                      //counting points
                    tot++;                                                                          // counting total words
                    tf.setText("");
                    ctr1.setText(String.valueOf(cor));
                    ctr2.setText(String.valueOf(tot));
                    wordshown = words[new Random().nextInt(words.length)];
                    word.setText(wordshown);
                }

                num = 0;

                for (i = 0; i < 10; i++) {
                    if (String.valueOf(e.getKeyChar()).equalsIgnoreCase((first[i].getText())))         //highlighting button on click
                    {
                        num = 1;
                        first[i].setForeground(Color.black);
                        first[i].setBackground(Color.white);
                        break;
                    }
                }
                if (num == 0)
                    for (i = 0; i < 10; i++) {
                        if ((String.valueOf(e.getKeyChar()).equalsIgnoreCase((second[i].getText())))) {
                            num = 2;
                            second[i].setForeground(Color.black);
                            second[i].setBackground(Color.white);
                            break;
                        }
                    }
                if (num == 0)
                    for (i = 0; i < 10; i++) {
                        if ((String.valueOf(e.getKeyChar()).equalsIgnoreCase((third[i].getText())))) {
                            num = 3;
                            third[i].setForeground(Color.black);
                            third[i].setBackground(Color.white);
                            break;
                        }
                    }
            }           //keyPressed function ends
        });        //textfield keyadapter ends

        quit.addActionListener(qt->frame.dispose());                    //End game on exit button click

        //Adding Components to game frame
        frame.setLayout(null);
        frame.add(tf);
        frame.add(quit);
        frame.add(word);
        frame.add(wordsCorrect);
        frame.add(wordsTot);
        frame.add(message);
        frame.add(time);
        frame.add(ctr1);
        frame.add(ctr2);
        third[0].setVisible(false);
        second[9].setVisible(false);
        third[9].setVisible(false);
        third[8].setVisible(false);
        frame.getContentPane().setBackground(new Color(193,251,255));
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(800,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }                                                                         //actionPerformed function ends
    }                                                                         //Action class ends

    private static class RoundedBorder implements Border                       //class for making Buttons' borders Round
    {
        private int radius;
        RoundedBorder(int radius) {
            this.radius = radius;
        }
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }
        public boolean isBorderOpaque() {
            return true;
        }
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width-1, height-1, radius, radius);
        }
    }                                                                                    //RoundedBorder ends
}                                                                                       //Pro class Ends

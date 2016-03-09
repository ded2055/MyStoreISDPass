import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

/**
 * Created by Ded on 09.03.2016.
 */
public class MyStoreISDPass {
    JButton findButton = new JButton("Find Password");
    JPanel windowContent = new JPanel();
    JTextField numRestField = new JTextField(3);
    JLabel restLable = new JLabel("Enter rest number: ");
    JLabel dateLabel = new JLabel("Enter date: ");
    JLabel yourPAssLabel = new JLabel("Your Password:");
    JLabel date = new JLabel();
    JLabel passLabel = new JLabel();

    MyStoreISDPass(){
        BorderLayout windowContentLayout = new BorderLayout();
        windowContent.setLayout(windowContentLayout);

        GridLayout p1Layout = new GridLayout(3,2);
        JPanel p1 = new JPanel(p1Layout);

        date.setText(LocalDate.now().toString());
        p1.add(restLable);
        p1.add(numRestField);
        p1.add(dateLabel);
        p1.add(date);
        p1.add(yourPAssLabel);
        p1.add(passLabel);
     //   p1.add(new DatePicker());



        windowContent.add("North",p1);
        windowContent.add("South",findButton);

        PassFinderEngine passEngine = new PassFinderEngine(this);

        findButton.addActionListener(passEngine);


        JFrame frame = new JFrame("Pass finder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(windowContent);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        MyStoreISDPass pass = new MyStoreISDPass();
    }
}

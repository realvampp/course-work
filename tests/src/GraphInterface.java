import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
public class GraphInterface {
    JFrame jfrm;
    long num;
    final long PRIMORIAL = (long)2*3*5*7*11*13*17*19*23*29*31*37*41*43;
    ArrayList<Long> numbers;
    long choice;
    DecimalFormat df = new DecimalFormat("#,###.##");
    GraphInterface(){
        jfrm = new JFrame("Check is prime and factorization");
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(500, 220);
        Box box = new Box(BoxLayout.Y_AXIS);
        jfrm.setContentPane(box);
        JLabel setMode = new JLabel("Оберіть режим роботи");
        JRadioButton addprimo43 = new JRadioButton("Додати до прайморіала 43");
        JRadioButton justnumber = new JRadioButton("Просто перевірити число");
        ButtonGroup bg = new ButtonGroup();
        bg.add(addprimo43);
        bg.add(justnumber);
        JLabel title =new JLabel("Введіть число(непарне), яке ви хочете додати до прайморіала 43");
        JTextField enternum = new JTextField(15);
        JLabel div1 = new JLabel("Множники");
        JLabel isPrimo = new JLabel("Чи є простим");
        JLabel time = new JLabel("Час за який виконано обчислення");

        addprimo43.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice = PRIMORIAL;
            }
        });
        justnumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice = 0;

            }
        });
        enternum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num = Integer.parseInt(enternum.getText()) + choice;
                boolean check = DivisorOvershoot.isPrime(num);
                isPrimo.setText((check) ? "Це число просте" : "Це число складене");
                long start = System.nanoTime();
                SolvingInequalities.Factoring(num);
                double end = (System.nanoTime() - start) / 1e9;
                time.setText(df.format(end) + " секунд витрачено на підрахунки");
                numbers = SolvingInequalities.numbers;
                div1.setText("Множники: " + numbers);
                SolvingInequalities.numbers.clear();
            }
        });

        box.add(setMode);
        box.add(addprimo43);
        box.add(justnumber);
        box.add(title);
        box.add(enternum);
        box.add(isPrimo);
        box.add(div1);
        box.add(time);

        jfrm.setVisible(true);
    }
}

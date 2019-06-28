import javax.swing.JFrame;
import java.awt.*;

public class Application extends JFrame{
    public Application(){
        setTitle("Візуалізація алгоритмів сортування");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridBagLayout());
        add(new SelectionSort(), new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH,
                GridBagConstraints.BOTH, new Insets(10, 10, 10, 10), 0, 0));
        add(new BubbleSort(), new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH,
                GridBagConstraints.BOTH, new Insets(10, 10, 10, 10), 0, 0));
        add(new InsertionSort(), new GridBagConstraints(1, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH,
                GridBagConstraints.BOTH, new Insets(10, 10, 10, 10), 0, 0));
        add(new ShellSort(), new GridBagConstraints(1, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH,
                GridBagConstraints.BOTH, new Insets(10, 10, 10, 10), 0, 0));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Application();
    }

}

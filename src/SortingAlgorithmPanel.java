import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class SortingAlgorithmPanel extends JPanel implements ActionListener {
    
    private int WIDTH = 400;
    private int HEIGHT = 400;

    private int DELAY = 50;
    private Timer timer;

    protected JButton restartBtn, pauseBtn;
    protected JLabel nameLbl;
    protected JLabel iterLbl;

    protected Image background;
    protected String name;
    protected int[] data;
    protected boolean goSort = true;
    protected boolean isSorted = false;
    protected int iterations = 0;

    public SortingAlgorithmPanel(String name){
        setPreferredSize((new Dimension(WIDTH, HEIGHT)));
        setLayout(null);
        this.name = name;
        initVisualComponent();
//        background = Toolkit.getDefaultToolkit().createImage("background.jpg");
        timer = new Timer(DELAY, this);
        timer.start();
        restart();
    }

    private void initVisualComponent(){
        nameLbl = new JLabel(name, SwingConstants.CENTER);
        nameLbl.setLocation(0, 0);
        nameLbl.setFont(new Font("TimesRoman", Font.BOLD, 25));
        nameLbl.setSize(WIDTH, 50);
        add(nameLbl);

        iterLbl = new JLabel("Кількість ітерацій: 0", SwingConstants.CENTER);
        iterLbl.setLocation(0, 50);
        iterLbl.setFont(new Font("TimesRoman", Font.BOLD, 25));
        iterLbl.setSize(WIDTH, 50);
        add(iterLbl);

        restartBtn = new JButton("Restart");
        restartBtn.setLocation(75, 350);
        restartBtn.setSize(100, 25);
        restartBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restart();
            }
        });
        add(restartBtn);

        pauseBtn = new JButton("Pause");
        pauseBtn.setLocation(225, 350);
        pauseBtn.setSize(100, 25);
        pauseBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pause();
            }
        });
        add(pauseBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(goSort){
            sort();
        } else{
            isSorted = isSorted();
        }
        repaint();
    }

    private boolean isSorted(){
        for(int i = 0; i < data.length - 1; i++){
            if(data[i] > data[i + 1]){
                return false;
            }
        }
        return true;
    }
    protected abstract void sort();
    protected abstract void restart();
    protected abstract void pause();
}

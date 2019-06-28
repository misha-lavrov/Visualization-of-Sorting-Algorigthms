import java.awt.*;
import java.util.Random;

public class ShellSort extends SortingAlgorithmPanel{
    private int i, j, d, n;
    private boolean dCycle, iCycle, jCycle;

    public ShellSort(){
        super("Сортування Шелла");
    }

    @Override
    protected void sort() {
        if (dCycle){
            if(d >= 1) {
                dCycle = false;
                jCycle = false;
                iCycle = true;
                i = d;
            }else{
                goSort = false;
            }
        }

        if(iCycle){
            if(i < n){
                iCycle = false;
                dCycle = false;
                jCycle = true;
                j = i;
            }else{
                iCycle = false;
                jCycle = false;
                dCycle = true;
                d /= 2;
            }
        }

        if(jCycle){
           if(j >= d && data[j-d] > data[j]){
                int temp = data[j];
                data[j] = data[j - d];
                data[j - d] = temp;
                j -= d;
            }else{
               jCycle = false;
               dCycle = false;
               iCycle = true;
               i++;
           }
        }
        iterations++;
    }

    @Override
    protected void paintComponent(Graphics g) {
        iterLbl.setText("Кількість ітерацій: " + iterations);
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for(int i = 0; i < data.length; i++){
            if(!isSorted) {
                if (i == this.j) {
                    g2.setColor(Color.ORANGE);
                    g2.fillRect(25 + i * 10, 325 - data[i], 10, data[i]);
                } else if (i == this.j - d) {
                    g2.setColor(Color.GREEN);
                    g2.fillRect(25 + i * 10, 325 - data[i], 10, data[i]);
                }
            }
            g2.setColor(Color.BLACK);
            g2.drawRect(25 + i * 10, 325 - data[i], 10, data[i]);

        }
    }

    @Override
    protected void pause() {
        goSort = !goSort;
    }

    @Override
    protected void restart() {
        iterations = 0;
        data = new int[35];
        n = data.length;
        d = n / 2;
        i = d;
        j = i;
        dCycle = true;
        iCycle = false;
        jCycle = false;
        for(int i = 0; i < data.length; i++){
            data[i] = i * 5 + 5;
        }
        for(int i = 0; i < data.length; i++){
            int temp = data[i];
            int rnd = new Random().nextInt(35);
            data[i] = data[rnd];
            data[rnd] = temp;
        }
        goSort = true;
        isSorted = false;
    }
}

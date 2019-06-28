import java.awt.*;
import java.util.Random;

public class SelectionSort extends SortingAlgorithmPanel{

    private int i, j, max;
    private boolean haveMax;

    public SelectionSort(){
        super("Сортування вибором");
    }

    @Override
    protected void sort() {
        if(i < 0){
            goSort = false;
            return;
        }
        if(i < data.length && haveMax){
            int temp = data[i];
            data[i] = data[max];
            data[max] = temp;
            i--;
            max = i;
            haveMax = false;
            j = 0;
        }
        if(j < i){
            if(data[max] < data[j]){
                max = j;
            }
            j++;
        }else{
            haveMax = true;
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
                if (i == this.max && haveMax) {
                    g2.setColor(Color.ORANGE);
                    g2.fillRect(25 + i * 10, 325 - data[i], 10, data[i]);
                }
                if (i == this.i) {
                    g2.setColor(Color.GREEN);
                    g2.fillRect(25 + i * 10, 325 - data[i], 10, data[i]);
                }
                if (i == j) {
                    g2.setColor(Color.RED);
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
        i = data.length - 1;
        j = 0;
        max = i;
        haveMax = false;
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

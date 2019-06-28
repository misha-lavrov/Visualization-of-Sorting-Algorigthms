import java.awt.*;
import java.util.Random;

public class InsertionSort extends SortingAlgorithmPanel{
    private int i, n, j, key;
    private boolean goSwap;

    public InsertionSort(){
        super("Сортування вставкою");
    }

    @Override
    protected void sort() {
        if(i < n){
            if(!goSwap){
                key = data[i];
                j = i - 1;
                goSwap = true;
            }
            if(goSwap && j >= 0 && data[j] > key){
                data[j + 1] = data[j];
                j--;
            }else{
                i++;
                goSwap = false;
                data[j + 1] = key;
            }

        }else{
            goSort = false;
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
                if (i == this.i) {
                    g2.setColor(Color.ORANGE);
                    g2.fillRect(25 + i * 10, 325 - data[i], 10, data[i]);
                } else if (i == this.j) {
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
        i = 1;
        j = i - 1;
        key = data[i];
        n = data.length;
        goSwap = false;
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

import java.awt.*;
import java.util.Random;

public class BubbleSort extends SortingAlgorithmPanel{
    private int i, n;

    public BubbleSort(){
        super("Сортування бульбашкою");
    }

    @Override
    protected void sort() {
        if(i < n - 1){
            if(data[i] > data[i + 1]){
                int temp = data[i];
                data[i] = data[i + 1];
                data[i + 1] = temp;
            }
            i++;
        }else{
            i = 0;
            n--;
        }
        if(n == 1){
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
            if(!isSorted){
                if(i == this.i){
                    g2.setColor(Color.ORANGE);
                    g2.fillRect(25 + i * 10, 325 - data[i], 10, data[i]);
                }else if(i == this.i + 1){
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
        i = 0;
        data = new int[35];
        n = data.length;
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

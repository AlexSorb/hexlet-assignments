package exercise;

// BEGIN
public class MinThread extends Thread{
    private int[] array;
    private Integer min;

    public MinThread(int[] array) {
        this.array = array;
        min = null;
    }

    @Override
    public void run() {
        var currentThread = Thread.currentThread().getName();
        System.out.printf("INFO: Thread %s started%n", currentThread);
        min = array[0];
        for (int i = 0 ; i < array.length; i++) {
            min = (min > array[i]) ? array[i] : min;
        }
        System.out.printf("INFO: Thread %s finished%n", currentThread);
    }

    public Integer getMin() {
        return min;
    }

}
// END

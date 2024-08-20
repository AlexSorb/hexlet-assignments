package exercise;

// BEGIN
public class MaxThread extends Thread {

    private int[] array;
    private Integer max;

    public MaxThread(int[] array) {
        this.array = array;
        this.max = null;
    }

    @Override
    public void run() {
        var currentThread = Thread.currentThread().getName();
        System.out.printf("INFO: Thread %s started%n", currentThread);
        max = array[0];
        for (int i = 0 ; i < array.length; i++) {
            max = (max < array[i]) ? array[i] : max;
        }
        System.out.printf("INFO: Thread %s finished%n", currentThread);
    }

    public Integer getMax() {
        return max;
    }

}
// END

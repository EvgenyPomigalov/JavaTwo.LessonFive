import java.util.Arrays;

public class LessonFive {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
    method1();
    method2();
    }

    private static void method1(){
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        fillArr(arr);
        System.out.println("Время на заполнение в 1 методе - " + (System.currentTimeMillis() - a));
    }

    private static void method2() {
        try {
            long allTime =System.currentTimeMillis();
            float[] arr = new float[size];
            Arrays.fill(arr, 1);
            long a = System.currentTimeMillis();
            float[] a1 = new float[h];
            float[] a2 = new float[h];
            System.arraycopy(arr, 0, a1, 0, h);
            System.arraycopy(arr, h, a2, 0, h);
            System.out.println("Время разбивки на 2 - " + (System.currentTimeMillis() - a));
            MyThread t0 = new MyThread("t0", a1);
            MyThread t1 = new MyThread("t1", a2);
            t0.join();
            t1.join();
            a = System.currentTimeMillis();
            System.arraycopy(a1, 0, arr, 0, h);
            System.arraycopy(a2, 0, arr, h, h);
            System.out.println("Время на склейку - " + (System.currentTimeMillis() - a));
            System.out.println("Общее время выполнения во 2 методе - " + (System.currentTimeMillis() - allTime));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void fillArr(float[] arrToFill) {
        for (int i = 0; i < arrToFill.length; i++)
            arrToFill[i] = (float)(arrToFill[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }


}

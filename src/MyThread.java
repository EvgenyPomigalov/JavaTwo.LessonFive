public class MyThread extends Thread {
    private float[] arr;
    public MyThread(String name, float[] arr) {
        super(name);
        this.arr = arr;
        start();
    }

    @Override
    public void run() {
       fillArr(arr);
    }
    private void fillArr(float[] arrToFill) {
        long a = System.currentTimeMillis();
        for (int i = 0; i < arrToFill.length; i++)
            arrToFill[i] = (float)(arrToFill[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
       System.out.println("Время просчета массива в потоке " + Thread.currentThread().getName() +": " + (System.currentTimeMillis() - a));
    }
}

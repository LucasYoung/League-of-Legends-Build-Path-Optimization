/*
 * Decompiled with CFR 0_115.
 */
import java.io.PrintStream;

public class Timer
implements Runnable {
    private int halfSeconds = 0;

    public int getHalfSeconds() {
        return this.halfSeconds;
    }

    @Override
    public void run() {
        try {
            Thread.currentThread();
            Thread.sleep(500);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        ++this.halfSeconds;
        this.run();
    }
}


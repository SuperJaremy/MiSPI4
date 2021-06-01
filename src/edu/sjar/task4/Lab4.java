package edu.sjar.task4;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// var. 2162
public class Lab4 {
    public static void main(String[] args) {
        B a = new B();
        B b = new E();
        E c = new E();
        a.z10();
        b.z5();
        b.z33();
        a.z7();
        a.z1();
        a.z15();
        b.z42();
        b.z9();
        b.z24();
        a.z25();
        a.z36(a);
        a.z36(b);
        c.z36(c);
        c.z38();
        c.z22();
        c.z28();
        Thread t = new Thread(() -> {
            E d = new E();
            while (true) {
                try {
                    d.z21();
                    Thread.sleep(7);
                } catch (Exception e) {
                }
            }
        });
        t.start();
    }
}

class B {
    private final String STRINGS_OUT_FILE = "stringsOut.txt";
    private final String HELLO_WORLD_WRTR_FILE = "helloWorldWrtr.txt";
    private final String PRINT_STREAM_FILE = "printStream.txt";

    int z32;
    int z8;
    int z44;
    int z18;
    int z46;
    long z29;
    long z23;
    long z39;
    ObjectOutputStream stringsOut;
    ObjectOutputStream helloWorldWrtr;
    ObjectOutputStream printStream;

    Map<URL, byte[]> cache = new HashMap<>();
    int z14;
    int z35;

    List<String> z12 = new ArrayList<>();

    public B() {
        z32 = 8;
        z8 = 4;
        z44 = 1;
        z18 = 2;
        z46 = 0;
        z29 = 2L;
        z23 = 3L;
        z39 = 9L;
        try {
            stringsOut = new ObjectOutputStream(new FileOutputStream(STRINGS_OUT_FILE));
            helloWorldWrtr = new ObjectOutputStream(new FileOutputStream(HELLO_WORLD_WRTR_FILE));
            printStream = new ObjectOutputStream(new FileOutputStream(PRINT_STREAM_FILE));
        } catch (Exception e) {
        }
    }

    public void init() {
        try {
            if (stringsOut == null) {
                stringsOut = new ObjectOutputStream(new FileOutputStream(STRINGS_OUT_FILE));
            }
            System.out.println("Thread : " + Thread.currentThread() + ", stringsOut = " + stringsOut);
        } catch (Exception e) {
        }

        try {
            if (helloWorldWrtr == null) {
                helloWorldWrtr = new ObjectOutputStream(new FileOutputStream(HELLO_WORLD_WRTR_FILE));
            }
            System.out.println("Thread : " + Thread.currentThread() + ", helloWorldWrtr = " + helloWorldWrtr);
        } catch (Exception e) {
        }

        try {
            if (printStream == null)
                printStream = new ObjectOutputStream(new FileOutputStream(PRINT_STREAM_FILE));
            System.out.println("Thread : " + Thread.currentThread() + ", printStream = " + printStream);
        } catch (Exception e) {
        }
    }

    public byte[] getValueFromCache(String s) {
        try {
            URL url = new URL(s);
            if (!cache.containsKey(url)) {
                cache.put(url, new byte[262144]);
            }
            return cache.get(url);
        } catch (Exception e) {
            System.out.println("Error: invalid URL!");
            return null;
        }
    }

    public void z10() {
        Thread t = new Thread(() -> {
            init();
            int i = 0;
            while (true) {
                i++;
                try {
                    synchronized (printStream) {
                        printStream.writeObject("метод z10 в классе B (#" + i + ")");
                        Thread.sleep(5);
                        printStream.flush();
                        printStream.reset();
                    }
                } catch (Exception e) {
                }
            }
        });
        t.start();
    }

    public void z5() {
        Thread t = new Thread(() -> {
            init();
            int i = 0;
            while (true) {
                i++;
                try {
                    synchronized (stringsOut) {
                        stringsOut.writeObject("метод z5 в классе B (#" + i + ")");
                        Thread.sleep(6);
                        stringsOut.flush();
                        stringsOut.reset();
                    }
                } catch (Exception e) {
                }
            }
        });
        t.start();
    }

    public void z33() {
        Thread t = new Thread(() -> {
            init();
            int i = 0;
            while (true) {
                i++;
                try {
                    synchronized (printStream) {
                        printStream.writeObject("метод z33 в классе B (#" + i + ")");
                        Thread.sleep(5);
                        printStream.flush();
                        printStream.reset();
                    }
                } catch (Exception e) {
                }
            }
        });
        t.start();
    }

    public void z7() {
        Thread t = new Thread(() -> {
            init();
            int i = 0;
            while (true) {
                i++;
                try {
                    synchronized (printStream) {
                        printStream.writeObject("метод z7 в классе B (#" + i + ")");
                        Thread.sleep(6);
                        printStream.flush();
                        printStream.reset();
                    }
                } catch (Exception e) {
                }
            }
        });
        t.start();
    }

    public void z1() {
        Thread t = new Thread(() -> {
            init();
            int i = 0;
            while (true) {
                i++;
                try {
                    synchronized (printStream) {
                        printStream.writeObject("метод z1 в классе B (#" + i + ")");
                        Thread.sleep(6);
                        printStream.flush();
                        printStream.reset();
                    }
                } catch (Exception e) {
                }
            }
        });
        t.start();
    }

    public void z15() {
        Thread t = new Thread(() -> {
            init();
            int i = 0;
            while (true) {
                i++;
                try {
                    synchronized (printStream) {
                        printStream.writeObject("метод z15 в классе B (#" + i + ")");
                        Thread.sleep(6);
                        printStream.flush();
                        printStream.reset();
                    }
                } catch (Exception e) {
                }
            }
        });
        t.start();
    }

    public void z42() {
        System.out.println("метод z42 в классе B");
        System.out.println(z14);
    }

    public void z9() {
        System.out.println("метод z9 в классе B");
        System.out.println((z14 + 4));
    }

    public void z24() {
        System.out.println("метод z24 в классе B");
        System.out.println(z35);
    }

    public void z25() {
        System.out.println("метод z25 в классе B");
        System.out.println((z35 + 3));
    }

    public void z36(B r) {
        r.z10();
    }

}

class E extends B {
    private final int MAX_CAPACITY = 16384;
    private final String GOOGLE_LINK = "https://www.google.com";

    public E() {
        z32 = 5;
        z8 = 7;
        z18 = 9;
        z23 = 3L;
        z39 = 0L;
    }

    public void z1() {
        Thread t = new Thread(() -> {
            init();

            int i = 0;
            while (true) {
                i++;
                try {
                    synchronized (helloWorldWrtr) {
                        helloWorldWrtr.writeObject("метод z1 в классе E (#" + i + ")");
                        Thread.sleep(14);
                        helloWorldWrtr.flush();
                        helloWorldWrtr.reset();
                    }
                } catch (Exception e) {
                }
            }
        });
        t.start();
    }

    public void z15() {
        Thread t = new Thread(() -> {
            init();
            int i = 0;
            while (true) {
                i++;
                try {
                    synchronized (printStream) {
                        printStream.writeObject("метод z15 в классе E (#" + i + ")");
                        Thread.sleep(5);
                        printStream.flush();
                        printStream.reset();
                    }
                } catch (Exception e) {
                }
            }
        });
        t.start();
    }

    public void z38() {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    synchronized (cache) {
                        getValueFromCache(GOOGLE_LINK);
                        Thread.sleep(6);
                    }
                } catch (Exception e) {
                }
            }
        });
        t.start();
    }

    public void z22() {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    synchronized (cache) {
                        getValueFromCache(GOOGLE_LINK);
                        Thread.sleep(14);
                    }
                } catch (Exception e) {
                }
            }
        });
        t.start();
    }

    public void z28() {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    synchronized (cache) {
                        getValueFromCache(GOOGLE_LINK);
                        Thread.sleep(14);
                    }
                } catch (Exception e) {
                }
            }
        });
        t.start();
    }

    public void z42() {
        System.out.println("метод z42 в классе E");
        System.out.println(z14++);
    }

    public void z9() {
        System.out.println("метод z9 в классе E");
        System.out.println(z35);
    }

    public void z24() {
        System.out.println("метод z24 в классе E");
        System.out.println((z35 - 3));
    }

    public void z25() {
        System.out.println("метод z25 в классе E");
        System.out.println(z35);
    }

    public void z21() {
        if (this.z12.size() > MAX_CAPACITY) {
            this.z12.clear();
            System.gc();
        }
        for (int i = 0; i < 7; i++) {
            this.z12.add(String.valueOf(System.nanoTime()));
//             System.out.println(new Date() + " - " + this.z12.size());
        }
    }

    public void z36(B r) {
        r.z33();
    }

    public void z36(E r) {
        r.z7();
    }
}

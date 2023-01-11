package ThreadTest;

import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

import java.util.concurrent.Callable;

public class Thread1 implements Callable<String> {
    public Thread1(){}
    @Override
    public String call() throws Exception {
        int upperLimit = Integer.MAX_VALUE/100000;
        for (int i = 0; i < upperLimit; i++) {
            if(i % 100 == 0) {
                System.out.println(i + "\t\t" + upperLimit);
                Thread.sleep(10);
            }
        }
        return "DONE WITH CALLABLE";
    }
}

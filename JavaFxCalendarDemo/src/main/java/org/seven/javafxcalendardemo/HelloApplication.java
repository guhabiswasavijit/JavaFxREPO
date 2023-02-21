package org.seven.javafxcalendardemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
@SpringBootApplication
public class HelloApplication extends Application {
    private ConfigurableApplicationContext springContext;
    private Parent root;
    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(HelloApplication.class);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        fxmlLoader.setControllerFactory(springContext::getBean);
        root = fxmlLoader.load();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        springContext.stop();
    }

    public static void main(String[] args) {
        System.out.println("Running my java");
        launch();
    }
}
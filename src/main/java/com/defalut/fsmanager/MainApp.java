package com.defalut.fsmanager;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Главный класс приложения файлового менеджера.
 * Отвечает за инициализацию JavaFX и загрузку интерфейса.
 */
public class MainApp extends Application {
    /**
     * Логгер для записи событий приложения.
     */
    static final Logger logger = LogManager.getLogger(MainApp.class);

    /**
     * Метод для запуска приложения.
     *
     * @param primaryStage Основная сцена JavaFX.
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FileManager.fxml"));
            Scene scene = new Scene(loader.load());
            primaryStage.setTitle("Файловый менеджер");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            logger.error("Ошибка загрузки интерфейса", e);
            CustomExceptionHandler.handleException("Ошибка загрузки интерфейса", e);
        }
    }

    /**
     * Главный метод для запуска JavaFX-приложения.
     *
     * @param args Аргументы командной строки.
     */
    public static void main(String[] args) {
        launch(args);
    }
}

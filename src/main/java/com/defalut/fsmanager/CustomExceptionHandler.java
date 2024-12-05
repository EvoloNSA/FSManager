package com.defalut.fsmanager;


import javafx.scene.control.Alert;

/**
 * Утилитный класс для обработки исключений в приложении.
 * Показывает пользователю уведомления об ошибках.
 */
public class CustomExceptionHandler {

    /**
     * Обрабатывает исключение, выводя сообщение об ошибке в диалоговом окне.
     *
     * @param message Сообщение об ошибке.
     * @param e       Исключение, которое требуется обработать.
     */
    public static void handleException(String message, Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText(message);
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }
}

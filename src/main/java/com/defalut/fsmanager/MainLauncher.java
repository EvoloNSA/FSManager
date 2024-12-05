package com.defalut.fsmanager;

/**
 * Класс MainLauncher используется для запуска основного приложения.
 * Этот класс необходим для обхода ограничений некоторых окружений, таких как пакеты JavaFX,
 * где точка входа должна находиться в отдельном классе.
 */
public class MainLauncher {
    /**
     * Точка входа для запуска приложения.
     *
     * @param args Аргументы командной строки.
     */
    public static void main(String[] args) {
        MainApp.main(args);
    }
}
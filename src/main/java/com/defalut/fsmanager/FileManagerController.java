package com.defalut.fsmanager;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.List;

import static com.defalut.fsmanager.MainApp.logger;

/**
 * Контроллер для управления интерфейсом файлового менеджера.
 * Отвечает за взаимодействие с пользователем.
 */
public class FileManagerController {

    /**
     * Список файлов в текущем каталоге.
     */
    @FXML
    private ListView<String> fileListView;

    /**
     * Метка для отображения текущего выбранного каталога.
     */
    @FXML
    private Label selectedFileLabel;

    /**
     * Текущая директория, отображаемая в приложении.
     */
    private File currentDirectory;

    /**
     * Инициализация контроллера. Загружает список файлов из домашней директории пользователя.
     */
    @FXML
    public void initialize() {
        currentDirectory = new File(System.getProperty("user.home"));
        loadFiles(currentDirectory);
    }

    /**
     * Обрабатывает событие копирования файла.
     * Показывает диалог выбора файла и каталога назначения.
     *
     * @param event Событие клика мыши.
     */
    @FXML
    public void onCopyFileClick(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выберите файл для копирования");
        File sourceFile = fileChooser.showOpenDialog(null);

        if (sourceFile != null) {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("Выберите папку назначения");
            File destinationDirectory = directoryChooser.showDialog(null);

            if (destinationDirectory != null) {
                try {
                    FileUtils.copyFile(sourceFile, destinationDirectory);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Успех");
                    alert.setHeaderText("Файл успешно скопирован!");
                    alert.showAndWait();
                } catch (Exception e) {
                    logger.error("Ошибка при копировании файла", e);
                    CustomExceptionHandler.handleException("Ошибка при копировании файла", e);
                }
            }
        }
    }

    /**
     * Загружает список файлов и директорий из указанной папки.
     *
     * @param directory Папка, содержимое которой требуется отобразить.
     */
    private void loadFiles(File directory) {
        try {
            fileListView.getItems().clear();
            File[] files = directory.listFiles();

            if (files != null) {
                if (file.isHidden()) {
                        continue;
                    }
                for (File file : files) {
                    long fileSize = file.isFile() ? file.length() : 0;
                    fileListView.getItems().add(file.getName() + " (" + fileSize + " байт)");
                }
            }

            selectedFileLabel.setText("Текущая директория: " + directory.getAbsolutePath());
            currentDirectory = directory;
        } catch (Exception e) {
            logger.error("Ошибка загрузки файлов", e);
            CustomExceptionHandler.handleException("Ошибка загрузки файлов", e);
        }
    }
}

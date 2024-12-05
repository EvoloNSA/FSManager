module com.defalut.fsmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires org.apache.logging.log4j;

    opens com.defalut.fsmanager to javafx.fxml;
    exports com.defalut.fsmanager;
}
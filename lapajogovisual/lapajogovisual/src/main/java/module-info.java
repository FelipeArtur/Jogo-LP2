module com.felipe.lapajogovisual {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.felipe.lapajogovisual to javafx.fxml;
    exports com.felipe.lapajogovisual;
}

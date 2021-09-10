module com.mycompany.examen20212e {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.examen20212e to javafx.fxml;
    exports com.mycompany.examen20212e;
}

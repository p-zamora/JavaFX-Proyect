module sunat.gob.pe.medicalsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    
    opens sunat.gob.pe.medicalsystem.model.utils to java.sql;
    opens sunat.gob.pe.medicalsystem.controller to javafx.fxml;
    exports sunat.gob.pe.medicalsystem.controller;
    exports sunat.gob.pe.medicalsystem;    
}

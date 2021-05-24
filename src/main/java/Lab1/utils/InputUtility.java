package Lab1.utils;

import Lab1.controller.PatientController;
import Lab1.entities.Patient;
import Lab1.model.PatientModel;
import Lab1.view.PatientView;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class InputUtility {
    private PatientView patientView = new PatientView();
    private Scanner sc = new Scanner(System.in);
    private PatientController patientController = new PatientController();
    static Logger logger = Logger.getLogger(PatientController.class);
    private Patient patient = new Patient();

    public InputUtility() throws FileNotFoundException {
    }

    public void start() throws IOException, ClassNotFoundException {
        String action;
        patientController.loadData();
        patientView.printMessage(patientView.INPUT_DATA);
        while (!sc.hasNext("4")) {
            action = sc.nextLine();
            patientController.calculate(action);
        }

        FileAppender appender = new FileAppender(new SimpleLayout(), "log.xml");
        logger.setLevel(Level.DEBUG);
        logger.addAppender(appender);
        logger.debug(patient.toString());
        patientView.printMessage(patientView.END_DATA);
        patientController.out.close();
        patientController.transferData();
    }
}
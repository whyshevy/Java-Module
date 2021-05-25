package Lab1.utils;

import Lab1.controller.PatientController;
import Lab1.entities.Patient;
import Lab1.model.PatientModel;
import Lab1.view.PatientView;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class InputUtility {
    private PatientView patientView = new PatientView();
    private Scanner sc = new Scanner(System.in);
    private PatientController patientController = new PatientController();
    static Logger logger = Logger.getLogger(InputUtility.class);
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
        DOMConfigurator.configure("log4j.xml");
        patientController.out.close();
        patientController.transferData();
        logger.debug("Log4j appender configuration is successfull !!! \n");
        patientView.printMessage(patientView.END_DATA);
    }
}
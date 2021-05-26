package Lab1.utils;

import Lab1.controller.PatientController;
import Lab1.entities.Patient;
import Lab1.view.PatientView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class InputUtility {
    private PatientView patientView = new PatientView();
    private Scanner sc = new Scanner(System.in);
    private PatientController patientController = new PatientController();
    private Patient patient = new Patient();

    public InputUtility() throws FileNotFoundException {
    }

    public void start() throws IOException, ClassNotFoundException {
        String action;
        try {
            patientController.loadData();
        } catch (IOException e) {
            patientController.logger.error(patientView.LOG_SERIAZABLE_FILE_NOT_FOUND);
        }
        patientView.printMessage(patientView.INPUT_DATA);
        while (!sc.hasNext("4")) {
            action = sc.nextLine();
            patientController.calculate(action);
        }
        patientController.out.close();
        patientController.transferData();
        patientView.printMessage(patientView.END_DATA);
        patientController.logger.info(patientView.LOG_USER_FINISHED);
    }
}
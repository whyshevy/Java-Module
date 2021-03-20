package Lab1.utils;

import Lab1.controller.PatientController;
import Lab1.view.PatientView;

import java.util.Scanner;

public class InputUtility {
    private PatientView patientView = new PatientView();
    private Scanner sc = new Scanner(System.in);
    private PatientController patientController = new PatientController();
    public void start() {
        String action;
        patientView.printMessage(patientView.INPUT_DATA);
        while(!sc.hasNext("4")) {
            action = sc.nextLine();
            patientController.calculate(action);
        }
        patientView.printMessage(patientView.END_DATA);
    }
}
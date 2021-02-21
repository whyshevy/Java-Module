package Lab1.controller;

import Lab1.model.PatientInfo;
import Lab1.model.PatientModel;
import Lab1.view.PatientView;

import java.util.Scanner;

public class PatientController {
    private static final Scanner sc = new Scanner(System.in);
    private final PatientView view = new PatientView();
    private final PatientModel patientModel = new PatientModel(10);

    public void start() {
        String action;
        view.printMessage(view.INPUT_DATA);
        while(!sc.hasNext("4")) {
            action = sc.nextLine();
            calculate(action);
        }
        view.printMessage(view.END_DATA);
    }

    private void calculate(String action) {

        PatientInfo[] patientInfos = new PatientInfo[0];

        if (action.equalsIgnoreCase("1")) {
            patientInfos = showAllPatientValues();
        } else if (action.equalsIgnoreCase("2")) {
            patientInfos = showPatientsByDiagnosis();
        } else if (action.equalsIgnoreCase("3")) {
            patientInfos = showPatientsByCardNumber();
        } else {
            view.printMessage(view.WRONG_INPUT_DATA);
        }

        if (patientInfos.length > 0) {
            view.printMessageAndResult(view.RESULT + System.lineSeparator() + view.COLUMNS, patientInfos);
            view.printMessage(System.lineSeparator());
        } else {
            view.printMessage(view.NO_DATA + System.lineSeparator());
        }

        view.printMessage(view.INPUT_DATA);
    }

    private PatientInfo[] showAllPatientValues() {
        return patientModel.getAllPatientValues();
    }
    private PatientInfo[] showPatientsByDiagnosis() {
        view.printMessage(view.SELECT_DIAGNOSIS);
        String diagnosis = sc.nextLine();
        return patientModel.getPatientsByDiagnosis(diagnosis);
    }
    private PatientInfo[] showPatientsByCardNumber() {
        view.printMessage(view.SELECT_MEDICAL_CARD_NUMBER_FIRST);
        String firstCardNumber = sc.nextLine();
        view.printMessage(view.SELECT_MEDICAL_CARD_NUMBER_SECOND);
        String secondCardNumber = sc.nextLine();
        return patientModel.getPatientsByMedicalCardRange(firstCardNumber, secondCardNumber);
    }
}

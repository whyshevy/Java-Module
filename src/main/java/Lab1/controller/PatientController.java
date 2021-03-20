package Lab1.controller;

import Lab1.controller.exceptions.MedicalCardNumberIsOutOfBoundsException;
import Lab1.controller.validator.Validator;
import Lab1.entities.Patient;
import Lab1.model.PatientModel;
import Lab1.view.PatientView;

import java.util.Scanner;

public class PatientController {
    private static final Scanner sc = new Scanner(System.in);
    private final PatientView patientView = new PatientView();
    private final PatientModel patientModel = new PatientModel(10);

    public void calculate(String action) {

        Patient[] patients = new Patient[]{};

        switch (action) {
            case "1":
                patients = showAllPatientValues();
                break;
            case "2":
                patients = showPatientsByDiagnosis();
                break;
            case "3":
                patients = showPatientsByCardNumber();
                break;
            default:
                patientView.printMessage(patientView.WRONG_INPUT_DATA);
                break;
        }

        if (patients != null) {
            if (patients.length > 0) {
                patientView.printMessageAndResult(patientView.RESULT + System.lineSeparator() + patientView.COLUMNS, patients);
                patientView.printMessage(System.lineSeparator());
            } else {
                patientView.printMessage(patientView.NO_DATA + System.lineSeparator());
            }
        }
        patientView.printMessage(patientView.INPUT_DATA);
    }

    private Patient[] showAllPatientValues() {
        return patientModel.getAllPatientValues();
    }

    private Patient[] showPatientsByDiagnosis() {
        patientView.printMessage(patientView.SELECT_DIAGNOSIS);
        String diagnosis = sc.nextLine();
        return patientModel.getPatientsByDiagnosis(diagnosis);
    }

    private Patient[] showPatientsByCardNumber() {
        String firstCardNumber;
        String secondCardNumber;
        try {
            patientView.printMessage(patientView.SELECT_MEDICAL_CARD_NUMBER_FIRST);
            if (sc.hasNextLine()) {
                firstCardNumber = sc.nextLine();
            }
            else {
                throw new NumberFormatException(PatientView.NUMBER_EXCEPTION);
            }
            patientView.printMessage(patientView.SELECT_MEDICAL_CARD_NUMBER_SECOND);
            if (sc.hasNextInt()) {
                secondCardNumber = sc.nextLine();
            }
            else {
                throw new NumberFormatException(PatientView.NUMBER_EXCEPTION);
            }
            int firstParseRange = Integer.parseInt(firstCardNumber);
            int secondParseRange = Integer.parseInt(secondCardNumber);
            Validator.checkMedicalCardNumbersThatNotExists(firstParseRange, secondParseRange);
            return patientModel.getPatientsByMedicalCardRange(firstParseRange, secondParseRange);
        } catch (NumberFormatException e) {
            System.err.println(PatientView.NUMBER_EXCEPTION);
        } catch (MedicalCardNumberIsOutOfBoundsException e) {
            System.err.println(PatientView.OUT_OF_RANGE_EXCEPTION);
        }
        return null;
    }
}


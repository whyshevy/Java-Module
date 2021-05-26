package Lab1.controller;

import Lab1.controller.exceptions.MedicalCardNumberIsOutOfBoundsException;
import Lab1.controller.validator.Validator;
import Lab1.entities.Patient;
import Lab1.model.PatientModel;
import Lab1.utils.InputUtility;
import Lab1.view.PatientView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class PatientController {
    private static final Scanner sc = new Scanner(System.in);
    public PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
    private final PatientView patientView = new PatientView();
    private final PatientModel patientModel = new PatientModel();
    public Logger logger = LogManager.getLogger(PatientController.class);

    public PatientController() throws FileNotFoundException {
    }


    public void calculate(String action) {

        Patient[] patients = new Patient[]{};

        switch (action) {
            case "1":
                patients = showAllPatientValues();
                Arrays.asList(patients).forEach((patient -> out.println(patient)));
                out.println("\n");
                logger.info(patientView.LOG_ALL_VALUES);
                logger.info(patientView.LOG_INTERMEDIATE_DATA);
                break;
            case "2":
                patients = showPatientsByDiagnosis();
                Arrays.asList(patients).forEach((patient -> out.println(patient)));
                out.println("\n");
                logger.info(patientView.LOG_SEARCHED_PATIENTS_BY_DIAGNOSIS);
                logger.info(patientView.LOG_INTERMEDIATE_DATA);
                break;
            case "3":
                patients = showPatientsByCardNumber();
                if (patients != null) {
                    Arrays.asList(patients).forEach((patient -> out.println(patient)));
                    out.println("\n");
                    logger.info(patientView.LOG_SEARCHED_PATIENTS_BY_MEDICAL_CARD);
                    logger.info(patientView.LOG_INTERMEDIATE_DATA);
                } else
                    break;
            default:
                patientView.printMessage(patientView.WRONG_INPUT_DATA);
                Arrays.asList(patients).forEach((patient -> out.println(patient)));
                logger.warn(patientView.LOG_USER_ENTERD_WRONG_ACTION);
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

    public void transferData() throws IOException {
        FileOutputStream os = new FileOutputStream("data.ser");
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(patientModel.getAllPatientValues());
        oos.close();
    }

    public void loadData() throws IOException, ClassNotFoundException {
        FileInputStream is = new FileInputStream("data.ser");
        ObjectInputStream ois = new ObjectInputStream(is);
        var object = ois.readObject();
        ois.close();
        patientModel.patientsInfos = (Patient[]) object;
        logger.info(patientView.LOG_DATA_IS_LOADED);
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
            } else {
                logger.warn(patientView.LOG_USER_ENTERED_WRONG_FORMAT_VALUES);
                throw new NumberFormatException(PatientView.NUMBER_EXCEPTION);
            }
            patientView.printMessage(patientView.SELECT_MEDICAL_CARD_NUMBER_SECOND);
            if (sc.hasNextInt()) {
                secondCardNumber = sc.nextLine();
            } else {
                logger.warn(patientView.LOG_USER_ENTERED_WRONG_FORMAT_VALUES);
                throw new NumberFormatException(PatientView.NUMBER_EXCEPTION);
            }
            int firstParseRange = Integer.parseInt(firstCardNumber);
            int secondParseRange = Integer.parseInt(secondCardNumber);
            Validator.checkMedicalCardNumbersThatNotExists(firstParseRange, secondParseRange);
            return patientModel.getPatientsByMedicalCardRange(firstParseRange, secondParseRange);
        } catch (NumberFormatException e) {
            logger.warn(patientView.LOG_USER_ENTERED_WRONG_FORMAT_VALUES);
            System.err.println(PatientView.NUMBER_EXCEPTION);
        } catch (MedicalCardNumberIsOutOfBoundsException e) {
            logger.warn(patientView.LOG_USER_ENTERED_WRONG_RANGE_OR_SAME_NUM);
            System.err.println(PatientView.OUT_OF_RANGE_EXCEPTION);
        }
        return null;
    }
}


package Lab1.view;

import Lab1.entities.Patient;

public class PatientView {
    public final String INPUT_DATA = "Enter the number what action you want to perform: \n1)To view all values \n2)Search patients by diagnosis \n3)Search patients by medical card number \n4)To Exit \n";

    public final String END_DATA = "See you next time!";

    public final String LOG_ALL_VALUES = "User viewed table of all values";

    public final String LOG_SEARCHED_PATIENTS_BY_DIAGNOSIS = "User searched patients by certain diagnosis";

    public final String LOG_SEARCHED_PATIENTS_BY_MEDICAL_CARD = "User searched patients in range of medical card numbers";

    public final String LOG_INTERMEDIATE_DATA = "Intermediate data loaded into output.txt file";

    public final String LOG_SERIAZABLE_FILE_NOT_FOUND = "File data.ser is missing";

    public final String LOG_DATA_IS_LOADED = "Data from data.ser is loaded";

    public final String LOG_USER_ENTERD_WRONG_ACTION = "User entered wrong or non-existent action";

    public final String LOG_USER_FINISHED = "User exit the program";

    public final String LOG_USER_ENTERED_WRONG_FORMAT_VALUES = "User entered wrong format values in medical card number search action";

    public final String LOG_USER_ENTERED_WRONG_RANGE_OR_SAME_NUM = "User entered wrong range of existing numbers or maybe entered the same number twice!";

    public final String WRONG_INPUT_DATA = "Wrong input!";

    public static final String OUT_OF_RANGE_EXCEPTION = "You entered wrong range of existing numbers or maybe you entered the same number twice!";

    public static final String NUMBER_EXCEPTION = "Values that you entered, are in a wrong format!";

    public final String NO_DATA = "Nothing have been found!";

    public final String SELECT_DIAGNOSIS = "Enter diagnosis, which you're looking for:\n";

    public final String SELECT_MEDICAL_CARD_NUMBER_FIRST = "Enter first in range medical card number, which you're looking for:\n";

    public final String SELECT_MEDICAL_CARD_NUMBER_SECOND = "Enter second in range medical card number, which you're looking for:\n";

    public final String RESULT = String.format("%125s", "|Patients Info|");

    public final String COLUMNS = String.format("%20s:%20s:%20s:%30s:%30s:%30s:%30s:%30s:",
            "ID",
            "Name",
            "Surname",
            "Patronymic",
            "Address",
            "PhoneNumber",
            "MedicalCardNumber",
            "Diagnosis"
    );

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printMessageAndResult(String message, Patient[] patients) {
        System.out.println(message);
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }
}

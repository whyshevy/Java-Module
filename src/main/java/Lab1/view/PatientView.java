package Lab1.view;

import Lab1.model.PatientInfo;

public class PatientView {
    public final String INPUT_DATA = "Enter the number what action you want to perform: \n1)To view all values \n2)Search patients by diagnosis \n3)Search patients by medical card number \n4)To Exit \n";

    public final String END_DATA = "See you next time!";

    public final String WRONG_INPUT_DATA = "Wrong input! ";

    public final String NO_DATA = "Nothing have been found!";

    public final String SELECT_DIAGNOSIS = "Enter diagnosis, which you're looking for:\n";

    public final String SELECT_MEDICAL_CARD_NUMBER_FIRST = "Enter first in range medical card number, which you're looking for:\n";

    public final String SELECT_MEDICAL_CARD_NUMBER_SECOND = "Enter second in range medical card number, which you're looking for:\n";

    public final String RESULT = String.format("%125s", "Patients Info");

    public final String COLUMNS = String.format("%20s%20s%20s%30s%30s%30s%30s%30s",
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

    public void printMessageAndResult(String message, PatientInfo[] patientInfos) {
        System.out.println(message);
        for (PatientInfo patientInfo : patientInfos) {
            System.out.println(patientInfo);
        }
    }
}

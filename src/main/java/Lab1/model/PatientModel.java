package Lab1.model;

import Lab1.entities.PatientInfo;

import java.util.Comparator;
import java.util.stream.Stream;

public class PatientModel {

    private final PatientInfo[] patientsInfos;

    public PatientModel(int numberOfObjects) {
        patientsInfos = new PatientInfo[numberOfObjects];
        Data data = new Data();
        for (int number = 0; number < numberOfObjects; number++) {
            int identificationNumber = getRandomID(data);
            String name = getRandomName(data);
            String surname = getRandomSurname(data);
            String patronymic = getRandomPatronymic(data);
            String address = getRandomAddress(data);
            long phoneNumber = getRandomPhoneNumber(data);
            int medicalCardNumber = getRandomMedicalCardNumber(data);
            String diagnosis = getRandomDiagnosis(data);
            patientsInfos[number] = new PatientInfo(identificationNumber, name, surname, patronymic, address, phoneNumber, medicalCardNumber, diagnosis);
        }
    }

    private int getRandomNumber(int end) {
        return (int) Math.floor(Math.random() * (end + 1));
    }

    private int getRandomID(Data data) {
        int randomNum = getRandomNumber(data.identificationNumber.length - 1);
        return data.identificationNumber[randomNum];
    }

    private String getRandomName(Data data) {
        int randomNum = getRandomNumber(data.name.length - 1);
        return data.name[randomNum];
    }

    private String getRandomSurname(Data data) {
        int randomNum = getRandomNumber(data.surname.length - 1);
        return data.surname[randomNum];
    }

    private String getRandomPatronymic(Data data) {
        int randomNum = getRandomNumber(data.patronymic.length - 1);
        return data.patronymic[randomNum];
    }

    private String getRandomAddress(Data data) {
        int randomNum = getRandomNumber(data.address.length - 1);
        return data.address[randomNum];
    }

    private long getRandomPhoneNumber(Data data) {
        int randomNum = getRandomNumber(data.phoneNumber.length - 1);
        return data.phoneNumber[randomNum];
    }

    private int getRandomMedicalCardNumber(Data data) {
        int randomNum = getRandomNumber(data.medicalCardNumber.length - 1);
        return data.medicalCardNumber[randomNum];
    }

    private String getRandomDiagnosis(Data data) {
        int randomNum = getRandomNumber(data.diagnosis.length - 1);
        return data.diagnosis[randomNum];
    }

    public PatientInfo[] getAllPatientValues() {
        return patientsInfos;
    }

    public PatientInfo[] getPatientsByDiagnosis(String diagnosis) {
        PatientInfo[] enteredDiagnosis = new PatientInfo[0];
        for (PatientInfo patientInfo : patientsInfos) {
            if (patientInfo.getDiagnosis().equalsIgnoreCase(diagnosis)) {
                PatientInfo[] newEnteredDiagnosis = new PatientInfo[enteredDiagnosis.length + 1];
                System.arraycopy(enteredDiagnosis, 0, newEnteredDiagnosis, 0, enteredDiagnosis.length);
                enteredDiagnosis = newEnteredDiagnosis;
                enteredDiagnosis[enteredDiagnosis.length - 1] = patientInfo;
            }
        }
        return enteredDiagnosis;
    }

    public PatientInfo[] getPatientsByMedicalCardRange(String firstCardNumber, String secondCardNumber) {
        int firstNumber = Integer.parseInt(firstCardNumber);
        int secondNumber = Integer.parseInt(secondCardNumber);
        if (firstNumber > secondNumber) {
            return Stream.of(patientsInfos).filter(patientInfo ->
                    patientInfo.getMedicalCardNumber() < firstNumber
                            && patientInfo.getMedicalCardNumber() > secondNumber)
                    .sorted(Comparator.comparingInt(PatientInfo::getMedicalCardNumber))
                    .toArray(PatientInfo[]::new);

        } else {
            return Stream.of(patientsInfos).filter(patientInfo ->
                    patientInfo.getMedicalCardNumber() > firstNumber
                            && patientInfo.getMedicalCardNumber() < secondNumber)
                    .sorted(Comparator.comparingInt(PatientInfo::getMedicalCardNumber))
                    .toArray(PatientInfo[]::new);
        }
    }
}
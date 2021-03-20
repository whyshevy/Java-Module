package Lab1.model;

import Lab1.controller.exceptions.MedicalCardNumberIsOutOfBoundsException;
import Lab1.controller.validator.Validator;
import Lab1.entities.Patient;
import Lab1.view.PatientView;

import java.util.Comparator;
import java.util.stream.Stream;

public class PatientModel {

    private final Patient[] patientsInfos;

    public PatientModel(int numberOfObjects) {
        //создать класс DataSource
        patientsInfos = new Patient[numberOfObjects];
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
            patientsInfos[number] = new Patient(identificationNumber, name, surname, patronymic, address, phoneNumber, medicalCardNumber, diagnosis);
        }
    }

    private int getRandomNumber(int end) {
        return (int) Math.floor(Math.random() * (end + 1));
    }

    private int getRandomID(Data data) {
        int randomInt = getRandomNumber(data.identificationNumber.length - 1);
        return data.identificationNumber[randomInt];
    }

    private String getRandomName(Data data) {
        int randomInt = getRandomNumber(data.name.length - 1);
        return data.name[randomInt];
    }

    private String getRandomSurname(Data data) {
        int randomInt = getRandomNumber(data.surname.length - 1);
        return data.surname[randomInt];
    }

    private String getRandomPatronymic(Data data) {
        int randomInt = getRandomNumber(data.patronymic.length - 1);
        return data.patronymic[randomInt];
    }

    private String getRandomAddress(Data data) {
        int randomInt = getRandomNumber(data.address.length - 1);
        return data.address[randomInt];
    }

    private long getRandomPhoneNumber(Data data) {
        int randomInt = getRandomNumber(data.phoneNumber.length - 1);
        return data.phoneNumber[randomInt];
    }

    private int getRandomMedicalCardNumber(Data data) {
        int randomInt = getRandomNumber(data.medicalCardNumber.length - 1);
        return data.medicalCardNumber[randomInt];
    }

    private String getRandomDiagnosis(Data data) {
        int randomInt = getRandomNumber(data.diagnosis.length - 1);
        return data.diagnosis[randomInt];
    }

    public Patient[] getAllPatientValues() {
        return patientsInfos;
    }

    public Patient[] getPatientsByDiagnosis(String diagnosis) {
        Patient[] enteredDiagnosis = new Patient[]{};
        for (Patient patient : patientsInfos) {
            if (patient.getDiagnosis().equalsIgnoreCase(diagnosis)) {
                Patient[] newEnteredDiagnosis = new Patient[enteredDiagnosis.length + 1];
                System.arraycopy(enteredDiagnosis, 0, newEnteredDiagnosis, 0, enteredDiagnosis.length);
                enteredDiagnosis = newEnteredDiagnosis;
                enteredDiagnosis[enteredDiagnosis.length - 1] = patient;
            }
        }
        return enteredDiagnosis;
    }

    public Patient[] getPatientsByMedicalCardRange(int firstCardNumber, int secondCardNumber){
        if (firstCardNumber > secondCardNumber) {
            return Stream.of(patientsInfos).filter(patient ->
                    patient.getMedicalCardNumber() < firstCardNumber
                            && patient.getMedicalCardNumber() > secondCardNumber)
                    .sorted(Comparator.comparingInt(Patient::getMedicalCardNumber))
                    .toArray(Patient[]::new);
        } else {
            return Stream.of(patientsInfos).filter(patient ->
                    patient.getMedicalCardNumber() > firstCardNumber
                            && patient.getMedicalCardNumber() < secondCardNumber)
                    .sorted(Comparator.comparingInt(Patient::getMedicalCardNumber))
                    .toArray(Patient[]::new);
        }

    }
}
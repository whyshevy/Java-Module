package Lab1.controller.validator;

import Lab1.controller.exceptions.MedicalCardNumberIsOutOfBoundsException;

import Lab1.view.PatientView;

public class Validator {
    public static void checkMedicalCardNumbersThatNotExists(int firstRangeNumber, int secondRangeNumber) throws MedicalCardNumberIsOutOfBoundsException {
        if (firstRangeNumber < 0 || firstRangeNumber > 14124) {
            throw new MedicalCardNumberIsOutOfBoundsException(PatientView.OUT_OF_RANGE_EXCEPTION);
        }
        if (secondRangeNumber < 0 || secondRangeNumber > 14124) {
            throw new MedicalCardNumberIsOutOfBoundsException(PatientView.OUT_OF_RANGE_EXCEPTION);
        }
        if (firstRangeNumber == secondRangeNumber) {
            throw new MedicalCardNumberIsOutOfBoundsException(PatientView.OUT_OF_RANGE_EXCEPTION);
        }
    }
}

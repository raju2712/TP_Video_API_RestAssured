package MockingSolution;

import org.mockito.Mockito;

class PANcard {

	public String isValid(String panCard) {

		if (panCard.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}") == true) {
			return "Valid PAN";
		} else {
			return "not a Valid PAN";
		}
	}

	public static PANcard getMockObject() {
		PANcard mocObj = Mockito.mock(PANcard.class);
		Mockito.when(mocObj.isValid("ABCDE1234A")).thenReturn("Valid PAN Card");
		Mockito.when(mocObj.isValid("ABCDE1234B")).thenReturn("Valid PAN Card");
		Mockito.when(mocObj.isValid("ABCDE1234C")).thenReturn("Invalid PAN Card");
		return mocObj;
	}
}

public class MockitoPANcardMockingTest {

	public static void main(String[] args) {
		PANcard obj = PANcard.getMockObject();
		System.out.println(obj.isValid("ABCDE1234A"));
		System.out.println(obj.isValid("ABCDE1234C"));  //In given data itself it is given as Invalid
		System.out.println(obj.isValid("ABCDE1234N"));  //Given PAn card is not present in Data, so it will give null

	}
}

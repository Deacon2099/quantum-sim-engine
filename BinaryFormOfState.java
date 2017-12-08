import java.lang.Math;

class BinaryFormOfState {
	
private boolean tableWithBinaryFormOfState[][];
private int totalQubits;

public BinaryFormOfState(int givenTotalQubits) {
	totalQubits = givenTotalQubits;
	int totalStates=(int)Math.pow(2,givenTotalQubits);
	tableWithBinaryFormOfState = new boolean [totalQubits][totalStates];
	String BinaryString;
	for (int state=0; state<totalStates; state++){
		BinaryString=Integer.toBinaryString(state);
		for (int qubit=0; qubit<totalQubits; qubit++){
			if(BinaryString.length()>qubit){
				if(BinaryString.charAt(qubit)=='1'){
				tableWithBinaryFormOfState[BinaryString.length()-1-qubit][state]=true;
				}
			}
		}
	}

}

public boolean QubitIsOneInState(int qubit, int state){
	return tableWithBinaryFormOfState[qubit][state];
}

public void PrintResults(){
	int totalStates=(int)Math.pow(2,totalQubits);
	for (int state=0; state<totalStates; state++){
		System.out.println("Binary form of state " + state + " is "+ Integer.toBinaryString(state));
		for (int qubit=0; qubit<totalQubits; qubit++){
			System.out.println("In state "+ state + ", qubit " + qubit + " is " + QubitIsOneInState(qubit,state));
		}
	}
}

}
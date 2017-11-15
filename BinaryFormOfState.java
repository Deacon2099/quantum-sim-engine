import java.lang.Math;

class BinaryFormOfState {
	
private boolean tableWithBinaryFormOfState[][];
private int numberOfQubitsForThisInstance;

public BinaryFormOfState(int numberOfQubits) {
	numberOfQubitsForThisInstance = numberOfQubits;
	int numberOfStates=(int)Math.pow(2,numberOfQubits);
	tableWithBinaryFormOfState = new boolean [numberOfQubitsForThisInstance][numberOfStates];
	String BinaryString;
	for (int state=0; state<numberOfStates; state++){
		BinaryString=Integer.toBinaryString(state);
		for (int qubit=0; qubit<numberOfQubitsForThisInstance; qubit++){
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
	int numberOfStates=(int)Math.pow(2,numberOfQubitsForThisInstance);
	for (int state=0; state<numberOfStates; state++){
		System.out.println("Binary form of state " + state + " is "+ Integer.toBinaryString(state));
		for (int qubit=0; qubit<numberOfQubitsForThisInstance; qubit++){
			System.out.println("In state "+ state + ", qubit " + qubit + " is " + QubitIsOneInState(qubit,state));
		}
	}
}

}
//import java.lang.Math;

class QuantumCircuit {
	private int circuitSchematic[][];
	private QuantumRegister initialRegister;
	private QuantumGate circuitGates;
	private QuantumRegister finalRegister;
	private BinaryFormOfState binaryForm;
	private int numberOfQubitsForThisInstance;


	public QuantumCircuit(int numberOfQubits){
		numberOfQubitsForThisInstance = numberOfQubits;
		int numberOfStates=(int)Math.pow(2,numberOfQubits);
		circuitSchematic = new int [numberOfQubitsForThisInstance+2][100];
		for(int i=0; i<=(numberOfQubitsForThisInstance+1); i++){
			for(int j=0; j<=99; j++){
				circuitSchematic[i][j]=0;
			}
		}
		initialRegister = new QuantumRegister(numberOfQubitsForThisInstance);
		circuitGates = new QuantumGate(numberOfQubitsForThisInstance);
		finalRegister = new QuantumRegister(numberOfQubitsForThisInstance);
		binaryForm = new BinaryFormOfState(numberOfQubitsForThisInstance);
	}

	public QuantumCircuit(int numberOfQubits, int initialState){
		numberOfQubitsForThisInstance = numberOfQubits;
		int numberOfStates=(int)Math.pow(2,numberOfQubits);
		circuitSchematic = new int [numberOfQubitsForThisInstance+2][100];
		for(int i=0; i<=(numberOfQubitsForThisInstance+1); i++){
			for(int j=0; j<=99; j++){
				circuitSchematic[i][j]=0;
			}
		}
		initialRegister = new QuantumRegister(numberOfQubitsForThisInstance);
		initialRegister.Set(initialState,new Complex (1.0f));
		circuitGates = new QuantumGate(numberOfQubitsForThisInstance);
		finalRegister = new QuantumRegister(numberOfQubitsForThisInstance);
		binaryForm = new BinaryFormOfState(numberOfQubitsForThisInstance);
	}

	public void AddGate (int targetQubit, int stepNumber, int gateID){
		circuitSchematic[targetQubit][stepNumber]=gateID;	
		int controlSum=0;
		for(int i=0;i<=numberOfQubitsForThisInstance;i++){
			System.out.println("qubit "+i+" and step "+stepNumber+" and circschem is "+circuitSchematic[i][stepNumber]+" numbOfQubits "+numberOfQubitsForThisInstance);
			controlSum+=circuitSchematic[i][stepNumber];
			System.out.println("next");
		}
		System.out.println("done "+controlSum);
		circuitSchematic[numberOfQubitsForThisInstance+1][stepNumber]=controlSum;
		System.out.println("check gate "+circuitSchematic[targetQubit][stepNumber]);
	}
		
}
//import java.lang.Math;

class QuantumCircuit {
	private int circuitSchematic[][];
	public QuantumRegister initialRegister; //debug: change to private later
	public QuantumGate circuitGates;  //debug: change to private later
	public QuantumRegister finalRegister; //debug: change to private later
	private BinaryFormOfState binaryForm;
	private int numberOfQubitsForThisInstance;
	private int numberOfStates;
	private int stepLimit=100;


	public QuantumCircuit(int numberOfQubits){
		numberOfQubitsForThisInstance = numberOfQubits;
		numberOfStates=(int)Math.pow(2,numberOfQubits);
		circuitSchematic = new int [numberOfQubitsForThisInstance+1][stepLimit];
		for(int i=0; i<=(numberOfQubitsForThisInstance); i++){
			for(int j=0; j<=stepLimit-1; j++){
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
		numberOfStates=(int)Math.pow(2,numberOfQubits);
		circuitSchematic = new int [numberOfQubitsForThisInstance+1][stepLimit];
		for(int i=0; i<=(numberOfQubitsForThisInstance); i++){
			for(int j=0; j<=stepLimit-1; j++){
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
		for(int i=0;i<=numberOfQubitsForThisInstance-1;i++){
			controlSum+=circuitSchematic[i][stepNumber];
		}
		circuitSchematic[numberOfQubitsForThisInstance][stepNumber]=controlSum;
	}
	
	public void Calculate (){
		for (int step=0;step<stepLimit;step++){
			if(circuitSchematic[numberOfQubitsForThisInstance][step]>0){
				for(int qubit=0;qubit<numberOfQubitsForThisInstance;qubit++){
					if(circuitSchematic[qubit][step]==1){
						for(int state=0;state<numberOfStates;state++){
						circuitGates.PauliX(qubit,state);
						}
					}
				}
			}
		}
		finalRegister=circuitGates.MultiplyBy(initialRegister);
	}
	
	public Complex GetResult (int stateInFinalRegister){
			return finalRegister.Get(stateInFinalRegister,0);
	}
		
}
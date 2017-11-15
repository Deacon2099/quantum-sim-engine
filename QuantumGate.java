class QuantumGate extends Matrix {
	private BinaryFormOfState binaryForm;
	
	public QuantumGate(int numberOfQubits){
		super((int)Math.pow(2,numberOfQubits),(int)Math.pow(2,numberOfQubits));
		binaryForm = new BinaryFormOfState(numberOfQubits);
		this.IdentityMatrix();
	}

	public void PauliX (int targetQubit, int state){
		if(binaryForm.QubitIsOneInState(targetQubit, state))
		 SwitchRow(state,state-(int)Math.pow(2,targetQubit));
	}
		
}
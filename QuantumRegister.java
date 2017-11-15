class QuantumRegister extends Matrix {

	public QuantumRegister(int numberOfQubits){
		super((int)Math.pow(2,numberOfQubits),1);
	}

    public void Set(int state, Complex value){
		this.Set(state, 0, value);
	}
		
}
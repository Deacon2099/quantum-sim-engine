class QuantumRegister extends Matrix {

	public QuantumRegister(int totalQubits){
		super((int)Math.pow(2,totalQubits),1);
		this.Set(0,new Complex(1.0f));
	}

    public void Set(int state, Complex value){
		this.Set(state, 0, value);
	}
		

}
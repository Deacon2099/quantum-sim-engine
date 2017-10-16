class QuantumRegister extends Matrix {
	
	public QuantumRegister(int n){
		super(n,1);
	}

    public void Set(int state, Complex value){
		this.Set(state, 0, value);
	}
		
}
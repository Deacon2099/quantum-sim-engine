class QuantumGate extends Matrix {
	private BinaryFormOfState binaryForm;
	private int totalQubits;
	private Complex imUnit = new Complex(0,1);
	private Complex minusOneReal = new Complex(-1,0);
	
	
	public QuantumGate(int givenTotalQubits){
		super((int)Math.pow(2,givenTotalQubits),(int)Math.pow(2,givenTotalQubits));
		binaryForm = new BinaryFormOfState(givenTotalQubits);
		this.IdentityMatrix();
		totalQubits = givenTotalQubits;
	}

	public void PauliX (int targetQubit, int state){
		if(binaryForm.QubitIsOneInState(targetQubit, state))
		 SwitchRow(state,state-(int)Math.pow(2,targetQubit));
	}

	public void PauliY (int targetQubit, int state){
		if(binaryForm.QubitIsOneInState(targetQubit, state)){
			SwitchRow(state,state-(int)Math.pow(2,targetQubit));
			for(int column=0; column<=this.totalColumns-1; column++){
				Set(state, column, Get(state, column).MultiplyBy(imUnit));
				Set(state-(int)Math.pow(2,targetQubit), column, Get(state-(int)Math.pow(2,targetQubit), column).MultiplyBy(imUnit.Negation()));
			}
		}
		
	}
	
	public void PauliZ (int targetQubit, int state){
		if(binaryForm.QubitIsOneInState(targetQubit, state)){
			for(int column=0; column<=this.totalColumns-1; column++){
				Set(state, column, Get(state, column).MultiplyBy(minusOneReal));
			}
		}
		
	}
	
	public QuantumRegister MultiplyBy (QuantumRegister register){
		QuantumRegister result = new QuantumRegister(totalQubits);
		result.Set(0, 0, new Complex(0.0f));
		try{
			if (this.totalColumns != register.totalRows)
            {
                throw new ArrayIndexOutOfBoundsException();
            }
			for (int i=0; i<=this.totalRows-1; i++){
				for (int j=0; j<=register.totalColumns-1; j++){
					for (int k=0; k<=this.totalColumns-1; k++){
					result.Set(i,j,result.Get(i,j).Add(this.Get(i,k).MultiplyBy(register.Get(k,j))));
					}
					//System.out.println("["+i+","+j+"]:"+result.Get(i,j).ToString()); //uncomment for debug 
				}
			}
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Error: Column of first Matrix should be the same lenght as row of second Matrix.");
			System.exit(-1);
		}
		return result;
	}

}
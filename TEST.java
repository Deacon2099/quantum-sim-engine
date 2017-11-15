class TEST {
	public static void main (String args[]) {
	try{
		int errorCounter=0;
		int innerErrorCounter=0;
        
		
		System.out.println("\n*** PRESS ENTER TO BEGIN TESTS ***");
		System.out.println("\nNotes: Norm function from QuantumRegister is not used. Maybe should be used with user defined QuantumGate.");
		System.in.read();
		
		//test 01
		System.out.println("   test 01: First test, checking if 0 is different than 1. Expecting TRUE.");		
		if(0<1 || 0>1)
			PASSED();
		else{
			NOTPASSED();
			errorCounter++;}
		

		//test 02
		System.out.println("   test 02: Void constructor of Complex class. Expecting (0,0).");
		Complex t02complex = new Complex();
		if(t02complex.GetRe()==0.0f & t02complex.GetIm()==0.0f)
			PASSED();
		else{
			NOTPASSED();
			errorCounter++;}
		
		
		//test 03
		System.out.println("   test 03: Real constructor of Complex class. Expecting (5,0).");
		Complex t03complex = new Complex(5.0f);
		if(t03complex.GetRe()==5.0f & t03complex.GetIm()==0.0f)
			PASSED();
		else{
			NOTPASSED();
			errorCounter++;}
		
		//test 04
		System.out.println("   test 04: Full (Real and Imagine) constructor of Complex class. Expecting (2,8).");
		Complex t04complex = new Complex(2.0f, 8.0f);
		if(t04complex.GetRe()==2.0f & t04complex.GetIm()==8.0f)
			PASSED();
		else{
			NOTPASSED();
			errorCounter++;}
		
		//test 05
		System.out.println("   test 05: Negation of one complex number. Expecting (-2,-8).");
		Complex t05complex = new Complex(2.0f, 8.0f);
		t05complex = t05complex.Negation();
		if(t05complex.GetRe()==-2.0f & t05complex.GetIm()==-8.0f)
			PASSED();
		else{
			NOTPASSED();
			errorCounter++;}

		//test 06
		System.out.println("   test 06: Addition of two complex numbers. Expecting (3,15).");
		Complex t06complex = new Complex(1.0f, 7.0f);
		Complex t06Acomplex = new Complex(2.0f, 8.0f);
		t06complex = t06complex.Add(t06Acomplex);
		if(t06complex.GetRe()==3.0f & t06complex.GetIm()==15.0f)
			PASSED();
		else{
			NOTPASSED();
			errorCounter++;}
			
		//test 07
		System.out.println("   test 07: Substraction of two complex numbers. Expecting (1,2).");
		Complex t07complex = new Complex(5.0f, 8.0f);
		Complex t07Acomplex = new Complex(4.0f, 6.0f);
		t07complex = t07complex.Substract(t07Acomplex);
		if(t07complex.GetRe()==1.0f & t07complex.GetIm()==2.0f)
			PASSED();
		else{
			NOTPASSED();
			errorCounter++;}

		//test 08
		System.out.println("   test 08: Multiplication of two complex numbers. Expecting (-5,14).");
		Complex t08complex = new Complex(3.0f, 2.0f);
		Complex t08Acomplex = new Complex(1.0f, 4.0f);
		t08complex = t08complex.MultiplyBy(t08Acomplex);
		if(t08complex.GetRe()==-5.0f & t08complex.GetIm()==14.0f)
			PASSED();
		else{
			NOTPASSED();
			errorCounter++;}
			
		//test 08.01
		System.out.println("   test 08.01: Multiplication by single float number. Expecting (12,2).");
		Complex t08Bcomplex = new Complex(3.0f, 2.0f);
        t08Bcomplex = t08Bcomplex.MultiplyBy(4.0f);
		if(t08Bcomplex.GetRe()==12.0f & t08Bcomplex.GetIm()==2.0f)
			PASSED();
		else{
			NOTPASSED();
			errorCounter++;}

		//test 09
		System.out.println("   test 09: Complex modulus (absolute value) of complex number. Expecting |(3,-2)|=3,605.");
		Complex t09complex = new Complex(3.0f, -2.0f);
		if(t09complex.Mod()==(float)Math.sqrt(13.0f))
			PASSED();
		else{
			NOTPASSED();
			errorCounter++;}

		//test 10
		System.out.println("   test 10: Complex modulus squared (absolute value squered) of complex number. Expecting |(3,-2)|^2=13.");
		Complex t10complex = new Complex(3.0f, -2.0f);
		if(t10complex.Mod2()==13.0f)
			PASSED();
		else{
			NOTPASSED();
			errorCounter++;}
			
		//test 11
		System.out.println("   test 11: Phi angle in radians of complex number's polar form. Expecting -0.5880026f. Checking also Real=0 and Imagine > 0 and < 0");
		Complex t11complex = new Complex(3.0f, -2.0f);
		Complex t11Acomplex = new Complex(0.0f, 2.0f);	
		Complex t11Bcomplex = new Complex(0.0f, -2.0f);
		if(t11complex.Phi()==-0.5880026f & t11Acomplex.Phi()==(((float)Math.PI)/2.0f) & t11Bcomplex.Phi()==(-((float)Math.PI)/2.0f))
			PASSED();
		else{
			NOTPASSED();
			errorCounter++;}

		//test 12
		System.out.println("   test 12: Checking ToString for complex number. Expecting (3.0-2.0i)");
		Complex t12complex = new Complex(3.0f, -2.0f);
		if(t12complex.ToString().equals(3.0f+""+(-2.0f)+"i"))
			PASSED();
		else{
			NOTPASSED();
			errorCounter++;
			System.out.println(t12complex.ToString());}
			
		//test 13
		System.out.println("   test 13: Checking ToPolarString for complex number. Expecting 3.6055512exp^(-0.5880026)i");
		Complex t13complex = new Complex(3.0f, -2.0f);
		if(t13complex.ToPolarString().equals(3.6055512f+"exp^("+(-0.5880026f)+")i"))
			PASSED();
		else{
			NOTPASSED();
			errorCounter++;}

		//test 14
		System.out.println("   test 14: Void constructor of Matrix class with n rows/columns. Expecting matrix with 5 rows/columns filled with zeros.");
		Matrix t14matrix = new Matrix(5);
		innerErrorCounter=0;
		for (int i=0; i<=4; i++){
			for (int j=0; j<=4; j++){
				//System.out.println("["+i+","+j+"]:"+t14matrix.Get(i,j).ToString()); //uncomment for debug 
				if(t14matrix.Get(i,j).GetRe()==0.0f & t14matrix.Get(i,j).GetIm()==0.0f);
				else
					innerErrorCounter++;					
			}
		}
		if(innerErrorCounter==0)
			PASSED();
		else{
			NOTPASSED();
			errorCounter++;}	

		//test 15
		System.out.println("   test 15: Identity Matrix with n rows/columns. Expecting Identity matrix with 5 rows/columns.");
		Matrix t15matrix = new Matrix(5);
		t15matrix.IdentityMatrix();
		innerErrorCounter=0;
		for (int i=0; i<=4; i++){
			for (int j=0; j<=4; j++){
				//System.out.println("["+i+","+j+"]:"+t15matrix.Get(i,j).ToString()); //uncomment for debug 
				if(i==j){
					if(t15matrix.Get(i,j).GetRe()==1.0f & t15matrix.Get(i,j).GetIm()==0.0f);
					else
						innerErrorCounter++;
				}
				else
					if(t15matrix.Get(i,j).GetRe()==0.0f & t15matrix.Get(i,j).GetIm()==0.0f);
					else
						innerErrorCounter++;					
			}
		}
		if(innerErrorCounter==0)
			PASSED();
		else{
			NOTPASSED();
			errorCounter++;}					

		//test 16
		System.out.println("   test 16: Void constructor of Matrix class with n rows and m columns. Expecting Identity matrix with 5 rows and 7 columns filled with zeros.");
		Matrix t16matrix = new Matrix(5,7);
		innerErrorCounter=0;
		for (int i=0; i<=4; i++){
			for (int j=0; j<=6; j++){
				//System.out.println("["+i+","+j+"]:"+t16matrix.Get(i,j).ToString()); //uncomment for debug 
				if(t16matrix.Get(i,j).GetRe()==0.0f & t16matrix.Get(i,j).GetIm()==0.0f);
				else
					innerErrorCounter++;					
			}
		}
		if(innerErrorCounter==0)
			PASSED();
		else{
			NOTPASSED();
			errorCounter++;}			

		//test 17
		System.out.println("   test 17: Switching rows of matrix. Expecting to switch rows 3 and 5.");
		Matrix t17matrix = new Matrix(6,7);
		t17matrix.Set(3,1,new Complex(4.0f, 34.0f));
		t17matrix.Set(5,1,new Complex(17.0f, 8.0f));		
		t17matrix.SwitchRow(3,5);
		//for (int i=0; i<=5; i++){ //uncomment for debug
			//for (int j=0; j<=6; j++){ //uncomment for debug
			//	System.out.println("["+i+","+j+"]:"+t17matrix.Get(i,j).ToString());}} //uncomment for debug 
		if(t17matrix.Get(3,1).GetRe()==17.0f & t17matrix.Get(3,1).GetIm()==8.0f & t17matrix.Get(5,1).GetRe()==4.0f & t17matrix.Get(5,1).GetIm()==34.0f)
			PASSED();
		else{
			NOTPASSED();
			errorCounter++;}						
			
		//test 18
		System.out.println("   test 18: Addition of two matrices. Expecting the following result:");
		System.out.println("            [1,2][3,4]     [5, 6][7,  8]     [6,  8][10, 12]");
		System.out.println("            [5,6][7,8]  +  [9,10][11,12]  =  [14,16][18,20]");
		Matrix t18Amatrix = new Matrix(2,2);
		Matrix t18Bmatrix = new Matrix(2,2);
		t18Amatrix.Set(0,0,new Complex(1.0f, 2.0f));
		t18Amatrix.Set(0,1,new Complex(3.0f, 4.0f));
		t18Amatrix.Set(1,0,new Complex(5.0f, 6.0f));
		t18Amatrix.Set(1,1,new Complex(7.0f, 8.0f));
		t18Bmatrix.Set(0,0,new Complex(5.0f, 6.0f));
		t18Bmatrix.Set(0,1,new Complex(7.0f, 8.0f));
		t18Bmatrix.Set(1,0,new Complex(9.0f, 10.0f));
		t18Bmatrix.Set(1,1,new Complex(11.0f, 12.0f));
		t18Amatrix = t18Amatrix.Add(t18Bmatrix);
		//for (int i=0; i<=1; i++){ //uncomment for debug
			//for (int j=0; j<=1; j++){ //uncomment for debug
				//System.out.println("["+i+","+j+"]:"+t18Amatrix.Get(i,j).ToString());}} //uncomment for debug 
		if(t18Amatrix.Get(0,0).GetRe()==6.0f & t18Amatrix.Get(0,0).GetIm()==8.0f & t18Amatrix.Get(0,1).GetRe()==10.0f & t18Amatrix.Get(0,1).GetIm()==12.0f & t18Amatrix.Get(1,0).GetRe()==14.0f & t18Amatrix.Get(1,0).GetIm()==16.0f & t18Amatrix.Get(1,1).GetRe()==18.0f & t18Amatrix.Get(1,1).GetIm()==20.0f)
			PASSED();
		else{
			NOTPASSED();
			errorCounter++;}				
			
		//test 19
		System.out.println("   test 19: Substraction of two matrices. Expecting the following result:");
		System.out.println("            [1,2][3,4]     [5, 6][7,  8]     [-4,  -4][-4, -4]");
		System.out.println("            [5,6][7,8]  -  [9,10][11,12]  =  [-4,  -4][-4, -4]");
		Matrix t19Amatrix = new Matrix(2,2);
		Matrix t19Bmatrix = new Matrix(2,2);
		t19Amatrix.Set(0,0,new Complex(1.0f, 2.0f));
		t19Amatrix.Set(0,1,new Complex(3.0f, 4.0f));
		t19Amatrix.Set(1,0,new Complex(5.0f, 6.0f));
		t19Amatrix.Set(1,1,new Complex(7.0f, 8.0f));
		t19Bmatrix.Set(0,0,new Complex(5.0f, 6.0f));
		t19Bmatrix.Set(0,1,new Complex(7.0f, 8.0f));
		t19Bmatrix.Set(1,0,new Complex(9.0f, 10.0f));
		t19Bmatrix.Set(1,1,new Complex(11.0f, 12.0f));
		t19Amatrix = t19Amatrix.Substract(t19Bmatrix);
		//for (int i=0; i<=1; i++){ //uncomment for debug
			//for (int j=0; j<=1; j++){ //uncomment for debug
				//System.out.println("["+i+","+j+"]:"+t19Amatrix.Get(i,j).ToString());}} //uncomment for debug 
		if(t19Amatrix.Get(0,0).GetRe()==-4.0f & t19Amatrix.Get(0,0).GetIm()==-4.0f & t19Amatrix.Get(0,1).GetRe()==-4.0f & t19Amatrix.Get(0,1).GetIm()==-4.0f & t19Amatrix.Get(1,0).GetRe()==-4.0f & t19Amatrix.Get(1,0).GetIm()==-4.0f & t19Amatrix.Get(1,1).GetRe()==-4.0f & t19Amatrix.Get(1,1).GetIm()==-4.0f)
			PASSED();
		else{
			NOTPASSED();
			errorCounter++;}			

		//test 20
		System.out.println("   test 20: Multiplication of two matrices. Expecting the following result:");
		System.out.println("            [1,2][3,4]     [5, 6][7,  8]     [-20,  82][-24, 102]");
		System.out.println("            [5,6][7,8]  *  [9,10][11,12]  =  [-28,  202][-32, 254]");
		Matrix t20Amatrix = new Matrix(2,2);
		Matrix t20Bmatrix = new Matrix(2,2);
		t20Amatrix.Set(0,0,new Complex(1.0f, 2.0f));
		t20Amatrix.Set(0,1,new Complex(3.0f, 4.0f));
		t20Amatrix.Set(1,0,new Complex(5.0f, 6.0f));
		t20Amatrix.Set(1,1,new Complex(7.0f, 8.0f));
		t20Bmatrix.Set(0,0,new Complex(5.0f, 6.0f));
		t20Bmatrix.Set(0,1,new Complex(7.0f, 8.0f));
		t20Bmatrix.Set(1,0,new Complex(9.0f, 10.0f));
		t20Bmatrix.Set(1,1,new Complex(11.0f, 12.0f));
		t20Amatrix = t20Amatrix.MultiplyBy(t20Bmatrix);
		//for (int i=0; i<=1; i++){ //uncomment for debug
			//for (int j=0; j<=1; j++){ //uncomment for debug
				//System.out.println("["+i+","+j+"]:"+t20Amatrix.Get(i,j).ToString());}} //uncomment for debug 
		if(t20Amatrix.Get(0,0).GetRe()==-20.0f & t20Amatrix.Get(0,0).GetIm()==82.0f & t20Amatrix.Get(0,1).GetRe()==-24.0f & t20Amatrix.Get(0,1).GetIm()==102.0f & t20Amatrix.Get(1,0).GetRe()==-28.0f & t20Amatrix.Get(1,0).GetIm()==202.0f & t20Amatrix.Get(1,1).GetRe()==-32.0f & t20Amatrix.Get(1,1).GetIm()==254.0f)
			PASSED();
		else{
			NOTPASSED();
			errorCounter++;}	
			
		//test 21
		System.out.println("   test 21: Multiplication of two matrices with different number of rows and columns. Expecting the following result:");
		System.out.println("            [1, 2][3, 4][5,  6]   [5,  6]   [-33, 172]");
		System.out.println("            [5, 6][7, 8][9, 10] * [7,  8] = [-45, 352]");
		System.out.println("                                  [9, 10]             ");		
		Matrix t21Amatrix = new Matrix(2,3);
		Matrix t21Bmatrix = new Matrix(3,1);
		Matrix t21resultmatrix = new Matrix(2,1);
		t21Amatrix.Set(0,0,new Complex(1.0f, 2.0f));
		t21Amatrix.Set(0,1,new Complex(3.0f, 4.0f));
		t21Amatrix.Set(0,2,new Complex(5.0f, 6.0f));
		t21Amatrix.Set(1,0,new Complex(5.0f, 6.0f));
		t21Amatrix.Set(1,1,new Complex(7.0f, 8.0f));
		t21Amatrix.Set(1,2,new Complex(9.0f, 10.0f));
		t21Bmatrix.Set(0,0,new Complex(5.0f, 6.0f));
		t21Bmatrix.Set(1,0,new Complex(7.0f, 8.0f));
		t21Bmatrix.Set(2,0,new Complex(9.0f, 10.0f));
		t21resultmatrix = t21Amatrix.MultiplyBy(t21Bmatrix);
		//for (int i=0; i<=1; i++){ //uncomment for debug
			//for (int j=0; j<=0; j++){ //uncomment for debug
				//System.out.println("["+i+","+j+"]:"+t21resultmatrix.Get(i,j).ToString());}} //uncomment for debug 
		if(t21resultmatrix.Get(0,0).GetRe()==-33.0f & t21resultmatrix.Get(0,0).GetIm()==172.0f & t21resultmatrix.Get(1,0).GetRe()==-45.0f & t21resultmatrix.Get(1,0).GetIm()==352.0f)
			PASSED();
		else{
			NOTPASSED();
			errorCounter++;}	

		//test 22
		System.out.println("   test 22: Constructing Quantum Register as extension of Matrix class.");
		QuantumRegister t22qregist = new QuantumRegister(1);
		t22qregist.Set(0,0,new Complex(4.0f, 34.0f)); //setter with row and column
		t22qregist.Set(1,new Complex(17.0f, 8.0f));	  //setter only with row	
		//for (int i=0; i<=1; i++){ //uncomment for debug
			//for (int j=0; j<=0; j++){ //uncomment for debug
				//System.out.println("["+i+","+j+"]:"+t22qregist.Get(i,j).ToString());}} //uncomment for debug 
		if(t22qregist.Get(0,0).GetRe()==4.0f & t22qregist.Get(0,0).GetIm()==34.0f & t22qregist.Get(1,0).GetRe()==17.0f & t22qregist.Get(1,0).GetIm()==8.0f)
			PASSED();
		else{
			NOTPASSED();
			errorCounter++;}					

		//test 23
		System.out.println("   test 23: Testing utility class BinaryFormOfState which contains table with binary form of all states.");
		System.out.println("            Checking state  6 for 5 qubits. Expecting result: [00110] (qubit number zero is last).");
		System.out.println("            Checking state 19 for 5 qubits. Expecting result: [10011] (qubit number zero is last).");
		BinaryFormOfState test23binaryform = new BinaryFormOfState(5);
		//test23binaryform.PrintResults(); //uncomment for debug
		if(test23binaryform.QubitIsOneInState(0,6)==false & test23binaryform.QubitIsOneInState(1,6)==true & test23binaryform.QubitIsOneInState(2,6)==true & test23binaryform.QubitIsOneInState(3,6)==false & test23binaryform.QubitIsOneInState(4,6)==false & 
		   test23binaryform.QubitIsOneInState(0,19)==true & test23binaryform.QubitIsOneInState(1,19)==true & test23binaryform.QubitIsOneInState(2,19)==false & test23binaryform.QubitIsOneInState(3,19)==false & test23binaryform.QubitIsOneInState(4,19)==true)
			PASSED();
		else{
			NOTPASSED();
			errorCounter++;}		

		//test 24
		System.out.println("   test 24: Using Pauli X quantum gate for one qubit circuit.");
		QuantumGate t24qgate = new QuantumGate(1);
		t24qgate.PauliX(0,0);
		t24qgate.PauliX(0,1);
		//for (int i=0; i<=1; i++){ //uncomment for debug
		//System.out.print("["+i+"]"); //uncomment for debug 
			//for (int j=0; j<=1; j++){ //uncomment for debug
				//System.out.print(" "+(int)t24qgate.Get(i,j).GetRe());} //uncomment for debug 
			//System.out.println(" ");} //uncomment for debug 
		if(t24qgate.Get(0,0).GetRe()==0.0f & t24qgate.Get(0,1).GetRe()==1.0f & t24qgate.Get(1,0).GetRe()==1.0f & t24qgate.Get(1,1).GetRe()==0.0f)
			PASSED();
		else{
			NOTPASSED();
			errorCounter++;}				
			
		//test 25
		System.out.println("   test 25: Using Pauli X quantum gate for 3 qubits circuit. Gate is on the qubit in the middle.");
		QuantumGate t25qgate = new QuantumGate(3);
		for (int q=0; q<=7; q++){
		t25qgate.PauliX(1,q);
		}
		//for (int i=0; i<=7; i++){ //uncomment for debug
			//System.out.print("["+i+"]"); //uncomment for debug 
			//for (int j=0; j<=7; j++){ //uncomment for debug
				//System.out.print(" "+(int)t25qgate.Get(i,j).GetRe());}//uncomment for debug
			//System.out.println(" ");} //uncomment for debug 
		if(t25qgate.Get(0,2).GetRe()==1.0f & t25qgate.Get(2,0).GetRe()==1.0f & t25qgate.Get(3,1).GetRe()==1.0f & t25qgate.Get(1,3).GetRe()==1.0f &
		   t25qgate.Get(4,6).GetRe()==1.0f & t25qgate.Get(6,4).GetRe()==1.0f & t25qgate.Get(5,7).GetRe()==1.0f & t25qgate.Get(7,5).GetRe()==1.0f)
			PASSED();
		else{
			NOTPASSED();
			errorCounter++;}				
	
		//test 26
		System.out.println("   test 26: Creating and calculating Quantum Circuit for one qubit and with Pauli X gate.");
		QuantumCircuit t26qcirc = new QuantumCircuit(1);
		t26qcirc.AddGate(0,0,1); //(targetqubit,step,gateId)
		/*t26qcirc.Calculate();
		if(t26qcirc.GetResult(0).GetRe()==1.0f & t26qcirc.GetResult(0).GetIm()==0.0f)
			PASSED();
		else{
			NOTPASSED();
			errorCounter++;}		*/	

		//SPECIAL TEST OF EFFICIENCY - uncomment below to proceed
/*      
		int specialTestNumberOfQubits = 10;
		int repeat = 25;	
		System.out.println("   ***SPECIAL EFFICIENCY TEST***");
		System.out.println("   *** starting test for "+specialTestNumberOfQubits+" qubits and repeating "+repeat+" times.");	
		QuantumGate sptqgate = new QuantumGate(specialTestNumberOfQubits);
		for(int r=1; r<=repeat; r++){
		sptqgate.IdentityMatrix();
		for (int q=0; q<=(int)Math.pow(2,specialTestNumberOfQubits)-1; q++){
		sptqgate.PauliX(1,q);
		//System.out.println("   ***working*** "+q);		
		}
		System.out.println("   *** repeating " + r);
		}
		System.out.println("   *** done ");
		System.out.println(" "); 
*/
	
	if(errorCounter==0)
		System.out.println("\nGreat work!");
	else
		System.out.println("\nFound "+errorCounter+" errors.");
	}
	catch(ArrayIndexOutOfBoundsException e){
		System.out.println("Nie ma elementu");
		System.exit(-1);
	}
	catch(Exception e){
		System.out.println("Jakiś błąd!");
		System.exit(-1);
	}
	}

	public static void PASSED(){
		System.out.println("PASSED");
	}

	public static void  NOTPASSED(){
		System.out.println("*** NOT PASSED");
	}

}



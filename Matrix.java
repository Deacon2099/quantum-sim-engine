import java.lang.Math;

class Matrix {
	private Complex innerArray[][];
	protected int totalRows;
	protected int totalColumns;

	
	public Matrix(int n){
		totalRows=n;
		totalColumns=n;
		FillAllInnerArrayWithZeros();
	}

	public Matrix(int n, int m){
		totalRows=n;
		totalColumns=m;
		FillAllInnerArrayWithZeros();
	}
	
	private void FillAllInnerArrayWithZeros (){
		innerArray = new Complex [totalRows][totalColumns];
		for (int i=0; i<=totalRows-1; i++){
			for (int j=0; j<=totalColumns-1; j++){
				innerArray[i][j]= new Complex (0.0f,0.0f);
				
			//System.out.println("["+i+","+j+"]:"+innerArray[i][j].ToString()); //uncomment for debug 
			}
		}
	}
	
	public void IdentityMatrix (){
		for (int i=0; i<=totalRows-1; i++){
			for (int j=0; j<=totalColumns-1; j++){
				if(i==j)
					innerArray[i][j]= new Complex (1.0f,0.0f);
				else
					innerArray[i][j]= new Complex (0.0f,0.0f);
				
			//System.out.println("["+i+","+j+"]:"+innerArray[i][j].ToString()); //uncomment for debug 
			}
		}
	}
	
	public void SwitchRow(int rowA, int rowB){
		float temporaryRe;
		float temporaryIm;
		for (int i=0; i<=totalColumns-1; i++){
			temporaryRe=innerArray[rowA][i].GetRe();
			temporaryIm=innerArray[rowA][i].GetIm();
			innerArray[rowA][i]=innerArray[rowB][i];
			innerArray[rowB][i]= new Complex(temporaryRe,temporaryIm);
		}
	}

	public Matrix Add (Matrix mat1){
		Matrix result = new Matrix(totalRows,totalColumns);
		for (int i=0; i<=totalRows-1; i++){
			for (int j=0; j<=totalColumns-1; j++){
				result.Set(i,j,this.Get(i,j).Add(mat1.Get(i,j)));
				
			//System.out.println("["+i+","+j+"]:"+result.Get(i,j).ToString()); //uncomment for debug 
			}
		}
		return result;
	}	
	
	public Matrix Substract (Matrix mat1){
		Matrix result = new Matrix(totalRows,totalColumns);
		for (int i=0; i<=totalRows-1; i++){
			for (int j=0; j<=totalColumns-1; j++){
				result.Set(i,j,this.Get(i,j).Substract(mat1.Get(i,j)));
				
			//System.out.println("["+i+","+j+"]:"+result.Get(i,j).ToString()); //uncomment for debug 
			}
		}
		return result;
	}		

	public Matrix MultiplyBy (Matrix mat1){
		Matrix result = new Matrix(this.totalRows,mat1.totalColumns);
		try{
			if (this.totalColumns != mat1.totalRows)
            {
                throw new ArrayIndexOutOfBoundsException();
            }
			for (int i=0; i<=this.totalRows-1; i++){
				for (int j=0; j<=mat1.totalColumns-1; j++){
					for (int k=0; k<=this.totalColumns-1; k++){
					result.Set(i,j,result.Get(i,j).Add(this.Get(i,k).MultiplyBy(mat1.Get(k,j))));
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
	
	public Complex Get(int row, int column){
		return innerArray[row][column];
	}
	
	public void Set(int row, int column, Complex value){
		innerArray[row][column]=value;
	}
	
	public void DebugPrintMatrixDetailsOnlyRealValues(){
		for (int i=0; i<totalRows; i++){
			System.out.print("["+i+"]"); 
			for (int j=0; j<totalColumns; j++){
				System.out.print(" "+(int)this.Get(i,j).GetRe());
			}
			System.out.println(" ");
		} 
	}
	
	public void DebugPrintMatrixDetailsComplexValues(){
		for (int i=0; i<totalRows; i++){
			System.out.print("["+i+"]"); 
			for (int j=0; j<totalColumns; j++){
			System.out.print(" ["+this.Get(i,j).ToString()+"]");
			}
			System.out.println(" ");
		} 
	}
	
}
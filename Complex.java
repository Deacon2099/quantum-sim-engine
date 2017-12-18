import java.lang.Math;

class Complex {
	private float re;
	private float im;
	
	public Complex(){
		re = 0.0f;
		im = 0.0f;
	}
	
	public Complex(float real){
		re = real;
		im = 0.0f;
	}
	
	public Complex(float real, float imagine){
		re = real;
		im = imagine;
	}
	
	public float GetRe(){
		return re;
	}
	
	public float GetIm(){
		return im;
	}

	public Complex Negation(){
		Complex result= new Complex(-re,-im);
		return result;
	}
	
	public Complex Add(Complex com1){
		Complex result= new Complex(re + com1.GetRe(),im + com1.GetIm());
		return result;
	}
	
	public Complex Substract(Complex com1){
		Complex result= new Complex(re - com1.GetRe(),im - com1.GetIm());
		return result;
	}

	public Complex MultiplyBy(Complex com1){
		float solveRe = (this.GetRe()*com1.GetRe())-(this.GetIm()*com1.GetIm());
		float solveIm = (this.GetRe()*com1.GetIm())+(this.GetIm()*com1.GetRe());
		Complex result= new Complex(solveRe,solveIm);
		return result;
	}
	
	public Complex MultiplyBy(float number){
		Complex result= new Complex(this.GetRe()*number,im);
		return result;
	}
	
	public float Mod(){
		return (float)Math.sqrt((re*re)+(im*im));
	}
	
	public float Mod2(){
		return ((re*re)+(im*im));
	}
	
	public float Phi(){
		if(re==0 & im>=0)
			return ((float)Math.PI)/2.0f;
		else
			if(re==0 & im<0)
				return -((float)Math.PI)/2.0f;
			else
				return (float)Math.atan((im)/(re));
	}
	
	public String ToString(){
		if(im>=0)
			return (re+0.0f)+"+"+(im+0.0f)+"i";
		else
			return (re+0.0f)+""+(im+0.0f)+"i";
	}
	
	public String ToPolarString(){
			return this.Mod()+"exp^("+this.Phi()+")i";
	}
}

/** Jared Dunn
 * PA6 Java
 * JBS2011
 * this is the object i use for my java matching game. its a car object and its made up of 2 strings
 * a MAKE and a MODEL.
 * 
 * there are the typical get,new and toString methods.
 * @author Jared
 *
 */
public class Car {
	private String make;
	private String model;
	private String car;
	
	public Car (String mke, String mdl){
		make = mke;
		model = mdl;
		car = make + " " + model;
	}
	public String getMake(){
		return make;
	}
	public String getModel(){
		return model;
	}
	public void newMake(String mke){
		make =mke;
	}
	public void newModel(String mdl){
		model = mdl;
	}
	public String toString(){
		return car;
	}
	
}

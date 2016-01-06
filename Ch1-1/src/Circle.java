public class Circle {           
   //The radius and color variables
   private double radius;
   private String color;
   
   /*
    * 1st constructor, which sets both radius and color to default (from online)
    */ 
   public Circle() {
      radius = 1.0;
      color = "red";
   }
   
   
   /*
    * 2nd constructor with given radius, but color default (from online)
    * @param r	the radius 
    */
   public Circle(double r) {
      this.radius = r;
      color = "red";
   }
   
   /*
    * Constructor written by me
    * @param r: the radius
    * @param color: the color
    */
   public Circle(double r, String color){
	   setColor(color);
	   setRadius(r);
   }
   
   /*
    * @return the color
    */
   public String getColor(){
	   return this.color;
   }
   /*
    * @return the radius
    */
   public double getRadius() {
     return this.radius; 
   }
   
  /*
   * @return the area
   */
   public double getArea() {
      return radius*radius*Math.PI;
   }
   
   /*
    * Set the color
    * @param c: the color to set
    */
   public void setColor(String c){
	   this.color = c;
   }
   /*
    * Sets the radius
    * @param the radius
    */
   public void setRadius(double radius){
	   this.radius = radius;
   }
   /*
    * @return the radius and the color as strings
    */
   public String toString() {
	   return "Circle: radius=" + radius + " color=" + color;
	}
}
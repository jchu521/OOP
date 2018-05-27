public class Car : Vehicle
{
    public Car(string registrationNumber): base(registrationNumber){
        //init fields specific to the car class
    }
}

public class Shape{

}

public class Circle : Shape {

}

//Upcasting
Circle circle = new Circle();
Shape shape = circle;
//Downcasting
Circle anotherCircle = (Circle) shape;

Car car = (Car) obj;
Car car = obj as Car;
if(car != null){

}

if(obj is Car){
    Car car = (Car) obj;
}

int number = 10;
Object obj = number;
Object obj = 10;
int number = (int) obj;

public abstract class Shape{
    public abstract virtual void Draw();
}

public sealed class Circle : Shape{
    public sealed override void Draw(){
        console.WriteLine("Drawing a circle");
    }
}
var shape = new Shape();
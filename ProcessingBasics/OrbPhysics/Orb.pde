public class Orb {
  float x, y;
  float xSpeed, ySpeed;
  float radius;
  color c;

  public Orb(float x_, float y_, float xSpeed_, float ySpeed_, float radius_ ) {
    x = x_;
    y = y_;
    xSpeed = xSpeed_;
    ySpeed = ySpeed_;
    radius = radius_;
    //random color... why not.
    c = color(random(256), random(256), random(256));
  }


  void display() {
    //Part 1:
    //draw a ellipse at the x,y position, with the correct radius.
    //make sure it is the correct color
    //make sure you read the parameters of ellipse, so that you have the correct size.
    //radius is NOT one of the parameters of ellipse by default.
    fill(c, 171);
    ellipse(x,y,radius*2,radius*2);
  }

  void move() {
    //PART 2
    //change the x based on the xSpeed
    //change the y based on the ySpeed
    x+=xSpeed;
    y+=ySpeed;
    //PART 3
    //Change the speed when you collide with the end of the screen (all 4 sides)
    if(x >= width - radius || x <= 0 + radius){
      xSpeed *= -1;
    }
    if(y >= height - radius || y <= 0 + radius){

      ySpeed *= -1;
    }
    //Part 4
    //Add a small adjustment for gravity. Gravity is a ySpeed acceleration...
    //You don't need a variable for this if every object experiences the same
    //gravitational constant.

   ySpeed += 0.1;
  }
}

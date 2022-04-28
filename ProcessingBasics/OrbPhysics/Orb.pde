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
    fill(c, 210);
    ellipse(x, y, radius*2, radius*2);
    line(x, y, 5*xSpeed + x, 5*ySpeed + y);
    if (MODE == 2){
      line(x,y,500,400);
    }
  }

  void move() {
    //PART 2
    //change the x based on the xSpeed
    //change the y based on the ySpeed
    x+=xSpeed;
    y+=ySpeed;
    //PART 3
    //Change the speed when you collide with the end of the screen (all 4 sides)
    //if (x >= width - radius || x <= 0 + radius) {
    //  xSpeed *= -1;
    //}
    //if (y >= height - radius || y <= 0 + radius) {

    //  ySpeed *= -1;
    //}
    //Part 4
    //Add a small adjustment for gravity. Gravity is a ySpeed acceleration...
    //You don't need a variable for this if every object experiences the same
    //gravitational constant.
    //if (xSpeed != 0 && ySpeed != 0) {
    //  ySpeed += 0.1;
    //}
  }
  void attract(Orb other) {

    other.xSpeed += ((20 * (x - other.x)) / (dist(x, y, other.x, other.y) * dist(x, y, other.x, other.y)));
    other.ySpeed += ((20 * (y - other.y)) / (dist(x, y, other.x, other.y) * dist(x, y, other.x, other.y)));
  }
  void attractSpring(Orb other){
    float force = (dist(other.x,other.y,x,y) - SPRING_LENGTH) * SPRING_CONSTANT;
    other.xSpeed += force * ((x - other.x)/dist(other.x,other.y,x,y));
    other.xSpeed *= SPRING_DAMPEN;
    other.ySpeed += force * ((y - other.y)/dist(other.x,other.y,x,y));
    other.ySpeed *= SPRING_DAMPEN;
  }
  void bounce() {
    if (x >= width - radius || x <= 0 + radius) {
      xSpeed *= -1;
    }
    if (y >= height - radius || y <= 0 + radius) {

      ySpeed *= -1;
    }
  }

  void gravity() {
    ySpeed += 0.15;
  }
}

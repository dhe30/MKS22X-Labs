ArrayList<Orb>orbList;
final int BOUNCE = 0;
final int ORBIT = 1;
final int SPRING = 2;
final float SPRING_LENGTH = 300;
final float SPRING_CONSTANT = 0.005;
final float SPRING_DAMPEN = 0.995;
final Orb center = new Orb(500, 400, 0, 0, 5);
boolean BACK = true;
boolean GAVA = true;
int MODE = BOUNCE;
void setup() {
  size(1000, 800);
  orbList = new ArrayList<Orb>();
}
void mouseClicked() {
  //add a new Orb to the orbList, constructed as follows:
  //The x and y positions are the same as the mouse
  //the radius should be between in the range [20.0,70.0)
  //the xSpeed and ySpeed should be in the range [-3.0,3.0)
  //float xSpeed = random(-3,3);
  //float ySpeed = random(-3,3);
  //float radius = random(20.0,70.0);
  orbList.add(new Orb(mouseX, mouseY, 5, 0, 20));
}
void draw() {
  if (BACK) {
    background(255);
  }
  fill(255,255,255);
  noStroke();
  rect(0,0,75,70);
  stroke(1);
  fill(3, 3, 3);
  ellipse(500, 400, 10*2, 10*2);
  for (Orb o : orbList) {
    if (MODE == ORBIT) {
      (center).attract(o);
    } else if (MODE == SPRING){
      (center).attractSpring(o);
    }
    o.move();
    if (MODE == BOUNCE) {
      o.bounce();
    }
    if (GAVA) {
      o.gravity();
    } 
    o.display();
  }
  fill(0);
  text(frameRate, 20, 20);
  text(orbList.size(), 20, 40);
  if (MODE == BOUNCE) {
    text("BOUNCE", 20, 60);
  } else if (MODE == ORBIT) {
    text("ORBIT", 20, 60);
  } else if (MODE == SPRING) {
    text("SPRING", 20, 60);
  }
  
}

void keyPressed() {
  if (key == BACKSPACE) {
    orbList = new ArrayList<Orb>();
  }
  if (key == ' ') {
    if (MODE == BOUNCE) {
      MODE = ORBIT;
    } else if (MODE == ORBIT) {
      MODE = SPRING;
    } else if (MODE == SPRING) {
      MODE = BOUNCE;
    }
  }
  if (key == 'b') {
    BACK = !BACK;
  }
  if (key == 'g') {
    GAVA = !GAVA;
  }
}

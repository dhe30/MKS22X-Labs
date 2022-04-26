ArrayList<Orb>orbList;
final int GRAVITY = 0;
final int ORBIT = 1;
int MODE = 0;
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
  background(255);
  fill(3, 3, 3);
  ellipse(500, 350, 3*2, 3*2);
  for (Orb o : orbList) {
    if (MODE == ORBIT){
      o.attract(new Orb(500,350,0,0,3));
    }
    o.move();
    if(MODE == GRAVITY){
      o.bounce();
      o.gravity();
    }
    o.display();
  }
  fill(0);
  text(frameRate, 20, 20);
  text(orbList.size(), 20, 40);
}

void keyPressed(){
  if (key == BACKSPACE){
      orbList = new ArrayList<Orb>();
  }
  if (key == ' '){
    if (MODE == 0){
      MODE = 1;
    } else if (MODE == 1){
      MODE = 0;
    }
  }
}

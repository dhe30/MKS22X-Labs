static int SPRING = 2;
static float SPRING_LENGTH = 50;
static float SPRING_DAMPEN = 0.990;
static float SPRING_CONSTANT = 0.015;
static int MODE = SPRING;
static float LA_GRAVEDAD = 0.35;
static String CLICK_MODE = "Add";
OrbList orbs;
void setup() {
  size(1000, 800);
  orbs = new OrbList();
}
void mouseClicked() {
  if (CLICK_MODE.equals("Add")) {
    orbs.add(new OrbNode(mouseX, mouseY, 0, 0, 30));
  } else if (CLICK_MODE.equals("Insert")) {
    orbs.add(mouseX, new OrbNode(mouseX, mouseY, 0, 0, 30));
  }
}
void draw() {
  background(255);
  orbs.processAll();
  orbs.display();
  text("SPRING CONSTANT: " + SPRING_CONSTANT, 420, 20);
  text("SPRING DAMPEN: " + SPRING_DAMPEN, 420, 40);
  text("SPRING LENGTH: " + SPRING_LENGTH, 420, 60);
  text("GRAVITY: " + LA_GRAVEDAD, 420, 80);
  text("MODE: " + CLICK_MODE, 420, 100);
}
void keyPressed() {
  if (key == '1') {
    SPRING_CONSTANT*=1.1;
  }
  if (key == '2') {
    SPRING_CONSTANT*=0.9;
  }
  if (key == '3') {
    SPRING_DAMPEN*=1.1;
  }
  if (key == '4') {
    SPRING_DAMPEN*=0.9;
  }
  if (key == '5') {
    SPRING_LENGTH*=1.1;
  }
  if (key == '6') {
    SPRING_LENGTH*=0.9;
  }
  if (key == '7') {
    LA_GRAVEDAD*=1.1;
  }
  if (key == '8') {
    LA_GRAVEDAD*=0.9;
  }
  if (key == ' ') {
    if (CLICK_MODE.equals("Add")){
      CLICK_MODE = "Insert";
    } else if (CLICK_MODE.equals("Insert")){
      CLICK_MODE = "Add";
    } 
  }
}

public class OrbNode {
  float x, y;
  float dx, dy;
  float radius;
  color c;
  OrbNode next, prev;
  public OrbNode() {
  }
  public OrbNode(float x_, float y_) {
    this(x_, y_, 0.0, 0.0, 50.0);
  }
  public OrbNode(float x_, float y_, float dx_, float dy_, float radius_ ) {
    x = x_;
    y = y_;
    dx = dx_;
    dy = dy_;
    radius = radius_;
    c = color(random(255), random(255), random(255), 200);
  }
  /**
   *complete this method
   */
  void display() {
    fill(c);
    ellipse(x, y, radius*2, radius*2);
    if (next != null) {
      line(x+1, y+1, next.x+1, next.y+1);
    } 
    if (prev != null) {
      line(x-1, y-1, prev.x-1, prev.y-1);
    }
    //If next or previous exist, draw lines to them! (aim for slightly off center)
    /*you write this part*/
  }

  void springAttract(OrbNode other) {
    float dist = dist(x, y, other.x, other.y) ;
    float force = (dist - SPRING_LENGTH) * SPRING_CONSTANT;
    float displacex = (x - other.x) ;
    float displacey = (y - other.y) ;
    other.dx += displacex * force / dist;
    other.dy += displacey * force / dist;
    other.dx*= SPRING_DAMPEN;
    other.dy*= SPRING_DAMPEN;
  }

  /**
   *complete this method
   */
  void move() {
    //have prev and next apply spring force to this node;
    /*you write this part*/
    if (next != null) {
      next.springAttract(next.prev);
    } 
    if (prev != null) {
      prev.springAttract(prev.next);
    }
    //apply velocity to position
    x+=dx;
    y+=dy;
    //apply gravity
    dy+=LA_GRAVEDAD;
  }
}

public class FixedOrbNode extends OrbNode {
  void move() {
  }
  FixedOrbNode(float x_, float y_) {
    x = x_;
    y = y_;
    radius = 30;
    c = color(0);
  }
}


public class OrbList {
  OrbNode first, last;

  //create a fixed orb
  OrbList() {
    first = new FixedOrbNode(0, height/5);
    last = new FixedOrbNode(width, height/5);
    //link them to eachother
    first.next = last;
    last.prev = first;
  }

  /**
   *complete this method
   */
  void add(OrbNode orb) {
    orb.next = last;
    last.prev.next = orb;
    orb.prev = last.prev;
    last.prev = orb;
    //insert orb at the end of the list before the last node.
  }

  /**
   *complete this method
   *process all nodes by running move.
   */
  void processAll() {
    OrbNode current = first;
    //advance current to next until it is null, move() each of the nodes
  }
  /**
   *complete this method
   *Display all nodes by running their display().
   */
  void display() {
    OrbNode current = first;
    //advance current to next until it is null, display() each of the nodes
    while (current.next != null) {
      current.move();
      current.display();
      current=current.next;
    }
    current.display();
  }

  void add(int xcor, OrbNode toBeAdded) {
    OrbNode current = first;
    while (current.next.x < xcor) {
      current = current.next;
    }
    toBeAdded.prev = current;
    toBeAdded.next = current.next;
    current.next.prev = toBeAdded;
    current.next = toBeAdded;
  }
  void delete(OrbNode target) {
    if (target != null) {
      target.prev = target.next;
      target.next = target.prev;
    }
  }

  OrbNode getNodeAt(int x, int y) {
    OrbNode current = first;
    while (current.next != null) {
      if (dist(x, y, current.next.y, current.next.y) <= current.next.radius) {
        return current.next;
      }
      current = current.next;
    }
    return null;
  }
}

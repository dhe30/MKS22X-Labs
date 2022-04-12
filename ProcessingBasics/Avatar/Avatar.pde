void avatar(int x, int y){
  //your code here
  stroke(229,155,155);
  strokeWeight(5);
  fill(237,235,235);
  arc(x,y,400,400,3.14,6.28);
  fill(162,110,110);
  arc(x,y,400,400,0,3.14);
  fill(10,10,10);
  triangle(x-140,y-140,x+140,y-140,x,y+195);
  strokeWeight(5);
  stroke(255,255,255);
  line(x,y-135,x,y+195);
  stroke(10,10,10);
  fill(227,204,204);
  arc(x-100,y-100,100,30,3.14,6.28);
  arc(x-100,y-100,100,30,0,3.14);
  arc(x-100,y-40,100,30,3.14,6.28);
  arc(x-100,y-40,100,30,0,3.14);
  arc(x-100,y+20,100,30,3.14,6.28);
  arc(x-100,y+20,100,30,0,3.14);
  fill(255,255,255);
  arc(x+100,y-100,100,30,3.14,6.28);
  arc(x+100,y-100,100,30,0,3.14);
  arc(x+95,y-40,110,30,3.14,6.28);
  arc(x+95,y-40,110,30,0,3.14);
  arc(x+90,y+20,120,30,3.14,6.28);
  arc(x+90,y+20,120,30,0,3.14);
  arc(x+85,y+80,130,30,3.14,6.28);
  arc(x+85,y+80,130,30,0,3.14);
  strokeWeight(0);
  fill(255,0,0);
  circle(x+100,y-100,10);
     fill(10,10,10);
   circle(x+95,y-40,15);

   circle(x+90,y+20,20);
  circle(x+85,y+80,25);
}

int x,y;
  int MODE;
  void setup(){
           size(800,800);
           MODE = 2;
           x = width/2;
           y = height/2;
  }
  void draw(){
           background(255);
           x = change(x);
           y = change(y);
           avatar(x,y);
           if (clicked){
           avatar(mouseX, mouseY);
         }
  }
  boolean clicked;
  void mouseClicked(){
    clicked = true;
    if (MODE < 3){
      MODE += 1;
    } else {
      MODE -=2;
    }
  }
  int change(int value){
    /**
     mode 1: return a random location on the screen.
     mode 2: change value by +1, 0, or -1 randomly
     mode 3: change value by +1 , but if it goes past the end of the screen ,
           wrap back around to the other end of the screen.
    */

    switch(MODE){
     case 1:
       return (int)(Math.random()*(800 + 1));
     case 2:
       return value + (int)(Math.random()*(3)) - 1;
     case 3:
       if (value + 1 > 800){
         return 0;
       }
       return value + 1;
     default:
       return width/2;
    }
  }

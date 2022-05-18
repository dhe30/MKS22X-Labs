public class Kernel {
  float[][]kernel;

  /**Constructor takes the kernel that will be applied to the image
   *This implementation only allows 3x3 kernels
   */
  public Kernel(float[][]init) {
    kernel = new float[init.length][init[0].length];
    for (int i = 0; i < init.length; i++) { 
      for (int a = 0; a < init[i].length; a++) {
        kernel[i][a] = init[i][a];
      }
    }
  }

  /**If part of the kernel is off of the image, return black, Otherwise
   *Calculate the convolution of r/g/b separately, and return that color\
   *if the calculation for any of the r,g,b values is outside the range
   *     0-255, then clamp it to that range (< 0 becomes 0, >255 becomes 255)
   */
  color calcNewColor(PImage img, int x, int y) {
    float red = 0.0;
    float green = 0.0;
    float blue = 0.0;
    int xcor = x - 1;
    int ycor = y - 1;
    for (int i = x - 1; i < x + 2; i++) {
      for (int a = y - 1; a < y + 2; a++) {
        red += red(img.get(i, a)) * kernel[i-xcor][a-ycor];
        green += green(img.get(i, a)) * kernel[i-xcor][a-ycor];
        blue += blue(img.get(i, a)) * kernel[i-xcor][a-ycor];
      }
    }
    return color(red, green, blue);
    //Hint: start by always returning black.
    //This will let you test your apply method right away!
  }

  /**You must write this method that applies the kernel to the source,
   *and saves the data to the destination.*/
  void apply(PImage source, PImage destination) {
    for (int i = 0; i < source.height; i++) { 
      for (int a = 0; a < source.width; a++) {
        destination.set(a, i, calcNewColor(source, a, i));
      }
    }
  }
}
void setup() {
  size(1450, 500);
  PImage car = loadImage("redcar.png");
  PImage output = car.copy();
  Kernel k = new Kernel( new float[][] {
    {-1, -1, -1}, 
    {-1, 8, -1}, 
    {-1, -1, -1}
    } );
  Kernel k2 = new Kernel( new float[][] {
    {.11, .11, .11}, 
    {.11, .11, .11}, 
    {.11, .11, .11}
    } );
  String[] names = new String[]{
    "Identity", "Blur", "Sharpen",
    "Outline", "Left Sobel", "Right Sobel",
    "Top Sobel", "Emboss"
  };

  Kernel[] kernels = new Kernel[] {
    new Kernel( new float[][] {
    {0, 0, 0},
    {0, 1, 0},
    {0, 0, 0}    }) ,
    new Kernel( new float[][] {
    {.111, .111, .111},
    {.111, .111, .111},
    {.111, .111, .111}    }) ,
    new Kernel( new float[][] {
    {0, -1, 0},
    {-1, 5, -1},
    {0, -1, 0}    }) ,
    new Kernel( new float[][] {
    {-1, -1, -1},
    {-1, 8, -1},
    {-1, -1, -1}    }) ,
    new Kernel( new float[][] {
    {1, 0, -1},
    {2, 0, -2},
    {1, 0, -1}    }) ,
    new Kernel( new float[][] {
    {-1, 0, 1},
    {-2, 0, 2},
    {-1, 0, 1}    }) ,
    new Kernel( new float[][] {
    {1, 2,  1},
    {0, 0, 0},
    {-1, -2, -1}    }),
        new Kernel( new float[][] {
    {-2, -1,  0},
    {-1, 1, 1},
    {0, 1, 2}    })
  };
  
  kernels[4].apply(car, output);
  image(car, 0, 0);
  image(output, car.width, 0);
}
